

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="layout/startstyle.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <title>RPG</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/gamestart.js" defer></script>
    <script src="${pageContext.request.contextPath}/JavaScript/animation.js" defer></script>

</head>
<body>

    <div class="layer">
    <div class="sawa">
        <form method="POST" action="${pageContext.request.contextPath}/Tutorial">
            <button type="submit" class="gamestart style="border: none; background: none;" name="battle1_start" id="battle1_start" value="battle1">
            <span class="theme">穏やかなる勇者の物語</span>
            <span class="theme1">～静寂の大地とささやきの風～</span>

            </button>
        </form>
        </div>

    </div>
</body>
</html>