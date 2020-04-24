package com.zhanchengwlkj.zcWebBoot.dao;

import com.zhanchengwlkj.zcWebBoot.modal.Product;
import com.zhanchengwlkj.zcWebBoot.modal.Type;

import java.util.List;


public interface ProductDao extends BaseDao<Product> {


    List<Product> findProductListByCityAll(String city, String county, int day1, int day2, int page, int pageSize);

    List<Product> findProductListByCityAllMoneyDesc(String city, String county,  int day1, int day2,Integer page, int pageSize);

    List<Product> findProductListByCityAllMoney(String city, String county, int day1, int day2, Integer page, int pageSize);


    List<Product> findProductListByCityMenuParent(String city, String county, int day1, int day2, Integer page, int pageSize, Integer type_parent_id);

    List<Product> findProductListByCityAllMenuParentMoneyDesc(String city, String county, int day1, int day2, Integer page, int pageSize, Integer type_parent_id);

    List<Product> findProductListByCityAllMenuParentMoney(String city, String county, int day1, int day2, Integer page, int pageSize, Integer type_parent_id);


    List<Product> findProductListByCityMenu(String city, String county, int day1, int day2, Integer page, int pageSize, Integer type_id);

    List<Product> findProductListByCityAllMenuMoneyDesc(String city, String county, int day1, int day2, Integer page, int pageSize, Integer type_id);

    List<Product> findProductListByCityAllMenuMoney(String city, String county, int day1, int day2, Integer page, int pageSize, Integer type_id);

    Product findProductById(Integer id);

    List<Product> findProductListByStoreId(Integer store_id, int page, int pageSize);

    List<Type> findProductTypeList(Integer pid);
}
