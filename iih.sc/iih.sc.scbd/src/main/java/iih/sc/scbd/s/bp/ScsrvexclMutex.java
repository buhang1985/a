package iih.sc.scbd.s.bp;

import java.util.List;

import iih.sc.comm.DateTimeUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scsrvexcl.d.ScSrvExclDO;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class ScsrvexclMutex {
	
	/**
	 * 医技互斥数据校验，不允许出现A1=A2 && B1=B2 和 不允许出现A1=B2 && B1=A2
	 * @param Id_scsrv_a
	 * @param Id_scsrv_b
	 * @return
	 * @throws BizException
	 */
	public FBoolean isExistence(ScSrvExclDO scSrvExclDO) throws BizException {
		DAFacade dafacade = new DAFacade();
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append(" select count(*) ");
		sb.append(" from SC_SRV_EXCL t");
		sb.append(" where ((t.id_scsrv_a = ? and t.id_scsrv_b = ?)");
		sb.append(" or (t.id_scsrv_b = ? and t.id_scsrv_a = ?))");
		
		param.addParam(scSrvExclDO.getId_scsrv_a());
		param.addParam(scSrvExclDO.getId_scsrv_b());
		param.addParam(scSrvExclDO.getId_scsrv_b());
		param.addParam(scSrvExclDO.getId_scsrv_a());
		
		if(scSrvExclDO.getId_scsrvexcl() != null)
		{
			sb.append(" and t.id_scsrvexcl != ?");
			param.addParam(scSrvExclDO.getId_scsrvexcl());
		}
		
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
