package iih.bl.cc.s.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blcc.i.IBlccCudService;
import iih.bl.cc.ep.CcEP;
import iih.bl.cc.service.i.IBLCcMaintainService;
import iih.bl.cc.service.i.IBLCcQueService;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 住院自动结账定时任务
 * @author ly 2018/04/23
 * @review by yangyang 2018-06-25
 */
public class BlCcIpAutoSettleAccountPlugin implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		
		// 1.获取当前时间 有为结账的非IIH端的收取的费用的人员数据
		// 获取当前时间
		FDateTime fdTime = AppUtils.getServerDateTime();
		Map<String, Object> map = arg0.getKeyMap();
		Object cctime = map.get("cctime");// 结账时间
		
		FBoolean fgCrossDay = FBoolean.valueOf((String)map.get("crossday"));//是否跨天
		if(FBoolean.TRUE.equals(fgCrossDay)){
			fdTime = fdTime.getDateTimeBefore(1);
		}	
		if (cctime != null && !StringUtil.isEmpty(cctime.toString())) {
			// 设置当前日期与传入的时间为结算时间
			fdTime = new FDateTime(fdTime.getDate().toString() + " " + cctime);
		}	
		String pttp = (String)map.get("pttp");
		
		//没有结账数据时是否产生一条结账（bl_cc）数据
		FBoolean fgEmptyCC = FBoolean.valueOf((String)map.get("createblcc")) ;
		//参数-结账人员
		String strPsndoc = (String)map.get("blccpsn");
		//参数-组织id
		String idorg = (String)map.get("idorg");
		String idgrp = (String)map.get("idgrp");
		
		PreAlertObject retObj = new PreAlertObject();
		PsnDocDO[] ccPsn = getCcPsn(fdTime,pttp);

		BLTaskLogger.info("自动住院结账任务开始");
		
		if (ArrayUtil.isEmpty(ccPsn)&& FBoolean.FALSE.equals(fgEmptyCC)) {
			BLTaskLogger.info("自动住院结账结账任务结束,未查询到待结账人员。");
			return retObj;
		}
		
		// 创建服务
		IBLCcQueService ccQueService = ServiceFinder.find(IBLCcQueService.class);
		IBLCcMaintainService ccMaService = ServiceFinder.find(IBLCcMaintainService.class);
		IBlccCudService blccService = ServiceFinder.find(IBlccCudService.class);
		
		//参与此次结账人员id
		List<String> psnCC= new ArrayList<String>();
		//取住院结账类型
		List<String> sdCctpList= new ArrayList<String>();
		FBoolean bBlcc= FBoolean.FALSE; //是否结过账
		// 2.循环获取出的人员数据 获取待结账数据
		for (PsnDocDO psnDo : ccPsn) {

			BLTaskLogger.info(String.format("人员%s(%s)自动结账开始", psnDo.getName(), psnDo.getCode()));
			Context.get().setGroupId(psnDo.getId_group());
			Context.get().setOrgId(psnDo.getId_org());
			Context.get().setStuffId(psnDo.getId_psndoc());
			Context.get().setDeptId(psnDo.getId_dep());	
			try {
				if(ListUtil.isEmpty(sdCctpList)){
					sdCctpList=this.getSd_cctp();
				}
				for(String sd_cctp :sdCctpList){
					BlccAggDO[] blccAggDOArr = ccQueService.previewChechOut(psnDo.getId_psndoc(), psnDo.getId_org(), sd_cctp, fdTime);
					if (!ArrayUtil.isEmpty(blccAggDOArr)) {
						bBlcc=FBoolean.TRUE;
						// 2.2对应 结账人员 进行结账
						BlccAggDO[] ccAgg = ccMaService.doCheckoutChange(blccAggDOArr, sd_cctp, fdTime);
						// 2.3获取结账数据后 修改结账时间为当前时间
						if (!ArrayUtil.isEmpty(ccAgg)) {
							for (BlccAggDO ccAggDO : ccAgg) {
								ccAggDO.getParentDO().setDt_cc(fdTime);
								ccAggDO.getParentDO().setStatus(DOStatus.UPDATED);
							}
							blccService.save(ccAgg);
						}				
					}
				}
				if(FBoolean.FALSE.equals(bBlcc)){
					if(!psnCC.contains(psnDo.getId_psndoc()))
						psnCC.add(psnDo.getId_psndoc());
				}
				bBlcc=FBoolean.FALSE;
			} catch (Exception e) {
				BLTaskLogger.error(String.format("人员%s(%s)自动结账失败。原因:%s",
						psnDo.getName(), psnDo.getCode(), e.getMessage()), e);
			}
			
			BLTaskLogger.info(String.format("人员%s(%s)自动结账结束", psnDo.getName(), psnDo.getCode()));
		}
		
		//对于结账参数中的人员，如果没有结账数据，则默认插入一条结账数据
		//对于结账参数中的人员，如果没有结账数据，则默认插入一条结账数据
		if(FBoolean.TRUE.equals(fgEmptyCC)&&!StringUtil.isEmpty(strPsndoc)){
			sdCctpList= new ArrayList<String>();
			String[] idPsnArr= strPsndoc.split(",");
			if(ListUtil.isEmpty(sdCctpList)&&!StringUtil.isEmpty(idorg)&&!StringUtil.isEmpty(idgrp)){
				Context.get().setOrgId(idorg);
				Context.get().setGroupId(idgrp);
				sdCctpList=this.getSd_cctp();
			}
			CcEP ccep= new CcEP();
			ccep.saveEmptyBlccAggDO(idPsnArr, sdCctpList, fdTime, psnCC);
		}
		BLTaskLogger.info("住院自动结账任务结束");
		return retObj;
	}
	
	/**
	 * 获取住院结账类型
	 * @return
	 */
	private List<String> getSd_cctp(){
		List<String> sdcctpList= new ArrayList<String>();
		String str_blcc0002=BlParams.BLCC0002();
		if(StringUtil.isEmpty(str_blcc0002)){
			return sdcctpList;
		}
		String[] sd_cctpArr= str_blcc0002.split("\\|");
		for(String sd_cctp : sd_cctpArr){
			if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp)
					||IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)){
				sdcctpList.add(sd_cctp);
			}
		}
		return sdcctpList;
	}
	
	/**
	 * 获取指定时间以前未结算的人员数据
	 * 
	 * @param fdTime
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PsnDocDO[] getCcPsn(FDateTime fdTime,String pttp) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sqlWhere = new StringBuilder();

		sqlWhere.append("SELECT DISTINCT BD_PSNDOC.ID_PSNDOC,  ");
		sqlWhere.append("BD_PSNDOC.CODE, ");
		sqlWhere.append("BD_PSNDOC.NAME, ");
		sqlWhere.append("BD_PSNDOC.ID_GROUP, ");
		sqlWhere.append("BD_PSNDOC.ID_ORG, ");
		sqlWhere.append("BD_PSNDOC.ID_DEP ");
		sqlWhere.append(" FROM BD_PSNDOC ");
		sqlWhere.append(" WHERE ID_PSNDOC IN ");
		sqlWhere.append("(SELECT ID_EMP_PAY FROM BL_PAY_PAT_IP WHERE nvl(ID_CC,'~')='~' AND DT_PAY<'");
		sqlWhere.append(fdTime.toString() + "' ");
		
		List<String> pttpSdList = new ArrayList<String>();
		
		if(!StringUtil.isEmpty(pttp)){
			String[] pttpIds = pttp.split(",");
			//查询终端数据
			List<UdidocDO> udiList = (List<UdidocDO>)daf.findByPKs(UdidocDO.class, pttpIds);
			if(!ListUtil.isEmpty(udiList)){
				for (UdidocDO udidocDO : udiList) {
					pttpSdList.add(udidocDO.getCode());
				}
			}
		}
	
		if(pttpSdList.size() > 0){
			sqlWhere.append("AND " + SqlUtils.getInSqlByIds("SD_PTTP", pttpSdList));
		}
		//sqlWhere.append("AND SD_PTTP<>'01')");
	
		sqlWhere.append(" UNION  SELECT ID_EMP_PAY  FROM BL_PREPAY_PAT  WHERE NVL(ID_CC, '~') = '~' ");
		sqlWhere.append(" AND SD_PAYTP = '12'  AND DT_PAY <'");
		sqlWhere.append(fdTime.toString() + "' ");
		
		if(pttpSdList.size() > 0){
			sqlWhere.append("AND " + SqlUtils.getInSqlByIds("SD_PTTP", pttpSdList));
		}
		
		//增加查询发票表
		if(pttpSdList.size() > 0 && pttpSdList.contains(IBlDictCodeConst.SD_PTTP_WINDOW)){
			sqlWhere.append(" UNION SELECT id_emp_inc  FROM bl_inc_ip  WHERE fg_print = 'Y' and fg_cc_out = 'N' ");
			sqlWhere.append("  and dt_inc <='");
			sqlWhere.append(fdTime.toString() + "' ");
			sqlWhere.append(" UNION SELECT id_emp_canc  FROM bl_inc_ip  WHERE fg_cc_in = 'N' ");
			sqlWhere.append("  and dt_canc <='");
			sqlWhere.append(fdTime.toString() + "' ");
		}
		sqlWhere.append(")");
		
		List<PsnDocDO> list = (List<PsnDocDO>) daf.execQuery(sqlWhere.toString(), new BeanListHandler(PsnDocDO.class));
		if (list != null)
			return list.toArray(new PsnDocDO[list.size()]);
		return null;
	}
}