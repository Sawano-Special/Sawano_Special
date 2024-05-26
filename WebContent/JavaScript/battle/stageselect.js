// ../JavaScript/battle/stageselect.js
$(document).ready(function() {
    const onMouseenter = (e) => {
        $(e.target).css({
            'box-shadow': '0 0 10px 5px rgba(255, 255, 0, 0.7)',
        });
    };

    const onMouseleave = (e) => {
        $(e.target).css({
            'box-shadow': 'none',
        });
    };

    $('.stage1-img, .stage2-img, .stage3-img, .stage4-img, .stage5-img')
        .on('mouseenter', onMouseenter)
        .on('mouseleave', onMouseleave);

});

