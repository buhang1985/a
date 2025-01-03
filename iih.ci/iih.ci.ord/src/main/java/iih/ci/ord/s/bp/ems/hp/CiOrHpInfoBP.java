package iih.ci.ord.s.bp.ems.hp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.ci.mi.basic.MiErrorLevel;
import iih.ci.mi.ord.i.meta.OrdIndicRstDTO;
import iih.ci.mi.ord.i.meta.OrdRuleRstDTO;
import iih.ci.mi.ord.i.meta.OrdSpecillRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvIndicRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordext.d.HpJudgeEnum;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医保信息
 * @author HUMS
 *
 */
public class CiOrHpInfoBP {
	
	public CiOrHpInfoBP(){
	}

	public CiorderAggDO exec(CiEnContextDTO ctx, CiOrAggAndRelDatum ordData) throws BizException{
		
		CiorderAggDO ordAgg = ordData.getOraggdo();
		CiOrderDO order = ordAgg.getParentDO();
		
		GetIndicVerifyRstBP bp = new GetIndicVerifyRstBP();
		OrdIndicRstDTO ordIndicRst = bp.getIndicRst(ctx,ordData);
		if(ordIndicRst != null ){
			
			List<OrdSrvIndicRstDTO> ordSrvIndicList = ordIndicRst.getOrdSrvIndicRstList();
			
			for(OrdSrvDO ordSrv : ordAgg.getOrdSrvDO()){
				
				for(OrdSrvIndicRstDTO ordSrvIndic : ordSrvIndicList){
					if(ordSrv.getId_srv().equals(ordSrvIndic.getId_srv())){
						ordSrv.setEu_hpjudge(ordSrvIndic.getEu_hpjudge());
						ordSrv.setEu_orsrvhp(ordSrvIndic.getEu_orsrvhp());
						break;
					}
				}
			}
		}
		
		this.setOrdHpInfo(ctx, ordAgg);
		
		// 设置特殊病表
		this.setFgSpecill(ctx, ordData);
		// 服务项目中如果包含医保的，进行医保规则校验，医保规则校验只校验明细项时医保的。非医保不需要校验
		boolean isContainHpOrdSrv = false;		
		for(OrdSrvDO ordSrv : ordAgg.getOrdSrvDO()){
			if(HpJudgeRstEnum.HP.equals(ordSrv.getEu_orsrvhp())){
				isContainHpOrdSrv = true;
			}
		}
		
		// 医保的需要规则判断
		if(isContainHpOrdSrv){
			
			GetMiRuleVerifyRstBP ruleVerify  = new GetMiRuleVerifyRstBP();
			OrdRuleRstDTO ordRuleRst = ruleVerify.getMiRuleRst(ctx, ordData);
			StringBuffer msgBuffer = new StringBuffer();
			
			if(MiErrorLevel.ERROR.equals(ordRuleRst.getErrorlevel())){
				msgBuffer.append("Stop^");
			}else if(MiErrorLevel.WARN.equals(ordRuleRst.getErrorlevel())){
				msgBuffer.append("Warning^");
			}
			msgBuffer.append(ordRuleRst.getMsg());		
			
		
			order.setMdicalinfo(msgBuffer.toString());
			
			if(ordRuleRst.getMsg().length() >0){
				
				// 草药明细个数
				int herbsCnt = 0;
				
				if(order.getSd_srvtp().startsWith(IBdSrvTpDictCodeConst.SD_SRVTP_HERBDRUG)){
					for(OrdSrvDO ordSrv : ordAgg.getOrdSrvDO()){
						if(ordSrv.getSd_srvtp().startsWith(IBdSrvTpDictCodeConst.SD_SRVTP_HERBDRUG)){
							herbsCnt++;
						}
					}	
				}
				
				// 草药单方
				if(herbsCnt==1 ){
					
					order.setEu_orhp(HpJudgeRstEnum.SELFPAY);
					for(OrdSrvDO ordSrv : ordAgg.getOrdSrvDO()){
						ordSrv.setEu_orsrvhp(HpJudgeRstEnum.SELFPAY);
					}
				}
			}
		}
		
		// 更新原医保自费标识
		this.updateOrdSrvFgSelfpay(ctx, ordAgg);
		
		return ordAgg;
	}
	
	/**
	 * 设置医保特殊病标识
	 * @throws BizException 
	 */
	public void setFgSpecill(CiEnContextDTO ctx, CiOrAggAndRelDatum ordData) throws BizException{
	
		GetMiSpecillVerifyRstBP bp = new GetMiSpecillVerifyRstBP();
		OrdSpecillRstDTO ordSpecill = bp.getMiSpecillRst(ctx, ordData);
		
		if(ordSpecill == null){
			return ;
		}
		
		OrdSrvDO[] ordSrvs = ordData.getOraggdo().getOrdSrvDO();
		
		List<OrdSrvSpecillRstDTO> ordSrvSpecillList = ordSpecill.getOrdSrvSpecillRstList();
		
		for(OrdSrvDO ordSrv : ordSrvs){
			for(OrdSrvSpecillRstDTO ordSrvSPecill : ordSrvSpecillList){
				if(ordSrv.getId_srv().equals(ordSrvSPecill.getId_srv())){
					ordSrv.setFg_specill(ordSrvSPecill.getFg_specill());
				}
			}
		}
	}
	
