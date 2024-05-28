<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer current_hp = (Integer) request.getSession().getAttribute("current_hp");
Integer enemy_hp = (Integer) request.getAttribute("enemy_hp");
Integer hero_hp = (Integer) request.getAttribute("hero_hp");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>対戦画面</title>
<link rel="stylesheet" href="<c:url value='/views1/battle1style.css' />">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
    src="${pageContext.request.contextPath}/JavaScript/battle/hpUpdate.js"></script>
<script
    src="${pageContext.request.contextPath}/JavaScript/battle/text.js"></script>
</head>
<body>
    <div class="layer">
        <div class="textbox">
            <span id="message-display"><%=request.getAttribute("message")%></span>
        </div>

        <div class="enemy">
            <img src="<c:url value='/views1/tatunami.jpg' />" alt="相手のポケモン"
                class="enemy-img">
            <div class="hp-bar">
                <!-- <div class="hp-fill" style="width: ${(current_hp >= 0) ? (100 * (enemy_hp - current_hp) / enemy_hp) : 0}%;"></div> -->
                <div class="hp-fill" style="width: ${current_hp * 100/ enemy_hp}%;"></div>

            </div>
            <!-- <p>HP: <c:out value="${(current_hp >= 0) ? (enemy_hp - current_hp) : enemy_hp}" /> / <c:out value="${enemy_hp}" /></p>  -->
            <p>
                HP:
                <c:out value="${current_hp}" />
                /
                <c:out value="${enemy_hp}" />
            </p>
        </div>

        <div class="player">
            <img src="<c:url value='/views1/Sample1.jpg' />" alt="自分のポケモン"
                class="player-img">
            <div class="hp-bar">
                <div class="hp-fill" style="width: ${100 * hero_hp / hero_hp}%;"></div>
            </div>
            <p>
                HP:
                <c:out value="${hero_hp}" />
                /
                <c:out value="${hero_hp}" />
            </p>
        </div>

        <form method="POST" action="/Sawano_special/practice">
            <div class="attack">
                <button type="submit" name="attack" id="attack" value="攻撃">攻撃する</button>
            </div>
        </form>

        <div class="recover">
            <button>回復する</button>
        </div>
        <div class="escape">
            <form action="${pageContext.request.contextPath}/StageSelect"
                method="get">
                <button type="submit">逃げる</button>
            </form>
        </div>


    </div>

</body>
</html>

<%
request.getSession().setAttribute("current_hp", current_hp);
%>