package com.zhanchengwlkj.zcWebBoot.service.impl;

import com.zhanchengwlkj.zcWebBoot.dao.ProductDao;

import com.zhanchengwlkj.zcWebBoot.modal.Product;
import com.zhanchengwlkj.zcWebBoot.modal.StoreNews;
import com.zhanchengwlkj.zcWebBoot.modal.Type;
import com.zhanchengwlkj.zcWebBoot.service.ProductService;
import com.zhanchengwlkj.zcWebBoot.service.TypeService;
import com.zhanchengwlkj.zcWebBoot.utils.Constant;
import com.zhanchengwlkj.zcWebBoot.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private ProductDao productDao;

    @Override
    public R findProductList(Integer type_parent_id,Integer type_id,  String time, String city, String county, Integer sort, Integer page) {
       if(null == type_id) type_id = 0;
       if(null == type_parent_id) type_parent_id = 0;
       if(null == sort) sort = 0;
       if(null == page) page = 1;
        List<Product> list = null;
        int day1 = 0;
        int day2 = 9999;
        if("1个月以内".equals(time)){
            day2 = 30;
        }else if("1-3个月".equals(time)){
            day1 = 30;
            day2 = 90;
        }else if("3-12个月".equals(time)){
            day1 = 90;
            day2 = 365;
        }else if("1年以上".equals(time)){
            day1 = 365;
            day2 = 9999;
        }

        if(null == county)county = "";

        if(type_parent_id == 0){
            //一级菜单为“全部”，二级菜单为“全部”，不按菜单查询
            if(sort == 0){
                //不排序
                list = productDao.findProductListByCityAll(city,county, day1,day2,page, Constant.PAGE_SIZE);
            }else if(sort == 1){
                //学费最高
                list = productDao.findProductListByCityAllMoneyDesc(city,county,day1,day2, page, Constant.PAGE_SIZE);
            }else if(sort == 2){
                //学费最低
                list = productDao.findProductListByCityAllMoney(city,county, day1,day2, page, Constant.PAGE_SIZE);
            }
        }else if(type_id == 0){
            //一级菜单不为全部，二级菜单为全部，按一级菜单查询
            if(sort == 0){
                //不排序
               list = productDao.findProductListByCityMenuParent(city,county, day1,day2,page, Constant.PAGE_SIZE,type_parent_id);
            }else if(sort == 1){
                //学费最高
                list = productDao.findProductListByCityAllMenuParentMoneyDesc(city,county, day1,day2,page, Constant.PAGE_SIZE,type_parent_id);
            }else if(sort == 2){
                //学费最低
                list = productDao.findProductListByCityAllMenuParentMoney(city,county,day1,day2, page, Constant.PAGE_SIZE,type_parent_id);
            }
        }else{
            //一级菜单不为全部，二级菜单不为全部，按二级菜单查询
            if(sort == 0){
                //不排序
                list = productDao.findProductListByCityMenu(city,county, day1,day2,page, Constant.PAGE_SIZE,type_id);
            }else if(sort == 1){
                //学费最高
                list = productDao.findProductListByCityAllMenuMoneyDesc(city,county, day1,day2,page, Constant.PAGE_SIZE,type_id);
            }else if(sort == 2){
                //学费最低
                list = productDao.findProductListByCityAllMenuMoney(city,county, day1,day2,page, Constant.PAGE_SIZE,type_id);
            }
        }


        if(list != null){
            LOG.info("list size:"+list.size());
        }
        return R.ok(list,1);
    }

    @Override
    public R findProductById(Integer id) {
        if(null == id || 0 == id)return R.fail("id错误");
        Product modal = productDao.findProductById(id);
        return R.ok(modal,1);
    }

    @Override
    public R findProductListByStoreId(Integer store_id, Integer page) {
        if(null == store_id)return R.fail("id错误");
        if(null == page || page==0)page=1;
        List<Product> list=  productDao.findProductListByStoreId(store_id,(page-1)* Constant.PAGE_SIZE,Constant.PAGE_SIZE);
        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }

    @Override
    public R findProductTypeList(Integer pid) {
        List<Type> list=  productDao.findProductTypeList(pid);
        return R.ok(list,1);
    }
}
