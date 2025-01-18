<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books and Authors</title>
</head>
<body>
    <h1>Books</h1>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Author</th>
        </tr>
        <%-- Пример вывода данных, список книг загружается через DAO/Service --%>
        <%-- for (Book book : books) { --%>
        <tr>
            <td><%= "Example Title" %></td>
            <td><%= "Example Author" %></td>
        </tr>
        <%-- } --%>
    </table>
</body>
</html>

