<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゆうしゃのじょうほう</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" crossorigin="anonymous"></script>

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
</div>

</body>
</html>


</body>
</html>