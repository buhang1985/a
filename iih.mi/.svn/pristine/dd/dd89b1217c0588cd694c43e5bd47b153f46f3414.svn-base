package iih.mi.inst.bizgrp.tonglingcity.bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import iih.mi.bd.d.HpDTO;
import iih.mi.inst.bizbase.bp.DeserializeBp;
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
public class ImportMITreatByPropNamesBp {
	// 缓冲区大小
	private final int _bufferSize = 10000;

	private final String[] _propNameMapping;

	public ImportMITreatByPropNamesBp(String[] propNameMapping) {
		this._propNameMapping = propNameMapping;
	}

	public void exec(InputStream fileStream, HpDTO hpDTO) throws BizException {
		ImportMedInsurZl(fileStream, hpDTO);
		syncInsurZlData(hpDTO);
	}

	/**
	 * 同步医保诊疗数据_同步记录表数据到对照表
	 * 
	 * @param hpDTO
	 * @throws BizException
	 */
	private void syncInsurZlData(HpDTO hpDTO) throws BizException {
		SyncInsurZlDataBp bp = new SyncInsurZlDataBp();
		bp.exec(hpDTO.getId_hp(), null);
	}

	/**
	 * s 导入医保诊疗目录
	 * 
	 * @param fileStream
	 * @param hpDTO
	 * @throws BizException
	 */
	private void ImportMedInsurZl(InputStream fileStream, HpDTO hpDTO) throws BizException {
		ClearOldData(hpDTO);

		DeserializeBp<BdHpZlOrginalDO> bp = new DeserializeBp<BdHpZlOrginalDO>(this._propNameMapping);
		FDateTime srvDateTime = AppUtils.getServerDateTime();
		ArrayList<BdHpZlOrginalDO> dataList = new ArrayList<BdHpZlOrginalDO>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream, "UTF-8"));
			String lineStr = reader.readLine();
			while (StringUtils.isNotEmpty(lineStr)) {
				BdHpZlOrginalDO newData = bp.exec(lineStr, BdHpZlOrginalDO.class);
				boolean isEffective = CheckEffective(newData, srvDateTime);
				if (isEffective) {
					dataList.add(newData);
				}
				if (dataList.size() >= this._bufferSize) {
					// 达到缓冲区最大值时保存到数据库
					SaveMedInsurZl(dataList, hpDTO);
					dataList.clear();
				}
				lineStr = reader.readLine();
			}
			if (dataList.size() > 0) {
				SaveMedInsurZl(dataList, hpDTO);
				dataList.clear();
			}

		} catch (IOException e) {
			throw new BizException(e);
		}
	}

	/**
	 * 清空旧数据
	 * 
	 * @param hpDTO
	 * @throws BizException
	 */
	private void ClearOldData(HpDTO hpDTO) throws BizException {
		String wherePart = String.format("id_hp = '%s'", hpDTO.getId_hp());

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
	 * @param hpDTO
	 * @throws BizException
	 */
	private void SaveMedInsurZl(ArrayList<BdHpZlOrginalDO> dataList, HpDTO hpDTO) throws BizException {
		BdHpZlOrginalDO[] medInsurZls = dataList.toArray(new BdHpZlOrginalDO[0]);
		// 初始化共通属性值
		InitCommProp(medInsurZls, hpDTO);
		// 保存到数据库
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(medInsurZls);
	}

	/**
	 * 初始化共通属性
	 * 
	 * @param medInsurZls
	 * @param hpDTO
	 */
	private void InitCommProp(BdHpZlOrginalDO[] medInsurZls, HpDTO hpDTO) {
		for (BdHpZlOrginalDO zlOrginalDO : medInsurZls) {
			zlOrginalDO.setId_grp(Context.get().getGroupId());
			zlOrginalDO.setId_org(Context.get().getOrgId());
			zlOrginalDO.setId_hp(hpDTO.getId_hp());
		}
	}
}
