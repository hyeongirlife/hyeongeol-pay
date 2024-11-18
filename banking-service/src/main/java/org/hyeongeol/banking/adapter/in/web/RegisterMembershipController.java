package org.hyeongeol.banking.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.hyeongeolpay.membership.application.port.in.RegisterMembershipCommand;
import org.hyeongeolpay.membership.application.port.in.RegisterMembershipUseCase;
import org.hyeongeolpay.membership.common.WebAdapter;
import org.hyeongeolpay.membership.domain.Membership;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {
    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping(path="/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        // request ~

        // request -> command로 변경 -> request가 변경되도 쉽게 조절가능
        RegisterMembershipCommand command = RegisterMembershipCommand.builder().name(request.getName()).address(request.getAddress()).email(request.getEmail()).isValid(true).isCorp(request.isCorp()).build();

        // command -> usecase로 처리
        return registerMembershipUseCase.registerMembership(command);

    }


}
