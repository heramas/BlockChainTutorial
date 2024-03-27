import core.Block;
import core.Transaction;
import util.Utils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Block block1 = new Block(1, null, 0, new ArrayList());
        block1.mine();
        block1.getInformation();

        Block block2 = new Block(2, block1.getBlockHash(), 0, new ArrayList());
        block2.addTransaction(new Transaction("김달수","이요한", 1.5));
        block2.addTransaction(new Transaction("최준수","이요한", 0.5));
        block2.mine();
        block2.getInformation();

        Block block3 = new Block(3, block2.getBlockHash(), 0, new ArrayList());
        block3.addTransaction(new Transaction("이요한","최준수", 3.5));
        block3.addTransaction(new Transaction("최준수","박정현", 5.5));
        block3.mine();
        block3.getInformation();
    }
}