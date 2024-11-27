package biz.utilsdev.qrgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.utilsdev.qrgenerator.model.QrData;
import org.springframework.stereotype.Repository;

@Repository
public interface IQrDataRepository extends JpaRepository<QrData, Long> {

}
