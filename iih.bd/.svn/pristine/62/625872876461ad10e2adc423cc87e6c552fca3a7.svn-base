package iih.bd.srv.medsrv.s;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.desc.MedSrvSetItemDODesc;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.s.rule.CalMedSrvSetItmChkNumRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IMedSrvSetItemDOCudService.class,
		IMedSrvSetItemDORService.class }, binding = Binding.JSONRPC)
public class MedSrvSetItemDOCrudServiceImpl extends BaseDOService<MedSrvSetItemDO>
		implements IMedSrvSetItemDOCudService, IMedSrvSetItemDORService {

	public MedSrvSetItemDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedSrvSetItemDODesc.class), IAppFwTempTbl.tmp_iaw_01.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<MedSrvSetItemDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new CalMedSrvSetItmChkNumRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<MedSrvSetItemDO> processor, MedSrvSetItemDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new CalMedSrvSetItmChkNumRule());
	}
}
