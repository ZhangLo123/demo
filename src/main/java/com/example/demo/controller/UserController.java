package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.UserDataInfo;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import static com.example.demo.utils.CodeTest.sendMsg;


@Controller
public class UserController {

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    UserService userService;
    @Autowired
    HttpSession httpSession;


    /**
     * 用户登录
     * @return
     */
    @RequestMapping("/user/registOrLogin")
    @ResponseBody
    public JsonResult login(@RequestBody Map<String,Object> param){
        String username = param.get("username").toString();
        String password = param.get("password").toString();

        User user = userService.userLogin(username);

        String Ident = UserController.RandomCode();
        String nowTime = sf.format(new Date(System.currentTimeMillis()));



        if (user != null){
            if (user.getuPassWord().equals(password)){

                String token = user.getuToken();
                httpSession.setAttribute("name",username);
                httpSession.setAttribute("token",token);

                return new JsonResult(new User(user.getuId(),user.getuName(),user.getuHeadimage(),user.getuSex(),user.getuBirthday(),user.getuProvince(),token),"login success",200);
            }
            else {
                return new JsonResult("","用户名或密码错误",500);
            }
        }else {
            String tokenReg = Ident + System.currentTimeMillis();
            String userId = UserController.IDCode();
            User user1 = new User(userId,username,password,tokenReg,nowTime);
            userService.saveUser(user1);
            User user2 = userService.userLogin(user1.getuName());
            httpSession.setAttribute("name",username);
            httpSession.setAttribute("token",tokenReg);
            System.out.println("-----------------------------------------------");
            System.out.println(httpSession.getAttribute("name"));
            System.out.println(httpSession.getAttribute("token"));
            System.out.println("-----------------------------------------------");

            return new JsonResult(new User(user2.getuId(),user2.getuName(),user2.getuHeadimage(),user2.getuSex(),user2.getuBirthday(),user2.getuProvince(),tokenReg),"register success",200);

        }

    }


    /**
     * 管理员登陆
     * @param param
     * @return
     */
    @RequestMapping("/user/adminLogin")
    @ResponseBody
    public JsonResult<UserDataInfo> adminlogin(@RequestBody Map<String,Object> param) {
        String username = param.get("username").toString();
        String password = param.get("password").toString();

        User user = userService.userLogin(username);

        if (user != null){
            if (user.getuPassWord().equals(password)){

                httpSession.setAttribute("name",username);
                httpSession.setAttribute("token",user.getuToken());

                return new JsonResult(new User(user.getuId(),user.getuName(),user.getuToken(),user.getuLimit()),"login success",200);
            }else {
                return new JsonResult("","密码错误",501);
            }

        }else {
            return new JsonResult("","用户名错误",502);
        }
    }


    /**
     * 退出登录
     */
    @RequestMapping("/user/logout")
    @ResponseBody
    public JsonResult<UserDataInfo> loginOut(@RequestBody Map<String,Object> param){
        String username = param.get("username").toString();
        String token = param.get("token").toString();

        String uNameLogout = httpSession.getAttribute("name").toString();
        String uTokenLogout = httpSession.getAttribute("token").toString();

        if (username.equals(uNameLogout) && token.equals(uTokenLogout)){
            httpSession.removeAttribute("name");
            httpSession.removeAttribute("token");
            System.out.println("退出成功");
            return new JsonResult<>(new UserDataInfo(uNameLogout),"logout success",200);
        }else {
            return new JsonResult<>(new UserDataInfo(uNameLogout),"logout failure",500);
        }
    }


    @RequestMapping("/user/bindPhone.php")
    @ResponseBody
    public JsonResult bindUserPhone(@RequestBody Map<String,Object> param){

        String userId = param.get("userId").toString();
        String userToken = param.get("userToken").toString();
        String userphone = param.get("phone").toString();

        User user = userService.findByuserId(userId);
        String uToken = user.getuToken();

        if (userToken.equals(uToken)){
            user.setuPhone(userphone);
            userService.updateUserPhone(user);

            return new JsonResult(user,"bindSuccess",200);

        }else {
            return new JsonResult("","bindFailure",500);
        }

    }



