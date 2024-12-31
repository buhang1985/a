package iih.ci.ord.s.bp.orsms.lis;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.app.i.ICiapplissheetCudService;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsms.lis.cfg.EmsMergeUtils;
import iih.ci.ord.s.bp.orsms.lis.qry.CiLisOpOrSmsQry;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 临床医嘱合单列表数据生成临床医嘱合单并保存及相关处理操作BP
 */
public class CiOrSmsList2CiOrLisSheetHandleBP {

	/**
	 * 临床医嘱合单列表数据生成临床医嘱合单并保存及相关处理
	 * 
	 * @param ordersmslist
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public CiapplissheetAggDO[] exec(CiOrderDO[] ciors, List<CiLisOrSmsIoDTO> ordersmslist, CiOrSessionDO session) throws BizException {
		ICiapplissheetCudService lissheetservice = ServiceFinder.find(ICiapplissheetCudService.class);
		CiapplissheetAggDO[] aggs = createAppLisSheet(ciors, ordersmslist, session);
		return saveLissheet(aggs);
	}
	/**
	 * 保存打印申请单
	 * @param lissheet
	 * @return
	 * @throws BizException
	 */
	public CiapplissheetAggDO[] saveLissheet(CiapplissheetAggDO[] lissheet) throws BizException{
		ICiapplissheetCudService lissheetservice = ServiceFinder.find(ICiapplissheetCudService.class);
		lissheet = lissheetservice.save(lissheet);
		return lissheet;
	}
	/**
	 * 临床医嘱合单列表数据生成临床医嘱合单并保存及相关处理
	 * 
	 * @param ordersmslist
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public CiapplissheetAggDO[] createAppLisSheet(CiOrderDO[] ciors, List<CiLisOrSmsIoDTO> ordersmslist, CiOrSessionDO session) throws BizException {
		// 检验条码规则是否启用
		FBoolean isAutoUse= FBoolean.FALSE;
		try{
			isAutoUse = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_XH_CIOR0020);
		}catch(Exception ex){
			isAutoUse = FBoolean.FALSE;
		}
		// 检验条码规则自定义
		String XH_cfgParam = ParamsetQryUtil.getParaString(Context.get().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_XH_CIOR0015);
		
		if (ordersmslist == null || ordersmslist.size() == 0) {
			return null;
		}
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		
		String sql = getSQlStr(ciors[0].getId_en());
		Map<String, Object> map = CiOrdUtils.getRsMap(sql);
		List<CiapplissheetAggDO> list = new ArrayList<CiapplissheetAggDO>();
		Map<String,FDouble> orprices=getOrPrices(ciors);
		
		CiAppLisSheetDO ciAppLisSheetDO = new CiAppLisSheetDO();
		ciAppLisSheetDO.setId_en(context.getId_en());
		String[] code_cg = CiOrdUtils.generateNormNOs(ordersmslist.size(), ciAppLisSheetDO);
		int num=0;
		String[] id_appsheets = new DBUtil().getOIDs(ordersmslist.size());
		for (CiLisOrSmsIoDTO smsinfo : ordersmslist) {
	
			if (smsinfo.getCilisorinfos() != null && smsinfo.getCilisorinfos().size() > 0) {
				smsinfo.setId_ciapplissheet(id_appsheets[num]);
				CiapplissheetAggDO agg = new CiapplissheetAggDO();
				CiAppLisSheetDO liapsheet = new CiAppLisSheetDO();
				agg.setParentDO(liapsheet);
				// 唯一编码 规则 TODO
				// IBillcodeManage codeS1 = ServiceFinder.find(IBillcodeManage.class);
				// String code_cg = codeS1.getPreBillCode_RequiresNew(OrdApLabDODesc.CLASS_FULLNAME);
				
				CiLisOrInfo4Sms dto = (CiLisOrInfo4Sms) smsinfo.getCilisorinfos().get(0);
				if( context != null && (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(context.getCode_entp())
						||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(context.getCode_entp())
						||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(context.getCode_entp()))
						&& context.getSd_hptp() != null && context.getSd_hptp().startsWith("2")){
					//判断是否商报
					liapsheet.setFg_hecominsur(FBoolean.TRUE);
					liapsheet.setHecominsurinfo(context.getName_pat()+" :"+CiOrdAppUtils.getServerDateTime());
				}else{
					liapsheet.setFg_hecominsur(FBoolean.FALSE);
				}
				
				/* 
                 * 条形码规则拼接
                 * 
                 * 目前规则拼接仅用于象湖项目
                 * 
                 * History:
                 *      2020年6月8日13:39:15  restructure by mkp
                 */
                if (FBoolean.TRUE.equals(isAutoUse)&&!CiOrdUtils.isEmpty(XH_cfgParam)&&!CiOrdUtils.isEmpty(context.getCode_entp())) {
                    String[] preffixs = XH_cfgParam.split(",");
                    // 根据就诊类型匹配组织参数中的拼接内容
                    try {
                        switch (context.getCode_entp()) {
                        case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
                            liapsheet.setCode_app(preffixs[0].concat(code_cg[num]));
                            break;
                        case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
                            liapsheet.setCode_app(preffixs[1].concat(code_cg[num]));
                            break;
                        case IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE:
                            liapsheet.setCode_app(preffixs[2].concat(code_cg[num]));
                            break;
                        default:
                            liapsheet.setCode_app(code_cg[num]);
                            break;
                        }   
                    } catch (IndexOutOfBoundsException e) {
                        throw new BizException("数组越界。\n请检查组织参数【检验条码规则自定义 - XH_CIOR0015 】是否配置完整。\n参数格式: 门诊,住院,预住院，如: 21,22,23");
                    }
                } else {
                    liapsheet.setCode_app(code_cg[num]);
                }

