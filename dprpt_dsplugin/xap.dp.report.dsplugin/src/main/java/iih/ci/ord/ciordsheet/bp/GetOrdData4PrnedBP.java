package iih.ci.ord.ciordsheet.bp;

import iih.ci.ord.ciordsheet.CiOrdSheetParamDTO;
import iih.ci.ord.ciordsheet.CiOrdSheetQryService;

/**
 * 查询就诊打印过的医嘱单数据（重整标记行需要单独处理）
 * @author Young
 *
 */
public class GetOrdData4PrnedBP extends GetOrdSheetDataBaseBP {

	/**
	 * 获取查询的sql语句
	 * @return
	 */
	protected String getQuerySql(CiOrdSheetParamDTO paramDTO, String pageNums) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from (");
		buffer.append(this.getStrFields(paramDTO));
		buffer.append(" from (");
		buffer.append(this.getStrFieldsOrSrvMM());
		buffer.append(this.getFromSqlOrSrvMM());
		buffer.append(this.getWhereSqlOrSrvMM(paramDTO, pageNums));
		buffer.append(") ORSRVMM");
		buffer.append(this.getFromSql());
		buffer.append(" union ");
		buffer.append(this.getStrFieldsReformrow());
		buffer.append(this.getFromSqlReformrow());
		buffer.append(this.getWhereSqlReformrow(paramDTO, pageNums));
		buffer.append(")");
		buffer.append(this.getOrderBySql());

		return buffer.toString();
	}
	
	/**
	 * 查询sql语句字段
	 * @return
	 */
	@Override
	protected String getStrFields(CiOrdSheetParamDTO paramDTO) {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getStrFields(paramDTO))
		.append(",ORSRVMM.id_orprn,ORSRVMM.name_orprn,ORSRVMM.page_num,ORSRVMM.row_num,ORSRVMM.fg_canc_prn,ORSRVMM.fg_stop_prn,ORSRVMM.fg_skin_prn");
		return sb.toString();
	}
	
	/**
	 * 查询sql语句字段
	 * @return
	 */
	@Override
	protected String getStrFieldsOrSrvMM() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getStrFieldsOrSrvMM())
		.append(",ORPRN.id_orprn,ORPRN.name_orprn,ORPRN.page_num,ORPRN.row_num,ORPRN.fg_canc_prn,ORPRN.fg_stop_prn,ORPRN.fg_skin_prn");
		return sb.toString();
	}
	
	/**
	 * 查询重整标记行sql语句字段
	 * @return
	 */
	protected String getStrFieldsReformrow() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ORG.name name_org,ENIP.code_amr_ip,ENIP.name_bed,EN.name_pat name_pat_en,'' sex_pat,'' age,'' fg_ip,")
		.append("'' fg_newborn,'' dt_acpt,DEPPHY.name name_dep_phy,DEPNUR.name name_dep_nur,'' id_emp_sign,'' name_emp_sign,'' id_emp_chk,'' name_emp_chk,'' name_emp_exe,")
		//新增字段位置
		.append("'' name_dep_exe,'' dt_sign,'' dt_mp,'' id_emp_stop,'' name_emp_stop,'' id_emp_chk_stop,'' name_emp_chk_stop,'' name_emp_canc,'' dt_canc,'' rst_skintest,'' fg_skintest,'' skintestrst,")
		.append("'' fg_urgent,'N' fg_pip,'' id_en,'reformrow_key' id_orsrv_key,'' id_or,'' content_or,'reformrow_key' code_or,'' sd_srvtp,'' dt_effe,'' dt_end,")
		.append("'' fg_chk,'' fg_chk_stop,'' fg_chk_canc,'' des_or,0 orders,")
		.append("'' fg_long,'' fg_set,'' fg_self,'' fg_selfsrv,")
		.append("'" + CiOrdSheetQryService.Str_reformrow + "' name_srv,0.0 quan_medu,null sortno,1 sortno_srv,")
		.append("'' name_mm,'' name_prn,'' spec,'' medu_name,'' route_name,'' routedes_name,'' freq_name,")
		.append("'Y' fg_reformrow,null Fg_pres_outp,null Fg_wholepack,null quan_cur,'' Name_unit_sale,ORPRN.id_orprn,ORPRN.name_orprn,ORPRN.page_num,ORPRN.row_num,'' fg_canc_prn,'' fg_stop_prn,'' fg_skin_prn");
		
		return sb.toString();
	}
	
	/**
	 * 查询重整标记行from语句字段
	 * @return
	 */
	protected String getFromSqlReformrow() {
		StringBuilder sb = new StringBuilder();
		sb.append(" from ci_or_prn ORPRN ")
		.append(" left join en_ent EN on ORPRN.id_en=EN.id_ent")
		.append(" left join en_ent_ip ENIP on ORPRN.id_en=ENIP.id_ent")
		.append(" left join bd_org ORG on EN.id_org=ORG.id_org")
		.append(" left join bd_dep DEPPHY on EN.id_dep_phy=DEPPHY.id_dep")
		.append(" left join bd_dep DEPNUR on EN.id_dep_nur=DEPNUR.id_dep");
		return sb.toString();
	}
	
	/**
	 * 查询重整标记行where语句字段
	 * @return
	 */
	protected String getWhereSqlReformrow(CiOrdSheetParamDTO paramDTO, String pageNums) {
		return " where ORPRN.ds<1 and ORPRN.fg_reformrow='Y'";
	}
	
	/**
	 * 获取排序sql
	 * @return
	 */
	@Override
	protected String getOrderBySql() {
		return " order by page_num,row_num";
	}
}
