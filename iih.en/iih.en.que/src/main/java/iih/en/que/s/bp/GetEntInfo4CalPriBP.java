package iih.en.que.s.bp;

import iih.bd.fc.querule.d.PriorityDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取计算优先级的患者信息
 * @author yank
 *
 */
public class GetEntInfo4CalPriBP {
	/**
	 * 获取计算优先级的患者信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public PriorityDTO exec(String entId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENT.ID_ENT,ENT.ID_PAT,ENT.DT_BIRTH_PAT AS D_BIRTH,ENT.ID_SEX_PAT AS ID_SEX,OP.ID_SCSRV,OP.ID_LEVEL_DISE,OP.SD_LEVEL_DISE CODE_LEVEL_DISE,");
		sqlBuilder.append("OP.FG_NEEDRTN AS FG_CONT,ENT.ID_PATCA");
		sqlBuilder.append(" FROM EN_ENT_OP OP");
		sqlBuilder.append(" INNER JOIN EN_ENT ENT ON OP.ID_ENT = ENT.ID_ENT");
		sqlBuilder.append(" WHERE ENT.ID_ENT=?");
		
		SqlParam param = new SqlParam();
		param.addParam(entId);
		PriorityDTO priDTO = (PriorityDTO) new DAFacade().execQuery(sqlBuilder.toString(),param,new BeanHandler(PriorityDTO.class));

		return priDTO;
	}
}
