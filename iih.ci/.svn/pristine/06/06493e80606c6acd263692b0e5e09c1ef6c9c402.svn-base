package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ciordems.d.OrConfirm;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getCiOrdConfirmQry2 implements ITransQry{
	
	private String id_dep_nur;
	private String sd_su_or;
	private String fg_long;
	private String id_dep_phy;
	private String id_bed;
	private OrConfirm confirm;
	public getCiOrdConfirmQry2(OrConfirm confirm){
		this.id_dep_nur=confirm.getId_dep_nur();
		this.fg_long=confirm.getFg_long()==null?null:(confirm.getFg_long()).toString();
		this.id_dep_phy=confirm.getId_dep_phy();
		this.sd_su_or=confirm.getSd_su_or();
		this.id_bed=confirm.getId_bed();
		this.confirm=confirm;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		param.addParam(this.id_dep_nur);

		if(this.id_dep_phy!=null)
			param.addParam(this.id_dep_phy);
		if(this.id_bed!=null)
			param.addParam(this.id_bed);
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		
		String b="And (";
		if(FBoolean.TRUE.equals(this.confirm.getFg_sign()))
			b+=" (CI_OR .fg_sign ='Y' ) OR";
		if(FBoolean.TRUE.equals(this.confirm.getFg_stop())){
			b+="  (CI_OR .fg_stop = 'Y' And CI_OR .fg_chk_stop ='N' And CI_OR .fg_canc = 'N' And  CI_OR .fg_chk = 'Y') OR";
		}
		if(FBoolean.TRUE.equals(this.confirm.getFg_canc())){
			b+="  (CI_OR .fg_canc = 'Y' And CI_OR .fg_chk_canc ='N') OR";
		}
		
		String str="SELECT EN_ENT_IP.name_bed, "
				+ "EN_ENT_IP.id_bed, "
				+ "EN_ENT.id_ent,"
				+ "EN_ENT.code entcode, ";
		       str+="EN_ENT.code_entp, "
				+ "EN_ENT.id_pat, "
				+ "EN_ENT.name_pat, "
				+ "EN_ENT.sd_sex_pat sd_sex, "
				+ " EN_ENT.dt_birth_pat age_pat, ";
		       str+=" EN_ENT.id_dep_phy, EN_ENT. id_dep_nur,"
				+ "CI_OR. id_or id_confirm, CI_OR.sd_su_or, CI_OR.id_dep_mp,"
				+ "CI_OR .fg_sign,CI_OR .fg_stop,CI_OR .fg_canc,CI_OR .fg_chk, "
				+ "CI_OR .fg_chk_stop,CI_OR .fg_chk_canc, "
				+ "CI_OR.fg_long, CI_OR.id_freq, CI_OR.fg_pres_outp, "
				+ "CI_OR.code_or,"
				+ "BD_DEP.NAME AS NAME_DEP_MP,";
		str+=" CI_OR.content_or, CI_OR.dt_effe,CI_OR.ID_EMP_SIGN id_emp_create,   CI_OR.dt_end,";
		str+=" (select b.NAME  from BD_PSNDOC b where b.ID_PSNDOC=CI_OR.ID_EMP_SIGN) name_emp_sign,(select b.NAME  from BD_PSNDOC b where b.ID_PSNDOC=CI_OR.ID_EMP_STOP) name_emp_stop,"
				+ "(select b.NAME  from BD_PSNDOC b where b.ID_PSNDOC=CI_OR.ID_EMP_CANC) name_emp_canc,";
		str+=" CI_OR.id_emp_stop, CI_OR.dt_canc, CI_OR.id_emp_canc, EN_ENT_HP.id_hp ,";
		str+=" CI_OR.quan_firday_mp ,";
		str+=" bd_freq.freqct ";
		str+=" FROM CI_ORDER CI_OR INNER JOIN EN_ENT ON EN_ENT. id_ent = CI_OR .id_en ";
		str+="  LEFT JOIN EN_ENT_IP ON EN_ENT_IP. id_ent = EN_ENT.id_ent ";
		str+="  LEFT JOIN EN_ENT_HP ON EN_ENT_HP. id_ent = EN_ENT . id_ent AND EN_ENT_HP. fg_maj ='Y' ";
		str+="  left join bd_freq on bd_freq.id_freq=CI_OR.id_freq ";
		str+="  LEFT JOIN BD_DEP ON BD_DEP.ID_DEP=CI_OR.ID_DEP_MP";
		str+="  WHERE EN_ENT. id_dep_nur =? And EN_ENT.fg_ip='Y' and (nvl(ci_or.sd_orsrcfun,'~')='~' or CI_OR.sd_orsrcfun !='2') "
		        + "And EN_ENT.code_entp in ('"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"','"+IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS+"','" + IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE + "') and CI_OR.ds=0 ";
		
		if(FBoolean.TRUE.equals(this.confirm.getFg_sign())||FBoolean.TRUE.equals(this.confirm.getFg_stop())||FBoolean.TRUE.equals(this.confirm.getFg_canc()))
			str+=b.substring(0, b.length()-2)+")";
		if(this.confirm.getId_orderchkca()!=null&&!this.confirm.getId_orderchkca().equals(""))
			str+=" and ("+this.confirm.getId_orderchkca()+") ";

		if(this.id_dep_phy!=null)
			str+=" And EN_ENT. id_dep_phy =? ";
		if(this.id_bed!=null)
			str+=" And EN_ENT_IP . id_bed = ? ";
		
         str+=" order by EN_ENT_IP.name_bed asc,CI_OR.dt_effe asc";
		return str;
	}

}
