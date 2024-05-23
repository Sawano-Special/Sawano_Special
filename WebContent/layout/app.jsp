<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="layout/appstyle.css">
        <title>RPG</title>
    </head>
    <body>
    <div class="layer">

            <h1>ゲームスタート</h1>
            <h2>ステージセレクト</h2>


            <form action="${pageContext.request.contextPath}/practice" method="POST">
            <a href="practice">
            <img src="layout/battle-background1.jpg" alt="ステージ1"class="stage1-img" >
            </a>
            </form>

            <div class="stage2">
            <a href="views2/battle2.jsp">
            <img src="layout/battle-background1.jpg" alt="ステージ２"class="stage2-img" >
            </a>
            </div>

            <a href="views3/battle3.jsp">
            <img src="<c:url value='/layout/battle-background1.jpg' />" alt="バトル3へ挑戦だ！">
            </a>
            <form action="views3/battle3.jsp" method="get">
                <button type="submit">バトル4へ挑戦だ！</button>
            </form>
        </div>
    </body>
</html>
