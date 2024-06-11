var messages = ["エルドリス帝国が大変だ。", "魔王軍が攻めこんできた。", "このままじゃこの国は滅びてしまう。"
    ,"勇者パーティの皆さん","魔王軍を撃退してください！","気を付けて行ってらっしゃい！"];
    var currentIndex = 0;
    var isDisplaying = false;
    var needMessageSkip = false;

    function clearMessage(){
      $("#message-display").html('');
    }

    function displayMessage(message, idx = 0) {
      if (idx <message.length) {
        let html = $("#message-display").html();
        if (needMessageSkip){
          idx = message.length;
          html = message;
          isDisplaying = false;
        }
        else {
          html += message[idx];
          idx++;
        }
        html = html.replace(/\n/g, '<br>');
        $("#message-display").html(html);
      }
      else {
        isDisplaying = false;
      }

      if (isDisplaying){
        setTimeout(displayMessage, 50, message, idx);
      }
      needMessageSkip = false;
    }

    function displayNextMessage() {
      
    if(currentIndex < 15){
        if (!isDisplaying){
        isDisplaying = true;
        clearMessage();
        displayMessage(messages[currentIndex]);
        currentIndex = currentIndex + 1;
      }
      else {
        needMessageSkip = true;
      }
    }else{
        if (!isDisplaying){
        isDisplaying = true;
        clearMessage();
        displayMessage(messages[currentIndex]);
      }
      else {
        needMessageSkip = true;
      }
    }
        
    }

    $(document).ready(function () {
      $("#message-display").click(displayNextMessage);
      displayNextMessage();
    });