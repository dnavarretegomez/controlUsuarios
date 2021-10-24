package cl.bci.apirest.usuario.repository;

import java.time.LocalDateTime;

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
	@Query(value = "UPDATE AUDITORIA a SET a.ISACTIVE = FALSE, a.id = '', a.token = '' WHERE a.TOKEN = :token", nativeQuery = true)
	void logout(@Param("token") String token);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE AUDITORIA SET ISACTIVE  = TRUE, id = :token, token = :token, LAST_LOGIN = :lastLogin, MODIFIED= :modified WHERE FK_USUARIO = :idUsuario", nativeQuery = true)
	void Login(@Param("token") String Token, @Param("lastLogin") LocalDateTime lastLogin, @Param("modified") LocalDateTime modified,@Param("idUsuario") int idUsuario);
}