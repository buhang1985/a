package iih.bd.mm.certi.s.rule;

import iih.bd.mm.certi.d.CertificationDO;
import iih.bd.mm.certi.s.bp.CertiDeBeforeBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 资质证书字典删除前规则
 * 
 * @author hao_wu
 *
 */
public class CertificationBeforeDeleteRule implements IRule<CertificationDO> {

	@Override
	public void process(CertificationDO... certiCationDOS) throws BizException {
		// 检查是否允许删除
		CertiDeBeforeBp bp = new CertiDeBeforeBp();

		bp.exec(certiCationDOS);
	}
}