				liapsheet.setId_ciapplissheet(id_appsheets[num]);
				liapsheet.setId_di(dto.getOrlisapdo().getId_di());
				liapsheet.setId_diitm(dto.getOrlisapdo().getId_diitm());
				liapsheet.setStr_id_diitm(dto.getOrlisapdo().getStr_id_diitm());
				liapsheet.setStr_code_di(dto.getOrlisapdo().getStr_code_di());
				liapsheet.setStr_name_di(dto.getOrlisapdo().getStr_name_di());
				liapsheet.setName_diag(dto.getOrlisapdo().getName_diag());
				liapsheet.setId_group(dto.getOrdo().getId_grp());
				liapsheet.setId_org(dto.getOrdo().getId_org());
				liapsheet.setDt_plan(dto.getOrlisapdo().getDt_plan());

				liapsheet.setFg_urgent(dto.getOrdo().getFg_urgent());
				liapsheet.setId_org_app(dto.getOrdo().getId_org_or());
				liapsheet.setId_dep_app(dto.getOrdo().getId_dep_or());
				liapsheet.setFg_prn(dto.getOrlisapdo().getFg_prn());
				liapsheet.setCnt_prn(dto.getOrlisapdo().getCnt_prn());

				liapsheet.setFg_hp_pres(FBoolean.FALSE);// C.fg_maj,C.fg_fundpay,
				String fg_maj = CiOrdUtils.nullHandle(map.get("fg_maj"));
				String fg_fundpay = CiOrdUtils.nullHandle(map.get("fg_fundpay"));
				//判断是否医保就诊
				if (fg_maj != null && fg_maj.equals("Y") && fg_fundpay != null && fg_fundpay.equals("Y"))
				{
					liapsheet.setFg_hp_pres(FBoolean.TRUE);
					//0184069：开立检验“血浆乳酸测定”，点击“打印”缺少医保标志。
					//判断当前检验医嘱单是否为医保医嘱
					if(ciors[0].getFg_orhp() != null && ciors[0].getFg_orhp().isValue()){
						liapsheet.setFg_lishp(FBoolean.TRUE);
					}
				}
				liapsheet.setId_emp_app(dto.getOrdo().getId_emp_or());
				liapsheet.setDt_app(dto.getOrlisapdo().getCreatedtime());
				liapsheet.setId_pat(dto.getOrdo().getId_pat());
				liapsheet.setId_entp(dto.getOrdo().getId_entp());
				liapsheet.setCode_entp(dto.getOrdo().getCode_entp());
				liapsheet.setId_en(dto.getOrdo().getId_en());
				liapsheet.setFg_bb(dto.getOrdo().getFg_bb());
				liapsheet.setNo_bb(dto.getOrdo().getNo_bb());
				liapsheet.setFg_opspecial(FBoolean.FALSE);//特殊病
				String ur = CiOrdUtils.nullHandle(map.get("sd_svrtp"));
				if (ur != null && ur.equals(CiLisOrSmsUtils.CILISOR_SMS_SPECIAL))
					liapsheet.setFg_opspecial(FBoolean.TRUE);
				liapsheet.setAnnouncements(smsinfo.getAnnouncements());
				liapsheet.setSampcolplace(null);            //需要业务上进一步确认如何赋值
				liapsheet.setId_sampcoltime(dto.getOrlisapdo().getId_sampcoltime());
				liapsheet.setLen_sampcoltime(dto.getOrlisapdo().getLen_sampcoltime());
				liapsheet.setId_sampcollecttimetp(dto.getOrlisapdo().getId_sampcollecttimetp());
				liapsheet.setSd_sampcollecttimetp(dto.getOrlisapdo().getSd_sampcollecttimetp());
				liapsheet.setId_unit_sampcoltime(dto.getOrlisapdo().getId_unit_sampcoltime());
				liapsheet.setStatus(DOStatus.NEW);
				liapsheet.setId_samptp(smsinfo.getId_samptp());
				liapsheet.setSd_samptp(smsinfo.getSd_samptp());
				liapsheet.setId_dep_mp(dto.getOrdo().getId_dep_mp());
				
