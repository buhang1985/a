package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpUnpayAndAccDrugDTO;
import iih.mp.dg.dto.opdgdisp.d.DrugsDTO;
import iih.mp.dg.i.IMpDgOutService;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 查询患者门诊已缴费未拿药信息(调用药品的接口查询)
 * @author zhangpp - 2019.3.18
 *
 */
public class GetAccountDrugInfoBP {

	/**
	 * 获取门诊已缴费未拿药信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public OpUnpayAndAccDrugDTO[] exec(String patId) throws BizException{
		
		if(EnValidator.isEmpty(patId)){
			throw new BizException("患者id不能为空！");
		}
		
		//通过服务，获取DrugsDTO[]
		IMpDgOutService qryService = ServiceFinder.find(IMpDgOutService.class);
		DrugsDTO[] drDtos = qryService.getAccountDrugInfo(patId);
		
		//将DrugsDTO转换为OpUnpayAndAccDrugDTO
		OpUnpayAndAccDrugDTO[] dtos = this.getResult(drDtos);
		
		return dtos;
	}
	
	/**
	 * 将DrugsDTO转换为OpUnpayAndAccDrugDTO
	 * @param drDtos
	 * @return
	 */
	private OpUnpayAndAccDrugDTO[] getResult(DrugsDTO[] drDtos){
		
		if (drDtos == null) {
			return new OpUnpayAndAccDrugDTO[0];
		}
		
		ArrayList<OpUnpayAndAccDrugDTO> doList = new ArrayList<OpUnpayAndAccDrugDTO>();
		for (DrugsDTO drDto : drDtos) {
			OpUnpayAndAccDrugDTO opDTO = new OpUnpayAndAccDrugDTO();
			opDTO.setName_srv(drDto.getName_srv());
			opDTO.setName_mm(drDto.getName_mm());
			opDTO.setPrice_ratio(drDto.getPrice());
			opDTO.setQuan(drDto.getQuan());
			opDTO.setAmt_ratio(drDto.getAmt_should());
			if(drDto.getDays_or() != null){	
				opDTO.setDays_or(drDto.getDays_or().toString());
			}
			doList.add(opDTO);
		}	
		
		return doList.toArray(new OpUnpayAndAccDrugDTO[0]);
	}
	
}
