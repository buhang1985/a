package iih.bd.srv.s.bp.qry;

import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 医生站医疗服务选择时，医疗单匹配查询条件
 */
public class MedSrvMatchEmsQry implements ITransQry {
	private SrvMatchEmsParamDTO _param;
	
	/**
	 * 构造函数
	 * @param param
	 */
	public MedSrvMatchEmsQry(SrvMatchEmsParamDTO param){
		_param=param;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
//		param.addParam(_param.getId_grp());
//		param.addParam(_param.getId_org());
//		param.addParam(_param.getId_org());
		param.addParam(_param.getId_dept());
		param.addParam(_param.getEmsappmode());
		param.addParam(_param.getDt_or());
		param.addParam(_param.getDt_or());
		return param;
	}

	@Override
	public String getQrySQLStr() {
		String orgsql=BdEnvContextUtil.processEnvContext(new EmsDO(), "A");
		String str= " select A.Id_Srvof as id_ems,A.NAME_SHOW,A.Funclassstr as funcclassstr,A.Id_Dept,B.Eu_Direct,B.Id_Srv,B.Sd_Srvtp,A.Dt_Effe,B.Eu_Ofreftp,A.fg_quickwflow "
			  +" from bd_srv_of A  "
			  +" inner join bd_srv_of_rel B on A.Id_Srvof=B.Id_Srvof "
			  +" where  (("+orgsql    //li_cheng  加上管控模式
			 +" and A.Id_Dept='~') or ("+orgsql+" and A.Id_Dept = ?) )"
			  +" and A.Eu_Emsappmode=? and A.Fg_Entp_"+getEntpFldNameStr()+"='Y'  and A.Fg_Active='Y'  "
			  +" and (A.Dt_Effe<=? and A.Dt_End>=?) "
			  +" order by id_dept asc,dt_effe desc ,id_ems,eu_direct desc,id_srv ";
		
//			  +" where A.Id_Grp=? and "
//			  +" ((A.Id_Org=? and A.Id_Dept='~') or (A.Id_Org=? and A.Id_Dept=?)) "
//			  +" and A.Eu_Emsappmode=? and A.Fg_Entp_"+getEntpFldNameStr()+"='Y'  and A.Fg_Active='Y'  "
//			  +" and (A.Dt_Effe<=? and A.Dt_End>=?) "
//			  +" order by id_dept asc,dt_effe desc ,id_ems,eu_direct desc,id_srv ";

			//--科室优先  时间最近优先";
		return str;
	}
	
	/**
	 * 获得就诊类型对应的字段名
	 */
	private String getEntpFldNameStr(){
		String entp=_param.getCode_entp();
		return BdSrvUtils.getEntpFldNameStr(entp);
	}

}
