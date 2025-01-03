package iih.bd.srv.medsrv.refs;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.srv.medsrv.refs.sql.hptype.HptypeDisplay;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.DaoUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 服务参照-临床住院医生站专用
 * @author HUMS
 *
 */
public class IpOrMedsrvRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;
	
	//01:拼音码,10:五笔码,11:五笔码和拼音码,默认使用拼音码
	private String sd_inputmethod = "";
	//0  医保适应症医保限制条件提示信息 ，1 医保适应症 院内限制提示信息 ，2 医保适应症 医保限制+院内限制 信息
	private String sd_hpinfomode = "";
	// 匹配模式，1左匹配，2右匹配，3全匹配	
	private String matchModel = "";
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_srvmm","name_pkg_unit", "des_pri", "name_srvtp",  "des","code" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "idsrvidmm", "id_srv", "name_srv", "sd_srvtp", "Id_mm", "name_mm",  "id_pkg_unit","fg_ctm"};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务项目","发药单位", "参考价","开单类型", "描述", "服务编码" };
	}

	@Override
	public String getPkFieldCode() {
		return "idsrvidmm";
	}

	@Override
	public String getRefCodeField() {
		return "idsrvidmm";
	}

	@Override
	public String getRefNameField() {
		return "name_srvmm";//MedSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return "bdsrvmm";//MedSrvDODesc.TABLE_NAME;
	}
	
	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		String searchText = blurValue.toLowerCase();
		searchText = searchText.replaceAll("[ ]+", "%");
		searchText = searchText == "%" ? "" : blurValue;
		sd_inputmethod = (String) this.getExtendAttributeValue("inputmethod");//01:拼音码,10:五笔码,11:五笔码和拼音码
		if (StringUtils.isNullOrEmpty(sd_inputmethod)) {
			sd_inputmethod = "01";
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(" (");
		sb.append("lower(name_srv) like '%");
		sb.append(blurValue + "%'");

		sb.append(" or ");
		sb.append("lower(code_srv) like '%");
		sb.append(blurValue + "%'");

		sb.append(" or ");
		sb.append("lower(name_mm) like '%");
		sb.append(blurValue + "%'");

		sb.append(" or ");
		sb.append("lower(code_mm) like '%");
		sb.append(blurValue + "%'");

		if ("1".equals(sd_inputmethod.substring(1))) {
			sb.append(" or ");
			sb.append("lower(pycode_srv) like '%");
			sb.append(blurValue + "%'");

			sb.append(" or ");
			sb.append("lower(pycode_mm) like '%");
			sb.append(blurValue + "%'");
		}

		if (sd_inputmethod.startsWith("1")) {
			sb.append(" or ");
			sb.append("lower(wbcode_srv) like '%");
			sb.append(blurValue + "%'");

			sb.append(" or ");
			sb.append("lower(wbcode_mm) like '%");
			sb.append(blurValue + "%'");
		}

		sb.append(") ");

		this.addWherePart(sb.toString());

		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(sb.toString());
		}
	}
	
	@Override
	public RefResultSet filterRefPks(String[] filterPks) {
		String filterPksText = DaoUtil.joinQryArrays((String[]) filterPks);
		StringBuilder buff = new StringBuilder();
		buff.append(" idsrvidmm ");
		if (filterPks.length == 1) {
			buff.append(" = ").append(filterPksText);
		} else {
			buff.append(" in (").append(filterPksText).append(")");
		}
		String wherePart = buff.toString();
		this.addWherePart(wherePart);
		try {
			RefResultSet refResultSet = this.getRefData();
			return refResultSet;
		} finally {
			this.removeWherePart(wherePart);
		}
	}
	
	@Override
	public String getRefSql() {
		String srvtp = (String) this.getExtendAttributeValue("Sd_srvtp");
		String code_entp = (String) this.getExtendAttributeValue("code_entp");
		String id_hp = (String) this.getExtendAttributeValue("id_hp");
		String id_pripat = (String) this.getExtendAttributeValue("id_pripat");
		String id_org = Context.get().getOrgId();
		String id_dept = Context.get().getDeptId();
		
		
		sd_hpinfomode = (String) this.getExtendAttributeValue("hpinfomode");//0  医保适应症医保限制条件提示信息 ，1 医保适应症 院内限制提示信息 ，2 医保适应症 医保限制+院内限制 信息
		if (StringUtils.isNullOrEmpty(sd_hpinfomode)) {
			sd_hpinfomode = "0";
		}
		
		// 暂时根据 就诊类型 有值与否 判断是否为参照过滤查询
		if (StringUtils.isNullOrEmpty(code_entp) ){
			return getBdSrvSql(id_org,id_dept);
		}
		else{
			return getBdSrvMmPgkUnitSql(id_org,id_dept,Context.get().getUserId(),id_hp,id_pripat);
		}
	}

	
	
	/**
	 * 住院服务参照SQL语句
	 * @param id_org
	 * @param code_entp
	 * @param id_hp
	 * @param sd_srvtp
	 * @return
	 */
	public String getBdSrvSql(String id_org,String id_dept) {
		
		StringBuilder formatsql = new StringBuilder("select * from (");
		formatsql.append("select BDSRV.name as name_srvmm,")
		.append(" BDMM.appkgname name_pkg_unit,")
		.append(" BDSRV.Pri as des_pri,")
		.append(" '' as name_srvtp,")
		.append(" (BDSRV.Des||' '||BDMM.Des||', ') as des,")
		.append(" BDSRV.code,")
		.append(" (BDSRV.id_srv||BDMM.id_mm||BDMM.id_ap_unit) as IdSrvIdMm,")
		.append(" BDSRV.Id_srv,")
		.append(" BDSRV.name as name_srv,")
		.append(" BDSRV.Sd_srvtp,")
		.append(" BDMM.id_mm,")
		.append(" BDMM.name as name_mm,")		
		.append(" BDMM.id_ap_unit id_pkg_unit,")
		.append(" BDSRV.fg_ctm ")
		.append(" from bd_srv BDSRV")
		.append(" left join v_bd_mm_ip_pkg BDMM on BDSRV.id_srv=BDMM.id_srv and BDSRV.ds=0 and BDSRV.fg_use_ip = 'Y' ")
		.append(" left join bd_srvoth_wordfreq WORDFREQ on BDSRV.id_srv = WORDFREQ.id_biz and WORDFREQ.biz_classtype = 'medsrv' and WORDFREQ.id_dept='"+id_dept+"'")
		.append(" and WORDFREQ.id_emp ='" + Context.get().getUserId() + "'")
		.append("where (BDSRV.fg_bl = 'N' or ( BDSRV.fg_bl = 'Y' and BDSRV.fg_active_bl='Y')) and BDSRV.Id_Org='" + id_org + "' and BDSRV.Fg_Or='Y' and BDSRV.Fg_Active='Y' ");
		
		formatsql.append(" ) bdsrvmm ");
		
		List<String> whereList = this.getWherePart();
		for (String part : whereList) {
			formatsql.append(" where ").append(part);
			
		}
		
		return formatsql.toString();
	}
	
	/**
	 * 获得Sql数据串（支持药品选择模式） 服务项目、助记码、参考价、描述 。。。。。 原关联bd_srv查询价格 现关联bd_srv_price查询价格
	 * 
	 * @param id_org
	 * @param code_entp
	 * @param id_hp
	 * @param inputstr
	 * @param sd_srvtp
	 * @return
	 */
	public String getBdSrvMmSql(String id_org, String id_dept, String code_entp, String id_hp, 
			String sd_srvtp, String id_pripat,String sd_inputmethod) {		
		return null;
	}
	
	public String getBdSrvMmPgkUnitSql(String id_org, String id_dept,String id_emp_or, String id_hp, String id_pripat) {	
		StringBuilder sbWhere = new StringBuilder(" where 1=1 ");
		List<String> whereList = this.getWherePart();
		for (String part : whereList) {
			sbWhere.append(" and ").append(part);
		}
		String hptypeDisplay = HptypeDisplay.getInstance().getHptyDisplay();
		StringBuilder sql = new StringBuilder("");
		sql.append(" select distinct name_srvmm, name_pkg_unit,des_pri,  ")
		.append(" name_srvtp,  hpsrvtp_name || ' ' || hpsrvtp_des || ' ' || des des, code_srv code ,")
		.append(" idsrvidmm,  id_srv,  name_srv, sd_srvtp, Id_mm, name_mm, id_pkg_unit,  fg_ctm ")
		.append(" from  ( select bdsrvmm.*,udisrvtp.ctrl2 name_srvtp, ")
		.append(" bdsrvmm.name_srv || (case when bdsrvmm.fg_mm = 'Y' and fg_ctm != 'Y' then ('[' || decode(name_srv,name_mm,'',name_mm)|| bdsrvmm.spec || ']')else '' end) name_srvmm, ");
		sql.append(String.format(" (case when hpsrvca.code is null and bdsrvmm.fg_bl = 'Y' then '%s ' when udica.name is null and bdsrvmm.fg_bl = 'Y' then '%s ' else udica.name end) hpsrvtp_name, ",hptypeDisplay,hptypeDisplay));
		sql.append(" (case when bdsrvmm.fg_mm = 'Y' and fg_ctm != 'Y' then  to_char(price, 'fm9999999990.00') else to_char(price_ratio, 'fm9999999990.00') || '' end) des_pri, ")
		.append(" decode(hpsrvca.des,null,'',hpsrvca.des) hpsrvca_des,decode(udica.des,null,'',udica.des)||  CASE  WHEN hpsrvca.rate IS NULL THEN  ''  ELSE '报销比例：'||TO_CHAR(hpsrvca.rate, 'fm9999999990.00')||' ' END hpsrvtp_des, ")
		.append(" decode(hpsrvctr.his_des,null,'',hpsrvctr.his_des) hpsrvctr_des  ")
		.append(" from (select bdsrvmm.* from (select distinct bdsrvmm.id_srv || bdsrvmm.id_mm || id_pkg_unit idsrvidmm, ")
		.append(" bdsrvmm.*, decode(bdsrvfreq.cnt, null, 0, bdsrvfreq.cnt) wf ")
		
		.append(" from ((select bdsrv.id_srv, bdsrv.sd_srvtp, bdsrv.code code_srv, bdsrv.name name_srv, ")
		.append(" fg_ctm, fg_mm, fg_bl,  bdsrv.pycode pycode_srv, bdsrv.wbcode wbcode_srv, decode(bdsrv.des, null, '') des, ")
		.append(" decode(substr(sd_srvtp, 1, 2), '01', substr(sd_srvtp, 1, 4), '14', substr(sd_srvtp, 1, 4), substr(sd_srvtp, 1, 2)) ctm_srvtp, ")
		.append(" '' code_mm, '' id_mm, '' name_mm, '' spec, '' pycode_mm, '' wbcode_mm, '' id_pkg_unit, '' name_pkg_unit,  0 price   from bd_srv bdsrv ")
		.append(" where bdsrv.fg_or = 'Y' and bdsrv.fg_mm != 'Y' and bdsrv.fg_use_ip = 'Y' and bdsrv.fg_active = 'Y' and (bdsrv.fg_bl = 'N' or ( bdsrv.fg_bl = 'Y' and bdsrv.fg_active_bl='Y')) and bdsrv.ds = '0'  and bdsrv.id_org = '"+id_org+"')")
		.append(" union (select bdsrv.id_srv, bdsrv.sd_srvtp, bdmm.code code_srv, bdsrv.name name_srv, ")
		.append(" fg_ctm,  fg_mm, fg_bl, bdsrv.pycode pycode_srv,  bdsrv.wbcode wbcode_srv, ")
		.append(" decode (nvl(drugprop.sd_pois,'0'),'0','',udipois.name||' ')|| ")
		.append(" decode (nvl(drugprop.sd_anti,'0'),'0','',udianti.name||' ')|| ")
		.append(" decode(bdmm.des,  null,  bdsrv.des, bdsrv.des || ' ' || bdmm.des) des, ")
		.append(" decode(substr(sd_srvtp, 1, 2), '01', substr(sd_srvtp, 1, 4), '14', substr(sd_srvtp, 1, 4), substr(sd_srvtp, 1, 2)) ctm_srvtp, ")
		.append(" bdmm.code code_mm,  bdmm.id_mm,  bdmm.name as name_mm,  bdmm.spec,  bdmm.pycode pycode_mm, bdmm.wbcode wbcode_mm, id_ap_unit id_pkg_unit, appkgname name_pkg_unit, bdmm.price_pkg as price ")
		.append(" from bd_srv bdsrv left join v_bd_mm_ip_pkg bdmm  on bdsrv.id_srv = bdmm.id_srv ")
		.append(" left join bd_srv_drug drugprop on drugprop.id_srv = bdsrv.id_srv ")
		.append(" left join bd_udidoc udipois on udipois.id_udidoc = drugprop.id_pois ")
		.append(" left join bd_udidoc udianti on udianti.id_udidoc = drugprop.id_anti ")
		.append(" where bdsrv.fg_or = 'Y'  and bdsrv.fg_mm = 'Y'  and bdsrv.fg_use_ip = 'Y' and bdsrv.fg_active = 'Y' and bdsrv.ds = '0'  and bdsrv.id_org = '"+id_org+"' and bdmm.fg_use_ip = 'Y' and bdmm.fg_active='Y' and (bdmm.fg_out is null or bdmm.fg_out ='N')) ) bdsrvmm ")
		.append(" left join bd_srvoth_wordfreq bdsrvfreq on bdsrvmm.id_srv = bdsrvfreq.id_biz and bdsrvfreq.biz_classtype = 'medsrv'  and bdsrvfreq.id_dept = '"+id_dept+"' and bdsrvfreq.id_emp = '"+id_emp_or+"' ");

		if(sbWhere.length() > 0){
			sql.append(sbWhere.toString());
		}
		
		sql.append(" order by length(pycode_srv) asc, wf desc) bdsrvmm  where rownum <= 100) bdsrvmm ")

		.append(" left join view_price_rp blprice on bdsrvmm.ID_SRV = blprice.id_srv ")
		.append(" and blprice.ID_PRIPAT = '"+id_pripat+"' ")
		.append(" left join bd_hp_srvorca hpsrvca  on bdsrvmm.id_srv = hpsrvca.id_srv  and hpsrvca.id_hp = '"+id_hp+"' ")
		.append(" left join bd_hp_srvctr hpsrvctr  on bdsrvmm.id_srv = hpsrvctr.id_srv and hpsrvctr.eu_hpsrvtp = hpsrvca.eu_hpsrvtp ")
		.append(" left join bd_udidoc udica  on udica.code = hpsrvca.sd_hpsrvtp and udica.ACTIVESTATE='2' and  udica.id_udidoclist = '@@@@ZZ2000000000003P' ")
		.append(" left join bd_udidoc udisrvtp  on udisrvtp.code = ctm_srvtp ")
		
		.append(" and udisrvtp.id_udidoclist = '@@@@ZZ2000000000000T'")
		.append(" )bdsrvmm  order by length(bdsrvmm.name_srv) asc, bdsrvmm.name_srvmm asc ");
		
		
		return sql.toString();
	}
	
}
