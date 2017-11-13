<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<%@page import="fr.livre.common.Constante"%>
<bean:define id="userForm" name="userForm" />

<bean:define id="userDataContext" name="<%=Constante.DATA_CONTEXT%>"
	type="fr.livre.user.UserDataContext" />
<bean:define id="listRole" name="userDataContext" property="listRole" />


<div id="body">
<%// Si il y'a une erreur%> 
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
</logic:present> <br />
<br />

<html:form action="/admin/TraitementCreationUserAction">

	<!-- CREATION DE LOGIN -->
	<TABLE BORDER="0" cellspacing="4">

		<tr>
			<td width="100"></td>
			<td width="250"><span class="labelfield"><bean:message
				key="livre.user.login" /></span></td>
			<td width="50"><span class="labelfield">:</span></td>
			<td width="50"><span class="mandatory">*</span></td>
			<td width="300"><html:text property="login" size="25"
				maxlength="50" /></td>
			<td width="200"></td>
		</tr>

		<tr>
			<td width="100"></td>
			<td width="250"><span class="labelfield"> <bean:message
				key="livre.user.password" /> </span></td>
			<td width="50"><span class="labelfield">:</span></td>
			<td width="50"><span class="mandatory">*</span></td>
			<td width="300"><html:password property="password" size="25"
				maxlength="50" /></td>
			<td width="200"></td>
		</tr>

		<tr>
			<td width="100"></td>
			<td width="250"><span class="labelfield"><bean:message
				key="livre.user.password2" /> </span></td>
			<td width="50"><span class="labelfield">:</span></td>
			<td width="50"><span class="mandatory">* </span></td>
			<td width="300"><html:password property="password2" size="25" />
			</td>
			<td width="200"></td>
		</tr>


		<tr>
			<td width="100"></td>
			<td width="250"><span class="labelfield"><bean:message
				key="livre.user.name" /></span></td>
			<td width="50"><span class="labelfield">:</span></td>
			<td width="50"><span class="mandatory">*</span></td>
			<td width="300"><html:text property="nom" size="25"
				maxlength="60" /></td>
			<td width="200"></td>
		</tr>

		<tr>
			<td width="100"></td>
			<td width="250"><span class="labelfield"><bean:message
				key="livre.user.prenom" /></span></td>
			<td width="50"><span class="labelfield">:</span></td>
			<td width="50"><span class="mandatory">*</span></td>
			<td width="300"><html:text property="prenom" size="25"
				maxlength="60" /></td>
			<td width="200"></td>
		</tr>

		<tr>
			<td width="100"></td>
			<td width="250"><span class="labelfield"><bean:message
				key="livre.user.adresse" /></span></td>
			<td width="50"><span class="labelfield">:</span></td>
			<td width="50"><span class="mandatory">*</span></td>
			<td width="300"><html:textarea property="adresse" cols="25"
				rows="3" /></td>
			<td width="200"></td>
		</tr>

		<tr>
			<td width="100"></td>
			<td width="250"><span class="labelfield"><bean:message
				key="livre.user.mail" /></span></td>
			<td width="50"><span class="labelfield">:</span></td>
			<td width="50"><span class="mandatory">*</span></td>
			<td width="300"><html:text property="mail" size="25"
				maxlength="50" /></td>
			<td width="200"></td>
		</tr>

		<tr>
			<td width="100"></td>
			<td width="250"><span class="labelfield"><bean:message
				key="livre.user.droit" /></span></td>
			<td width="50"><span class="labelfield">:</span></td>
			<td width="50"><span class="mandatory">*</span></td>
			<td width="300"><html:select property="role">
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
			<td width="200"></td>
		</tr>


	</TABLE>

	<br>

	<!-- ENVOI  -->
	<TABLE BORDER="0">
		<tr>
			<td width="300"></td>
			<td width="300"><html:submit>
				<bean:message key="livre.user.send" />
			</html:submit></td>
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
</html:form></div>