<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゆうしゃのじょうほう</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://code.jquery.com/jquery-3.7.1.slim.js"
    integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
<%-- <script
    src="${pageContext.request.contextPath}/JavaScript/hero_info/hero_info.js"
    defer></script> --%>
</head>
<body>


<form action="${pageContext.request.contextPath}/StageSelect" method="post">
    <select id="my-select" name="hero_info">
        <option value="1">勇者</option>
        <option value="2">魔法使い</option>
        <option value="3">剣士</option>
    </select>
    <button type="submit">選択</button>
</form>

<form action="${pageContext.request.contextPath}/StageSelect" method="get">
    <button type="submit">戻る</button>
</form>

  

</body>
</html>