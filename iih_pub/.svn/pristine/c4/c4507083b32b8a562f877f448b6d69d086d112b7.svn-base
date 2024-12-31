package iih.bd.srv.srvcate.d.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

/**
 * 医疗服务分类参照模型
 * 
 * @author hao_wu 2019-8-20
 *
 */
public class SrvcateRefModel extends RefTreeModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { SrvCateDO.CODE, SrvCateDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { SrvCateDO.ID_SRVCA, SrvCateDO.ID_PARENT, SrvCateDO.INNERCODE, SrvCateDO.ID_SRVTP,
				SrvCateDO.SD_SRVTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "默认服务类型", "默认服务类型编码" };
	}

	@Override
	public String getTableName() {
		return new SrvCateDO().getTableName();
	}

	@Override
	public String getPkFieldCode() {
		return SrvCateDO.ID_SRVCA;
	}

	@Override
	public String getRefCodeField() {
		return SrvCateDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return SrvCateDO.NAME;
	}

	@Override
	public String getChildField() {
		return SrvCateDO.ID_SRVCA;
	}

	@Override
	public String getFatherField() {
		return SrvCateDO.ID_PARENT;
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}

		return refSql;
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1 and ds = 0");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new SrvCateDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String code = (String) this.getExtendAttributeValue("Code");
		if (code != null && !code.equals("")) {
			stringBuilder.append(" and code like '" + code + "%'  ");
		}

		// 就诊类型
		String entpCode = (String) this.getExtendAttributeValue("code_entp");
		if (StringUtils.isNotEmpty(entpCode)) {
			if (entpCode.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)) {
				stringBuilder.append(" and fg_entp_op  = 'Y'");
			} else if (entpCode.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)) {
				stringBuilder.append(" and fg_entp_er  = 'Y'");
			} else if (entpCode.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) {
				stringBuilder.append(" and fg_entp_pe  = 'Y'");
			} else if (entpCode.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) {
				stringBuilder.append(" and fg_entp_ip  = 'Y'");
			} else if (entpCode.equals(IBdFcDictCodeConst.SD_CODE_ENTP_FA)) {
				stringBuilder.append(" and fg_entp_fm  = 'Y'");
			}
		}

		String wherePart = (String) this.getExtendAttributeValue("wherePart");
		if (StringUtils.isNotEmpty(wherePart)) {
			stringBuilder.append(" AND ");
			stringBuilder.append(wherePart);
		}

		String srvTpId = (String) this.getExtendAttributeValue("id_srvtp");
		if (StringUtils.isNotEmpty(srvTpId)) {
			stringBuilder.append("AND ID_SRVTP IN ");
			stringBuilder.append("(SELECT DISTINCT SRVTP.ID_UDIDOC ");
			stringBuilder.append("FROM BD_UDIDOC SRVTP ");
			stringBuilder.append("INNER JOIN BD_UDIDOC SRVTP_CHILD ");
			stringBuilder.append(String.format("ON SRVTP.ID_UDIDOC = '%s' ", srvTpId));
			stringBuilder.append("AND SRVTP.ID_UDIDOCLIST = SRVTP_CHILD.ID_UDIDOCLIST ");
			stringBuilder.append("AND INSTR(SRVTP_CHILD.INNERCODE,SRVTP.INNERCODE) = 1) ");
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("code");
		return stringBuilder.toString();
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { SrvCateDO.NAME, SrvCateDO.CODE, SrvCateDO.MNECODE };
	}

}
