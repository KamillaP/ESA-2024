# Общая задача
Разработать приложение, использующее общую архитектуру и технологии JavaEE . <br>

# Структура проекта
src <br>
├── main <br>
│   ├── java <br>
│   │   └── com.example <br>
│   │       ├── entities <br>
│   │       │   ├── Book.java <br>
│   │       │   ├── Author.java <br>
│   │       ├── dao <br>
│   │       │   ├── BookDAO.java <br>
│   │       │   ├── AuthorDAO.java <br>
│   │       ├── service <br>
│   │       │   ├── BookService.java <br>
│   │       │   ├── AuthorService.java <br>
│   ├── resources <br>
│   │   └── META-INF <br>
│   │       └── persistence.xml <br>
│   ├── webapp <br>
│       ├── index.jsp <br>
│       └── WEB-INF <br>
│           └── web.xml <br>

# База данных
Имя: `booksdb` <br>
`CREATE DATABASE booksdb;` <br>
`  CREATE USER postgres WITH ENCRYPTED PASSWORD 'password';` <br>
`  GRANT ALL PRIVILEGES ON DATABASE booksdb TO postgres;`<br>
`  CREATE TABLE Author (`<br>
`      id SERIAL PRIMARY KEY,`<br>
`      name VARCHAR(255) NOT NULL`<br>
`  );`<br>
`  CREATE TABLE Book (`<br>
`      id SERIAL PRIMARY KEY,`<br>
`      title VARCHAR(255) NOT NULL,`<br>
`      author_id INTEGER REFERENCES Author(id)`<br>
`  );`
