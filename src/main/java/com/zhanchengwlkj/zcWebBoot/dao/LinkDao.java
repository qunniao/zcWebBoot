package com.zhanchengwlkj.zcWebBoot.dao;

import com.zhanchengwlkj.zcWebBoot.modal.Ad;
import com.zhanchengwlkj.zcWebBoot.modal.Link;
import com.zhanchengwlkj.zcWebBoot.modal.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface LinkDao extends BaseDao<Type> {

    List<Link> findLinkListByType(String type,  String city);
}
