package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.model.commons.LoginResponse;
import co.com.poli.alquilatuprofe.model.commons.Sesion;
import co.com.poli.alquilatuprofe.model.requester.LoginRequester;

import java.io.IOException;

public interface LoginService {

    LoginResponse login(LoginRequester requester) throws IOException;
    Sesion obtenerSesion(String id);
    void cerrarSesion();
}
