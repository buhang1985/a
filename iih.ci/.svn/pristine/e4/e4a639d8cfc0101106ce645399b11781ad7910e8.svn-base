package iih.ci.mrqc.mrconnotationqc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.mrconnotationqc.d.desc.MrConnotationQcDODesc;
import iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcDO;
import iih.ci.mrqc.mrconnotationqc.i.IMrconnotationqcMDOCudService;
import iih.ci.mrqc.mrconnotationqc.i.IMrconnotationqcMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * mrconnotationqcdo主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrconnotationqcMDOCudService.class,IMrconnotationqcMDORService.class}, binding=Binding.JSONRPC)
public class MrconnotationqcMDOCrudServiceImpl extends BaseDOService<MrConnotationQcDO> implements IMrconnotationqcMDOCudService,IMrconnotationqcMDORService {

    public MrconnotationqcMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrConnotationQcDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

