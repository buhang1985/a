package iih.ci.ord.s.bp.ems.save.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorsrvhp.d.CiOrSrvHpDO;
import iih.ci.ord.ciorsrvhp.i.ICiorsrvhpRService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.OrSrvSyncInfoDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.ems.EmsHelper;
import iih.ci.ord.s.bp.exception.CiOrSetMemCntAddPriMdSrvNullException;
import iih.ci.ord.s.bp.exception.CiOrSetMemCntPriMdSrvNullException;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPriceCalBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/*
 * 临床医嘱服务套开立模式服务处理操作BP
 */
public class CiOrSrvSetHandle4OrModeBP {
	/**
	 * 临床医嘱服务套开立模式服务处理
	 * @param ciord
	 * @param ems
	 * @param srvsetitemindexs
	 * @param setsrvdo
	 * @param ht
	 * @return
	 * @throws BizException
	 */
	public  ArrayList<OrdSrvDO> exec(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] srvsetitemindexs,MedSrvDO setsrvdo,Hashtable ht,List<OrdSrvDO> orsetsrv)  throws BizException{
		long startTime = System.currentTimeMillis();
		String id_srv_set=setsrvdo.getId_srv();
		int iN=CiOrdUtils.getSrvsetMemberValidCnt(ems, srvsetitemindexs);//srvsetitemindexs.length-1;
		MedSrvSetItemDO[] bdsrvinsetItems=CiOrdUtils.getBdSrvSetItems(id_srv_set);//查询套内已经启用的临床和非临床项目的集合
		MedSrvSetItemDO[] bdsrvinset = CiOrdUtils.getBdSrvSetItemsNotClinical(bdsrvinsetItems);//查询套内已经启用的非临床项目的集合
		Map<String,MedSrvSetItemDO> bdsrvinsetClinicalMap = CiOrdUtils.getBdSrvSetItemsClinicalMap(bdsrvinsetItems);//查询套内已经启用的非临床项目的集合
		Context.get().setAttribute("bdsrvinsetClinicalMap", bdsrvinsetClinicalMap);
		ArrayList<OrdSrvDO> srvdos=new ArrayList<OrdSrvDO>();
		boolean isSum=false;
		// 就诊上下文
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		
		Hashtable isGenerated=new Hashtable();
		if(CiOrdUtils.isSrvsetMemberSumPrimd(setsrvdo.getId_primd())){//成员合计  去0的srvsetitemindexs+非srvsetitemindexs+bdsrvinset   套逻辑bdsrvinset
			long tBeginTime = System.currentTimeMillis();
			//套合计部分的处理
			srvdos=createSrvMmInfo(aggdo,ems,srvsetitemindexs,ht,isGenerated,bdsrvinsetClinicalMap);//isSum=true;
			OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表——成员合计,耗时:%s(ms)", setsrvdo.getName(),System.currentTimeMillis()-tBeginTime));
			
		}else if(CiOrdUtils.isSrvsetMemberCntPrimd(setsrvdo.getId_primd())){//成员个数定价 srvsetitemindexs对应服务+非srvsetitemindexs   套逻辑bdsrvinset
			long tBeginTime = System.currentTimeMillis();
			PriStdSrvDTO[] prisrvs=CiOrSrvPriCalUtils.CalSrvSetFIXPrices(id_srv_set,iN);
			if(!priStdSrvCheck(prisrvs)){throw new CiOrSetMemCntPriMdSrvNullException();}
			srvdos=createSrvMmInfos(aggdo,ems,srvsetitemindexs[0],prisrvs,1,Integer.toString(iN),isGenerated);
			agentOrSrvStatusMod4SetMemCntHandle(aggdo,srvdos); //2016-06-27 增加该逻辑
			OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表——成员个数定价,耗时:%s(ms)", setsrvdo.getName(),System.currentTimeMillis()-tBeginTime));
			
		}else if(CiOrdUtils.isSrvsetMemCntAdditionalPrimd(setsrvdo.getId_primd())){//成员个数加收   srvsetitemindexs对应服务+非srvsetitemindexs   套逻辑bdsrvinset
			long tBeginTime = System.currentTimeMillis();
			PriStdSrvDTO[] prisrvs=CiOrSrvPriCalUtils.CalSrvSetMUPrices(id_srv_set,iN);
			if(!priStdSrvCheck(prisrvs)){throw new CiOrSetMemCntAddPriMdSrvNullException();}
			srvdos=createSrvMmInfos(aggdo,ems,srvsetitemindexs[0],prisrvs,iN,Integer.toString(iN),isGenerated);	
			agentOrSrvStatusMod4SetMemCntHandle(aggdo,srvdos); //2016-06-27 增加该逻辑
			OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表——成员个数加收,耗时:%s(ms)", setsrvdo.getName(),System.currentTimeMillis()-tBeginTime));
		}else{
			//暂不存在  不处理
		}
		
		if(isGenerated(isGenerated))return null;//2016-08-18    费用页签逻辑增加 
		
		long tBeginTime = System.currentTimeMillis();
		//套内非临床项目处理  套内合计价时应为null
		ArrayList<OrdSrvDO> srvdos1=createSrvMmInfo4SetItems(aggdo.getParentDO(),ems,srvsetitemindexs,bdsrvinset,ht,isSum);
		srvdos1Handle(srvdos1,id_srv_set);
		OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表——套内非临床,耗时:%s(ms)", setsrvdo.getName(),System.currentTimeMillis()-tBeginTime));
		
		//合并返回
		if (!(srvdos1 == null || srvdos1.size() == 0)) {
			if (srvdos == null) {
				srvdos = new ArrayList<OrdSrvDO>();
				srvdos.addAll(srvdos1);
			} else {
				srvdos.addAll(srvdos1);
			}
		}
		if (CiOrdUtils.isOpWf(aggdo.getParentDO().getCode_entp())) {
			OrdSrvDO ordSrv = handleMedSrv(setsrvdo, aggdo, ems,orsetsrv);
			if (srvdos == null) {
				srvdos = new ArrayList<OrdSrvDO>();
			}
			srvdos.add(ordSrv);
		}
		ordSrvDOFreqMod(srvdos,CiOrdUtils.getOrSrvSyncInfo(aggdo.getParentDO().getId_freq(),null));//医嘱项目频次修正逻辑添加  2016-06-14
		CiOrdUtils.LogerOutInfo(" 临床医嘱服务套开立模式服务处理 CiOrSrvSetHandle4OrModeBP  的exec 耗时"+(System.currentTimeMillis()-startTime));
		return srvdos;
	}
	
	/**
	 * 是否已经生成过
	 * @param o
	 * @return
	 */
	private boolean isGenerated(Hashtable o){
		if(CiOrdUtils.isEmpty(o))return false;
		return true;
	}
	/**
	 * 将服务套本身转为ordSrvDO存入ci_or_srv
	 * 注意 fg_bl='N' fg_or='Y'
	 * @author yzh
	 * @param medsrv
	 * @param aggdo
	 * @return
	 * @throws BizException 
	 */
	private OrdSrvDO handleMedSrv(MedSrvDO medsrv,CiorderAggDO aggdo,CiEmsDTO ems,List<OrdSrvDO> orsetsrv) throws BizException{
		CiOrderDO ordo=aggdo.getParentDO();
		OrdSrvDO ordsrv = new OrdSrvDO();
		if(CiOrdUtils.isDONew(ordo)){//新增处理
			//TODO 新增逻辑
			createMainSrvInfo(medsrv,aggdo,ordsrv,ems,0);
		}else if(CiOrdUtils.isDOMod(ordo)){//修改处理
			//TODO 编辑逻辑
			ordsrv = setMainSrvMmModInfo(aggdo,ems,0,orsetsrv);
		}
		return ordsrv;
	}
	private OrdSrvDO setMainSrvMmModInfo(CiorderAggDO aggdo,CiEmsDTO ems,int index,List<OrdSrvDO> orsetsrv) throws BizException{

		CiEmsSrvDTO srvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(index);
		CiOrderDO ordo=aggdo.getParentDO();
		OrdSrvDO srvdo = new OrdSrvDO();
		if(ordo.getFg_set().equals(FBoolean.TRUE)){
			srvdo = orsetsrv.get(0);
		}else{
			srvdo = CiOrdUtils.getMatchDatum(aggdo.getOrdSrvDO(), srvdto.getId_orsrv());
		}
		if(CiOrdUtils.isEmpty(srvdo)) return null;
		//皮试医嘱相关处理逻辑
		//if(CiOrdUtils.isNeedSkinTest(srvdto)){
		//	srvMmRelSkinOrModHandle(srvdo,srvdto,rtn,ems);
		//}
		if(CiOrdUtils.isEmpty(orsetsrv)){
			srvdo.setId_or(srvdto.getId_or());
			srvdo.setId_orsrv(srvdto.getId_orsrv());
		}
		srvdo.setId_srvtp(srvdto.getId_srvtp());
		srvdo.setSd_srvtp(srvdto.getSd_srvtp());
		srvdo.setId_srv(srvdto.getId_srv());
		srvdo.setName(srvdto.getName_srv());
		srvdo.setFg_dose_anoma(CiOrdUtils.nullHandle(srvdto.getFg_dose_anoma()));
		srvdo.setQuan_medu(srvdto.getQuan_med());
		srvdo.setId_medu(srvdto.getId_unit_med());
		srvdo.setId_route(srvdto.getId_route());
		srvdo.setId_routedes(srvdto.getId_routedes());
		srvdo.setId_boil(srvdto.getId_boil());
		srvdo.setId_boildes(srvdto.getId_boildes());
		srvdo.setId_freq(ordo.getId_freq());
		//srvdo.setId_org_srv(ordo.getId_org_or());
		//srvdo.setId_dep_srv(ordo.getId_dep_or());
		//srvdo.setId_wg_or(ordo.getId_wg_or());
		//srvdo.setId_emp_srv(ordo.getId_emp_or());
		//srvdo.setDt_create(ordo.getDt_entry());
		srvdo.setId_dep_mp(srvdto.getId_dep());  //调用科室算法
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdto.getId_dep()));
		//srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		//srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		//srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		//srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//srvdo.setDt_last_mp(srvdto.getDt_last_mp());
		
		srvdo.setDt_last_bl(ordo.getDt_last_bl());
		//srvdo.setFg_or(CiOrdUtils.nullHandle(srvdto.getFg_or()));
		//srvdo.setFg_bl(CiOrdUtils.nullHandle(srvdto.getFg_bl()));
		srvdo.setFg_or(FBoolean.TRUE);
		srvdo.setFg_bl(FBoolean.FALSE);
		srvdo.setEu_blmd(srvdto.getEu_blmd());
		srvdo.setFg_mm(CiOrdUtils.nullHandle(srvdto.getFg_mm()));
