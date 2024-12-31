package iih.bd.srv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.bp.qry.GetMedSrvRelMmQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 获得医疗服务关联的物品集合操作BP
 */
public class GetMedSrvRelMmListBP {
	/**
	 * 获得医疗服务关联的物品集合信息
	 * （所有）
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public MedSrvRelMmDTO[] exec(String id_srv)throws BizException {
		if(BdSrvUtils.isEmpty(id_srv))return null;
		GetMedSrvRelMmQry qry = new GetMedSrvRelMmQry(id_srv);
		MedSrvRelMmDTO[] rtn = (MedSrvRelMmDTO[])AppFwUtil.getDORstWithDao(qry, MedSrvRelMmDTO.class);
		return rtn;
	}
}
