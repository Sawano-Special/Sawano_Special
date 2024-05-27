<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="layout/appstyle.css">
    <title>RPG</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/battle/stageselect.js" defer></script>
</head>
<body>
    <div class="layer">
        <form method="POST" action="${pageContext.request.contextPath}/practice">

        <div class="textbox">
                    <c:out value="${name}" />
        </div>
            <button type="submit" style="border: none; background: none;"name="battle1_start" id="battle1_start" value="battle1">
                <img src="layout/battle-background1.jpg" alt="ステージ1" class="stage1-img">
            </button>
        </form>

        <div class="stage2">
            <a href="views2/battle2.jsp">
                <img src="layout/background2.jpg" alt="ステージ2" class="stage2-img">
            </a>
        </div>

        <div class="stage3">
            <a href="views3/battle3.jsp">
                <img src="layout/background3.jpg" alt="ステージ3" class="stage3-img">
            </a>
        </div>

        <div class="stage4">
            <a href="views4/battle4.jsp">
                <img src="layout/background4.jpg" alt="ステージ4" class="stage4-img">
            </a>
        </div>

        <div class="stage5">
            <a href="views5/battle5.jsp">
                <img src="layout/background.jpeg" alt="ステージ5" class="stage5-img">
            </a>
        </div>
    </div>
</body>
</html>
