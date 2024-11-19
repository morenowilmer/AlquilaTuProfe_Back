package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.repository.UsuarioRepository;
import co.com.poli.alquilatuprofe.model.commons.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAdapterImpl implements UsuarioAdapter{

    private final UsuarioRepository usuarioRepository;

    public UsuarioAdapterImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario consultarUsuario(String tipoIdentificacion, String identificacion, String tipoUsuario) {
        return null;
    }
}
