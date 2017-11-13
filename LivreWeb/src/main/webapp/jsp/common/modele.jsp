<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>


<html:html locale="true">

<head>
  <link href="<%=request.getContextPath()%>/css/style.css" type="text/css" rel="StyleSheet">
</head>

<body>

	<tiles:insert attribute="entete" />
	
	<br/>	
	<table>
	  <tr>
	    <td width="370" valign="top"><tiles:insert attribute="menu" /></td>
	    <td width="530" valign="top"><tiles:insert attribute="body" /></td>
	  </tr>
	</table>

</body>

</html:html>