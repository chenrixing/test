package com.pp.wms.storage.mapper;

import java.util.List;

/**
 * 基础Mapper接口，规定了必须实现的增删改查
 * 子Mapper接口在声明继承时需明确 T:实体类(如Book), Index:用于索引的字段数据类型(如String)
 * Created by Makkah at 2019/1/16 15:16
 */
public interface Mapper<T, Index> {
    int selectCount();

    List<T> selectAll();

    List<T> select4Page(int page, int limit);

//    List<T> selectLike(Index... indices);

    T selectOne(Index index);

    int insertOne(T t);

    int updateOne(T t);

    int deleteOne(Index index);
}
