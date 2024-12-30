package iih.sc.scbd.scdeptparam.s;

import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScAggLogRule;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.scdeptparam.d.desc.ScDeptParamDODesc;
import iih.sc.scbd.scdeptparam.d.desc.ScDeptParamDsDODesc;
import iih.sc.scbd.scdeptparam.i.IScdeptparamCudService;
import iih.sc.scbd.scdeptparam.i.IScdeptparamRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;

/**
 * 排班科室参数AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IScdeptparamCudService.class, IScdeptparamRService.class }, binding = Binding.JSONRPC)
public class ScdeptparamCrudServiceImpl extends BaseAggService<ScdeptparamAggDO, ScDeptParamDO> implements
		IScdeptparamCudService, IScdeptparamRService {
	public ScdeptparamCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ScDeptParamDODesc.class), IAppFwTempTbl.tmp_iaw_27.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance(new String[] { ScDeptParamDsDODesc.TABLE_NAME },
				true, false) };
	}
	 //新增
    @Override
    protected void addInsertAfterRule(AroundProcesser<ScdeptparamAggDO> processor) {
    	// TODO Auto-generated method stub
    	super.addInsertAfterRule(processor);
    	// 记录业务日志
    	processor.addAfterRule(new ScAggLogRule<ScdeptparamAggDO>(EuOperTp.INSERT));
    }
    //更新
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScdeptparamAggDO> processor, ScdeptparamAggDO[] originvos) {
    	// TODO Auto-generated method stub
    	super.addUpdateAfterRule(processor, originvos);
    	// 记录业务日志
    	processor.addAfterRule(new ScAggLogRule<ScdeptparamAggDO>(EuOperTp.UPDATE, originvos));
    }
    //删除
    @SuppressWarnings("unchecked")
	@Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScdeptparamAggDO> processor) {
    	// TODO Auto-generated method stub
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<ScdeptparamAggDO>(EuOperTp.DELETE));
    }
}
