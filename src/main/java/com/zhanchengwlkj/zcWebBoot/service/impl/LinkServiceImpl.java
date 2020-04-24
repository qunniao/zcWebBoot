package com.zhanchengwlkj.zcWebBoot.service.impl;

import com.zhanchengwlkj.zcWebBoot.dao.LinkDao;
import com.zhanchengwlkj.zcWebBoot.modal.Link;
import com.zhanchengwlkj.zcWebBoot.service.LinkService;
import com.zhanchengwlkj.zcWebBoot.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {
    private static final Logger LOG = LoggerFactory.getLogger(LinkServiceImpl.class);

    @Resource
    private LinkDao dao;


    @Override
    public R findLinkListByType(String type, String city) {
        city = "%" + city + "%";
        List<Link> list=  dao.findLinkListByType(type,city);
        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }
}
