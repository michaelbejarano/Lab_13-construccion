package com.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado del registro y validación de datos de usuarios.
 * Esta clase aplica buenas prácticas de encapsulamiento, validación
 * y manejo seguro de errores conforme a estándares de calidad.
 */
public final class UserRegistrationService {

    /**
     * Último mensaje de error producido durante la validación.
     */
    private String lastErrorMessage;

    /**
     * Lista de usuarios registrados.
     */
    private final List<String> users = new ArrayList<>();

    /**
     * Longitud mínima esperada para una contraseña válida.
     */
    private static final int MIN_PASSWORD_LENGTH = 8;

    /**
     * Constructor de la clase. No ejecuta lógica adicional.
     */
    public UserRegistrationService() {
        // No se requiere lógica adicional.
    }

    /**
     * Retorna el último mensaje de error registrado.
     *
     * @return mensaje de error o null si no existe
     */
    public String getLastErrorMessage() {
        return this.lastErrorMessage;
    }

    /**
     * Permite registrar un usuario validando sus datos de entrada.
     *
     * @param username nombre del usuario
     * @param password contraseña del usuario
     * @param email    correo electrónico válido
     * @return true si el registro es exitoso, false en caso contrario
     */
    public boolean registerUser(final String username,
            final String password, final String email) {

        if (username == null || username.trim().isEmpty()) {
            this.lastErrorMessage = "El nombre de usuario está vacío.";
            return false;
        }

        if (password == null) {
            this.lastErrorMessage = "La contraseña es null.";
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            this.lastErrorMessage = "La contraseña es muy corta.";
            return false;
        }

        if (!email.contains("@") || !email.contains(".")) {
            this.lastErrorMessage = "El correo electrónico no parece válido.";
            return false;
        }

        try {
            saveUser(username);
        } catch (Exception e) {
            this.lastErrorMessage = "Error desconocido al guardar el usuario.";
            return false;
        }

        this.lastErrorMessage = null;
        System.out.println("Usuario registrado: " + username);
        return true;
    }

    /**
     * Almacena el nombre de usuario en la lista.
     *
     * @param username nombre del usuario
     * @throws Exception si el nombre es considerado no permitido
     */
    private void saveUser(final String username) throws Exception {
        this.users.add(username);

        if ("error".equals(username)) {
            throw new Exception("Nombre de usuario no permitido.");
        }
    }

    /**
     * Retorna la longitud del texto ingresado.
     * Si es null, retorna -1.
     *
     * @param text texto a evaluar
     * @return longitud del texto o -1 si es null
     */
    public int countCharacters(final String text) {
        if (text == null) {
            return -1;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            result.append(text.charAt(i));
        }
        return result.length();
    }
}
