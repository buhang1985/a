package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurtreatrec.d.MedInsurTreatRecDO;
import iih.bd.pp.medinsurtreatrec.i.IMedinsurtreatrecCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 导入医保诊疗业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurZlRecBp {

	// 缓冲区大小
	private final int _bufferSize = 10000;

	private final String[] _propNameMapping = new String[] { "Code", "Dt_b", "Name", "Code_ca", "Sd_hpsrvtp",
			"Pay_self_tp", "Str_approve", "Str_two_insurpay", "Str_add_insur", "Str_add_insur_sal", "Str_special_itm",
			"Origin_place", "Pri_max", "Retire_ey_pri_max", "Amt_prepay_max", "Domestic_pri_max", "Rate_self_oep",
			"Rate_self_ip", "Rate_retire", "Rate_injury", "Rate_birth", "Rate_ey", "Rate_unit", "Rate_family",
			"Rate_import_diff", "Str_hospital_help", "Hospital_code", "Unit", "Py_code", "Wb_code", "Zdy_code",
			"Firm_name", "Id_emp_handle", "Dt_handle", "Dt_e", "Note", "Des", "Str_effective" };

	public void exec(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec) throws BizException {
		SaveMedInsurTreat(fileStream, medInsurFileDownRec);
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
	private void SaveMedInsurTreat(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		DeserializeBp<MedInsurTreatRecDO> bp = new DeserializeBp<MedInsurTreatRecDO>(this._propNameMapping);

		ArrayList<MedInsurTreatRecDO> dataList = new ArrayList<MedInsurTreatRecDO>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
		try {
			String lineStr = reader.readLine();
			while (StringUtils.isNotEmpty(lineStr)) {
				MedInsurTreatRecDO newData = bp.exec(lineStr, MedInsurTreatRecDO.class);
				if (newData != null) {
					dataList.add(newData);
				}
				if (dataList.size() >= this._bufferSize) {
					// 达到缓冲区最大值时保存到数据库
					SaveMedInsurTreat(dataList, medInsurFileDownRec);
					dataList.clear();
				}
				lineStr = reader.readLine();
			}
			if (dataList.size() > 0) {
				SaveMedInsurTreat(dataList, medInsurFileDownRec);
				dataList.clear();
			}

		} catch (IOException e) {
			throw new BizException(e);
		}
	}

	/**
	 * 保存诊疗目录数据到数据库
	 * 
	 * @param dataList
	 * @param hpdo
	 * @param medInsurFileDownRec
	 * @throws BizException
	 */
	private void SaveMedInsurTreat(ArrayList<MedInsurTreatRecDO> dataList, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		MedInsurTreatRecDO[] medInsurTreatRecs = dataList.toArray(new MedInsurTreatRecDO[0]);
		// 初始化共通属性值
		InitCommProp(medInsurTreatRecs, medInsurFileDownRec);
		// 保存到数据库
		IMedinsurtreatrecCudService medinsurTreatrecCudService = ServiceFinder.find(IMedinsurtreatrecCudService.class);
		medinsurTreatrecCudService.insert(medInsurTreatRecs);
	}

	/**
	 * 初始化共通属性
	 * 
	 * @param result
	 * @param hpdo
	 * @param medInsurFileDownRec
	 */
	private void InitCommProp(MedInsurTreatRecDO[] result, MedInsurFileDownRecDO medInsurFileDownRec) {
		for (MedInsurTreatRecDO medInsurTreatRec : result) {
			medInsurTreatRec.setId_grp(Context.get().getGroupId());
			medInsurTreatRec.setId_org(Context.get().getOrgId());
			medInsurTreatRec.setId_down(medInsurFileDownRec.getId_down());
		}
	}
}
