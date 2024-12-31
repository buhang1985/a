package iih.bd.srv.mrtplseg.s;

import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.d.desc.MrTplSegmentDODesc;
import iih.bd.srv.mrtplseg.i.IMrtplsegCudService;
import iih.bd.srv.mrtplseg.i.IMrtplsegRService;
import iih.bd.srv.mrtplseg.s.rule.DelStreamBeforeDelSegmentRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗记录片段模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMrtplsegCudService.class, IMrtplsegRService.class }, binding = Binding.JSONRPC)
public class MrtplsegCrudServiceImpl extends BaseDOService<MrTplSegmentDO>
		implements IMrtplsegCudService, IMrtplsegRService {

	public MrtplsegCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrTplSegmentDODesc.class), IAppFwTempTbl.tmp_iaw_18.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance(new String[]{"bd_mrtpl_sec_fs"}) };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MrTplSegmentDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<MrTplSegmentDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new DelStreamBeforeDelSegmentRule());
	}
}
