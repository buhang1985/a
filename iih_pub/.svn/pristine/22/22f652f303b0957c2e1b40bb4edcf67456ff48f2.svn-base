package iih.bd.srv.dept.refs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.orgfw.dept.refs.DeptUserRefModel;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 存在特殊级抗菌药专家的科室
 * @author Administrator
 *
 */
public class DeotDocterRefModel extends DeptUserRefModel{
	public static final String SYS_PARAM_TSKJY_DEPT ="CIOR0505";//特殊级抗菌药是否允许同科室医生会诊
	private static final long serialVersionUID = 1L;
	@Override
	public String getRefSql() {
		String refSql =  "  select bd_dep.code,bd_dep.name,bd_dep.id_dep,bd_dep.id_parent,bd_dep.innercode from bd_dep bd_dep where id_dep in ( "
		               + "  SELECT PSNDOC.id_dep FROM bd_srv_spec_anti_expert BD_SRV_SPEC_ANTI_EXPERT " 
		               + "	LEFT JOIN bd_psndoc PSNDOC 	 " 
		               + "	ON PSNDOC.id_psndoc = BD_SRV_SPEC_ANTI_EXPERT.id_psndoc	 )";
		StringBuilder sb = new StringBuilder(refSql);
		List whereList = this.getWherePart();
		if (whereList.size() > 0) {
			Iterator orderList = this.getWherePart().iterator();

			while (orderList.hasNext()) {
				String i = (String) orderList.next();
				sb.append(" and (").append(i).append(") ");
			}
		}  
        sb.append(" and bd_dep.id_org='"+Context.get().getOrgId()+"'");
        FBoolean flag;
		try {
			flag = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),SYS_PARAM_TSKJY_DEPT);
			if(FBoolean.FALSE.equals(flag)){
				sb.append(" and bd_dep.id_dep!='"+Context.get().getDeptId()+"'");  
			}
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		List arg6 = this.getOrderPart();
		if (arg6.size() > 0) {
			sb.append(" order by ");

			for (int arg7 = 0; arg7 < arg6.size(); ++arg7) {
				String order = (String) arg6.get(arg7);
				if (arg7 == 0) {
					sb.append(order);
				} else {
					sb.append("," + order);
				}
			}
		}

		return sb.toString();
	}
}
