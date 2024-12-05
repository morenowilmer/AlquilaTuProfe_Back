package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.HojaVidaEntity;
import co.com.poli.alquilatuprofe.bd.repository.HojaVidaRepository;
import co.com.poli.alquilatuprofe.model.commons.HojaVida;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HojaVidaAdapterImpl implements HojaVidaAdapter {

    private final HojaVidaRepository hojaVidaRepository;
    private final ModelMapper modelMapper;

    public HojaVidaAdapterImpl(HojaVidaRepository hojaVidaRepository,
                               ModelMapper modelMapper) {
        this.hojaVidaRepository = hojaVidaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HojaVida> consultarHojaVidas(Integer idUsuario) {
        List<HojaVidaEntity> hojaVidas = hojaVidaRepository.findByidUsuario(idUsuario);

        return (!hojaVidas.isEmpty()) ? modelMapper.map(hojaVidas, new TypeToken<List<HojaVida>>() {}.getType()) : Collections.emptyList();
    }
}
