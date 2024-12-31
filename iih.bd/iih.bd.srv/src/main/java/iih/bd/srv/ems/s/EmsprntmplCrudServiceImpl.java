package iih.bd.srv.ems.s;

import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.bd.srv.ems.d.desc.EmsPrnTmplDODesc;
import iih.bd.srv.ems.i.IEmsprntmplCudService;
import iih.bd.srv.ems.i.IEmsprntmplRService;
import iih.bd.srv.ems.s.validator.EmsPrnTmplRelPresDODataValidate;
import iih.bd.srv.ems.s.validator.EmsPrnTmplRelSrvDODataValidate;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗单打印模板管理AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmsprntmplCudService.class, IEmsprntmplRService.class }, binding = Binding.JSONRPC)
public class EmsprntmplCrudServiceImpl extends BaseAggService<EmsprntmplAggDO, EmsPrnTmplDO>
		implements IEmsprntmplCudService, IEmsprntmplRService {
	public EmsprntmplCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmsPrnTmplDODesc.class), IAppFwTempTbl.tmp_iaw_02.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), new EmsPrnTmplRelSrvDODataValidate(),
				new EmsPrnTmplRelPresDODataValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmsprntmplAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), new EmsPrnTmplRelSrvDODataValidate(),
				new EmsPrnTmplRelPresDODataValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
