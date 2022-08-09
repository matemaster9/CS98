package cs.matemaster.web.service.impl;

import cs.matemaster.web.common.model.ComStaff;
import cs.matemaster.web.mapper.ComStaffMapper;
import cs.matemaster.web.service.ComStaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/8
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ComStaffServiceImpl implements ComStaffService {

    private final ComStaffMapper comStaffMapper;

    @Override
    public void forge(List<ComStaff> forgedData) {
        int count = comStaffMapper.batchInsert(forgedData);
        log.info("插入数据：" + count + "条");
    }
}
