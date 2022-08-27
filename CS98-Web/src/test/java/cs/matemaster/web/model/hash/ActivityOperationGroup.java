package cs.matemaster.web.model.hash;

import com.google.common.base.Charsets;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import lombok.Data;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/27
 */
@Data
public class ActivityOperationGroup {

    private int rank;

    private ActOprMember leader;

    private List<ActOprMember> members;

    public enum FunnelEnum implements Funnel<Object> {
        MEMBER {
            @Override
            public void funnel(Object arg, PrimitiveSink primitiveSink) {
                List<ActOprMember> actOprMembers = (List<ActOprMember>) arg;
                actOprMembers.forEach(actOprMember -> primitiveSink
                        .putString(actOprMember.getCode(), Charsets.UTF_8)
                        .putString(actOprMember.getName(), Charsets.UTF_8)
                );
            }
        },

        LEADER {
            @Override
            public void funnel(Object arg, PrimitiveSink primitiveSink) {
                ActOprMember actOprMember = (ActOprMember) arg;
                primitiveSink
                        .putString(actOprMember.getCode(), Charsets.UTF_8)
                        .putString(actOprMember.getName(), Charsets.UTF_8);
            }
        }
    }
}
