package cl.bci.apirest.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cl.bci.apirest.usuario.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	@Query(value = "SELECT count(email) FROM USUARIO WHERE EMAIL = ?1 ", nativeQuery = true)
	int countEmail(String email);
	
	@Query(value = "SELECT ID_USUARIO FROM USUARIO WHERE EMAIL = ?1 AND PASSWORD = ?2", nativeQuery=true)
	int getIdUsuario(String email, String password);
}