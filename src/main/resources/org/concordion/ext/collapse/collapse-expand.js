var Collapsible = (function() {
	var my = {};
	my.collapseExpand = function(elementId) {
		var ele = document.getElementById(elementId);
		var collapsedHeight = parseInt(ele.getAttribute("collapsed-height"));
		var collapsedHeightUnit = ele.getAttribute("collapsed-height-unit");
		if (parseInt(ele.style.height, 10) !== collapsedHeight) {
			ele.style.height = collapsedHeight + collapsedHeightUnit;
		} else {
			ele.style.height = ele.scrollHeight;
		}
	}
	return my;
})();
