package iih.bd.pp.anhuisrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdhpfwssorginalRService;
import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 补全医保服务设施信息业务逻辑</br>
 * 选择医保服务设施参照后进行补全
 * 
 * @author hao_wu
 *
 */
public class CompInsurFwssDataBp {
	public void exec(FwssCompDTO[] fwssCompDTOs) throws BizException {
		if (fwssCompDTOs == null) {
			return;
		}
		CompInsurFwssData(fwssCompDTOs);
	}

	/**
	 * 补全医保服务设施信息列表
	 * 
	 * @param fwssCompDTOs
	 * @throws BizException
	 */
	private void CompInsurFwssData(FwssCompDTO[] fwssCompDTOs) throws BizException {
		for (FwssCompDTO fwssCompDTO : fwssCompDTOs) {
			CompInsurFwssData(fwssCompDTO);
		}
	}

	/**
	 * 补全医保服务设施信息
	 * 
	 * @param fwssCompDTO
	 * @throws BizException
	 */
	private void CompInsurFwssData(FwssCompDTO fwssCompDTO) throws BizException {
		if (fwssCompDTO == null) {
			return;
		}
		if (StringUtils.isBlank(fwssCompDTO.getCode())) {
			ClearInsurFwssDataBp bp = new ClearInsurFwssDataBp();
			bp.exec(fwssCompDTO);
			return;
		}
		BdHpFwssOrginalDO bdHpFwssOrginalDO = GetInsurDiByCode(fwssCompDTO.getCode());
		CompInsurFwssData(fwssCompDTO, bdHpFwssOrginalDO);
	}

	/**
	 * 使用医保服务设施编码查询医保服务设施
	 * 
	 * @param hpdidict_code
	 * @return
	 * @throws BizException
	 */
	private BdHpFwssOrginalDO GetInsurDiByCode(String insurFwssCode) throws BizException {
		IBdhpfwssorginalRService bdhpfwssorginalRService = ServiceFinder.find(IBdhpfwssorginalRService.class);
		BdHpFwssOrginalDO[] result = bdhpfwssorginalRService.findByAttrValString(BdHpFwssOrginalDO.CODE, insurFwssCode);
		if (result == null || result.length <= 0) {
			String msg = String.format("获取医保服务设施失败，医保服务设施编码：\"%s\"。", insurFwssCode);
			throw new BizException(msg);
		}
		return result[0];
	}

	/**
	 * 补全医保服务设施信息
	 * 
	 * @param fwssCompDTO
	 * @param bdHpFwssOrginalDO
	 */
	private void CompInsurFwssData(FwssCompDTO fwssCompDTO, BdHpFwssOrginalDO bdHpFwssOrginalDO) {
		if (fwssCompDTO == null || bdHpFwssOrginalDO == null) {
			return;
		}

		fwssCompDTO.setId_hpfwssorginal(bdHpFwssOrginalDO.getId_hpfwssorginal());
		fwssCompDTO.setName(bdHpFwssOrginalDO.getName());
		fwssCompDTO.setCode(bdHpFwssOrginalDO.getCode());
		fwssCompDTO.setCode_ca(bdHpFwssOrginalDO.getCode_ca());
		fwssCompDTO.setSd_hpsrvtp(bdHpFwssOrginalDO.getSd_hpsrvtp());
		fwssCompDTO.setPri_max(bdHpFwssOrginalDO.getPri_max());
		fwssCompDTO.setRetire_ey_pri_max(bdHpFwssOrginalDO.getRetire_ey_pri_max());
		fwssCompDTO.setDes(bdHpFwssOrginalDO.getDes());
		fwssCompDTO.setDt_b(bdHpFwssOrginalDO.getDt_b());
		fwssCompDTO.setDt_e(bdHpFwssOrginalDO.getDt_e());
		fwssCompDTO.setHospital_code(bdHpFwssOrginalDO.getHospital_code());
		fwssCompDTO.setStr_effective(bdHpFwssOrginalDO.getStr_effective());
		fwssCompDTO.setHospital_rank(bdHpFwssOrginalDO.getHospital_rank());
		fwssCompDTO.setHospital_bed_rank(bdHpFwssOrginalDO.getHospital_bed_rank());
		fwssCompDTO.setFwss_pay_standard(bdHpFwssOrginalDO.getFwss_pay_standard());
		fwssCompDTO.setId_emp_handle(bdHpFwssOrginalDO.getId_emp_handle());
		fwssCompDTO.setDt_handle(bdHpFwssOrginalDO.getDt_handle());
		fwssCompDTO.setPy_code(bdHpFwssOrginalDO.getPy_code());
		fwssCompDTO.setWb_code(bdHpFwssOrginalDO.getWb_code());
		fwssCompDTO.setZdy_code(bdHpFwssOrginalDO.getZdy_code());
		fwssCompDTO.setStr_prc_drug_list(bdHpFwssOrginalDO.getStr_prc_drug_list());
		fwssCompDTO.setStr_prc_b_drug_list(bdHpFwssOrginalDO.getStr_prc_b_drug_list());
		fwssCompDTO.setStr_resident_use(bdHpFwssOrginalDO.getStr_resident_use());
		if (fwssCompDTO.getStatus() == DOStatus.UNCHANGED) {
			fwssCompDTO.setStatus(DOStatus.UPDATED);
		}
	}
	//
	// /**
	// * 转换为日期时间格式
	// *
	// * @param dateTimeStr
	// * @return
	// */
	// private FDateTime ConvertToDateTime(String dateTimeStr) {
	// if (dateTimeStr.length() == 14) {
	// String newValue = String.format("%s/%s/%s %s:%s:%s",
	// dateTimeStr.substring(0, 3),
	// dateTimeStr.substring(4, 5), dateTimeStr.substring(6, 7),
	// dateTimeStr.substring(8, 9),
	// dateTimeStr.substring(10, 11), dateTimeStr.substring(12, 13));
	// return new FDateTime(newValue);
	// }
	// return null;
	// }

}
