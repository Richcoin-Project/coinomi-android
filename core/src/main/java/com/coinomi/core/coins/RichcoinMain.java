package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;
import com.coinomi.core.coins.families.ReddFamily;

import org.bitcoinj.core.Coin;

/**
 * @author Ahmed Bodiwala
 */
public class RichcoinMain extends CoinType {
    private RichcoinMain() {
        id = "richcoin.main";

        addressHeader = 61;
        p2shHeader = 9;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        family = BitFamily.get();
        name = "Richcoin";
        symbol = "USD";
        uriScheme = "richcoin";
        bip44Index = 80;
        unitExponent = 8;
        feePerKb = value(100000);
        minNonDust = value(1000000);   // 0.01 USD mininput
        softDustLimit = value(100000000); // 1 USD
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Richcoin Signed Message:\n");
        
    }

    private static RichcoinMain instance = new RichcoinMain();
    public static synchronized RichcoinMain get() {
        return instance;
    }
}
