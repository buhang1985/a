package iih.bd.pp.anhuisrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.d.BdHpDosageOrginalDO;
import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdhpdosageorginalRService;
import iih.bd.pp.anhuiinsur.i.IBdhpdrugorginalRService;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 补全医保药品信息业务逻辑</br>
 * 选择医保药品参照后进行补全
 * 
 * @author hao_wu
 *
 */
public class CompInsurDrugDataBp {

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
			CompInsurDrugData(drugCompDTO);
		}
	}

	/**
	 * 补全医保药品信息
	 * 
	 * @param drugCompDTO
	 * @throws BizException
	 */
	private void CompInsurDrugData(DrugCompDTO drugCompDTO) throws BizException {
		if (drugCompDTO == null) {
			return;
		}
		if (StringUtils.isBlank(drugCompDTO.getCode())) {
			ClearInsurDrugDataBp bp = new ClearInsurDrugDataBp();
			bp.exec(drugCompDTO);
			return;
		}
		BdHpDrugOrginalDO bdHpFwssOrginalDO = GetInsurDiByCode(drugCompDTO.getId_hp(), drugCompDTO.getCode());
		CompInsurDrugData(drugCompDTO, bdHpFwssOrginalDO);
		CompInsurDrugDosageData(drugCompDTO);
	}

	/**
	 * 补全医保药品剂型信息
	 * 
	 * @param drugCompDTO
	 * @throws BizException
	 */
	private void CompInsurDrugDosageData(DrugCompDTO drugCompDTO) throws BizException {
		if (drugCompDTO != null && !StringUtils.isEmpty(drugCompDTO.getDosage())) {
			BdHpDosageOrginalDO dosageOrginalDO = GetInsurDosageByCode(drugCompDTO.getDosage());
			if (dosageOrginalDO != null) {
				drugCompDTO.setDosage_name(dosageOrginalDO.getName());
			} else {
				drugCompDTO.setDosage_name(drugCompDTO.getDosage());
			}
		}
	}

	/**
	 * 
	 * 通过医保剂型编码获取医保剂型信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private BdHpDosageOrginalDO GetInsurDosageByCode(String dosageCode) throws BizException {
		IBdhpdosageorginalRService bdhpdosageorginalRService = ServiceFinder.find(IBdhpdosageorginalRService.class);
		BdHpDosageOrginalDO[] result = bdhpdosageorginalRService.findByAttrValString(BdHpDosageOrginalDO.CODE,
				dosageCode);
		if (result != null && result.length >= 1) {
			return result[0];
		}
		return null;
	}

	/**
	 * 使用医保药品编码查询医保药品
	 * 
	 * @param hpId
	 * @param insurDrugCode
	 * @return
	 * @throws BizException
	 */
	private BdHpDrugOrginalDO GetInsurDiByCode(String hpId, String insurDrugCode) throws BizException {
		IBdhpdrugorginalRService bdhpdrugorginalRService = ServiceFinder.find(IBdhpdrugorginalRService.class);
		String strWhere=String.format(" id_hp='%s' and code='%s'", hpId,insurDrugCode);
		BdHpDrugOrginalDO[] result = bdhpdrugorginalRService.find(strWhere, "",FBoolean.TRUE);
		if (result == null || result.length <= 0) {
			String msg = String.format("获取医保药品失败，医保药品编码：\"%s\"。", insurDrugCode);
			throw new BizException(msg);
		}
		return result[0];
	}

	/**
	 * 补全医保药品信息
	 * 
	 * @param drugCompDTO
	 * @param bdHpDrugOrginalDO
	 */
	private void CompInsurDrugData(DrugCompDTO drugCompDTO, BdHpDrugOrginalDO bdHpDrugOrginalDO) {
		if (drugCompDTO == null || bdHpDrugOrginalDO == null) {
			return;
		}

		drugCompDTO.setId_hpdrugorginal(bdHpDrugOrginalDO.getId_hpdrugorginal());
		drugCompDTO.setName(bdHpDrugOrginalDO.getName());
		drugCompDTO.setCode(bdHpDrugOrginalDO.getCode());
		drugCompDTO.setCode_ca(bdHpDrugOrginalDO.getCode_ca());
		drugCompDTO.setSd_hpsrvtp(bdHpDrugOrginalDO.getSd_hpsrvtp());
		drugCompDTO.setPri_max(bdHpDrugOrginalDO.getPri_max());
		drugCompDTO.setRetire_ey_pri_max(bdHpDrugOrginalDO.getRetire_ey_pri_max());
		drugCompDTO.setDes(bdHpDrugOrginalDO.getDes());
		drugCompDTO.setDt_b(bdHpDrugOrginalDO.getDt_b());
		drugCompDTO.setDt_e(bdHpDrugOrginalDO.getDt_e());
		drugCompDTO.setRate_self_oep(bdHpDrugOrginalDO.getRate_self_oep());
		drugCompDTO.setRate_self_ip(bdHpDrugOrginalDO.getRate_self_ip());
		drugCompDTO.setRate_retire(bdHpDrugOrginalDO.getRate_retire());
		drugCompDTO.setRate_injury(bdHpDrugOrginalDO.getRate_injury());
		drugCompDTO.setRate_birth(bdHpDrugOrginalDO.getRate_birth());
		drugCompDTO.setRate_ey(bdHpDrugOrginalDO.getRate_ey());
		drugCompDTO.setRate_unit(bdHpDrugOrginalDO.getRate_unit());
		drugCompDTO.setRate_family(bdHpDrugOrginalDO.getRate_family());
		drugCompDTO.setRate_import_diff(bdHpDrugOrginalDO.getRate_import_diff());
		drugCompDTO.setName_english(bdHpDrugOrginalDO.getName_english());
		drugCompDTO.setDrug_type(bdHpDrugOrginalDO.getDrug_type());
		drugCompDTO.setStr_oct(bdHpDrugOrginalDO.getStr_oct());
		drugCompDTO.setDrug_grade(bdHpDrugOrginalDO.getDrug_grade());
		drugCompDTO.setDose_unit(bdHpDrugOrginalDO.getDose_unit());
		drugCompDTO.setDosage(bdHpDrugOrginalDO.getDosage());
		drugCompDTO.setSingle_dose(bdHpDrugOrginalDO.getSingle_dose());
		drugCompDTO.setFreq(bdHpDrugOrginalDO.getFreq());
		drugCompDTO.setUsage(bdHpDrugOrginalDO.getUsage());
		drugCompDTO.setSpec(bdHpDrugOrginalDO.getSpec());
		drugCompDTO.setUnit(bdHpDrugOrginalDO.getUnit());
		drugCompDTO.setAmt_prepay_max(bdHpDrugOrginalDO.getAmt_prepay_max());
		drugCompDTO.setStr_prep_self(bdHpDrugOrginalDO.getStr_prep_self());
		drugCompDTO.setHospital_code(bdHpDrugOrginalDO.getHospital_code());
		drugCompDTO.setStr_approve(bdHpDrugOrginalDO.getStr_approve());
		drugCompDTO.setMin_hospital_rank(bdHpDrugOrginalDO.getMin_hospital_rank());
		drugCompDTO.setMin_doctor_rank(bdHpDrugOrginalDO.getMin_doctor_rank());
		drugCompDTO.setStr_add_insur(bdHpDrugOrginalDO.getStr_add_insur());
		drugCompDTO.setStr_add_insur_sal(bdHpDrugOrginalDO.getStr_add_insur_sal());
		drugCompDTO.setStr_bidding_drug(bdHpDrugOrginalDO.getStr_bidding_drug());
		drugCompDTO.setBidding_price(bdHpDrugOrginalDO.getBidding_price());
		drugCompDTO.setStr_spec_drug(bdHpDrugOrginalDO.getStr_spec_drug());
		drugCompDTO.setStr_two_insurpay(bdHpDrugOrginalDO.getStr_two_insurpay());
		drugCompDTO.setDrug_name(bdHpDrugOrginalDO.getDrug_name());
		drugCompDTO.setDrug_name_price(bdHpDrugOrginalDO.getDrug_name_price());
		drugCompDTO.setDrug_name_pycode(bdHpDrugOrginalDO.getDrug_name_pycode());
		drugCompDTO.setDrug_name_wbcode(bdHpDrugOrginalDO.getDrug_name_wbcode());
		drugCompDTO.setPharm_firm_name(bdHpDrugOrginalDO.getPharm_firm_name());
		drugCompDTO.setPrc_drug_certi(bdHpDrugOrginalDO.getPrc_drug_certi());
		drugCompDTO.setId_emp_handle(bdHpDrugOrginalDO.getId_emp_handle());
		drugCompDTO.setDt_handle(bdHpDrugOrginalDO.getDt_handle());
		drugCompDTO.setPrc_direc_code(bdHpDrugOrginalDO.getPrc_direc_code());
		drugCompDTO.setReference_price(bdHpDrugOrginalDO.getReference_price());
		drugCompDTO.setReference_hospital(bdHpDrugOrginalDO.getReference_hospital());
		drugCompDTO.setOrigin_place(bdHpDrugOrginalDO.getOrigin_place());
		drugCompDTO.setStr_effective(bdHpDrugOrginalDO.getStr_effective());
		drugCompDTO.setStr_prc_b_druglist(bdHpDrugOrginalDO.getStr_prc_b_druglist());
		drugCompDTO.setStr_resident_use(bdHpDrugOrginalDO.getStr_resident_use());
		drugCompDTO.setSex_limit_pay(bdHpDrugOrginalDO.getSex_limit_pay());
		drugCompDTO.setDisease_limit_pay(bdHpDrugOrginalDO.getDisease_limit_pay());
		drugCompDTO.setPy_code(bdHpDrugOrginalDO.getPy_code());
		drugCompDTO.setWb_code(bdHpDrugOrginalDO.getWb_code());
		drugCompDTO.setZdy_code(bdHpDrugOrginalDO.getZdy_code());
		drugCompDTO.setStr_prc_druglist(bdHpDrugOrginalDO.getStr_prc_druglist());
		drugCompDTO.setMax_use_days(bdHpDrugOrginalDO.getMax_use_days());
		if (drugCompDTO.getStatus() == DOStatus.UNCHANGED) {
			drugCompDTO.setStatus(DOStatus.UPDATED);
		}
	}
}
