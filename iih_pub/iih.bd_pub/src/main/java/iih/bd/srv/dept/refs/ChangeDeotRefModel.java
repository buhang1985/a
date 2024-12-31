package iih.bd.srv.dept.refs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.orgfw.dept.refs.DeptUserRefModel;

/**
 * 转科医嘱单 科室参照
 * @author Liyue
 *
 */
public class ChangeDeotRefModel extends DeptUserRefModel{
	private static final long serialVersionUID = 1L;
	@Override
	public String getRefSql() {
		String refSql =  " select bd_dep.code,bd_dep.name,bd_dep.id_dep,bd_dep.id_parent,bd_dep.innercode from "
				+ "bd_dep bd_dep where bd_dep.ds ='0' and bd_dep.activestate ='2' and bd_dep.id_org='"+Context.get().getOrgId()+"' ";
		             
		StringBuilder sb = new StringBuilder(refSql);
		List whereList = this.getWherePart();
		if (whereList.size() > 0) {
			Iterator orderList = this.getWherePart().iterator();

			while (orderList.hasNext()) {
				String i = (String) orderList.next();
				sb.append(" and (").append(i).append(") ");
			}
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
