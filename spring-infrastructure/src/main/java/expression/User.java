package expression;

public class User {

    private String firstName;
    private String secondName;
    private String email;
    private Boolean isAdmin;
    private Integer age;

    public User(String firstName, String secondName, Boolean isAdmin, String email, Integer age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.isAdmin = isAdmin;
        this.email = email;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
