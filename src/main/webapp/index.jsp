<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2020/5/13
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>绑定手机号</title>
    <style>
        body {
            background: black;
            color: #ffffff;
        }

        .box {
            width: 400px;
            margin: 100px auto;
            padding: 50px;
            background: rgb(255, 223, 16);
            box-shadow: 0px 0px 50px 0px #ffffff;
            border-radius: 35px;
        }

        .context {
            border-radius: 35px;
            background: rgb(255, 196, 138);
            height: 200px;
        }

        h2 {
            text-align: center;
            color: black;
        }

        .controller {
            margin-top: 20px;
            padding-left: 32px;
            padding-top: 20px;
        }

        input {
            background: none;
            border: none;
            padding: 5px;
            border-bottom: 1px solid #425ec2;
            color: #ffffff;
        }

        a {
            color: #de3b23;
            margin-left: 20px;
        }

        button {
            margin-left: 70px;
            margin-bottom: 10px;
            text-align: center;
            width: 200px;
            font-size: 20px;
            background: #87b5b3;
            color: #ffffff;
            border: none;
            padding: 8px;
            border-radius: 50px;
            outline: none;
        }

        button:hover {
            box-shadow: 0px 0px 10px 0px #ffffff;
        }
    </style>
</head>
<body>
<div class="box">
    <h2>【搜索助手】短信验证码</h2>
    <div class="context">
        <div class="controller">手机号：<input type="text" id="phone"></div>
        <div class="controller"><input type="text" id="code"><a href="javascript:void(0)" id="getCode">获取验证码</a></div>
        <div class="controller">
            <button type="">绑 定</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    var obj = document.getElementById("getCode");
    var flag = 60;//全局变量
    obj.onclick = function () {
        //控制这个时间
        if (flag < 60) {
            return;
        }

        //ajax
        var xhr = new XMLHttpRequest();
        xhr.open("get", "getCode.do?phone=" + document.getElementById("phone").valueOf(), true);
        //true表示异步请求
        //监控请求状态
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                alert(xhr.responseText)
            }
        }
        xhr.send(null);
        alert("验证码已发送，请注意查收！");

        timer();

    }

    //计时器
    function timer() {
        flag--;
        obj.innerHTML = flag + "秒后重新获取";
        if (flag == 0) {
            obj.innerHTML = "获取验证码";
            flag = 60;
        } else {

            setTimeout("timer()", 1000);//递归调用
        }
    }


</script>
</body>
</html>
