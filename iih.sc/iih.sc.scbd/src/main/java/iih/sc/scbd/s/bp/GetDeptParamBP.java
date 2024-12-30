package iih.sc.scbd.s.bp;

import iih.sc.comm.ScContextUtils;
import iih.sc.scbd.scdeptparam.d.EuStatus;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 
 * @author Sarah
 *
 */
public class GetDeptParamBP {
	/**
	 * 获取时间段内科室参数
	 * @param d_b
	 * @param d_e
	 * @return
	 * @throws BizException
	 */
	public ScDeptParamDO[] exec(String d_b,String d_e,String sd_sctp) throws BizException{
		  StringBuilder sb = new StringBuilder();
		  SqlParam sp = new SqlParam();
		  sb.append("select * from sc_dep_param where ");
		  sb.append("  id_dep =?  and eu_status  = ? and sd_sctp=?");
		  sp.addParam(ScContextUtils.getDeptId());
		  sp.addParam(EuStatus.SUBMIT);
		  sp.addParam(sd_sctp);
		  sb.append(" and( (d_begin >=? and d_begin <=? )");
		  sp.addParam(d_b);
		  sp.addParam(d_e);
		  sb.append(" or (d_end >=? and d_end <=?) ");
		  sp.addParam(d_b);
		  sp.addParam(d_e);
		  sb.append(" or (d_begin >=? and d_end<= ?)");
		  sp.addParam(d_b);
		  sp.addParam(d_e);
		  sb.append(" or ( d_begin <=? and d_end is null)");
		  sp.addParam(d_b);
		  
		  sb.append(" or (d_begin <=? and d_end>= ?))");
		  sp.addParam(d_b);
		  sp.addParam(d_e);
		  List<ScDeptParamDO> datas = (List<ScDeptParamDO>) new DAFacade().execQuery(sb.toString(),
					sp, new BeanListHandler(ScDeptParamDO.class));
		  if(ListUtil.isEmpty(datas))
			  return null;
			  
		return datas.toArray(new ScDeptParamDO[]{});
	}
}
