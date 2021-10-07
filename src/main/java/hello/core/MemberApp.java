package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    //
    public static void main(String[] args) {

        // [1-2와 2-1을 진행하기 위해 선언한것]
        MemberService memberService = new MemberServiceImpl();

        // 1-1. 생성자 이용해 회원을 생성하여 member 객체에 담는다.(회원만 생성된것)
        Member member = new Member(1L,"memberA", Grade.VIP); // 생성자의 파라미터에 입력한 정보들이 Member DTO(VO)에 담긴다

        // 1-2. 1-1.에서 생성된, 회원을 담은 객체인 member를 memberService.join(매개변수)에 넣는다. (회원가입이 진행되는 것이다.)
        memberService.join(member);

        // 2-1. 파라미터에 아이디를 넣어, 아이디를 키로 이용해 메모리에 이미 저장되어있는 회원객체를 가져와 findMember에 담는것
        Member findMember = memberService.findMember(1L); // 2-6. 최종적으로 키값인 1L을 이용해서 값인 객체를 불러온후 그 객체를 findMember에 저장한다.

        System.out.println("new member = " + member.getName()); // 새로 회원가입한 멤버
        System.out.println("find Member = " + findMember.getName()); // 우리가 찾는 멤버

        //3. 마지막으로 콘솔창을 통해 우리가 저장했던 객체와, 아이디를 키로해서 가져온 객체가 일치하는것을 확인할 수 있다.
    }
}
