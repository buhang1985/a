package iih.bd.fc.mdwfor.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.fc.wforqry.d.WforQryCondDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;



public class MdwforQry implements ITransQry {
	
	
	private WforQryCondDTO cond;
	
	
	public MdwforQry(WforQryCondDTO cond){
		this.cond=cond;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		
		
		if(!StringUtils.isBlank(cond.getEntp())){
			//患者姓名
			String entp = cond.getEntp();
			String[] sl = entp.split(";");
			StringBuffer sb = new StringBuffer();
			for(String s:sl)
			{
				s = "'" + s +"'," ;
				sb.append(s);
				
			}
			String newStr = sb.toString();
			String para = "(" + newStr.substring(0, newStr.length() - 1) + ")";
			
			rtnParam.addParam(cond.getEntp());

			whereSQL.append("and  t.id_entp in ?");
		}
		
		
		
//		if(cond.getDt_charge_start()!=null){
//			//付款日期开始
//			rtnParam.addParam(cond.getDt_charge_start());
//			whereSQL.append("");
//		}
		 
		return rtnParam;
	}



	 
	@Override
	public String getQrySQLStr() {
		return getQrySQLStr_();
	}
	
	 
	private String getQrySQLStr_(){
		return 
				"SELECT t.*, bd.code dept_code, bd.name dept_name FROM md_wf_or t\n" +
				"LEFT JOIN bd_dep bd\n" + 
				"ON t.id_dept = bd.id_dep" +	       
	        	" where "+getOrgCondStr()
	   ;
	}
	
	
	
	
	/**
	 * 组织串
	 * @return
	 */
	private String getOrgCondStr(){
		return "1=1";//t.id_org='' and t.id_grp='' and
	}
	


}

