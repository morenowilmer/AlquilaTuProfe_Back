package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.model.commons.Usuario;

public interface UsuarioAdapter {

    Usuario consultarUsuario(Integer tipoIdentificacion, String identificacion);
    Usuario registrarUsuario(Usuario usuario);
}
