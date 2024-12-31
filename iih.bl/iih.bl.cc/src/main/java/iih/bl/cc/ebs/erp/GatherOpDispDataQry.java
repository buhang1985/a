package iih.bl.cc.ebs.erp;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊药品查询类
 * @author ly
 *
 */
public class GatherOpDispDataQry implements ITransQry{
	private String selectDate = null;
	
	public GatherOpDispDataQry() {
		this.selectDate=ErpSqlCondHelper.getCurrentDateBefore();
	}
	
	public GatherOpDispDataQry(String sDate) {
		this.selectDate = sDate;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer sql) {
		
//		SqlParam param = new SqlParam();
//		sql.append(" and oep.dt_cg >= ? ");//开始
//		sql.append(" and oep.dt_cg <= ? ");//结束
//		
//		if (selectDate == null) {
//			param.addParam(ErpSqlCondHelper.getLastDateBegin());
//			param.addParam(ErpSqlCondHelper.getLastDateEnd());
//		}
//		else {
//			param.addParam(selectDate + " 00:00:00");
//			param.addParam(selectDate + " 23:59:59");
//		}
//		
//		sql.append(this.getOrderBySql());
//		
//		return param;
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		//对查询数据分组求和 by lim
		sqlSb.append("select  0 as iface_batch_id,");
		sqlSb.append("  0 as line_num,");
		sqlSb.append(" '100' as hospital_code,");
		sqlSb.append(" 'OP' as op_ip_flag,");
		sqlSb.append(" substr(tbl.charge_date,1,10)||' 00:00:00' as charge_date,");
		sqlSb.append(" tbl.item_number,");
		sqlSb.append(" tbl.item_desc,");
		sqlSb.append(" tbl.charge_dept_name,");
		sqlSb.append(" tbl.charge_dept,");
		sqlSb.append(" tbl.execute_dept_code,");
		sqlSb.append(" tbl.execute_dept_name,");	
		sqlSb.append(" '' as ward_sn,");	
		sqlSb.append(" '' as ward_sn_name,");	
		sqlSb.append("  tbl.group_no,");	
		sqlSb.append("   tbl.group_name,");	
		sqlSb.append("   sum(tbl.deliver_qty) as deliver_qty,");	
		sqlSb.append("  tbl.deliver_uom_code,");	
		sqlSb.append("  tbl.retail_price,");	
		sqlSb.append("   null as sync_date,");
		sqlSb.append("   null as process_flag,");
		sqlSb.append("   null as process_date,");
		sqlSb.append("   tbl.window_no");
		sqlSb.append(" from");
		sqlSb.append("(");
		//非预交金结算
		sqlSb.append("select 0 as iface_batch_id,");//子自增列
		sqlSb.append(" 0 as line_num,");//行号
		sqlSb.append(" '100' as  hospital_code,");//医院编码
		sqlSb.append(" 'OP' as op_ip_flag,");//门诊住院标志
		sqlSb.append(" oep.dt_cg as charge_date,");//计费日期
		sqlSb.append(" itm.code_mm as item_number,");//费用编码(药品编码)
		sqlSb.append(" itm.name_mm as item_desc,");//药品名称
		sqlSb.append(" ordep.name as charge_dept_name,");//开单科室名称
		sqlSb.append(" ordep.code as charge_dept,");//开单科室编码
		sqlSb.append(" mpdep.code as execute_dept_code,");//执行科室编码
		//by lim ebs中execute_dept_name存了编码字段 2017-10-23
		sqlSb.append(" mpdep.code as execute_dept_name,");//执行科室编码
		sqlSb.append(" '' as ward_sn,");//病区编码
		sqlSb.append(" '' as ward_sn_name,");//病区名称
		sqlSb.append(" wh.code as group_no,");//药房编码 ->仓库编码
		sqlSb.append(" wh.name as group_name,");//药房名称 ->仓库名称
		sqlSb.append(" itm.quan * oep.eu_direct as deliver_qty,");//数量
		sqlSb.append(" measdoc.code as deliver_uom_code,");//单位
		sqlSb.append(" itm.price as retail_price,");//单价
		sqlSb.append(" null as sync_date,");//上传日期 
		sqlSb.append(" null as process_flag,");//接收标志
		sqlSb.append(" null as process_date,");//接收日期
		sqlSb.append("  win.id_quesite_pl as window_no");
		
		sqlSb.append(" from bl_cg_itm_oep itm ");
		sqlSb.append(" inner join bl_cg_oep oep");
		sqlSb.append(" on itm.id_cgoep = oep.id_cgoep");
		sqlSb.append(" inner join BL_ST_OEP st on st.id_stoep=itm.id_stoep");
		sqlSb.append(" left join bd_org org");
		sqlSb.append(" on itm.id_org = org.id_org");
		sqlSb.append(" left join bd_dep ordep");
		sqlSb.append(" on itm.id_dep_or = ordep.id_dep");
		sqlSb.append(" left join bd_dep mpdep");
		sqlSb.append(" on itm.id_dep_mp = mpdep.id_dep");
		sqlSb.append(" left join bd_dep whdep");
		sqlSb.append(" on itm.id_dep_wh = whdep.id_dep");
		sqlSb.append(" left join bd_wh wh");
		sqlSb.append(" on whdep.id_dep = wh.id_dep_belong");
		sqlSb.append(" left join bd_measdoc measdoc ");
		sqlSb.append(" on itm.pgku_cur = measdoc.id_measdoc");
		sqlSb.append(" left join  mp_dg_win win ");
		sqlSb.append(" on win.id_pres=itm.id_pres ");
		sqlSb.append(" where substr(itm.sd_srvtp,0,2) = '01' and fg_acc='N'");//药品数据
		sqlSb.append(" and st.dt_st >= '"+selectDate + " 00:00:00'");//日结日期开始
		sqlSb.append(" and st.dt_st <= '" +selectDate + " 23:59:59'");//日结日期结束
	//	sqlSb.append(" and oep.dt_cg >= '"+selectDate + " 00:00:00'");//结算日期开始
	//	sqlSb.append(" and oep.dt_cg <= '" +selectDate + " 23:59:59'");//结算日期结束
		//预交金记账
		sqlSb.append(" union all ");
		
		sqlSb.append(" select 0 as iface_batch_id,");//子自增列
		sqlSb.append(" 0 as line_num,");//行号
		sqlSb.append(" '100' as  hospital_code,");//医院编码
		sqlSb.append(" 'OP' as op_ip_flag,");//门诊住院标志
		sqlSb.append(" oep.dt_cg as charge_date,");//计费日期
		sqlSb.append(" itm.code_mm as item_number,");//费用编码(药品编码)
		sqlSb.append(" itm.name_mm as item_desc,");//药品名称
		sqlSb.append(" ordep.name as charge_dept_name,");//开单科室名称
		sqlSb.append(" ordep.code as charge_dept,");//开单科室编码
		sqlSb.append(" mpdep.code as execute_dept_code,");//执行科室编码
		//by lim ebs中execute_dept_name存了编码字段 2017-10-23
		sqlSb.append(" mpdep.code as execute_dept_name,");//执行科室编码
		sqlSb.append(" '' as ward_sn,");//病区编码
		sqlSb.append(" '' as ward_sn_name,");//病区名称
		sqlSb.append(" wh.code as group_no,");//药房编码 ->仓库编码
		sqlSb.append(" wh.name as group_name,");//药房名称 ->仓库名称
		sqlSb.append(" itm.quan * oep.eu_direct as deliver_qty,");//数量
		sqlSb.append(" measdoc.code as deliver_uom_code,");//单位
		sqlSb.append(" itm.price as retail_price,");//单价
		sqlSb.append(" null as sync_date,");//上传日期 
		sqlSb.append(" null as process_flag,");//接收标志
		sqlSb.append(" null as process_date,");//接收日期
		sqlSb.append("  win.id_quesite_pl as window_no");
		
		sqlSb.append(" from bl_cg_itm_oep itm ");
		sqlSb.append(" inner join bl_cg_oep oep");
		sqlSb.append(" on itm.id_cgoep = oep.id_cgoep");
		sqlSb.append(" left join bd_org org");
		sqlSb.append(" on itm.id_org = org.id_org");
		sqlSb.append(" left join bd_dep ordep");
		sqlSb.append(" on itm.id_dep_or = ordep.id_dep");
		sqlSb.append(" left join bd_dep mpdep");
		sqlSb.append(" on itm.id_dep_mp = mpdep.id_dep");
		sqlSb.append(" left join bd_dep whdep");
		sqlSb.append(" on itm.id_dep_wh = whdep.id_dep");
		sqlSb.append(" left join bd_wh wh");
		sqlSb.append(" on whdep.id_dep = wh.id_dep_belong");
		sqlSb.append(" left join bd_measdoc measdoc ");
		sqlSb.append(" on itm.pgku_cur = measdoc.id_measdoc");
		sqlSb.append(" left join  mp_dg_win win ");
		sqlSb.append(" on win.id_pres=itm.id_pres ");
		sqlSb.append(" where substr(itm.sd_srvtp,0,2) = '01' and fg_acc='Y'");//药品数据
		sqlSb.append(" and oep.dt_cg>= '"+selectDate + " 00:00:00'");//开始
		sqlSb.append(" and oep.dt_cg <= '" +selectDate + " 23:59:59'");//结束	
		
		//分组求和
		sqlSb.append("   ) tbl ");
		sqlSb.append(" group by  substr(tbl.charge_date,1,10)||' 00:00:00',");
		sqlSb.append("tbl.item_number,");
		sqlSb.append("tbl.item_desc,");
		sqlSb.append("tbl.charge_dept_name,");
		sqlSb.append("tbl.charge_dept,");
		sqlSb.append("tbl.execute_dept_code,");
		sqlSb.append("tbl.execute_dept_name,");
		sqlSb.append("tbl.group_no,");
		sqlSb.append("tbl.group_name,");             
		sqlSb.append("tbl.deliver_uom_code,");
		sqlSb.append("tbl.retail_price,");
		sqlSb.append("tbl.window_no");
		return sqlSb.toString();
	}
	
	/**
	 * 取得排序sqls
	 * @return
	 */
	private String getOrderBySql(){
		 //by lim 由于分组求和，先注释掉排序
		//return " order by oep.dt_cg,itm.id_pres,itm.code_srv ";
		return "";
	}
}
