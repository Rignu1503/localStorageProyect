package com.rigo.local.storage.localStorageProyect.infrastructure.helpers;


import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmailHelpper {

    @Autowired
    private final JavaMailSender mailSender;

    public void sendEmailInvoice(String to, String clientName, ArrayList<String> products, ArrayList<Integer> quantities, ArrayList<Double> prices ) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        String htmlContent = readHTMLTemplate(products, quantities, prices);

        try {
            mimeMessage.setContent(htmlContent, "text/html");
            mimeMessage.setSubject("Factura para " + clientName);
            mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public String readHTMLTemplate(ArrayList<String> products, ArrayList<Integer> quantities, ArrayList<Double> prices) {

        final Path path = Path.of("src/main/resources/templates/invoiceTemplate.html");

        try (var lines = Files.lines(path)){
            var html = lines.collect(Collectors.joining());

            html = html.replace("{{date}}", LocalDate.now().toString());

            StringBuilder tableRows = new StringBuilder();

            for (int i = 0; i < products.size(); i++) {
                String row = "<tr>" +
                        "<td>" + products.get(i) + "</td>" +
                        "<td>" + quantities.get(i) + "</td>" +
                        "<td>" + prices.get(i) + "</td>" +
                        "</tr>";
                tableRows.append(row);
            }
            html = html.replace("{{tableRows}}", tableRows.toString());

            return html;

        } catch (IOException e) {
            System.out.println("Error reading HTML template: " + e.getMessage());
            throw new RuntimeException(e);

        }

    }

}
