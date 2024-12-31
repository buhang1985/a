package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import iih.bd.pp.anhuisrvorca.s.bp.SyncInsurZlDataBp;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 导入医保诊疗目录数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurZlBp {
	// 缓冲区大小
	private final int _bufferSize = 10000;

	private final String[] _propNameMapping = new String[] { "Code", "Dt_b", "Name", "Code_ca", "Sd_hpsrvtp",
			"Pay_self_tp", "Str_approve", "Str_two_insurpay", "Str_add_insur", "Str_add_insur_sal", "Str_special_itm",
			"Origin_place", "Pri_max", "Retire_ey_pri_max", "Amt_prepay_max", "Domestic_pri_max", "Rate_self_oep",
			"Rate_self_ip", "Rate_retire", "Rate_injury", "Rate_birth", "Rate_ey", "Rate_unit", "Rate_family",
			"Rate_import_diff", "Str_hospital_help", "Hospital_code", "Unit", "Py_code", "Wb_code", "Zdy_code",
			"Firm_name", "Id_emp_handle", "Dt_handle", "Dt_e", "Note", "Des", "Str_effective" };

	public void exec(InputStream fileStream, HPDO hpdo) throws BizException {
		ImportMedInsurZl(fileStream, hpdo);
		syncInsurZlData(hpdo);
	}

	/**
	 * 同步医保诊疗数据_同步记录表数据到对照表
	 * 
	 * @param hpdo
	 * @throws BizException
	 */
	private void syncInsurZlData(HPDO hpdo) throws BizException {
		SyncInsurZlDataBp bp = new SyncInsurZlDataBp();
		bp.exec(hpdo.getId_hp(), null);
	}

	/**
	 * 导入医保诊疗目录
	 * 
	 * @param fileStream
	 * @param hpdo
	 * @throws BizException
	 */
	private void ImportMedInsurZl(InputStream fileStream, HPDO hpdo) throws BizException {
		ClearOldData(hpdo);

		DeserializeBp<BdHpZlOrginalDO> bp = new DeserializeBp<BdHpZlOrginalDO>(this._propNameMapping);
		FDateTime srvDateTime = AppUtils.getServerDateTime();
		ArrayList<BdHpZlOrginalDO> dataList = new ArrayList<BdHpZlOrginalDO>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
		try {
			String lineStr = reader.readLine();
			while (StringUtils.isNotEmpty(lineStr)) {
				BdHpZlOrginalDO newData = bp.exec(lineStr, BdHpZlOrginalDO.class);
				boolean isEffective = CheckEffective(newData, srvDateTime);
				if (isEffective) {
					dataList.add(newData);
				}
				if (dataList.size() >= this._bufferSize) {
					// 达到缓冲区最大值时保存到数据库
					SaveMedInsurZl(dataList, hpdo);
					dataList.clear();
				}
				lineStr = reader.readLine();
			}
			if (dataList.size() > 0) {
				SaveMedInsurZl(dataList, hpdo);
				dataList.clear();
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
		daFacade.deleteByWhere(BdHpZlOrginalDO.class, wherePart);
	}

	/**
	 * 检查数据有效性
	 * 
	 * @param newData
	 * @param srvDateTime
	 * @return
	 */
	private boolean CheckEffective(BdHpZlOrginalDO newData, FDateTime srvDateTime) {
		if (newData != null && newData.getDt_b() != null && newData.getDt_b().before(srvDateTime)
				&& (newData.getDt_e() == null || newData.getDt_e().after(srvDateTime))
				&& StringUtils.isNotEmpty(newData.getStr_effective()) && newData.getStr_effective().equals("1")) {
			return true;
		}
		return false;
	}

	/**
	 * 保存诊疗目录数据到数据库
	 * 
	 * @param dataList
	 * @param hpdo
	 * @throws BizException
	 */
	private void SaveMedInsurZl(ArrayList<BdHpZlOrginalDO> dataList, HPDO hpdo) throws BizException {
		BdHpZlOrginalDO[] medInsurZls = dataList.toArray(new BdHpZlOrginalDO[0]);
		// 初始化共通属性值
		InitCommProp(medInsurZls, hpdo);
		// 保存到数据库
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(medInsurZls);
	}

	/**
	 * 初始化共通属性
	 * 
	 * @param medInsurZls
	 * @param hpdo
	 */
	private void InitCommProp(BdHpZlOrginalDO[] medInsurZls, HPDO hpdo) {
		for (BdHpZlOrginalDO zlOrginalDO : medInsurZls) {
			zlOrginalDO.setId_grp(Context.get().getGroupId());
			zlOrginalDO.setId_org(Context.get().getOrgId());
			zlOrginalDO.setId_hp(hpdo.getId_hp());
		}
	}
}
