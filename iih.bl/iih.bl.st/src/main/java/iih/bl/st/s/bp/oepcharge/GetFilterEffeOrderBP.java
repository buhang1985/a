package iih.bl.st.s.bp.oepcharge;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.params.BlParams;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import java.util.ArrayList;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;

/**
 * 根据参数过滤待缴费医嘱数据
 * @author liming06
 * @since 2020-06-03
 *
 */
public class GetFilterEffeOrderBP {
	// 药品
	FDateTime drugTime;
	// 检查
	FDateTime risTime;
	// 检验
	FDateTime lisTime;
	// 诊疗
	FDateTime treatTime;

	public GetFilterEffeOrderBP() throws BizException {
		FDateTime fdEndTime = AppUtils.getServerDateTime();
		// 药品
		drugTime = DateTimeUtils.getDateTimeBefore(fdEndTime, BlParams.BLSTOEP0009());
		// 检查
		risTime = DateTimeUtils.getDateTimeBefore(fdEndTime, BlParams.BLSTOEP0010());
		// 检验
		lisTime = DateTimeUtils.getDateTimeBefore(fdEndTime, BlParams.BLSTOEP0011());
		// 诊疗
		treatTime = DateTimeUtils.getDateTimeBefore(fdEndTime, BlParams.BLSTOEP0012());

	}
	
	/**
	 * 获取调入医嘱是否符合调入条件
	 * 
	 * @param presdto
	 * @return
	 */
	public BlOepChargeInputDTO[] getImputEffeData(BlOepChargeInputDTO[] orDtos) {
		List<BlOepChargeInputDTO> retList = new ArrayList<BlOepChargeInputDTO>();
		if (!ArrayUtil.isEmpty(orDtos)) {
			for (BlOepChargeInputDTO dto : orDtos) {
				if (effeOrByTpAndDt(dto.getPrntype(), dto.getDt_sign())) {
					retList.add(dto);
				}
			}
		}
		return retList.toArray(new BlOepChargeInputDTO[]{});
	}
	
	/**
	 * 校验医嘱类型与开单日期是否符合调入条件
	 * 
	 * @param typestr
	 * @param dt_sign
	 * @return
	 */
	private boolean effeOrByTpAndDt(String typestr, FDateTime dt_sign) {
		if (!StringUtil.isEmptyWithTrim(typestr)) {
			if (typestr.startsWith(IBdSrvDictCodeConst.DRUG_TYPE)) {
				// 药品类
				if (drugTime.after(dt_sign)) {
					return false;
				}
			}
			if (typestr.startsWith(IBdSrvDictCodeConst.RIS_TYPE) || typestr.startsWith(IBdSrvDictCodeConst.PATHGY_TYPE)) {
				// 检查类
				if (risTime.after(dt_sign)) {
					return false;
				}
			}
			if (typestr.startsWith(IBdSrvDictCodeConst.LIS_TYPE)) {
				// 检验类
				if (lisTime.after(dt_sign)) {
					return false;
				}
			}
			if (typestr.startsWith(IBdSrvDictCodeConst.TREATMENT_TYPE)) {
				// 治疗类
				if (treatTime.after(dt_sign)) {
					return false;
				}
			}
			return true;
		}
		return true;
	}
}
