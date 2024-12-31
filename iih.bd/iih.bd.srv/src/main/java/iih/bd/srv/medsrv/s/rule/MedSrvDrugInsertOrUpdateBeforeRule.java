package iih.bd.srv.medsrv.s.rule;

import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.s.rule.bp.MedSrvDrugInsertOrUpdateBeforeRuleBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 医疗服务药品属性插入或更新前规则
 * 
 * @author hao_wu
 *
 */
public class MedSrvDrugInsertOrUpdateBeforeRule implements IRule<MedSrvDrugDO> {

	@Override
	public void process(MedSrvDrugDO... arg0) throws BizException {
		MedSrvDrugInsertOrUpdateBeforeRuleBp bp = new MedSrvDrugInsertOrUpdateBeforeRuleBp();
		bp.exec(arg0);
	}
}
