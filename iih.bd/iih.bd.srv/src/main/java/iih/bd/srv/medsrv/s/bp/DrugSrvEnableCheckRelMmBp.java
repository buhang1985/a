package iih.bd.srv.medsrv.s.bp;

import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdMmParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药品服务启用检查关联物品业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DrugSrvEnableCheckRelMmBp {

	public void exec(MedSrvDO medsrvDo) throws BizException {
		if (medsrvDo == null) {
			return;
		}

		CheckRelMm(medsrvDo);
	}

	/**
	 * 检查关联物品
	 * 
	 * @param medsrvDo
	 * @throws BizException
	 */
	private void CheckRelMm(MedSrvDO medsrvDo) throws BizException {
		MeterialDO[] materialArray = GetRelMaterialArray(medsrvDo);
		if (materialArray == null || materialArray.length <= 0) {
			String msg = String.format("医疗服务\"%s\"关联物品中不存在已启用的物品，不能启用。", medsrvDo.getName());
			throw new BizException(msg);
		}

		CheckRelMmData(materialArray, medsrvDo);
	}

	/**
	 * 检查关联物品数据完整性
	 * 
	 * @param materialArray
	 * @throws BizException
	 */
	private void CheckRelMmData(MeterialDO[] materialArray, MedSrvDO medsrvDo) throws BizException {
		if (materialArray == null || materialArray.length <= 0) {
			return;
		}

		String drugMCPropMM = BdMmParamUtils.GetDrugMCPropMM();

		for (MeterialDO meterialDO : materialArray) {
			CheckRelMmData(meterialDO, medsrvDo, drugMCPropMM);
		}
	}

	/**
	 * 检查关联物品数据完整性
	 * 
	 * @param meterialDO
	 * @throws BizException
	 */
	private void CheckRelMmData(MeterialDO meterialDO, MedSrvDO medsrvDo, String drugMCPropMM) throws BizException {
		String msg = String.format("医疗服务\"%s\"关联药品\"%s\"中", medsrvDo.getName(), meterialDO.getName());
		if (StringUtil.isEmpty(meterialDO.getSpec())) {
			msg = String.format("%s规格为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(meterialDO.getId_unit_pkgbase())) {
			msg = String.format("%s基本包装单位为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(meterialDO.getName_unit_pkgbase())) {
			msg = String.format("%s基本包装单位名称为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(meterialDO.getId_unit_pkgsp())) {
			msg = String.format("%s零售包装单位为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(meterialDO.getName_unit_pkgsp())) {
			msg = String.format("%s零售包装单位名称为空。", msg);
			throw new BizException(msg);
		}
		if (meterialDO.getFactor_sb() == null || meterialDO.getFactor_sb().toDouble() <= 0) {
			msg = String.format("%s换算系数（零基）为空。", msg);
			throw new BizException(msg);
		}
		if (meterialDO.getFactor_mb() == null || meterialDO.getFactor_mb().toDouble() <= 0) {
			msg = String.format("%s空换算系数（医基）为空。", msg);
			throw new BizException(msg);
		}
		if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM)
				&& StringUtil.isEmpty(meterialDO.getSrv_id_unit_med())) {
			msg = String.format("%s医学单位为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(meterialDO.getId_mupkgutp())) {
			msg = String.format("%s包装单位住院取整模式为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(meterialDO.getSd_mupkgutp())) {
			msg = String.format("%s包装单位住院取整模式编码为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(meterialDO.getId_opmutp())) {
			msg = String.format("%s包装单位门诊取整模式为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(meterialDO.getSd_opmutp())) {
			msg = String.format("%s包装单位门诊取整模式编码为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(meterialDO.getId_unit_weight())) {
			if (StringUtil.isEmpty(meterialDO.getId_unit_volbase())) {
				// throw new BizException("关联物品重量和体积不能同时为空"); // --
				// 暂时屏蔽规则（保证医学单位、零售单位、基本包装单位以及转换系数不为空即可）
			} else {
				if (meterialDO.getFactor_vb() == null || meterialDO.getFactor_vb().toDouble() <= 0) {
					msg = String.format("%s换算系数（体基）为空。", msg);
					throw new BizException(msg);
				}
			}
		} else {
			if (meterialDO.getFactor_wb() == null || meterialDO.getFactor_wb().toDouble() <= 0) {
				msg = String.format("%s换算系数（重量）为空。", msg);
				throw new BizException(msg);
			}
		}
		if (meterialDO.getFg_skin() == null) {
			msg = String.format("%s皮试标志为空。", msg);
			throw new BizException(msg);
		} else {
			if (meterialDO.getFg_skin() != null && meterialDO.getFg_skin() == FBoolean.TRUE) {
				if (StringUtil.isEmpty(meterialDO.getId_skinca())) {
					msg = String.format("%s皮试类型为空。", msg);
					throw new BizException(msg);
				}
				if (StringUtil.isEmpty(meterialDO.getSd_skinca())) {
					msg = String.format("%s皮试类型编码为空。", msg);
					throw new BizException(msg);
				}
				switch (meterialDO.getSd_skinca()) {
				case "0"://诊疗皮试
					if (StringUtil.isEmpty(meterialDO.getId_srvskin())) {
						msg = String.format("%s物品皮试项目为空。", msg);
						throw new BizException(msg);
					}
					break;
				case "1"://原液皮试
					if (StringUtil.isEmpty(meterialDO.getId_mmskin())) {
						msg = String.format("%s物品皮试药品为空。", msg);
						throw new BizException(msg);
					}
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * 获取已启用关联物品列表
	 * 
	 * @param medsrvDo
	 * @return
	 * @throws BizException
	 */
	private MeterialDO[] GetRelMaterialArray(MedSrvDO medsrvDo) throws BizException {
		IMeterialMDORService meterialMDORService = ServiceFinder.find(IMeterialMDORService.class);
		String whereStr = String.format("fg_active = 'Y' AND id_srv = '%s'", medsrvDo.getId_srv());
		MeterialDO[] materialArray = meterialMDORService.find(whereStr, "id_srv", FBoolean.FALSE);
		return materialArray;
	}
}
