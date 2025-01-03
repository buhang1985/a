package iih.ci.ord.s.bp;

import org.apache.cxf.common.util.StringUtils;

import iih.bd.bc.param.IBdMmParamCodeConst;
import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOQryService;
import iih.bd.utils.ContextUtils;
import iih.bd.utils.ParamUtils;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;

/*
 * 
 * 
 */
public class getMedsrvDOAndBdMMINfoBP {
	
    /**
     * 
     * @param id_srv
     * @param id_mm
     * @return
     */
	public MedSrvDO getMedsrvDOAndBdMMINfoBP(String id_srv,String id_mm,String code_entp)throws BizException{
		String paramValue = ParamUtils.GetOrgParamStringValue(ContextUtils.getOrgId(), IBdMmParamCodeConst.DRUGMCPROPMM);
		MedSrvDO  medSrvDO =  ServiceFinder.find(IMedsrvMDOQryService.class).findById(id_srv);
		if(IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(paramValue) && !StringUtils.isEmpty(id_mm)){
			if(code_entp==null)
				throw new BizException("就诊类型不能为空！");
			EmsOrDrug  drug = getDrugInfo(id_srv,id_mm,code_entp);
			if(drug != null && medSrvDO != null){
				medSrvDO.setQuan_med(drug.getQuan_med());
				medSrvDO.setId_freq(drug.getId_freq());
				//0176984: 住院医生站：开具药品时会默认带出药品维护的医嘱频率，此时医嘱频率为每日一次或者每日三次等，但是长临标志显示为临时，需要手动再次修改频率，长临标志才会更正
				medSrvDO.setSd_frequnitct(drug.getSd_frequnitct());
				medSrvDO.setFreqct(drug.getFreqct());
				medSrvDO.setFreq_name(drug.getName_freq());
				medSrvDO.setId_route(drug.getId_route());
				medSrvDO.setRoute_name(drug.getName_route());
				medSrvDO.setId_routedes(drug.getId_routedes());
				medSrvDO.setRoutedes_name(drug.getName_routedes());
				medSrvDO.setId_unit_med(drug.getId_unit_med());
				medSrvDO.setMed_name(drug.getName_unit_med());
				medSrvDO.setFg_long(drug.getFg_long());
				medSrvDO.setPri(drug.getPrice());
				String fg_use = this.getPropertyStr("Fg_use", code_entp);
				medSrvDO.setAttrVal(fg_use, drug.getFg_use());
			}
		}
		return medSrvDO;
	}
	
	/**
     * 
     * @param id_srv
     * @param id_mm
     * @return
     */
	public MedSrvDO getMedsrvDOAndBdMMINfoBP(CiEnContextDTO ctx,String id_srv,String id_mm)throws BizException{
		MedSrvDO medSrvDO = getMedsrvDOAndBdMMINfoBP(id_srv,id_mm,ctx.getCode_entp());
		//本服务定价模式
		if (IBdPrimdCodeConst.ID_PRI_SRV.equals(medSrvDO.getId_primd())) {
			medSrvDO.setPri(OrderEmsPriceUtils.calculatePrice(medSrvDO.getId_srv(), medSrvDO.getId_primd(), ctx.getId_pripat()).getPrice_ratio());
		}
		return medSrvDO;
	}
	
	
	
