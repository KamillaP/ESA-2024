# Общая задача
Разработать приложение, использующее общую архитектуру и технологии JavaEE . <br>

# Структура проекта
src <br>
├── main <br>
│   ├── java <br>
│   │   └── com.example <br>
│   │       ├── entities <br>
│   │       │   ├── Book.java - <br>
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

`Book.java` (в пакете com.example.entities)
Модельная сущность, представляющая книгу.
Содержит поля id, title и связь с автором (author).
Используется для сопоставления данных с таблицей Book в базе данных.

`Author.java` (в пакете com.example.entities)
Модельная сущность, представляющая автора.
- Содержит поля id, name и связь с книгами (books).
- Отражает структуру таблицы Author в базе данных.

`BookDAO.java` (в пакете com.example.dao)
Класс для работы с данными таблицы Book.
Методы:

- create(Book book) — сохранение книги.
- find(Long id) — поиск книги по ID.
- findAll() — получение всех книг.
  
`AuthorDAO.java` (в пакете com.example.dao)
Класс для работы с данными таблицы Author.
Методы аналогичны BookDAO, но для авторов.

`BookService.java` (в пакете com.example.service)
Логический слой для работы с книгами.
Содержит методы для создания книги (createBook) и получения списка книг (listBooks).
Вызывает методы из BookDAO.

`AuthorService.java` (в пакете com.example.service)
Логический слой для работы с авторами.
Обеспечивает создание авторов и получение их списка, используя AuthorDAO.

`index.jsp`
Главная страница веб-приложения.
Отображает список книг и их авторов в табличной форме.
Данные должны поступать через сервисы (BookService, AuthorService).

`web.xml`
Конфигурационный файл веб-приложения.
Определяет:

Название приложения (Books Application).
Настройки, такие как начальная страница (index.jsp) или маппинг сервлетов (если добавляются).

`persistence.xml`
Конфигурация JPA (Java Persistence API).
Определяет:

Имя persistence unit (books-unit).
Подключаемые сущности (Book, Author).
Настройки подключения к базе данных PostgreSQL.


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
