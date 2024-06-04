<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゆうしゃのじょうほう</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
$(document).ready(function() {
    $('#character-select').change(function() {
        var selectedValue = $(this).val();
        var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
        $.ajax({
            url: contextPath + '/GetCharacterInfo',
            method: 'GET',
            data: { id: selectedValue },
            success: function(data) {
                console.log(data); // デバッグ用
                // dataが想定通りのオブジェクトであることを確認します
                if (data && data.name && data.description && data.imagePath) {
                    $('#character-name').text(data.name);
                    $('#character-description').text(data.description);
                    $('#character-image').attr('src', contextPath + data.imagePath);

                    // キャラクターのステータスデータを取得
                    var stats = data.stats; // { attack: 80, defense: 60, speed: 70, hp: 50, magic: 90 }

                    // 既存のチャートがあれば破棄
                    if (window.myRadarChart) {
                        window.myRadarChart.destroy();
                    }

                    // レーダーチャートの描画
                    var ctx = document.getElementById('character-stats-chart').getContext('2d');
                    window.myRadarChart = new Chart(ctx, {
                        type: 'radar',
                        data: {
                            labels: ['攻撃力', '防御力', 'スピード', 'HP', '魔法力'],
                            datasets: [{
                                label: data.name + 'のステータス',
                                data: [stats.attack, stats.defense, stats.speed, stats.hp, stats.magic],
                                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                                borderColor: 'rgba(54, 162, 235, 1)',
                                borderWidth: 1
                            }]
                        },
                        options: {
                            scale: {
                                ticks: {
                                    beginAtZero: true,
                                    max: 100
                                }
                            }
                        }
                    });
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
    <canvas id="character-stats-chart" width="400" height="400"></canvas>
</div>

</body>
</html>