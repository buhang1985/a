package iih.pe.pwf.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

public interface IPeInitMaintainService {
	//体检系统每日初始化
	public void peInit(String init_date, String id_grp, String id_org) throws BizException;

	public String peIdno() throws BizException;
	
	//体检系统每日初始化功能，增加删除多余健康管理预约信息的功能
	public void peHmDel(FDate nowDate, String id_grp, String id_org) throws BizException;
}
