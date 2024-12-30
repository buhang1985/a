package iih.sc.apt.s.bp;

import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.comm.ScAppUtils;

/**
 * 预约支付信息转换
 * @author yank
 *
 */
public class AptPayInfoParser {
	/**
	 * 转换为就诊支付信息
	 * @param aptPayDTO
	 * @return
	 */
	public PayInfoDTO transToEnPayInfo(AptPayDTO aptPayDTO){
		//当PayInfoDTO中存在PayInfoDTO时，直接使用
		if(aptPayDTO.getPayinfo() != null && aptPayDTO.getPayinfo().size() > 0){
			return (PayInfoDTO)aptPayDTO.getPayinfo().get(0);
		}
		PayInfoDTO payInfo = new PayInfoDTO();
		payInfo.setAmt_st(aptPayDTO.getAmt_st());//标准金额
		payInfo.setAmt_hp(aptPayDTO.getAmt_hp());//医保支付
		payInfo.setAmt_pat(aptPayDTO.getAmt_pat());//患者自付			
		payInfo.setAmt(aptPayDTO.getAmt());//应付金额
		payInfo.setRelpay(aptPayDTO.getRelpay());//实收
		payInfo.setChange(aptPayDTO.getChange());//找零	
		payInfo.setPaystyle(aptPayDTO.getPaystyle());//支付方式
		payInfo.setNo_bank(aptPayDTO.getNo_bank());//支付账号
		payInfo.setRemark(aptPayDTO.getRemark());//支付备注，如订单号
		payInfo.setFg_print(aptPayDTO.getFg_print());
		payInfo.setFg_newprice(aptPayDTO.getFg_newprice());
		payInfo.setSd_pttp(aptPayDTO.getSd_pttp());
		return payInfo;
	}
	
	/**
	 * 转为预约支付信息
	 * 
	 * @param payInfo
	 * @return
	 */
	public AptPayDTO transToAptPay(PayInfoDTO payInfo){
		AptPayDTO aptPayDTO = new AptPayDTO();
		aptPayDTO.setPayinfo(ScAppUtils.doArray2List(payInfo));
		aptPayDTO.setAmt(payInfo.getAmt());
		aptPayDTO.setAmt_st(payInfo.getAmt_st());
		aptPayDTO.setAmt_hp(payInfo.getAmt_hp());
		aptPayDTO.setAmt_pat(payInfo.getAmt_pat());
		aptPayDTO.setRelpay(payInfo.getRelpay());
		aptPayDTO.setChange(payInfo.getChange());
		aptPayDTO.setPaystyle(payInfo.getPaystyle());
		aptPayDTO.setNo_bank(payInfo.getNo_bank());
		aptPayDTO.setRemark(payInfo.getRemark());
		aptPayDTO.setFg_print(payInfo.getFg_print());
		aptPayDTO.setFg_newprice(payInfo.getFg_newprice());
		aptPayDTO.setSd_pttp(payInfo.getSd_pttp());
		return aptPayDTO;
	}
}
