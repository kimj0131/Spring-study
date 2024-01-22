const refBtnJSON = document.getElementById("refBtnJSON");
const refBtnXML = document.getElementById("refBtnXML");

const refResultDiv1 = document.getElementById("refResultDiv1");
const refResultDiv2 = document.getElementById("refResultDiv2");

refBtnJSON.addEventListener("click", (e) => {
	refResultDiv1.innerHTML = "";
	const xhttp = new XMLHttpRequest();
	xhttp.addEventListener("readystatechange", (e) => {
		if (xhttp.readyState === 4 && xhttp.status == 200) {
			const cargo = xhttp.responseText;

			const obj = JSON.parse(cargo);
			console.log(obj);

			for (let i = 0; i < 10; i++) {
				const emp = document.createElement("div");

				emp.innerHTML = obj[i].employee_id + " / " + obj[i].first_name + " / " + obj[i].last_name + " ";

				refResultDiv1.appendChild(emp);
			}
		}
	});
	xhttp.open("GET", "./rest/quizJSON");
	xhttp.send();
});

refBtnXML.addEventListener("click", (e) => {
	refResultDiv2.innerHTML = "";
	const xhttp = new XMLHttpRequest();
	xhttp.addEventListener("readystatechange", (e) => {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			const xmlDoc = xhttp.responseXML;
			const emps = xmlDoc.getElementsByTagName("item");
			for (let i = 0; i < emps.length; i++) {
				const fields = emps[i].children;
				for (let j = 0; j < fields.length; j++) {
					const emp = document.createElement("div");

					emp.innerHTML = fields[j].tagName + ":" + fields[j].innerHTML;

					refResultDiv2.appendChild(emp);
				}
			}
		}
	});
	xhttp.open("GET", "./rest/quizXML");
	xhttp.send();
});
