package iih.ci.ord.s.ems.op.orderv1.bp.qry;

import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrderListViewDTO4PresQry implements ITransQry {

	private String id_en;
	private String code_entp;
	private String id_emp_or;
	
	public GetOrderListViewDTO4PresQry(String id_en, String code_entp, String id_emp_or){
		this.id_en = id_en;
		this.code_entp = code_entp;
		this.id_emp_or = id_emp_or;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String strSql = "select ORD.Id_or,"
		        + "ORD.Sd_srvtp,"
				+ "'' as Name_srvtp,"
				+ "ORD.Ord_colligate,"
				+ "ORD.Content_or,"
				
				+ "ORD.Id_su_or,"
				+ "ORD.Sd_su_or,"
				+ "'' as Name_su_or,"
				+ "ORD.Id_su_mp,"
				+ "ORD.Sd_su_mp,"
				+ "ORD.Id_su_bl,"
				+ "ORD.Sd_su_bl,"
				+ "ORD.Id_orrsttp,"
				+ "ORD.Sd_orrsttp,"
				
				+ "ORD.Id_emp_or,"
				+ "'' as Name_emp_or,"
				+ "'' as Doctor,"
				+ "ORD.Id_emp_sign,"
				+ "'' as Name_emp_sign,"
				
				+ "ORD.Fg_skintest,"
				+ "'' as Skintest_result,"
				+ "ORD.Fg_sign," 
				+ "ORD.Fg_stop," 
				+ "'' as Check_result," 
				+ "ORD.Dt_effe,"
				+ "ORD.Eu_hpindicjudge," 
				+ "ORD.Eu_uncporjudge,"
				+ "ORD.Sv " 
				
				+ "from ci_order ORD ";
		String strWhere = String.format(" where ORD.id_en='%s' and ORD.code_entp='%s' and ORD.id_emp_or='%s' "
				+ "and ORD.fg_canc='N' and ORD.fg_pres_outp='N' and ORD.sd_srvtp like '0101%' and ORD.eu_orsrcmdtp!='%s' "
				+ "and (ORD.eu_feereversetp is null or ORD.eu_feereversetp<>1)",
						this.id_en, this.code_entp, this.id_emp_or, OrSourceFromEnum.IIHMEDTECHORDERS);

		return strSql + strWhere;
	}
}
