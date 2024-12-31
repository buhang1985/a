package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.i.IDODesc;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;

/**
 * 医疗服务 DO数据 
 * 
 */
public class MedSrvDO2 extends MedSrvDO {
	
	@Override
	public String getTableName() {	  
		return "bd_srv_import";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvDODesc.class);
	}
	
}