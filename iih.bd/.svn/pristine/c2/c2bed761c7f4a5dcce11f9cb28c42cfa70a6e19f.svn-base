package iih.bd.pp.anhuisrvorca.s.bp;

import xap.mw.core.data.BizException;

/**
 * 安徽医保_三大目录自动对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class AutoCompBp {

	public void exec(String hpCode) throws BizException {
		AutoCompDrug(hpCode);
		AutoCompFwss(hpCode);
		AutoCompTreat(hpCode);
	}

	/**
	 * 自动药品对照
	 * 
	 * @throws BizException
	 */
	private void AutoCompDrug(String hpCode) throws BizException {
		AutoCompDrugBp bp = new AutoCompDrugBp();
		bp.exec(hpCode);
	}

	/**
	 * 自动诊疗对照
	 * 
	 * @throws BizException
	 */
	private void AutoCompTreat(String hpCode) throws BizException {
		AutoCompTreatBp bp = new AutoCompTreatBp();
		bp.exec(hpCode);
	}

	/**
	 * 自动服务设施对照
	 * 
	 * @throws BizException
	 */
	private void AutoCompFwss(String hpCode) throws BizException {
		AutoCompFwssBp bp = new AutoCompFwssBp();
		bp.exec(hpCode);
	}
}
