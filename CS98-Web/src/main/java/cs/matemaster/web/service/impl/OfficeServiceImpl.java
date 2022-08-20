package cs.matemaster.web.service.impl;

import cs.matemaster.web.common.model.dto.GlobalCompanyDto;
import cs.matemaster.web.common.webcore.WebLogger;
import cs.matemaster.web.mapper.GlobalCompanyMapper;
import cs.matemaster.web.service.OfficeService;
import cs.matemaster.web.util.ExcelUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/18
 */
@Service
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final GlobalCompanyMapper globalCompanyMapper;

    @Override
    public Boolean saveGlobalCompanyList(MultipartFile file) {
        List<GlobalCompanyDto> globalCompanyList = ExcelUtil.getMapping(file, GlobalCompanyDto.class, 0, 1);
        int count = 0;
        if (CollectionUtils.isNotEmpty(globalCompanyList)) {
            count = globalCompanyMapper.batchInsertGlobalCom(globalCompanyList);
        }
        return globalCompanyList.size() == count;
    }
}
