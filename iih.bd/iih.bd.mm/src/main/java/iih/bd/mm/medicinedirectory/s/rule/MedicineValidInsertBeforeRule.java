package iih.bd.mm.medicinedirectory.s.rule;

import iih.bd.mm.medicinedirectory.d.MedicineDirectoryDO;
import iih.bd.mm.medidirecdto.s.bp.MedidirecValiddtoBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

public class MedicineValidInsertBeforeRule implements IRule<MedicineDirectoryDO> {

	@Override
	public void process(MedicineDirectoryDO... dos) throws BizException {
		MedidirecValiddtoBP bp = new MedidirecValiddtoBP();
		bp.exec(dos);
	}
}
