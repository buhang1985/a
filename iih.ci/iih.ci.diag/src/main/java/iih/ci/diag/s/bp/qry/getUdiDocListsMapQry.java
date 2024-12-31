/**
 * 
 */
package iih.ci.diag.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询诊断体系
 * @ClassName: getUdiDocListsMapBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年3月2日 下午4:32:34
 * @Package iih.ci.diag.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getUdiDocListsMapQry implements ITransQry {
   
	
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		return param;
	}

	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}

	private String getSql(){
		return "  select  * from bd_udidoc where id_udidoclist ='"+ICiDictCodeConst.CI_DISYS+"'";
                
	}
}
