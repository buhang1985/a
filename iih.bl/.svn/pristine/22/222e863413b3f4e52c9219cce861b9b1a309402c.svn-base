package iih.bl.cc.ep;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlCcIncCancDO;
import iih.bl.cc.blcc.d.BlCcIncDO;
import iih.bl.cc.blcc.d.BlCcIncReDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancCudService;
import iih.bl.inc.blinccanc.i.IBlinccancRService;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.i.IBlincipMDOCudService;
import iih.bl.inc.blincip.i.IBlincipMDORService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.i.IBlincoepMDOCudService;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 结账发票EP
 * @author yankan
 * @since 2017-06-19
 *
 */
public class CcIncEP {
	
	/**
	 * 结账-- 更改门诊发票信息为已结账
	 * @param id_user
	 * @param end_time
	 * @param id_cc
	 * @throws BizException
	 */
	public void updateIncOepInfos(String id_user, FDateTime end_time,String id_cc) throws BizException{
		BlIncOepDO[] blIncOepDOArr = this.getBlIncOepDOInfosBP(id_user, end_time);
		IBlincoepMDOCudService oepCService = ServiceFinder.find(IBlincoepMDOCudService.class);
		if(blIncOepDOArr != null && blIncOepDOArr.length > 0){
			for(BlIncOepDO blIncOepDO : blIncOepDOArr){
				blIncOepDO.setStatus(DOStatus.UPDATED);
				if(!blIncOepDO.getFg_canc().booleanValue()){
					blIncOepDO.setFg_cc_out(FBoolean.TRUE);
					blIncOepDO.setId_cc_out(id_cc);
				}else{
					// by lim 结账时，判断开票人是否是当前操作员，防止结账人和开票人不一致，替别人结账 2017-06-29
					if(!blIncOepDO.getFg_cc_out().booleanValue() && id_user.equals(blIncOepDO.getId_emp_inc())){					
					//if(!blIncOepDO.getFg_cc_out().booleanValue()){
						blIncOepDO.setFg_cc_out(FBoolean.TRUE);
						blIncOepDO.setId_cc_out(id_cc);
					}
					if(!blIncOepDO.getFg_cc_in().booleanValue() && id_user.equals(blIncOepDO.getId_emp_canc())){	
						blIncOepDO.setFg_cc_in(FBoolean.TRUE);
						blIncOepDO.setId_cc_in(id_cc);
					}
				}
			}
			oepCService.save(blIncOepDOArr);
		}
	}
	/**
	 * 取消结账-更改门诊发票信息为未结账
	 * @param blccAggDO
	 * @throws BizException
	 */
	public void updateIncOepInfosForCancel(BlccAggDO blccAggDO) throws BizException{
		StringBuilder oepStr = new StringBuilder();
		oepStr.append(" a0.id_cc_out = '").append(blccAggDO.getParentDO().getId_cc()).append("'")
				   .append(" or a0.id_cc_in = '").append(blccAggDO.getParentDO().getId_cc()).append("'");
		IBlincoepMDORService incOepService = ServiceFinder.find(IBlincoepMDORService.class);
		BlIncOepDO[] blIncOepDOArr = incOepService.find(oepStr.toString(), null, FBoolean.FALSE);
		IBlincoepMDOCudService oepCService = ServiceFinder.find(IBlincoepMDOCudService.class);
		if(blIncOepDOArr != null && blIncOepDOArr.length > 0){
			for(BlIncOepDO blIncOepDO : blIncOepDOArr){
				blIncOepDO.setStatus(DOStatus.UPDATED);
				if(blccAggDO.getParentDO().getId_cc().equals(blIncOepDO.getId_cc_out())){
					blIncOepDO.setFg_cc_out(FBoolean.FALSE);
					blIncOepDO.setId_cc_out("~");
				}
				if(blccAggDO.getParentDO().getId_cc().equals(blIncOepDO.getId_cc_in())){
					blIncOepDO.setFg_cc_in(FBoolean.FALSE);
					blIncOepDO.setId_cc_in("~");
				}
			}
			oepCService.save(blIncOepDOArr);
		}
	}
	/**
	 * 结账--更改住院发票信息为已结账
	 * @param id_user
	 * @param end_time
	 * @param id_cc
	 * @throws BizException
	 */
	public void updateIncIpInfos(String id_user, FDateTime end_time,String id_cc) throws BizException{
		BlIncIpDO[] blIncIpDOArr = this.getBlIncIpDOInfos(id_user, end_time);
		IBlincipMDOCudService ipCService = ServiceFinder.find(IBlincipMDOCudService.class);
		if(blIncIpDOArr != null && blIncIpDOArr.length > 0){
			for(BlIncIpDO blIncIpDO : blIncIpDOArr){
				blIncIpDO.setStatus(DOStatus.UPDATED);
				if(!blIncIpDO.getFg_canc().booleanValue()){
					blIncIpDO.setFg_cc_out(FBoolean.TRUE);
					blIncIpDO.setId_cc_out(id_cc);
				}else{
					if(!blIncIpDO.getFg_cc_out().booleanValue() && id_user.equals(blIncIpDO.getId_emp_inc())){					
					//if(!blIncOepDO.getFg_cc_out().booleanValue()){
						blIncIpDO.setFg_cc_out(FBoolean.TRUE);
						blIncIpDO.setId_cc_out(id_cc);
					}
					if(!blIncIpDO.getFg_cc_in().booleanValue() && id_user.equals(blIncIpDO.getId_emp_canc())){	
						blIncIpDO.setFg_cc_in(FBoolean.TRUE);
						blIncIpDO.setId_cc_in(id_cc);
					}
//					if(!blIncIpDO.getFg_cc_out().booleanValue()){
//						blIncIpDO.setFg_cc_out(FBoolean.TRUE);
//						blIncIpDO.setId_cc_out(id_cc);
//					}
//					blIncIpDO.setFg_cc_in(FBoolean.TRUE);
//					blIncIpDO.setId_cc_in(id_cc);
				}
			}
			ipCService.save(blIncIpDOArr);
		}
	}
	/**
	 * 取消结账--更改住院发票信息为未结账
	 * @param blccAggDO
	 * @throws BizException
	 */
	public void updateIncIpInfosForCancel(BlccAggDO blccAggDO) throws BizException{
		StringBuilder ipStr = new StringBuilder();
		ipStr.append(" a0.id_cc_out = '").append(blccAggDO.getParentDO().getId_cc()).append("'")
		       .append(" or a0.id_cc_in = '").append(blccAggDO.getParentDO().getId_cc()).append("'");
		IBlincipMDORService incIpService = ServiceFinder.find(IBlincipMDORService.class);
		BlIncIpDO[] blIncIpDOArr = incIpService.find(ipStr.toString(), null, FBoolean.FALSE);
		IBlincipMDOCudService ipCService = ServiceFinder.find(IBlincipMDOCudService.class);
		if(blIncIpDOArr != null && blIncIpDOArr.length > 0){
			for(BlIncIpDO blIncIpDO : blIncIpDOArr){
				blIncIpDO.setStatus(DOStatus.UPDATED);
				if(blccAggDO.getParentDO().getId_cc().equals(blIncIpDO.getId_cc_out())){
					blIncIpDO.setFg_cc_out(FBoolean.FALSE);
					blIncIpDO.setId_cc_out("~");
				}
				if(blccAggDO.getParentDO().getId_cc().equals(blIncIpDO.getId_cc_in())){
					blIncIpDO.setFg_cc_in(FBoolean.FALSE);
					blIncIpDO.setId_cc_in("~");
				}
			}
			ipCService.save(blIncIpDOArr);
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
	public BlIncOepDO[] getBlIncOepDOInfosBP(String id_user, FDateTime end_time) throws BizException{
		StringBuffer oepStr = new StringBuffer();
//		oepStr.append(" (a0.fg_print = 'Y' and a0.fg_cc_out = 'N'  and a0.fg_canc = 'N' and a0.id_emp_inc = '").append(id_user).append("' and a0.dt_inc <= '").append(end_time).append("') ")
//				   .append(" or (a0.fg_canc = 'Y' and a0.fg_cc_in = 'N'  and a0.id_emp_canc = '").append(id_user).append("' and a0.dt_canc <= '").append(end_time).append("') ");
		oepStr.append(" ((a0.fg_print = 'Y' and a0.fg_cc_out = 'N'  and a0.id_emp_inc = '").append(id_user).append("' and a0.dt_inc <= '").append(end_time).append("') ")
		   .append(" or (a0.fg_cc_in = 'N'  and a0.id_emp_canc = '").append(id_user).append("' and a0.dt_canc <= '").append(end_time).append("')) and a0.fg_ec_inc='N' ");
		IBlincoepMDORService incOepService = ServiceFinder.find(IBlincoepMDORService.class);
		BlIncOepDO[] blIncOepDOArr = incOepService.find(oepStr.toString(), null, FBoolean.FALSE);
		return blIncOepDOArr;
	}		
	/**
	 * 结账-获取住院发票信息
	 * @param id_user
	 * @param end_time
	 * @return
	 * @throws BizException
	 */
	public BlIncIpDO[] getBlIncIpDOInfos(String id_user, FDateTime end_time) throws BizException{
		StringBuffer ipStr = new StringBuffer();
//		ipStr.append(" (a0.fg_print = 'Y' and a0.fg_cc_out = 'N' and a0.fg_canc = 'N' and a0.id_emp_inc = '").append(id_user).append("' and a0.dt_inc <= '").append(end_time).append("') ")
//		   .append(" or (a0.fg_canc = 'Y' and a0.fg_cc_in = 'N' and a0.id_emp_canc = '").append(id_user).append("' and a0.dt_canc <= '").append(end_time).append("') ");
		ipStr.append(" (a0.fg_print = 'Y' and a0.fg_cc_out = 'N' and a0.id_emp_inc = '").append(id_user).append("' and a0.dt_inc <= '").append(end_time).append("') ")
		   .append(" or (a0.fg_cc_in = 'N' and a0.id_emp_canc = '").append(id_user).append("' and a0.dt_canc <= '").append(end_time).append("') ");
		IBlincipMDORService incIpService = ServiceFinder.find(IBlincipMDORService.class);
		BlIncIpDO[] blIncIpDOArr = incIpService.find(ipStr.toString(), null, FBoolean.FALSE);
		return blIncIpDOArr;
	}

	/**
	 * 结账-修改空白作废票据表(BL_INC_CANC)中结账标志为已结账
	 * @param id_user
	 * @param end_time
	 * @param id_cc
	 * @param fg_cc
	 * @throws BizException
	 */
	public void updateIncCancOepInfos(String id_user,FDateTime end_time,String id_cc,FBoolean fg_cc,String sd_cctp)throws BizException{
		StringBuilder incSql = new StringBuilder();
//		incSql.append(" a0.ID_ORG = '").append(id_org).append("'")
		incSql.append(" a0.FG_CC='N' AND a0.ID_EMP_CANC = '").append(id_user).append("'");
		incSql.append(" and a0.DT_CANC < '").append(end_time).append("'");
		incSql.append(" and a0.id_incca in ('");
		//根据门诊住院区分结账 by lim 2017-09-05
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊预交金
			incSql.append(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE).append("','");
			incSql.append(IBdPpCodeTypeConst.ID_DESIGNED_FUND);
		}else if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)){//门诊预交金
			incSql.append(IBdPpCodeTypeConst.ID_OUTPATIENT_DEPOSIT);
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			incSql.append(IBdPpCodeTypeConst.ID_INHOS_INVOICE);
		}else if(IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp)){
			incSql.append(IBdPpCodeTypeConst.ID_INHOS_DEPOSIT);
		}		
		incSql.append("')");
		IBlinccancRService incRService = ServiceFinder.find(IBlinccancRService.class);
		
		BlIncCancDO[] blIncCancDOArr = incRService.find(incSql.toString(), null, FBoolean.FALSE);
		if(blIncCancDOArr != null && blIncCancDOArr.length > 0){
			for(BlIncCancDO blIncCancDO : blIncCancDOArr){
				blIncCancDO.setId_cc(id_cc);
				blIncCancDO.setFg_cc(fg_cc);
				blIncCancDO.setStatus(DOStatus.UPDATED);
			}
			IBlinccancCudService incCService = ServiceFinder.find(IBlinccancCudService.class);
			incCService.save(blIncCancDOArr);
		}
	}
	/**
	 * 取消结账--修改空白作废票据表(BL_INC_CANC)中结账标志为未结账
	 * @param sqlStr
	 * @throws BizException
	 */
	public void updateIncCancOepInfosForCancel(String sqlStr)throws BizException{
		IBlinccancRService incRService = ServiceFinder.find(IBlinccancRService.class);	
		BlIncCancDO[] blIncCancDOArr = incRService.find(sqlStr, null, FBoolean.FALSE);
		if(blIncCancDOArr != null && blIncCancDOArr.length > 0){
			for(BlIncCancDO blIncCancDO : blIncCancDOArr){
				blIncCancDO.setId_cc(null);
				blIncCancDO.setFg_cc(FBoolean.FALSE);
				blIncCancDO.setStatus(DOStatus.UPDATED);
			}
			IBlinccancCudService incCService = ServiceFinder.find(IBlinccancCudService.class);
			incCService.save(blIncCancDOArr);
		}
	}
	/**
	 * 检查是否有空白作废发票
	 * @param id_user
	 * @param id_org
	 * @param sd_cctp
	 * @param end_time
	 * @return
	 * @throws BizException
	 */
	public FBoolean checkBlIncCancInfo(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		FBoolean flag = FBoolean.FALSE;
		StringBuffer tb = new StringBuffer();
		tb.append(" a0.fg_cc = 'N'")
		  .append(" and a0.id_emp_canc = '").append(id_user).append("'")
		  .append(" and a0.dt_canc < '").append(end_time).append("'");
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）
			tb.append(" and a0.id_incca = '").append(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE).append("'");
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			tb.append(" and a0.id_incca = '").append(IBdInccaCodeConst.ID_INHOS_INVOICE).append("'");
		}
		
		IBlinccancRService canService = ServiceFinder.find(IBlinccancRService.class);
		BlIncCancDO[] blIncCancDOArr = canService.find(tb.toString(), null, FBoolean.FALSE);
		if(blIncCancDOArr != null && blIncCancDOArr.length > 0){
			flag = FBoolean.TRUE;
		}
		return flag;
	}	
	/**
	 *  给结账对象添加发票信息
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
			CcIncEP getInfo= new CcIncEP();
			BlIncOepDO[] list = getInfo.getBlIncOepDOInfosBP(id_user, end_time);
			if(list != null && list.length > 0){
				for(BlIncOepDO blIncOepDO : list){
					if(blIncOepDO.getIncno() == null){
						//throw new BizException("门诊发票为空！");
						continue;
					}
					//收发票
					if(FBoolean.FALSE.equals(blIncOepDO.getFg_cc_out()) && id_user.equals(blIncOepDO.getId_emp_inc())){
						incnos.append(blIncOepDO.getIncno());
						incnos.append(",");
						inccn++;
					}
					if(FBoolean.FALSE.equals(blIncOepDO.getFg_cc_in()) && blIncOepDO.getFg_canc().booleanValue() && id_user.equals(blIncOepDO.getId_emp_canc())){
						incnos_re.append(blIncOepDO.getIncno());
						incnos_re.append(",");
						inccn_re++;
					}
					//退发票明细
					if(blIncOepDO.getFg_canc().booleanValue() && !blIncOepDO.getFg_cc_in().booleanValue() && id_user.equals(blIncOepDO.getId_emp_canc())){
						BlCcIncReDO blccIncReDo = new BlCcIncReDO();
						blccIncReDo.setId_org(id_org);
						blccIncReDo.setId_grp(Context.get().getGroupId());
						blccIncReDo.setId_incca(blIncOepDO.getId_incca());
						blccIncReDo.setIncno_re(blIncOepDO.getIncno());
						blccIncReDo.setDt_re(blIncOepDO.getDt_canc());
						blccIncReDo.setFg_ec_inc(FBoolean.FALSE);
						increList.add(blccIncReDo);
					}
					if(!id_user.equals(blIncOepDO.getId_emp_inc()))
							continue;
					//记录发票
					BlCcIncDO incDO = incMap.get(blIncOepDO.getCode_incpkg());
					if(incDO == null){
							BlCcIncDO blccIncDO = new BlCcIncDO();
							blccIncDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);//门诊发票
							blccIncDO.setCode_incpkg(blIncOepDO.getCode_incpkg());
							if(!blIncOepDO.getFg_cc_out().booleanValue()){
								blccIncDO.setNum_b(blIncOepDO.getIncno());
								blccIncDO.setNum_e(blIncOepDO.getIncno());
							}
							if(blIncOepDO.getFg_canc().booleanValue()&& !blIncOepDO.getFg_cc_in().booleanValue()){
								blccIncDO.setIncnos_canc(blIncOepDO.getIncno());
							}
							blccIncDO.setStatus(DOStatus.NEW);
							incMap.put(blIncOepDO.getCode_incpkg(), blccIncDO);
					}else{
						if(FBoolean.FALSE.equals(blIncOepDO.getFg_cc_out()) && blIncOepDO.getIncno().compareTo((StringUtil.isEmpty(incDO.getNum_b())?blIncOepDO.getIncno():incDO.getNum_b())) <= 0){
							incDO.setNum_b(blIncOepDO.getIncno());
						}
						if(FBoolean.FALSE.equals(blIncOepDO.getFg_cc_out()) && blIncOepDO.getIncno().compareTo((StringUtil.isEmpty(incDO.getNum_e())?blIncOepDO.getIncno():incDO.getNum_e())) >= 0){
							incDO.setNum_e(blIncOepDO.getIncno());
						}
						if(blIncOepDO.getFg_canc().booleanValue()&& !blIncOepDO.getFg_cc_in().booleanValue()){
							StringBuffer incSt = new StringBuffer();
							if(incDO.getIncnos_canc() != null){
								incSt.append(incDO.getIncnos_canc()).append(",").append(blIncOepDO.getIncno());
							}else{
								incSt.append(blIncOepDO.getIncno());
							}
							incDO.setIncnos_canc(incSt.toString());
						}
					}
				}
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){
			CcIncEP blIpInfo= new CcIncEP();
			BlIncIpDO[] list = blIpInfo.getBlIncIpDOInfos(id_user, end_time);
			if(list != null && list.length > 0){
				for(BlIncIpDO blIncIpDO : list){
					if(blIncIpDO.getIncno() == null){
						continue;
					}
					//收发票
					if(FBoolean.FALSE.equals(blIncIpDO.getFg_cc_out()) && id_user.equals(blIncIpDO.getId_emp_inc())){
						incnos.append(blIncIpDO.getIncno());
						incnos.append(",");
						inccn++;
					}
					if(FBoolean.FALSE.equals(blIncIpDO.getFg_cc_in()) && blIncIpDO.getFg_canc().booleanValue()&& id_user.equals(blIncIpDO.getId_emp_canc())){
						incnos_re.append(blIncIpDO.getIncno());
						incnos_re.append(",");
						inccn_re++;
					}else{
//						if(incnos.length() > 0){
//							incnos.append(",");
//						}
//						incnos.append(blIncIpDO.getIncno());
//						inccn++;
					}
					//作废发票明细
					if(blIncIpDO.getFg_canc().booleanValue() && !blIncIpDO.getFg_cc_in().booleanValue() && id_user.equals(blIncIpDO.getId_emp_canc())){
						BlCcIncReDO blccIncReDo = new BlCcIncReDO();
						blccIncReDo.setId_org(id_org);
						blccIncReDo.setId_grp(Context.get().getGroupId());
						blccIncReDo.setId_incca(blIncIpDO.getId_incca());
						blccIncReDo.setIncno_re(blIncIpDO.getIncno());
						blccIncReDo.setDt_re(blIncIpDO.getDt_canc());
						increList.add(blccIncReDo);
					}
					//开出的发票
					if(!id_user.equals(blIncIpDO.getId_emp_inc()))
						continue;
					//记录发票
					BlCcIncDO incDO = incMap.get(blIncIpDO.getCode_incpkg());
					if(incDO == null){
						if(blIncIpDO.getFg_canc().booleanValue()&& !blIncIpDO.getFg_cc_in().booleanValue()){
							BlCcIncDO blccIncDO = new BlCcIncDO();
							blccIncDO.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);//住院发票
							blccIncDO.setCode_incpkg(blIncIpDO.getCode_incpkg());
							if(!blIncIpDO.getFg_cc_out().booleanValue()){
								blccIncDO.setNum_b(blIncIpDO.getIncno());
								blccIncDO.setNum_e(blIncIpDO.getIncno());
							}
							if(blIncIpDO.getFg_canc().booleanValue()&& !blIncIpDO.getFg_cc_in().booleanValue()){
								blccIncDO.setIncnos_canc(blIncIpDO.getIncno());
							}
							blccIncDO.setFg_ec_inc(FBoolean.FALSE);
							blccIncDO.setStatus(DOStatus.NEW);
							incMap.put(blIncIpDO.getCode_incpkg(), blccIncDO);
						}
					}else{
						if(FBoolean.FALSE.equals(blIncIpDO.getFg_cc_out()) && blIncIpDO.getIncno().compareTo((StringUtil.isEmpty(incDO.getNum_b())?blIncIpDO.getIncno():incDO.getNum_b())) <= 0){
							incDO.setNum_b(blIncIpDO.getIncno());
						}
						if(FBoolean.FALSE.equals(blIncIpDO.getFg_cc_out()) && blIncIpDO.getIncno().compareTo((StringUtil.isEmpty(incDO.getNum_e())?blIncIpDO.getIncno():incDO.getNum_e())) >= 0){
							incDO.setNum_e(blIncIpDO.getIncno());
						}
						if(blIncIpDO.getFg_canc().booleanValue()&& !blIncIpDO.getFg_cc_in().booleanValue()){
							StringBuffer incSt = new StringBuffer();
							if(incDO.getIncnos_canc() != null){
								incSt.append(incDO.getIncnos_canc()).append(",").append(blIncIpDO.getIncno());
							}else{
								incSt.append(blIncIpDO.getIncno());
							}
							incDO.setIncnos_canc(incSt.toString());
						}
					}
//					//作废发票明细
//					if(blIncIpDO.getFg_canc().booleanValue()){
//						BlCcIncReDO blccIncReDo = new BlCcIncReDO();
//						blccIncReDo.setId_org(id_org);
//						blccIncReDo.setId_grp(Context.get().getGroupId());
//						blccIncReDo.setId_incca(blIncIpDO.getId_incca());
//						blccIncReDo.setIncno_re(blIncIpDO.getIncno());
//						blccIncReDo.setDt_re(blIncIpDO.getDt_canc());
//						increList.add(blccIncReDo);
//					}
				}
			}
		}
		blccDO.setIncnos(incnos.toString());//使用结算发票号信息串
		blccDO.setInccn(inccn);//发票张数
		blccDO.setInccn_re(inccn_re);//退费发票张数
		blccDO.setIncnos_re(incnos_re.toString());//退费发票号信息串
		
		//添加空白发票
		StringBuffer tb = new StringBuffer();
		tb.append(" a0.fg_cc = 'N' and a0.fg_ec_inc='N' ")
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
				blccIncCancDO.setFg_ec_inc(FBoolean.FALSE);
				blccIncCancDO.setStatus(DOStatus.NEW);
				incancList.add(blccIncCancDO);
			}
		}
		blccDO.setIncnos_canc(incnos_canc.toString());//作废结算发票号信息串
		blccDO.setInccn_canc(inccn_canc);//作废结算发票张数
		for(String key : incMap.keySet()){
			BlCcIncDO blccIncDO = incMap.get(key);
			blccIncDO.setId_org(id_org);
			blccIncDO.setId_grp(Context.get().getGroupId());
			incList.add(blccIncDO);
		}
	}		
}
