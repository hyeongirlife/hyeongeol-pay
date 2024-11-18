package org.hyeongeol.banking.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.hyeongeolpay.membership.adapter.out.persistance.MembershipJpaEntity;
import org.hyeongeolpay.membership.application.port.in.FindMembershipCommand;
import org.hyeongeolpay.membership.application.port.in.FindMembershipUseCase;
import org.hyeongeolpay.membership.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {
       private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping(path="/membership/{membershipId}")
    ResponseEntity<MembershipJpaEntity> findMembershipByMemberId(@PathVariable String membershipId) {
        FindMembershipCommand command = FindMembershipCommand.builder().membershipId(membershipId).build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }
}
