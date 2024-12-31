package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import xap.mw.core.data.DOStatus;

/**
 * 清除药品对照中的医保药品信息
 * 
 * @author hao_wu
 *
 */
public class ClearInsurDrugDataBp {

	public void exec(DrugCompDTO drugCompDTO) {
		drugCompDTO.setId_hpdrugorginal(null);
		drugCompDTO.setName(null);
		drugCompDTO.setCode(null);
		drugCompDTO.setCode_ca(null);
		drugCompDTO.setSd_hpsrvtp(null);
		drugCompDTO.setPri_max(null);
		drugCompDTO.setRetire_ey_pri_max(null);
		drugCompDTO.setDes(null);
		drugCompDTO.setDt_b(null);
		drugCompDTO.setDt_e(null);
		drugCompDTO.setRate_self_oep(null);
		drugCompDTO.setRate_self_ip(null);
		drugCompDTO.setRate_retire(null);
		drugCompDTO.setRate_injury(null);
		drugCompDTO.setRate_birth(null);
		drugCompDTO.setRate_ey(null);
		drugCompDTO.setRate_unit(null);
		drugCompDTO.setRate_family(null);
		drugCompDTO.setRate_import_diff(null);
		drugCompDTO.setName_english(null);
		drugCompDTO.setDrug_type(null);
		drugCompDTO.setStr_oct(null);
		drugCompDTO.setDrug_grade(null);
		drugCompDTO.setDose_unit(null);
		drugCompDTO.setDosage(null);
		drugCompDTO.setDosage_name(null);
		drugCompDTO.setSingle_dose(null);
		drugCompDTO.setFreq(null);
		drugCompDTO.setUsage(null);
		drugCompDTO.setSpec(null);
		drugCompDTO.setUnit(null);
		drugCompDTO.setAmt_prepay_max(null);
		drugCompDTO.setStr_prep_self(null);
		drugCompDTO.setHospital_code(null);
		drugCompDTO.setStr_approve(null);
		drugCompDTO.setMin_hospital_rank(null);
		drugCompDTO.setMin_doctor_rank(null);
		drugCompDTO.setStr_add_insur(null);
		drugCompDTO.setStr_add_insur_sal(null);
		drugCompDTO.setStr_bidding_drug(null);
		drugCompDTO.setBidding_price(null);
		drugCompDTO.setStr_spec_drug(null);
		drugCompDTO.setStr_two_insurpay(null);
		drugCompDTO.setDrug_name(null);
		drugCompDTO.setDrug_name_price(null);
		drugCompDTO.setDrug_name_pycode(null);
		drugCompDTO.setDrug_name_wbcode(null);
		drugCompDTO.setPharm_firm_name(null);
		drugCompDTO.setPrc_drug_certi(null);
		drugCompDTO.setId_emp_handle(null);
		drugCompDTO.setDt_handle(null);
		drugCompDTO.setPrc_direc_code(null);
		drugCompDTO.setReference_price(null);
		drugCompDTO.setReference_hospital(null);
		drugCompDTO.setOrigin_place(null);
		drugCompDTO.setStr_effective(null);
		drugCompDTO.setStr_prc_b_druglist(null);
		drugCompDTO.setStr_resident_use(null);
		drugCompDTO.setSex_limit_pay(null);
		drugCompDTO.setDisease_limit_pay(null);
		drugCompDTO.setPy_code(null);
		drugCompDTO.setWb_code(null);
		drugCompDTO.setZdy_code(null);
		drugCompDTO.setStr_prc_druglist(null);
		drugCompDTO.setMax_use_days(null);
		drugCompDTO.setStatus(DOStatus.UNCHANGED);
	}

}
