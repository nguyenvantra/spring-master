## JPA Hibernate Mappings
__Association mappings__ are one of the key features of JPA and Hibernate. They model the relationship between two database tables as attributes in your domain model. ... JPA and Hibernate support the same associations as you know from your relational database model.

* __One-to-One__
* __Many-to-One__
* __Many-to-Many__

#### 1. Dependencies in project ([pom.xml](https://github.com/nguyenvantra/spring-master/blob/master/springboot-jpa-hibernate-mapping/pom.xml))
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

#### 2. Mapping One-to-One Relationship
Create 2 entities __User__ and __Token__ that having One-to-One relationship

User entity:
```java 
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "token_id")
    private Token token;

    public User(String email, Token token) {
        this.email = email;
        this.token = token;
    }
}
```

Token entity:
```java
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "token")
public class Token implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String token;

    @OneToOne(mappedBy = "token")
    private User user;

    public Token(String token) {
        this.token = token;
    }
}
```

 
