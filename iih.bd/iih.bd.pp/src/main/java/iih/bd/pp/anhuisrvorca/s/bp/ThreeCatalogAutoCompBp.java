package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.s.bp.sql.ThreeCatalogAutoCompSql;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 三大目录自动对照
 * @author guoyang
 *
 */
public class ThreeCatalogAutoCompBp {

	public void exec() throws BizException{
		deleteUnComp();
		autoComp();
	}

	/**
	 * 自动对照
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private void autoComp() throws BizException {
		DAFacade daFacade = new DAFacade();
		ThreeCatalogAutoCompSql sql = new ThreeCatalogAutoCompSql();
		ArrayList<HPSrvorcaDO> hpDiVsHisDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		for (HPSrvorcaDO hpSrvorcaDO : hpDiVsHisDOList) {
			hpSrvorcaDO.setId_grp(Context.get().getGroupId());
			hpSrvorcaDO.setId_org(Context.get().getOrgId());
		}
		daFacade.insertDOs(hpDiVsHisDOList.toArray(new HPSrvorcaDO[0]));
	}

	/**
	 * 删除未对照的数据，eu_status为0(未匹配)和1(已匹配)
	 * @throws DAException 
	 */
	private void deleteUnComp() throws BizException {
		DAFacade daFacade = new DAFacade();
		String sqlStr = "DELETE FROM BD_HP_SRVORCA WHERE EU_STATUS in (?,?)";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		sqlParam.addParam(HpStatusEnum.MATCHED);
		daFacade.execUpdate(sqlStr, sqlParam);
	}
}
