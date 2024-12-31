package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppRisSheetOrDO;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.obtain.ICiOrdBlRService;
import iih.ci.ord.ordext.d.HpJudgeEnum;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitlis.pku.PKUSplitConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;


/**
 * 诊断保存时更新医嘱中的保外诊断属性
 * 
 * @author HUMS
 *
 */
public class CiOrderUpdateHpCiDiBP {

	// 医嘱读写服务接口
	private ICiorderMDORService iciorderMDORService;
	private ICiorderMDOCudService iciorderMDOCudService;

	// 服务项目读写接口
	private IOrdSrvDORService iordSrvDORService;
	private IOrdSrvDOCudService iordSrvDOCudService;
	//agg 查询集合
	private   ICiorderRService iOrAggQryService;
	private ICiOrdBlRService ciOrdBlRService;

	private CiEnContextDTO context;

	public CiOrderUpdateHpCiDiBP(CiEnContextDTO context) {

		this.context = context;

		iciorderMDORService = CiOrdAppUtils.getOrQryService();
		iciorderMDOCudService = CiOrdAppUtils.getOrService();

		iordSrvDORService = CiOrdAppUtils.getOrSrvQryService();
		iordSrvDOCudService = CiOrdAppUtils.getOrSrvService();
		
		iOrAggQryService = CiOrdAppUtils.getOrAggQryService();
		ciOrdBlRService = (ICiOrdBlRService)ServiceFinder.find(ICiOrdBlRService.class);
	}
    /**
     * 开立 签署 未结算的的医嘱
     * @param id_ent
     * @return
     */
	public FBoolean getEffectiveOrder(String id_ent)throws BizException{
		String whereStr ="id_en='"+id_ent+"' and fg_orhp='N' and  fg_canc = 'N' ";
		CiorderAggDO[] aggorderDO = iOrAggQryService.find(whereStr, "sv", FBoolean.FALSE);
		List<String> idOrSrvList = getIdOrsrvID(aggorderDO);
	    //判断是否结算   【Y：已经结算， N 未结算】
	    Map<String, FBoolean> map = ciOrdBlRService.getOrSrvBlStatus(idOrSrvList.toArray(new String[idOrSrvList.size()]));
		if(IsSettleAccount(map)==FBoolean.TRUE){
			return FBoolean.TRUE;
		}else{
		   return FBoolean.FALSE;	
		}
		
	}
	
	/**
	 * 判断是否已经记账
	 * @param map
	 * @return Y 未记账， N 已记账
	 */
	private FBoolean  IsSettleAccount(Map<String, FBoolean> map){
		if(map == null)return FBoolean.FALSE;
		for(FBoolean isSettleAccount :map.values()){
			if(FBoolean.FALSE.equals(isSettleAccount)){
				return FBoolean.TRUE;
			}
		}
		return FBoolean.FALSE;
	}
	
	/**
	 *医嘱项目的集合ID
	 * @param aggorderDO
	 * @return
	 */
	private List<String> getIdOrsrvID(CiorderAggDO[] aggorderDO) {
		
		List<String> idOrSrvList = new ArrayList<String>();
		if (aggorderDO != null && aggorderDO.length > 0) {
			for (CiorderAggDO aggdo : aggorderDO) {
				if (aggdo != null && aggdo.getOrdSrvDO() != null && aggdo.getOrdSrvDO().length > 0) {
					for (OrdSrvDO ordsrvdo : aggdo.getOrdSrvDO()) {
						idOrSrvList.add(ordsrvdo.getId_orsrv());
					}
				}
			}
		}
		return idOrSrvList;
	}
	
