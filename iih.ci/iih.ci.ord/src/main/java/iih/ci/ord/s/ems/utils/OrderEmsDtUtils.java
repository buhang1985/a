package iih.ci.ord.s.ems.utils;

import java.util.Map;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;

public class OrderEmsDtUtils {
	/**
	 * 计算停止时间（已使用）
	 * @param statTime
	 * @param usedays
	 * @return
	 */
	public static FDateTime GetEndDateTime(FDateTime statTime, int usedays) {
		if (statTime == null || usedays == 0)
			return null;

		return statTime.getDateTimeAfter(usedays);
	}

	/**
	 * 开始时间默认赋值规则
	 * @param id_ent
	 * @param ipLoginDt
	 * @return
	 * @throws BizException 
	 */
	public static FDateTime GetEffeDateTime(String id_ent,FDateTime ipLoginDt) throws BizException{
		String effeparam=SysParamUtils.getSysParam().getSYS_PARAM_IpOrdDtEentryDefaultSet().getOrgParam();
		FDateTime dt_effe=CiOrdAppUtils.getServerDateTime();
		
		if(CiOrdUtils.isEmpty(effeparam))return CiOrdAppUtils.getServerDateTime();
		switch(effeparam){

		case ICiOrdNSysParamConst.PARAM_IPORDDTEENTRYDEFAULTSET_CUR:
			//当【开始时间默认赋值规则】 = 0 当前时间 , 医嘱默认开始时间=当前系统时间
			return dt_effe;
		case ICiOrdNSysParamConst.PARAM_IPORDDTEENTRYDEFAULTSET_SET:
			//当【开始时间默认赋值规则】 =1配置时间 , 医嘱默认开始时间 = 当天日期 + 【开始时间默认配置时间】。
			String defTime=SysParamUtils.getSysParam().getSYS_PARAM_IpOrdDtEentryDefaultTime().getOrgParam();//开始时间默认配置时间
			if(CiOrdUtils.isEmpty(defTime))return dt_effe;
			return new FDateTime(dt_effe.getDate(),new FTime(defTime));
		case ICiOrdNSysParamConst.PARAM_IPORDDTEENTRYDEFAULTSET_FRONT:
			//当【开始时间默认赋值规则】 =2上条时间 , 以一次医生站打开为一个区间,若在该区间内，没有新开医嘱时，新开的第一条医嘱，开始时间默认为当前系统时间,再次新开一条医嘱时，医嘱的默认开始时间 = 最新修改的开立医嘱的开始时间
			Object obj=getNextOrdDtEntry(id_ent,ipLoginDt);
			if(obj!=null) return new FDateTime(((Map<String, Object>)obj).get("dt_effe").toString());
			return dt_effe;
		}
		return null;
	}
	
	private static Object getNextOrdDtEntry(String id_ent,FDateTime ipLoginDt) throws BizException{
		String wherestr=String.format("select ord.dt_effe from ci_order ord where ord.id_en = '%s'  and ord.dt_entry > '%s'  and rownum = 1 order by ord.code_or desc",id_ent,ipLoginDt);
		return new DAFacade().execQuery(wherestr, new MapHandler());
	}
}
