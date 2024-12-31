package iih.mi.mibd.treatdircomp.s;

import iih.mi.mibd.treatdircomp.d.TreatDirCompDTO;
import iih.mi.mibd.treatdircomp.i.ITreatdircompExtCudService;
import iih.mi.mibd.treatdircomp.i.ITreatdircompExtRService;
import iih.mi.mibd.treatdircomp.s.bp.AutoTreatCompBp;
import iih.mi.mibd.treatdircomp.s.bp.DelTreatCompBp;
import iih.mi.mibd.treatdircomp.s.bp.FindTreatCompBp;
import iih.mi.mibd.treatdircomp.s.bp.SaveTreatCompBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @ClassName: TreatdircompExtCrudServiceImpl
 * @Description: 医保平台_诊疗对照AggDO数据CRUD服务实现
 * @author: dj.zhang
 * @date: 2018年1月31日 下午2:17:11
 */
public class TreatdircompExtCrudServiceImpl implements ITreatdircompExtCudService, ITreatdircompExtRService {

	/**
	 * 诊疗项目对照信息查询服务
	 * 
	 * @param qryRootNodeDto
	 * @param misId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<TreatDirCompDTO> findCompDataList(QryRootNodeDTO qryRootNodeDto, String misId,
			PaginationInfo pg) throws BizException {
		FindTreatCompBp bp = new FindTreatCompBp();
		PagingRtnData<TreatDirCompDTO> result = bp.exec(qryRootNodeDto, misId, pg);
		return result;
	}

	/**
	 * 保存诊疗项目对照
	 * 
	 * @param treatDirCompDTOs
	 *            诊疗项目对照信息
	 * @throws BizException
	 */
	@Override
	public TreatDirCompDTO[] saveTreatComp(String misId, TreatDirCompDTO[] treatDirCompDTOs) throws BizException {
		SaveTreatCompBp bp = new SaveTreatCompBp();
		TreatDirCompDTO[] result = bp.exec(misId, treatDirCompDTOs);
		return result;
	}

	/**
	 * @Title: AutoComp
	 * @Description: 自动对照
	 * @param misId
	 * @throws BizException
	 */
	@Override
	public void autoTreatComp(String misId) throws BizException {

		AutoTreatCompBp bp = new AutoTreatCompBp();
		bp.exec(misId);

	}

	/**  
	* @Title: delTreatComp  
	* @Description: 删除对照
	* @param misId
	* @param treatDirCompDtOs
	* @return   
	 * @throws BizException 
	*/  
	@Override
	public TreatDirCompDTO[] delTreatComp(String misId, TreatDirCompDTO[] treatDirCompDtOs) throws BizException {
		DelTreatCompBp bp = new DelTreatCompBp();
		TreatDirCompDTO[] result = bp.exec(misId, treatDirCompDtOs);
		return result;
	}

}
