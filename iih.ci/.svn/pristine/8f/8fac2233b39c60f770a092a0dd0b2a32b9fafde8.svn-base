package iih.ci.ord.ap.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ap.d.desc.CiApSpecAntiRecordDODesc;
import iih.ci.ord.ap.d.CiApSpecAntiRecordDO;
import iih.ci.ord.ap.i.ICiapspecantirecordCudService;
import iih.ci.ord.ap.i.ICiapspecantirecordRService;


/**
 * 特殊级抗菌药物临床应用记录表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiapspecantirecordCudService.class,ICiapspecantirecordRService.class}, binding=Binding.JSONRPC)
public class CiapspecantirecordCrudServiceImpl extends BaseDOService<CiApSpecAntiRecordDO> implements ICiapspecantirecordCudService,ICiapspecantirecordRService {
    public CiapspecantirecordCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiApSpecAntiRecordDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }

	@Override
	public void deleteByIdOrs(String[] id_ors) throws BizException {
		CiApSpecAntiRecordDO[] records = this.findByAttrValStrings(CiApSpecAntiRecordDO.ID_OR, id_ors);
		if(records!=null){
			this.delete(records);
		}
	}
}
