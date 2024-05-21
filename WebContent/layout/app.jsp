<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="appstyle.css">
        <title>RPG</title>
    </head>
    <body>
        <div id="header">
            <h1>ここから始まる</h1>
            <h2>新しい挑戦</h2>

            <form action="views1/battle1.jsp" method="get">
                <button type="submit">バトル1へ挑戦だ！</button>
            </form>
            <a href="views2/battle2.jsp">
            <img src="battle-background.png" alt="バトル2へ挑戦だ！">
            </a>
            <form action="views3/battle3.jsp" method="get">
                <button type="submit">バトル3へ挑戦だ！</button>
            </form>
            <form action="views3/battle3.jsp" method="get">
                <button type="submit">バトル4へ挑戦だ！</button>
            </form>
        </div>
    </body>
</html>