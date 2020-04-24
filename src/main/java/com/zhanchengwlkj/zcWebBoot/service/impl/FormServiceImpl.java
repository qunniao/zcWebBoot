package com.zhanchengwlkj.zcWebBoot.service.impl;

import com.zhanchengwlkj.zcWebBoot.dao.FormDao;
import com.zhanchengwlkj.zcWebBoot.modal.Form;
import com.zhanchengwlkj.zcWebBoot.service.FormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FormServiceImpl implements FormService {
    private static final Logger LOG = LoggerFactory.getLogger(FormServiceImpl.class);

    @Resource
    private FormDao formDao;


    @Override
    public void addForm(String name, String city,Integer type_int, String field1, String phone, String content) {
       int type=0;
       if(type_int!=null) type = type_int;
        Form modal = new Form();
        modal.setName(name);
        modal.setCity(city);
        modal.setType_int(type);
        modal.setField1(field1);
        modal.setPhone(phone);
        modal.setContent(content);
        modal.setCreate_time((int)(System.currentTimeMillis()/1000));
        formDao.addForm(modal);
    }
}
