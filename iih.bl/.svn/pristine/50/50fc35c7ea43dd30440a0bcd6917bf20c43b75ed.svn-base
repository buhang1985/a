package iih.bl.pay.blpaypat.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blprepay.ep.UpdateAccInfoEp;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
/**
 * 门诊收费、退费、住院收付款时如果支付方式选择了预交金，则更改预交金账户金额，在预交金中增加一条记录
 * @author li_pengying
 *
 */
public class PrepayPatOpBp {
	/**
	 * 目前供门诊收费节点，退费节点，住院收付款节点使用：
	 * 收、退费方式为预交金，即在预交金中增加相关一条预交金操作记录，并修改预交金账户金额
	 * @param payment_prepay_amt 支付的预交金金额
	 * @param id_pat 患者ID
	 * @param operatorInfoDTO 操作员信息
	 * @param eu_direct 预交金收付款方向
	 * @param entType 就诊类型ID
	 * @param sd_paytp 收付款方式SD
	 * @param id_paytp 收付款方式iD
	 * @param note 备注
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] saveBlPayPatInfoRefund(FDouble payment_prepay_amt,String id_pat,OperatorInfoDTO operatorInfoDTO,Integer eu_direct,String entType,String sd_paytp,String id_paytp,String note) 
			throws BizException{
		BlPrePayPatDO blPayPatDO=new BlPrePayPatDO();
		
//		sd_paytp	预交金收付款类型	21 患者预交金消费
//		blPayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_CODE_HZYJ);
//		blPayPatDO.setId_paytp(IBlDictCodeConst.SD_PAYTP_ID_HZYJ);
		blPayPatDO.setSd_paytp(sd_paytp);
		blPayPatDO.setId_paytp(id_paytp);
		if(eu_direct==1 && IBlDictCodeConst.SD_PAYTP_OPPREPAY.equals(sd_paytp)) //剩余预交金结存
		{
			blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
			blPayPatDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
		}
		else
		{
			blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
			blPayPatDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
		}
		blPayPatDO.setId_pat(id_pat);
		blPayPatDO.setId_org(operatorInfoDTO.getId_org());
		blPayPatDO.setId_grp(operatorInfoDTO.getId_grp());
		blPayPatDO.setId_org_pay(operatorInfoDTO.getId_org_emp());
		blPayPatDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		blPayPatDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatDO.setAmt(payment_prepay_amt);//金额
		blPayPatDO.setId_bank(null);
		blPayPatDO.setBankno(null);
		blPayPatDO.setPaymodenode(null);
		blPayPatDO.setFg_canc(FBoolean.FALSE);
		blPayPatDO.setId_emp_canc(null);
		blPayPatDO.setDt_canc(null);
		blPayPatDO.setFg_cc(FBoolean.FALSE);
		blPayPatDO.setId_cc(null);
		
		blPayPatDO.setCode_rep(null);
		blPayPatDO.setId_par(null);
		blPayPatDO.setFg_rep_return(FBoolean.FALSE);
		blPayPatDO.setSd_rep_lost(null);
		blPayPatDO.setId_rep_lost(null);
		blPayPatDO.setEu_direct(eu_direct);//收退款方向,与预交金账户增减额方向一致
		blPayPatDO.setDt_return(null);
		blPayPatDO.setId_emp_return(null);
		blPayPatDO.setId_st_mid(null);
		blPayPatDO.setNote(note);
		Object pttp = Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_SD_PTTP);
		if(pttp != null){
			blPayPatDO.setSd_pttp((String)pttp);
		}
		TimeService timeService = new TimeServiceImpl();//获取当前服务器时间
		FDateTime dateTime = timeService.getUFDateTime();
		blPayPatDO.setDt_pay(dateTime);
//		blPayPatDO.setCode_incca(this.getRepCodeByCCTP(payType));//票据类型编码
//		blPayPatDO.setId_incca(this.getRepIdByCCTP(payType));//票据类型ID
		blPayPatDO.setId_ent(null);//就诊类型id,门急诊结算不考虑
		blPayPatDO.setId_enttp(entType);//就诊类型id,门急诊结算不考虑
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(entType)){
			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(entType)){
			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		}
		blPayPatDO.setStatus(DOStatus.NEW);//数据状态为新增
		if(StringUtil.isEmpty(blPayPatDO.getId_paypat())){
			blPayPatDO.setId_paypat( new DBUtil().getOIDs(1)[0]);
		}
		
		FBoolean IsTransferPrepay  =FBoolean.FALSE;
		if(Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_TRANSFERPREPAY)!=null)
		{
			IsTransferPrepay=(FBoolean)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_TRANSFERPREPAY) ;
		}
		 
		
		if(eu_direct==1 && FBoolean.TRUE.equals(IsTransferPrepay) )//结存
		{
			FBoolean Fg_useinc =FBoolean.FALSE;
			
			if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(entType))
			{
				Fg_useinc = BlParams.BLINC0017();
				
			}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(entType))
			{
				Fg_useinc =BlParams.BLINC0018();
			}
					
			String code="";
			if(FBoolean.TRUE.equals(Fg_useinc))
			{
				if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(entType)){
					code = BlCodeUtils.generateOpPrepayCode();
				}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(entType)){
					code = BlCodeUtils.generateIpPrepayCode();
				}
			}		
			else
			{
				IBlIncUtilService incService =ServiceFinder.find(IBlIncUtilService.class);
				String inccaId = IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(entType) ? 
						IBdInccaCodeConst.ID_INHOS_DEPOSIT : IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT;
				
				code = incService.getCurInvoiceNo(Context.get().getStuffId(),Context.get().getClientHost(),inccaId);
			}
			
			blPayPatDO.setCode_rep(code);

			if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(entType)){
				blPayPatDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
			}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(entType)){
				blPayPatDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			}
			
			PrepayPatRcptEP prepayEp = new PrepayPatRcptEP();
			BlPrepayPatRcptDO rcptDO = null;
			if (FBoolean.FALSE.equals(Fg_useinc)) {
				rcptDO = prepayEp.saveRcptPrint(blPayPatDO, null);
			} else {
				rcptDO = prepayEp.saveRcptPrintWithCode(blPayPatDO, code);
			}
			blPayPatDO.setCode_rep(rcptDO.getCode_rep());
		}
		
		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] blPrePayPatDO = payService.save(new BlPrePayPatDO[]{blPayPatDO});
		if(blPrePayPatDO == null || blPrePayPatDO.length == 0){
			throw new BizException("保存结算——预交金数据失败！");
		}
		
//		//修改患者预交金收退款总额，在DoOepFgAmtAcc中完成
//		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(entType)){
//			this.updateBlPayMamtOepInfo(blPayPatDO.getId_pat(), eu_direct, blPayPatDO.getAmt(), blPayPatDO.getId_pm(), blPayPatDO.getSd_pm());
//		}
		
		//账户信息修改	
		UpdateAccInfoEp newep=new UpdateAccInfoEp();
		newep.updatePiPatAccInfo(payment_prepay_amt.multiply(eu_direct).doubleValue(), blPayPatDO, entType);
		
		return blPrePayPatDO;
	}
}
