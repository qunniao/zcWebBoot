package com.zhanchengwlkj.zcWebBoot.dao;

import com.zhanchengwlkj.zcWebBoot.modal.News;

import java.util.List;


public interface NewsDao extends BaseDao<News> {


    List<News> findNewsListByAll(String type, int page, int pageSize);

    News findNewsById(Integer id);

    List<News> findNewsListByRight(int page, int pageSize);
}
