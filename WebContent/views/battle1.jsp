<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>RPG</title>
    </head>
    <body>
        <div id="header">
            <h1>今から始まる</h1>
            <h2>次の挑戦</h2>

            <!-- action属性をサーブレットのコンテキストパスとURLパターンに修正 -->
            <!-- action属性をサーブレットのコンテキストパスとURLパターンに修正 -->
            <form action="${pageContext.request.contextPath}/StageSelect" method="get">
                <button type="submit">ステージ選択画面に戻る（CV澤野）</button>
            </form>

        </div>
    </body>
</html>