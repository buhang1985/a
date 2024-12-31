package iih.mi.mc.mimcpatspec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mc.mimcpatspec.d.desc.MiMcPatSpecDODesc;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDO;
import iih.mi.mc.mimcpatspec.i.IMimcpatspecdiMDOCudService;
import iih.mi.mc.mimcpatspec.i.IMimcpatspecdiMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医保特殊病患者维护主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMimcpatspecdiMDOCudService.class,IMimcpatspecdiMDORService.class}, binding=Binding.JSONRPC)
public class MimcpatspecdiMDOCrudServiceImpl extends BaseDOService<MiMcPatSpecDO> implements IMimcpatspecdiMDOCudService,IMimcpatspecdiMDORService {

    public MimcpatspecdiMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcPatSpecDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

