package iih.bl.pay.s.bp.ip;

import iih.bl.pay.dto.d.BlIpRegisKnotsPayDTO;

import java.util.List;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author xy.zhou
 * @date 2018年7月14日
 */
public class GetBlIpRegisKnotsPayDTOBp {
	/**
	 * 
	 * @Title: exec   
	 * @Description: 查询患者历次住院结算后的结转押金 
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlIpRegisKnotsPayDTO[] 
	 * @author: xy.zhou     
	 * @throws
	 */
	public BlIpRegisKnotsPayDTO[] exec(String patId, String entId)throws BizException{
		if (StringUtils.isEmptyWithTrim(patId) || StringUtil.isEmpty(entId)) {
			throw new BizException("查询患者结转押金时，患者id就诊id不能为空！");
		}
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append(" select prepay.id_paypat,prepay.id_ent,prepay.id_pat,entip.code_amr_ip,entip.times_ip,prepay.amt,udi.name,psn.name,"
				+ "prepay.dt_pay,rcpt.code_rep from bl_prepay_pat prepay ");
		sqlStr.append(" left join en_ent_ip entip on prepay.id_ent=entip.id_ent ");
		sqlStr.append(" left join bd_udidoc udi on prepay.id_pm=udi.id_udidoc ");
		sqlStr.append(" left join bd_psndoc psn on prepay.id_emp_pay=psn.id_psndoc ");
		sqlStr.append(" left join bl_prepay_pat_rcpt rcpt on prepay.id_paypat=rcpt.id_paypat ");
		sqlStr.append(" where  prepay.id_pat=? ");
		sqlStr.append(" and prepay.id_ent <> ? ");
		sqlStr.append(" and prepay.code_enttp = '10' ");
		SqlParam param = new SqlParam();  
		param.addParam(patId);
		param.addParam(entId);
		sqlStr.append(" and prepay.fg_rep_return='N' and  prepay.eu_direct=1 and nvl(prepay.fg_canc,'N') ='N'  ");
		DAFacade df = new DAFacade();
		List<BlIpRegisKnotsPayDTO> srvList = (List<BlIpRegisKnotsPayDTO>)df.execQuery(sqlStr.toString(), param, new BeanListHandler(BlIpRegisKnotsPayDTO.class));
		return srvList.toArray(new BlIpRegisKnotsPayDTO[]{});
	}
}
