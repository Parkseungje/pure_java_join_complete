package hello.core.member;

// 서비스단
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 1-3. main에서 생성한 회원객체를 파라미터에 담아 회원을 저장하는, 회원가입 메서드
    public void join(Member member){

        // 1-4. 회원을 저장하는 행위(서비스)
        memberRepository.save(member);
    }

    // 2-2. id를 키로 이용해 메모리에 저장되어있는 객체를 가져오는 메서드
    public Member findMember(Long memberId){

        // 2-3. 회원을 조회하는 행위(서비스)
        return memberRepository.findById(memberId);
    }
}