	/**
	 * 设置药品医嘱的医保属性
	 * @param ctx
	 * @param ordAgg
	 */
	private void setOrdHpInfo(CiEnContextDTO ctx, CiorderAggDO ordAgg){
		
		CiOrderDO order = ordAgg.getParentDO();
		OrdSrvDO[] ordSrvs = ordAgg.getOrdSrvDO();		
	
		String eu_hpjudge = this.getEu_hpjudge(ctx, ordSrvs);
		String eu_orhp = this.getEu_orhp(ctx, ordSrvs);
		order.setEu_hpjudge(eu_hpjudge);
		order.setEu_orhp(eu_orhp);
	}
	
	/**
	 * 根据服务项目判断医嘱的医保标识
	 * @param ordSrvs
	 * @return
	 */
	private String getEu_orhp(CiEnContextDTO ctx, OrdSrvDO[] ordSrvs) {
			
		// 存在医保项目
		boolean isAllNotJudge = true; 
		// 是否全自费
		boolean isAllSelfpay = true;
				
		for(OrdSrvDO ordSrv : ordSrvs){
			
			if(ordSrv.getStatus() == DOStatus.DELETED){
				continue;
			}
			
			if(HpJudgeRstEnum.DISABLED.equals(ordSrv.getEu_orsrvhp())){
				return HpJudgeRstEnum.DISABLED;
			}
			
			if(HpJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_orsrvhp())){
				return HpJudgeRstEnum.WAITING_JUDGE;				
			}
			
			if(HpJudgeRstEnum.HP.equals(ordSrv.getEu_orsrvhp())){
				return HpJudgeRstEnum.HP;
			}
			
			if(!HpJudgeRstEnum.SELFPAY.equals(ordSrv.getEu_orsrvhp()) && !HpJudgeRstEnum.NOT_JUDGE.equals(ordSrv.getEu_orsrvhp())){
				isAllSelfpay = false;
			}
			
			if(!HpJudgeRstEnum.NOT_JUDGE.equals(ordSrv.getEu_orsrvhp())){
				isAllNotJudge = false;
			}
		}
		
		if(isAllNotJudge){
			return HpJudgeRstEnum.NOT_JUDGE;
		}
		
		if(isAllSelfpay){
			return HpJudgeRstEnum.SELFPAY;
		}else{
			return HpJudgeRstEnum.NOT_JUDGE;
		}
	}

	/**
	 * 设置药品医嘱的医保判断方式
	 * @param ordSrvs
	 * @return
	 */
	private String getEu_hpjudge(CiEnContextDTO ctx, OrdSrvDO[] ordSrvs){
		
		// 是否全自费
		boolean isAllNotJudge = true;
		// 是否存在费用项目
		boolean isExistsBlitem = false;
		
		for(OrdSrvDO ordSrv : ordSrvs){
						
			// 未启用医保判断
			if(HpJudgeEnum.DISABLED.equals(ordSrv.getEu_hpjudge())){
				return HpJudgeEnum.DISABLED;
			}
			
			// 非医保就诊
			if(HpJudgeEnum.NON_MEDICAL.equals(ordSrv.getEu_hpjudge())){
				return HpJudgeEnum.NON_MEDICAL;
			}
			
			isExistsBlitem = true;
			
			if(HpJudgeEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpjudge())){
				return HpJudgeEnum.WAITING_JUDGE;				
			}
			
			if(HpJudgeEnum.DOCTOR_JUDGE.equals(ordSrv.getEu_hpjudge())){
				return HpJudgeEnum.DOCTOR_JUDGE;
			}
			
			if(!HpJudgeEnum.NOT_JUDGE.equals(ordSrv.getEu_hpjudge())){
				isAllNotJudge = false;
			}			
		}
		
		// 不存在费用项目
		if(!isExistsBlitem){
			return HpJudgeEnum.NON_BLITEM;
		}
		
		// 全部不需要判断
		if(isAllNotJudge){
			return HpJudgeEnum.NOT_JUDGE;
		}		
		
		return HpJudgeEnum.SYSTEM_JUDGE;
	}

	/**
	 * 更新原医保自费标识
	 * @param ctx
	 * @param ordAgg
	 * @throws BizException 
	 */
	private void updateOrdSrvFgSelfpay(CiEnContextDTO ctx, CiorderAggDO ordAgg) throws BizException{
		
		CiOrderDO order = ordAgg.getParentDO();
		OrdSrvDO[]ordSrvs = ordAgg.getOrdSrvDO();
		
		for(OrdSrvDO ordSrv : ordSrvs){
			// 未启用医保判断，直接返回
			if(HpJudgeRstEnum.DISABLED.equals(ordSrv.getEu_orsrvhp())){
				return;
			}
		}
				
		order.setFg_orhp(FBoolean.FALSE);
		for(OrdSrvDO ordSrv : ordSrvs){
			
			if(!FBoolean.TRUE.equals(ordSrv.getFg_bl())){
				continue;
			}
			
			if(HpJudgeRstEnum.HP.equals(ordSrv.getEu_orsrvhp())){
				ordSrv.setFg_selfpay(FBoolean.FALSE);
				order.setFg_orhp(FBoolean.TRUE);
			}else{
				ordSrv.setFg_selfpay(FBoolean.TRUE);
			}
		}
	}
}
