package iih.bd.srv.medusage.s.rule;

import iih.bd.srv.medusage.d.MedUsageDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 医疗用法更新前数据对照规则
 * 
 * @author hao_wu
 *
 */
public class MedUsageUpdateBeforeCompareRule implements ICompareRule<MedUsageDO> {

	@Override
	public void process(MedUsageDO[] newData, MedUsageDO[] oldData) throws BizException {
		ChangDataCheck(newData, oldData);
	}

	/**
	 * 医疗用法变更数据检查
	 * 
	 * @param newData
	 * @param oldData
	 * @throws BizException
	 */
	private void ChangDataCheck(MedUsageDO[] newData, MedUsageDO[] oldData) throws BizException {
		MedUsageChangDataCheckBp bp = new MedUsageChangDataCheckBp();
		bp.exec(newData, oldData);
	}

}
