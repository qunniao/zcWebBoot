package com.zhanchengwlkj.zcWebBoot.service.impl;

import com.zhanchengwlkj.zcWebBoot.dao.AdDao;
import com.zhanchengwlkj.zcWebBoot.modal.Ad;
import com.zhanchengwlkj.zcWebBoot.service.AdService;
import com.zhanchengwlkj.zcWebBoot.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    private static final Logger LOG = LoggerFactory.getLogger(AdServiceImpl.class);

    @Resource
    private AdDao adDao;


    @Override
    public R findAdListByType(String type, String city) {
        city = "%" + city + "%";
        List<Ad> list=  adDao.findAdListByType(type,city);
        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }
}
