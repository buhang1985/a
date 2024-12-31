package iih.mi.mibd.srvfacdircomp.s.bp;

import java.util.ArrayList;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.srvfacdircomp.d.SrvfacDirCompDTO;
import iih.mi.mibd.srvfacdircomp.s.bp.sql.FindSrvfacCompsql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/** 
* @author hexx 
* @version 创建时间：2018年2月6日 下午4:32:07 
* 通过药品ID查询服务设施对照
*/
public class FindSrvfacCompBySrvfacIdBp {

	/**  
	* @Title: exec  
	* @Description: 执行
	* @param misId
	* @param srvfacIds
	* @return
	* @throws BizException   
	*/
	@SuppressWarnings("unchecked")
	SrvfacDirCompDTO[] exec(String misId, String[] srvfacIds) throws BizException {
		String wherePart = SqlUtils.getInSqlByIds("BD_SRV.ID_SRV", srvfacIds);
		FindSrvfacCompsql sql = new FindSrvfacCompsql(misId, wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<SrvfacDirCompDTO> result = (ArrayList<SrvfacDirCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(SrvfacDirCompDTO.class));
		return result.toArray(new SrvfacDirCompDTO[0]);
	}
}
