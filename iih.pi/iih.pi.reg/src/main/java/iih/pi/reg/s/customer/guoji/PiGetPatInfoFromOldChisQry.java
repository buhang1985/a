package iih.pi.reg.s.customer.guoji;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 从老chis获取患者信息查询类
 * @author ly 2017/04/26
 *
 */
public class PiGetPatInfoFromOldChisQry implements ITransQry{

	private String codePat;
	private boolean isIdentity;
	
	public PiGetPatInfoFromOldChisQry(String codePat,boolean isIdentity){
		this.codePat = codePat;
		this.isIdentity = isIdentity;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		if(this.isIdentity){
			param.addParam(codePat);
		}else{
			param.addParam(codePat);
			param.addParam(codePat);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
/*		sqlSb.append("select ");
		sqlSb.append("patient_id,");//患者编码
		sqlSb.append("p_bar_code,");//条码号
		sqlSb.append("name,");//姓名
		sqlSb.append("sex,");//性别
		sqlSb.append("birthday,");//生日
		sqlSb.append("social_no,");//身份证号
		sqlSb.append("response_type,");//身份
		sqlSb.append("home_district,");//家庭区县
		sqlSb.append("home_street,");//家庭街道
		sqlSb.append("home_tel,");//家庭电话
		sqlSb.append("home_zipcode,");//家庭邮编
		//sqlSb.append("dentify_flag, ");//实名认证标志
		sqlSb.append("marry_code,");//婚姻代码
		sqlSb.append("max_times ");//最后就诊次数
		sqlSb.append("lv_data ");//最后就诊日期
*/		//TODO
		sqlSb.append("select * ");
		sqlSb.append("from  view_mz_patient_mi_iih ");
		if(this.isIdentity){
			//身份证查询
			sqlSb.append("where social_no = ? ");
			sqlSb.append("and (black_flag = '01' or black_flag = '1') ");
		}else{
			sqlSb.append("where p_bar_code = ? "
					+ "or patient_id = ? ");
		}
		
		sqlSb.append(" order by max_times desc,lv_data desc ");
		
		return sqlSb.toString();
	}
}
