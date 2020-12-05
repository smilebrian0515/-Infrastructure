package org.brian.backend.exception;

import org.brian.backend.utiiity.CheckUtil;
import org.slf4j.Logger;

import java.util.Map;

public class RootException extends Exception {
    public interface ILoggableExceptions {
        ExceptionLogger exceptionLogger = ExceptionLogger.getInstance();

        int getCode();

        String getResourceKey();

        String getMessage();

        // 一般用途，單純輸出原本定義的 Exception 的訊息
        static void info(ILoggableExceptions loggableExceptions, Logger logger, Throwable t, boolean printStackTrace) {
            exceptionLogger.info(logger, loggableExceptions.getMessage(), t, printStackTrace);
        }

        // 輸出原本定義的 Exception 的訊息後面再接上補充用的訊息（extraMsg）
        static void info(ILoggableExceptions loggableExceptions, Logger logger, String extraMsg, Throwable t, boolean printStackTrace) {
            StringBuilder sb = new StringBuilder(loggableExceptions.getMessage()).append(", ").append(extraMsg);
            exceptionLogger.info(logger, sb.toString(), t, printStackTrace);
        }

        // 以全新的訊息取代原來定義的 Exception 的訊息
        static void info(Logger logger, Throwable t, String newMsg, boolean printStackTrace) {
            exceptionLogger.info(logger, newMsg, t, printStackTrace);
        }

        // 一般用途，單純輸出原本定義的 Exception 的訊息，外加 Exception 發生時的相關判別用參數
        static void info(ILoggableExceptions loggableExceptions, Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            exceptionLogger.info(logger, loggableExceptions.getMessage(), t, printStackTrace, params);
        }

        // 輸出原本定義的 Exception 的訊息後面再接上補充用的訊息（extraMsg），外加 Exception 發生時的相關判別用參數
        static void info(ILoggableExceptions loggableExceptions, Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            StringBuilder sb = new StringBuilder(loggableExceptions.getMessage()).append(", ").append(extraMsg);
            exceptionLogger.info(logger, sb.toString(), t, printStackTrace);
        }

        // 以全新的訊息取代原來定義的 Exception 的訊息，外加 Exception 發生時的相關判別用參數
        static void info(Logger logger, Throwable t, String newMsg, boolean printStackTrace, Map<String, Object> params) {
            exceptionLogger.info(logger, newMsg, t, printStackTrace, params);
        }

        // 一般用途，單純輸出原本定義的 Exception 的訊息
        static void warn(ILoggableExceptions loggableExceptions, Logger logger, Throwable t, boolean printStackTrace) {
            exceptionLogger.warn(logger, loggableExceptions.getMessage(), t, printStackTrace);
        }

        // 輸出原本定義的 Exception 的訊息後面再接上補充用的訊息（extraMsg）
        static void warn(ILoggableExceptions loggableExceptions, Logger logger, String extraMsg, Throwable t, boolean printStackTrace) {
            StringBuilder sb = new StringBuilder(loggableExceptions.getMessage()).append(", ").append(extraMsg);
            exceptionLogger.warn(logger, sb.toString(), t, printStackTrace);
        }

        // 以全新的訊息取代原來定義的 Exception 的訊息
        static void warn(Logger logger, Throwable t, String newMsg, boolean printStackTrace) {
            exceptionLogger.warn(logger, newMsg, t, printStackTrace);
        }

        // 一般用途，單純輸出原本定義的 Exception 的訊息，外加 Exception 發生時的相關判別用參數
        static void warn(ILoggableExceptions loggableExceptions, Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            exceptionLogger.warn(logger, loggableExceptions.getMessage(), t, printStackTrace, params);
        }

        // 輸出原本定義的 Exception 的訊息後面再接上補充用的訊息（extraMsg），外加 Exception 發生時的相關判別用參數
        static void warn(ILoggableExceptions loggableExceptions, Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            StringBuilder sb = new StringBuilder(loggableExceptions.getMessage()).append(", ").append(extraMsg);
            exceptionLogger.warn(logger, sb.toString(), t, printStackTrace, params);
        }

        // 以全新的訊息取代原來定義的 Exception 的訊息，外加 Exception 發生時的相關判別用參數
        static void warn(Logger logger, Throwable t, String newMsg, boolean printStackTrace, Map<String, Object> params) {
            exceptionLogger.warn(logger, newMsg, t, printStackTrace, params);
        }

        // 一般用途，單純輸出原本定義的 Exception 的訊息
        static void error(ILoggableExceptions loggableExceptions, Logger logger, Throwable t, boolean printStackTrace) {
            exceptionLogger.error(logger, loggableExceptions.getMessage(), t, printStackTrace);
        }

