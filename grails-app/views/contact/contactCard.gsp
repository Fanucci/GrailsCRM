
    <body>
        <main class="mdl-layout__content mdl-color--grey-100">
          <g:form name="myForm" action="findContact" controller="contact">
        <g:each in="${contactfieldsList}" status="x" var="contactField">
            

    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="sample4" value="${contactField.getFieldProperty()}">
    <label class="mdl-textfield__label" for="sample4">${contactField.getFieldName()}:</label>

  </div>
  
            </g:each>
          </g:form>
<form action="#">
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="sample3">
    <label class="mdl-textfield__label" for="sample3">Text...</label>
  </div>
</form>
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
                   </main>
                </body>

