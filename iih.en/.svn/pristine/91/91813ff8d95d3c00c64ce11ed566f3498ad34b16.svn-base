package iih.en.pv.s.bp;

import iih.bl.cg.dto.oepcg4en.d.BlCgUnpay4EnDTO;
import iih.bl.cg.i.IBlOutQryService;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpUnpayAndAccDrugDTO;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 查询患者门诊待交费数据(调用费用的接口查询)
 * @author zhangpp 2019.3.12
 *
 */
public class GetOepUnpayDetailBP {

	/**
	 * 查询患者门诊待交费数据
	 * @param patId
	 * @param days
	 * @return
	 * @throws BizException
	 */
	public OpUnpayAndAccDrugDTO[] exec(String patId, Integer days) throws BizException{
		
		if(EnValidator.isEmpty(patId)){
			throw new BizException("患者id不能为空！");
		}
		
		//通过服务，获取BlCgUnpay4EnDTO[]
		IBlOutQryService qryService = ServiceFinder.find(IBlOutQryService.class);
		BlCgUnpay4EnDTO[] blDtos = qryService.getOepUnpayDetail(patId, days);
		
		//将BlCgUnpay4EnDTO转换为OpUnpayAndAccDrugDTO
		OpUnpayAndAccDrugDTO[] dtos = this.getResult(blDtos);
		
		return dtos;
	}

	/**
	 * 将BlCgUnpay4EnDTO转换为OpUnpayAndAccDrugDTO
	 * @param blDtos
	 * @return
	 */
	private OpUnpayAndAccDrugDTO[] getResult(BlCgUnpay4EnDTO[] blDtos){
		
		if (blDtos == null) {
			return new OpUnpayAndAccDrugDTO[0];
		}
		
		ArrayList<OpUnpayAndAccDrugDTO> doList = new ArrayList<OpUnpayAndAccDrugDTO>();
		for (BlCgUnpay4EnDTO blDTO : blDtos) {
			OpUnpayAndAccDrugDTO opDTO = new OpUnpayAndAccDrugDTO();
			opDTO.setId_or(blDTO.getId_or());
			opDTO.setName_srv(blDTO.getName_srv());
			opDTO.setName_mm(blDTO.getName_mm());
			opDTO.setPrice_ratio(blDTO.getPrice_ratio());
			opDTO.setQuan(blDTO.getQuan());
			opDTO.setAmt_ratio(blDTO.getAmt_ratio());
			opDTO.setName_measdoc(blDTO.getName_measdoc());
			opDTO.setSpec(blDTO.getSpec());
			opDTO.setName_dep_or(blDTO.getName_dep_or());
			opDTO.setName_emp_or(blDTO.getName_emp_or());
			opDTO.setContent_or(blDTO.getContent_or());
			doList.add(opDTO);
		}	
		
		return doList.toArray(new OpUnpayAndAccDrugDTO[0]);
	}
	
}
