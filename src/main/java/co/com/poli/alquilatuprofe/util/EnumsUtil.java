package co.com.poli.alquilatuprofe.util;

import co.com.poli.alquilatuprofe.model.enums.EnumGenerales;

import java.util.Arrays;

public class EnumsUtil {

    public static String enumGeneralesInformacion(String valor) {
        return Arrays.stream(EnumGenerales.values())
                .filter(enumGenerales -> enumGenerales.getValor().equals(valor))
                .map(EnumGenerales::getInformacion)
                .findFirst().orElse("");
    }
}
