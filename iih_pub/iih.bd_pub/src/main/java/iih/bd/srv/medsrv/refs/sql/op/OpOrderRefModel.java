package iih.bd.srv.medsrv.refs.sql.op;


import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.refs.sql.er.FlowOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.er.FlowOrderRefSrvSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.er.FstaidOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.er.FstaidOrderRefSrvSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.ip.DrugCheckDisplayMd4IP;
import xap.mw.core.data.Context;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.DaoUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class OpOrderRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	// 01:拼音码,10:五笔码,11:五笔码和拼音码,默认使用拼音码
	private String sd_inputmethod = "";
	//
	private String eu_srvtp = "";
	private String blurValue = "";
	private String herbpreparationtp="";
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_srvmm", "des_pri", "srvtp", "name_srvtp","name_unit_sale","pakbasefactor", "des", "code" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "idsrvidmm", "id_srv", "sd_srvtp", "id_mm", "fg_ctm","id_unit_sale","pycode" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务项目", "参考价","服务分类", "开单类型","发药单位","换算系数","描述", "物品编码" };
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
		return "srv";// MedSrvDODesc.TABLE_NAME;
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
		this.blurValue = blurValue;
		sd_inputmethod = (String) this.getExtendAttributeValue("inputmethod");// 01:拼音码,10:五笔码,11:五笔码和拼音码
		if (StringUtils.isNullOrEmpty(sd_inputmethod)) {
			sd_inputmethod = "01";
		}
		if (pg == null)
			return this.getRefData();
		else
			return this.getRefData(pg);
			
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
		String id_hp = (String) this.getExtendAttributeValue("id_hp");
		String id_pripat = (String) this.getExtendAttributeValue("id_pripat");
		String openType = (String) this.getExtendAttributeValue("openType");
		String code_entp = (String) this.getExtendAttributeValue("code_entp");
		String mmGroupCodeParam = DrugCheckDisplayMd4IP.getInstance().getDrugGroupParam();
		Logger.warn("参照入参：id_hp:"+id_hp+"--id_pripat:"+id_pripat+"--openType:"+openType+"--code_entp:"+code_entp);
		if(StringUtils.isNullOrEmpty(openType))
		{
			return this.getDefaultSql(code_entp);
		}
		this.herbpreparationtp=setHerbPreParationType(openType);
		StringBuffer buffer = null;
		if(!"01".equals(this.eu_srvtp)&&(StringUtils.isNullOrEmpty(openType)||"All".equals(openType))){//全部
			OpOrderRefSrvSQLBuilder refsrv = getOrderRefSrvSQLBuilder(code_entp);
			buffer = refsrv.getSQL(this.sd_inputmethod, id_hp, id_pripat, blurValue, this.getWherePart());
			buffer.append(" union ");
			OpOrderRefMMSQLBuilder refmm = getOrderRefMMSQLBuilder(code_entp);
			if("11".equals(getDrugDisplayMd())){
				buffer.append(refmm.getSrvMmPkgSQL(this.sd_inputmethod, id_hp, blurValue, this.getWherePart(),mmGroupCodeParam,herbpreparationtp).toString());
			}else{
				buffer.append(refmm.getSrvMmSQL(this.sd_inputmethod, id_hp, blurValue, this.getWherePart(),mmGroupCodeParam,herbpreparationtp).toString());
			}
			return this.getQuerySql(buffer);
		}else if("01".equals(this.eu_srvtp)||openType.startsWith("01")||!StringUtils.isNullOrEmpty(herbpreparationtp)){//药品
			OpOrderRefMMSQLBuilder refsrv = getOrderRefMMSQLBuilder(code_entp);
			if("11".equals(getDrugDisplayMd())){
				buffer = refsrv.getSrvMmPkgSQL(this.sd_inputmethod, id_hp, blurValue, this.getWherePart(),mmGroupCodeParam,herbpreparationtp);
			}else{
				buffer = refsrv.getSrvMmSQL(this.sd_inputmethod, id_hp, blurValue, this.getWherePart(),mmGroupCodeParam,herbpreparationtp);
			}
			buffer.append(refsrv.addOrderBy());
			return buffer.toString();
		}else{//非药品
			OpOrderRefSrvSQLBuilder refsrv = getOrderRefSrvSQLBuilder(code_entp);
			buffer = refsrv.getSQL(this.sd_inputmethod, id_hp, id_pripat, blurValue, this.getWherePart());
			buffer.append(refsrv.addOrderBy());
			return buffer.toString();
		}
	}
	
	private String setHerbPreParationType(String openType) {
		if(IBdSrvDictCodeConst.ID_HERB_PREPARATIONTP_YP.equals(openType)){//饮片 
			return IBdSrvDictCodeConst.SD_HERB_PREPARATIONTP_YP;
		}else if(IBdSrvDictCodeConst.ID_HERB_PREPARATIONTP_KL.equals(openType)){// 颗粒
			return IBdSrvDictCodeConst.SD_HERB_PREPARATIONTP_KL;
		}else if(IBdSrvDictCodeConst.ID_HERB_PREPARATIONTP_FJ.equals(openType)){// 粉剂
			return IBdSrvDictCodeConst.SD_HERB_PREPARATIONTP_FJ;
		}else{
			return "";
		}
	}

	protected OpOrderRefSrvSQLBuilder getOrderRefSrvSQLBuilder(String code_entp){
		if (StringUtils.isNullOrEmpty(code_entp)) {
			return new OpOrderRefSrvSQLBuilder();
		} else {
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {// 门诊
				return new OpOrderRefSrvSQLBuilder();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)) {// 急诊流水
				return new FlowOrderRefSrvSQLBuilder();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)) {// 急诊抢救
				return new FstaidOrderRefSrvSQLBuilder();
			}
		}
		return new OpOrderRefSrvSQLBuilder();
	}
	
	protected OpOrderRefMMSQLBuilder getOrderRefMMSQLBuilder(String code_entp){
		if (StringUtils.isNullOrEmpty(code_entp)) {
			return new OpOrderRefMMSQLBuilder();
		} else {
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {// 门诊
				return new OpOrderRefMMSQLBuilder();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)) {// 急诊流水
				return new FlowOrderRefMMSQLBuilder();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)) {// 急诊抢救
				return new FstaidOrderRefMMSQLBuilder();
			}
		}
		return new OpOrderRefMMSQLBuilder();
	}
	/**
	 * 获得药品开单参照模式
	 * @return
	 */
	public String getDrugDisplayMd(){
		return DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP();
	}
	
	public String getDefaultSql(String code_entp) {
		if("11".equals(DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP())){
			StringBuilder formatsql = new StringBuilder("select * from (");
			formatsql.append("select BDSRV.name as name_srvmm,")
					.append(" BDSRV.Pri as des_pri, '' srvtp,")
					.append(" '' as name_srvtp,'' as name_unit_sale,'' as pakbasefactor,")
					.append(" (BDSRV.Des||' '||BDMM.Des||', ') as des,")
					.append(" BDSRV.code,")
					.append(" (BDSRV.id_srv||BDMM.id_mm||id_unit_pkg) as IdSrvIdMm,")
					.append(" BDSRV.Id_srv,")
					.append(" BDSRV.Sd_srvtp,")
					.append(" BDMM.id_mm,")
					.append(" BDSRV.fg_ctm,'' as id_unit_sale,'' pycode ")
					.append(" from bd_srv BDSRV")
					.append(" left join bd_mm BDMM on BDSRV.id_srv=BDMM.id_srv and BDSRV.ds=0 ");
					formatsql.append(" left join ");
					formatsql.append(" ( ");
					formatsql.append(" SELECT id_mm,factor,id_unit_pkg,MAX(sd_mmpkgupro) sd_mmpkgupro");
					formatsql.append("		FROM bd_mm_pkgu");
					formatsql.append("		GROUP BY id_mm,");
					formatsql.append("		factor,");
					formatsql.append("		id_unit_pkg");
					formatsql.append(" ) MM_OP_PKG on MM_OP_PKG.id_mm = BDMM.id_mm");
					formatsql.append(" left join bd_measdoc unitsale on unitsale.id_measdoc = MM_OP_PKG.id_unit_pkg ");
					formatsql.append("where BDSRV.Id_Org='" + Context.get().getOrgId() + "' and BDSRV.Fg_Or='Y' and BDSRV.Fg_Active='Y' ");

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
			.append(" BDSRV.Pri as des_pri, '' srvtp,")
			.append(" '' as name_srvtp,'' as name_unit_sale,'' as pakbasefactor,")
			.append(" (BDSRV.Des||' '||BDMM.Des||', ') as des,")
			.append(" BDSRV.code,")
			.append(" (BDSRV.id_srv||BDMM.id_mm) as IdSrvIdMm,")
			.append(" BDSRV.Id_srv,")
			.append(" BDSRV.Sd_srvtp,")
			.append(" BDMM.id_mm,")
			.append(" BDSRV.fg_ctm,'' as id_unit_sale,'' pycode ")
			.append(" from bd_srv BDSRV")
			.append(" left join bd_mm BDMM on BDSRV.id_srv=BDMM.id_srv and BDSRV.ds=0 ")
			.append("where BDSRV.Id_Org='" + Context.get().getOrgId() + "' and BDSRV.Fg_Or='Y' and BDSRV.Fg_Active='Y' ")
			.append(" ) bdsrvmm ");

			List<String> whereList = this.getWherePart();
			for (String part : whereList) {
				formatsql.append(" where ").append(part);

			}

			return formatsql.toString();
		}
	}
	
	private String getQuerySql(StringBuffer buffer){
		return "select * from ("+ buffer.toString() +") order by length(name_srvmm) asc, pycode";
	}
}
