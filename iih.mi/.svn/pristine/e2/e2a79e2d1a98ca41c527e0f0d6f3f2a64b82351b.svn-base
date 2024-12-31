package iih.mi.inst.bizgrp.tonglingcity.bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import iih.mi.bd.d.HpDTO;
import iih.mi.inst.bizbase.bp.DeserializeBp;
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
public class ImportMIDrugByPropNamesBp {
	// 缓冲区大小
	private final int _bufferSize = 10000;

	private final String[] _propNameMapping;

	public ImportMIDrugByPropNamesBp(String[] propNameMapping) {
		this._propNameMapping = propNameMapping;
	}

	public void exec(InputStream fileStream, HpDTO hpDTO) throws BizException {
		ImportMedInsurDrug(fileStream, hpDTO);
		syncInsurDrugData(hpDTO);
	}

	/**
	 * 同步医保药品数据_同步记录表数据到对照表
	 * 
	 * @param hpdo
	 * @throws BizException
	 */
	private void syncInsurDrugData(HpDTO hpDTO) throws BizException {
		SyncInsurDrugDataBp bp = new SyncInsurDrugDataBp();
		bp.exec(hpDTO.getId_hp(), null);
	}

	/**
	 * 导入医保药品目录
	 * 
	 * @param fileStream
	 * @param hpdo
	 * @throws BizException
	 */
	private void ImportMedInsurDrug(InputStream fileStream, HpDTO hpDTO) throws BizException {
		ClearOldData(hpDTO);

		DeserializeBp<BdHpDrugOrginalDO> bp = new DeserializeBp<BdHpDrugOrginalDO>(this._propNameMapping);
		FDateTime srvDateTime = AppUtils.getServerDateTime();
		ArrayList<BdHpDrugOrginalDO> bufferList = new ArrayList<BdHpDrugOrginalDO>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(fileStream, "UTF-8"));
			String lineStr = reader.readLine();
			while (StringUtils.isNotEmpty(lineStr)) {
				BdHpDrugOrginalDO newData = bp.exec(lineStr, BdHpDrugOrginalDO.class);
				boolean isEffective = CheckEffective(newData, srvDateTime);
				if (isEffective) {
					bufferList.add(newData);
				}
				if (bufferList.size() >= this._bufferSize) {
					// 达到缓冲区最大值时保存到数据库
					SaveMedInsurDrug(bufferList, hpDTO);
					bufferList.clear();
				}
				lineStr = reader.readLine();
			}
			if (bufferList.size() > 0) {
				SaveMedInsurDrug(bufferList, hpDTO);
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
	private void ClearOldData(HpDTO hpDTO) throws BizException {
		String wherePart = String.format("id_hp = '%s'", hpDTO.getId_hp());

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
	private void SaveMedInsurDrug(ArrayList<BdHpDrugOrginalDO> dataList, HpDTO hpDTO) throws BizException {
		BdHpDrugOrginalDO[] medInsurDrugs = dataList.toArray(new BdHpDrugOrginalDO[0]);
		// 初始化共通属性值
		InitCommProp(medInsurDrugs, hpDTO);
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
	private void InitCommProp(BdHpDrugOrginalDO[] medInsurDrugs, HpDTO hpDTO) {
		for (BdHpDrugOrginalDO drugOrginalDO : medInsurDrugs) {
			drugOrginalDO.setId_grp(Context.get().getGroupId());
			drugOrginalDO.setId_org(Context.get().getOrgId());
			drugOrginalDO.setId_hp(hpDTO.getId_hp());
		}
	}
}
