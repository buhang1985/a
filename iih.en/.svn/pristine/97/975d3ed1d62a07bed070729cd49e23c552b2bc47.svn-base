package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enclin.i.IEntstateRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 *  获取孕妇风险等级
 * 
 * @author liubin
 *
 */
public class GetGravidariskBP {
	
	/**
	 * 获取孕产妇风险等级就诊状况
	 * 
	 * @param code_entp
	 * @param id_ent
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public EntStateDO exec(String code_entp, String id_ent, String id_pat) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT ENTSTATE.ID_ENTSTATE ");
		sqlBuilder.append(" FROM EN_ENT_STATE ENTSTATE ");
		sqlBuilder.append(" INNER JOIN BD_EN_STATETP_EXT STATEEXT ON ENTSTATE.ID_ENSTATETP = STATEEXT.ID_ENSTATETP ");
		sqlBuilder.append(" WHERE ENTSTATE.Sd_enstatetp = ? ");
		param.addParam(IBdFcDictCodeConst.SD_ENTSTATETP_GRAVIDARISK);
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp))
			sqlBuilder.append(" AND STATEEXT.FG_OP = ? ");
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp))
			sqlBuilder.append(" AND STATEEXT.FG_ER = ? ");
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp))
			sqlBuilder.append(" AND STATEEXT.FG_IP = ? ");
		else
			return null;
		sqlBuilder.append(" AND ((STATEEXT.FG_ENT = ? AND ENTSTATE.ID_ENT = ?) OR (STATEEXT.FG_ENT = ? AND ENTSTATE.ID_PAT = ?)) ");
		String sql = sqlBuilder.toString();
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.TRUE);
		param.addParam(id_ent);
		param.addParam(FBoolean.FALSE);
		param.addParam(id_pat);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(EnValidator.isEmpty(list))
			return null;
		IEntstateRService serv = ServiceFinder.find(IEntstateRService.class);
		EntStateDO[]  entStates = serv.findByIds(list.toArray(new String[0]), FBoolean.FALSE);
		return EnValidator.isEmpty(entStates) ? null : entStates[0];
	}
}
