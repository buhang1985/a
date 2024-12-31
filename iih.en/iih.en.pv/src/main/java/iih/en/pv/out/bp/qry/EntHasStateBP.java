package iih.en.pv.out.bp.qry;

import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者是否有对应就诊状况
 * 
 * @author liubin
 *
 */
public class EntHasStateBP {
	/**
	 * 患者是否有对应就诊状况
	 * 
	 * @param entId 
	 * 			就诊id
	 * @param sd_enstatetp
	 * 			就诊状况类型  (iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_ENSTATE_XXX)
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String entId, String sd_enstatetp) throws BizException {
		if(EnValidator.isEmpty(entId) || EnValidator.isEmpty(sd_enstatetp))
			return FBoolean.FALSE;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT COUNT(1) ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" WHERE EN.ID_ENT = ? ");
		sqlBuilder.append(" AND EXISTS(SELECT STATE.SD_ENSTATETP ");
		sqlBuilder.append(" FROM EN_ENT_STATE STATE ");
		sqlBuilder.append(" INNER JOIN BD_EN_STATETP_EXT EXTSTATE ON STATE.ID_ENSTATETP = EXTSTATE.ID_ENSTATETP ");
		sqlBuilder.append(" WHERE STATE.SD_ENSTATETP = ? ");
		sqlBuilder.append(" AND ((EXTSTATE.FG_ENT = 'Y' AND STATE.ID_ENT = EN.ID_ENT) ");
		sqlBuilder.append(" OR (EXTSTATE.FG_ENT = 'N' AND STATE.ID_PAT = EN.ID_PAT))) ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
	    param.addParam(sd_enstatetp);
	    Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return new FBoolean(count != null && count > 0); 
	}
}
