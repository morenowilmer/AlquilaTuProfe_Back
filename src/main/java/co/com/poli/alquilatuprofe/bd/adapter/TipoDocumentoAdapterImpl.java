package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.bd.entities.TipoDocumentoEntity;
import co.com.poli.alquilatuprofe.bd.repository.TipoDocumentoRepository;
import co.com.poli.alquilatuprofe.model.commons.TipoDocumento;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TipoDocumentoAdapterImpl implements TipoDocumentoAdapter {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoAdapterImpl(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @Override
    public List<TipoDocumento> consultarTiposDocumentosActivos() {
        ModelMapper modelMapper = new ModelMapper();
        List<TipoDocumentoEntity> tiposDocumentos = tipoDocumentoRepository.tiposDocumentosActivos();
        return !tiposDocumentos.isEmpty() ? modelMapper.map(tiposDocumentos, new TypeToken<List<TipoDocumento>>() {}.getType()) :
                Collections.emptyList();
    }
}
