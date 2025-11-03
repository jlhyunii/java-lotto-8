package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    public Map<LottoRank, Integer> calculateResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatches(lotto, winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            LottoRank rank = LottoRank.of(matchCount, bonusMatch);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    private int countMatches(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public double calculateProfitRate(Map<LottoRank, Integer> result, int purchaseAmount) {
        long totalPrize = result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profit = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(profit * 10) / 10.0;
    }
}
