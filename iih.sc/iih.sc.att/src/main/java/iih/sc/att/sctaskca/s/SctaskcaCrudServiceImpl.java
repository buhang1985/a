package iih.sc.att.sctaskca.s;

import iih.sc.att.sctaskca.d.ScTaskCaDO;
import iih.sc.att.sctaskca.d.desc.ScTaskCaDODesc;
import iih.sc.att.sctaskca.i.ISctaskcaCudService;
import iih.sc.att.sctaskca.i.ISctaskcaRService;
import iih.sc.comm.rule.GrpOrgInitRule;

import java.util.Arrays;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 考勤类型分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISctaskcaCudService.class, ISctaskcaRService.class }, binding = Binding.JSONRPC)
public class SctaskcaCrudServiceImpl extends BaseDOService<ScTaskCaDO> implements
		ISctaskcaCudService, ISctaskcaRService {


	public SctaskcaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ScTaskCaDODesc.class), IAppFwTempTbl.tmp_iaw_26
				.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] {
				new BDUniqueRuleValidate(),
				NullValueValidator.createMDNullValueValidator(new ScTaskCaDO().getDODesc(),
						Arrays.asList(ScTaskCaDO.NAME, ScTaskCaDO.CODE, ScTaskCaDO.EU_TASKTP)) };
	}

	@Override
	protected Validator[] getUpdateValidator(ScTaskCaDO[] oldDOs) {
		return new Validator[] {
				new BDUniqueRuleValidate(),
				NullValueValidator.createMDNullValueValidator(new ScTaskCaDO().getDODesc(),
						Arrays.asList(ScTaskCaDO.NAME, ScTaskCaDO.CODE, ScTaskCaDO.EU_TASKTP)) };
	}

}
