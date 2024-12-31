package iih.bl.cg.s.bp.qry;

import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;
/**
 * 通过查询方案查询出患者信息（一日费用清单（住院处））
 * 
 * @author shaokx
 * @since 2018年7月2日
 */
public class GetIpDayFeeDetailQry implements ITransQry{

    private String whereStr;
	
	public GetIpDayFeeDetailQry(String whereStr){
		this.whereStr = whereStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
//		if(!StringUtil.isEmpty(this.whereStr)){
//			param.addParam(this.whereStr);
//		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" ent.id_ent, ");
		sql.append(" entip.id_bed, ");
		sql.append(" entip.name_bed, ");
		sql.append(" pat.id_pat, ");
		sql.append(" pat.name as name_pat, ");
		sql.append(" entip.code_amr_ip, ");
		sql.append(" ent.dt_acpt, ");
		sql.append(" ent.dt_end, ");
		sql.append(" ent.DT_Entry ");
		sql.append(" from en_ent ent ");
		sql.append(" inner join en_ent_ip entip ");
		sql.append(" on ent.id_ent = entip.id_ent ");
		sql.append(" inner join pi_pat pat ");
		sql.append(" on pat.id_pat = ent.id_pat ");
		sql.append(" where ");
		if(!StringUtil.isEmpty(this.whereStr)){
			sql.append(this.whereStr);
		}else{
			//如果查询条件为空。默认查住院患者信息 by lim 2018-08-05
			sql.append(" ent.fg_ip='Y'");
		}
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new PatiVisitDO(), "ent");//增加组织隔离
		sql.append(sqlContext);
		return sql.toString();
	}
	
	
	
	
	
}
