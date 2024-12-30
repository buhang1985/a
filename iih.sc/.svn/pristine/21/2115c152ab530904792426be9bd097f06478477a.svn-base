package iih.sc.sch.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.MtSchDetailDTO;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksCudService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 加号BP
 * 
 * @author yankan
 *
 */
public class AddTicketBP {
	/**
	 * 号源加号
	 * 
	 * @param schId 排班id
	 * @param amount 加号个数
	 * @param addEnum 加号类型, 0：正常号；1：加号；2：补号
	 * @param polCn 号源池
	 * @param srvslot 单次服务时长
	 * @param sd_sctp 排班类型
	 * @param sd_tickmd 票号模式
	 * @param t_e_acpt 诊疗结束时间
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO[] addTick(String schId, int amount, Integer addEnum, Integer polCn,String scchlId, MtSchDetailDTO schDetailDTO) throws BizException {
		this.validate(schId, amount, addEnum, polCn);

		//获取排班
		SchEP schEP = new SchEP();
		ScSchDO schDO = schEP.getById(schId);
		if (schDO == null) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		}

		if (amount > 0) {
			return this.addTicket(schDO, amount, ScContextUtils.getPsnId(), addEnum, polCn,scchlId,schDetailDTO);
		} else {
			amount = Math.abs(amount);
			return this.subTicket(schDO, amount, ScContextUtils.getPsnId(), addEnum, polCn);
		}
	}
	
	/**
	 * 加号
	 * 
	 * @param schId 排班ID
	 * @param addNum 加号数量
	 * @param oprId 操作员id
	 * @param addEnum 加号状态 0：正常号；1：加号；2：补号
	 * @param isReg 是挂号，否则是预约
	 * @param polCn号源池
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO[] addTicket(ScSchDO schDO, int addNum, String oprId, Integer addEnum, Integer polCn,String scchlId, MtSchDetailDTO schDetailDTO)
			throws BizException {
		//1.门诊排班加号验证是否达到最大加号数
		this.validateOpMaxAddNum(schDO, addNum, addEnum);
		
		GetScplanBySchBp bySchBp = new GetScplanBySchBp();
		ScPlanDO planDO = bySchBp.exec(schDO);
		if (planDO == null)
			throw new BizException(IScMsgConst.SC_SCH_SCPLAN_ISEMPY);
		//2.排班号源处理
		SchEP schBP = new SchEP();
		//3.号段处理
			TicksEP ticksBP = new TicksEP();
		//4.号位处理
		TickEP tickBP = new TickEP();
		if(schDetailDTO != null && IScDictCodeConst.SD_SCTP_MT.equals(schDetailDTO.getSd_sctp()) && isModifySchEndTime(schDetailDTO)){
			schBP.addTicket(schDO, addNum, addEnum, polCn,schDetailDTO.getT_e_acpt());
			if (IScDictCodeConst.SD_TICKMD_TICKS.equals(planDO.getSd_tickmd())) {// //医技排班加号号段模式需要判断是否增加新号段
				ScSchTicksDO ticks = ticksBP.addTicket(schDO.getId_sch(), oprId, addNum, addEnum,schDetailDTO);
				return tickBP.addTicketWithPolcn(schDO.getId_sch(), oprId, addNum, addEnum, scchlId,polCn,ticks,schDetailDTO);
			}else{
				return tickBP.addTicketWithPolcn(schDO.getId_sch(), oprId, addNum, addEnum, scchlId,polCn,null,schDetailDTO);
			}
		}else{
			schBP.addTicket(schDO, addNum, addEnum, polCn);
			if (IScDictCodeConst.SD_TICKMD_TICKS.equals(planDO.getSd_tickmd())) {//号段模式
			ticksBP.addTicket(schDO.getId_sch(), oprId, addNum, addEnum);
		}
		return tickBP.addTicketWithPolcn(schDO.getId_sch(), oprId, addNum, addEnum, scchlId,polCn);
	}
	}

	/**
	 * 减号
	 * 
	 * @param schDO 排班DO
	 * @param addNum 加号数量
	 * @param oprId 操作员id
	 * @param addEnum 加号状态 0：正常号；1：加号；2：补号
	 * @param polCn号源池
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO[] subTicket(ScSchDO schDO, int addNum, String oprId, Integer addEnum, Integer polCn)
			throws BizException {
		// 1、排班号源处理
		SchEP schBP = new SchEP();
		schBP.subTicket(schDO, addNum, addEnum, polCn);

		// 2、号位处理
		TickEP tickBP = new TickEP();
		ScSchTickDO[] tickDOArray = tickBP.subTicket(schDO.getId_sch(), oprId, addNum);

		// 3、号段处理
		if (!ArrayUtil.isEmpty(tickDOArray)) {
			Map<String, ScSchTicksDO> ticksDOMap = new HashMap<String, ScSchTicksDO>();
			TicksEP ticksBP = new TicksEP();
			for (ScSchTickDO tickDO : tickDOArray) {
				if (!StringUtil.isEmpty(tickDO.getId_ticks())) {
					ScSchTicksDO ticksDO = ticksDOMap.get(tickDO.getId_ticks());
					if (ticksDO == null) {
						ticksDO = ticksBP.getTicksById(tickDO.getId_ticks());
						if (ticksDO == null) {
							continue;
						}
						ticksDO.setStatus(DOStatus.UPDATED);
						ticksDOMap.put(tickDO.getId_ticks(), ticksDO);
					}
					ticksDO.setQuecn(ticksDO.getQuecn() - 1);// 总数减1
					FBoolean fg_used = new FBoolean(ticksDO.getQuecn_used() >= ticksDO.getQuecn());// 是否已经用完
					ticksDO.setFg_used(fg_used);
					ticksDO.setQuecn_appt(ticksDO.getQuecn_appt() - 1);
				}
			}
			ScSchTicksDO[] ticksDOArray = ticksDOMap.values().toArray(new ScSchTicksDO[0]);
			IScticksCudService tksCudService = ServiceFinder.find(IScticksCudService.class);
			tksCudService.save(ticksDOArray);
		}

		return tickDOArray;
	}
	/**
	 * 验证参数
	 * @param schId 排班id
	 * @param amount 加号个数
	 * @param addEnum 加号类型
	 * @param polCn号源池
	 * @return
	 * @throws BizException
	 */
	private void validate(String schId, int amount, Integer addEnum, Integer polCn) throws BizException{
		ScValidator.validateParam("加号数量", amount);
		ScValidator.validateParam("号源池polCn", polCn);
		ScValidator.validateParam("schId", schId);
	}
	/**
	 * 门诊排班加号验证是否达到最大加号数
	 * 
	 * @param schDO
	 * @throws BizException 
	 */
	private void validateOpMaxAddNum(ScSchDO schDO, int addNum, Integer addEnum) throws BizException{
		if(!IScDictCodeConst.SD_SCTP_OP.equals(schDO.getSd_sctp()))
			return;
		if(!EuAddTickMod.JH.equals(addEnum))
			return;
		int addquecn = schDO.getAddquecn()==null ? 0 : schDO.getAddquecn().intValue();
		int maxAddNum = schDO.getMax_num_add()==null ? 0 : schDO.getMax_num_add().intValue();
		if((addquecn + addNum) > maxAddNum)
			throw new BizException(IScMsgConst.ERROR_SCH_MAX_FOR_ADD);
	}
	
	/**
	 * 是否需要修改排班的诊疗结束时间
	 * @param schDetailDTO
	 * @return
	 */
	private boolean isModifySchEndTime(MtSchDetailDTO schDetailDTO){
		if(schDetailDTO == null || !IScDictCodeConst.SD_SCTP_MT.equals(schDetailDTO.getSd_sctp())){
			return false;
		}
		if(schDetailDTO.getT_e_acpt().compareTo(schDetailDTO.getFix_t_e_acpt()) == 0){
			return false;
		}
 		return true;
	}
}
