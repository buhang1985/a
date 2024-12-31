package iih.ci.mrm.s.mrfpmanage.bp;

import iih.ci.mrfp.cimrfpquickfinddo.d.CiMrFpQuickFindDO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class MrfpManageQryBP extends PagingServiceImpl<CiMrFpQuickFindDO>{
	/**
	 * 住院病案首页查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CiMrFpQuickFindDO> getMrfpSearchList(QryRootNodeDTO qRNode, PaginationInfo pInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "";
 		
 		if (qRNode!=null) {
 			sqlwhere += service.getQueryStringWithoutDesc(qRNode);
 		}
 		// 用于封装总查询条件
 		List<String> sqlList = new ArrayList<String>();
 		// 用于临时封装手术相关的查询条件
 		List<String> sugSqlList = new ArrayList<String>();
 		// 用于临时封装西医诊断相关的查询条件
 		List<String> xydiSqlList = new ArrayList<String>();
 		// 用于临时封装中医诊断相关的查询条件
 		List<String> zydiSqlList = new ArrayList<String>();
 		
 		String[] sugArr = {"qf.col0318", "qf.col0340", "qf.col0362", "qf.col0384", "qf.col0406", "qf.col0428", "qf.col0450", "qf.col0472"};
 		String[] xydiArr = {"qf.col0509", "qf.col0519", "qf.col0529", "qf.col0539", "qf.col0549", "qf.col0559", "qf.col0569", "qf.col0579", "qf.col0589", "qf.col0599", "qf.col0609"};
 		String[] zydiArr = {"qf.col0630", "qf.col0641", "qf.col0652", "qf.col0663", "qf.col0674", "qf.col0685", "qf.col0696", "qf.col0707", "qf.col0718", "qf.col0729", "qf.col0740"};
 		
 		if (!"".equals(sqlwhere) && sqlwhere != null) {
 			// 去除查询方案生成的SQL两边的括号
 			sqlwhere = sqlwhere.substring(1, sqlwhere.length() - 1);
 			// 将各个查询条件转换为数组
 	 		String[] sqlWhereArr = sqlwhere.split("AND");
 	 		// 分隔符，如果有多个手术或者诊断的查询条件时，用于分隔并单独拼接各个查询SQL
 	 		String breakMark = "-";
 	 		
 	 		for (String sqlWhereStr : sqlWhereArr) {
				// 分开字段名与值
 	 			String[] strs = sqlWhereStr.split("=");
 	 			
 	 			if (ArrayUtils.contains(sugArr, strs[0].trim())) {// 匹配手术相关的查询条件
 	 				// 封装手术相关的查询条件
 	 				for (String sugStr : sugArr) {
						sugSqlList.add(sugStr + " = " + strs[1].trim());
					}
 	 				sugSqlList.add(breakMark);
 	 			} else if (ArrayUtils.contains(xydiArr, strs[0].trim())) {// 匹配西医诊断相关的查询条件
 	 				// 封装西医诊断相关的查询条件
 	 				for (String xydiStr : xydiArr) {
 	 					xydiSqlList.add(xydiStr + " = " + strs[1].trim());
					}
 	 				xydiSqlList.add(breakMark);
 	 			} else if (ArrayUtils.contains(zydiArr, strs[0].trim())) {// 匹配中医诊断相关的查询条件
 	 				// 封装中医诊断相关的查询条件
 	 				for (String zydiStr : zydiArr) {
 	 					zydiSqlList.add(zydiStr + " = " + strs[1].trim());
					}
 	 				zydiSqlList.add(breakMark);
 	 			} else {
 	 				sqlList.add(sqlWhereStr);
 	 			}
			}
 		}
 		// 用于拼接查询方案修改后的查询条件语句
 		StringBuilder sqlWhereSb = new StringBuilder();
 		
 		for (String sql : sqlList) {
 			sqlWhereSb.append(sql);
 			sqlWhereSb.append(" and ");
		}
 		
 		if (sugSqlList.size() > 0) {
 			sqlWhereSb.append("(");
 			
 	 		for (String sugSql : sugSqlList) {
 	 			
 	 			if ("-".equals(sugSql)) {
 	 				sqlWhereSb.append("1 = 2) and (");
 	 				continue;
 	 			}
 	 			sqlWhereSb.append(sugSql);
 	 			sqlWhereSb.append(" or ");
 			}
 	 		sqlWhereSb.append("1 = 1) and ");
 		}
 		
 		if (xydiSqlList.size() > 0) {
 			sqlWhereSb.append("(");
 			
 			for (String xydiSql : xydiSqlList) {
 				
 	 			if ("-".equals(xydiSql)) {
 	 				sqlWhereSb.append("1 = 2) and (");
 	 				continue;
 	 			}
 	 			sqlWhereSb.append(xydiSql);
 	 			sqlWhereSb.append(" or ");
 			}
 			sqlWhereSb.append("1 = 1) and ");
 		}
		
 		if (zydiSqlList.size() > 0) {
 			sqlWhereSb.append("(");
 			
 			for (String zydiSql : zydiSqlList) {
				
 	 			if ("-".equals(zydiSql)) {
 	 				sqlWhereSb.append("1 = 2) and (");
 	 				continue;
 	 			}
 	 			sqlWhereSb.append(zydiSql);
 	 			sqlWhereSb.append(" or ");
 			}
 			sqlWhereSb.append("1 = 1) and ");
 		}
 		
 		if (sqlWhereSb.length() > 0) {
 			sqlwhere = " where " + sqlWhereSb.toString().substring(0, sqlWhereSb.toString().length() - 4);
 		}
 		StringBuilder sb = new StringBuilder();
 		sb.append("select qf.col0038, ");
 		sb.append("       pay_method.code  as col0038_code, ");
 		sb.append("       pay_method.name  as col0038_name, ");
 		sb.append("       qf.col0071, ");
 		sb.append("       qf.col0039, ");
 		sb.append("       qf.col0037, ");
 		sb.append("       qf.col0016, ");
 		sb.append("       qf.col0019, ");
 		sb.append("       sex.code         as col0019_code, ");
 		sb.append("       sex.name         as col0019_name, ");
 		sb.append("       qf.col0020, ");
 		sb.append("       qf.col0021, ");
 		sb.append("       qf.col0040, ");
 		sb.append("       country.code     as col0040_code, ");
 		sb.append("       country.name     as col0040_name, ");
 		sb.append("       qf.col0041, ");
 		sb.append("       nation.code      as col0041_code, ");
 		sb.append("       nation.name      as col0041_name, ");
 		sb.append("       qf.col0022, ");
 		sb.append("       addr_birth.code  as col0022_code, ");
 		sb.append("       addr_birth.name  as col0022_name, ");
 		sb.append("       qf.col0023, ");
 		sb.append("       addr_origin.code as col0023_code, ");
 		sb.append("       addr_origin.name as col0023_name, ");
 		sb.append("       qf.col0043, ");
 		sb.append("       id_type.code     as col0043_code, ");
 		sb.append("       id_type.name     as col0043_name, ");
 		sb.append("       qf.col0044, ");
 		sb.append("       qf.col0045, ");
 		sb.append("       occu.code        as col0045_code, ");
 		sb.append("       occu.name        as col0045_name, ");
 		sb.append("       qf.col0042, ");
 		sb.append("       marry.code       as col0042_code, ");
 		sb.append("       marry.name       as col0042_name, ");
 		sb.append("       qf.col0024, ");
 		sb.append("       addr_now.code    as col0024_code, ");
 		sb.append("       addr_now.name    as col0024_name, ");
 		sb.append("       qf.col0025, ");
 		sb.append("       qf.col0026, ");
 		sb.append("       qf.col0027, ");
 		sb.append("       addr_cencus.code as col0027_code, ");
 		sb.append("       addr_cencus.name as col0027_name, ");
 		sb.append("       qf.col0028, ");
 		sb.append("       qf.col0029, ");
 		sb.append("       addr_work.code   as col0029_code, ");
 		sb.append("       addr_work.name   as col0029_name, ");
 		sb.append("       qf.col0031, ");
 		sb.append("       qf.col0032, ");
 		sb.append("       qf.col0033, ");
 		sb.append("       qf.col0034, ");
 		sb.append("       cont_type.code   as col0034_code, ");
 		sb.append("       cont_type.name   as col0034_name, ");
 		sb.append("       qf.col0035, ");
 		sb.append("       addr_cont.code   as col0035_code, ");
 		sb.append("       addr_cont.name   as col0035_name, ");
 		sb.append("       qf.col0036, ");
 		sb.append("       qf.col0049, ");
 		sb.append("       referalsrc.code  as col0049_code, ");
 		sb.append("       referalsrc.name  as col0049_name, ");
 		sb.append("       qf.col0050, ");
 		sb.append("       qf.col0051, ");
 		sb.append("       inhos_dep.code   as col0051_code, ");
 		sb.append("       inhos_dep.name   as col0051_name, ");
 		sb.append("       qf.col0056, ");
 		sb.append("       inhos_bed.code   as col0056_code, ");
 		sb.append("       inhos_bed.name   as col0056_name, ");
 		sb.append("       qf.col0052, ");
 		sb.append("       trans_dep.code   as col0052_code, ");
 		sb.append("       trans_dep.name   as col0052_name, ");
 		sb.append("       qf.col0053, ");
 		sb.append("       qf.col0054, ");
 		sb.append("       outhos_dep.code  as col0054_code, ");
 		sb.append("       outhos_dep.name  as col0054_name, ");
 		sb.append("       qf.col0057, ");
 		sb.append("       outhos_bed.code  as col0057_code, ");
 		sb.append("       outhos_bed.name  as col0057_name, ");
 		sb.append("       qf.col0055, ");
 		sb.append("       qf.col0058, ");
 		sb.append("       outp_cm_di.code  as col0058_code, ");
 		sb.append("       outp_cm_di.name  as col0058_name, ");
 		sb.append("       qf.col0138, ");
 		sb.append("       iioutreason.code      as col0138_code, ");
 		sb.append("       iioutreason.name      as col0138_name, ");
 		sb.append("       qf.col0141, ");
 		sb.append("       qf.col0112,  ");
 		sb.append("       qf.col0156, ");
 		sb.append("       hightest_di.code      as col0156_code, ");
 		sb.append("       hightest_di.name      as col0156_name, ");
 		sb.append("       qf.col0091, ");
 		sb.append("       qf.col0092, ");
 		sb.append("       qf.col0093, ");
 		sb.append("       qf.col0116, ");
 		sb.append("       qf.col0117, ");
 		sb.append("       qf.col0094, ");
 		sb.append("       qf.col0095, ");
 		sb.append("       qf.col0096, ");
 		sb.append("       qf.col0097, ");
 		sb.append("       qf.col0163, ");
 		sb.append("       qf.col0164, ");
 		sb.append("       qf.col0165, ");
 		sb.append("       qf.col0166, ");
 		sb.append("       qf.col0098, ");
 		sb.append("       dirofdept.code        as col0098_code, ");
 		sb.append("       dirofdept.name        as col0098_name, ");
 		sb.append("       qf.col0162, ");
 		sb.append("       team_doc.code         as col0162_code, ");
 		sb.append("       team_doc.name         as col0162_name, ");
 		sb.append("       qf.col0099, ");
 		sb.append("       zr_doc.code           as col0099_code, ");
 		sb.append("       zr_doc.name           as col0099_name, ");
 		sb.append("       qf.col0102, ");
 		sb.append("       zz_doc.code           as col0102_code, ");
 		sb.append("       zz_doc.name           as col0102_name, ");
 		sb.append("       qf.col0103, ");
 		sb.append("       zy_doc.code           as col0103_code, ");
 		sb.append("       zy_doc.name           as col0103_name, ");
 		sb.append("       qf.col0101, ");
 		sb.append("       emp_nur.code          as col0101_code, ");
 		sb.append("       emp_nur.name          as col0101_name, ");
 		sb.append("       qf.col0104, ");
 		sb.append("       learn_doc.code        as col0104_code, ");
 		sb.append("       learn_doc.name        as col0104_name, ");
 		sb.append("       qf.col0105, ");
 		sb.append("       intern_doc.code       as col0105_code, ");
 		sb.append("       intern_doc.name       as col0105_name, ");
 		sb.append("       qf.col0108, ");
 		sb.append("       coder.code            as col0108_code, ");
 		sb.append("       coder.name            as col0108_name, ");
 		sb.append("       qf.col0109, ");
 		sb.append("       qf.col0110, ");
 		sb.append("       qf.col0106, ");
 		sb.append("       qcp_doc.code          as col0106_code, ");
 		sb.append("       qcp_doc.name          as col0106_name, ");
 		sb.append("       qf.col0107, ");
 		sb.append("       qcp_nur.code          as col0107_code, ");
 		sb.append("       qcp_nur.code          as col0107_name, ");
 		sb.append("       qf.col0111, ");
 		sb.append("       qf.col0159, ");
 		sb.append("       inpath_status.code    as col0159_code, ");
 		sb.append("       inpath_status.name    as col0159_name, ");
 		sb.append("       qf.col0160, ");
 		sb.append("       complete_status.code  as col0160_code, ");
 		sb.append("       complete_status.name  as col0160_name, ");
 		sb.append("       qf.col0161, ");
 		sb.append("       varistion_status.code as col0161_code, ");
 		sb.append("       varistion_status.name as col0161_name, ");
 		sb.append("       qf.col0113, ");
 		sb.append("		  qf.col0002, ");
 		sb.append("		  qf.col0014, ");
 		sb.append("		  qf.col0015, ");
 		sb.append("		  qf.col0018 ");
 		sb.append("  from mr_qf_fp qf ");
 		sb.append("  left join bd_udidoc pay_method ");
 		sb.append("    on qf.col0038 = pay_method.id_udidoc ");
 		sb.append("  left join bd_udidoc sex ");
 		sb.append("    on qf.col0019 = sex.id_udidoc ");
 		sb.append("  left join bd_udidoc nation ");
 		sb.append("    on qf.col0041 = nation.id_udidoc ");
 		sb.append("  left join bd_udidoc id_type ");
 		sb.append("    on qf.col0043 = id_type.id_udidoc ");
 		sb.append("  left join bd_udidoc occu ");
 		sb.append("    on qf.col0045 = occu.id_udidoc ");
 		sb.append("  left join bd_udidoc marry ");
 		sb.append("    on qf.col0042 = marry.id_udidoc ");
 		sb.append("  left join bd_udidoc cont_type ");
 		sb.append("    on qf.col0034 = cont_type.id_udidoc ");
 		sb.append("  left join bd_udidoc referalsrc ");
 		sb.append("    on qf.col0049 = referalsrc.id_udidoc ");
 		sb.append("  left join bd_dep inhos_dep ");
 		sb.append("    on qf.col0051 = inhos_dep.id_dep ");
 		sb.append("  left join bd_dep inhos_bed ");
 		sb.append("    on qf.col0056 = inhos_bed.id_dep ");
 		sb.append("  left join bd_dep trans_dep ");
 		sb.append("    on qf.col0052 = trans_dep.id_dep ");
 		sb.append("  left join bd_dep outhos_dep ");
 		sb.append("    on qf.col0054 = outhos_dep.id_dep ");
 		sb.append("  left join bd_dep outhos_bed ");
 		sb.append("    on qf.col0057 = outhos_bed.id_dep ");
 		sb.append("  left join bd_udidoc hightest_di ");
 		sb.append("    on qf.col0156 = hightest_di.id_udidoc ");
 		sb.append("  left join bd_psndoc dirofdept ");
 		sb.append("    on qf.col0098 = dirofdept.id_psndoc ");
 		sb.append("  left join bd_psndoc team_doc ");
 		sb.append("    on qf.col0162 = team_doc.id_psndoc ");
 		sb.append("  left join bd_psndoc zr_doc ");
 		sb.append("    on qf.col0099 = zr_doc.id_psndoc ");
 		sb.append("  left join bd_psndoc zz_doc ");
 		sb.append("    on qf.col0102 = zz_doc.id_psndoc ");
 		sb.append("  left join bd_psndoc zy_doc ");
 		sb.append("    on qf.col0103 = zy_doc.id_psndoc ");
 		sb.append("  left join bd_psndoc emp_nur ");
 		sb.append("    on qf.col0101 = emp_nur.id_psndoc ");
 		sb.append("  left join bd_psndoc learn_doc ");
 		sb.append("    on qf.col0104 = learn_doc.id_psndoc ");
 		sb.append("  left join bd_psndoc intern_doc ");
 		sb.append("    on qf.col0105 = intern_doc.id_psndoc ");
 		sb.append("  left join bd_psndoc coder ");
 		sb.append("    on qf.col0108 = coder.id_psndoc ");
 		sb.append("  left join bd_psndoc qcp_doc ");
 		sb.append("    on qf.col0106 = qcp_doc.id_psndoc ");
 		sb.append("  left join bd_psndoc qcp_nur ");
 		sb.append("    on qf.col0107 = qcp_nur.id_psndoc ");
 		sb.append("  left join bd_udidoc inpath_status ");
 		sb.append("    on qf.col0159 = inpath_status.id_udidoc ");
 		sb.append("  left join bd_udidoc complete_status ");
 		sb.append("    on qf.col0160 = complete_status.id_udidoc ");
 		sb.append("  left join bd_udidoc varistion_status ");
 		sb.append("    on qf.col0161 = varistion_status.id_udidoc ");
 		sb.append("  left join bd_country country ");
 		sb.append("    on qf.col0040 = country.id_countryzone ");
 		sb.append("  left join bd_mr_area addr_birth ");
 		sb.append("    on qf.col0022 = addr_birth.id_mr_area ");
 		sb.append("  left join bd_adminarea addr_origin ");
 		sb.append("    on qf.col0023 = addr_origin.id_adminarea ");
 		sb.append("  left join bd_adminarea addr_now ");
 		sb.append("    on qf.col0024 = addr_now.id_adminarea ");
 		sb.append("  left join bd_adminarea addr_cencus ");
 		sb.append("    on qf.col0027 = addr_cencus.id_adminarea ");
 		sb.append("  left join bd_adminarea addr_work ");
 		sb.append("    on qf.col0029 = addr_work.id_adminarea ");
 		sb.append("  left join bd_adminarea addr_cont ");
 		sb.append("    on qf.col0035 = addr_cont.id_adminarea ");
 		sb.append("  left join bd_di_def outp_cm_di ");
 		sb.append("    on qf.col0058 = outp_cm_di.id_didef ");
 		sb.append("  left join bd_di_def iioutreason ");
 		sb.append("    on qf.col0138 = iioutreason.id_didef ");
 		sb.append(sqlwhere);
 		sb.append(" order by qf.col0053 " );
 		//sb.append(" WHERE "+sqlwhere+" and "+EnvContextUtil.processEnvContext("",new AMrDO(),false) +" and ee.fg_ip = 'N' ");
 		String sqlStr=sb.toString();
		PagingRtnData<CiMrFpQuickFindDO> pagingRtnData = super.findByPageInfo(new CiMrFpQuickFindDO(), pInfo, sqlStr, "", null);
		return pagingRtnData;
	}
	
}
