package com.zhanchengwlkj.zcWebBoot.service;


import com.zhanchengwlkj.zcWebBoot.utils.R;

public interface TypeService {

    R findTypeListByFlag(int flag);

    R findSchoolTypeListByPid(Integer pid);
}
