package iih.bd.mhi.baserefs;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.refs.BdRefGridModel;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 医疗保险基础参照表格模型
 * 
 * @author hao_wu
 *
 */
public abstract class MhiBaseRefGridModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 是否是根据主键查询
	 */
	protected Boolean _isByPks = false;

	/**
	 * 获取医保产品主键
	 * 
	 * @return
	 * @throws BizException
	 */
	protected String getHpId() {
		String hpId = (String) this.getExtendAttributeValue("hpId");
		if (StringUtils.isEmpty(hpId)) {
			throw new BizRuntimeException("医保产品主键不允许为空");
		}
		return hpId;
	}

	@Override
	protected String buildWherePart() {
		String wherePart = super.buildWherePart();
		if (this._isByPks) {
			return wherePart;
		}
		String hpWherePart = getHpWherePart();
		return String.format("%s AND %s", wherePart, hpWherePart);
	}

	/**
	 * 获取医保产品条件语句
	 * 
	 * @return
	 */
	protected String getHpWherePart() {
		String hpId = this.getHpId();
		return String.format("id_hp = '%s'", hpId);
	}

	@Override
	public RefResultSet filterRefPks(String[] filterPks) {
		this._isByPks = true;
		RefResultSet resultSet = super.filterRefPks(filterPks);
		this._isByPks = false;
		return resultSet;
	}
}
