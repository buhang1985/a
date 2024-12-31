package iih.mi.mibd.treatdircomp.s.bp;

import java.util.ArrayList;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.treatdircomp.d.TreatdircompDO;
import iih.mi.mibd.treatdircomp.s.bp.sql.AutoCompTreatByCodeAndNameSql;
import iih.mi.mibd.treatdircomp.s.bp.sql.AutoCompTreatByCodeSql;
import iih.mi.mibd.treatdircomp.s.bp.sql.AutoCompTreatByNameSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @ClassName: AutoTreatCompBp
 * @Description: 自动对照业务处理
 * @author: dj.zhang
 * @date: 2018年2月2日 上午11:20:45
 */
public class AutoTreatCompBp {

	public void exec(String misId) throws BizException {
		TreatdircompDO[] byCodeAndNameDOs = AutoCompTreatByCodeAndName(misId);
		TreatdircompDO[] byCodeAndNameDOsWithDf = SetDefaultValue(byCodeAndNameDOs, misId);
		save(byCodeAndNameDOsWithDf);
		TreatdircompDO[] byCodeDOs = AutoCompTreatByCode(misId);
		TreatdircompDO[] byCodeDOsWithDf = SetDefaultValue(byCodeDOs, misId);
		save(byCodeDOsWithDf);
		TreatdircompDO[] byNameDOs = AutoCompTreatByName(misId);
		TreatdircompDO[] byNameDOsWithDf = SetDefaultValue(byNameDOs, misId);
		save(byNameDOsWithDf);
	}

	/**
	 * @Title: AutoCompDiByCodeAndName
	 * @Description: 根据编码和名称对照
	 * @return
	 */
	private TreatdircompDO[] AutoCompTreatByCodeAndName(String misId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompTreatByCodeAndNameSql sql = new AutoCompTreatByCodeAndNameSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<TreatdircompDO> treatdircompDOList = (ArrayList<TreatdircompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(TreatdircompDO.class));
		return treatdircompDOList.toArray(new TreatdircompDO[0]);
	}

	/**
	 * @Title: AutoCompTreatByCode
	 * @Description: 根据编码自动对照
	 * @return
	 */
	private TreatdircompDO[] AutoCompTreatByCode(String misId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompTreatByCodeSql sql = new AutoCompTreatByCodeSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<TreatdircompDO> treatdircompDOList = (ArrayList<TreatdircompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(TreatdircompDO.class));
		return treatdircompDOList.toArray(new TreatdircompDO[0]);
	}

	/**
	 * @Title: AutoCompTreatByName
	 * @Description: 根据名称自动对照
	 * @return
	 * @throws BizException
	 */
	private TreatdircompDO[] AutoCompTreatByName(String misId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompTreatByNameSql sql = new AutoCompTreatByNameSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<TreatdircompDO> treatdircompDOList = (ArrayList<TreatdircompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(TreatdircompDO.class));
		return treatdircompDOList.toArray(new TreatdircompDO[0]);
	}

	/**
	 * @Title: SetDefaultValue
	 * @Description: 设置公共属性
	 * @param byNameDOs
	 * @param misId
	 * @return
	 */
	private TreatdircompDO[] SetDefaultValue(TreatdircompDO[] treatdircompDOs, String misId) throws BizException {
		for (TreatdircompDO treatdircompDO : treatdircompDOs) {
			treatdircompDO.setId_org(Context.get().getOrgId());
			treatdircompDO.setId_grp(Context.get().getGroupId());
			treatdircompDO.setId_mis(misId);
			treatdircompDO.setEu_status(DirCompState.COMPED);
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
	private void save(TreatdircompDO[] treatdircompDOs) throws DAException {
		DAFacade daFacade = new DAFacade();
		if (treatdircompDOs != null || treatdircompDOs.length > 0) {
			daFacade.insertDOs(treatdircompDOs);
		}
	}

}
