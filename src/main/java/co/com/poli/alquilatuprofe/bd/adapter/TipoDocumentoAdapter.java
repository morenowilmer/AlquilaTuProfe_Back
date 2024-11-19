package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.model.commons.TipoDocumento;

import java.util.List;

public interface TipoDocumentoAdapter {

    List<TipoDocumento> consultarTiposDocumentosActivos();
}
