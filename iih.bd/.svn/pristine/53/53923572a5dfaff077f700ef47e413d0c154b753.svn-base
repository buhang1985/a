package iih.bd.srv.medsrv.s;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.s.bp.MedSrvSetAccSrvBp;
import iih.bd.srv.medsrv.s.rule.CalMedSrvSetItmChkNumRule;
import iih.bd.srv.medsrv.s.rule.DelAccountSrvBeforeDelMedSrvMDORule;
import iih.bd.srv.medsrv.s.rule.DelIncCaItmRelBeforeDelMedSrvMDORule;
import iih.bd.srv.medsrv.s.rule.DelPriSrvBeforeDelMedSrvRule;
import iih.bd.srv.medsrv.s.rule.MedSrvInsertOrUpdateBeforeRule;
import iih.bd.srv.medsrv.s.rule.MedSrvPropChangCheckRule;
import iih.bd.srv.medsrv.s.rule.updatesrvpricetable.UpdateSrvPriceTableAfterUpdateRule;
import iih.bd.srv.medsrv.s.rule.updatesrvpricetable.UpdateSrvPriceTableRule;
import iih.bd.srv.medsrv.s.validator.MedSrvCodeLengthValidate;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IMedsrvMDOCudService.class, IMedsrvMDORService.class }, binding = Binding.JSONRPC)
public class MedsrvMDOCrudServiceImpl extends BaseDOService<MedSrvDO>
		implements IMedsrvMDOCudService, IMedsrvMDORService {

	public MedsrvMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedSrvDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
	}

	@Override
	public PagingRtnData<MedSrvDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		PagingRtnData<MedSrvDO> admlist = super.findByPageInfo(pg, wherePart, orderByPart);
		MedSrvSetAccSrvBp bp = new MedSrvSetAccSrvBp();
		bp.exec(admlist);
		return admlist;
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new MedSrvCodeLengthValidate(), new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MedSrvDO[] oldDOs) {
		return new Validator[] { new MedSrvCodeLengthValidate(), new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker
				.getInstance(new String[] { new IncCaItmRelDO().getTableName(), new HPSrvorcaDO().getTableName() }) };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<MedSrvDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new MedSrvInsertOrUpdateBeforeRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MedSrvDO> processer, MedSrvDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new MedSrvInsertOrUpdateBeforeRule());
		processer.addBeforeRule(new MedSrvPropChangCheckRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<MedSrvDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new CalMedSrvSetItmChkNumRule());
		processor.addAfterRule(new UpdateSrvPriceTableRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<MedSrvDO> processor, MedSrvDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new CalMedSrvSetItmChkNumRule());
		processor.addAfterRule(new UpdateSrvPriceTableAfterUpdateRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<MedSrvDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new DelIncCaItmRelBeforeDelMedSrvMDORule());
		processer.addBeforeRule(new DelAccountSrvBeforeDelMedSrvMDORule());
		processer.addBeforeRule(new DelPriSrvBeforeDelMedSrvRule(FBoolean.TRUE));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<MedSrvDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new DelIncCaItmRelBeforeDelMedSrvMDORule());
		processer.addBeforeRule(new DelAccountSrvBeforeDelMedSrvMDORule());
		processer.addBeforeRule(new DelPriSrvBeforeDelMedSrvRule(FBoolean.FALSE));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<MedSrvDO> processor) {
		super.addRealDeleteAfterRule(processor);
		processor.addAfterRule(new UpdateSrvPriceTableRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteAfterRule(AroundProcesser<MedSrvDO> processor) {
		super.addLogicDeleteAfterRule(processor);
		processor.addAfterRule(new UpdateSrvPriceTableRule());
	}
}
