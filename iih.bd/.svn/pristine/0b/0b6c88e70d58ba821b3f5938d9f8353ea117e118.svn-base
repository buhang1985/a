package iih.bd.res.bizgrp.s;
import iih.bd.res.bizgrp.d.BizGrpBedDO;
import iih.bd.res.bizgrp.d.desc.BizGrpBedDODesc;
import iih.bd.res.bizgrp.i.IBizGrpBedDOCudService;
import iih.bd.res.bizgrp.i.IBizGrpBedDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 业务组主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBizGrpBedDOCudService.class,IBizGrpBedDORService.class}, binding=Binding.JSONRPC)
public class BizGrpBedDOCrudServiceImpl extends BaseDOService<BizGrpBedDO> implements IBizGrpBedDOCudService,IBizGrpBedDORService {

    public BizGrpBedDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BizGrpBedDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

