package iih.bd.pp.hpdivshisdto.s.bp;

import java.util.ArrayList;

import iih.bd.pp.hpdivshis.d.HpDiVsHisDO;
import iih.bd.pp.hpdivshisdto.s.bp.sql.AutoCompInsurDiSql;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 自动对照医保病种目录业务逻辑
 * 
 * @author hao_wu
 *
 */
public class AutoCompInsurDiBp {

	public void exec(String code) throws BizException {
		DeleteNoReviewData();
		AutoCompInsurDi(code);
	}

	@SuppressWarnings("unchecked")
	private void AutoCompInsurDi(String idHp) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompInsurDiSql sql = new AutoCompInsurDiSql(idHp);
		ArrayList<HpDiVsHisDO> hpDiVsHisDOList = (ArrayList<HpDiVsHisDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HpDiVsHisDO.class));
		daFacade.insertDOs(hpDiVsHisDOList.toArray(new HpDiVsHisDO[0]));
	}

	private void DeleteNoReviewData() throws BizException {
		DAFacade daFacade = new DAFacade();
		String sqlStr = "DELETE FROM BD_HP_DI_VS_HIS WHERE EU_STATUS <> ?";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(HpStatusEnum.REVIEW);
		daFacade.execUpdate(sqlStr, sqlParam);
	}
}
