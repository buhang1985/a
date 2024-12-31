package iih.mi.itf2.service.bp.bdservice.drug;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.d.BdHpDosageOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdhpdosageorginalRService;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.mi.biz.dto.d.MiSrvTp;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.drugmanualcomp.d.DrugManualCompDTO;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataInParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataOutParam;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.service.bp.bdservice.util.ToolUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 补全医保药品信息业务逻辑</br>
 * 选择医保药品参照后进行补全
 * Title: CompInsurDrugDataNewBp.java
 * @author zhang.hw
 * @date 2019年5月27日  
 * @version 1.0
 */
public class CompInsurDrugDataBp {

	public void exec(DrugManualCompDTO[] drugCompDTOs) throws BizException {
		if (drugCompDTOs == null) {
			return ;
		}
		CompInsurDrugData(drugCompDTOs);
	}

	/**
	 * 补全医保药品信息列表
	 * 
	 * @param drugCompDTOs
	 * @throws BizException
	 */
	private void CompInsurDrugData(DrugManualCompDTO[] drugCompDTOs) throws BizException {
		for (DrugManualCompDTO drugCompDTO : drugCompDTOs) {
			CompInsurDrugData(drugCompDTO);
		}
	}

	/**
	 * 补全医保药品信息
	 * 
	 * @param drugCompDTO
	 * @throws BizException
	 */
	private void CompInsurDrugData(DrugManualCompDTO drugCompDTO) throws BizException {
		if (drugCompDTO == null) {
			return;
		}
		if (StringUtils.isBlank(drugCompDTO.getMi_code())) {
			ClearInsurDrugDataBp bp = new ClearInsurDrugDataBp();
			bp.exec(drugCompDTO);
			return;
		}
		DrugManualCompDTO bdHpFwssOrginalDO = GetInsurDiByCode(drugCompDTO.getId_hp(), drugCompDTO.getMi_code());
		CompInsurDrugData(drugCompDTO, bdHpFwssOrginalDO);
	}

