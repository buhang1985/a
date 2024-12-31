package iih.bl.comm.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.log.BLBizLogger;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.comm.thirdpayapi.BlThirdPayValidateUtil;
import iih.bl.itf.dto.thirdpayvalidate.d.BlThirdPayValidateRltDTO;
import iih.bl.itf.payplatform.d.BlOrdQryRstDTO;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.d.BlThirdTransRegDO;
import iih.bl.itf.trdtrans.d.FrontEndEnum;
import iih.bl.itf.trdtrans.d.TransStateEnum;
import iih.bl.itf.trdtrans.i.ITrdtransrcdCudService;
import iih.bl.itf.trdtrans.i.ITrdtransrcdRService;
import iih.bl.itf.trdtrans.i.ITrdtransregRService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.pi.reg.patcust.d.PiPatCustDO;
import iih.pi.reg.patcust.i.IPatcustRService;
import iih.pmp.pay.i.IPmpPayExternalService;
import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * IIH在线支付
 * @author LIM
 *
 */
public class BlThirdPayBP {

	/**
	 * 退费(微信支付宝)
	 * @param blOrdReqDTO 退费入参
	 * @param id_transrcd
	 * @return
	 * @throws BizException
	 */
	public FBoolean execRefund(BlOrdReqDTO blOrdReqDTO,String id_transrcd) throws BizException{
		if(blOrdReqDTO==null){
			throw new BizException("退费信息为空！");
		}
		BLTaskLogger.info("患者："+blOrdReqDTO.getId_pat()+ " 调用退费接口入参：BlOrdReqDTO：【" +blOrdReqDTO.serializeJson()+"】id_transrcd：【"+id_transrcd+"】");
		//1.将入参转换成退费需要的dto
		OrdReqDTO ordReqDTO=this.convertOrdReqDTO(blOrdReqDTO);
		BLTaskLogger.info("患者："+blOrdReqDTO.getId_pat()+ " 调用退费接口转换退费入参：OrdReqDTO：【"+ ordReqDTO.serializeJson() +"】");
		//2.退费
		try{
			IPmpPayExternalService ser = ServiceFinder.find(IPmpPayExternalService.class);
			OrdRstDTO ordRstDTO= ser.refund(ordReqDTO);
			BLTaskLogger.info("患者："+blOrdReqDTO.getId_pat()+ " 调用退费接口出参:" +(ordRstDTO!=null?ordRstDTO.serializeJson():"null"));
			//3.如果返回信息是成功，则更新日志信息为已发送
			if(ordRstDTO!=null && BizStatusEnum.BIZ_SUCCESS.equals(ordRstDTO.getBiz_status())){
				BlThirdTransRcdDO blThirdTransRcdDO =this.getThirdDoById(id_transrcd);
				convertBlOrdQryRstDTOByRstDTO(blThirdTransRcdDO,ordRstDTO);
	            this.updateThirdTradeLog(id_transrcd, blThirdTransRcdDO);
				return FBoolean.TRUE;
			}
		}catch(Exception e){
			BLTaskLogger.info("患者："+blOrdReqDTO.getId_pat()+" 退费失败！"+e.getMessage());
		}
		return FBoolean.FALSE;
	}
    
	/**
	 * 将blOrdReqDTO转换为OrdReqDTO
	 * @param blOrdReqDTO
	 * @return
	 */
	private OrdReqDTO convertOrdReqDTO(BlOrdReqDTO blOrdReqDTO){
		OrdReqDTO ordReqDTO= new OrdReqDTO();
        ordReqDTO.setOrd_no(blOrdReqDTO.getOrd_no());
        ordReqDTO.setSubject(blOrdReqDTO.getSubject()); 
        ordReqDTO.setAmount(blOrdReqDTO.getAmt());
        ordReqDTO.setId_user_req(blOrdReqDTO.getId_psndoc());
        ordReqDTO.setSd_chl(blOrdReqDTO.getSd_chl());
        ordReqDTO.setTradetype(blOrdReqDTO.getTradetype()); 
        ordReqDTO.setRefund_req_no(blOrdReqDTO.getRefund_req_no());
        ordReqDTO.setFg_refund(blOrdReqDTO.getFg_refund());
		return ordReqDTO;
	}
	
