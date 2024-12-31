package iih.bl.inc.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 后移票据号
 * @author tcy
 *
 */
public class NextInvoiceNoUpdateCurNo implements ITransQry {

	private String _id_emp_inc;
	private String _code_incca;
	
	public NextInvoiceNoUpdateCurNo(){
		 
	 }
	
	 public NextInvoiceNoUpdateCurNo(String id_emp_inc,String id_incca){
		 _id_emp_inc = id_emp_inc;
		 _code_incca= id_incca;
		}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id_emp_inc); //操作员ID
		rtnParam.addParam(_code_incca);   //票据类型
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return GetNextInvoiceNoUpdateCurNo();
	}
	
	private String GetNextInvoiceNoUpdateCurNo(){
		
		return  " Update BL_INC_ISS "+
				"  set INCNO_CUR = INCNO_CUR + 1 "+
				"  WHERE ID_EMP_ISS = ? "+
				"  AND BL_INC_ISS.ID_INCCA = "+
				"  (select x.id_incca from bd_incca x where x.code = ?) "+
				"  AND FG_CURUSE = 'Y'";
	
	}

}
