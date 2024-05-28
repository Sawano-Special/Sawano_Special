<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="layout/tutorial.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <title>RPG</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/tutorial.js" defer></script>
    <script
    src="${pageContext.request.contextPath}/JavaScript/battle/text.js"></script>
</head>
<body>
    <div class="layer">

    <h1>澤野スペシャルへようこそ</h1>

    <h2>このゲームには５つのステージが用意されている<br>
    各ステージのボスキャラを倒し、すべてのステージを制覇せよ！</h2>

    <div class="next">
    <form method="POST" action="${pageContext.request.contextPath}/StageSelect">
    <button type="submit" class="start-game">
            <a>ゲームを開始する</a>
            </button>
            </form>
        </div>
    </div>
</body>
</html>