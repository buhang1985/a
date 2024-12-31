package iih.bd.srv.medsrv.s.rule;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.s.rule.bp.DelIncCaItmRelBeforeDelAccSubRuleBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;
/**
 * 删除医疗服务前删除核算科目与收费项目的关联关系
 * 
 * @author shao_yuan
 *
 */

public class DelIncCaItmRelBeforeDelAccSubRule implements IRule<MedsrvAggDO>{

	@Override
	public void process(MedsrvAggDO... arg0) throws BizException {
		DelIncCaItmRelBeforeDelAccSubRuleBp bp = new DelIncCaItmRelBeforeDelAccSubRuleBp();
		bp.exec(arg0);
	}

}
