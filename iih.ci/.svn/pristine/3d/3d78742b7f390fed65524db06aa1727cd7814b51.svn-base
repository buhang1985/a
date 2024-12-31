package iih.ci.ord.s.ems.utils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bs.i.external.provide.IBdBsCiService;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.bdprisamp.d.BdPriSampDO;
import iih.bd.pp.bdprisamp.d.desc.BdPriSampDODesc;
import iih.bd.pp.bdprisamp.i.IBdprisampRService;
import iih.bd.srv.medsrv.d.MedSrvFitSexEnum;
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
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.DateUtils;
import iih.ci.ord.pub.d.AllergicPharmHandleMode;
import iih.ci.ord.s.bp.base.fc.GetOrMpCloseLoopTpBP;
import iih.ci.ord.s.bp.ems.save.ip.CiOrDtLastBlCal4OpenBP;
import iih.ci.ord.s.ems.meta.StringList;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class OrderUtils {
	/**
	 * 医嘱操作返回提示
	 */
	public static final String KYE_MESSAGE = "ResultMessage";
	/**
	 * 
	 */
	public static final String IsRecurs = "IsRecurs";
	
	/**
	 * 医嘱签署判断医保
	 */
	public static final String OrderHpInfo4Sign = "OrderHpInfo4Sign";
    public static final String OrderHpInfo_Checked = "OrderHpInfo_Checked";
	
    /**
     * 医嘱签署临床路径
     */
    public static final String IDors4HpOrClinpath = "IDors4HpOrClinpath";
    public static final String HpOrClinpath_Checked = "HpOrClinpath_Checked";
    /**
     * 医嘱签署特殊药判断
     */
    public static final String SpecilDrugs4Sign = "SpecilDrugs4Sign";
    public static final String SpecilDrugs_Checked = "SpecilDrugs_Checked";
    /**
     * 医嘱签署毒麻药
     */
    public static final String PoisInfoCheck4Sign = "PoisInfoCheck4Sign";
    public static final String PoisInfo_Checked = "PoisInfo_Checked";
    /**
     * 医嘱停止时间
     */
    public static final String OrderStopTime = "OrderStopTime";
    /**
     * 排斥提示
     */
    public static final String ReactMsg = "ReactMsg";
    /**
     * 错误等级
     */
    public static final String ErrorLevel_A="A";
    public static final String ErrorLevel_B="B";
    public static final String ErrorLevel_C="C";
    public static final String ErrorLevel_D="D";
    public static final String ErrorLevel_E="E";
	
	/**
	 * 获得临床医嘱结束时间信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public static  FDateTime[] getDtBeginEnd(String code_entp,FDateTime dt_begin_ui,FDateTime dt_end_ui,Integer use_days)  throws BizException{
		FDateTime[] rtn=new FDateTime[2];
		rtn[0]=dt_begin_ui;
		if(CiOrdUtils.isOpUrgentWf(code_entp)){//结束日期=开始日期
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
		if(CiOrdUtils.isOpUrgentWf(ctx.getCode_entp())){
			// 2016-09-18  打开该代码注释 
			hours=ParamsetQryUtil.getParaInt(ctx.getId_org(), ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
			if(hours<=0)
			{
				hours=24;
			}
			return DateUtils.getDateTimeAfter(dt_begin_ui,hours);
		}
		
		return null;
	}
	public static  FDateTime getDtInvalid(String code_entp, String id_org,FDateTime dt_begin_ui )  throws BizException{
		Integer hours=null;
		if(CiOrdUtils.isOpUrgentWf(code_entp)){
			// 2016-09-18  打开该代码注释 
			hours=ParamsetQryUtil.getParaInt(id_org, ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
			if(hours<=0)
			{
				hours=24;
			}
			return DateUtils.getDateTimeAfter(dt_begin_ui,hours);
		}
		
		return null;
	}
	/**
	 * 获得最近医嘱生成日期
	 * @param id_freq
	 * @param dt_effe
	 * @param firstdaytimes
	 * @return
	 * @throws BizException
	 */
	public static FDateTime getLastDt(String id_freq,FDateTime dt_effe,Integer firstdaytimes,FBoolean fg_long) throws BizException{
		CiOrDtLastBlCal4OpenBP bp=new CiOrDtLastBlCal4OpenBP();
		return bp.exec(id_freq, dt_effe, firstdaytimes,fg_long);
	}
	/**
	 * 获得医嘱闭环类型id
	 * 
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	public static String getOrCLoopTpId(CiOrderDO ordo) throws BizException {
		try {
			GetOrMpCloseLoopTpBP bp = new GetOrMpCloseLoopTpBP();
			OrpltpDO[] cltpids = bp.exec(ordo);
			if (CiOrdUtils.isEmpty(cltpids) || CiOrdUtils.isEmpty(cltpids[0]))
				return null;
			return cltpids[0].getId_orpltp();
		} catch (Exception e) {
			Logger.error(e);
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
		//Ent4BannerDTO banner = ctx.getEnt4BannerDTO();
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
		if(!CiOrdUtils.isEmpty(defv))
			return defv;
		
		//住院情形时，默认值设置
		if(CiOrdUtils.isIpWf(ctx.getCode_entp())){
			return FBoolean.TRUE;	
		}
		
		//门诊情形时，默认值设置处理
		if(CiOrdUtils.isOpWf(ctx.getCode_entp())){
			
			//非药品医嘱时
			if(!CiOrdUtils.isPharmacy(sd_srvtp)){
				return FBoolean.TRUE;
			}
			
			//草药医嘱时
			if(CiOrdUtils.isHerbOrder(sd_srvtp)){
				return FBoolean.FALSE;
			}
			// 没有给定用法，不能判断是否在院执行，默认为不在院执行
			if (CiOrdUtils.isEmpty(id_route))
			{
				return FBoolean.FALSE;
			}
			String grpableusgstr = SysParamUtils.getSysParam().getSYS_PARAM_CiPharmGrpableUsageScope().getOrgParam();
			if (CiOrdUtils.isEmpty(grpableusgstr))
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
		if (!CiOrdUtils.isEmpty(szOrdApLabDO)){
			return szOrdApLabDO;
		}
		// 检查申请单保存
		OrdApObsDO[] szOrdApObsDO = CiOrdAppUtils.getOrapprisQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApObsDO)){
			return szOrdApObsDO;
		}
		// 手术申请单保存
		CiorappsurgeryAggDO[] szCiorappsurgeryAggDO = CiOrdAppUtils.getOrappsurgeryQrytService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorappsurgeryAggDO)){
			return szCiorappsurgeryAggDO;
		}
		// 备血申请单保存
		CiorappbtAggDO[] szCiorappbtAggDO = CiOrdAppUtils.getOrappbtQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorappbtAggDO)){
			return szCiorappbtAggDO;
		}
		// 会诊申请单保存
		CiorappconsultAggDO[] szCiorappconsultAggDO = CiOrdAppUtils.getOrappconsultQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorappconsultAggDO)){
			return szCiorappconsultAggDO;
		}
		// 用血申请单保存
		OrdAppBtUseDO[] szOrdAppBtUseDO = CiOrdAppUtils.getOrappbuQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdAppBtUseDO)){
			return szOrdAppBtUseDO;
		}
		// 转科申请单保存
		OrdApTransDO[] szOrdApTransDO = CiOrdAppUtils.getOrapptransdepQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApTransDO)){
			return szOrdApTransDO;
		}
		// 出院申请单保存
		OrdApOutDO[] szOrdApOutDO = CiOrdAppUtils.getOrappoutQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApOutDO)){
			return szOrdApOutDO;
		}
		// 病理申请单保存
		CiorapppathgyAggDO[] szCiorapppathgyAggDO = CiOrdAppUtils.getOrapppathgyQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorapppathgyAggDO)){
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
			if(CiOrdUtils.isEmpty(sd_specimentp))return null;
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
			if(CiOrdUtils.isEmpty(sd_specimenvesseltp))return null;
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
			if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(entp))
				return "er";
			if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(entp))
				return "er1";
			if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(entp))
				return "er2";
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
				if (itemMainSuit != null && !CiOrdUtils.isEmpty(itemMainSuit.getContent())) {
					clinialBuffer.append("以" + itemMainSuit.getContent() + "之主诉就诊。").append(System.lineSeparator());
				}

				if (itemNowDise != null && !CiOrdUtils.isEmpty(itemNowDise.getContent())) {
					clinialBuffer.append(itemNowDise.getContent()).append(System.lineSeparator());
				}

				if (itemTest != null && !CiOrdUtils.isEmpty(itemTest.getContent())) {
					clinialBuffer.append(itemTest.getContent());
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
			.append("  from ci_order A" )
			.append("  left join ci_ap_sug B"  ) 
			.append("  on B.Id_Or = A.Id_Or"  ) 
			.append("  left join bd_udidoc C"  ) 
			.append("  on C.Id_Udidoc = B.Id_Anestp"  ) 
			.append("  where A.Fg_Canc = 'N'"  ) 
			.append("  and A.Sd_Su_Bl <> 2"  ) 
			//.append("  and C.ctrl1='0'"  )
			.append("  and A.Sd_Srvtp like '")
			.append(sd_srvtp  )
			.append("%'"  )
			.append("  and A.Id_En='" )
			.append(id_en  )
			.append("'"  );
			DAFacade daf = new DAFacade();
			return (List<CheckOpRstDTO>)daf.execQuery(sqlSB.toString(), new BeanListHandler(CheckOpRstDTO.class));
		}
		/**
		 * 判断是否工作日
		 * @param date
		 * @param workCalendarId
		 * @return
		 * @throws BizException
		 */
		public static Boolean isWordDay(FDate date,String workCalendarId) throws BizException{
			IBdBsCiService service = ServiceFinder.find(IBdBsCiService.class);
			FBoolean flag= service.isWorkDay(date, workCalendarId);
			return (CiOrdUtils.isEmpty(flag)?false:flag.booleanValue());
		}

		/**
		 * 查询医嘱状态
		 * 
		 * @param idors
		 * @return
		 * @throws BizException
		 */
		public static FMap getOrderStatus(String idors) throws BizException {
			String sqlStr = "select id_or,sd_su_or,fg_sign,fg_feertnable from ci_order where id_or in (" + idors + "))";
			List<Map<String, Object>> rst = CiOrdUtils.getRsMapList(sqlStr);
			FMap map = new FMap();
			if (rst != null && rst.size() > 0) {
				for (Map<String, Object> itm : rst) {
					map.put(itm.get("id_or").toString(), itm);
				}
			}
			return map;
		}
		/**
		 * 获得医嘱开始时间格式化处理
		 * 5分制，10分制，30分制，整点制
		 * @return
		 */
		public static FDateTime GetFormatServerDateTime() {
			String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
			FDateTime nowDate = CiOrdAppUtils.getServerDateTime();
			int point;
			try {
				point = ParamsetQryUtil.getParaInt(id_org, ICiOrdCustomSysParamConst.TL_PARAM_TIMEINTEGRATIONFORMAT);
			} catch (BizException e) {
				point = 99;
			}
			if (point == 99) {// 不取整模式
				return nowDate;
			}
			int minute = nowDate.getMinute();
			// 如果为0（整点处理）,使用60作为处理
			if (point == 0)
	        {
	            if (minute != 0)
	            {
	                return nowDate.addSeconds((-minute) * 60).addSeconds(-nowDate.getSecond());
	            }
	            else
	            {
	                return nowDate;
	            }

	        }
	        else
	        {
	            if (minute == 0)
	            {
	                return nowDate;
	            }
	            else
	            {
	                int rstMinute = (minute / point ) * point;
	                return nowDate.addSeconds((rstMinute-minute)  * 60).addSeconds(-nowDate.getSecond());
	            }
	        }
		}
		/**
		 * 校验性别
		 * @param sd_sex
		 * @param fit_sex
		 * @param name_srv
		 * @param name_srvca
		 * @throws BizException
		 */
		public static void ValidateSex(String sd_sex,Integer fit_sex,String name_srv,String sd_srvtp) throws BizException
        {
            sd_sex = (CiOrdUtils.isEmpty(sd_sex) || "0".equals(sd_sex) || "9".equals(sd_sex)) ? "0" : sd_sex;
            if (fit_sex != null && (int)MedSrvFitSexEnum.UNLIMITED != fit_sex && Integer.parseInt(sd_sex) != fit_sex)
            {
               String name_srvca = "";
               if(sd_srvtp !=null && sd_srvtp.startsWith("02")){
            	   name_srvca = "检查";
               }else if(sd_srvtp !=null && sd_srvtp.startsWith("03")){
            	   name_srvca = "检验";
               }
               throw new BizException(name_srv + "为" + (fit_sex == 1 ? "男性" : "女性") + name_srvca+ "项目，不能开立");
            }
        }
		/**
		 * 校验性别,错误信息返回
		 * @param sd_sex
		 * @param fit_sex
		 * @param name_srv
		 * @param name_srvca
		 * @throws BizException
		 */
		public static String ValidateSexMessageRst(String sd_sex,Integer fit_sex,String name_srv,String sd_srvtp) throws BizException
        {
            sd_sex = (CiOrdUtils.isEmpty(sd_sex) || "0".equals(sd_sex) || "9".equals(sd_sex)) ? "0" : sd_sex;
            if (fit_sex != null && (int)MedSrvFitSexEnum.UNLIMITED != fit_sex && Integer.parseInt(sd_sex) != fit_sex)
            {
               String name_srvca = "";
               if(sd_srvtp !=null && sd_srvtp.startsWith("02")){
            	   name_srvca = "检查";
               }else if(sd_srvtp !=null && sd_srvtp.startsWith("03")){
            	   name_srvca = "检验";
               }
               return name_srv + "为" + (fit_sex == 1 ? "男性" : "女性") + name_srvca+ "项目，不能开立";
            }
            return null;
        }
		public static FDateTime getCompareFormatServerDateTime(String id_ent) throws BizException{
			FDateTime nowDate = CiOrdAppUtils.getServerDateTime();
			if(id_ent==null||"".equals(id_ent)){
				return nowDate;
			}
			FDateTime date=GetFormatServerDateTime();
			IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
			IpBasicDTO ipBasicInfo = service.getIpBasicInfo(id_ent);
			FDateTime dt_acpt = ipBasicInfo.getDt_acpt();
			if(dt_acpt.compareTo(date)>=1){
				return dt_acpt;
			}
			return date;
		}
}
