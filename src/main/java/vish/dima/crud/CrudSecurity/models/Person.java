package vish.dima.crud.CrudSecurity.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должлно быть от 2 до 100 символов")
    @Column(name = "username")
    private String name;

    @Min(value = 1900, message = "Год рождения не может быть раньше 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должлно быть от 2 до 100 символов")
    String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Имя не должно быть пустым")
                        @Size(min = 2, max = 100, message = "Имя должлно быть от 2 до 100 символов") String name) {
        this.name = name;
    }

    @Min(value = 1900, message = "Год рождения не может быть раньше 1900")
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(@Min(value = 1900, message = "Год рождения не может быть раньше 1900") int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                '}';
    }
}
