# Practical Work #2
Application using Spring Framework <br>

# Структура проекта
LibraryProject/<br>
├── src/<br>
│   ├── main/<br>
│   │   ├── java/<br>
│   │   │   ├── com/<br>
│   │   │   │   ├── library/<br>
│   │   │   │   │   ├── controller/<br>
│   │   │   │   │   │   └── LibraryController.java      <br>
│   │   │   │   │   ├── model/<br>
│   │   │   │   │   │   ├── Author.java                 <br>
│   │   │   │   │   │   ├── Book.java                   <br>
│   │   │   │   │   ├── repository/<br>
│   │   │   │   │   │   ├── AuthorRepository.java       <br>
│   │   │   │   │   │   ├── BookRepository.java         <br>
│   │   │   │   │   ├── service/<br>
│   │   │   │   │   │   └── LibraryService.java         <br>
│   │   │   │   │   ├── config/<br>
│   │   │   │   │   │   ├── HibernateConfig.java        <br>
│   │   │   │   │   │   └── SpringConfig.java           <br>
│   │   ├── resources/<br>
│   │   │   ├── application.properties                  <br>
│   │   │   ├── hibernate.cfg.xml                       <br>
│   │   │   ├── templates/                              <br>
│   │   │   │   ├── books.html                          <br>
│   │   │   │   ├── authors.html                        <br>
│   │   ├── webapp/<br>
│   │   │   ├── WEB-INF/
│   │   │   │   ├── web.xml                             <br>
├── pom.xml                                             <br>


Создание структыры проекта через Maven <br>
`mvn archetype:generate -DgroupId=com.library -DartifactId=LibraryProject -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

`controller/`:

Хранит классы контроллеров, такие как LibraryController.
Это точка входа для HTTP-запросов. Контроллеры обрабатывают запросы, вызывают сервисный слой и возвращают результаты пользователю.

`model/:`

Содержит классы сущностей (Entity), такие как Author и Book.
Эти классы аннотированы Hibernate (например, @Entity, @Id) для отображения на таблицы базы данных.

`repository/:`

Включает репозитории для работы с базой данных.
Обычно это интерфейсы, расширяющие JpaRepository или CrudRepository из Spring Data.

`service/:`

Содержит бизнес-логику, инкапсулированную в сервисные классы.
Пример: LibraryService управляет операциями добавления, получения и удаления данных.

`config/:`

Хранит конфигурационные классы Spring и Hibernate.
Пример: SpringConfig.java для настройки Spring или HibernateConfig.java для настройки Hibernate (если не используется XML).

`resources/:`

Содержит ресурсы, такие как конфигурационные файлы и HTML-шаблоны.
`application.properties:` конфигурация базы данных и Spring.
`hibernate.cfg.xml:` конфигурация Hibernate.
`templates/:` HTML-файлы для представлений (используются с Thymeleaf или JSP).
`pom.xml:`

Файл конфигурации Maven для указания зависимостей, таких как Spring Boot, Hibernate, Thymeleaf и MySQL.
