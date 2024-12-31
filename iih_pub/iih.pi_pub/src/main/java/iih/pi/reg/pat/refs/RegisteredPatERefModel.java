package iih.pi.reg.pat.refs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: RegisteredPatERefModel  
* @Description: 注册患者参照
* @author xy.zhou
* @date 2019年3月21日
 */
public class RegisteredPatERefModel extends RefGridModel{


	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{"code_pat","name_pat","name_sex","mob"};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"患者编码","姓名","性别","移动电话"};
	}
	
	@Override
	public String getPkFieldCode() {
		return "id_pat";
	}
	
	@Override
	public String getRefCodeField() {
		return "code_pat";
	}
	
	@Override
	public String getRefNameField() {
		return "name_pat";
	}
	
	@Override
	public String getTableName() {
		return "pi_pat";
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"id_pat"};
	}
	
	@Override
	public String getRefSql() {
		String cond = getPrintCond();
		String sql = getAddSql(cond);
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("       pat.code as code_pat, ");
		sqlSb.append("       pat.name  as name_pat, ");
		sqlSb.append("       doc1.name as name_sex, ");
		sqlSb.append("       pat.mob, ");
		sqlSb.append("       pat.id_pat  ");
		sqlSb.append("  from pi_pat pat ");
		sqlSb.append("  left join bd_udidoc doc1 ");
		sqlSb.append("    on doc1.id_udidoc = pat.id_sex ");
		sqlSb.append(sql);
		
		return sqlSb.toString();
	}
	
	private String getPrintCond(){
		SqlParam param = this.getParam();
		int countParams = param.getCountParams();
		String print=null;
		if(countParams>0){
			String param0 = (String)param.get(0);
			print = param0.replaceAll("%","");
			param.clearParams();
			return print;
		}
		return null;
	}
	private String getAddSql(String cond){
		if(StringUtil.isEmpty(cond)){
			return " where 1=2 ";
		}else{
			
//			Pattern compile = Pattern.compile("[0-9]*");
//			Matcher isNum  = compile.matcher(cond);
//			if(isNum.matches()){//如果是数字
//				return"where pat.code='"+cond+"' ";
//			}
//			
//			String pattern = "[\u4e00-\u9fa5]+";
//			boolean isMatch =  Pattern.matches(pattern, cond);
//			if(isMatch){//如果是中文
//				if(cond.length()>1){//默认输入两个字才查询（数据量级太大）
//					return" where pat.name like '%"+cond+"%' ";
//				}
//			}
			if(cond.length()<7){//数据量级过大，只查询六位以上
				return " where 1=1 and pat.name like '%"+cond+"%'";
			}
			return " where 1=1 and pat.name like '%"+cond+"%' or pat.code like '%"+cond+"%' or pat.id_code like '%"+cond+"%' ";
			
		}
	}
}	
