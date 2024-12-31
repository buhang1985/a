package iih.bd.mm.supcertifications.s;

import iih.bd.mm.supcertifications.d.SupCertifiDO;
import iih.bd.mm.supcertifications.d.desc.SupCertifiDODesc;
import iih.bd.mm.supcertifications.i.ISupcertificationsCudService;
import iih.bd.mm.supcertifications.i.ISupcertificationsRService;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 供应商厂商资质证书AggDO数据CRUD服务实现
 */
public class SupcertificationsCrudServiceImpl extends BaseDOService<SupCertifiDO>
		implements ISupcertificationsCudService, ISupcertificationsRService {

	public SupcertificationsCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SupCertifiDODesc.class), IAppFwTempTbl.tmp_iaw_20.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(SupCertifiDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
