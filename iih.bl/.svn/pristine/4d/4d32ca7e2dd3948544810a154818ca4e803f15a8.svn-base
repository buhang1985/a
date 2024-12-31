package iih.bl.hp.blhppatspec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.blhppatspec.d.desc.BlHpPatSpecDODesc;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import iih.bl.hp.blhppatspec.i.IBlhppatspecMDOCudService;
import iih.bl.hp.blhppatspec.i.IBlhppatspecMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医保特殊病患者主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlhppatspecMDOCudService.class,IBlhppatspecMDORService.class}, binding=Binding.JSONRPC)
public class BlhppatspecMDOCrudServiceImpl extends BaseDOService<BlHpPatSpecDO> implements IBlhppatspecMDOCudService,IBlhppatspecMDORService {

    public BlhppatspecMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpPatSpecDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

