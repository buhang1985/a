package iih.bd.srv.s.bp.qry;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SrvRtCtlInfoNQry implements ITransQry {
	private SrvRtCtlParam _rtctlparam;
	
	public SrvRtCtlInfoNQry(SrvRtCtlParam rtctlparam){
		this._rtctlparam=rtctlparam;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam param = new SqlParam();
		if(isSingleIdV()){
			param.addParam(_rtctlparam.getId_srvs());
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		String orgsqlrt=BdEnvContextUtil.processEnvContext(new MedSrvDO(), "AA");
		String orgsqlrtitm=BdEnvContextUtil.processEnvContext(new MedSrvDO(), "CC");
		
		String sql= "select EE.Ctrl5, BB.Id_Srvrtca, AA.Id_Srvrt, AA.Code, AA.Name, '' as id_srv,'' as id_mm, AA.Rules, BB.Fg_Ructr, BB.Eu_Rtlimit "
				+ "from bd_srv_rt AA "
				+ " left outer join bd_srv_rtca BB ON AA.Id_Srvrtca=BB.ID_SRVRTCA "
				+ " left outer join bd_udidoc EE ON EE.Id_udidoc=BB.Id_srvrttp "
				+ " where AA.Fg_Use_"+getEnttpFgField(_rtctlparam.getId_entp())+"='Y' and BB.Fg_Ructr='Y' and "+orgsqlrt
				+ " union all "
				+ " select DD.Ctrl5, DD.ID_SRVRTCA, DD.Id_Srvrt, DD.Code, DD.Name, CC.Id_Srv, CC.Id_mm, '1=1' as Rules, DD.Fg_Ructr, DD.Eu_Rtlimit "
				+ " from bd_srv_rt_itm CC "
				+ " left outer join (select FF.Ctrl5, GG.ID_SRVRTCA,GG.Fg_Ructr,GG.Eu_Rtlimit,HH.Id_Srvrt,HH.Id_Grp,HH.Id_Org,HH.Code,HH.Name,HH.Fg_Use_"+getEnttpFgField(_rtctlparam.getId_entp())
				+ " from bd_srv_rt HH left outer join bd_srv_rtca GG ON HH.Id_Srvrtca=GG.Id_Srvrtca "
				+ " left outer join bd_udidoc FF ON FF.Id_udidoc=GG.Id_srvrttp "
				+ " where HH.Fg_Use_"+getEnttpFgField(_rtctlparam.getId_entp())+"='Y' and GG.Fg_Ructr='N') DD ON CC.Id_Srvrt=DD.Id_Srvrt "
				+ " where CC.Id_Srv "+getIdSrvSqlStr()+" and "+orgsqlrtitm
		  		+ " and DD.Fg_Use_"+getEnttpFgField(_rtctlparam.getId_entp())+"='Y' order by Id_Srvrtca,Code";
		
		return sql;
	}
	
	private String getIdSrvSqlStr(){
		if(isSingleIdV())return BdSrvUtils.EQUAL_STR+BdSrvUtils.QUESTION_STR;
		String id_srvs=_rtctlparam.getId_srvs();
		return BdSrvUtils.getIdsSqlStrWithInStr(id_srvs);
	}

	/**
	 * 是否单ID值
	 * @return
	 */
	private boolean isSingleIdV(){
		String id_srvs=_rtctlparam.getId_srvs();
		if(BdSrvUtils.isEmpty(id_srvs) || !BdSrvUtils.isInStr(id_srvs,BdSrvUtils.COMMA_STR))return true;
		return false;

	}
	
	private String getEnttpFgField(String entp){
		return BdSrvUtils.getEntpFldNameStr8Id(entp);
	}
}
