package iih.bd.res.bed.s;

import iih.bd.res.bed.bp.GetAttrValBP;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.BedAggDO;
import iih.bd.res.bed.d.desc.BdbedDesc;
import iih.bd.res.bed.i.IBedCudService;
import iih.bd.res.bed.i.IBedRService;
import iih.bd.res.bed.rule.BedInitCodeRule;
import iih.bd.res.bed.rule.GrpOrgInitRule;
import iih.bd.res.bed.s.rule.BedNameChangedRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 床位管理AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IBedCudService.class, IBedRService.class }, binding = Binding.JSONRPC)
public class BedCrudServiceImpl extends BaseAggService<BedAggDO, Bdbed> implements IBedCudService, IBedRService {

	public BedCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdbedDesc.class), IAppFwTempTbl.tmp_iaw_27.name());
	}

	@Override
	protected void addInsertBeforeRule(AroundProcesser<BedAggDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new IRule[] { new GrpOrgInitRule() });
		processer.addBeforeRule(new IRule[] { new BedInitCodeRule() });
	}

	@Override
	public BedAggDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		// TODO Auto-generated method stub

		BedAggDO[] bedAggs = super.find(whereStr, orderStr, isLazy);
		// if(bedAggs)
		if (ArrayUtil.isEmpty(bedAggs)) {
			return null;
		}
		for (BedAggDO bedAggdo : bedAggs) {
			if (ArrayUtil.isEmpty(bedAggdo.getBedAttrDO()))
				continue;
			GetAttrValBP getvalBP = new GetAttrValBP();
			getvalBP.exe(bedAggdo.getBedAttrDO());
		}
		return bedAggs;
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
	protected Validator[] getUpdateValidator(BedAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<BedAggDO> processor, BedAggDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new BedNameChangedRule<BedAggDO>());
	}
}
