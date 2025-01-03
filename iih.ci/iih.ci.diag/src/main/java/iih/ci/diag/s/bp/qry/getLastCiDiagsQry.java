/**
 * 
 */
package iih.ci.diag.s.bp.qry;

import com.google.common.reflect.Parameter;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getLastCiDiagsQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年3月2日 下午1:45:25
 * @Package iih.ci.diag.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getLastCiDiagsQry implements ITransQry {

    public String _id_en;
    public getLastCiDiagsQry(String id_en){
    	this._id_en = id_en;
    }
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		param.addParam(this._id_en);
		//param.addParam(this._id_en);
		//param.addParam(this._id_en);
		return param;
	}
 
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return  getSql();
	}

	private String getSql(){
		
		return "  select  *   from ci_di  where id_en =? "
				+ "  and fg_sign = 'Y' and fg_cancel='N' order  by  sd_ditp desc , dt_sign desc ";
		/*return "  select * from ci_di where dt_sign in ("
			   +" select max(dt_sign) from ci_di where id_en =?"
			   +"  and  fg_sign ='Y' "
			   +"  and sd_ditp !='4'"
			   +"  union"
			   +"  select max(dt_sign) from ci_di where sd_ditp ='4' and fg_sign ='Y'  and id_en =? "
		       +")";*/
			/*+ " sd_ditp =("
				+ "select max(sd_ditp) "
				+ "from ci_di where id_en = ?) ";*/
	}
}
