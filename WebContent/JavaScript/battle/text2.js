$(document).ready(function() {
	var messages = ["やぁ！", "澤野の世界へようこそ！", "この世界はさわのスペシャルといって悪の魔神、"
	,"かっちゃんとたつのーりが支配する悪い世界なんだ！","そんな悪の魔神を倒すべく3人の戦士を紹介しよう！","1人目はたつなみ！","彼はミスタードラゴンズの1人で、ドラゴンズのリーダーなんだ！"
	,"2人目は細川！","中日ドラゴンズの期待のホープだ！","そして3人目は..."
	,"さわの！君自身だ！","君は2人の戦士とともに、悪を倒してもらう！","モテモテの未来もそう遠くないだろう！"
	,"ステージ1から順にボスを倒し、世界の平和を取り戻してくれ！","さわのこうき！頼んだぞ！"];
	var currentIndex = 0;
	var isDisplaying = false;

	function displayNextMessage() {
		if (currentIndex < messages.length) {
			$("#message-display").text(messages[currentIndex]);
			currentIndex++;
			isDisplaying = false;
		} else {
			currentIndex = 0;

		}
	}

	$("#message-display").click(function() {
		if (!isDisplaying) {
			isDisplaying = false;
			//$("#message-display").empty();
			displayNextMessage();
		}
	});

	displayNextMessage(); // 最初にaaaaaを表示する
});
