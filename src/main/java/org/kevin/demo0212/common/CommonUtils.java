package org.kevin.demo0212.common;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.rsa.RSASignature;

import javax.crypto.Cipher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author Kevin.Z
 * @version 2020-03-12s
 */
public class CommonUtils {
    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter dtf_ = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
    private static final Random RD = new Random(System.currentTimeMillis());

    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String replaceLineCharacter(String str) {
        return str.replaceAll("[\\n]", "<br/>");
    }

    public static String replaceBlank(String str) {
        return str.replaceAll("[\\s]", "");
    }

    public static String securityPwdEncoder(String pwd) {
        PasswordEncoder pwdEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return pwdEncoder.encode(pwd);
    }

    public static LocalDateTime parseStr2LocalDateTime(String ldtStr, boolean starts) {
        if (starts) {
            ldtStr += " 00:00:00";
        } else {
            ldtStr += " 23:59:59";
        }

        return LocalDateTime.parse(ldtStr, dtf);
    }

    public static LocalDateTime parse2LocalDateTimeWithT(String timeStr) {
        if (timeStr != null) {
            return LocalDateTime.parse(timeStr, dtf_);
        }
        return null;
    }

    public static String LocalDateTime2String(LocalDateTime ldt) {
        return dtf_.format(ldt);
    }

    public static String convertSpecialCharacter(String str) {
        str = str.replaceAll(":", "-");
        str = str.replaceAll("\\.", "-");
        str = str.replaceAll("\\s", "-");

        return str;
    }

    public static Date LocalDateTime2Date(LocalDateTime ldt) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = ldt.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    public static int generateInteger(int bound){
        return RD.nextInt(bound) + 1;
    }

    private static char[] alphabetic = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    };
    private static final int DEFAULT_LENGTH_ALPHABETIC = 52;

    public static String generateString() {
        return generateStringWithLength(13);
    }

    public static String generateStringWithLength(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(alphabetic[RD.nextInt(52)]);
        }
        return sb.toString();
    }

    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encrypt(String source) {
        // 用来将字节转换成 16 进制表示的字符

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes()); // 通过使用 update 方法处理数据,使指定的 byte数组更新摘要   (为什么需要先使用update方法   有的md5方法中怎么不使用？)
            byte[] encryptStr = md.digest(); // 获得密文完成哈希计算,产生128 位的长整数
            char[] str = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对每一个字节,转换成 16 进制字符的转换
                byte byte0 = encryptStr[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            return new String(str); // 换后的结果转换为字符串
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
