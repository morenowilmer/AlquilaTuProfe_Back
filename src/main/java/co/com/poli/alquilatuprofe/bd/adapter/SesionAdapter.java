package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.model.commons.Sesion;

public interface SesionAdapter {

    void guardarSesion(Sesion sesion);

    Sesion obtenerSesion(String id);
    void eliminarSesion(String id);
    void eliminarSesionesUsuario(Integer idUsuario);
}
