package iih.bl.cg.bp.ip.qry;

import xap.lui.core.xml.StringUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取住院医嘱的记账信息
 * @author liwenqiang 2017年12月6日 16:58:15
 *
 */
public class GetIpCgListByOrIdQry implements ITransQry {

	String orId;
	String entId;
	String srvId;
	String idHp;
	public GetIpCgListByOrIdQry(String orId,String entId,String srvId,String idHp) {
		this.orId = orId;
		this.entId=entId;
		this.srvId=srvId;
		this.idHp = idHp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(orId);
		param.addParam(entId);
	
		if(!StringUtils.isEmpty(srvId))
			param.addParam(srvId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  ");
		sql.append("CGIP.ID_CGIP id_cgip, ");
		sql.append("CGIP.DT_CG dt_cg, ");
		sql.append("CGIP.NAME_SRV name_srv, ");
		sql.append("CGIP.NAME_MM name_mm, ");
		sql.append("CGIP.SPEC spec, ");
		sql.append("CGIP.price_ratio price_ratio, ");
		sql.append("CGIP.QUAN*CGIP.EU_DIRECT quan_mend, ");
		sql.append("CGIP.amt_ratio*CGIP.EU_DIRECT amt_ratio, ");
		sql.append("dep.name name_dep_mp, ");
		sql.append("decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','3','丙类','未对应') sd_hpsrvtp, ");
		sql.append("psndoc.NAME name_emp_cg ");
		sql.append(" FROM  ");
		sql.append("BL_CG_IP CGIP ");
		sql.append("LEFT JOIN	BL_ST_IP stip ON stip.id_stip=cgip.id_stip ");
		sql.append("LEFT JOIN BD_PSNDOC psndoc ON CGIP.id_emp_cg=PSNDOC.ID_PSNDOC ");
		sql.append("LEFT JOIN BD_DEP dep ON CGIP.id_dep_mp=dep.id_dep ");
		sql.append("left join bd_hp_srvorca  hpsrv on  ((cgip.id_srv = hpsrv.id_srv and cgip.fg_mm='N') or (cgip.id_mm = hpsrv.id_mm and cgip.fg_mm = 'Y')) ");
		sql.append(" and hpsrv.id_hp = '").append(this.idHp).append("' ");
		sql.append("WHERE CGIP.ID_OR=?  ");
		sql.append(" and cgip.fg_real = 'Y' ");
		sql.append(" and ( CGIP.Id_ent=? ");

		sql.append(" ) ");
		if(!StringUtils.isEmpty(srvId))
			sql.append(" and cgip.id_srv = ? ");
		sql.append("AND NVL(stip.FG_CANC, 'N')='N' ");
		sql.append(" AND NVL(STIP.EU_DIRECT, '1')='1' ");
		sql.append(" ORDER BY CGIP.DT_CG desc ");
		return sql.toString();
	}
}
