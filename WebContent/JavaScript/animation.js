$(document).ready(function() {
    $('body').mousemove(function(e) {
        const x = e.pageX;
        const y = e.pageY;
        const particle = $('<div class="particle"></div>').css({
            left: x,
            top: y
        });
        $('body').append(particle);
        particle.animate({
            opacity: 0
        }, 1500, function() {
            $(this).remove();
        });
    });
});