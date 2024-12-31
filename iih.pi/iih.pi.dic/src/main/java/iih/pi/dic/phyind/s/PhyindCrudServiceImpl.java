package iih.pi.dic.phyind.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import iih.pi.dic.phyind.d.desc.PiPatPhyIndDODesc;
import iih.pi.dic.phyind.d.PhyindAggDO;
import iih.pi.dic.phyind.d.PiPatPhyIndDO;
import iih.pi.dic.phyind.i.IPhyindCudService;
import iih.pi.dic.phyind.i.IPhyindRService;


/**
 * 患者生理指标AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPhyindCudService.class,IPhyindRService.class}, binding=Binding.JSONRPC)
public class PhyindCrudServiceImpl extends BaseAggService<PhyindAggDO,PiPatPhyIndDO> implements IPhyindCudService,IPhyindRService {

    public PhyindCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatPhyIndDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }

    @Override
  	protected Validator[] getDeleteValidator() {
  		return new Validator[] {
  				AggBDReferenceChecker.getInstance(new String[] {"pi_pat_phyindopt"},true,false)
  		};
  	}
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] {
  				new BDUniqueRuleValidate()
  		};
    }
    
    @Override
    protected Validator[] getUpdateValidator(PhyindAggDO[] oldDOs) {
    	return new Validator[] {
  				new BDUniqueRuleValidate()
  		};
    }
}

