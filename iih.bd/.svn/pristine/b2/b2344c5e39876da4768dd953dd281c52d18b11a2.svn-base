package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;

/**
 * 同步医保数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SyncInsurDataBp {

	public void exec(String hpCode, String[] pks) throws BizException {
		String hpId = GetHpId(hpCode);
		SyncInsurDrugData(hpId, pks);
		SyncInsurZlData(hpId, pks);
		SyncInsurFwssData(hpId, pks);
	}

	/**
	 * 获取医保计划主键
	 * 
	 * @param hpCode
	 * @return
	 * @throws BizException
	 */
	private String GetHpId(String hpCode) throws BizException {
		FindHpDoByCodeBp bp = new FindHpDoByCodeBp();
		HPDO hpdo = bp.exec(hpCode);
		return hpdo.getId_hp();
	}

	/**
	 * 同步医保服务设施数据
	 * 
	 * @throws BizException
	 */
	private void SyncInsurFwssData(String hpId, String[] pks) throws BizException {
		SyncInsurFwssDataBp bp = new SyncInsurFwssDataBp();
		bp.exec(hpId, pks);
	}

	/**
	 * 同步医保诊疗信息
	 * 
	 * @throws BizException
	 */
	private void SyncInsurZlData(String hpId, String[] pks) throws BizException {
		SyncInsurZlDataBp bp = new SyncInsurZlDataBp();
		bp.exec(hpId, pks);
	}

	/**
	 * 同步医保药品信息
	 * 
	 * @throws BizException
	 */
	private void SyncInsurDrugData(String hpId, String[] pks) throws BizException {
		SyncInsurDrugDataBp bp = new SyncInsurDrugDataBp();
		bp.exec(hpId, pks);
	}
}
