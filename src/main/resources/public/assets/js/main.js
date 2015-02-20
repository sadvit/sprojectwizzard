var startMessage = null;
var dropClicked = false;
var currentMenu = null;

window.onload = function() {
	var menus = document.getElementById("header").getElementsByClassName("drop");
	for(var index = 0, size = menus.length; index < size; index++) {
		menus[index].style.display = "none";
		menus[index].parentNode.getElementsByTagName("a")[0].onclick = dropMenu;
	}
	var lists = document.getElementById("page").getElementsByClassName("drop");
	for(var index = 0, size = lists.length; index < size; index++) {
		var element = lists[index];
		if(element.tagName == "ul" || element.tagName == "div") {
			var parent = element.parentNode;
			var child = document.createElement("img");
			child.className = "arrow";
			child.onclick = dropList;
			child.style.cursor = "pointer";
			child.style.marginRight = "10px";
			child.src = "../img/arrow-gray-right.gif";
			parent.insertBefore(child, parent.firstChild);
			element.style.display = "none";
		}
	}
	if(startMessage !== null) {
		show(startMessage);
	}
}

window.onclick = function() {
	if(currentMenu != null) {
		if(!dropClicked) {
			currentMenu.style.display = "none";
			currentMenu = null;
		} else {
			dropClicked = false;
		}
	}
}

function show(message, action) {
	showMessage(message, [{
		caption: "Закрыть",
		handler: (action !== undefined ? action : function() {})
	}]);
}

function confirmation(form, message) {
	showMessage(message, [{
		caption: "Да",
		handler: function() {
			form.submit();
		}
	}, {
		caption: "Отменить",
		handler: function() {}
	}]);
	return false;
}

function submitFormById(id) {
	var form = document.getElementById(id);
	var isSubmit = true;
	if(form.onsubmit != null) {
		isSubmit = form.onsubmit();
	}
	if(isSubmit) {
		form.submit();
	}
	return false;
}

function showMessage(message, buttons) {
	var body = document.getElementsByTagName("body")[0];
	var messageElement = document.createElement("div");
	messageElement.id = "confirm-message";
	var messageContent = document.createElement("div");
	var messageText = document.createElement("p");
	messageText.innerHTML = message;
	messageContent.appendChild(messageText);
	var buttonsElement = document.createElement("form");
	for(var index = 0, size = buttons.length; index < size; index++) {
		var button = document.createElement("button");
		button.type = "button";
		button.handler = buttons[index];
		button.onclick = function() {
			body.removeChild(messageElement);
			this.handler.handler();
		}
		button.appendChild(document.createTextNode(buttons[index].caption));
		buttonsElement.appendChild(button);
	}
	messageContent.appendChild(buttonsElement);
	messageElement.appendChild(messageContent);
	body.insertBefore(messageElement, body.firstChild);
}

function dropMenu(e) {
	var menu = e.currentTarget.parentNode.getElementsByClassName("drop")[0];
	if(menu.style.display === "none") {
		if(currentMenu != null && menu != currentMenu) {
			currentMenu.style.display = "none";
		}
		menu.style.display = "block";
		currentMenu = menu;
		dropClicked = true;
	}
	return false;
}

function dropList(e) {
	var parent = e.currentTarget.parentNode;
	var element = parent.getElementsByTagName("div")[0];
	if(element === undefined || parent != element.parentNode) {
		element = parent.getElementsByTagName("ul")[0];
	}
	if(element.style.display === "none") {
		element.style.display = "block";
		parent.getElementsByTagName("img")[0].src = "../img/arrow-gray-bottom.gif";
	} else {
		element.style.display = "none";
		parent.getElementsByTagName("img")[0].src = "../img/arrow-gray-right.gif";
	}
}
