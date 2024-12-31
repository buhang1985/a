package iih.bd.pp.anhuisrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdhpfwssorginalRService;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class CompInsurDrugTreatDataBp {
	public void exec(DrugCompDTO[] drugCompDTOs) throws BizException {
		if (drugCompDTOs == null) {
			return;
		}
		CompInsurDrugData(drugCompDTOs);
	}
	
	/**
	 * 补全医保药品信息列表
	 * 
	 * @param drugCompDTOs
	 * @throws BizException
	 */
	private void CompInsurDrugData(DrugCompDTO[] drugCompDTOs) throws BizException {
		for (DrugCompDTO drugCompDTO : drugCompDTOs) {
			//if ((HpSrvTpEnum.ZL.toString()).equals(drugCompDTO.getEu_hpsrvtp())) {
				CompInsurDrugTreatData(drugCompDTO);
			//} else if ((HpSrvTpEnum.FWSS.toString()).equals(drugCompDTO.getEu_hpsrvtp())) {
				//CompInsurFwssDataBp(drugCompDTO);
			//}
			//CompInsurDrugData(drugCompDTO);
		}
	}
	
	/**
	 * 补全医保诊疗数据
	 * 
	 * @param drugCompDTO
	 * @throws BizException
	 */
	private void CompInsurDrugTreatData(DrugCompDTO drugCompDTO) throws BizException {
		CompInsurDrugTreatZLDataBp bp = new CompInsurDrugTreatZLDataBp();
		bp.exec(new DrugCompDTO[] { drugCompDTO });
	}
	
	/**
	 * 补全服务设施数据业务逻辑
	 * 
	 * @param drugCompDTO
	 * @throws BizException
	 */
	private void CompInsurFwssDataBp(DrugCompDTO drugCompDTO) throws BizException {
		if (StringUtils.isBlank(drugCompDTO.getCode())) {
			ClearInsurDrugDataBp bp = new ClearInsurDrugDataBp();
			bp.exec(drugCompDTO);
			return;
		}
		BdHpFwssOrginalDO bdHpFwssOrginalDO = GetInsurDiByCode(drugCompDTO.getCode());
		CompInsurFwssData(drugCompDTO, bdHpFwssOrginalDO);
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
	 * 补全医保服务设施信息
	 * 
	 * @param fwssCompDTO
	 * @param bdHpFwssOrginalDO
	 */
	private void CompInsurFwssData(DrugCompDTO drugCompDTO, BdHpFwssOrginalDO bdHpFwssOrginalDO) {
		if (drugCompDTO == null || bdHpFwssOrginalDO == null) {
			return;
		}

		//drugCompDTO.setId_hpfwssorginal(bdHpFwssOrginalDO.getId_hpfwssorginal());
		drugCompDTO.setName(bdHpFwssOrginalDO.getName());
		drugCompDTO.setCode_ca(bdHpFwssOrginalDO.getCode_ca());
		drugCompDTO.setSd_hpsrvtp(bdHpFwssOrginalDO.getSd_hpsrvtp());
		drugCompDTO.setPri_max(bdHpFwssOrginalDO.getPri_max());
		drugCompDTO.setRetire_ey_pri_max(bdHpFwssOrginalDO.getRetire_ey_pri_max());
		drugCompDTO.setDes(bdHpFwssOrginalDO.getDes());
		drugCompDTO.setDt_b(bdHpFwssOrginalDO.getDt_b());
		drugCompDTO.setDt_e(bdHpFwssOrginalDO.getDt_e());
		drugCompDTO.setHospital_code(bdHpFwssOrginalDO.getHospital_code());
		drugCompDTO.setStr_effective(bdHpFwssOrginalDO.getStr_effective());
		/*drugCompDTO.setHospital_rank(bdHpFwssOrginalDO.getHospital_rank());
		drugCompDTO.setHospital_bed_rank(bdHpFwssOrginalDO.getHospital_bed_rank());
		drugCompDTO.setFwss_pay_standard(bdHpFwssOrginalDO.getFwss_pay_standard());*/
		drugCompDTO.setId_emp_handle(bdHpFwssOrginalDO.getId_emp_handle());
		drugCompDTO.setDt_handle(bdHpFwssOrginalDO.getDt_handle());
		drugCompDTO.setPy_code(bdHpFwssOrginalDO.getPy_code());
		drugCompDTO.setWb_code(bdHpFwssOrginalDO.getWb_code());
		drugCompDTO.setZdy_code(bdHpFwssOrginalDO.getZdy_code());
		drugCompDTO.setStr_prc_druglist(bdHpFwssOrginalDO.getStr_prc_drug_list());
		drugCompDTO.setStr_prc_b_druglist(bdHpFwssOrginalDO.getStr_prc_b_drug_list());
		drugCompDTO.setStr_resident_use(bdHpFwssOrginalDO.getStr_resident_use());
		/*drugCompDTO.setHospital_rank(bdHpFwssOrginalDO.getHospital_rank());
		drugCompDTO.setHospital_bed_rank(bdHpFwssOrginalDO.getHospital_bed_rank());
		drugCompDTO.setFwss_pay_standard(bdHpFwssOrginalDO.getFwss_pay_standard());*/
		if (drugCompDTO.getStatus() == DOStatus.UNCHANGED) {
			drugCompDTO.setStatus(DOStatus.UPDATED);
		}
	}
}
