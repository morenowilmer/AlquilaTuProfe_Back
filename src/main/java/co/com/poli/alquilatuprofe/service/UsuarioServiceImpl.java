package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.bd.adapter.HojaVidaAdapter;
import co.com.poli.alquilatuprofe.bd.adapter.UsuarioAdapter;
import co.com.poli.alquilatuprofe.model.commons.TipoUsuario;
import co.com.poli.alquilatuprofe.model.commons.Usuario;
import co.com.poli.alquilatuprofe.model.enums.TipoUsuarioEnum;
import co.com.poli.alquilatuprofe.model.exception.ErrorException;
import co.com.poli.alquilatuprofe.model.requester.ConsultarUsuarioRequester;
import co.com.poli.alquilatuprofe.model.requester.RegistroUsuarioRequester;
import co.com.poli.alquilatuprofe.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Value("${imagenes.ruta.base}")
    private String rutaBaseImagenes;

    private static final String NOMBRE_IMG_PERFIL = "%s-perfil.png";

    private final UsuarioAdapter usuarioAdapter;
    private final HojaVidaAdapter hojaVidaAdapter;
    private final ModelMapper mapper = new ModelMapper();

    public UsuarioServiceImpl(UsuarioAdapter usuarioAdapter,
                              HojaVidaAdapter hojaVidaAdapter) {
        this.usuarioAdapter = usuarioAdapter;
        this.hojaVidaAdapter = hojaVidaAdapter;
    }

    @Override
    public Usuario registrarUsuario(RegistroUsuarioRequester requester) throws Exception{
        String rutaFoto = this.guardarFoto(requester.getFotoBase64(), requester.getIdentificacion());

        Usuario usuario = mapper.map(requester, Usuario.class);
        usuario.setRutaFoto(rutaFoto);
        usuario.setNroClases(0);
        usuario.setNroHorasClases(0);
        usuario.setActivo("S");
        usuario.setContrasena(Base64.getEncoder().encodeToString(requester.getContrasena().getBytes()));

        return usuarioAdapter.registrarUsuario(usuario);
    }

    @Override
    public List<TipoUsuario> consultarTiposUsuarios() {
        return Arrays.stream(TipoUsuarioEnum.values()).map(tipo -> new TipoUsuario(tipo.getNombre(), tipo.getValue())).toList();
    }

    @Override
    public Usuario consultarUsuario(ConsultarUsuarioRequester requester) {
        Usuario usuario = usuarioAdapter.consultarUsuario(requester.getTipoIdentificacion(), requester.getIdentificacion());

        if (Objects.nonNull(usuario)) {
            usuario.setHojaVidas(hojaVidaAdapter.consultarHojaVidas(usuario.getId()));
        }

        return usuario;
    }

    private String guardarFoto(String fotoBase64, String identificacion) throws Exception {
        try {
            String rutaImagen = File.separator.concat("perfil").concat(File.separator)
                    .concat(UUID.randomUUID().toString().replace("-", ""))
                    .concat(File.separator).concat(NOMBRE_IMG_PERFIL.formatted(identificacion));

            FileUtil.guardarImagen(rutaBaseImagenes.concat(rutaImagen), fotoBase64);
            return rutaImagen;
        } catch (Exception e) {
            throw new ErrorException("Error guardando la foto de perfil.");
        }
    }
}
