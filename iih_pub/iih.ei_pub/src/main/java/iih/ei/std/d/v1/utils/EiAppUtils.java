package iih.ei.std.d.v1.utils;

import java.util.HashSet;
import java.util.Set;

import com.mysql.jdbc.StringUtils;

import iih.bd.res.dayslot.i.IDayslotQryService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

public class EiAppUtils {
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	public static FDateTime getServerDateTime(){
		TimeService ts = ServiceFinder.find(TimeService.class);
		return  ts.getUFDateTime();
	}
	/***
	 * 获得服务器日期
	 * @return
	 */
	public static FDate getServerDate(){
		TimeService ts = ServiceFinder.find(TimeService.class);
		return  ts.getUFDateTime().getDate().asLocalBegin();
	}
	/**
	 * 获取日期时间
	 * 当前时间处于日期分组开始时间之前，取日期分组开始时间
	 * 
	 * @param dayslotId
	 * @return
	 * @throws BizException 
	 */
	public static FDateTime getAcptQryDateTime(FDate date, String dayslotId) throws BizException{
		FDateTime curDateTime = getServerDateTime();
		if(StringUtils.isNullOrEmpty(dayslotId))
			return curDateTime;
		IDayslotQryService serv = ServiceFinder.find(IDayslotQryService.class);
		FTime time = serv.getDayslotStartTime(dayslotId);
		FDateTime dayDateTime = getFDateTime(date == null ? curDateTime.getDate() : date, time);
		if(curDateTime.before(dayDateTime))
			return dayDateTime;
		return curDateTime;
	}
	/**
	 * 根据日期和时间获取日期时间类型
	 * @param date 日期
	 * @param time 时间
	 * @return
	 */
	public static FDateTime getFDateTime(FDate date,FTime time){
		return new FDateTime(date.asLocalBegin(),time);
	}
	/**
	 * 从BaseDO数组中获取某个字段集合
	 * （该字段必须为String类型）
	 * @param keyPropName
	 * @param dos
	 * @return
	 */
	public static String[] getKeyPropArrayFromDO(String keyPropName, BaseDO...dos){
		if(ArrayUtil.isEmpty(dos))
			return null;
		Set<String> set = new HashSet<String>();
		for(BaseDO d : dos){
			Object obj = d.getAttrVal(keyPropName);
			if(obj != null && obj instanceof String){
				set.add((String)obj);
			}
		}
		return set.isEmpty() ? null : set.toArray(new String[set.size()]);
	}
	/**
	 * DO集合转FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static FArrayList doArray2List(BaseDO...dos){
		if(ArrayUtil.isEmpty(dos))
			return null;
		FArrayList list = new FArrayList();
		for(BaseDO d : dos)
			list.add(d);
		return list;
	}
	
	/**
	 * Object集合转FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static FArrayList objArray2List(Object...objs){
		if(EiValidator.isNullOrEmpty(objs))
			return null;
		FArrayList list = new FArrayList();
		for(Object d : objs)
			list.add(d);
		return list;
	}
	
}