	/**
	 * 使用医保药品编码查询医保药品
	 * 
	 * @param hpId
	 * @param insurDrugCode
	 * @return
	 * @throws BizException
	 */
	private DrugManualCompDTO GetInsurDiByCode(String hpId, String insurDrugCode) throws BizException {
		MiContext miContext = new MiContext();
		miContext.setIdHp(hpId);
		MiFacade miFacade = new MiFacade(miContext);
		LoadOrginalDataInParam inParam = new LoadOrginalDataInParam();
		inParam.setDirtype(MiDirEnum.MIDIRDRUG);
		inParam.setId_hp(hpId);
		FArrayList list = new FArrayList();
		Collections.addAll(list,insurDrugCode);
		inParam.setCodes(list);
		MiResultOutParam<LoadOrginalDataOutParam> outParam = miFacade.selectOrginalData(inParam);
		if (!outParam.getFg_deal().booleanValue()||!(outParam.getFg_HpSuccess()!=null&&outParam.getFg_HpSuccess().booleanValue())) {
			new BizException(outParam.getErrorMsg());
		}
		LoadOrginalDataOutParam orginalDataOutParam = outParam.getData();
		if (!MiDirEnum.MIDIRDRUG.equals(orginalDataOutParam.getDirtype())) {
			new BizException("查询已对照原始目录信息出错，请联系工程师！出错信息——his目录类型："+inParam.getDirtype()+"；客开返回目录类型："+orginalDataOutParam.getDirtype());
		}
		DrugManualCompDTO[] result = ToolUtils.ToList(orginalDataOutParam.getDetail()).toArray(new DrugManualCompDTO[orginalDataOutParam.getDetail().size()]);
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
	private void CompInsurDrugData(DrugManualCompDTO drugCompDTO, DrugManualCompDTO bdHpDrugOrginalDO) {
		if (drugCompDTO == null || bdHpDrugOrginalDO == null) {
			return;
		}
		drugCompDTO.setId_hpdrugorginal(bdHpDrugOrginalDO.getId_hpdrugorginal());
		drugCompDTO.setMi_name(bdHpDrugOrginalDO.getMi_name());
		drugCompDTO.setMi_code(bdHpDrugOrginalDO.getMi_code());
		drugCompDTO.setMi_code_ca(bdHpDrugOrginalDO.getMi_code_ca());
		drugCompDTO.setMi_name_ca(bdHpDrugOrginalDO.getMi_name_ca());
		drugCompDTO.setMi_sd_hpsrvtp(bdHpDrugOrginalDO.getMi_sd_hpsrvtp());
		drugCompDTO.setMi_price_fixed(bdHpDrugOrginalDO.getMi_price_fixed());
		drugCompDTO.setMi_limit_reimb_des(bdHpDrugOrginalDO.getMi_limit_reimb_des());
		drugCompDTO.setMi_dt_b(bdHpDrugOrginalDO.getMi_dt_b());
		drugCompDTO.setMi_dt_e(bdHpDrugOrginalDO.getMi_dt_e());
		drugCompDTO.setMi_rate_self_oep(bdHpDrugOrginalDO.getMi_rate_self_oep());
		drugCompDTO.setMi_rate_self_ip(bdHpDrugOrginalDO.getMi_rate_self_ip());
		drugCompDTO.setMi_rate_retire(bdHpDrugOrginalDO.getMi_rate_retire());
		drugCompDTO.setMi_rate_injury(bdHpDrugOrginalDO.getMi_rate_injury());
		drugCompDTO.setMi_rate_birth(bdHpDrugOrginalDO.getMi_rate_birth());
		drugCompDTO.setMi_rate_unit(bdHpDrugOrginalDO.getMi_rate_unit());
		drugCompDTO.setMi_drug_type(bdHpDrugOrginalDO.getMi_drug_type());
		drugCompDTO.setMi_fg_oct(bdHpDrugOrginalDO.getMi_fg_oct());
		drugCompDTO.setMi_drug_grade(bdHpDrugOrginalDO.getMi_drug_grade());
		drugCompDTO.setMi_dose_unit(bdHpDrugOrginalDO.getMi_dose_unit());
		drugCompDTO.setMi_dosage(bdHpDrugOrginalDO.getMi_dosage());
		drugCompDTO.setMi_dosage_name(bdHpDrugOrginalDO.getMi_dosage_name());
		drugCompDTO.setMi_single_dose(bdHpDrugOrginalDO.getMi_single_dose());
		drugCompDTO.setMi_freq(bdHpDrugOrginalDO.getMi_freq());
		drugCompDTO.setMi_usage(bdHpDrugOrginalDO.getMi_usage());
		drugCompDTO.setMi_spec(bdHpDrugOrginalDO.getMi_spec());
		drugCompDTO.setMi_unit(bdHpDrugOrginalDO.getMi_unit());
		drugCompDTO.setMi_fg_hosp_prep(bdHpDrugOrginalDO.getMi_fg_hosp_prep());
		drugCompDTO.setMi_hospital_code(bdHpDrugOrginalDO.getMi_hospital_code());
		drugCompDTO.setMi_fg_bidding_drug(bdHpDrugOrginalDO.getMi_fg_bidding_drug());
		drugCompDTO.setMi_bidding_price(bdHpDrugOrginalDO.getMi_bidding_price());
		drugCompDTO.setMi_fg_spec_drug(bdHpDrugOrginalDO.getMi_fg_spec_drug());
		drugCompDTO.setMi_drug_tradename(bdHpDrugOrginalDO.getMi_drug_tradename());
		drugCompDTO.setMi_tradename_price(bdHpDrugOrginalDO.getMi_tradename_price());
		drugCompDTO.setMi_tradename_pycode(bdHpDrugOrginalDO.getMi_tradename_pycode());
		drugCompDTO.setMi_tradename_wbcode(bdHpDrugOrginalDO.getMi_tradename_wbcode());
		drugCompDTO.setMi_pharm_name(bdHpDrugOrginalDO.getMi_pharm_name());
		drugCompDTO.setMi_quasi_drug(bdHpDrugOrginalDO.getMi_quasi_drug());
		drugCompDTO.setMi_handle_emp(bdHpDrugOrginalDO.getMi_handle_emp());
		drugCompDTO.setMi_dt_handle(bdHpDrugOrginalDO.getMi_dt_handle());
		drugCompDTO.setMi_origin_place(bdHpDrugOrginalDO.getMi_origin_place());
		drugCompDTO.setMi_fg_effective(bdHpDrugOrginalDO.getMi_fg_effective());
		drugCompDTO.setMi_fg_resident_use(bdHpDrugOrginalDO.getMi_fg_resident_use());
		drugCompDTO.setMi_disease_limit_pay(bdHpDrugOrginalDO.getMi_disease_limit_pay());
		drugCompDTO.setMi_py_code(bdHpDrugOrginalDO.getMi_py_code());
		drugCompDTO.setMi_wb_code(bdHpDrugOrginalDO.getMi_wb_code());
		drugCompDTO.setMi_fg_prc_druglist(bdHpDrugOrginalDO.getMi_fg_prc_druglist());
		drugCompDTO.setMi_def1(bdHpDrugOrginalDO.getMi_def1());
		drugCompDTO.setMi_def2(bdHpDrugOrginalDO.getMi_def2());
		drugCompDTO.setMi_def3(bdHpDrugOrginalDO.getMi_def3());
		drugCompDTO.setMi_def4(bdHpDrugOrginalDO.getMi_def4());
		drugCompDTO.setMi_def5(bdHpDrugOrginalDO.getMi_def5());
		drugCompDTO.setMi_def6(bdHpDrugOrginalDO.getMi_def6());
		drugCompDTO.setMi_def7(bdHpDrugOrginalDO.getMi_def7());
		drugCompDTO.setMi_def8(bdHpDrugOrginalDO.getMi_def8());
		drugCompDTO.setMi_def9(bdHpDrugOrginalDO.getMi_def9());
		drugCompDTO.setMi_def10(bdHpDrugOrginalDO.getMi_def10());
		drugCompDTO.setMi_def11(bdHpDrugOrginalDO.getMi_def11());
		drugCompDTO.setMi_def12(bdHpDrugOrginalDO.getMi_def12());
		drugCompDTO.setMi_def13(bdHpDrugOrginalDO.getMi_def13());
		drugCompDTO.setMi_def14(bdHpDrugOrginalDO.getMi_def14());
		drugCompDTO.setMi_def15(bdHpDrugOrginalDO.getMi_def15());
		drugCompDTO.setMi_def16(bdHpDrugOrginalDO.getMi_def16());
		drugCompDTO.setMi_def17(bdHpDrugOrginalDO.getMi_def17());
		drugCompDTO.setMi_def18(bdHpDrugOrginalDO.getMi_def18());
		drugCompDTO.setMi_def19(bdHpDrugOrginalDO.getMi_def19());
		drugCompDTO.setMi_def20(bdHpDrugOrginalDO.getMi_def20());
		if (drugCompDTO.getStatus() == DOStatus.UNCHANGED) {
			drugCompDTO.setStatus(DOStatus.UPDATED);
		}
	}
}