        // 輸出原本定義的 Exception 的訊息後面再接上補充用的訊息（extraMsg）
        static void error(ILoggableExceptions loggableExceptions, Logger logger, String extraMsg, Throwable t, boolean printStackTrace) {
            StringBuilder sb = new StringBuilder(loggableExceptions.getMessage()).append(", ").append(extraMsg);
            exceptionLogger.error(logger, sb.toString(), t, printStackTrace);
        }

        // 以全新的訊息取代原來定義的 Exception 的訊息
        static void error(Logger logger, Throwable t, String newMsg, boolean printStackTrace) {
            exceptionLogger.error(logger, newMsg, t, printStackTrace);
        }

        // 一般用途，單純輸出原本定義的 Exception 的訊息，外加 Exception 發生時的相關判別用參數
        static void error(ILoggableExceptions loggableExceptions, Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            exceptionLogger.error(logger, loggableExceptions.getMessage(), t, printStackTrace, params);
        }

        // 輸出原本定義的 Exception 的訊息後面再接上補充用的訊息（extraMsg），外加 Exception 發生時的相關判別用參數
        static void error(ILoggableExceptions loggableExceptions, Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            StringBuilder sb = new StringBuilder(loggableExceptions.getMessage()).append(", ").append(extraMsg);
            exceptionLogger.error(logger, sb.toString(), t, printStackTrace, params);
        }

        // 以全新的訊息取代原來定義的 Exception 的訊息，外加 Exception 發生時的相關判別用參數
        static void error(Logger logger, Throwable t, String newMsg, boolean printStackTrace, Map<String, Object> params) {
            exceptionLogger.error(logger, newMsg, t, printStackTrace, params);
        }

        /**
         * 一般性的訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         */
        void info(Logger logger, Throwable t, boolean printStackTrace);

        /**
         * 一般性的訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         */
        void info(Logger logger, String extraMsg, Throwable t, boolean printStackTrace);

        /**
         * 一般性的訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param newMsg          以另外的新訊息取代原來定義的 Exception 的訊息
         */
        void info(Logger logger, Throwable t, boolean printStackTrace, String newMsg);

        /**
         * 一般性的訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
         */
        void info(Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params);

        /**
         * 一般性的訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
         */
        void info(Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params);

        /**
         * 一般性的訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param newMsg          以另外的新訊息取代原來定義的 Exception 的訊息
         * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
         */
        void info(Logger logger, Throwable t, boolean printStackTrace, String newMsg, Map<String, Object> params);

        /**
         * 一般性的訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         */
        void warn(Logger logger, Throwable t, boolean printStackTrace);

        /**
         * 警示訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         */
        void warn(Logger logger, String extraMsg, Throwable t, boolean printStackTrace);

        /**
         * 警示訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param newMsg          以另外的新訊息取代原來定義的 Exception 的訊息
         */
        void warn(Logger logger, Throwable t, boolean printStackTrace, String newMsg);

        /**
         * 警示訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
         */
        void warn(Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params);

        /**
         * 警示訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
         */
        void warn(Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params);

        /**
         * 警示訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param newMsg          以另外的新訊息取代原來定義的 Exception 的訊息
         * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
         */
        void warn(Logger logger, Throwable t, boolean printStackTrace, String newMsg, Map<String, Object> params);

        /**
         * 嚴重錯誤訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         */
        void error(Logger logger, Throwable t, boolean printStackTrace);

        /**
         * 嚴重錯誤訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         */
        void error(Logger logger, String extraMsg, Throwable t, boolean printStackTrace);

        /**
         * 嚴重錯誤訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param newMsg          以另外的新訊息取代原來定義的 Exception 的訊息
         */
        void error(Logger logger, Throwable t, boolean printStackTrace, String newMsg);

        /**
         * 嚴重錯誤訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
         */
        void error(Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params);

        /**
         * 嚴重錯誤訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
         */
        void error(Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params);

        /**
         * 嚴重錯誤訊息
         *
         * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
         * @param t               Exception 物件
         * @param printStackTrace 是否印出 Stack Trace
         * @param newMsg          以另外的新訊息取代原來定義的 Exception 的訊息
         * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
         */
        void error(Logger logger, Throwable t, boolean printStackTrace, String newMsg, Map<String, Object> params);
    }

    private String message;
    private ILoggableExceptions enumException;

    public RootException() {
        super();
        this.enumException = null;
        this.message = null;
    }

    public RootException(String message) {
        super(message);
        this.enumException = null;
        this.message = message;
    }

    public RootException(ILoggableExceptions enumException) {
        this.enumException = enumException;
        this.message = enumException.getMessage();
    }

    public RootException(ILoggableExceptions enumException, Throwable ex) {
        super(ex);
        this.enumException = enumException;
        this.message = enumException.getMessage();
    }

    public RootException(ILoggableExceptions enumException, String message) {
        this.enumException = enumException;
        this.message = message;
    }

