package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.security.auth.message.config.AuthConfig;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Henry
 * @date 2020-3-8 21:14
 */
public class Main2 {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> formData = new HashMap<>();
        formData.put("datasource", "dbId");
        formData.put("projectId", "projectId");
        formData.put("userId", "userId");
        formData.put("AccessKeyId", "clientId");
        formData.put("timeStamp", "timestamp");
        formData.put("signature", "md5");
        System.out.println(objectMapper.writeValueAsString(formData));


//        BigDecimal b1 = new BigDecimal("1.0945");
//        BigDecimal b2 = new BigDecimal("0.8");
//        System.out.println(b1.subtract(b2));
//        System.out.println(b1.compareTo(b2));
//         BigDecimal b = b1.setScale(3, BigDecimal.ROUND_HALF_DOWN);
//         BigDecimal bb = b1.setScale(3, BigDecimal.ROUND_HALF_UP);
//        System.out.println(b);
//        System.out.println(bb);
//        System.out.println(BigDecimal.valueOf(0.11));
//        int[] arr1 = {5, 4,3,2,1};
//        List l = Collections.singletonList(arr1);//泛型，只有一个数组应用作为元素
//
//        List ll = Arrays.stream(arr1).boxed().collect(Collectors.toList());
//
//        Integer [] arr = {1,2,3,4,5};
//        List<Integer> list = new ArrayList(Arrays.asList(arr));
//        for (int i = 0; i < list.size(); i++) {
//            Integer integer = list.get(i);
//            if (integer == 4) {
//                list.remove(i);
//            }
//        }
////        for (Integer integer : list) {
////            if (integer == 1) {
////                list.remove(integer);
////            }
////        }
//
//        list.forEach(System.out::println);
    }

}
