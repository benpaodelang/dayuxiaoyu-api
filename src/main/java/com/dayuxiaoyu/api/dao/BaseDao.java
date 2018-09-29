package com.dayuxiaoyu.api.dao;

import com.dayuxiaoyu.api.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.api.dao.pagination.PaginationList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoyang
 * @version V1.0
 * @Title:BaseDao.java
 * @Description:DAO基类，实现了通用的增删改查及分页查询方法，并注入了MyBatis的sqlSessionFactory
 * @date Jan 17, 2014 9:57:36 AM
 */

public abstract class BaseDao<Entity> extends SqlSessionDaoSupport {

    private Class<Entity> entityClass = null;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        this.entityClass = null;
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<Entity>) parameterizedType[0];
        }
    }

    public Class<Entity> getEntityClass() {
        return entityClass;
    }

    public abstract void setMySqlSessionFactory(SqlSessionFactory sqlSessionFactory);

    @SuppressWarnings("unchecked")
    public PaginationList selectPaginationList(String statement, Object parameter,
                                               PaginationInfo paginationInfo) {
        PaginationList paginationList = new PaginationList();

        if (parameter == null) {
            throw new RuntimeException("parameter can not be null");
        }
        if (paginationInfo != null) {
            PageHelper.startPage(paginationInfo.getCurrentPage(), paginationInfo.getRecordPerPage(), true);
        }

        List result = this.getSqlSession().selectList(statement, parameter);
        PageInfo pageInfo = new PageInfo(result);

        paginationList.addAll(result);
        if (paginationInfo == null) {
            paginationInfo = new PaginationInfo();
            paginationInfo.setCurrentPage(1);
            paginationInfo.setRecordPerPage(result.size());
            paginationInfo.setTotalPage(1);
            paginationInfo.setTotalRecord(new Long(result.size()));
        } else {
            paginationInfo.setTotalPage(pageInfo.getPages());
            paginationInfo.setTotalRecord(pageInfo.getTotal());
        }
        paginationList.setPaginationInfo(paginationInfo);

        return paginationList;
    }

    /**
     * 删除记录
     *
     * @param cond
     * @return
     */
    public boolean deleteEntity(Map<String, Object> cond) {
        Map<String, Object> delete = new HashMap<String, Object>();
        delete.put("input", cond);
        int result =
                this.getSqlSession()
                        .delete(this.getEntityClass().getSimpleName() + ".deleteEntity", delete);
        return result == 1;
    }

    public Entity addEntity(Entity entity) {
        this.getSqlSession().insert(this.getEntityClass().getSimpleName() + ".addEntity", entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public Entity findEntityById(Map<String, Object> cond, Map<String, Object> output) {
        Map<String, Object> find = new HashMap<String, Object>();
        find.put("input", cond);
        find.put("output", output);
        return (Entity) this.getSqlSession().selectOne(
                this.getEntityClass().getSimpleName() + ".findEntityById", find);
    }

    @SuppressWarnings("unchecked")
    public PaginationList<Entity> findEntityListByCond(Map<String, Object> cond, Map<String, Object> output,
                                                       PaginationInfo paginationInfo) {
        Map<String, Object> find = new HashMap<String, Object>();
        find.put("input", cond);
        find.put("output", output);
        return this.selectPaginationList(this.getEntityClass().getSimpleName()
                + ".findEntityListByCond", find, paginationInfo);
    }


    public boolean updateEntity(Map<String, Object> cond, Map<String, Object> updateValue) {
        Map<String, Object> update = new HashMap<String, Object>();
        update.put("value", updateValue);
        update.put("input", cond);
        int result =
                this.getSqlSession().update(
                        this.getEntityClass().getSimpleName() + ".updateEntityByCond", update);
        return result == 1;
    }

}
