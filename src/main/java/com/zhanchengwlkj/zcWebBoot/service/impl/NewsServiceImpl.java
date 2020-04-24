package com.zhanchengwlkj.zcWebBoot.service.impl;

import com.zhanchengwlkj.zcWebBoot.dao.NewsDao;
import com.zhanchengwlkj.zcWebBoot.modal.News;
import com.zhanchengwlkj.zcWebBoot.service.NewsService;
import com.zhanchengwlkj.zcWebBoot.utils.Constant;
import com.zhanchengwlkj.zcWebBoot.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private static final Logger LOG = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Resource
    private NewsDao newsDao;


    @Override
    public R findNewsListByAll(String type, Integer page) {
        List<News> list=  newsDao.findNewsListByAll(type,(page-1)* Constant.PAGE_SIZE,Constant.PAGE_SIZE);
        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }

    @Override
    public R findNewsById(Integer id) {
        if(null == id || 0 == id)return R.fail("请输入有效的id");
        News modal=  newsDao.findNewsById(id);
        return R.ok(modal,1);
    }

    @Override
    public R findNewsListByRight() {
        int page = 1;
        List<News> list=  newsDao.findNewsListByRight(page,Constant.NEWS_RIGHT_PAGE_SIZE);
        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }
}
