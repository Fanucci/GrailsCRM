<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="new_view">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>
    </head>
    <body>
              <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content">
                    			<g:uploadForm action="uploadfile">
				<fieldset class="form">
                    <input type="file" name="file" />
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="upload" class="save" value="Загрузить" />
				</fieldset>
			</g:uploadForm>
                                        
        <table>
                <thead>
                        <tr>
                                <g:sortableColumn property="phone" title="Phone" />
                                <g:sortableColumn property="region" title="Region" />
                        </tr>
                </thead>
                <tbody>
                <g:each in="${contactInstanceList}" status="i" var="contactInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <td><g:textField name="myField" value="${contactInstance.getPropertyOf("phone")}" /></td>
                                <td><g:textField name="myField2" value="${contactInstance.getPropertyOf("region")}" /></td>
                        </tr>
                </g:each>
                </tbody>
        </table>

    </body>
</html>