	/**
	 * 将退费返回dto数据组织到日志表中
	 * @param blThirdTransRcdDO
	 * @param ordRstDTO
	 */
    private void convertBlOrdQryRstDTOByRstDTO(BlThirdTransRcdDO blThirdTransRcdDO,OrdRstDTO ordRstDTO)
    {
    	blThirdTransRcdDO.setOrder_no(ordRstDTO.getOrd_no());//外部订单号
        blThirdTransRcdDO.setVoucher_no(ordRstDTO.getTrade_no());//IIH支付平台内部交易号   
        blThirdTransRcdDO.setSerial_no_trd(ordRstDTO.getBanktradeno());//第三方交易流水号
        blThirdTransRcdDO.setSerial_no_ord(ordRstDTO.getBankorderno());//第三方交易订单号
        blThirdTransRcdDO.setSerial_no(ordRstDTO.getTrade_no_chl());//IIH支付平台渠道交易号           
        blThirdTransRcdDO.setHos_ord_no(ordRstDTO.getMch_order_no());//商户订单号
        blThirdTransRcdDO.setOutput(ordRstDTO.serializeJson());
        blThirdTransRcdDO.setAmt(ordRstDTO.getAmount());
        blThirdTransRcdDO.setDt_oper(ordRstDTO.getTradetime());
        blThirdTransRcdDO.setEu_direct((int)PayDirectEnum.CHANGE);
        blThirdTransRcdDO.setEu_status((int)TransStateEnum.TRDSUCCESS);
        blThirdTransRcdDO.setOutput(ordRstDTO.serializeJson());
    }
	/**
	 * 保存日志数据
	 * @param blThirdTransRcdDO
	 * @return
	 * @throws BizException
	 */
    public String saveThirdTradeLog(BlThirdTransRcdDO blThirdTransRcdDO) throws BizException
    {
    	ITrdtransrcdCudService trdtransrcdCrudService= ServiceFinder.find(ITrdtransrcdCudService.class);
    	BlThirdTransRcdDO[] blThirdTransRcdDOArr = trdtransrcdCrudService.save(new BlThirdTransRcdDO[] { blThirdTransRcdDO });
        return blThirdTransRcdDOArr != null?blThirdTransRcdDOArr[0].getId_transrcd():"";
    }
    /**
	 * 更新日志数据
	 * @throws BizException 
	 */
	public void updateThirdTradeLog(String id_transrcd, BlThirdTransRcdDO blThirdTransRcdDO) throws BizException{
		ITrdtransrcdRService ser = ServiceFinder.find(ITrdtransrcdRService.class);
		BlThirdTransRcdDO thirdTransRcdDO= ser.findById(id_transrcd);
		if(blThirdTransRcdDO!=null){
			thirdTransRcdDO.setEu_status( blThirdTransRcdDO.getEu_status());
            if (!StringUtils.isEmpty(blThirdTransRcdDO.getOutput())){
                thirdTransRcdDO.setOutput(blThirdTransRcdDO.getOutput());
            }
            if (!StringUtils.isEmpty(thirdTransRcdDO.getId_st())){
                thirdTransRcdDO.setId_st(blThirdTransRcdDO.getId_st()); 
            }
            if (!StringUtils.isEmpty(blThirdTransRcdDO.getId_par())){
                thirdTransRcdDO.setId_par(blThirdTransRcdDO.getId_par());
            }
            if (!StringUtils.isEmpty(blThirdTransRcdDO.getOrder_no())){
            	thirdTransRcdDO.setOrder_no(blThirdTransRcdDO.getOrder_no());//订单号
            }
            if (!StringUtils.isEmpty(blThirdTransRcdDO.getVoucher_no())){
            	 thirdTransRcdDO.setVoucher_no(blThirdTransRcdDO.getVoucher_no());//IIH支付平台内部交易号   
            }
            if (!StringUtils.isEmpty(blThirdTransRcdDO.getSerial_no_trd())){
            	thirdTransRcdDO.setSerial_no_trd(blThirdTransRcdDO.getSerial_no_trd());//第三方交易流水号
            }
            if (!StringUtils.isEmpty(blThirdTransRcdDO.getSerial_no_ord())){
            	thirdTransRcdDO.setSerial_no_ord(blThirdTransRcdDO.getSerial_no_ord());//第三方交易订单号
            }
            if (!StringUtils.isEmpty(blThirdTransRcdDO.getSerial_no())){
            	thirdTransRcdDO.setSerial_no(blThirdTransRcdDO.getSerial_no());//IIH支付平台渠道交易号 
            }
            if (!StringUtils.isEmpty(blThirdTransRcdDO.getHos_ord_no())){
            	thirdTransRcdDO.setHos_ord_no(blThirdTransRcdDO.getHos_ord_no());//商户订单号
            }
            if(blThirdTransRcdDO.getDt_oper()!=null){
            	thirdTransRcdDO.setDt_oper(blThirdTransRcdDO.getDt_oper());
            }
            thirdTransRcdDO.setFg_rollback(FBoolean.FALSE);
            thirdTransRcdDO.setStatus(DOStatus.UPDATED);	
            this.saveThirdTradeLog(thirdTransRcdDO);
		}
	}
	
