package iih.ci.ord.s.ems.op.orderv1.bp.qry;

import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrderListViewDTOQry implements ITransQry {

	private String id_en;
	private String code_entp;
	private String orderbyMode;
	
	public GetOrderListViewDTOQry(String id_en, String code_entp, String orderbyMode){
		this.id_en = id_en;
		this.code_entp = code_entp;
		this.orderbyMode = orderbyMode;
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
				+ "'' as Ord_colligate,"
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
				+ "PSNOR.Name as Name_emp_or,"
				+ "PSNOR.Name as Doctor,"
				+ "ORD.Id_emp_sign,"
				+ "PSNSIGN.Name as Name_emp_sign,"
				
				+ "ORD.Fg_skintest,"
				+ "'' as Skintest_result,"
				+ "ORD.Fg_sign," 
				+ "ORD.Fg_stop," 
				+ "'' as Check_result," 
				+ "ORD.Dt_effe,"
				+ "ORD.Eu_hpindicjudge," 
				+ "ORD.Eu_uncporjudge,"
				+ "ORD.Sv " 
				
				+ "from ci_order ORD "
				+ "left join bd_psndoc PSNOR on PSNOR.Id_psndoc=ORD.Id_emp_or "
				+ "left join bd_psndoc PSNSIGN on PSNSIGN.Id_psndoc=ORD.Id_emp_sign ";
		String strWhere = String.format(" where ORD.id_en='%s' and ORD.code_entp='%s' and ORD.fg_canc='N' and ORD.fg_pres_outp='N' and ORD.eu_orsrcmdtp!='%s' and (ORD.eu_feereversetp is null or ORD.eu_feereversetp<>1)",
						this.id_en, this.code_entp, OrSourceFromEnum.IIHMEDTECHORDERS);
		String strOrderby = " order by ORD.createdtime " + this.orderbyMode;

		return strSql + strWhere + strOrderby;
	}

}
