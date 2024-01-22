const out = document.getElementById("out");
const emps = document.getElementById("employees");
const btn1 = document.getElementById("btn1");
const btn2 = document.getElementById("btn2"); // JSON
const btn3 = document.getElementById("btn3"); // XML

const btn4 = document.getElementById("btn4"); // PUT 해보기

//
btn1.addEventListener("click", (e) => {
	// 1. Ajax 요청 객체 생성
	const xhttp = new XMLHttpRequest();

	// 2. readystatechange 이벤트 리스터 설정
	// : xhttp 객체의 상태가 변화할때마다 발생하는 이벤트를 설정해둬야한다
	xhttp.addEventListener("readystatechange", (e) => {
		// readyState 1 : open()이 성공했을 때 (send()하기 전)
		// readyState 2 : 요청에 대한 응답이 도착했을 때
		// readyState 3 : 응답에 대한 처리를 시작했을 때
		// readyState 4 : 응답에 대한 처리가 모두 끝났을 때(사용 준비 완료)
		// console.dir(xhttp.readyState);

		if (xhttp.readyState == 4) {
			// REST Controller로 부터 응답받은 데이터는 responseText에 들어있다
			console.log(xhttp.responseText);

			// @RestController에서 받아온 데이터를 활용할 수 있다.
			const respText = xhttp.responseText;
			out.innerHTML += "<div>" + respText + "</div>";
		}
	});

	// 3. open(methos, uri) : 요청을 어떤 방식으로 어디에 보낼지 설정한다
	xhttp.open("GET", "./rest/v1");

	// 4. 요청을 보낸다 (location.href와 다르게 다음 페이지로 넘어가지 않는다.)
	xhttp.send();
});

//
btn2.addEventListener("click", (e) => {
	const xhttp = new XMLHttpRequest();
	xhttp.addEventListener("readystatechange", (e) => {
		if (xhttp.readyState === 4 && xhttp.status == 200) {
			const cargo = xhttp.responseText;

			// JSCN은 Javascript Object 형식의 문자열이지 오브젝트가 아니다
			// 오브젝트로 변환하는 과정이 필요하다...
			console.log(cargo);
			console.log(typeof cargo);

			// JSON으로 전달받은 Java의 데이터를 자바스크립트 오브젝트로 변환하여 활용
			const obj = JSON.parse(cargo);
			console.log(obj);
			console.log("employee_id : " + obj.employee_id);
			console.log("first_name : " + obj.first_name);
			console.log("last_name : " + obj.last_name);

			const newEmpId = document.createElement("div");
			const newFirstName = document.createElement("div");
			const newLastName = document.createElement("div");

			newEmpId.classList.add("emp-id");
			newFirstName.classList.add("emp-fname");
			newLastName.classList.add("emp-lname");

			newEmpId.innerHTML = obj.employee_id;
			newFirstName.innerHTML = obj.first_name;
			newLastName.innerHTML = obj.last_name;

			emps.appendChild(newEmpId);
			emps.appendChild(newFirstName);
			emps.appendChild(newLastName);
		}
	});
	xhttp.open("GET", "./rest/v4");
	xhttp.send();
});

//
btn3.addEventListener("click", (e) => {
	const xhttp = new XMLHttpRequest();
	xhttp.addEventListener("readystatechange", (e) => {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			// 응답된 데이터의 최초의 모습
			console.log(xhttp.responseText);

			// responseXML로 전달받은 XML데이터를 document처럼 사용할 수 있다
			console.dir(xhttp.responseXML);

			const xmlDoc = xhttp.responseXML;
			const emps = xmlDoc.getElementsByTagName("item");

			console.log(emps);

			for (let i = 0; i < emps.length; i++) {
				console.log(`### emp${i} ###`);

				const fields = emps[i].children;
				for (let j = 0; j < fields.length; j++) {
					console.log(fields[j].tagName, ":", fields[j].innerHTML);
				}
			}
		}
	});

	xhttp.open("get", "./rest/v6");
	xhttp.send();
});

// PUT 방식(Update)
btn4.addEventListener("click", (e) => {
	const xhttp = new XMLHttpRequest();
	xhttp.addEventListener("readystatechange", (e) => {
		console.log("응답받은 상태코드", xhttp.status);
		if (xhttp.readyState == 4) {
			if (xhttp.status == 200) {
				console.log("요청이 잘 처리 되었습니다..");
				console.log(JSON.parse(xhttp.responseText));
			} else if (xhttp.status == 400) {
				console.log("뭔가 잘 안됐습니다...");
				alert("업데이트 실패!");
			}
		}
	});
	// ※ <input>의 데이터로 생성한 객체라고 가정
	const userData = {
		employee_id: 188,
		first_name: "John",
		last_name: "Doe",
	};

	xhttp.open("PUT", "./rest/emp");

	// 데이터를 문자열로 보내야 직렬화가 가능하다
	// 요청에 함께 실려가는 문자열이 어떤 내용인지 content-type을 통해 설명해야 한다
	// JSON.parse(String) : JSON형식 문자열을 자바스크립트 객체로 변환해주는 메서드
	// JSON.stringify(Object) : 자바스크립트 객체를 JSON형식 문자열로 변환해주는 메서드
	xhttp.setRequestHeader("content-type", "application/json");
	xhttp.send(JSON.stringify(userData));
});
