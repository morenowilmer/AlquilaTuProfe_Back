package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.model.commons.LoginResponse;
import co.com.poli.alquilatuprofe.model.commons.Sesion;
import co.com.poli.alquilatuprofe.model.requester.LoginRequester;

public interface LoginService {

    LoginResponse login(LoginRequester requester);
    Sesion obtenerSesion(String id);
    void cerrarSesion();
}
