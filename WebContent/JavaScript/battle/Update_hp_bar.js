// HPゲージを更新する関数
function updateHpBar(hpBarId, currentHp, maxHp) {
    const hpPercentage = (currentHp / maxHp) * 100;
    $(hpBarId).css('width', hpPercentage + '%');
}

document.addEventListener('DOMContentLoaded', function() {
    const messages = [message, message2]; // 表示するメッセージのリスト
    let currentIndex = 0; // 現在のメッセージインデックス
    const messageBox = document.getElementById('message-display');
    const nextTextButton = document.getElementById('nextButton');

    messageBox.textContent = messages[currentIndex];

    nextTextButton.addEventListener('click', function() {
        currentIndex++; // インデックスを進める

        if (currentIndex < messages.length) {
            messageBox.textContent = messages[currentIndex];

            // ここでHPゲージの更新処理を行います
            // 例として、敵とヒーローのHPをランダムに減らしていますが、実際のロジックに合わせて調整してください
            if (currentIndex === 1) { // 最初のメッセージ後に敵のHPを減らす
                const newEnemyHp = enemy_current_hp - Math.floor(Math.random() * 20); // ランダムにHPを減らす
                updateHpBar('.enemy .hp-fill', newEnemyHp, enemy_hp);
            } else if (currentIndex === 2) { // 2番目のメッセージ後にヒーローのHPを減らす
                const newHeroHp = hero_current_hp - Math.floor(Math.random() * 10); // ランダムにHPを減らす
                updateHpBar('.player .hp-fill', newHeroHp, hero_hp);
            }
        } else {
            nextTextButton.disabled = true; // これ以上表示するメッセージがない場合、ボタンを無効にする
        }
    });
});
