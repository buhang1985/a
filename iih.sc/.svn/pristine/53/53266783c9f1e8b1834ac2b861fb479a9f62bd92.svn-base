package iih.sc.scp.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDORService;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvRService;
import xap.lui.core.scriptrule.XapScriptAPI;
import xap.mw.core.data.BizException;
import xap.mw.core.data.agg.voutils.SafeCompute;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;	

/**
 * 按照规则引擎设置计划名称
 * @author libaoliang
 *
 */
public class GetScPlNameBP {
	
	 /**
     * 按照规则引擎设置计划名称
     * @param srvId
     * @param resId
     * @return
     * @throws BizException
     */
    public String exec(String depId, String srvId,String resId) throws BizException{
    	Map<String, Object> varies=new HashMap<String, Object>();
    	IDeptRService deptRService=ServiceFinder.find(IDeptRService.class);
    	DeptDO deptDO=deptRService.findById(depId);
    	ISchedulesrvMDORService schedulesrvMDORService=ServiceFinder.find(ISchedulesrvMDORService.class);
    	ScheduleSrvDO scheduleSrvDO=schedulesrvMDORService.findById(srvId);
    	IScheduleresRService scheduleresRService =ServiceFinder.find(IScheduleresRService.class);
    	ScheduleResDO scheduleResDO=	scheduleresRService.findById(resId);
    	varies.put("scplType", IScDictCodeConst.SD_SCTP_OP.equals(scheduleResDO.getSd_sctp())?"门": IScDictCodeConst.SD_SCTP_MT.equals(scheduleResDO.getSd_sctp())?"医":"无需处理");
    	varies.put("DeptDO", deptDO);
    	varies.put("ScheduleSrvDO", scheduleSrvDO);
    	varies.put("ScheduleResDO", scheduleResDO);
    	Map<String, Object> map=	XapScriptAPI.exeRule("SC.PL", varies);
		try {
		return map.get("sc_pl_name").toString();
		} catch (Exception e) {
			throw new BizException("排班计名称划规则应用失败！");
		}
    }

}
