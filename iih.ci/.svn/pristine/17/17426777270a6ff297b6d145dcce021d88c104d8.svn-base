package iih.ci.ord.s.ems.ip.assi.cp.pathgy;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.defsave.DefaultPathgyCreateOrderInfo;
import iih.ci.ord.s.ems.itf.ICalcPriModeProxy;
import iih.ci.ord.s.ems.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvExtPackage;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;

public class CpDefaultPathgyCreateOrderInfo extends DefaultPathgyCreateOrderInfo{
public StringBuilder erromsg=new StringBuilder();
	
	@Override
	protected OrdSrvDO assembleOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, BdSrvMmInfo bdSrvMmInfo) 
			throws BizException {
		try {
			return super.assembleOrderSrvInfo(ctx, orderInfo, bdSrvMmInfo);
		}catch(Exception ex) {
			this.erromsg.append(ex.getMessage());
			Logger.error(ex);		
			return this.cpassembleOrderSrvInfo(ctx, orderInfo, bdSrvMmInfo);
		}
	}
	
	private OrdSrvDO cpassembleOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, BdSrvMmInfo bdSrvMmInfo) 
			throws BizException {
			OrdSrvDO srvdo = new OrdSrvDO();
			srvdo.setId_primd(bdSrvMmInfo.getBdSrvInfo().getId_primd());
			srvdo.setPri(bdSrvMmInfo.getBdSrvInfo().getPri());
//			srvdo.setSortno(index);
			srvdo.setId_or(orderInfo.getId_or());
			srvdo.setId_orsrv(generatePks());
			srvdo.setId_pat(ctx.getId_pat());
			srvdo.setId_entp(ctx.getId_entp());
			srvdo.setCode_entp(ctx.getCode_entp());
			srvdo.setId_en(ctx.getId_en());
			srvdo.setId_srvtp(bdSrvMmInfo.getBdSrvInfo().getId_srvtp());
			srvdo.setSd_srvtp(bdSrvMmInfo.getBdSrvInfo().getSd_srvtp());
			srvdo.setId_srv(bdSrvMmInfo.getBdSrvInfo().getId_srv());
			srvdo.setName(bdSrvMmInfo.getBdSrvInfo().getName());
			srvdo.setFg_dose_anoma(null);
			if(CiOrdUtils.isEmpty(bdSrvMmInfo.getBdSrvSetItemInfo())){
				srvdo.setQuan_medu(bdSrvMmInfo.getBdSrvInfo().getQuan_med());
				srvdo.setId_medu(bdSrvMmInfo.getBdSrvInfo().getId_unit_med());
			}else{
				srvdo.setQuan_medu(bdSrvMmInfo.getBdSrvSetItemInfo().getQuan_medu());
				srvdo.setId_medu(bdSrvMmInfo.getBdSrvSetItemInfo().getId_medu());
			}
			srvdo.setId_route(bdSrvMmInfo.getBdSrvInfo().getId_route());
			srvdo.setId_routedes(bdSrvMmInfo.getBdSrvInfo().getId_routedes());
			srvdo.setId_boil(bdSrvMmInfo.getBdSrvInfo().getId_boil());
			srvdo.setId_boildes(bdSrvMmInfo.getBdSrvInfo().getId_boildes());
			srvdo.setId_freq(bdSrvMmInfo.getBdSrvInfo().getId_freq()); 
			srvdo.setId_org_srv(ctx.getId_org());
			srvdo.setId_dep_srv(ctx.getId_dep_or());
			srvdo.setId_wg_or(ctx.getId_wg_or());
			srvdo.setId_emp_srv(ctx.getId_emp_or());
			srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());

			srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
			srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			srvdo.setQuan_total_medu(this.getQuantumUtils().getUnMMQuantum(orderInfo.getDt_effe(),srvdo.getId_freq(), nUseDays, srvdo.getQuan_medu()));// 计算服务总量
			srvdo.setFg_or(bdSrvMmInfo.getBdSrvInfo().getFg_or());
			srvdo.setEu_blmd(bdSrvMmInfo.getBdSrvInfo().getEu_blmd());
			srvdo.setFg_mm(CiOrdUtils.nullHandle(bdSrvMmInfo.getBdSrvInfo().getFg_mm()));
			if(CiOrdUtils.isTrue(srvdo.getFg_mm()) && !CiOrdUtils.isEmpty(bdSrvMmInfo.getMmInfo())) {
				srvdo.setId_mm(CiOrdUtils.nullHandle(bdSrvMmInfo.getMmInfo().getId_mm()));
			}
			//if (CiOrdUtils.isEmpty(bdSrvMmInfo.getBdSrvInfo().getPri())) {
			try {
			// 映射折扣价，如果折扣价为空，则后台再查询折扣价
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), bdSrvMmInfo.getBdSrvInfo().getId_srv(),
					bdSrvMmInfo.getBdSrvInfo().getId_primd(), srvdo);
			//		} else {
			//			srvdo.setPri(bdSrvMmInfo.getBdSrvInfo().getPri());
			//			srvdo.setPri_std(bdSrvMmInfo.getBdSrvInfo().getPri());// 标准价
			//			// srvdo.setPri_ratio(bdSrvMmInfo.getBdSrvInfo().getPri_ratio());//价格系数??
			//			srvdo.setId_pripat(ctx.getEnt4BannerDTO().getId_pripat());// 患者价格分类
			//		}
			}catch(Exception ex2) {
				this.erromsg.append(ex2.getMessage());
				Logger.error(ex2);
				
			}
			OrWfDeptInfoDTO orWfDeptInfoDTO = DeptInfoUtils.GetOrWfDeptInfo(ctx, bdSrvMmInfo.getBdSrvInfo().getId_srv(), bdSrvMmInfo.getMmInfo()==null?null:bdSrvMmInfo.getMmInfo().getId_mm(),bdSrvMmInfo.getBdSrvInfo().getId_route() ,orderInfo.getId_dep_mp(),
					bdSrvMmInfo.getBdSrvInfo().getFg_long(), ctx.getFg_pres_outp(),orderInfo.getDt_effe());
			srvdo.setId_dep_mp(orWfDeptInfoDTO.getFirstid_mp_dept());
			if(CiOrdUtils.isTrue(srvdo.getFg_mm())){
				srvdo.setId_dep_wh(orWfDeptInfoDTO.getId_dept_wh());
			}
			srvdo.setFg_set(CiOrdUtils.nullHandle(bdSrvMmInfo.getBdSrvInfo().getFg_set()));
			// srvdo.setFg_indic((bdSrvMmInfo.getBdSrvInfo().getFg_hpindicjudged()));//之前关闭，现在打开了（zhangwq）//???字段类型不符合
			// srvdo.setFg_propc(CiOrdUtils.nullHandle(bdSrvMmInfo.getBdSrvInfo().getFg_propc()));
			// srvdo.setFg_self(CiOrdUtils.nullHandle(srvInfo.getFg_self()));
			// srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(null));//--
			srvdo.setNote_srv(bdSrvMmInfo.getBdSrvInfo().getDes());
			srvdo.setId_srvca(bdSrvMmInfo.getBdSrvInfo().getId_srvca());
			srvdo.setFg_bl(CiOrdUtils.nullHandle(bdSrvMmInfo.getBdSrvInfo().getFg_bl()));
			srvdo.setCode_srv(bdSrvMmInfo.getBdSrvInfo().getCode());
			// 服务来源
