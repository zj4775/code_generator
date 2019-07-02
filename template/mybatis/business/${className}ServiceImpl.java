package ${basepackage}.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vcredit.vcs.framework.commons.exception.BizException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ${basepackage}.entity.${table.className}Entity;
import ${basepackage}.repository.I${table.className}Repository;
import ${basepackage}.service.I${table.className}Service;

 

@Service
@Slf4j
public class ${table.className}ServiceImpl implements I${table.className}Service {

	@Autowired
	private ${table.className}Mapper ${table.entityName}Mapper;

	@Override
	public Long save(${table.className}VO ${table.entityName}VO){
		${table.className}Entity entity = new ${table.className}Entity();
        BeanUtils.copyProperties(${table.entityName}VO, entity);
		${table.entityName}Mapper.save(entity);
		return entity.getId();
	}

	@Override
	public PageInfo<${table.className}VO> query(${table.className}VO ${table.entityName}VO, int pageNo, int pageSize) {
		${table.className}Entity entity = new ${table.className}Entity();
		BeanUtils.copyProperties(${table.entityName}VO, entity);
        PageHelper.startPage(pageNo, pageSize);
        List<${table.className}Entity> list = ${table.entityName}Mapper.query(entity);
        PageInfo<${table.className}Entity> page = new PageInfo<${table.className}Entity>(list);
        PageInfo<${table.className}VO> result=null;
        try {
        	result=PageCopyUtil.copyTo(page, ${table.className}VO.class);
        } catch (Exception e) {
            log.error("error entity to vo runtimeException", e);
        }
        return result;
	}
    
}