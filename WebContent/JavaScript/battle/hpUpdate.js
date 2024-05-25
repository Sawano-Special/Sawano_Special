// JavaScript/battle/hpUpdate.js

$(document).ready(function() {
    function updateHpBar(barSelector, hp, maxHp) {
        const percentage = (hp / maxHp) * 100;
        $(barSelector).css('width', percentage + '%');
    }

    // 初期状態でHPゲージを設定
    updateHpBar('.enemy-hp-bar-inner', enemyHp, enemyHp);
    updateHpBar('.player-hp-bar-inner', heroHp, heroHp);

    // サーバーからHPの情報を動的に取得して更新する場合
    // Example: HPが変化したときのイベント（これはサーバーとの通信によって更新される例です）
    $('#attack').on('click', function() {
        // 仮にHPが変わったとする
        const newEnemyHp = enemyHp - 10; // 仮のダメージ
        const newHeroHp = heroHp - 5; // 仮のダメージ
        updateHpBar('.enemy-hp-bar-inner', newEnemyHp, enemyHp);
        updateHpBar('.player-hp-bar-inner', newHeroHp, heroHp);
    });
});
