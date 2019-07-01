<!DOCTYPE html>
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>��ҳ</title>
</head>
<body>
	  ${name}
	<#if sex=="1">
           男
      <#elseif sex=="2">
      女
     <#else>
        其他
	  
	  </#if>	  
	 <#list listResult as user>
	   ${user}
	 </#list>
</body> 
</html>