	/**
	 * 更新开立状态医嘱、医嘱项目中的保外诊断属性
	 * 
	 * @throws BizException
	 */
	public void execUpdateOrds() throws BizException {
		/* bug 109472    该问题修改方案如下：
		1、医生站：自费诊断保存后，未结算费用、单据都应变为自费，并且提示医生进行单据重打。
		2、收费界面：增加单据是医保还是自费显示信息。

		医生站详细修改方案，自费诊断添加如下逻辑：
		E. 若药品为特殊病药，则需要将其特殊病标志设置为false
		 将未结算的医保单据修改为非医保
		A. 查询本次就诊下的医保标志为Y，费用已结算标志fg_blsettled = N的单据。
		B. 若单据为处方：
		1、将医保标志修改为N
		2、修改处方类型：将医疗保险处方笺类型调整为自费的处方类型，如门诊处方笺或急诊处方笺。其中毒麻、精一处方类型不需要变。建议改部分走处方类型分方规则来实现。
		3、修改处方标志：涉及标志为医保标志、特殊病标志
		C. 若单据为非处方：则将其医保标志设置为N
		 弹出提示信息【存在保外诊断，患者应全额自费。其中未结算的费用因此变成自费，请重打该部分单据。】 */
		List<String> idOrList = null;
		Map<String,String>  map  = new  HashMap<String,String>();//没有结算的处方主键
		Map<String,String> idOrsrvMap = new HashMap<String,String>();
		Map<String,String>  IdOrmap  = new  HashMap<String,String>();//医嘱主键
		String ciOrderwhereStr = "id_en = '" + context.getId_en() + "' and sd_su_or in ('0','10') and fg_canc = 'N'";
		CiOrderDO[] ciorders = iciorderMDORService.find(ciOrderwhereStr, "", FBoolean.FALSE);

		if (ciorders != null && ciorders.length > 0) {

			idOrList = new ArrayList<String>();
			for (CiOrderDO ciOrder : ciorders) {
				idOrList.add(ciOrder.getId_or());
				IdOrmap.put(ciOrder.getId_or(), ciOrder.getId_or());
			}
		}
		//未结算的医嘱项目更新成自费
		UpDataCiORSrvDOFgSelfPay(IdOrmap,map,idOrsrvMap);
		if (map != null && map.size() > 0) {
			// 修改处方（医保的处方）
			UpdateCipres(map);
		}
		//修改 非药品的打印类型
		updateNotDrugPrn(idOrList,idOrsrvMap);
	}

	/**
	 * 更新指定医嘱、医嘱项目的保外诊断属性
	 * 
	 * @param idOrs
	 * @throws BizException
	 */
	public void execUpdateOrds(String[] idOrs) throws BizException {

		CiOrderDO[] ciorders = iciorderMDORService.findByIds(idOrs, FBoolean.FALSE);

		if (ciorders != null && ciorders.length > 0) {
			// 更新医嘱中的医保适应症判断结果
			this.updateCiOrders(ciorders);
			// 更新服务项目中的是否自费标识为自费
			this.execUpdateOrdSrvs(idOrs);
		}
	}
	
    //更新医嘱项目的自费标志（有保外诊断时 未计算的医嘱项目）
	private void UpDataCiORSrvDOFgSelfPay(Map<String,String> IdOrmap,Map<String,String> id_presmap,Map<String,String> idOrsrvMap)throws BizException{
		if(IdOrmap != null && IdOrmap.size() >0){	
		String sql = "select id_orsrv from ci_or_srv where id_or in ("+  CiOrdUtils.getMapConveretstr2(IdOrmap) +") and fg_bl='Y'";
		DAFacade cade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<OrdSrvDO> ordSrvList = (List<OrdSrvDO>) cade.execQuery(sql, new BeanListHandler(OrdSrvDO.class));
		
		List<String> idOrSrvList = new ArrayList<String>();
		if(ordSrvList != null && ordSrvList.size() >0){
			for(OrdSrvDO ordSrv:ordSrvList){
				idOrSrvList.add(ordSrv.getId_orsrv());
		      }	
			
			//判断是否结算   【Y：已经结算， N 未结算】
		    Map<String, FBoolean> map = ciOrdBlRService.getOrSrvBlStatus(idOrSrvList.toArray(new String[idOrSrvList.size()]));
	     
		   // 获取未结算的服务集合
			String idorsrv = "id_orsrv in (" + MapToString(map) + ")";
			OrdSrvDO[] ordSrvs = iordSrvDORService.find(idorsrv, null, FBoolean.FALSE);
			String idorsql = getIdors(ordSrvs);
			if(!StringUtils.isNullOrEmpty(idorsql)){
				String idors = " id_or in ("+getIdors(ordSrvs)+")";
				CiOrderDO[] ciorders = iciorderMDORService.find(idors, null, FBoolean.FALSE);
				this.updateCiOrders(ciorders);
			}
			for (OrdSrvDO ordSrv : ordSrvs) {
				if(ordSrv.getId_pres() != null){
					id_presmap.put(ordSrv.getId_pres(), ordSrv.getId_pres());//处方主键
				}
				ordSrv.setEu_hpjudge(HpJudgeEnum.SYSTEM_JUDGE);
				ordSrv.setEu_orsrvhp(HpJudgeRstEnum.SELFPAY);
				
				ordSrv.setFg_indic(FBoolean.FALSE);
				ordSrv.setFg_selfpay(FBoolean.TRUE);
				ordSrv.setFg_specill(FBoolean.FALSE);
				ordSrv.setStatus(DOStatus.UPDATED);
				idOrsrvMap.put(ordSrv.getId_orsrv(), ordSrv.getId_orsrv());
			}			// 更新医嘱和服务项目中
			iordSrvDOCudService.save(ordSrvs);
		}
	  }
	}
	private String getIdors(OrdSrvDO[] ordSrvs){
		StringBuffer idors = new StringBuffer(); 
		if (!CiOrdUtils.isEmpty(ordSrvs)) {
			for (OrdSrvDO ordSrvDO : ordSrvs) {
				idors.append("'");
				idors.append(ordSrvDO.getId_or());
				idors.append("',");
			}
			if(idors.lastIndexOf(",")>0){
				  return idors.substring(0, idors.lastIndexOf(","));	
			}
		}
		return null;
	}
	
