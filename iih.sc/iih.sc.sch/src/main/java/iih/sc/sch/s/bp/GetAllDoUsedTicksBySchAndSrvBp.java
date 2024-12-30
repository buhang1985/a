package iih.sc.sch.s.bp;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取所有可用号段 
 * @author ccj
 *
 */
public class GetAllDoUsedTicksBySchAndSrvBp {
	
	/**
	 * 获取所有可用号段 
	 * @param id_sch 排班id
	 * @param id_srv 服务id
	 * @throws BizException
	 */
	public ScSchTicksDO[] exec(String id_sch,String id_srv) throws BizException{
		if(StringUtils.isEmpty(id_sch)) throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		IScticksRService iScticksRService = ServiceFinder.find(IScticksRService.class);
		String whereStr;
		if (ScParamUtils.getscAptCOI(null).booleanValue() && StringUtils.isNotEmpty(id_srv)) {
			IScBdOutQryService bdOutQryService = ServiceFinder.find(IScBdOutQryService.class);
			String srvArrays = bdOutQryService.getScSrvIdsByBdSrv(id_srv);
			if(StringUtils.isEmpty(srvArrays)) return null;
			//医技预约检查项目类型 true 且  有指定服务
			whereStr = String.format("id_sch='%s' and id_scsrv = (%s) and fg_active = 'Y' and (QUECN_APPT -  NVL(QUECN_USED, 0))>0",id_sch,srvArrays);
		}else{
			whereStr = String.format("id_sch='%s' and fg_active = 'Y' and (QUECN_APPT -  NVL(QUECN_USED, 0))>0",id_sch);
		}
		ScSchTicksDO[] schTicksDOs = iScticksRService.find(whereStr, "queno_b", FBoolean.TRUE);
		return schTicksDOs;
	}
	
}
