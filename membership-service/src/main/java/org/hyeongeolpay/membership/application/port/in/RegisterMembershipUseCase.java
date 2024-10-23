package org.hyeongeolpay.membership.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hyeongeolpay.membership.common.SelfValidating;
import org.hyeongeolpay.membership.common.UseCase;
import org.hyeongeolpay.membership.domain.Membership;
import org.springframework.stereotype.Component;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public interface RegisterMembershipUseCase  {
    Membership registerMembership(RegisterMembershipCommand command);
}
