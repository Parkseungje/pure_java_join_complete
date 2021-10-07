package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // HshMap<>이라는 (키,값)으로 이루어진 저장도구 이용
    private static Map<Long, Member> store = new HashMap<>();

    // 1-5. 회원을 저장하는 행위가 구동되는 방식
    public void save(Member member) {

        // 1-6. store라는 저장도구에 (key(키): 회원객체의 id, value(값): 객체자체)를 넣는다.
        //      최종적으로 store라는 저장도구에 회원객체 하나가 들어간것이다.
        store.put(member.getId(),member);
    }

    // 2-4. 회원을 조회하는 행위가 구동되는 방식
    public Member findById(Long memberId){

        // 2-5. 1-6에서 키와 값으로 먼저 store에 저장했었는데 키를 이용해 값으로 저장했던 객체를 불러오는것이다.
        return store.get(memberId);
    }

}
