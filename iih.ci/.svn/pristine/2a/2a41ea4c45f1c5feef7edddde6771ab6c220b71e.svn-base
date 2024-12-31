package iih.ci.ord.s.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOQryService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.sc.apt.out.ci.d.ScAddApplInParamDTO;
import iih.sc.apt.out.i.ISc4CiCmdService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * Copyright © 2018 北大医疗信息技术有限公司 PKU healthcare IT solution Co. Ltd
 * @author 作者 lizheng:
 * @version 创建时间：2018年8月14日 上午10:28:39
 * 
 * 
 * 类说明
 */

public class CiOrderRisInfoToScAptApplBp {
	
	/**
	 * 调用SC接口向sc回写医技申请单信息
	 * @param orders
	 * @throws BizException
	 */
	public void sendCiOrderRisInfoToScAptAppl(CiOrderDO[] orders,String sd_hptp) throws BizException{
		if (CiOrdUtils.isEmpty(orders)) return;
		
		ISc4CiCmdService isc4cicmdservice = ServiceFinder.find(ISc4CiCmdService.class);
		
        //查询并返回医嘱ID及其对应的检查合单打印申请单号。key：ID_OR，医嘱ID，value：CODE_APP，如果有多个则用逗号连接
        Map<String, String> risSheetCodeMap = queryRisOrderSheetCode(orders);
        
        //根据【管理单据派生医嘱关联关系CI_APP_DIRIVE_OR_REL】获得id_or和id_app的关系。
        Map<String, String> orId2AppIdMap = queryOrId2AppIdMap(orders);
        
		for (CiOrderDO ciOrderDO : orders) {
			if(ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS) 
					|| ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS) 
					|| ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){
				Object obj = null;
				if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
					//ICiorapppathgyMDORService iciorapppathgymdorservice = ServiceFinder.find(ICiorapppathgyMDORService.class);
					//OrdApPathgyDO[] ordApPathgys = iciorapppathgymdorservice.find("id_or='"+ciOrderDO.getId_or()+"'", null, FBoolean.FALSE);
					//if(!ArrayUtil.isEmpty(ordApPathgys)){
						
					//}
				} else {
					ICiorapprisRService iciorapprisrservice = ServiceFinder.find(ICiorapprisRService.class);
					OrdApObsDO[] ordApObs = iciorapprisrservice.find("id_or='"+ciOrderDO.getId_or()+"'", null, FBoolean.FALSE);
					if(!ArrayUtil.isEmpty(ordApObs)){
						obj = ordApObs[0];
					}
				}
				String id_srv = getFgsetIdsrv(ciOrderDO);
				boolean isSelfPay = this.isSelfPay(ciOrderDO);
				
				ScAddApplInParamDTO scaddapplinparamdto = new ScAddApplInParamDTO();
				// 合单打印单号赋值
				String appCode = orId2AppIdMap.get(ciOrderDO.getId_or());
				if (StringUtils.isEmpty(appCode)) {
					scaddapplinparamdto.setMultor_apply_no(risSheetCodeMap.get(ciOrderDO.getId_or()));
				} else {
					scaddapplinparamdto.setMultor_apply_no(appCode);
				}
                
				handleRiscApt(ciOrderDO,scaddapplinparamdto,obj,sd_hptp,isSelfPay,id_srv);
				
