package co.com.poli.alquilatuprofe.service;

import co.com.poli.alquilatuprofe.bd.adapter.TipoDocumentoAdapter;
import co.com.poli.alquilatuprofe.model.commons.TipoDocumento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    private final TipoDocumentoAdapter tipoDocumentoAdapter;

    public TipoDocumentoServiceImpl(TipoDocumentoAdapter tipoDocumentoAdapter) {
        this.tipoDocumentoAdapter = tipoDocumentoAdapter;
    }

    @Override
    public List<TipoDocumento> consultarTiposDocumentosActivos() {
        return tipoDocumentoAdapter.consultarTiposDocumentosActivos();
    }
}
