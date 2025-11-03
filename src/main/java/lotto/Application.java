package lotto;

import lotto.domain.Lotto;
import lotto.handler.LottoInputHandler;
import lotto.service.LottoGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoInputHandler lottoInputHandler = new LottoInputHandler();
        LottoGenerator lottoGenerator = new LottoGenerator();

        int purchaseAmount = lottoInputHandler.inputPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.generate(purchaseAmount);

        System.out.println();
        System.out.println((purchaseAmount / 1000) + "개를 구매했습니다.");
        lottos.forEach(System.out::println);

        System.out.println();
        List<Integer> winningNumbers = lottoInputHandler.inputWinningNumbers();
    }
}
