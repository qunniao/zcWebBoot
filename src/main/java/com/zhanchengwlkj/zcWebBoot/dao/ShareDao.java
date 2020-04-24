package com.zhanchengwlkj.zcWebBoot.dao;

import com.zhanchengwlkj.zcWebBoot.modal.News;
import com.zhanchengwlkj.zcWebBoot.modal.ShareArticle;
import com.zhanchengwlkj.zcWebBoot.modal.Type;

import java.util.List;


public interface ShareDao extends BaseDao<ShareArticle> {

    List<ShareArticle> findShareArticleListByAll(int page, int pageSize);

    ShareArticle findShareArticleById(Integer id);

    List<ShareArticle> findShareArticleListByType(String type_str,  int page, int pageSize);

    List<News> findShareArticleListByHot(int page, int pageSize);
}
