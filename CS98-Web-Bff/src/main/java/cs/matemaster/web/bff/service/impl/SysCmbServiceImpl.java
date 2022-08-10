package cs.matemaster.web.bff.service.impl;

import cs.matemaster.web.bff.model.syscmb.dto.ActReportDTO;
import cs.matemaster.web.bff.model.syscmb.dto.BigDataDTO;
import cs.matemaster.web.bff.model.syscmb.dto.RipApiDTO;
import cs.matemaster.web.bff.model.syscmb.vo.ActDataFunnelVO;
import cs.matemaster.web.bff.service.SysCmbService;
import lombok.AllArgsConstructor;
import lombok.var;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author MateMaster
 * @since 2022/7/12
 */
@Service
@AllArgsConstructor
public class SysCmbServiceImpl implements SysCmbService {

    public void demo() {
        var activityIdList = ActReportDTO.getList();
        var bigDataDTOList = BigDataDTO.getList(100);
        var ripApiDTOList = RipApiDTO.getList(100);
    }

    private List<ActDataFunnelVO> mergeAndStatistics(List<String> activityIdList, List<BigDataDTO> bigDataDTOList, List<RipApiDTO> ripApiDTOList) {
        List<ActDataFunnelVO> result = new ArrayList<>();

        var bigDataDTOMap = bigDataDTOList.parallelStream()
                .collect(Collectors.toMap(bigData -> bigData.getActivityId() + bigData.getDate(), Function.identity()));

        var ripApiDTOMap = ripApiDTOList.parallelStream()
                .collect(Collectors.toMap(ripApi -> ripApi.getActivityId() + ripApi.getTime(), Function.identity()));

        for (var key : bigDataDTOMap.keySet()) {
            if (!ripApiDTOMap.containsKey(key)) {
                continue;
            }

            var bigDataDTO = bigDataDTOMap.get(key);
            var ripApiDTO = ripApiDTOMap.get(key);

            var actDataFunnelVO = new ActDataFunnelVO();
            actDataFunnelVO.setCount(StringUtils.isEmpty(bigDataDTO.getCount()) ? 0 : Integer.parseInt(bigDataDTO.getCount()));
            actDataFunnelVO.setCountSuc(ripApiDTO.getCountSuc());

            result.add(actDataFunnelVO);
        }

        return result;
    }


    private List<ActDataFunnelVO> statistics(List<ActDataFunnelVO> data) {
        return Collections.emptyList();
    }
}
