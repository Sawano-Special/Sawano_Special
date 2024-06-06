<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer enemy_current_hp = (Integer) request.getSession().getAttribute("enemy_current_hp");
Integer hero_current_hp = (Integer) request.getSession().getAttribute("hero_current_hp");
Integer enemy_hp = (Integer) request.getAttribute("enemy_hp");
Integer hero_hp = (Integer) request.getAttribute("hero_hp");
Integer hero_attack = (Integer) request.getAttribute("hero_attack");
Integer enemy_attack = (Integer) request.getAttribute("enemy_attack");
Integer before_hero_hp = (Integer) request.getAttribute("before_hero_hp");
Integer before_enemy_hp = (Integer) request.getAttribute("before_enemy_hp");
Integer hero_speed = (Integer) request.getAttribute("hero_speed");
Integer enemy_speed = (Integer) request.getAttribute("enemy_speed");
Integer speed_ave = (Integer) request.getAttribute("speed_ave");


String imagePath = ""; // imagePathを初期化
// hero_infoの値を取得
Integer hero_info = (Integer) request.getAttribute("hero_info");
// hero_infoの値に基づいてimagePathを設定
if (hero_info == null || hero_info == 1) {
    imagePath = "hero.png";
} else if (hero_info == 2) {
    imagePath = "hero1.jpg";
} else if (hero_info == 3) {
    imagePath = "hero2.jpg";
}
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>対戦画面</title>
<link rel="stylesheet" href="<c:url value='/views1/battle1style.css' />">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- <script src="${pageContext.request.contextPath}/JavaScript/battle/hpUpdate.js"></script> -->
<!-- <script src="${pageContext.request.contextPath}/JavaScript/battle/text.js"></script> -->

<script>
$(document).ready(function() {
    // 相手のHPを取得
    const enemyHp = parseInt($("#enemy-hp").text(), 10);

    // 相手のHPが0より大きい場合、ステージ選択画面に戻るボタンを無効にする
    if (enemyHp > 0) {
        $("#stage-select-button").prop('disabled', true);
    } else {
        // HPが0またはそれ以下の場合、ボタンを有効にする
        $("#stage-select-button").prop('disabled', false);
    }
});
</script>

<script type="text/javascript">
var message = '<%=request.getAttribute("message")%>';
var message2 = '<%=request.getAttribute("message2")%>';

console.log("JavaScriptの変数の値: " + message);
console.log("JavaScriptの変数の値: " + message2);

// HPゲージを更新する関数
function updateHpBar(hpBarId, currentHp, maxHp) {
    const hpPercentage = (currentHp / maxHp) * 100;
    $(hpBarId).css('width', hpPercentage + '%');
}

