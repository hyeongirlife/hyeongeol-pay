package org.hyeongeol.banking.application.port.out;

import org.hyeongeolpay.membership.adapter.out.persistance.MembershipJpaEntity;
import org.hyeongeolpay.membership.domain.Membership;

public interface ModifyMembershipPort {
    MembershipJpaEntity modifyMembership(
            Membership.MembershipId membershipId,
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    );
}
