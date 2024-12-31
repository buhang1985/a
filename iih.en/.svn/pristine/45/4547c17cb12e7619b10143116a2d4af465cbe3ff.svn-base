package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院未结算的价格分类集合
 * @author yank
 *
 */
public class GetIpUnstlPriPatListBP {
	/**
	 * 获取住院未结算的价格分类集合
	 * @return
	 * @throws BizException
	 */
	public List<String> exec() throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT DISTINCT EN.ID_PRIPAT ");
		sqlBuilder.append("FROM EN_ENT EN ");
		sqlBuilder.append("WHERE EN.FG_ST = 'N' ");
		sqlBuilder.append(" AND EN.CODE_ENTP = ? ");
		sqlBuilder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP);//住院
		List<String> priPatList = (List<String>)new DAFacade().execQuery(sqlBuilder.toString(),param, new ColumnListHandler());
		return priPatList;
	}
}
