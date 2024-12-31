package iih.bd.srv.srvspecantiexpert.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.srvspecantiexpert.d.SrvSpecAntiExpertDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据人员基本信息的查询方案查询抗菌药专家bp
 * 
 * @author guoyang
 *
 */
public class FindSrvSpecAntiExpertByQCondBp {

	public SrvSpecAntiExpertDO[] exec(QryRootNodeDTO qryRootNodeDTO, String orderStr) throws BizException {

		String sql = getSql(qryRootNodeDTO, orderStr);

		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<SrvSpecAntiExpertDO> srvSpecAntiExpertDOs = (List<SrvSpecAntiExpertDO>) daFacade.execQuery(sql,
				new BeanListHandler(SrvSpecAntiExpertDO.class));

		if (srvSpecAntiExpertDOs != null && srvSpecAntiExpertDOs.size() > 0) {
			return srvSpecAntiExpertDOs.toArray(new SrvSpecAntiExpertDO[0]);
		}
		return null;
	}

	/**
	 * 获取sql
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	private String getSql(QryRootNodeDTO qryRootNodeDTO, String orderStr) throws BizException {

		StringBuffer sb = new StringBuffer();
		String where = getWhere(qryRootNodeDTO, orderStr);
		sb.append(" SELECT expert.id_srvspecantiexpert, expert.id_grp, expert.id_org, ");
		sb.append(" 	   expert.id_psndoc, expert.createdby, expert.createdtime,  ");
		sb.append("        expert.modifiedby, expert.modifiedtime, expert.ds, expert.sv, ");
		sb.append("        psndoc.code, psndoc.name, ");
		sb.append("        psndoc.id_empwktp, psndoc.sd_empwktp, psndoc.name_empwktp, ");
		sb.append("        psndoc.id_emptitle, psndoc.sd_emptitle, psndoc.name_emptitle, ");
		sb.append("        psndoc.id_dep, psndoc.sd_dep, psndoc.name_dep ");
		sb.append(" FROM bd_srv_spec_anti_expert expert ");
		sb.append(" RIGHT JOIN( ");
		sb.append(" 	SELECT a0.id_psndoc, ");
		sb.append("     	   a0.code, ");
		sb.append("      	   a0.name, ");
		sb.append(" 		   empwktp.id_udidoc  AS id_empwktp, ");
		sb.append("            empwktp.code       AS sd_empwktp, ");
		sb.append(" 		   empwktp.name       AS name_empwktp, ");
		sb.append("            emptitle.id_udidoc AS id_emptitle, ");
		sb.append(" 		   emptitle.code      AS sd_emptitle, ");
		sb.append(" 		   emptitle.name      AS name_emptitle, ");
		sb.append(" 		   dep.id_dep, ");
		sb.append(" 		   dep.code AS sd_dep, ");
		sb.append(" 		   dep.name AS name_dep ");
		sb.append(" 	FROM bd_psndoc a0 ");
		sb.append(" 	LEFT JOIN bd_udidoc empwktp ");
		sb.append(" 	ON empwktp.id_udidoc = a0.id_empwktp ");
		sb.append(" 	LEFT JOIN bd_udidoc emptitle ");
		sb.append(" 	ON emptitle.id_udidoc = a0.id_emptitle ");
		sb.append(" 	LEFT JOIN bd_dep dep ");
		sb.append(" 	ON dep.id_dep = a0.id_dep ");
		sb.append("     where ");
		sb.append(where);
		sb.append(" ) psndoc ");
		sb.append(" ON psndoc.id_psndoc = expert.id_psndoc ");

		String wherePart = BdEnvContextUtil.processEnvContext(new SrvSpecAntiExpertDO(), "expert");
		if (StringUtils.isNotEmpty(wherePart)) {
			sb.append(" where ");
			sb.append(wherePart);
		}
		return sb.toString();
	}

	/**
	 * 根据查询方案获取sql的where条件
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String getWhere(QryRootNodeDTO qryRootNodeDTO, String orderStr) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String qryWherePart = qrySQLGeneratorService.getQueryStringWithDOName(qryRootNodeDTO, PsnDocDO.class.getName());
		if (StringUtils.isNotEmpty(qryWherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(qryWherePart);
		}

		String wherePart = BdEnvContextUtil.processEnvContext(new PsnDocDO(), "a0");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(orderStr)) {
			wherePartBuilder.append(" ORDER BY ");
			wherePartBuilder.append(orderStr);
		}
		return wherePartBuilder.toString();
	}
}
