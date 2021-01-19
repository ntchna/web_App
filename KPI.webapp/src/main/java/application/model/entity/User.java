package application.model.entity;

public class User
{
    private int id;
    private String role = "guest";
    private String username;
    private String password;
    private String name;
    private String surname;
    private boolean enable;

    public User(String username) {
        this.username = username;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public User(int id, String role, String username, String password, String name, String surname, boolean enable) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.enable = enable;
    }

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntRole(){
        int role = 2;
        if(this.role.equals("admin")) role = 1;
        return role;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public String  getEnable(){
        String enable = "active";
        if(!this.enable) enable = "blocked";
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", enable=" + enable +
                '}';
    }
}
