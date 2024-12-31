package iih.bd.pp.hpsrvorca.bp;

import java.math.RoundingMode;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpIndicationRuleEnum;
import iih.bd.pp.hpsrvorca.d.ImportDTO;
import iih.bd.pp.hpsrvorca.d.ImportResultEnum;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;

/**
 * HPSrvorcaDO 适配器
 * 
 * @author hao_wu
 * 
 */
public class HPSrvorcaDOAdapter {

	/**
	 * 适配医保计划对照信息
	 * 
	 * @param token
	 * @param fg_drug
	 * @return
	 */
	public HPSrvorcaDO GetHPSrvorcaDO(String token, Boolean fg_drug, ImportDTO importDTO) {
		if (fg_drug) {
			return GetHPSrvorcaDO_Drug(token, importDTO);
		} else {
			return GetHPSrvorcaDO_Treat(token, importDTO);
		}
	}

	/**
	 * 获取诊疗对照
	 * 
	 * @param token
	 * @return
	 */
	private HPSrvorcaDO GetHPSrvorcaDO_Treat(String token, ImportDTO importDTO) {
		String[] strItemCataArr = token.split("\\|");
		if (strItemCataArr.length < 8 || strItemCataArr.length > 9) {
			importDTO.setResult(ImportResultEnum.IMPORTDATAERROR);
			return null;
		}

		HPSrvorcaDO hpSrvorcaDO = new HPSrvorcaDO();
		hpSrvorcaDO.setStatus(DOStatus.NEW);
		hpSrvorcaDO.setId_grp(Context.get().getGroupId());
		hpSrvorcaDO.setId_org(Context.get().getOrgId());
		hpSrvorcaDO.setEu_hpsrvctrtp(HpIndicationRuleEnum.NO_CONTROL);

		// HIS编码
		hpSrvorcaDO.setHis_code(strItemCataArr[0]);
		// HIS名称
		hpSrvorcaDO.setHis_name(strItemCataArr[1]);
		// 医保编码
		hpSrvorcaDO.setCode(strItemCataArr[2]);
		// 医保名称
		hpSrvorcaDO.setName(strItemCataArr[3]);
		// 物品基本包装单位
		hpSrvorcaDO.setMm_unit_pkgbase(strItemCataArr[4]);
		// 物品零售价
		hpSrvorcaDO.setMm_price(new FDouble(strItemCataArr[5]));
		// 收费等级
		hpSrvorcaDO.setSd_hpsrvtp(strItemCataArr[6]);
		// 收费类别
		hpSrvorcaDO.setCode_ca(strItemCataArr[7]);
		if (strItemCataArr.length >= 9) {
			// 备注
			hpSrvorcaDO.setDes(strItemCataArr[8]);
		}
		return hpSrvorcaDO;
	}

	/**
	 * 获取药品对照
	 * 
	 * @param token
	 * @return
	 */
	private HPSrvorcaDO GetHPSrvorcaDO_Drug(String token, ImportDTO importDTO) {
		String[] strItemCataArr = token.split("\\|");
		if (strItemCataArr.length < 10 || strItemCataArr.length > 11) {
			importDTO.setResult(ImportResultEnum.IMPORTDATAERROR);
			return null;
		}
		HPSrvorcaDO hpSrvorcaDO = new HPSrvorcaDO();
		hpSrvorcaDO.setStatus(DOStatus.NEW);
		hpSrvorcaDO.setId_grp(Context.get().getGroupId());
		hpSrvorcaDO.setId_org(Context.get().getOrgId());
		hpSrvorcaDO.setEu_hpsrvctrtp(HpIndicationRuleEnum.NO_CONTROL);
		if (strItemCataArr[1] != "中药饮片及药材") {
			// HIS药品编码
			hpSrvorcaDO.setHis_code(strItemCataArr[0]);
			// HIS药品名称
			hpSrvorcaDO.setHis_name(strItemCataArr[1]);
			// 医保药品编码
			hpSrvorcaDO.setCode(strItemCataArr[2]);
			// 医保药品名称
			hpSrvorcaDO.setName(strItemCataArr[3]);
			// 医保剂型编码
			hpSrvorcaDO.setCode_dosage(strItemCataArr[4]);
			// 药品规格
			hpSrvorcaDO.setMm_spec(strItemCataArr[5]);
			// 药品基本包装单位
			hpSrvorcaDO.setMm_unit_pkgbase(strItemCataArr[6]);
			// 药品零售价
			hpSrvorcaDO.setMm_price(new FDouble(strItemCataArr[7]));
			// 收费等级
			hpSrvorcaDO.setSd_hpsrvtp(strItemCataArr[8]);
			// 收费类别
			hpSrvorcaDO.setCode_ca(strItemCataArr[9]);
		} else {

			// HIS药品编码
			hpSrvorcaDO.setHis_code(strItemCataArr[0]);
			// HIS药品名称
			hpSrvorcaDO.setHis_name(strItemCataArr[5]);
			// 医保药品编码
			hpSrvorcaDO.setCode(strItemCataArr[2]);
			// 医保药品名称
			hpSrvorcaDO.setName(strItemCataArr[5]);
			// 医保剂型编码
			hpSrvorcaDO.setCode_dosage(strItemCataArr[4]);
			// 药品规格
			hpSrvorcaDO.setMm_spec(strItemCataArr[1]);
			// 药品基本包装单位
			hpSrvorcaDO.setMm_unit_pkgbase(strItemCataArr[6]);
			// 药品零售价
			hpSrvorcaDO.setMm_price(new FDouble(strItemCataArr[7]));
			// 收费等级
			hpSrvorcaDO.setSd_hpsrvtp(strItemCataArr[8]);
			// 收费类别
			hpSrvorcaDO.setCode_ca(strItemCataArr[9]);
		}
		if (strItemCataArr.length >= 11) {// 备注
			hpSrvorcaDO.setDes(strItemCataArr[10]);
		}
		return hpSrvorcaDO;
	}

