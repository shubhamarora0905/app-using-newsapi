/**
 * 
 */

		/* $("#submit").click(function() {
			alert("Handler for .click() called.");
		}); */

$('.ui.dropdown').dropdown();

function getDataFromWebService() {
$('.card').show();
	let countryLet = $("#country-select").val();
	
	let categoryLet = $("#category-select").val();

	const vm = new Vue({
	  el: '#app',
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
	    .then(response => {this.results = response.data.articles})
	  }
	});
}

//getDataFromWebService();

$("#submit").click(function() {
			getDataFromWebService();
		});