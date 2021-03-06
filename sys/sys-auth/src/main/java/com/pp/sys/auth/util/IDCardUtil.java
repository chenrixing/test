package com.pp.sys.auth.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Makkah at 2019/1/15 16:26
 */
public class IDCardUtil {
    private static IDCardUtil idCardUtil;

    private IDCardUtil() {
    }

    public static IDCardUtil getInstance() {
        if (idCardUtil == null) return new IDCardUtil();
        return idCardUtil;
    }

    /**
     * 校验算法：将前面的身份证号码17位数加权求和（系数分别7、9、10、5、8、4、2、1、6、3、7、9、10、5、8、4、2），然后除以11，根据余数找到对应的校验位（分别为1、0、X 、9、8、7、6、5、4、3、2），如果计算的校验位和输入的校验位一致说明身份证号码合法。
     *
     * @param idCard 身份证号码字符串
     * @return 是否为合法身份证号码
     */
    private boolean isLeagal(String idCard) {
        int sum = 0;
        if (idCard.length() != 18) return false;
        char[] chars = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int[] weights = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] idChars = idCard.toCharArray();
        for (int i = 0; i < 17; i++) {
            sum += weights[i] * (idChars[i] - '0');
        }
        return chars[sum % 11] == idChars[17];
    }

    /**
     * 身份证号码第17位表示性别，奇数为男，偶数为女
     *
     * @param idCard 身份证号码字符串
     * @return 1 男 0 女
     */
    Integer getSex(String idCard) {
        if (!isLeagal(idCard)) return null;
        return idCard.charAt(16) % 2 == 0 ? 1 : 0;
    }

    Date getBirthday(String idCard) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(idCard.substring(6, 14));
    }
}
