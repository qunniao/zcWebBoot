package com.zhanchengwlkj.zcWebBoot.dao;

import com.zhanchengwlkj.zcWebBoot.modal.Menu;
import com.zhanchengwlkj.zcWebBoot.modal.Product;
import com.zhanchengwlkj.zcWebBoot.modal.Type;

import java.util.List;


public interface ProductTypeDao extends BaseDao<Product> {


    List<Menu> findProductTypeListByPid(Integer pid);
}
