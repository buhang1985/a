package iih.en.pv.s.mvelextmethod;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

import com.ymer.designer.scripteditor.MvelExtMethod;

/**
 * 预检内置函数
 * 
 * @author Administrator
 *
 */
public class PreMvelExcute implements MvelExtMethod {

	@Override
	public void importMethod(ParserContext ctx) {
		ctx.addImport("getAge", MVEL.getStaticMethod(PreMvelExcute.class, "getAge", new Class[] { FDate.class}));
		ctx.addImport("hasPreInfo", MVEL.getStaticMethod(PreMvelExcute.class, "hasPreInfo", new Class[] { String.class }));
		ctx.addImport("hasPreBetweenYears", MVEL.getStaticMethod(PreMvelExcute.class, "hasPreBetweenYears", new Class[] { String.class, Integer.class }));
		ctx.addImport("hasPreBetweenMonths", MVEL.getStaticMethod(PreMvelExcute.class, "hasPreBetweenMonths", new Class[] { String.class, Integer.class }));
		ctx.addImport("hasPreBetweenDays", MVEL.getStaticMethod(PreMvelExcute.class, "hasPreBetweenDays", new Class[] { String.class, Integer.class }));
	}
	
	@Override
	public Map<String,String> getMethodParamsDesc(){
		Map<String, String> descs = new HashMap<String, String>();
		descs.put("getAge", "计算年龄，参数[出生日期]，返回值[int:年龄]");
		descs.put("hasPreInfo", "本次就诊是否已经预检，返回值[boolean]");
		descs.put("hasPreBetweenYears", "患者N年之内是否经过预检，参数[患者编码,N]");
		descs.put("hasPreBetweenMonths", "患者N个月之内是否经过预检，参数[患者编码,N]");
		descs.put("hasPreBetweenDays", "患者N天之内是否经过预检，参数[患者编码,N]");
		return descs;
	}

	@Override
	public String getClazzDesc() {
		return "门急诊预检预置规则函数!";
	}
	
	public Map<String, String> getReturnTypes() {
		Map<String, String> returnTypes = new HashMap<String, String>();
		returnTypes.put("getAge", int.class.getName());
		returnTypes.put("hasPreInfo", boolean.class.getName());
		returnTypes.put("hasPreBetweenYears", boolean.class.getName());
		returnTypes.put("hasPreBetweenMonths", boolean.class.getName());
		returnTypes.put("hasPreBetweenDays", boolean.class.getName());
		return returnTypes;
	}
	/**
	 * 获取年龄
	 * 
	 * @param birth
	 * @return
	 */
	public static int getAge(FDate birth){
		if(birth != null){
			FDateTime curTime = EnAppUtils.getServerDateTime();
			FDate curDate = curTime.getDate().asBegin();
			if (birth.after(curDate)) {
			   return -1;
			}    
			int Months = curDate.getLocalMonth() - birth.getLocalMonth() + 12 * (curDate.getLocalYear() - birth.getLocalYear());
			Calendar cal = Calendar.getInstance();
			cal.setTime(birth.toDate());
			cal.add(Calendar.MONTH, Months);  
			int totalMonth = new FDate(cal.getTime()).after(curDate) ? Months - 1 : Months;    
			int fullYear = totalMonth / 12;
			return fullYear;
		}
		return -1;
	}
	/**
	 * 本次就诊有没有预检信息
	 * 
	 * @param Id_ent
	 * @return
	 * @throws BizException
	 */
	public static boolean hasPreInfo(String Id_ent) throws BizException{
		if(EnValidator.isEmpty(Id_ent))
			return false;
		String sql = "SELECT COUNT(*) FROM CI_OBS_PRE WHERE ID_ENT = ? ";
		SqlParam param = new SqlParam();
		param.addParam(Id_ent);
		int count = (int) new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(count > 0){
			return true;
		}
		return false;
	}
	/**
	 * 判断years年内是否有预检信息
	 * 
	 * @param pat_code
	 * @param years
	 * @return
	 * @throws BizException
	 */
	public static boolean hasPreBetweenYears(String pat_code, Integer years) throws BizException{
		if(years == null)
			return false;
		FDateTime curTime = EnAppUtils.getServerDateTime();
		FDateTime bDateTime = getDateTime(curTime, -years, Calendar.YEAR);
		return hasPre(pat_code, bDateTime, curTime);
	}
	/**
	 * 判断months个月内是否有预检信息
	 * 
	 * @param pat_code
	 * @param months
	 * @return
	 * @throws BizException
	 */
	public static boolean hasPreBetweenMonths(String pat_code, Integer months) throws BizException{
		if(months == null)
			return false;
		FDateTime curTime = EnAppUtils.getServerDateTime();
		FDateTime bDateTime = getDateTime(curTime, -months, Calendar.MONTH);
		return hasPre(pat_code, bDateTime, curTime);
	}
	/**
	 * 判断days天内是否有预检信息
	 * 
	 * @param pat_code
	 * @param days
	 * @return
	 * @throws BizException
	 */
	public static boolean hasPreBetweenDays(String pat_code, Integer days) throws BizException{
		if(days == null)
			return false;
		FDateTime curTime = EnAppUtils.getServerDateTime();
		FDateTime bDateTime = getDateTime(curTime, -days, Calendar.DATE);
		return hasPre(pat_code, bDateTime, curTime);
	}
	/**
	 * 判断此时间段内是否有预检
	 * 
	 * @param pat_code
	 * @param bDateTime
	 * @param eDateTime
	 * @return
	 * @throws BizException
	 */
	private static boolean hasPre(String pat_code, FDateTime bDateTime, FDateTime eDateTime) throws BizException{
		String sql = getSql();
		SqlParam param = getParam(pat_code, bDateTime, eDateTime);
		int count = (int) new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(count > 0){
			return true;
		}
		return false;
	}
	/**
	 * 获取SQL语句
	 * 
	 * @return
	 */
	private static String getSql(){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(CI_OBS_PRE.ID_OBSPRE) ");
		sb.append("FROM PI_PAT PI_PAT ");
		sb.append("INNER JOIN EN_ENT EN_ENT ON PI_PAT.ID_PAT = EN_ENT.ID_PAT ");
		sb.append("INNER JOIN CI_OBS_PRE CI_OBS_PRE ON EN_ENT.ID_ENT = CI_OBS_PRE.ID_ENT ");
		sb.append("WHERE PI_PAT.CODE = ? ");
		sb.append("AND EN_ENT.DT_ACPT >= ? ");
		sb.append("AND EN_ENT.DT_ACPT <= ? ");
		//集团管控
		String orgWhere = ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN_ENT");
		if(!EnValidator.isEmpty(orgWhere)){
			sb.append(" AND ").append(orgWhere);
		}
		return sb.toString();
	}
	/**
	 * 获取参数
	 * 
	 * @param pat_code
	 * @param bDateTime
	 * @param eDateTime
	 * @return
	 */
	private static SqlParam getParam(String pat_code, FDateTime bDateTime, FDateTime eDateTime){
		SqlParam param = new SqlParam();
		param.addParam(pat_code);
		param.addParam(bDateTime);
		param.addParam(eDateTime);
		return param;
	}
	/**
	 * 获取时间
	 * 
	 * @param curTime
	 * @param amount
	 * @param field
	 * @return
	 */
	private static FDateTime getDateTime(FDateTime curTime, int amount, int field){
		Calendar cal = Calendar.getInstance();
		//FTime time = curTime.getUFTime();
		cal.setTime(curTime.getBeginDate().toDate());
		cal.add(field, amount);
		return new FDateTime(cal.getTime());
	}
}

