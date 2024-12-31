package iih.pi.dic.phyind.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.dic.phyind.d.desc.PiPatPhyIndDODesc;
import iih.pi.dic.phyind.d.PiPatPhyIndDO;
import iih.pi.dic.phyind.i.IPhyindMDOCudService;
import iih.pi.dic.phyind.i.IPhyindMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者生理指标主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPhyindMDOCudService.class,IPhyindMDORService.class}, binding=Binding.JSONRPC)
public class PhyindMDOCrudServiceImpl extends BaseDOService<PiPatPhyIndDO> implements IPhyindMDOCudService,IPhyindMDORService {

    public PhyindMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatPhyIndDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

