package core;

import util.Utils;
import java.util.ArrayList;

public class Block {

    private int blockId;
    private String previousBlockHash;
    private int nonce;
    private ArrayList<Transaction> transactionList;

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public Block(int blockId, String previousBlockHash, int nonce, ArrayList transactionList) {
        this.blockId = blockId;
        this.previousBlockHash = previousBlockHash;
        this.nonce = nonce;
        this.transactionList = transactionList;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public void getInformation() {
        System.out.println("-----------------------------------");
        System.out.println("블록 번호 : " + getBlockId());
        System.out.println("이전 해시값 : " + getPreviousBlockHash());
        System.out.println("채굴 변수 값 : " + getNonce());
        System.out.println("트랜잭션 개수 : " + transactionList.size() + "개");
        for (int i = 0; i < transactionList.size(); i++) {
            System.out.println(transactionList.get(i).getInformation());
        }
        System.out.println("블록 해시 : " + getBlockHash());
        System.out.println("-----------------------------------");
    }

    public String getBlockHash() {
        String transactionInformations = "";
        for (int i = 0; i < transactionList.size(); i++) {
            transactionInformations += transactionList.get(i).getInformation();
        }
        return Utils.getHash(nonce + transactionInformations + previousBlockHash);
    }

    public void mine() {
        while(true) {
            if ( getBlockHash().substring(0,4).equals("0000")) {
                System.out.println(blockId + "번째 블록의 채굴에 성공했습니다.");
                break;
            }
            nonce++;
        }
    }
}