document.addEventListener('DOMContentLoaded', function() {
    const messages = [message, message2]; // 表示するメッセージのリスト
    let currentIndex = 0; // 現在のメッセージインデックス
    const messageBox = document.getElementById('message-display');
    const nextTextButton = document.getElementById('nextButton');
    const hero_display_hp = document.getElementById('hero-hp');
    const enemy_display_hp = document.getElementById('enemy_display_hp');
    const attack = document.getElementById('attack');
    const recovery = document.getElementById('recovery');
    const run_away = document.getElementById('run_away');

    attack.disabled = true;
    recovery.disabled = true;
    run_away.disabled = true;

    console.log("開かれた");

    messageBox.textContent = messages[currentIndex];

    console.log(${hero_speed});
    console.log(${enemy_speed});

    if(${hero_speed} > ${enemy_speed}){
        updateHpBar('.enemy .hp-fill', '${enemy_current_hp}', '${enemy_hp}');

        enemy_display_hp.innerHTML = 'HP: <c:out value="${enemy_current_hp}" />/<c:out value="${enemy_hp}" />';

        console.log("第1メッセージ!!");

        console.log("${enemy_current_hp}");
        if(${before_hero_hp} == "null"){
        updateHpBar('.player .hp-fill','${hero_hp}', '${hero_hp}');
        hero_display_hp.innerHTML = 'HP:<c:out value="${hero_hp}" />/<c:out value="${hero_hp}" />';
        }else{
            updateHpBar('.player .hp-fill','${before_hero_hp}', '${hero_hp}');
            hero_display_hp.innerHTML = 'HP:<c:out value="${before_hero_hp}" />/<c:out value="${hero_hp}" />';
        }

        nextTextButton.addEventListener('click', function() {
            currentIndex++; // インデックスを進める

            if (currentIndex < messages.length) {
                messageBox.textContent = messages[currentIndex];

                updateHpBar('.player .hp-fill','${hero_current_hp}', '${hero_hp}');
                hero_display_hp.innerHTML = 'HP:<c:out value="${hero_current_hp}" />/<c:out value="${hero_hp}" />';
                console.log("第2メッセージ!!");
                console.log("${hero_current_hp}");

                // ここでHPゲージの更新処理を行います
                // 例として、敵とヒーローのHPをランダムに減らしていますが、実際のロジックに合わせて調整してください
               // if (currentIndex ===1) { // 最初のメッセージ後に敵のHPを減らす
                 //   updateHpBar('.player .hp-fill','${hero_current_hp}', '${hero_hp}');
                   // console.log("第2メッセージ!!");
                   // console.log("${hero_current_hp}");

                //}
            } else {
                nextTextButton.disabled = true; // これ以上表示するメッセージがない場合、ボタンを無効にする
                attack.disabled = false;
                recovery.disabled = false;
                run_away.disabled = false;
                console.log('適用されてない');
            }
        });
    }else if(${hero_speed} < ${enemy_speed} ){
        updateHpBar('.player .hp-fill','${hero_current_hp}', '${hero_hp}');

        hero_display_hp.innerHTML = 'HP: <c:out value="${hero_current_hp}" />/<c:out value="${hero_hp}" />';

        console.log("第1メッセージ!!");

        console.log("${hero_current_hp}");
        if(${before_enemy_hp} == "null"){
        updateHpBar('.player .hp-fill','${enemy_hp}', '${enemy_hp}');
        enemy_display_hp.innerHTML = 'HP:<c:out value="${enemy_hp}" />/<c:out value="${enemy_hp}" />';
        }else{
            updateHpBar('.player .hp-fill','${before_enemy_hp}', '${enemy_hp}');
            enemy_display_hp.innerHTML = 'HP:<c:out value="${before_enemy_hp}" />/<c:out value="${enemy_hp}" />';
        }

        nextTextButton.addEventListener('click', function() {
            currentIndex++; // インデックスを進める

            if (currentIndex < messages.length) {
                messageBox.textContent = messages[currentIndex];

                updateHpBar('.enemy .hp-fill', '${enemy_current_hp}', '${enemy_hp}');
                hero_display_hp.innerHTML = 'HP:<c:out value="${enemy_current_hp}" />/<c:out value="${enemy_hp}" />';
                console.log("第2メッセージ!!");
                console.log("${enemy_current_hp}");

                // ここでHPゲージの更新処理を行います
                // 例として、敵とヒーローのHPをランダムに減らしていますが、実際のロジックに合わせて調整してください
               // if (currentIndex ===1) { // 最初のメッセージ後に敵のHPを減らす
                 //   updateHpBar('.player .hp-fill','${hero_current_hp}', '${hero_hp}');
                   // console.log("第2メッセージ!!");
                   // console.log("${hero_current_hp}");

                //}
            } else {
                nextTextButton.disabled = true; // これ以上表示するメッセージがない場合、ボタンを無効にする
                console.log('適用されてない');
            }
        });
    }else{  //スピードが同じとき
        //ヒーロー先攻撃
        if(${speed_ave} <= 5){
            updateHpBar('.enemy .hp-fill', '${enemy_current_hp}', '${enemy_hp}');

            enemy_display_hp.innerHTML = 'HP: <c:out value="${enemy_current_hp}" />/<c:out value="${enemy_hp}" />';

            console.log("第1メッセージ!!");

            console.log("${enemy_current_hp}");
            if(${before_hero_hp} == "null"){
            updateHpBar('.player .hp-fill','${hero_hp}', '${hero_hp}');
            hero_display_hp.innerHTML = 'HP:<c:out value="${hero_hp}" />/<c:out value="${hero_hp}" />';
            }else{
                updateHpBar('.player .hp-fill','${before_hero_hp}', '${hero_hp}');
                hero_display_hp.innerHTML = 'HP:<c:out value="${before_hero_hp}" />/<c:out value="${hero_hp}" />';
            }

            nextTextButton.addEventListener('click', function() {
                currentIndex++; // インデックスを進める

                if (currentIndex < messages.length) {
                    messageBox.textContent = messages[currentIndex];

                    updateHpBar('.player .hp-fill','${hero_current_hp}', '${hero_hp}');
                    hero_display_hp.innerHTML = 'HP:<c:out value="${hero_current_hp}" />/<c:out value="${hero_hp}" />';
                    console.log("第2メッセージ!!");
                    console.log("${hero_current_hp}");

                    // ここでHPゲージの更新処理を行います
                    // 例として、敵とヒーローのHPをランダムに減らしていますが、実際のロジックに合わせて調整してください
                   // if (currentIndex ===1) { // 最初のメッセージ後に敵のHPを減らす
                     //   updateHpBar('.player .hp-fill','${hero_current_hp}', '${hero_hp}');
                       // console.log("第2メッセージ!!");
                       // console.log("${hero_current_hp}");

                    //}
                } else {
                    nextTextButton.disabled = true; // これ以上表示するメッセージがない場合、ボタンを無効にする
                    console.log('適用されてない');
                }
            });
        }else{  //エネミー先攻撃
            updateHpBar('.player .hp-fill','${hero_current_hp}', '${hero_hp}');

            hero_display_hp.innerHTML = 'HP: <c:out value="${hero_current_hp}" />/<c:out value="${hero_hp}" />';

            console.log("第1メッセージ!!");

            console.log("${hero_current_hp}");
            if(${before_enemy_hp} == "null"){
            updateHpBar('.player .hp-fill','${enemy_hp}', '${enemy_hp}');
            enemy_display_hp.innerHTML = 'HP:<c:out value="${enemy_hp}" />/<c:out value="${enemy_hp}" />';
            }else{
                updateHpBar('.player .hp-fill','${before_enemy_hp}', '${enemy_hp}');
                enemy_display_hp.innerHTML = 'HP:<c:out value="${before_enemy_hp}" />/<c:out value="${enemy_hp}" />';
            }

            nextTextButton.addEventListener('click', function() {
                currentIndex++; // インデックスを進める

                if (currentIndex < messages.length) {
                    messageBox.textContent = messages[currentIndex];

                    updateHpBar('.enemy .hp-fill', '${enemy_current_hp}', '${enemy_hp}');
                    hero_display_hp.innerHTML = 'HP:<c:out value="${enemy_current_hp}" />/<c:out value="${enemy_hp}" />';
                    console.log("第2メッセージ!!");
                    console.log("${enemy_current_hp}");

                    // ここでHPゲージの更新処理を行います
                    // 例として、敵とヒーローのHPをランダムに減らしていますが、実際のロジックに合わせて調整してください
                   // if (currentIndex ===1) { // 最初のメッセージ後に敵のHPを減らす
                     //   updateHpBar('.player .hp-fill','${hero_current_hp}', '${hero_hp}');
                       // console.log("第2メッセージ!!");
                       // console.log("${hero_current_hp}");

                    //}
                } else {
                    nextTextButton.disabled = true; // これ以上表示するメッセージがない場合、ボタンを無効にする
                    console.log('適用されてない');
                }
            });
        }
    }

});

