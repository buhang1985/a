package iih.bl.hp.bp.Qry;

import iih.bd.base.utils.SqlUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取医嘱适应症诊断依赖信息
 * @author LIM
 *
 */
public class GetCiSrvInDicQry implements ITransQry{
	String id_ent;
	String[] diIds;
	String[] diIdsall;
	public GetCiSrvInDicQry(String id_ent,String[] diIds,String[] diIdsall){
		this.id_ent=id_ent;
		this.diIds=diIds;	
		this.diIdsall=diIdsall;
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
		if(diIdsall!=null){
			for (String diidStr : diIdsall) {
				param.addParam(diidStr);
			}	
		}
		return param;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		sb.append("select distinct didef.Code as Code_di,didef.name as Name_di,csrv.id_or,cor.code_or,csrv.id_orsrv,csrv.id_srv,csrv.name as name_srv,");
		sb.append("cmm.id_orsrvmm,cmm.id_mm as id_ormm,cmm.name_mm as Name_mm,'01' as Eu_dpndrsn, 0 as Fg_delete,");
		sb.append(" '存在适应症医嘱，不能删除该诊断' as Desc_dpndrsn");
		sb.append(" from  ci_or_srv csrv ");
		sb.append(" inner join bd_hp_srvorca hpsrv ON csrv.id_srv = hpsrv.id_srv ");
		sb.append(" inner join bd_hp_srvctr_di ctrdi ON hpsrv.id_srv = ctrdi.id_srv ");
		sb.append(" inner join ci_order cor ON csrv.id_or =cor.id_or ");
		sb.append(" inner join ci_or_srv_mm cmm ON csrv.id_orsrv = cmm.id_orsrv ");
		sb.append(" inner join bd_di_def didef on didef.id_didef =ctrdi.id_di_def  ");
		sb.append(" where csrv.id_en =? And csrv.fg_indic='Y' and cor.fg_canc='N' and nvl(csrv.fg_selfpay,'N')='N' ");
		sb.append(" and csrv.sd_su_bl = '0' and didef.code in('0'");
		//ci_order.fg_canc = 'N' --作废标志：未作废 ci_or_srv.sd_su_bl ！= '2'   --记账状态：已退费
		if(diIds!=null)
			for (String diidStr : diIds) {
				sb.append(",?");
			}
		sb.append(")");
		//排除剩余诊断也包含删除诊断的限制物品
		sb.append(" and ctrdi.code_srv_hp not in (select di.code_srv_hp from bd_hp_srvctr_di di ");
		sb.append(" inner join bd_di_def didef on didef.id_didef =di.id_di_def ");
		sb.append(" where code in('0'");
		if(diIdsall!=null)
			for (String diidStr : diIdsall) {
				sb.append(",?");
			}
		sb.append(") )");
		return sb.toString();
	}
}
