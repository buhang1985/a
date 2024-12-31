package iih.bd.mhi.hpdrugdircomp.s.bp;

import java.util.ArrayList;

import iih.bd.mhi.docenum.d.DirCompState;
import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDO;
import iih.bd.mhi.hpdrugdircomp.s.bp.sql.AutoCompHpDrugByCodeSql;
import iih.bd.mhi.hpdrugdircomp.s.bp.sql.AutoCompHpDrugByNameAndCodeSql;
import iih.bd.mhi.hpdrugdircomp.s.bp.sql.AutoCompHpDrugByNameSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 药品目录自动对照业务逻辑
 * 
 * @author hexx
 * @version 创建时间：2018年2月2日 上午9:21:37 药品目录自动对照业务逻辑
 */
public class AutoCompHpDrugBp {

	/**
	 * 业务执行
	 * 
	 * @param hpId
	 * @throws BizException
	 */
	public void exec(String hpId) throws BizException {
		HpDrugDirCompDO[] hpdrugdircompDOs = AutoCompHpDrug(hpId);
		HpDrugDirCompDO[] hpdrugDirCompDos = SetDefaultValue(hpId, hpdrugdircompDOs);
		save(hpdrugDirCompDos);

		HpDrugDirCompDO[] hpdrugDirCompDOByName = AutoCompHpDrugByName(hpId);
		HpDrugDirCompDO[] hpdrugDirCompDosByName = SetDefaultValue(hpId, hpdrugDirCompDOByName);
		save(hpdrugDirCompDosByName);

		HpDrugDirCompDO[] hpdrugDirCompDOByCode = AutoCompHpDrugByCode(hpId);
		HpDrugDirCompDO[] hpdrugDirCompDosByCode = SetDefaultValue(hpId, hpdrugDirCompDOByCode);
		save(hpdrugDirCompDosByCode);
	}

	/**
	 * 保存数据
	 * 
	 * @param drugDirCompDo
	 * @throws DAException
	 */
	private void save(HpDrugDirCompDO[] drugDirCompDo) throws DAException {
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(drugDirCompDo);
	}

	/**
	 * 设置默认属性
	 * 
	 * @param hpId
	 * @param drugdircompDOs
	 * @return
	 */
	private HpDrugDirCompDO[] SetDefaultValue(String hpId, HpDrugDirCompDO[] drugdircompDOs) {
		for (HpDrugDirCompDO drugdircompDO : drugdircompDOs) {
			drugdircompDO.setId_grp(Context.get().getGroupId());
			drugdircompDO.setId_org(Context.get().getOrgId());
			drugdircompDO.setId_hp(hpId);
			drugdircompDO.setEu_status(DirCompState.COMPED);
		}
		return drugdircompDOs;
	}

	/**
	 * 通过名称进行对照
	 * 
	 * @return
	 * @throws DAException
	 */
	private HpDrugDirCompDO[] AutoCompHpDrugByName(String hpId) throws DAException {
		DAFacade daFacade = new DAFacade();
		AutoCompHpDrugByNameSql sql = new AutoCompHpDrugByNameSql(hpId);
		@SuppressWarnings("unchecked")
		ArrayList<HpDrugDirCompDO> drugdircompDOList = (ArrayList<HpDrugDirCompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(HpDrugDirCompDO.class));
		return drugdircompDOList.toArray(new HpDrugDirCompDO[0]);
	}

	/**
	 * 通过code进行对照
	 * 
	 * @return
	 * @throws DAException
	 */
	private HpDrugDirCompDO[] AutoCompHpDrugByCode(String hpId) throws DAException {
		DAFacade daFacade = new DAFacade();
		AutoCompHpDrugByCodeSql sql = new AutoCompHpDrugByCodeSql(hpId);
		@SuppressWarnings("unchecked")
		ArrayList<HpDrugDirCompDO> drugdircompDOList = (ArrayList<HpDrugDirCompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(HpDrugDirCompDO.class));
		return drugdircompDOList.toArray(new HpDrugDirCompDO[0]);
	}

	/**
	 * 进行对照
	 * 
	 * @param hpId
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private HpDrugDirCompDO[] AutoCompHpDrug(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompHpDrugByNameAndCodeSql sql = new AutoCompHpDrugByNameAndCodeSql(hpId);
		ArrayList<HpDrugDirCompDO> drugdircompDOList = (ArrayList<HpDrugDirCompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(HpDrugDirCompDO.class));
		return drugdircompDOList.toArray(new HpDrugDirCompDO[0]);
	}
}
