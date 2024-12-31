package iih.mi.mibd.drugdircomp.s;
import iih.mi.mibd.drugdircomp.d.DrugDirCompDTO;
import iih.mi.mibd.drugdircomp.i.IDrugdircompExtCudService;
import iih.mi.mibd.drugdircomp.i.IDrugdircompExtRService;
import iih.mi.mibd.drugdircomp.s.bp.AutoCompDrugBp;
import iih.mi.mibd.drugdircomp.s.bp.DeleteDrugCompBp;
import iih.mi.mibd.drugdircomp.s.bp.FindDrugDirCompBp;
import iih.mi.mibd.drugdircomp.s.bp.SaveDrugCompBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保平台_药品对照AggDO数据CRUD服务实现
 *@author hexx
 */
public class DrugdircompExtCrudServiceImpl  implements IDrugdircompExtCudService,IDrugdircompExtRService {
	
	/**
	 * 药品对照信息查询服务
	 * 
	 * @param qryRootNodeDto
	 * @param mis_id
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<DrugDirCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String misId,
			PaginationInfo pg) throws BizException {
		
		FindDrugDirCompBp bp = new FindDrugDirCompBp();
		PagingRtnData<DrugDirCompDTO> result = bp.exec(qryRootNodeDto, misId, pg);
		return result;
	}

	/**
	 * 保存诊疗项目对照
	 * 
	 * @param drugdirCompDTOs
	 *           药品对照信息
	 * @throws BizException
	 */
	@Override
	public DrugDirCompDTO[] saveDrugComp(String misId,DrugDirCompDTO[] drugdirCompDTOs) throws BizException {
		SaveDrugCompBp bp = new SaveDrugCompBp();
		DrugDirCompDTO[] result = bp.exec(misId,drugdirCompDTOs);
		return result;
	}

	/**  
	* @Title: autoComp  
	* @Description: 自动对照
	* @param misId   
	 * @throws BizException 
	*/
	@Override
	public void autoComp(String misId) throws BizException {
		AutoCompDrugBp bp = new AutoCompDrugBp();
		bp.exec(misId);
	}

	/**  
	* @Title: deleteDrugComp  
	* @Description:删除对照
	* @param drugdirCompDTOs   
	 * @throws BizException 
	*/
	@Override
	public DrugDirCompDTO[] deleteDrugComp(String misId,DrugDirCompDTO[] drugdirCompDTOs) throws BizException {
		DeleteDrugCompBp bp = new DeleteDrugCompBp();
		DrugDirCompDTO[] result = bp.exec(misId,drugdirCompDTOs);
		return result;
	}	
}
