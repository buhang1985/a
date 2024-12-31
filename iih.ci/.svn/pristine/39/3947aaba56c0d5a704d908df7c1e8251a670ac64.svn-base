package iih.ci.ord.s.external.provide.bp.partner.qry;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.external.provide.meta.partner.IpOrderAmountParamDTO;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 患者历史医嘱数量查询
 * @author zhangwq
 *
 */
public class GetIpOrdersAmount8EnQry implements ITransQry {
	//患者历史医嘱数量查询入参dto
	private IpOrderAmountParamDTO param;
	public GetIpOrdersAmount8EnQry(IpOrderAmountParamDTO param){
		this.param = param;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if(!StringUtils.isEmpty(this.param.getCode_entp())){
			sqlParam.addParam(this.param.getCode_entp());
		}
		if(!StringUtils.isEmpty(this.param.getCode_pat())){
			sqlParam.addParam(this.param.getCode_pat());
		}
		if(this.param.getTimes_ip()!=null){
			sqlParam.addParam(this.param.getTimes_ip());
		}
		if(!StringUtils.isEmpty(this.param.getCode_srvca())){
			sqlParam.addParam(this.param.getCode_srvca());
		}
		if(!StringUtils.isEmpty(this.param.getCode_srvca_ext())){
			sqlParam.addParam("ip_"+this.param.getCode_srvca_ext());
		}
		if(!StringUtils.isEmpty(this.param.getCode_dep_nur_or())){
			sqlParam.addParam(this.param.getCode_dep_nur_or());
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append("select pat.code as code_pat,entip.times_ip,ent.code as code_en,entip.code_amr_ip,depnur.code as code_dep_nur_or,count(*) hisnum_or ");
		sb.append("from en_ent ent left join en_ent_ip entip on ent.id_ent = entip.id_ent ");
		sb.append("left join pi_pat pat on pat.id_pat=ent.id_pat ");
		sb.append("left join bd_dep depnur on depnur.id_dep = entip.id_dep_nuradm ");
		sb.append("left join ci_order ci on ci.id_pat = pat.id_pat ");
		sb.append("left join bd_srvca srvca on ci.id_srvca = srvca.id_srvca ");
		sb.append("where ci.fg_chk_canc='N' and ci.fg_sign='Y' ");
		sb.append(getOrgGroupFilter("ent"));
		if(!StringUtils.isEmpty(this.param.getCode_entp())){
			sb.append(" and ent.code_entp=?" );
		}
		if(!StringUtils.isEmpty(this.param.getCode_pat())){
			sb.append(" and pat.code=? " );
		}
		if(this.param.getTimes_ip()!=null){
			sb.append(" and entip.times_ip=? " );
		}
		if(!StringUtils.isEmpty(this.param.getCode_srvca())){
			sb.append(" and srvca.code=? " );
		}
		if(!StringUtils.isEmpty(this.param.getCode_srvca_ext())){
			sb.append(" and srvca.code=? " );
		}
		if(!StringUtils.isEmpty(this.param.getCode_dep_nur_or())){
			sb.append(" and depnur.code=? " );
		}
		sb.append(" group by pat.code,entip.times_ip,ent.code,entip.code_amr_ip,depnur.code ");
		return sb.toString();
	}
	public String getOrgGroupFilter(String className){
		return " and "+className+".id_org='"+Context.get().getOrgId()+"' and "+className+".id_grp='"+Context.get().getGroupId()+"' ";
	}
}
