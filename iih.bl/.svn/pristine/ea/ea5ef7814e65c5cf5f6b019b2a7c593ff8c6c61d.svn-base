package iih.bl.cc.ep;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlCcIncCancDO;
import iih.bl.cc.blcc.d.BlCcIncDO;
import iih.bl.cc.blcc.d.BlCcIncReDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancRService;
import iih.bl.inc.blincoeppaper.d.BlIncOepPaperDO;
import iih.bl.inc.blincoeppaper.i.IBlincoeppaperCudService;
import iih.bl.inc.blincoeppaper.i.IBlincoeppaperRService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 电子发票结账
 * @author liming06
 *
 */
public class CcElecIncEP {

	/**
	 * 结账-- 更改门诊电子发票信息为已结账
	 * @param id_user
	 * @param end_time
	 * @param id_cc
	 * @throws BizException
	 */
	public void updateElecIncOepInfos(String id_user, FDateTime end_time,String id_cc) throws BizException{
		BlIncOepPaperDO[] blIncOepPaperDOArr = this.getBlElecIncOepDOInfosBP(id_user, end_time);
		IBlincoeppaperCudService oepCService = ServiceFinder.find(IBlincoeppaperCudService.class);
		if(!ArrayUtil.isEmpty(blIncOepPaperDOArr)){
			for(BlIncOepPaperDO blIncOepPaperDO : blIncOepPaperDOArr){
				blIncOepPaperDO.setStatus(DOStatus.UPDATED);
				if(!blIncOepPaperDO.getFg_canc().booleanValue()){
					blIncOepPaperDO.setFg_cc_out(FBoolean.TRUE);
					blIncOepPaperDO.setId_cc_out(id_cc);
				}else{
					if(!blIncOepPaperDO.getFg_cc_out().booleanValue() && id_user.equals(blIncOepPaperDO.getId_emp_inc())){					
						blIncOepPaperDO.setFg_cc_out(FBoolean.TRUE);
						blIncOepPaperDO.setId_cc_out(id_cc);
					}
					if(!blIncOepPaperDO.getFg_cc_in().booleanValue() && id_user.equals(blIncOepPaperDO.getId_emp_canc())){	
						blIncOepPaperDO.setFg_cc_in(FBoolean.TRUE);
						blIncOepPaperDO.setId_cc_in(id_cc);
					}
				}
			}
			oepCService.save(blIncOepPaperDOArr);
		}
	}
	
	/**
	 * 取消结账-更改门诊电子发票信息为未结账
	 * @param blccAggDO
	 * @throws BizException
	 */
	public void updateElecIncOepInfosForCancel(BlccAggDO blccAggDO) throws BizException{
		StringBuilder oepStr = new StringBuilder();
		oepStr.append(" a0.id_cc_out = '").append(blccAggDO.getParentDO().getId_cc()).append("'")
				   .append(" or a0.id_cc_in = '").append(blccAggDO.getParentDO().getId_cc()).append("'");
		IBlincoeppaperRService incOepService = ServiceFinder.find(IBlincoeppaperRService.class);
		BlIncOepPaperDO[] blIncOepDOPaperArr = incOepService.find(oepStr.toString(), null, FBoolean.FALSE);
		IBlincoeppaperCudService oepCService = ServiceFinder.find(IBlincoeppaperCudService.class);
		if(!ArrayUtil.isEmpty(blIncOepDOPaperArr)){
			for(BlIncOepPaperDO blIncOepPaperDO : blIncOepDOPaperArr){
				blIncOepPaperDO.setStatus(DOStatus.UPDATED);
				if(blccAggDO.getParentDO().getId_cc().equals(blIncOepPaperDO.getId_cc_out())){
					blIncOepPaperDO.setFg_cc_out(FBoolean.FALSE);
					blIncOepPaperDO.setId_cc_out("~");
				}
				if(blccAggDO.getParentDO().getId_cc().equals(blIncOepPaperDO.getId_cc_in())){
					blIncOepPaperDO.setFg_cc_in(FBoolean.FALSE);
					blIncOepPaperDO.setId_cc_in("~");
				}
			}
			oepCService.save(blIncOepDOPaperArr);
		}
	}
	
	/**
	 *  获取门诊发票信息
	 * @param id_user
	 * @param end_time
	 * @return
	 * @throws BizException
	 * @author LIM
	 */
	public BlIncOepPaperDO[] getBlElecIncOepDOInfosBP(String id_user, FDateTime end_time) throws BizException{
		StringBuffer oepStr = new StringBuffer();
		oepStr.append(" ( a0.fg_cc_out = 'N'  and a0.id_emp_inc = '").append(id_user).append("' and a0.dt_inc <= '").append(end_time).append("') ")
		   .append(" or (a0.fg_cc_in = 'N'  and a0.id_emp_canc = '").append(id_user).append("' and a0.dt_canc <= '").append(end_time).append("') ");
		IBlincoeppaperRService incOepService = ServiceFinder.find(IBlincoeppaperRService.class);
		BlIncOepPaperDO[] blIncOepDOArr = incOepService.find(oepStr.toString(), null, FBoolean.FALSE);
		return blIncOepDOArr;
	}	
	
