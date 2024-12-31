package iih.en.que.s.bp.op.cmd.benmgr;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.que.empque.d.EnQueEmpDO;
import iih.en.que.empque.i.IEnempqueCudService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 自动生成队列出诊医生
 * 
 * @author liubin
 *
 */
public class CreateQueEmpsBP {
	/**
	 * 自动生成队列出诊医生
	 * 
	 * @param benId
	 * @param date
	 * @throws BizException
	 */
	public void exec(String benId, FDate date) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT BD_QUE.ID_QUE    AS ID_QUE, ");
		sqlBuilder.append(" SBQ.ID_DAYSLOT   AS ID_DAYSLOT, ");
		sqlBuilder.append(" SBQ.D_SCH        AS D_QUE, ");
		sqlBuilder.append(" SCRES.ID_EMP    AS ID_EMP, ");
		sqlBuilder.append(" SBQ.ID_DAYSLOT  AS ID_DAYSLOT ");
		sqlBuilder.append(" FROM BD_QUE BD_QUE ");
		sqlBuilder.append(" INNER JOIN (SELECT BQ.ID_QUE, SCH.ID_DAYSLOT, SCH.D_SCH ");
		sqlBuilder.append(" FROM BD_QUE BQ ");
		sqlBuilder.append(" INNER JOIN SC_PL SCPL ON BQ.ID_DEP = SCPL.ID_DEP AND BQ.ID_SCRES = SCPL.ID_SCRES AND BQ.ID_QUEBEN = SCPL.ID_QUEBEN ");
		sqlBuilder.append(" INNER JOIN SC_SCH SCH ON SCPL.ID_SCPL = SCH.ID_SCPL ");
		sqlBuilder.append(" WHERE BQ.FG_ACTIVE = ? ");
		sqlBuilder.append(" AND SCPL.FG_ACTIVE = ? ");
		sqlBuilder.append(" AND SCH.D_SCH = ? ");
		sqlBuilder.append(" AND BQ.SD_QUETP = ? ");
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.TRUE);
		param.addParam(date);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		if(!EnValidator.isEmpty(benId)){
			sqlBuilder.append(" AND BQ.ID_QUEBEN = ? ");
			param.addParam(benId);
		}
		sqlBuilder.append(" GROUP BY BQ.ID_QUE, SCH.ID_DAYSLOT, SCH.D_SCH) SBQ ON BD_QUE.ID_QUE = SBQ.ID_QUE ");
		sqlBuilder.append(" INNER JOIN SC_RES SCRES ON BD_QUE.ID_SCRES = SCRES.ID_SCRES AND SCRES.SD_SCRESTP = ? ");
		sqlBuilder.append(" WHERE NOT EXISTS (SELECT * FROM EN_QUE_EMP EMP WHERE EMP.ID_QUE = BD_QUE.ID_QUE AND EMP.ID_DAYSLOT = SBQ.ID_DAYSLOT AND EMP.D_QUE = SBQ.D_SCH ) ");
		String sql = sqlBuilder.toString();
		param.addParam(IScDictCodeConst.SD_SCRESTP_EMP);
		List<EnQueEmpDO> list = (List<EnQueEmpDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnQueEmpDO.class));
		if(EnValidator.isEmpty(list))
			return;
		for(EnQueEmpDO emp : list){
			emp.setStatus(DOStatus.NEW);
			emp.setFg_active(FBoolean.TRUE);
			emp.setFg_stop(FBoolean.FALSE);
		}
		ServiceFinder.find(IEnempqueCudService.class).save(list.toArray(new EnQueEmpDO[0]));
	}
}
