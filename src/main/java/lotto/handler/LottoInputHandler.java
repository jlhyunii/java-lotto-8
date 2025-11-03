package lotto.handler;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputHandler {

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
