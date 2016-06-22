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
                        <g:submitButton name="upload" value="Загрузить" class="save" />
                    </fieldset>
                </g:uploadForm>
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

<g:form name="myForm" action="divideBase" controller="contact">
                <div class="demo-options mdl-card mdl-color--deep-purple-500 mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--3-col-tablet mdl-cell--12-col-desktop">
                    <div class="mdl-card__supporting-text mdl-color-text--blue-grey-50">
                        <h3>Разделить на:</h3>
                        <ul>

                            <g:each in="${userList}" status="i" var="it">
                                <li>
                                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                                        <g:checkBox name="myCheckbox" value="${it.id}" class="mdl-checkbox__input" />
                                        <span class="mdl-checkbox__label">${it.username}</span>
                                    </label>
                                </li>
                            </g:each>
                        </ul>
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <g:submitButton name="update" value="Поделить" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-color-text--blue-grey-50" />
                        <div class="mdl-layout-spacer"></div>
                        <i class="material-icons">format_list_numbered</i>
                    </div>
                </div>
<g:link controller="upload" action="getCodes" class="mdl-button mdl-js-button mdl-js-ripple-effect">Добавить коды</g:link>

</g:form>
                <div id="spinner" class="spinner" style="display:none;">
                    Loading&hellip;
                </div>
                </div>
                </body>
                </html>
