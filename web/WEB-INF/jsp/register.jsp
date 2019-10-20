<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>S'enregistrez</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div class="callout large primary">
    <div class="row column text-center">
        <h1>Jeu Calcul Mental</h1>
    </div>
</div>
<c:if test="${ !empty registerBean.creationResult}">
    <div class="callout alert">
        <p>${registerBean.creationResult}</p>
    </div>
</c:if>
<div class="row small-5 small-centered">
    <form method="POST" action="register">
        <div class="form-icons">
            <h4>Enregistrez-vous</h4>
            <div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-user"></i>
						</span>
                <input class="input-group-field" type="text" placeholder="Login" name="form-login" value="${registerBean.login}"/>
            </div>
            <div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-key"></i>
						</span>
                <input class="input-group-field" type="password" placeholder="Mot de passe" name="form-pwd"/>
            </div>
        </div>
        <button class="button expanded">Valider</button>
    </form>


</div>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
</body>
</html>