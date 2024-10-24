package org.hyeongeolpay.membership.service;

import lombok.RequiredArgsConstructor;
import org.hyeongeolpay.membership.adapter.out.persistance.MembershipJpaEntity;
import org.hyeongeolpay.membership.application.port.in.FindMembershipCommand;
import org.hyeongeolpay.membership.application.port.in.FindMembershipUseCase;
import org.hyeongeolpay.membership.application.port.out.FindMembershipPort;
import org.hyeongeolpay.membership.common.UseCase;
import org.hyeongeolpay.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    // private final MembershipMapper membershipMapper;

    @Override
    public MembershipJpaEntity findMembership(FindMembershipCommand command) {
        return findMembershipPort.findMembership(new Membership.MembershipId((command.getMembershipId())));
    }

}
