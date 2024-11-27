package biz.utilsdev.qrgenerator.controller;

import biz.utilsdev.qrgenerator.model.QrData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import biz.utilsdev.qrgenerator.repository.IQrDataRepository;
import biz.utilsdev.qrgenerator.service.QrDataService;
import org.springframework.web.server.ResponseStatusException;

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

    @Operation(
            summary = "Generar código QR desde la base de datos",
            description = "Obtiene datos de la base de datos por su ID y genera un código QR con la información en formato JSON.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "QR generado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Datos no encontrados")
            }
    )
    // Primera forma: Generar QR con datos de la BD
    @GetMapping("from-db/{id}")
    public ResponseEntity<byte[]> generateQrFromDb(@PathVariable Long id) throws Exception {

        QrData qrData = iQrDataRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        // Convierte los datos a JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(qrData);

        // Genera el QR a partir del JSON
        byte[] qr = qrDataService.generateQr(jsonContent);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(qr);
    }

    @Operation(
            summary = "Generar código QR desde datos ingresados por el usuario",
            description = "Recibe datos clave-valor enviados por el usuario, los convierte en formato JSON y genera un código QR basado en esa información.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "QR generado correctamente"),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. Asegúrate de enviar un JSON válido con pares clave-valor.")
            }
    )
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

    @Operation(
            summary = "Generar código QR desde texto o URL",
            description = "Recibe un texto o una URL en el cuerpo de la solicitud y genera un código QR con ese contenido.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "QR generado correctamente"),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. Asegúrate de enviar un texto o URL válido en el cuerpo de la solicitud.")
            }
    )
    // Tercera forma: Generar QR con texto o URL
    @PostMapping("/from-text")
    public ResponseEntity<byte[]> generateQrFromText(@RequestBody String text) throws Exception {
        byte[] qr = qrDataService.generateQr(text);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qr);
    }

}
