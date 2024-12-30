package iih.sc.sch.s.bp;

import java.util.List;

import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据资源和科室获取排班
 * @author yank
 *
 */
public class GetSchByResAndDepBP {
	/**
	 * 获取排班
	 * @param date 日期
	 * @param dayslotId 日期分组id
	 * @param scResId 排班资源id
	 * @param depId 科室id
	 * @return 排班DO
	 * @throws BizException
	 */
	public ScSchDO exec(FDate date,String dayslotId,String scResId,String depId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT SCH.*");
		sqlBuilder.append(" FROM SC_SCH SCH ");
		sqlBuilder.append(" INNER JOIN SC_PL PL ON PL.ID_SCPL=SCH.ID_SCPL");
		sqlBuilder.append(" WHERE 1=1");				
		sqlBuilder.append(" AND SCH.D_SCH=? AND SCH.ID_DAYSLOT=?");
		param.addParam(date);
		param.addParam(dayslotId);		
		sqlBuilder.append(" AND PL.ID_SCRES=?");
		param.addParam(scResId);	
		sqlBuilder.append(" AND PL.ID_DEP=?");
		param.addParam(depId);	
		
		ScSchDO schDO = null;
		List<ScSchDO> list = (List<ScSchDO>) new DAFacade().execQuery(sqlBuilder.toString(), param,new BeanListHandler(ScSchDO.class));
		if(!ListUtil.isEmpty(list)){
			schDO = list.get(0);
		}
		return schDO;
	}
}
