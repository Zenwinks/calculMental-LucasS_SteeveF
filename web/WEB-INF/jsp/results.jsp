<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Jeu</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div class="callout large primary">
    <div class="row column text-center">
        <h1>Résultats</h1>
    </div>
</div>
<c:forEach var="question" items="${ questions }" varStatus="status">
    <div>
        <span><b>Calcul : </b>${question.calcul}</span><br>
        <span>Votre réponse : <i>${question.reponseUser}</i></span>
        <c:if test="${question.reponseUser != question.resultat}">
            <span style="color: red"><b>La bonne réponse était : ${question.resultat}</b></span>
        </c:if>
    </div>
</c:forEach>

</body>
</html>
