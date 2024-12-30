package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.i.IMporInternalService;
import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class RewriteOrClosedLoopState {
	
	/**
	 * 预约医嘱闭环   组织参数 SC1000    0:不调闭环       1:调用闭环  
	 * @author maxy
	 * @param id_or  医嘱id
	 * @param dt_plan 医嘱时间
	 * @param funCode  节点编码
	 * @param direction 0 正向 1 逆向
	 * @throws BizException
	 */
	public static void exec(String id_or,FDateTime dt_plan,String funCode,int direction) throws BizException
	{
		if(ScParamUtils.getScSysAptUseMpCircle().equals(1))
		{
			// 拼装回写医嘱闭环状态的入参数据
			OrPlanDTO orPlanDto = new OrPlanDTO();
			orPlanDto.setId_or(id_or);
			orPlanDto.setDt_mp_plan(dt_plan);
			orPlanDto.setEu_tp(1);
			orPlanDto.setId_dep(ScContextUtils.getDeptId());
			orPlanDto.setId_emp(ScContextUtils.getPsnId());
			orPlanDto.setDt_exe(ScAppUtils.getServerDateTime());
			IMporInternalService mporInternalService = ServiceFinder.find(IMporInternalService.class);
			if (direction == 0) {
				//调用正向闭环接口
				mporInternalService.updateOrpltpByOr(new OrPlanDTO[]{orPlanDto}, funCode, null);
			}else if(direction == 1){
				//调用逆向闭环接口
				mporInternalService.cancelByOrPan(new OrPlanDTO[]{orPlanDto});
			}
		}
	}
}
