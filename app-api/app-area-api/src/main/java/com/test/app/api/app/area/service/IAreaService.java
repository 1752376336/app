package com.test.app.api.app.area.service;


import com.test.app.api.app.area.model.Area;
import com.test.app.framework.core.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "区域-接口",description = "区域相关接口")
@RequestMapping("/api/v1/app/area")
public interface IAreaService extends IService<Area> {

    /**
     * 区域列表
     * @return
     */
//    @RequestMapping(path = "/list",method = RequestMethod.GET)
//    @ResponseBody
//    @ApiOperation(value = "获取所有区域集合-操作")
//    List<Area> queryArea();

    /**
     * 根据id查询具体区域
     * @param areaId
     * @return
     */
//    @RequestMapping(path = "/query",method = RequestMethod.GET)
//    @ResponseBody
//    @ApiOperation(value = "按照id查找区域-操作")
//    Area queryAreaById(int areaId);

    /**
     * 插入区域
     * @param areaName
     * @param priority
     * @return
     */
//    @RequestMapping(path = "/insert",method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation(value = "创建区域-操作")
//    int insertArea(String areaName,int priority);

    /**
     * 更新区域信息
     * @param areaId
     * @param areaName
     * @param priority
     * @return
     */
//    @RequestMapping(path = "/update",method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation(value = "更新-操作")
//    int updateArea(int areaId,String areaName,int priority);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
//    @RequestMapping(path = "/delet",method = RequestMethod.DELETE)
//    @ResponseBody
//    @ApiOperation(value = "删除-操作")
//    int deleteArea(int areaId);

    /**
     * 测试用，不涉及数据库操作和业务逻辑
     * @return mybatis配置文件路径
     */
//    @RequestMapping(path = "/test",method = RequestMethod.GET)
//    @ResponseBody
//    @ApiOperation(value = "测试-操作")
//    String test();
}
