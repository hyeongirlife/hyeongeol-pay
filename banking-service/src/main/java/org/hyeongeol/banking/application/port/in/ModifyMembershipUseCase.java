package org.hyeongeol.banking.application.port.in;

import org.hyeongeolpay.membership.domain.Membership;


public interface ModifyMembershipUseCase {
    Membership modifyMembership(ModifyMembershipCommand command);
}
