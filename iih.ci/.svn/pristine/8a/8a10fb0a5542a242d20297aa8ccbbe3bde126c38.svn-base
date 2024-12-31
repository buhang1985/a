package iih.ci.ord.specanti.s;

import iih.ci.ord.ap.d.CiApSpecAntiRecordDO;
import iih.ci.ord.s.bp.specant.SpecAntiConsApplyNewQryBP;
import iih.ci.ord.s.bp.specant.SpecAntiConsApplyQryBP;
import iih.ci.ord.s.bp.specant.SpecAntiConsTreeQryBP;
import iih.ci.ord.s.bp.specant.SpecantionOrderBP;
import iih.ci.ord.specanti.bp.CarbapenemJudgeBP;
import iih.ci.ord.specanti.bp.SpecAntiJudgeBP;
import iih.ci.ord.specanti.d.SpecAntiParamDTO;
import iih.ci.ord.specanti.d.SpecOrderAntiDrugAppDTO;
import iih.ci.ord.specanti.d.SpecOrderAntiDrugDTO;
import iih.ci.ord.specanti.d.SpecantOrderDTO;
import iih.ci.ord.specanti.d.SpecantionApplyDTO;
import iih.ci.ord.specanti.i.ISpecantOrderService;
import iih.ci.ord.speconsqrydto.d.SpeconsQryDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;


@Service(serviceInterfaces={ISpecantOrderService.class}, binding=Binding.JSONRPC)
public class SpecantOrderServiceImpl implements ISpecantOrderService{
	//start GH
	@Override
	public SpecantOrderDTO[] findByDrugName(String patId,String whereParm) throws BizException {
		SpecAntiConsTreeQryBP bp = new SpecAntiConsTreeQryBP();
		SpecantOrderDTO[] dto = bp.exec(patId,whereParm);
		return dto;
	}

	@Override
	public SpecantionApplyDTO findApplyById(String id_apspecanticons) throws BizException {
		SpecAntiConsApplyQryBP bp = new SpecAntiConsApplyQryBP();
		SpecantionApplyDTO dto = bp.exec(id_apspecanticons);
		
		//调查诊断得的接口 getDiagArray(String id_ent)   ICiOrdQryService
		
//		ICiOrdQryService utils = (ICiOrdQryService) ServiceFinder.find(ICiOrdQryService.class);
//		String Str_name_diitm =utils.getDiagArray(dto.getId_ent())[0];
//		dto.setStr_name_diitm(Str_name_diitm);
		
		return dto;
	}
	@Override
	public SpecantionApplyDTO newApply(String id_or) throws BizException {
		SpecAntiConsApplyNewQryBP bp = new SpecAntiConsApplyNewQryBP();
		SpecantionApplyDTO dto = bp.exec(id_or);
		return dto;
	}
	//通过申请时间查询
	@Override
	public SpecantionApplyDTO[] findByTime(SpeconsQryDTO speconsQryDTO) throws BizException {
		SpecantionOrderBP bp = new SpecantionOrderBP();
		SpecantionApplyDTO[] dto = bp.exec(speconsQryDTO);
		return dto;
	}
	//通过申请单ID查询
	@Override
	public SpecantionApplyDTO[] findById(String id_apspecanticons) throws BizException {
		SpecantionOrderBP bp = new SpecantionOrderBP();
		SpecantionApplyDTO[] dto = bp.exec1(id_apspecanticons);
		return dto;
	}
	@Override
	public Boolean approval(SpecantionApplyDTO specantionDTO) throws BizException {
		SpecantionOrderBP bp = new SpecantionOrderBP();
		return bp.approval(specantionDTO);
	}
	
	@Override
	public Integer hasApprovaled(String id_en,String code_ent, String[] szId_mm) throws BizException {
		return new SpecantionOrderBP().hasApprovaled(id_en, code_ent, szId_mm);
	}

	@Override
	public SpecOrderAntiDrugDTO[] getOrderAntiDrugsInfo(String[] szId_or) throws BizException {
		// TODO Auto-generated method stub
		return new SpecantionOrderBP().getOrderAntiDrugsInfo(szId_or);
	}

	@Override
	public SpecOrderAntiDrugAppDTO[] getOrderAntiDrugAppsInfo(String id_en) throws BizException {
		// TODO Auto-generated method stub
		return new SpecantionOrderBP().getOrderAntiDrugAppsInfo(id_en);
	}

	@Override
	public SpecAntiParamDTO[] specAntiJudge(SpecAntiParamDTO[] params) throws BizException {
		SpecAntiJudgeBP bp = new SpecAntiJudgeBP();
		return bp.exec(params);
	}

	@Override
	public CiApSpecAntiRecordDO[] carbapenemJudge(String[] id_ors) throws BizException {
		CarbapenemJudgeBP bp = new CarbapenemJudgeBP();
		return bp.exec(id_ors);
	}
	
}
