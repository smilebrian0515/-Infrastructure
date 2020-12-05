package plugin;/*
package com.incrte.ms.dao.ext.paging;


import static org.mybatis.dynamic.sql.SqlBuilder.*;


import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;


import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;

import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.where.render.WhereClauseProvider;

@Mapper
public interface TblcityMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "record.id", before = false, resultType = Integer.class)
    int insert(InsertStatementProvider<Tblcity> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("TblcityResult")
    Tblcity selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("TblcityResult")
    List<Tblcity> selectManyWithRowbounds(SelectStatementProvider selectStatement, RowBounds rowBounds);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Function<SelectStatementProvider, List<Tblcity>> selectManyWithRowbounds(RowBounds rowBounds) {
        return selectStatement -> selectManyWithRowbounds(selectStatement, rowBounds);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "TblcityResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "state", property = "state", jdbcType = JdbcType.VARCHAR),
            @Result(column = "country", property = "country", jdbcType = JdbcType.VARCHAR)
    })
    List<Tblcity> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(tblcity);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, tblcity);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, tblcity)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Tblcity record) {
        return insert(SqlBuilder.insert(record)
                .into(tblcity)
                .map(name).toProperty("name")
                .map(state).toProperty("state")
                .map(country).toProperty("country")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Tblcity record) {
        return insert(SqlBuilder.insert(record)
                .into(tblcity)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(state).toPropertyWhenPresent("state", record::getState)
                .map(country).toPropertyWhenPresent("country", record::getCountry)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Tblcity>>> selectByExample(RowBounds rowBounds) {
        return SelectDSL.selectWithMapper(selectManyWithRowbounds(rowBounds), id, name, state, country)
                .from(tblcity);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Tblcity>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, name, state, country)
                .from(tblcity);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Tblcity>>> selectDistinctByExample(RowBounds rowBounds) {
        return SelectDSL.selectDistinctWithMapper(selectManyWithRowbounds(rowBounds), id, name, state, country)
                .from(tblcity);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Tblcity>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, name, state, country)
                .from(tblcity);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Tblcity selectByPrimaryKey(Integer id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, name, state, country)
                .from(tblcity)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Tblcity record) {
        return UpdateDSL.updateWithMapper(this::update, tblcity)
                .set(name).equalTo(record::getName)
                .set(state).equalTo(record::getState)
                .set(country).equalTo(record::getCountry);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Tblcity record) {
        return UpdateDSL.updateWithMapper(this::update, tblcity)
                .set(name).equalToWhenPresent(record::getName)
                .set(state).equalToWhenPresent(record::getState)
                .set(country).equalToWhenPresent(record::getCountry);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Tblcity record) {
        return UpdateDSL.updateWithMapper(this::update, tblcity)
                .set(name).equalTo(record::getName)
                .set(state).equalTo(record::getState)
                .set(country).equalTo(record::getCountry)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Tblcity record) {
        return UpdateDSL.updateWithMapper(this::update, tblcity)
                .set(name).equalToWhenPresent(record::getName)
                .set(state).equalToWhenPresent(record::getState)
                .set(country).equalToWhenPresent(record::getCountry)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    default QueryExpressionDSL<LimitAndOffsetAdapter<List<Tblcity>>> selectByExampleWithLimitAndOffset(int limit, int offset) {
        return SelectDSL.select(selectModel -> LimitAndOffsetAdapter.of(selectModel, this::selectMany, limit, offset),
                id, name, state, country)
                .from(tblcity);
    }


    */
/**
     * WhereClauseProvider whereClause = where(id, isLessThan(60))
     * .build()
     * .render(RenderingStrategy.MYBATIS3, "whereClauseProvider");
     * <p>
     * List<Tblcity> animals = mapper.selectByExampleWithLimitAndOffset(whereClause, 5, 15);
     *//*

    @Select({
            "select *",
            "from city",
            "${whereClauseProvider.whereClause}",
            "order by id",
            "LIMIT #{limit,jdbcType=INTEGER} OFFSET #{offset,jdbcType=INTEGER}"
    })
    @ResultMap("TblcityResult")
    List<Tblcity> selectByExampleWithLimitAndOffset(@Param("whereClauseProvider") WhereClauseProvider whereClause,
                                                    @Param("limit") int limit, @Param("offset") int offset);

    @Select({
            "${selectStatementProvider.selectStatement}",
            "LIMIT #{limit,jdbcType=INTEGER} OFFSET #{offset,jdbcType=INTEGER}"
    })
    @ResultMap("TblcityResult")
    List<Tblcity> selectByExampleWithLimitAndOffset(@Param("selectStatementProvider") SelectStatementProvider selectStatement,
                                                    @Param("limit") int limit, @Param("offset") int offset);

}*/
