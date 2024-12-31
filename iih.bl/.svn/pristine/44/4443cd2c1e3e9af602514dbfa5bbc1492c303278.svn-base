package iih.bl.st.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.itf.trdtrans.d.TransStateEnum;
import iih.bl.st.dto.d.BlReconciliationQryCondDTO;
import iih.bl.st.dto.d.BlReconciliationShowDataDTO;
import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
* @ClassName: GetTransactionDataBP  
* @Description: 获取交易数据 
* @author xy.zhou
* @date 2019年3月29日
 */
public class GetTransactionDataBP {

	public BlReconciliationShowDataDTO[] exec(BlReconciliationQryCondDTO blCondDTO )throws BizException{
		
		if(blCondDTO==null){
			throw new BizException("查询条件为空！");
		}
		
		//获取iih交易表数据
		List<BlReconciliationShowDataDTO> qryIIHReconciliationData = this.qryIIHReconciliationData(blCondDTO);
		if(ListUtil.isEmpty(qryIIHReconciliationData)){
			return null;
		}
		
		//调用平台获取部分字段
		qryPlatformReconciliationData(qryIIHReconciliationData);
		
		return qryIIHReconciliationData.toArray(new BlReconciliationShowDataDTO[]{});
	}
	
	/**
	 * 获取iih数据
	 */
	@SuppressWarnings("unchecked")
	private List<BlReconciliationShowDataDTO> qryIIHReconciliationData(BlReconciliationQryCondDTO blCondDTO) throws BizException{
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select rcd.id_transrcd, ");
		sqlSb.append("       rcd.id_transreg, ");
		sqlSb.append("       reg.name_factory as name_transreg, ");
		sqlSb.append("       rcd.dt_oper, ");
		sqlSb.append("       doc1.id_udidoc as id_serial, ");
		sqlSb.append("       rcd.sd_chl as code_serial, ");
		sqlSb.append("       doc1.name as name_serial, ");
		sqlSb.append("       rcd.id_bizscene, ");
		sqlSb.append("       rcd.sd_bizscene as code_bizscene, ");
		sqlSb.append("       doc2.name as name_bizscene, ");
		sqlSb.append("       rcd.id_pat, ");
		sqlSb.append("       pat.code as code_pat, ");
		sqlSb.append("       pat.name as name_pat, ");
		sqlSb.append("       pat.mob as pat_mob, ");
		sqlSb.append("       pat.id_idtp, ");
		sqlSb.append("       pat.sd_idtp, ");
		sqlSb.append("       pat.id_code, ");
		sqlSb.append("       doc3.name as name_idtp, ");
		sqlSb.append("       rcd.id_pm, ");
		sqlSb.append("       pm.code as code_pm, ");
		sqlSb.append("       pm.name as name_pm, ");
		sqlSb.append("       rcd.fg_rollback, ");
		sqlSb.append("       (case ");
		sqlSb.append("         when rcd.eu_direct = 1 then ");
		sqlSb.append("          '支付' ");
		sqlSb.append("         else ");
		sqlSb.append("          '退款 ' ");
		sqlSb.append("       end) as name_eu_direct, ");
		sqlSb.append("       rcd.eu_direct as code_eu_driect, ");
		sqlSb.append("       rcd.id_emp_oper, ");
		sqlSb.append("       psn.name as name_emp_oper, ");
		sqlSb.append("       (case rcd.eu_status ");
		sqlSb.append("         when 0 then ");
		sqlSb.append("          '第三方交易成功' ");
		sqlSb.append("         when 1 then ");
		sqlSb.append("          'IIH交易成功' ");
		sqlSb.append("         when 2 then ");
		sqlSb.append("          '第三方交易回退' ");
		sqlSb.append("         when 3 then ");
		sqlSb.append("          '第三方交易失败' ");
		sqlSb.append("       end) as name_eu_iihstatus, ");
		sqlSb.append("       rcd.eu_status as code_eu_iihstatus,  ");
		sqlSb.append("       rcd.trademsg as des, ");
		sqlSb.append("       rcd.trademsg as trademsg, ");
		sqlSb.append("       rcd.amt, ");
		sqlSb.append("       rcd.serial_no, ");
		sqlSb.append("       rcd.hos_ord_no, ");
		sqlSb.append("       rcd.voucher_no, ");
		sqlSb.append("       rcd.order_no, ");
		sqlSb.append("       rcd.serial_no_ord, ");
		sqlSb.append("       rcd.serial_no_trd, ");
		sqlSb.append("       rcd.id_par, ");
		sqlSb.append("       rcd2.order_no ");
		sqlSb.append("  from bl_trd_trans_rcd rcd ");
		sqlSb.append("  left join bl_trd_trans_reg reg ");
		sqlSb.append("    on rcd.id_transreg = reg.id_transreg ");
		sqlSb.append("  left join bd_udidoc doc1 ");
		sqlSb.append("    on doc1.code = rcd.sd_chl ");
		sqlSb.append("  left join bd_udidoc doc2 ");
		sqlSb.append("    on doc2.id_udidoc = rcd.id_bizscene ");
		sqlSb.append("  left join pi_pat pat ");
		sqlSb.append("    on pat.id_pat = rcd.id_pat ");
		sqlSb.append("  left join bd_udidoc doc3 ");
		sqlSb.append("    on pat.id_idtp = doc3.id_udidoc ");
		sqlSb.append("  left join bd_pri_pm pm ");
		sqlSb.append("    on pm.id_pm = rcd.id_pm ");
		sqlSb.append("  left join bd_psndoc psn ");
		sqlSb.append("    on psn.id_psndoc = rcd.id_emp_oper ");
		sqlSb.append("  left join bl_trd_trans_rcd rcd2 ");
		sqlSb.append("    on rcd2.id_transrcd = rcd.id_par");
		sqlSb.append(" where 1=1 ");
		
		if(!StringUtil.isEmpty(blCondDTO.getCode_serial())){
			sqlSb.append(" and rcd.sd_chl ='").append(blCondDTO.getCode_serial()).append("' ");
		}
		if(!StringUtil.isEmpty(blCondDTO.getId_pm())){
			sqlSb.append("  and rcd.id_pm ='").append(blCondDTO.getId_pm()).append("' ");
		}
		if(blCondDTO.getDt_transr_start()!=null){
			sqlSb.append(" and rcd.dt_oper >='").append(blCondDTO.getDt_transr_start()).append("' ");
		}
		if(blCondDTO.getDt_transr_last()!=null){
			sqlSb.append(" and rcd.dt_oper <='").append(blCondDTO.getDt_transr_last()).append("' ");
		}
		if(!StringUtil.isEmpty(blCondDTO.getId_emp_oper())){
			sqlSb.append(" and rcd.id_emp_oper='").append(blCondDTO.getId_emp_oper()).append("' ");
		}
		List<BlReconciliationShowDataDTO> bShowDataDTOs = (List<BlReconciliationShowDataDTO>) new DAFacade().execQuery(sqlSb.toString(),new BeanListHandler(BlReconciliationShowDataDTO.class));

		return bShowDataDTOs;
	}
	
