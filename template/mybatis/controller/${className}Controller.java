package ${basepackage}.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.vcredit.vcs.framework.commons.exception.BizException;
import com.vcredit.vcs.framework.commons.response.Response;
import com.github.pagehelper.PageInfo;




@RestController
@RequestMapping("/api")
@Slf4j
public class ${table.className}Controller {

    @Resource
    private I${table.className}Service ${table.entityName}Service;

    @RequestMapping(value = "/${table.entityName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Response<${table.className}VO> save(@RequestBody ${table.className}VO vo) {
        log.info(vo.toString());
       
        Response<${table.className}VO> res = new Response<${table.className}VO>();
        try {
            Long id = ${table.entityName}Service.save(vo);
            vo.setId(id);
        } catch (BizException e) {
            throw e;
        }
        res.setItems(vo);
        return res;
    }

    @RequestMapping(value = "/${table.entityName}", method = RequestMethod.GET)
    public Response<PageInfo<${table.className}VO>> getList(@RequestParam(required = false) String name,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        Response<PageInfo<${table.className}VO>> res = new Response<PageInfo<${table.className}VO>>();
        ${table.className}VO vo = new ${table.className}VO();
        res.setItems(${table.entityName}Service.query(vo, page, pageSize));
        return res;
    }

}
