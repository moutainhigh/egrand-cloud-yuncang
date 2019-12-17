package com.egrand.cloud.yuncang.file.server.mapper;

import com.egrand.cloud.yuncang.file.client.model.entity.File;
import com.egrand.core.mybatis.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 *  Mapper 接口
 * @author ZZH
 * @date 2019-12-17
 */
@Mapper
public interface FileMapper extends SuperMapper<File> {

}
