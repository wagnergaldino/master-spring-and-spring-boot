package br.net.galdino.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.galdino.restfulwebservices.bean.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	public Post findByIdAndUserId(int postId, int userId);
}
