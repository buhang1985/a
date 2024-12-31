package iih.bl.cg.s;

import iih.bl.cg.bp.ip.GetIpCgListByInccaItmBP;
import iih.bl.cg.bp.ip.GetIpCgListBySrvSumBP;
import iih.bl.cg.bp.ip.GetIpCgSrvSumListBP;
import iih.bl.cg.bp.ip.GetIpInccaItmListBP;
import iih.bl.cg.bp.ip.GetIpInccaItmSumBP;
import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.cg.dto.d.BlIpCgSrvSumDTO;
import iih.bl.cg.dto.d.DayIpCgInfoDTO;
import iih.bl.cg.dto.mb.ipfeebill.d.BlCgIpFeeBillCondDTO;
import iih.bl.cg.dto.mb.ipfeebill.d.BlCgIpFeeBillDTO;
import iih.bl.cg.i.IBlCgForMbhService;
import iih.bl.cg.s.provide.mbh.BlIpGetIpFeeBillForMbhBP;
import iih.bl.cg.s.provide.mbh.GetIpDayAmtCgsBp;
import iih.bl.cg.s.provide.mbh.GetIpDayCgDTOsBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 费用记帐域对移动医疗提供服务
 * @author ly 2018/08/06
 *
 */
public class BlCgForMbhServiceImpl implements IBlCgForMbhService {

	/**
	 * 查询住院患者费用清单
	 * @param cond
	 * @return
	 * @throws BizException
	 * @author ly 2018/08/06
	 */
	@Override
	public BlCgIpFeeBillDTO[] getIpFeeBill(BlCgIpFeeBillCondDTO cond) throws BizException {
		BlIpGetIpFeeBillForMbhBP bp = new BlIpGetIpFeeBillForMbhBP();
		return bp.exec(cond);
	}
	
	/**
	 * 供移动护理，查询收费项目汇总
	 * @author liwq
	 * @since 2018年1月24日16:39:50
	 */
	public BlIpCgSrvSumDTO[] getSrvCgSumDTO(String entId) throws BizException {
		GetIpCgSrvSumListBP bp = new GetIpCgSrvSumListBP();
		return bp.exec(entId, null);
	}
	
	/**
	 * 供移动护理，查询收费项目记账明细
	 * @author liwq
	 * @since 2018年1月24日16:39:50
	 */
	public BlIpCgDTO[] getSrvCgDetailsDTO(String entId, String srvId) throws BizException {
		GetIpCgListBySrvSumBP bp = new GetIpCgListBySrvSumBP();
		BlIpCgSrvSumDTO dto = new BlIpCgSrvSumDTO();
		dto.setId_srv(srvId);
		return bp.exec(entId, dto, null);
	}
	
	/**
	 * 供移动护理，获取住院一日清单费用
	 * @author liwq
	 * @param id_ent 就诊id
	 * @param dt_cg  日期格式：yyyy-MM-dd
	 * @throws Exception 
	 * @since 2018年3月7日15:01:58
	 */
	public DayIpCgInfoDTO[] getIpDayCgDTOs(String id_ent, FDate dt_cg) throws Exception {
		GetIpDayCgDTOsBp bp = new GetIpDayCgDTOsBp();
		return bp.exec(id_ent, dt_cg);
	}
	
	/**
	 * 供移动护理，获取住院每日记账金额之和
	 * @author liwq
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @since 2018年4月1日15:04:06
	 */
	public DayIpCgInfoDTO[] getIpDayAmtCgs(String id_ent)  throws BizException {
		GetIpDayAmtCgsBp bp = new GetIpDayAmtCgsBp();
		return bp.exec(id_ent);
	}
	
	/**
	 * 供移动护理，获取患者住院账单项汇总信息
	 * @param entId 就诊id
	 * @param fgSt 是否结算
	 * @param stId 结算id
	 * @return 账单项集合
	 * @throws BizException
	 * @author liwq
	 * @since 2018年4月1日15:26:05
	 */
	public BlInccaItmDTO[] getIpIncItmInfo(String entId,FBoolean fgSt,String stId) throws BizException {
		GetIpInccaItmSumBP bp = new GetIpInccaItmSumBP();
		return bp.exec(entId, fgSt, stId);
	}
	
	/**
	 * 供移动护理，获取患者住院账单某项的每日记账金额
	 * @param entId 就诊id
	 * @param inccaItmCode 账单项编码
	 * @return 账单项集合
	 * @throws BizException
	 * @author liwq
	 * @since 2018年4月1日15:32:10
	 */	
	public BlInccaItmDTO[] getIpIncItmDayAmts(String entId,String inccaItmCode) throws BizException {
		GetIpInccaItmListBP getBillItmListBP = new GetIpInccaItmListBP();
		return getBillItmListBP.exec(entId,inccaItmCode);
	}
	
	/**
	 * 供移动护理，获取患者某账单项某日记账信息 
	 * @param entId 就诊id
	 * @param inccaItmCode 账单项编码
	 * @param cgDate 记账日期 格式：yyyy-MM-dd
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2018年4月1日15:32:10
	 */
	public BlIpCgDTO[] getIpCgListByInccaItm(String entId,String inccaItmCode,FDate cgDate) throws BizException {
		GetIpCgListByInccaItmBP bp = new GetIpCgListByInccaItmBP();
		BlInccaItmDTO itmDto = new BlInccaItmDTO();
		itmDto.setCode_inccaitm(inccaItmCode);
		itmDto.setDt_cg(cgDate);
		return bp.exec(entId, itmDto);
	}
}
