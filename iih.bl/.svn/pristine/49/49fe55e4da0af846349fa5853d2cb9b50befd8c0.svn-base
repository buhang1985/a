package iih.bl.pay.blpaypat.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.blprepay.ep.BlPrepayPatDOEp;
import iih.bl.pay.blprepay.ep.UpdateAccInfoEp;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.dto.prepayreceipt.d.BlPrepayReceiptDTO;
import iih.bl.pay.s.bp.BlPrepayReceiptPrintBP;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存住院预交金主要业务逻辑类
 * @author li_pengying
 * @version ly 2018/06/22 打印和预交金保存剥离
 */
public class SavePrepayInfoIpBp {

	/*
	 *住院 预交金录入数据的保存
	 * */
	public BlPrePayPatDO[] execSaveIpBlPayPatInfo(BlPayPatItemDTO blPayPatItemDTO,BlPrePayPatDO blPayPatDO, String payType) 
			throws BizException{
		//主要业务： 1.校验票据号   2.保存新增的预交金数据   3.更新账户   4，更新票据号
		
		//1.校验票据号 ：验证票据编号是否可用  by ly
		/*GetInvoiceInfoBP  incbp=new GetInvoiceInfoBP();
		String code_rep=incbp.getInvoiceInfo(blPayPatDO.getId_emp_pay(), payType);
		if(blPayPatItemDTO.getCode_rep() != null && !(blPayPatItemDTO.getCode_rep()).equals(code_rep)){
			throw new BizException("当前票据已被他人修改，请刷新界面，重做业务！");
		}*/
		
		//录入数据保存 :   2.先插入一条住院预交金数据， 3.再更新就诊账户信息，4.更新票据信息
		BlPrepayPatDOEp  prepayEp=new BlPrepayPatDOEp();
		//2.先插入一条住院预交金数据，保存
		BlPrePayPatDO[] blPrePayPatDOArr =prepayEp.insertBlPayPatInfo(blPayPatItemDTO, blPayPatDO, payType);
		
		//3.再更新就诊账户信息， 账户信息修改接口：当为住院时修改就诊账户信息，同时支持门诊或者住院的账户修改
		UpdateAccInfoEp newep=new UpdateAccInfoEp();
		newep.updatePiPatAccInfo(blPayPatItemDTO.getAmt().doubleValue(), blPayPatDO, payType);
		
		//4.更新票据信息 ，票据编码修改 by ly
		/*BlPrepayPatDOEp newBl=new BlPrepayPatDOEp ();
		IBLInvoiceService incService = (IBLInvoiceService)ServiceFinder.find(IBLInvoiceService.class);
    	incService.NextInvoiceNoUpdateCurNo(blPayPatDO.getId_emp_pay(), newBl.getRepCodeByCCTP(payType));*/
		
		//如果是住院类型的收退预交金，则为其中的计算列code_ent字段赋值，它是个计算列字段，获得其值的目的是为了在打印收据条上显示出就诊号,实际上数组blPrePayPatDOArr中只有1条数据 所以在其循环内部可以调用服务
		/*if(blPrePayPatDOArr != null  && IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType) ){
			this.setCode_ent(blPrePayPatDOArr, payType);
		}*/ //没啥用
		
		//打印票据
		BlPrePayPatDO prepayDO = blPrePayPatDOArr[0];
		BlPrepayReceiptDTO dto = new BlPrepayReceiptDTO();
		dto.setId_paypat(prepayDO.getId_paypat());
		dto.setCode_rep(blPayPatItemDTO.getCode_rep());
		dto.setFg_checkcode(FBoolean.TRUE);
		new BlPrepayReceiptPrintBP().exec(dto);
		
		//重新查询数据
		IBlpaypatRService rService = ServiceFinder.find(IBlpaypatRService.class);
		prepayDO = rService.findById(prepayDO.getId_paypat());
		
		return new BlPrePayPatDO[] { prepayDO };
	}
	
    /**  
     * //如果是住院类型的收退预交金，则为其中的计算列code_ent字段赋值
     * @param blpppDOArr
     * @param payType
     * @return
     * @throws BizException
     */
	@Deprecated
	private  BlPrePayPatDO[]  setCode_ent(BlPrePayPatDO[]  blpppDOArr, String payType) throws BizException{
		//如果是住院类型的收退预交金，则为其中的计算列code_ent字段赋值
			  if(blpppDOArr != null  && IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType) )
			   {	
					List<String> idList = new ArrayList<String>();
					for(BlPrePayPatDO blPrePayPatDO : blpppDOArr){
						idList.add(blPrePayPatDO.getId_paypat());
					}
					IBlpaypatRService service = ServiceFinder.find(IBlpaypatRService.class);
					blpppDOArr = service.findByBIds(idList.toArray(new String[]{}), FBoolean.FALSE);
				  
					//就诊类型是住院时，得到就诊编码
					if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType))
					{
						//获取就诊编码
						IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
						if(entService != null )
						{
							//实际上数组blPrePayPatDOArr中只有1条数据 所以在其循环内部可以调用服务
							for(BlPrePayPatDO blPrePayPatDO : blpppDOArr)
							{
								PatiVisitDO patiVisitDO =  entService.findById(blPrePayPatDO.getId_ent());
								if(patiVisitDO == null){
									throw new BizException("就诊不存在！");
								}
								blPrePayPatDO.setCode_ent(patiVisitDO.getCode());
							}
						}
						
					}
				}
				
		return blpppDOArr;
	}
	
	
}
