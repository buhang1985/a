package iih.bd.mm.intelcabinet.s.rule;

import iih.bd.mm.intelcabinet.d.IntelCabinetDO;
import iih.bd.mm.intelcabinet.s.bp.IntelCabiCuAfterBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 智能柜插入和更新前规则
 * 
 * @author hao_wu
 *
 */
public class IntelCabinetAfterInsertOrUpdateRule implements IRule<IntelCabinetDO> {

	@Override
	public void process(IntelCabinetDO... intelCabinetDOS) throws BizException {
		IntelCabiCuAfterBp bp = new IntelCabiCuAfterBp();

		bp.exec(intelCabinetDOS);
	}

}
