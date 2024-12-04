package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.model.commons.TipoUsuario;
import co.com.poli.alquilatuprofe.model.commons.Usuario;
import co.com.poli.alquilatuprofe.model.requester.ConsultarUsuarioRequester;
import co.com.poli.alquilatuprofe.model.requester.RegistroUsuarioRequester;

import java.util.List;

public interface UsuarioService {

    Usuario registrarUsuario(RegistroUsuarioRequester requester) throws Exception;
    List<TipoUsuario> consultarTiposUsuarios();
    Usuario consultarUsuario(ConsultarUsuarioRequester requester);
}
