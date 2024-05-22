<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>対戦画面</title>
        <link rel="stylesheet" href="<c:url value='/views1/battle1style.css' />">
    </head>
    <body>
           <div class="layer">

           <div class="textbox">主人公は${result }ダメージを与えた！！</div>


           <div class="enemy">
            <!-- 相手のポケモンの画像をここに配置 -->
            <img src="<c:url value='/views1/Sample.jpg' />" alt="相手のポケモン" class="enemy-img">
            <p>HP: 70/100</p>
           </div>

           <div class="player">
            <!-- 自分のポケモンの画像をここに配置 -->
            <img src="<c:url value='/views1/Sample1.jpg' />" alt="自分のポケモン" class="player-img">
            <p>HP: 50/100</p>
            </div>
            <div class="attack">
            <button>攻撃する</button>
            </div>
            <div class="recover">
            <button>回復する</button>
            </div>
            <div class="escape">
            <form action="${pageContext.request.contextPath}/StageSelect" method="get">
                <button type="submit">逃げる</button>
            </form>
            </div>

            <!-- action属性をサーブレットのコンテキストパスとURLパターンに修正 -->
            <!-- action属性をサーブレットのコンテキストパスとURLパターンに修正 -->
            <form action="${pageContext.request.contextPath}/StageSelect" method="get">
                <button type="submit">ステージ選択画面に戻る</button>
            </form>

            </div>

    </body>
</html>