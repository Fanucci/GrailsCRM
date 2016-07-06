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
            <div class="mdl-grid">
          <g:form name="myForm" action="findContact" controller="contact">
          <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
            <label class="mdl-button mdl-js-button mdl-button--icon" for="search2">
              <i class="material-icons">search</i>
            </label>
            <div class="mdl-textfield__expandable-holder">
                <g:textField class="mdl-textfield__input" name="search2" value="${search}"> </g:textField>
              <label class="mdl-textfield__label" value="${search}" for="search">Enter your query...</label>
            </div>
          </div>
          </g:form>
                 <g:if test="${contactInstanceList[0]!=null}">
                    <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
                        <thead>
                            <tr>
                                <g:each in="${contactInstanceList[0].contactfields}" status="z" var="contactField1">
                                    <th class="mdl-data-table__cell--non-numeric">${contactField1.getFieldName()}</th>
                                    </g:each>
                                    <th class="mdl-data-table__cell--non-numeric">Owner</th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${contactInstanceList}" var="contactInstance">
                                <tr>
                                    <g:each in="${contactInstance.contactfields}" status="x" var="contactField">
                                        <td class="mdl-data-table__cell--non-numeric">${contactField.getFieldProperty()}</td>
                                    </g:each>
                                    <td class="mdl-data-table__cell--non-numeric">${contactInstance.getOwnerUsername()}</td>
                                </tr>

                            </g:each>
                        </tbody>
                    </table>
                </g:if>




                </div>
                   </main>
                </body>
                </html>
