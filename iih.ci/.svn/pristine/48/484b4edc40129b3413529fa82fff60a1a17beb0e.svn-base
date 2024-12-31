package iih.ci.ord.s.ems.op.orderv1.bp.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPresSplitDTOs4ReCoverPresQry implements ITransQry {

	private String _id_emp_sign;
	private String _code_entp;
	private String _id_en;
	
	public GetPresSplitDTOs4ReCoverPresQry(String _id_emp_sign, String code_entp, String id_en) {
		this._id_emp_sign = _id_emp_sign;
		this._code_entp = code_entp;
		this._id_en = id_en;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String sql = "select ORSRV.id_pres,ORSRV.id_orsrv,ORSRV.id_srvtp,ORSRV.sd_srvtp,ORSRV.id_route,ORSRV.id_routedes,ORSRV.id_boil,ORSRV.id_boildes,"
				   + "ORSRV.fg_or,ORSRV.fg_self,ORSRV.fg_base,ORSRV.fg_specill,ORSRV.fg_extdispense,ORSRV.id_dep_mp,ORSRV.id_dep_wh,"
				   //自费标志为N 医保 1，自费标志为Y 非医保 0
	               + "(case WHEN (ORSRV.fg_selfpay='N') then '1' else '0' end) as fg_hp_pres,"
				   
				   + "ORD.id_or,ORD.id_grp,ORD.id_org,ORD.id_pat,ORD.id_en,ORD.id_entp,ORD.code_entp," 
	               + "ORD.fg_bb,ORD.no_bb,ORD.dt_entry,ORD.id_emp_or,ORD.id_dep_or,ORD.fg_vip,"
	               
	               + "ORSRVMM.sd_pharm,ORSRVMM.sd_anti,ORSRVMM.sd_mmtp,ORSRVMM.sd_dosage,ORSRVMM.sd_pois,"
	               + "ORSRVMM.quan_cur,ORSRVMM.price_pgku_cur pri,ORSRVMM.sd_antipsy mental1,"
	               
	               + "SRVDRUG.sd_mmtp,DEP.sd_clinicalprofessiontp,HPKIND.code_hpkind,HPKIND.name_hpkind,"
	               + "'' mental2, '' control , '' ordinary "
	               +",ORD.sd_excessive_reason"

	               + "from ci_or_srv ORSRV "
	               + "left join ci_order ORD on ORSRV.ID_OR=ORD.ID_OR "
	               + "left join ci_or_srv_mm ORSRVMM on ORSRV.id_orsrv=ORSRVMM.id_orsrv "
	               + "left join bd_srv_drug SRVDRUG on SRVDRUG.id_srv=ORSRV.id_srv " 
	               + "left join bd_dep DEP on DEP.id_dep=ORD.id_dep_or "
	               + "left join en_ent_hp ENTHP on ENTHP.fg_maj='Y' and ENTHP.id_ent=ORD.id_en "  
	               + "left join bd_hp_kind HPKIND on ENTHP.id_hpkind=HPKIND.id_hpkind and ORSRV.id_hp=HPKIND.id_hp " 
	               
	               + "where ORSRV.sd_su_mp='" + ICiDictCodeConst.SD_SU_MP_NONE + "' "
	               + "and ORSRV.sd_su_bl='" + ICiDictCodeConst.SD_SU_BL_NONE + "' "
	               + "and ORD.fg_sign='Y' and ORD.fg_canc='N' and ORSRV.fg_self='N' "
	               + "and ORSRV.sd_srvtp like '" + IBdSrvDictCodeConst.SD_SRVTP_DRUG + "%' " 
	               + "and ORD.id_emp_sign='" + this._id_emp_sign + "' "
	               + "and ORSRV.id_en='" +this._id_en+ "' "
	               + "and ORSRV.code_entp='" +this._code_entp + "' ";
			return sql;
	}
}
