package biz.utilsdev.qrgenerator.controller;

import biz.utilsdev.qrgenerator.model.QrData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import biz.utilsdev.qrgenerator.repository.IQrDataRepository;
import biz.utilsdev.qrgenerator.service.QrDataService;

import java.util.Map;

@RestController
@RequestMapping("/qr")
public class QrDataController {

    private final IQrDataRepository iQrDataRepository;
    private final QrDataService qrDataService;

    public QrDataController(IQrDataRepository qrDataRepository, QrDataService qrDataService) {
        this.iQrDataRepository = qrDataRepository;
        this.qrDataService = qrDataService;
    }

    // Primera forma: Generar QR con datos de la BD
    @GetMapping("from-db/{id}")
    public ResponseEntity<byte[]> generateQrFromDb(@PathVariable Long id) throws Exception {

        QrData qrData = iQrDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data not found"));

        // Convierte los datos a JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(qrData);

        // Genera el QR a partir del JSON
        byte[] qr = qrDataService.generateQr(jsonContent);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(qr);
    }

    // Segunda forma: Generar QR con datos ingresados por el usuario
    @PostMapping("/from-input")
    public ResponseEntity<byte[]> generateQrFromInput(@RequestBody Map<String, String> data) throws Exception {

        // Convierte el mapa en un JSON usando Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(data);

        // Genera el QR con el JSON como contenido
        byte[] qr = qrDataService.generateQr(jsonContent);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(qr);
    }

}
