package com.zhanchengwlkj.zcWebBoot.controller;

import com.zhanchengwlkj.zcWebBoot.exception.TipException;
import com.zhanchengwlkj.zcWebBoot.service.*;
import com.zhanchengwlkj.zcWebBoot.utils.Constant;
import com.zhanchengwlkj.zcWebBoot.utils.LogUtil;
import com.zhanchengwlkj.zcWebBoot.utils.R;
import com.zhanchengwlkj.zcWebBoot.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/front")
public class InterfaceController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private FormService formService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private ShareService shareService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService ProductTypeService;

    @Autowired
    private AdService adService;

    @Autowired
    private LinkService linkService;

    /**
     * 获取人气推荐列表
     */
    @GetMapping(value = "/findStoreListByRecommend")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findStoreListByRecommend(@RequestParam String province, @RequestParam String city) {
        LogUtil.d("findStoreListByRecommend","province: "+province+"  city:"+city);
        if (StringUtils.isBlank(province) || StringUtils.isBlank(city)) {
            province = "浙江省";
            city = "杭州";
        }

        R r = storeService.findStoreListByRecommend(province,city);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取默认店铺列表
     */
    @GetMapping(value = "/findStoreListByAll")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findStoreListByAll(Integer type_id,Integer kecheng_id,String jigou,String province, String city,String area,Integer page) {
        LogUtil.d("findStoreListByAll,参数","province: "+province+"  city:"+city);
        if (StringUtils.isBlank(province) || StringUtils.isBlank(city)) {
            province = "浙江省";
            city = "杭州";
        }
        if(null == page)page = 1;
        R r = storeService.findStoreListByType(type_id,kecheng_id,jigou,province,city,area,page,Constant.TYPE_STORE);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }




    /**
     * 获取默认企业列表
     */
    @GetMapping(value = "/findCompanyListByAll")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findCompanyListByAll(Integer type_id,String money_start,String money_end,String province, String city,String area,Integer page) {
        LogUtil.d("findCompanyListByAll","province: "+province+"  city:"+city);
        if (StringUtils.isBlank(province) || StringUtils.isBlank(city)) {
            province = "浙江省";
            city = "杭州";
        }
        if(null == page)page = 1;
        R r = storeService.findCompanyListByAll(type_id, money_start, money_end, province,city, area, page, Constant.TYPE_COMPANY);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }



    /**
     * 按类型-获取推荐的企业列表
     */
    @GetMapping(value = "/findRecommendCompanyListByTypeId")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findRecommendCompanyListByTypeId(@RequestParam String province, @RequestParam String city,Integer page,Integer type_id) {
        LogUtil.d("findRecommendCompanyListByTypeId","province: "+province+"  city:"+city);
        if (StringUtils.isBlank(province) || StringUtils.isBlank(city)) {
            province = "浙江省";
            city = "杭州";
        }
        if(null == page)page = 1;
        if(null == type_id)type_id = 0;
        R r = storeService.findStoreListByTypeId(province,city,page,Constant.RECOMMEND_COMPANY_PAGE_SIZE,Constant.TYPE_COMPANY,type_id);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取店铺分类列表
     */
    @GetMapping(value = "/findTypeListByStore")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findTypeListByStore() {
        LogUtil.d("findTypeListByStore","enter");

        R r = typeService.findTypeListByFlag(Constant.TYPE_STORE_FLAG);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取学校分类列表
     */
    @GetMapping(value = "/findSchoolTypeListByPid")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findSchoolTypeListByPid(Integer pid) {
        LogUtil.d("findSchoolTypeListByPid", "pid:"+pid);

        R r = typeService.findSchoolTypeListByPid(pid);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取课程分类列表
     */
    @GetMapping(value = "/findProductTypeListByPid")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findProductTypeListByPid(Integer pid) {
        LogUtil.d("findProductTypeListByPid"," pid:"+pid);

        R r = ProductTypeService.findProductTypeListByPid(pid);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取企业分类列表
     */
    @GetMapping(value = "/findTypeListByCompany")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findTypeListByCompany() {
        LogUtil.d("findTypeListByCompany","enter");

        R r = typeService.findTypeListByFlag(Constant.TYPE_COMPANY_FLAG);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取最新加盟店列表
     */
    @GetMapping(value = "/findCompanyListByNew")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findCompanyListByNew() {
        LogUtil.d("findCompanyListByNew","enter");

        R r = storeService.findStoreListByFlagNew(Constant.TYPE_COMPANY);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }




    /**
     * 提交表单
     */
    @GetMapping(value = "/addForm")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R addForm(String city, Integer type_int,String field1,String name,String phone,String content) {
        LogUtil.d("addForm","参数————field1: "+field1+"  city:"+city+" phone:"+phone+" content:"+content);
        if (phone.trim().length() != 11) {
           return R.fail("请输入正确的手机号码");
        }

        formService.addForm(name,city,type_int,field1,phone,content);

        return R.ok();
    }

    /**
     * 获取所有新闻列表
     */
    @GetMapping(value = "/findNewsListByAll")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findNewsListByAll(String type,Integer page) {
        LogUtil.d("findNewsListByAll","参数————page: "+page);
        if (null == page) page = 1;
        if (0 == page) page = 1;
        R r = newsService.findNewsListByAll(type,page);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取右侧新闻列表
     */
    @GetMapping(value = "/findNewsListByRight")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findNewsListByRight() {
        LogUtil.d("findNewsListByRight","enter");
        R r = newsService.findNewsListByRight();

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取新闻详情
     */
    @GetMapping(value = "/findNewsById")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findNewsById(Integer id) {
        LogUtil.d("findNewsById","参数————id: "+id);
        if (null == id || 0 == id ){
            return R.fail("请输入有效的id");
        }

        R r = newsService.findNewsById(id);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }


    /**
     * 获取店铺新闻列表
     */
    @GetMapping(value = "/findStoreNewsListByAll")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findStoreNewsListByAll(Integer store_id,Integer page) {
        LogUtil.d("findStoreNewsListByAll","参数————page: "+page);
        if (null == page) page = 1;
        if (0 == page) page = 1;
        if(null == store_id) store_id = 0;
        R r = storeService.findStoreNewsListByAll(store_id,page);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取店铺新闻详情
     */
    @GetMapping(value = "/findStoreNewsById")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findStoreNewsById(Integer id) {
        LogUtil.d("findStoreNewsById","参数————id: "+id);
        if (null == id || 0 == id ){
            return R.fail("请输入有效的id");
        }

        R r = storeService.findStoreNewsById(id);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }


    /**
     * 获取达人分享文章列表
     */
    @GetMapping(value = "/findShareArticleListByType")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findShareArticleListByType(String type_str,Integer page) {
        LogUtil.d("findShareArticleListByType","参数————page: "+page+" type_str:"+type_str);
        if (null == page) page = 1;
        if (0 == page) page = 1;
        R r = shareService.findShareArticleListByType(type_str,page);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取达人分享右侧热门作品
     */
    @GetMapping(value = "/findShareArticleListByHot")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findShareArticleListByHot() {
        LogUtil.d("findShareArticleListByHot","参数————");

        R r = shareService.findShareArticleListByHot();

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取达人分享文章详情
     */
    @GetMapping(value = "/findShareArticleById")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findShareArticleById(Integer id) {
        LogUtil.d("findShareArticleById","参数————id: "+id);
        if (null == id || 0 == id ){
            return R.fail("请输入有效的id");
        }

        R r = shareService.findShareArticleById(id);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取产品列表
     */
    @GetMapping(value = "/findProductList")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findProductList(Integer type_parent_id,Integer type_id, String time,String city, String county, Integer sort, Integer page) {
        LogUtil.d("findProductList","参数————type_id: "+type_id+" type_parent_id:"+type_parent_id+"  time:"+time+" city:"+city+"  county:"+county+"  sort:"+sort+" page:"+page);
        if(city ==null && county == null){
            city="杭州";
        }
        R r = productService.findProductList(type_parent_id,type_id,time,city,county,sort,page);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 获取产品详情
     */
    @GetMapping(value = "/findProductById")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findProductById(Integer id) {
        LogUtil.d("findProductById","参数————id: "+id);
        if(null == id){
           return R.fail("id错误");
        }
        R r = productService.findProductById(id);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 根据id获取店铺信息
     */
    @GetMapping(value = "/findStoreById")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findStoreById(Integer id) {
        LogUtil.d("findStoreById","参数————id: "+id);
        if(null == id){
            return R.fail("id错误");
        }
        R r = storeService.findStoreById(id);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 根据店铺Id获取该店铺的产品列表
     */
    @GetMapping(value = "/findProductListByStoreId")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public R findProductListByStoreId(Integer id,Integer page) {
        LogUtil.d("findProductListByStoreId","参数————id: "+id);
        if(null == id){
            return R.fail("id错误");
        }
        if(null == page) page = 1;
        R r = productService.findProductListByStoreId(id,page);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 根据店铺Id获取该店铺的产品列表
     */
    @GetMapping(value = "/findProductTypeList")
    @ResponseBody
    public R findProductTypeList(Integer pid) {
        LogUtil.d("findProductTypeList","参数————pid: "+pid);
        if(null == pid){
            return R.fail("pid错误");
        }

        R r = productService.findProductTypeList(pid);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 根据广告类型获取广告列表
     */
    @GetMapping(value = "/findAdListByType")
    @ResponseBody
    public R findAdListByType(String type,String city) {
        LogUtil.d("findAdListByType","参数————type: "+type);
        if(null == type){
            type="school_right";
        }
        if(null == city)city="杭州";

        R r = adService.findAdListByType(type,city);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }

    /**
     * 根据类型获取友情链接列表
     */
    @GetMapping(value = "/findLinkListByType")
    @ResponseBody
    public R findLinkListByType(String type,String city) {
        LogUtil.d("findLinkListByType","参数————type: "+type);
        if(null == type){
            type="首页";
        }
        if(null == city)city="杭州";

        R r = linkService.findLinkListByType(type,city);

        //   logService.insertLog(LogActions.UP_INFO.getAction(), GsonUtils.toJsonString(temp), request.getRemoteAddr(), this.getUid(request));
        r.ToString();
        return r;
    }
}
