<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='css/index.css'/>"/>
    <style type="text/css">
        div {
            cursor: pointer;
            border: 1px solid #555;
            background: #ccc;
            padding: 5px;
            width: 100px;
            height: 20px;
            line-height: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<p>Hello World</p>
<label><span>登录名：</span><input id="loginName" type="text" value="admin"></label>
<label><span>密码：</span><input id="password" type="password" value="admin"></label>
<div id="login" style="">登录</div>
<script type="text/javascript" src="lib/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript">
    $("#login").on("click", () => {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/requestAction/findUser",
                dataType: "json",
                data: {loginName: $("#loginName").val(), password: $("#password").val()},
                async: true,
                success: (data) => {
                    if (data)
                        alert("登陆成功");
                    else
                        alert("登陆失败");
                }
            });
        }
    )
</script>
</body>
</html>