	/**
	 * 序列化医保目录对照导出数据
	 * 
	 * @param hpSrvorcaDO
	 *            医保目录对照数据
	 * @param fg_drug
	 *            是否是药品信息导出
	 * @return 序列化后的导出信息
	 */
	public String serialization(HPSrvorcaDO hpSrvorcaDO, Boolean fg_drug) {
		if (fg_drug) {
			return serialization_Drug(hpSrvorcaDO);
		} else {
			return serialization_Treat(hpSrvorcaDO);
		}
	}

	public String serialization_Drug(HPSrvorcaDO hpSrvorcaDO) {
		if (hpSrvorcaDO.getSd_hpsrvtp().startsWith("0103")) {
			return String.format("%s|中药饮片及药材|%s|%s|%s|%s",
					hpSrvorcaDO.getHis_code() == null ? "" : hpSrvorcaDO.getHis_code(),
					hpSrvorcaDO.getCode() == null ? "" : hpSrvorcaDO.getCode(),
					hpSrvorcaDO.getHis_name() == null ? "" : hpSrvorcaDO.getHis_name(),
					hpSrvorcaDO.getMm_unit_pkgbase() == null ? "" : hpSrvorcaDO.getMm_unit_pkgbase(),
					hpSrvorcaDO.getMm_price() == null ? ""
							: hpSrvorcaDO.getMm_price().setScale(4, RoundingMode.HALF_UP.ordinal()).toString());
		}
		return String.format("%s|%s|%s|%s|%s|%s", hpSrvorcaDO.getHis_code() == null ? "" : hpSrvorcaDO.getHis_code(),
				hpSrvorcaDO.getHis_name() == null ? "" : hpSrvorcaDO.getHis_name(),
				hpSrvorcaDO.getCode() == null ? "" : hpSrvorcaDO.getCode(),
				hpSrvorcaDO.getMm_spec() == null ? "" : hpSrvorcaDO.getMm_spec(),
				hpSrvorcaDO.getMm_unit_pkgbase() == null ? "" : hpSrvorcaDO.getMm_unit_pkgbase(),
				hpSrvorcaDO.getMm_price() == null ? ""
						: hpSrvorcaDO.getMm_price().setScale(4, RoundingMode.HALF_UP.ordinal()).toString());
	}

	public String serialization_Treat(HPSrvorcaDO hpSrvorcaDO) {
		String serialString = String.format("%s|%s|%s|%s|%s",
				hpSrvorcaDO.getHis_code() == null ? "" : hpSrvorcaDO.getHis_code(),
				hpSrvorcaDO.getHis_name() == null ? "" : hpSrvorcaDO.getHis_name(),
				hpSrvorcaDO.getCode() == null ? "" : hpSrvorcaDO.getCode(), "", "");
		return serialString;
	}

	// /**
	// * 当使用物品code时进行适配
	// *
	// * @param token
	// * @param meterialDOArray
	// * 物品信息列表
	// * @return
	// */
	// public HPSrvorcaDO GetHPSrvorcaDO(String token, ImportDTO importDTO,
	// MeterialDO[] meterialDOArray) {
	// HPSrvorcaDO hpSrvorcaDO = GetHPSrvorcaDO(token, true, importDTO);
	// if (hpSrvorcaDO == null)
	// return null;
	// MeterialDO meterialDO = GetMeterialDoByCode(meterialDOArray,
	// hpSrvorcaDO.getSrv_code());
	// if (meterialDO == null) {
	// importDTO.setResult(ImportResultEnum.MMNOTFOUND);
	// hpSrvorcaDO.setSrv_code(null);
	// return null;
	// }
	// hpSrvorcaDO.setSrv_code(meterialDO.getSrv_code());
	// return hpSrvorcaDO;
	// }
	//
	// /**
	// * 通过物品ID查找物品信息
	// *
	// * @param meterialDOArray
	// * 物品信息列表
	// * @param mmCode
	// * 物品编码
	// * @return 物品信息
	// */
	// private MeterialDO GetMeterialDoByCode(MeterialDO[] meterialDOArray,
	// String mmCode) {
	// for (MeterialDO meterialDO : meterialDOArray) {
	// if (meterialDO.getCode() != null && meterialDO.getCode().equals(mmCode))
	// return meterialDO;
	// }
	// return null;
	// }
}
