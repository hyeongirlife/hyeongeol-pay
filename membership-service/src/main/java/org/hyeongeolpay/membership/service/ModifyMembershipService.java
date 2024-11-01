package org.hyeongeolpay.membership.service;

import lombok.RequiredArgsConstructor;
import org.hyeongeolpay.membership.adapter.out.persistance.MembershipJpaEntity;
import org.hyeongeolpay.membership.adapter.out.persistance.MembershipMapper;
import org.hyeongeolpay.membership.application.port.in.ModifyMembershipCommand;
import org.hyeongeolpay.membership.application.port.in.ModifyMembershipUseCase;
import org.hyeongeolpay.membership.application.port.out.ModifyMembershipPort;
import org.hyeongeolpay.membership.common.UseCase;
import org.hyeongeolpay.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }

}
