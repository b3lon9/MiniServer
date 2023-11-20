package kr.co.cavedwellers.demo;

import kr.co.cavedwellers.demo.data.Member;
import kr.co.cavedwellers.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {
	MemoryMemberRepository repository = new MemoryMemberRepository();

	@Test
	void contextLoads() {
	}

	@Test
	public void save() {
		// given
		Member member = new Member();
		member.setName("spring");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();		// Optional이니깐 get으로 꺼냄

		assertThat(member).isEqualTo(result);
	}

}
