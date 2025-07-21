<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<h2>Danh sách phim</h2>
<a href="movies/add" class="add-btn">Thêm mới phim</a>
<table>
    <thead>
    <tr>
        <th>Mã phim</th>
        <th>Tiêu đề</th>
        <th>Đạo diễn</th>
        <th>Thể loại</th>
        <th>Thời lượng</th>
        <th>Ngôn ngữ</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="movie" items="${movies}" varStatus="loop">
    <tr>
        <td>${movie.id}</td>
        <td>${movie.title}</td>
        <td>${movie.director}</td>
        <td>${movie.genre}</td>
        <td>${movie.duration}</td>
        <td>${movie.language}</td>
        <td class="group-btn">
            <a href="movies/edit/${movie.id}" class="edit-btn">Sửa</a>
            <a href="movies/delete/${movie.id}" onclick="return confirm('Bạn có chắc muốn xóa không?')" class ="delete-btn">Xóa</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
