package iih.bd.srv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.s.bp.qry.MedSrvDOInfoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/*
 * 根据服务ID获得医疗服务DO数据信息操作BP
 */
public class GetMedSrvDO8IdBP {
	/**
	 * 根据服务ID获得医疗服务DO数据信息
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public MedSrvDO exec(String id_srv)throws BizException {
		//非空有效性校验
		if(BdSrvUtils.isEmpty(id_srv))return null;
		
		//创建查询字串信息
		MedSrvDOInfoQry qry = new MedSrvDOInfoQry(id_srv);
		
		//获得查询结果
		MedSrvDO[] rtns = (MedSrvDO[])AppFwUtil.getDORstWithDao(qry, MedSrvDO.class);
		
		//非空校验
		if(BdSrvUtils.isEmpty(rtns)) return null;
		
		//返回值处理
		return rtns[0];
	}
}
