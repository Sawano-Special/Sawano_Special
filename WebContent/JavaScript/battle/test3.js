// HTMLのボタン要素を取得
const button = document.querySelector('.textbox');

// ボタンがクリックされたときの処理
button.addEventListener('click', () => {
  // サーブレットに送信するデータを作成
  const data = new FormData();
  data.append('attack', 'sawano');

  // サーブレットにPOSTリクエストを送信
  fetch('/Sawano_special/StageSelect2', {
    method: 'POST',
    body: data
  })
  .then(response => {
    // サーブレットからの応答を処理
    console.log(response);
	console.log(data);
  })
  .catch(error => {
    // エラー処理
    console.error(error);
  });
});