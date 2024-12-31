package iih.pi.reg.pat.s;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.pat.s.rule.ChangePhotoFormatRule;
import iih.pi.reg.pat.s.rule.CheckPatDataWhenInsertRule;
import iih.pi.reg.pat.s.rule.CheckPatDataWhenUpdateRule;
import iih.pi.reg.pat.s.rule.CreatePatAccRule;
import iih.pi.reg.pat.s.rule.CreatePatMhRule;
import iih.pi.reg.pat.s.rule.CreatePatPsnRule;
import iih.pi.reg.pat.s.rule.DispCardWhenInsertPatCardRule;
import iih.pi.reg.pat.s.rule.EncryptPatPwdBeforeInsertRule;
import iih.pi.reg.pat.s.rule.EncryptPatPwdBeforeUpdateRule;
import iih.pi.reg.pat.s.rule.InsertPatToChisRule;
import iih.pi.reg.pat.s.rule.PatChangedRecordRule;
import iih.pi.reg.pat.s.rule.PatTagInsertRule;
import iih.pi.reg.pat.s.rule.PatTagUpdateRule;
import iih.pi.reg.pat.s.rule.SetPatDefaultValueWhenInsertRule;
import iih.pi.reg.pat.s.rule.SetPatDefaultValueWhenUpdateRule;
import iih.pi.reg.pat.s.rule.SyncEnPatInfoRule;
import iih.pi.reg.pat.s.rule.UpdateChisPatRule;
import iih.pi.reg.pat.s.validator.CheckNullValidator;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 患者基本信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPatiCudService.class, IPatiRService.class }, binding = Binding.JSONRPC)
public class PatiCrudServiceImpl extends BaseAggService<PatiAggDO, PatDO> implements IPatiCudService, IPatiRService {

	public PatiCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PatDODesc.class), IAppFwTempTbl.tmp_iaw_29.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<PatiAggDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new SetPatDefaultValueWhenInsertRule<PatiAggDO>());
		processer.addBeforeRule(new EncryptPatPwdBeforeInsertRule());
		processer.addBeforeRule(new CheckPatDataWhenInsertRule<PatiAggDO>());
		processer.addBeforeRule(new DispCardWhenInsertPatCardRule());
		processer.addBeforeRule(new InsertPatToChisRule());
		processer.addBeforeRule(new ChangePhotoFormatRule<PatiAggDO>());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<PatiAggDO> processer, PatiAggDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new SetPatDefaultValueWhenUpdateRule<PatiAggDO>());
		processer.addBeforeRule(new EncryptPatPwdBeforeUpdateRule());
		processer.addBeforeRule(new CheckPatDataWhenUpdateRule<PatiAggDO>());
		processer.addBeforeRule(new DispCardWhenInsertPatCardRule());
		processer.addBeforeRule(new UpdateChisPatRule());
		processer.addBeforeRule(new ChangePhotoFormatRule<PatiAggDO>());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<PatiAggDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new CreatePatAccRule<PatiAggDO>());
		processor.addAfterRule(new CreatePatPsnRule());
		processor.addAfterRule(new CreatePatMhRule());
		processor.addAfterFinalRule(new PatTagInsertRule());
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<PatiAggDO> processor, PatiAggDO[] originvos) {

		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new PatChangedRecordRule<PatiAggDO>());
		processor.addAfterRule(new SyncEnPatInfoRule<PatiAggDO>());
		processor.addAfterRule(new PatTagUpdateRule());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new CheckNullValidator() };
	}
}
