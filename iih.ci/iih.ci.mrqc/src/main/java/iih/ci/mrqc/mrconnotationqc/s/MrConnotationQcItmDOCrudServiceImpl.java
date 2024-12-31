package iih.ci.mrqc.mrconnotationqc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.mrconnotationqc.d.desc.MrConnotationQcItmDODesc;
import iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcItmDO;
import iih.ci.mrqc.mrconnotationqc.i.IMrConnotationQcItmDOCudService;
import iih.ci.mrqc.mrconnotationqc.i.IMrConnotationQcItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * mrconnotationqcdo主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrConnotationQcItmDOCudService.class,IMrConnotationQcItmDORService.class}, binding=Binding.JSONRPC)
public class MrConnotationQcItmDOCrudServiceImpl extends BaseDOService<MrConnotationQcItmDO> implements IMrConnotationQcItmDOCudService,IMrConnotationQcItmDORService {

    public MrConnotationQcItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrConnotationQcItmDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

