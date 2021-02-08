var name = `${name}`
console.log(name)
if (name.length != 0) {
	console.log('not null or empty' + name.length)
	console.log(name.length)
	$("#login").hide();
	$("#register").hide();
} else {
	$("#logout").hide();
	console.log('in logout ' + name.length)
}

if (name.length == 0) {
	$("#cart").click(function() { alert('You must be logged in to view the cart'); });
}b