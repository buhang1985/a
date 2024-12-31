package iih.bl.inc.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 
 * @author tcy
 *
 */
public class CurrentInvoiceNoQry  implements ITransQry {
	private String _id_emp_inc;
	private String _code_incca;
	 public CurrentInvoiceNoQry(){
		 
	 }
	
	 public CurrentInvoiceNoQry(String id_emp_inc,String code_incca){
		 _id_emp_inc = id_emp_inc;
		 _code_incca= code_incca;
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
			return GetInvoiceNoSql();
		}

		
		private String GetInvoiceNoSql(){
			return "SELECT A.INCNO_CUR"+
			 		" FROM BL_INC_ISS A"+
			 		" INNER JOIN BD_INCCA B "+
			 		" ON A.ID_INCCA = B.ID_INCCA "+
			 		" WHERE A.ID_EMP_ISS = ? AND "+
			 		" A.FG_CURUSE = 'Y' AND "+
			 		" B.CODE = ?" ;			
		}

}
