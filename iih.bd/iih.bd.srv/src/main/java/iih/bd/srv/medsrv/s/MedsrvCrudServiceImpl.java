package iih.bd.srv.medsrv.s;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.pp.accountsrv.d.desc.AccountSrvDODesc;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.srv.medsrv.d.MedSrvAliasDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.medsrv.i.IMedsrvCudService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.medsrv.s.rule.CalMedSrvSetItmChkNumRule;
import iih.bd.srv.medsrv.s.rule.DelAccSrvRelBeforeDelMedSrvRule;
import iih.bd.srv.medsrv.s.rule.DelIncCaItmRelBeforeDelMedSrvRule;
import iih.bd.srv.medsrv.s.rule.DelPriSrvBeforeDelMedSrvRule;
import iih.bd.srv.medsrv.s.rule.MedSrvPropChangCheckRule;
import iih.bd.srv.medsrv.s.rule.MedsrvAggInsertOrUpdateBeforeRule;
import iih.bd.srv.medsrv.s.rule.RemoveGarbageChildDataRule;
import iih.bd.srv.medsrv.s.rule.updatesrvpricetable.UpdateSrvPriceTableByAggAfterUpdateRule;
import iih.bd.srv.medsrv.s.rule.updatesrvpricetable.UpdateSrvPriceTableByAggRule;
import iih.bd.srv.medsrv.s.validator.MedSrvCodeLengthValidate;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.AggNullValueValidator;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMedsrvCudService.class, IMedsrvRService.class }, binding = Binding.JSONRPC)
public class MedsrvCrudServiceImpl extends BaseAggService<MedsrvAggDO, MedSrvDO>
		implements IMedsrvCudService, IMedsrvRService {
	public MedsrvCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedSrvDODesc.class), IAppFwTempTbl.tmp_iaw_06.name());
	}

	protected Validator[] getInsertValidator() {
		Map<IDODesc, List<String>> m = new HashMap<>();
		m.put(new MedSrvDO().getDODesc(), Arrays.asList(MedSrvDO.NAME));
		m.put(new MedSrvAliasDO().getDODesc(), Arrays.asList(MedSrvAliasDO.ALIAS));
		return new Validator[] { new MedSrvCodeLengthValidate(), new BDUniqueRuleValidate(),
				AggNullValueValidator.createMDNullValueValidator(new MedsrvAggDO().getAggDesc(), m)

		};
	}

	@Override
	protected Validator[] getUpdateValidator(MedsrvAggDO[] oldDOs) {
		return new Validator[] { new MedSrvCodeLengthValidate(), new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance(new String[] { new IncCaItmRelDO().getTableName(),
				new HPSrvorcaDO().getTableName(), new PriSrvDO().getTableName(), AccountSrvDODesc.TABLE_NAME }, true,
				false) };
	}

	@Override
	protected Validator[] getLogicDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance(new String[] { new IncCaItmRelDO().getTableName(),
				new HPSrvorcaDO().getTableName(), new PriSrvDO().getTableName(), AccountSrvDODesc.TABLE_NAME }, true,
				false) };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<MedsrvAggDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new RemoveGarbageChildDataRule());
		processer.addBeforeRule(new MedsrvAggInsertOrUpdateBeforeRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MedsrvAggDO> processer, MedsrvAggDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new RemoveGarbageChildDataRule());
		processer.addBeforeRule(new MedsrvAggInsertOrUpdateBeforeRule());
		processer.addBeforeRule(new MedSrvPropChangCheckRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<MedsrvAggDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new CalMedSrvSetItmChkNumRule());
		processor.addAfterRule(new UpdateSrvPriceTableByAggRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<MedsrvAggDO> processor, MedsrvAggDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new CalMedSrvSetItmChkNumRule());
		processor.addAfterRule(new UpdateSrvPriceTableByAggAfterUpdateRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<MedsrvAggDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new DelIncCaItmRelBeforeDelMedSrvRule());
		processer.addBeforeRule(new DelAccSrvRelBeforeDelMedSrvRule());
		processer.addBeforeRule(new DelPriSrvBeforeDelMedSrvRule(FBoolean.TRUE));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<MedsrvAggDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new DelIncCaItmRelBeforeDelMedSrvRule());
		processer.addBeforeRule(new DelAccSrvRelBeforeDelMedSrvRule());
		processer.addBeforeRule(new DelPriSrvBeforeDelMedSrvRule(FBoolean.FALSE));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<MedsrvAggDO> processor) {
		super.addRealDeleteAfterRule(processor);
		processor.addAfterRule(new UpdateSrvPriceTableByAggRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteAfterRule(AroundProcesser<MedsrvAggDO> processor) {
		super.addLogicDeleteAfterRule(processor);
		processor.addAfterRule(new UpdateSrvPriceTableByAggRule());
	}
}
