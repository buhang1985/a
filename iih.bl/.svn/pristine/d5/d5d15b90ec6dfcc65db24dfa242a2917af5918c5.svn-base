package iih.bl.cc.service.s.bp.sql;

import iih.bl.cc.blccdto.d.BlpayOepPatDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 通过收付款信息查询对应的费用明细
 * Title: GetBlccOepInfosSql.java
 * @author zhang.hw
 * @date 2019年9月29日  
 * @version 1.0
 */
public class GetBlccOepInfosSql implements ITransQry {
	
	private BlpayOepPatDTO _blpayOepPatDTO;

	public GetBlccOepInfosSql(BlpayOepPatDTO blpayOepPatDTO) {
		this._blpayOepPatDTO = blpayOepPatDTO;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._blpayOepPatDTO.getId_stoep());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select  distinct  cg.id_cgitmoep      as  Id_blccoepinfo, ");
		sql.append("                                 cg.name_inccaitm  as  billitem_name, ");
		sql.append("                                 cg.name_srv            as  cost_name, ");
		sql.append("                                 cg.spec                    as  specs, ");
		sql.append("                                 cg.price                  as  price, ");
		sql.append("                                 cg.quan                    as  quan, ");
		sql.append("                                 cg.amt_ratio          as  amt, ");
		sql.append("                                 ca.name                    as  hp_type, ");
		sql.append("                                 ordep.name              as  dep_or, ");
		sql.append("                                 mpdep.name              as  dep_mp ");
		sql.append("     from  bl_st_oep  stoep ");
		sql.append("     left  join  bl_cg_itm_oep  cg ");
		sql.append("         on  cg.id_stoep  =  stoep.id_stoep ");
		sql.append("     left  join  en_ent  ent ");
		sql.append("         on  ent.id_ent  =  stoep.id_ent ");
		sql.append("     left  join  pi_pat_ca  ca ");
		sql.append("         on  ca.id_patca  =  ent.id_patca ");
		sql.append("     left  join  bd_dep  ordep ");
		sql.append("         on  ordep.id_dep  =  cg.id_dep_or ");
		sql.append("     left  join  bd_dep  mpdep ");
		sql.append("         on  mpdep.id_dep  =  cg.id_dep_mp ");
		sql.append("   where  stoep.id_stoep  =  ? ");

		return sql.toString();
	}

}
