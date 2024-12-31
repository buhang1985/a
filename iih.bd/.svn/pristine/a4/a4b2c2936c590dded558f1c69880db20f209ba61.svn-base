package iih.bd.mhi.hptreatdircomp.s.bp;

import java.util.ArrayList;

import iih.bd.mhi.docenum.d.DirCompState;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDO;
import iih.bd.mhi.hptreatdircomp.s.bp.sql.AutoCompHpTreatByCodeAndNameSql;
import iih.bd.mhi.hptreatdircomp.s.bp.sql.AutoCompHpTreatByCodeSql;
import iih.bd.mhi.hptreatdircomp.s.bp.sql.AutoCompTreatByNameSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class AutoTreatCompBp {

	public void exec(String hpId) throws BizException {
		HpTreatDirCompDO[] byCodeAndNameDOs = AutoCompHpTreatByCodeAndName(hpId);
		HpTreatDirCompDO[] byCodeAndNameDOsWithDf = SetDefaultValue(byCodeAndNameDOs, hpId);
		save(byCodeAndNameDOsWithDf);
		HpTreatDirCompDO[] byCodeDOs = AutoCompHpTreatByCode(hpId);
		HpTreatDirCompDO[] byCodeDOsWithDf = SetDefaultValue(byCodeDOs, hpId);
		save(byCodeDOsWithDf);
		HpTreatDirCompDO[] byNameDOs = AutoCompHpTreatByName(hpId);
		HpTreatDirCompDO[] byNameDOsWithDf = SetDefaultValue(byNameDOs, hpId);
		save(byNameDOsWithDf);
	}

	/**
	 * @Title: AutoCompDiByCodeAndName
	 * @Description: 根据编码和名称对照
	 * @return
	 */
	private HpTreatDirCompDO[] AutoCompHpTreatByCodeAndName(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompHpTreatByCodeAndNameSql sql = new AutoCompHpTreatByCodeAndNameSql(hpId);
		@SuppressWarnings("unchecked")
		ArrayList<HpTreatDirCompDO> hpTreatdircompDOList = (ArrayList<HpTreatDirCompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(HpTreatDirCompDO.class));
		return hpTreatdircompDOList.toArray(new HpTreatDirCompDO[0]);
	}

	/**
	 * @Title: AutoCompTreatByCode
	 * @Description: 根据编码自动对照
	 * @return
	 */
	private HpTreatDirCompDO[] AutoCompHpTreatByCode(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompHpTreatByCodeSql sql = new AutoCompHpTreatByCodeSql(hpId);
		@SuppressWarnings("unchecked")
		ArrayList<HpTreatDirCompDO> treatdircompDOList = (ArrayList<HpTreatDirCompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(HpTreatDirCompDO.class));
		return treatdircompDOList.toArray(new HpTreatDirCompDO[0]);
	}

	/**
	 * @Title: AutoCompTreatByName
	 * @Description: 根据名称自动对照
	 * @return
	 * @throws BizException
	 */
	private HpTreatDirCompDO[] AutoCompHpTreatByName(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompTreatByNameSql sql = new AutoCompTreatByNameSql(hpId);
		@SuppressWarnings("unchecked")
		ArrayList<HpTreatDirCompDO> treatdircompDOList = (ArrayList<HpTreatDirCompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(HpTreatDirCompDO.class));
		return treatdircompDOList.toArray(new HpTreatDirCompDO[0]);
	}

	/**
	 * @Title: SetDefaultValue
	 * @Description: 设置公共属性
	 * @param byNameDOs
	 * @param hpId
	 * @return
	 */
	private HpTreatDirCompDO[] SetDefaultValue(HpTreatDirCompDO[] treatdircompDOs, String hpId) throws BizException {
		for (HpTreatDirCompDO HpTreatDirCompDO : treatdircompDOs) {
			HpTreatDirCompDO.setId_org(Context.get().getOrgId());
			HpTreatDirCompDO.setId_grp(Context.get().getGroupId());
			HpTreatDirCompDO.setId_hp(hpId);
			HpTreatDirCompDO.setEu_status(DirCompState.COMPED);
		}
		return treatdircompDOs;
	}

	/**
	 * @Title: save
	 * @Description: 保存
	 * @param treatdircompDOs
	 * @throws DAException
	 */
	@SuppressWarnings("null")
	private void save(HpTreatDirCompDO[] treatdircompDOs) throws DAException {
		DAFacade daFacade = new DAFacade();
		if (treatdircompDOs != null || treatdircompDOs.length > 0) {
			daFacade.insertDOs(treatdircompDOs);
		}
	}
}
