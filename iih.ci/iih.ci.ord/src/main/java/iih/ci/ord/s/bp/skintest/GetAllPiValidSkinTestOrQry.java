package iih.ci.ord.s.bp.skintest;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获得有效皮试医嘱数据信息查询
 */
public class GetAllPiValidSkinTestOrQry implements ITransQry {
	private String _id_pi;
	private FDateTime[] _dt_section; 
	
	/**
	 * 构造函数
	 * @param id_pi
	 * @param dt_section
	 */
	public GetAllPiValidSkinTestOrQry(String id_pi,FDateTime[] dt_section){
		_id_pi=id_pi;
		_dt_section=dt_section; 
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam  sqlParam = new SqlParam();
		sqlParam.addParam(_id_pi);
		sqlParam.addParam(_dt_section[0]);
		sqlParam.addParam(_dt_section[1]);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return " select A.id_or,A.Id_srv,C.Sd_Rst_Skintest,C.dt_create as dt_skintest,A.name_or,A.code_or,A.dt_effe,mm.id_mm,"
			  +" c.id_emp_create,p.name as name_emp_create "
			  +" from ci_order A "
              +" left outer join ci_skin_test C ON A.id_or=C.Id_Or "
			  +" left join bd_psndoc p on p.id_psndoc=c.id_emp_create"
              +" left join ci_or_srv srv on srv.id_or=A.id_or and srv.id_srv = A.id_srv"
			  +" left join ci_or_srv_mm mm on mm.id_orsrv = srv.id_orsrv"
              //+" where A.Id_Pat=? and A.Sd_Srvtp = '"+IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST+"'  And A.Fg_Canc='N' "
              //药品也可以作为皮试医嘱
              +" where A.Id_Pat=? and A.fg_skintest='Y'  And A.Fg_Canc='N' "
              +" and A.dt_effe>=? and A.Dt_Effe<=? "
              +" and (A.Sd_Su_Mp ='1' or A.sd_su_mp='20') and A.fg_canc='N' and A.sd_su_bl !=2 order by A.Dt_Effe desc";
              //+" and A.Id_Srv=? and A.Sd_Su_Mp in ('0','1') order by A.Dt_Effe desc";
	}

}
