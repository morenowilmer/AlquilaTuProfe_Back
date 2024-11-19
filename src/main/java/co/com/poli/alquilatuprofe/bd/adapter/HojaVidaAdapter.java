package co.com.poli.alquilatuprofe.bd.adapter;

import co.com.poli.alquilatuprofe.model.commons.HojaVida;

import java.util.List;

public interface HojaVidaAdapter {

    List<HojaVida> consultarHojaVidas(Integer idUsuario);
}
