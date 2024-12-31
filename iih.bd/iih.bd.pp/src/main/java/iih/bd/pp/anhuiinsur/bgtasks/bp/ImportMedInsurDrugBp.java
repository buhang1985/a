package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import iih.bd.pp.anhuisrvorca.s.bp.SyncInsurDrugDataBp;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 导入医保药品目录数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurDrugBp {
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

	public void exec(InputStream fileStream, HPDO hpdo) throws BizException {
		ImportMedInsurDrug(fileStream, hpdo);
		syncInsurDrugData(hpdo);
	}

	/**
	 * 同步医保药品数据_同步记录表数据到对照表
	 * 
	 * @param hpdo
	 * @throws BizException
	 */
	private void syncInsurDrugData(HPDO hpdo) throws BizException {
		SyncInsurDrugDataBp bp = new SyncInsurDrugDataBp();
		bp.exec(hpdo.getId_hp(), null);
	}

	/**
	 * 导入医保药品目录
	 * 
	 * @param fileStream
	 * @param hpdo
	 * @throws BizException
	 */
	private void ImportMedInsurDrug(InputStream fileStream, HPDO hpdo) throws BizException {
		ClearOldData(hpdo);

		DeserializeBp<BdHpDrugOrginalDO> bp = new DeserializeBp<BdHpDrugOrginalDO>(this._propNameMapping);
		FDateTime srvDateTime = AppUtils.getServerDateTime();
		ArrayList<BdHpDrugOrginalDO> bufferList = new ArrayList<BdHpDrugOrginalDO>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(fileStream, "GB2312"));
			String lineStr = reader.readLine();
			while (StringUtils.isNotEmpty(lineStr)) {
				BdHpDrugOrginalDO newData = bp.exec(lineStr, BdHpDrugOrginalDO.class);
				boolean isEffective = CheckEffective(newData, srvDateTime);
				if (isEffective) {
					bufferList.add(newData);
				}
				if (bufferList.size() >= this._bufferSize) {
					// 达到缓冲区最大值时保存到数据库
					SaveMedInsurDrug(bufferList, hpdo);
					bufferList.clear();
				}
				lineStr = reader.readLine();
			}
			if (bufferList.size() > 0) {
				SaveMedInsurDrug(bufferList, hpdo);
				bufferList.clear();
			}

		} catch (IOException e) {
			throw new BizException(e);
		}
	}

	/**
	 * 清空旧数据
	 * 
	 * @param hpdo
	 * @throws BizException
	 */
	private void ClearOldData(HPDO hpdo) throws BizException {
		String wherePart = String.format("id_hp = '%s'", hpdo.getId_hp());

		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(BdHpDrugOrginalDO.class, wherePart);
	}

	/**
	 * 检查数据有效性
	 * 
	 * @param newData
	 * @param srvDateTime
	 * @return
	 */
	private boolean CheckEffective(BdHpDrugOrginalDO newData, FDateTime srvDateTime) {
		if (newData != null && newData.getDt_b() != null && newData.getDt_b().before(srvDateTime)
				&& (newData.getDt_e() == null || newData.getDt_e().after(srvDateTime))
				&& StringUtils.isNotEmpty(newData.getStr_effective()) && newData.getStr_effective().equals("1")) {
			return true;
		}
		return false;
	}

	/**
	 * 保存药品目录数据到数据库
	 * 
	 * @param dataList
	 * @param hpdo
	 * @throws BizException
	 */
	private void SaveMedInsurDrug(ArrayList<BdHpDrugOrginalDO> dataList, HPDO hpdo) throws BizException {
		BdHpDrugOrginalDO[] medInsurDrugs = dataList.toArray(new BdHpDrugOrginalDO[0]);
		// 初始化共通属性值
		InitCommProp(medInsurDrugs, hpdo);
		// 保存到数据库
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(medInsurDrugs);
	}

	/**
	 * 初始化共通属性
	 * 
	 * @param medInsurDrugs
	 * @param hpdo
	 */
	private void InitCommProp(BdHpDrugOrginalDO[] medInsurDrugs, HPDO hpdo) {
		for (BdHpDrugOrginalDO drugOrginalDO : medInsurDrugs) {
			drugOrginalDO.setId_grp(Context.get().getGroupId());
			drugOrginalDO.setId_org(Context.get().getOrgId());
			drugOrginalDO.setId_hp(hpdo.getId_hp());
		}
	}
}
