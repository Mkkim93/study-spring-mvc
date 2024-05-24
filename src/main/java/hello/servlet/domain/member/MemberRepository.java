package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    // member 의 데이터를 store 라는 리스트에 담아서 store.put() 을 통해 데이터를 전달하거나 return store.values() 를 통해 전달한다.
    private static Map<Long, Member> store = new HashMap<>();

    private static Long sequence = 0L;

    // 싱글톤(Singleton) 생성
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository(){

    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
