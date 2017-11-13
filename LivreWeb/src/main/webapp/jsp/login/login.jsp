<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<!-- To prevent caching -->
<% 
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>

<head>
  <link href="<%=request.getContextPath()%>/css/style.css" type="text/css" rel="StyleSheet">
</head>


<html>
  <body>
  
   <TABLE BORDER="0">
     <tr>
		 <td> <span class="titre"> <bean:message key="livre.login.titre" /> </span> </td>
	 </tr>
	</TABLE>


 <TABLE BORDER="0">
    <tr>
      <td width="650"> </td>
      <td width="150"> <html:link action="/login/InitLoginAction?locale=fr"  > <img src="<%=request.getContextPath()%>/images/drap_fr.gif" border="0"> </html:link>  
          &nbsp; <html:link action="/login/InitLoginAction?locale=en"  > <img src="<%=request.getContextPath()%>/images/drap_GB.gif" border="0"> </html:link>
      </td>
    </tr>
</TABLE>
<br>
<br>
<br>

<% // Si il y'a une erreur %>
<TABLE BORDER="0">
  <tr>
    <td class="tdmessagelogin"> 
    
    <% if ("echec".equalsIgnoreCase(request.getParameter("message"))){ %>
       <div id="idmessage" class="messageerreur">  
         <bean:message key="livre.message.badloginpassword"/>
      </div>  
    <% } %>   
      
   </td>
  </tr>
</TABLE>

  <br>
  <br>
  
 <form action="<%=request.getContextPath()%>/j_security_check" method="POST">
  <table class="tablelogin">
    <tr>
      <td><span class="labelfield"><bean:message key="livre.login.login"/></span></td>
      <td><span class="labelfield">:</span></td>
      <td><input type="text" name="j_username" /></td>
    </tr>
    <tr>
      <td><span class="labelfield"><bean:message key="livre.login.password"/></span></td>
      <td><span class="labelfield">:</span></td>
      <td><input type="password" name="j_password" /></td>
    </tr>
    <tr>
       <td colspan="3"><center><html:submit styleClass="styleButton"><bean:message key="livre.login.valider" /></html:submit></center></td>
    </tr>
  </table>
</form>

<br>

<TABLE BORDER="0"> 
    <tr>
      <td><span class="inscription"> <html:link action="/inscription/InitInscriptionAction"> <bean:message key="livre.inscription.page"/> </html:link></span> </td>
    </tr>
</TABLE>

    
  </body>
</html>