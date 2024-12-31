package iih.sc.scbd.schedulesrv.refs;

import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulesrv.d.ScSrvKindDO;
import iih.sc.scbd.schedulesrv.d.ScSrvKindItm;
import xap.sys.appfw.refinfo.RefTreeGridModel;
import xap.sys.jdbc.kernel.SqlParam;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 排班服务类别明细参照模型
 * 
 * @author zhengcm
 * @date 2018-04-19 14:52:41
 *
 */
public class ScSrvKindItemRefModel extends RefTreeGridModel {
	
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScSrvKindItm.ID_SCSRVKIND,ScSrvKindItm.ID_SCSRVKINDITM};
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ScSrvKindItm.CODE, ScSrvKindItm.NAME };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { ScSrvKindItm.CODE, ScSrvKindItm.NAME };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return new ScSrvKindItm().getTableName();
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return ScSrvKindItm.ID_SCSRVKINDITM;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return ScSrvKindItm.CODE;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return ScSrvKindItm.NAME;
	}

	/**
	 * 分类表名
	 */
	@Override
	public String getClassTableName() {
		return new ScSrvKindDO().getTableName();
	}

	/**
	 * 分类字段名数组
	 */
	@Override
	public String[] getClassFieldCode() {
		return new String[] { ScSrvKindDO.CODE, ScSrvKindDO.NAME, ScSrvKindDO.ID_SCSRVKIND,
				"'~' as id_parent" };
	}

	/**
	 * 分类名称字段
	 */
	@Override
	public String getClassRefNameField() {
		return ScSrvKindDO.NAME;
	}

	/**
	 * 分类编码字段
	 */
	@Override
	public String getClassRefCodeField() {
		return ScSrvKindDO.CODE;
	}

	/**
	 * 分类主键字段
	 */
	@Override
	public String getClassPkFieldCode() {
		return ScSrvKindDO.ID_SCSRVKIND;
	}

	/**
	 * 档案表中和分类连接的字段
	 */
	@Override
	public String getDocJoinField() {
		return ScSrvKindItm.ID_SCSRVKIND;
	}

	/**
	 * 分类表中和档案连接的字段---一般是分类主键
	 */
	@Override
	public String getClassJoinField() {
		return ScSrvKindDO.ID_SCSRVKIND;
	}

	/**
	 * 父子键树结构：子字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getChildField() {
		return ScSrvKindDO.ID_SCSRVKIND;
	}

	/**
	 * 父子键树结构：父字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getFatherField() {
		return "id_parent";
	}

	/**
	 * 返回分类数据查询过滤条件数组
	 */
	@Override
	public String[] getClassWherePart() {
		return new String[] { "ds = '0'" };
	}

	/**
	 * 返回分类数据查询排序条件
	 */
	@Override
	public String[] getClassOrderPart() {
		return new String[] { ScSrvKindDO.CODE, ScSrvKindDO.NAME };
	}

	@Override
	public String getClassRefSql() {
		// 获取过滤参数
		String id_scca = (String) getExtendAttributeValue("id_scca");
		StringBuilder sb = new StringBuilder();
		sb.append("select * from (select kind.code, kind.name, kind.id_scsrvkind,kind.id_scca ");
		sb.append("from " + new ScSrvKindDO().getTableName() + " kind ");
		sb.append("where 1= 1 and kind.fg_active = 'Y' ");
		sb.append("and "+ScGroupControlUtils.getGroupControlFitler(new ScSrvKindDO(), "kind"));
		// 排序
		sb.append("order by kind.code) kinditem where 1 = 1 ");
		if (!StringUtil.isEmptyWithTrim(id_scca)) {
			sb.append("and kinditem.id_scca = '" + id_scca + "' ");
		}
		return sb.toString();
	}
	
	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		String id_scca = (String) getExtendAttributeValue("id_scca");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("sc_srv_kind_itm.id_scsrvkind in( select kind.id_scsrvkind ");
		stringBuilder.append("from " + new ScSrvKindDO().getTableName() + " kind ");
		stringBuilder.append("where 1= 1 and kind.fg_active = 'Y' ");
		stringBuilder.append("and "+ScGroupControlUtils.getGroupControlFitler(new ScSrvKindDO(), "kind"));
		if (!StringUtil.isEmptyWithTrim(id_scca)) {
			stringBuilder.append("and kind.id_scca = '" + id_scca + "') ");
		}else{
			stringBuilder.append(")");
		}
		//过滤类别参照
		stringBuilder.append(" and "+new ScSrvKindItm().getTableName()+".fg_active = 'Y' ");
		
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new ScSrvKindItm(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		return stringBuilder.toString();
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
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s,%s", ScSrvKindItm.CODE, ScSrvKindItm.NAME));
		return stringBuilder.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @Fields serialVersionUID
	 *//*
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		//return new String[] { "kindname","code", "name", "kindcode"  };
		return new String[] { ScSrvKindItm.CODE, ScSrvKindItm.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		//return new String[] { "id_scsrvkinditm","id_scsrvkind"};
		return new String[] { ScSrvKindItm.ID_SCSRVKINDITM,ScSrvKindItm.ID_SCSRVKIND };
	}
	
	@Override
	public String[] getShowFieldName() {
		//return new String[] { "类型名称","明细编码", "明细名称", "类型编码" };
		return new String[] { "编码","类型" };
	}

	@Override
	public String getPkFieldCode() {
		//return "id_scsrvkinditm";
		return ScSrvKindItm.ID_SCSRVKINDITM;
	}

	@Override
	public String getRefCodeField() {
		//return "code";
		return ScSrvKindItm.CODE;
	}
	@Override
	public String getChildField() {
		//return "id_scsrvkinditm";
		return ScSrvKindDO.ID_SCSRVKIND;
	}
	
	@Override
	public String getRefNameField() {
		//return "name";
		return ScSrvKindItm.NAME;
	}
	*//**
	 * 参照主表名
	 *//*
	@Override
	public String getTableName() {
		//return "Kinditem";
		return new ScSrvKindItm().getTableName();
	}
	*//**
	 * 分类表名
	 *//*
	@Override
	public String getClassTableName() {
		return new ScSrvKindDO().getTableName();
	}

	*//**
	 * 分类字段名数组
	 *//*
	@Override
	public String[] getClassFieldCode() {
		return new String[] { ScSrvKindDO.CODE, ScSrvKindDO.NAME};
	}
		
	*//**
	 * 分类名称字段
	 *//*
	@Override
	public String getClassRefNameField() {
		return ScSrvKindDO.NAME;
	}
	*//**
	 * 分类编码字段
	 *//*
	@Override
	public String getClassRefCodeField() {
		return ScSrvKindDO.CODE;
	}
	*//**
	 * 档案表中和分类连接的字段
	 *//*
	@Override
	public String getDocJoinField() {
		return ScSrvKindItm.ID_SCSRVKIND;
	}
	*//**
	 * 分类表中和档案连接的字段---一般是分类主键
	 *//*
	@Override
	public String getClassJoinField() {
		return ScSrvKindDO.ID_SCSRVKIND;
	}
	*//**
	 * 分类主键字段
	 *//*
	@Override
	public String getClassPkFieldCode() {
		return ScSrvKindDO.ID_SCSRVKIND;
	}
	
	*//**
	 * 父子键树结构：父字段。左树右表中，用于描述左分类的树结构。
	 *//*
	@Override
	public String getFatherField() {
		return ScSrvKindDO.ID_SCCA;
	}

	@Override
	public String getClassRefSql() {
		String id_scca = (String) getExtendAttributeValue("id_scca");
		String wherePart = BuildClassWherePart();
		String orderPart = BuildClassOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getClassRefSql();

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
	*//**
	 * 构建条件语句
	 * 
	 * @return
	 *//*
	private String BuildClassWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = ScGroupControlUtils.getGroupControlFitler(new ScSrvKindDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		return stringBuilder.toString();
	}

	*//**
	 * 构建排序语句
	 * 
	 * @return
	 *//*
	private String BuildClassOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s,%s", ScSrvKindDO.CODE, ScSrvKindDO.NAME));
		return stringBuilder.toString();
	}
	
	 * 拼音、五笔、助记码 过滤
	 
	@Override
	public String[] getBlurFields() {
		return new String[] { ScSrvKindItm.CODE, ScSrvKindItm.NAME };
	}

	@Override
	public String getRefSql() {
		// 获取过滤参数
		String id_scca = (String) getExtendAttributeValue("id_scca");
		StringBuilder sb = new StringBuilder();
		sb.append("select * from (select kind.code,kind.name,kind.id_scsrvkind,kind.id_scca from "+new ScSrvKindDO().getTableName()+" kind where 1=1 and kind.fg_active = 'Y'  ");
		sb.append("and "+ScGroupControlUtils.getGroupControlFitler(new ScSrvKindDO(), "kind"));
		sb.append(" order by kind.code)");
		sb.append( " kinditem where 1=1 ");

		if (!StringUtil.isEmptyWithTrim(id_scca)) {
			sb.append("and kinditem.id_scca = '" + id_scca + "' ");
		}
		List<String> whereList = this.getWherePart();
		if (!ListUtil.isEmpty(whereList)) {
			for (String where : this.getWherePart()) {
				sb.append(" and (").append(where).append(") ");
			}
		}
		return sb.toString();
	}*/
}
