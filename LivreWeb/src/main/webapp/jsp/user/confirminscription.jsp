<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<html:html locale="true">

<head>
  <link href="<%=request.getContextPath()%>/css/style.css" type="text/css" rel="StyleSheet">
</head>

<body>
 <br>
 
 
 <TABLE BORDER="0">
     <tr>
		 <td> <span class="titre"> <bean:message key="livre.inscription.titre" /> </span> </td>
	 </tr>
  </TABLE>
 
 <br>
 
 <% // Si il y'a une erreur %>
<TABLE BORDER="0">
  <tr>
    <td> 
     <div id="idmessage" class="messageinfo">  
          <bean:message key="livre.inscription.confirm" />
      </div>  
   </td>
  </tr>
</TABLE>
<br/>
<br/>
<TABLE BORDER="0">
  <tr>
    <td> 
      <div class="lieninscription">
       <html:link action="/login/InitLoginAction"><bean:message key="livre.inscription.accueil"/></html:link>
      </div>
   </td>
  </tr>
</TABLE>
</body>
</html:html>