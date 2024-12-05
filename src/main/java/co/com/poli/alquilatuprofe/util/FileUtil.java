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
        int newWidth = 200;
        int newHeight = 150;
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, image.getType());
        java.awt.Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, newWidth, newHeight, null);
        g.dispose();
        Path path = Paths.get(rutaImagen);
        Files.createDirectories(path.getParent());
        ImageIO.write(resizedImage, "png", path.toFile());
    }

    public static String obtenerImagen(String rutaImagen) throws IOException {

        if (Objects.isNull(rutaImagen) || rutaImagen.isEmpty())
            return null;
        BufferedImage imagen = ImageIO.read(new File(rutaImagen.replace("/", File.separator)));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(imagen, "png", outputStream);
        byte[] imageBytes = outputStream.toByteArray();

        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
