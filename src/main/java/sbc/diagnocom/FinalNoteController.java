package sbc.diagnocom;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinalNoteController {
    // Botones de accion
    @FXML
    private Button reiniciar;
    @FXML
    private Button printDiagno;
    @FXML
    private Button salir;

    // Labels de informacion
    @FXML
    private Label enfermedad;
    @FXML
    private Label diagnostico;
    @FXML
    private Label label;

    @FXML
    private void reiniciarPressed() throws IOException {
        App.setRoot("se1F", 816, 540, "LUGAR DE LA AFECCIÓN");
        App.encadenamientos.removeAllElements();
    }

    @FXML
    private void printPDF() throws IOException, DocumentException, AWTException {
        // Nombre del archivo
        var fileName = System.getProperty("user.dir") + "/impresiones/" + new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss")
                .format(new Date()) + "_" + App.user + ".pdf";

        Document file = new Document(PageSize.A4.rotate(), 10, 10, 10, 10); // Crea el archivo PDF
        PdfWriter hand = PdfWriter.getInstance(file, new FileOutputStream(fileName)); // Crea el escritor del archivo

        file.open(); // Abre el archivo

        // Ajustando GUI para impresion
        reiniciar.setVisible(false);
        printDiagno.setVisible(false);
        salir.setVisible(false);

        // Tomando screenshot de la pantalla
        Image pic = enfermedad.getScene().snapshot(null);
        BufferedImage screenshot = SwingFXUtils.fromFXImage(pic, null);
        ImageIO.write(screenshot, "png", new File((System.getProperty("user.dir") + "/impresiones/" + "pic.png")));

        // REinstaurando GUI
        reiniciar.setVisible(true);
        printDiagno.setVisible(true);
        salir.setVisible(true);

        // Obtiene la imagen y la redimensiona
        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance((System.getProperty("user.dir") + "/impresiones/" + "pic.png"));
        img.setAbsolutePosition(20, 50);

        file.add(img); // Agrega la imagen al PDF

        file.close(); // Cierra el archivo
        hand.close(); // Cierra el escritor

        // Borra la screenshot
        System.out.println(new File((System.getProperty("user.dir") + "/impresiones/" + "pic.png")).delete());
        label.setVisible(true); // Mensaje se confirmacion de impresion
    }

    @FXML
    private void salirPressed() {
        System.exit(0);
    }

    @FXML
    void initialize() {
        label.setVisible(false);

        var strEnfer = "Su diagnóstico médico preliminar es: " + App.encadenamientos.pop();
        var strDiagn = "Su diagnóstico se categoriza como: " + App.encadenamientos.pop();

        this.diagnostico.setText(strDiagn);
        this.enfermedad.setText(strEnfer);
    }
}
