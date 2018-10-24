package com.tiantian.distribute.common.service;


import com.tiantian.distribute.common.mapper.BaseMapper;

import java.util.List;

public abstract class BaseService<T> {

    public abstract BaseMapper<T> getMapper();

    public void add(T t){
        getMapper().insert(t);
    }

    public void addBySelective(T t){
        getMapper().insertBySelective(t);
    }

    public void update(T t){
        getMapper().update(t);
    }

    public void updateBySelective(T t) {
        getMapper().updateBySelective(t);
    }

    public void delete(Object... ids){
        if (ids == null || ids.length < 1) {
            return;
        }
        for (Object id : ids) {
            getMapper().delete(id);

        }
    }
    public T queryById(Object id){
        return getMapper().queryById(id);
    }
    public int queryByCount(T t){
        return getMapper().queryByCount(t);
    }
    public List<T> selectByBean(T t){
        return getMapper().selectByBean(t);
    }
}
