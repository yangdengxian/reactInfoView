let formData = new FormData();  
formData.append("type","top");  
formData.append("key","465f9be9bafef783f15a46d25f35880d");  
debugger; 
fetch("http://localhost:8082/search/NewsInfoServlet" , {  
 	method: 'POST',  
 	headers: {},  
 	body: formData 
}).then(function(response){
	console.log(response);
}) 