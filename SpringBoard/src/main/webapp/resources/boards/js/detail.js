const updateBtn = document.getElementById("updateBtn");
const inputPassword = document.getElementById("inputPassword");

const getHashedPassword = (password) => sha256(password).toUpperCase();
const checkHash = () => boardPassword === getHashedPassword(inputPassword.value);

updateBtn.addEventListener("click", (e) => {
	if (checkHash()) {
		location.href = "./update?board_id=" + board_id;
	} else {
		alert("비밀번호가 틀렸습니다!");
	}
});

const delBtn = document.querySelector("#delBtn");
//
const delForm = document.querySelector("#delForm");
const hiddenPassword = document.querySelector("#hiddenPassword");

delBtn.addEventListener("click", (e) => {
	if (checkHash()) {
		hiddenPassword.value = getHashedPassword(inputPassword.value);
		delForm.submit();
	} else {
		alert("비밀번호가 틀렸습니다!");
	}
});

//////////////////////////////////////////////
