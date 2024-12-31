package iih.bd.srv.srvselfcaitm.s;

import iih.bd.srv.srvselfcaitm.d.SrvSelfCaItemDO;
import iih.bd.srv.srvselfcaitm.d.SrvselfcaitmAggDO;
import iih.bd.srv.srvselfcaitm.d.desc.SrvSelfCaItemDODesc;
import iih.bd.srv.srvselfcaitm.i.ISrvselfcaitmCudService;
import iih.bd.srv.srvselfcaitm.i.ISrvselfcaitmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 服务自定义分类项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvselfcaitmCudService.class, ISrvselfcaitmRService.class }, binding = Binding.JSONRPC)
public class SrvselfcaitmCrudServiceImpl extends BaseAggService<SrvselfcaitmAggDO, SrvSelfCaItemDO>
		implements ISrvselfcaitmCudService, ISrvselfcaitmRService {

	public SrvselfcaitmCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvSelfCaItemDODesc.class), IAppFwTempTbl.tmp_iaw_01.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(SrvselfcaitmAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
