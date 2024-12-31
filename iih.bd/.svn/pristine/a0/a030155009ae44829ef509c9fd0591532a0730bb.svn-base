package iih.bd.fc.orpltpmtpara.s;

import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import iih.bd.fc.orpltpmtpara.d.desc.OrpltpmtParaDODesc;
import iih.bd.fc.orpltpmtpara.i.IOrpltpmtparaCudService;
import iih.bd.fc.orpltpmtpara.i.IOrpltpmtparaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医嘱执行闭环类型匹配参数AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IOrpltpmtparaCudService.class, IOrpltpmtparaRService.class }, binding = Binding.JSONRPC)
public class OrpltpmtparaCrudServiceImpl extends BaseDOService<OrpltpmtParaDO>
		implements IOrpltpmtparaCudService, IOrpltpmtparaRService {
	public OrpltpmtparaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(OrpltpmtParaDODesc.class), IAppFwTempTbl.tmp_iaw_19.name());
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
	protected Validator[] getUpdateValidator(OrpltpmtParaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
