package org.hyeongeol.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankingAccount {
    @Getter private final String registeredBankingAccountId; // 뱅킹id
    @Getter private final String membershipId; // 멤버id
    @Getter private final String bankName; // 은행명
    @Getter private final String bankAccountNumber; // 계좌번호
    @Getter private final Boolean linkedStatusValid; // 계좌가 정상인지?



    public static RegisteredBankingAccount generateRegisteredBanckAccount (
            RegisteredBankingAccount.RegisteredBankAccountId registeredBankAccountId;
    ){
        return new RegisteredBankingAccount(
                registeredBankingAccountId.registeredBankAccountId
        );
    }

    @Value
    public static class RegisteredBankAccountId {
        public RegisteredBankAccountId(String value) {
            this.registeredBankAccountId = value;
        }
        String registeredBankAccountId;
    }
    @Value
    public static class MembershipId {
        public MembershipId(String value) {
            this.membershipId = value;
        }
        String membershipId;
    }

    @Value
    public static class BankName {
        public BankName(String value) {
            this.bankName = value;
        }
        String bankName;
    }

    @Value
    public static class BankAccountNumber {
        public BankAccountNumber(String value) {
            this.bankAccountNumber = value;
        }
        String bankAccountNumber;
    }
    @Value
    public static class LinkedStatusValid {
        public LinkedStatusValid(Boolean value) {
            this.linkedStatusValid = value;
        }
        String linkedStatusValid;
    }


}
