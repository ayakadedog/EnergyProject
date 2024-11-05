package com.energy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.energy.entity.CScenario;
import com.energy.mapper.CScenarioMapper;
import com.energy.service.CScenarioService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【c_scenario】的数据库操作Service实现
* @createDate 2024-11-05 14:35:23
*/
@Service
public class CScenarioServiceImpl extends ServiceImpl<CScenarioMapper, CScenario>
    implements CScenarioService {

    @Override
    public void modifyStatus(Integer stu, List<Long> list) {
        for (Long ids : list) {
            CScenario dish = this.getById(ids);
            dish.setStatus(stu);
            this.updateById(dish);
        }
    }
}




