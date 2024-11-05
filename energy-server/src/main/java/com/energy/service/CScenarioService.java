package com.energy.service;

import com.energy.entity.CScenario;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lenovo
* @description 针对表【c_scenario】的数据库操作Service
* @createDate 2024-11-05 14:35:23
*/
public interface CScenarioService extends IService<CScenario> {

    void modifyStatus(Integer stu, List<Long> ids);
}
