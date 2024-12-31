package iih.bl.hp.blhppatspec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.blhppatspec.d.desc.BlHpPatSpecDiDODesc;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDiDO;
import iih.bl.hp.blhppatspec.i.IBlHpPatSpecDiDOCudService;
import iih.bl.hp.blhppatspec.i.IBlHpPatSpecDiDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医保特殊病患者主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlHpPatSpecDiDOCudService.class,IBlHpPatSpecDiDORService.class}, binding=Binding.JSONRPC)
public class BlHpPatSpecDiDOCrudServiceImpl extends BaseDOService<BlHpPatSpecDiDO> implements IBlHpPatSpecDiDOCudService,IBlHpPatSpecDiDORService {

    public BlHpPatSpecDiDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpPatSpecDiDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

