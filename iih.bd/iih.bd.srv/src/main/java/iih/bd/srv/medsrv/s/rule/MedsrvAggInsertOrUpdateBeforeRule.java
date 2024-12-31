package iih.bd.srv.medsrv.s.rule;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.s.rule.bp.MedsrvAggInsertOrUpdateBeforeRuleBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 医疗服务插入或更新前规则
 * 
 * @author hao_wu
 *
 */
public class MedsrvAggInsertOrUpdateBeforeRule implements IRule<MedsrvAggDO> {

	@Override
	public void process(MedsrvAggDO... arg0) throws BizException {
		MedsrvAggInsertOrUpdateBeforeRuleBp bp = new MedsrvAggInsertOrUpdateBeforeRuleBp();
		bp.exec(arg0);
	}
}
