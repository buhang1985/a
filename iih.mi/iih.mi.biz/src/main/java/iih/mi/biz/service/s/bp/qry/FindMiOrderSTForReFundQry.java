package iih.mi.biz.service.s.bp.qry;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据结算号查询订单结算信息
 * 
 * @author liming06
 * @since 2019-11-11
 */
public class FindMiOrderSTForReFundQry implements ITransQry {

	String code_st;
	FBoolean bCharge;
	String selField = "st.id_orderstrecord,st.id_orderrecord,st.id_pat,st.hp_no,st.id_hp," + "st.code_st,st.eu_direct,st.id_parent,st.id_root,st.register_no,st.trade_no,"
			+ " st.eu_status,st.fg_lock,st.dt_order";

	public FindMiOrderSTForReFundQry(String code_st, FBoolean bCharge) {
		this.code_st = code_st;
		this.bCharge = bCharge;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(this.code_st);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		if (FBoolean.TRUE.equals(this.bCharge)) {
			// 重收
			sb.append("select  ");
			sb.append(this.selField);
			sb.append(" from mi_order_st_record st ");
			sb.append(" where exists(select orist.id_parent from mi_order_st_record orist where orist.id_orderrecord=st.id_parent and  orist.code_st =?)");
		} else {
			// 退
			sb.append("select  ");
			sb.append(this.selField);
			sb.append(" from mi_order_st_record st");
			sb.append(" where exists(select orist.id_parent from mi_order_st_record orist inner join mi_order_record ord on orist.id_orderrecord=ord.id_orderrecord");
			sb.append(" where orist.eu_direct='-1' and  orist.id_orderrecord=st.id_orderrecord and  orist.code_st =?)");
		}
		return sb.toString();
	}

}
