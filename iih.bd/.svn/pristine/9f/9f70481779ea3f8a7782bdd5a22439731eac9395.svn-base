package iih.bd.mm.meterial.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.meterial.d.MeterialDO;
import xap.mw.coreitf.d.FDouble;

/**
 * 更新物品规格业务逻辑
 * 
 * @author hao_wu
 *
 */
public class UpdateMaterialSpecByMaterialsBp {

	public MeterialDO[] exec(MeterialDO[] materials) {
		if (materials == null) {
			return null;
		}

		for (MeterialDO meterialDO : materials) {
			updateMaterialSpec(meterialDO);
		}
		return materials;
	}

	/**
	 * 更新物品规格
	 * 
	 * @param meterialDO
	 */
	private void updateMaterialSpec(MeterialDO meterialDO) {
		if (meterialDO == null) {
			return;
		}
		String spec = buildSpec(meterialDO);
		meterialDO.setSpec(spec);
	}

	/**
	 * 构建规格
	 * 
	 * @param meterialDo
	 * @return
	 */
	private String buildSpec(MeterialDO meterialDo) {

		// 物品规格
		String spec = null;
		String specSub;
		// 重量+重量单位
		if (StringUtils.isNotBlank(meterialDo.getId_unit_weight())) {
			FDouble wbFac = meterialDo.getFactor_wb() == null ? new FDouble(0) : meterialDo.getFactor_wb();
			specSub = String.format("%s%s", wbFac, meterialDo.getWeight_name());
			spec = specSub;
		}

		// 体积+体积单位
		if (StringUtils.isNotBlank(meterialDo.getId_unit_volbase())) {
			FDouble vbFac = meterialDo.getFactor_vb() == null ? new FDouble(0) : meterialDo.getFactor_vb();
			specSub = String.format("%s%s", vbFac, meterialDo.getVolbase_name());
			if (meterialDo.getId_unit_volbase().equals(meterialDo.getId_unit_weight())) {
				spec = specSub;
			} else {
				spec = StringUtils.isBlank(spec) ? specSub : String.format("%s*%s", spec, specSub);
			}
		}

		// 零基系数+基本单位
		if (StringUtils.isNotBlank(meterialDo.getId_unit_pkgbase())) {
			if (meterialDo.getId_unit_pkgbase().equals(meterialDo.getId_unit_weight())) {
				FDouble wbFac = meterialDo.getFactor_wb() == null ? new FDouble(0) : meterialDo.getFactor_wb();
				specSub = String.format("%s%s", wbFac, meterialDo.getWeight_name());
				spec = spec.replace("*" + specSub, "").replace(specSub + "*", "").replace(specSub, "");
			}

			if (meterialDo.getId_unit_pkgbase().equals(meterialDo.getId_unit_volbase())) {
				FDouble vbFac = meterialDo.getFactor_vb() == null ? new FDouble(0) : meterialDo.getFactor_vb();
				specSub = String.format("%s%s", vbFac, meterialDo.getVolbase_name());
				spec = spec.replace("*" + specSub, "").replace(specSub + "*", "").replace(specSub, "");
			}

			FDouble sbFac = meterialDo.getFactor_sb() == null ? new FDouble(0) : meterialDo.getFactor_sb();
			specSub = String.format("%s%s", sbFac, meterialDo.getPkgbase_name());
			spec = StringUtils.isBlank(spec) ? specSub : String.format("%s*%s", spec, specSub);
		}

		if (StringUtils.isNotBlank(meterialDo.getId_unit_pkgsp())) {
			spec = String.format("%s/%s", spec, meterialDo.getPkgsp_name());
			if (meterialDo.getId_unit_pkgsp().equals(meterialDo.getId_unit_weight())) {
				FDouble wbFac = meterialDo.getFactor_wb() == null ? new FDouble(0) : meterialDo.getFactor_wb();
				specSub = String.format("%s%s", wbFac, meterialDo.getWeight_name());
				spec = spec.replace("*" + specSub, "").replace(specSub + "*", "").replace(specSub, "");
			}

			if (meterialDo.getId_unit_pkgsp().equals(meterialDo.getId_unit_volbase())) {
				FDouble vbFac = meterialDo.getFactor_vb() == null ? new FDouble(0) : meterialDo.getFactor_vb();
				specSub = String.format("%s%s", vbFac, meterialDo.getVolbase_name());
				spec = spec.replace("*" + specSub, "").replace(specSub + "*", "").replace(specSub, "");
			}

			if (meterialDo.getId_unit_pkgsp().equals(meterialDo.getId_unit_pkgbase())) {
				FDouble sbFac = meterialDo.getFactor_sb() == null ? new FDouble(0) : meterialDo.getFactor_sb();
				specSub = String.format("%s%s", sbFac, meterialDo.getPkgbase_name());
				spec = spec.replace("*" + specSub, "").replace(specSub + "*", "").replace(specSub, "");
			}

			if (spec.equals("/" + meterialDo.getPkgsp_name())) {
				spec = String.format("1%s", meterialDo.getPkgsp_name());
			}
		}
		return spec;
	}

}