	private String MapToString(Map<String, FBoolean> map) {
		
		if (map == null)
			return null;
		StringBuffer sb = new StringBuffer();
		for (String key : map.keySet()) {
			if (FBoolean.FALSE.equals(map.get(key))) {
				sb.append("'");
				sb.append(key);
				sb.append("',");
			}
		}
		if (sb.lastIndexOf(",") > 0) {
			return sb.substring(0, sb.lastIndexOf(","));
		}
		return null;
	}
	
	/**
	 * 更新医嘱服务项目中自费标识改为自费
	 * 
	 * @param idOrs
	 * @throws BizException
	 */
	public void execUpdateOrdSrvs(String[] idOrs) throws BizException {

		StringBuffer buffer = new StringBuffer();
		if (idOrs != null && idOrs.length > 0) {

			// 将原医保就诊的医嘱内容修改为非医保状态
			for (String idOr : idOrs) {
				buffer.append(",'" + idOr + "'");
			}
			// 将原有的服务项目中自费标识改为自费
			String orSrvWhereStr = "id_or in (" + buffer.substring(1) + ")";
			OrdSrvDO[] ordSrvs = iordSrvDORService.find(orSrvWhereStr, null, FBoolean.FALSE);
			for (OrdSrvDO ordSrv : ordSrvs) {
				ordSrv.setFg_selfpay(FBoolean.TRUE);
				ordSrv.setFg_indic(FBoolean.FALSE);
			}

			// 更新医嘱和服务项目中
			iordSrvDOCudService.update(ordSrvs);
		}
	}