	/**
	 * 组织支付平台日志DTO信息
	 * @param blOrdReqDTO 支付入参
	 * @param blOrdQryRstDTO 支付平台返回结果
	 * @param eu_status 交易状态
	 * @return
	 * @throws BizException
	 */
    public  BlThirdTransRcdDO setThirdPayDTO(BlOrdReqDTO blOrdReqDTO, BlOrdQryRstDTO blOrdQryRstDTO, int eu_status) throws BizException
    {
        BlThirdTransRcdDO blThirdTransRcdDO = new BlThirdTransRcdDO();
        if (blOrdReqDTO != null)
        {
            blThirdTransRcdDO.setId_bizscene(blOrdReqDTO.getId_bizscene()); //BlDictCodeConst.ID_BIZSCENE_PAY;
            blThirdTransRcdDO.setSd_bizscene(blOrdReqDTO.getSd_bizscene());// BlDictCodeConst.SD_BIZSCENE_PAY;
            blThirdTransRcdDO.setId_pat(blOrdReqDTO.getId_pat());
            blThirdTransRcdDO.setCode_enttp(blOrdReqDTO.getCode_enttp());// BdFcDictCodeConst.SD_CODE_ENTP_OP;
            if (blOrdReqDTO.getFg_refund().booleanValue())
            {
                String id_par=StringUtil.isEmpty(blOrdReqDTO.getId_par()) ? this.getThirdIdByOrdNo(blOrdReqDTO.getOrd_no()) : blOrdReqDTO.getId_par();
                BLBizLogger.info("退款的外部订单号：【" + blOrdReqDTO.getRefund_req_no() + "】对应的收款主键为【" + id_par + "】");
                blThirdTransRcdDO.setId_par(id_par); 
            }
            if (!StringUtil.isEmpty(blOrdReqDTO.getId_pm()))
            {
                blThirdTransRcdDO.setId_pm(blOrdReqDTO.getId_pm());
            }
            if (!StringUtil.isEmpty(blOrdReqDTO.getId_ent()))
            {
                blThirdTransRcdDO.setId_ent(blOrdReqDTO.getId_ent());
            }
            blThirdTransRcdDO.setId_st(blOrdReqDTO.getId_st());
            blThirdTransRcdDO.setId_pay(blOrdReqDTO.getId_pay());
            blThirdTransRcdDO.setEu_direct(blOrdReqDTO.getEu_direct()); // (int)PayDirectEnum.CHARGE;  
            blThirdTransRcdDO.setAmt(blOrdReqDTO.getAmt()); 
            blThirdTransRcdDO.setId_grp(Context.get().getGroupId());
            blThirdTransRcdDO.setId_org(Context.get().getOrgId());
            blThirdTransRcdDO.setId_emp_oper(Context.get().getStuffId());
            blThirdTransRcdDO.setCreatedby(Context.get().getStuffId());
            blThirdTransRcdDO.setInput(blOrdReqDTO.serializeJson()); 
            blThirdTransRcdDO.setSd_chl(blOrdReqDTO.getSd_chl());
            if (!StringUtil.isEmpty(blOrdReqDTO.getRefund_req_no()))
            {
                blThirdTransRcdDO.setRefund_req_no(blOrdReqDTO.getRefund_req_no());
            }
        }
        if(StringUtils.isNotEmpty(blOrdReqDTO.getOrd_no())){
        	blThirdTransRcdDO.setOrder_no(blOrdReqDTO.getOrd_no());//订单号
        }
        if (blOrdQryRstDTO != null)
        {
            blThirdTransRcdDO.setOrder_no(blOrdQryRstDTO.getOrd_no());//订单号
            blThirdTransRcdDO.setVoucher_no(blOrdQryRstDTO.getTrade_no());//IIH支付平台内部交易号   
            blThirdTransRcdDO.setSerial_no_trd(blOrdQryRstDTO.getBanktradeno());//第三方交易流水号
            blThirdTransRcdDO.setSerial_no_ord(blOrdQryRstDTO.getBankorderno());//第三方交易订单号
            blThirdTransRcdDO.setSerial_no(blOrdQryRstDTO.getTrade_no_chl());//IIH支付平台渠道交易号           
            blThirdTransRcdDO.setHos_ord_no(blOrdQryRstDTO.getMch_order_no());//商户订单号
            blThirdTransRcdDO.setOutput(blOrdQryRstDTO.serializeJson()); 
            blThirdTransRcdDO.setDt_oper(blOrdQryRstDTO.getTradetime()); 
        }

        blThirdTransRcdDO.setEu_status(eu_status);// (int)TransStateEnum.TRDSUCCESS;
        blThirdTransRcdDO.setCreatedtime(AppUtils.getServerDateTime()); 
        blThirdTransRcdDO.setStatus(DOStatus.NEW); 
        return blThirdTransRcdDO;
    }
    
