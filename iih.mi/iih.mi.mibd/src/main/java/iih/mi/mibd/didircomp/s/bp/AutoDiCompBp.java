package iih.mi.mibd.didircomp.s.bp;

import java.util.ArrayList;

import iih.mi.mibd.didircomp.d.DidircompDO;
import iih.mi.mibd.didircomp.s.bp.sql.AutoCompDiByCodeAndNameSql;
import iih.mi.mibd.didircomp.s.bp.sql.AutoCompDiByCodeSql;
import iih.mi.mibd.didircomp.s.bp.sql.AutoCompDiByNameSql;
import iih.mi.mibd.docenum.d.DirCompState;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @ClassName: AutoDiCompBp
 * @Description: 自动对照
 * @author: dj.zhang
 * @date: 2018年2月7日 上午9:50:10
 */
public class AutoDiCompBp {

	/**
	 * @Title: exec
	 * @Description: 执行对照
	 * @param misId
	 */
	public void exec(String misId) throws BizException {
		DidircompDO[] byCodeAndNameDOs = AutoCompDiByCodeAndName(misId);
		DidircompDO[] byCodeAndNameDOsWithDf = SetDefaultValue(byCodeAndNameDOs, misId);
		save(byCodeAndNameDOsWithDf);
		DidircompDO[] byCodeDOs = AutoCompDiByCode(misId);
		DidircompDO[] byCodeDOsWithDf = SetDefaultValue(byCodeDOs, misId);
		save(byCodeDOsWithDf);
		DidircompDO[] byNameDOs = AutoCompDiByName(misId);
		DidircompDO[] byNameDOsWithDf = SetDefaultValue(byNameDOs, misId);
		save(byNameDOsWithDf);
	}

	/**
	 * @Title: save
	 * @Description: 保存
	 * @param didircompDOList
	 * @throws DAException
	 */
	@SuppressWarnings("null")
	private void save(DidircompDO[] didircompDOList) throws DAException {
		DAFacade daFacade = new DAFacade();
		if (didircompDOList != null || didircompDOList.length > 0) {
			daFacade.insertDOs(didircompDOList);
		}
	}

	/**
	 * @Title: SetDefaultValue
	 * @Description: 设置公共字段属性
	 */
	private DidircompDO[] SetDefaultValue(DidircompDO[] didircompDOs, String misId) throws DAException {
		for (DidircompDO didircompDO : didircompDOs) {
			didircompDO.setId_org(Context.get().getOrgId());
			didircompDO.setId_grp(Context.get().getGroupId());
			didircompDO.setId_mis(misId);
			didircompDO.setEu_status(DirCompState.COMPED);
		}
		return didircompDOs;
	}

	/**
	 * @Title: AutoCompDiByCodeAndName
	 * @Description: 通过编码和名称自动对照
	 * @param misId
	 * @return
	 * @throws DAException
	 */
	private DidircompDO[] AutoCompDiByCodeAndName(String misId) throws DAException {
		DAFacade daFacade = new DAFacade();
		AutoCompDiByCodeAndNameSql sql = new AutoCompDiByCodeAndNameSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<DidircompDO> didircompDOList = (ArrayList<DidircompDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DidircompDO.class));
		return didircompDOList.toArray(new DidircompDO[0]);
	}

	/**
	 * @Title: AutoCompDiByCode
	 * @Description: 通过编码自动对照
	 * @param misId
	 * @return
	 * @throws DAException
	 */
	private DidircompDO[] AutoCompDiByCode(String misId) throws DAException {
		DAFacade daFacade = new DAFacade();
		AutoCompDiByCodeSql sql = new AutoCompDiByCodeSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<DidircompDO> didircompDOList = (ArrayList<DidircompDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DidircompDO.class));
		return didircompDOList.toArray(new DidircompDO[0]);
	}

	/**
	 * @Title: AutoCompDiByName
	 * @Description: 通过名称自动对照
	 * @param misId
	 * @throws DAException
	 */
	private DidircompDO[] AutoCompDiByName(String misId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompDiByNameSql sql = new AutoCompDiByNameSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<DidircompDO> didircompDOList = (ArrayList<DidircompDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DidircompDO.class));
		return didircompDOList.toArray(new DidircompDO[0]);
	}

}
