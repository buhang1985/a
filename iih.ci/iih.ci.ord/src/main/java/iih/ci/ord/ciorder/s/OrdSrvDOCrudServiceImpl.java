package iih.ci.ord.ciorder.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床医嘱主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdSrvDOCudService.class,IOrdSrvDORService.class}, binding=Binding.JSONRPC)
public class OrdSrvDOCrudServiceImpl extends BaseDOService<OrdSrvDO> implements IOrdSrvDOCudService,IOrdSrvDORService {

    public OrdSrvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdSrvDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
//0187604: 临床路径直接开立的情况下，如果有错误信息，在医嘱列表上显示   允许开立频次为空的数据，设置erro_level标记错误信息
//	@Override
//	public OrdSrvDO[] save(OrdSrvDO... dos) throws BizException {
//		//20190528 增加原因：兰陵现场出现ci_or_srv表中频次id_freq为空的情况，无法定位原因，且目前一共有72条数据异常数据（极少一部分），不是必现的；所以在保存服务之前添加了一个校验
//		for(OrdSrvDO srv : dos){
//			if(CiOrdUtils.isEmpty(srv.getId_freq())){
//				throw new BizException("保存医嘱时，服务【"+srv.getName()+"】频次为空，不允许保存！");
//			}
//		}
//		return super.save(dos);
//	}
    
}

