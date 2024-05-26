<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer sum_damage = (Integer) request.getSession().getAttribute("sum_damage");
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
<script src="${pageContext.request.contextPath}/JavaScript/battle/hpUpdate.js"></script>
</head>
<body>
    <div class="layer">
        <div class="textbox">
           <c:choose>
                <c:when test="${sum_damage >= 0}">
                    <c:out value="${name}" />
                        は
                    <c:out value="${attack}" />
                        ダメージを与えた！！
                </c:when>
                <c:when test="${sum_damage < 0}">
                    <c:out value="${name}" />
                        は敵を倒した
                </c:when>
                <c:otherwise>
                    <p>バトルスタート！！</p>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="enemy">
            <img src="<c:url value='/views1/Sample.jpg' />" alt="相手のポケモン" class="enemy-img">
            <div class="hp-bar">
                <div class="hp-fill" style="width: ${(sum_damage >= 0) ? (100 * (enemy_hp - sum_damage) / enemy_hp) : 0}%;"></div>
            </div>
            <p>HP: <c:out value="${(sum_damage >= 0) ? (enemy_hp - sum_damage) : enemy_hp}" /> / <c:out value="${enemy_hp}" /></p>
        </div>

        <div class="player">
            <img src="<c:url value='/views1/Sample1.jpg' />" alt="自分のポケモン" class="player-img">
            <div class="hp-bar">
                <div class="hp-fill" style="width: ${100 * hero_hp / hero_hp}%;"></div>
            </div>
            <p>HP: <c:out value="${hero_hp}" /> / <c:out value="${hero_hp}" /></p>
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
            <form action="${pageContext.request.contextPath}/StageSelect" method="get">
                <button type="submit">逃げる</button>
            </form>
        </div>

        <form action="${pageContext.request.contextPath}/StageSelect" method="get">
            <button type="submit">ステージ選択画面に戻る</button>
        </form>
    </div>

</body>
</html>

<%
request.getSession().setAttribute("sum_damage", sum_damage);
%>