package iih.bl.itf.std.bp.balacc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.bl.itf.dto.blthirdreconcilldto.d.BlThirdOrderDTO;
import iih.bl.itf.dto.blthirdreconcilldto.d.BlThirdReconCillDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.d.TransStateEnum;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询订单数据
 * 
 * @author zhangxin
 * @date 2019年4月16日
 */
public class CheckOrderStausBP {
	public BlThirdReconCillDTO[] exec(BlThirdOrderDTO[] ordDOs, String begin_date, String end_date) throws BizException {
		if (ArrayUtils.isEmpty(ordDOs) || StringUtils.isEmpty(begin_date) || StringUtils.isEmpty(end_date)) {
			throw new BizException("费用查询订单数据传入参数不能为空");
		}
		DAFacade dafacade1 = new DAFacade();
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("  select rcd.order_no, ");
		sqlb.append("  rcd.eu_direct, ");
		sqlb.append("  rcd.amt, ");
		sqlb.append(" rcd.eu_status,");
		sqlb.append("   pat.name      Pat_name, ");
		sqlb.append("  doc.name      Emp_name ");
		sqlb.append("   from bl_trd_trans_rcd rcd ");
		sqlb.append("  inner join pi_pat pat on pat.id_pat = rcd.id_pat ");
		sqlb.append("  inner join bd_psndoc doc on doc.id_psndoc = rcd.id_emp_oper ");
		sqlb.append(" where rcd.dt_oper between ? and ?  ");
		SqlParam sqlp1 = new SqlParam();
		sqlp1.addParam(begin_date);
		sqlp1.addParam(end_date);
		// 查原始交易记录表数据
		@SuppressWarnings("unchecked")
		List<BlThirdTransRcdDO> blPrepaySrcpmOepDOLst = (List<BlThirdTransRcdDO>) dafacade1.execQuery(sqlb.toString(),
				sqlp1, new BeanListHandler(BlThirdTransRcdDO.class));

		if (ListUtil.isEmpty(blPrepaySrcpmOepDOLst)) {
			throw new BizException("费用查询订单数据无第三方支付费用数据");
		}

		List<BlThirdReconCillDTO> reconcill = new ArrayList<BlThirdReconCillDTO>();
		for (BlThirdOrderDTO ord : ordDOs) {
			for (BlThirdTransRcdDO rcdDo : blPrepaySrcpmOepDOLst) {
				// 如果订单号相等
				if (ord.getOrd_no().equals(rcdDo.getOrder_no())) {
					BlThirdReconCillDTO reconDto = new BlThirdReconCillDTO();
					// 如果是收费
					if (rcdDo.getEu_direct().equals((int) PayDirectEnum.CHARGE)) {
						// 如果是第三方交易成功
						if (rcdDo.getEu_status().equals((int) TransStateEnum.TRDSUCCESS)) {

							reconDto = this.compDate(rcdDo, "IIH支付-交易单边", null);
							reconcill.add(reconDto);
						} else if (rcdDo.getEu_status().equals((int) TransStateEnum.IIHSUCCESS)) {
							if (!rcdDo.getAmt().equals(ord.getAmount())) {
								FDouble sub = rcdDo.getAmt().sub(ord.getAmount());
								reconDto = this.compDate(rcdDo, "IIH支付-交易差额", sub.toString());
								reconcill.add(reconDto);
							}

						}
						
					//如果是退费
					}else if (rcdDo.getEu_direct().equals((int) PayDirectEnum.CHANGE)){
						//如果是第三方交易失败
						if (rcdDo.getEu_status().equals((int) TransStateEnum.UNFAIL)) {

							reconDto = this.compDate(rcdDo, "IIH退款-交易单边", null);
							reconcill.add(reconDto);
						} else if (rcdDo.getEu_status().equals((int) TransStateEnum.TRDSUCCESS)) {
							FDouble bkamt = ord.getAmount().sub(ord.getAmount_bk());
							if (!rcdDo.getAmt().equals(bkamt)) {
								FDouble sub = rcdDo.getAmt().sub(bkamt);
								reconDto = this.compDate(rcdDo, "IIH退款-交易差额", sub.toString());
								reconcill.add(reconDto);
							}

						}
						
					}
				
					break;
				}
			}
		}
		return reconcill.toArray(new BlThirdReconCillDTO[] {});

	}

	private BlThirdReconCillDTO compDate(BlThirdTransRcdDO rcdDo, String errReason, String bk_amt) {
		BlThirdReconCillDTO reconDto = new BlThirdReconCillDTO();
		if (StringUtils.isEmpty(errReason)) {
			return reconDto;
		} // 异常种类
		reconDto.setEx_type(errReason);
		// 金额
		reconDto.setAmount(rcdDo.getAmt().toString());
		// 订单号
		reconDto.setOrd_no(rcdDo.getOrder_no());
		// 患者id
		reconDto.setPay_ps(rcdDo.getPat_name());
		// 操作员
		reconDto.setRecon_ps(rcdDo.getEmp_name());
		// 差额
		if (!StringUtils.isEmpty(bk_amt)) {
			reconDto.setAmount_ex(bk_amt);
		}
		return reconDto;
		// TODO Auto-generated method stub

	}
}
