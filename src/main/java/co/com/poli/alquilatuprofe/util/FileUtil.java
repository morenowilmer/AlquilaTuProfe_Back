package co.com.poli.alquilatuprofe.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;

public class FileUtil {

    public static void guardarImagen(String rutaImagen, String imagen) throws IOException {
        byte[] imageBytes = Base64.getDecoder().decode(imagen);
        rutaImagen = rutaImagen.replace("/", File.separator);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
        BufferedImage image = ImageIO.read(inputStream);
        Path path = Paths.get(rutaImagen);
        Files.createDirectories(path.getParent());
        ImageIO.write(image, "png", path.toFile());
    }

    public static String obtenerImagen(String rutaImagen) throws IOException {

        if (Objects.isNull(rutaImagen) || rutaImagen.isEmpty())
            return null;
        BufferedImage imagen = ImageIO.read(new File(rutaImagen));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imagen, "png", baos);
        byte[] imageBytes = baos.toByteArray();

        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
