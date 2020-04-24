package com.zhanchengwlkj.zcWebBoot.dao;

import com.zhanchengwlkj.zcWebBoot.modal.News;
import com.zhanchengwlkj.zcWebBoot.modal.Store;
import com.zhanchengwlkj.zcWebBoot.modal.StoreNews;


import java.util.List;

public interface StoreDao extends BaseDao<Store> {

    List<Store> findStoreListByRecommend(String province, String city, int type);

    List<Store> findStoreListByNew(String province, String city, int page, int pageSize);

    List<News> findStoreNewsListByAll(Integer store_id, int page, int pageSize);

    StoreNews findStoreNewsById(Integer id);



    List<Store> findStoreListByTypeId(String province, String city, int page, int pageSize, Integer type, Integer type_id);


    Store findStoreById(Integer id);

    List<Store> findStoreListByFlagNew(int type, int page, int pageSize);




    List<Store> findStoreListByType(String province, String city, String area, int page, int pageSize, int type,String jigou);
    List<Store> findStoreListByTypeKeCheng(String province, String city, String area, int page, int pageSize, int type, Integer kecheng_id,String jigou);

    List<Store> findStoreListByType2(String province, String city, String area, int page, int pageSize, int type, Integer type_id,String jigou);

    List<Store> findStoreListByTypeKeCheng2(String province, String city, String area, int page, int pageSize, int type, Integer kecheng_id, Integer type_id,String jigou);

    List<Store> findCompanyListByAll(String money_start, String money_end, String province, String city, String area, int page, int pageSize, int typeCompany);

    List<Store> findCompanyListByAllType(Integer type_id, String money_start, String money_end, String province, String city, String area, int page, int pageSize, int typeCompany);
}
