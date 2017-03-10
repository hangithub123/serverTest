<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
<style type="text/css"></style>
<script type="text/script">

    var obj={phone:"110",password:"123456"}

    function asy(){
    try{
   var xmlhttp=new XMLHttpRequest();
}catch(e){
var xmlhttp=new ActiveXObject('Microsoft.XMLHTTP');
}
   xmlhttp.open('GET','register',true);
   xmlhttp.onreadystatechange=function(){
   if(xmlhttp.readyState == 4&&xmlhttp.status==200){
      alert("啊哈哈");
}
}
xmlhttp.send(obj);
}
</script>
</head>
<body>
<input type="button" onclick="asy();" value="send"></input>
</body>
</html>