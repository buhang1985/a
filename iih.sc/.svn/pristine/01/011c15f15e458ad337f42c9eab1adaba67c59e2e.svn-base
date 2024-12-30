package iih.sc.apt.s.bp.mt.apt.validate;

import java.util.ArrayList;
import java.util.List;

import iih.sc.comm.IScMsgConst;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.i.IScSchOptsrvDORService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class ValSchSrvBP {
	/**
	 * 校验医疗服务是否在排班所对应排班服务当中
	 * @param id_srv
	 * @param schDO
	 * @throws BizException 
	 */
	public void exec(String id_srv,String id_sch,ScPlanDO planDO) throws BizException{
		// 排班服务查询服务
		IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
		String where = String.format(ScheduleSrvRelDO.ID_MDSRV + " = '%s'", id_srv);
		ScheduleSrvRelDO[] relDOs = relQryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(relDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH_4_SCSRV);
		}
		List<String> scSrvIds = new ArrayList<String>();
		for (ScheduleSrvRelDO relDO : relDOs) {
			scSrvIds.add(relDO.getId_scsrv());
		}
		//查询排班的备用排班服务
		List<String> scOptSrvIds = new ArrayList<String>();
		IScSchOptsrvDORService iscschoptsrvdorservice = ServiceFinder.find(IScSchOptsrvDORService.class);
		ScSchOptsrvDO[] optsrvs = iscschoptsrvdorservice.find("id_sch='"+id_sch+"'", null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(optsrvs)){
			for (ScSchOptsrvDO scSchOptsrvDO : optsrvs) {
				scOptSrvIds.add(scSchOptsrvDO.getId_scsrv());
			}
		}
		boolean checkOptSrv = false;
		for (String id_scsrv : scOptSrvIds) {
			if(scSrvIds.contains(id_scsrv)){
				checkOptSrv = true;
			}
		}
		if(!scSrvIds.contains(planDO.getId_scsrv()) && !checkOptSrv){
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH_4_SCSRV_TYPE);
		}
	}
}
