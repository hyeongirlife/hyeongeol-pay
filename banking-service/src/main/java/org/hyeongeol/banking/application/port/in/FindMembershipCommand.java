package org.hyeongeol.banking.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hyeongeolpay.membership.common.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindMembershipCommand extends SelfValidating<FindMembershipCommand> {
    private final String membershipId;
}
