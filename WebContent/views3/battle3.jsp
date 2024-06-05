<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer enemy_current_hp = (Integer) request.getSession().getAttribute("enemy_current_hp");
Integer hero_current_hp = (Integer) request.getSession().getAttribute("hero_current_hp");
Integer enemy_hp = (Integer) request.getAttribute("enemy_hp");
Integer hero_hp = (Integer) request.getAttribute("hero_hp");
%>




<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>対戦画面</title>
<link rel="stylesheet" href="<c:url value='/views3/battle3style.css' />">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
    src="${pageContext.request.contextPath}/JavaScript/battle/hpUpdate.js"></script>
<!-- <script
    src="${pageContext.request.contextPath}/JavaScript/battle/text.js"></script> -->

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

<script type="text/javascript">        // JSPの変数をJavaScriptに渡す
var message = '<%=request.getAttribute("message")%>';
var message2 = '<%=request.getAttribute("message2")%>';
var message3 = '<%=request.getAttribute("message3")%>';
var message4 = '<%=request.getAttribute("message4")%>';
console.log("JavaScriptの変数の値: " + message);        // ここでさらにJavaScriptの処理を行う

document.addEventListener('DOMContentLoaded', function() {
    const messages = [message, message2,message3,message4]; // 表示するメッセージのリスト
    let currentIndex = 0; // 現在のメッセージインデックス
    const messageBox = document.getElementById('message-display');
    const nextTextButton = document.getElementById('nextButton');    // 最初のメッセージを表示
    messageBox.textContent = messages[currentIndex];
    nextTextButton.addEventListener('click', function() {
        currentIndex++; // インデックスを進める
        if ((currentIndex < messages.length)
                && (messages[currentIndex] != null)) {            // 次のメッセージを表示
            messageBox.textContent = messages[currentIndex];
        }else {            // これ以上表示するメッセージがない場合、ボタンを無効にする
            nextTextButton.disabled = true;
        }
});
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
            <img src="<c:url value='/views3/durahan.png' />" alt="相手のポケモン"
                class="enemy-img">
            <div class="hp-bar">
                <!-- <div class="hp-fill" style="width: ${(enemy_current_hp >= 0) ? (100 * (enemy_hp - enemy_current_hp) / enemy_hp) : 0}%;"></div> -->
                <div class="hp-fill" style="width: ${enemy_current_hp * 100/ enemy_hp}%;"></div>

            </div>
            <!-- <p>HP: <c:out value="${(enemy_current_hp >= 0) ? (enemy_hp - enemy_current_hp) : enemy_hp}" /> / <c:out value="${enemy_hp}" /></p>  -->
            <p>
            HP:
            <span id="enemy-hp"><c:out value="${enemy_current_hp}" /></span>
             /
            <c:out value="${enemy_hp}" />
            </p>
        </div>

        <div class="player">
            <img src="<c:url value='/views3/hero.png' />" alt="自分のポケモン"
                class="player-img">
            <div class="hp-bar">
                <div class="hp-fill" style="width: ${100 * hero_current_hp / hero_hp}%;"></div>
            </div>
            <p>

                HP:
                <c:out value="${hero_current_hp}" />
                /
                <c:out value="${hero_hp}" />
            </p>
        </div>


        <form method="POST" action="/Sawano_special/practice3">
            <div class="attack">
      <% if (Boolean.TRUE.equals(request.getAttribute("attack_locked"))) { %>
                <button disabled type="submit" name="attack" id="attack" value="攻撃">攻撃する</button>
          <% } else { %>
        <button  type="submit" name="attack" id="attack" value="攻撃">攻撃する</button>
                <% } %>
            </div>
        </form>

        <form method="POST" action="/Sawano_special/practice3">
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
                <button disabled type="submit">逃げる</button>
                <% } else { %>
                <button type="submit">逃げる</button>
                 <% } %>
            </form>
        </div>


        <form action="${pageContext.request.contextPath}/StageSelect" method="get">
        <button type="submit" id="stage-select-button">ステージクリア！！</button>
        </form>


    </div>

</body>
</html>

<%
request.getSession().setAttribute("enemy_current_hp", enemy_current_hp);
%>