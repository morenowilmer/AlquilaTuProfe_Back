package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.bd.adapter.HojaVidaAdapter;
import co.com.poli.alquilatuprofe.bd.adapter.UsuarioAdapter;
import co.com.poli.alquilatuprofe.model.commons.TipoUsuario;
import co.com.poli.alquilatuprofe.model.commons.Usuario;
import co.com.poli.alquilatuprofe.model.enums.TipoUsuarioEnum;
import co.com.poli.alquilatuprofe.model.requester.ConsultarUsuarioRequester;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioAdapter usuarioAdapter;
    private final HojaVidaAdapter hojaVidaAdapter;

    public UsuarioServiceImpl(UsuarioAdapter usuarioAdapter,
                              HojaVidaAdapter hojaVidaAdapter) {
        this.usuarioAdapter = usuarioAdapter;
        this.hojaVidaAdapter = hojaVidaAdapter;
    }

    @Override
    public List<TipoUsuario> consultarTiposUsuarios() {
        return Arrays.stream(TipoUsuarioEnum.values()).map(tipo -> new TipoUsuario(tipo.getNombre(), tipo.getValue())).toList();
    }

    @Override
    public Usuario consultarUsuario(ConsultarUsuarioRequester requester) {
        Usuario usuario = usuarioAdapter.consultarUsuario(requester.getTipoIdentificacion(), requester.getIdentificacion(), requester.getTipoUsuario());

        if (Objects.nonNull(usuario)) {
            usuario.setHojaVidas(hojaVidaAdapter.consultarHojaVidas(usuario.getId()));
        }

        return usuario;
    }
}
