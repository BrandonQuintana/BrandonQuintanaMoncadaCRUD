/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Esta clase nos va a servir para implementar poo de encapsulamientos para tener
 * acceso a los datos que provienen de la tabla de alumno de la bd, para ello
 * se utiliza los get y set correspondientes a sus variables.
 * Esta clase va a representar la tabla de bd alumno
 * @author TheLostFloyd
 */
public class Alumno {
    private int id;
    private String nombre, password, email, pais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    
}
