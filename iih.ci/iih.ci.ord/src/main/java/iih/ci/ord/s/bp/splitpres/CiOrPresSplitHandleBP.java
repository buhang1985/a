package iih.ci.ord.s.bp.splitpres;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.cfg.CiRuleCfgExecutorBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医嘱分方操作BP
 */
public class CiOrPresSplitHandleBP {
	/**
	 * 临床医嘱分方
	 * @param ciors
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public List<CiOrPresSplitList> exec(CiEnContextDTO ctx, CiOrderDO[] ciors, CiOrSessionDO session) throws BizException {
		//临床医嘱分方时，分方医嘱过滤与处理
		long startTime = System.currentTimeMillis();
		
		ciors = orPresSplitOrFilterHandle(ciors, session);
		if (CiOrdUtils.isEmpty(ciors))
			return null;
		
		long endTime1 = System.currentTimeMillis();
		long time1 = endTime1 - startTime;

		//分方医嘱到临床医嘱分方数据信息列表集合的转换
		List<CiOrPresSplitList> presList = convertCiOr2CiOrPresSplitList(ciors);
		
		long endTime2 = System.currentTimeMillis();
		long time2 = endTime2 - endTime1;
		
		// 重构分方逻辑
		CiRuleCfgExecutorBP executorBP = new CiRuleCfgExecutorBP();
		presList = executorBP.execSplitPres(ctx,presList);
		
//		long endTime3 = System.currentTimeMillis();
//		long time3 = endTime3 - endTime2;

		//生成处方并保存处方
		CiPresDO[] cipres = genPresByOrdPresSplit(presList, session);
		if(!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ctx.getCode_entp())){
		//目前存在一个bug，不能定位问题：门诊药品医嘱签署后，存在ci_or_srv中的处方id_pres为空的情况;因此保存成功后判断是否有为空，有为空直接抛出异常
		List<String> lstIdors = new ArrayList<String>();
			for(CiOrderDO order : ciors){
				lstIdors.add(order.getId_or());
			}
			OrdSrvDO[] ordSrvs = CiOrdAppUtils.getOrSrvQryService().findByAttrValStrings(OrdSrvDO.ID_OR, lstIdors.toArray(new String[0]));
			for(OrdSrvDO ordsrv : ordSrvs){
				//1、是药品，并且处方为空；2、组合计价中的药品不分方； 3、不计费类型为1嘱托不分方
				if(!OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(ordsrv.getEu_sourcemd()) 
						&& !ICiDictCodeConst.SD_NODISPENSE_ENTRUST.equals(ordsrv.getSd_nodispense()) 
						&& ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG) 
						&& FBoolean.FALSE.equals(ordsrv.getFg_self()) 
						&& FBoolean.FALSE.equals(ordsrv.getFg_extdispense())
						&& StringUtils.isEmpty(ordsrv.getId_pres())){
					throw new BizException(ordsrv.getName()+"分方失败，处方id_pres为空，请重新分方");
				}
			}
		}
		//long endTime4 = System.currentTimeMillis();
		//long time4 = endTime4 - endTime3;

		//临床医嘱处方分方后执行域相关处理
		ciOrPresSplitMpHandle(cipres);
		
//		long endTime5 = System.currentTimeMillis();
//		long time5 = endTime5 - endTime4;

//		System.out.println("构造待分方数据：" + time1 + System.lineSeparator()
//		+ "将待分方数据转换为分方规则数据：" + time2 + System.lineSeparator()
//		+ "获取分方规则：" + time3 + System.lineSeparator()
//		+ "保存处方数据：" + time4 + "ms\n"
//		+ "分方结束调用执行域接口" + time5);
		
		//返回
		return presList;
	}
	
	/**
	 * 临床医嘱分方时，分方医嘱过滤与处理
	 * @param ciorder
	 * @param session
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] orPresSplitOrFilterHandle(CiOrderDO[] ciorder, CiOrSessionDO session) throws BizException {
		CiOrPresSplitOrFilterHandleBP bp = new CiOrPresSplitOrFilterHandleBP();
		return bp.exec(ciorder, session);
	}
	
	/**
	 * 分方医嘱到临床医嘱分方数据信息列表集合的转换
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	protected List<CiOrPresSplitList> convertCiOr2CiOrPresSplitList(CiOrderDO[] ciors)throws BizException {
		CiOr2CiOrPresSplitListBP bp=new CiOr2CiOrPresSplitListBP();
		return bp.exec(ciors);
	}
	
	/**
	 * 生成处方并保存
	 * @return
	 * @throws BizException 
	 */
	protected CiPresDO[] genPresByOrdPresSplit(List<CiOrPresSplitList> orpressplitlists,CiOrSessionDO session) throws BizException{
		CiOrPresSplitList2CiOrPresHandleBP  bp = new CiOrPresSplitList2CiOrPresHandleBP();
		  return bp.exec(orpressplitlists,session);
	}
	
	/**
	 * 临床医嘱处方分方后执行域相关处理
	 * @param cipres
	 * @throws BizException
	 */
	protected void ciOrPresSplitMpHandle(CiPresDO[] cipres) throws BizException{
		CiOrPresSplitMpHandleBP bp=new CiOrPresSplitMpHandleBP();
		bp.exec(cipres);
	}
	
	/**
	 *  获得分方规则编排插件并执行编排
	 * @param orpressplitlists
	 * @return
	 * @throws BizException 
	 */
	protected List<CiOrPresSplitList> ciOrPresSplitRuleArrangePluginExec(List<CiOrPresSplitList> orpressplitlists) throws BizException{
		CiOrPresSplitRuleArrangeExeBP bp=new CiOrPresSplitRuleArrangeExeBP();
		return bp.exec(orpressplitlists);
	}

}
