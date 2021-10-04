import {home} from "/modules/home.js"
const render = () => {
    document.getElementById("content").innerHTML = home();
}
window.onload=render();