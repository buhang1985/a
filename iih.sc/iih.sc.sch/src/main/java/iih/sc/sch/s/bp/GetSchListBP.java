package iih.sc.sch.s.bp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取排班信息
 * @author yank
 *
 */
public class GetSchListBP {
	/**
	 * 获取排班信息
	 * @param date 日期
	 * @param dayslotId 午别id
	 * @param depId 科室id
	 * @param empId 人员id，如果人员为空，则取科室的排班信息
	 * @return
	 * @throws BizException
	 */
	public ScSchDO[] exec(FDate date,String dayslotId,String depId,String empId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT SCH.*");
		sqlBuilder.append(" FROM SC_SCH SCH ");
		sqlBuilder.append(" INNER JOIN SC_PL PL ON PL.ID_SCPL=SCH.ID_SCPL");
		sqlBuilder.append(" INNER JOIN SC_RES RES ON RES.ID_SCRES=PL.ID_SCRES");
		sqlBuilder.append(" WHERE 1=1");
		
		SqlParam param = new SqlParam();
		if(date!=null){
			sqlBuilder.append(" AND SCH.D_SCH=?");
			param.addParam(date);
		}
		if(StringUtils.isNotEmpty(dayslotId)){
			sqlBuilder.append(" AND SCH.ID_DAYSLOT=?");
			param.addParam(dayslotId);		
		}
		if(StringUtils.isNotEmpty(depId)){
			sqlBuilder.append(" AND PL.ID_DEP=?");
			param.addParam(depId);
		}
		if(StringUtils.isNotEmpty(empId)){
			sqlBuilder.append(" AND RES.ID_EMP=? AND RES.SD_SCRESTP=?");
			param.addParam(empId);
			param.addParam(IScDictCodeConst.SD_SCRESTP_EMP);
		}	
		
		List<ScSchDO> schDOList = (List<ScSchDO>)new DAFacade().execQuery(sqlBuilder.toString(), param,new BeanListHandler(ScSchDO.class));
		if(ListUtil.isEmpty(schDOList)){
			return null;
		}
		return schDOList.toArray(new ScSchDO[0]);
	}
}
