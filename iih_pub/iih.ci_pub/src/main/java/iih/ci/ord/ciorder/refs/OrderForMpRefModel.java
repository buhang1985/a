package iih.ci.ord.ciorder.refs;

import iih.bd.srv.medsrv.d.MedSrvDO;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;
/**
 * 医嘱参照模型-->护理域使用
 * @author hjh 2018/10/15
 *
 */
public class OrderForMpRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_or" };
	}

//	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "wbcode", "pycode" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "医嘱名称" };
	}

	@Override
	public String getPkFieldCode() {
		return "name_or";
	}

	@Override
	public String getRefCodeField() {
		return "name_or";
	}

	@Override
	public String getRefNameField() {
		return "name_or";
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { "name_or", "wbcode","pycode" };
	}
	@Override
	public String getTableName() {
		return "ordsrv";
	}
	
	@Override
	public String getRefSql() {
		
		String entIds = (String) this.getExtendAttributeValue("id_ent");
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select * from(");
//		sqlSb.append("select ");
//		sqlSb.append("srv.code,");
//		sqlSb.append("ord.name_or as name, ");
//		sqlSb.append("ord.dt_entry,");
//		sqlSb.append("ord.id_or,");
//		sqlSb.append("srv.wbcode,");
//		sqlSb.append("srv.pycode ");
//		sqlSb.append("from ci_order ord ");
//		sqlSb.append("inner join bd_srv srv ");
//		sqlSb.append("on ord.id_srv = srv.id_srv ");
//		sqlSb.append("where ord.fg_chk = 'Y' ");
//		sqlSb.append("and ord.ds = 0 ");
//		sqlSb.append("and ord.name_or in ( ");
		sqlSb.append(" select distinct name_or,srv.wbcode,srv.pycode from ci_order cior  ");
		sqlSb.append(" left join bd_srv srv on srv.id_srv = cior.id_srv ");
		sqlSb.append(" where cior.fg_chk = 'Y' and cior.fg_canc='N' and cior.fg_long='Y' and srv.fg_ctm = 'N'   and nvl(cior.id_route,'~')='~'");
		sqlSb.append(" and  (substr(cior.sd_srvtp,0,2) in ('06','08') or cior.sd_srvtp in ('0503','0505') )");
		sqlSb.append(" and cior.sd_orsrcfun <>'2' and cior.dt_end > '"+new FDateTime()+"'");
		sqlSb.append(" and cior.name_or not like '%注射器%' and  cior.name_or not like '%输液%' ");
		sqlSb.append(" and cior.name_or not like '医用%' and  cior.name_or not like '一次性%' ");
		sqlSb.append(" and cior.name_or not like '%口服%' and  cior.name_or not like '%静注%' ");
		sqlSb.append(" and cior.name_or not like '%皮下注射%' and cior.name_or not like '%''%' ");
		sqlSb.append(" and cior.name_or not like '%滴眼液%' ");
		if(!StringUtil.isEmptyWithTrim(entIds)){
			String[] id_ents = entIds.split(",");
			if (null != id_ents && 0<id_ents.length) {
				String wherestr = "";
				for (String id_ent : id_ents) {
					wherestr +=((StringUtil.isEmptyWithTrim(wherestr)?"'": ",'")+id_ent+"'");
				}
				sqlSb.append("and cior.id_en in (" + wherestr + ") ");
			}
		}else{
			sqlSb.append(" and 1=2");
		}
//		sqlSb.append("order by ord.dt_entry ) ordsrv ");
		sqlSb.append(" ) ordsrv where 1=1 ");
//		
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlSb.append(" And (").append(where).append(") ");
			}
		}
		
		return sqlSb.toString();
	}
	
//	@Override
//	public String[] getBlurFields() {
//		return new String[] { "code", "name", "wbcode", "pycode" };
//	}
}
