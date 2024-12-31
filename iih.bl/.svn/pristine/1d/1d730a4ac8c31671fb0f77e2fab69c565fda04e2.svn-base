package iih.bl.cg.s;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import iih.bl.cg.bp.ippre.TrunIpPreToIpBp;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.i.IBlCgAccountPackService;
import iih.bl.cg.s.cglogic.pkgbp.BlKeepAccountForIpFlowPackBP;
import iih.bl.cg.s.cglogic.pkgbp.BlRefundAccountForIpFlowPackBP;

/**
 * 费用记账包装服务
 * @author ly 2019/03/14
 *
 */
public class BlCgAccountPackServiceImpl implements IBlCgAccountPackService{

	/**
	 * 住院流程记账包装
	 * 含住院及留观
	 * @param accDtos 待记账数据
	 * @param accSetDto 记账配置
	 * @return 记账结果
	 * @throws BizException
	 * @author ly 2019/03/14
	 */
	@Override
	public BlCgAccountRltDTO keepAccountForIpFlow(BlCgAccountDTO[] accDtos, BlCgAccountSetDTO accSetDto) throws BizException {
		BlKeepAccountForIpFlowPackBP bp = new BlKeepAccountForIpFlowPackBP();
		return bp.exec(accDtos, accSetDto);
	}

	/**
	 * 住院流程退记账包装
	 * 含住院及留观
	 * @param refundDtos 退记账数据
	 * @param accSetDto 退记账配置
	 * @return 退记账结果
	 * @throws BizException
	 * @author ly 2019/03/14
	 */
	@Override
	public BlCgAccountRltDTO refundAccountForIpFlow(BlCgRefundAccountDTO[] refundDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException {
		BlRefundAccountForIpFlowPackBP bp = new BlRefundAccountForIpFlowPackBP();
		return bp.exec(refundDtos, accSetDto);
	}
	
	/**
	 * 预住院转住院后的费用处理
	 * 
	 * 【使用场景】：
	 * 		预住院转住院。 
	 * 【业务逻辑】：
	 * 		（1）对预住院产生的记账明细进行全红冲（产生的红冲数据code_entp同原始记录） 
	 * 		（2）红冲后，需要产生新的记账明细，其中：
	 * 			1）code_entp: 10（住院就诊类型编码） 
	 * 			2）id_entp: 住院就诊类型ID
	 * 			3）dt_cg：根据参数“BLCG0039”的配置来决定， 若配置为（1：记账时间为当前时间），则dt_cg为：入参传入的预住院转住院时间；
	 * 		若配置为（2：记账时间为原始时间）, 则dt_cg为：原始记账时间。
	 * 			4）dt_srv：同dt_cg 
	 * 			5）note: 预住院转住院费用
	 * 			6）fg_selfpay：若BLCG0037配置为“3”，则需要将fg_selfpay设置为‘Y’。
	 * 		（3）对每条转的记账均需要：存入预住院费用转出日志 bl_cg_ippre_log，参见数据表中对各字段描述。
	 * @param id_ent 就诊ID
	 * @param dtIpPreToIp 预住院转住院时间
	 * @return 布尔型 Y: 转入成功 N：转入失败 
	 * @throws BizException
	 * @author xb 2020/02/13
	 */
	@Override
	public FBoolean trunIpPreToIp(String id_ent, FDateTime dtIpPreToIp) throws BizException{
		TrunIpPreToIpBp bp = new TrunIpPreToIpBp();
		return bp.exec(id_ent, dtIpPreToIp); 
	}
}
