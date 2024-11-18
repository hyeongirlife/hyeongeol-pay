package org.hyeongeol.banking.application.port.in;

import org.hyeongeolpay.membership.adapter.out.persistance.MembershipJpaEntity;


public interface FindMembershipUseCase {
    MembershipJpaEntity findMembership(FindMembershipCommand command);
}
