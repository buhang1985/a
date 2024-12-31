package iih.bd.pp.anhuisrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdhpzlorginalRService;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 补全医保诊疗项目信息业务逻辑</br>
 * 选择医保诊疗项目参照后进行补全
 * 
 * @author hao_wu
 *
 */
public class CompInsurTreatDataBp {
	public void exec(TreatCompDTO[] treatCompDTOs) throws BizException {
		if (treatCompDTOs == null) {
			return;
		}
		CompInsurTreatData(treatCompDTOs);
	}

	/**
	 * 补全医保诊疗项目信息列表
	 * 
	 * @param treatCompDTOs
	 * @throws BizException
	 */
	private void CompInsurTreatData(TreatCompDTO[] treatCompDTOs) throws BizException {
		for (TreatCompDTO treatCompDTO : treatCompDTOs) {
			CompInsurTreatData(treatCompDTO);
		}
	}

	/**
	 * 补全医保诊疗项目信息
	 * 
	 * @param treatCompDTO
	 * @throws BizException
	 */
	private void CompInsurTreatData(TreatCompDTO treatCompDTO) throws BizException {
		if (treatCompDTO == null) {
			return;
		}
		if (StringUtils.isBlank(treatCompDTO.getCode())) {
			ClearInsurTreatDataBp bp = new ClearInsurTreatDataBp();
			bp.exec(treatCompDTO);
			return;
		}
		BdHpZlOrginalDO bdHpZlOrginalDO = GetInsurZlByCode(treatCompDTO.getCode());
		CompInsurTreatData(treatCompDTO, bdHpZlOrginalDO);
	}

	/**
	 * 使用医保诊疗编码查询医保诊疗
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
	 * 补全医保诊疗项目信息
	 * 
	 * @param treatCompDTO
	 * @param bdHpZlOrginalDO
	 */
	private void CompInsurTreatData(TreatCompDTO treatCompDTO, BdHpZlOrginalDO bdHpZlOrginalDO) {
		if (treatCompDTO == null || bdHpZlOrginalDO == null) {
			return;
		}

		treatCompDTO.setId_hpzlorginal(bdHpZlOrginalDO.getId_hpzlorginal());
		treatCompDTO.setName(bdHpZlOrginalDO.getName());
		treatCompDTO.setCode(bdHpZlOrginalDO.getCode());
		treatCompDTO.setCode_ca(bdHpZlOrginalDO.getCode_ca());
		treatCompDTO.setSd_hpsrvtp(bdHpZlOrginalDO.getSd_hpsrvtp());
		treatCompDTO.setPri_max(bdHpZlOrginalDO.getPri_max());
		treatCompDTO.setRetire_ey_pri_max(bdHpZlOrginalDO.getRetire_ey_pri_max());
		treatCompDTO.setDes(bdHpZlOrginalDO.getDes());
		treatCompDTO.setDt_b(bdHpZlOrginalDO.getDt_b());
		treatCompDTO.setDt_e(bdHpZlOrginalDO.getDt_e());
		treatCompDTO.setRate_self_oep(bdHpZlOrginalDO.getRate_self_oep());
		treatCompDTO.setRate_self_ip(bdHpZlOrginalDO.getRate_self_ip());
		treatCompDTO.setRate_retire(bdHpZlOrginalDO.getRate_retire());
		treatCompDTO.setRate_injury(bdHpZlOrginalDO.getRate_injury());
		treatCompDTO.setRate_birth(bdHpZlOrginalDO.getRate_birth());
		treatCompDTO.setRate_ey(bdHpZlOrginalDO.getRate_ey());
		treatCompDTO.setRate_unit(bdHpZlOrginalDO.getRate_unit());
		treatCompDTO.setRate_family(bdHpZlOrginalDO.getRate_family());
		treatCompDTO.setRate_import_diff(bdHpZlOrginalDO.getRate_import_diff());
		treatCompDTO.setStr_resident_use(bdHpZlOrginalDO.getStr_resident_use());
		treatCompDTO.setPay_self_tp(bdHpZlOrginalDO.getPay_self_tp());
		treatCompDTO.setStr_approve(bdHpZlOrginalDO.getStr_approve());
		treatCompDTO.setStr_two_insurpay(bdHpZlOrginalDO.getStr_two_insurpay());
		treatCompDTO.setStr_add_insur(bdHpZlOrginalDO.getStr_add_insur());
		treatCompDTO.setStr_add_insur_sal(bdHpZlOrginalDO.getStr_add_insur_sal());
		treatCompDTO.setStr_special_itm(bdHpZlOrginalDO.getStr_special_itm());
		treatCompDTO.setOrigin_place(bdHpZlOrginalDO.getOrigin_place());
		treatCompDTO.setAmt_prepay_max(bdHpZlOrginalDO.getAmt_prepay_max());
		treatCompDTO.setDomestic_pri_max(bdHpZlOrginalDO.getDomestic_pri_max());
		treatCompDTO.setStr_hospital_help(bdHpZlOrginalDO.getStr_hospital_help());
		treatCompDTO.setHospital_code(bdHpZlOrginalDO.getHospital_code());
		treatCompDTO.setStr_hospital_help(bdHpZlOrginalDO.getStr_hospital_help());
		treatCompDTO.setUnit(bdHpZlOrginalDO.getUnit());
		treatCompDTO.setFirm_name(bdHpZlOrginalDO.getFirm_name());
		treatCompDTO.setId_emp_handle(bdHpZlOrginalDO.getId_emp_handle());
		treatCompDTO.setDt_handle(bdHpZlOrginalDO.getDt_handle());
		treatCompDTO.setStr_effective(bdHpZlOrginalDO.getStr_effective());
		treatCompDTO.setPy_code(bdHpZlOrginalDO.getPy_code());
		treatCompDTO.setWb_code(bdHpZlOrginalDO.getWb_code());
		treatCompDTO.setZdy_code(bdHpZlOrginalDO.getZdy_code());
		treatCompDTO.setStr_prc_druglist(bdHpZlOrginalDO.getStr_prc_druglist());
		treatCompDTO.setStr_prc_b_druglist(bdHpZlOrginalDO.getStr_prc_b_druglist());

		if (treatCompDTO.getStatus() == DOStatus.UNCHANGED) {
			treatCompDTO.setStatus(DOStatus.UPDATED);
		}
	}
}
