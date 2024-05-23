package hello.servlet.domain.member;

import lombok.Data;

@Data
public class Member {

    private Long id; // HTML 에서 데이터 불러오는 법 ${member.id}

    private String username;

    private int age;

    public Member(){}

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
