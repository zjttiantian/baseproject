package com.tiantian.distribute.common.mapper;

import java.util.List;

public interface BaseMapper<T> {
    public void insert(T t);
    public void insertBySelective(T t);

    public void update(T t);
    public void updateBySelective(T t);

    public void delete(Object id);

    public T queryById(Object id);
    public int queryByCount(T t);

    public int countBySql(String sql);

    public List<T> selectByBean(T t);

}