				isc4cicmdservice.addScAptAppl(scaddapplinparamdto);
			}
		}
	}
	/**
	 * 
	 * @param ord
	 * @throws BizException
	 */
	private String getFgsetIdsrv(CiOrderDO ord) throws BizException {
		if(ord != null && FBoolean.TRUE.equals(ord.getFg_set()) && ord.getId_or() != null) {
		  StringBuffer sql = new StringBuffer();
		  sql.append(" select orsrv.id_srv")
		  .append(" from ci_or_srv orsrv left join ci_order cior on orsrv.id_or = cior.id_or")
		  .append(" where orsrv.fg_or = 'Y'")
		  .append(" and orsrv.id_or = ?")
		  .append(" and orsrv.id_srv != cior.id_srv")
		  .append(" order by orsrv.sortno asc");
		  SqlParam param = new SqlParam();
		  param.addParam(ord.getId_or());
		  List<String> list = (List<String>)(new DAFacade()).execQuery(sql.toString(),param,  new ColumnListHandler());
		  if(list != null && list.size() >0) {
			  return list.get(0);
		  }
		}
		return null;
	}
	/**
	 * 是否不计费医嘱
	 * @param ord
	 * @return
	 * @throws BizException
	 */
	private boolean isFree(CiOrderDO ord)throws BizException{
		if(ord != null && FBoolean.FALSE.equals(ord.getFg_set()) && ord.getId_or() != null) {
			IMedsrvMDOQryService imedsrvmdoqryservice = ServiceFinder.find(IMedsrvMDOQryService.class);
			MedSrvDO medsrv = imedsrvmdoqryservice.findById(ord.getId_srv());
			if(medsrv != null && IBdPrimdCodeConst.ID_PRI_FREE.equals(medsrv.getId_primd())){
				return true;
			}
		}
		return false;
	}
	/**
	 * 获取医嘱费用项是否医保
	 * @param ord
	 * @return
	 * @throws BizException
	 */
	private boolean isSelfPay(CiOrderDO ord) throws BizException{
		if(ord != null && !StringUtil.isEmpty(ord.getId_or())){
			StringBuffer sql = new StringBuffer();
			//检查检验 有一个项目是非自费 就是医保
			sql.append(" select count(1) from ci_or_srv where fg_bl = 'Y' and fg_selfpay = 'N' and id_or = ?");
			SqlParam param = new SqlParam();
			param.addParam(ord.getId_or());
			 List<Integer> list = (List<Integer>)(new DAFacade()).execQuery(sql.toString(),param,  new ColumnListHandler());
			 int count = 0;
			  if(list != null && list.size() >0) {
				  count = list.get(0);
			  }
			  if(count > 0){
				  return true;
			  }
			  return false;
		}
		return true;
	}
	/**
	 * 
	 * @param ord
	 * @param param
	 * @throws BizException 
	 */
	private void handleRiscApt(CiOrderDO ord, ScAddApplInParamDTO param,Object obj,String sd_hptp,boolean isSelfPay,String id_srv) throws BizException{
		param.setId_or(ord.getId_or());
		param.setApplyno(ord.getApplyno());
		param.setContent_or(ord.getContent_or());
		if(obj != null){
			if(obj instanceof OrdApObsDO){
				OrdApObsDO ordApObsDO = (OrdApObsDO) obj;
				param.setD_begin(ordApObsDO.getDt_plan().getDate());
			}
		}else{
			param.setD_begin(ord.getDt_effe().getDate());
		}
		param.setDt_effe_or(ord.getDt_effe());
		param.setDes_or(ord.getDes_or());
		//param.setDt_appl(aggDO.getParentDO().getDt_plan());
		param.setFg_urgent(ord.getFg_urgent());
		param.setId_ent(ord.getId_en());
		if(StringUtil.isEmpty(id_srv)){
			param.setId_srv(ord.getId_srv());
		}else{
		param.setId_srv(id_srv);
		}
		param.setName_or(ord.getName_or());
		param.setId_dep_mp(ord.getId_dep_mp());
		param.setId_dep_appl(ord.getId_dep_sign()); 
		param.setId_emp_appl(ord.getId_emp_sign()); 
		param.setSd_sctp(IScDictCodeConst.SD_SCTP_MT);//医技
		param.setSd_aptmd(EuAptmd.APPL.toString());
		param.setSd_sys_from(IScDictCodeConst.SD_SYS_FROM_IIH);
		param.setId_entp(ord.getId_entp());//就诊类型id
		param.setCode_entp(ord.getCode_entp());
		//添加科研标识
		param.setCode_or(ord.getCode_or());
		param.setFg_research(ord.getFg_research());
		param.setCode_researchproject(ord.getCode_researchproject());
		//是否医保支付 非科研的 费用标识为Y 自费标识全为N的 —— 科研的全是自费
		if(ord.getFg_research() != null && !ord.getFg_research().booleanValue() && isSelfPay){
			param.setFg_hp(FBoolean.TRUE);
		}else{
			param.setFg_hp(FBoolean.FALSE);
		}
		if(!StringUtil.isEmpty(sd_hptp) && sd_hptp.startsWith("2")){
			param.setFg_bl(FBoolean.TRUE);
		}else{
			param.setFg_bl(FBoolean.FALSE);
		}
		// 判断是不计费服务则申请单插入时标记为已计费
		boolean isFree = this.isFree(ord);
		if(isFree){
			param.setFg_bl(FBoolean.TRUE);
		}
	}
	
	/**
     * 查询医嘱对应的检查合单打印申请单号
     * @param orders
     * @throws DAException
     */
    @SuppressWarnings("unchecked")
    private Map<String, String> queryRisOrderSheetCode(CiOrderDO[] orders) throws DAException {
        Map<String, String> risSheetCodeMap = new HashMap<>();
        
        StringBuilder inParam = new StringBuilder();
        for (CiOrderDO order : orders) {
            inParam.append(",'" + order.getId_or() + "'");
        }
        
        StringBuilder sql = new StringBuilder();
        sql.append(" select risor.ID_OR, listagg(ris.CODE_APP, ',') within group (order by ris.CODE_APP ) code_app")
           .append(" from ci_app_ris ris")
           .append("          left join ci_app_ris_or risor on ris.ID_CIAPPRISSHEET = risor.ID_CIAPPRISSHEET")
           .append(" where risor.ID_OR in (" + inParam.substring(1) + ")")
           .append(" group by risor.ID_OR");
        
        List<Map<String, String>> results =  (List<Map<String, String>>) new DAFacade().execQuery(sql.toString(), new MapListHandler());
        if (results != null) {
            for (Map<String, String> result : results) {
                String id_or = result.get("id_or");
                String code_app = result.get("code_app");
                risSheetCodeMap.put(id_or, code_app);
            }
        }
        return risSheetCodeMap;
    }
	
    /**
     * 根据【管理单据派生医嘱关联关系CI_APP_DIRIVE_OR_REL】获得id_or和code_app的关系。
     * 
     * @param orders	医嘱DO集合
     * @return map key: id_or, value: code_app
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	private Map<String, String> queryOrId2AppIdMap(CiOrderDO[] orders) throws BizException {
    	//id_or和code_app的map集合
    	Map<String, String> orId2AppIdMap = new HashMap<>();
    	
    	StringBuilder inSql = new StringBuilder();
    	SqlParam params = new SqlParam();
    	for (CiOrderDO ciOrderDO : orders) {
    		inSql.append(",?");
    		params.addParam(ciOrderDO.getId_or());
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("select b.id_relor, a.code_app ")
    	  .append("from ci_app_ris a ")
    	  .append("left join ci_app_dirive_or_rel b on b.id_app = a.id_ciapprissheet ")
    	  .append("where b.id_relor in (" + inSql.toString().substring(1) + ") ");
    	List<Map<String, String>> rst =  (List<Map<String, String>>) new DAFacade().execQuery(sb.toString(), params, new MapListHandler());
    	for (Map<String, String> temp : rst) {
    		orId2AppIdMap.put(temp.get("id_relor"), temp.get("code_app"));
    	}
    	return orId2AppIdMap;
    }
}
