/*$(document).ready(function() {
  var message = "次の行動はどうする？";
  var index = 0;
  var isDisplaying = false;

  function displayNextChar() {
    if (index < message.length) {
      $("#message-display").append(message.charAt(index));
      index++;
      setTimeout(displayNextChar, 50);
    } else {
      isDisplaying = false;
      $("#message-display").off("click", displayNextChar);
      $("#message-display").click(function() {
        if (!isDisplaying) {
          isDisplaying = true;
          index = 0;
          $("#message-display").empty();
          displayNextChar();
        }
      });
    }
  }

  $(".textbox").click(function() {
    if (!isDisplaying) {
      isDisplaying = true;
      displayNextChar();
    }
  });
});
*/