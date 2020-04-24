package com.zhanchengwlkj.zcWebBoot.dao;

import com.zhanchengwlkj.zcWebBoot.modal.Type;

import java.util.List;


public interface TypeDao extends BaseDao<Type> {


    List<Type> findTypeListByFlag(int flag);

    List<Type> findSchoolTypeListByPid(Integer pid);
}
