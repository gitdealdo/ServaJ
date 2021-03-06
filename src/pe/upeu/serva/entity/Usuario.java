package pe.upeu.serva.entity;
// Generated 01/05/2017 02:26:18 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Long id;
     private String usuario;
     private String clave;
     private String nombres;
     private String apellidos;
     private String correo;
     private String celular;
     private Set recetamenus = new HashSet(0);

    public Usuario() {
    }

    public Usuario(String usuario, String clave, String nombres, String apellidos, String correo, String celular, Set recetamenus) {
       this.usuario = usuario;
       this.clave = clave;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.correo = correo;
       this.celular = celular;
       this.recetamenus = recetamenus;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public Set getRecetamenus() {
        return this.recetamenus;
    }
    
    public void setRecetamenus(Set recetamenus) {
        this.recetamenus = recetamenus;
    }




}


