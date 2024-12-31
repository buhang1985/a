package iih.bl.cg.service.s.bp;

import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.dto.orsrvguide.d.OrSrvGuideDTO;

/**
 * 设置服务换算率
 * 
 * @author yang.lu 2017年12月7日
 *
 */
public class SetSrvFactorBP {

	/**
	 * 传入服务数据计算换算率 与 开单天数（提供医保使用）
	 * 
	 * @param orSrvDtos
	 * @return
	 */
	public OrSrvGuideDTO[] exec(OrSrvGuideDTO[] orSrvDtos) {
		//校验
		if (orSrvDtos == null)
			return orSrvDtos;
		// 2017年8月17日 国际医院要求当前 传持有量天数与换算率 需要对应修改
		for (OrSrvGuideDTO orSrvGuideDTO : orSrvDtos) {
			if (orSrvGuideDTO == null)
				continue;
			FDouble facsb = orSrvGuideDTO.getFactor_sb();
			FDouble facmb = orSrvGuideDTO.getFactor_mb();
			// 开药天数
			Double days = Double.parseDouble((orSrvGuideDTO.getDays() == null ? orSrvGuideDTO.getQuan_total_medu().toString() : orSrvGuideDTO.getDays()));
			// 持有量天数
			Double daysava = (orSrvGuideDTO.getDays_available() == null ? 0 : Double.parseDouble(orSrvGuideDTO.getDays_available()));
			// 频次周期下次数
			Double freq = orSrvGuideDTO.getFreqct() == null ? 0 : Double.parseDouble(orSrvGuideDTO.getFreqct().toString());
			// 单次用量
			Double dosage = Double.parseDouble(orSrvGuideDTO.getDosage());
			// 数量
			Double quan = Double.parseDouble(orSrvGuideDTO.getQuan_total_medu().toString());

			// 默认为 ：换算率=零基换算率*药基换算率；
			if (facsb != null && facmb != null)
				orSrvGuideDTO.setFactor(facsb.multiply(facmb));
			// 门诊取整模式为按次取整
			if (IBdMmDictCodeConst.SD_MUPKGUTP_TIMES.equals(orSrvGuideDTO.getSd_opmutp())) {
				if (!StringUtil.isEmpty(orSrvGuideDTO.getDays()) && !StringUtil.isEmpty(orSrvGuideDTO.getDays_available()) && !StringUtil.isEmpty(orSrvGuideDTO.getDosage())) {
					// 持有量天数与开单量天数差额相差1天以上时
					if ((daysava - days) > 1) {
						// 中药饮片及颗粒：
						if (IBdMmDictCodeConst.SD_MMTP_DRUG_CHIHE.equals(orSrvGuideDTO.getSd_mmtp())) {
							// 换算率=用药天数×单次用量/数量。
							orSrvGuideDTO.setFactor(new FDouble(((days * dosage) / quan) + ""));
						}
						// 其他药品：
						else {
							// 换算率=用药天数×（单次用量×频次）/数量。
							if (dosage > 0)
								orSrvGuideDTO.setFactor(new FDouble((dosage * freq * days / quan) + ""));
						}
					}
					// 按此取整没有一天以上差值 换算率公式
					else {
						// 换算率=用药天数×（单次用量×频次）/数量。
						if (dosage > 0)
							orSrvGuideDTO.setFactor(new FDouble((dosage * freq * days / quan) + ""));
					}

				}
			} else {
				orSrvGuideDTO.setDays(orSrvGuideDTO.getDays_available());
			}
		}

		return orSrvDtos;
	}
}
