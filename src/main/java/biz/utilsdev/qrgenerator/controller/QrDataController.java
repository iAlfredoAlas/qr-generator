package biz.utilsdev.qrgenerator.controller;

import biz.utilsdev.qrgenerator.model.QrData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.utilsdev.qrgenerator.repository.IQrDataRepository;
import biz.utilsdev.qrgenerator.service.QrDataService;

@RestController
@RequestMapping("/qr")
public class QrDataController {

	private final IQrDataRepository iQrDataRepository;
	private final QrDataService qrDataService;
	
	public QrDataController(IQrDataRepository qrDataRepository, QrDataService qrDataService) {
		this.iQrDataRepository = qrDataRepository;
		this.qrDataService = qrDataService;
	}

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

}