    /**
     * 根据外部订单号查询对应的主键id
     * @param ordNo
     * @return
     * @throws BizException 
     */
    public static String getThirdIdByOrdNo(String ordNo) throws BizException
    {
    	//添加判斷 orderno 不能為空
    	if(!StringUtil.isEmpty(ordNo)){
    	    ////查询收款交易日志id
        	ITrdtransrcdRService trdtransrcdRService= ServiceFinder.find(ITrdtransrcdRService.class);
            BlThirdTransRcdDO[] blThirdTransRcdDO = trdtransrcdRService.findByAttrValString(BlThirdTransRcdDO.ORDER_NO, ordNo);
            if (!ArrayUtils.isEmpty(blThirdTransRcdDO))
            {
                return blThirdTransRcdDO[0].getId_transrcd();
            }
    	}
    	
        return "";
    }
    /**
     * 根据外部订单号查询收款人
     * @param ordNo
     * @return
     * @throws BizException 
     */
    public static String getEmpIdByOrdNo(String ordNo) throws BizException
    {
    	//添加判斷 orderno 不能為空
    	if(!StringUtil.isEmpty(ordNo)){
    	    ////查询收款交易日志id
        	ITrdtransrcdRService trdtransrcdRService= ServiceFinder.find(ITrdtransrcdRService.class);
            BlThirdTransRcdDO[] blThirdTransRcdDO = trdtransrcdRService.findByAttrValString(BlThirdTransRcdDO.ORDER_NO, ordNo);
            if (!ArrayUtils.isEmpty(blThirdTransRcdDO))
            {
            	for (BlThirdTransRcdDO blThirdDO : blThirdTransRcdDO) {
            		
				}
                return blThirdTransRcdDO[0].getId_emp_oper();
            }
    	}
    	
        return "";
    }
    /**
     * 查询在线支付日志表
     * @param id_transrcd
     * @return
     * @throws BizException
     */
    public BlThirdTransRcdDO getThirdDoById(String id_transrcd) throws BizException{
    	ITrdtransrcdRService ser= ServiceFinder.find(ITrdtransrcdRService.class);
        BlThirdTransRcdDO blThirdTransRcdDO =ser.findById(id_transrcd);
        return blThirdTransRcdDO!=null?blThirdTransRcdDO:new BlThirdTransRcdDO();
    }
    
