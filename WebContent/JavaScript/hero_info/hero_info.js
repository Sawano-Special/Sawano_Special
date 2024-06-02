document.addEventListener('DOMContentLoaded', () => {
    const select = document.getElementById('my-select');

    select.addEventListener('change', (e) => {
        const value = e.target.value;
        console.log('value: ', value);

        // サーブレットに送信するデータを作成
        const data = new FormData();
        data.append('selectedValue', value);

        // サーブレットにPOSTリクエストを送信
        fetch('/Sawano_special/practice', {
            method: 'POST',
            body: data
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(responseText => {
            console.log(responseText); // サーバーの応答をログに表示
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});
/*const select = document.getElementById('my-select');

select.addEventListener('change', (e) => {
  console.log('value: ', e.target.value);
});*/