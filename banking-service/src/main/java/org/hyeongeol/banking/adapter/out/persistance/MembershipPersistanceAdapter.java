package org.hyeongeol.banking.adapter.out.persistance;

import lombok.RequiredArgsConstructor;
import org.hyeongeolpay.membership.application.port.out.FindMembershipPort;
import org.hyeongeolpay.membership.application.port.out.ModifyMembershipPort;
import org.hyeongeolpay.membership.application.port.out.RegisterMembershipPort;
import org.hyeongeolpay.membership.common.PersistenceAdapter;
import org.hyeongeolpay.membership.domain.Membership;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistanceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    ) {
        return membershipRepository.save(
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
        membershipRepository.getReferenceById(Long.parseLong(membershipId.getMembershipId()));
        return null;
    }

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        MembershipJpaEntity entity = membershipRepository.getReferenceById(Long.parseLong(membershipId.getMembershipId()));
        entity.setName(membershipName.getNameValue());
        entity.setAddress(membershipAddress.getAddressValue());
        entity.setEmail(membershipEmail.getEmailValue());
        entity.setCorp(membershipIsCorp.isCorpValue());
        entity.setValid(membershipIsValid.isValidValue());

        return membershipRepository.save(entity);
    }

}
