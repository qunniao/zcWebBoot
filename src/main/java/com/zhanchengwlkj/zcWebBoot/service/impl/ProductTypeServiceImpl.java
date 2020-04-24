package com.zhanchengwlkj.zcWebBoot.service.impl;

import com.zhanchengwlkj.zcWebBoot.dao.ProductTypeDao;
import com.zhanchengwlkj.zcWebBoot.dao.TypeDao;
import com.zhanchengwlkj.zcWebBoot.modal.Menu;
import com.zhanchengwlkj.zcWebBoot.modal.Type;
import com.zhanchengwlkj.zcWebBoot.service.ProductTypeService;
import com.zhanchengwlkj.zcWebBoot.service.TypeService;
import com.zhanchengwlkj.zcWebBoot.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

    @Resource
    private ProductTypeDao dao;


    @Override
    public R findProductTypeListByPid(Integer pid) {
        List<Menu> list=  dao.findProductTypeListByPid(pid);
        return R.ok(list,1);
    }
}
