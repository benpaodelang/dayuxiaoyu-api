package com.dayuxiaoyu.api.dao.cms;

import com.dayuxiaoyu.api.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author zyp
 * @version 1.0
 * @time 2017/12/15 13/43
 * @since
 */
public class CmsBaseDao<Entity> extends BaseDao<Entity> {
    @Autowired
    @Override
    public void setMySqlSessionFactory(
            @Qualifier("cmsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        this.setSqlSessionFactory(sqlSessionFactory);
    }
}
