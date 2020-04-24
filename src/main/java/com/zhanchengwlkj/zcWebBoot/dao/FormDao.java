package com.zhanchengwlkj.zcWebBoot.dao;

import com.zhanchengwlkj.zcWebBoot.modal.Form;
import com.zhanchengwlkj.zcWebBoot.modal.Type;

import java.util.List;


public interface FormDao extends BaseDao<Form> {

    void addForm(Form modal);
}
