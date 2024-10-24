package org.hyeongeolpay.membership.adapter.out.persistance;

import lombok.RequiredArgsConstructor;
import org.hyeongeolpay.membership.application.port.out.FindMembershipPort;
import org.hyeongeolpay.membership.application.port.out.RegisterMembershipPort;
import org.hyeongeolpay.membership.common.PersistenceAdapter;
import org.hyeongeolpay.membership.domain.Membership;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistanceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository springDataMembershipRepository;

    @Override
    public MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    ) {
        return springDataMembershipRepository.save(
                new MembershipJpaEntity(
                        membershipName.getNameValue(),
                        membershipEmail.getEmailValue(),
                        membershipAddress.getAddressValue(),
                        membershipIsValid.isValidValue(),
                        membershipIsCorp.isCorpValue()
                )
        );
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        springDataMembershipRepository.getReferenceById(Long.parseLong(membershipId.getMembershipId()));
        return null;
    }

}
