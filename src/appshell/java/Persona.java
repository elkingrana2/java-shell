package appshell.java;

public class Persona {

    String username;
    String password;
    String email;
    String name;
    String id_usuario;

    public Persona(String username, String password, String email, String name, String id_usuario) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.id_usuario = id_usuario;
    }

    public Persona() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}
