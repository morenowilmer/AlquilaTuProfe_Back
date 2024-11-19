package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.model.commons.TipoUsuario;
import co.com.poli.alquilatuprofe.model.commons.Usuario;
import co.com.poli.alquilatuprofe.model.requester.ConsultarUsuarioRequester;

import java.util.List;

public interface UsuarioService {

    List<TipoUsuario> consultarTiposUsuarios();
    Usuario consultarUsuario(ConsultarUsuarioRequester requester);
}
