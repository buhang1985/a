package iih.en.pv.s.bp.op;

import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.s.OutpatientCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 取消就诊OP表
 * @author WJY
 *
 */
public class CancEntOpBp {
	/**
	 * 退号更新en_ent_op表就诊次数
	 * @param opDO
	 * @param patId
	 * @throws BizException
	 */
	public void cancEntOp(OutpatientDO opDO, String patId) throws BizException{
		opDO.setTimes_op(this.getMinTimesOp(patId) - 1);
		opDO.setStatus(DOStatus.UPDATED);
		OutpatientCrudServiceImpl opService = new OutpatientCrudServiceImpl();
		opService.update(opDO);
	}
	
	/**
	 * 获取最小就诊次数
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	private Integer getMinTimesOp(String patId) throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select min(op.times_op) timesop ");
		sql.append(" from en_ent_op op ");
		sql.append(" left join en_ent ent ");
		sql.append(" on op.id_ent = ent.id_ent  ");
		sql.append(" where ent.id_pat = ? ");
		SqlParam param = new SqlParam();
        param.addParam(patId);
		DAFacade daf = new DAFacade();
		Integer timesop = 0;
			try {
				timesop = (Integer) daf.execQuery(sql.toString(),param,
						new ColumnHandler());
			} catch (DAException e) {
				e.printStackTrace();
			}
		if(timesop == null) timesop = 0;
		return timesop;
	}
}
