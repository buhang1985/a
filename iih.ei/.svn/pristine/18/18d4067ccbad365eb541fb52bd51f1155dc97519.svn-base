package iih.ei.xhcmu.pat;

import iih.ei.xhcmu.pat.qry.GetNameSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetNameBp {

	/**
	 * 检索指定姓氏的患者名称
	 * 
	 * @param firstName
	 * @return
	 * @throws DAException
	 */
	public String exec(String firstName) throws BizException {
		String rtn = "";
		GetNameSql sql = new GetNameSql(firstName);
		PatInfo[] infos = (PatInfo[]) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(PatInfo.class));
		if (infos != null && infos.length > 0) {
			for (PatInfo patInfo : infos) {
				rtn += (rtn.length() == 0 ? "" : ",") + patInfo.getName();
			}
		}
		return rtn;
	}

}
