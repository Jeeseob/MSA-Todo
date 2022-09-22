package Lora.NetworkServer.loraTestData;

import javax.persistence.Id;

public class LoraTestData {

    @Id
    private long id;
    private long mote; //의미 불명
    private String time; // yyyy-mm-dd hh:mm:ss 로 변경필요(repository에서 적용)
    private long timeUsec; //의미 불명
    private int accurateTime; //의미 불명
    private int seqNo; // 몇번째 데이터인지
    private int port; // 포트별로 데이터를 다르게 처리하는 방법을 사용하면, 여러 데이터를 동시에 처리할 수 있을 듯.
    private String data;

    public String getTime() {
        return time;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public int getPort() {
        return port;
    }

    public String getData() {
        return data;
    }
}
