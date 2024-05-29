$(document).ready(function() {
  var message = ["aaaaaaaaaaaaaa", "bbbbbbbbbbbbb", "ccccccccccccccc"];
console.log(message);
  var index = 0;
  var isDisplaying = false;

  function displayNextChar() {
    if (index < message.length) {
      $("#message-display").append(message[index]);
      index++;
//setTimeout(displayNextChar, 10000);
    } else {
      isDisplaying = false;
      index = 0;
$("#message-display").empty();
          displayNextChar();
    }
  }

  $("#message-display").click(function() {
    if (!isDisplaying) {
      isDisplaying = true;
      displayNextChar();
    }
  });
});