//			srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
			srvdo.setId_primd(bdSrvMmInfo.getBdSrvInfo().getId_primd());

			// srvdo.setId_reltp(srvInfo.getId_reltp());//2016-03-25 新增 关联类型
			// srvdo.setFg_hpindicjudged(srvInfo.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
			// srvdo.setFg_extdispense(srvInfo.getFg_extdispense());//外配药标识
			if (CiOrdUtils.isTrue(srvdo.getFg_skintest())) {
				srvdo.setSd_reltp(IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN);
			} else {
				// srvdo.setSd_reltp(srvInfo.getSd_reltp());//2016-03-25 新增 关联类型编码
			}
			// srvdo.setId_or_rel(srvInfo.getId_or_rel());//2016-03-25 新增 对应关联医嘱id
			srvdo.setFg_selfsrv(bdSrvMmInfo.getBdSrvInfo().getFg_ctm());
			if(!CiOrdUtils.isEmpty(srvdo.getId_srv()) && !srvdo.getId_srv().equals(orderInfo.getId_srv())) srvdo.setId_srv_src(orderInfo.getId_srv());
			srvdo.setQuan_total_medu(bdSrvMmInfo.getBdSrvInfo().getQuan_med());
			srvdo.setFg_selfpay(FBoolean.TRUE);//2016-07-08新增自费标识
			srvdo.setId_hp(ctx.getId_hp());// 2016-07-12新增医保相关信息
			// srvdo.setId_hpsrvtp(ctx.getId_hpsrvtp());
			// srvdo.setSd_hpsrvtp(ctx.getSd_hpsrvtp());
			// srvdo.setDes_hplimit(ctx.getLimit());

			//srvdo.setId_dep_mp(orderInfo.getId_dep_mp());
			// srvdo.setId_dep_wh(mmdo.getId_dep_wh());
			// srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(orderInfo.getId_dep_mp()));
			// srvdo.setFg_base(srvInfo.getFg_base());//???
			srvdo.setInnercode_srvca(bdSrvMmInfo.getBdSrvInfo().getSrvca_innercode());
			srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
			srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId());
			srvdo.setFg_feertnable(FBoolean.TRUE); // 可退费标识
			srvdo.setStatus(DOStatus.NEW);
			// 医嘱项目对应的物品处理???计算接口参数不符
			// if(OrSrvSplitUtil.isTrue(srvInfo.getFg_mm())){
			// if(!CiOrdUtils.isEmpty(srvInfo.getId_mm())){
			// OrdSrvMmDO ordsrvmmdo=createCiOrdSrvMmDO(srvdo,srvInfo);//??放到哪？
			//
			//
			// //2016-07-21 新增 毒麻药品服务 代办人信息核对登录处理逻辑
			// // if(CiOrdUtils.isSrvPoisonHandle(srvdto)){
			// // OrSrvAgentInfoDO orsrvagentdo=createSrvAgentInfoDO(srvdto);
			// // }
			//
			// }
			// }
			// 变动用药处理???计算接口参数不符
			// if(OrSrvSplitUtil.isTrue(srvInfo.getFg_dose_anoma())){
			// // OrdSrvDoseDO[] dosedos=getOrdSrvDoses(srvdo,srvdto);
			// // if(dosedos!=null && dosedos.length!=0){
			// // rtn.setSrvdoses(dosedos);
			// // }
			// }

			return srvdo;
		
	}

	/**
	 * 根据费用对照出来的价表信息构造医嘱服务集合
	 * 
	 * @param ctx
	 *            就诊上下文
	 * @param setSrvInfo
	 *            套服务对象
	 * @param szPriStdSrvDTO
	 *            价表集合
	 * @return 医嘱服务对象集合
	 * @throws BizException
	 */
	protected OrderSrvExtPackage CalcPriStdSrvOfOrdSrvList(CiEnContextDTO ctx, CiOrderDO orderInfo, MedSrvDO setSrvInfo,
			ICalcPriModeProxy iCalcPriModeProxy,Object uiModel) throws BizException {
        try {
        	
        	return super.CalcPriStdSrvOfOrdSrvList(ctx, orderInfo, setSrvInfo, iCalcPriModeProxy, uiModel);
	
        }catch(Exception ex) {
        	this.erromsg.append(ex.getMessage());
        	Logger.error(ex);
        	return new OrderSrvExtPackage(setSrvInfo.getId_srv(),new OrderSrvMmList());
        }
		
	}

}
