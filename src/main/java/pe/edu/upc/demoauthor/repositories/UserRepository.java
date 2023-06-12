package pe.edu.upc.demoauthor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.demoauthor.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
	
	//BUSCAR POR NOMBRE
	@Query("select count(u.username) from User u where u.username =:username")
	public int buscarUsername(@Param("username") String nombre);
	
	
	//INSERTAR ROLES
	@Transactional
	@Modifying
	@Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
	public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO USERS (username, password, enabled, role_id ) VALUES (:username, :password, :enabled, :rol_id)", nativeQuery = true)
	public void insertUser(@Param("username") String username,
	                          @Param("password") String password,
							  @Param("enabled") boolean enabled,
							  @Param("rol_id") Long rol_id);

}