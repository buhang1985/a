package iih.bd.res.goodslocation.refs;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.res.goodslocation.d.GoodslocationDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 货位参照模型
 * 
 * @author hao_wu 2019-9-5
 *
 */
public class GoodsLocRefModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	protected List<String> getHiddenFieldCodeList() {
		List<String> fieldCodeList = super.getHiddenFieldCodeList();
		fieldCodeList.add(GoodslocationDO.ID_WH);
		return fieldCodeList;
	}

	@Override
	protected StringBuilder buildWhereParter() {
		StringBuilder wherePartBuilder = super.buildWhereParter();

		wherePartBuilder.append(" and fg_active = 'Y'");

		String id_wh = (String) this.getExtendAttributeValue("id_wh");
		if (StringUtils.isNotBlank(id_wh)) {
			String whereStr = String.format(" and id_wh='%s'", id_wh);
			wherePartBuilder.append(whereStr);
		}

		return wherePartBuilder;
	}

	@Override
	protected IBaseDO getDo() {
		return new GoodslocationDO();
	}
}
