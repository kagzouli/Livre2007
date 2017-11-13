<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>


<script language="javascript">
function supprimer(contexte,idUser){
  var action= contexte + "/admin/TraitementSuppressionUserAction.do?idUser="+idUser;
  if (window.confirm("Voulez vous supprimer cette utilisateur")){
     window.location = action;
  }
}

</script>

<bean:define id="userBean" name="userBean" />


<div id="body">
<%
// Si il y'a une erreur
%> <logic:present
	name="<%=org.apache.struts.Globals.ERROR_KEY%>">
	<TABLE BORDER="0">
		<tr>
			<td>
			<div id="idmessageerreuradmin" class="messageadmin"><html:errors />
			</div>
			</td>
		</tr>
	</TABLE>
</logic:present> <br />
<br />


<!-- CHARGEMENT DU USER -->
<TABLE BORDER="0" cellspacing="4">

	<tr>
		<td width="100"></td>
		<td width="250"><span class="labelfield"><bean:message
			key="livre.user.login" /></span></td>
		<td width="50"><span class="labelfield">:</span></td>
		<td width="50">&nbsp;</td>
		<td width="300"><bean:write name="userBean" property="login" /></td>
		<td width="200"></td>
	</tr>

	<tr>
		<td width="100"></td>
		<td width="250"><span class="labelfield"> <bean:message
			key="livre.user.password" /> </span></td>
		<td width="50"><span class="labelfield">:</span></td>
		<td width="50">&nbsp;</td>
		<td width="300"><bean:write name="userBean" property="password" /></td>
		<td width="200"></td>
	</tr>

	<tr>
		<td width="100"></td>
		<td width="250"><span class="labelfield"><bean:message
			key="livre.user.name" /></span></td>
		<td width="50"><span class="labelfield">:</span></td>
		<td width="50">&nbsp;</td>
		<td width="300"><bean:write name="userBean" property="nom" /></td>
		<td width="200"></td>
	</tr>

	<tr>
		<td width="100"></td>
		<td width="250"><span class="labelfield"><bean:message
			key="livre.user.prenom" /></span></td>
		<td width="50"><span class="labelfield">:</span></td>
		<td width="50">&nbsp;</td>
		<td width="300"><bean:write name="userBean" property="prenom" /></td>
		<td width="200"></td>
	</tr>

	<tr>
		<td width="100"></td>
		<td width="250"><span class="labelfield"><bean:message
			key="livre.user.adresse" /></span></td>
		<td width="50"><span class="labelfield">:</span></td>
		<td width="50">&nbsp;</td>
		<td width="300"><bean:write name="userBean" property="adresse" /></td>
		<td width="200"></td>
	</tr>

	<tr>
		<td width="100"></td>
		<td width="250"><span class="labelfield"><bean:message
			key="livre.user.mail" /></span></td>
		<td width="50"><span class="labelfield">:</span></td>
		<td width="50">&nbsp;</td>
		<td width="300"><bean:write name="userBean" property="mail" /></td>
		<td width="200"></td>
	</tr>

	<tr>
		<td width="100"></td>
		<td width="250"><span class="labelfield"><bean:message
			key="livre.user.droit" /></span></td>
		<td width="50"><span class="labelfield">:</span></td>
		<td width="50">&nbsp;</td>
		<td width="300"><bean:write name="userBean" property="role.libelle" /></td>
		<td width="200"></td>
	</tr>


</TABLE>

<br>

<!-- ENVOI  -->
<TABLE BORDER="0">
	<tr>
		<td width="200"></td>
		<td width="200">
		  <html:link action="/admin/InitModificationUserAction" paramId="idUser" paramName="userBean" paramProperty="idUser"><bean:message key="livre.user.modifier"/></html:link>
		</td>
		<td width="200">
		  <bean:define id="idUser" name="userBean" property="idUser" />
		  <a href="javascript:supprimer('<%=request.getContextPath()%>','<%=idUser%>');"> <bean:message key="livre.user.supprimer"/></a>
		</td>
		<td width="200"></td>
	</tr>
</TABLE>

<br>
<TABLE BORDER="0">
	<tr>
		<td width="250"></td>
		<td width="450"><span class="mandatory"><bean:message
			key="livre.appli.mandatory" /></span></td>
		<td width="100"></td>
	</tr>
</TABLE>
</div>