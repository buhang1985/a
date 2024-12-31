package iih.en.que.s.bp.op.qry.benmgr;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnEmpQueInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室队列信息
 * 
 * @author liubin
 *
 */
public class GetQueInfosBP {
    /**
     * 获取科室队列信息
     * 
     * @param depId
     * @param quebenId
     * @param date
     * @return
     * @throws BizException 
     */
	public EnEmpQueInfoDTO[] exec(String depId, String quebenId, FDate date) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BD_QUE.ID_QUE    AS ID_QUE, ");
		sqlBuilder.append(" BD_QUE.CODE      AS CODE_QUE, ");
		sqlBuilder.append(" BD_QUE.NAME      AS NAME_QUE, ");
		sqlBuilder.append(" BD_QUE.ID_QUEBEN AS ID_QUEBEN, ");
		sqlBuilder.append(" SBQ.ID_DAYSLOT   AS ID_DAYSLOT, ");
		sqlBuilder.append(" DAYSLOT.NAME     AS NAME_DAYSLOT, ");
		sqlBuilder.append(" SBQ.D_SCH        AS D_SCH, ");
		sqlBuilder.append(" BD_QUE.ID_DEP    AS ID_DEP, ");
		sqlBuilder.append(" BD_QUE.ID_SCRES  AS ID_SCRES ");
		sqlBuilder.append(" FROM BD_QUE BD_QUE ");
		sqlBuilder.append(" INNER JOIN (SELECT BQ.ID_QUE, SCH.ID_DAYSLOT, SCH.D_SCH ");
		sqlBuilder.append(" FROM BD_QUE BQ ");
		sqlBuilder.append(" INNER JOIN SC_PL SCPL ON BQ.ID_DEP = SCPL.ID_DEP AND BQ.ID_SCRES = SCPL.ID_SCRES AND BQ.ID_QUEBEN = SCPL.ID_QUEBEN ");
		sqlBuilder.append(" INNER JOIN SC_SCH SCH ON SCPL.ID_SCPL = SCH.ID_SCPL ");
		sqlBuilder.append(" WHERE BQ.ID_QUEBEN = ? ");
		sqlBuilder.append(" AND BQ.ID_DEP = ? ");
		sqlBuilder.append(" AND BQ.FG_ACTIVE = ? ");
		sqlBuilder.append(" AND SCPL.FG_ACTIVE = ? ");
		sqlBuilder.append(" AND SCH.D_SCH = ? ");
		sqlBuilder.append(" AND BQ.SD_QUETP = ? ");
		sqlBuilder.append(" GROUP BY BQ.ID_QUE, SCH.ID_DAYSLOT, SCH.D_SCH) SBQ ");
		sqlBuilder.append(" ON BD_QUE.ID_QUE = SBQ.ID_QUE ");
		sqlBuilder.append(" INNER JOIN BD_DAYSLOT DAYSLOT ");
		sqlBuilder.append(" ON DAYSLOT.ID_DAYSLOT = SBQ.ID_DAYSLOT ");
		sqlBuilder.append(" ORDER BY  BD_QUE.CODE,DAYSLOT.NAME ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(quebenId);
		param.addParam(depId);
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.TRUE);
		param.addParam(date);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		List<EnEmpQueInfoDTO> list = (List<EnEmpQueInfoDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnEmpQueInfoDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new EnEmpQueInfoDTO[0]);
	}
}
