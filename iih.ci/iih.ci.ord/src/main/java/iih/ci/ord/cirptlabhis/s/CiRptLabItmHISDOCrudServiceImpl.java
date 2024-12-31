package iih.ci.ord.cirptlabhis.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cirptlabhis.d.desc.CiRptLabItmHISDODesc;
import iih.ci.ord.cirptlabhis.d.CiRptLabItmHISDO;
import iih.ci.ord.cirptlabhis.i.ICiRptLabItmHISDOCudService;
import iih.ci.ord.cirptlabhis.i.ICiRptLabItmHISDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 检验报告单历史主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiRptLabItmHISDOCudService.class,ICiRptLabItmHISDORService.class}, binding=Binding.JSONRPC)
public class CiRptLabItmHISDOCrudServiceImpl extends BaseDOService<CiRptLabItmHISDO> implements ICiRptLabItmHISDOCudService,ICiRptLabItmHISDORService {

    public CiRptLabItmHISDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptLabItmHISDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

