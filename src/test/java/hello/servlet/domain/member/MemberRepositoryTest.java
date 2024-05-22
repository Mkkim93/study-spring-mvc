package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    // 싱글톤이기 때문에 MemberRepository 객체를 생성하기 위해 new 로 생성할 필요가 없다.
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach // TEST 한개가 끝나면 데이터를 초기화한다. 그리고 다음 테스트를 진행 한다.
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("Member Save Data == Member Find Data ?")
    void save() {
        // given
        Member member = new Member("kim", 20);


        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);

    }

    @Test
    @DisplayName("Member findAll Correct!")
    void findAll() {
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
