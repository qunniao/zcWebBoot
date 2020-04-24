package com.zhanchengwlkj.zcWebBoot.service;


import com.zhanchengwlkj.zcWebBoot.utils.R;

public interface ShareService {


    R findShareArticleListByType(String type_str, Integer page);

    R findShareArticleById(Integer id);

    R findShareArticleListByHot();
}
