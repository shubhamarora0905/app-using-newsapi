/**
 * 
 */

/* $("#submit").click(function() {
	alert("Handler for .click() called.");
}); */

$('.ui.dropdown').dropdown();

function getDataFromWebService(a) {
	$('.text.wrapper.initial').children().show();
	let countryLet = $("#country-select").val();

	let categoryLet = $("#category-select").val();

	const vm = new Vue({
		el: a,
		data: {
			results: [
			]
		},
		mounted() {
			axios.get('/getNews', {
				params: {
					country: countryLet,
					category: categoryLet
				}
			})
				.then(response => { this.results = response.data.articles })
		}
	});
}

//getDataFromWebService();

$("#submit").click(function () {
	let countryLet = $("#country-select").val();
	let categoryLet = $("#category-select").val();

	if(countryLet == "") {
		alert("Country not selected.");
		return;
	}
	
	if(categoryLet == "") {
		alert("Category not selected");
		return;
	}

	if($('.card').length < 3) {
		getDataFromWebService('#app');
	} else {
		processForReselection();	
	}
});

let count = 1;

function processForReselection() {
	$('.text.wrapper.initial').children().remove();
	
	let currentId = $('.text.wrapper.initial').attr("id");
	
	$('.text.wrapper.initial').attr("id","app" + count);
	$('.text.wrapper.initial').append(document.getElementById('clonableCard').cloneNode(true));
	getDataFromWebService('#'+"app" + count);
	count++;
	
}