package iih.bl.cg.service.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blproparoep.i.IBlproparoepCudService;
import iih.bl.prop.blproparoep.i.IBlproparoepRService;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.blpropoep.i.IBlpropoepCudService;
import iih.bl.prop.blpropoep.i.IBlpropoepRService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class RefundFeeInsureErrBp {

	/**
	 * 医保交易异常处理
	 * @param strCodeSt 结算流水号
	 * @param operatorInfoDTO 操作人员信息
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(String strCodeSt,OperatorInfoDTO operatorInfoDTO) throws BizException
	{
		IBlstoepRService rService=ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] stOepDoArr=rService.findByAttrValString(BlStOepDO.CODE_ST, strCodeSt);
		if(ArrayUtil.isEmpty(stOepDoArr))
			throw new BizException("未查询到对应的结算信息，请确认退费记录是否正确!");
		//找到原付款信息
		IBlpaypatoepRService paypatService=ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO paypatAggDO=paypatService.findById(stOepDoArr[0].getId_paypatoep());
		//组装原付款信息
		BlpaypatoepAggDO aggDoRedBill=new BlpaypatoepAggDO();
		BlPayPatOepDO paypatOepDo=(BlPayPatOepDO)paypatAggDO.getParentDO().clone();
		paypatOepDo.setEu_direct(BookRtnDirectEnum.REFUND);
		paypatOepDo.setDt_pay(AppUtils.getServerDateTime());
		paypatOepDo.setId_dep_pay(operatorInfoDTO.getId_dep());
		paypatOepDo.setId_emp_pay(operatorInfoDTO.getId_emp());
		//退费的显示是未记账
		paypatOepDo.setFg_cc(FBoolean.FALSE);
		paypatOepDo.setStatus(DOStatus.NEW);
		aggDoRedBill.setParentDO(paypatOepDo);
		
		BlPayItmPatOepDO[] payItmOepDoArr=paypatAggDO.getBlPayItmPatOepDO();
		List<BlPayItmPatOepDO> lst=new ArrayList<BlPayItmPatOepDO>();
		for(BlPayItmPatOepDO payItm:payItmOepDoArr)
		{
			BlPayItmPatOepDO payItmpatOepDo=(BlPayItmPatOepDO)payItm.clone();
			payItmpatOepDo.setId_payitmpatoep(null);
			payItmpatOepDo.setStatus(DOStatus.NEW);
			lst.add(payItmpatOepDo);
		}
		aggDoRedBill.setBlPayItmPatOepDO(lst.toArray(new BlPayItmPatOepDO[lst.size()]));
		
		IBlCgItmOepDORService cgItmRService=ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] cgItmOepDoArr=cgItmRService.findByAttrValString(BlCgItmOepDO.ID_STOEP, stOepDoArr[0].getId_stoep());
		
        List<BlRefundItmDTO> refundItmDtoArr = new ArrayList<BlRefundItmDTO>();
        List<String> strIdCgOepArr=new ArrayList<String>();
        for (BlCgItmOepDO cgItmOepDo:cgItmOepDoArr)
        {
            BlRefundItmDTO dto = new BlRefundItmDTO();
            dto.setId_cgoep(cgItmOepDo.getId_cgoep());
            dto.setId_cditmoep(cgItmOepDo.getId_cgitmoep());
            dto.setId_orsrv(cgItmOepDo.getId_orsrv());
            dto.setQuan_refund(cgItmOepDo.getQuan());
            dto.setFg_mm(cgItmOepDo.getFg_mm());
            dto.setId_mm(cgItmOepDo.getId_mm());
            dto.setReq_unit_id(cgItmOepDo.getSrvu());
            dto.setId_dep(cgItmOepDo.getId_dep_or());
            dto.setId_dep_wh(cgItmOepDo.getId_dep_wh());
            if (cgItmOepDo.getFg_mm().booleanValue())
            {     
            	//药品未发放
                dto.setFg_drug_provide(FBoolean.FALSE);
            }
            if(!strIdCgOepArr.contains(cgItmOepDo.getId_cgoep()))
            {
            	strIdCgOepArr.add(cgItmOepDo.getId_cgoep());
            }
            refundItmDtoArr.add(dto);
        }
        
		RefundFeeBp bp = new RefundFeeBp();
		// 1.做全费的退款操作
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = bp.exec(stOepDoArr[0].getId_stoep(), 
				strIdCgOepArr.toArray(new String[strIdCgOepArr.size()]), 
				refundItmDtoArr.toArray(new BlRefundItmDTO[refundItmDtoArr.size()]), 
				operatorInfoDTO, 
				aggDoRedBill, 
				FBoolean.TRUE, 
				FBoolean.FALSE,
				null);
		
		//2、红冲分摊数据
		//获取原分摊数据
		BlStOepDO[] stoepRedBackArr=rService.findByAttrValString(BlStOepDO.ID_PAR, stOepDoArr[0].getId_stoep());
		IBlpropoepRService propService=ServiceFinder.find(IBlpropoepRService.class);
		BlPropOepDO[] propOepDoArr=propService.findByAttrValString(BlPropOepDO.ID_STOEP, stOepDoArr[0].getId_stoep());
		//生成退费分摊
		BlPropOepDO blpropOepDoRedback=(BlPropOepDO)propOepDoArr[0].clone();
		blpropOepDoRedback.setDt_prop(AppUtils.getServerDateTime());
		blpropOepDoRedback.setEu_direct(BookRtnDirectEnum.REFUND);
		blpropOepDoRedback.setId_propoep(null);
		//结算ID
		blpropOepDoRedback.setId_stoep(stoepRedBackArr[0].getId_stoep());
		blpropOepDoRedback.setStatus(DOStatus.NEW);
		IBlpropoepCudService propCudSerivce=ServiceFinder.find(IBlpropoepCudService.class);
		BlPropOepDO[] propOepDoRedbackSavedArr=propCudSerivce.save(new BlPropOepDO[]{blpropOepDoRedback});
		
		//红冲应收数据
		IBlproparoepRService propAroepService=ServiceFinder.find(IBlproparoepRService.class);
		BlproparoepAggDO[] propArDoAggArr=propAroepService.findByAttrValString(BlPropOepDO.ID_PROPOEP, propOepDoArr[0].getId_propoep());
		
		BlproparoepAggDO redBackAggdo=new BlproparoepAggDO();
		BlPropArOepDO blpropOepRedBack=(BlPropArOepDO)propArDoAggArr[0].getParentDO().clone();
		blpropOepRedBack.setEu_direct(BookRtnDirectEnum.REFUND);
		blpropOepRedBack.setId_propoep(propOepDoRedbackSavedArr[0].getId_propoep());
		blpropOepRedBack.setId_proparoep(null);
		blpropOepRedBack.setStatus(DOStatus.NEW);
		redBackAggdo.setParentDO(blpropOepRedBack);
		
		/*BlPropArOepNeusoftDO propArOepNeusoftDo=(BlPropArOepNeusoftDO)propArDoAggArr[0].getBlPropArOepNeusoftDO()[0].clone();
		propArOepNeusoftDo.setId_proparoepneusoft(null);
		propArOepNeusoftDo.setStatus(DOStatus.NEW);
		redBackAggdo.setBlPropArOepNeusoftDO(new BlPropArOepNeusoftDO[]{propArOepNeusoftDo});*/
		IBlproparoepCudService propAroepCudSerivce=ServiceFinder.find(IBlproparoepCudService.class);
		propAroepCudSerivce.save(new BlproparoepAggDO[]{redBackAggdo});
		//3、记录医保交易状态		
		return null;
	}
}