</script>

</head>
<body>
    <div class="layer">
        <div class="textbox">
            <span id="message-display"><%=request.getAttribute("message")%></span>
            <button id="nextButton">Next Message</button>
        </div>

        <div class="enemy">
            <img src="<c:url value='/views1/slime.png' />" alt="相手のポケモン"
                class="enemy-img">
            <div class="hp-bar">
                <div class="hp-fill" ></div>
            </div>
            <p id="enemy_display_hp">
                HP: <span id="enemy-hp"><c:out value="${enemy_current_hp}" /></span>
                /
                <c:out value="${enemy_hp}" />
            </p>
        </div>

        <div class="player">
            <img src="${pageContext.request.contextPath}/views1/<%= imagePath %>"
                alt="自分のポケモン" class="player-img">
            <div class="hp-bar">
                <div class="hp-fill" ></div>
            </div>
            <p id="hero-hp">
                HP:
                <c:out value="${hero_current_hp}" />
                /
                <c:out value="${hero_hp}" />
            </p>
        </div>

        <form method="POST" action="/Sawano_special/practice">
            <div class="attack">
      <% if (Boolean.TRUE.equals(request.getAttribute("attack_locked"))) { %>
                <button disabled type="submit" name="attack" id="attack" value="攻撃">攻撃する</button>
          <% } else { %>
        <button  type="submit" name="attack" id="attack" value="攻撃">攻撃する</button>
                <% } %>
            </div>
        </form>

        <form method="POST" action="/Sawano_special/practice">
        <div class="recover">
        <% if (Boolean.TRUE.equals(request.getAttribute("recovery_locked"))) { %>
            <button disabled  type="submit" name="recovery" id="recovery" value="回復">回復する</button>
            <% } else { %>
            <button  type="submit" name="recovery" id="recovery" value="回復">回復する</button>
             <% } %>
             </div>
        </form>

        <div class="escape">
            <form action="${pageContext.request.contextPath}/StageSelect"
                method="get">
                 <% if (Boolean.TRUE.equals(request.getAttribute("run_locked"))) { %>
                <button disabled type="submit" id = "run_away">逃げる</button>
                <% } else { %>
                <button type="submit" id="run_away">逃げる</button>
                 <% } %>
            </form>
        </div>

        <form action="${pageContext.request.contextPath}/StageSelect"
            method="get">
            <button type="submit" id="stage-select-button">ステージ1クリア！！</button>
        </form>
    </div>
</body>
</html>

<%
request.getSession().setAttribute("enemy_current_hp", enemy_current_hp);
request.getSession().setAttribute("hero_current_hp", hero_current_hp);
%>