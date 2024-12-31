package iih.bd.mm.certi.s.rule;

import iih.bd.mm.certi.d.CertificationDO;
import iih.bd.mm.certi.s.bp.CertiCuAfterBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 资质证书字典插入或更新后规则
 * 
 * @author hao_wu
 *
 */
public class CertificationAfterInsertOrUpdateRule implements IRule<CertificationDO> {

	@Override
	public void process(CertificationDO... certiCationDOS) throws BizException {
		CertiCuAfterBp bp = new CertiCuAfterBp();

		bp.exec(certiCationDOS);
	}

}
