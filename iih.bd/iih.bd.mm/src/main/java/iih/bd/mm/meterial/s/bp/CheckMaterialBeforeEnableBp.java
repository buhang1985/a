package iih.bd.mm.meterial.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.utils.BdMmParamUtils;
import xap.mw.core.data.BizException;

/**
 * 启用前检查物品信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CheckMaterialBeforeEnableBp {

	public void exec(MeterialDO[] materials) throws BizException {
		if (materials == null || materials.length <= 0) {
			return;
		}

		CheckMaterial(materials);
	}

	/**
	 * 检查物品信息
	 * 
	 * @param materials
	 * @throws BizException
	 */
	private void CheckMaterial(MeterialDO[] materials) throws BizException {
		CheckNotNullProp(materials);
	}

	/**
	 * 检查不可空属性
	 * 
	 * @param materials
	 * @throws BizException
	 */
	private void CheckNotNullProp(MeterialDO[] materials) throws BizException {
		String drugMediPropManageMode = BdMmParamUtils.GetDrugMCPropMM();
		for (MeterialDO meterialDO : materials) {
			CheckNotNullProp(meterialDO, drugMediPropManageMode);
		}
	}

	/**
	 * 检查不可空属性
	 * 
	 * @param meterialDO
	 * @param drugMediPropManageMode
	 *            药品用药属性管理模式
	 * @throws BizException
	 */
	private void CheckNotNullProp(MeterialDO meterialDO, String drugMediPropManageMode) throws BizException {
		if (meterialDO.getSd_mmtp().startsWith(IBdMmDictCodeConst.SD_MMTP_DRUG)) {
			CheckDrugNotNullProp(meterialDO, drugMediPropManageMode);
		}
	}

	/**
	 * 检查药品非空属性
	 * 
	 * @param meterialDO
	 * @param drugMediPropManageMode
	 *            药品用药属性管理模式
	 * @throws BizException
	 */
	private void CheckDrugNotNullProp(MeterialDO meterialDO, String drugMediPropManageMode) throws BizException {
		if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugMediPropManageMode)) {
			if (StringUtils.isEmpty(meterialDO.getId_freq())) {
				String msg = String.format("药品\"%s\"频次不允许为空。", meterialDO.getName());
				throw new BizException(msg);
			}
		}
	}
}
