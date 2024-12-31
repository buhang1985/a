package iih.bl.st.ip.s.bp;

import java.util.Arrays;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.params.BlParams;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.ep.IpStEP;
import iih.bl.st.s.bp.ip.BackPayReDoStBp;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.biz.dto.d.MiFlowType;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保结算划价
 * @author yangyang
 * @date 2018-03-28
 */
public class HpSettleBp {

	public FBoolean exec(InsureContext insureContext,String strIdEnt,String id_dep, String id_emp, FDateTime dt_end,InpPayRtnValDTO hpPayRtnValDto) throws BizException
	{		
//		if(StringUtil.isEmptyWithTrim(id_ent) 
//			|| StringUtil.isEmptyWithTrim(id_dep) 
//			|| StringUtil.isEmptyWithTrim(dt_end.toStdString())) {
//			
//			throw new BizException("住院结算参数不能为空！");
//		}
		//1. 判断是否母婴合并结算  且 获取就诊信息
		FBoolean isMerge =  BlParams.BLSTIP0005();
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO entNewBorn = inpPatAccImpls.getNewbornDO(strIdEnt);
		IpStEP stEP = new IpStEP();
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		if(FBoolean.TRUE.equals(isMerge) && entNewBorn != null){
			patiVisitDO = stEP.getPatiEntInfo(entNewBorn.getId_ent_mom());
		} else {
			patiVisitDO = stEP.getPatiEntInfo(strIdEnt);
		}
		
		//2. 获取就诊账户状态和费用审核信息
		GetAuditAndFrozenBP frozenAudit = new GetAuditAndFrozenBP();//new
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

		//9、保存分摊数据
		InsureFacade facade=new InsureFacade(insureContext);
		HisPropertyRefHpDTO hisPropertydto=new HisPropertyRefHpDTO();
		//如果是前置流程，且单据号不为空，则更新结算的单据号
		String flowType = facade.GetHpFlowType();
		if (flowType.equals(MiFlowType.PREFLOW)) {
			if(!StringUtils.isNullOrEmpty(hpPayRtnValDto.getBillcode()))
			{
				blStIpDOArr[0].setCode_st(hpPayRtnValDto.getBillcode());
				blStIpDOArr[0].setStatus(DOStatus.UPDATED);
				IBlstipCudService stIpCudService=ServiceFinder.find(IBlstipCudService.class);
				stIpCudService.save(new BlStIpDO[]{blStIpDOArr[0]});
				
			}
		}
		//分摊数据关联结算
		hisPropertydto.setId_ref(blStIpDOArr[0].getId_stip());
		//返回具体的分摊数据
		FArrayList arrayList=facade.saveHpPropData(hpPayRtnValDto,hisPropertydto);
		//8. 发送事件 暂时不发送 
		//this.invokeNewEvent(patiVisitDO, blStIpDOArr[0], cgIpDOArr);
		
		return FBoolean.TRUE;
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
	 * 根据记账主键进行结算
	 * @description:
	 * @author:hanjq  2020年7月16日
	 * @param insureContext
	 * @param strIdEnt
	 * @param id_dep
	 * @param id_emp
	 * @param dt_end
	 * @param hpPayRtnValDto
	 * @param idCgIps
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec2(InsureContext insureContext, String strIdEnt, String id_dep, String id_emp, FDateTime dt_end,
			InpPayRtnValDTO hpPayRtnValDto, String[] idCgIps) throws BizException {
		if(idCgIps == null || idCgIps.length == 0){
			throw new BizException("记账主键为空！");
		}
		//1. 判断是否母婴合并结算  且 获取就诊信息
		FBoolean isMerge =  BlParams.BLSTIP0005();
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO entNewBorn = inpPatAccImpls.getNewbornDO(strIdEnt);
		IpStEP stEP = new IpStEP();
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		if(FBoolean.TRUE.equals(isMerge) && entNewBorn != null){
			patiVisitDO = stEP.getPatiEntInfo(entNewBorn.getId_ent_mom());
		} else {
			patiVisitDO = stEP.getPatiEntInfo(strIdEnt);
		}
		
		//2. 获取就诊账户状态和费用审核信息
		GetAuditAndFrozenBP frozenAudit = new GetAuditAndFrozenBP();//new
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

		//9、保存分摊数据
		InsureFacade facade=new InsureFacade(insureContext);
		HisPropertyRefHpDTO hisPropertydto=new HisPropertyRefHpDTO();
		//如果是前置流程，且单据号不为空，则更新结算的单据号
		String flowType = facade.GetHpFlowType();
		if (flowType.equals(MiFlowType.PREFLOW)) {
			if(!StringUtils.isNullOrEmpty(hpPayRtnValDto.getBillcode()))
			{
				blStIpDOArr[0].setCode_st(hpPayRtnValDto.getBillcode());
				blStIpDOArr[0].setStatus(DOStatus.UPDATED);
				IBlstipCudService stIpCudService=ServiceFinder.find(IBlstipCudService.class);
				stIpCudService.save(new BlStIpDO[]{blStIpDOArr[0]});
				
			}
		}
		//分摊数据关联结算
		hisPropertydto.setId_ref(blStIpDOArr[0].getId_stip());
		//返回具体的分摊数据
		FArrayList arrayList=facade.saveHpPropData(hpPayRtnValDto,hisPropertydto);
		//8. 发送事件 暂时不发送 
		//this.invokeNewEvent(patiVisitDO, blStIpDOArr[0], cgIpDOArr);
		
		return FBoolean.TRUE;
	}
	
	private BlCgIpDO[] findCgInfoByIds(String[] idCgIps) throws BizException {
		IBlcgqueryRService cgService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] blcgIpDOArr = cgService.findByIds(idCgIps, FBoolean.FALSE);
		return blcgIpDOArr;
	}
}
