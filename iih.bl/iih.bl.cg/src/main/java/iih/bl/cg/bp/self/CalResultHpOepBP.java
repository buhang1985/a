package iih.bl.cg.bp.self;

import java.util.List;

import org.dom4j.DocumentException;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import iih.bl.cg.api.d.InsurPriceInfo;
import iih.bl.cg.api.d.ResultInfo;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.hp.divideresult.d.DivideResultDTO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.medicareinformation.d.HealthFeeDTO;
import iih.bl.st.dto.medicareinformation.d.HealthFeeItemDTO;
import iih.pi.reg.pat.d.PatDO;

public class CalResultHpOepBP {
/**
 * 上传门诊交费结算结果（回写HIS）1.3
 * @param param
 * @return
 * @throws BizException
 * @throws DocumentException 
 */
	public ResultInfo exec(InsurPriceInfo param) throws BizException, DocumentException{
		//1.判断参数是否为空
		if(param==null)
		{
			throw new BizException("传入的参数不能为空！");
		}
		if(param.getPatCode()==null || param.getInsurCardNo()==null || param.getEntpCode()==null || param.getOperatorCode()==null || param.getInsurPriceResult()==null)
		{
			throw new BizException("传入的参数不能为空！");
		}
		ResultInfo rtnInfo = new ResultInfo();
		rtnInfo.setResultCode("1");
		rtnInfo.setErrorMsg("操作失败！");
		//2.判断门急诊代码是否正确 00 门诊 01 急诊
		if(param.getEntpCode()!="01" && param.getEntpCode()!="00")
		{
			rtnInfo.setErrorMsg("门急诊代码不正确！");
			return rtnInfo;			
		}
		//3.根据患者code查询患者id_pat
		String[] pat = {"Id_pat"};
		List<PatDO> patDoList = (List<PatDO>)new DAFacade().findByCond(PatDO.class, "code = '"+param.getPatCode()+"' ","1", pat);  
		
		if(patDoList == null || patDoList.size() <= 0)
		{
			rtnInfo.setErrorMsg("该患者不存在！");
			return rtnInfo;
		}
		//4.判断操作员是否存在
		String[] psn={"Id_psndoc"};
		List<PsnDocDO> psnList = (List<PsnDocDO>) new DAFacade().findByCond(PsnDocDO.class,"code='"+ param.getOperatorCode() +"'","1",psn);
		if(psnList == null || psnList.size() <= 0)
		{
			rtnInfo.setErrorMsg("该操作员不存在！");
			return rtnInfo;
		}	
		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
        operatorInfoDTO.setId_dep(psnList.get(0).getId_dep());
        operatorInfoDTO.setId_emp(psnList.get(0).getId_psndoc());
        operatorInfoDTO.setId_grp(psnList.get(0).getId_group());
        operatorInfoDTO.setId_org(psnList.get(0).getId_org());
        operatorInfoDTO.setId_org_emp(psnList.get(0).getId_org());		
		//分解传入医保xml
		DivideResultDTO divDto= new DivideResultDTO();
		DivideResultByXmlBp bp= new DivideResultByXmlBp();
		divDto=bp.exec(param.getInsurPriceResult());
		//组装数据
		if(divDto!=null)
		{
			//查询计算表id_stoep字段值
			String[] st = {"Id_stoep,Id_ent"};
			String id_stoep="";
			String id_ent="";
			List<BlStOepDO> stDoList = (List<BlStOepDO>)new DAFacade().findByCond(BlStOepDO.class, "code_st = '"+ divDto.getFeeno() +"' ","1", st);  
			
			if(stDoList == null || stDoList.size() <= 0)
			{
				rtnInfo.setErrorMsg("该患者划价信息有误！");
				return rtnInfo;
			}else{
				id_stoep=stDoList.get(0).getId_stoep();
				id_ent=stDoList.get(0).getId_ent();
			}	
			
			String tradeNo=divDto.getTradeno();
			//分解汇总信息
			HealthFeeDTO feeDTO= new HealthFeeDTO();
			AssmHealthFeeDTOBp assmHealth = new AssmHealthFeeDTOBp();
			feeDTO=assmHealth.exec(divDto);
			//明细信息
			List<HealthFeeItemDTO> feeItemDTO =  assmHealth.ConvertTOHealthFeeItemDTOLst(divDto);
			
			//
			List<BlproparoepAggDO> blproparoepAggDOArr=assmHealth.ConvertTOBlproparoepAggDOLst(feeDTO, feeItemDTO, id_ent);
			//组装分摊数据
			List<BlPropOepDO> blPropOepDO =assmHealth.ConvertTOPropOepDODTOLst(operatorInfoDTO,id_stoep);
			
			//组装记账数据
			BlcgoepAggDO[] blcgoepAggDO=assmHealth.getBlcgoepAggDO(id_stoep);
			
			//组装支付数据
//			BlpaypatoepAggDO BlpaypatoepAggDO=assmHealth.AssemblePayData();
//			
//			IBLCiOrderToBlCgService ser= ServiceFinder.find(IBLCiOrderToBlCgService.class);
//			ser.SettlementInsurPayment(blPropOepDO, blproparoepAggDOArr, blcgoepAggDO, blpaypatoepAggDO, IsDrugApplication, PrintInvoice, IsTransferPrepay);
		}
		
		return rtnInfo;
	}
}
