package org.hyeongeol.banking.application.port.in;

import org.hyeongeolpay.membership.domain.Membership;


public interface RegisterMembershipUseCase  {
    Membership registerMembership(RegisterMembershipCommand command);
}
