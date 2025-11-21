package com.tecsup.labs;

/**
 * Clase principal de ejecución del sistema.
 */
public final class Main {

    /**
     * Constructor privado para evitar instanciación.
     */
    private Main() {
        throw new UnsupportedOperationException("Clase utilitaria");
    }

    /**
     * Método principal de ejecución del programa.
     *
     * @param args argumentos desde consola
     */
    public static void main(final String[] args) {

        UserRegistrationService service = new UserRegistrationService();

        service.registerUser("juan", "123", "juan@correo.com");
        System.out.println(service.getLastErrorMessage());

        service.registerUser(null, "12345678", "correo-sin-arroba");
        System.out.println(service.getLastErrorMessage());

        service.registerUser("error", "12345678", "error@correo.com");
        System.out.println(service.getLastErrorMessage());
    }
}
