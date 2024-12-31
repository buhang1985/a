package iih.bd.srv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.bp.qry.MedSrvDOsInfoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/*
 * 根据服务ID数组获得医疗服务DO数据数组信息操作BP
 */
public class GetMedSrvDOs8IdsBP {
	/**
	 * 根据服务ID数组获得医疗服务DO数据数组信息
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	public MedSrvDO[] exec(String[] id_srvs)throws BizException {
		//非空有效性校验
		if(BdSrvUtils.isEmpty(id_srvs))return null;
		
		//创建查询字串信息
		MedSrvDOsInfoQry qry = new MedSrvDOsInfoQry(id_srvs);
		
		//获得查询结果
		MedSrvDO[] rtns = (MedSrvDO[])AppFwUtil.getDORstWithDao(qry, MedSrvDO.class);
		
		//非空校验
		if(BdSrvUtils.isEmpty(rtns)) return null;
		
		//返回值处理
		return BdSrvUtils.InOutSeqSyncHandle(id_srvs,rtns);
	}
}
