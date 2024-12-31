package iih.ci.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bs.i.external.provide.IBdBsCiService;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.bdprisamp.d.BdPriSampDO;
import iih.bd.pp.bdprisamp.d.desc.BdPriSampDODesc;
import iih.bd.pp.bdprisamp.i.IBdprisampRService;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.desc.FreqTimeDODesc;
import iih.bd.srv.freqdef.i.IFreqTimeDORService;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ciordems.d.ext.CheckOpRstDTO;
import iih.ci.ord.ciorder.d.RefuseCheckTp;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.d.AllergicPharmHandleMode;
import iih.ci.sdk.define.ICiOrderActionConst;
import iih.ci.sdk.ems.meta.StringList;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiOrderUtils extends ICiOrderActionConst {	
	
	
	/**
	 * 获得临床医嘱结束时间信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public static  FDateTime[] getDtBeginEnd(String code_entp,FDateTime dt_begin_ui,FDateTime dt_end_ui,Integer use_days)  throws BizException{
		FDateTime[] rtn=new FDateTime[2];
		rtn[0]=dt_begin_ui;
		if(CiDwsUtils.isOpUrgentWf(code_entp)){//结束日期=开始日期
			FDateTime fd = new FDateTime();
			if(dt_end_ui== null){
				rtn[1]=fd.getDateTimeAfter(use_days);
			}else{
				rtn[1]=dt_end_ui;
			}
			
		}

		return rtn;
	}
	/**
	 * 获得医嘱过期时间
	 * @param ems
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public static  FDateTime getDtInvalid(CiEnContextDTO ctx,FDateTime dt_begin_ui )  throws BizException{
		Integer hours=null;
		if(CiDwsUtils.isOpUrgentWf(ctx.getCode_entp())){
			// 2016-09-18  打开该代码注释 
			hours=ParamsetQryUtil.getParaInt(ctx.getId_org(), ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
			if(hours<=0)
			{
				hours=24;
			}
			return CiDateUtils.getDateTimeAfter(dt_begin_ui,hours);
		}
		
		return null;
	}
	
	public static  FDateTime getDtInvalid(String code_entp, String id_org,FDateTime dt_begin_ui )  throws BizException{
		Integer hours=null;
		if(CiDwsUtils.isOpUrgentWf(code_entp)){
			// 2016-09-18  打开该代码注释 
			hours=ParamsetQryUtil.getParaInt(id_org, ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
			if(hours<=0)
			{
				hours=24;
			}
			return CiDateUtils.getDateTimeAfter(dt_begin_ui,hours);
		}
		
		return null;
	}
	/**
	 * 获取皮试结果
	 * 
	 * @param drug
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public static SkinTestRstDTO getSkinTestCheckResult(FBoolean fg_sdintest,String id_srv,String id_mm,String id_srvskin, CiEnContextDTO ctx) throws BizException {

		// 非皮试药品，不获取皮试校验结果
		if (!FBoolean.TRUE.equals(fg_sdintest)) {
			return null;
		}
		
		SkinTestParamDTO param = new SkinTestParamDTO();
		param.setId_mm(id_mm);
		param.setId_org(ctx.getId_org());
		param.setId_pi(ctx.getId_pat());
		param.setDt_birth(FDate.getDate(ctx.getDt_birth()));
		param.setId_srv(id_srv);
		param.setId_skinsrv(id_srvskin);
		return CiOrdAppUtils.getCiOrdQryService().skinTestLogicMainBP(param);
	}	
	/**
	 * 判断是否需要皮试
	 * @param id_srv
	 * @param mmdo
	 * @param ctx
	 * @return
	 * @throws BizException 
	 */
	public static FBoolean needFgSkinTest(CiEnContextDTO ctx,MeterialDO mmdo) throws BizException{
		SkinTestRstDTO rstdo=getSkinTestCheckResult(mmdo.getFg_skin(), mmdo.getId_srv(), mmdo.getId_mm(), mmdo.getId_srvskin(), ctx);
		if(rstdo.getAllergicpharmhandlemode()==AllergicPharmHandleMode.ALLERGICRESKINTEST ||
				rstdo.getAllergicpharmhandlemode()==AllergicPharmHandleMode.SKINALLERGICTEST ||
				rstdo.getAllergicpharmhandlemode()==AllergicPharmHandleMode.WAITSKINTESTRPT){
			return FBoolean.TRUE;
		}else{
			return FBoolean.FALSE;
		}
	}
	
	/**
	 *获取物品对应当前包装单位
	 * @param id_mm
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	private  Map<String,MaterialUnitDTO> getMmUnit(String[] id_mms,String code_entp) throws BizException{
		IMaterialBaseInfoService service=ServiceFinder.find(IMaterialBaseInfoService.class);
		MaterialUnitDTO[] units=service.getMMunitByEntp(id_mms, code_entp);
		Map<String,MaterialUnitDTO> unitMap=new HashMap<String,MaterialUnitDTO>();
		for(MaterialUnitDTO unit:units){//取每个物品返回数据的第一条
			if(unitMap.containsKey(unit.getId_mm()))continue;
			unitMap.put(unit.getId_mm(), unit);
		}
		return unitMap;
	}
	
	public static FDateTime getConsTimeLimit(String id_unit,int quan_time,FDateTime dt_plan){
		
		if(quan_time==0)return dt_plan;
		if (id_unit == ICiDictCodeConst.ID_MEASDOC_TIME_DD)//天
        {
			int seconsds=(quan_time - 1)*24*60*60;
			dt_plan=dt_plan.addSeconds(seconsds);
			SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			return new FDateTime(dateformat.format(dt_plan));
        }
        if (id_unit == ICiDictCodeConst.ID_MEASDOC_TIME_HH)//小时
        {
        	int seconsds=(quan_time - 1)*60*60;
            return dt_plan.addSeconds(seconsds);
        }
        if (id_unit == ICiDictCodeConst.ID_MEASDOC_TIME_MM)//分
        {
        	int seconsds=(quan_time - 1)*60;
            return dt_plan.addSeconds(seconsds);
        }
        if (id_unit == ICiDictCodeConst.ID_MEASDOC_TIME_SS)//秒
        {
        	return dt_plan.addSeconds(quan_time);
        }
        return dt_plan;
	}
	
	/**
	 * 生成主键方法
	 * @param size
	 * @return
	 */
	public static String[] GeneratePKs(int size){
		
		String[] szPK = new DBUtil().getOIDs(size);
		
		return szPK;
	}

	public static FBoolean IsMpInpatent(CiEnContextDTO ctx,String sd_srvtp, String id_route, FBoolean defv) throws BizException{
		//在院执行对象为空判断，不为空时无需设置值直接返回
		if(!ObjectUtils.isEmpty(defv))
			return defv;
		
		//住院情形时，默认值设置
		if(CiDwsUtils.isIpWf(ctx.getCode_entp())){
			return FBoolean.TRUE;	
		}
		
		//门诊情形时，默认值设置处理
		if(CiDwsUtils.isOpWf(ctx.getCode_entp())){
			
			//非药品医嘱时
			if(!sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
				return FBoolean.TRUE;
			}
			
			//草药医嘱时
			if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
				return FBoolean.FALSE;
			}
			// 没有给定用法，不能判断是否在院执行，默认为不在院执行
			if (ObjectUtils.isEmpty(id_route))
			{
				return FBoolean.FALSE;
			}
			String grpableusgstr = SysParamUtils.getSysParam().getSYS_PARAM_CiPharmGrpableUsageScope().getOrgParam();
			if (ObjectUtils.isEmpty(grpableusgstr))
				return FBoolean.FALSE;
			
			if (grpableusgstr.indexOf(id_route) >= 0)
				return FBoolean.TRUE;
				
		}
		//其他
		return FBoolean.FALSE;
	}
	
	/**
	 * 获取申清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	public static Object[] QryOrderAppSheetList(String[] szId_or) throws BizException{
		// 检验申请单保存
		OrdApLabDO[] szOrdApLabDO = CiOrdAppUtils.getOrapplisQryService().findByAttrValStrings("Id_or", szId_or);
		if (!ObjectUtils.isEmpty(szOrdApLabDO)){
			return szOrdApLabDO;
		}
		// 检查申请单保存
		OrdApObsDO[] szOrdApObsDO = CiOrdAppUtils.getOrapprisQryService().findByAttrValStrings("Id_or", szId_or);
		if (!ObjectUtils.isEmpty(szOrdApObsDO)){
			return szOrdApObsDO;
		}
		// 手术申请单保存
		CiorappsurgeryAggDO[] szCiorappsurgeryAggDO = CiOrdAppUtils.getOrappsurgeryQrytService().findByAttrValStrings("Id_or", szId_or);
		if (!ObjectUtils.isEmpty(szCiorappsurgeryAggDO)){
			return szCiorappsurgeryAggDO;
		}
		// 备血申请单保存
		CiorappbtAggDO[] szCiorappbtAggDO = CiOrdAppUtils.getOrappbtQryService().findByAttrValStrings("Id_or", szId_or);
		if (!ObjectUtils.isEmpty(szCiorappbtAggDO)){
			return szCiorappbtAggDO;
		}
		// 会诊申请单保存
		CiorappconsultAggDO[] szCiorappconsultAggDO = CiOrdAppUtils.getOrappconsultQryService().findByAttrValStrings("Id_or", szId_or);
		if (!ObjectUtils.isEmpty(szCiorappconsultAggDO)){
			return szCiorappconsultAggDO;
		}
		// 用血申请单保存
		OrdAppBtUseDO[] szOrdAppBtUseDO = CiOrdAppUtils.getOrappbuQryService().findByAttrValStrings("Id_or", szId_or);
		if (!ObjectUtils.isEmpty(szOrdAppBtUseDO)){
			return szOrdAppBtUseDO;
		}
		// 转科申请单保存
		OrdApTransDO[] szOrdApTransDO = CiOrdAppUtils.getOrapptransdepQryService().findByAttrValStrings("Id_or", szId_or);
		if (!ObjectUtils.isEmpty(szOrdApTransDO)){
			return szOrdApTransDO;
		}
		// 出院申请单保存
		OrdApOutDO[] szOrdApOutDO = CiOrdAppUtils.getOrappoutQryService().findByAttrValStrings("Id_or", szId_or);
		if (!ObjectUtils.isEmpty(szOrdApOutDO)){
			return szOrdApOutDO;
		}
		// 病理申请单保存
		CiorapppathgyAggDO[] szCiorapppathgyAggDO = CiOrdAppUtils.getOrapppathgyQryService().findByAttrValStrings("Id_or", szId_or);
		if (!ObjectUtils.isEmpty(szCiorapppathgyAggDO)){
			return szCiorapppathgyAggDO;
		}
		return null;
	}

	/**
	 * 从DO模型中回去指定字段的值信息数组
	 * @param szInfo
	 * @param attr
	 * @return
	 */
	public static <T extends BaseDO> String[] ModelAttrValues(T[] szInfo,String attr){
		StringList strList = new StringList();
		for (T info : szInfo){
			strList.add(info.getAttrVal(attr).toString());
		}
		return strList.asArray();
	}

	/**
	 * 泛型设置DO 的id_or属性
	 * 
	 * @param szAppSheet
	 * @param id_or
	 * @return
	 */
	public static <T extends BaseDO> T[] UpdateOrderAppSheet(T[] szAppSheet, String id_or) {
		for (T info : szAppSheet) {
			info.setAttrVal("Id_or", id_or);
		}
		return szAppSheet;
	}

	/**
	 * 泛型设置aggdo 的id_or属性
	 * 
	 * @param szAppSheet
	 * @param id_or
	 * @return
	 */
	public static <T extends BaseAggDO> T[] UpdateOrderAppSheet(T[] szAppSheet, String id_or) {
		for (T info : szAppSheet) {
			info.getParentDO().setAttrVal("Id_or", id_or);
		}
		return szAppSheet;
	}

	/**
	 * 获得标本类型对应的费用集合
	 * 
	 * @param sd_specimentp
	 * @param id_scope_rel
	 * @param isscopedept是否科室范围
	 * @return
	 * @throws BizException
	 */
	public static BdPriSampDO[] getSpecimenTpRelFeeSrvInfo(String sd_specimentp, String id_scope_org)
			throws BizException {
		if(ObjectUtils.isEmpty(sd_specimentp))return null;
		String tbaliasname = BdPriSampDODesc.TABLE_ALIAS_NAME;			
		BdPriSampDO[] do1 = ServiceFinder.find(IBdprisampRService.class).find(
				String.format(" %s.sd_samptp='%s' and %s.id_org='%s'", tbaliasname,sd_specimentp,tbaliasname,id_scope_org),
				"sd_samptp,sortno", FBoolean.FALSE);
		return do1;
	}

	/**
	 * 获得检验项目标本容器对应的费用集合
	 * 
	 * @param sd_specimenvesseltp
	 * @param id_org
	 * @param code_entp
	 * @param reltype
	 * @return
	 * @throws BizException
	 */
	public static Map<String, Object> getLisSrvVesselTpRelFeeSrvInfo(String sd_specimenvesseltp, String id_org,
			String code_entp) throws BizException {
		if(ObjectUtils.isEmpty(sd_specimenvesseltp))return null;
		String wherestr=String.format(" select B.Id_Srv "
		          +" from bd_srv_sani A left outer join bd_srv B ON A.Id_Srv=B.Id_Srv  "
		          +" where A.Id_Org='%s' and A.Sd_Sanitp='%s' and B.Fg_Use_%s='Y' and B.Fg_Active='Y'",id_org,sd_specimenvesseltp,getEntpFldNameStr(code_entp));
		return (Map<String, Object>) (new DAFacade().execQuery(wherestr, new MapHandler()));
	}
	
	/**
	 * 获得就诊类型对应的字段名
	 * 
	 * @param entp
	 * @return
	 */
	public static String getEntpFldNameStr(String entp) {
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entp))
			return "op";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(entp))
			return "ip";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(entp))
			return "er";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(entp))
			return "pe";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(entp))
			return "fm";

		return "";
	}
	
	/**
	 * 获取临床症状和体征
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public static String getClinicalzztzInfo(String id_ent) 
			throws BizException {
		String sql = String.format("id_ent='%s' and code_element in ('%s','%s','%s')", id_ent, ICiDictCodeConst.CODE_ELEMENT_MAINSUIT, 
				ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE, ICiDictCodeConst.CODE_ELEMENT_TEST);
		MrDocRefValueDO[] mrDocRefValueDOs = ServiceFinder.find(IMrdocrefvalueRService.class).find(sql, "", FBoolean.FALSE);
		if (mrDocRefValueDOs != null && mrDocRefValueDOs.length > 0) {
			StringBuffer clinialBuffer = new StringBuffer();
			MrDocRefValueDO itemMainSuit = null, itemNowDise = null, itemTest = null;
			for (MrDocRefValueDO mrDocRefValueDO : mrDocRefValueDOs) {
				// 主诉
				if (itemMainSuit == null && mrDocRefValueDO.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_MAINSUIT)) {
					itemMainSuit = mrDocRefValueDO;
				}
				// 现病史
				if (itemNowDise == null && mrDocRefValueDO.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE)) {
					itemNowDise = mrDocRefValueDO;
				}
				// 体格检查
				if (itemTest == null && mrDocRefValueDO.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_TEST)) {
					itemTest = mrDocRefValueDO;
				}
			}
			if (itemMainSuit != null && !ObjectUtils.isEmpty(itemMainSuit.getContent())) {
				clinialBuffer.append("主诉：" + itemMainSuit.getContent()).append(System.lineSeparator());
			}

			if (itemNowDise != null && !ObjectUtils.isEmpty(itemNowDise.getContent())) {
				clinialBuffer.append("现病史：" + itemNowDise.getContent()).append(System.lineSeparator());
			}

			if (itemTest != null && !ObjectUtils.isEmpty(itemTest.getContent())) {
				clinialBuffer.append("体格检查：" + itemTest.getContent().replace("\r", "").replace("\n", ""));
			}
			if(clinialBuffer.toString().length() > 1330){
				return clinialBuffer.toString().substring(0,1330);
			}
			return clinialBuffer.toString();
		}
		return null;
	}
	/**
	 * 获取患者入科时间
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public static FDateTime getInHosTime(String id_en) throws BizException{
		IpBasicDTO ipDto=ServiceFinder.find(IEnOutQryService.class).getIpBasicInfo(id_en);
		return ipDto.getDt_acpt();
	}
	/**
	 * 获取当次就诊下的所有手术
	 * @param id_en
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	public static List<CheckOpRstDTO> getReturnMsg(String id_en,String sd_srvtp) throws BizException{
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append("select A.Id_Or, A.Id_Srv, B.Dt_Plan, C.ctrl1 as eu_anesca" )
		.append("  from ci_order A left join ci_ap_sug B  on B.Id_Or = A.Id_Or " )
		.append("  left join bd_udidoc C on C.Id_Udidoc = B.Id_Anestp  where A.Fg_Canc = 'N'"  ) 
		.append("  and A.Sd_Su_Bl <> 2 and A.Sd_Srvtp like ? and A.Id_En=?"  ) ;
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(sd_srvtp);
		sqlParam.addParam(id_en);
		
		return (List<CheckOpRstDTO>)new DAFacade().execQuery(sqlSB.toString(), sqlParam,new BeanListHandler(CheckOpRstDTO.class));
	}
	/**
	 * 获取当次就诊下的所有有效手术
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public static Integer getTotalActivateSurgeryOrds(String id_en) throws BizException{
		//本次就诊，未作废确认的手术医嘱
		SqlParam param = new SqlParam();
		param.addParam(id_en);
		String sql = "select count(*) cnt from ci_order where id_en=? and sd_srvtp like '04%' and fg_chk_canc!='Y'";
		Map<String, Object> rst = (Map<String, Object>) (new DAFacade().execQuery(sql, param, new MapHandler()));
		
		return rst != null ? Integer.parseInt(rst.get("cnt").toString()) : 0;
	}
	/**
	 * 判断是否工作日
	 * @param date
	 * @param workCalendarId
	 * @return
	 * @throws BizException
	 */
	public static Boolean isWorkDay(FDate date,String workCalendarId) throws BizException{
		IBdBsCiService service = ServiceFinder.find(IBdBsCiService.class);
		FBoolean flag= service.isWorkDay(date, workCalendarId);
		return (ObjectUtils.isEmpty(flag)?false:flag.booleanValue());
	}

	/**
	 * 获取医嘱状态
	 * @param mapParam
	 * @return
	 * @throws BizException
	 */
	public static String[] getOrderStatus(Map<String, Object> mapParam)
			throws BizException {
		String code_entp = mapParam.containsKey("code_entp") && mapParam.get("code_entp") != null ? mapParam.get("code_entp").toString() : "";
		String sd_su_or = mapParam.containsKey("sd_su_or") && mapParam.get("sd_su_or") != null ? mapParam.get("sd_su_or").toString() : "";
		String sd_su_mp = mapParam.containsKey("sd_su_mp") && mapParam.get("sd_su_mp") != null ? mapParam.get("sd_su_mp").toString() : "";
		String eu_refusechecktp = mapParam.containsKey("eu_refusechecktp") && mapParam.get("eu_refusechecktp") != null ? mapParam.get("eu_refusechecktp").toString() : "";
		FBoolean fg_refusecheck = mapParam.containsKey("fg_refusecheck") && mapParam.get("fg_refusecheck") != null ? (FBoolean)mapParam.get("fg_refusecheck") : FBoolean.FALSE;
		FBoolean fg_stop = mapParam.containsKey("fg_stop") && mapParam.get("fg_stop") != null ? (FBoolean)mapParam.get("fg_stop") : FBoolean.FALSE;
		FBoolean fg_pres_outp = mapParam.containsKey("fg_pres_outp") && mapParam.get("fg_pres_outp") != null ? (FBoolean)mapParam.get("fg_pres_outp") : FBoolean.FALSE;
		String sd_status = "";
		String name_status = "";
		if (ICiDictCodeConst.SD_SU_OPEN.equals(sd_su_or)) {
			sd_status = ICiDictCodeConst.SD_SU_OPEN;// 开立
			name_status = "开立";
		} else if (ICiDictCodeConst.SD_SU_SIGN.equals(sd_su_or)) {
			sd_status = ICiDictCodeConst.SD_SU_SIGN;// 签署
			name_status = "签署";
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
				if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(sd_su_mp)) {
					if (fg_stop != null) {
						sd_status = ICiDictCodeConst.SD_SU_21;
						name_status = "执行中";
					} else {
						sd_status = ICiDictCodeConst.SD_SU_11;
						name_status = "未知";
					}
				}
			}
			if(ObjectUtils.isTrue(fg_refusecheck) && RefuseCheckTp.REFUSE_SIGN_CHECK.equals(eu_refusechecktp)){
				sd_status = ICiDictCodeConst.SD_SU_SIGN + RefuseCheckTp.REFUSE_SIGN_CHECK;// 拒绝确认
				name_status = "拒绝确认";
			}
		} else if (ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(sd_su_or)) {
			if (ICiDictCodeConst.SD_SU_MP_NONE.equals(sd_su_mp)) {
				if (FBoolean.FALSE.equals(fg_stop) || FBoolean.TRUE.equals(fg_pres_outp)) {
					// 出院带药不需要预停操作
					sd_status = ICiDictCodeConst.SD_SU_CHECKTHROUGH;// 确认
					name_status = "确认";
				} else if (FBoolean.TRUE.equals(fg_stop)) {
					sd_status = ICiDictCodeConst.SD_SU_22;// 确认预停
					name_status = "确认+预停";
					if(ObjectUtils.isTrue(fg_refusecheck) && RefuseCheckTp.REFUSE_STOP_CHECK.equals(eu_refusechecktp)){
						sd_status = ICiDictCodeConst.SD_SU_CHECKTHROUGH + RefuseCheckTp.REFUSE_STOP_CHECK;// 拒绝停止确认
						name_status = "拒绝停止确认";
					}
				} else {
					sd_status = ICiDictCodeConst.SD_SU_11;// 未知
					name_status = "未知";
				}
			} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(sd_su_mp)) {
				if (FBoolean.FALSE.equals(fg_stop)) {
					sd_status = ICiDictCodeConst.SD_SU_21;// 执行中
					name_status = "执行中";
				} else if (FBoolean.TRUE.equals(fg_stop) && IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
					sd_status = ICiDictCodeConst.SD_SU_23;// 预停
					name_status = "执行中+预停";
					// 是否 护士拒绝停止确认
					if(ObjectUtils.isTrue(fg_refusecheck) && RefuseCheckTp.REFUSE_STOP_CHECK.equals(eu_refusechecktp)){
						sd_status = ICiDictCodeConst.SD_SU_23 + RefuseCheckTp.REFUSE_STOP_CHECK;// 拒绝停止确认
						name_status = "拒绝停止确认";
					}
				} else {
					sd_status = ICiDictCodeConst.SD_SU_11;// 未知
					name_status = "未知";
				}
			} else if (ICiDictCodeConst.SD_SU_MP_EXEOK.equals(sd_su_mp)) {
				sd_status = ICiDictCodeConst.SD_SU_FINISH;// 完成
				name_status = "完成";
			} else if (ICiDictCodeConst.SD_SU_MP_EXECANC.equals(sd_su_mp)) {
				sd_status = ICiDictCodeConst.SD_SU_61;// 取消
				name_status = "取消";
			} else if (ICiDictCodeConst.SD_SU_MP_CANCEL.equals(sd_su_mp)) {
				sd_status = ICiDictCodeConst.SD_SU_62;// 不执行
				name_status = "不执行";
			} else {
				sd_status = ICiDictCodeConst.SD_SU_11;// 未知
				name_status = "未知";
			}
		} else if (ICiDictCodeConst.SD_SU_CHECKSTOP.equals(sd_su_or)) {
			if (FBoolean.TRUE.equals(fg_stop)) {
				if (ICiDictCodeConst.SD_SU_MP_NONE.equals(sd_su_mp)) {
					sd_status = ICiDictCodeConst.SD_SU_CHECKSTOP;
					name_status = "确认+停止";
				} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(sd_su_mp)) {
					if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
						sd_status = ICiDictCodeConst.SD_SU_21;
						name_status = "执行中";
					} else {
						sd_status = ICiDictCodeConst.SD_SU_51;
						name_status = "执行中+停止";
					}
				} else {
					sd_status = ICiDictCodeConst.SD_SU_11;// 未知
					name_status = "未知";
				}
			} else {
				sd_status = ICiDictCodeConst.SD_SU_11;// 未知
				name_status = "未知";
			}
		} else if (ICiDictCodeConst.SD_SU_FINISH.equals(sd_su_or)) {
			if (ICiDictCodeConst.SD_SU_MP_EXEOK.equals(sd_su_mp)) {
				sd_status = ICiDictCodeConst.SD_SU_FINISH;// 完成
				name_status = "完成";
			} else if (ICiDictCodeConst.SD_SU_MP_EXECANC.equals(sd_su_mp)) {
				sd_status = ICiDictCodeConst.SD_SU_61;// 取消
				name_status = "取消";
			} else if (ICiDictCodeConst.SD_SU_MP_CANCEL.equals(sd_su_mp)) {
				sd_status = ICiDictCodeConst.SD_SU_62;// 不执行
				name_status = "不执行";
			} else {
				sd_status = ICiDictCodeConst.SD_SU_11;// 未知
				name_status = "未知";
			}
		} else if (ICiDictCodeConst.SD_SU_CANCEL.equals(sd_su_or)) {
			sd_status = ICiDictCodeConst.SD_SU_CANCEL;// 作废
			name_status = "作废";
			// 是否 护士拒绝停止确认
			if(ObjectUtils.isTrue(fg_refusecheck) && RefuseCheckTp.REFUSE_CANC_CHECK.equals(eu_refusechecktp)){
				sd_status = ICiDictCodeConst.SD_SU_CANCEL + RefuseCheckTp.REFUSE_CANC_CHECK;// 拒绝作废确认
				name_status = "拒绝作废确认";
			}
		} else if (ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(sd_su_or)) {
			sd_status = ICiDictCodeConst.SD_SU_CHECKCANCEL;// 作废确认
			name_status = "已作废";
		} else {
			sd_status = ICiDictCodeConst.SD_SU_11;// 未知
			name_status = "未知";
		}
		return new String[] { sd_status, name_status };
	}
	
	/**
	 * 获取首日执行次数
	 * 
	 * @param id_freq
	 * @param dt_entry
	 * @return
	 * @throws BizException
	 */
	public static Integer getQuan_firday_mp(String id_freq, FDateTime dt_entry)
			throws BizException {
		if (StringUtils.isNullOrEmpty(id_freq) || dt_entry == null) {
			return 0;
		}
		FTime[] exctimes = getFreqTime(id_freq);
		Integer quan = 1;
		for (int i = 0; i < exctimes.length; i++) {
			
			if(quan == exctimes.length){
				return quan;
			}
			
			if (exctimes[i].after(new FTime(dt_entry.getTime()))) {
				quan++;
			}
		}
		return quan;
	}

	/**
	 * 获取频次执行时刻
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static FTime[] getFreqTime(String id_freq) throws BizException {
		FreqTimeDO[] freqTimeDOs = ServiceFinder.find(IFreqTimeDORService.class).find(
						FreqTimeDODesc.TABLE_ALIAS_NAME + ".Id_freq='" + id_freq + "'",
						FreqTimeDODesc.TABLE_ALIAS_NAME + ".Sortno", FBoolean.FALSE);
		if (freqTimeDOs != null && freqTimeDOs.length > 0) {
			FTime[] times = new FTime[freqTimeDOs.length];
			for (int i = 0; i < freqTimeDOs.length; i++) {
				times[i] = freqTimeDOs[i].getTime_mp();
			}
			return times;
		}
		return new FTime[] {};
	}
	
	
	/**
	 * 服务互斥数据进行分组处理
	 * 
	 * @param srvreacts
	 * @return
	 */
	public static Map<String, List<SrvReactDTO>> getSrvReactGrpMap(
			SrvReactDTO[] srvreacts) {
		if (srvreacts == null || srvreacts.length == 0)
			return null;
		Map<String, List<SrvReactDTO>> rtnHt = new HashMap<String, List<SrvReactDTO>>();
		List<SrvReactDTO> list = null;
		String key = "";
		for (int i = 0; i < srvreacts.length; i++) {
			// 全排斥情况处理
			if (IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL.equals(srvreacts[i]
					.getSd_reacttp())) {// 全排斥
				key = IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL;
				if (rtnHt.containsKey(key)) {
					list = rtnHt.get(key);
					list.add(srvreacts[i]);
				} else {
					list = new ArrayList<SrvReactDTO>();
					list.add(srvreacts[i]);
					rtnHt.put(key, list);
				}
			} else if (IBdSrvDictCodeConst.SD_REACTTP_GRPINEXCLUDE
					.equals(srvreacts[i].getSd_reacttp())) {// 非全排
				key = srvreacts[i].getId_srvreact();
				if (rtnHt.containsKey(key)) {
					list = rtnHt.get(key);
					list.add(srvreacts[i]);
				} else {
					list = new ArrayList<SrvReactDTO>();
					list.add(srvreacts[i]);
					rtnHt.put(key, list);
				}
			} else {// 其它

			}
		}
		return rtnHt;
	}
	
	public static String getSrvReactIdStrs(SrvReactDTO[] srvreacts) {
		// 有效性校验
		if (srvreacts == null || srvreacts.length == 0)
			return null;
		String rtn = "", id_srvreact = "";

		// 遍历
		for (int i = 0; i < srvreacts.length; i++) {
			id_srvreact = srvreacts[i].getId_srvreact();
			if (rtn.indexOf("," + id_srvreact)>=0)
				continue;
			rtn += "," + id_srvreact;
		}

		// 返回
		return rtn.substring(1);
	}
	
	/**
	 *医嘱状态值有效性校验
	 * @param sd_su_or
	 * @return
	 */
	public static boolean orStatusValidateCheck4Mod(String sd_su_or) {
		// 状态校验
		if (!(ICiDictCodeConst.SD_SU_SIGN.equals(sd_su_or)
				|| ICiDictCodeConst.SD_SU_OPEN.equals(sd_su_or)
				|| ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(sd_su_or)
				|| ICiDictCodeConst.SD_SU_CANCEL.equals(sd_su_or)
				|| ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(sd_su_or)
				|| ICiDictCodeConst.SD_SU_DOCTORSTOP.equals(sd_su_or) || ICiDictCodeConst.SD_SU_CHECKSTOP
					.equals(sd_su_or))) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param preStr 前缀
	 * @param code_entp 就诊类型
	 * @return 可使用标识
	 */
	public static String MakeUseType(String preStr, String code_entp) {

		String value = "";
		switch (code_entp) {
		case IEnDictCodeConst.SD_ENTP_OUTPATIENT:
			value = "op";
			break;
		case IEnDictCodeConst.SD_ENTP_EMERGENCY:
			value = "er";
			break;
		case IEnDictCodeConst.SD_ENTP_INPATIENT:
			value = "ip";
			break;
		case IEnDictCodeConst.SD_ENTP_HOME:
			value = "fm";
			break;
		case IEnDictCodeConst.SD_ENTP_PHYSICALEXAM:
			value = "pe";
			break;
		}

		return preStr + value;
	}
	

	/**
	 * 是否门急诊
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpUrgentWf(String sd_entp) {
		if (ObjectUtils.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp)
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(sd_entp))
			return true;
		return false;

	}

	/**
	 * 是否门诊
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpWf(String sd_entp) {
		if (ObjectUtils.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp))
			return true;
		return false;

	}

	/**
	 * 是否急诊
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isUrgentWf(String sd_entp) {
		if (ObjectUtils.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(sd_entp))
			return true;
		return false;

	}

	/**
	 * 是否住院
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isIpWf(String sd_entp) {
		if (ObjectUtils.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(sd_entp))
			return true;
		return false;
	}
}
