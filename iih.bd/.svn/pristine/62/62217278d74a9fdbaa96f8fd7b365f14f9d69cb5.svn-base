package iih.bd.pp.anhuisrvorca.s.bp;

import xap.mw.core.data.BizException;

/**
 * 自动对照诊疗和服务设施业务逻辑
 * 
 * @author hao_wu
 *
 */
public class AutoCompTreatAndFwssBp {

	public void exec(String hpCode) throws BizException {
		AutoCompFwss(hpCode);
		AutoCompTreat(hpCode);
	}

	/**
	 * 自动对照诊疗
	 * 
	 * @throws BizException
	 */
	private void AutoCompFwss(String hpCode) throws BizException {
		AutoCompFwssBp bp = new AutoCompFwssBp();
		bp.exec(hpCode);
	}

	/**
	 * 自动对照服务设施
	 * 
	 * @throws BizException
	 */
	private void AutoCompTreat(String hpCode) throws BizException {
		AutoCompTreatBp bp = new AutoCompTreatBp();
		bp.exec(hpCode);
	}
}
