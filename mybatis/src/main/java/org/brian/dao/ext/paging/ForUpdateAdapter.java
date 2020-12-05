package org.brian.dao.ext.paging;

import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class ForUpdateAdapter<R> {
    private SelectModel selectModel;
    private Function<SelectStatementProvider, R> mapperMethod;
    private ForUpdateAdapter(SelectModel selectModel, Function<SelectStatementProvider, R> mapperMethod) {
        this.selectModel = Objects.requireNonNull(selectModel);
        this.mapperMethod = Objects.requireNonNull(mapperMethod);
    }

    public R execute() {
        return mapperMethod.apply(selectStatement());
    }

    private SelectStatementProvider selectStatement() {
        return new ForUpdateDecorator(
                selectModel.render(RenderingStrategy.MYBATIS3));
    }

    public static <R> ForUpdateAdapter<R> of(SelectModel selectModel,
                                             Function<SelectStatementProvider, R> mapperMethod) {
        return new ForUpdateAdapter<>(selectModel, mapperMethod);
    }

    public class ForUpdateDecorator implements SelectStatementProvider {
        private Map<String, Object> parameters = new HashMap<>();
        private String selectStatement;

        public ForUpdateDecorator(SelectStatementProvider delegate) {
            parameters.putAll(delegate.getParameters());

            selectStatement = delegate.getSelectStatement() +
                    " FOR UPDATE";
        }

        @Override
        public Map<String, Object> getParameters() {
            return parameters;
        }

        @Override
        public String getSelectStatement() {
            return selectStatement;
        }
    }
}
