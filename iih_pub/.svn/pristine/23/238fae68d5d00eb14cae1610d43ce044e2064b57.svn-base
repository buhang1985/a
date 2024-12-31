package iih.bd.srv.doctorprint.ref;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xap.sys.orgfw.dept.refs.DeptUserRefModel;

/**
 * 打印模板类型参照
 * @author Liyue
 *
 */
public class CiPrintTpRefModel extends DeptUserRefModel{
	private static final long serialVersionUID = 1L;
	@Override
	public String[] getShowFieldName() {
		return (new String[] { "编码","名称"});
	}
	@Override
	public String getRefSql() {
		String refSql =  " select code,name from bd_ems_prntmpl  ";
		             
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
