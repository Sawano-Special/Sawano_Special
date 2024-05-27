// ../JavaScript/gamestart.js
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

    // Event for "Start Game" button
    $('.gamestart')
        .on('mouseenter', onMouseenter)
        .on('mouseleave', onMouseleave);
});