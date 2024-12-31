package xap.rptdsplugin.comm;

import com.software.vtreport.sysfuncs.RptSysFuncMgr;

public class RptFuncExtLoader {
	// 业务扩展的日期函数分类ID、Name
	public final static int CatID_DateBiz = RptSysFuncMgr.BizCat_From + 1;
	public final static String CatName_DateBiz = "日期扩展函数";
	
	/**
	 * 供报表获取扩展函数定义的入口，该方法名不能变 <br/>
	 * 注：返回的class中，必须存在定义报表函数类别的方法：static SysFuncCategory[] getCategories()
	 */
	public static Class<?>[] GetRptFuncClzz() {
		return new Class<?>[] {
			RptBizFuncs.class,
		};
	}
}
