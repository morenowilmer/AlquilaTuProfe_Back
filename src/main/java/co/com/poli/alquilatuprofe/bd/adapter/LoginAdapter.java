package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.model.commons.Usuario;

public interface LoginAdapter {

    Usuario login(String tipoUSuario, String correo, String contrasena, String activo);
}
