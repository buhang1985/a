package iih.mi.mibd.srvfacdircomp.s.bp;

import java.util.ArrayList;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.srvfacdircomp.d.SrvFacDirCompDO;
import iih.mi.mibd.srvfacdircomp.s.bp.sql.AutoCompSrvfacByCodeAndNameSql;
import iih.mi.mibd.srvfacdircomp.s.bp.sql.AutoCompSrvfacByCodeSql;
import iih.mi.mibd.srvfacdircomp.s.bp.sql.AutoCompSrvfacByNameSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author hexx
 * @version 创建时间：2018年2月6日 下午5:55:24 自动对照业务逻辑
 */
public class AutoCompSrvfacBp {

	public void exec(String misId) throws BizException {
		SrvFacDirCompDO[] byCodeAndNameDOs = AutoCompSrvfacByCodeAndName(misId);
		SrvFacDirCompDO[] byCodeAndNameDOsWithDf = SetDefaultValue(byCodeAndNameDOs, misId);
		save(byCodeAndNameDOsWithDf);
		SrvFacDirCompDO[] byCodeDOs = AutoCompSrvfacByCode(misId);
		SrvFacDirCompDO[] byCodeDOsWithDf = SetDefaultValue(byCodeDOs, misId);
		save(byCodeDOsWithDf);
		SrvFacDirCompDO[] byNameDOs = AutoCompSrvfacByName(misId);
		SrvFacDirCompDO[] byNameDOsWithDf = SetDefaultValue(byNameDOs, misId);
		save(byNameDOsWithDf);
	}

	/**
	 * @Title: save
	 * @Description: 保存
	 * @param srvfacdircompDOs
	 * @throws DAException
	 */
	@SuppressWarnings("null")
	private void save(SrvFacDirCompDO[] srvfacdircompDOs) throws DAException {
		DAFacade daFacade = new DAFacade();
		if (srvfacdircompDOs != null || srvfacdircompDOs.length > 0) {
			daFacade.insertDOs(srvfacdircompDOs);
		}
	}

	/**
	 * @Title: SetDefaultValue
	 * @Description: 设置公共属性
	 * @param srvfacdircompDOs
	 * @param misId
	 * @return
	 */
	private SrvFacDirCompDO[] SetDefaultValue(SrvFacDirCompDO[] srvfacdircompDOs, String misId) {
		for (SrvFacDirCompDO srvFacDirCompDO : srvfacdircompDOs) {
			srvFacDirCompDO.setId_org(Context.get().getOrgId());
			srvFacDirCompDO.setId_grp(Context.get().getGroupId());
			srvFacDirCompDO.setId_mis(misId);
			srvFacDirCompDO.setEu_status(DirCompState.COMPED);
		}
		return srvfacdircompDOs;
	}

	/**
	 * @Title: AutoCompSrvfacByName
	 * @Description: 根据名称自动对照
	 * @param misId
	 * @return
	 * @throws DAException
	 */
	private SrvFacDirCompDO[] AutoCompSrvfacByName(String misId) throws DAException {
		DAFacade daFacade = new DAFacade();
		AutoCompSrvfacByNameSql sql = new AutoCompSrvfacByNameSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<SrvFacDirCompDO> srvfacdircompDOList = (ArrayList<SrvFacDirCompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(SrvFacDirCompDO.class));
		return srvfacdircompDOList.toArray(new SrvFacDirCompDO[0]);
	}

	/**
	 * @Title: AutoCompSrvfacByCode
	 * @Description: 根据编码自动对照
	 * @param misId
	 * @return
	 * @throws DAException
	 */
	private SrvFacDirCompDO[] AutoCompSrvfacByCode(String misId) throws DAException {
		DAFacade daFacade = new DAFacade();
		AutoCompSrvfacByCodeSql sql = new AutoCompSrvfacByCodeSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<SrvFacDirCompDO> srvfacdircompDOList = (ArrayList<SrvFacDirCompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(SrvFacDirCompDO.class));
		return srvfacdircompDOList.toArray(new SrvFacDirCompDO[0]);
	}

	/**
	 * @Title: AutoCompSrvfacByCodeAndName
	 * @Description: TODO
	 * @param misId
	 * @return
	 * @throws DAException
	 */
	private SrvFacDirCompDO[] AutoCompSrvfacByCodeAndName(String misId) throws DAException {
		DAFacade daFacade = new DAFacade();
		AutoCompSrvfacByCodeAndNameSql sql = new AutoCompSrvfacByCodeAndNameSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<SrvFacDirCompDO> srvfacdircompDOList = (ArrayList<SrvFacDirCompDO>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(SrvFacDirCompDO.class));
		return srvfacdircompDOList.toArray(new SrvFacDirCompDO[0]);
	}

}
