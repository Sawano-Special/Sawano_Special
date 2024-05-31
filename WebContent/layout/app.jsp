<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="layout/appstyle.css">
<title>RPG</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
    src="${pageContext.request.contextPath}/JavaScript/battle/stageselect.js"
    defer></script>
<script
    src="${pageContext.request.contextPath}/JavaScript/battle/text2.js"
    defer></script>
</head>
<body>
    <div class="layer">

        <div class="textbox">
        <div id="message-display"></div>
                <%--<span id="message-display"><%=request.getAttribute("message")%></span> --%>
  <br>          <%-- <span id="message-display"><%=request.getAttribute("jsonArray")%></span><br> --%>
            </div>

        <form method="POST"
            action="${pageContext.request.contextPath}/practice">

            <div class="stage1" name="stage1" value="stage1">
            <button type="submit" style="border: none; background: none;"
                name="battle1_start" id="battle1_start" value="battle1">
                <img src="layout/battle-background1.jpg" alt="ステージ1"
                    class="stage1-img">
            </button>
            </div>
        </form>


        <form method="POST"
            action="${pageContext.request.contextPath}/practice2">

        <div class="stage2" name="stage2" value="stage2">

            <% if (Boolean.TRUE.equals(request.getSession().getAttribute("stage2_unlocked"))) { %>
        <button type="submit" style="border: none; background: none;"
                name="battle2_start" id="battle2_start" value="battle2">
                <img src="layout/battle-background.png" alt="ステージ2"
                    class="stage1-img">
        </button>
            <% } else { %>
        <img src="layout/battle-background.png" alt="ステージ2" class="stage2-img">
            <% } %>
        </div>
        </form>

        <form method="POST"
            action="${pageContext.request.contextPath}/practice3">
        <div class="stage3" name="stage3" value="stage3">

            <% if (Boolean.TRUE.equals(request.getSession().getAttribute("stage3_unlocked"))) { %>
        <button type="submit" style="border: none; background: none;"
                name="battle3_start" id="battle3_start" value="battle3">
                <img src="layout/stage3.jpg" alt="ステージ3"
                    class="stage1-img">
        </button>
            <% } else { %>
        <img src="layout/stage3.jpg" alt="ステージ3" class="stage3-img">
            <% } %>
        </div>
        </form>


        <form method="POST"
            action="${pageContext.request.contextPath}/practice4">
        <div class="stage4" name="stage4" value="stage4">

            <% if (Boolean.TRUE.equals(request.getSession().getAttribute("stage4_unlocked"))) { %>
        <button type="submit" style="border: none; background: none;"
                name="battle4_start" id="battle4_start" value="battle4">
                <img src="layout/stage4.jpg" alt="ステージ4"
                    class="stage4-img">
        </button>
            <% } else { %>
        <img src="layout/stage4.jpg" alt="ステージ4" class="stage4-img">
            <% } %>
        </div>
        </form>


        <form method="POST"
            action="${pageContext.request.contextPath}/practice5">
        <div class="stage5" name="stage5" value="stage5">

            <% if (Boolean.TRUE.equals(request.getSession().getAttribute("stage5_unlocked"))) { %>
        <button type="submit" style="border: none; background: none;"
                name="battle5_start" id="battle5_start" value="battle5">
                <img src="layout/stage5.jpg" alt="ステージ5"
                    class="stage5-img">
        </button>
            <% } else { %>
        <img src="layout/stage5.jpg" alt="ステージ5" class="stage5-img">
            <% } %>
        </div>
        </form>


    </div>

</body>
</html>
