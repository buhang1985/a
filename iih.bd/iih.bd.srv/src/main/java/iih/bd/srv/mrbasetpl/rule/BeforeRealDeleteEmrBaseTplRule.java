package iih.bd.srv.mrbasetpl.rule;

import iih.bd.srv.mrbasetpl.bp.RealDeleteFsBp;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 医疗记录基础模板真删除前规则
 * 
 * @author hao_wu
 *
 */
public class BeforeRealDeleteEmrBaseTplRule implements IRule<EmrBaseTplDO> {

	@Override
	public void process(EmrBaseTplDO... arg0) throws BizException {

		RealDeleteFsBp bp = new RealDeleteFsBp();

		for (EmrBaseTplDO emrBaseTplDO : arg0) {
			bp.exec(emrBaseTplDO);
		}
	}

}
