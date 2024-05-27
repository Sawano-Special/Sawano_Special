document.addEventListener('DOMContentLoaded', function() {
    const chars = document.querySelectorAll('.char');
    chars.forEach((char, index) => {
        char.style.setProperty('--char-index', index);
    });
});