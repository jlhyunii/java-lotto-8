package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.handler.LottoInputHandler;
import lotto.handler.LottoOutputHandler;
import lotto.service.LottoGenerator;
import lotto.service.LottoResultCalculator;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoInputHandler lottoInputHandler = new LottoInputHandler();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
        LottoOutputHandler lottoOutputHandler = new LottoOutputHandler();

        int purchaseAmount = lottoInputHandler.inputPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.generate(purchaseAmount);

        System.out.println();
        System.out.println((purchaseAmount / 1000) + "개를 구매했습니다.");
        lottos.forEach(System.out::println);

        System.out.println();
        List<Integer> winningNumbers = lottoInputHandler.inputWinningNumbers();

        System.out.println();
        int bonusNumber = lottoInputHandler.inputBonusNumber(winningNumbers);

        Map<LottoRank, Integer> result =
                lottoResultCalculator.calculateResults(lottos, winningNumbers, bonusNumber);

        double profitRate = lottoResultCalculator.calculateProfitRate(result, purchaseAmount);
        lottoOutputHandler.printResult(result, profitRate);
    }
}
