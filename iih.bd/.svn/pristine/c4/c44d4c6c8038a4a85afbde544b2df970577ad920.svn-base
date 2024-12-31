package iih.bd.srv.medsrv.bf;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.dto.d.SrvSetItemDTO;
import iih.bd.srv.medsrv.bf.qry.SrvSetSrvItemInfoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据服务套ID获得套内成员服务信息集合BP
 */
public class GetSrvSetSrvItemsInfoBP {
	/**
	 * 根据服务套ID获得套内成员服务信息集合操作
	 * @param id_srvca
	 * @return
	 * @throws BizException
	 */
	public  SrvSetItemDTO[] exec(String id_srv_set)  throws BizException
	{
		if(StringUtils.isBlank(id_srv_set))return null;
		SrvSetSrvItemInfoQry qry=new SrvSetSrvItemInfoQry(id_srv_set);
		SrvSetItemDTO[] rtn=(SrvSetItemDTO[])AppFwUtil.getDORstWithDao(qry, SrvSetItemDTO.class);
		return rtn;
	}
}
