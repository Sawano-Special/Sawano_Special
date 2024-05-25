// JavaScript/battle/hpUpdate.js

$(document).ready(function() {
    // HPゲージを更新する関数
    function updateHpBars(sumDamage, enemyHp, heroHp) {
        const enemyHpPercentage = (enemyHp - sumDamage) / enemyHp * 100;
        const heroHpPercentage = (heroHp - sumDamage) / heroHp * 100;

        $('.enemy-hp-bar-inner').css('width', enemyHpPercentage + '%');
        $('.player-hp-bar-inner').css('width', heroHpPercentage + '%');
    }

    // サーバーサイドから取得した初期のHP値を取得
    const sumDamage = parseInt($('#sumDamage').val());
    const enemyHp = parseInt($('#enemyHp').val());
    const heroHp = parseInt($('#heroHp').val());

    // 初期状態でHPゲージを更新
    updateHpBars(sumDamage, enemyHp, heroHp);

    // 攻撃ボタンがクリックされたときの処理
    $('#attack').on('click', function() {
        // HPダメージを加算
        const newSumDamage = sumDamage + 10; // 仮のダメージ

        // HPゲージを更新
        updateHpBars(newSumDamage, enemyHp, heroHp);

        // サーバーに更新されたHPダメージを送信するなどの処理を追加

        // デバッグ用にコンソールにダメージ値を出力
        console.log('sumDamage:', newSumDamage);
    });
});
