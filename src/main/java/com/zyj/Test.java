package com.zyj;

import com.zyj.util.HMacMD5;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import java.util.UUID;

@Slf4j
public class Test {

    public static void main(String[] args) {

        System.out.println(UUID.randomUUID());

    }

}
