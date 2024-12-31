package iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.qry;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取医嘱适应症诊断依赖信息
 * @author LIM
 *
 */
public class GetCiSrvInDicQry implements ITransQry{
	String id_ent;
	String id_hp;
	String[] diIds;
	String[] diIdsall;
	String entType;
	public GetCiSrvInDicQry(String id_ent,String id_hp,String[] diIds,String[] diIdsall,String entType){
		this.id_ent=id_ent;
		this.id_hp=id_hp;
		this.diIds=diIds;	
		this.diIdsall=diIdsall;
		this.entType=entType;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();	
		param.addParam(this.id_ent);
		param.addParam(this.id_hp);
		if(!ArrayUtil.isEmpty(diIdsall))
		param.addParam(this.id_hp);
		return param;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		sb.append("select distinct didef.Code as Code_di,didef.name as Name_di,csrv.id_or,cor.code_or,csrv.id_orsrv,csrv.id_srv,csrv.name as name_srv,");
		sb.append("cmm.id_orsrvmm,cmm.id_mm as id_ormm,cmm.name_mm as Name_mm,'01' as Eu_dpndrsn, 0 as Fg_delete,");
		sb.append(" '存在适应症医嘱，不能删除该诊断' as Desc_dpndrsn");
		sb.append(" from  ci_or_srv csrv ");
		sb.append(" inner join bd_hp_srvorca hpsrv ON csrv.id_srv = hpsrv.id_srv  and hpsrv.id_hp=csrv.id_hp");
		sb.append(" inner join bd_hp_srvctr_di ctrdi ON hpsrv.id_srv = ctrdi.id_srv and hpsrv.id_hp=ctrdi.id_hp ");
		sb.append(" inner join ci_order cor ON csrv.id_or =cor.id_or ");
		sb.append(" inner join ci_or_srv_mm cmm ON csrv.id_orsrv = cmm.id_orsrv ");
		sb.append(" inner join bd_di_def didef on didef.id_didef =ctrdi.id_di_def  ");
		sb.append(" where csrv.id_en =? and hpsrv.id_hp=?  and nvl(csrv.fg_selfpay,'N')='N' ");
		//住院或者急诊留观
		if(entType.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP) || entType.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)){
			sb.append(" and cor.fg_chk_canc='N' ");
		}else{
			//门诊
			sb.append(" and cor.fg_canc='N' ");
		}
		sb.append(" and csrv.sd_su_bl = '0'");
		sb.append(SqlUtils.getInSqlByIds(" and didef.id_didef ", diIds));
		//排除剩余诊断也包含删除诊断的限制物品
		if(!ArrayUtil.isEmpty(diIdsall))
		{
			sb.append(" and ctrdi.id_srv not in (select di.id_srv from bd_hp_srvctr_di di ");
			sb.append(" inner join bd_di_def didef on didef.id_didef =di.id_di_def ");
			sb.append(" where di.id_hp=? ");
		    sb.append(SqlUtils.getInSqlByIds(" and di.id_di_def ", diIdsall));
		    sb.append(")");
		}
		return sb.toString();
	}
}