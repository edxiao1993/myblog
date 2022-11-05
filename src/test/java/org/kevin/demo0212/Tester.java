package org.kevin.demo0212;

import org.junit.jupiter.api.Test;
import org.kevin.demo0212.common.CommonUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-15
 */
public class Tester {

    @Test
    void testLength(){
        String s = "0322";
        String e = CommonUtils.securityPwdEncoder(s);
        System.out.println(s);
        System.out.println(e);
        System.out.println(e.length());

        // fng: {bcrypt}$2a$10$EYmG0xP0woV1bzq3GNGayO5NZJDemAperf7412u6LC1kvC/DzTfnG
        // 0322: {bcrypt}$2a$10$b5fujPML6omKYzCb/3P8seY4obHc.70p/sQYAfE2Y/3cVaJBQIJn6
    }

    @Test
    void tester(){
        int i = 100;
        System.out.println(i>>1);

        StringBuilder sb = new StringBuilder();
        StringBuffer sf = new StringBuffer();

        List<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("12345");
        list.add("!@#$");
        Collections.sort(list);
    }

    @Test
    void t2(){
        List<String> s = new ArrayList<>();
        System.out.println(s.size());
    }

    @Test
    void sumBinary(){
        String as = "11111";
        String bs = "1111";
        int al = as.length() - 1;
        int bl = bs.length() - 1;

        int pos = Math.min(as.length(), bs.length());
        int x = 0;
        StringBuilder ss = new StringBuilder("");
        int sum = -1;
        while(al >= 0 && bl >= 0){
            sum = (as.charAt(al) - 48) + (bs.charAt(bl) - 48) + x;
            if(sum > 1){
                sum -= 2;
                x = 1;
            } else {
                x = 0;
            }
            ss.append(sum);
            al--;
            bl--;
        }
        if(as.length() < bs.length()){
            as = bs;
        }
        al = as.length() - pos;
        for (int i = al-1; i >= 0; i--) {
            sum = as.charAt(al) - 48 + x;
            if(sum > 1){
                sum -= 2;
                x = 1;
            } else {
                x = 0;
            }
            ss.append(sum);
        }
        if(x == 1){
            ss.append(x);
        }
        String result = ss.toString();
        for (int i = result.length() - 1; i >= 0; i--) {
            System.out.print(result.charAt(i) - 48);
        }
    }

    @Test
    void testBoundry(){
        String s = "10101010";
        int x = -1;
        int temp = s.length();
        System.out.println(s.charAt(temp - 1));
        for (int i = temp-1; i >= 0; i--) {
            x = s.charAt(i) - 48;
            System.out.print(x);
        }
    }
    
    @Test
    void alphabetic(){
        for (int i = 97; i < 123; i++) {
            System.out.print("'" + (char)i + "',");
        }
    }
}
