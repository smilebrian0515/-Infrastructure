package org.brian.backend.exception;

import org.slf4j.Logger;

import java.util.Map;

public class ParameterException extends RootException {

    public enum Exceptions implements ILoggableExceptions {

        ;
        private int code;
        private String resourceKey;

        private String message;

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getResourceKey() {
            return resourceKey;
        }

        @Override
        public String getMessage() {
            return message;
        }

        Exceptions(int code, String resourceKey, String message) {
            this.code = code;
            this.resourceKey = resourceKey;
            this.message = message;
        }

        @Override
        public void info(Logger logger, Throwable t, boolean printStackTrace) {
            ILoggableExceptions.info(this, logger, t, printStackTrace);
        }

        @Override
        public void info(Logger logger, String extraMsg, Throwable t, boolean printStackTrace) {
            ILoggableExceptions.info(this, logger, extraMsg, t, printStackTrace);
        }

        @Override
        public void info(Logger logger, Throwable t, boolean printStackTrace, String newMsg) {
            ILoggableExceptions.info(logger, t, newMsg, printStackTrace);
        }

        @Override
        public void info(Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            ILoggableExceptions.info(this, logger, t, printStackTrace, params);
        }

        @Override
        public void info(Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            ILoggableExceptions.info(this, logger, extraMsg, t, printStackTrace, params);
        }

        @Override
        public void info(Logger logger, Throwable t, boolean printStackTrace, String newMsg, Map<String, Object> params) {
            ILoggableExceptions.info(logger, t, newMsg, printStackTrace, params);
        }

        @Override
        public void warn(Logger logger, Throwable t, boolean printStackTrace) {
            ILoggableExceptions.warn(this, logger, t, printStackTrace);
        }

        @Override
        public void warn(Logger logger, String extraMsg, Throwable t, boolean printStackTrace) {
            ILoggableExceptions.warn(this, logger, extraMsg, t, printStackTrace);
        }

        @Override
        public void warn(Logger logger, Throwable t, boolean printStackTrace, String newMsg) {
            ILoggableExceptions.warn(logger, t, newMsg, printStackTrace);
        }

        @Override
        public void warn(Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            ILoggableExceptions.warn(this, logger, t, printStackTrace, params);
        }

        @Override
        public void warn(Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            ILoggableExceptions.warn(this, logger, extraMsg, t, printStackTrace, params);
        }

        @Override
        public void warn(Logger logger, Throwable t, boolean printStackTrace, String newMsg, Map<String, Object> params) {
            ILoggableExceptions.warn(logger, t, newMsg, printStackTrace, params);
        }

        @Override
        public void error(Logger logger, Throwable t, boolean printStackTrace) {
            ILoggableExceptions.error(this, logger, t, printStackTrace);
        }

        @Override
        public void error(Logger logger, String extraMsg, Throwable t, boolean printStackTrace) {
            ILoggableExceptions.error(this, logger, extraMsg, t, printStackTrace);
        }

        @Override
        public void error(Logger logger, Throwable t, boolean printStackTrace, String newMsg) {
            ILoggableExceptions.error(logger, t, newMsg, printStackTrace);
        }

        @Override
        public void error(Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            ILoggableExceptions.error(this, logger, t, printStackTrace, params);
        }

        @Override
        public void error(Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            ILoggableExceptions.error(this, logger, extraMsg, t, printStackTrace, params);
        }

        @Override
        public void error(Logger logger, Throwable t, boolean printStackTrace, String newMsg, Map<String, Object> params) {
            ILoggableExceptions.error(logger, t, newMsg, printStackTrace, params);
        }
    }

    public ParameterException(String Description) {
        super(Description);
    }

    public ParameterException() {
    }

    public ParameterException(Exceptions enumException) {
        super(enumException);
    }

    public ParameterException(Exceptions enumException, Throwable ex) {
        super(enumException, ex);
    }

    public ParameterException(Exceptions enumException, String message) {
        super(enumException, message);
    }

    public ParameterException(Exceptions enumException, String message, Throwable ex) {
        super(enumException, message, ex);
    }
}
