console.log("hi!");

const div1 = document.querySelector("#div1");

const div2 = $("#div2");

console.log(div1);
console.log(div2);

div2.addClass("btn");
div2.addClass("warning");

div2.click(function (e) {
	console.log(e);
	console.log("div2 click!");
});

const ajaxBtn = $("#ajax-btn");

/*
	url : 요청주소
	method or type : 요청 방식
	dataType : 요청 성공 후 받을 데이터의 타입
	success : Ajax 응답을 성공적으로 받았을 때의 콜백 메서드 정의
*/
ajaxBtn.click(function (e) {
	$.ajax({
		type: "GET",
		url: "employee/101",
		dataType: "json",
		success: function (emp, state, xhttp) {
			console.log("전달받은 데이터 : ", emp);
			console.log("상태코드 : ", state);
			console.log(xhttp);
		},
	});
});
