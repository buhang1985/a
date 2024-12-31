package iih.ci.ord.s.external.outqry.bp;

import iih.ci.ord.external.outqry.d.OrdQueryParamDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class OpOrderInfoQry implements ITransQry{
	
	private String[] id_ent;
	private String code_srvca;
	private String sd_srvtp;
	private String dt_b_search;
	private String dt_e_search;
	private String code_or;
	private String code_emp_sign;
	private String code_dep_sign;
	private String fg_sign;
	private String fg_chk;
	private String fg_canc;
	private String sd_su_bl;
	private String code_dep_mp;
	
	public OpOrderInfoQry(String[] id_ent,OrdQueryParamDTO param) {
		this.id_ent=id_ent;
		this.code_srvca=param.getCode_srvca();
		this.sd_srvtp=param.getSd_srvtp();
		this.dt_b_search=param.getDt_b_search();
		this.dt_e_search=param.getDt_e_search();
		this.code_or=param.getCode_or();
		this.code_emp_sign=param.getCode_emp_sign();
		this.code_dep_sign=param.getCode_dep_sign();
		this.fg_sign=param.getFg_sign();
		this.fg_chk=param.getFg_chk();
		this.fg_canc=param.getFg_canc();
		this.sd_su_bl=param.getSd_su_bl();
		this.code_dep_mp=param.getCode_dep_mp();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param=new SqlParam();
		
		for (String s : id_ent) {
			param.addParam(s);			
		}
		if(!CiOutQueryUtils.isStrEmpty(code_srvca)) 
			param.addParam(code_srvca);
		if(!CiOutQueryUtils.isStrEmpty(sd_srvtp)) 
			param.addParam(sd_srvtp+"%");
		if(!CiOutQueryUtils.isStrEmpty(dt_b_search)) 
			param.addParam(dt_b_search);
		if(!CiOutQueryUtils.isStrEmpty(dt_e_search)) 
			param.addParam(dt_e_search);
		if(!CiOutQueryUtils.isStrEmpty(code_or)) 
			param.addParam(code_or);
		if(!CiOutQueryUtils.isStrEmpty(code_emp_sign)) 
			param.addParam(code_emp_sign);
		if(!CiOutQueryUtils.isStrEmpty(code_dep_sign)) 
			param.addParam(code_dep_sign);
		if(!CiOutQueryUtils.isStrEmpty(fg_sign)) 
			param.addParam(fg_sign);
		if(!CiOutQueryUtils.isStrEmpty(fg_chk)) 
			param.addParam(fg_chk);
		if(!CiOutQueryUtils.isStrEmpty(fg_canc)) 
			param.addParam(fg_canc);
		if(!CiOutQueryUtils.isStrEmpty(sd_su_bl)) 
			param.addParam(sd_su_bl);
		if(!CiOutQueryUtils.isStrEmpty(code_dep_mp)) 
			param.addParam(code_dep_mp);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append(CiOutQueryUtils.getOrdInfoBaseSql());
		if(id_ent.length==1) {
			sb.append(" where ci_order.id_en=?  ");
		}else {
			sb.append(" where ci_order.id_en in "+getents());
		}
		sb.append("  and ci_or_srv.fg_or='Y' ");
		if(!CiOutQueryUtils.isStrEmpty(code_srvca)) 
			sb.append(" and bd_srvca.code=? ");
		if(!CiOutQueryUtils.isStrEmpty(sd_srvtp)) 
			sb.append(" and ci_order.sd_srvtp like ? ");
		if(!CiOutQueryUtils.isStrEmpty(dt_b_search)) 
			sb.append(" and ci_order.dt_effe>=? ");
		if(!CiOutQueryUtils.isStrEmpty(dt_e_search)) 
			sb.append(" and ci_order.dt_effe<=? ");
		if(!CiOutQueryUtils.isStrEmpty(code_or)) 
			sb.append(" and ci_order.code_or=? ");
		if(!CiOutQueryUtils.isStrEmpty(code_emp_sign)) 
			sb.append(" and psn2.code=? ");
		if(!CiOutQueryUtils.isStrEmpty(code_dep_sign)) 
			sb.append(" and dep5.code=? ");
		if(!CiOutQueryUtils.isStrEmpty(fg_sign)) 
			sb.append(" and ci_order.fg_sign=? ");
		if(!CiOutQueryUtils.isStrEmpty(fg_chk)) 
			sb.append(" and ci_order.fg_chk=? ");
		if(!CiOutQueryUtils.isStrEmpty(fg_canc)) 
			sb.append(" and ci_order.fg_canc=? ");
		if(!CiOutQueryUtils.isStrEmpty(sd_su_bl)) 
			sb.append(" and ci_order.sd_su_bl=? ");
		if(!CiOutQueryUtils.isStrEmpty(code_dep_mp)) 
			sb.append(" and dep2.code=? ");
		sb.append(" and ci_order.ds=0 ");
		return sb.toString();
	}
	
	private String getents() {
		StringBuilder sb=new StringBuilder();
		sb.append(" (");
		for (String s : id_ent) {
			sb.append("?,");			
		}
		String s=sb.toString();
		int i=s.lastIndexOf(",");
		return s.substring(0, i)+")";
	}

}
