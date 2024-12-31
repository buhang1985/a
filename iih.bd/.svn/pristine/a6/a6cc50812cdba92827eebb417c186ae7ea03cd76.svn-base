package iih.bd.srv.mrtplseg.s.rule;

import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.s.rule.bp.DelStreamWithSegmentBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 删除片段模板前删除模板内容规则
 * 
 * @author hao_wu
 *
 */
public class DelStreamBeforeDelSegmentRule implements IRule<MrTplSegmentDO> {

	@Override
	public void process(MrTplSegmentDO... mrTplSegmentArray) throws BizException {
		if (mrTplSegmentArray == null || mrTplSegmentArray.length <= 0) {
			return;
		}
		DelStreamWithSegmentBp bp = new DelStreamWithSegmentBp();
		bp.exec(mrTplSegmentArray);
	}
}
