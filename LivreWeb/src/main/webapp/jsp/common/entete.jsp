<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

 <%@page import="fr.livre.common.Constante"%>
 
  <TABLE BORDER="0">
     <tr>
		 <td> <span class="entete"> <bean:message key="livre.entete.hellobegin" />&nbsp;<bean:write name="<%=Constante.USER_DATA%>" property="login" scope="session"/> </span> </td>
	 </tr>
  </TABLE>
  
    <TABLE BORDER="0">
     <tr>
		 <td width="850">&nbsp;</td>
		 <td><html:link action="/Logout"><bean:message key="livre.deconnexion" /></html:link></td>
	 </tr>
  </TABLE>
  
  
  <hr />
  <br/>