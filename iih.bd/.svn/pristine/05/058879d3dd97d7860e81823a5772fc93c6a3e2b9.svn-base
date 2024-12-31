package iih.bd.srv.emrterm.s;

import iih.bd.srv.emrterm.d.EmrNormWordCaDO;
import iih.bd.srv.emrterm.d.EmrnormwordAggDO;
import iih.bd.srv.emrterm.d.desc.EmrNormWordCaDODesc;
import iih.bd.srv.emrterm.i.IEmrnormwordCudService;
import iih.bd.srv.emrterm.i.IEmrnormwordRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 病历常用词分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmrnormwordCudService.class, IEmrnormwordRService.class }, binding = Binding.JSONRPC)
public class EmrnormwordCrudServiceImpl extends BaseAggService<EmrnormwordAggDO, EmrNormWordCaDO>
		implements IEmrnormwordCudService, IEmrnormwordRService {
	public EmrnormwordCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrNormWordCaDODesc.class), IAppFwTempTbl.tmp_iaw_17.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrnormwordAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
