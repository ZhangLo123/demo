package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.utils.ProductDataInfo;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    ImagesService imagesService;
    @Autowired
    HttpSession httpSession;
    @Autowired
    ShopUploadService shopUploadService;
    @Autowired
    WXUserService wxUserService;


    @Test
    void contextLoads() {
//        User user = new User("123d","xxxx","1234567","vdfvbefbvjwbjibcfbn", LocalDate.now());
//        userService.saveUser(user);
//        User user1 = userService.userLogin("xxxx");
//        httpSession.setAttribute("name",user1.getuName());
//
//        String name = httpSession.getAttribute("name").toString();
//        System.out.println(name);

        userService.findAll().forEach(System.out::print);
//        System.out.println(user1.getuId());
    }

    @Test
    void contextLoads1() {
//        插入仪器
//        Product product = new Product();
//        product.setpName("超声仪12");
//        product.setPrice(3000.00);
//        product.setFactory("康科瑞工程检测技术有限公司");
//        product.setService("5A");
//        product.setImage("file:///F:/app/product/image/20191120192738.jpg");
//
//        productService.saveProduct(product);
//
//        productService.findAllPro().forEach(System.out::print);

//        查找仪器
//        List<Product> products = productService.findBypName("超声仪");
//        System.out.println(products.size());
//        System.out.println(products);
//
//        int i;
//        ProductDataInfo productDataInfo;
//        for (i = 0;i<products.size();i++){
//            productDataInfo = new ProductDataInfo(products.get(i).getpId(),products.get(i).getpName(),products.get(i).getPrice(),products.get(i).getFactory()
//            ,products.get(i).getService(),products.get(i).getImage());
//            System.out.println(productDataInfo);
//        }
            File target = new File("D:\\360Downloads\\Apk\\file.bat");
            if (target.exists() && target.isFile()){
                boolean flag = target.delete();
            }
            try {
                if (target.createNewFile()){
                    for (int i = 0; i < 4096; i++) {
                        DataOutputStream out = new DataOutputStream(new FileOutputStream(target, true));
                        byte[] bytes = new byte[2];
                        bytes[0] = (byte) (i / 256);
                        bytes[1] = (byte) (i % 256);
                        out.write(bytes);
//                    out.writeInt(i);
                        out.close();
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


    }


    @Test
    void contextLoads2() {
        Images images = new Images();
        images.setUserId("2");
        images.setpId("12112");
        images.setpShopname("ceshi");
        images.setImPathLunbo("https://ae01.alicdn.com/kf/HTB1Mj7iTmzqK1RjSZFjq6zlCFXaP.jpg");
//        images.setImCreateTime(LocalDate.now());

        imagesService.saveImage(images);
        imagesService.findAllImage().forEach(System.out::print);

    }

    @Test
    void shopUploadTest() {
        ShopUpload shopUpload = new ShopUpload();
        shopUpload.setUserId("2");
        shopUpload.setShopName("静载");
        shopUpload.setShopPrice(2000);
        shopUpload.setShopFactory("康科瑞");
        shopUpload.setShopInfo("非常好");

        shopUploadService.uploadShop(shopUpload);

        shopUploadService.findAllshop().forEach(System.out::print);


    }

    @Test
    void Random() {

        SimpleDateFormat sFormat = new SimpleDateFormat("yyMMdd");
        Calendar calendar = Calendar.getInstance();
        String frealDir = sFormat.format(calendar.getTime());

        //生成一个包含大小写字母的随机6位字符串；方法1
        String randomcode = "";
        for (int i = 0; i < 6; i++) {
            //52个字母与6个大小写字母间的符号；范围为91~96
            int value = (int) (Math.random() * 58 + 65);
            while (value >= 91 && value <= 96)
                value = (int) (Math.random() * 58 + 65);
            randomcode = randomcode + (char) value;

        }
        randomcode = randomcode + frealDir;
        System.out.println(randomcode);

    }

    @Test
    void ImageFind() {
//         List<Images> imagesList = imagesService.findImage(17);
//         System.out.println(imagesList);
//         List<String> imgUrl = new ArrayList<>();


//         for (int i = 0; i<imagesList.size();i++){
//              String imPath = imagesList.get(i).getImPath();
//              imgUrl.add(imPath);
//             System.out.println(imPath);
//         }
//        System.out.println(imgUrl.toString());

    }

//    @Test
//    void suijishu() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入1个数字:");
//        int max=sc.nextInt()+20;
//        int min=sc.nextInt()-20;
//        Random random = new Random();
//        for (int i =0;i<6;i++) {
//            int s = random.nextInt(max) % (max - min + 1) + min;
//            System.out.println(s);
//        }
//    }

    @Test
    void savewxuser() {


    }
}