    /**
     * 在线支付门诊收退费支付方式校验
     * @param blPayItmPatOepDOArr
     * @param scene
     * @return
     * @throws BizException 
     */
    public static BlPayItmPatOepDO validate (BlPayItmPatOepDO[] blPayItmPatOepDOArr,String scene) throws BizException{
    	List<String> idPmList= new ArrayList<String>();
    	for(BlPayItmPatOepDO itmOepDo:blPayItmPatOepDOArr){
    		idPmList.add(itmOepDo.getId_pm());
    	}
    	BlThirdPayValidateRltDTO dto=BlThirdPayValidateUtil.validate(idPmList.toArray(new String[]{}), scene);
    	if(FBoolean.TRUE.equals(dto.getFg_success()) && !StringUtils.isEmpty(dto.getId_pm())){
	    	for(BlPayItmPatOepDO itmOepDo:blPayItmPatOepDOArr){
	    		if(itmOepDo.getId_pm().equals(dto.getId_pm())){
	    			return itmOepDo;
	    		}
	    	}
    	}
    	return null;
    }
    /**
     * 在线支付门诊收退费支付方式校验  增加真实交易验证 并判断方向
     * @param blPayItmPatOepDOArr
     * @param scene
     * @return
     * @throws BizException 
     */
    public static BlPayItmPatOepDO validateNew (BlPayItmPatOepDO[] blPayItmPatOepDOArr,String scene,Integer eu_direct) throws BizException{
    	List<String> idPmList= new ArrayList<String>();
    	for(BlPayItmPatOepDO itmOepDo:blPayItmPatOepDOArr){
    		if(FBoolean.TRUE.equals(itmOepDo.getFg_realpay())&&itmOepDo.getEu_direct().equals(eu_direct)){
        		idPmList.add(itmOepDo.getId_pm());
    		}
    	}
    	BlThirdPayValidateRltDTO dto=BlThirdPayValidateUtil.validate(idPmList.toArray(new String[]{}), scene);
    	if(FBoolean.TRUE.equals(dto.getFg_success()) && !StringUtils.isEmpty(dto.getId_pm())){
	    	for(BlPayItmPatOepDO itmOepDo:blPayItmPatOepDOArr){
	    		if(itmOepDo.getId_pm().equals(dto.getId_pm())
	    				&&itmOepDo.getFg_realpay().booleanValue()&&itmOepDo.getEu_direct().equals(eu_direct)
	    				){
	    			return itmOepDo;
	    		}
	    	}
    	}
    	return null;
    }
    /**
	 * 查询退费状态
	 * @param blOrdReqDTO
	 * @return
	 * @throws BizException
	 */
	public String refundQuery(BlOrdReqDTO blOrdReqDTO) throws BizException{
		OrdReqDTO ordReqDTO=this.convertOrdReqDTO(blOrdReqDTO);
		IPmpPayOperatorService ser = ServiceFinder.find(IPmpPayOperatorService.class);
		String status=ser.RefundTaskQry(ordReqDTO);
		if(!StringUtil.isEmpty(status)){
			return status;
			//ordRstDTO=this.convertQryRstDTOToRstDTO(ordQryRstDTO[0]);
		}
		return null;
	}
	/**
	 * 将退费查询返回值进行转换
	 * @param ordQryRstDTO
	 * @return
	 */
	private OrdRstDTO convertQryRstDTOToRstDTO(OrdQryRstDTO ordQryRstDTO){
		OrdRstDTO ordRstDTO= new OrdRstDTO();
		ordRstDTO.setTrade_no(ordQryRstDTO.getTrade_no());//IIH支付平台内部交易号   
		ordRstDTO.setBanktradeno(ordQryRstDTO.getBanktradeno());//第三方交易流水号
		ordRstDTO.setBankorderno(ordQryRstDTO.getBankorderno());//第三方交易订单号
        ordRstDTO.setTrade_no_chl(ordQryRstDTO.getTrade_no_chl());//IIH支付平台渠道交易号           
        ordRstDTO.setMch_order_no(ordQryRstDTO.getMch_order_no());//商户订单号
        ordRstDTO.setAmount(ordQryRstDTO.getAmount());
        ordRstDTO.setTradetime(ordQryRstDTO.getTradetime());
        ordRstDTO.setTrade_status(ordQryRstDTO.getTrade_status());//交易状态
        ordRstDTO.setBiz_status(ordQryRstDTO.getBiz_status());
        return ordRstDTO;
	}
	/**
	 * 设置交易状态
	 * @param ordRstDTO
	 * @param id_transrcd
	 * @param id_interfacerefundinfo
	 * @throws BizException 
	 */
	public FBoolean updateTradeStatus(OrdRstDTO ordRstDTO,String id_transrcd) throws BizException{
		if(ordRstDTO!=null && BizStatusEnum.BIZ_SUCCESS.equals(ordRstDTO.getBiz_status())){
			BlThirdTransRcdDO blThirdTransRcdDO =this.getThirdDoById(id_transrcd);
			convertBlOrdQryRstDTOByRstDTO(blThirdTransRcdDO,ordRstDTO);
            this.updateThirdTradeLog(id_transrcd, blThirdTransRcdDO);
            return FBoolean.TRUE;
		}else{
			return FBoolean.FALSE;
		}
	}
	/**
	 * 根据结算数据判断交易场景
	 * 
	 * @param Eu_sttp
	 * @return
	 * @throws BizException 
	 */
	public static String isScene(BlStOepDO blstoepDO) throws BizException {
		String sd_biz = null;
		// 判断交易场景
		if (StringUtils.isNotEmpty(blstoepDO.getPecode()) && PayDirectEnum.CHANGE.equals(blstoepDO.getEu_direct())) {
			// 体检退费
			sd_biz = IBlDictCodeConst.SD_BIZSCENE_PE_REFUND;
		} else if (StringUtils.isNotEmpty(blstoepDO.getPecode())
				&& PayDirectEnum.CHARGE.equals(blstoepDO.getEu_direct())) {
	        //团检收费 体检收费
			sd_biz =isPeCustSt(blstoepDO.getId_pat())?IBlDictCodeConst.SD_BIZSCENE_PECUST_CHARGE:IBlDictCodeConst.SD_BIZSCENE_PE_CHARGE;
		}else {
			switch (blstoepDO.getEu_sttp()) {
			// 挂号取消结算
			case StTypeEnum.ST_REGISTER_RED:
				sd_biz = IBlDictCodeConst.SD_BIZSCENE_OEP_REENT;
				break;
			// 挂号结算
			case StTypeEnum.ST_OEP_REG:
				sd_biz = IBlDictCodeConst.SD_BIZSCENE_OEP_ENT;
				break;
			// 门诊收费
			case StTypeEnum.ST_OEP_CHARGE:
				sd_biz = IBlDictCodeConst.SD_BIZSCENE_OEP_CHARGE;
				break;
			// 门诊取消收费
			case StTypeEnum.ST_OEP_RED:
				sd_biz = IBlDictCodeConst.SD_BIZSCENE_OEP_REFUND;
				break;
			default:
				break;
			}
		}
		return sd_biz;
	}
	/**
	 * 查询是否为团体患者
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private static Boolean isPeCustSt(String id_pat) throws BizException{
		IPatcustRService ipatRService = ServiceFinder.find(IPatcustRService.class);
		PiPatCustDO[] piPatCustDOs = ipatRService.findByAttrValString(PiPatCustDO.ID_PAT, id_pat);
		if(!ArrayUtil.isEmpty(piPatCustDOs)){
			return true;
		}
		return false;
	}
	/**
	 * 是否是后台退费
	 * @param id_pm
	 * @return
	 * @throws BizException
	 */
	public static boolean isThirdFefund(String id_pm) throws BizException{
		ITrdtransregRService iRegService = ServiceFinder.find(ITrdtransregRService.class);
		BlThirdTransRegDO[] blThirdTransRegDOs = iRegService.findByAttrValString(BlThirdTransRegDO.ID_PM, id_pm);
		if(!ArrayUtil.isEmpty(blThirdTransRegDOs)){
			Integer eu_port = blThirdTransRegDOs[0].getRefund_port();
			if(eu_port==null||FrontEndEnum.END.equals(eu_port)){
				return true;
			}
		}
		return false;
	}
	
}
