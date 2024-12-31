package iih.bd.srv.srvspecantiexpert.refs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.srvspecantiexpert.d.SrvSpecAntiExpertDO;
import iih.bd.srv.srvspecantiexpert.d.desc.SrvSpecAntiExpertDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 查询特殊使用级抗菌药专家参照
 * 
 * @author HUMS
 * @author hao_wu 2018-7-1 修改DO名称,迭代逻辑
 *
 */
public class SpecAntiExpertRefModel extends RefGridModel {
	public static final String SYS_PARAM_TSKJY_DEPT ="CIOR0505";//特殊级抗菌药是否允许同科室医生会诊
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { SrvSpecAntiExpertDO.CODE, SrvSpecAntiExpertDO.NAME, SrvSpecAntiExpertDO.NAME_EMPTITLE };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { SrvSpecAntiExpertDO.ID_PSNDOC,
				SrvSpecAntiExpertDO.ID_EMPTITLE,
				SrvSpecAntiExpertDO.SD_EMPTITLE,
				SrvSpecAntiExpertDO.ID_DEP,
				SrvSpecAntiExpertDO.SD_DEP,
				SrvSpecAntiExpertDO.NAME_DEP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "职称" };
	}

	@Override
	public String getPkFieldCode() {
		return SrvSpecAntiExpertDO.ID_SRVSPECANTIEXPERT;
	}

	@Override
	public String getTableName() {
		return SrvSpecAntiExpertDODesc.TABLE_NAME;
	}

	@Override
	public String getRefCodeField() {
		return SrvSpecAntiExpertDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return SrvSpecAntiExpertDO.NAME;

	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = this.getCustomerRefSql();

		} finally {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}

		return refSql;
	}

	private String getCustomerRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT PSNDOC.code,");
		sqlBuilder.append("PSNDOC.name,");
		sqlBuilder.append("TITLE.name name_emptitle,");
		sqlBuilder.append("BD_SRV_SPEC_ANTI_EXPERT.id_psndoc,");
		sqlBuilder.append("PSNDOC.id_emptitle,");
		sqlBuilder.append("TITLE.code sd_emptitle,");
		sqlBuilder.append("PSNDOC.id_dep,");
		sqlBuilder.append("DEP.code sd_dep,");
		sqlBuilder.append("DEP.name name_dep ");
		sqlBuilder.append("FROM bd_srv_spec_anti_expert BD_SRV_SPEC_ANTI_EXPERT ");
		sqlBuilder.append("LEFT JOIN bd_psndoc PSNDOC ");
		sqlBuilder.append("ON PSNDOC.id_psndoc = BD_SRV_SPEC_ANTI_EXPERT.id_psndoc ");
		sqlBuilder.append("LEFT JOIN bd_dep DEP ");
		sqlBuilder.append("ON DEP.id_dep = PSNDOC.id_dep ");
		sqlBuilder.append("LEFT JOIN bd_udidoc TITLE ");
		sqlBuilder.append("ON TITLE.id_udidoc = PSNDOC.id_emptitle");

		List<String> wherePartList = this.getWherePart();
		for (int i = 0; i < wherePartList.size(); i++) {
			if (i == 0) {
				sqlBuilder.append(" WHERE ");
			} else {
				sqlBuilder.append(" AND ");
			}

			sqlBuilder.append(wherePartList.get(i));
		}

		List<String> orderPartList = this.getOrderPart();
		for (int i = 0; i < orderPartList.size(); i++) {
			if (i == 0) {
				sqlBuilder.append(" ORDER BY ");
			} else {
				sqlBuilder.append(" , ");
			}

			sqlBuilder.append(orderPartList.get(i));
		}

		return sqlBuilder.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 * @throws BizException 
	 */
	private String BuildWherePart()  {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new SrvSpecAntiExpertDO(), "BD_SRV_SPEC_ANTI_EXPERT");
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		 FBoolean flag;
		try {
			flag = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),SYS_PARAM_TSKJY_DEPT);
			if(FBoolean.FALSE.equals(flag)){
				stringBuilder.append(" and DEP.id_dep!='"+Context.get().getDeptId()+"'");
			}
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringBuilder.toString();
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		StringBuffer sb = new StringBuffer();
		 if(!StringUtils.isBlank(blurValue)) {
				sb.append(" (lower(PSNDOC.Code)");
				sb.append("  like '%").append(blurValue).append("%'");
				sb.append(" or ");
				sb.append("  lower(PSNDOC.name)");
				sb.append("  like '%").append(blurValue).append("%'");
				sb.append(" or ");
				sb.append("  lower(TITLE.name)");
				sb.append("  like '%").append(blurValue).append("%')");
				this.addWherePart(sb.toString());
		 }
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData();
		} finally {
			this.removeWherePart(sb.toString());
		}
	}
	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("PSNDOC.CODE");
		return stringBuilder.toString();
	}

}
