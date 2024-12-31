package iih.bd.srv.mrfpbltype.s;

import iih.bd.srv.mrfpbltype.d.MrFpBlTypeDO;
import iih.bd.srv.mrfpbltype.d.MrfpbltypeAggDO;
import iih.bd.srv.mrfpbltype.d.desc.MrFpBlTypeDODesc;
import iih.bd.srv.mrfpbltype.i.IMrfpbltypeCudService;
import iih.bd.srv.mrfpbltype.i.IMrfpbltypeRService;
import iih.bd.srv.mrfpbltype.s.rule.MrfpbltypeAggBeforeInsertOrUpdateRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.TreeBaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 病案首页费用分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMrfpbltypeCudService.class, IMrfpbltypeRService.class }, binding = Binding.JSONRPC)
public class MrfpbltypeCrudServiceImpl extends TreeBaseAggService<MrfpbltypeAggDO, MrFpBlTypeDO>
		implements IMrfpbltypeCudService, IMrfpbltypeRService {
	public MrfpbltypeCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrFpBlTypeDODesc.class), IAppFwTempTbl.tmp_iaw_09.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MrfpbltypeAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<MrfpbltypeAggDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new MrfpbltypeAggBeforeInsertOrUpdateRule());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MrfpbltypeAggDO> processor, MrfpbltypeAggDO[] originvos) {
		super.addUpdateBeforeRule(processor, originvos);
		processor.addBeforeRule(new MrfpbltypeAggBeforeInsertOrUpdateRule());
	}
}
