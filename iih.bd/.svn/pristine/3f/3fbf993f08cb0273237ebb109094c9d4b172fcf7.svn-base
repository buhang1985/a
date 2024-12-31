package iih.bd.pp.anhuisrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdhpzlorginalRService;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 补全医保药品诊疗项目信息业务逻辑</br>
 * 选择医保诊疗项目参照后进行补全
 * 
 * @author hao_wu
 *
 */
public class CompInsurDrugTreatZLDataBp {
	public void exec(DrugCompDTO[] drugCompDTOs) throws BizException {
		if (drugCompDTOs == null) {
			return;
		}
		CompInsurDrugTreatData(drugCompDTOs);
	}
	
	/**
	 * 补全医保药品诊疗项目信息列表
	 * 
	 * @param drugCompDTOs
	 * @throws BizException
	 */
	private void CompInsurDrugTreatData(DrugCompDTO[] drugCompDTOs) throws BizException {
		for (DrugCompDTO drugCompDTO : drugCompDTOs) {
			CompInsurDrugTreatData(drugCompDTO);
		}
	}
	
	/**
	 * 补全医保药品诊疗项目信息
	 * 
	 * @param drugCompDTO
	 * @throws BizException
	 */
	private void CompInsurDrugTreatData(DrugCompDTO drugCompDTO) throws BizException {
		if (drugCompDTO == null) {
			return;
		}
		if (StringUtils.isBlank(drugCompDTO.getCode())) {
			ClearInsurDrugDataBp bp = new ClearInsurDrugDataBp();
			bp.exec(drugCompDTO);
			return;
		}
		BdHpZlOrginalDO bdHpZlOrginalDO = GetInsurZlByCode(drugCompDTO.getCode());
		CompInsurTreatData(drugCompDTO, bdHpZlOrginalDO);
	}
	
	/**
	 * 使用医保药品诊疗编码查询医保诊疗
	 * 
	 * @param hpdidict_code
	 * @return
	 * @throws BizException
	 */
	private BdHpZlOrginalDO GetInsurZlByCode(String insurZlCode) throws BizException {
		IBdhpzlorginalRService bdhpzlorginalRService = ServiceFinder.find(IBdhpzlorginalRService.class);
		BdHpZlOrginalDO[] result = bdhpzlorginalRService.findByAttrValString(BdHpZlOrginalDO.CODE, insurZlCode);
		if (result == null || result.length <= 0) {
			String msg = String.format("获取医保诊疗失败，医保诊疗编码：\"%s\"。", insurZlCode);
			throw new BizException(msg);
		}
		return result[0];
	}
	
	/**
	 * 补全医保药品诊疗项目信息
	 * 
	 * @param drugCompDTO
	 * @param bdHpZlOrginalDO
	 */
	private void CompInsurTreatData(DrugCompDTO drugCompDTO, BdHpZlOrginalDO bdHpZlOrginalDO) {
		if (drugCompDTO == null || bdHpZlOrginalDO == null) {
			return;
		}

		//drugCompDTO.setId_hpzlorginal(bdHpZlOrginalDO.getId_hpzlorginal());
		drugCompDTO.setName(bdHpZlOrginalDO.getName());
		drugCompDTO.setCode(bdHpZlOrginalDO.getCode());
		drugCompDTO.setCode_ca(bdHpZlOrginalDO.getCode_ca());
		drugCompDTO.setSd_hpsrvtp(bdHpZlOrginalDO.getSd_hpsrvtp());
		drugCompDTO.setPri_max(bdHpZlOrginalDO.getPri_max());
		drugCompDTO.setRetire_ey_pri_max(bdHpZlOrginalDO.getRetire_ey_pri_max());
		drugCompDTO.setDes(bdHpZlOrginalDO.getDes());
		drugCompDTO.setDt_b(bdHpZlOrginalDO.getDt_b());
		drugCompDTO.setDt_e(bdHpZlOrginalDO.getDt_e());
		drugCompDTO.setRate_self_oep(bdHpZlOrginalDO.getRate_self_oep());
		drugCompDTO.setRate_self_ip(bdHpZlOrginalDO.getRate_self_ip());
		drugCompDTO.setRate_retire(bdHpZlOrginalDO.getRate_retire());
		drugCompDTO.setRate_injury(bdHpZlOrginalDO.getRate_injury());
		drugCompDTO.setRate_birth(bdHpZlOrginalDO.getRate_birth());
		drugCompDTO.setRate_ey(bdHpZlOrginalDO.getRate_ey());
		drugCompDTO.setRate_unit(bdHpZlOrginalDO.getRate_unit());
		drugCompDTO.setRate_family(bdHpZlOrginalDO.getRate_family());
		drugCompDTO.setRate_import_diff(bdHpZlOrginalDO.getRate_import_diff());
		drugCompDTO.setStr_resident_use(bdHpZlOrginalDO.getStr_resident_use());
		//drugCompDTO.setPay_self_tp(bdHpZlOrginalDO.getPay_self_tp());
		drugCompDTO.setStr_approve(bdHpZlOrginalDO.getStr_approve());
		drugCompDTO.setStr_two_insurpay(bdHpZlOrginalDO.getStr_two_insurpay());
		drugCompDTO.setStr_add_insur(bdHpZlOrginalDO.getStr_add_insur());
		drugCompDTO.setStr_add_insur_sal(bdHpZlOrginalDO.getStr_add_insur_sal());
		//drugCompDTO.setStr_special_itm(bdHpZlOrginalDO.getStr_special_itm());
		drugCompDTO.setOrigin_place(bdHpZlOrginalDO.getOrigin_place());
		drugCompDTO.setAmt_prepay_max(bdHpZlOrginalDO.getAmt_prepay_max());
		//drugCompDTO.setDomestic_pri_max(bdHpZlOrginalDO.getDomestic_pri_max());
		//drugCompDTO.setStr_hospital_help(bdHpZlOrginalDO.getStr_hospital_help());
		drugCompDTO.setHospital_code(bdHpZlOrginalDO.getHospital_code());
		//drugCompDTO.setStr_hospital_help(bdHpZlOrginalDO.getStr_hospital_help());
		drugCompDTO.setUnit(bdHpZlOrginalDO.getUnit());
		//drugCompDTO.setFirm_name(bdHpZlOrginalDO.getFirm_name());
		drugCompDTO.setId_emp_handle(bdHpZlOrginalDO.getId_emp_handle());
		drugCompDTO.setDt_handle(bdHpZlOrginalDO.getDt_handle());
		drugCompDTO.setStr_effective(bdHpZlOrginalDO.getStr_effective());
		drugCompDTO.setPy_code(bdHpZlOrginalDO.getPy_code());
		drugCompDTO.setWb_code(bdHpZlOrginalDO.getWb_code());
		drugCompDTO.setZdy_code(bdHpZlOrginalDO.getZdy_code());
		drugCompDTO.setStr_prc_druglist(bdHpZlOrginalDO.getStr_prc_druglist());
		drugCompDTO.setStr_prc_b_druglist(bdHpZlOrginalDO.getStr_prc_b_druglist());

		if (drugCompDTO.getStatus() == DOStatus.UNCHANGED) {
			drugCompDTO.setStatus(DOStatus.UPDATED);
		}
	}
}
