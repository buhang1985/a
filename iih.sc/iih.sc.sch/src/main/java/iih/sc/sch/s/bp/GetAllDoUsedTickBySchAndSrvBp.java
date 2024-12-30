package iih.sc.sch.s.bp;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取所有可用号位
 * @author ccj
 */
public class GetAllDoUsedTickBySchAndSrvBp {
	
	/**
	 * 获取所有可用号位
	 * @param id_sch 排班id
	 * @param id_srv 服务id
	 * @return
	 */
	public ScSchTickDO[] exec(String id_srv,String id_sch) throws  BizException{
		if(StringUtils.isEmpty(id_sch)) throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		String whereStr;
		if (ScParamUtils.getscAptCOI(null).booleanValue() && StringUtils.isNotEmpty(id_srv)) {
			IScBdOutQryService bdOutQryService = ServiceFinder.find(IScBdOutQryService.class);
			String srvArrays = bdOutQryService.getScSrvIdsByBdSrv(id_srv);
			if(StringUtils.isEmpty(srvArrays)) return null;
			// 医技预约检查项目类型 true 且 有指定服务
			whereStr = String.format("id_sch='%s' and id_scsrv in (%s) and fg_active = 'Y' and eu_used = %d and eu_usescope = %d ", id_sch, srvArrays, EuUseState.WY, EuUseScope.APT);
		} else {
			whereStr = String.format("id_sch='%s' and fg_active = 'Y' and eu_used = %d and eu_usescope = %d ", id_sch, EuUseState.WY, EuUseScope.APT);
		}
		ISctickRService sctickRService = ServiceFinder.find(ISctickRService.class);
		return sctickRService.find(whereStr, "queno", FBoolean.TRUE);
	}
	
}
