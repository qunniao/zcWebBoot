package com.zhanchengwlkj.zcWebBoot.dao;

import com.zhanchengwlkj.zcWebBoot.modal.Ad;
import com.zhanchengwlkj.zcWebBoot.modal.Type;

import java.util.List;


public interface AdDao extends BaseDao<Type> {

    List<Ad> findAdListByType(String type, String city);
}
