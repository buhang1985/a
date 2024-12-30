package iih.sc.scbd.schedulesrv.s.bp;

import java.util.List;

import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.s.bp.sql.ScheduleSrvAggUpdateBeforeSql;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医技排班服务中的子DO删除Bp
 * @author guoyang
 */
public class ScheduleSrvAggUpdateBeforeBp {

	public void exe(ScheduleSrvDO scheduleSrvDO, List<String> IdMdSrvList) throws DAException {
		if (IdMdSrvList != null && IdMdSrvList.size() > 0 && scheduleSrvDO != null) {

			DAFacade daFacade = new DAFacade();
			ScheduleSrvAggUpdateBeforeSql sql = new ScheduleSrvAggUpdateBeforeSql(scheduleSrvDO.getInnercode(),
					IdMdSrvList);
			daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
		}
	}
}

