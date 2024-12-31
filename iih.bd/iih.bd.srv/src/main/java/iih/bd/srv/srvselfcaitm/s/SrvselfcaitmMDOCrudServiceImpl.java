package iih.bd.srv.srvselfcaitm.s;

import iih.bd.srv.srvselfcaitm.d.SrvSelfCaItemDO;
import iih.bd.srv.srvselfcaitm.d.desc.SrvSelfCaItemDODesc;
import iih.bd.srv.srvselfcaitm.i.ISrvselfcaitmMDOCudService;
import iih.bd.srv.srvselfcaitm.i.ISrvselfcaitmMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 服务自定义分类项目主实体CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvselfcaitmMDOCudService.class,
		ISrvselfcaitmMDORService.class }, binding = Binding.JSONRPC)
public class SrvselfcaitmMDOCrudServiceImpl extends BaseDOService<SrvSelfCaItemDO>
		implements ISrvselfcaitmMDOCudService, ISrvselfcaitmMDORService {

	public SrvselfcaitmMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvSelfCaItemDODesc.class), IAppFwTempTbl.tmp_iaw_17.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(SrvSelfCaItemDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
