package iih.bd.mhi.hptreatdircomp.s;

import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDTO;
import iih.bd.mhi.hptreatdircomp.i.IHptreatdircompExtCudService;
import iih.bd.mhi.hptreatdircomp.i.IHptreatdircompExtRService;
import iih.bd.mhi.hptreatdircomp.s.bp.AutoTreatCompBp;
import iih.bd.mhi.hptreatdircomp.s.bp.DelTreatCompBp;
import iih.bd.mhi.hptreatdircomp.s.bp.FindHpTreatCompBp;
import iih.bd.mhi.hptreatdircomp.s.bp.SaveHpTreatCompBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保产品_诊疗对照AggDO数据CRUD服务实现
 */
public class HptreatdircompExtCrudServiceImpl implements IHptreatdircompExtCudService, IHptreatdircompExtRService {

	/**
	 * 诊疗项目对照信息查询服务
	 * 
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<HpTreatDirCompDTO> findCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId,
			PaginationInfo pg) throws BizException {
		FindHpTreatCompBp bp = new FindHpTreatCompBp();
		PagingRtnData<HpTreatDirCompDTO> result = bp.exec(qryRootNodeDto, hpId, pg);
		return result;
	}

	/**
	 * @Title: saveHpTreatComp
	 * @Description:保存诊疗项目对照
	 * @param hpId
	 * @param treatDirCompDTOs
	 * @throws BizException
	 */
	@Override
	public HpTreatDirCompDTO[] saveHpTreatComp(String hpId, HpTreatDirCompDTO[] treatDirCompDTOs) throws BizException {
		SaveHpTreatCompBp bp = new SaveHpTreatCompBp();
		HpTreatDirCompDTO[] result = bp.exec(hpId, treatDirCompDTOs);
		return result;
	}

	/**
	 * @Title: autoHpTreatComp
	 * @Description: 自动对照
	 * @param hpId
	 * @throws BizException
	 */
	@Override
	public void autoHpTreatComp(String hpId) throws BizException {
		AutoTreatCompBp bp = new AutoTreatCompBp();
		bp.exec(hpId);

	}

	/**
	 * @Title: delHpTreatComp
	 * @Description: 删除对照
	 * @param hpId
	 * @param treatDirCompDtOs
	 * @throws BizException
	 */ 
	@Override
	public HpTreatDirCompDTO[] delHpTreatComp(String hpId, HpTreatDirCompDTO[] treatDirCompDtOs) throws BizException {
		DelTreatCompBp bp = new DelTreatCompBp();
		HpTreatDirCompDTO[] result = bp.exec(hpId, treatDirCompDtOs);
		return result;
	}

	/**
	 * @Title: onDownload
	 * @Description: 下载目录
	 * @throws BizException
	 */
	@Override
	public void onDownload() throws BizException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @Title: onDownload
	 * @Description: 医保上报
	 * @throws BizException
	 */
	@Override
	public void onMedireport() throws BizException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @Title: onDownload
	 * @Description: 同步审批
	 * @throws BizException
	 */
	@Override
	public void onSyncMediapproval() throws BizException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @Title: onDownload
	 * @Description: 医保上报撤销
	 * @throws BizException
	 */
	@Override
	public void onRevokeMedireport() throws BizException {
		// TODO Auto-generated method stub
		
	}
}
