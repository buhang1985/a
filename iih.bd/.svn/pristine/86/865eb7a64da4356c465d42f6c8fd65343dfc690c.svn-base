package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.i.IDrugCompCudService;
import iih.bd.pp.anhuisrvorca.i.IDrugCompRService;
import iih.bd.pp.anhuisrvorca.s.bp.AutoCompDrugBp;
import iih.bd.pp.anhuisrvorca.s.bp.CanCleOwnExpenseBp;
import iih.bd.pp.anhuisrvorca.s.bp.CompInsurDrugDataBp;
import iih.bd.pp.anhuisrvorca.s.bp.CompInsurDrugTreatDataBp;
import iih.bd.pp.anhuisrvorca.s.bp.DeleteDrugCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindAllDrugCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindDrugCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindExceedMaxPriDrugCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.RefreshDrugCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.RevokeMediReportBp;
import iih.bd.pp.anhuisrvorca.s.bp.SaveDrugCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.SetOwnExpenseBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保药品对照信息查询服务
 * 
 * @author guoyang, hao_wu
 *
 */
public class DrugCompCrudServiceImpl implements IDrugCompRService, IDrugCompCudService {

	@Override
	public PagingRtnData<DrugCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		FindDrugCompBp bp = new FindDrugCompBp();
		PagingRtnData<DrugCompDTO> result = bp.exec(qryRootNodeDto, hpId, pg);
		return result;
	}

	@Override
	public DrugCompDTO[] CompInsurDrugData(DrugCompDTO[] drugCompDTOs) throws BizException {
		CompInsurDrugDataBp bp = new CompInsurDrugDataBp();
		bp.exec(drugCompDTOs);
		return drugCompDTOs;
	}

	@Override
	public DrugCompDTO[] SaveDrugComp(DrugCompDTO[] drugCompDTOs) throws BizException {
		SaveDrugCompBp bp = new SaveDrugCompBp();
		DrugCompDTO[] result = bp.exec(drugCompDTOs);
		return result;
	}

	@Override
	public DrugCompDTO[] DeleteDrugComp(DrugCompDTO[] drugCompDTOs) throws BizException {
		DeleteDrugCompBp bp = new DeleteDrugCompBp();
		DrugCompDTO[] result = bp.exec(drugCompDTOs);
		return result;
	}

	@Override
	public DrugCompDTO[] FindAllDrugComp(String hpCode) throws BizException {
		FindAllDrugCompBp bp = new FindAllDrugCompBp();
		DrugCompDTO[] result = bp.exec(hpCode);
		return result;
	}

	@Override
	public void AutoComp(String hpCode) throws BizException {
		AutoCompDrugBp bp = new AutoCompDrugBp();
		bp.exec(hpCode);
	}

	@Override
	public void RefreshComp(String hpCode) throws BizException {
		RefreshDrugCompBp bp = new RefreshDrugCompBp();
		bp.exec(hpCode);
	}

	@Override
	public PagingRtnData<DrugCompDTO> FindExceedMaxPriComp(String hpCode, PaginationInfo pg) throws BizException {
		FindExceedMaxPriDrugCompBp bp = new FindExceedMaxPriDrugCompBp();
		PagingRtnData<DrugCompDTO> result = bp.exec(hpCode, pg);
		return result;
	}

	@Override
	public DrugCompDTO[] RevokeMediReport(DrugCompDTO[] drugCompDTOs) throws BizException {
		RevokeMediReportBp bp = new RevokeMediReportBp();
		DrugCompDTO[] result = bp.exec(drugCompDTOs);
		return result;
	}

	@Override
	public String[] setOwnExpense(DrugCompDTO[] drugCompDTOs) throws BizException {
		SetOwnExpenseBp bp = new SetOwnExpenseBp();
		String[] result = bp.exec(drugCompDTOs);
		return result;
	}

	@Override
	public String[] canCleOwnExpense(DrugCompDTO[] drugCompDTOs) throws BizException {
		CanCleOwnExpenseBp bp = new CanCleOwnExpenseBp();
		String[] result = bp.exec(drugCompDTOs);
		return result;
	}

	@Override
	public DrugCompDTO[] CompInsurDrugTreatData(DrugCompDTO[] drugCompDTOs) throws BizException {
		CompInsurDrugTreatDataBp bp = new CompInsurDrugTreatDataBp();
		bp.exec(drugCompDTOs);
		return drugCompDTOs;
	}
}
