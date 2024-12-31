package iih.bl.st.s.task;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.transaction.TransactionStatus;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.base.utils.StringUtils;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.d.BlThirdTransRegDO;
import iih.bl.itf.trdtrans.d.TransStateEnum;
import iih.bl.itf.trdtrans.i.ITrdtransregRService;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;
/**
 * 定时退费任务 并更新退费状态 
 * @author Administrator
 *
 */
public class ResendIIHRefundInfoTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		PreAlertObject obj = new PreAlertObject();
		
		Map<String, Object> map = ctx.getKeyMap();
		String id_pm = (String) map.get("id_pm");
		String days = (String) map.get("days");
		if(StringUtil.isEmpty(id_pm)||StringUtil.isEmpty(days)){
			throw new BizException("请维护在线退费任务的支付方式和周期");
		}
		FDateTime dtBegin = new FDateTime(AppUtils.getServerDate().getDateBefore(Integer.parseInt(days)-1).getMillis());
		FDateTime dtEnd = new FDateTime(AppUtils.getServerDateTime().getMillis()).subSeconds(1800);
		//多组织处理
		IOrgRServiceExt orgService = ServiceFinder.find(IOrgRServiceExt.class);
		OrgDO[] orgDos =  orgService.queryAllOrgUnitVOs();
		
		if(ArrayUtil.isEmpty(orgDos))
			return obj;
		
		for (OrgDO orgDO : orgDos) {
			Context.get().setGroupId(orgDO.getId_grp());
			Context.get().setOrgId(orgDO.getId_org());
			Context.get().setGroupNumber(orgDO.getGroupno());
			
			//1.查询所有支付终端类型为窗口，支付方式为支付宝或者微信并且发送状态为失败的数据
			BlOrdReqDTO[] refundInfoDOArr=this.getSendFailInfo(id_pm,dtBegin,dtEnd);
			//2.调用发送失败数据重新发送
			if(ArrayUtils.isNotEmpty(refundInfoDOArr)){
				for(final BlOrdReqDTO retfundInfo :refundInfoDOArr){
					
					TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
						@Override
						public String doInTransaction(TransactionStatus arg0) throws InvocationTargetException {
							try {
								process(retfundInfo);
							} catch (BizException e) {
								throw new InvocationTargetException(e);
							}
							return null;
					     }
					});
			    	
				}
			}
		}
		
	
		
		return obj;
	}
	/**
	 * 执行退费逻辑
	 * @param retfundInfo
	 * @throws BizException
	 */
	private void process(BlOrdReqDTO retfundInfo) throws BizException{
		Context.get().setStuffId(retfundInfo.getId_psndoc());
    	FBoolean fBoolean =FBoolean.FALSE;
    	BlThirdPayBP bp = new BlThirdPayBP();
    	String status = bp.refundQuery(retfundInfo);
		if (status != null && TradeStatusEnum.REFUND_SUCCESS.toString().equals(status)) {
			upDateThirdState(retfundInfo.getId_transrcd(),bp);
			fBoolean =FBoolean.TRUE;
			String msg =fBoolean.booleanValue() ? "  退费成功":"  退费失败";
			BLTaskLogger.info("患者：【"+ retfundInfo.getId_pat()+"】退费信息："+ retfundInfo.serializeJson()+msg);
			return ;
		}
		fBoolean = bp.execRefund(retfundInfo, retfundInfo.getId_transrcd());
		if(fBoolean.booleanValue()){
			upDateThirdState(retfundInfo.getId_transrcd(),bp);
		}
		String msg =fBoolean.booleanValue() ? "  退费成功":"  退费失败";
		BLTaskLogger.info("患者：【"+ retfundInfo.getId_pat()+"】退费信息："+ retfundInfo.serializeJson()+msg);
	}
	/**
	 * 更新第三方交易记录状态
	 * @param id_transrcd
	 * @param bp
	 * @throws BizException
	 */
	  private void upDateThirdState(String id_transrcd,BlThirdPayBP bp) throws BizException{
	    	BlThirdTransRcdDO blThirdTransRcdDO =new BlThirdTransRcdDO();
			blThirdTransRcdDO.setEu_status((int)TransStateEnum.TRDSUCCESS);
			bp.updateThirdTradeLog(id_transrcd, blThirdTransRcdDO);
	    }
    /**
     * 查询要退费的信息
     * @return
     * @throws BizException 
     */
	private BlOrdReqDTO[] getSendFailInfo(String id_pm,FDateTime dtBegin,FDateTime dtEnd) throws BizException {
		List<BlOrdReqDTO> listBlOrdDTO = new ArrayList<BlOrdReqDTO>();
		
		Map<String, BlThirdTransRegDO> transRegMap = findThirdTransReg(id_pm);
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" select rcd.id_transrcd,rcd.order_no,rcd.amt,rcdor.id_emp_oper,rcd.id_pm,rcd.code_enttp,rcd.id_bizscene,rcd.sd_bizscene,rcd.id_pat ,rcd.eu_status,rcd.refund_req_no ");
		sqlSb.append(" from  bl_trd_trans_rcd rcd ");
		sqlSb.append(" inner join bl_trd_trans_rcd rcdor on rcdor.id_transrcd =rcd.id_par ");
		sqlSb.append(" where  rcd.order_no  is not null and  rcd.eu_direct=-1 and rcd.eu_status=3 and   (rcd.createdtime between ? and ?)  and rcd.refund_req_no is not null ");
		sqlSb.append(" and "+SqlUtils.getInSqlByIdsSplit("rcd.Id_pm", id_pm));
		sqlSb.append(" and rcd.id_org =? " );
		SqlParam param = new SqlParam();
		param.addParam(dtBegin);
		param.addParam(dtEnd);
		param.addParam(Context.get().getOrgId());
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BlThirdTransRcdDO> blThirdTransRcdDOs = (List<BlThirdTransRcdDO>)daf.execQuery(
				sqlSb.toString(), param, new BeanListHandler(BlThirdTransRcdDO.class));
	
	    for (BlThirdTransRcdDO blThirdTransRcdDO : blThirdTransRcdDOs) {
	    	BlOrdReqDTO dto = new BlOrdReqDTO();
	    	//退费金额
	    	dto.setAmt(blThirdTransRcdDO.getAmt());
	    	//订单号
	    	dto.setOrd_no(blThirdTransRcdDO.getOrder_no());
	    	//退费人员
	    	dto.setId_psndoc(blThirdTransRcdDO.getId_emp_oper());
	    	//退款请求号
	    	dto.setRefund_req_no(blThirdTransRcdDO.getRefund_req_no());
	    	//内容
	    	dto.setSubject("延迟退费" + blThirdTransRcdDO.getAmt() + "元");
	    	//方向
	    	dto.setEu_direct(PayDirectEnum.CHANGE);
	    	//支付方式id
	    	dto.setId_pm(blThirdTransRcdDO.getId_pm());
	    	//就诊类型
	    	dto.setCode_enttp(blThirdTransRcdDO.getCode_enttp());
	    	//交易场景
	    	dto.setId_bizscene(blThirdTransRcdDO.getId_bizscene());
	    	dto.setSd_bizscene(blThirdTransRcdDO.getSd_bizscene());
	    	dto.setFg_refund(FBoolean.TRUE);
	    	dto.setTrade_status(blThirdTransRcdDO.getEu_status());
	    	//第三方交易记录id
	    	dto.setId_transrcd(blThirdTransRcdDO.getId_transrcd());
	    	//患者id
	    	dto.setId_pat(blThirdTransRcdDO.getId_pat());
	    	//交易渠道
	    	dto.setSd_chl(transRegMap.get(blThirdTransRcdDO.getId_pm()).getSd_paychannel());
	    	//交易类型
	    	if(StringUtils.isNotEmpty(transRegMap.get(blThirdTransRcdDO.getId_pm()).getTrade_type())){
		    	dto.setTradetype(transRegMap.get(blThirdTransRcdDO.getId_pm()).getTrade_type());
	    	}else {
	    		dto.setTradetype(IBdPripmCodeConst.ID_PRI_PM_ALIPAY.equals(blThirdTransRcdDO.getId_pm()) ? CmbcSceneEnum.ZFBSCAN
	    				: CmbcSceneEnum.WXSCAN);
	    	}
	    	listBlOrdDTO.add(dto);
		}
		return listBlOrdDTO.toArray(new BlOrdReqDTO[]{});
	}
	/**
	 * 查询第三方交易注册信息
	 * @param id_pm
	 * @return
	 * @throws BizException 
	 */
	private Map<String,BlThirdTransRegDO> findThirdTransReg(String id_pm) throws BizException{
		Map<String,BlThirdTransRegDO> RegMap = new HashMap<String,BlThirdTransRegDO>();
		ITrdtransregRService regService = ServiceFinder.find(ITrdtransregRService.class);
		BlThirdTransRegDO[] blThirdTransRegDOs = regService.find(SqlUtils.getInSqlByIdsSplit("Id_pm", id_pm), "", FBoolean.FALSE);
		for (BlThirdTransRegDO blThirdTransRegDO : blThirdTransRegDOs) {
			RegMap.put(blThirdTransRegDO.getId_pm(), blThirdTransRegDO);
		}
		return RegMap;
	}
}
