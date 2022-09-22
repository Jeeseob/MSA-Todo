package Lora.NetworkServer.loraTestData;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component // 테스트 용도, 메모리에서 데이터 처리
public class MemoryLoraTestDataRepository implements LoraTestDataRepository {


    private static ArrayList<LoraTestData> loraTestDataArrayList = new ArrayList<LoraTestData>();

    @Override
    public ArrayList<LoraTestData> findAll() {
        return loraTestDataArrayList;
    }

    // port 번호를 기반으로 해당되는 데이터 가져오기.
    @Override
    public ArrayList<LoraTestData> findByPort(int port) {
        ArrayList<LoraTestData> datafindByPort = new ArrayList<LoraTestData>();
        for (LoraTestData data : loraTestDataArrayList) {
            if (data.getPort() == port) {
                datafindByPort.add(data);
            }
        }
        return datafindByPort;
    }
}
