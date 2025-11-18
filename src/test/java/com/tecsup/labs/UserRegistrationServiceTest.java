package com.tecsup.labs;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationServiceTest {

    @Test
    public void testRegisterUser() {
        UserRegistrationService service = new UserRegistrationService();

        assertFalse(service.registerUser("", "12345678", "test@correo.com"));
        assertEquals("El nombre de usuario está vacío.", service.lastErrorMessage);

        assertFalse(service.registerUser("juan", "123", "juan@correo.com"));
        assertEquals("La contraseña es muy corta.", service.lastErrorMessage);

        assertTrue(service.registerUser("maria", "12345678", "maria@correo.com"));
    }
}
