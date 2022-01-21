package Lora.NetworkServer.loraTestData;

import java.util.ArrayList;

public interface LoraTestDataRepository {

    ArrayList<LoraTestData> findAll();

    ArrayList<LoraTestData> findByPort(int port);

}