				if (session != null)
					liapsheet.setId_session(session.getId_ciorsession());
				FArrayList2 fa = smsinfo.getCilisorinfos();
				CiAppLisSheetOrDO[] aplist = new CiAppLisSheetOrDO[fa.size()];
				FDouble sheetprice=FDouble.ZERO_DBL;
				int i = 0;
				FBoolean vipflag=FBoolean.FALSE;
				for (Object o : fa) {
					CiLisOrInfo4Sms t = (CiLisOrInfo4Sms) o;
					CiAppLisSheetOrDO ap = new CiAppLisSheetOrDO();
					ap.setId_or(t.getOrdo().getId_or());
					ap.setId_ciapplissheet(id_appsheets[num]);
					ap.setId_orlab(t.getOrlisapdo().getId_orlab());
					ap.setAmt_app(orprices.get(t.getOrdo().getId_or()));
					sheetprice=sheetprice.add(orprices.get(t.getOrdo().getId_or()));
					ap.setStatus(DOStatus.NEW);
					aplist[i] = ap;
					if(t.getOrdo().getFg_vip().booleanValue()==true){
						vipflag=t.getOrdo().getFg_vip();
					}
					i++;
				}
				//赋vip标志
				liapsheet.setFg_vip(vipflag);
				liapsheet.setAmt_app_total(sheetprice);
				agg.setCiAppLisSheetOrDO(aplist);
				list.add(agg);

			}
			num++;
		}
		CiapplissheetAggDO[] aggs = list.toArray(new CiapplissheetAggDO[list.size()]);
		return aggs;
	}
	/**
	 * 获得 SQL串
	 * 
	 * @param id_en
	 * @return
	 */
	private String getSQlStr(String id_en) {
		CiLisOpOrSmsQry qry = new CiLisOpOrSmsQry(id_en);
		return qry.getQrySQLStr();
	}
	
	/**
	 * 获取医嘱总价
	 * @throws BizException 
	 */
	
	private Map<String,FDouble> getOrPrices(CiOrderDO[] ciors) throws BizException{
		
		return EmsMergeUtils.GetOrdPriceMap(ciors);
	}

}
