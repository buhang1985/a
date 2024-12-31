package iih.en.comm.util;

import iih.bd.res.dayslot.i.IDayslotQryService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.IEnRuleConst;
import iih.en.comm.validator.EnValidator;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 应用帮助类
 * @author yankan
 *
 */
public class EnAppUtils {
	/**
	 * SqlParamDTO转换为SqlParam
	 * 
	 * @param sqlParamDTO
	 * @return
	 */
	public static SqlParam convertToSqlParam(SqlParamDTO sqlParamDTO) {
		if (sqlParamDTO == null)
			return null;
		FArrayList parameters = sqlParamDTO.getParameters();
		if (EnValidator.isEmpty(parameters))
			return null;
		SqlParam sqlParam = new SqlParam();
		for (int i = 0; i < parameters.size(); ++i) {
			sqlParam.addParam(parameters.get(i));
		}
		return sqlParam;
	}
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
		if(EnValidator.isEmpty(dayslotId))
			return curDateTime;
		IDayslotQryService serv = ServiceFinder.find(IDayslotQryService.class);
		FTime time = serv.getDayslotStartTime(dayslotId);
		FDateTime dayDateTime = getFDateTime(date == null ? curDateTime.getDate() : date, time);
		if(curDateTime.before(dayDateTime))
			return dayDateTime;
		return curDateTime;
	}
	/**
	 * 计算可提前接诊时间
	 * 
	 * @param dateTime
	 * @return
	 */
	public static FDateTime getAdvanceAcptTime(FDateTime dateTime){
		int time = EnParamUtils.getAdvanceAcptTime();
		if(time > 0)
			return dateTime.addSeconds(time * 60);
		return dateTime;
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
	 * 获取拼音码
	 * TODO 后续框架提供支持
	 * @param name 名称
	 * @return
	 */
	public static String getPyCode(String name){
		String py=CnToPy.getPyFirstCode(name);
		return py;
	}
	/**
	 * 获取五笔码
	 * TODO 后续框架提供支持
	 * @param name 名称
	 * @return
	 */
	public static String getWbCode(String name){
		String wb=CnToWB.getWBCode(name);
		return wb;
	}
	
	/**
	 * 把日期转化为yyyyMMdd样式字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String toStringFDateFormat(FDate date){
		if(date == null || date.toDate() == null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(date.toDate());
	}
	/**
	 * 把日期转化为yyyyMMddHHmmss样式字符串
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String toStringFDateTimeFormat(FDateTime dateTime){
		if(dateTime == null || dateTime.getDate() == null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(dateTime.getDate().toDate());
	}
	/**
	 * Object集合转FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static FArrayList objArray2List(Object...objs){
		if(EnValidator.isEmpty(objs))
			return null;
		FArrayList list = new FArrayList();
		for(Object d : objs)
			list.add(d);
		return list;
	}
	/**
	 * DO集合转FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static FArrayList doArray2List(BaseDO...dos){
		if(EnValidator.isEmpty(dos))
			return null;
		FArrayList list = new FArrayList();
		for(BaseDO d : dos)
			list.add(d);
		return list;
	}
	/**
	 * AggDO集合转FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static FArrayList aggDoArray2List(BaseAggDO...dos){
		if(EnValidator.isEmpty(dos))
			return null;
		FArrayList list = new FArrayList();
		for(BaseAggDO d : dos)
			list.add(d);
		return list;
	}
	/**
	 * 从BaseDO数组中获取某个字段集合
	 * （该字段必须为String类型）
	 * @param keyPropName
	 * @param dos
	 * @return
	 */
	public static String[] getKeyPropArrayFromDO(String keyPropName, BaseDO...dos){
		if(EnValidator.isEmpty(dos))
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
	 * 该号码是否是手机号
	 * 
	 * @param mob
	 * @return
	 */
	public static boolean isMob(String mob){
		Pattern p = Pattern.compile("^[1]\\d{10}$");
		Matcher m = p.matcher(mob);
		return m.matches();
	}
	/**
	 * 获取自定义档案
	 * 
	 * @param udiTypeCode 自定义档案类型编码
	 * @param code 自定义档案编码
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO getUdidoc(String udiTypeCode, String code) throws BizException{
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		return serv.findByCode(udiTypeCode, code);
	}	
	/**
	 * 获取自定义档案
	 * 
	 * @param udiTypeCode 自定义档案类型编码
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO[] getUdidocs(String udiTypeCode) throws BizException{
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		return serv.findByUdidoclistCode(udiTypeCode);
	}
	/**
	 * 该号码是否是固定电话
	 * 
	 * @param tel
	 * @return
	 */
	public static boolean isTel(String tel){
		Pattern p = Pattern.compile("^\\d{3}-\\d{8}$|^\\d{4}-\\d{7,8}$");
		Matcher m = p.matcher(tel);
		return m.matches();
	}
	/**
	 * 计算年龄
	 * @param birthDate 出生日期
	 * @return
	 */
	public static Integer getAge(FDate birthDate){
		if(birthDate==null)
			return null;
		TimeService ts = ServiceFinder.find(TimeService.class);
		FDateTime currentTime = ts.getUFDateTime();
		int days = currentTime.getDate().getDaysAfter(birthDate);
		int age = days/365;
		return age;		
	}
	/**
	 * 获取挂号、入院登记规则引擎异常提示信息
	 * @param regMvelCode-规则编码
	 * @return
	 */
	public static String getRegMvelMsgForErr(String regMvelCode){
		switch(regMvelCode){
			case IEnRuleConst.EN_REG_AGE_CONST:
				return IEnMsgConst.EN_REG_AGE_CONST_MSG;
			case IEnRuleConst.EN_REG_SEX_MALE_CONST:
				return IEnMsgConst.EN_REG_SEX_MALE_CONST_MSG;
			case IEnRuleConst.EN_REG_SEX_FEMALE_CONST:
				return IEnMsgConst.EN_REG_SEX_FEMALE_CONST_MSG;
			case IEnRuleConst.EN_REG_COUNT_CONST:
				return IEnMsgConst.EN_REG_COUNT_CONST_MSG;
			case IEnRuleConst.EN_REG_REPEAT_CONST:
				return IEnMsgConst.EN_REG_REPEAT_CONST_MSG;
			case IEnRuleConst.SC_APT_REPEAT_CONST:
				return IEnMsgConst.SC_APT_REPEAT_CONST_MSG;
			case IEnRuleConst.EN_REG_DLOT_DEP_CONST:
				return IEnMsgConst.EN_REG_DLOT_DEP_CONST_MSG;
			case IEnRuleConst.IP_IS_EXIST_CONST:
				return IEnMsgConst.IP_IS_EXIST_CONST_MSG;
			case IEnRuleConst.EN_REG_JOINT_RULE2:
				return IEnMsgConst.EN_REG_JOINT_RULE2;
			case IEnRuleConst.EN_REG_SPINE_RULE2:
				return IEnMsgConst.EN_REG_JOINT_RULE2;
			case IEnRuleConst.EN_REG_RULE_18:
				return IEnMsgConst.EN_REG_AGE18_CONST_MSG;
				
			//入院登记
			case IEnRuleConst.EN_IP_AGE_CONST:
				return IEnMsgConst.EN_IP_AGE_CONST_MSG;
			case IEnRuleConst.EN_IP_SEX_MALE_CONST:
				return IEnMsgConst.EN_IP_SEX_MALE_CONST_MSG;
			case IEnRuleConst.EN_IP_SEX_FEMALE_CONST:
				return IEnMsgConst.EN_IP_SEX_FEMALE_CONST_MSG;
			default:
				return null;
		}
	}
}
