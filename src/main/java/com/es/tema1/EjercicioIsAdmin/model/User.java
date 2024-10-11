package com.es.tema1.EjercicioIsAdmin.model;

/**
 * Clase que representa un usuario en el sistema.
 * Incluye información sobre el ID, correo, contraseña encriptada y si el usuario es administrador.
 */
public class User {

    private String Id;
    private String correo;
    private String encriptedPassword;
    private Boolean isAdmin;

    /**
     * Constructor que inicializa todos los campos del usuario, incluyendo la opción de ser administrador.
     *
     * @param id               El ID del usuario.
     * @param correo           El correo electrónico del usuario.
     * @param encriptedPassword La contraseña encriptada del usuario.
     * @param isAdmin         Indica si el usuario es administrador.
     */
    public User(String id, String correo, String encriptedPassword, Boolean isAdmin) {
        Id = id;
        this.correo = correo;
        this.encriptedPassword = encriptedPassword;
        this.isAdmin = isAdmin;
    }

    /**
     * Constructor que inicializa el ID, correo y contraseña encriptada del usuario.
     * El usuario no es administrador por defecto.
     *
     * @param id               El ID del usuario.
     * @param correo           El correo electrónico del usuario.
     * @param encriptedPassword La contraseña encriptada del usuario.
     */
    public User(String id, String correo, String encriptedPassword) { //Creado para que por defecto no sea admin
        Id = id;
        this.correo = correo;
        this.encriptedPassword = encriptedPassword;
        this.isAdmin = false;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public String getId() {
        return Id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id El nuevo ID del usuario.
     */
    public void setId(String id) {
        Id = id;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo El nuevo correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña encriptada del usuario.
     *
     * @return La contraseña encriptada del usuario.
     */
    public String getEncriptedPassword() {
        return encriptedPassword;
    }

    /**
     * Establece la contraseña encriptada del usuario.
     *
     * @param encriptedPassword La nueva contraseña encriptada del usuario.
     */
    public void setEncriptedPassword(String encriptedPassword) {
        this.encriptedPassword = encriptedPassword;
    }

    /**
     * Obtiene el estado de administrador del usuario.
     *
     * @return true si el usuario es administrador, false en caso contrario.
     */
    public Boolean getAdmin() {
        return isAdmin;
    }

    /**
     * Establece el estado de administrador del usuario.
     *
     * @param admin true si el usuario debe ser administrador, false en caso contrario.
     */
    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto User.
     *
     * @return Una cadena que representa el objeto User.
     */
    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", correo='" + correo + '\'' +
                ", encriptedPassword='" + encriptedPassword + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
