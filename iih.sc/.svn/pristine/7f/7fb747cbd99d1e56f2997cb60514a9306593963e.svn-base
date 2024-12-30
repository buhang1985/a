package iih.sc.scbd.s.bp;

import iih.sc.comm.ScSqlUtils;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 *  查找sctpSd对应的有科室参数的部门
 * @author Sarah
 *
 */
public class GetDeptWithDeptParamBP {
	/**
	 * 查找sctpSd对应的有科室参数的部门
	 * 
	 * @return
	 */
	public DeptDO[] exec(String sctpSd,String depId) throws BizException{
		String[] sctps = sctpSd.split(",");
		
		StringBuilder sb = new StringBuilder();
		SqlParam sp = new SqlParam();
		sb.append(" select DISTINCT (param2.id_dep) ,dep.* from sc_dep_param param2");
		sb.append(" inner join bd_dep  dep");
		sb.append(" on param2.id_dep = dep.id_dep");
		sb.append(" where");
		if (sctps.length>1) {
			String sctpCond = ScSqlUtils.buildIdStr(sctps);
			sb.append(" param2.sd_sctp in (");
			sb.append(sctpCond).append(")");
		}else{
			sb.append(" param2.sd_sctp = ?");
		sp.addParam(sctpSd);
		}
		if(!StringUtil.isEmptyWithTrim(depId)){
			sb.append(" and  param2.id_dep = ?  ");
			sp.addParam(depId);
		}
		sb.append(" AND ").append(ScGroupControlUtils.getGroupControlFitler(new ScPlanDODesc(), "param2"));
		sb.append("  order by dep.code  ");
		  List<DeptDO> datas = (List<DeptDO>) new DAFacade().execQuery(sb.toString(),
					sp, new BeanListHandler(DeptDO.class));
		  if(ListUtil.isEmpty(datas)){
			 return null;
		   }
		return  datas.toArray(new DeptDO[0]);
	}
}
