package iih.mi.inst.bizgrp.tonglingcity.bp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import iih.mi.bd.d.HpDTO;
import iih.mi.biz.dto.d.MiSrvTp;
import iih.mi.itf.facade.HpCacheProxy;
import xap.mw.core.data.BizException;

/**
 * 导入医保目录数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurBp {

	public void exec(String fileKey, String hpId, String miSrvTp) throws BizException {
		// InputStream fileStream = FileServerUtils.Download(fileKey, true);
		InputStream fileStream = null;
		try {
			fileStream = new FileInputStream("D:\\zzyb\\YPML_19000101000100.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImportMedInsur(fileStream, hpId, miSrvTp);
	}

	/**
	 * 导入医保目录数据
	 * 
	 * @param fileStream
	 *            文件流
	 * @param hpCode
	 *            医保计划编码
	 * @param miSrvTp
	 *            医保项目类型
	 * @throws BizException
	 */
	private void ImportMedInsur(InputStream fileStream, String hpId, String miSrvTp) throws BizException {
		HpDTO hpDTO = HpCacheProxy.getHpDTOById(hpId);

		if (miSrvTp.equals(MiSrvTp.DRUG)) {
			ImportMedInsurDrug(fileStream, hpDTO);
		} else if (miSrvTp.equals(MiSrvTp.TREAT)) {
			ImportMedInsurZl(fileStream, hpDTO);
		} else if (miSrvTp.equals(MiSrvTp.SRVFAC)) {
			ImportMedInsurFwss(fileStream, hpDTO);
		}
	}

	/**
	 * 导入医保药品目录数据
	 * 
	 * @param fileStream
	 *            文件流
	 * @param hpdo
	 *            医保计划
	 * @throws BizException
	 */
	private void ImportMedInsurDrug(InputStream fileStream, HpDTO hpDTO) throws BizException {
		String[] _propNameMapping = new String[] { "Code", "Name", "Name_english", "Code_ca", "Str_oct", "Drug_grade",
				"Py_code", "Dose_unit", "Pri_max", "Amt_prepay_max", "Retire_ey_pri_max", "Rate_self_oep",
				"Rate_self_ip", "Rate_retire", "Rate_injury", "Rate_birth", "Rate_ey", "Rate_family", "Str_prep_self",
				"Hospital_code", "Str_approve", "Min_hospital_rank", "Min_doctor_rank", "Str_add_insur",
				"Str_add_insur_sal", "Str_bidding_drug", "Bidding_price", "Str_spec_drug", "Str_two_insurpay", "Dosage",
				"Single_dose", "Freq", "Usage", "Wb_code", "Unit", "Spec", "Max_use_days", "Drug_name",
				"Drug_name_price", "Drug_name_pycode", "Drug_name_wbcode", "Pharm_firm_name", "Prc_drug_certi",
				"Id_emp_handle", "Dt_handle", "Dt_b", "Dt_e", "Note", "Zdy_code", "Prc_direc_code", "Reference_price",
				"Reference_hospital", "Des", "Origin_place", "Str_effective" };

		ImportMIDrugByPropNamesBp bp = new ImportMIDrugByPropNamesBp(_propNameMapping);
		bp.exec(fileStream, hpDTO);
	}

	/**
	 * 导入医保诊疗目录数据
	 * 
	 * @param fileStream
	 *            文件流
	 * @param hpdo
	 *            医保计划
	 * @throws BizException
	 */
	private void ImportMedInsurZl(InputStream fileStream, HpDTO hpDTO) throws BizException {
		String[] propNameMapping = new String[] { "Code", "Dt_b", "Name", "Code_ca", "Sd_hpsrvtp", "Pay_self_tp",
				"Str_approve", "Str_two_insurpay", "Str_add_insur", "Str_add_insur_sal", "Str_special_itm",
				"Origin_place", "Pri_max", "Retire_ey_pri_max", "Amt_prepay_max", "Domestic_pri_max", "Rate_self_oep",
				"Rate_self_ip", "Rate_retire", "Rate_injury", "Rate_birth", "Rate_ey", "Rate_unit", "Rate_family",
				"Rate_import_diff", "Str_hospital_help", "Hospital_code", "Unit", "Py_code", "Wb_code", "Zdy_code",
				"Firm_name", "Id_emp_handle", "Dt_handle", "Dt_e", "Note", "Des", "Str_effective" };

		ImportMITreatByPropNamesBp bp = new ImportMITreatByPropNamesBp(propNameMapping);
		bp.exec(fileStream, hpDTO);
	}

	/**
	 * 导入医保服务设施目录数据
	 * 
	 * @param fileStream
	 *            文件流
	 * @param hpdo
	 *            医保计划
	 */
	private void ImportMedInsurFwss(InputStream fileStream, HpDTO hpDTO) throws BizException {
		String[] propNameMapping = new String[] { "Code", "Name", "Dt_b", "Code_ca", "Hospital_rank",
				"Hospital_bed_rank", "Fwss_pay_standard", "Pri_max", "Retire_ey_pri_max", "Py_code", "Wb_code", "Des",
				"Dt_e", "Id_emp_handle", "Dt_handle", "Str_effective" };

		ImportMISrvFacByPropMappingBp bp = new ImportMISrvFacByPropMappingBp(propNameMapping);
		bp.exec(fileStream, hpDTO);
	}
}
