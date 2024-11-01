package org.hyeongeolpay.membership.application.port.in;

import org.hyeongeolpay.membership.adapter.out.persistance.MembershipJpaEntity;
import org.hyeongeolpay.membership.domain.Membership;


public interface ModifyMembershipUseCase {
    Membership modifyMembership(ModifyMembershipCommand command);
}
