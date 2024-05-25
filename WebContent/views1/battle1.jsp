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
<script>
	// サーバーサイドから取得したHPの値をJavaScriptに渡す
	const sumDamage = $
	{
		sum_damage
	};
	const enemyHp = $
	{
		enemy_hp
	};
	const heroHp = $
	{
		hero_hp
	};

	// HPゲージを更新する関数
	function updateHpBars() {
		const enemyHpPercentage = (enemyHp - sumDamage) / enemyHp * 100;
		const heroHpPercentage = (heroHp - sumDamage) / heroHp * 100;

		$('.enemy-hp-bar-inner').css('width', enemyHpPercentage + '%');
		$('.player-hp-bar-inner').css('width', heroHpPercentage + '%');
	}

	$(document).ready(function() {
		// 初期状態でHPゲージを更新
		updateHpBars();

		// 攻撃ボタンがクリックされたときの処理
		$('#attack').on('click', function() {
			// HPダメージを加算
			sumDamage += 10; // 仮のダメージ

			// HPゲージを更新
			updateHpBars();

			// サーバーに更新されたHPダメージを送信するなどの処理を追加

			// デバッグ用にコンソールにダメージ値を出力
			console.log('sumDamage:', sumDamage);
		});
	});
</script>
<script src="JavaScript/battle/hpUpdate.js"></script>

<style>
/* HPゲージのスタイル */
.hp-bar {
	width: 200px; /* ゲージの幅 */
	height: 20px; /* ゲージの高さ */
	border: 1px solid black; /* 枠線 */
	margin-bottom: 10px; /* ゲージ間の余白 */
}

.hp-bar-inner {
	height: 100%; /* ゲージの高さ */
	background-color: green; /* ゲージの色 */
}
</style>
</head>
<body>
	<div class="layer">
	<!-- ここは仮 -->
	<div id="life-frame">
    <div id="life-bar"></div>
    <div id="life-mark"></div>
</div>

<div id="btns-wrap">
    <div id="increase-btn" onclick="alterLife( 10 )">+</div>
    <div id="decrease-btn" onclick="alterLife( -10 )">-</div>
</div>

<!--ここまで！！！！！！！！！！！！！  -->

		<div class="enemy-hp-bar">
			<div class="enemy-hp-bar-inner"></div>
		</div>
		<div class="player-hp-bar">
			<div class="player-hp-bar-inner"></div>

		</div>

		<div class="textbox">

			<c:out value="${name}" />
			は
			<c:out value="${attack}" />
			ダメージを与えた！！
		</div>


		<div class="enemy">
			<!-- 相手のポケモンの画像をここに配置 -->
			<img src="<c:url value='/views1/Sample.jpg' />" alt="相手のポケモン"
				class="enemy-img">
			<p>
				HP:
				<c:out value="${sum_damage}" />
				/
				<c:out value="${enemy_hp}" />
			</p>
		</div>

		<div class="player">
			<!-- 自分のポケモンの画像をここに配置 -->
			<img src="<c:url value='/views1/Sample1.jpg' />" alt="自分のポケモン"
				class="player-img">
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

		<!-- action属性をサーブレットのコンテキストパスとURLパターンに修正 -->
		<!-- action属性をサーブレットのコンテキストパスとURLパターンに修正 -->
		<form action="${pageContext.request.contextPath}/StageSelect"
			method="get">
			<button type="submit">ステージ選択画面に戻る</button>
		</form>

	</div>

</body>
</html>

<%
request.getSession().setAttribute("sum_damage", sum_damage);
%>