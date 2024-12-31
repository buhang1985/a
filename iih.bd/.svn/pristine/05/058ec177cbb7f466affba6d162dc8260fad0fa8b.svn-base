package iih.bd.fc.s.bp.orpltpmatch.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
* @Description:医嘱闭环匹配算法查询   
* @author：zhongcl@founder.com.cn 
* @version 2020年4月2日 上午9:13:22创建  
* @version xuxing_2020年4月18日17:30:38，修正无扩展字段引起药品闭环全部失效问题
*
 */
public class GetOrpltpMatchAttrSql implements ITransQry {

	private String code_entp;
	
	public GetOrpltpMatchAttrSql(String code_entp) {
		super();
		this.code_entp = code_entp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param=new SqlParam();
		param.addParam(code_entp);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql=new StringBuilder();
		sql.append(" SELECT                                                                                                           ");
		sql.append(" a0.ID_ORPLTP_MATCH,                                                                                              ");
		sql.append(" a0.ID_GRP,                                                                                                       ");
		sql.append(" a0.ID_ORG,                                                                                                       ");
		sql.append(" a0.ID_ORPLTP,                                                                                                    ");
		sql.append(" a0.ID_ENTP,                                                                                                      ");
		sql.append(" a0.CODE_ENTP,                                                                                                    ");
		sql.append(" a0.ID_SRVTP,                                                                                                     ");
		sql.append(" a0.SD_SRVTP,                                                                                                     ");
		sql.append(" a0.ID_SRV,                                                                                                       ");
		sql.append(" a0.ID_MP_ROUTE,                                                                                                  ");
		sql.append(" a0.SD_MP_ROUTE,                                                                                                  ");
		sql.append(" route.ctrl1 as code_param,                                                                                       ");
		sql.append(" a0.EU_SKINTEST,                                                                                                  ");
		sql.append(" a0.EU_MP_IN,                                                                                                     ");
		sql.append(" a0.EU_PRES_OUTP,                                                                                                 ");
		sql.append(" a0.EU_FG_BACK,                                                                                                   ");
		sql.append(" a0.EU_WHOLEPACK,                                                                                                 ");
		sql.append(" a0.EU_SRV,                                                                                                       ");
		sql.append(" a0.ID_DEP_REL,                                                                                                   ");
		sql.append(" a0.SD_DEP_REL,                                                                                                   ");
		sql.append(" a0.EU_DEP_OR,                                                                                                    ");
		sql.append(" a0.EU_DEP_PHY,                                                                                                   ");
		sql.append(" a0.EU_DEP_NUR,                                                                                                   ");
		sql.append(" a0.EU_DDM                                                                                                        ");
		sql.append(" FROM bd_orpltp_match a0                                                                                          ");
		sql.append(" inner join bd_orpltp orpltp on orpltp.id_orpltp = a0.id_orpltp                                                   ");
		sql.append(" left join bd_udidoc route on a0.ID_MP_ROUTE = route.id_udidoc  and route.id_udidoclist = '@@@@BZ400000000001EG'  ");
		sql.append(" where 1=1                                                                                                        ");
		sql.append(" and a0.code_entp = ?						                                                                      ");
		sql.append(" and orpltp.fg_active = 'Y'                                                                                       ");
		return sql.toString();
	}

}
