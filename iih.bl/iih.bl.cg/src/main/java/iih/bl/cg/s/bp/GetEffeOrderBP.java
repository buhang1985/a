package iih.bl.cg.s.bp;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.hp.viewmziihypshare.d.ViewMzIihYpShareDTO;
import iih.bl.params.BlParams;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;

public class GetEffeOrderBP {
	// 药品
	FDateTime drugTime;
	// 检查
	FDateTime risTime;
	// 检验
	FDateTime lisTime;
	// 诊疗
	FDateTime treatTime;

	public GetEffeOrderBP() throws BizException {
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
	 * chis共享数据过滤
	 * 
	 * @param dtos
	 * @return
	 */
	public ViewMzIihYpShareDTO[] getChisEffeData(ViewMzIihYpShareDTO[] dtos) {
		ArrayList<ViewMzIihYpShareDTO> list = new ArrayList<ViewMzIihYpShareDTO>();
		if (dtos != null && dtos.length > 0) {
			for (ViewMzIihYpShareDTO viewMzIihYpShareDTO : dtos) {
				if (ICiDictCodeConst.SD_SU_BL_NONE.equals(viewMzIihYpShareDTO.getSd_su_bl()) && effeOrByTpAndDt(IBdSrvDictCodeConst.DRUG_TYPE, viewMzIihYpShareDTO.getHappen_date())) {
					list.add(viewMzIihYpShareDTO);
				}
			}
		}
		return list.toArray(new ViewMzIihYpShareDTO[list.size()]);
	}

	/**
	 * 开单校验数据过滤
	 * 
	 * @param list
	 *            HpQryCiorderDTO
	 * @return
	 */
	public FArrayList2 getRuleEffeData(FArrayList2 list) {
		FArrayList2 retList = new FArrayList2();
		if (list != null && list.size() > 0) {
			for (Object object : list) {
				HpQryCiorderDTO cior = (HpQryCiorderDTO) object;
				FDateTime dtEffe = cior.getCiorderdo().getDt_effe();
				boolean isAdd = true;
				if (ICiDictCodeConst.SD_SU_BL_NONE.equals(cior.getCiorderdo().getSd_su_bl())) {
					if (cior.getCiorderdo().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
						isAdd = effeOrByTpAndDt(IBdSrvDictCodeConst.DRUG_TYPE, dtEffe);
					}
					if (cior.getCiorderdo().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
						isAdd = effeOrByTpAndDt(IBdSrvDictCodeConst.RIS_TYPE, dtEffe);
					}
					if (cior.getCiorderdo().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
						isAdd = effeOrByTpAndDt(IBdSrvDictCodeConst.LIS_TYPE, dtEffe);
					}
					if (cior.getCiorderdo().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
						isAdd = effeOrByTpAndDt(IBdSrvDictCodeConst.TREATMENT_TYPE, dtEffe);
					}
				}
				if (isAdd) {
					retList.add(cior);
				}
			}
		}
		return retList;
	}

	/**
	 * 获取调入医嘱是否符合调入条件
	 * 
	 * @param presdto
	 * @return
	 */
	public FArrayList getImputEffeData(FArrayList presdtos) {
		FArrayList retList = new FArrayList();
		if (presdtos != null && presdtos.size() > 0) {
			for (Object object : presdtos) {
				PrescriptionCostDto presdto = (PrescriptionCostDto) object;
				if (effeOrByTpAndDt(presdto.getPrntype(), presdto.getDt_sign())) {
					retList.add(presdto);
				}
			}
		}
		return retList;
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
			if (typestr.startsWith(IBdSrvDictCodeConst.RIS_TYPE)|| typestr.startsWith(IBdSrvDictCodeConst.PATHGY_TYPE)) {
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
