package lotto.handler;

import lotto.domain.LottoRank;

import java.text.DecimalFormat;
import java.util.Map;

public class LottoOutputHandler {

    public void printResult(Map<LottoRank, Integer> result, double profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        printRank(result, LottoRank.FIFTH, "3개 일치 (5,000원)");
        printRank(result, LottoRank.FOURTH, "4개 일치 (50,000원)");
        printRank(result, LottoRank.THIRD, "5개 일치 (1,500,000원)");
        printRank(result, LottoRank.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        printRank(result, LottoRank.FIRST, "6개 일치 (2,000,000,000원)");

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("총 수익률은 " + df.format(profitRate) + "%입니다.");
    }

    private void printRank(Map<LottoRank, Integer> result, LottoRank rank, String label) {
        System.out.println(label + " - " + result.getOrDefault(rank, 0) + "개");
    }
}
