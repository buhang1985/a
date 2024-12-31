package iih.mi.mc.mimctactics;

import iih.bd.base.refs.BdRefGridModel;
import iih.mi.mc.mimctactics.d.MiMcTacticsDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 医保策略参照模型
 * @author zhaogx 2019年6月19日
 *
 */
public class MiMcTacticsRefGridModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	protected IBaseDO getDo() {
		return new MiMcTacticsDO();
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MiMcTacticsDO.NAME, MiMcTacticsDO.PATH, MiMcTacticsDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[]{"名称","路径","编码"};
	}
}
