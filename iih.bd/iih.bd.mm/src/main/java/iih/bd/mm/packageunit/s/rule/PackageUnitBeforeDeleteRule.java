package iih.bd.mm.packageunit.s.rule;

import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.mm.packageunit.s.bp.PkgutpDeBeforeBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品包装单位类型删除前规则
 * 
 * @author hao_wu
 *
 */
public class PackageUnitBeforeDeleteRule implements IRule<PackageUnitDO> {

	@Override
	public void process(PackageUnitDO... pckUnitDOS) throws BizException {
		PkgutpDeBeforeBp bp = new PkgutpDeBeforeBp();

		bp.exec(pckUnitDOS);
	}

}
