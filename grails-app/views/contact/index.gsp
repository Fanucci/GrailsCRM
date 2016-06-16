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
<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Номер</th>
      <th>Регион</th>
    </tr>
  </thead>
  <tbody>

                <g:each in="${contactInstanceList}" status="i" var="contactInstance">
                        <tr>
      <td class="mdl-data-table__cell--non-numeric">${contactInstance.getPropertyOf("phone")}</td>
      <td>${contactInstance.getPropertyOf("region")}</td>
    </tr>
                </g:each>
  </tbody>
</table>
</div>  

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
    </body>
</html>
