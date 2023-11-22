package br.net.galdino.firstwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.galdino.firstwebapp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	public List<Todo> findByUsername(String username);
}
