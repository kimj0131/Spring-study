const fruitInsertBtn = document.getElementById("fruitInsertBtn");

fruitInsertBtn.addEventListener("click", (e) => {
	const fruitData = {
		fruit_name: document.getElementById("fruit_name_in").value,
		fruit_price: document.getElementById("fruit_price_in").value,
		fruit_grade: document.getElementById("fruit_grade_in").value,
		country_id: document.getElementById("country_id_in").value,
	};
	console.log(fruitData);
	const xhttp = new XMLHttpRequest();
	xhttp.addEventListener("readystatechange", (e) => {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			alert(JSON.parse(xhttp.responseText).fruit_name + " 의 insert가 완료됬습니다");
		} else {
			alert("insert 실패");
		}
	});

	xhttp.open("post", "./rest/fruit");

	xhttp.setRequestHeader("content-type", "application/json");
	xhttp.send(JSON.stringify(fruitData));
});

const fruitUpdateBtn = document.getElementById("fruitUpdateBtn");
const fruit_id = document.getElementById("fruit_id_up");

fruitUpdateBtn.addEventListener("click", (e) => {
	const fruitData = {
		fruit_id: fruit_id.value,
		fruit_name: document.getElementById("fruit_name_up").value,
		fruit_price: document.getElementById("fruit_price_up").value,
		fruit_grade: document.getElementById("fruit_grade_up").value,
		country_id: document.getElementById("country_id_up").value,
	};
	console.log(fruitData);
	const xhttp = new XMLHttpRequest();
	xhttp.addEventListener("readystatechange", (e) => {
		if (xhttp.readyState == 4) {
			if (xhttp.status == 200) {
				alert(JSON.parse(xhttp.responseText).fruit_name + " 의 Update가 완료됬습니다");
			} else {
				alert("Update 실패");
			}
		}
	});
	// xhttp.open("put", `./rest/fruit/${fruit_id.value}`);
	xhttp.open("put", "./rest/fruit");
	xhttp.setRequestHeader("content-type", "application/json");
	xhttp.send(JSON.stringify(fruitData));
});
