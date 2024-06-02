var messages = ["やぁ！", "澤野の世界へようこそ！", "この世界はさわのスペシャルといって悪の魔神、"
	,"かっちゃんとたつのーりが支配する悪い世界なん\nだ！","そんな悪の魔神を倒すべく3人の戦士を紹介しよ\nう！","1人目はたつなみ！"
	,"彼はミスタードラゴンズの\n1人で、ドラゴンズのリーダーなんだ！","2人目は細川！","中日ドラゴンズの期待のホープだ！"
	,"そして3人目は...","さわの！君自身だ！","君は2人の戦士とともに、悪を倒してもらう！"
	,"モテモテの未来もそう遠くないだろう！","ステージ1から順にボスを倒し、世界の平和を取\nり戻してくれ！","さわのこうき！頼んだぞ！"
	,"上にあるステージ1に挑戦だ！"];
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