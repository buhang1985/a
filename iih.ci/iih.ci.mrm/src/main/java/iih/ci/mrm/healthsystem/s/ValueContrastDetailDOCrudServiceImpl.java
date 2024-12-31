package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mrm.healthsystem.d.desc.ValueContrastDetailDODesc;
import iih.ci.mrm.healthsystem.d.ValueContrastDetailDO;
import iih.ci.mrm.healthsystem.i.IValueContrastDetailDOCudService;
import iih.ci.mrm.healthsystem.i.IValueContrastDetailDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 对照主实体CRUD服务实现
 */
@Service(serviceInterfaces={IValueContrastDetailDOCudService.class,IValueContrastDetailDORService.class}, binding=Binding.JSONRPC)
public class ValueContrastDetailDOCrudServiceImpl extends BaseDOService<ValueContrastDetailDO> implements IValueContrastDetailDOCudService,IValueContrastDetailDORService {

    public ValueContrastDetailDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ValueContrastDetailDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    /**
 	 * (自定义)根据查询模板条件、分页信息查询分页数据集合；
 	 * 与自动服务相比会自动计算序号
 	 * @param qryRootNodeDTO
 	 * @param orderStr
 	 * @param pg
 	 * @return
 	 * @throws BizException
 	 */
 	public PagingRtnData<ValueContrastDetailDO> findByQCondAndPageInfoCustom(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException
 	{
 		PagingRtnData<ValueContrastDetailDO> lst = this.findByQCondAndPageInfo( qryRootNodeDTO, orderStr, pg) ;
 		//根据页码和数据条数计算本页序号
 		if(lst !=null&&lst.getPageData()!=null)
 		{
 			int i =1;
 			for(Object det : 	lst.getPageData())
 			{
 				ValueContrastDetailDO cndt = (ValueContrastDetailDO)det;
 				if(cndt!=null)
 				{
 					int sort = lst.getPagingInfo().getPageIndex()*lst.getPagingInfo().getPageCount()+i;
 					cndt.setSerial_number(sort);
 					i++;
 				}
 			} 			
 		}
 		return lst;
 	}
 	/**
	*  (自定义)根据分页信息及查询与分组条件获得分页数据
	*  与自动服务相比会自动计算序号
	*/
	public  PagingRtnData<ValueContrastDetailDO> findByPageInfoCustom(PaginationInfo pg, String wherePart,String orderByPart) throws BizException
	{
		PagingRtnData<ValueContrastDetailDO> lst = this.findByPageInfo( pg, wherePart, orderByPart) ;
 		//根据页码和数据条数计算本页序号
 		if(lst !=null&&lst.getPageData()!=null)
 		{
 			int i =1;
 			for(Object det : 	lst.getPageData())
 			{
 				ValueContrastDetailDO cndt = (ValueContrastDetailDO)det;
 				if(cndt!=null)
 				{
 					int sort = lst.getPagingInfo().getPageIndex()*lst.getPagingInfo().getPageSize()+i;
 					cndt.setSerial_number(sort);
 					i++;
 				}
 			} 			
 		}
 		return lst;
		
	}
	
}

