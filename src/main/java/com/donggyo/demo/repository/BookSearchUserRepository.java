package com.donggyo.demo.repository;

import com.donggyo.demo.entity.BookSearchUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookSearchUserRepository extends JpaRepository<BookSearchUser, String> {

	BookSearchUser getUserByUserId(String userId);

	boolean existsByUserId(String userId);
	boolean existsByUserIdAndPassword(String userId, String password);
}
