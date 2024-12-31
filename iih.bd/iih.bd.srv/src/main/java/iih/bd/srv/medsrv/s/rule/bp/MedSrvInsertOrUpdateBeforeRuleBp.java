package iih.bd.srv.medsrv.s.rule.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医疗服务插入或更新前规则业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedSrvInsertOrUpdateBeforeRuleBp {

	public void exec(MedSrvDO[] medSrvArr) throws BizException {
		if (medSrvArr == null || medSrvArr.length <= 0) {
			return;
		}

		CheckNameUnique(medSrvArr);
		CheckSetOrd(medSrvArr);
		CheckUnitMed(medSrvArr);
		CheckRout(medSrvArr);
	}

	/**
	 * 检查默认用量单位
	 * 
	 * @param medsrvDoArray
	 * @throws BizException
	 */
	private void CheckUnitMed(MedSrvDO[] medsrvDoArray) throws BizException {
		CheckUnitMedBp bp = new CheckUnitMedBp();
		bp.exec(medsrvDoArray);
	}

	/**
	 * 检查服务套开立方式
	 * 
	 * @param medSrvArr
	 * @return
	 * @throws BizException
	 */
	private void CheckSetOrd(MedSrvDO[] medSrvArr) throws BizException {
		if (medSrvArr == null || medSrvArr.length <= 0) {
			return;
		}
		for (MedSrvDO medSrvDO : medSrvArr) {
			CheckSetOrd(medSrvDO);
		}
	}

	/**
	 * 检查服务套开立方式
	 * 
	 * @param medSrvDO
	 * @return
	 * @return
	 * @throws BizException
	 */
	private void CheckSetOrd(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO != null && medSrvDO.getFg_set() != null && medSrvDO.getFg_set().equals(FBoolean.TRUE)
				&& medSrvDO.getId_setord() == null) {
			String msg = String.format("医疗服务\"%s\"是服务套，服务套开立方式不允许为空。", medSrvDO.getName());
			throw new BizException(msg);
		}
	}

	/**
	 * 检查医疗服务名称唯一性
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void CheckNameUnique(MedSrvDO[] medSrvArr) throws BizException {
		CheckNameUniqueBp bp = new CheckNameUniqueBp();
		bp.exec(medSrvArr);
	}

	/**
	 * 检查用法是否符合剂型
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void CheckRout(MedSrvDO[] medSrvArr) throws BizException {
		MedSrvDrugCheckRoutBp bp = new MedSrvDrugCheckRoutBp();
		// MedSrvEnableValidateBp enableValidateBp = new
		// MedSrvEnableValidateBp();
		for (MedSrvDO medSrvDO : medSrvArr) {
			bp.exec(null, medSrvDO);
			// enableValidateBp.exec(medSrvDO);
		}
	}
}
