<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キャラクター選択画面</title>
<style>
/* レーダーチャートのサイズを調整するためのスタイル */
#chart-container {
  width: 30%; /* 元の大きさの0.3倍 */
  position: fixed; /*固定位置 */
  bottom: 0; /* 画面の下に配置 */
  right: 0; /* 画面の右に配置 */
  margin: 10px; /* 少しの余白を追加 */

  /* 画像を右に移動させるためのスタイル */
 #character-image {
  width: 100%; /* 元の大きさの0.3倍 */
  position: fixed; /*固定位置 */
  bottom: 0; /* 画面の下に配置 */
  left: 20px; /* 画面の右に配置 */
  margin: 10px; /* 少しの余白を追加 */
}
</style>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" crossorigin="anonymous"></script>
<!-- Chart.jsを追加 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
$(document).ready(function() {
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: ['攻撃力', 'すばやさ', 'HP'],
            datasets: [{
                label: 'ステータス',
                data: [80, 200, 200],
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                r: {
                    min: 0, // 最小値を0に設定
                    max: 300, // 最大値を300に設定
                    ticks: {
                        stepSize: 50 // 目盛りの間隔を50に設定
                    }
                }
            }
        }
    });

    function updateChartData(hero_info) {
        var newData;
        if (hero_info == 1) {
            newData = [80, 200, 200];
        } else if (hero_info == 2) {
            newData = [150, 120, 150];
        } else if (hero_info == 3) {
            newData = [80, 180, 250];
        }
        myChart.data.datasets[0].data = newData;
        myChart.update();
    }

    $('#character-select').change(function() {
        var selectedValue = $(this).val();
        updateChartData(selectedValue);

        var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
        $.ajax({
            url: contextPath + '/GetCharacterInfo',
            method: 'GET',
            data: { id: selectedValue },
            success: function(data) {
                console.log(data); // デバッグ用
                if (data && data.name && data.description && data.imagePath) {
                    $('#character-name').text(data.name);
                    $('#character-description').text(data.description);
                    $('#character-image').attr('src', contextPath + data.imagePath);
                } else {
                    console.error('Unexpected data format:', data);
                }
            },
            error: function() {
                alert('キャラクター情報の取得に失敗しました');
            }
        });
    });
});
</script>

</head>
<body>

<form id="character-form" action="${pageContext.request.contextPath}/StageSelect" method="post">
    <select id="character-select" name="hero_info">
        <option value="1">勇者</option>
        <option value="2">魔法使い</option>
        <option value="3">剣士</option>
    </select>
    <button type="submit">選択</button>
</form>

<form action="${pageContext.request.contextPath}/StageSelect" method="get">
    <button type="submit">戻る</button>
</form>

<div id="character-info">
    <h2 id="character-name"></h2>
    <p id="character-description"></p>
    <img id="character-image" src="${pageContext.request.contextPath}/hero_inf/hero.png" alt="キャラクター画像">
    <!-- レーダーチャートを表示するためのキャンバスを追加 -->
    <div id="chart-container">
        <canvas id="myChart" width="50" height="50"></canvas>
    </div>
</div>

</body>
</html>
