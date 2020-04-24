package com.zhanchengwlkj.zcWebBoot.service;


import com.zhanchengwlkj.zcWebBoot.utils.R;

public interface NewsService {

    R findNewsListByAll(String type, Integer page);

    R findNewsById(Integer id);

    R findNewsListByRight();
}
