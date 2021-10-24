package cl.bci.apirest.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bci.apirest.usuario.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String> {

}
