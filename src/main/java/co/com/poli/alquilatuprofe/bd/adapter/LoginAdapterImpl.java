package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.UsuarioEntity;
import co.com.poli.alquilatuprofe.bd.repository.UsuarioRepository;
import co.com.poli.alquilatuprofe.model.commons.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginAdapterImpl implements LoginAdapter{

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper mapper;

    public LoginAdapterImpl(UsuarioRepository usuarioRepository,
                            ModelMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario login(String correo, String contrasena, String activo) {
        UsuarioEntity usuario = usuarioRepository
                .findByCorreoAndContrasenaAndActivo(correo, contrasena, activo);

        return (Objects.nonNull(usuario)) ? mapper.map(usuario, Usuario.class) : null;
    }
}
