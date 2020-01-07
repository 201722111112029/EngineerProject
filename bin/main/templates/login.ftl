<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>云盘</title>
<style>
    *{
    margin: 0;
    padding:0;
    }
    input[type=text], select {
  width: 90%;
  padding: 12px 20px;
  margin: 8px 10px 5px 15px;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
    input[type="password"] {
 width: 90%;
 padding: 12px 20px;
 margin: 8px 10px 5px 15px;
 display: inline-block;
 border: 1px solid #ccc;
 border-radius: 4px;
 box-sizing: border-box;
 }
    body{
        background-image:url('img/backg.png');
        overflow: hidden;
    }
    .signin{
        width: 300px;
        height: 430px;
        padding: 40px;
        margin-top: 200px;
        margin-left: 500px;
        background-color: rgba(0, 255, 255, 0.295);
        border-radius: 10px;
    }
    .btn{
        padding: 0;
        border: 0px;
        width: 80%;
        height: 40px;
        background-color: rgb(53, 167, 243);
        font-size: 15px;
        margin-top: 10px;
        border-radius:5px;
        margin-left: 28px;
        text-align: center;
        line-height: 40px;
        color: aliceblue;
    }
</style>
</head>

<body>
<div class="signin">
    <h2>账号密码登录</h2>
    <form action="checkLegitimacy" method="post">
    <input type="text" name="username"  placeholder="用户名">
    <input type="password" name="password"  placeholder="密码">
    <button class="btn" type="submit">登 录</button>
    </form>
</div>
</body>
</html>