    public RootException(ILoggableExceptions enumException, String message, Throwable ex) {
        super(ex);
        this.enumException = enumException;
        this.message = message;
    }


    public int getCode() {
        return enumException.getCode();
    }

    public String getResourceKey() {
        return enumException.getResourceKey();
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 一般性的訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param printStackTrace 是否印出 Stack Trace
     */
    public void info(Logger logger, boolean printStackTrace) {
        if (message == null) {
            enumException.info(logger, this, printStackTrace);
        } else {
            enumException.info(logger, this, printStackTrace, message);
        }
    }

    /**
     * 一般性的訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
     * @param printStackTrace 是否印出 Stack Trace
     */
    public void info(Logger logger, String extraMsg, boolean printStackTrace) {
        if (message == null) {
            enumException.info(logger, extraMsg, this, printStackTrace);
        } else {
            enumException.info(logger, this, printStackTrace, message);
        }
    }

    /**
     * 一般性的訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param printStackTrace 是否印出 Stack Trace
     * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
     */
    public void info(Logger logger, boolean printStackTrace, Map<String, Object> params) {
        if (message == null) {
            enumException.info(logger, this, printStackTrace, params);
        } else {
            enumException.info(logger, this, printStackTrace, message, params);
        }
    }

    /**
     * 一般性的訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
     * @param printStackTrace 是否印出 Stack Trace
     * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
     */
    public void info(Logger logger, String extraMsg, boolean printStackTrace, Map<String, Object> params) {
        if (message == null) {
            enumException.info(logger, extraMsg, this, printStackTrace, params);
        } else {
            enumException.info(logger, this, printStackTrace, message, params);
        }
    }

    /**
     * 警示訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param printStackTrace 是否印出 Stack Trace
     */
    public void warn(Logger logger, boolean printStackTrace) {
        if (message == null) {
            enumException.warn(logger, this, printStackTrace);
        } else {
            enumException.warn(logger, this, printStackTrace, message);
        }
    }

    /**
     * 警示訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
     * @param printStackTrace 是否印出 Stack Trace
     */
    public void warn(Logger logger, String extraMsg, boolean printStackTrace) {
        if (message == null) {
            enumException.warn(logger, extraMsg, this, printStackTrace);
        } else {
            enumException.warn(logger, this, printStackTrace, message);
        }
    }

    /**
     * 警示訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param printStackTrace 是否印出 Stack Trace
     * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
     */
    public void warn(Logger logger, boolean printStackTrace, Map<String, Object> params) {
        if (message == null) {
            enumException.warn(logger, this, printStackTrace, params);
        } else {
            enumException.warn(logger, this, printStackTrace, message, params);
        }
    }

    /**
     * 警示訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
     * @param printStackTrace 是否印出 Stack Trace
     * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
     */
    public void warn(Logger logger, String extraMsg, boolean printStackTrace, Map<String, Object> params) {
        if (message == null) {
            enumException.warn(logger, extraMsg, this, printStackTrace, params);
        } else {
            enumException.warn(logger, this, printStackTrace, message, params);
        }
    }

    /**
     * 嚴重錯誤訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param printStackTrace 是否印出 Stack Trace
     */
    public void error(Logger logger, boolean printStackTrace) {
        if (message == null) {
            enumException.error(logger, this, printStackTrace);
        } else {
            enumException.error(logger, this, printStackTrace, message);
        }
    }

    /**
     * 嚴重錯誤訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
     * @param printStackTrace 是否印出 Stack Trace
     */
    public void error(Logger logger, String extraMsg, boolean printStackTrace) {
        if (message == null) {
            enumException.error(logger, extraMsg, this, printStackTrace);
        } else {
            enumException.error(logger, this, printStackTrace, message);
        }
    }

    /**
     * 嚴重錯誤訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param printStackTrace 是否印出 Stack Trace
     * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
     */
    public void error(Logger logger, boolean printStackTrace, Map<String, Object> params) {
        if (message == null) {
            enumException.error(logger, this, printStackTrace, params);
        } else {
            enumException.error(logger, this, printStackTrace, message, params);
        }
    }

    /**
     * 嚴重錯誤訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param extraMsg        額外的訊息，輸出時將會直接接到原定義訊息的後面，但如果以新的自定訊息取代原有 Exception 訊息，extraMsg 將無效
     * @param printStackTrace 是否印出 Stack Trace
     * @param params          可紀錄發生 Exception 時的重要變數值，供除錯時研判狀況
     */
    public void error(Logger logger, String extraMsg, boolean printStackTrace, Map<String, Object> params) {
        if (!CheckUtil.isBlankOrNull(extraMsg)) {
            enumException.error(logger, extraMsg, this, printStackTrace, params);
        } else {
            enumException.error(logger, this, printStackTrace, message, params);
        }
    }
}
