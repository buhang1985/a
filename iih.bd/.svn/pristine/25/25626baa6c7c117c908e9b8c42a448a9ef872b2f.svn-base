package iih.bd.pp.statvsacca.s;
import iih.bd.pp.statvsacca.d.StatVsaCcaDO;
import iih.bd.pp.statvsacca.d.desc.StatVsaCcaDODesc;
import iih.bd.pp.statvsacca.i.IStatvsaccaCudService;
import iih.bd.pp.statvsacca.i.IStatvsaccaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 自定义统计分类与核算科目对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IStatvsaccaCudService.class,IStatvsaccaRService.class}, binding=Binding.JSONRPC)
public class StatvsaccaCrudServiceImpl extends TreeBaseDOService<StatVsaCcaDO> implements IStatvsaccaCudService,IStatvsaccaRService {
    public StatvsaccaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(StatVsaCcaDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(StatVsaCcaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
