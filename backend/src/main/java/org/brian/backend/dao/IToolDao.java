package org.brian.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IToolDao {

    /**
     * @param seqName 要取的 Sequence 名稱
     * @return long, 根據 seqName 取得值
     * @author Brian
     * @date 2020/12/06 05:57:00
     */
    @Select("  SELECT NEXT VALUE FOR ${sql_seqName};")
    long getSeq(@Param("sql_seqName") String seqName);
}
