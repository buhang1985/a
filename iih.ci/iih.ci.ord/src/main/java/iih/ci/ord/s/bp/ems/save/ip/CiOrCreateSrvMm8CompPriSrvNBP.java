package iih.ci.ord.s.bp.ems.save.ip;

import java.util.Hashtable;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrSrvPriHelper;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrAttachInfoUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 根据定价模式返回的价格服务生成医嘱项目操作BP（仅对组合定价模式的情形）
 */
public class CiOrCreateSrvMm8CompPriSrvNBP {
	/**
	 * 根据定价模式返回的价格服务生成医嘱项目（仅对组合定价模式的情形）
	 * @param ordo
	 * @param ems
	 * @param ipos
	 * @param prisrv
	 * @param quan  是进入医学单位的数量值   不是服务总量
	 * @return
	 * @throws BizException
	 */
	public  OrdSrvDO exec(CiorderAggDO aggdo,CiEmsDTO ems,Integer ipos,PriStdSrvDTO prisrv,MedSrvDO prisrvdo,FDouble quan)  throws BizException{
		if(prisrv==null)return null;
		long startTime = System.currentTimeMillis();
		CiOrderDO ordo=aggdo.getParentDO();
		OrdSrvDO srvdo=null; 
		if(CiOrdUtils.isDONew(ordo)){//新增处理
			srvdo=createOrSrvMmInfo(ordo,ems,ipos,prisrv,prisrvdo,quan,null);
		}else{//修改
			srvdo=orSrvMmInfoModHandle(aggdo,ems,ipos,prisrv,prisrvdo,quan,null);
		}
		CiOrdUtils.getlogger().info(" 根据定价模式返回的价格服务生成医嘱项目（仅对组合定价模式的情形）(CiOrCreateSrvMm8CompPriSrvBP) 耗时"+( System.currentTimeMillis()-startTime));
		return srvdo;
	}
	/**
	 * 根据定价模式返回的价格服务生成医嘱项目（仅对组合定价模式的情形），增加组合定价关联物品逻辑
	 * @param ordo
	 * @param ems
	 * @param ipos
	 * @param prisrv
	 * @param quan  是进入医学单位的数量值   不是服务总量
	 * @param ht
	 * @return
	 * @throws BizException
	 */
	public  OrdSrvDO exec(CiorderAggDO aggdo,CiEmsDTO ems,Integer ipos,PriStdSrvDTO prisrv,MedSrvDO prisrvdo,FDouble quan,Hashtable ht)  throws BizException{
		if(prisrv==null)return null;
		long startTime = System.currentTimeMillis();
		CiOrderDO ordo=aggdo.getParentDO();
		OrdSrvDO srvdo=null; 
		if(CiOrdUtils.isDONew(ordo)){//新增处理
			srvdo=createOrSrvMmInfo(ordo,ems,ipos,prisrv,prisrvdo,quan,ht);
		}else{//修改
			srvdo=orSrvMmInfoModHandle(aggdo,ems,ipos,prisrv,prisrvdo,quan,ht);
		}
		CiOrdUtils.getlogger().info(" 根据定价模式返回的价格服务生成医嘱项目（仅对组合定价模式的情形）(CiOrCreateSrvMm8CompPriSrvBP) 耗时"+( System.currentTimeMillis()-startTime));
		return srvdo;
	}

	
	/**
	 * 生成医嘱项目信息
	 * @param ordo
	 * @param srvdo
	 * @param ems
	 * @param ipos
	 * @param prisrv
	 * @param quan
	 * @throws BizException
	 */
	private OrdSrvDO createOrSrvMmInfo(CiOrderDO ordo,CiEmsDTO ems,Integer ipos,PriStdSrvDTO prisrv,MedSrvDO prisrvdo,FDouble quan,Hashtable ht)  throws BizException{
		CiEmsSrvDTO setsrv=(CiEmsSrvDTO)ems.getEmssrvs().get(ipos);
		
		//下面一行代码注释原因：2016-11-11  代码优化 改进   每个查询耗时将近50ms多  将这部分代码调整到入口参数中以便做批量查询
		//批量查询时，比如10个服务查询时间基本上也是稳定在50ms多一点
		//MedSrvDO prisrvdo=CiOrdAppUtils.getMedsrvMDORService().findById(prisrv.getId_srv());
		long starts = System.currentTimeMillis();

		OrdSrvDO srvdo=new OrdSrvDO();
	//	getMpDeptID(ordo,ems,setsrv,prisrvdo,null);  // 垃圾代码    2016 11-11 性能调优

		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		srvdo.setId_or(ordo.getId_or());
		//srvdo.setId_pres(srvdto.getId_pres());
		srvdo.setId_pat(ordo.getId_pat());
		srvdo.setId_entp(ordo.getId_entp());
		srvdo.setCode_entp(ordo.getCode_entp());
		srvdo.setId_en(ordo.getId_en());
		//srvdo.setSortno(srvdto.getSortno());
		srvdo.setId_srvtp(prisrvdo.getId_srvtp());
		srvdo.setSd_srvtp(prisrvdo.getSd_srvtp());
		srvdo.setId_srv(prisrvdo.getId_srv());
		srvdo.setName(prisrvdo.getName());
		srvdo.setFg_dose_anoma(FBoolean.FALSE);
		//新服务的剂量=原服务的剂量（quan）*组合计价中配置的比例数量（CiOrSrvPriHelper.getPriStdSrvQuan(prisrv)）
		srvdo.setQuan_medu(CiOrSrvPriHelper.getPriStdSrvQuan(prisrv).multiply(quan)); //2016-06-29
		srvdo.setId_medu(prisrvdo.getId_unit_med());
		srvdo.setId_route(prisrvdo.getId_route());
		srvdo.setId_routedes(prisrvdo.getId_routedes());
		srvdo.setId_boil(prisrvdo.getId_boil());
		srvdo.setId_boildes(prisrvdo.getId_boildes());
		srvdo.setId_freq(ordo.getId_freq());
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		//srvdo.setId_dep_mp(getMpDeptID());    //调整到最后
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//srvdo.setDt_last_mp(srvdto.getDt_last_mp());
		//srvdo.setDt_last_cg(getLastDt(setsrv.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setDt_last_bl(ordo.getDt_last_bl());
		srvdo.setFg_or(FBoolean.FALSE);
		srvdo.setEu_blmd(prisrvdo.getEu_blmd());  //本服务定价
		srvdo.setFg_mm(FBoolean.FALSE);
		
		if(CiOrdUtils.isEmpty(prisrv)){
			srvdo.setPri(CiOrdUtils.getOrSrvPrice(ordo, setsrv));// //2016-08-26  修改该逻辑
		}else{
			srvdo.setPri(prisrv.getPrice());
			if(!CiOrdUtils.isEmpty(prisrv.getAttrVal("Pri_std")))
				srvdo.setPri_std((FDouble)prisrv.getAttrVal("Pri_std"));
			if(!CiOrdUtils.isEmpty(prisrv.getAttrVal("Pri_ratio")))
				srvdo.setPri_ratio((FDouble)prisrv.getAttrVal("Pri_ratio"));
			srvdo.setId_pripat(prisrv.getId_pripat());
		}
		
		long startTime = System.currentTimeMillis();
		srvdo.setFg_set(FBoolean.FALSE);
		//srvdo.setFg_indic(srvdto.getFg_indic());
		srvdo.setFg_propc(FBoolean.FALSE);
		if(!CiOrdUtils.isEmpty(setsrv.getSd_nodispense())){
			if(ICiDictCodeConst.SD_NODISPENSE_SELF.equals(setsrv.getSd_nodispense())){
				srvdo.setFg_self(FBoolean.TRUE);// 2020-3-25 李月龙 添加
				srvdo.setSd_nodispense(ICiDictCodeConst.SD_NODISPENSE_SELF);
				srvdo.setId_nodispense(ICiDictCodeConst.ID_NODISPENSE_SELF);
			}else if(ICiDictCodeConst.SD_NODISPENSE_ENTRUST.equals(setsrv.getSd_nodispense())){
				srvdo.setFg_self(FBoolean.FALSE);
				srvdo.setSd_nodispense(ICiDictCodeConst.SD_NODISPENSE_ENTRUST);
				srvdo.setId_nodispense(ICiDictCodeConst.ID_NODISPENSE_ENTRUST);
			}else if(ICiDictCodeConst.SD_NODISPENSE_FOREIGN.equals(setsrv.getSd_nodispense())){
				srvdo.setFg_self(FBoolean.FALSE);
				srvdo.setSd_nodispense(ICiDictCodeConst.SD_NODISPENSE_FOREIGN);
				srvdo.setId_nodispense(ICiDictCodeConst.ID_NODISPENSE_FOREIGN);
			}
			
		}else{
			srvdo.setFg_self(FBoolean.FALSE);
		}

		srvdo.setFg_pres_outp(FBoolean.FALSE);
		srvdo.setNote_srv("");
		srvdo.setId_srvca(prisrvdo.getId_srvca());
		if(!CiOrdUtils.isEmpty(srvdo.getSd_nodispense()) || FBoolean.TRUE.equals(srvdo.getFg_self())){
			srvdo.setFg_bl(FBoolean.FALSE);
		}else{
			srvdo.setFg_bl(CiOrdUtils.nullHandle(prisrvdo.getFg_bl()));
		}
		srvdo.setCode_srv(prisrvdo.getCode());
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD);
		//srvdo.setId_dep_mp(getMpDeptID(ems,srvdo));  //2016-08-05 注释掉
		
