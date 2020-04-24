package com.zhanchengwlkj.zcWebBoot.utils;

import org.springframework.stereotype.Component;

@Component
public class Constant {
    public static final int PAGE_SIZE = 20;
    public static final int NEWS_RIGHT_PAGE_SIZE = 7;//右侧新闻列表数量
    public static final int STORE_NEWS_PAGE_SIZE = 7;//店铺新闻列表数量
    public static final int SHARE_ARTICLE_PAGE_SIZE = 20;//分享文章列表数量
    public static final int RECOMMEND_COMPANY_PAGE_SIZE = 7;//企业右侧推荐企业列表数量

    public static final int TYPE_STORE = 0;//店铺类型
    public static final int TYPE_COMPANY = 1;//企业类型

    public static final int TYPE_STORE_FLAG = 0;//店铺分类
    public static final int TYPE_COMPANY_FLAG = 1;//企业分类
}
