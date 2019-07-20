package com.donggyo.demo.service

import com.donggyo.demo.repository.BookSearchUserRepository
import spock.lang.Specification
import spock.lang.Unroll

class BookSearchUserServiceTest extends Specification {

	BookSearchUserService sut
	BookSearchUserRepository bookSearchUserRepository

	void setup() {
		bookSearchUserRepository = Mock(BookSearchUserRepository)

		sut = new BookSearchUserService(bookSearchUserRepository: bookSearchUserRepository)
	}

	@Unroll
	def "if there is no such Id then checkIfUserExists must return false"() {
		given:
		bookSearchUserRepository.existsByUserId("existing_id") >> true
		bookSearchUserRepository.existsByUserId("not_existing_id") >> false

		when:
		def res = sut.checkIfUserExists(USER_ID)

		then:
		res == RESULT

		where:
		RESULT | USER_ID
		true   | "existing_id"
		false  | "not_existing_id"
	}
}
