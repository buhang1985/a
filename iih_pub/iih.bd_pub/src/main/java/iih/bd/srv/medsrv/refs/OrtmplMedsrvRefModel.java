package iih.bd.srv.medsrv.refs;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.DaoUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 医嘱模板明细服务参照
 * @author Young
 *
 */
public class OrtmplMedsrvRefModel extends RefGridModel {
	//01:拼音码,10:五笔码,11:五笔码和拼音码,默认使用拼音码
	private String sd_inputmethod = "";
	private String queryStr = "";
	private String sd_herbpreparationtp;
	public void setSd_herbpreparationtp(String sd_herbpreparationtp) {
		this.sd_herbpreparationtp = sd_herbpreparationtp;
	}
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Name_show", "Code", "Name_srvtp", "Price", "Des" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "Id_srv", "Id_srvtp","Sd_srvtp", "Id_mm", "Id_ortmpl", "Id_ortmpltp", 
				"Spec", "Quan_med", "Id_unit_med", "Med_code", "Med_name",
				"Id_freq", "Freq_code", "Freq_name", 
				"Id_route", "Route_code", "Route_name", 
				"Id_routedes", "Routedes_code", "Routedes_name",
				"Id_boil", "Boil_code", "Boil_name", 
				"Id_boildes", "Boildes_code", "Boildes_name", 
				"Ismuldose", "Ismulexec", "Sd_totalopenmode", "Times", 
				"Id_samptp", "Sd_samptp", "Name_samptp", "Fg_set", "Des_or","idsrvidmm","name","Id_herbpreparationtp","Sd_herbpreparationtp" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "编码", "类型", "价格", "描述" };
	}

	@Override
	public String getPkFieldCode() {
		return "idsrvidmm";
	}

	@Override
	public String getRefCodeField() {
		return "Code";
	}

	@Override
	public String getRefNameField() {
		return "Name_show";
	}

	@Override
	public String getTableName() {
		return "SRV";
	}

	@Override
	public void addWherePart(String wherePart) {
		getWherePart().add(wherePart);
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		sd_inputmethod = (String) this.getExtendAttributeValue("inputmethod");//01:拼音码,10:五笔码,11:五笔码和拼音码
		if (StringUtils.isNullOrEmpty(sd_inputmethod)) {
			sd_inputmethod = "01";
		}
		if(!StringUtils.isNullOrEmpty(blurValue))
		{
			blurValue = blurValue.toLowerCase();
		}
		StringBuffer sb = new StringBuffer();
		this.queryStr = blurValue;
		sb.append("(lower(SRV.name) like '%" + blurValue + "%'");
		sb.append(" or lower(SRV.code) like '%" + blurValue + "%'");
		if ("1".equals(sd_inputmethod.substring(1))) {
			sb.append(" or lower(SRV.pycode) like '%" + blurValue + "%'");
		}
		if (sd_inputmethod.startsWith("1")) {
			sb.append(" or lower(SRV.wbcode) like '%" + blurValue + "%'");
		}
		sb.append(")");
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
	public String getRefSql() {		
		Integer flag = (Integer) this.getExtendAttributeValue("srvortmplFlag");
		String srvWhere = (String) this.getExtendAttributeValue("srvwhere");
		String ortmplWhere = (String) this.getExtendAttributeValue("ortmplwhere");
		String code_entp = (String) this.getExtendAttributeValue("code_entp");
	    sd_herbpreparationtp = (String) this.getExtendAttributeValue("sd_herbpreparationtp");
		return this.getSrvMmTmplSql(code_entp, flag, srvWhere == null ? "" : srvWhere, ortmplWhere == null ? "" : ortmplWhere);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "Name", "Code", "Pycode","Wbcode", "Mnecode" };
	}
	
	private String getSrvMmTmplSql(String code_entp, Integer flag, String srvWhere, String ortmplWhere) {
		String orgsql = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "SRV");
		
		String whereStr = "";
		List<String> whereList = this.getWherePart();
		for (String part : whereList) {
			whereStr += part;
		}
		
		//点击参照结果时，根据主键ID回查数据
		if (flag == null) {
			StringBuilder sql = new StringBuilder("");
			sql.append("select * from (");
			sql.append(this.getSrvSql(code_entp, "", orgsql, "", srvWhere, true));
			sql.append(" union all ");
			sql.append(this.getTmplSql(code_entp, "", orgsql, "", ortmplWhere, true));
			sql.append(")");
			sql.append(whereStr.length() > 0 ? " where " + whereStr : "");
			return sql.toString();
		}
		
		StringBuilder sbcnt = new StringBuilder("");
		if (this.queryStr.length() > 0) {
			sbcnt.append(",length(BDSRV.name)-length('" + this.queryStr + "') as cnt_name");
			if (this.sd_inputmethod.length() > 0) {
				if ("1".equals(this.sd_inputmethod.substring(1))) {
					sbcnt.append(",length(BDSRV.pycode)-length('" + this.queryStr + "') as cnt_py");
				}
				if (this.sd_inputmethod.startsWith("1")) {
					sbcnt.append(",length(BDSRV.wbcode)-length('" + this.queryStr + "') as cnt_wb");
				}
			}
		}

		StringBuilder sql = new StringBuilder("");
		sql.append("select * from (");
		switch (flag) {
		case 1:
			sql.append(this.getSrvSql(code_entp, sbcnt.toString(), orgsql, whereStr, srvWhere, false));
			break;
		case 2:
			sql.append(this.getTmplSql(code_entp, sbcnt.toString(), orgsql, whereStr, ortmplWhere, false));
			break;
		case 3:
			sql.append(this.getSrvSql(code_entp, sbcnt.toString(), orgsql, whereStr, srvWhere, false));
			sql.append(" union all ");
			sql.append(this.getTmplSql(code_entp, sbcnt.toString(), orgsql, whereStr, ortmplWhere, false));
			break;
		default:
			break;
		}
		sql.append(")");

		if(this.queryStr.length() > 0){
			sql.append(" order by cnt_name asc");
			if (this.sd_inputmethod.length() > 0){
				if ("1".equals(this.sd_inputmethod.substring(1))) {
					sql.append(",cnt_py asc");
				}
				if (this.sd_inputmethod.startsWith("1")) {
					sql.append(",cnt_wb asc");
				}
			}
		}
		return sql.toString();
	}
	
	private String getSrvSql(String code_entp, String sbcnt, String orgsql, String whereStr, String srvWhere, boolean isRst) {
		StringBuilder sql = new StringBuilder("");
		sql.append("(select BDSRV.name_show,BDSRV.code,BDSRV.fullname as name_srvtp,BDSRV.price,BDSRV.des,")
		.append("BDSRV.id_srv,BDSRV.id_srvtp,BDSRV.sd_srvtp,BDSRV.id_mm,'' as id_ortmpl,'' as id_ortmpltp,")
		.append("BDSRV.spec,BDSRV.quan_med,BDSRV.id_unit_med,MEASDOC.code as med_code,MEASDOC.name as med_name,")
		.append("BDSRV.id_freq,FREQ.code as freq_code,FREQ.name as freq_name,")
		.append("BDSRV.id_route,ROUTE.code as route_code,ROUTE.name as route_name,")
		.append("BDSRV.id_routedes,ROUTEDES.code as routedes_code,ROUTEDES.name as routedes_name,")
		.append("BDSRV.id_boil,BOIL.code as boil_code,BOIL.name as boil_name,")
		.append("BDSRV.id_boildes,BOILDES.code as boildes_code,BOILDES.name as boildes_name,")
		.append("BDSRV.ismuldose,BDSRV.ismulexec,BDSRV.sd_totalopenmode,BDSRV.times,")
		.append("SRVLAB.id_samptp,SRVLAB.sd_samptp,SAMPTP.name as name_samptp,BDSRV.fg_set,'' as des_or,")
		.append("BDSRV.id_srv||BDSRV.id_mm as idsrvidmm,BDSRV.name,id_herbpreparationtp,sd_herbpreparationtp ")
		.append(sbcnt)
		.append(" from (")
		.append("(select SRV.id_srv,srvca.fullname,SRV.id_srvtp,SRV.sd_srvtp,MM.id_mm,MM.code,SRV.name,")
		.append("SRV.name||(case when SRV.fg_ctm !='Y' then '['||(case when SRV.name=MM.name then '' else MM.name||'，' end)||MM.Spec||']' else '' end) as name_show,")
		.append("decode(substr(SRV.sd_srvtp,1,2),'01',substr(SRV.sd_srvtp,1,4),'14',substr(SRV.sd_srvtp,1,4),substr(SRV.sd_srvtp,1,2)) as sd_srvtp_ext,")
		.append("(case when MM.des is null then SRV.des else SRV.des||' '||MM.des end) as des,SRV.pycode,SRV.wbcode,SRV.times,")
		.append("SRV.ismuldose,SRV.ismulexec,SRV.sd_totalopenmode,")
		.append("'N' as fg_set,SRV.quan_med,SRV.id_unit_med,SRV.id_freq,SRV.id_route,SRV.id_routedes,SRV.id_boil,SRV.id_boildes,")
		.append("to_char(MM.price,'fm9999999990.00') as price,")
		.append("MM.spec,")
		.append("MM.id_herbpreparationtp,")
		.append("MM.sd_herbpreparationtp ")
		.append(" from bd_srv SRV ")
		.append(" left join bd_srv_drug DRUG on SRV.id_srv=DRUG.id_srv ")
		.append(" LEFT JOIN bd_srvca srvca  ON srvca.id_srvca=SRV.id_srvca left join bd_mm MM on SRV.id_srv=MM.id_srv")
		.append(" where SRV.fg_mm='Y' and SRV.fg_or='Y' and SRV.fg_active='Y' and SRV.ds=0 and MM.fg_active='Y' and (MM.fg_out is null or MM.fg_out='N')")
		.append(this.getFgentpStr(code_entp, "SRV", "fg_use")).append(" and ").append(orgsql)
		.append(whereStr.length() > 0 ? (isRst ? " and " + whereStr : " and (" + whereStr + " or " + whereStr.replaceAll("SRV", "MM") + ")") : "")
		.append(srvWhere);
		if(!StringUtils.isNullOrEmpty(sd_herbpreparationtp)){
			sql.append(String.format(" and (nvl(MM.sd_herbpreparationtp,'~')='~' or MM.sd_herbpreparationtp = '%s') ",this.sd_herbpreparationtp));
		}
		sql.append(") union all (")
		.append("select SRV.id_srv,srvca.fullname,SRV.id_srvtp,SRV.sd_srvtp,'' as id_mm,SRV.code,SRV.name,SRV.name name_show,")
		.append("decode(substr(SRV.sd_srvtp,1,2),'01',substr(SRV.sd_srvtp,1,4),'14',substr(SRV.sd_srvtp,1,4),substr(SRV.sd_srvtp,1,2)) as sd_srvtp_ext,")
		.append("SRV.des,SRV.pycode,SRV.wbcode,SRV.times,")
		.append("SRV.ismuldose,SRV.ismulexec,SRV.sd_totalopenmode,")
		.append("SRV.fg_set,SRV.quan_med,SRV.id_unit_med,SRV.id_freq,SRV.id_route,SRV.id_routedes,SRV.id_boil,SRV.id_boildes,")
		.append("to_char((select BDSRVPRICE.price_std from view_price_rp BDSRVPRICE where BDSRVPRICE.id_srv=SRV.id_srv and rownum=1),'fm9999999990.00') as price,")
		.append("'' as spec,")
		.append("'' id_herbpreparationtp,")
		.append("'' sd_herbpreparationtp ")
		.append(" from bd_srv SRV LEFT JOIN bd_srvca srvca ON srvca.id_srvca=SRV.id_srvca ")
		.append(" where SRV.fg_mm!='Y' and SRV.fg_or='Y' and SRV.fg_active='Y' and SRV.ds=0 ")
		.append(this.getFgentpStr(code_entp, "SRV", "fg_use")).append(" and ").append(orgsql)
		.append(whereStr.length() > 0 ? " and " + whereStr : "")
		.append(srvWhere)
		.append(")) BDSRV")
		.append(" left join bd_udidoc SRVTP on BDSRV.sd_srvtp_ext=SRVTP.code and SRVTP.id_udidoclist='" + IBdSrvDictCodeTypeConst.ID_SRVTP + "'")
		.append(" left join bd_measdoc MEASDOC on BDSRV.id_unit_med=MEASDOC.id_measdoc")
		.append(" left join bd_freq FREQ ON BDSRV.id_freq=FREQ.id_freq")
		.append(" left join bd_route ROUTE ON BDSRV.id_route=ROUTE.id_route")
		.append(" left join bd_route_des ROUTEDES ON BDSRV.id_routedes=ROUTEDES.id_routedes")
		.append(" left join bd_boil BOIL ON BDSRV.id_boil=BOIL.id_boil")
		.append(" left join bd_boil_des BOILDES ON BDSRV.id_boildes=BOILDES.id_boildes")
		.append(" left join bd_srv_lab SRVLAB ON BDSRV.id_srv=SRVLAB.id_srv")
		.append(" left join bd_udidoc SAMPTP ON SAMPTP.id_udidoc=SRVLAB.id_samptp)");
		return sql.toString();
	}
	
	private String getTmplSql(String code_entp, String sbcnt, String orgsql, String whereStr, String ortmplWhere, boolean isRst) {
		StringBuilder sql = new StringBuilder("");
		sql.append("(select TMPL.name as name_show,TMPL.code,'' as price,'' as des,''             as fullname, ")
		.append("TMPL.id_ortmpl as id_srv,'' as id_srvtp,'' as sd_srvtp,'' as id_mm,TMPL.id_ortmpl,TMPL.id_ortmpltp,")
		.append("'' as spec,TMPL.orders as quan_med,'' as id_unit_med,'' as med_code,'' as med_name,")
		.append("TMPL.id_freq,FREQ.code as freq_code,FREQ.name as freq_name,")
		.append("TMPL.id_route,ROUTE.code as route_code,ROUTE.name as route_name,")
		.append("TMPL.id_routedes,ROUTEDES.code as routedes_code,ROUTEDES.name as routedes_name,")
		.append("TMPL.id_boil,BOIL.code as boil_code,BOIL.name as boil_name,")
		.append("TMPL.id_boildes,BOILDES.code as boildes_code,BOILDES.name as boildes_name,")
		.append("'' as ismuldose,'' as ismulexec,'' as sd_totalopenmode,0 times,")
		.append("'' as id_samptp,'' as sd_samptp,'' as name_samptp,'' as fg_set,TMPL.des_or,")
		.append("TMPL.id_ortmpl as idsrvidmm,TMPL.name as name,'' id_herbpreparationtp,'' sd_herbpreparationtp")
		.append(sbcnt.replaceAll("BDSRV", "TMPL"))
		.append(" from bd_srv_ortmpl TMPL")
		.append(" left join bd_udidoc ORTMPLTP ON TMPL.id_ortmpltp = ORTMPLTP.id_udidoc")
		.append(" left join bd_freq FREQ ON TMPL.id_freq=FREQ.id_freq")
		.append(" left join bd_route ROUTE ON TMPL.id_route=ROUTE.id_route")
		.append(" left join bd_route_des ROUTEDES ON TMPL.id_routedes=ROUTEDES.id_routedes")
		.append(" left join bd_boil BOIL ON TMPL.id_boil=BOIL.id_boil")
		.append(" left join bd_boil_des BOILDES ON TMPL.id_boildes=BOILDES.id_boildes")
		.append(" where TMPL.fg_active='Y' and TMPL.ds=0 and TMPL.sd_ortmpltp not like '1%' and TMPL.fg_sync='N' ")
		.append(this.getFgentpStr(code_entp, "TMPL", "fg_entp"))
		.append(" and ").append(orgsql.replaceAll("SRV", "TMPL"))
		.append(whereStr.length() > 0 ? (isRst ? " and " + whereStr.replaceAll("SRV", "TMPL").replaceAll("Id_srv", "Id_ortmpl") : " and " + whereStr.replaceAll("SRV", "TMPL")) : "")
		.append(ortmplWhere).append(")");
		return sql.toString();
	}
	
	/**
	 * 获得使用范围标识字段名
	 * @param code_entp
	 * @param tbname
	 * @param strFiled
	 * @return
	 */
	private String getFgentpStr(String code_entp, String tbname, String strFiled) {
		String str = "";
		if(StringUtils.isNullOrEmpty(code_entp)){
			return str;
		}
		if (code_entp.contains(IBdFcDictCodeConst.SD_CODE_ENTP_OP + ",")) {
			str += (str.length() > 0 ? " or " : "") + tbname + "." + strFiled + "_op='Y'";
		} 
		if (code_entp.contains(IBdFcDictCodeConst.SD_CODE_ENTP_IP + ",")) {
			str += (str.length() > 0 ? " or " : "") + tbname + "." + strFiled + "_ip='Y'";
		} 
		if (code_entp.contains(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW + ",")) {
			str += (str.length() > 0 ? " or " : "") + tbname + "." + strFiled + "_er='Y'";
		} 
		if (code_entp.contains(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID + ",")) {
			str += (str.length() > 0 ? " or " : "") + tbname + "." + strFiled + "_er1='Y'";
		} 
		if (code_entp.contains(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS + ",")) {
			str += (str.length() > 0 ? " or " : "") + tbname + "." + strFiled + "_er2='Y'";
		} 
		if (code_entp.contains(IBdFcDictCodeConst.SD_CODE_ENTP_PE + ",")) {
			str += (str.length() > 0 ? " or " : "") + tbname + "." + strFiled + "_pe='Y'";
		} 
		if (code_entp.contains(IBdFcDictCodeConst.SD_CODE_ENTP_FA + ",")) {
			str += (str.length() > 0 ? " or " : "") + tbname + "." + strFiled + "_fm='Y'";
		}
		if (code_entp.contains(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE + ",")) {
			if ("TMPL".equals(tbname)) {
				str += (str.length() > 0 ? " or " : "") + tbname + ".fg_use_pip='Y'";
			}else{
				str += (str.length() > 0 ? " or " : "") + tbname + "." + strFiled + "_pip='Y'";
			}
			
		}
		
 		return str.length() > 0 ? " and (" + str + ")" : str;
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
}
