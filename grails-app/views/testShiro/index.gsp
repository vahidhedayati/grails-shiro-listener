
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'admin.label', default: 'Admin')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		


	</head>
	<body>
	
--------------------------------------------<br>
This is a list of users that will not automatically refresh:<br>

${NonRefreshUsers }


--------------------------------------------<br>

This next div will automatically update when a user logs in <br>
<div id="onlineUsers">
</div>

<g:javascript>
    function getOnline() {
        <g:remoteFunction action="getOnline" update="onlineUsers"/>
    }
    function pollPage() {
        getOnline();
        setTimeout('pollPage()', 5000);
    }
    pollPage();
</g:javascript>

</body>
</html>