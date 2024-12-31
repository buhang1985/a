package iih.bd.mm.meterial.s;

import iih.bd.mm.meterial.bp.MaterialReAfterBp;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.mm.meterial.i.IMeterialCudService;
import iih.bd.mm.meterial.i.IMeterialRService;
import iih.bd.mm.meterial.s.rule.MaterialPropChangCheckRule;
import iih.bd.mm.meterial.s.rule.MeterialAggAfterDeleteRule;
import iih.bd.mm.meterial.s.rule.MeterialAggAfterInsertOrUpdateRule;
import iih.bd.mm.meterial.s.rule.MeterialAggBeforeDeleteRule;
import iih.bd.mm.meterial.s.rule.MeterialAggBeforeInsertRule;
import iih.bd.mm.meterial.s.rule.MeterialAggBeforeUpdateRule;
import iih.bd.mm.meterial.s.rule.VirtualStockInRule;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗物品AggDO数据CRUD服务实现
 */
public class MeterialCrudServiceImpl extends BaseAggService<MeterialAggDO, MeterialDO>
		implements IMeterialCudService, IMeterialRService {

	public MeterialCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MeterialDODesc.class), IAppFwTempTbl.tmp_iaw_22.name());
	}

	@Override
	public void delete(MeterialAggDO[] aggs) throws BizException {
		// TODO Auto-generated method stub
		MeterialAggDO[] meterialAggDOs =super.update(aggs);
		EventDispatcher.fireEvent(new BDCommonEvent("iih.bd.mm.meterial.d.MeterialAggDO","190713",null,aggs));
	}
	@Override
	public MeterialAggDO[] insert(MeterialAggDO[] arg0) throws BizException {
		// TODO Auto-generated method stub
		MeterialAggDO[] meterialAggDOs =super.insert(arg0);
		EventDispatcher.fireEvent(new BDCommonEvent("iih.bd.mm.meterial.d.MeterialAggDO","190712",null,arg0));
		return meterialAggDOs;
	}
	@Override
	public MeterialAggDO[] update(MeterialAggDO[] aggs) throws BizException {
		// TODO Auto-generated method stub
		MeterialAggDO[] meterialAggDOs =super.update(aggs);
		EventDispatcher.fireEvent(new BDCommonEvent("iih.bd.mm.meterial.d.MeterialAggDO","190711",null,aggs));
		return meterialAggDOs;
	}
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<MeterialAggDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new MeterialAggBeforeInsertRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MeterialAggDO> processer, MeterialAggDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new MeterialAggBeforeUpdateRule());
		processer.addBeforeRule(new MaterialPropChangCheckRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<MeterialAggDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new MeterialAggAfterInsertOrUpdateRule());
		processor.addAfterRule(new VirtualStockInRule());
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<MeterialAggDO> processer, MeterialAggDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new MeterialAggAfterInsertOrUpdateRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<MeterialAggDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new MeterialAggBeforeDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<MeterialAggDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new MeterialAggBeforeDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteAfterRule(AroundProcesser<MeterialAggDO> processer) {
		super.addLogicDeleteAfterRule(processer);
		processer.addAfterRule(new MeterialAggAfterDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<MeterialAggDO> processer) {
		super.addRealDeleteAfterRule(processer);
		processer.addAfterRule(new MeterialAggAfterDeleteRule());
	}

	@Override
	public MeterialAggDO findById(String id) throws BizException {

		MeterialAggDO meterialAggDO = super.findById(id);
		if (meterialAggDO == null) {

			return meterialAggDO;
		}

		MaterialReAfterBp bp = new MaterialReAfterBp();
		bp.exec(new MeterialAggDO[] { meterialAggDO });

		return meterialAggDO;
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
	protected Validator[] getUpdateValidator(MeterialAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
