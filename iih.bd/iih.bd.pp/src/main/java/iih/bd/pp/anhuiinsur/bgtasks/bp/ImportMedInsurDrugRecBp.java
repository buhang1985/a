package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurdrugrec.d.MedInsurDrugRecDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 导入医保药品业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurDrugRecBp {

	// 缓冲区大小
	private final int _bufferSize = 10000;

	private final String[] _propNameMapping = new String[] { "Code", "Name", "Name_english", "Code_ca", "Str_oct",
			"Drug_grade", "Py_code", "Dose_unit", "Pri_max", "Amt_prepay_max", "Retire_ey_pri_max", "Rate_self_oep",
			"Rate_self_ip", "Rate_retire", "Rate_injury", "Rate_birth", "Rate_ey", "Rate_family", "Str_prep_self",
			"Hospital_code", "Str_approve", "Min_hospital_rank", "Min_doctor_rank", "Str_add_insur",
			"Str_add_insur_sal", "Str_bidding_drug", "Bidding_price", "Str_spec_drug", "Str_two_insurpay", "Dosage",
			"Single_dose", "Freq", "Usage", "Wb_code", "Unit", "Spec", "Max_use_days", "Drug_name", "Drug_name_price",
			"Drug_name_pycode", "Drug_name_wbcode", "Pharm_firm_name", "Prc_drug_certi", "Id_emp_handle", "Dt_handle",
			"Dt_b", "Dt_e", "Note", "Zdy_code", "Prc_direc_code", "Reference_price", "Reference_hospital", "Des",
			"Origin_place", "Str_effective" };

	public void exec(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec) throws BizException {
		SaveMedInsurDrug(fileStream, medInsurFileDownRec);
		GenerateDataDiff(medInsurFileDownRec);
	}

	/**
	 * 生成数据差异
	 * 
	 * @param medInsurFileDownRec
	 * @throws BizException
	 */
	private void GenerateDataDiff(MedInsurFileDownRecDO medInsurFileDownRec) throws BizException {
		StartGenerateDiffInfoByDownIdBp bp = new StartGenerateDiffInfoByDownIdBp();
		bp.exec(medInsurFileDownRec);
	}

	/**
	 * 反序列化并保存到数据库
	 * 
	 * @param fileStream
	 * @param hpdo
	 * @param medInsurFileDownRec
	 * @throws BizException
	 */
	private void SaveMedInsurDrug(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		DeserializeBp<MedInsurDrugRecDO> bp = new DeserializeBp<MedInsurDrugRecDO>(this._propNameMapping);

		ArrayList<MedInsurDrugRecDO> dataList = new ArrayList<MedInsurDrugRecDO>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
		try {
			String lineStr = reader.readLine();
			while (StringUtils.isNotEmpty(lineStr)) {
				MedInsurDrugRecDO newData = bp.exec(lineStr, MedInsurDrugRecDO.class);
				if (newData != null) {
					dataList.add(newData);
				}
				if (dataList.size() >= this._bufferSize) {
					// 达到缓冲区最大值时保存到数据库
					SaveMedInsurDrug(dataList, medInsurFileDownRec);
					dataList.clear();
				}
				lineStr = reader.readLine();
			}
			if (dataList.size() > 0) {
				SaveMedInsurDrug(dataList, medInsurFileDownRec);
				dataList.clear();
			}

		} catch (IOException e) {
			throw new BizException(e);
		}
	}

	/**
	 * 保存药品目录数据到数据库
	 * 
	 * @param dataList
	 * @param hpdo
	 * @param medInsurFileDownRec
	 * @throws BizException
	 */
	private void SaveMedInsurDrug(ArrayList<MedInsurDrugRecDO> dataList, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		MedInsurDrugRecDO[] medInsurDrugRecs = dataList.toArray(new MedInsurDrugRecDO[0]);
		// 初始化共通属性值
		InitCommProp(medInsurDrugRecs, medInsurFileDownRec);
		// 保存到数据库
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(medInsurDrugRecs);
	}

	/**
	 * 初始化共通属性
	 * 
	 * @param result
	 * @param hpdo
	 * @param medInsurFileDownRec
	 */
	private void InitCommProp(MedInsurDrugRecDO[] result, MedInsurFileDownRecDO medInsurFileDownRec) {
		for (MedInsurDrugRecDO medInsurDrugRec : result) {
			medInsurDrugRec.setId_grp(Context.get().getGroupId());
			medInsurDrugRec.setId_org(Context.get().getOrgId());
			medInsurDrugRec.setId_down(medInsurFileDownRec.getId_down());
		}
	}
}
