package cs.matemaster.web.facade.impl;

import cs.matemaster.web.common.constant.ErrorCode;
import cs.matemaster.web.common.exception.WebRuntimeException;
import cs.matemaster.web.common.model.ComStaff;
import cs.matemaster.web.common.util.MockUtil;
import cs.matemaster.web.facade.ComStaffFacade;
import cs.matemaster.web.service.ComStaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/8
 */
@Component
@RequiredArgsConstructor
public class ComStaffFacadeImpl implements ComStaffFacade {

    private final ComStaffService comStaffService;

    @Override
    public void forge(int size) {
        if (size <= 0) {
            throw new WebRuntimeException(ErrorCode.ILLEGAL_PARAM);
        }
        List<ComStaff> forgedData = MockUtil.getComStaffList(size);
        comStaffService.forge(forgedData);
    }
}
