package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.HojaVidaEntity;
import co.com.poli.alquilatuprofe.bd.repository.HojaVidaRepository;
import co.com.poli.alquilatuprofe.model.commons.HojaVida;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HojaVidaAdapterImpl implements HojaVidaAdapter {

    private final HojaVidaRepository hojaVidaRepository;

    public HojaVidaAdapterImpl(HojaVidaRepository hojaVidaRepository) {
        this.hojaVidaRepository = hojaVidaRepository;
    }

    @Override
    public List<HojaVida> consultarHojaVidas(Integer idUsuario) {
        ModelMapper modelMapper = new ModelMapper();
        List<HojaVidaEntity> hojaVidas = hojaVidaRepository.findByidUsuario(idUsuario);

        return (!hojaVidas.isEmpty()) ? modelMapper.map(hojaVidas, new TypeToken<List<HojaVida>>() {}.getType()) : Collections.emptyList();
    }
}
