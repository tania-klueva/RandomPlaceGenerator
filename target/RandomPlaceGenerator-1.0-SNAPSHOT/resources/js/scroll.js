var UID = {
    _current: 0,
    getNew: function(){
        this._current++;
        return this._current;
    }
};

HTMLElement.prototype.pseudoStyle = function(element,prop,value){
    var _this = this;
    var _sheetId = "pseudoStyles";
    var _head = document.head || document.getElementsByTagName('head')[0];
    var _sheet = document.getElementById(_sheetId) || document.createElement('style');
    _sheet.id = _sheetId;
    var className = "pseudoStyle" + UID.getNew();

    _this.className +=  " "+className;

    _sheet.innerHTML += " ."+className+":"+element+"{"+prop+":"+value+"}";
    _head.appendChild(_sheet);
    return this;
};

window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    let nav = document.getElementById("navbar");
    let brand = document.getElementsByClassName("navbar-brand");
    let link = document.getElementsByClassName("nav-link");

    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        nav.pseudoStyle("before", "transform", "none");
        nav.pseudoStyle("after", "transform", "none");
        for (let i = 0; i < link.length; i++) {
            link[i].style.fontSize = "1rem";

        }
        for (let i = 0; i < brand.length; i++) {
            brand[i].style.fontSize = "2.2rem";

        }

    } else {
        nav.pseudoStyle("before", "transform", "skewY(-2deg)");
        nav.pseudoStyle("after", "transform", "skewY(-2deg)");
        nav.style.transform="none";
        for (let i = 0; i < link.length; i++) {
            link[i].style.fontSize = "1.2rem";

        }
        for (let i = 0; i < brand.length; i++) {
            brand[i].style.fontSize = "3rem";

        }
    }
}