	private EmsOrDrug getDrugInfo(String id_srv,String id_mm,String code_entp)throws BizException{
		EmsOrDrug drug = null;
		String querySql =   getSql(code_entp);
		SqlParam param = new SqlParam();
		param.addParam(id_srv);
		param.addParam(id_mm);
		DAFacade daf = new DAFacade();
	   drug = (EmsOrDrug) daf.execQuery(querySql, param, new BeanHandler(EmsOrDrug.class));
	   return drug;
	}
	
	
	 private String  getSql(String code_entp)throws BizException{
		 
		 StringBuffer sqlSB = new StringBuffer();
			// 获取当前就诊类型对应的可使用标识
			String fg_use = this.getPropertyStr("fg_use", code_entp);
			// 获取当前就诊类型物品的绑定时机
			String id_mmbind_str = this.getMmbindPropertyStr("id_mmbind", code_entp);
			String sd_mmbind_str = this.getMmbindPropertyStr("sd_mmbind", code_entp);
		 sqlSB.append(
					" SELECT  A.id_srvtp,A.sd_srvtp,A.id_srv,A.code as code_srv, A.name as name_srv,B.id_unit_med,D.name as name_unit_med,A.sd_mmbind_op,A.sd_mmbind_er, A.fg_bl,A.id_primd as id_pri,")
		.append(" B.")
		.append(fg_use)
		.append(" as fg_use,")
		.append(" B.id_mm,B.spec as spec_mm,B.name as name_mm,B.price,B.des as des_mm,B.sup_name as name_sup,B.code as code_mm ,")
		.append(" B.id_mupkgutp,B.sd_mupkgutp,B.id_opmutp,B.sd_opmutp,B.Factor_mb,B.factor_sb as factor_cb,B.id_val,B.sd_val,B.Id_Srvskin,B.Fg_skin as fg_skintest,")
		.append(" drug.fg_highrisk,drug.id_dosage ,drug.sd_dosage ,drug.id_pharm ,drug.sd_pharm ,")
		.append(" drug.sd_pois ,drug.id_pois ,drug.id_anti ,drug.sd_anti ,drug.fg_pois ,drug.fg_anti ,B.id_mmtp,B.sd_mmtp,")
		.append(" C.id_measdoc as id_unit_sale,C.name as name_unit_sale , E.id_measdoc as id_unit_base, E.name as name_unit_base, ")
		.append(" B.quan_med,A.fg_mm,A.fg_ctm,A.id_primd id_pri,")
		.append(" B.id_boil, F1.name as name_boil, ")
		.append(" B.id_boildes,F.name as Name_boildes,")
		.append(" B.id_freq,G.name as name_freq,G.freqct,G.SD_FREQUNITCT,")
		.append(" B.id_route,H.name as name_route, ")
		.append(" B.id_routedes,I.name as name_routedes, ")
		.append(" A.eu_blmd, ")
		.append(" B.fg_skin as fg_skintest_mm,")
		.append(" G.fg_long")
 		.append(" from bd_srv A left outer join bd_mm B on A.id_srv = B.id_srv  ")
 		.append(" left outer join bd_srv_drug  drug on drug.id_srv = A.ID_SRV")
 		.append(" left outer join bd_measdoc C on B.id_unit_pkgsp=C.id_measdoc ")
 		.append(" left outer join bd_measdoc D on B.id_unit_med=D.id_measdoc")
 		.append(" left outer join bd_measdoc E on B.id_unit_pkgbase=E.id_measdoc ")
 		.append(" left outer join bd_boil_des F  on B.Id_Boildes = F.Id_Boildes ")
 		.append(" left outer join bd_boil F1  on B.Id_Boil = F1.Id_Boil ")
 		.append(" left outer join bd_freq G on G.id_freq = B.id_freq")
 		.append(" left outer join bd_route H on H.id_route = B.id_route")
					.append(" left outer join bd_route_des I on I.id_routedes = B.id_routedes")
 		.append(" WHERE  A.fg_active='Y' and B.fg_active =  'Y'  and B.ds ='0' and A.id_srv = ? and B.id_mm = ? ");
		 return sqlSB.toString();
	 }
	 
	 /**
		 * 根据就诊类型获取可使用属性/绑定属性
		 * 
		 * @param preStr
		 *            前缀
		 * @param code_entp
		 * @return
		 */
		private String getPropertyStr(String preStr, String code_entp) {

			String propertyType = null;
			switch (code_entp) {
			case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
				propertyType = "_op";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
				propertyType = "_er";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
				propertyType = "_er1";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
				propertyType = "_er2";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
				propertyType = "_ip";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
				propertyType = "_fm";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
				propertyType = "_pe";
			case IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE:
				propertyType = "_pip";
				break;
			}

			return preStr + propertyType;
		}
		private String getMmbindPropertyStr(String preStr, String code_entp) {

			String propertyType = null;
			switch (code_entp) {
			case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
				propertyType = "_op";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
				propertyType = "_er";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
				propertyType = "_er";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
				propertyType = "_er";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
				propertyType = "_ip";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
				propertyType = "_fm";
				break;
			case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
				propertyType = "_pe";
				break;
			}

			return preStr + propertyType;
		}
}
