package iih.bd.pp.accountsubject.refs;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.param.IBdPpParamCodeConst;
import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.pp.accountsubject.d.desc.AccountSubjectDODesc;
import iih.bd.utils.BdEnvContextUtil;
import iih.bd.utils.BdPpParamUtils;
import iih.bd.utils.log.BdPpLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

public class AccountSubjectRefModel extends RefTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { AccountSubjectDO.CODE, AccountSubjectDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { AccountSubjectDO.ID_ACCOUNTCA, AccountSubjectDO.ID_ACCOUNT, AccountSubjectDO.ID_PAR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return AccountSubjectDO.ID_ACCOUNTCA;
	}

	@Override
	public String getRefCodeField() {
		return AccountSubjectDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return AccountSubjectDO.NAME;
	}

	@Override
	public String getTableName() {
		return AccountSubjectDODesc.TABLE_NAME;
	}

	@Override
	public String getFatherField() {
		return AccountSubjectDO.ID_PAR;
	}

	@Override
	public String getChildField() {
		return AccountSubjectDO.ID_ACCOUNTCA;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { AccountSubjectDO.CODE, AccountSubjectDO.NAME, AccountSubjectDO.PYCODE,
				AccountSubjectDO.WBCODE, AccountSubjectDO.INSTR };
	}

	@Override
	public String getRefSql() {
		String wherePart = buildWherePart();
		String orderPart = buildOrderPart();
		try {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			return super.getRefSql();

		} finally {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}
	}

	private String buildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and ds = 0 ");

		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new AccountSubjectDO(), false);
		stringBuilder.append(String.format(" and %s ", bdModeWherePart));

		// 共用核算体系
		FBoolean shareAcountSystem = FBoolean.FALSE;
		try {
			shareAcountSystem = BdPpParamUtils.getShareAcountSystemFlag();
		} catch (BizException e) {
			BdPpLogUtils.logExAndTitle(e, "获取参数失败：%s.", IBdPpParamCodeConst.BL_AC_SHAREACCOUNTSYSTEM);
		}
		if (FBoolean.TRUE.equals(shareAcountSystem)) {
			stringBuilder.append(String.format(" and id_account = '%s' ", IBdPpDictCodeConst.ID_ACCOUNT_GY));
		} else {
			stringBuilder.append(String.format(" and id_account in ('%s','%s') ", IBdPpDictCodeConst.ID_ACCOUNT_MZ,
					IBdPpDictCodeConst.ID_ACCOUNT_ZY));
		}

		// 只显示叶子节点
		FBoolean onlyShowLeaf = (FBoolean) getExtendAttributeValue("OnlyShowLeaf");
		if (FBoolean.TRUE.equals(onlyShowLeaf)) {
			try {
				String sql = "select id_par from BD_ACCOUNT_CA where id_par is not null and id_par <> '~'";
				DAFacade daFacade = new DAFacade();
				@SuppressWarnings("unchecked")
				List<String> parentIdList = (List<String>) daFacade.execQuery(sql, new ColumnListHandler());
				if (parentIdList != null && parentIdList.size() > 0) {
					String wherepart = String.format(" and %s",
							SqlUtils.getNotInSqlByIds(AccountSubjectDO.ID_ACCOUNTCA, parentIdList));
					stringBuilder.append(wherepart);
				}
			} catch (Exception e) {
				BdPpLogUtils.logExAndTitle(e, "处理叶子节点查询异常");
			}
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String buildOrderPart() {
		return AccountSubjectDO.CODE;
	}
}
