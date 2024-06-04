$(document).ready(function() {
  // 攻撃ボタンをクリックした時の処理
  $('#attack').click(function() {
    // 敵のHPを減らす
    var enemyHpFill = $('.enemy .hp-fill');
    var enemyHpText = $('.enemy p');
    var enemyHp = parseInt(enemyHpText.text().split('/')[0]);
    var maxEnemyHp = parseInt(enemyHpText.text().split('/')[1]);
    var damageDealt = 10; // 仮の攻撃力
    var newEnemyHp = enemyHp - damageDealt;
    if (newEnemyHp < 0) {
      newEnemyHp = 0;
    }
setTimeout(() => {
    enemyHpFill.css('width', (100 * newEnemyHp / maxEnemyHp) + '%');
    enemyHpText.text(newEnemyHp + ' / ' + maxEnemyHp);
}, 5000);

    // 自分のHPを減らす
    var playerHpFill = $('.player .hp-fill');
    var playerHpText = $('.player p');
    var playerHp = parseInt(playerHpText.text().split('/')[0]);
    var maxPlayerHp = parseInt(playerHpText.text().split('/')[1]);
    var damageReceived = 5; // 仮の被ダメージ
    var newPlayerHp = playerHp - damageReceived;
    if (newPlayerHp < 0) {
      newPlayerHp = 0;
    }
    playerHpFill.css('width', (100 * newPlayerHp / maxPlayerHp) + '%');
    playerHpText.text(newPlayerHp + ' / ' + maxPlayerHp);
  });
});