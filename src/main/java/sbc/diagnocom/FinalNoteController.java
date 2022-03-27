package sbc.diagnocom;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinalNoteController {
    private String strEnfer;
    private String strDiagn;

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
    private void printPDF() throws FileNotFoundException, DocumentException {
        // Nombre del archivo
        var fileName = System.getProperty("user.dir") + "/impresiones/" + new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss")
                .format(new Date()) + "_" + App.user + ".pdf";

        Document file = new Document(PageSize.LETTER); // Crea el archivo PDF
        PdfWriter hand = PdfWriter.getInstance(file, new FileOutputStream(fileName)); // Crea el escritor del archivo

        file.open(); // Abre el archivo

        // Objeto parrafo que contendra el texto
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        parrafo.setFont(FontFactory.getFont("Varela Round Regular", 18, Font.BOLDITALIC, BaseColor.BLUE));
        parrafo.add("DIAGNOCOM: Sistema experto diagnosticador de enfermedades comunes.\n" + "Usuario:" + App.user);
        parrafo.add("\n\n" + strEnfer + "\n" + strDiagn);

        file.add(parrafo); // Agrega el parrafo al documento PDF
        file.close(); // Cierra el archivo
        hand.close(); // Cierra el escritor

        label.setVisible(true);
    }

    @FXML
    private void salirPressed() {
        System.exit(0);
    }

    @FXML
    void initialize() {
        label.setVisible(false);

        strEnfer = "Su diagnóstico médico preliminar es: " + App.encadenamientos.pop();
        strDiagn = "Su diagnóstico se categoriza como: " + App.encadenamientos.pop();

        this.diagnostico.setText(strDiagn);
        this.enfermedad.setText(strEnfer);
    }
}
