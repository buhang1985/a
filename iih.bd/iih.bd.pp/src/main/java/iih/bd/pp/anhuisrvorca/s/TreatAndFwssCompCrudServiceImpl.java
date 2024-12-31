package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.i.ITreatAndFwssCompCudService;
import iih.bd.pp.anhuisrvorca.i.ITreatAndFwssCompRService;
import iih.bd.pp.anhuisrvorca.s.bp.AutoCompTreatAndFwssBp;
import iih.bd.pp.anhuisrvorca.s.bp.CompInsurTreatAndFwssDataBp;
import iih.bd.pp.anhuisrvorca.s.bp.DeleteTreatAndFwssCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindCanSyncApprovalCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindExceedMaxPriCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindTreatAndFwssCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.RefreshTreatAndFwssCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.SaveTreatAndFwssCompBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 诊疗和服务设施对照服务
 * 
 * @author hao_wu
 *
 */
public class TreatAndFwssCompCrudServiceImpl implements ITreatAndFwssCompCudService, ITreatAndFwssCompRService {

	@Override
	public PagingRtnData<TreatCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		FindTreatAndFwssCompBp bp = new FindTreatAndFwssCompBp();
		PagingRtnData<TreatCompDTO> result = bp.exec(qryRootNodeDto, hpId, pg);
		return result;
	}

	@Override
	public TreatCompDTO[] CompInsurZlAndFwssData(TreatCompDTO[] treatCompDTOs) throws BizException {
		CompInsurTreatAndFwssDataBp bp = new CompInsurTreatAndFwssDataBp();
		bp.exec(treatCompDTOs);
		return treatCompDTOs;
	}

	@Override
	public TreatCompDTO[] FindCanSyncApprovalComp(String hpCode) throws BizException {
		FindCanSyncApprovalCompBp bp = new FindCanSyncApprovalCompBp();
		TreatCompDTO[] result = bp.exec(hpCode);
		return result;
	}

	@Override
	public TreatCompDTO[] SaveTreatAndFwssComp(TreatCompDTO[] treatCompDTOs) throws BizException {
		SaveTreatAndFwssCompBp bp = new SaveTreatAndFwssCompBp();
		TreatCompDTO[] result = bp.exec(treatCompDTOs);
		return result;
	}

	@Override
	public void AutoComp(String hpCode) throws BizException {
		AutoCompTreatAndFwssBp bp = new AutoCompTreatAndFwssBp();
		bp.exec(hpCode);
	}

	@Override
	public void RefreshComp(String hpCode) throws BizException {
		RefreshTreatAndFwssCompBp bp = new RefreshTreatAndFwssCompBp();
		bp.exec(hpCode);
	}

	@Override
	public TreatCompDTO[] DeleteTreatAndFwssComp(TreatCompDTO[] treatCompDTOs) throws BizException {
		DeleteTreatAndFwssCompBp bp = new DeleteTreatAndFwssCompBp();
		TreatCompDTO[] result = bp.exec(treatCompDTOs);
		return result;
	}

	@Override
	public PagingRtnData<TreatCompDTO> FindExceedMaxPriComp(String hpCode,PaginationInfo pg) throws BizException {
		FindExceedMaxPriCompBp bp = new FindExceedMaxPriCompBp();
		PagingRtnData<TreatCompDTO> result = bp.exec(hpCode,pg);
		return result;
	}
}
