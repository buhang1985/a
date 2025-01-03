package iih.ci.ord.s.bp.ems.hp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.mi.basic.MiErrorLevel;
import iih.ci.mi.common.utils.MiEnContextUtil;
import iih.ci.mi.ord.i.ICiMiOrdRService;
import iih.ci.mi.ord.i.meta.OrdRuleRstDTO;
import iih.ci.mi.ord.i.meta.OrdSpecillRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.sdk.utils.StringUtils;
import iih.mi.itf2.util.MiParamUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱签署医保校验
 * @author HUMS
 *
 */
public class OrdHpSignInfoBP {
   
    
	private ICiMiOrdRService ciMiOrdRService ; 
	public OrdHpSignInfoBP(){
		ciMiOrdRService = ServiceFinder.find(ICiMiOrdRService.class);
	}
	
	/**
	 * 医嘱签署医保信息校验
	 * @param ctx
	 * @param ordAggs
	 * @return
	 * @throws BizException
	 */
	public OrderRstDTO checkOrdHpInfoSign(CiEnContextDTO ctx, OrderOperateDTO orderOperate, CiorderAggDO[] ordAggs) throws BizException{
		Long start = System.currentTimeMillis();
		
		FMap2 extension = orderOperate.getExtension();
		
		OrderRstDTO orderRst = this.checkHpJudgeOrds(ctx, ordAggs);
		if(orderRst != null){
			return orderRst;
		}
		
		orderRst = this.checkWaitJudgeOrds(ctx, ordAggs);
		if(orderRst != null){
			return orderRst;
		}
		
		if (extension==null || extension != null && !extension.containsKey("SpecilDrugs_Checked")) {
			orderRst = this.updateSpecillFlag(ctx, ordAggs);
		}
		
		if(orderRst != null){
			return orderRst;
		}
		
		// 医保规则校验
		if (extension==null || extension != null && !extension.containsKey("MiRuleVerify")) {
			orderRst = this.getMiRuleVerifyRst(ctx, ordAggs);
		}
		if(orderRst != null){
			return orderRst;
		}
		
		Long end = System.currentTimeMillis();
		OrdBizLogger.info(ctx, "签署"+ordAggs.length+"条医嘱调用医保校验逻辑耗时："+(end-start)+"！");
		
		
		return orderRst;
	} 
	
	/**
	 * 签署时需要进行医保共享校验的医保医嘱
	 * @param ctx
	 * @param ordAggs
	 * @return
	 * @throws BizException
	 */
	private OrderRstDTO checkHpJudgeOrds(CiEnContextDTO ctx, CiorderAggDO[] ordAggs) throws BizException{
		
		if(CiOrdUtils.isEmpty(ordAggs)) return null;
		
		if(!ciMiOrdRService.isEnabledMedicalShareVerify(ctx)){
			return null;
		}
		
		FArrayList list = new FArrayList();
		for(CiorderAggDO agg : ordAggs){
			
			CiOrderDO ord = agg.getParentDO();
			//只有医保的进行共享校验
			if (HpJudgeRstEnum.HP.equals(ord.getEu_orhp())) {
				list.append(ord.getId_or());
			}
		}
		
		if(list.size() ==0){
			return null;
		}
		
		OrdBizLogger.info(null, "未进行医保共享校验判断，不允许进行签署！");
		return this.getOrderRstDTO("needHpSharingCheckIdOrs", list);
		
	}
	
	/**
	 * 获取需要医保适应症判断的医嘱
	 * @param ctx
	 * @param ordAggs
	 * @return
	 * @throws BizException
	 */
	private OrderRstDTO checkWaitJudgeOrds(CiEnContextDTO ctx, CiorderAggDO[] ordAggs) throws BizException{
		
		if(CiOrdUtils.isEmpty(ordAggs)) return null;
		
		if(!ciMiOrdRService.isEnabledIndicVerify(ctx)){
			return null;
		}
		
		FArrayList list = new FArrayList();
		for(CiorderAggDO agg : ordAggs){
			
			CiOrderDO ord = agg.getParentDO();
			//只要有医保或临床路径未判断，都会打开医嘱审核界面，医嘱审核界面中包含全部内容，所以只要判断其中一个就可以了
			if (HpJudgeRstEnum.WAITING_JUDGE.equals(ord.getEu_orhp())) {
				list.append(ord.getId_or());
			}
		}
		
		if(list.size() ==0){
			return null;
		}
		
		OrdBizLogger.info(null, "未进行医保判断，不允许进行签署！");
		return this.getOrderRstDTO("willCheckIdOrs", list);
		
	}
	