//		srvdo.setPri(srvdto.getPrice());
//		//折扣价、折扣系数赋值、标准价
//		CiOrdUtils.assignPriratToSrvDO(srvdto,srvdo);
		
		if(CiOrdUtils.isEmpty(srvdto.getPrice())){
			if(!CiOrdUtils.isEmpty(srvdo.getEu_blmd()) && srvdo.getEu_blmd()==MedSrvBlModeEnum.MANUALBL){
				srvdo.setPri(srvdto.getPrice());
				srvdo.setPri_std(srvdto.getPrice());
				srvdo.setPri_ratio(FDouble.ONE_DBL);
			}else{
				//映射折扣价，如果折扣价为空，则后台再查询折扣价
				CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ordo.getCode_entp(), srvdto, srvdo,null);
			}
		}else{
			if(!CiOrdUtils.isEmpty(srvdo.getEu_blmd()) && srvdo.getEu_blmd()==MedSrvBlModeEnum.MANUALBL){
				srvdo.setPri(srvdto.getPrice());
				srvdo.setPri_std(srvdto.getPrice());
				srvdo.setPri_ratio(FDouble.ONE_DBL);
			}else{
				srvdo.setPri(srvdto.getPrice());
				srvdo.setPri_std(srvdto.getPri_std());
				srvdo.setPri_ratio(srvdto.getPri_ratio());
				srvdo.setId_pripat(srvdto.getId_pripat());
			}
		}
		srvdo.setFg_set(CiOrdUtils.nullHandle(srvdto.getFg_set()));
		srvdo.setFg_indic(srvdto.getFg_indic());//之前关闭，现在打开了（zhangwq）
		srvdo.setFg_propc(CiOrdUtils.nullHandle(srvdto.getFg_propc()));
		srvdo.setFg_self(CiOrdUtils.nullHandle(srvdto.getFg_self()));
		srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(srvdto.getFg_outp()));
		String desSrv = srvdto.getDes_srv();
		srvdo.setNote_srv(srvdto.getDes_srv());
		srvdo.setId_srvca(srvdto.getId_srvca());
		srvdo.setCode_srv(srvdto.getCode_srv());
		srvdo.setEu_sourcemd(srvdto.getEu_sourcemd());
		srvdo.setEu_blmd(srvdto.getEu_blmd());
		srvdo.setFg_skintest(CiOrdUtils.nullHandle(srvdto.getFg_skintest()));//2016-03-25 新增
		srvdo.setId_skintest_skip_reason(srvdto.getId_skintest_skip_reason());//2016-03-25 新增
		srvdo.setSd_skintest_skip_reason(srvdto.getSd_skintest_skip_reason());//2016-03-25 新增
		srvdo.setId_reltp(srvdto.getId_reltp());//2016-03-25 新增 关联类型
		srvdo.setSd_reltp(srvdto.getSd_reltp());//2016-03-25 新增  关联类型编码
		srvdo.setId_or_rel(srvdto.getId_or_rel());//2016-03-25 新增  对应关联医嘱id
		//srvdo.setDt_last_cg(srvdto.getDt_last_bl());//2016-03-25 新增  最近费用日期
		srvdo.setId_primd(srvdto.getId_primd());
		srvdo.setFg_selfsrv(srvdto.getFg_selfsrv());
		srvdo.setId_srv_src(srvdto.getId_srv_src());
		srvdo.setFg_extdispense(srvdto.getFg_extdispense());//外配药标识
		// 非住院就诊或出院带药时候，计算服务总量 -- 2016.12.28 by wangqzh
		if(CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(),srvdo.getSd_srvtp()).booleanValue()){
			CiOrdUtils.setQuanTotalMeduToSrvDO(ems, srvdto, srvdo);
		}
