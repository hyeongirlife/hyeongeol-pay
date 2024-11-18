package org.hyeongeol.banking.service;

import lombok.RequiredArgsConstructor;
import org.hyeongeolpay.membership.adapter.out.persistance.MembershipJpaEntity;
import org.hyeongeolpay.membership.adapter.out.persistance.MembershipMapper;
import org.hyeongeolpay.membership.application.port.in.RegisterMembershipCommand;
import org.hyeongeolpay.membership.application.port.in.RegisterMembershipUseCase;
import org.hyeongeolpay.membership.application.port.out.RegisterMembershipPort;
import org.hyeongeolpay.membership.common.UseCase;
import org.hyeongeolpay.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // command -> DB 통신
        // 비즈니스 로직 -> DB
        // 외부 시스템으로 가기 위해선 port, adapter 필요.
        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        // entity -> Memberhship
        return membershipMapper.mapToDomainEntity(jpaEntity);
    }

}
