package cl.bci.apirest.usuario.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.bci.apirest.usuario.model.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, String> {
	@Query(value = "SELECT * FROM AUDITORIA  WHERE TOKEN = ?1", nativeQuery = true)
	Auditoria validateToken(String token);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE AUDITORIA a SET a.ISACTIVE = FALSE WHERE a.TOKEN = :token", nativeQuery = true)
	void logout(@Param("token") String token);
}