package iih.bl.st.s.bp.oepcharge.qry;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询待缴费医嘱sql
 * 
 * @author ly 2019/01/30
 *
 */
public class BlOepCostOrdInfoQry implements ITransQry {

	private List<String> orsrvIdList;

	public BlOepCostOrdInfoQry(List<String> orsrvIdList) {
		this.orsrvIdList = orsrvIdList;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {

		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_MP_EXECANC);
		param.addParam(ICiDictCodeConst.SD_SU_MP_CANCEL);
		sqlSb.append(" where orsrv.ds=0 and ord.sd_su_mp  not in (?,?) and  ");
		sqlSb.append(SqlUtils.getInSqlByIds("orsrv.id_orsrv", this.orsrvIdList.toArray(new String[0])));
		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("ord.id_pat,");
		sqlSb.append("ord.id_en id_ent,");
		sqlSb.append("ord.id_entp id_enttp,");
		sqlSb.append("ord.code_entp code_enttp,");
		sqlSb.append("ord.id_or,");
		sqlSb.append("ord.code_or,");
		sqlSb.append("ord.applyno,");
		sqlSb.append("pres.code pres_code,");
		sqlSb.append("ord.name_or,");
		sqlSb.append("ord.dt_effe dt_or,");
		sqlSb.append("ord.id_dep_or,");
		sqlSb.append("ord.id_emp_or,");
		sqlSb.append("ord.content_or,");
		sqlSb.append("ord.sd_srvtp,");
		sqlSb.append("ord.id_didef,");
		sqlSb.append("ord.name_didef,");
		sqlSb.append("ord.dt_sign,");
		
		sqlSb.append("orsrv.id_pres,");
		sqlSb.append("orsrv.id_orsrv,");
		sqlSb.append("orsrv.id_srv,");
		sqlSb.append("orsrv.fg_or,");
		sqlSb.append("orsrv.code_srv,");
		sqlSb.append("orsrv.name name_srv,");
		sqlSb.append("orsrv.id_dep_mp,");
		sqlSb.append("orsrv.id_dep_wh,");
		sqlSb.append("orsrv.fg_mm,");

		sqlSb.append("orsrvmm.code_mm,");
		sqlSb.append("orsrvmm.name_mm,");
		sqlSb.append("orsrvmm.id_mm,");
		sqlSb.append("orsrvmm.id_pgku_cur,");
		sqlSb.append("orsrvmm.id_pgku_base,");
		sqlSb.append("mm.spec,");
		
		sqlSb.append("decode(orsrv.fg_mm,'Y', orsrvmm.id_pgku_cur,orsrv.id_medu) srvu, ");
		sqlSb.append("decode(orsrv.fg_mm,'Y', measdocmm.name,measdoc.name) srvu_name, ");
		sqlSb.append("decode(orsrv.fg_mm,'Y', orsrvmm.quan_cur,orsrv.quan_total_medu) quan, ");

		sqlSb.append("ent.id_patca id_paticate,");
		sqlSb.append("ent.id_pripat,");
		sqlSb.append("ent.code code_ent,");
		sqlSb.append("patca.name name_patca,");
		sqlSb.append("pripat.name name_pripat,");

		sqlSb.append("ordep.id_dep id_dep_or,");
		sqlSb.append("ordep.name name_dep_or,");
		sqlSb.append("mpdep.id_dep id_dep_mp,");
		sqlSb.append("mpdep.name name_dep_mp,");
		sqlSb.append("psndoc.name name_emp_or, ");
		
		sqlSb.append("inccaitm.id_inccaitm ,");
		sqlSb.append(" inccaitm.name name_inccaitm ,");
		sqlSb.append("inccaitm.code code_inccaitm, ");
		
		sqlSb.append("case when ord.sd_srvtp like '0207%' then '05' ");
		sqlSb.append(" when ord.sd_srvtp like '01%' then '01'");
		sqlSb.append(" when ord.sd_srvtp like '02%' then '02'");
		sqlSb.append(" when ord.sd_srvtp like '03%' then '03'");
		sqlSb.append(" else '04' end Prntype,");
		
		sqlSb.append(" entop.TIMES_OP ");
		
		

		sqlSb.append("from ci_order ord ");
		sqlSb.append("inner join ci_or_srv orsrv ");
		sqlSb.append("on ord.id_or = orsrv.id_or ");
		sqlSb.append("inner join en_ent ent ");
		sqlSb.append("on ord.id_en = ent.id_ent ");
		sqlSb.append("left join ci_pres pres ");
		sqlSb.append("on  orsrv.id_pres = pres.id_pres ");
		sqlSb.append("left join ci_or_srv_mm orsrvmm ");
		sqlSb.append("on orsrv.id_orsrv = orsrvmm.id_orsrv ");
		sqlSb.append("left join bd_mm mm ");
		sqlSb.append("on orsrvmm.id_mm = mm.id_mm ");
		sqlSb.append("left join pi_pat_ca patca ");
		sqlSb.append("on ent.id_patca = patca.id_patca ");
		sqlSb.append("left join bd_pri_pat pripat ");
		sqlSb.append("on ent.id_pripat = pripat.id_pripat ");
		sqlSb.append("left join bd_dep ordep ");
		sqlSb.append("on ord.id_dep_or = ordep.id_dep ");
		sqlSb.append("left join bd_dep mpdep ");
		sqlSb.append("on orsrv.id_dep_mp = mpdep.id_dep ");
		sqlSb.append("left join bd_psndoc psndoc ");
		sqlSb.append("on ord.id_emp_or = psndoc.id_psndoc ");
		sqlSb.append(" left join bd_measdoc measdocmm on measdocmm.id_measdoc=orsrvmm.id_pgku_cur ");
		sqlSb.append(" left join bd_measdoc measdoc on measdoc.id_measdoc=orsrv.id_medu");
		sqlSb.append(" inner join bd_incca_itm_rel inccarel on orsrv.id_srv=inccarel.id_srv  ");
		sqlSb.append(" left join en_ent_op entop on entop.id_ent=ord.id_en ");
		sqlSb.append(" inner join bd_incca_itm inccaitm on inccaitm.id_inccaitm=inccarel.id_inccaitm and inccaitm.id_incca='");
		sqlSb.append(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		sqlSb.append("'");

		return sqlSb.toString();
	}

}
