package iih.bd.mm.meterial.s;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.mm.meterial.i.IMeterialMDOCudService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.meterial.s.rule.MaterialPropChangCheckRule;
import iih.bd.mm.meterial.s.rule.MaterialPropChangSetSrvRule;
import iih.bd.mm.meterial.s.rule.MeterialAfterInsertOrUpdateRule;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗物品AggDO数据CRUD服务实现
 */
public class MeterialMDOCrudServiceImpl extends BaseDOService<MeterialDO> implements IMeterialMDOCudService, IMeterialMDORService {

	public MeterialMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MeterialDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<MeterialDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new MeterialAfterInsertOrUpdateRule());
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<MeterialDO> processer, MeterialDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new MeterialAfterInsertOrUpdateRule());
		processer.addAfterRule(new MaterialPropChangSetSrvRule());
	}

	@Override
	public MeterialDO findById(String id) throws BizException {

		MeterialDO meterialDO = super.findById(id);
		if (meterialDO == null) {

			return null;
		}

		setupDOAfterSearch(meterialDO);
		return meterialDO;
	}

	private void setupDOAfterSearch(MeterialDO meterialDO) throws BizException {

		IMeterialService iMeterialService = ServiceFinder.find(IMeterialService.class);
		iMeterialService.getMedSrvInfo(new MeterialDO[] { meterialDO });
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MeterialDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MeterialDO> processer, MeterialDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new MaterialPropChangCheckRule());
	}
}
