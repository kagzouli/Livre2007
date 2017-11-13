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
     <div id="idmessage" class="messageerreur">  
         <html:errors />
      </div>  
   </td>
  </tr>
</TABLE>


 <br>
 
 <html:form action="/inscription/TraitementInscriptionAction">
 <html:hidden property="role" />
  <TABLE BORDER="0" cellspacing="7">
 
    <tr>
      <td width="200">  </td>
		  <td width="100"><span class="labelfield"><bean:message key="livre.inscription.login"/></span></td>
		  <td width="50"> <span class="labelfield">:</span></td>
		  <td width="50"> <span class="mandatory">*</span></td>
		  <td width="200"> <html:text property="login" size="25" maxlength="50" />  </td>
		  <td width="200"> </td>
   	</tr>
		
		<tr>
      <td width="200">  </td>
		  <td width="100"> <span class="labelfield"><bean:message key="livre.inscription.password"/></span></td>
		  <td width="50">  <span class="labelfield">: </span></td>
		  <td width="50">  <span class="mandatory">* </span></td>
		  <td width="200"> <html:password property="password" size="25" maxlength="50"/></td>
		  <td width="200"> </td>
   	</tr>
		
	<tr>
      <td width="200">  </td>
		  <td width="100"> <span class="labelfield"><bean:message key="livre.inscription.password2"/></span> </td>
		  <td width="50">  <span class="labelfield"> : </span> </td>
		  <td width="50">  <span class="mandatory"> * </span> </td>
		  <td width="200"> <html:password property="password2" size="25" maxlength="50" />  </td>
		  <td width="200"> </td>
   	</tr>
   	
    <tr>
      <td width="200">  </td>
		  <td width="100"> <span class="labelfield"><bean:message key="livre.inscription.name"/></span> </td>
		  <td width="50">  <span class="labelfield"> : </span> </td>
		  <td width="50">  <span class="mandatory"> * </span> </td>
		  <td width="200"> <html:text property="nom" size="25" maxlength="60" />  </td>
		  <td width="200"> </td>
   	</tr>
   	
   	<tr>
      <td width="200">  </td>
		  <td width="100"> <span class="labelfield"><bean:message key="livre.inscription.prenom"/></span> </td>
		  <td width="50">  <span class="labelfield"> : </span> </td>
		  <td width="50">  <span class="mandatory"> * </span> </td>
		  <td width="200"> <html:text property="prenom" size="25" maxlength="60"/>  </td>
		  <td width="200"> </td>
   	</tr>
   	
   	<tr>
      <td width="200">  </td>
		  <td width="100"> <span class="labelfield"><bean:message key="livre.inscription.adresse"/></span> </td>
		  <td width="50">  <span class="labelfield"> : </span> </td>
		  <td width="50">  <span class="mandatory"> * </span> </td>
		  <td width="200"> <html:textarea property="adresse" cols="25" rows="3" />  </td>
		  <td width="200"> </td>
   	</tr>

  	<tr>
      <td width="200">  </td>
		  <td width="100"> <span class="labelfield"><bean:message key="livre.inscription.mail"/></span> </td>
		  <td width="50">  <span class="labelfield"> : </span> </td>
		  <td width="50">  <span class="mandatory"> * </span> </td>
		  <td width="200"> <html:text property="mail" size="25" maxlength="50"/>  </td>
		  <td width="200"> </td>
   	</tr>
   </TABLE>
  
	 <br>
	 
	 <TABLE BORDER="0">
	  <tr>
		 <td width="370"> </td>
		 <td width="150"> <html:submit styleClass="styleButton"> <bean:message key="livre.inscription.send"/> </html:submit> </td>
		 <td width="250"> </td>
		</tr>
	 </TABLE> 
	 
	 <br>
	 <TABLE BORDER="0">
	  <tr>
		 <td width="300"> </td>
		 <td width="300"> <span class="mandatory"><bean:message key="livre.appli.mandatory"/></span> </td>
		 <td width="200"> </td>
		</tr>
	 </TABLE>
  
 
  </html:form>
 
 </body>

 </html:html>
