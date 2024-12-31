package iih.bl.st.s.bp;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.params.BlParams;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.ep.IpStEP;
import iih.bl.st.listrener.event.BlStIpEvent;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院结算BP
 * 
 * @author liwq
 *
 */
public class DoIpSettlementBP {

	/**
	 * 
	 * @param id_pat
	 * @param id_ent
	 * @param id_dep 费用开立科室
	 * @param id_emp
	 * @param dt_end  
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public String exec (String id_pat, String id_ent, String id_dep, String id_emp, FDateTime dt_end) throws BizException {
		
		if(StringUtil.isEmptyWithTrim(id_ent) 
			|| StringUtil.isEmptyWithTrim(id_dep) 
			|| StringUtil.isEmptyWithTrim(dt_end.toStdString())) {
			
			throw new BizException("住院结算参数不能为空！");
		}
		//1. 判断是否母婴合并结算  且 获取就诊信息
		FBoolean isMerge =  BlParams.BLSTIP0005();
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO entNewBorn = inpPatAccImpls.getNewbornDO(id_ent);
		IpStEP stEP = new IpStEP();
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		if(FBoolean.TRUE.equals(isMerge) && entNewBorn != null){
			patiVisitDO = stEP.getPatiEntInfo(entNewBorn.getId_ent_mom());
		} else {
			patiVisitDO = stEP.getPatiEntInfo(id_ent);
		}
		//2. 获取就诊账户状态和费用审核信息
		GetFrozenAndAuditBP frozenAudit = new GetFrozenAndAuditBP();
		FArrayList2 frozenAuditList = frozenAudit.exec(patiVisitDO.getId_ent());
		if(frozenAuditList ==null || frozenAuditList.size() <= 0) {
			throw new BizException("获取患者就诊账户状态和费用审核信息失败！");
		}
		//2.1 就诊账户状态
		FBoolean entAccStatus  = (FBoolean)frozenAuditList.get(0);
		if(entAccStatus.booleanValue()) {
			throw new BizException("该患者就诊账户已被封帐，请先通知相关人员进行解封！");
		}
		//2.2费用审核情况
		BlAuditIp auditIp = (BlAuditIp)frozenAuditList.get(1);
		if(auditIp == null) {
			throw new BizException("该患者还没有完成费用审核，请先通知费用审核人员执行费用审核操作！");
		} else {
			if(StringUtil.isEmpty(patiVisitDO.getId_hp()) && !auditIp.getFg_pass_clinic().booleanValue()) {
				throw new BizException("该患者还没有完成住院费用审核，请先通知相关审核人员执行费用审核操作！");
			} else if(!StringUtil.isEmpty(patiVisitDO.getId_hp()) && !auditIp.getFg_pass_hp().booleanValue()){
				throw new BizException("该患者还没有完成医保费用审核，请先通知相关审核人员执行费用审核操作！");
			}
		}
		//3.查询本次结算对应的记账费用明细	
		String sqlQur = stEP.getSqlParam(patiVisitDO.getId_ent(), id_dep, dt_end);
		BlCgIpDO[] cgIpDOArr = this.findCgInfoByQur(sqlQur);

		//4.保存本次结算信息
		BlStIpDO[] blStIpDOArr = stEP.saveSettleDo(patiVisitDO, cgIpDOArr, dt_end, id_emp, id_dep);
		
		//5.更新记账明细表中相关结算字段
		stEP.updateCgStFields(blStIpDOArr[0],id_dep);	

		//6.如果是出院结算，修改就诊表信息
		if (!patiVisitDO.getFg_ip().booleanValue()) {
			//母婴合合并结算时，同时更新婴儿
			if(FBoolean.TRUE.equals(isMerge)){
				List<NewbornDO> list = (List<NewbornDO>)new DAFacade().findByAttrValString(NewbornDO.class, "Id_ent_mom", patiVisitDO.getId_ent(), null);
				if(list != null && !list.isEmpty()){
					for (NewbornDO newbornDO : list) {
						PatiVisitDO bbDo = stEP.getPatiEntInfo(newbornDO.getId_ent_bb());
						stEP.updateEntStFlag(bbDo);
					}
				} 
				stEP.updateEntStFlag(patiVisitDO);				
			}else {
			   stEP.updateEntStFlag(patiVisitDO);
			}
		}

		//7.修改审核记录
		stEP.updateAuditInfo(blStIpDOArr[0].getId_stip(),auditIp);

		//而外更新fg_selfpay 日照专用
		if(FBoolean.TRUE.equals(BlParams.BLSWICH0005())){
			DAFacade daf = new DAFacade();
			String sql = "update bl_cg_ip set fg_selfpay = 'N' where id_stip = '"+blStIpDOArr[0].getId_stip()+"'";
			daf.execUpdate(sql);
		}
		
		//8. 发送事件 暂时不发送 
		//this.invokeNewEvent(patiVisitDO, blStIpDOArr[0], cgIpDOArr);
		
		return blStIpDOArr[0].getId_stip();
	}
	
	public String exec (String id_ent, String id_emp, String[] idCgIps) throws BizException {
		
		if(StringUtil.isEmptyWithTrim(id_ent) 
			|| ArrayUtils.isEmpty(idCgIps) ) {
			
			throw new BizException("住院结算参数不能为空！");
		}
		IpStEP stEP = new IpStEP();
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		patiVisitDO = stEP.getPatiEntInfo(id_ent);
		//2. 获取就诊账户状态和费用审核信息
		GetFrozenAndAuditBP frozenAudit = new GetFrozenAndAuditBP();
		FArrayList2 frozenAuditList = frozenAudit.exec(patiVisitDO.getId_ent());
		if(frozenAuditList ==null || frozenAuditList.size() <= 0) {
			throw new BizException("获取患者就诊账户状态和费用审核信息失败！");
		}
		//2.1 就诊账户状态
		FBoolean entAccStatus  = (FBoolean)frozenAuditList.get(0);
		if(entAccStatus.booleanValue()) {
			throw new BizException("该患者就诊账户已被封帐，请先通知相关人员进行解封！");
		}
		//2.2费用审核情况
		BlAuditIp auditIp = (BlAuditIp)frozenAuditList.get(1);
		if(auditIp == null) {
			throw new BizException("该患者还没有完成费用审核，请先通知费用审核人员执行费用审核操作！");
		} else {
			if(StringUtil.isEmpty(patiVisitDO.getId_hp()) && !auditIp.getFg_pass_clinic().booleanValue()) {
				throw new BizException("该患者还没有完成住院费用审核，请先通知相关审核人员执行费用审核操作！");
			} else if(!StringUtil.isEmpty(patiVisitDO.getId_hp()) && !auditIp.getFg_pass_hp().booleanValue()){
				throw new BizException("该患者还没有完成医保费用审核，请先通知相关审核人员执行费用审核操作！");
			}
		}
		//3.查询本次结算对应的记账费用明细
		BlCgIpDO[] cgIpDOArr = this.findCgInfoByIds(idCgIps);

		//4.保存本次结算信息
		BlStIpDO[] blStIpDOArr = stEP.saveSettleDo(patiVisitDO, cgIpDOArr, id_emp);
		
		//5.更新记账明细表中相关结算字段
		stEP.updateCgStFields(blStIpDOArr[0],cgIpDOArr);	
		
		//6.如果是出院结算，修改就诊表信息
		boolean hasUnsettle = hasUnSettleCgs(id_ent);
		if (!hasUnsettle && !patiVisitDO.getFg_ip().booleanValue()) {
			stEP.updateEntStFlag(patiVisitDO);
		}

		//7.修改审核记录
		stEP.updateAuditInfo(blStIpDOArr[0].getId_stip(),auditIp);

		//而外更新fg_selfpay 日照专用
		if(FBoolean.TRUE.equals(BlParams.BLSWICH0005())){
			DAFacade daf = new DAFacade();
			String sql = "update bl_cg_ip set fg_selfpay = 'N' where id_stip = '"+blStIpDOArr[0].getId_stip()+"'";
			daf.execUpdate(sql);
		}
		
		//8. 发送事件 暂时不发送 
		//this.invokeNewEvent(patiVisitDO, blStIpDOArr[0], cgIpDOArr);
		
		return blStIpDOArr[0].getId_stip();
	}
	
	/**
	 * 查询住院要结算的记账费用
	 * 
	 * @param sqlQur
	 * @return
	 * @throws BizException
	 */
	private BlCgIpDO[] findCgInfoByQur(String sqlQur) throws BizException {
		IBlcgqueryRService cgService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] blcgIpDOArr = cgService.find(sqlQur, null, FBoolean.FALSE);
		return blcgIpDOArr;
	}
	
	/**
	 * 查询住院要结算的记账费用
	 * 
	 * @param sqlQur
	 * @return
	 * @throws BizException
	 */
	private BlCgIpDO[] findCgInfoByIds(String[] idCgIps) throws BizException {
		IBlcgqueryRService cgService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] blcgIpDOArr = cgService.findByIds(idCgIps, FBoolean.FALSE);
		return blcgIpDOArr;
	}
	
	/**
	 * 判断是否还有未结算的记账信息
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	private boolean hasUnSettleCgs(String idEnt) throws BizException {
		String sql = "select count(1) from bl_cg_ip where id_ent = ? and fg_st = 'N'";
		SqlParam param = new SqlParam();
		param.addParam(idEnt);
		DAFacade daf = new DAFacade();
		Integer num = (Integer) daf.execQuery(sql,param, new ColumnHandler());
		return num > 0;
	}
	
	/**
	 * 发送事件
	 * 
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public void invokeNewEvent(PatiVisitDO patiVisitDO, BlStIpDO blStIpDO,
			BlCgIpDO[] blCgIpDOArr) throws BizException {
		// 发送事件
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		blEventInfoDTO.setPatiVisitDO(patiVisitDO);
		FArrayList cgList = new FArrayList();
		Collections.addAll(cgList, blCgIpDOArr);
		blEventInfoDTO.setBlCgIpDOList(cgList);
		blEventInfoDTO.setBlStIpDO(blStIpDO);

		BlStIpEvent blStIpEvent = new BlStIpEvent();
		blStIpEvent.invokeNew(blEventInfoDTO);
	}
}