//		if (!ems.getCode_entp().equals(IEnDictCodeConst.SD_ENTP_INPATIENT)
//				|| (!CiOrdUtils.isEmpty(ordo.getFg_pres_outp()))
//				&& ordo.getFg_pres_outp().booleanValue()) {
//
//			if (srvdto.getQuan_total_medu() != null&&srvdto.getQuan_total_medu().doubleValue()!=0) {
//				srvdo.setQuan_total_medu(srvdto.getQuan_total_medu());
//			} else {
//				QuantumParamDTO quantum = new QuantumParamDTO(ems,srvdto);
//				CalQuantumBP bp = new CalQuantumBP();
//				srvdo.setQuan_total_medu(bp.getQuantum(quantum));
//			}
//		}
		//FIXME  Fg_hpindicjudged=9 fg_selfpay='Y'
		srvdo.setFg_selfpay(srvdto.getFg_selfpay()); //2016-07-08新增自费标识
		srvdo.setId_hp(srvdto.getId_hp());//2016-07-12新增医保相关信息
		srvdo.setId_hpsrvtp(srvdto.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(srvdto.getSd_hpsrvtp());
		srvdo.setPriby(srvdto.getPriby());//2016-09-01  新增
		if(!CiOrdUtils.isEmpty(ordo.getEu_hpindicjudge())&& ordo.getEu_hpindicjudge() == 9){
			srvdo.setFg_hpindicjudged(srvdto.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
		}else{
			if(!CiOrdUtils.isEmpty(srvdto.getFg_hpindicjudged()) && srvdto.getFg_hpindicjudged() == HpIndicJudgeEnum.SELFPAY){
				srvdo.setFg_hpindicjudged(null);//FIXME 编辑状态暂时置为null 去医保计算处重新计算
			}else{
				srvdo.setFg_hpindicjudged(srvdto.getFg_hpindicjudged());
			}
		}
		srvdo.setFg_base(srvdto.getFg_base());
		srvdo.setStatus(DOStatus.UPDATED);
		//关联的物品id
		srvdo.setId_mm(srvdto.getId_mm());
		return srvdo;

	
	}
	/**
	 * 为套本身创建ci_or_srv
	 * @param medsrv
	 * @param aggdo
	 * @param srvdo
	 * @param ems
	 * @throws BizException
	 */
	private void createMainSrvInfo(MedSrvDO medsrv,CiorderAggDO aggdo,OrdSrvDO srvdo,CiEmsDTO ems,int index) throws BizException{
		CiOrderDO ordo = aggdo.getParentDO();
		CiEmsSrvDTO srvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(index);
		if(ordo.getStatus()==DOStatus.DELETED) return;
		srvdo.setId_or(CiOrdUtils.getCiOrderId(ordo, srvdto.getId_or()));
		//srvdo.setId_pres(srvdto.getId_pres());
		srvdo.setId_pat(ordo.getId_pat());
		srvdo.setId_entp(ordo.getId_entp());
		srvdo.setCode_entp(ordo.getCode_entp());
		srvdo.setId_en(ordo.getId_en());
		srvdo.setSortno(index);
		srvdo.setId_srvtp(srvdto.getId_srvtp());
		srvdo.setSd_srvtp(srvdto.getSd_srvtp());
		srvdo.setId_srv(srvdto.getId_srv());
		srvdo.setName(srvdto.getName_srv());
		srvdo.setFg_dose_anoma(CiOrdUtils.nullHandle(srvdto.getFg_dose_anoma()));
//		srvdo.setQuan_medu(ordo.getQuan_medu());
		//剂量取前端输入的剂量 by yzh 2017-12-04 09:13:35
		srvdo.setQuan_medu(ems.getQuan_medu());
		srvdo.setId_medu(srvdto.getId_unit_med());
		srvdo.setId_route(srvdto.getId_route());
		srvdo.setId_routedes(srvdto.getId_routedes());
		srvdo.setId_boil(srvdto.getId_boil());
		srvdo.setId_boildes(srvdto.getId_boildes());
		srvdo.setId_freq(srvdto.getId_freq());   //2016-12-01 - mxj - 修改ordo.getId_freq()--》srvdto.getId_freq()  应该为业务传进的项目freq不应该是医嘱的freq，如果是的话应该走业务规则算法
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdto.getId_dep()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setDt_last_bl(ordo.getDt_last_bl());
		srvdo.setEu_blmd(srvdto.getEu_blmd());
		srvdo.setFg_mm(CiOrdUtils.nullHandle(srvdto.getFg_mm()));
		CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO",CiEnContextDTO.class);
		if(!CiOrdUtils.isEmpty(srvdo.getEu_blmd()) && srvdo.getEu_blmd()==MedSrvBlModeEnum.MANUALBL){
			srvdo.setPri(srvdto.getPrice());
			srvdo.setPri_std(srvdto.getPrice());
			srvdo.setPri_ratio(FDouble.ONE_DBL);
		}else if(!CiOrdUtils.isEmpty(srvdto.getPrice())){
			srvdo.setPri(srvdto.getPrice());
			srvdo.setPri_std(srvdto.getPrice());
			srvdo.setPri_ratio(FDouble.ONE_DBL);
		}
		else{
//			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ordo.getCode_entp(), srvdto, srvdo,null);
		}
		srvdo.setId_pripat(cienContext.getId_pripat());
		srvdo.setFg_set(CiOrdUtils.nullHandle(srvdto.getFg_set()));
		srvdo.setFg_indic(srvdto.getFg_indic());//之前关闭，现在打开了（zhangwq）
		srvdo.setFg_propc(CiOrdUtils.nullHandle(srvdto.getFg_propc()));
		srvdo.setFg_self(CiOrdUtils.nullHandle(srvdto.getFg_self()));
		srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(srvdto.getFg_outp()));
		srvdo.setNote_srv(srvdto.getDes_srv());
		srvdo.setId_srvca(srvdto.getId_srvca());
		//srvdo.setFg_or(CiOrdUtils.nullHandle(srvdto.getFg_or()));
		//srvdo.setFg_bl(CiOrdUtils.nullHandle(srvdto.getFg_bl()));
		srvdo.setFg_or(FBoolean.TRUE);
		srvdo.setFg_bl(FBoolean.FALSE);
		srvdo.setCode_srv(srvdto.getCode_srv());
		srvdo.setEu_sourcemd(srvdto.getEu_sourcemd());
		srvdo.setEu_blmd(srvdto.getEu_blmd());
	    srvdo.setId_primd(srvdto.getId_primd());
		srvdo.setFg_skintest(CiOrdUtils.nullHandle(srvdto.getFg_skintest()));//2016-03-25 新增
		srvdo.setId_skintest_skip_reason(srvdto.getId_skintest_skip_reason());//2016-03-25 新增
		srvdo.setSd_skintest_skip_reason(srvdto.getSd_skintest_skip_reason());//2016-03-25 新增
		srvdo.setId_reltp(srvdto.getId_reltp());//2016-03-25 新增 关联类型
		srvdo.setFg_hpindicjudged(srvdto.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
		srvdo.setFg_extdispense(srvdto.getFg_extdispense());//外配药标识
		if(FBoolean.TRUE.equals(srvdo.getFg_skintest()))
		{
			srvdo.setSd_reltp(IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN);
		}else{
			srvdo.setSd_reltp(srvdto.getSd_reltp());//2016-03-25 新增  关联类型编码
		}
		srvdo.setId_or_rel(srvdto.getId_or_rel());//2016-03-25 新增  对应关联医嘱id
		srvdo.setEu_sourcemd(srvdto.getEu_sourcemd()); //添加医疗单来源
		srvdo.setId_primd(srvdto.getId_primd());
		srvdo.setFg_selfsrv(srvdto.getFg_selfsrv());
		srvdo.setId_srv_src(srvdto.getId_srv_src());
		// 非住院就诊或出院带药时候，计算服务总量 -- 2016.12.28 by wangqzh
		if(CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(),srvdo.getSd_srvtp()).booleanValue()){
			CiOrdUtils.setQuanTotalMeduToSrvDO(ems, srvdto, srvdo);
		}
		srvdo.setFg_selfpay(srvdto.getFg_selfpay());//2016-07-08新增自费标识
		srvdo.setId_hp(srvdto.getId_hp());//2016-07-12新增医保相关信息
		srvdo.setId_hpsrvtp(srvdto.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(srvdto.getSd_hpsrvtp());
		srvdo.setDes_hplimit(srvdto.getLimit());
		srvdo.setFg_pres_outp(srvdto.getFg_outp());//出院带药标识  zwq 2016-08-11
		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
		if(srvdto.getId_dep() == null){
			exeandwhdeptinfo=CiOrdUtils.getMpDeptID(ems,0,ordo.getDt_effe());  //待打开
			srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
			if(exeandwhdeptinfo.getId_dep_mp() == null){
				srvdo.setId_dep_mp(ems.getId_dep_mp());
			}else{
				srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开
			}
			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   //待打开
			//srvdo.setId_dep_mp(CiOrdUtils.getMpDeptID(ems,srvdo));   //调整到最后    //待注释
			
		}else{
			srvdo.setId_dep_mp(srvdto.getId_dep()); 
			srvdo.setId_dep_wh(srvdto.getId_dep_wh());
		}
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setFg_base(srvdto.getFg_base());
		srvdo.setPriby(srvdto.getPriby());//2016-09-01  新增
		srvdo.setFg_feertnable(FBoolean.TRUE); //可退费标识
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_org( CiOrdAppUtils.getEnvContext().getOrgId()); // 组织id);
		srvdo.setId_grp( CiOrdAppUtils.getEnvContext().getGroupId()); // 集团id;
		srvdo.setId_mm(srvdto.getId_mm());
	}
	/**
	 * 获取服务价格
	 * @param medsrv
	 * @param ordsrv
	 * @throws BizException
	 */
	private void getMedSrvPrice(MedSrvDO medsrv,OrdSrvDO ordsrv) throws BizException{
		CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
		CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO",CiEnContextDTO.class);
		MedSrvPriceDO srvprice = bp.exec(getBdSrvPriCalParamDTOFrom(medsrv),cienContext.getId_pripat());
		if(!CiOrdUtils.isEmpty(srvprice)){
			ordsrv.setPri(srvprice.getPrice_ratio());
			ordsrv.setPri_std(srvprice.getPrice_std());
			ordsrv.setId_pripat(cienContext.getId_pripat());
			if(!CiOrdUtils.isEmpty(srvprice.getPrice_ratio())&&!CiOrdUtils.isEmpty(srvprice.getPrice_std())){
				if(!CiOrdUtils.isEmpty(srvprice.getPrice_std())&&srvprice.getPrice_std().toDouble()!=0){
					ordsrv.setPri_ratio(srvprice.getPrice_ratio().div(srvprice.getPrice_std()));//折扣系数
				}
			}
		}else{
			ordsrv.setPri(FDouble.ZERO_DBL);
			ordsrv.setPri_std(FDouble.ZERO_DBL);
		}
	}
	private static BdSrvPriCalParamDTO getBdSrvPriCalParamDTOFrom(MedSrvDO medsrv){
		BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
		param.setId_srv(medsrv.getId_srv());
		param.setId_primd(medsrv.getId_primd());
		return param;
	}
	/**
	 * 获得最近医嘱生成日期
	 * @param id_freq
	 * @param dt_effe
	 * @param firstdaytimes
	 * @return
	 * @throws BizException
	 */
	private FDateTime getLastDt(String id_freq,FDateTime dt_effe,Integer firstdaytimes,FBoolean fg_long) throws BizException{
		CiOrDtLastBlCal4OpenBP bp=new CiOrDtLastBlCal4OpenBP();
		return bp.exec(id_freq, dt_effe, firstdaytimes,fg_long);
	}
	/**
	 * 根据ems服务物品信息生成医嘱项目集合（医嘱模式套合计处理逻辑）
	 */
	private ArrayList<OrdSrvDO> createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] indexes,Hashtable ht,Hashtable isGenerated) throws BizException{
		
		//生成医嘱项目信息
		CiOrCreateSrvMms8EmsBP bp=new CiOrCreateSrvMms8EmsBP();
		ArrayList<OrdSrvDO> rtn=bp.exec(aggdo, ems, indexes,ht);
		
		//空判断
		if(CiOrdUtils.isEmpty(rtn))return null;
		
		//组合定价模式的处理逻辑   这个逻辑是后期增加的2016-05-18新增逻辑分支
		long startTime = System.currentTimeMillis();
		ArrayList<OrdSrvDO> rtnComp=null;//getCiOrCompPriOrSrvs(aggdo,ems,indexes); // 2016-12-19 注释改代码，套内项目组合时，重复计算问题
		CiOrdUtils.LogerOutInfo("类 CiOrSrvSetHandle4OrModeBP 组合定价模式的处理逻辑 的方法 getCiOrCompPriOrSrvs耗时"+(System.currentTimeMillis()-startTime));
		if(CiOrdUtils.isEmpty(rtnComp))return rtn;
		
		//返回值处理
		rtn.addAll(rtnComp);
		return rtn;
	}
	private ArrayList<OrdSrvDO> createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] indexes,Hashtable ht,Hashtable isGenerated,Map<String,MedSrvSetItemDO> bdsrvinsetClinicalMap) throws BizException{
		
		//生成医嘱项目信息
		CiOrCreateSrvMms8EmsBP bp=new CiOrCreateSrvMms8EmsBP();
		ArrayList<OrdSrvDO> rtn=bp.exec(aggdo, ems, indexes,ht,bdsrvinsetClinicalMap);
		
		//空判断
		if(CiOrdUtils.isEmpty(rtn))return null;
		
		//组合定价模式的处理逻辑   这个逻辑是后期增加的2016-05-18新增逻辑分支
		long startTime = System.currentTimeMillis();
		ArrayList<OrdSrvDO> rtnComp=null;//getCiOrCompPriOrSrvs(aggdo,ems,indexes); // 2016-12-19 注释改代码，套内项目组合时，重复计算问题
		CiOrdUtils.LogerOutInfo("类 CiOrSrvSetHandle4OrModeBP 组合定价模式的处理逻辑 的方法 getCiOrCompPriOrSrvs耗时"+(System.currentTimeMillis()-startTime));
		if(CiOrdUtils.isEmpty(rtnComp))return rtn;
		
		//返回值处理
		rtn.addAll(rtnComp);
		return rtn;
	}
	/**
	 * 根据定价模式返回的价格服务生成医嘱项目
	 * @param aggdo
	 * @param ems
	 * @param setindex
	 * @param prisrvs
	 * @param quan
	 * @return
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> createSrvMmInfos(CiorderAggDO aggdo,CiEmsDTO ems,Integer setindex,PriStdSrvDTO[] prisrvs,Integer quan,String priby,Hashtable isGenerated) throws BizException{
		//有效性检查
		if(CiOrdUtils.isEmpty(prisrvs))return null;
		
		//参数设置
		ArrayList<OrdSrvDO> rtn=new ArrayList<OrdSrvDO>();
		long startTime = System.currentTimeMillis();
		//下面一行代码注释原因：2016-11-11  代码优化 改进   每个查询耗时将近50ms多  将这部分代码调整到入口参数中以便做批量查询
		//批量查询时，比如10个服务查询时间基本上也是稳定在50ms多一点
		//CiOrCreateSrvMm8CalSrvBP bp = new CiOrCreateSrvMm8CalSrvBP();
		CiOrCreateSrvMm8CalSrvNBP bp = new CiOrCreateSrvMm8CalSrvNBP();  //调优新增   2016-11-11
		MedSrvDO[] medsrvdos=CiOrdUtils.getMedSrvInfoDOs(prisrvs);//调优新增   2016-11-11
		OrdSrvDO orsrvdo;
		
		
		//2016-08-01 新增逻辑 主要为费用页签使用 还是有漏洞
		if(EmsHelper.isEmsSrvsGenerated(ems, aggdo.getParentDO().getId_srv(), new Integer[]{OrSrvSourceFromEnum.AGENTFROMPRIMD},priby)){
			isGenerated.put("1", "1");
			return  rtn;
		}
		

		//遍历
		for(int i=0;i<prisrvs.length;i++){
			if(CiOrdUtils.isEmpty(prisrvs[i].getId_srv()))continue;
			
			//bp=new CiOrCreateSrvMm8CalSrvBP();
			orsrvdo= bp.exec(aggdo, ems, setindex, prisrvs[i],medsrvdos[i],quan,priby);	//orsrvdo= bp.exec(aggdo, ems, setindex, prisrvs[i],quan,priby);	//调优调整   2016-11-11	
			if(CiOrdUtils.isEmpty(orsrvdo))continue;
			rtn.add(orsrvdo);
		}

		CiOrdUtils.getlogger().info("根据组合定价模式返回的价格服务生成医嘱项目（仅对套的情形） 耗时"+( System.currentTimeMillis()-startTime));
		//返回
		return rtn;
	}
	
	/**
	 * 根据定价模式返回的价格服务生成医嘱项目
	 * @param ordo
	 * @param ems
	 * @param setindex
	 * @param prisrv
	 * @param quan
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,Integer setindex,PriStdSrvDTO prisrv,Integer quan) throws BizException{
		CiOrCreateSrvMm8CalSrvBP bp=new CiOrCreateSrvMm8CalSrvBP();
		return bp.exec(aggdo, ems, setindex, prisrv, quan,"");
	}
	
	
	/**
	 * 根据套内非临床标识服务生成医嘱项目集合（仅对套的情形）
	 * 套内合计价时则直接返回
	 * @param ordo
	 * @param ems
	 * @param setindex
	 * @param bdsrvinset
	 * @return
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> createSrvMmInfo4SetItems(CiOrderDO ordo,CiEmsDTO ems,Integer[] setindex,MedSrvSetItemDO[] bdsrvinset,Hashtable ht,boolean isSum) throws BizException{
		if(isSum)return null;//套内合计价时则返回
		CiOrCreateSrvMm8SetItemBP bp=new CiOrCreateSrvMm8SetItemBP();
		return bp.exec(ordo, ems, setindex, bdsrvinset,ht);
	}
	
	/**
	 * 套对应价格服务存在性检查
	 * @param prisrv
	 * @return
	 */
	private boolean priStdSrvCheck(PriStdSrvDTO prisrv){
		if(CiOrdUtils.isEmpty(prisrv))return false;
		if(CiOrdUtils.isEmpty(prisrv.getId_srv()))return false;
		return true;
	}
	
	/**
	 * 套对应价格服务存在性检查
	 * @param prisrv
	 * @return
	 */
	private boolean priStdSrvCheck(PriStdSrvDTO[] prisrvs){
		if(CiOrdUtils.isEmpty(prisrvs))return false;
		int iN=0;
		for(int i=0;i<prisrvs.length;i++){
			if(CiOrdUtils.isEmpty(prisrvs[i].getId_srv())){
				return false;
			}else{
				iN+=1;
			}
		}
		if(iN==0)return false;
		return true;
	}
	
	/**
	 * 创建组合定价模式医嘱项目对应的医嘱项目
	 * @param aggdo
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private ArrayList<OrdSrvDO> getCiOrCompPriOrSrvs(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] indexes,Hashtable ht) throws BizException{
		//有效性校验
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0)return null;
		ArrayList<OrdSrvDO> rtnlist=new ArrayList<OrdSrvDO>();
		ArrayList<OrdSrvDO> rtnTmp=null;
		
		//遍历
		for(int i=1;i<indexes.length;i++){
			
			//服务项目组合定价模式逻辑判断
			CiEmsSrvDTO emssrvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(indexes[i]);
			if(!isSrvCompPriMd(emssrvdto))continue;
			
			//2016-08-01 新增逻辑 主要为费用页签使用 还是有些漏洞
			if(EmsHelper.isEmsSrvsGenerated(ems, emssrvdto.getId_srv(), new Integer[]{OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD},null)){
				continue;
			}
			
			//组合定价模式处理
			long startTime = System.currentTimeMillis();
			rtnTmp=getSrvMm8CompPriSrv(aggdo,ems,i,ht);
			CiOrdUtils.LogerOutInfo("类 CiOrSrvSetHandle4OrModeBP 组合定价模式处理 耗时  "+(System.currentTimeMillis() -startTime));
			if(!CiOrdUtils.isEmpty(rtnTmp)){
				ordSrvDOFreqMod(rtnTmp,CiOrdUtils.getOrSrvSyncInfo(aggdo.getParentDO().getId_freq(),emssrvdto.getFg_or()));
				rtnlist.addAll(rtnTmp);
			}
		}
		
		return rtnlist;
	}
	
	/**
	 * 获得组合定价模式医嘱项目对应的费用医嘱项目集合数据信息
	 * @param aggdo
	 * @param ems
	 * @param ipos
	 * @return
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> getSrvMm8CompPriSrv(CiorderAggDO aggdo,CiEmsDTO ems,Integer ipos,Hashtable ht) throws BizException{
		CiOrCreateSrvMm8CompPriSrv0BP bp=new CiOrCreateSrvMm8CompPriSrv0BP();
		return bp.exec(aggdo, ems, ipos,ht);
	}
	
	/**
	 * 医疗单项目是否为组合定价模式的逻辑判断
	 * （非套 非套内项目的情形）
	 * 套的已经在套逻辑中处理了
	 * @param emssrvdto
	 * @return
	 * @throws BizException 
	 */
	private boolean isSrvCompPriMd(CiEmsSrvDTO emssrvdto) throws BizException{
		return CiOrdUtils.isSrvCompPriMd(emssrvdto);
	}
	
	/**
	 * 医嘱项目频次修正
	 * @param ordsrvdos
	 * @param id_freq
	 * @throws BizException
	 */
	private void ordSrvDOFreqMod(OrdSrvDO[] ordsrvdos,OrSrvSyncInfoDTO syncinfo) throws BizException{
		CiOrOrdSrvDOsFreqModBP bp=new CiOrOrdSrvDOsFreqModBP();
		bp.exec(ordsrvdos, syncinfo);
		
	}
	
	/**
	 * 医嘱项目频次修正
	 * @param ordsrvdos
	 * @param id_freq
	 * @throws BizException
	 */
	private void ordSrvDOFreqMod(ArrayList<OrdSrvDO> ordsrvdos,OrSrvSyncInfoDTO syncinfo) throws BizException{
		CiOrOrdSrvDOsFreqMod1BP bp=new CiOrOrdSrvDOsFreqMod1BP();
		bp.exec(ordsrvdos, syncinfo);
		
	}
	
	/**
	 * 套成员计价派生医嘱项目状态修改
	 * @param aggdo
	 * @param srvdos
	 */
	private void agentOrSrvStatusMod4SetMemCntHandle(CiorderAggDO aggdo,ArrayList<OrdSrvDO> srvdos){
		ArrayList<OrdSrvDO> delorsrvs=CiOrdUtils.agentOrSrvStatusMod4SetMemCntHandle(aggdo);
		if(CiOrdUtils.isEmpty(delorsrvs))return;
		srvdos.addAll(delorsrvs);
	}
	
	/**
	 * 套内项目设置套id
	 * @param srvdos1
	 * @param id_srv_set
	 */
	private void srvdos1Handle(ArrayList<OrdSrvDO> srvdos1,String id_srv_set){
		if(CiOrdUtils.isEmpty(srvdos1))return;
		for(int i=0;i<srvdos1.size();i++){
			srvdos1.get(i).setId_srv_src(id_srv_set);
		}
	}
	
	private MedSrvDO getsrv8idsrv(MedSrvDO[] medsrvdos,String id_srv){

		for (MedSrvDO medSrvDO : medsrvdos) {
			if(medSrvDO.getId_srv().equals(id_srv)){
				return medSrvDO;
			}
		}
		return null;
	}

}
