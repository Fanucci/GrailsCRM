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
<g:if test="${contactInstanceList[0]!=null}">
<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
  <thead>
    <tr>
       <g:each in="${contactInstanceList[0].contactfields}" status="z" var="contactField1">
                <th class="mdl-data-table__cell--non-numeric">${contactField1.getFieldName()}</th>
      </g:each>
    </tr>
  </thead>
  <tbody>
                <g:each in="${contactInstanceList}" status="i" var="contactInstance">
                        <tr>
                            <g:each in="${contactInstance.contactfields}" status="x" var="contactField">
                <td class="mdl-data-table__cell--non-numeric">${contactField.getFieldProperty()}</td>
      </g:each>
    </tr>
                </g:each>
  </tbody>
</table>
</g:if>


			<div class="pagination">
				<g:paginate total="${contactInstanceTotal}" />
			</div>       
              <button id="show-action" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
    Show Action
            </button>
    <script>
        $('#show-action').click(function () {
        showDialog({
            title: 'Upload Base?',
            text: 'Вы собираетесь dsuhepbnm базу.<br/>Продолжить?',
            negative: {
                title: 'Нет'
            },
            positive: {
                title: 'Да',
                onClick: function (e) {
                location.href="${createLink(controller: 'contact', action: 'download')}";
                }}
        });
    });
    </script>
    </div>  
    </body>
</html>
