package hello.core.member.service;

import hello.core.member.Member;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //("memberService1") 요런식으로 이름도 지정 가능함.
public class MemberServiceImpl implements MemberService{
    /*---------------------------------수정 전 ---------------------
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 만약, private final MemberRepository memberRepository; 로 끝낸다면, 구현체가 없기에 NullPointExecption 발생
    // 그러기에 구현객체를 생성해야함.
    // 이렇게 하면 MemberServiceImpl이 추상화인 MemberRepository와 구체화인 MemoryMemberRepository를 의존하기 때문에 dip 위반하고있음.
    // MemberServiceImpl이 인터페이스인 MemberRepository에만 의존하도록 설계해야함
     */

    // --------------------------------수정 후 --------------------------
    public final MemberRepository memberRepository;
    @Autowired // -> ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
