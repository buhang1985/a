package iih.ci.diag.pub;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 通用的类
 * 系统时间
 * 登陆用户信息
 */
public class CommonUtil {
	//系统时间
	
	public static FDateTime getDateTime()throws BizException{
		TimeService timeService = new TimeServiceImpl();
		 FDateTime dateTime = timeService.getUFDateTime();
		 return  dateTime;
	}
	
/*	public static FTime getTime()throws BizException{
		TimeService timeService = new TimeServiceImpl();
		return  timeService.getTime()
		 
	}*/

	public static Context getContext(){
	    return Context.get();
	}
	
	/**
	 * 医保的诊断判断
	 * @param id_hp
	 * @param id_diArr
	 * @param id_entp
	 * @return Map<String,FBoolean>
	 * @throws BizException
	 */
	public static Map<String,FBoolean> BdHpDiJudge(String id_hp,String[] id_diArr,String id_entp) throws BizException{
		return CiDiAppUtils.getIHpQueService().BdHpDiJudge(id_hp, id_diArr, id_entp);	
	}
	
	 //住院诊断维护作废模式设置  01不允许作废、11任意医生可作废、12本人及上级医生可作废、13本人可作废
    public static String getIpDiCancelModeSet(String parameter)throws BizException{
    	return ParamsetQryUtil.getParaString(parameter,CiDiagConstant.sys_IpDiCancelModeSet);
    }
	 //住院诊断控制模式  01不管控,02严格管控
    public static String getIpDiControlMode(String parameter)throws BizException{
    	return ParamsetQryUtil.getParaString(parameter,CiDiagConstant.sys_IpDiControlMode);
    }
}
