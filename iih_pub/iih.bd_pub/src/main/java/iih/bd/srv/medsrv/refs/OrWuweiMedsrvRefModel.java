package iih.bd.srv.medsrv.refs;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.srv.medsrv.refs.sql.op.DrugCheckDisplayMd4OP;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.DaoUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class OrWuweiMedsrvRefModel extends RefGridModel {
	private String paramCode="WW_CIOR0004";
	private static final long serialVersionUID = 1L;

	// 01:拼音码,10:五笔码,11:五笔码和拼音码,默认使用拼音码
	private String sd_inputmethod = "";
	// 0 医保适应症医保限制条件提示信息 ，1 医保适应症 院内限制提示信息 ，2 医保适应症 医保限制+院内限制 信息
	private String sd_hpinfomode = "";
	// 匹配模式，1左匹配，2右匹配，3全匹配
	private String matchModel = "";
	//
	private String eu_srvtp = "";

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_srvmm", "des_pri", "srvtp", "name_srvtp","name_unit_sale","pakbasefactor", "des", "code" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "idsrvidmm", "id_srv", "name_srv", "sd_srvtp", "id_mm", "name_mm", "fg_ctm","id_unit_sale" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务项目", "参考价","服务分类", "开单类型","发药单位","换算系数","描述", "服务编码" };
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
		return "name_srvmm";// MedSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return "bdsrvmm";// MedSrvDODesc.TABLE_NAME;
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		blurValue = blurValue.toLowerCase();
		blurValue = blurValue.replaceAll("[ ]+", "%");
		blurValue = blurValue == "%" ? "" : blurValue;
		// 处理特殊标记解析为 类型
		eu_srvtp = "";
		if (blurValue != null && blurValue.length() > 0) {
			if (blurValue.startsWith(",") || blurValue.startsWith("，")) {
				eu_srvtp = "01";
				blurValue = blurValue.substring(1);
			} else if (blurValue.startsWith(".") || blurValue.startsWith("。")) {
				eu_srvtp = "99";
				blurValue = blurValue.substring(1);
			}

		} else {
			eu_srvtp = "";
		}
		sd_inputmethod = (String) this.getExtendAttributeValue("inputmethod");// 01:拼音码,10:五笔码,11:五笔码和拼音码
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
		
		sb.append(" or ");
		sb.append("lower(wbcode_srv) like '%");
		sb.append(blurValue + "%'");
		
		sb.append(" or ");
		sb.append("lower(mnecode_srv) like '%");
		sb.append(blurValue + "%'");
		
		sb.append(" or ");
		sb.append("lower(shortname_srv) like '%");
		sb.append(blurValue + "%'");
		
		sb.append(" or ");
		sb.append("lower(als_name) like '%");
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

		sd_hpinfomode = (String) this.getExtendAttributeValue("hpinfomode");// 0 医保适应症医保限制条件提示信息 ，1 医保适应症 院内限制提示信息 ，2
																			// 医保适应症 医保限制+院内限制 信息
		if (StringUtils.isNullOrEmpty(sd_hpinfomode)) {
			sd_hpinfomode = "0";
		}

		// 暂时根据 就诊类型 有值与否 判断是否为参照过滤查询
		if (StringUtils.isNullOrEmpty(code_entp)) {
			return getBdSrvSql(id_org, id_dept);
		} else {
			return getWuweiBdSrvMmPgkUnitSql(id_org, id_dept, Context.get().getUserId(), id_hp, id_pripat);
		}
	}

	/**
	 * 住院服务参照SQL语句
	 * 
	 * @param id_org
	 * @param code_entp
	 * @param id_hp
	 * @param sd_srvtp
	 * @return
	 */
	public String getBdSrvSql(String id_org, String id_dept) {
		if("11".equals(DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP())){
			StringBuilder formatsql = new StringBuilder("select * from (");
			formatsql.append("select BDSRV.name as name_srvmm,")
					// .append(" BDMM.appkgname name_pkg_unit,")
					.append(" BDSRV.Pri as des_pri, '' srvtp,")
					.append(" '' as name_srvtp,'' as name_unit_sale,'' as pakbasefactor,")
					.append(" (BDSRV.Des||' '||BDMM.Des||', ') as des,")
					.append(" BDSRV.code,")
					.append(" (BDSRV.id_srv||BDMM.id_mm||id_unit_pkg) as IdSrvIdMm,")
					.append(" BDSRV.Id_srv,")
					.append(" BDSRV.name as name_srv,")
					.append(" BDSRV.Sd_srvtp,")
					.append(" BDMM.id_mm,")
					.append(" BDMM.name as name_mm,")
					// .append(" BDMM.id_ap_unit id_pkg_unit,")
					.append(" BDSRV.fg_ctm,'' as id_unit_sale ")
					.append(" from bd_srv BDSRV")
					.append(" left join bd_mm BDMM on BDSRV.id_srv=BDMM.id_srv and BDSRV.ds=0 and BDSRV.fg_use_op = 'Y' ");
					formatsql.append(" left join ");
					formatsql.append(" ( ");
					formatsql.append(" SELECT id_mm,factor,id_unit_pkg,MAX(sd_mmpkgupro) sd_mmpkgupro");
					formatsql.append("		FROM bd_mm_pkgu");
					formatsql.append("		WHERE EN_OPPKGTP     IS NOT NULL");
					formatsql.append("		GROUP BY id_mm,");
					formatsql.append("		factor,");
					formatsql.append("		id_unit_pkg");
					formatsql.append(" ) MM_OP_PKG on MM_OP_PKG.id_mm = BDMM.id_mm");
					formatsql.append(" left join bd_measdoc unitsale on unitsale.id_measdoc = MM_OP_PKG.id_unit_pkg ");
					formatsql.append(" left join bd_srvoth_wordfreq WORDFREQ on BDSRV.id_srv = WORDFREQ.id_biz and WORDFREQ.biz_classtype = 'medsrv' and WORDFREQ.id_dept='"
							+ id_dept + "'")
					.append(" and WORDFREQ.id_emp ='" + Context.get().getUserId() + "'")
					.append("where BDSRV.Id_Org='" + id_org + "' and BDSRV.Fg_Or='Y' and BDSRV.Fg_Active='Y' ");

			formatsql.append(" ) bdsrvmm ");

			List<String> whereList = this.getWherePart();
			for (String part : whereList) {
				formatsql.append(" where ").append(part);

			}

			return formatsql.toString();
			
		}else{
			StringBuilder formatsql = new StringBuilder("select * from (");
			formatsql.append("select BDSRV.name as name_srvmm,")
					// .append(" BDMM.appkgname name_pkg_unit,")
					.append(" BDSRV.Pri as des_pri, '' srvtp,").append(" '' as name_srvtp,'' as name_unit_sale,'' as pakbasefactor,")
					.append(" (BDSRV.Des||' '||BDMM.Des||', ') as des,").append(" BDSRV.code,")
					.append(" (BDSRV.id_srv||BDMM.id_mm) as IdSrvIdMm,").append(" BDSRV.Id_srv,")
					.append(" BDSRV.name as name_srv,").append(" BDSRV.Sd_srvtp,").append(" BDMM.id_mm,")
					.append(" BDMM.name as name_mm,")
					// .append(" BDMM.id_ap_unit id_pkg_unit,")
					.append(" BDSRV.fg_ctm,'' as id_unit_sale ").append(" from bd_srv BDSRV")
					.append(" left join bd_mm BDMM on BDSRV.id_srv=BDMM.id_srv and BDSRV.ds=0 and BDSRV.fg_use_op = 'Y' ")
					.append(" left join bd_srvoth_wordfreq WORDFREQ on BDSRV.id_srv = WORDFREQ.id_biz and WORDFREQ.biz_classtype = 'medsrv' and WORDFREQ.id_dept='"
							+ id_dept + "'")
					.append(" and WORDFREQ.id_emp ='" + Context.get().getUserId() + "'")
					.append("where BDSRV.Id_Org='" + id_org + "' and BDSRV.Fg_Or='Y' and BDSRV.Fg_Active='Y' ");

			formatsql.append(" ) bdsrvmm ");

			List<String> whereList = this.getWherePart();
			for (String part : whereList) {
				formatsql.append(" where ").append(part);

			}

			return formatsql.toString();
		}
		
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
	public String getBdSrvMmSql(String id_org, String id_dept, String code_entp, String id_hp, String sd_srvtp,
			String id_pripat, String sd_inputmethod) {
		return null;
	}

	public String getBdSrvMmPgkUnitSql(String id_org, String id_dept, String id_emp_or, String id_hp,
			String id_pripat) {
		StringBuilder sbWhere = new StringBuilder(" where 1=1 ");
		List<String> whereList = this.getWherePart();
		for (String part : whereList) {
			sbWhere.append(" and ").append(part);
		}
		StringBuilder sql = new StringBuilder("");
		sql.append(" select distinct name_srvmm, des_pri,'【'||tree1||'】' as srvtp,  ")
		.append(" name_srvtp, name_unit_sale,pakbasefactor, hpsrvtp_name || ' ' || hpsrvtp_des || ' ' || des des, code_srv code ,")
		.append(" idsrvidmm||id_unit_sale idsrvidmm,  id_srv,  name_srv, sd_srvtp, Id_mm, name_mm,  fg_ctm,id_unit_sale ")
		.append(" from  ")
		.append(" ( ")
		.append("	select bdsrvmm.*, srvca.fullName as tree1,udisrvtp.ctrl2 name_srvtp, ")
		.append(" 	bdsrvmm.name_srv || (case when bdsrvmm.fg_mm = 'Y' and bdsrvmm.fg_ctm != 'Y' then ('[' || decode(name_srv,name_mm,'',name_mm)|| bdsrvmm.spec || ']')else '' end) name_srvmm, ")
		.append(" 	(case when udica.name is null and bdsrvmm.fg_bl = 'Y' then '丙类' else udica.name end) hpsrvtp_name, ")
		.append(" 	(case when bdsrvmm.fg_mm = 'Y' and bdsrvmm.fg_ctm != 'Y' then  to_char(price, 'fm9999999990.00') else to_char(price_ratio, 'fm9999999990.00') || '' end) des_pri, ")
		.append(" 	decode(hpsrvca.des,null,'',hpsrvca.des) hpsrvca_des,decode(udica.des,null,'',udica.des) hpsrvtp_des, ")
		.append(" 	decode(hpsrvctr.his_des,null,'',hpsrvctr.his_des) hpsrvctr_des  ");
		if("11".equals(DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP())){
			sql.append(",unitsale.name name_unit_sale,MM_OP_PKG.factor||bdsrvmm.name_unit_pkgbase as pakbasefactor,MM_OP_PKG.id_unit_pkg as id_unit_sale ");
		}else{
			sql.append(",'' name_unit_sale,'' as pakbasefactor,'' as id_unit_sale ");
		}
		sql.append(" 	from ")
		.append(" 	(")
		.append(" 		select bdsrvmm.* ")
		.append("  		from ")
		.append("		(")
		.append("			select distinct ")
		.append(" 			bdsrvmm.*, decode(bdsrvfreq.cnt, null, 0, bdsrvfreq.cnt) wf ")
		.append(" 			from ")
		.append("			(")
		.append(" 				(select bdsrv.id_srv, bdsrv.sd_srvtp, bdsrv.code code_srv, bdsrv.name name_srv, ")
		.append(" 				fg_ctm, fg_mm, fg_bl,  bdsrv.pycode pycode_srv, bdsrv.wbcode wbcode_srv,bdsrv.mnecode as mnecode_srv,bdsrv.shortname as shortname_srv,decode(bdsrv.des, null, '') des, ")
		.append(" 				decode(substr(sd_srvtp, 1, 2), '01', substr(sd_srvtp, 1, 4), '14', substr(sd_srvtp, 1, 4), substr(sd_srvtp, 1, 2)) ctm_srvtp, ")
		.append(" 				'' code_mm, '' id_mm, '' name_mm, '' spec, '' pycode_mm, '' wbcode_mm,  0 price , '' id_srvdrug, '' id_dosage,")
		.append("				 '' als_name,'' sd_herbpreparationtp,id_srvca,bdsrv.id_srv idsrvidmm,'' as name_unit_pkgbase ")
		.append(" 				from bd_srv bdsrv ")
		.append(" 				where bdsrv.fg_or = 'Y' and bdsrv.fg_mm != 'Y' and bdsrv.fg_use_op = 'Y' and bdsrv.fg_active = 'Y' and bdsrv.ds = '0' and bdsrv.quan_med is not null and bdsrv.id_org = '"+id_org + "' and Sd_srvtp != '1203'")
		.append(" 				)")
				
		.append("			union ")
	
		.append(" 				(select bdsrvmm.id_srv, bdsrvmm.sd_srvtp, bdsrvmm.code_srv, bdsrvmm.name_srv, bdsrvmm.fg_ctm,bdsrvmm.fg_mm,bdsrvmm.fg_bl, bdsrvmm.pycode_srv, bdsrvmm.wbcode_srv,bdsrvmm.mnecode_srv,bdsrvmm.shortname_srv,")
		.append(" 				decode (nvl(drugprop.sd_pois,'0'),'0','',udipois.name||' ')|| ")
		.append(" 				decode (nvl(drugprop.sd_anti,'0'),'0','',udianti.name||' ')|| ")
		.append(" 				decode(des_mm,  null,  des_srv, des_srv || ' ' || des_mm) des, ")
		.append(" 				decode(substr(sd_srvtp, 1, 2), '01', substr(sd_srvtp, 1, 4), '14', substr(sd_srvtp, 1, 4), substr(sd_srvtp, 1, 2)) ctm_srvtp, ")
		.append(" 				code_mm,bdsrvmm.id_mm,name_mm, spec, pycode_mm, wbcode_mm,  price, drugprop.id_srvdrug, drugprop.id_dosage, ")
		.append(" 				als_name,sd_herbpreparationtp,id_srvca,bdsrvmm.id_srv||bdsrvmm.id_mm idsrvidmm,name_unit_pkgbase ")
		.append(" 				from ")
		.append("				(select bdsrv.id_srv, bdsrv.sd_srvtp,bdsrv.name name_srv,bdsrv.code code_srv,bdsrv.pycode pycode_srv,bdsrv.mnecode as mnecode_srv,bdsrv.shortname as shortname_srv,")
		.append(" 					bdsrv.wbcode wbcode_srv, bdsrv.fg_bl, ")
		.append(" 					bdsrv.des des_srv, bdsrv.fg_mm,bdsrv.fg_ctm,")
		.append(" 					bdmm.code code_mm,bdmm.id_mm,bdmm.name as name_mm,bdmm.spec,bdmm.pycode pycode_mm,")
		.append(" 					bdmm.wbcode wbcode_mm,bdmm.price,bdmm.des||decode(bdmm.sup_name,null,'','【'||bdmm.sup_name||'】'||'('||bdmm.abrad||')') des_mm,bdmm.fg_out,bdmm.sd_herbpreparationtp,id_srvca, ")
		.append("                   name_unit_pkgbase")
		.append(" 					from bd_srv bdsrv ")
		.append(" 					inner join ")
		.append(" 					(")
		.append("						select nvl(mmbl.quan_usable,0)quan_usable, bdmm.* ,b.name as abrad from bd_mm bdmm ")
		.append(" 						inner join ")
		.append("						(")
		.append("							select id_mm, sum(quan_usable) quan_usable ")
		.append(" 							from (")
		.append(" 								select bl.id_mm, quan_usable FROM mm_bl bl inner join (select id_wh from bd_wh where fg_use_op='Y' or fg_use_er='Y') wh ")
		.append(" 								on bl.id_wh=wh.id_wh inner join BD_MM_WH mmwh ON bl.id_wh = mmwh.id_wh AND mmwh.id_mm = bl.id_mm")
		.append(" 								WHERE MMWH.FG_ACTIVE = 'Y' AND mmwh.fg_out  = 'N' and bl.quan_usable > 0 ")
		.append("							) group by id_mm ")
		.append("						) mmbl on mmbl.id_mm = bdmm.id_mm   ")
		.append("						left join bd_udidoc b on b.id_udidoc = bdmm.id_abrd  where bdmm.fg_active = 'Y' and bdmm.ds = 0 and bdmm.fg_out = 'N'")
		.append("					)bdmm on bdsrv.id_srv = bdmm.id_srv ")
		.append(" 						where bdsrv.fg_or = 'Y' and bdsrv.fg_mm = 'Y' and bdsrv.fg_use_op = 'Y' and bdsrv.fg_active = 'Y' and bdsrv.ds = '0' and bdsrv.id_org = '"+ id_org + "' and Sd_srvtp != '1203'")
		.append(" 				) bdsrvmm ")
		.append(" 				left join bd_srv_drug drugprop on drugprop.id_srv = bdsrvmm.id_srv ")
		.append(" 				left join bd_udidoc udipois on udipois.id_udidoc = drugprop.id_pois ")
		.append(" 				left join bd_udidoc udianti on udianti.id_udidoc = drugprop.id_anti ")
		.append(" 				left join ")
		.append("  				(")
		.append(" 					select id_mm,to_char(wm_concat(name)) als_name from BD_MM_NAME where ds=0 group by id_mm")
		.append("				) bd_mm_als ")
		.append("  				on bd_mm_als.id_mm=bdsrvmm.id_mm ")
		.append(" 			)")
		.append(" 		) bdsrvmm ")
		.append(" left join bd_srvoth_wordfreq bdsrvfreq on bdsrvmm.id_srv = bdsrvfreq.id_biz and bdsrvfreq.biz_classtype = 'medsrv'  and bdsrvfreq.id_dept = '"+ id_dept + "' and bdsrvfreq.id_emp = '" + id_emp_or + "' ");
		if (sbWhere.length() > 0) {
			sql.append(sbWhere.toString());
		}
		// 99 表示非物品服务项目；01 表示药品服务项目
		sql.append(eu_srvtp.equals("99") ? " and sd_srvtp not like '01%'"
				: (eu_srvtp.equals("01") ? " and sd_srvtp like '01%' " : ""));

	sql.append(" order by length(pycode_srv) asc, wf desc");
	sql.append("	) bdsrvmm  where rownum <= 100");
		sql.append(") bdsrvmm ")

			.append(" left join view_price_rp blprice on bdsrvmm.ID_SRV = blprice.id_srv ")
			.append(" and blprice.ID_PRIPAT = '" + id_pripat + "' ")
			.append(" LEFT OUTER JOIN bd_srvca srvca  ON srvca.id_srvca = bdsrvmm.id_srvca")
			.append(" left join bd_hp_srvorca hpsrvca  on bdsrvmm.id_srv = hpsrvca.id_srv  and hpsrvca.id_hp = '"+ id_hp + "' ")
			.append(" and ((bdsrvmm.fg_mm='Y' and hpsrvca.Id_Mm=bdsrvmm.id_mm) or bdsrvmm.fg_mm='N')")
			.append(" left join bd_hp_srvctr hpsrvctr  on bdsrvmm.id_srv = hpsrvctr.id_srv and hpsrvctr.eu_hpsrvtp = hpsrvca.eu_hpsrvtp ")
			.append(" left join bd_udidoc udica  on udica.id_udidoc = hpsrvca.id_hpsrvtp ")
			.append(" left join bd_udidoc udisrvtp  on udisrvtp.code = ctm_srvtp ")
			.append(" and udisrvtp.id_udidoclist = '@@@@ZZ2000000000000T'");
			if("11".equals(DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP())){
				sql.append(" left join ");
				sql.append(" ( ");
				sql.append(" SELECT id_mm,factor,id_unit_pkg,MAX(sd_mmpkgupro) sd_mmpkgupro");
				sql.append("		FROM bd_mm_pkgu");
				sql.append("		WHERE EN_OPPKGTP     IS NOT NULL");
				sql.append("		GROUP BY id_mm,");
				sql.append("		factor,");
				sql.append("		id_unit_pkg");
				sql.append(" ) MM_OP_PKG on MM_OP_PKG.id_mm = bdsrvmm.id_mm");
				sql.append(" left join bd_measdoc unitsale on unitsale.id_measdoc = MM_OP_PKG.id_unit_pkg ");
			}
			sql.append(" )bdsrvmm order by length(bdsrvmm.name_srv) asc, bdsrvmm.name_srvmm asc ");

		return sql.toString();
	}

    /**
     * 武威走此方法
     * @code 0164497: 医生开立医嘱，明细界面“描述”一栏，加入医保药品对照表种的des、note字段
     * @return
     */
	public String getWuweiBdSrvMmPgkUnitSql(String id_org, String id_dept, String id_emp_or, String id_hp,
			String id_pripat) {
		StringBuilder sbWhere = new StringBuilder(" where 1=1 ");
		List<String> whereList = this.getWherePart();
		for (String part : whereList) {
			sbWhere.append(" and ").append(part);
		}
		StringBuilder sql = new StringBuilder("");
		sql.append(" select distinct name_srvmm, des_pri,'【'||tree1||'】' as srvtp,  ")
		.append(" name_srvtp, name_unit_sale,pakbasefactor, hpsrvtp_name  ||case when hp_srvorca_des is not null  then '['||hp_srvorca_des||']' else ''  end ||case when hp_srvorca_note is not null  then '['||hp_srvorca_note||']' else ''  end || hpsrvtp_des || ' ' || des des, code_srv code ,")
		.append(" idsrvidmm||id_unit_sale idsrvidmm,  id_srv,  name_srv, sd_srvtp, Id_mm, name_mm,  fg_ctm,id_unit_sale ")
		.append(" from  ")
		.append(" ( ")
		.append("	select bdsrvmm.*, srvca.fullName as tree1,udisrvtp.ctrl2 name_srvtp, ")
		.append(" 	bdsrvmm.name_srv || (case when bdsrvmm.fg_mm = 'Y' and bdsrvmm.fg_ctm != 'Y' then ('[' || decode(name_srv,name_mm,'',name_mm)|| bdsrvmm.spec || ']')else '' end) name_srvmm, ")
		.append(" 	(case when udica.name is null and bdsrvmm.fg_bl = 'Y' then '丙类' else udica.name end) hpsrvtp_name, ")
		.append(" 	(case when bdsrvmm.fg_mm = 'Y' and bdsrvmm.fg_ctm != 'Y' then  to_char(price, 'fm9999999990.00') else to_char(price_ratio, 'fm9999999990.00') || '' end) des_pri, ")
		.append(" 	DECODE(hp_srvorca.des,NULL,'',hp_srvorca.des) hp_srvorca_des,DECODE(hp_srvorca.note,NULL,'',hp_srvorca.note) hp_srvorca_note,decode(hpsrvca.des,null,'',hpsrvca.des) hpsrvca_des,decode(udica.des,null,'',udica.des) hpsrvtp_des, ")
		.append(" 	decode(hpsrvctr.his_des,null,'',hpsrvctr.his_des) hpsrvctr_des  ");
		if("11".equals(DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP())){
			sql.append(",unitsale.name name_unit_sale,MM_OP_PKG.factor||bdsrvmm.name_unit_pkgbase as pakbasefactor,MM_OP_PKG.id_unit_pkg as id_unit_sale ");
		}else{
			sql.append(",'' name_unit_sale,'' as pakbasefactor,'' as id_unit_sale ");
		}
		sql.append(" 	from ")
		.append(" 	(")
		.append(" 		select bdsrvmm.* ")
		.append("  		from ")
		.append("		(")
		.append("			select distinct ")
		.append(" 			bdsrvmm.*, decode(bdsrvfreq.cnt, null, 0, bdsrvfreq.cnt) wf ")
		.append(" 			from ")
		.append("			(")
		.append(" 				(select bdsrv.id_srv, bdsrv.sd_srvtp, bdsrv.code code_srv, bdsrv.name name_srv, ")
		.append(" 				fg_ctm, fg_mm, fg_bl,  bdsrv.pycode pycode_srv, bdsrv.wbcode wbcode_srv,bdsrv.mnecode as mnecode_srv,bdsrv.shortname as shortname_srv,decode(bdsrv.des, null, '') des, ")
		.append(" 				decode(substr(sd_srvtp, 1, 2), '01', substr(sd_srvtp, 1, 4), '14', substr(sd_srvtp, 1, 4), substr(sd_srvtp, 1, 2)) ctm_srvtp, ")
		.append(" 				'' code_mm, '' id_mm, '' name_mm, '' spec, '' pycode_mm, '' wbcode_mm,  0 price , '' id_srvdrug, '' id_dosage,")
		.append("				 '' als_name,'' sd_herbpreparationtp,id_srvca,bdsrv.id_srv idsrvidmm,'' as name_unit_pkgbase ")
		.append(" 				from bd_srv bdsrv ")
		.append(" 				where bdsrv.fg_or = 'Y' and bdsrv.fg_mm != 'Y' and bdsrv.fg_use_op = 'Y' and bdsrv.fg_active = 'Y' and bdsrv.ds = '0' and bdsrv.quan_med is not null and bdsrv.id_org = '"+id_org + "' and Sd_srvtp != '1203'")
		.append(" 				)")
				
		.append("			union ")
	
		.append(" 				(select bdsrvmm.id_srv, bdsrvmm.sd_srvtp, bdsrvmm.code_srv, bdsrvmm.name_srv, bdsrvmm.fg_ctm,bdsrvmm.fg_mm,bdsrvmm.fg_bl, bdsrvmm.pycode_srv, bdsrvmm.wbcode_srv,bdsrvmm.mnecode_srv,bdsrvmm.shortname_srv,")
		.append(" 				decode (nvl(drugprop.sd_pois,'0'),'0','',udipois.name||' ')|| ")
		.append(" 				decode (nvl(drugprop.sd_anti,'0'),'0','',udianti.name||' ')|| ")
		.append(" 				decode(des_mm,  null,  des_srv, des_srv || ' ' || des_mm) des, ")
		.append(" 				decode(substr(sd_srvtp, 1, 2), '01', substr(sd_srvtp, 1, 4), '14', substr(sd_srvtp, 1, 4), substr(sd_srvtp, 1, 2)) ctm_srvtp, ")
		.append(" 				code_mm,bdsrvmm.id_mm,name_mm, spec, pycode_mm, wbcode_mm,  price, drugprop.id_srvdrug, drugprop.id_dosage, ")
		.append(" 				als_name,sd_herbpreparationtp,id_srvca,bdsrvmm.id_srv||bdsrvmm.id_mm idsrvidmm,name_unit_pkgbase ")
		.append(" 				from ")
		.append("				(select bdsrv.id_srv, bdsrv.sd_srvtp,bdsrv.name name_srv,bdsrv.code code_srv,bdsrv.pycode pycode_srv,bdsrv.mnecode as mnecode_srv,bdsrv.shortname as shortname_srv,")
		.append(" 					bdsrv.wbcode wbcode_srv, bdsrv.fg_bl, ")
		.append(" 					bdsrv.des des_srv, bdsrv.fg_mm,bdsrv.fg_ctm,")
		.append(" 					bdmm.code code_mm,bdmm.id_mm,bdmm.name as name_mm,bdmm.spec,bdmm.pycode pycode_mm,")
		.append(" 					bdmm.wbcode wbcode_mm,bdmm.price,bdmm.des||decode(bdmm.sup_name,null,'','【'||bdmm.sup_name||'】'||'('||bdmm.abrad||')') des_mm,bdmm.fg_out,bdmm.sd_herbpreparationtp,id_srvca, ")
		.append("                   name_unit_pkgbase")
		.append(" 					from bd_srv bdsrv ")
		.append(" 					inner join ")
		.append(" 					(")
		.append("						select nvl(mmbl.quan_usable,0)quan_usable, bdmm.* ,b.name as abrad from bd_mm bdmm ")
		.append(" 						inner join ")
		.append("						(")
		.append("							select id_mm, sum(quan_usable) quan_usable ")
		.append(" 							from (")
		.append(" 								select bl.id_mm, quan_usable FROM mm_bl bl inner join (select id_wh from bd_wh where fg_use_op='Y' or fg_use_er='Y') wh ")
		.append(" 								on bl.id_wh=wh.id_wh inner join BD_MM_WH mmwh ON bl.id_wh = mmwh.id_wh AND mmwh.id_mm = bl.id_mm")
		.append(" 								WHERE MMWH.FG_ACTIVE = 'Y' AND mmwh.fg_out  = 'N' and bl.quan_usable > 0 ")
		.append("							) group by id_mm ")
		.append("						) mmbl on mmbl.id_mm = bdmm.id_mm   ")
		.append("						left join bd_udidoc b on b.id_udidoc = bdmm.id_abrd  where bdmm.fg_active = 'Y' and bdmm.ds = 0 and bdmm.fg_out = 'N'")
		.append("					)bdmm on bdsrv.id_srv = bdmm.id_srv ")
		.append(" 						where bdsrv.fg_or = 'Y' and bdsrv.fg_mm = 'Y' and bdsrv.fg_use_op = 'Y' and bdsrv.fg_active = 'Y' and bdsrv.ds = '0' and bdsrv.id_org = '"+ id_org + "' and Sd_srvtp != '1203'")
		.append(" 				) bdsrvmm ")
		.append(" 				left join bd_srv_drug drugprop on drugprop.id_srv = bdsrvmm.id_srv ")
		.append(" 				left join bd_udidoc udipois on udipois.id_udidoc = drugprop.id_pois ")
		.append(" 				left join bd_udidoc udianti on udianti.id_udidoc = drugprop.id_anti ")
		.append(" 				left join ")
		.append("  				(")
		.append(" 					select id_mm,to_char(wm_concat(name)) als_name from BD_MM_NAME where ds=0 group by id_mm")
		.append("				) bd_mm_als ")
		.append("  				on bd_mm_als.id_mm=bdsrvmm.id_mm ")
		.append(" 			)")
		.append(" 		) bdsrvmm ")
		.append(" left join bd_srvoth_wordfreq bdsrvfreq on bdsrvmm.id_srv = bdsrvfreq.id_biz and bdsrvfreq.biz_classtype = 'medsrv'  and bdsrvfreq.id_dept = '"+ id_dept + "' and bdsrvfreq.id_emp = '" + id_emp_or + "' ");
		if (sbWhere.length() > 0) {
			sql.append(sbWhere.toString().replace("srv.sd_srvtp", "sd_srvtp"));
		}
		// 99 表示非物品服务项目；01 表示药品服务项目
		sql.append(eu_srvtp.equals("99") ? " and sd_srvtp not like '01%'"
				: (eu_srvtp.equals("01") ? " and sd_srvtp like '01%' " : ""));

	sql.append(" order by length(pycode_srv) asc, wf desc");
	sql.append("	) bdsrvmm  where rownum <= 100");
		sql.append(") bdsrvmm ")

			.append(" left join view_price_rp blprice on bdsrvmm.ID_SRV = blprice.id_srv ")
			.append(" and blprice.ID_PRIPAT = '" + id_pripat + "' ")
			.append(" LEFT OUTER JOIN bd_srvca srvca  ON srvca.id_srvca = bdsrvmm.id_srvca")
			.append("  LEFT JOIN bd_hp_srvorca hp_srvorca ON bdsrvmm.id_srv  = hp_srvorca.id_srv left join bd_hp_srvorca hpsrvca  on bdsrvmm.id_srv = hpsrvca.id_srv  and hpsrvca.id_hp = '"+ id_hp + "' ")
			.append(" and ((bdsrvmm.fg_mm='Y' and hpsrvca.Id_Mm=bdsrvmm.id_mm) or bdsrvmm.fg_mm='N')")
			.append(" left join bd_hp_srvctr hpsrvctr  on bdsrvmm.id_srv = hpsrvctr.id_srv and hpsrvctr.eu_hpsrvtp = hpsrvca.eu_hpsrvtp ")
			.append(" left join bd_udidoc udica  on udica.id_udidoc = hpsrvca.id_hpsrvtp ")
			.append(" left join bd_udidoc udisrvtp  on udisrvtp.code = ctm_srvtp ")
			.append(" and udisrvtp.id_udidoclist = '@@@@ZZ2000000000000T'");
			if("11".equals(DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP())){
				sql.append(" left join ");
				sql.append(" ( ");
				sql.append(" SELECT id_mm,factor,id_unit_pkg,MAX(sd_mmpkgupro) sd_mmpkgupro");
				sql.append("		FROM bd_mm_pkgu");
				sql.append("		WHERE EN_OPPKGTP     IS NOT NULL");
				sql.append("		GROUP BY id_mm,");
				sql.append("		factor,");
				sql.append("		id_unit_pkg");
				sql.append(" ) MM_OP_PKG on MM_OP_PKG.id_mm = bdsrvmm.id_mm");
				sql.append(" left join bd_measdoc unitsale on unitsale.id_measdoc = MM_OP_PKG.id_unit_pkg ");
			}
			sql.append(" )bdsrvmm order by length(bdsrvmm.name_srv) asc, bdsrvmm.name_srvmm asc ");

		return sql.toString();
	}
}
