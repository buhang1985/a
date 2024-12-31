package iih.bd.srv.medsrv.s;

import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import iih.bd.srv.medsrv.d.desc.MedSrvRelMmDODesc;
import iih.bd.srv.medsrv.i.IMedsrvRelMmCudService;
import iih.bd.srv.medsrv.i.IMedsrvRelMmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务关联物品表数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedsrvRelMmCudService.class,IMedsrvRelMmRService.class}, binding=Binding.JSONRPC)
public class MedsrvRelMmCrudServiceImpl extends BaseDOService<MedSrvRelMmDO> implements IMedsrvRelMmCudService,IMedsrvRelMmRService {

	public MedsrvRelMmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvRelMmDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}

}
