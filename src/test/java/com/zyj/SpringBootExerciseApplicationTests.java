package com.zyj;

import com.zyj.util.AES_CBC;
import com.zyj.util.HMacMD5;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootExerciseApplicationTests {



    @Test
    void contextLoads() {
        String key = "1234567890abcdef";
        String iv = "1234567890abcdef";
        String data = "{\"total\":1,\"stationStatusInfo\":{\"operationID\":\"123456789\",\"stationID\":\"111111111111111\",\"con" +
                "nectorStatusInfos\":{\"connectorID\":1,\"equipmentID\":\"10000000000000000000001\",\"status\":4," +
                "\"currentA\":0,\"currentB\":0,\"currentC\":0,\"voltageA\":0,\"voltageB\":0,\"voltageC\":0,\"soc\":10,}}}";
        String encryptStr = AES_CBC.encrypt(data, key.getBytes(), iv.getBytes());
        System.out.println(encryptStr);
        String goal_str = "il7B0BSEjFdzpyKzfOFpvg/Se1CP802RItKYFPfSLRxJ3jf0bVl9hvYOEktPAYW2nd7S8MBcyHYyacHKbISq5iTmDzG+ivnR+SZJv3USNTYVMz9rCQVSxd0cLlqsJauko79NnwQJbzDTyLooYoIwz75qBOH2/xOMirpeEqRJrF/EQjWekJmGk9RtboXePu2rka+Xm51syBPhiXJAq0GfbfaFu9tNqs/e2Vjja/ltE1M0lqvxfXQ6da6HrThsm5id4ClZFIi0acRfrsPLRixS/IQYtksxghvJwbqOsbIsITail9Ayy4tKcogeEZiOO+4Ed264NSKmk7l3wKwJLAFjCFogBx8GE3OBz4pqcAn/ydA=";
        System.out.println(goal_str.equals(encryptStr));
        String hmacMd5Str = HMacMD5.getHmacMd5Str(key, encryptStr);
        System.out.println(hmacMd5Str);


    }

}
