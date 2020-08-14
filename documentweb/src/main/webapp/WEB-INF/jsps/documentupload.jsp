<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Document Upload</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
Id : <input type="text" name="id">
Document : <input type="file" name="document">
<input type='submit' name='submit' value="Upload">

</form>
</body>
</html>