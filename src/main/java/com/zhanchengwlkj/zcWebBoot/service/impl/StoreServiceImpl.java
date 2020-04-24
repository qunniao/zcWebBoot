package com.zhanchengwlkj.zcWebBoot.service.impl;

import com.zhanchengwlkj.zcWebBoot.dao.StoreDao;
import com.zhanchengwlkj.zcWebBoot.modal.News;
import com.zhanchengwlkj.zcWebBoot.modal.Store;
import com.zhanchengwlkj.zcWebBoot.modal.StoreNews;
import com.zhanchengwlkj.zcWebBoot.service.StoreService;
import com.zhanchengwlkj.zcWebBoot.utils.Constant;
import com.zhanchengwlkj.zcWebBoot.utils.LogUtil;
import com.zhanchengwlkj.zcWebBoot.utils.R;
import com.zhanchengwlkj.zcWebBoot.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private static final Logger LOG = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Resource
    private StoreDao storeDao;

    @Override
    public R findStoreListByRecommend(String province, String city) {
        List<Store> list=  storeDao.findStoreListByRecommend(province,city,Constant.TYPE_STORE);
        LOG.info("list size:"+list.size());

        return R.ok(list,1);
    }

    @Override
    public R findStoreListByType(Integer type_id, Integer kecheng_id, String jigou, String province, String city, String area, Integer page, int type) {
        if(null == page || page==0)page=1;
        if(province==null) province="";
        if(city==null)city="";
        if(area==null)area="";
        if(jigou==null)jigou="";
        List<Store> list = null;
        if(type_id == null || type_id==0){
            LogUtil.d("findStoreListByType","全部类型");
            //全部类型
            if(kecheng_id ==null || kecheng_id==0){
                //全部课程分类
                LogUtil.d("findStoreListByType","全部课程");
                list=  storeDao.findStoreListByType(province,city,area,(page-1)* Constant.PAGE_SIZE,Constant.PAGE_SIZE,type,jigou);
            }else{
                //某个课程分类
                LogUtil.d("findStoreListByType","某个课程");
                list=  storeDao.findStoreListByTypeKeCheng(province,city,area,(page-1)* Constant.PAGE_SIZE,Constant.PAGE_SIZE,type,kecheng_id,jigou);
            }
        }else{
            //某个类型
            LogUtil.d("findStoreListByType","某个类型 type_id:"+type_id);
            if(kecheng_id ==null || kecheng_id==0){
                //全部课程分类
                list=  storeDao.findStoreListByType2(province,city,area,(page-1)* Constant.PAGE_SIZE,Constant.PAGE_SIZE,type,type_id,jigou);
            }else{
                //某个课程分类
                list=  storeDao.findStoreListByTypeKeCheng2(province,city,area,(page-1)* Constant.PAGE_SIZE,Constant.PAGE_SIZE,type,kecheng_id,type_id,jigou);
            }
        }

        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }

    @Override
    public R findStoreListByTypeId(String province, String city, Integer page, Integer pageSize,  Integer type, Integer type_id) {
        if (StringUtils.isBlank(province) || StringUtils.isBlank(city)) {
            province = "浙江省";
            city = "杭州";
        }
        if(null == page)page = 1;
        if(null == type_id)type_id = 0;

        List<Store> list=  storeDao.findStoreListByTypeId(province,city,(page-1)* Constant.PAGE_SIZE,pageSize,type,type_id);
        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }

    @Override
    public R findStoreById(Integer id) {
        if(null == id || 0 == id)return R.fail("请输入有效的id");
        Store modal = storeDao.findStoreById(id);
        return R.ok(modal,1);
    }

    @Override
    public R findStoreListByFlagNew(int type) {
        int page = 0;
        int pageSize = 3;
        List<Store> list=  storeDao.findStoreListByFlagNew(type,page,pageSize);
        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }

    @Override
    public R findCompanyListByAll(Integer type_id, String money_start, String money_end, String province, String city, String area, Integer page, int typeCompany) {
        if(null == money_start)money_start = "0";
        if(null == money_end)money_end = "20000000";
        if(null == city)city = "杭州";
        if(null == page) page=1;
        if(province==null) province="";
        if(city==null)city="";
        if(area==null)area="";

        List<Store> list = null;
        if(type_id == null || type_id==0){
            //全部类型
            list=  storeDao.findCompanyListByAll(money_start,money_end,province,city,area,(page-1)* Constant.PAGE_SIZE,Constant.PAGE_SIZE, typeCompany);
        }else{
            //某个类型
            list=  storeDao.findCompanyListByAllType(type_id,money_start,money_end,province,city,area,(page-1)* Constant.PAGE_SIZE,Constant.PAGE_SIZE, typeCompany);
        }
        return  R.ok(list,1);
    }




    @Override
    public R findStoreNewsListByAll(Integer store_id, Integer page) {
        if(null == page || page==0)page=1;
        List<News> list=  storeDao.findStoreNewsListByAll(store_id,(page-1)* Constant.STORE_NEWS_PAGE_SIZE,Constant.STORE_NEWS_PAGE_SIZE);
        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }

    @Override
    public R findStoreNewsById(Integer id) {
        if(null == id || 0 == id)return R.fail("请输入有效的id");
        StoreNews modal=  storeDao.findStoreNewsById(id);
        return R.ok(modal,1);
    }


}
