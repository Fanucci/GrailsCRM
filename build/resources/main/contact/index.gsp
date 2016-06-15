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

            
     			<table>
				<thead>
					<tr>
						<g:sortableColumn property="FieldSettings" title="FieldSettings" />
						<g:sortableColumn property="other" title="other" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${contactInstanceList}" status="i" var="documentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="download" id="${contactInstance.id}">${contactInstance.filename}</g:link></td>
						<td><g:formatDate date="${contactInstance.uploadDate}" /></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${contactInstanceTotal}" />
			</div>       
            

    </body>
</html>
