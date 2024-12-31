package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.i.ITreatCompCudService;
import iih.bd.pp.anhuisrvorca.i.ITreatCompRService;
import iih.bd.pp.anhuisrvorca.s.bp.AutoCompTreatBp;
import iih.bd.pp.anhuisrvorca.s.bp.CanCleTreatOwnExpenseBp;
import iih.bd.pp.anhuisrvorca.s.bp.CompInsurTreatDataBp;
import iih.bd.pp.anhuisrvorca.s.bp.DeleteTreatCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindAllTreatCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindExceedMaxPriZlCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindTreatCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.RefreshTreatCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.SaveTreatCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.SetTreatOwnExpenseBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 诊疗项目对照信息查询服务
 * 
 * @author guoyang, hao_wu
 *
 */
public class TreatCompCrudServiceImpl implements ITreatCompRService, ITreatCompCudService {

	@Override
	public PagingRtnData<TreatCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		FindTreatCompBp bp = new FindTreatCompBp();
		PagingRtnData<TreatCompDTO> result = bp.exec(qryRootNodeDto, hpId, pg);
		return result;
	}

	@Override
	public TreatCompDTO[] CompInsurZlData(TreatCompDTO[] treatCompDTOs) throws BizException {
		CompInsurTreatDataBp bp = new CompInsurTreatDataBp();
		bp.exec(treatCompDTOs);
		return treatCompDTOs;
	}

	@Override
	public TreatCompDTO[] SaveTreatComp(TreatCompDTO[] treatCompDTOs) throws BizException {
		SaveTreatCompBp bp = new SaveTreatCompBp();
		TreatCompDTO[] result = bp.exec(treatCompDTOs);
		return result;
	}

	@Override
	public TreatCompDTO[] DeleteTreatComp(TreatCompDTO[] treatCompDTOs) throws BizException {
		DeleteTreatCompBp bp = new DeleteTreatCompBp();
		TreatCompDTO[] result = bp.exec(treatCompDTOs);
		return result;
	}

	@Override
	public TreatCompDTO[] FindAllTreatComp(String hpCode) throws BizException {
		FindAllTreatCompBp bp = new FindAllTreatCompBp();
		TreatCompDTO[] result = bp.exec(hpCode);
		return result;
	}

	@Override
	public void AutoComp(String hpCode) throws BizException {
		AutoCompTreatBp bp = new AutoCompTreatBp();
		bp.exec(hpCode);
	}

	@Override
	public void RefreshComp(String hpCode) throws BizException {
		RefreshTreatCompBp bp = new RefreshTreatCompBp();
		bp.exec(hpCode);
	}

	@Override
	public PagingRtnData<TreatCompDTO> FindExceedMaxPriZlComp(String hpCode, PaginationInfo pg) throws BizException {
		FindExceedMaxPriZlCompBp bp = new FindExceedMaxPriZlCompBp();
		PagingRtnData<TreatCompDTO> result = bp.exec(hpCode, pg);
		return result;
	}
	
	@Override
	public String[] setTreatOwnExpense(TreatCompDTO[] treatCompDTOs) throws BizException {
		SetTreatOwnExpenseBp bp = new SetTreatOwnExpenseBp();
		String[] result = bp.exec(treatCompDTOs);
		return result;
	}

	@Override
	public String[] canCleTreatOwnExpense(TreatCompDTO[] treatCompDTOs) throws BizException {
		CanCleTreatOwnExpenseBp bp = new CanCleTreatOwnExpenseBp();
		String[] result = bp.exec(treatCompDTOs);
		return result;
	}
}
