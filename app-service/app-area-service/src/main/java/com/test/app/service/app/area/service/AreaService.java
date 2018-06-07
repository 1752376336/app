package com.test.app.service.app.area.service;
import com.test.app.api.app.area.model.Area;
import com.test.app.api.app.area.service.IAreaService;
import com.test.app.api.app.area.service.IAreaServicePlus;
import com.test.app.framework.core.service.impl.GenericService;
import com.test.app.service.app.area.repository.IAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Controller
public class AreaService extends GenericService<Area> implements IAreaService,IAreaServicePlus {
//    @Autowired
//    IAreaRepository areaRepository;

//    @Override
//    public List<Area> queryArea() {
//        return areaRepository.queryArea();
//    }

//    @Override
//    public Area queryAreaById(int areaId) {
//        return areaRepository.queryAreaById(areaId);
//    }

//    @Override
//    public int insertArea(String areaName, int priority) {
//        Area area = new Area();
//        area.setAreaName(areaName);
//        area.setPriority(priority);
//        area.setCreateTime(new Date());
//        area.setLastEduttime(new Date());
//        int rt = areaRepository.insertArea(area);
//        return rt;
//    }

//    @Override
//    public int updateArea(int areaId, String areaName, int priority) {
//        Area area = new Area();
//        area.setAreaId(areaId);
//        area.setAreaName(areaName);
//        area.setPriority(priority);
//        area.setLastEduttime(new Date());
//        int rt = areaRepository.updateArea(area);
//        return rt;
//    }

//    @Override
//    public int deleteArea(int areaId) {
//        return areaRepository.deleteArea(areaId);
//    }

//    @Value("${app.swagger.contact.email}")
//    String test;

//    public String test() {
//        return test;
//    }

//    @Override
//    public int insertAreaPlus(@RequestBody Area model) {
//        model.setCreateTime(new Date());
//        model.setLastEduttime(new Date());
//        return areaRepository.insertArea(model);
//    }

//    @Override
//    public int updateAreaPlus(@RequestBody Area model) {
//        return areaRepository.updateArea(model);
//    }

//    public static void main(String[] args){System.out.println("Hello World");}
}
