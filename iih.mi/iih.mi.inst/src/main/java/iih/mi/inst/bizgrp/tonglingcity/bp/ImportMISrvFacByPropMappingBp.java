package iih.mi.inst.bizgrp.tonglingcity.bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.mi.bd.d.HpDTO;
import iih.mi.inst.bizbase.bp.DeserializeBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 导入医保服务设施目录数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ImportMISrvFacByPropMappingBp {
	// 缓冲区大小
	private final int _bufferSize = 10000;

	private final String[] _propNameMapping;

	public ImportMISrvFacByPropMappingBp(String[] propNameMapping) {
		this._propNameMapping = propNameMapping;
	}

	public void exec(InputStream fileStream, HpDTO hpDTO) throws BizException {
		ImportMedInsurFwss(fileStream, hpDTO);
		syncInsurFwssData(hpDTO);
	}

	/**
	 * 同步医保服务设施数据_同步记录表数据到对照表
	 * 
	 * @param hpDTO
	 * @throws BizException
	 */
	private void syncInsurFwssData(HpDTO hpDTO) throws BizException {
		SyncInsurFwssDataBp bp = new SyncInsurFwssDataBp();
		bp.exec(hpDTO.getId_hp(), null);
	}

	/**
	 * 导入医保服务设施目录
	 * 
	 * @param fileStream
	 * @param hpDTO
	 * @throws BizException
	 */
	private void ImportMedInsurFwss(InputStream fileStream, HpDTO hpDTO) throws BizException {
		ClearOldData(hpDTO);

		DeserializeBp<BdHpFwssOrginalDO> bp = new DeserializeBp<BdHpFwssOrginalDO>(this._propNameMapping);
		FDateTime srvDateTime = AppUtils.getServerDateTime();
		ArrayList<BdHpFwssOrginalDO> dataList = new ArrayList<BdHpFwssOrginalDO>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream, "UTF-8"));
			String lineStr = reader.readLine();
			while (StringUtils.isNotEmpty(lineStr)) {
				BdHpFwssOrginalDO newData = bp.exec(lineStr, BdHpFwssOrginalDO.class);
				boolean isEffective = CheckEffective(newData, srvDateTime);
				if (isEffective) {
					dataList.add(newData);
				}
				if (dataList.size() >= this._bufferSize) {
					// 达到缓冲区最大值时保存到数据库
					SaveMedInsurFwss(dataList, hpDTO);
					dataList.clear();
				}
				lineStr = reader.readLine();
			}
			if (dataList.size() > 0) {
				SaveMedInsurFwss(dataList, hpDTO);
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
		daFacade.deleteByWhere(BdHpFwssOrginalDO.class, wherePart);
	}

	/**
	 * 检查数据有效性
	 * 
	 * @param newData
	 * @param srvDateTime
	 * @return
	 */
	private boolean CheckEffective(BdHpFwssOrginalDO newData, FDateTime srvDateTime) {
		if (newData != null && newData.getDt_b() != null && newData.getDt_b().before(srvDateTime)
				&& (newData.getDt_e() == null || newData.getDt_e().after(srvDateTime))
				&& StringUtils.isNotEmpty(newData.getStr_effective()) && newData.getStr_effective().equals("1")) {
			return true;
		}
		return false;
	}

	/**
	 * 保存服务设施目录数据到数据库
	 * 
	 * @param dataList
	 * @param hpDTO
	 * @throws BizException
	 */
	private void SaveMedInsurFwss(ArrayList<BdHpFwssOrginalDO> dataList, HpDTO hpDTO) throws BizException {
		BdHpFwssOrginalDO[] medInsurFwsss = dataList.toArray(new BdHpFwssOrginalDO[0]);
		// 初始化共通属性值
		InitCommProp(medInsurFwsss, hpDTO);
		// 保存到数据库
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(medInsurFwsss);
	}

	/**
	 * 初始化共通属性
	 * 
	 * @param medInsurFwsss
	 * @param hpDTO
	 */
	private void InitCommProp(BdHpFwssOrginalDO[] medInsurFwsss, HpDTO hpDTO) {
		for (BdHpFwssOrginalDO fwssOrginalDO : medInsurFwsss) {
			fwssOrginalDO.setId_grp(Context.get().getGroupId());
			fwssOrginalDO.setId_org(Context.get().getOrgId());
			fwssOrginalDO.setId_hp(hpDTO.getId_hp());
		}
	}
}
