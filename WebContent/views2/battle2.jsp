<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>対戦画面</title>
        <link rel="stylesheet" href="battle2style.css">
    </head>
    <body>
           <div class="layer">

           <div class="textbox">ここにテキストを表示</div>


           <div class="enemy">
            <!-- 相手のポケモンの画像をここに配置 -->
            <img src="Sample.jpg" alt="相手のポケモン"class="enemy-img" >
            <p>HP: 70/100</p>
           </div>

           <div class="player">
            <!-- 自分のポケモンの画像をここに配置 -->
            <img src="Sample1.jpg" alt="自分のポケモン"class="player-img">
            <p>HP: 50/100</p>
            </div>
            <div class="attack">
            <button>攻撃する</button>
            </div>
            <div class="recover">
            <button>回復する</button>
            </div>
            <div class="escape">
            <button>逃げる</button>
            </div>

            <!-- action属性をサーブレットのコンテキストパスとURLパターンに修正 -->
            <!-- action属性をサーブレットのコンテキストパスとURLパターンに修正 -->
            <!-- action属性をサーブレットのコンテキストパスとURLパターンに修正 -->
            <form action="${pageContext.request.contextPath}/StageSelect" method="get">
                <button type="submit">ステージ選択画面に戻る</button>
            </form>

            </div>

    </body>
</html>