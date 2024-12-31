package iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.qry;

import iih.bd.base.utils.SqlUtils;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医嘱特殊病诊断依赖信息
 * @author LIM
 *
 */
public class GetCiSrvSpecillQry implements ITransQry{
	String id_ent;
	String id_hp;
	String[] diIds;
	String[] diIdsSur;
	public GetCiSrvSpecillQry(String id_ent,String id_hp,String[] diIds,String[] diIdsSur){
		this.id_ent=id_ent;
		this.id_hp=id_hp;
		this.diIds=diIds;	
		this.diIdsSur=diIdsSur;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();	
		param.addParam(this.id_ent);
		param.addParam(this.id_hp);	
		if(!ArrayUtil.isEmpty(diIdsSur)){
			param.addParam(this.id_hp);	
		}
		return param;		
	}
	@Override
	public String getQrySQLStr() {
		//特殊病要与特殊病患者绑定
		StringBuilder sb= new StringBuilder();
		sb.append("select distinct didef.Code as Code_di,didef.name as Name_di,csrv.id_or,cor.code_or,csrv.id_orsrv,csrv.id_srv,csrv.name as name_srv,");
		sb.append("cmm.id_orsrvmm,cmm.id_mm as id_ormm,cmm.name_mm as Name_mm,'02' as Eu_dpndrsn, 0 as Fg_delete,");
		sb.append(" '存在特殊病医嘱，不能删除该诊断' as Desc_dpndrsn");
		sb.append(" from  ci_or_srv csrv ");
		sb.append(" inner join ci_order cor ON csrv.id_or = cor.id_or  ");
		sb.append(" inner join ci_or_srv_mm cmm ON csrv.id_orsrv = cmm.id_orsrv   ");
		sb.append(" inner join bd_hp_srvorca hpsrv ON csrv.id_srv = hpsrv.id_srv  ");
		sb.append(" inner join MI_MC_SPEC_drug sd ON  cmm.id_mm=sd.id_mm");
		sb.append(" inner join MI_MC_SPEC sp ON sd.id_hpspec = sp.id_hpspec  ");
		sb.append(" inner join bd_di_def didef on didef.code = sp.code_di ");
		
		sb.append(" inner join pi_pat_hp pathp on cor.id_pat=pathp.id_pat  ");
		sb.append("	inner join mi_mc_pat_spec spec  on spec.id_hp=pathp.id_hp and  substr(spec.no_hp,1,9)=substr(pathp.no_hp,1,9)   ");
		sb.append("	inner join mi_mc_pat_spec_di specdi on spec.id_mimcpatspec=specdi.id_mimcpatspec and sp.code_di=specdi.code_di  ");
		sb.append(" where csrv.id_en =? and spec.id_hp=? and cor.fg_canc='N' and nvl(csrv.fg_selfpay,'N')='N'  ");
		sb.append("  and csrv.sd_su_bl = '0' ");
		if(!ArrayUtil.isEmpty(diIds))
			sb.append(SqlUtils.getInSqlByIds(" and sp.id_didef ", diIds));
		// 特殊病有效期内
	//	sb.append(" and specdi.dt_b<'" +AppUtils.getServerDateTime()+"'");
	//	sb.append(" and specdi.dt_e>'" +AppUtils.getServerDateTime()+"'");
		if(!ArrayUtil.isEmpty(diIdsSur)){
			sb.append(" and sd.id_srv||sd.id_mm   not in(  select drug.id_srv||drug.id_mm from MI_MC_SPEC_drug drug  ");
			sb.append(" inner join  MI_MC_SPEC sp  on drug.id_hpspec =sp.id_hpspec "); 
			sb.append(" where sp.id_hp=? ");
			sb.append(SqlUtils.getInSqlByIds(" and code_di ", diIdsSur));
			sb.append(")");
		}
		return sb.toString();
	}
}