	/**
	 *  给结账对象添加电子发票信息
	 * @param id_user
	 * @param id_org
	 * @param sd_cctp
	 * @param end_time
	 * @param blccDO
	 * @param incList
	 * @param incancList
	 * @param increList
	 * @throws BizException
	 */
	public void setBlccDOIncnoInfo(String id_user, String id_org, String sd_cctp, FDateTime end_time, BlCcDO blccDO, List<BlCcIncDO> incList, List<BlCcIncCancDO> incancList, List<BlCcIncReDO> increList) throws BizException{
		StringBuilder incnos = new StringBuilder();//使用结算发票号信息串
		Integer inccn = 0;//发票张数
		StringBuffer incnos_canc = new StringBuffer();//作废结算发票号信息串
		Integer inccn_canc = 0;//作废结算发票张数
		Integer inccn_re = 0;//退费发票张数
		StringBuilder incnos_re = new StringBuilder();//退费发票号信息串
		Map<String,BlCcIncDO> incMap = new HashMap<String,BlCcIncDO>();//记录结账_发票信息
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）

			BlIncOepPaperDO[] blIncOepPaperDOArr = this.getBlElecIncOepDOInfosBP(id_user, end_time);
			if(!ArrayUtil.isEmpty(blIncOepPaperDOArr)){
				for(BlIncOepPaperDO blIncOepPaperDO : blIncOepPaperDOArr){
					if(blIncOepPaperDO.getIncno() == null){
						continue;
					}
					//收发票
					if(FBoolean.FALSE.equals(blIncOepPaperDO.getFg_cc_out()) && id_user.equals(blIncOepPaperDO.getId_emp_inc())){
						incnos.append(blIncOepPaperDO.getIncno());
						incnos.append(",");
						inccn++;
					}
					if(FBoolean.FALSE.equals(blIncOepPaperDO.getFg_cc_in()) && blIncOepPaperDO.getFg_canc().booleanValue() && id_user.equals(blIncOepPaperDO.getId_emp_canc())){
						incnos_re.append(blIncOepPaperDO.getIncno());
						incnos_re.append(",");
						inccn_re++;
					}
					//退发票明细
					if(blIncOepPaperDO.getFg_canc().booleanValue() && !blIncOepPaperDO.getFg_cc_in().booleanValue() && id_user.equals(blIncOepPaperDO.getId_emp_canc())){
						BlCcIncReDO blccIncReDo = new BlCcIncReDO();
						blccIncReDo.setId_org(id_org);
						blccIncReDo.setId_grp(Context.get().getGroupId());
//						blccIncReDo.setId_incca(blIncOepPaperDO.getId_incca());
						blccIncReDo.setIncno_re(blIncOepPaperDO.getIncno());
						blccIncReDo.setDt_re(blIncOepPaperDO.getDt_canc());
						blccIncReDo.setFg_ec_inc(FBoolean.TRUE);
						increList.add(blccIncReDo);
					}
					if(!id_user.equals(blIncOepPaperDO.getId_emp_inc()))
							continue;
					//记录发票
					BlCcIncDO incDO = incMap.get(blIncOepPaperDO.getCode_incpkg());
					if(incDO == null){
							BlCcIncDO blccIncDO = new BlCcIncDO();
							blccIncDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);//门诊发票
							blccIncDO.setCode_incpkg(blIncOepPaperDO.getCode_incpkg());
							if(!blIncOepPaperDO.getFg_cc_out().booleanValue()){
								blccIncDO.setNum_b(blIncOepPaperDO.getIncno());
								blccIncDO.setNum_e(blIncOepPaperDO.getIncno());
							}
							if(blIncOepPaperDO.getFg_canc().booleanValue()&& !blIncOepPaperDO.getFg_cc_in().booleanValue()){
								blccIncDO.setIncnos_canc(blIncOepPaperDO.getIncno());
							}
							blccIncDO.setFg_ec_inc(FBoolean.TRUE);
							blccIncDO.setStatus(DOStatus.NEW);
							incMap.put(blIncOepPaperDO.getCode_incpkg(), blccIncDO);
					}else{
						if(FBoolean.FALSE.equals(blIncOepPaperDO.getFg_cc_out()) && blIncOepPaperDO.getIncno().compareTo((StringUtil.isEmpty(incDO.getNum_b())?blIncOepPaperDO.getIncno():incDO.getNum_b())) <= 0){
							incDO.setNum_b(blIncOepPaperDO.getIncno());
						}
						if(FBoolean.FALSE.equals(blIncOepPaperDO.getFg_cc_out()) && blIncOepPaperDO.getIncno().compareTo((StringUtil.isEmpty(incDO.getNum_e())?blIncOepPaperDO.getIncno():incDO.getNum_e())) >= 0){
							incDO.setNum_e(blIncOepPaperDO.getIncno());
						}
						if(blIncOepPaperDO.getFg_canc().booleanValue()&& !blIncOepPaperDO.getFg_cc_in().booleanValue()){
							StringBuffer incSt = new StringBuffer();
							if(incDO.getIncnos_canc() != null){
								incSt.append(incDO.getIncnos_canc()).append(",").append(blIncOepPaperDO.getIncno());
							}else{
								incSt.append(blIncOepPaperDO.getIncno());
							}
							incDO.setIncnos_canc(incSt.toString());
						}
					}
				}
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){
			// 住院暂时没实现电子票，先不做结账
		}
		blccDO.setIncnos_paper(incnos.toString());//使用结算发票号信息串
		blccDO.setInccn_paper(inccn);//发票张数
		blccDO.setInccn_re_paper(inccn_re);//退费发票张数
		blccDO.setIncnos_re_paper(incnos_re.toString());//退费发票号信息串
		
