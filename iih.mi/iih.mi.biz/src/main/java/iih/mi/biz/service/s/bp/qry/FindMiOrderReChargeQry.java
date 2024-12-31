package iih.mi.biz.service.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据订单号查询全退和重收的数据
 * @author liming06
 *
 */
public class FindMiOrderReChargeQry implements ITransQry {

	String code_st ;
	public FindMiOrderReChargeQry(String code_st){
		this.code_st=code_st;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(code_st); //结算编码
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		//全退
		sb.append("select *");
		sb.append(" from mi_order_record recharge");
		sb.append(" where  exists (select ori.id_orderrecord from mi_order_record ori");
		sb.append("  inner join mi_order_st_record st on ori.id_orderrecord= st.id_orderrecord");
		sb.append("  where  recharge.id_parent=ori.id_orderrecord and st.code_st=?)");
		return sb.toString();
	}

}
