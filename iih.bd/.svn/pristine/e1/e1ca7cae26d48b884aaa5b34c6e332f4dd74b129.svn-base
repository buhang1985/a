package iih.bd.mhi.hpdrugdircomp.s;

import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDTO;
import iih.bd.mhi.hpdrugdircomp.i.IHpdrugdircompExtCudService;
import iih.bd.mhi.hpdrugdircomp.i.IHpdrugdircompExtRService;
import iih.bd.mhi.hpdrugdircomp.s.bp.AutoCompHpDrugBp;
import iih.bd.mhi.hpdrugdircomp.s.bp.DeleteHpDrugCompBp;
import iih.bd.mhi.hpdrugdircomp.s.bp.FindHpDrugDirCompBp;
import iih.bd.mhi.hpdrugdircomp.s.bp.SaveHpDrugCompBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保平台_药品对照AggDO数据CRUD服务实现
 * 
 * @author hexx
 */
public class HpdrugdircompExtCrudServiceImpl implements IHpdrugdircompExtCudService, IHpdrugdircompExtRService {

	/**
	 * 药品对照信息查询服务
	 * 
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<HpDrugDirCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId,
			PaginationInfo pg) throws BizException {

		FindHpDrugDirCompBp bp = new FindHpDrugDirCompBp();
		PagingRtnData<HpDrugDirCompDTO> result = bp.exec(qryRootNodeDto, hpId, pg);
		return result;
	}

	/**
	 * 保存药品项目对照
	 * 
	 * @param hpdrugdirCompDTOs
	 *            药品对照信息
	 * @throws BizException
	 */
	@Override
	public HpDrugDirCompDTO[] saveHpDrugComp(String hpId, HpDrugDirCompDTO[] hpdrugdirCompDTOs) throws BizException {
		SaveHpDrugCompBp bp = new SaveHpDrugCompBp();
		HpDrugDirCompDTO[] result = bp.exec(hpId, hpdrugdirCompDTOs);
		return result;
	}

	/**
	 * @Title: autoComp
	 * @Description: 自动对照
	 * @param hpId
	 * @throws BizException
	 */
	@Override
	public void autoComp(String hpId) throws BizException {
		AutoCompHpDrugBp bp = new AutoCompHpDrugBp();
		bp.exec(hpId);
	}

	/**
	 * @Title: deleteHpDrugComp
	 * @Description:删除对照
	 * @param hpdrugdirCompDTOs
	 * @throws BizException
	 */
	@Override
	public HpDrugDirCompDTO[] deleteHpDrugComp(String hpId, HpDrugDirCompDTO[] hpdrugdirCompDTOs) throws BizException {
		DeleteHpDrugCompBp bp = new DeleteHpDrugCompBp();
		HpDrugDirCompDTO[] result = bp.exec(hpId, hpdrugdirCompDTOs);
		return result;
	}
}
