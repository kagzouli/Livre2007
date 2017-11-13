<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout"%>

<%@page import="fr.livre.common.Constante"%>
<bean:define id="userDataContext" name="<%=Constante.DATA_CONTEXT%>"
	type="fr.livre.user.UserDataContext" />
<bean:define id="listRole" name="userDataContext" property="listRole" />

<div id="body">
<%
// Si il y'a une erreur%> 

<logic:present
	name="<%=org.apache.struts.Globals.ERROR_KEY%>">
	<TABLE BORDER="0">
		<tr>
			<td>
			<div id="idmessageerreuradmin" class="messageadmin"><html:errors />
			</div>
			</td>
		</tr>
	</TABLE>
</logic:present> 

<html:form action="/admin/TraitementRechercheUserAction">

	<!-- CREATION DE LOGIN -->
	<TABLE BORDER="0" cellspacing="4" class="tablerecherche">
		<tr>
			<td>
			<table class="interieurtablerecherche">

				<tr>
					<td width="30"></td>
					<td width="150"><span class="labelfield"><bean:message
						key="livre.user.login" /></span></td>
					<td width="10"><span class="labelfield">:</span></td>
					<td width="150"><html:text property="login" size="25"
						maxlength="50" /></td>
					<td width="90"></td>
					<td width="150"><span class="labelfield"><bean:message
						key="livre.user.name" /></span></td>
					<td width="10"><span class="labelfield">:</span></td>
					<td width="150"><html:text property="nom" size="25"
						maxlength="50" /></td>

					<td width="20"></td>
				</tr>
				<tr>
					<td width="30"></td>
					<td width="150"><span class="labelfield"><bean:message
						key="livre.user.prenom" /></span></td>
					<td width="10"><span class="labelfield">:</span></td>
					<td width="150"><html:text property="prenom" size="25"
						maxlength="50" /></td>
					<td width="90"></td>
					<td width="150"><span class="labelfield"><bean:message
						key="livre.user.mail" /></span></td>
					<td width="10"><span class="labelfield">:</span></td>
					<td width="150"><html:text property="mail" size="25"
						maxlength="50" /></td>

					<td width="20"></td>
				</tr>
				<tr>
					<td width="30"></td>
					<td width="150"><span class="labelfield"><bean:message
						key="livre.user.droit" /></span></td>
					<td width="90"><span class="labelfield">:</span></td>
					<td width="150"><html:select property="role">
						<html:option value="">
							<bean:message key="livre.select.element" />
						</html:option>
						<logic:iterate id="roleBean" name="listRole"
							type="fr.livre.common.RoleBean">
							<html:option value="<%=roleBean.getLibelle()%>">
								<bean:write name="roleBean" property="libelle" />
							</html:option>
						</logic:iterate>
					</html:select></td>
					<td width="330" colspan="5"></td>
				</tr>

				<tr>
					<td colspan="8"></td>
					<td><html:submit styleClass="styleButton">
						<bean:message key="livre.recherche.button" />
					</html:submit></td>
				</tr>
			</TABLE>
			</td>
		</tr>
	</table>

	<br />
	<br />

	<%
	String imgOeil = new StringBuffer(40).append(request.getContextPath()).append("/images/oeil.gif").toString();
	%>
	<logic:present name="userDataContext" property="listUserBusinessBean">
		<table>
			<tr>
				<td><logic:notEmpty name="userDataContext" property="listUserBusinessBean">
					 <bean:define id="listeuser" name="userDataContext" property="listUserBusinessBean" />
						

					<layout:pager maxPageItems="10">
						<layout:collection id="user" name="listeuser"
							styleClass="enteteTab">
							<layout:collectionItem title="livre.user.login"
								styleClass="contenuTab" name="user" property="login"
								sortable="true" />
							<layout:collectionItem title="livre.user.password"
								styleClass="contenuTab" name="user" property="password"
								sortable="true" />
							<layout:collectionItem title="livre.user.name"
								styleClass="contenuTab" name="user" property="nom"
								sortable="true" />
							<layout:collectionItem title="livre.user.prenom"
								styleClass="contenuTab" name="user" property="prenom"
								sortable="true" />
							<layout:collectionItem title="livre.user.droit"
								styleClass="contenuTab" name="user" property="role.libelle"
								sortable="true" />
							<layout:collectionItem action="/admin/InitConsultationUserAction"
								paramId="idUser" paramName="user" paramProperty="idUser">
								<html:img src="<%=imgOeil%>" border="0" />
							</layout:collectionItem>
						</layout:collection>
					</layout:pager>
				</logic:notEmpty> <logic:empty name="listeuser">
					<bean:message key="livre.recherche.aucunresultat" />
				</logic:empty></td>
			</tr>
		</TABLE>
	</logic:present>

</html:form></div>