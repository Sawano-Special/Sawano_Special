$(document).ready(function() {
  var myArray = JSON.parse(myArray);
  var displayCount = 5;

  // 現在の表示位置
  var currentIndex = 0;

  // 表示中かどうかのフラグ
  var isDisplaying = false;

  // 次の要素を表示する関数
  function displayNextElements() {
    // 表示する要素数分ループ
    for (var i = 0; i < displayCount; i++) {
      // 配列の範囲内であれば要素を表示
      if (currentIndex < myArray.length) {
        $("#message-display").append(myArray[currentIndex] + "<br>");
        currentIndex++;
      } else {
        // 配列の最後まで表示した場合は終了
        isDisplaying = false;
        break;
      }
    }

    // 次の要素を表示するまで待機
    if (isDisplaying) {
      setTimeout(displayNextElements, 500);
    }
  }

  // クリックイベントのハンドラ関数
  $("#message-display").click(function() {
    // 表示中でない場合のみ実行
    if (!isDisplaying) {
      isDisplaying = true;
      displayNextElements();
    }
  });
});