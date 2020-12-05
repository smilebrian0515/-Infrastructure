package org.brian.backend.utiiity;

import org.brian.backend.exception.ParameterException;

public class CheckUtil {
    public static boolean checkIsNull(Object obj) {
        if (obj == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBlankOrNull(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static void checkParam(String strParam, String strParamName) throws ParameterException {
        if (isBlankOrNull(strParam)) {
            throw new ParameterException("Param Error:" + strParamName + " is incorrect.");
        }
    }

    public static void checkIsNull(Object obj, String strParamName) throws ParameterException {
        if (obj == null) {
            throw new ParameterException("Param Error:" + strParamName + " is incorrect.");
        }
    }
}