    @RequestMapping("/user/phoneCode.do")
    @ResponseBody
    public JsonResult<String> getphoneCode(@RequestBody Map<String,Object> param, HttpServletRequest request){

        // 用户名
        String name="dxwhqb";
        // 密码
        String pwd="2CBC974A8F7A29BB37C3B981DA3D";
        // 签名
        String sign="";
        // 追加发送时间，可为空，为空为及时发送
        String stime="";
        // 扩展码，必须为数字 可为空
        StringBuffer extno=new StringBuffer();

        //生成一个4位数的验证码
        String strCode = "";
        for (int i=0;i<4;i++){
            strCode+=(int)Math.floor(Math.random()*10);
        }
        System.out.println(strCode);

        String userId = param.get("userId").toString();
        String userToken = param.get("userToken").toString();
        String userphone = param.get("phone").toString();

        User user = userService.findByuserId(userId);
        String uToken = user.getuToken();

        if (userToken.equals(uToken)){

            StringBuffer mobileString = new StringBuffer(userphone);
            StringBuffer contextString = new StringBuffer("【搜索助手】尊敬的用户，您好！您的手机验证码为:"+strCode+"。此验证码用于认证，请即时使用。");

            try {
                System.out.println(sendMsg(name,pwd,mobileString,contextString,sign,stime,extno));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new JsonResult<>(strCode,"验证码发送成功",200);
        }else {
            return new JsonResult<>("","验证失败",500);
        }
    }


    /**
     * 上传头像
     * @param userId
     * @param userToken
     * @param multipartFile
     * @return
     */
    @RequestMapping("/user/updateUserface")
    @ResponseBody
    public JsonResult<User> updateUserface(@RequestParam("userId") String userId,
                                           @RequestParam("userToken") String userToken,
                                           @RequestParam("file") MultipartFile multipartFile){

        System.out.println("********************************************************");
        System.out.println(userId);
        System.out.println("********************************************************");
        System.out.println(userToken);
        System.out.println("********************************************************");
        System.out.println(multipartFile.toString());
        System.out.println("********************************************************");

        User user = userService.findByuserId(userId);
        String fileName = user.getuName();
        String uToken = user.getuToken();

        System.out.println("-------------------------------------------------------");
        System.out.println(fileName);
        System.out.println(uToken);
        System.out.println("-------------------------------------------------------");

        if (userToken.equals(uToken)) {
            String originalName = multipartFile.getOriginalFilename();
            String filePath = "F:\\app\\product\\image\\userInfo\\" + fileName;

            File dir = new File(filePath);
            if (!dir.exists()) { //若创建文件不存在则创建文件夹
                dir.mkdir();
                System.out.println(filePath);
            }

            String picNewName = UserController.RandomCode() + fileName + originalName.substring(originalName.lastIndexOf("."));
            File imgFace = new File(filePath + "\\" + picNewName);

            System.out.println("-------------------------------------------------------");
            System.out.println(imgFace);
            System.out.println("-------------------------------------------------------");
            try {
                multipartFile.transferTo(imgFace);
                user.setuHeadimage(imgFace.toString());
                userService.updateUserface(user);
                System.out.println(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
            User user2 = userService.findByuserId(userId);
            System.out.println(user2);
            return new JsonResult<>(user2,"上传成功",200);
        }else {
            return new JsonResult<>(new User(user.getuId(),user.getuName(),user.getuHeadimage(),user.getuSex(),user.getuBirthday(),user.getuProvince(),user.getuToken()),"上传失败",500);
        }
    }

    /**
     * 更改昵称
     * @return
     */
    @RequestMapping("/user/updateUserNickname")
    @ResponseBody
    public JsonResult<User> updateUserNickname(@RequestBody Map<String,Object> param){

        String userId = param.get("userId").toString();
        String userToken = param.get("userToken").toString();
        String username = param.get("username").toString();

        System.out.println("********************************************************");
        System.out.println(userId);
        System.out.println("********************************************************");
        System.out.println(userToken);
        System.out.println("********************************************************");
        System.out.println(username);
        System.out.println("********************************************************");

        User user = userService.findByuserId(userId);

        if (userToken.equals(user.getuToken())){
            user.setuName(username);
            userService.updateUserNickname(user);
        }else {
            return new JsonResult<>(new User(user.getuId(),user.getuName(),user.getuHeadimage(),user.getuSex(),user.getuBirthday(),user.getuProvince(),user.getuToken()),"UPDATA FAILURE",500);
        }
        User user1 = userService.findByuserId(userId);

        return new JsonResult<>(new User(user1.getuId(),user1.getuName(),user1.getuHeadimage(),user1.getuSex(),user1.getuBirthday(),user1.getuProvince(),user1.getuToken()),"",200);
    }

    /**
     * 更改生日
     * @return
     */
    @RequestMapping("/user/updateUserBirthday")
    @ResponseBody
    public JsonResult<User> updateUserBirthday(@RequestBody Map<String,Object> param){

        String userId = param.get("userId").toString();
        String userToken = param.get("userToken").toString();
        String birthday = param.get("birthday").toString();

        System.out.println("********************************************************");
        System.out.println(userId);
        System.out.println("********************************************************");
        System.out.println(userToken);
        System.out.println("********************************************************");
        System.out.println(birthday);
        System.out.println("********************************************************");

        User user = userService.findByuserId(userId);

        if (userToken.equals(user.getuToken())){
            user.setuBirthday(birthday);
            userService.updateUserBirthday(user);
        }else {
            return new JsonResult<>(new User(user.getuId(),user.getuName(),user.getuHeadimage(),user.getuSex(),user.getuBirthday(),user.getuProvince(),user.getuToken()),"UPDATA FAILURE",500);
        }
        User user1 = userService.findByuserId(userId);

        return new JsonResult<>(new User(user1.getuId(),user1.getuName(),user1.getuHeadimage(),user1.getuSex(),user1.getuBirthday(),user1.getuProvince(),user1.getuToken()),"",200);
    }

    /**
     * 更改城市
     * @return
     */
    @RequestMapping("/user/updateUserProvince")
    @ResponseBody
    public JsonResult<User> updateUserProvince(@RequestBody Map<String,Object> param){

        String userId = param.get("userId").toString();
        String userToken = param.get("userToken").toString();
        String province = param.get("province").toString();

        System.out.println("********************************************************");
        System.out.println(userId);
        System.out.println("********************************************************");
        System.out.println(userToken);
        System.out.println("********************************************************");
        System.out.println(province);
        System.out.println("********************************************************");

        User user = userService.findByuserId(userId);

        if (userToken.equals(user.getuToken())){
            user.setuProvince(province);
            userService.updateUserProvince(user);
        }else {
            return new JsonResult<>(new User(user.getuId(),user.getuName(),user.getuHeadimage(),user.getuSex(),user.getuBirthday(),user.getuProvince(),user.getuToken()),"UPDATA FAILURE",500);
        }
        User user1 = userService.findByuserId(userId);

        return new JsonResult<>(new User(user1.getuId(),user1.getuName(),user1.getuHeadimage(),user1.getuSex(),user1.getuBirthday(),user1.getuProvince(),user1.getuToken()),"",200);
    }

    /**
     * 更改性别
     * @return
     */
    @RequestMapping("/user/updateUserSex")
    @ResponseBody
    public JsonResult<User> updateUserSex(@RequestBody Map<String,Object> param){

        String userId = param.get("userId").toString();
        String userToken = param.get("userToken").toString();
        Integer sex = Integer.parseInt(param.get("sex").toString());

        System.out.println("********************************************************");
        System.out.println(userId);
        System.out.println("********************************************************");
        System.out.println(userToken);
        System.out.println("********************************************************");
        System.out.println(sex);
        System.out.println("********************************************************");

        User user = userService.findByuserId(userId);

        if (userToken.equals(user.getuToken())){
            user.setuSex(sex);
            userService.updateUserSex(user);
        }else {
            return new JsonResult<>(new User(user.getuId(),user.getuName(),user.getuHeadimage(),user.getuSex(),user.getuBirthday(),user.getuProvince(),user.getuToken()),"UPDATA FAILURE",500);
        }
        User user1 = userService.findByuserId(userId);

        return new JsonResult<>(new User(user1.getuId(),user1.getuName(),user1.getuHeadimage(),user1.getuSex(),user1.getuBirthday(),user1.getuProvince(),user1.getuToken()),"",200);
    }



    /**
     * 随机生成字母字符串
     * @return
     */
    public static String RandomCode(){

        SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        String frealDir = sFormat.format(calendar.getTime());

        //生成一个包含大小写字母的随机4位字符串；方法1
        String randomcode = "";
        for(int i=0;i<4;i++)
        {
            //52个字母与6个大小写字母间的符号；范围为91~96
            int value = (int)(Math.random()*58+65);
            while(value>=91 && value<=96)
                value = (int)(Math.random()*58+65);
            randomcode = randomcode + (char)value;

        }
        return frealDir+randomcode;
    }

    /**
     *随机生成userID
     * @return
     */
    public static String IDCode(){

        SimpleDateFormat sFormat = new SimpleDateFormat("yyMMdd");
        Calendar calendar = Calendar.getInstance();
        String frealDir = sFormat.format(calendar.getTime());

        //生成一个包含大小写字母的随机6位字符串；方法1
        String randomcode = "";
        for(int i=0;i<6;i++)
        {
            //52个字母与6个大小写字母间的符号；范围为91~96
            int value = (int)(Math.random()*58+65);
            while(value>=91 && value<=96)
                value = (int)(Math.random()*58+65);
            randomcode = randomcode + (char)value;

        }
        return frealDir+randomcode;
    }

}


