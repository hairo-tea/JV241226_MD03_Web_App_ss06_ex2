
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h2 {
            text-align: center;
            color: #333;
        }
        .form-container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            max-width: 600px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 10px;
            margin: 5px 0 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<h2>Thêm mới phim</h2>
<form action ="/movies/add" method="post" class="form-container">
    <label>Tiêu đề:</label>
    <input type="text" name="title"/>
    <label>Đạo diễn:</label>
    <input type="text" name="director"/>
    <label>Thể loại:</label>
    <input type="text" name="genre"/>
    <label>Mô tả:</label>
    <input type="text" name="description"/>
    <label>Thời gian (phút):</label>
    <input type="number" name="duration"/>
    <label>Ngôn ngữ:</label>
    <input type="text" name="language"/>
    <button>Thêm phim</button>
</form>
</body>
</html>
