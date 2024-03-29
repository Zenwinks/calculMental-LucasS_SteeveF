<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Accueil</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<html>
<body>
<div class="callout large primary">
    <div class="row column text-center">
        <h1>Accueil</h1>
    </div>
</div>
<div class="row small-8 small-centered">
    <h1>TOP 10</h1>
</div>
<div class="row">
    <div class="columns small-5">
        <table>
            <thead>
            <tr>
                <th>Pseudo</th>
                <th>Meilleur score</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="leader" items="${ sessionScope.leaders }" varStatus="status">
                <tr>
                    <td>${leader.login}</td>
                    <td>${leader.bestScore}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="columns small-7">
        <a href="jeu" class="button expanded">
            Jouer
        </a>
    </div>
</div>
</body>
</html>
