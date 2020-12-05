package org.brian.backend.exception;

import org.slf4j.Logger;

import java.util.Map;

public class ModuleException extends RootException {

    public enum Exceptions implements ILoggableExceptions {
        SequenceIsNotExist(5001,"","Sequence 不存在"),
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
            RootException.ILoggableExceptions.info(this, logger, t, printStackTrace);
        }

        @Override
        public void info(Logger logger, String extraMsg, Throwable t, boolean printStackTrace) {
            RootException.ILoggableExceptions.info(this, logger, extraMsg, t, printStackTrace);
        }

        @Override
        public void info(Logger logger, Throwable t, boolean printStackTrace, String newMsg) {
            RootException.ILoggableExceptions.info(logger, t, newMsg, printStackTrace);
        }

        @Override
        public void info(Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            RootException.ILoggableExceptions.info(this, logger, t, printStackTrace, params);
        }

        @Override
        public void info(Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            RootException.ILoggableExceptions.info(this, logger, extraMsg, t, printStackTrace, params);
        }

        @Override
        public void info(Logger logger, Throwable t, boolean printStackTrace, String newMsg, Map<String, Object> params) {
            RootException.ILoggableExceptions.info(logger, t, newMsg, printStackTrace, params);
        }

        @Override
        public void warn(Logger logger, Throwable t, boolean printStackTrace) {
            RootException.ILoggableExceptions.warn(this, logger, t, printStackTrace);
        }

        @Override
        public void warn(Logger logger, String extraMsg, Throwable t, boolean printStackTrace) {
            RootException.ILoggableExceptions.warn(this, logger, extraMsg, t, printStackTrace);
        }

        @Override
        public void warn(Logger logger, Throwable t, boolean printStackTrace, String newMsg) {
            RootException.ILoggableExceptions.warn(logger, t, newMsg, printStackTrace);
        }

        @Override
        public void warn(Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            RootException.ILoggableExceptions.warn(this, logger, t, printStackTrace, params);
        }

        @Override
        public void warn(Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            RootException.ILoggableExceptions.warn(this, logger, extraMsg, t, printStackTrace, params);
        }

        @Override
        public void warn(Logger logger, Throwable t, boolean printStackTrace, String newMsg, Map<String, Object> params) {
            RootException.ILoggableExceptions.warn(logger, t, newMsg, printStackTrace, params);
        }

        @Override
        public void error(Logger logger, Throwable t, boolean printStackTrace) {
            RootException.ILoggableExceptions.error(this, logger, t, printStackTrace);
        }

        @Override
        public void error(Logger logger, String extraMsg, Throwable t, boolean printStackTrace) {
            RootException.ILoggableExceptions.error(this, logger, extraMsg, t, printStackTrace);
        }

        @Override
        public void error(Logger logger, Throwable t, boolean printStackTrace, String newMsg) {
            RootException.ILoggableExceptions.error(logger, t, newMsg, printStackTrace);
        }

        @Override
        public void error(Logger logger, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            RootException.ILoggableExceptions.error(this, logger, t, printStackTrace, params);
        }

        @Override
        public void error(Logger logger, String extraMsg, Throwable t, boolean printStackTrace, Map<String, Object> params) {
            RootException.ILoggableExceptions.error(this, logger, extraMsg, t, printStackTrace, params);
        }

        @Override
        public void error(Logger logger, Throwable t, boolean printStackTrace, String newMsg, Map<String, Object> params) {
            RootException.ILoggableExceptions.error(logger, t, newMsg, printStackTrace, params);
        }
    }

    public ModuleException(String Description) {
        super(Description);
    }

    public ModuleException() {
    }

    public ModuleException(Exceptions enumException) {
        super(enumException);
    }

    public ModuleException(Exceptions enumException, Throwable ex) {
        super(enumException, ex);
    }

    public ModuleException(Exceptions enumException, String message) {
        super(enumException, message);
    }

    public ModuleException(Exceptions enumException, String message, Throwable ex) {
        super(enumException, message, ex);
    }
}
