package cs.matemaster.web;

import cs.matemaster.web.common.testmodel.DataFunnel;
import cs.matemaster.web.common.util.MockUtil;
import cs.matemaster.web.common.webcore.WebLogger;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author MateMaster
 * @since 2022/8/22
 */
public class StatisticsTest {

    @Test
    public void addUp() {
        List<DataFunnel> dataFunnelForTest = MockUtil.getDataFunnelForTest(200000);

        long now = System.currentTimeMillis();
        List<DataFunnel> sortedDataFunnel = dataFunnelForTest.stream().sorted(Comparator.comparing(DataFunnel::getDate).reversed()).collect(Collectors.toCollection(LinkedList::new));
        Map<String, DataFunnel> sumMap = sortedDataFunnel.parallelStream().collect(Collectors.groupingBy(DataFunnel::getDate, Collectors.collectingAndThen(Collectors.toList(), dataFunnels -> {
            DataFunnel dataFunnel = new DataFunnel();
            BigDecimal bigDecimal7 = new BigDecimal("0");
            BigDecimal bigDecimal8 = new BigDecimal("0");
            dataFunnel.setDate(dataFunnels.get(0).getDate());
            dataFunnel.setVar1(dataFunnels.stream().mapToInt(DataFunnel::getVar1).sum());
            dataFunnel.setVar2(dataFunnels.stream().mapToInt(DataFunnel::getVar2).sum());
            dataFunnel.setVar3(dataFunnels.stream().mapToInt(DataFunnel::getVar3).sum());
            dataFunnel.setVar4(dataFunnels.stream().mapToInt(DataFunnel::getVar4).sum());
            dataFunnel.setVar5(dataFunnels.stream().mapToInt(DataFunnel::getVar5).sum());
            dataFunnel.setVar6(dataFunnels.stream().mapToInt(DataFunnel::getVar6).sum());
            dataFunnel.setVar7(dataFunnels.stream().map(DataFunnel::getVar7).reduce(bigDecimal7, BigDecimal::add));
            dataFunnel.setVar8(dataFunnels.stream().map(DataFunnel::getVar8).reduce(bigDecimal8, BigDecimal::add));
            return dataFunnel;
        })));
        WebLogger.debug(System.currentTimeMillis() - now);

        now = System.currentTimeMillis();
        Map<String, Long> countMap = sortedDataFunnel.parallelStream().collect(Collectors.groupingBy(DataFunnel::getDate, Collectors.counting()));
        WebLogger.debug(System.currentTimeMillis() - now);

        now = System.currentTimeMillis();
        TreeSet<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.addAll(sumMap.keySet());
        int i = 0;
        for (String date : treeSet) {
            int count = Math.toIntExact(countMap.get(date)) + i;
            i = count + 1;
            sortedDataFunnel.add(count, sumMap.get(date));
        }
        WebLogger.debug(System.currentTimeMillis() - now);
    }
}