	/**
	 * 更新医嘱中相关的医保适应症状态
	 * 
	 * @param ciorders
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] updateCiOrders(CiOrderDO[] ciorders) throws BizException {

		// 将原医保就诊的医嘱内容修改为非医保状态
		for (CiOrderDO ciOrderDO : ciorders) {
			ciOrderDO.setEu_hpjudge(HpJudgeEnum.SYSTEM_JUDGE);
			ciOrderDO.setEu_orhp(HpJudgeRstEnum.SELFPAY);
			ciOrderDO.setEu_hpindicjudge(HpIndicJudgeEnum.SELFPAY);			
			ciOrderDO.setFg_orhp(FBoolean.FALSE);
			ciOrderDO.setBhpjudgerst(context.getBhpjudgerst()); // 基本医保判断结果数据信息
			ciOrderDO.setDes_bhpjudgerst(context.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述，保外诊断id串

		}

		// 更新医嘱和服务项目中
		return iciorderMDOCudService.update(ciorders);
	}
     /**
      * 开立自费诊断时修改处方 类型 处方名称，处方标识
      * @param map
      * @throws BizException
      */
	 private void UpdateCipres(Map<String,String> map)throws BizException{
		 if(map != null && map.size() >0) {
		 String id_pres = "id_pres in ( "+ CiOrdUtils.getMapConveretstr2(map) +") and  fg_hp_pres ='Y' and fg_blsettled = 'N' "; //   医保 1，  非医保 0
			if (id_pres != null) {
				// 查询要修改的处方
				CiPresDO[] ciPresDO = CiOrdAppUtils.getCiPresQryService().find(id_pres, "sv", FBoolean.FALSE);
				// 处理逻辑
				if (ciPresDO != null && ciPresDO.length > 0) {
					for (CiPresDO cipres : ciPresDO) {
												
						
						String id_prestpword = cipres.getId_prestpword();
						String sd_prestpword = cipres.getSd_prestpword();
						id_prestpword = Replace(id_prestpword,ICiDictCodeConst.ID_PRESCRIPTION_FLAG_YB); // 去掉医保
						id_prestpword = Replace(id_prestpword,ICiDictCodeConst.ID_PRESCRIPTION_FLAG_TSB); // 去掉特殊病
						cipres.setId_prestpword(id_prestpword);
						
						sd_prestpword = Replace(sd_prestpword,ICiDictCodeConst.SD_PRESCRIPTION_FLAG_YB); // 去掉医保
						sd_prestpword = Replace(sd_prestpword,ICiDictCodeConst.SD_PRESCRIPTION_FLAG_TSB); // 去掉特殊病
						cipres.setSd_prestpword(sd_prestpword);
						
						if (PKUSplitConst.SD_UDIDOC_PRESCRIPTION_YLBXCFJ.equals(cipres.getSd_prestp())) {
							
							if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(cipres.getCode_entp())) {
								// 门诊
								cipres.setName(ICiDictCodeConst.NAME_UDIDOC_PRESCRIPTION_MZCFJ);
								cipres.setId_prestp("0001Z8100000000LOMV0");
								cipres.setSd_prestp(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_MZCFJ);
							} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(cipres.getCode_entp()) || IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(cipres.getCode_entp())) {
								// 急诊
								cipres.setName(ICiDictCodeConst.NAME_UDIDOC_PRESCRIPTION_JZCFJ);
								cipres.setId_prestp("0001Z8100000000LOMV1");
								cipres.setSd_prestp(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_JZCFJ);
							}
						}
						
						cipres.setFg_hp_pres(FBoolean.FALSE);
						cipres.setStatus(DOStatus.UPDATED);
					}
				}
			 //保存修改后的处方
			 CiOrdAppUtils.getCiPresService().save(ciPresDO);
		 }
	   } 
	 }
	 /**
	  * 
	  * @param presword
	  * @param replaceword
	  * @return
	  */
	 private String Replace(String presword,String replaceword){
		 if(presword == null || presword=="")return "";
		 if(presword.indexOf(replaceword) >-1){
			 presword = presword.replace(replaceword+",","");
			 presword = presword.replace(replaceword,"");
		 }
		 return presword;
	 }
      /**
       * 修改非药品的医保标志， 检查 检验 治疗 费用清单
       * @param idOrList
       * @param map
       */
	 private void updateNotDrugPrn(List<String> idOrList,Map<String,String> map)throws BizException{
		 //检查    ci_app_ris c
		 updateCiAppRis(idOrList);
		 //病理 ci_app_pathgy
		 updateCiAppPathgy(idOrList);
		 //检验  i_app_lis e ,  ci_app_lis_or 
		 updateCiAppLis(idOrList);
		 //治疗   ci_app_treatexec  treatexec, ci_app_treatexec_or -- 治疗
		 updateCiAppTreatexec(idOrList);
		 //费用清单    ci_prn , ci_prn_item 
		 updateCiAppCiprn(map);
	 }
	 
	 @SuppressWarnings("unchecked")
	private void updateCiAppLis(List<String> idOrList)throws BizException{
 		 StringBuffer  sb = new StringBuffer();
 		 sb.append(" select e.* from ci_app_lis e"); 
 		 sb.append(" where exists (select r.id_ciapplissheet from  ci_app_lis_or r where e.id_ciapplissheet = r.id_ciapplissheet and r.id_or in ("+CiOrdUtils.ListConveretCharacterString(idOrList)+"))");
 		 sb.append(" and e.fg_hp_pres ='Y'  and  e.fg_blsettled='N'");
 		 
	     DAFacade   df = new DAFacade();
	     List<CiAppLisSheetDO> ciAppLisSheetDO = ( List<CiAppLisSheetDO>) df.execQuery(sb.toString(), new BeanListHandler(CiAppLisSheetDO.class));
	     if(ciAppLisSheetDO != null && ciAppLisSheetDO.size() >0){
	    	 for(CiAppLisSheetDO lissheetDO:ciAppLisSheetDO){
	    		 lissheetDO.setFg_lishp(FBoolean.FALSE);
	    		 //lissheetDO.setFg_specill(FBoolean.FALSE);
	    		 lissheetDO.setStatus(DOStatus.UPDATED);
	    	 }
	    	 CiOrdAppUtils.getICiapplissheetMDOCudService().save(ciAppLisSheetDO.toArray( new CiAppLisSheetDO[ciAppLisSheetDO.size()]));
	     }
	 }
	 
     @SuppressWarnings("unchecked")
	private void updateCiAppPathgy(List<String> idOrList)throws BizException{
    	 StringBuffer  sb = new StringBuffer();
    	 sb.append(" select e.* from ci_app_pathgy e "); 
 		 sb.append(" where   e.fg_hp ='Y'   and  e.fg_blsettled='N' and  e.id_or in ("+CiOrdUtils.ListConveretCharacterString(idOrList)+")  ");
	     DAFacade   df = new DAFacade();
	     List<CiAppPathgySheetDO> ciAppPathgySheetDO = (List<CiAppPathgySheetDO>) df.execQuery(sb.toString(), new BeanListHandler(CiAppPathgySheetDO.class));
		 if(ciAppPathgySheetDO != null && ciAppPathgySheetDO.size() >0){
			 for(CiAppPathgySheetDO ciAppPathgyDO:ciAppPathgySheetDO){
				 ciAppPathgyDO.setFg_hp(FBoolean.FALSE);
				 ciAppPathgyDO.setStatus(DOStatus.UPDATED);
			 }
			 CiOrdAppUtils.getICiapppathgysheetMDOCudService().save(ciAppPathgySheetDO.toArray( new CiAppPathgySheetDO[ciAppPathgySheetDO.size()] ));
		 }
	 }
     
     /**
      * 将检查打印单中保内想标识更新为自费<br/>
      * 与医保相关的都按自费逻辑更新：<br/> 
      * ci_app_ris中：fg_specill
      * ci_app_ris_or中fg_hp
      * @param idOrList 待更新的医嘱集合
      * @throws BizException
      */
	private void updateCiAppRis(List<String> idOrList) throws BizException {

		// 更新检查打印单属性集合
		String[] risSheetProps = new String[] { CiAppRisSheetDO.ID_CIAPPRISSHEET, CiAppRisSheetDO.FG_SPECILL };
		String[] risSheetOrProps = new String[] { CiAppRisSheetOrDO.ID_RISPRN_DETAIL, CiAppRisSheetOrDO.FG_ORHP };
		
		if(idOrList == null || idOrList.size() == 0){
			return ;
		}
		
		StringBuffer idOrParamBuffer = new StringBuffer();
		SqlParam param = new SqlParam();
		for (String id_or : idOrList) {
			param.addParam(id_or);
			idOrParamBuffer.append(",?");
		}

		// 未结算的并且是医保的打印单数据
		StringBuffer sb = new StringBuffer();
		sb.append("select ris.id_ciapprissheet,ris.fg_specill,risor.id_risprn_detail,risor.fg_orhp ");
		sb.append(" from ci_app_ris ris,ci_app_ris_or risor");
		sb.append(" where ris.id_ciapprissheet = risor.id_ciapprissheet and ris.fg_blsettled='N' ");
		sb.append(" and risor.fg_orhp = 'Y' and risor.id_or in(");
		sb.append(idOrParamBuffer.substring(1)).append(")");

		DAFacade df = new DAFacade();
		Object o = df.execQuery(sb.toString(), param, new MapListHandler());
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> resultMapList = (List<Map<String, Object>>) o;
		if (resultMapList.size() == 0) {
			return;
		}

		// 待更新医保标识的检查打印单主表、明细表集合
		List<CiAppRisSheetDO> risSheetList = new ArrayList<CiAppRisSheetDO>();
		List<CiAppRisSheetOrDO> risSheetOrList = new ArrayList<CiAppRisSheetOrDO>();

		for (Map<String, Object> map : resultMapList) {

			CiAppRisSheetDO ciAppRisSheet = new CiAppRisSheetDO();
			ciAppRisSheet.setId_ciapprissheet(map.get("id_ciapprissheet").toString());
			ciAppRisSheet.setFg_specill(FBoolean.FALSE);
			if (!risSheetList.contains(ciAppRisSheet)) {
				risSheetList.add(ciAppRisSheet);
			}

			CiAppRisSheetOrDO ciAppRisSheetOr = new CiAppRisSheetOrDO();
			ciAppRisSheetOr.setId_risprn_detail(map.get("id_risprn_detail").toString());
			ciAppRisSheetOr.setFg_orhp(FBoolean.FALSE);
			risSheetOrList.add(ciAppRisSheetOr);
		}

		df.updateDOArray(risSheetList.toArray(new CiAppRisSheetDO[risSheetList.size()]), risSheetProps);
		df.updateDOArray(risSheetOrList.toArray(new CiAppRisSheetOrDO[risSheetOrList.size()]), risSheetOrProps);
	}
     
     @SuppressWarnings("unchecked")
	private void updateCiAppTreatexec(List<String> idOrList)throws BizException{
    	 StringBuffer  sb = new StringBuffer();
 		 sb.append(" select treatexec.* from ci_app_treatexec  treatexec, "); 
 		 sb.append(" ci_app_treatexec_or  treatexec_or  where treatexec.id_ciapptreatexec = treatexec_or.id_ciapptreatexec ");
 		 sb.append(" and treatexec.fg_hp ='Y'  and  treatexec.fg_blsettled='N' and treatexec_or.id_or in ("+CiOrdUtils.ListConveretCharacterString(idOrList)+")  ");
	     DAFacade   df = new DAFacade();
	     List<CiAppTreatExecDO> TreatexecDO = (List<CiAppTreatExecDO>) df.execQuery(sb.toString(), new BeanListHandler(CiAppTreatExecDO.class));
		 if(TreatexecDO != null && TreatexecDO.size() >0){
			 for(CiAppTreatExecDO treatDO:TreatexecDO){
				 treatDO.setFg_hp(FBoolean.FALSE);
				 treatDO.setStatus(DOStatus.UPDATED);
			 }
			 CiOrdAppUtils.getICiapptreatexecMDOCudService().save(TreatexecDO.toArray(new CiAppTreatExecDO[TreatexecDO.size()]));
		 }
	 }
     
     private void updateCiAppCiprn(Map<String,String> map)throws BizException{
    	 StringBuffer  sb = new StringBuffer();
 		 
 		sb.append(" select ciprn.* from  ci_prn ciprn where ciprn.fg_hp ='Y' and  ciprn.fg_blsettled='N' ");
 		sb.append(" and exists (select 1 from ci_prn_item item where ciprn.id_ciprn = item.id_ciprn and item.id_biz in  ("+CiOrdUtils.getMapConveretstr2(map)+"))");
 		 
	     DAFacade   df = new DAFacade();
	     @SuppressWarnings("unchecked")
		List<CiPrnDO> ciprnDO = (List<CiPrnDO>) df.execQuery(sb.toString(), new BeanListHandler(CiPrnDO.class));
		 if(ciprnDO != null && ciprnDO.size() >0){
			for(CiPrnDO ciprn:ciprnDO){
				ciprn.setFg_hp(FBoolean.FALSE);
				ciprn.setFg_specill(FBoolean.FALSE);
				ciprn.setStatus(DOStatus.UPDATED);
			} 
			CiOrdAppUtils.getICiprintMDOCudService().save(ciprnDO.toArray(new CiPrnDO[ciprnDO.size()]));
		 }
	 }
}
