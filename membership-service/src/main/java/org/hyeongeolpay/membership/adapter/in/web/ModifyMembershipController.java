package org.hyeongeolpay.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.hyeongeolpay.membership.application.port.in.ModifyMembershipCommand;
import org.hyeongeolpay.membership.application.port.in.ModifyMembershipUseCase;
import org.hyeongeolpay.membership.common.WebAdapter;
import org.hyeongeolpay.membership.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {
       private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PatchMapping(path="/membership/modify/{membershipId}")
    ResponseEntity<Membership> modifyMembershipByMemberId(@RequestBody ModifyMembershipRequest request) {

        ModifyMembershipCommand command = ModifyMembershipCommand.builder().membershipId(request.getMembershipId())
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(request.isValid())
                .isCorp(request.isCorp())
                .build();

        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
    }
}
