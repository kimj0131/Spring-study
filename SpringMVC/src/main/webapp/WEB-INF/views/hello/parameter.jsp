<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>파라미터 폼</title>
	</head>
	<body>
		<h3>파라미터 보내는 폼</h3>

		<p>파라미터로 보내는 name값과 이 값을 받는 모델 클래스의 속성 이름이 일치하면 알아서 자동으로 바인딩 해준다</p>

		<form action="./parameter" method="post">
			DEPT_NO : <input type="number" name="department_id" value="50" /> <br />
			DEPT_NAME : <input type="text" name="department_name" value="It Programmer" /> <br />
			MGR_NO : <input type="number" name="manager_id" value="105" /> <br />
			LOC_NO : <input type="number" name="location_id" value="130" /> <br />
			<input type="submit" value="컨트롤러로 보내기" />
		</form>

		<hr />

		<form action="./para2" method="post">
			EMPLOYEE_ID : <input type="text" name="employee_id" value="135" />
			<input type="submit" value="보내기2" />
		</form>

		<hr />

		<form action="./para3" method="post">
			EMP_ID : <input type="text" name="employee_id" value="135" />
			<input type="submit" value="보내기3" />
		</form>
	</body>
</html>
