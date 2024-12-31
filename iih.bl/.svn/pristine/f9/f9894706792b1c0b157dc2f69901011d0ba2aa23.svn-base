package iih.bl.hp.bp.Qry;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取医嘱特殊病诊断依赖信息
 * @author LIM
 *
 */
public class GetCiSrvSpecillQry implements ITransQry {
	String id_ent;
	String[] diIds;
	String[] diIdsAll;
	public GetCiSrvSpecillQry(String id_ent,String[] diIds,String[] diIdsAll){
		this.id_ent=id_ent;
		this.diIds=diIds;	
		this.diIdsAll=diIdsAll;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();	
		if (this.id_ent != null && this.id_ent != "") {
			param.addParam(this.id_ent);
		}
		//删除诊断编码
		if(diIds!=null){
			for (String diidStr : diIds) {
				param.addParam(diidStr);
			}	
		}
		//删除后剩余诊断编码
		if(diIdsAll!=null){
			for (String diidStr : diIdsAll) {
				param.addParam(diidStr);
			}	
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
		sb.append(" inner join bd_hp_srvorca hpsrv ON csrv.id_srv = hpsrv.id_srv ");
		sb.append(" inner join bd_hp_spec_drug sd ON hpsrv.code = sd.code_hp ");
		sb.append(" inner join bd_hp_spec sp ON sd.id_hpspec = sp.id_hpspec ");
		sb.append(" inner join ci_order cor ON csrv.id_or = cor.id_or ");
		sb.append(" inner join ci_or_srv_mm cmm ON csrv.id_orsrv = cmm.id_orsrv ");
		sb.append("  inner join bd_di_def didef on didef.code = sp.code_di ");
		sb.append(" inner join pi_pat_hp pathp on cor.id_pat=pathp.id_pat ");
		sb.append("	inner join bl_hp_pat_spec spec  on spec.id_hp=pathp.id_hp and spec.no_hp=pathp.no_hp ");
		sb.append("	inner join bl_hp_pat_spec_di specdi on spec.id_hppatspec=specdi.id_hppatspec and sp.code_di=specdi.code_di ");
		sb.append(" where csrv.id_en =?  and cor.fg_canc='N' and nvl(csrv.fg_selfpay,'N')='N'  ");
		sb.append("  and csrv.sd_su_bl = '0' and sp.code_di in('0'");
		//不加此条件 And csrv.fg_specill='Y' 特殊病服务只有在签署后才改变状态，所以不加次判断 
		//ci_order.fg_canc = 'N' --作废标志：未作废 ci_or_srv.sd_su_bl ！= '2'   --记账状态：已退费
		if(diIds!=null)
			for (String diidStr : diIds) {
				sb.append(",?");
			}
		sb.append(")");
		// 特殊病有效期内
	//	sb.append(" and specdi.dt_b<'" +AppUtils.getServerDateTime()+"'");
	//	sb.append(" and specdi.dt_e>'" +AppUtils.getServerDateTime()+"'");
		sb.append(" and sd.code_hp  not in( select code_hp from bd_hp_spec_drug drug ");
		sb.append(" inner join  bd_hp_spec sp  on drug.id_hpspec =sp.id_hpspec"); 
		sb.append(" where code_di in('0'");
		if(diIdsAll!=null)
			for (String diidStr : diIdsAll) {
				sb.append(",?");
			}
		sb.append("))");
		return sb.toString();
	}
}