	/**
	 * 获取医保规则校验结果
	 * @param ctx
	 * @param ordAggs
	 * @return
	 * @throws BizException
	 */
	private OrderRstDTO getMiRuleVerifyRst(CiEnContextDTO ctx, CiorderAggDO[] ordAggs) throws BizException{
		
		GetMiRuleVerifyRstBP bp = new GetMiRuleVerifyRstBP();
		List<OrdRuleRstDTO>  ordRuleRstList = bp.getMiRuleRst(ctx, ordAggs);
		
		String msgType = null;
		StringBuffer msgBuffer = new StringBuffer();
		for(OrdRuleRstDTO ordRuleRst : ordRuleRstList){
			
			if(MiErrorLevel.ERROR.equals(ordRuleRst.getErrorlevel())){
				msgType = "Stop^";
			}else if(MiErrorLevel.WARN.equals(ordRuleRst.getErrorlevel())){
				msgType = "Warning^";
			}
			
			if(StringUtils.isNotEmpty(ordRuleRst.getMsg())){
				msgBuffer.append(ordRuleRst.getMsg()).append(System.lineSeparator());	
			}
			
		}
		
		if(msgBuffer.length() ==0){
			return null;
		}
		
		if(StringUtils.isNotEmpty(msgType)){
			msgBuffer.insert(0, msgType);
		}
		
		return this.getOrderRstDTO("MiRuleVerify", msgBuffer.toString());
	}
	
	/**
	 * 判断非特殊病项目是否符合特殊病，符合的更新为特殊病
	 * @param ctx
	 * @param ordAggs
	 * @return
	 * @throws BizException
	 */
	private OrderRstDTO updateSpecillFlag(CiEnContextDTO ctx,CiorderAggDO[] ordAggs) throws BizException{
			
		// 非医保或患者非特病返回false
		if (!MiEnContextUtil.IsHpSpecillPat(ctx)){ 
			return null;
		}
			
		// 急诊不校验特殊病
		if(ctx.getCode_entp().startsWith(IBdFcDictCodeConst.SD_CODE_ENTP_ET)){
			return null;
		}
		
		StringBuffer msgBuffer = new StringBuffer(); 
		
		GetMiSpecillVerifyRstBP bp = new GetMiSpecillVerifyRstBP();
		List<OrdSpecillRstDTO>  ordSpecillRsts = bp.getMiSpecillRsts(ctx, ordAggs);
		
		if(ordSpecillRsts ==null || ordSpecillRsts.size() ==0){
			return null;
		} 

		// 构造特殊病判断结果map集合
		Map<String, OrdSrvSpecillRstDTO> ordSrvSpecillMap = new HashMap<String, OrdSrvSpecillRstDTO>();
		for(OrdSpecillRstDTO ordSpecillRst : ordSpecillRsts){
			
			List<OrdSrvSpecillRstDTO> ordSrvSpecillList =  ordSpecillRst.getOrdSrvSpecillRstList();
			
			for(OrdSrvSpecillRstDTO ordSrvSpecill : ordSrvSpecillList){
				if(!ordSrvSpecillMap.containsKey(ordSrvSpecill.getId_orsrv())){
					ordSrvSpecillMap.put(ordSrvSpecill.getId_orsrv(), ordSrvSpecill);
				}
			}
		}
		
		// 根据特殊病判断结果赋值
		List<OrdSrvDO> ordSrvList = new ArrayList<OrdSrvDO>();
		List<String> idMmList= new ArrayList<String>();
		for(CiorderAggDO ordAgg : ordAggs){
			OrdSrvDO[]  ordSrvs = ordAgg.getOrdSrvDO();

			for(OrdSrvDO ordSrv : ordSrvs){
				
				OrdSrvSpecillRstDTO ordSrvSpecillRst = ordSrvSpecillMap.get(ordSrv.getId_orsrv());
				if(ordSrvSpecillRst == null){
					continue;
				}
				
				// 先开医嘱，后下诊断，非药品的保存为特殊病标识
				if(!ordSrvSpecillRst.getFg_specill().equals(ordSrv.getFg_specill())){
					ordSrv.setFg_specill(ordSrvSpecillRst.getFg_specill());
					ordSrv.setStatus(DOStatus.UPDATED);
					ordSrvList.add(ordSrv);
				}
				
				// 是特殊病药品，但是没有特殊病诊断，或病种返回提示信息
				if(FBoolean.TRUE.equals(ordSrvSpecillRst.getFg_specdrug()) && !FBoolean.TRUE.equals(ordSrvSpecillRst.getFg_specill())){
					if(FBoolean.TRUE.equals(ordSrv.getFg_mm())){
						if(idMmList.contains(ordSrvSpecillRst.getId_mm())){
							continue;
						}else{
							idMmList.add(ordSrvSpecillRst.getId_mm());	
						}
					}
					msgBuffer.append(ordSrvSpecillRst.getMsg()).append(System.lineSeparator());
				}
			}
		}
		
		if (ordSrvList.size() > 0) {
			CiOrdAppUtils.getICiorderSrvDOCudService() .update(ordSrvList.toArray(new OrdSrvDO[ordSrvList.size()]));
		}
		
		if (msgBuffer.length() > 0) {			
			OrdBizLogger.info(null, "特殊病药品判断 ："+msgBuffer.toString());
			return this.getOrderRstDTO("SpecilDrugs4Sign", msgBuffer.toString());
		}
		
		return null;
	}
	
	
	/**
	 * 获取返回结果
	 * 
	 * @param messageinfo
	 * @return
	 */
	private OrderRstDTO getOrderRstDTO(String messagekey, Object messageinfo) {
		OrderRstDTO rstDTO = new OrderRstDTO();
		FMap2 scene = new FMap2();
		scene.put(messagekey, messageinfo);
		rstDTO.setExtension(scene);
		return rstDTO;
	}
}
