package in.sp.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.sp.main.entity.User;

public interface UserRepository extends  JpaRepository<User, Integer>
{

	  // JPQL query to find users by address
    @Query("SELECT u FROM User u WHERE u.address = :address")
    List<User> findUsersByAddress(@Param("address") String address);

    // JPQL query to find users whose name contains a keyword
    @Query("SELECT u FROM User u WHERE u.name LIKE %:keyword%")
    List<User> findUsersByNameContaining(@Param("keyword") String keyword);
	
   @Query("select u from User u where u.name= :name")
    List<User> findUserByName(@Param("name") String name);
    
}
