package iih.pi.acc.account.s.bp;

import java.util.List;

import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 取得患者相关金额信息处理
 * @author ly
 *
 */
public class GetPatRelAmountInfoBP {

	/**
	 * 取得患者相关金额信息处理
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PatRelAmountInfoDTO[] exec(String... patIds) throws BizException{
		
		if(ArrayUtil.isEmpty(patIds))
			return null;
		
		String inPart = "(";
		for (String item : patIds) {
			if(StringUtil.isEmpty(item)){
				throw new BizException("参数患者id不能为空");
			}
			
			inPart += "'"+item+"',";
		}
		
		inPart = inPart.substring(0, inPart.length() - 1);
		inPart += ")";
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(this.getBaseSql());
		sqlSb.append("where pat.id_pat in ");
		sqlSb.append(inPart);
		
		List<PatRelAmountInfoDTO> result = (List<PatRelAmountInfoDTO>) new DAFacade()
				.execQuery(sqlSb.toString(), new BeanListHandler(PatRelAmountInfoDTO.class));
		
		if(ListUtil.isEmpty(result)){
			throw new BizException("患者账户不存在", 1);
		}
		
		//检测输入的患者id是否取到对应的账户信息
		for (String patId : patIds) {
			
			boolean contain = false;
			for (PatRelAmountInfoDTO info : result) {
				if(patId.equals(info.getId_pat())){
					contain = true;
					break;
				}
			}
			
			if(!contain){
				throw new BizException("患者账户不存在 患者id:" + patId, 1);
			}
		}
		
		return result.toArray(new PatRelAmountInfoDTO[result.size()]);	
	}
	
	/**
	 * 基础sql
	 * @return
	 */
	private String getBaseSql(){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select pat.id_pat, ");
		sqlSb.append("acc.prepay, ");
		sqlSb.append("nvl(acc.cred,0) + nvl(cret.encred,0) as cred_total, ");
		sqlSb.append("acc.acc_lock, ");
		sqlSb.append("nvl(acc.prepay,0) + nvl(acc.cred,0) + nvl(cret.patcred,0) - nvl(acc.acc_lock,0) as money_canuse, ");
		sqlSb.append("nvl(acc.prepay_emgstay, 0) as prepay_emgstay, ");
		sqlSb.append("nvl(acc.cred_emgstay, 0) + nvl(cret.patcred, 0) as cred_total_emgstay, ");
		sqlSb.append("nvl(acc.acc_lock_emgstay, 0) as acc_lock_emgstay,  ");
		sqlSb.append("nvl(acc.prepay_emgstay, 0) + nvl(acc.cred_emgstay, 0) + nvl(cret.patcred, 0) - nvl(acc.acc_lock_emgstay, 0) as money_canuse_emgstay, ");
		sqlSb.append("case acc.sd_accsta when '0' then 'N' when '1' then 'Y' else 'N' end as fg_acc_freeze ");
		sqlSb.append("from pi_pat pat ");
		sqlSb.append("inner join pi_pat_acc acc ");
		sqlSb.append("on pat.id_pat = acc.id_pat ");
		sqlSb.append("and acc.fg_active = 'Y' ");
		sqlSb.append("left join pi_pat_cret cret ");
		sqlSb.append("on pat.id_patcrettp = cret.id_patcret ");
		return sqlSb.toString();
	}
}
