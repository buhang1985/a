package iih.ci.preop.order.bp;

import java.util.List;

import iih.ci.preop.order.d.OrderListViewDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import xap.mw.core.data.BizException;

/**
 * 预住院申请单数据加载逻辑处理
 * 
 * @author wangqingzhu
 *
 */
public class OrderLoadBP {
public List<OrderListViewDTO> exec( String id_en, String code_entp) throws BizException{
		
		List<OrderListViewDTO> list = new SqlParamBuilder()
				.select("ts.code_or,ts.sd_srvtp,ts.name_or content_or,ts.id_emp_create as id_emp_or,ts.dt_effe,srvtpdoc.name as name_srvtp,psn.name as name_emp_or")
				.from("ci_ts_or ts")
				.leftJoin("bd_udidoc srvtpdoc").on("srvtpdoc.id_udidoclist='@@@@ZZ2000000000000T' and ts.sd_srvtp = srvtpdoc.code")
				.leftJoin("bd_psndoc psn").on("psn.id_psndoc = ts.id_emp_create")
				.where("ts.fg_canc='N'").and("ts.id_en", id_en).Q(OrderListViewDTO.class);
		return list;
	}

}
