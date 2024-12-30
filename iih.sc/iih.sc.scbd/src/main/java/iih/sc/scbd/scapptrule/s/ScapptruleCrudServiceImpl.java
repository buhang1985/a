package iih.sc.scbd.scapptrule.s;

import java.util.Arrays;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import iih.sc.scbd.scapptrule.d.desc.ScapptruleDODesc;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.comm.rule.GrpOrgInitRule;
import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import iih.sc.scbd.scapptrule.i.IScapptruleCudService;
import iih.sc.scbd.scapptrule.i.IScapptruleRService;

/**
 * 排班预约规则AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IScapptruleCudService.class,
		IScapptruleRService.class }, binding = Binding.JSONRPC)
public class ScapptruleCrudServiceImpl extends BaseDOService<ScapptruleDO>
		implements IScapptruleCudService, IScapptruleRService {
	@Override
	/**
	 * 修改唯一性校验
	 */
	protected Validator[] getUpdateValidator(ScapptruleDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	/**
	 * 新增唯一性校验
	 */
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	public ScapptruleCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ScapptruleDODesc.class),
				IAppFwTempTbl.tmp_iaw_04.name());
	}
    /**
     * 删除校验
     */
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
			BDReferenceChecker.getInstance()
		};
	}

}
