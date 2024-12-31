package iih.bl.cg.service.s.bp.qry;

import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医保查询及回退，根据条件获取医保交易数据
 * 
 * @author yang.lu
 *
 */
public class GetBlStOepAndCodeHpDTOBySelDtos implements ITransQry {

	String sDate;
	String eDate;
	String code_hp;
	String id_hp;

	public GetBlStOepAndCodeHpDTOBySelDtos(String sDate, String eDate, String code_hp, String id_hp) {

		this.sDate = sDate;
		this.eDate = eDate;
		this.code_hp = code_hp;
		this.id_hp = id_hp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();

		if (!StringUtil.isEmptyWithTrim(code_hp)) {
			sqlParam.addParam(code_hp);
		}
		if (!StringUtil.isEmptyWithTrim(id_hp)) {
			sqlParam.addParam(id_hp);
		}
		// sqlb.append(" or (1=1");
		if (!StringUtil.isEmptyWithTrim(sDate)) {
			sqlParam.addParam(new FDate(sDate));
		}
		if (!StringUtil.isEmptyWithTrim(eDate)) {
			sqlParam.addParam(new FDate(eDate));
		}
		if (!StringUtil.isEmptyWithTrim(id_hp)) {
			sqlParam.addParam(id_hp);
		}
		if (!StringUtil.isEmptyWithTrim(code_hp)) {
			sqlParam.addParam(code_hp);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlb = new StringBuilder();
		sqlb.append(" select a1.id_hperror,'' code_st,a1.Id_stoep, a1.code_hp,a1.id_pat,'' id_ent,to_char(sysdate) dt_prop,fg_rollback FbHpTradeError,p1.code pat_code,p1.name pat_name,P1.ID_CODE pat_id_code,P1.DT_BIRTH pat_dt_birth ,a1.eu_direct,a1.id_hp,a1.dt_trade dt_trade,a1.eu_srctp");
		sqlb.append(" from  bl_hp_error a1");
		sqlb.append(" inner join pi_pat p1  on a1.id_pat=p1.id_pat ");
		if (!StringUtil.isEmptyWithTrim(code_hp)) {
			sqlb.append(" and a1.code_hp=? ");
		}
		if (!StringUtil.isEmptyWithTrim(id_hp)) {
			sqlb.append(" AND a1.ID_PAT in (SELECT id_pat FROM PI_PAT_HP where no_hp=?)");
		}
		sqlb.append(" union all ");
		sqlb.append(" select '' id_hperror,");
		sqlb.append(" a.code_st,a.Id_stoep, c.code_hp,a.id_pat,a.id_ent,b.dt_prop,'Y' FbHpTradeError,aa.code pat_code,aa.name pat_name,aa.ID_CODE pat_id_code,aa.DT_BIRTH pat_dt_birth,a.eu_direct,c.id_hp,a.dt_st dt_trade,d.eu_srctp");
		sqlb.append(" from  bl_st_oep a");
		sqlb.append(" inner join pi_pat aa on a.id_pat=aa.id_pat");
		sqlb.append(" INNER join bl_cg_itm_oep d on a.id_stoep=d.id_stoep");
		sqlb.append(" inner join en_ent_hp p on a.id_ent=p.id_ent");
		sqlb.append(" left join bl_prop_oep b on a.id_stoep = b.id_stoep");
		sqlb.append(" left join bl_prop_ar_oep c on b.id_propoep = c.id_propoep");
		sqlb.append(" where 1=1 ");
		if (!StringUtil.isEmptyWithTrim(sDate)) {
			sqlb.append(" and a.dt_st >= ? ");
		}
		if (!StringUtil.isEmptyWithTrim(eDate)) {
			sqlb.append(" and a.dt_st < ? ");
		}
		if (!StringUtil.isEmptyWithTrim(id_hp)) {
			sqlb.append(" 	AND a.ID_STOEP in (select id_stoep from BL_PROP_OEP where id_propoep in  (SELECT id_propoep from BL_PROP_AR_OEP where ID_HP IN (SELECT ID_HP FROM pi_pat_hp where no_hp=?)))");
		}
		if (!StringUtil.isEmptyWithTrim(code_hp)) {
			sqlb.append(" and c.code_hp=? ");
		}
		sqlb.append(" group by a.code_st,a.Id_stoep, c.code_hp,a.id_pat,a.id_ent,b.dt_prop,aa.code ,aa.name ,aa.ID_CODE ,aa.DT_BIRTH ,a.eu_direct,c.id_hp,a.dt_st ,d.eu_srctp");

		return  "SELECT * FROM(" + sqlb.toString() + ")A ORDER BY A.dt_trade DESC";
	}

}
