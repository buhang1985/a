package iih.ci.mr.cimrsfmsec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrsfmsec.d.desc.CimrsfmsecDODesc;
import iih.ci.mr.cimrsfmsec.d.CimrsfmsecDO;
import iih.ci.mr.cimrsfmsec.i.ICimrsfmsecMDOCudService;
import iih.ci.mr.cimrsfmsec.i.ICimrsfmsecMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医疗记录智能表单段落主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICimrsfmsecMDOCudService.class,ICimrsfmsecMDORService.class}, binding=Binding.JSONRPC)
public class CimrsfmsecMDOCrudServiceImpl extends BaseDOService<CimrsfmsecDO> implements ICimrsfmsecMDOCudService,ICimrsfmsecMDORService {

    public CimrsfmsecMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CimrsfmsecDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

