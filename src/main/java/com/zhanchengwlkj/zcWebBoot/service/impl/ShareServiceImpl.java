package com.zhanchengwlkj.zcWebBoot.service.impl;

import com.zhanchengwlkj.zcWebBoot.dao.ShareDao;
import com.zhanchengwlkj.zcWebBoot.modal.News;
import com.zhanchengwlkj.zcWebBoot.modal.ShareArticle;
import com.zhanchengwlkj.zcWebBoot.service.ShareService;
import com.zhanchengwlkj.zcWebBoot.utils.Constant;
import com.zhanchengwlkj.zcWebBoot.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    private static final Logger LOG = LoggerFactory.getLogger(ShareServiceImpl.class);

    @Resource
    private ShareDao shareDao;


    @Override
    public R findShareArticleListByType(String type_str, Integer page) {
        if(null == type_str) type_str = "";
        List<ShareArticle> list= null;
        if("".equals(type_str)){
            //取全部
            list=  shareDao.findShareArticleListByAll((page-1)* Constant.SHARE_ARTICLE_PAGE_SIZE,Constant.SHARE_ARTICLE_PAGE_SIZE);

        }else{
            //按分类取
            list=  shareDao.findShareArticleListByType(type_str,(page-1)* Constant.SHARE_ARTICLE_PAGE_SIZE,Constant.SHARE_ARTICLE_PAGE_SIZE);

        }

        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }

    @Override
    public R findShareArticleById(Integer id) {
        if(null == id || 0 == id)return R.fail("请输入有效的id");
        ShareArticle modal=  shareDao.findShareArticleById(id);
        return R.ok(modal,1);
    }

    @Override
    public R findShareArticleListByHot() {
        int page = 0;
        List<News> list =  shareDao.findShareArticleListByHot(page,Constant.NEWS_RIGHT_PAGE_SIZE);
        return R.ok(list,1);
    }


}
