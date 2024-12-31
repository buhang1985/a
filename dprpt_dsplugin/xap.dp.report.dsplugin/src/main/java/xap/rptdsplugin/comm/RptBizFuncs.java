package xap.rptdsplugin.comm;

import java.util.Date;

import com.software.comm.util.StringUtil;
import com.software.vtreport.engine.script.GlobalScripts;
import com.software.vtreport.sysfuncs.RptSysFuncInfo;
import com.software.vtreport.sysfuncs.SysFuncCategory;

/**
 * 报表函数扩展类
 */
public class RptBizFuncs {
	/**
	 * 获取扩展分类项列表 <br/>
	 * 【注】待注册类中必须存在该静态方法，即使是返回null
	 */
	public static SysFuncCategory[] getCategories() {
		return new SysFuncCategory[] {
			new SysFuncCategory(RptFuncExtLoader.CatID_DateBiz, RptFuncExtLoader.CatName_DateBiz)
		};
	}
	
	// ======================= 日期函数 =========================//
	
	/**
	 * 调用底层方法计算年龄
	 */
	@RptSysFuncInfo(catId=RptFuncExtLoader.CatID_DateBiz, description="将生日字符串(1)按格式(2)转换成日期，然后计算年龄")
	public static String calcAge(String strBirthday, String strFmt) {
		String res_agestr = calcAge(strBirthday, null, strFmt);
		return res_agestr;
	}
	/**
	 * 旧版的年龄计算函数 (boolean参数没用了)
	 * @deprecated	废弃。从函数弹框列表中去掉了，但保留方法，用于兼容旧模板
	 */
	public static String calcAge(String strBirthday, String strFmt, boolean simpleAge) {
		String res_agestr = calcAge(strBirthday, strFmt);
		return res_agestr;
	}
	
	/**
	 * 调用底层方法计算年龄 <br/>
	 * 注1: 结束日期可以传入null，表示使用系统当前时间
	 * @param strBirthday	生日
	 * @param strToDate		指定的结束日期，为空表示使用系统时间
	 * @param strFmt		日期格式	
	 */
	@RptSysFuncInfo(catId=RptFuncExtLoader.CatID_DateBiz, description="将生日字符串(1)和截至日期字符串(2)均按格式(3)转换成日期，然后计算年龄")
	public static String calcAge(String strBirthday, String strToDate, String strFmt) {
		// 解析出生日期字符串
		Date dt_birthday = GlobalScripts.parseDate(strBirthday, strFmt);
		if(null == dt_birthday) return GlobalScripts.Text_EmptyAge;
		
		// 解析截至日期字符串
		Date to_date = null;
		if(StringUtil.isNullOrEmpty(strToDate)) { to_date = new Date(); }
		else { to_date = GlobalScripts.parseDate(strToDate, strFmt); }
		if(null == to_date || to_date.before(dt_birthday)) return GlobalScripts.Text_EmptyAge;
		
		// 调用底层(xap.sys_pub)的年龄计算函数
		xap.mw.coreitf.d.FDate birth_day = new xap.mw.coreitf.d.FDate(dt_birthday);
		xap.mw.coreitf.d.FDateTime to_datetime = new xap.mw.coreitf.d.FDateTime(to_date);
		//String res_agestr = xap.sys.util.AgeCalcUtil.getAge(birth_day, to_datetime);
		String res_agestr = xap.sys.appfw.xapformula.utils.AgeCalcUtil.getAge(birth_day);
		return res_agestr;
	}
}
