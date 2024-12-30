package iih.sc.scbd.s.bp;

import java.util.List;

import iih.sc.scbd.scsrvexcl.d.ScSrvExclDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class IsExisMutexDataBP {
	/**
	 * 医技互斥数据校验，不允许出现A1=A2 && B1=B2 
	 * @param Id_scsrv_a
	 * @param Id_scsrv_b
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(ScSrvExclDO scSrvExclDO) throws BizException {
		DAFacade dafacade = new DAFacade();
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append(" select count(*) ");
		sb.append(" from SC_SRV_EXCL t");
		sb.append(" where t.id_scsrv_a = ? and t.id_scsrv_b = ?");
		
		if(scSrvExclDO.getId_scsrvexcl() != null)
		{
			sb.append(" and id_scsrvexcl not in( '"+scSrvExclDO.getId_scsrvexcl()+"')");
		}
		
		param.addParam(scSrvExclDO.getId_scsrv_a());
		param.addParam(scSrvExclDO.getId_scsrv_b());
		List<String> list = (List<String>) dafacade.execQuery(sb.toString(),param, new ColumnListHandler());
		int count = 0;
		if (list != null && list.size() > 0) {
			Object o = list.get(0);
			count = Integer.parseInt(o.toString());
		}
		if (count > 0) {
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}
