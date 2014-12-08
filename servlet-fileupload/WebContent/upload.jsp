<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" enctype="multipart/form-data" action="upload">
		<table>
			<tr>
				<td>File1 to upload:</td>
				<td><input type="file" name="upfile1"></td>
			</tr>
			<tr>
				<td>about the file1:</td>
				<td><input type="text" name="note1"></td>
			</tr>
			<tr>
				<td>File2 to upload:</td>
				<td><input type="file" name="upfile2"></td>
			</tr>
			<tr>
				<td>about the file2:</td>
				<td><input type="text" name="note2"></td>
			</tr>
			<tr>
				<td><input type="reset" value="reset"></td>
				<td><input type="submit" value="upload"></td>
			</tr>
		</table>
	</form>
</body>
</html>