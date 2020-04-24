package com.zhanchengwlkj.zcWebBoot.service.impl;

import com.zhanchengwlkj.zcWebBoot.dao.TypeDao;
import com.zhanchengwlkj.zcWebBoot.modal.Type;
import com.zhanchengwlkj.zcWebBoot.service.TypeService;
import com.zhanchengwlkj.zcWebBoot.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private static final Logger LOG = LoggerFactory.getLogger(TypeServiceImpl.class);

    @Resource
    private TypeDao typeDao;


    @Override
    public R findTypeListByFlag(int flag) {
        List<Type> list=  typeDao.findTypeListByFlag(flag);
        LOG.info("list size:"+list.size());
        return R.ok(list,1);
    }

    @Override
    public R findSchoolTypeListByPid(Integer pid) {
        List<Type> list=  typeDao.findSchoolTypeListByPid(pid);
        return R.ok(list,1);
    }
}
