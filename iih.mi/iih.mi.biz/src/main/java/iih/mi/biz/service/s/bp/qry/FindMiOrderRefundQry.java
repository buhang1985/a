package iih.mi.biz.service.s.bp.qry;

import iih.mi.biz.dto.miorderrecorddto.d.MiOrderBusinessState;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据订单号查询全退和重收的数据
 * @author liming06
 *
 */
public class FindMiOrderRefundQry implements ITransQry {

	String id_order ;
	String selStr="id_orderrecord,code_st,trade_no";
	public FindMiOrderRefundQry(String id_order){
		this.id_order=id_order;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(id_order); //订单ID
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		//全退
		sb.append("select ");
		sb.append(" refund.id_orderrecord,refund.code_st,refund.trade_no,"+ MiOrderBusinessState.REFUND +" as eu_business");
		sb.append(" from mi_order_record refund");
		sb.append(" where   refund.id_parent=?");
		sb.append(" union all");
		//重收
		sb.append(" select ");
		sb.append(" recharge.id_orderrecord,recharge.code_st,recharge.trade_no,"+ MiOrderBusinessState.REFUND +" as eu_business");
		sb.append(" from mi_order_record recharge");
		sb.append(" where exists ( select 1 from mi_order_record refund where recharge.id_parent=refund.id_orderrecord and  refund.id_parent=?)");
		
		return sb.toString();
	}

}
