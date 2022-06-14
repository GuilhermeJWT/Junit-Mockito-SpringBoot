package br.com.systemsgs.repository;

import br.com.systemsgs.domain.ModelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ModelUser, Integer> {

    Optional<ModelUser> findByEmail(String email);
}
