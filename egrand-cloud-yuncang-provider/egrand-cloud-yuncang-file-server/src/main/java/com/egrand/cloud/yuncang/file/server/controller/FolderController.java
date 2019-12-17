package com.egrand.cloud.yuncang.file.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.egrand.cloud.yuncang.file.client.model.entity.Folder;
import com.egrand.cloud.yuncang.file.server.service.FolderService;
import com.egrand.core.model.PageParams;
import com.egrand.core.model.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

/**
 *  前端控制器
 *
 * @author ZZH
 * @date 2019-12-17
 */
@Api(value = "", tags = "")
    @RestController
@RequestMapping("folder")
    public class FolderController {

    @Autowired
    private FolderService targetService;

    /**
    * 获取分页数据
    *
    * @return
    */
    @ApiOperation(value = "获取分页数据", notes = "获取分页数据")
    @GetMapping(value = "/list")
    public ResultBody<IPage<Folder>>list(@RequestParam(required = false) Map map){
        PageParams pageParams = new PageParams(map);
        Folder query = pageParams.mapToObject(Folder.class);
        QueryWrapper<Folder> queryWrapper = new QueryWrapper();
        return ResultBody.ok().data(targetService.page(pageParams,queryWrapper));
    }

    /**
     * 根据ID查找数据
     */
    @ApiOperation(value = "根据ID查找数据", notes = "根据ID查找数据")
    @ResponseBody
    @RequestMapping("/get")
    public ResultBody<Folder> get(@RequestParam("id") Long id){
        Folder entity = targetService.getById(id);
        return ResultBody.ok().data(entity);
    }

    /**
    * 添加数据
    * @return
    */
    @ApiOperation(value = "添加数据", notes = "添加数据")
    @ApiImplicitParams({
         @ApiImplicitParam(name = "folderName", required = true, value = "文件夹名称", paramType = "form"),
         @ApiImplicitParam(name = "parentId", required = true, value = "上级文件夹", paramType = "form"),
         @ApiImplicitParam(name = "folderLocation", required = true, value = "文件夹位置", paramType = "form"),
         @ApiImplicitParam(name = "fileSize", required = true, value = "文件大小", paramType = "form"),
         @ApiImplicitParam(name = "fileCount", required = true, value = "文件个数", paramType = "form"),
         @ApiImplicitParam(name = "folderType", required = true, value = "文件夹类型（gd:固定文件夹/zdy:自定义文件夹）", paramType = "form"),
         @ApiImplicitParam(name = "folderUser", required = true, value = "文件夹用途（user:个人/share:资料共享/work:协作）", paramType = "form"),
         @ApiImplicitParam(name = "comment", required = true, value = "文件夹描述", paramType = "form"),
         @ApiImplicitParam(name = "createrId", required = true, value = "创建人ID", paramType = "form"),
        @ApiImplicitParam(name = "creater", required = true, value = "创建人", paramType = "form")
            })
    @PostMapping("/add")
    public ResultBody add(
        @RequestParam(value = "folderName") String folderName,
        @RequestParam(value = "parentId") Long parentId,
        @RequestParam(value = "folderLocation") String folderLocation,
        @RequestParam(value = "fileSize") BigDecimal fileSize,
        @RequestParam(value = "fileCount") Long fileCount,
        @RequestParam(value = "folderType") String folderType,
        @RequestParam(value = "folderUser") String folderUser,
        @RequestParam(value = "comment") String comment,
        @RequestParam(value = "createrId") Long createrId,
        @RequestParam(value = "creater") String creater
            ){
        Folder entity = new Folder();
        entity.setFolderName(folderName);
        entity.setParentId(parentId);
        entity.setFolderLocation(folderLocation);
        entity.setFileSize(fileSize);
        entity.setFileCount(fileCount);
        entity.setFolderType(folderType);
        entity.setFolderUser(folderUser);
        entity.setComment(comment);
        entity.setCreaterId(createrId);
        entity.setCreater(creater);
        targetService.save(entity);
        return ResultBody.ok();
    }

    /**
    * 更新数据
    * @return
    */
    @ApiOperation(value = "更新数据", notes = "更新数据")
    @ApiImplicitParams({
                    @ApiImplicitParam(name = "id", required = true, value = "ID", paramType = "form"),
                    @ApiImplicitParam(name = "folderName", required = true, value = "文件夹名称", paramType = "form"),
                    @ApiImplicitParam(name = "parentId", required = true, value = "上级文件夹", paramType = "form"),
                    @ApiImplicitParam(name = "folderLocation", required = true, value = "文件夹位置", paramType = "form"),
                    @ApiImplicitParam(name = "fileSize", required = true, value = "文件大小", paramType = "form"),
                    @ApiImplicitParam(name = "fileCount", required = true, value = "文件个数", paramType = "form"),
                    @ApiImplicitParam(name = "folderType", required = true, value = "文件夹类型（gd:固定文件夹/zdy:自定义文件夹）", paramType = "form"),
                    @ApiImplicitParam(name = "folderUser", required = true, value = "文件夹用途（user:个人/share:资料共享/work:协作）", paramType = "form"),
                    @ApiImplicitParam(name = "comment", required = true, value = "文件夹描述", paramType = "form"),
                    @ApiImplicitParam(name = "createrId", required = true, value = "创建人ID", paramType = "form"),
                    @ApiImplicitParam(name = "creater", required = true, value = "创建人", paramType = "form")
        })
        @PostMapping("/update")
        public ResultBody add(
                @RequestParam(value = "id") Long id,
                @RequestParam(value = "folderName") String folderName,
                @RequestParam(value = "parentId") Long parentId,
                @RequestParam(value = "folderLocation") String folderLocation,
                @RequestParam(value = "fileSize") BigDecimal fileSize,
                @RequestParam(value = "fileCount") Long fileCount,
                @RequestParam(value = "folderType") String folderType,
                @RequestParam(value = "folderUser") String folderUser,
                @RequestParam(value = "comment") String comment,
                @RequestParam(value = "createrId") Long createrId,
                @RequestParam(value = "creater") String creater
        ){
            Folder entity = new Folder();
                    entity.setId(id);
                    entity.setFolderName(folderName);
                    entity.setParentId(parentId);
                    entity.setFolderLocation(folderLocation);
                    entity.setFileSize(fileSize);
                    entity.setFileCount(fileCount);
                    entity.setFolderType(folderType);
                    entity.setFolderUser(folderUser);
                    entity.setComment(comment);
                    entity.setCreaterId(createrId);
                    entity.setCreater(creater);
                targetService.updateById(entity);
                return ResultBody.ok();
        }

    /**
    * 删除数据
    * @return
    */
    @ApiOperation(value = "删除数据", notes = "删除数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, value = "id", paramType = "form")
    })
    @PostMapping("/remove")
    public ResultBody remove(
            @RequestParam(value = "id") Long id
    ){
            targetService.removeById(id);
            return ResultBody.ok();
      }

    /**
    * 批量删除数据
    * @return
    */
    @ApiOperation(value = "批量删除数据", notes = "批量删除数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, value = "多个用,号隔开", paramType = "form")
    })
    @PostMapping("/batch/remove")
    public ResultBody batchRemove(
                @RequestParam(value = "ids") String ids
            ){
            targetService.removeByIds(Arrays.asList(ids.split(",")));
            return ResultBody.ok();
     }

}
