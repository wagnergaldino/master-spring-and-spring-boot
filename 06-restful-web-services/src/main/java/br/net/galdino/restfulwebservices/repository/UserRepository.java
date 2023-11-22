package br.net.galdino.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.galdino.restfulwebservices.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