	/**
	 * 获取部分平台数据(部分业务字段不明确待改进)
	 */
	private void qryPlatformReconciliationData(List<BlReconciliationShowDataDTO> blDataDTOs) throws BizException{
		
		IPmpPayOperatorService iService=ServiceFinder.find(IPmpPayOperatorService.class);
		List<OrdReqDTO> ordReqDTOs=new ArrayList<>();
		for (BlReconciliationShowDataDTO bDataDTO : blDataDTOs) {
			OrdReqDTO ordReqDTO=new OrdReqDTO();
			ordReqDTO.setOrd_no(bDataDTO.getOrder_no());
			ordReqDTO.setRefund_req_no(bDataDTO.getRefund_req_no());
			ordReqDTO.setId_user_req(bDataDTO.getId_emp_oper());
			ordReqDTOs.add(ordReqDTO);
		}
		//获取pmp字段信息
		OrdQryRstDTO[] ordQryRstDTOs = iService.PMPQueryBatch(ordReqDTOs.toArray(new OrdReqDTO []{}));
		if(ArrayUtil.isEmpty(ordQryRstDTOs)){
			return;
		}
		Map<String, OrdQryRstDTO> ordMap=new HashMap<>();
		StringBuffer str=new StringBuffer();
		for (OrdQryRstDTO ordQryRstDTO : ordQryRstDTOs) {
			str.append(ordQryRstDTO.getOrd_no());
			str.append(ordQryRstDTO.getRefund_no());
			str.append(ordQryRstDTO.getId_user_req());
			str.setLength(0);
			ordMap.put(str.toString(), ordQryRstDTO);
		}
		
		for (BlReconciliationShowDataDTO bDataDTO : blDataDTOs) {
			str.append(bDataDTO.getOrder_no());
			str.append(bDataDTO.getRefund_req_no());
			str.append(bDataDTO.getId_emp_oper());
			if(ordMap.containsKey(str.toString())){
				OrdQryRstDTO ordQryRstDTO = ordMap.get(str.toString());
				
				if(!bDataDTO.getCode_eu_iihstatus().equals(TransStateEnum.IIHSUCCESS)){//Exception_type这个字段搞不太清楚怎么赋值，待改进
					
					if(bDataDTO.getCode_eu_direct().equals(1)&&ordQryRstDTO.getOrd_status().equals(OrdStatusEnum.PAID)){
						bDataDTO.setException_type("异常已经处理");
					}else if(bDataDTO.getCode_eu_direct().equals(-1)&&ordQryRstDTO.getTrade_status().equals(OrdStatusEnum.TURN_REFUND)){
						bDataDTO.setException_type("异常已经处理");
					}else{
						bDataDTO.setException_type("异常未处理");
					}
					
				}
				
				if(TradeStatusEnum.TRADE_UNKNOWN==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.TRADE_UNKNOWN.toString());
					bDataDTO.setName_eu_pmpstatus("交易结果位置未知");
				}else if(TradeStatusEnum.PAY_SUCCESS==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.PAY_SUCCESS.toString());
					bDataDTO.setName_eu_pmpstatus("支付成功");
				}else if(TradeStatusEnum.PAY_WAIT==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.PAY_WAIT.toString());
					bDataDTO.setName_eu_pmpstatus("等待支付");
				}else if(TradeStatusEnum.PAY_FAIL==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.PAY_FAIL.toString());
					bDataDTO.setName_eu_pmpstatus("支付失败");
				}else if(TradeStatusEnum.REFUND_SUCCESS==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.REFUND_SUCCESS.toString());
					bDataDTO.setName_eu_pmpstatus("退款成功");
				}else if(TradeStatusEnum.REFUND_FAIL==ordQryRstDTO.getTrade_status()){
					if(ordQryRstDTO.getRefund_no().isEmpty()){
						bDataDTO.setCode_eu_pmpstatus(OrdStatusEnum.REVERSE.toString());
						bDataDTO.setName_eu_pmpstatus("撤回");
					}else{
						bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.REFUND_FAIL.toString());
						bDataDTO.setName_eu_pmpstatus("退款失败");
					}		
				}else if(TradeStatusEnum.TURN_REFUND==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.TURN_REFUND.toString());
					bDataDTO.setName_eu_pmpstatus("转入退款");
				}else if(TradeStatusEnum.CLOSED==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.CLOSED.toString());
					bDataDTO.setName_eu_pmpstatus("已关闭");
				}else if(TradeStatusEnum.REVOKED==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.REVOKED.toString());
					bDataDTO.setName_eu_pmpstatus("已撤销");
				}else if(TradeStatusEnum.NOTPAY==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.NOTPAY.toString());
					bDataDTO.setName_eu_pmpstatus("未支付");
				}else if(TradeStatusEnum.REFUNDING==ordQryRstDTO.getTrade_status()){
					bDataDTO.setCode_eu_pmpstatus(TradeStatusEnum.REFUNDING.toString());
					bDataDTO.setName_eu_pmpstatus("退款中");
				} 
				
			}
		}
	}
}
