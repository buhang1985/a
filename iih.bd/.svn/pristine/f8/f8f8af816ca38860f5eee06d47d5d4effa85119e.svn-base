package iih.bd.pp.anhuisrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdhpfwssorginalRService;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 补全医保和服务设施数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CompInsurTreatAndFwssDataBp {

	public void exec(TreatCompDTO[] treatCompDTOs) throws BizException {
		if (treatCompDTOs == null || treatCompDTOs.length <= 0) {
			return;
		}
		for (TreatCompDTO treatCompDTO : treatCompDTOs) {
			if ((HpSrvTpEnum.ZL.toString()).equals(treatCompDTO.getEu_hpsrvtp())) {
				CompInsurTreatData(treatCompDTO);
			} else if ((HpSrvTpEnum.FWSS.toString()).equals(treatCompDTO.getEu_hpsrvtp())) {
				CompInsurFwssDataBp(treatCompDTO);
			}
		}
	}

	/**
	 * 补全服务设施数据业务逻辑
	 * 
	 * @param treatCompDTO
	 * @throws BizException
	 */
	private void CompInsurFwssDataBp(TreatCompDTO treatCompDTO) throws BizException {
		if (StringUtils.isBlank(treatCompDTO.getCode())) {
			ClearInsurFwssData(treatCompDTO);
			return;
		}
		BdHpFwssOrginalDO bdHpFwssOrginalDO = GetInsurDiByCode(treatCompDTO.getCode());
		CompInsurFwssData(treatCompDTO, bdHpFwssOrginalDO);
	}

	/**
	 * 清除医保服务设施数据
	 * 
	 * @param treatCompDTO
	 */
	private void ClearInsurFwssData(TreatCompDTO treatCompDTO) {
		ClearInsurTreatDataBp bp = new ClearInsurTreatDataBp();
		bp.exec(treatCompDTO);
	}

	/**
	 * 补全医保服务设施信息
	 * 
	 * @param fwssCompDTO
	 * @param bdHpFwssOrginalDO
	 */
	private void CompInsurFwssData(TreatCompDTO treatCompDTO, BdHpFwssOrginalDO bdHpFwssOrginalDO) {
		if (treatCompDTO == null || bdHpFwssOrginalDO == null) {
			return;
		}

		treatCompDTO.setId_hpfwssorginal(bdHpFwssOrginalDO.getId_hpfwssorginal());
		treatCompDTO.setName(bdHpFwssOrginalDO.getName());
		treatCompDTO.setCode_ca(bdHpFwssOrginalDO.getCode_ca());
		treatCompDTO.setSd_hpsrvtp(bdHpFwssOrginalDO.getSd_hpsrvtp());
		treatCompDTO.setPri_max(bdHpFwssOrginalDO.getPri_max());
		treatCompDTO.setRetire_ey_pri_max(bdHpFwssOrginalDO.getRetire_ey_pri_max());
		treatCompDTO.setDes(bdHpFwssOrginalDO.getDes());
		treatCompDTO.setDt_b(bdHpFwssOrginalDO.getDt_b());
		treatCompDTO.setDt_e(bdHpFwssOrginalDO.getDt_e());
		treatCompDTO.setHospital_code(bdHpFwssOrginalDO.getHospital_code());
		treatCompDTO.setStr_effective(bdHpFwssOrginalDO.getStr_effective());
		treatCompDTO.setHospital_rank(bdHpFwssOrginalDO.getHospital_rank());
		treatCompDTO.setHospital_bed_rank(bdHpFwssOrginalDO.getHospital_bed_rank());
		treatCompDTO.setFwss_pay_standard(bdHpFwssOrginalDO.getFwss_pay_standard());
		treatCompDTO.setId_emp_handle(bdHpFwssOrginalDO.getId_emp_handle());
		treatCompDTO.setDt_handle(bdHpFwssOrginalDO.getDt_handle());
		treatCompDTO.setPy_code(bdHpFwssOrginalDO.getPy_code());
		treatCompDTO.setWb_code(bdHpFwssOrginalDO.getWb_code());
		treatCompDTO.setZdy_code(bdHpFwssOrginalDO.getZdy_code());
		treatCompDTO.setStr_prc_druglist(bdHpFwssOrginalDO.getStr_prc_drug_list());
		treatCompDTO.setStr_prc_b_druglist(bdHpFwssOrginalDO.getStr_prc_b_drug_list());
		treatCompDTO.setStr_resident_use(bdHpFwssOrginalDO.getStr_resident_use());
		treatCompDTO.setHospital_rank(bdHpFwssOrginalDO.getHospital_rank());
		treatCompDTO.setHospital_bed_rank(bdHpFwssOrginalDO.getHospital_bed_rank());
		treatCompDTO.setFwss_pay_standard(bdHpFwssOrginalDO.getFwss_pay_standard());
		if (treatCompDTO.getStatus() == DOStatus.UNCHANGED) {
			treatCompDTO.setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 使用医保服务设施编码查询医保服务设施
	 * 
	 * @param hpdidict_code
	 * @return
	 * @throws BizException
	 */
	private BdHpFwssOrginalDO GetInsurDiByCode(String insurFwssCode) throws BizException {
		if (insurFwssCode.endsWith("-F")) {
			insurFwssCode = insurFwssCode.substring(0, insurFwssCode.length() - 2);
		}
		IBdhpfwssorginalRService bdhpfwssorginalRService = ServiceFinder.find(IBdhpfwssorginalRService.class);
		BdHpFwssOrginalDO[] result = bdhpfwssorginalRService.findByAttrValString(BdHpFwssOrginalDO.CODE, insurFwssCode);
		if (result == null || result.length <= 0) {
			String msg = String.format("获取医保服务设施失败，医保服务设施编码：\"%s\"。", insurFwssCode);
			throw new BizException(msg);
		}
		return result[0];
	}

	/**
	 * 补全医保诊疗数据
	 * 
	 * @param treatCompDTO
	 * @throws BizException
	 */
	private void CompInsurTreatData(TreatCompDTO treatCompDTO) throws BizException {
		CompInsurTreatDataBp bp = new CompInsurTreatDataBp();
		bp.exec(new TreatCompDTO[] { treatCompDTO });
	}

}
