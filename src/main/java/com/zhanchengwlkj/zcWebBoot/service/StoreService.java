package com.zhanchengwlkj.zcWebBoot.service;


import com.zhanchengwlkj.zcWebBoot.utils.R;

public interface StoreService {


    R findStoreListByRecommend(String province, String city);


    R findStoreNewsListByAll(Integer store_id, Integer page);

    R findStoreNewsById(Integer id);

    R findStoreListByType(Integer type_id, Integer kecheng_id, String jigou, String province, String city, String area, Integer page, int type);

    R findStoreListByTypeId(String province, String city,Integer page,  Integer pageSize, Integer type, Integer type_id);

    R findStoreById(Integer product_id);

    R findStoreListByFlagNew(int typeCompany);


    R findCompanyListByAll(Integer type_id, String money_start, String money_end, String province, String city, String area, Integer page, int typeCompany);
}
