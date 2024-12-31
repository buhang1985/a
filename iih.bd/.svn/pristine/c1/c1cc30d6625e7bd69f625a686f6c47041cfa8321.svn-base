package iih.bd.res.bizgrp.s;

import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.res.bizgrp.d.BizgrpAggDO;
import iih.bd.res.bizgrp.d.desc.BizGroupDODesc;
import iih.bd.res.bizgrp.i.IBizgrpCudService;
import iih.bd.res.bizgrp.i.IBizgrpRService;
import iih.bd.res.bizgrp.s.bp.UpdateBizGrpBedBp;
import iih.bd.res.bizgrp.s.rule.EmpLeaderCheckRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 业务组AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IBizgrpCudService.class, IBizgrpRService.class }, binding = Binding.JSONRPC)
public class BizgrpCrudServiceImpl extends BaseAggService<BizgrpAggDO, BizGroupDO>
		implements IBizgrpCudService, IBizgrpRService {

	public BizgrpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BizGroupDODesc.class), IAppFwTempTbl.tmp_iaw_24.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(BizgrpAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@Override
	public BizgrpAggDO findById(String id) throws BizException {
		BizgrpAggDO bizgrpAggDO = super.findById(id);
		UpdateBizGrpBedBp bp = new UpdateBizGrpBedBp();
		bp.exec(bizgrpAggDO);
		return bizgrpAggDO;
	}
	
	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<BizgrpAggDO> processer, BizgrpAggDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new EmpLeaderCheckRule());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<BizgrpAggDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new EmpLeaderCheckRule());
	}
}
