package com.zhanchengwlkj.zcWebBoot.service;


import com.zhanchengwlkj.zcWebBoot.utils.R;

public interface ProductService {


    R findProductList(Integer type_parent_id,Integer type_id, String time, String city, String county, Integer sort, Integer page);

    R findProductById(Integer id);

    R findProductListByStoreId(Integer id, Integer page);

    R findProductTypeList(Integer pid);

}
