document.addEventListener('DOMContentLoaded', () => {
    const texts = ["ｔｔｔ", "さわの", "は", "立浪大好き"];
    let currentIndex = 0;

    const textElement = document.getElementById('text');
    const button = document.getElementById('nextButton');

    button.addEventListener('click', () => {
        currentIndex = (currentIndex + 1) % texts.length;
        textElement.textContent = texts[currentIndex];
    });
});