		//添加空白发票
		StringBuffer tb = new StringBuffer();
		tb.append(" a0.fg_cc = 'N' and a0.fg_ec_inc='Y' ")
		  .append(" and a0.id_emp_canc = '").append(id_user).append("'")
		  .append(" and a0.dt_canc < '").append(end_time).append("'");
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）
			tb.append(" and a0.id_incca = '").append(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE).append("'");
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			tb.append(" and a0.id_incca = '").append(IBdInccaCodeConst.ID_INHOS_INVOICE).append("'");
		}
		IBlinccancRService canService = ServiceFinder.find(IBlinccancRService.class);
		BlIncCancDO[] blIncCancDOArr = canService.find(tb.toString(), null, FBoolean.FALSE);
		if(blIncCancDOArr != null){
			String id_incca = null;
			if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）
				id_incca = IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE;
			}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
				id_incca = IBdInccaCodeConst.CODE_INHOS_INVOICE;
			}
			for(BlIncCancDO blIncCancDO : blIncCancDOArr){
				if(incnos_canc.length() > 0){
					incnos_canc.append(",");
				}
				incnos_canc.append(blIncCancDO.getIncno());
				inccn_canc++;
				if(incMap.get(blIncCancDO.getCode_incpkg()) == null){
					BlCcIncDO blccIncDO = new BlCcIncDO();
					blccIncDO.setId_incca(id_incca);//门诊发票
					blccIncDO.setCode_incpkg(blIncCancDO.getCode_incpkg());
//					blccIncDO.setNum_b(blIncCancDO.getIncno());
//					blccIncDO.setNum_e(blIncCancDO.getIncno());
					blccIncDO.setIncnos_canc(blIncCancDO.getIncno());

					blccIncDO.setStatus(DOStatus.NEW);
					incMap.put(blIncCancDO.getCode_incpkg(), blccIncDO);
				}else{
//					if(blIncCancDO.getIncno().compareTo(incMap.get(blIncCancDO.getCode_incpkg()).getNum_b()) < 0){
//						incMap.get(blIncCancDO.getCode_incpkg()).setNum_b(blIncCancDO.getIncno());
//					}
//					if(blIncCancDO.getIncno().compareTo(incMap.get(blIncCancDO.getCode_incpkg()).getNum_e()) > 0){
//						incMap.get(blIncCancDO.getCode_incpkg()).setNum_e(blIncCancDO.getIncno());
//					}
					StringBuffer incSt = new StringBuffer();
					if(incMap.get(blIncCancDO.getCode_incpkg()).getIncnos_canc() != null){
						incSt.append(incMap.get(blIncCancDO.getCode_incpkg()).getIncnos_canc());
					}
					if(blIncCancDO.getIncno() != null){
						if(!StringUtil.isEmpty(incSt.toString())){
							incSt.append(",").append(blIncCancDO.getIncno());
						}else{
							incSt.append(blIncCancDO.getIncno());
						}
					}
					incMap.get(blIncCancDO.getCode_incpkg()).setIncnos_canc(incSt.toString());
				}
				//作废发票明细
				BlCcIncCancDO blccIncCancDO = new BlCcIncCancDO();
				blccIncCancDO.setId_org(id_org);
				blccIncCancDO.setId_grp(Context.get().getGroupId());
				blccIncCancDO.setIncno_canc(blIncCancDO.getIncno());
				blccIncCancDO.setDt_canc(blIncCancDO.getDt_canc());
				blccIncCancDO.setNote_canc(blIncCancDO.getSd_reason_canc());
				blccIncCancDO.setFg_ec_inc(FBoolean.TRUE);
				blccIncCancDO.setStatus(DOStatus.NEW);
				incancList.add(blccIncCancDO);
			}
		}
		blccDO.setIncnos_canc_paper(incnos_canc.toString());//作废结算发票号信息串
		blccDO.setInccn_canc_paper(inccn_canc);//作废结算发票张数
		for(String key : incMap.keySet()){
			BlCcIncDO blccIncDO = incMap.get(key);
			blccIncDO.setId_org(id_org);
			blccIncDO.setId_grp(Context.get().getGroupId());
			incList.add(blccIncDO);
		}
	}		
}
