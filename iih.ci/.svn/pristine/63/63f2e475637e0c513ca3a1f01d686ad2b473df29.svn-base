package iih.ci.mr.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.ci.mr.s.bp.qry.DataElementSql;

public class DataElementBp {
	
	/**
	 * 医疗服务：生命体征项 (xuxing_2016-05-03)
	 * @param Id_mrvtca
	 * @return
	 * @throws BizException
	 */
	public MedSrvVtDO[] exec(String Id_mrvtca) throws BizException {

		DataElementSql sqlPara = new DataElementSql(Id_mrvtca);
		
		MedSrvVtDO[] rtn = (MedSrvVtDO[]) AppFwUtil.getDORstWithDao(sqlPara, MedSrvVtDO.class);
		
		return rtn;
	}
}
