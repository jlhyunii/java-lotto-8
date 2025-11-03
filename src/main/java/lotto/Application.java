package lotto;

import lotto.handler.LottoInputHandler;

public class Application {
    public static void main(String[] args) {
        LottoInputHandler lottoInputHandler = new LottoInputHandler();

        int purchaseAmount = lottoInputHandler.inputPurchaseAmount();
    }
}
