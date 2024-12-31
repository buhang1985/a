package iih.nm.nqm.nqmchkitm.refs;

import iih.nm.nqm.nqmchkitm.d.NmNqmChkitmDo;
import iih.nm.nqm.nqmchkitm.d.NmNqmChkitmcaDo;
import iih.nm.nqm.nqmchkitm.d.desc.NmNqmChkitmDoDesc;
import iih.nm.nqm.nqmchkitm.d.desc.NmNqmChkitmcaDoDesc;
import xap.sys.appfw.refinfo.RefTreeGridModel;

public class NqmChkRefTreeGridModel extends RefTreeGridModel {

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmNqmChkitmDo.CODE, NmNqmChkitmDo.NAME };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmNqmChkitmDo.ID_NQM_CHKITM };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { NmNqmChkitmDo.CODE, NmNqmChkitmDo.NAME };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return NmNqmChkitmDoDesc.TABLE_NAME;
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return NmNqmChkitmDo.ID_NQM_CHKITM;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return NmNqmChkitmDo.CODE;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return NmNqmChkitmDo.NAME;
	}

	/**
	 * 分类表名
	 */
	@Override
	public String getClassTableName() {
		return NmNqmChkitmcaDoDesc.TABLE_NAME;
	}

	/**
	 * 分类字段名数组
	 */
	@Override
	public String[] getClassFieldCode() {
		// 父节点中少一个ID_PARENT字段
		return new String[] { NmNqmChkitmcaDo.CODE, NmNqmChkitmcaDo.NAME, NmNqmChkitmcaDo.ID_NQM_CHKITMCA, NmNqmChkitmcaDo.ID_PAR };
	}

	/**
	 * 分类名称字段
	 */
	@Override
	public String getClassRefNameField() {
		return NmNqmChkitmcaDo.NAME;
	}

	/**
	 * 分类编码字段
	 */
	@Override
	public String getClassRefCodeField() {
		return NmNqmChkitmcaDo.CODE;
	}

	/**
	 * 分类主键字段
	 */
	@Override
	public String getClassPkFieldCode() {
		return NmNqmChkitmcaDo.ID_NQM_CHKITMCA;
	}

	/**
	 * 档案表中和分类连接的字段
	 */
	@Override
	public String getDocJoinField() {
		return NmNqmChkitmDo.ID_NQM_CHKITMCA;
	}

	/**
	 * 分类表中和档案连接的字段---一般是分类主键
	 */
	@Override
	public String getClassJoinField() {
		return NmNqmChkitmcaDo.ID_NQM_CHKITMCA;
	}

	/**
	 * 父子键树结构：子字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getChildField() {
		return NmNqmChkitmcaDo.ID_NQM_CHKITMCA;
	}

	/**
	 * 父子键树结构：父字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getFatherField() {
		return NmNqmChkitmcaDo.ID_PAR;
	}

	/**
	 * 返回分类数据查询过滤条件数组
	 */
	// @Override
	// public String[] getClassWherePart() {
	//
	// return new String[] { “ds = ‘0’ and activestate = ‘2’” };
	// }

	/**
	 * 返回分类数据查询排序条件
	 */
	@Override
	public String[] getClassOrderPart() {
		return new String[] { NmNqmChkitmcaDo.CODE };
	}
}
