package iih.bd.srv.medsrv.s.rule;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.s.rule.bp.MedSrvInsertOrUpdateBeforeRuleBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 医疗服务插入或更新前规则
 * 
 * @author hao_wu
 *
 */
public class MedSrvInsertOrUpdateBeforeRule implements IRule<MedSrvDO> {

	@Override
	public void process(MedSrvDO... arg0) throws BizException {
		MedSrvInsertOrUpdateBeforeRuleBp bp = new MedSrvInsertOrUpdateBeforeRuleBp();
		bp.exec(arg0);
	}
}
