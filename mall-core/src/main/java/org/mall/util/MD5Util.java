package org.mall.util;
import java.security.MessageDigest;

public class MD5Util {

    /**
     * 对字符串进行MD5加密
     * @param input 原始字符串
     * @return 32位小写MD5加密字符串
     */
    public static String md5(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(input.getBytes("UTF-8"));
            return bytesToHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密失败", e);
        }
    }

    /**
     * 字节数组转16进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * 验证字符串与MD5加密结果是否匹配
     */
    public static boolean verify(String input, String md5String) {
        if (input == null || md5String == null) {
            return false;
        }
        return md5String.equalsIgnoreCase(md5(input));
    }
}
