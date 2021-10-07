package hello.core.member;

public interface MemberService {
    
    // 회원가입 인터페이스
    void join(Member member);
    
    // 회원찾기 인터페이스
    Member findMember(Long memberId);
}
