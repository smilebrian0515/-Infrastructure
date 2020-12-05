package org.brian.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ExceptionLogger {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionLogger.class);
    private static ExceptionLogger instance = null;
    private static Object mutex = new Object();

    @FunctionalInterface
    private interface LogHandlerFunction {
        void handle(String msg);
    }

    @FunctionalInterface
    private interface LogThrowableHandlerFunction<T extends Throwable> {
        void handle(String msg, T t);
    }

    private ExceptionLogger() {
    }

    public static ExceptionLogger getInstance() {
        synchronized (mutex) {
            if (instance == null) {
                instance = new ExceptionLogger();
            }
        }
        return instance;
    }

    private void log(LogHandlerFunction logHandlerFunction, LogThrowableHandlerFunction<Throwable> logThrowableHandlerFunction,
                     String msg, Throwable t, boolean printStackTrace) {
        try {
            if (t != null) {
                MDC.put("exception_type", t.getClass().getName());
                StackTraceElement[] stackTrace = t.getStackTrace();
                StackTraceElement info = stackTrace[0];
                MDC.put("class_name", info.getClassName());
                MDC.put("method_name", info.getMethodName());
                MDC.put("file_name", info.getFileName());
                MDC.put("line_number", Integer.toString(info.getLineNumber()));
                if (printStackTrace) {
                    logThrowableHandlerFunction.handle(msg, t);
                } else {
                    logHandlerFunction.handle(msg);
                }
            } else {
                logHandlerFunction.handle(msg);
            }
            MDC.clear();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    private void log(LogHandlerFunction logHandlerFunction, LogThrowableHandlerFunction<Throwable> logThrowableHandlerFunction,
                     String msg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
        try {
            StringBuilder sb = new StringBuilder();
            List<Entry<String, Object>> list = new ArrayList<>(params.entrySet());
            int i = 0;
            for (; i < list.size() - 1; ++i) {
                Entry<String, Object> keyValuePair = list.get(i);
                sb.append(keyValuePair.getKey()).append(": ").append(keyValuePair.getValue().toString()).append(", ");
            }
            if (list.size() > 0) {
                Entry<String, Object> keyValuePair = list.get(i);
                sb.append(keyValuePair.getKey()).append(": ").append(keyValuePair.getValue().toString());
            }
            MDC.put("parameters", sb.toString());
            msg += ", [parameters]: " + sb.toString();
            log(logHandlerFunction, logThrowableHandlerFunction, msg, t, printStackTrace);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * 一般性的訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param msg             輸出訊息
     * @param t               Exception 物件
     * @param printStackTrace 是否印出 Stack Trace
     */
    public void info(Logger logger, String msg, Throwable t, boolean printStackTrace) {
        log(logger::info, logger::info, msg, t, printStackTrace);
    }

    /**
     * 一般性的訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param msg             輸出訊息
     * @param t               Exception 物件
     * @param printStackTrace 是否印出 Stack Trace
     * @param params          可紀錄重要變數值，供除錯時研判狀況
     */
    public void info(Logger logger, String msg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
        log(logger::info, logger::info, msg, t, printStackTrace, params);
    }

    /**
     * 警示訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param msg             輸出訊息
     * @param t               Exception 物件
     * @param printStackTrace 是否印出 Stack Trace
     */
    public void warn(Logger logger, String msg, Throwable t, boolean printStackTrace) {
        log(logger::warn, logger::warn, msg, t, printStackTrace);
    }

    /**
     * 警示訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param msg             輸出訊息
     * @param t               Exception 物件
     * @param printStackTrace 是否印出 Stack Trace
     * @param params          可紀錄重要變數值，供除錯時研判狀況
     */
    public void warn(Logger logger, String msg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
        log(logger::warn, logger::warn, msg, t, printStackTrace, params);
    }

    /**
     * 嚴重警告訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param msg             輸出訊息
     * @param t               Exception 物件
     * @param printStackTrace 是否印出 Stack Trace
     */
    public void error(Logger logger, String msg, Throwable t, boolean printStackTrace) {
        log(logger::error, logger::error, msg, t, printStackTrace);
    }

    /**
     * 嚴重警告訊息
     *
     * @param logger          發生 Exception 時，所在 class 內宣告的 Logger物件
     * @param msg             輸出訊息
     * @param t               Exception 物件
     * @param printStackTrace 是否印出 Stack Trace
     * @param params          可紀錄重要變數值，供除錯時研判狀況
     */
    public void error(Logger logger, String msg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
        log(logger::error, logger::error, msg, t, printStackTrace, params);
    }
}
