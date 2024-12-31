package iih.mi.inst.bizgrp.tonglingcity.bp;

import xap.mw.core.data.BizException;

/**
 * 自动对照诊疗和服务设施业务逻辑
 * 
 * @author hao_wu
 *
 */
public class AutoCompTreatAndSrvfacBp {

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
		AutoCompSrvfacBp bp = new AutoCompSrvfacBp();
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
