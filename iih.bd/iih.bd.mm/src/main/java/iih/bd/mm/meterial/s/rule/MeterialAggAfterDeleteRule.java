package iih.bd.mm.meterial.s.rule;

import iih.bd.mm.meterial.bp.MaterialDeAfterBp;
import iih.bd.mm.meterial.d.MeterialAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品基本信息删除后规则
 * 
 * @author hao_wu
 *
 */
public class MeterialAggAfterDeleteRule implements IRule<MeterialAggDO> {

	@Override
	public void process(MeterialAggDO... mmAggDOS) throws BizException {
		MaterialDeAfterBp bp = new MaterialDeAfterBp();

		bp.exec(mmAggDOS);
	}
}
