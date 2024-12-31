package iih.pe.wardprint.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @Description:检验标本信息获取
 * @author: xu_xing@founder.com.cn
 * @version：2018年8月28日 下午2:09:42 创建
 */
public class GetTestLableSql implements ITransQry {

	String id_papt;

	public GetTestLableSql(String id_papt) {
		this.id_papt = id_papt;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" sam.id_labsamp,                                                         ");
		sqlStr.append(" sam.no_bar,                                                             ");
		sqlStr.append(" sam.name_lab,                                                           ");
		sqlStr.append(" pat.name as name_pat,                                                         ");
		sqlStr.append(" enent.card_pe as name_bed,                                                       ");
		sqlStr.append(" pat.code as code_pat,                                                   ");
		sqlStr.append(" enent.pe_code as code_amr_ip,                                                    ");
		sqlStr.append(" pat.dt_birth as dt_birth_pat,                                                     ");
		sqlStr.append(" docsex.name as name_sex,                                                ");
		sqlStr.append(" docsamtp.name as name_samtp,                                            ");
		sqlStr.append(" docstube.name as name_tubetp,                                           ");
		sqlStr.append(" '普' as name_urgnt,    ");
		sqlStr.append(" sam.quan,                                                               ");
		sqlStr.append(" measdoc.name as name_measdoc,                                           ");
		sqlStr.append(" '体检' as name_dep_phy,                                            ");
		sqlStr.append(" '体检' as name_dep_nur                                             ");
		sqlStr.append(" from pe_apt_labsamp sam                                                 ");
		sqlStr.append(" inner join pe_apt_pepsnappt enent on enent.id_pepsnappt = sam.id_ent                 ");    
		sqlStr.append(" inner join pe_or_pepsnbinfo pat on enent.id_pepsnbinfo = pat.id_pepsnbinfo                     ");  
		sqlStr.append(" left join bd_udidoc docsamtp on docsamtp.id_udidoc = sam.id_labsamptp   ");
		sqlStr.append(" left join bd_udidoc docstube on docstube.id_udidoc = sam.id_tubetp      ");
		sqlStr.append(" left join bd_udidoc docsex on docsex.id_udidoc = pat.id_sex      ");
		sqlStr.append(" left join bd_measdoc measdoc on measdoc.id_measdoc = sam.id_unit_quan   ");
		sqlStr.append(" where                                                  ");
		if(this.id_papt != null){
			sqlStr.append(" sam.id_ent = '" + this.id_papt + "'                             ");
		}else{
			sqlStr.append(" 1 = 2                             ");
		}
		                                            
		return sqlStr.toString();
	}

}
