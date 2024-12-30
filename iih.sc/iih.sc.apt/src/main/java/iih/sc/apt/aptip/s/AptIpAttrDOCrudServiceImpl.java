package iih.sc.apt.aptip.s;
import iih.en.pv.entplan.d.EntHpDO;
import iih.sc.apt.aptip.d.AptIpAttrDO;
import iih.sc.apt.aptip.d.desc.AptIpAttrDODesc;
import iih.sc.apt.aptip.i.IAptIpAttrDOCudService;
import iih.sc.apt.aptip.i.IAptIpAttrDORService;
import iih.sc.apt.s.bp.GetValForAptIpAttrDOBP;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 住院预约主实体CRUD服务实现
 */
@Service(serviceInterfaces={IAptIpAttrDOCudService.class,IAptIpAttrDORService.class}, binding=Binding.JSONRPC)
public class AptIpAttrDOCrudServiceImpl extends BaseDOService<AptIpAttrDO> implements IAptIpAttrDOCudService,IAptIpAttrDORService {

    public AptIpAttrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AptIpAttrDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<AptIpAttrDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<AptIpAttrDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<AptIpAttrDO> processor, AptIpAttrDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<AptIpAttrDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<AptIpAttrDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<AptIpAttrDO>(EuOperTp.DELETE));
    }
    //TODO 需单独定义服务，不能重写生成服务，yank 2017-02-06
    @Override
    public AptIpAttrDO[] find(String whereStr, String orderStr, FBoolean isLazy)
    		throws BizException {
    	// TODO Auto-generated method stub
    	AptIpAttrDO[] aptIpAttrDOs = super.find(whereStr, orderStr, isLazy);
    	if(ArrayUtil.isEmpty(aptIpAttrDOs))
    		return null;
    	GetValForAptIpAttrDOBP getvalBP = new GetValForAptIpAttrDOBP();
    	getvalBP.exe(aptIpAttrDOs);
    	return aptIpAttrDOs;
    }
    
}