		//2016-06-28新增字段
		//srvdo.setFg_skintest_rst(Fg_skintest_rst);
		srvdo.setId_primd(prisrvdo.getId_primd());
		srvdo.setFg_selfsrv(prisrvdo.getFg_ctm());
		srvdo.setId_srv_src(CiOrdUtils.getEmsItemIdSrv(ems, ipos));
		
		//新服务的总量=原服务的剂量*组合计价中配置的比例数量*总次数
		//医技医生站也要计算总量
		//srvdo.setQuan_total_medu(CiOrdUtils.getEmsItemQuanTotalMed(ems, ipos));
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		if(ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(context.getStationType())||CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(), srvdo.getSd_srvtp()).booleanValue()){
			CalQuantumBP bp = new CalQuantumBP();
			srvdo.setQuan_total_medu(bp.getQuantum(srvdo.getQuan_medu(), ems.getTimes_cur()));
		}
		srvdo.setFg_selfpay(setsrv.getFg_selfpay());//2016-07-08新增自费标识  可能是有问题
		srvdo.setId_hp(setsrv.getId_hp());//2016-07-12新增医保相关信息
		srvdo.setId_hpsrvtp(setsrv.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(setsrv.getSd_hpsrvtp());
//		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
//		if(srvdo.getId_dep_mp()== null){
//			long start = System.currentTimeMillis();
//			exeandwhdeptinfo=getMpDeptID(ordo,ems,setsrv,prisrvdo,null);  //待打开
//			CiOrdUtils.LogerOutInfo("根据定价模式返回的价格服务生成医嘱项目操作BP（仅对组合定价模式的情形）(CiOrCreateSrvMm8CompPriSrvBP) 的方法 getMpDeptID 耗时"+(System.currentTimeMillis()-start));
//			//2017-2-9修改，组合计价内的服务执行科室走流向配置，不使用组合计价服务的执行科室 不知道为啥改成这样了，改回去
//			if(CiOrdUtils.isEmpty(setsrv.getId_dep())){
//				srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
//				srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开  
//				srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());
//			}else{
//				//srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
//				srvdo.setId_dep_mp(setsrv.getId_dep());   //待打开  //2016-08-30 注释掉该行 		
//				srvdo.setId_dep_wh(setsrv.getId_dep_wh());
//			}
////			srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   
////			srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   
////			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   
//		}else{}
		//20190309 应武威现场要求，改为临床跟随。后续会改为配置型
		
		if(CiOrdUtils.isEmpty(setsrv.getId_dep())){
			srvdo.setId_dep_mp(ordo.getId_dep_mp());
		}else{
			srvdo.setId_dep_mp(setsrv.getId_dep()); 		
			srvdo.setId_dep_wh(setsrv.getId_dep_wh());
		}
		if(srvdo.getId_org_mp()== null){srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));}
		
		srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId()); // 集团id
		srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId()); // 组织id
		
		srvdo.setFg_feertnable(FBoolean.TRUE);
		srvdo.setStatus(DOStatus.NEW);
		//医嘱项目对应的物品处理
		if(OrSrvSplitUtil.isTrue(prisrvdo.getFg_mm())){
			srvdo.setFg_or(FBoolean.FALSE);
			srvdo.setId_mm( prisrv.getId_mm());
			srvdo.setFg_mm(FBoolean.TRUE);
			OrdSrvMmDO ordSrvMMDO = compPriSrvMM(ordo,srvdo, prisrv, prisrvdo, quan);
			CiOrAttachInfoUtils.addOrdSrvMmDO(ht, srvdo.getId_srv(), ordSrvMMDO);
		}
		
		return srvdo;
	}
	/**
	 * 组合定价的服务为物品时的处理内容
	 * @param ordSrvDO
	 * @param prisrv
	 * @param prisrvdo
	 * @param quan
	 * @return
	 * @throws BizException 
	 */
	private OrdSrvMmDO compPriSrvMM(CiOrderDO ordo,OrdSrvDO ordSrvDO,PriStdSrvDTO prisrv,MedSrvDO prisrvdo,FDouble quan) throws BizException{
		//服务中剂量为换算后的值
		//总量为计算后的值
		String id_mm = prisrv.getId_mm();//物品id
		String id_quan_cur = prisrv.getId_unit();//总量单位
		if(CiOrdUtils.isEmpty(id_mm)){
			throw new BizException(ordo.getName_or()+"维护的组合定价物品不存在");
		}
		FDouble compQuan = prisrv.getQuan();//组合定价中维护的数量
		MeterialDO mmdo = ServiceFinder.find(IMeterialMDORService.class).findById(id_mm);
		if(mmdo == null){
			throw new BizException(ordo.getName_or()+"维护的组合定价物品不存在");
		}
		GetMaterialPriceDTO materialPriceDTO = CiOrdAppUtils.getIMaterialBaseInfoService().MaterialPriceForOt(id_mm, id_quan_cur);
		if(materialPriceDTO==null){
			throw new BizException("");
		}
		//取换算系数，取价格
		FDouble factor = materialPriceDTO.getFactor();
		//单价
		FDouble price = materialPriceDTO.getPrice_act();
		//医基换算系数
		FDouble factor_mb =mmdo.getFactor_mb();
		FDouble quan_medu = quan.multiply(compQuan).multiply(factor_mb).multiply(factor);
		//药品类型的剂量需要换算获得
		ordSrvDO.setQuan_medu(quan_medu);
		MedSrvDrugDO[] medSrvDrugDOs = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, prisrvdo.getId_srv());
		MedSrvDrugDO drugdo = medSrvDrugDOs[0];
		
		OrdSrvMmDO srvmmdo = new OrdSrvMmDO();
		srvmmdo.setStatus(DOStatus.NEW);
		srvmmdo.setId_orsrvmm(new DBUtil().getOIDs(1)[0]);//医嘱服务物品主键标识
		srvmmdo.setId_orsrv(ordSrvDO.getId_orsrv());//医嘱服务项目
		srvmmdo.setId_mm(id_mm); // 医疗物品
		srvmmdo.setCode_mm(mmdo.getCode()); // 物品编码
		srvmmdo.setName_mm(mmdo.getName()); // 物品名称
		srvmmdo.setId_pgku_base(mmdo.getId_unit_pkgbase()); // 基本包装单位
		srvmmdo.setId_dosage(drugdo.getId_dosage()); // 药品剂型
		srvmmdo.setSd_dosage(drugdo.getSd_dosage()); // 药品剂型编码
		srvmmdo.setId_pharm(drugdo.getId_pharm()); // 药理分类
		srvmmdo.setSd_pharm(drugdo.getSd_pharm()); // 药理分类编码
		srvmmdo.setId_pois(drugdo.getId_pois()); // 毒麻分类
		srvmmdo.setSd_pois(drugdo.getSd_pois()); // 毒麻分类编码
		srvmmdo.setId_anti(drugdo.getId_anti()); // 抗菌药分类
		srvmmdo.setSd_anti(drugdo.getSd_anti()); // 抗菌药分类编码
		srvmmdo.setId_mmtp(mmdo.getId_mmtp()); // 物品类型
		srvmmdo.setSd_mmtp(mmdo.getSd_mmtp()); // 物品类型编码
		srvmmdo.setFg_otc(mmdo.getFg_otc()); // OTC标识
		if (ordo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_opmutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_opmutp()); // 包装单位取整模式编码
		} else if (ordo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_mupkgutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_mupkgutp()); // 包装单位取整模式编码
		} else if (ordo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_ermutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_ermutp()); // 包装单位取整模式编码
		} else if (ordo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_er1mutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_er1mutp()); // 包装单位取整模式编码
		} else if (ordo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_er2mutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_er2mutp()); // 包装单位取整模式编码
		} else if(ordo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE)){
			srvmmdo.setId_mupkgutp(mmdo.getId_pipmutp()); 
			srvmmdo.setSd_mupkgutp(mmdo.getSd_pipmutp()); 
		}
		srvmmdo.setId_srv(drugdo.getId_srv()); // 药品服务id
		
		srvmmdo.setId_pgku_cur(id_quan_cur);
		srvmmdo.setPrice_pgku_cur(price);
		CalQuantumBP calQuantumBP = new CalQuantumBP();
		
		srvmmdo.setQuan_cur(calQuantumBP.getMMQuantum(ordo.getSd_srvtp(),srvmmdo.getSd_mupkgutp(), quan_medu, factor_mb, factor,ordo.getDt_effe(), 1, ordo.getId_freq()));
		//给ci_or_srv 重新赋值，保持一致
		ordSrvDO.setQuan_total_medu(calQuantumBP.getMMQuantum(ordo.getSd_srvtp(),srvmmdo.getSd_mupkgutp(), quan_medu, factor_mb, factor,ordo.getDt_effe(), 1, ordo.getId_freq()));
		ordSrvDO.setPri(price);
		try {
			int[] numben = OrSrvSplitUtil.getNumDen(ordSrvDO.getQuan_medu(), factor_mb);
			srvmmdo.setQuan_num_base(numben[0]);
			srvmmdo.setQuan_den_base(numben[1]);
		} catch (NumberFormatException ex) {
			throw new BizException(ordSrvDO.getName_srv() + "服务剂量录入不合法！");
		}
		srvmmdo.setQuan_bed_medu(FDouble.ZERO_DBL);
		srvmmdo.setFactor(factor);
		srvmmdo.setFactor_mb(factor_mb);
		srvmmdo.setId_dosage(drugdo.getId_dosage());
		srvmmdo.setSd_dosage(drugdo.getSd_dosage());
		srvmmdo.setId_pharm(drugdo.getId_pharm());
		srvmmdo.setSd_pharm(drugdo.getSd_pharm());
		srvmmdo.setId_val(mmdo.getId_val());
		srvmmdo.setSd_val(mmdo.getSd_val());
		srvmmdo.setId_pois(drugdo.getId_pois());
		srvmmdo.setSd_pois(drugdo.getSd_pois());
		srvmmdo.setId_anti(drugdo.getId_anti());
		srvmmdo.setSd_anti(drugdo.getSd_anti());
		srvmmdo.setId_mmtp(drugdo.getId_mmtp());
		srvmmdo.setSd_mmtp(drugdo.getSd_mmtp());
		srvmmdo.setId_srv(drugdo.getId_srv());
		return srvmmdo;
	}
	
	/**
	 * 设置医嘱项目数据信息
	 * @param aggdo
	 * @param ems
	 * @param ipos
	 * @param prisrv
	 * @param quan
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO orSrvMmInfoModHandle(CiorderAggDO aggdo,CiEmsDTO ems,Integer ipos,PriStdSrvDTO prisrv,MedSrvDO prisrvdo,FDouble quan,Hashtable ht) throws BizException{
		CiEmsSrvDTO setsrv=(CiEmsSrvDTO)ems.getEmssrvs().get(ipos);
		//下面一行代码注释原因：2016-11-11  代码优化 改进   每个查询耗时将近50ms多  将这部分代码调整到入口参数中以便做批量查询
		//批量查询时，比如10个服务查询时间基本上也是稳定在50ms多一点
		//MedSrvDO prisrvdo=CiOrdAppUtils.getMedsrvMDORService().findById(prisrv.getId_srv());
		OrdSrvDO srvdo=null;  //医嘱项目
		srvdo=CiOrdUtils.getMatchDatum(aggdo.getOrdSrvDO(), setsrv.getId_orsrv()); //组合项目本身
		if(srvdo==null){//组合本身新增     费用项新建
			return createOrSrvMmInfo(aggdo.getParentDO(),ems,ipos,prisrv,prisrvdo,quan,ht);
		}else{
			//if(srvdo.getStatus()==DOStatus.UPDATED){//组合本身是原有的    并且有修改   看费用项目本身情况
				srvdo=CiOrdUtils.getMatchDatum(aggdo.getOrdSrvDO(),srvdo.getId_srv(),prisrv.getId_srv());
				if(srvdo==null){//费用项目本身是新增 则新建
					return createOrSrvMmInfo(aggdo.getParentDO(),ems,ipos,prisrv,prisrvdo,quan,ht);
				}else{//费用项目本身是原有的
					CiEmsSrvDTO emssrvdto=CiOrdUtils.getMatchDatum(ems.getEmssrvs(),setsrv.getId_srv(),prisrv.getId_srv());
					if(emssrvdto!=null){
						if(emssrvdto.getStatus()==DOStatus.DELETED){ //不空且标识成deleted 这里漏洞比较大（组合对应的费用项目目前是不能删除的，如果将来能部分删除费用项目逻辑漏洞比较大）
							return createOrSrvMmInfo(aggdo.getParentDO(),ems,ipos,prisrv,prisrvdo,quan,ht);
						}else{
							//走下面更新逻辑
						}
					}else{
						//return createOrSrvMmInfo(aggdo.getParentDO(),ems,ipos,prisrv,prisrvdo,quan);
					}
				
				}
			}
//		else{//未变化   说明  在 我们始终有该费用项不用在此处再重复处理
//				return null;
//			}
//		}
		CiOrderDO ordo=aggdo.getParentDO();
		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		//srvdo.setId_or(srvdto.getId_or());
		//srvdo.setId_pres(srvdto.getId_pres());
		//srvdo.setId_pat(ordo.getId_pat());
		//srvdo.setId_entp(ordo.getId_entp());
		//srvdo.setCode_entp(ordo.getCode_entp());
		//srvdo.setId_en(ordo.getId_en());
		//srvdo.setSortno(srvdto.getSortno());
		srvdo.setId_srvtp(prisrvdo.getId_srvtp());
		srvdo.setSd_srvtp(prisrvdo.getSd_srvtp());
		srvdo.setId_srv(prisrvdo.getId_srv());
		srvdo.setName(prisrvdo.getName());
		srvdo.setFg_dose_anoma(FBoolean.FALSE);
		srvdo.setQuan_medu(CiOrSrvPriHelper.getPriStdSrvQuan(prisrv).multiply(quan));
		srvdo.setId_medu(prisrvdo.getId_unit_med());
		srvdo.setId_route(prisrvdo.getId_route());
		srvdo.setId_routedes(prisrvdo.getId_routedes());
		srvdo.setId_boil(prisrvdo.getId_boil());
		srvdo.setId_boildes(prisrvdo.getId_boildes());
		srvdo.setId_freq(ordo.getId_freq());
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		//srvdo.setId_dep_mp(getMpDeptID());       //调整到最后
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//srvdo.setDt_last_mp(srvdto.getDt_last_mp());
		//srvdo.setDt_last_cg(getLastDt(setsrv.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setDt_last_bl(ordo.getDt_last_bl());
		srvdo.setFg_or(FBoolean.FALSE);
		srvdo.setEu_blmd(prisrvdo.getEu_blmd());  //本服务定价
		srvdo.setFg_mm(FBoolean.FALSE);
		srvdo.setPri(prisrv.getPrice());
		if (!CiOrdUtils.isEmpty(prisrv.getAttrVal("Pri_std")))
			srvdo.setPri_std((FDouble) prisrv.getAttrVal("Pri_std"));
		if (!CiOrdUtils.isEmpty(prisrv.getAttrVal("Pri_ratio")))
			srvdo.setPri_ratio((FDouble) prisrv.getAttrVal("Pri_ratio"));
		srvdo.setId_pripat(prisrv.getId_pripat());
		srvdo.setFg_set(FBoolean.FALSE);
		//srvdo.setFg_indic(srvdto.getFg_indic());
		srvdo.setFg_propc(FBoolean.FALSE);
		if(!CiOrdUtils.isEmpty(setsrv.getSd_nodispense())){
			if(ICiDictCodeConst.SD_NODISPENSE_SELF.equals(setsrv.getSd_nodispense())){
				srvdo.setFg_self(FBoolean.TRUE);// 2020-3-25 李月龙 添加
				srvdo.setSd_nodispense(ICiDictCodeConst.SD_NODISPENSE_SELF);
				srvdo.setId_nodispense(ICiDictCodeConst.ID_NODISPENSE_SELF);
			}else if(ICiDictCodeConst.SD_NODISPENSE_ENTRUST.equals(setsrv.getSd_nodispense())){
				srvdo.setFg_self(FBoolean.FALSE);
				srvdo.setSd_nodispense(ICiDictCodeConst.SD_NODISPENSE_ENTRUST);
				srvdo.setId_nodispense(ICiDictCodeConst.ID_NODISPENSE_ENTRUST);
			}else if(ICiDictCodeConst.SD_NODISPENSE_FOREIGN.equals(setsrv.getSd_nodispense())){
				srvdo.setFg_self(FBoolean.FALSE);
				srvdo.setSd_nodispense(ICiDictCodeConst.SD_NODISPENSE_FOREIGN);
				srvdo.setId_nodispense(ICiDictCodeConst.ID_NODISPENSE_FOREIGN);
			}
		}else{
			srvdo.setFg_self(FBoolean.FALSE);
		}
		srvdo.setFg_pres_outp(FBoolean.FALSE);
		srvdo.setNote_srv("");
		srvdo.setId_srvca(prisrvdo.getId_srvca());
		if(!CiOrdUtils.isEmpty(srvdo.getSd_nodispense()) || FBoolean.TRUE.equals(srvdo.getFg_self())){
			srvdo.setFg_bl(FBoolean.FALSE);
		}else{
			srvdo.setFg_bl(CiOrdUtils.nullHandle(prisrvdo.getFg_bl()));
		}
		
		srvdo.setCode_srv(prisrvdo.getCode());
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD);
		//srvdo.setId_dep_mp(getMpDeptID(ems,srvdo));   //2016-08-05 注释掉
		//2016-06-28新增字段
		//srvdo.setFg_skintest_rst(Fg_skintest_rst);
		srvdo.setId_primd(prisrvdo.getId_primd());
		srvdo.setFg_selfsrv(prisrvdo.getFg_ctm());
		srvdo.setId_srv_src(CiOrdUtils.getEmsItemIdSrv(ems, ipos));
		//srvdo.setQuan_total_medu(CiOrdUtils.getEmsItemQuanTotalMed(ems, ipos));
		if(CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(), srvdo.getSd_srvtp()).booleanValue()){
			CalQuantumBP bp = new CalQuantumBP();
			srvdo.setQuan_total_medu(bp.getQuantum(srvdo.getQuan_medu(), ems.getTimes_cur()));
		}
		srvdo.setFg_selfpay(setsrv.getFg_selfpay());//2016-07-08新增自费标识  可能是有问题
		srvdo.setId_hp(setsrv.getId_hp());//2016-07-12新增医保相关信息
		srvdo.setId_hpsrvtp(setsrv.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(setsrv.getSd_hpsrvtp());
//		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
//		if(srvdo.getId_dep_mp()== null){
//			exeandwhdeptinfo=getMpDeptID(ordo,ems,setsrv,prisrvdo,null);  //待打开
//			if(CiOrdUtils.isEmpty(setsrv.getId_dep())){
//				srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
//				srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开  //2016-08-30 注释掉该行 
//			}else{
//				//srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
//				srvdo.setId_dep_mp(setsrv.getId_dep());   //待打开  //2016-08-30 注释掉该行 				
//			}
//			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   //待打开
//		}else{}
		if(CiOrdUtils.isEmpty(setsrv.getId_dep())){
			srvdo.setId_dep_mp(ordo.getId_dep_mp());
		}else{
			srvdo.setId_dep_mp(setsrv.getId_dep()); 		
			srvdo.setId_dep_wh(setsrv.getId_dep_wh());
		}
		if(srvdo.getId_org_mp()== null){srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));}

		 
		srvdo.setStatus(DOStatus.UPDATED);
		
		//医嘱项目对应的物品处理
		if(OrSrvSplitUtil.isTrue(prisrvdo.getFg_mm())){
			//应该是不存在这个情况
		}
		
//		srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId()); // 集团id
//		srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId()); // 组织id
		
		//变动用药处理  应该是不存在这个情况
		return srvdo;
			
	}
	
	
	
	private OrWfExDeptParamDTO getOrWfExDeptParam(CiEmsDTO ems,OrdSrvDO srvdo){
		OrWfExDeptParamDTO param=new OrWfExDeptParamDTO();
		param.setCode_entp(ems.getCode_entp());
		param.setSd_srvtp(srvdo.getSd_srvtp());
		param.setId_srvca(srvdo.getId_srvca());
		param.setId_usage(srvdo.getId_route());
		param.setRecurstr(CiOrdUtils.getFg_longStr(ems.getFg_long()));
		//param.setWeekno();
		//param.setTimestr();
		param.setId_srv(srvdo.getId_srv());
		//param.setId_mm();
		param.setId_dept_en(ems.getId_dept_en());
		param.setId_dept_ns(ems.getId_dept_ns());
		param.setId_dept_or(ems.getId_dep_phy());
		//param.setId_dept_ex();
		//param.setReserv1("");  //所属套
		//param.setReserv2();
		//param.setReserv3();		

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
	 * 获得执行科室数据信息
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 * @throws BizException
	 */
	private ExeWhDeptDTO getMpDeptID(CiOrderDO ordo,CiEmsDTO ems,CiEmsSrvDTO srvinsetdo,MedSrvDO prisrvdo,MedSrvRelMmDTO srvrelmmdo) throws BizException{
		ExeDeptCalParamDTO param=getExeDeptCalParamDTO(ordo,ems,srvinsetdo,prisrvdo,srvrelmmdo);
		return CiOrdUtils.getMpDeptID(param);
	}
	
	/**
	 * 获得执行科室计算参数信息DTO
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 */
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiOrderDO ordo,CiEmsDTO ems,CiEmsSrvDTO compsrvdto,MedSrvDO prisrvdo,MedSrvRelMmDTO srvrelmmdo){
		ExeDeptCalParamDTO paramdto=new ExeDeptCalParamDTO();
		paramdto.setCode_entp(ems.getCode_entp());
		paramdto.setId_dep_en(ems.getId_dept_en());
		paramdto.setId_dep_or(ems.getId_dep_phy());
		paramdto.setId_dep_ns(ems.getId_dept_ns());
		paramdto.setId_dep_exe(ordo.getId_dep_mp());
		paramdto.setFg_long(ems.getFg_long());
		paramdto.setId_srv(prisrvdo.getId_srv());
		if(!CiOrdUtils.isEmpty(srvrelmmdo)){
		paramdto.setId_mm(srvrelmmdo.getId_mm());}
		paramdto.setSd_srvtp(prisrvdo.getSd_srvtp());
		paramdto.setId_srvca(prisrvdo.getId_srvca());
		paramdto.setInnercode_srvca(prisrvdo.getSrvca_innercode());
		paramdto.setId_route(prisrvdo.getId_route());
		paramdto.setDt_effe(ordo.getDt_effe());
		//paramdto.setDef1();
		//paramdto.setDef2();
		//paramdto.setDef3();
		//paramdto.setDef4();
		//paramdto.setDef5();
		if(!CiOrdUtils.isTrue(prisrvdo.getFg_mm())){
			paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW);  //只求执行科室
		}else{
			paramdto.setEu_wftp(EnumFlow.NULL);   //求物资流向科室
		}
		
		return paramdto;
	}
	
}
