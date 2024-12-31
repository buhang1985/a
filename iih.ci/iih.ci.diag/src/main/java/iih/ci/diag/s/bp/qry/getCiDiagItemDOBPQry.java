/**
 * 
 */
package iih.ci.diag.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getCiDiagItemDOBPQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月22日 上午10:31:59
 * @Package iih.ci.diag.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getCiDiagItemDOBPQry implements ITransQry {
  
	public String _id_en;
	public String _code_entp ;
	public getCiDiagItemDOBPQry(String id_en,String code_entp){
		this._id_en = id_en;
		this._code_entp =code_entp;
	}
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlParam = new SqlParam();
		 sqlParam.addParam(this._id_en);
		 sqlParam.addParam(this._code_entp);
		 sqlParam.addParam(this._id_en);
		 sqlParam.addParam(this._code_entp);
		 sqlParam.addParam(this._id_en);
		return sqlParam;
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
		StringBuffer sb = new StringBuffer();
		sb.append("   select * from ci_di_itm");
		sb.append("  where id_di  in ");
		sb.append(" (select id_di from ci_di where dt_sign in (");
		sb.append("  select max(dt_sign) from ci_di where id_en =?  and ");
		sb.append("  fg_sign ='Y' and sd_ditp !='4' and code_entp =? ");
		sb.append("  union all  ");
		sb.append("  select max(dt_sign) from ci_di where id_en =?");
		sb.append("  and  fg_sign ='Y'  and  sd_ditp ='4' and code_entp =? ");
		sb.append("  )  and ci_di.id_en =?  )   and  ci_di_itm.fg_majdi ='Y' ");;
		 return sb.toString();
 
	}
}
