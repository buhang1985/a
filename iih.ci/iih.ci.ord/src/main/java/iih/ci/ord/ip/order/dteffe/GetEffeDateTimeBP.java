package iih.ci.ord.ip.order.dteffe;

import java.util.List;

import org.eclipse.jetty.util.log.Log;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import iih.ci.sdk.utils.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class GetEffeDateTimeBP {
	
	
	/**
	 * 开始时间默认赋值规则
	 * @param id_ent
	 * @param ipLoginDt
	 * @return
	 * @throws BizException 
	 */
	public   FDateTime GetEffeDateTime(String id_ent,FDateTime ipLoginDt) throws BizException{
		String effeparam=SysParamUtils.getSysParam().getSYS_PARAM_IpOrdDtEentryDefaultSet().getOrgParam();
		String minute =  SysParamUtils.getSysParam().getSYS_PARAM_IpOrdDtEentryDefaultMinute().getOrgParam();
		FDateTime dt_effe=CiOrdAppUtils.getServerDateTime();
		Boolean IsMinute = getMinute(ipLoginDt,dt_effe,minute);
		OrdBizLogger.info(null, String.format("GetEffeDateTime参数  effeparam %s ,  minute %s", effeparam,minute));
		if(IsMinute) {
			return dt_effe;
		}
		
		if(StringUtils.isEmptty(effeparam))return CiOrdAppUtils.getServerDateTime();
		switch(effeparam){

		case ICiOrdNSysParamConst.PARAM_IPORDDTEENTRYDEFAULTSET_CUR:
			//当【开始时间默认赋值规则】 = 0 当前时间 , 医嘱默认开始时间=当前系统时间
			return dt_effe.addSeconds(2);
		case ICiOrdNSysParamConst.PARAM_IPORDDTEENTRYDEFAULTSET_SET:
			//当【开始时间默认赋值规则】 =1配置时间 , 医嘱默认开始时间 = 当天日期 + 【开始时间默认配置时间】。
			String defTime=SysParamUtils.getSysParam().getSYS_PARAM_IpOrdDtEentryDefaultTime().getOrgParam();//开始时间默认配置时间
			if(StringUtils.isEmpty(defTime))return dt_effe;
			String datetime=dt_effe.getDate().toString()+" "+defTime;
			return new FDateTime(datetime);
		case ICiOrdNSysParamConst.PARAM_IPORDDTEENTRYDEFAULTSET_FRONT:
			//当【开始时间默认赋值规则】 =2上条时间 , 以一次医生站打开为一个区间,若在该区间内，没有新开医嘱时，新开的第一条医嘱，开始时间默认为当前系统时间,再次新开一条医嘱时，医嘱的默认开始时间 = 最新修改的开立医嘱的开始时间
			String  orderBy = " DESC ";
			String SequenceMode =SysParamUtils.getSysParam().getSYS_PARAM_OpListMarshalSequenceMode().getOrgParam();
			if("2".equals(SequenceMode)) {
				orderBy = " ASC";
			}
			List<String> obj=getNextOrdDtEntry2(id_ent,ipLoginDt,orderBy);
			if(obj!=null && obj.size() >0) { 
				 FDateTime datatime =  new FDateTime((obj.get(0).toString()));
					if(getMinute(datatime ,dt_effe,minute)) {
						return dt_effe;	
					}else {
						return datatime;
					}
				}else {
					return dt_effe;	
				}
		}
		return dt_effe;
	}
	
	/**
	 *获取最新 医嘱的时间
	 * @param id_ent
	 * @param ipLoginDt
	 * @return
	 * @throws BizException
	 */
	private   List<String> getNextOrdDtEntry2(String id_ent,FDateTime ipLoginDt,String orderBy) throws BizException{
		String wherestr=String.format("select ord.dt_effe from ci_order ord where ord.eu_orsrcmdtp !='0C' and ord.id_en = '%s'    order by    dt_effe  "+orderBy +" ,nvl(sortno,0)  "+orderBy+"  ",id_ent);
		return (List<String>) new DAFacade().execQuery(wherestr, new ColumnListHandler());
	}
	
	/**
	 * 时间的比较
	 * @param ipLoginDt
	 * @param dt_effe
	 * @param paramminute
	 * @return
	 */
	private    Boolean getMinute(FDateTime ipLoginDt,FDateTime dt_effe,String paramminute)throws BizException {
		if(paramminute != null) {
			double millisecond =  dt_effe.getMillis()-ipLoginDt.getMillis();
			double minute = millisecond / (60 * 1000);
			int difminute = Integer.parseInt(paramminute);
			if ((int)minute > difminute) {
				return true;
			}
		   return  false;
		}
		return true;
	}

}
