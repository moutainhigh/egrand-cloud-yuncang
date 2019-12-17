package com.egrand.cloud.yuncang.file.server.service.impl;

import com.egrand.cloud.yuncang.file.client.model.entity.Folder;
import com.egrand.cloud.yuncang.file.server.mapper.FolderMapper;
import com.egrand.cloud.yuncang.file.server.service.FolderService;
import com.egrand.core.mybatis.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author ZZH
 * @date 2019-12-17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FolderServiceImpl extends BaseServiceImpl<FolderMapper, Folder> implements FolderService {

}
