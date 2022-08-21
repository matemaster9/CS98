package cs.matemaster.web.thirdparty;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * @author MateMaster
 * @since 2022/8/20
 */
@AllArgsConstructor
public class MapImportHandler extends ExcelDataHandlerDefaultImpl<Map<String, Object>> {

    private final Map<String, String> NameValueMapper;

    @Override
    public void setMapValue(Map<String, Object> map, String originKey, Object value) {
        String property = NameValueMapper.get(originKey);
        map.put(property, value);
    }

}
