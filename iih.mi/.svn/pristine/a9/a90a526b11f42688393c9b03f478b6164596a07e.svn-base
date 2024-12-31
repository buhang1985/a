package iih.mi.mc.mimcspec.s.bp.qry;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.mi.itf2.util.MiParamUtil;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取特殊病患者该诊断下可开物品信息
 * @author LIM
 * @since 2019-10-10
 */
public class GetSpecPatDrugListQry implements ITransQry{

	String id_ent;
	String id_hp;
	String[] diIds;
	String[] idMms;
	FDateTime dt;
	public GetSpecPatDrugListQry(String id_ent,String id_hp,String[] diIds,String[] idMms){
		this.id_ent=id_ent;
		this.id_hp=id_hp;
		this.diIds=diIds;
		this.idMms=idMms;
		this.dt=AppUtils.getServerDateTime();
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param= new SqlParam();
		param.addParam(this.id_ent);
		param.addParam(this.id_hp);
		param.addParam(this.dt);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		sb.append("select ");
		sb.append(" drug.id_mm,spec.id_didef,spec.id_dsdef ");
		sb.append(" from en_ent_hp enthp");
		sb.append(" inner join MI_MC_SPEC spec on enthp.id_hp=spec.id_hp");
		sb.append(" inner join mi_mc_spec_drug drug on spec.id_hpspec=drug.id_hpspec");
		sb.append("	inner join mi_mc_pat_spec patspec  on patspec.id_hp=enthp.id_hp and  substr(patspec.no_hp,1,9)=substr(enthp.no_hp,1,9) ");
		sb.append(" inner join mi_mc_pat_spec_di specdi on patspec.id_mimcpatspec=specdi.id_mimcpatspec  ");
		int orderMode = MiParamUtil.MHIR0001();// 0：采用病种模式；1:诊断模式
		if (orderMode == 0) {
			// 0：采用病种模式
			sb.append(" and spec.id_dsdef=specdi.id_dsdef ");
		}else{
			sb.append(" and spec.id_didef=specdi.id_didef ");
		}
		sb.append("  where enthp.id_ent=? and spec.id_hp=? and nvl(drug.id_mm,'~')<>'~'");
		sb.append("  and ? between specdi.dt_b and specdi.Dt_e ");
		if(!ArrayUtil.isEmpty(diIds))
			sb.append(SqlUtils.getInSqlByIds(" and spec.id_didef ", diIds));
		if(!ArrayUtil.isEmpty(idMms))
			sb.append(SqlUtils.getInSqlByIds(" and drug.id_mm ", idMms));
		return sb.toString();
	}

}
