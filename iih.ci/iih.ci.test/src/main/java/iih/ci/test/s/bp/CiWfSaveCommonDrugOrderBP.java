package iih.ci.test.s.bp;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.test.utils.FreqInfoUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

public class CiWfSaveCommonDrugOrderBP {
	/**
	 * 拼装普药CiEmsDTO
	 * @param id_ent 就诊id
	 * @param id_emp 人员id
	 * @param id_org 组织id
	 * @param id_dep 部门id
	 * @param id_grp 集团id
	 * @param ent4bannerdto 就诊banner里面有一些患者就诊的基础信息
	 * @return
	 * @throws BizException 
	 */
	public CiEmsDTO exec(CiEmsDTO dto,Ent4BannerDTO ent4bannerdto,MedSrvDO medsrv,String id_org,String id_grp,String id_dep) throws BizException{
		SaveApDrug(dto, medsrv, ent4bannerdto, id_org, id_grp);
		FArrayList list = SaveOrDrugEmsItemToDto(dto, medsrv, ent4bannerdto, id_org, id_grp, id_dep);
		dto.setEmssrvs(list);
		return dto;
	}
	
	
	
	/**
	 * 通过基础数据和banner拼装CiEmsDTO
	 * @param dto ciemsdto 保存的入参
	 * @param medsrv 基础数据
	 * @param ent4bannerdto
	 * @param id_org
	 * @param id_grp
	 */
	private void SaveApDrug(CiEmsDTO dto,MedSrvDO medsrv,Ent4BannerDTO ent4bannerdto,String id_org,String id_grp)
    {
		//获取时间类
		TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
        dto.setFg_long(FBoolean.FALSE); //长临标识	 	 				 	 	 	 	 	 				 	 			 	 	 			 	 	 	 	 	 				 	 			 	 	 	
        dto.setId_freq("@@@@Z7100000000D0OYS");	        //医嘱频次	REF	医嘱频次定义	 	 	
        dto.setName_freq("一次");    //医嘱频次名称	SINGLE	String	 	
        dto.setSd_frequnitct("0");
        dto.setFreqct(1);
        dto.setFrequnitct(1);
        dto.setId_route("0001Z8100000000MICNM");	    //用法	REF	医疗服务_医疗用法	 	 	
        dto.setName_route("口服");    //用法名称	SINGLE	String	 	
        //dto.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes;	    //用法要求	REF	医疗用法要求	 	 	 	
        //dto.Name_routedes = emsHeadDO.Emsdrugs.Name_routedes;	//用法要求描述	SINGLE	String	 	
        //dto.Id_boil = emsHeadDO.Emsdrugs.Id_boil;	        // 煎法	REF	医疗服务中药煎法	 	 	 	 	
        //dto.Name_boil = emsHeadDO.Emsdrugs.Name_boil;	    //煎法名称	SINGLE	String	 	
        //dto.Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;	    //煎法要求	REF	中药煎法要求	 	 	 	
        //dto.Name_boildes = emsHeadDO.Emsdrugs.Name_boildes;	//煎法要求名称	SINGLE	String	 	
        //dto.Fg_boil	=          //代煎标识	SINGLE	FBoolean 	 	
        //dto.Days_or = emsHeadDO.Emsdrugs.Use_days;        //医嘱天数	SINGLE	Integer	 	
        
        dto.setDt_begin(ts.getUFDateTime());//ts.getUFDateTime() 获取系统当前时间
        dto.setDt_end(ts.getUFDateTime());
        //dto.Days_or = emsHeadDO.Emsdrugs.Use_days;
        //dto.Times_cur = emsHeadDO.Emsdrugs.Times_cur;
        //dto.Fg_mp_in = emsHeadDO.Emsdrugs.Fg_mp_in;	            //在院执行标识	SINGLE	 	 	 	 	
        //dto.Times_mp_in = emsHeadDO.Emsdrugs.Times_mp_in;      //在院执行次数
        //dto.Orders = emsHeadDO.Emsdrugs.Orders;	        //医嘱付数	SINGLE	Integer	 	
        //dto.Orders_boil = emsHeadDO.Emsdrugs.Orders_boil;	    //代煎付数	SINGLE	Integer	 	
        //if (emsHeadDO.Emsdrugs.Orders_boil != null && emsHeadDO.Emsdrugs.Orders_boil > 0)
        //{
        //    dto.Fg_boil = true;
        //    dto.Name_dep_mp = "";
        //}
        //else {
        //    dto.Fg_boil = false;
        //}
        //dto.Content=	        //医嘱内容	SINGLE	备注	4000 	
        //dto.Note	        //备注	SINGLE	备注	1000	 
        dto.setId_emp_phy(ent4bannerdto.getId_emp_phy());	    //开立医生	REF	人员基本信息	 	
        //dto.Name_emp_phy	//开立医生姓名	SINGLE	String	 	
        dto.setId_dep_phy(ent4bannerdto.getId_dep_phy());    //开立科室	REF	部门	20	 	 
        //dto.Name_dep_phy	//开立科室名称	SINGLE	String	 	
        dto.setId_wg_or(id_grp);   //医疗组	REF	业务组	20	业务 
        //dto.Dt_begin = emsHeadDO.Emsdrugs.Dt_begin_ui;	    //开始日期	SINGLE	FDateTim 	 	
        //dto.Dt_end = emsHeadDO.Emsdrugs.Dt_end_ui;	        //结束日期	SINGLE	FDateTim 	 	
        //dto.Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;    //医嘱过期时间	SINGLE	FDateTim
        dto.setNote(""); 
        //dto.Fg_bb	        //婴儿标识	SINGLE	FBoolean 	 	
        //dto.No_bb	        //婴儿序号	SINGLE	Integer	 	
        dto.setFg_pmor(FBoolean.FALSE);        //备用医嘱标识	SINGLE	FBoolean 	 	
        //dto.Des_pmor = emsHeadDO.Emsdrugs.Bak_des;	    //备用医嘱使用条件描述	SINGLE	 	 	
        //dto.Fg_active_pm= //备用医嘱启用标识	SINGLE	FBoo 	 	 	
        //dto.Id_reltp	    //关联医嘱类型编码	SINGLE	Stri 	 	
        //dto.Sd_reltp	    //关联医嘱类型	SINGLE	String	 	
        //dto.Id_or_rel	    //关联医嘱	SINGLE	String	 	
        //dto.Fg_ctlcp	    //临床路径控制标识	SINGLE	FBoo 	 	 	
        //dto.Fg_mr	        //医疗记录联动标识	SINGLE	FBoo 	 	 	
        //dto.Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;	    //需皮试标识	SINGLE	FBoolean 	 	
        //dto.Id_skintest_skip_reaso	//不皮试原因	SINGLE	 	 	 	
        //dto.Sd_skintest_skip_reaso	//不皮试原因编码	SING 	 
        //dto.Times_cur = LogicEx.GetInstance().GetDrugUseTotalCount(emsHeadDO);
        
        //dto.Times_mp_in	            //在院执行次数	SINGLE	 	 	 	
        //dto.Fg_mp_bed=emsHeadDO.Emsdrugs	            //床边执行标识	SINGLE	
        //dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
        //dto.Times_firday_mp = emsHeadDO.Emsdrugs.Quan_firday_mp;        //首日执行次数	SINGLE	 	 	 	
        dto.setFg_or_doc(FBoolean.TRUE);	            //医生医嘱标识	SINGLE	
        //dto.setId_dep_mp(); = emsHeadDO.Emsdrugs.Id_dep;//医嘱层面的执行科室 2016-08-03 zwq
        
        //EmsOrDrug ems = emsHeadDO.Emsdrugs.EmsOrDrugList.FirstOrDefault(p=>!p.IsDELETED); 
        //if (ems != null)
        //{
        //    dto.Id_srv = ems.Id_srv;   //zwq 2016-07-15 药品医疗单的id_srv取服务项目的第一个 
            //dto.Name = ems.Name_srv;
        //}
        dto.setName(medsrv.getName());
        // 药品超量开单原因
        //dto.Id_excessive_reason = emsHeadDO.Emsdrugs.Id_excessive_reason;
        //dto.Sd_excessive_reason = emsHeadDO.Emsdrugs.Sd_excessive_reason;
        dto.setId_unit_med("@@@@Z7100000000NY3YK");
        dto.setName_unit_med("克");
        dto.setQuan_medu(new FDouble("0.25"));
    }

	/**
	 * 拼装CiEmsDTO
	 * @param dto
	 * @param medsrv
	 * @param ent4bannerdto
	 * @param id_org
	 * @param id_grp
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public FArrayList SaveOrDrugEmsItemToDto(CiEmsDTO dto,MedSrvDO medsrv,Ent4BannerDTO ent4bannerdto,String id_org,String id_grp,String id_dep) throws BizException
    {
		TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
        FArrayList list = new FArrayList();
        //foreach (EmsOrDrug p in emsHeadDO.Emsdrugs.EmsOrDrugList)
        //{
            CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
            srvdto.setEu_sourcemd(0); //医疗单项目数据来源 
           // srvdto.Eu_sourcemd = 0;	     
//            CiEmsSrvDTO srv = flist.FirstOrDefault(x => x.Id_srv == p.Id_srv && x.Id_orsrv==p.Id_orsrv);
//            
//            if (srv != null)
//            {
//                srvdto = srv;
//                if (p.IsDELETED)
//                {
//                    srvdto.SetDeleted();
//                }
//                else {
//                    srvdto.SetUpdated();
//                }
//            }
//            else {// 增加该逻辑分支   针对 已保存的 医嘱项目 进行服务项目的修改 -- 2016-11-21 by wangqz
//                if (!string.IsNullOrEmpty(p.Id_orsrv)){
//                    srvdto.Status = DOStatus.UPDATED;
//                }
//            }
//            ;

            //srvdto.Id_orsrv = p.Id_orsrv;       //医疗单项目主键标识 
            //srvdto.Id_or	=                   //医疗单	SINGLE	F 
            //srvdto.Sortno = p.Sortno;	         //序号	SINGLE	I 
            srvdto.setId_srv(medsrv.getId_srv());	         //医疗服务	REF	 
           
            srvdto.setId_unit_med(medsrv.getId_unit_med());	     //医疗单位	REF
            //查询物品单位
            IMeasdocRService measdocService = ServiceFinder.find(IMeasdocRService.class);
            //剂量单位
            MeasDocDO measdoc = measdocService.findById(medsrv.getId_unit_med());
            srvdto.setName_unit_med(measdoc.getName());  //医疗单位编码	SINGL 
            srvdto.setQuan_med(medsrv.getQuan_med());	     //剂量	SINGLE	F 
            srvdto.setId_primd(medsrv.getId_primd());
            DAFacade dafacade = new DAFacade();
            //价格计算服务方法
            IPriCalService priService = (IPriCalService)ServiceFinder.find(IPriCalService.class);
            FDouble pri = priService.CalSingleSrvStdPrice(medsrv.getId_srv());
            srvdto.setPrice(pri);        //参考价格	SINGL 
            srvdto.setId_freq(medsrv.getId_freq());	         //医嘱频次	REF
           
            srvdto.setFreqct(FreqInfoUtils.GetFreqct(medsrv.getId_freq()));
            srvdto.setSd_frequnitct(FreqInfoUtils.GetSdFrequnitct(medsrv.getId_freq()));//zwq 2016-09-06
            srvdto.setName_freq(FreqInfoUtils.GetNameFreq(medsrv.getId_freq()));	     //医嘱频次名称	SINGL 
            srvdto.setId_route(medsrv.getId_route());	      //用法标识	REF	
            if(medsrv.getId_route() != null){
            	//用法服务
            	IMedusageRService meduseService = ServiceFinder.find(IMedusageRService.class);
            	MedUsageDO meduse = meduseService.findById(medsrv.getId_route());
            	srvdto.setName_route(meduse.getName());	      //用法	SINGLE	S 
            }
            //srvdto.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes;	      //用法要求标识	REF	  	 
            //srvdto.Name_routedes = emsHeadDO.Emsdrugs.Name_routedes;	  //用法要求	SINGL 
            srvdto.setId_boil(medsrv.getId_boil());	          //煎法标识	REF
            if(medsrv.getId_boil() != null){
            	ICherbboilmdMDORService boilService = ServiceFinder.find(ICherbboilmdMDORService.class);
            	CHerbBoilMdDO boil = boilService.findById(medsrv.getId_boil());
            	srvdto.setName_boil(boil.getName());	      //煎法	SINGLE	S 
            }
            //srvdto.Id_boildes = p.Id_boildes;	      //煎法要求标识	REF	  	
            //srvdto.Name_boildes = p.Name_boildes;	  //煎法要求	SINGL 
            srvdto.setFg_dose_anoma(FBoolean.FALSE);	  //变动用药标识	SINGL  	
            //srvdto.//Des_srv	          //备注	SINGLE	 

            //srvdto.Fg_outp = fg_out;	          //出院带药标识	SINGL  	zwq 2016-08-11
            srvdto.setFg_bl(medsrv.getFg_bl()); // 
            //srvdto.//Id_org_srv	      //开立机构	SINGL 
            //srvdto.//Id_dep_srv	      //开立科室	SINGL 
            //srvdto.//Id_ward_srv	      //开立病区	SINGL 
            //srvdto.//Id_emp_srv	      //开立人员	SINGL 
            srvdto.setDt_create_srv(ts.getUFDateTime());  //开立时间	SINGL 
            //srvdto.//Dt_last_bl	      //最近生成日期	SINGL 
            //srvdto.Eu_blmd	          //划价方式	SINGL 
            //srvdto.Id_orsrvmm = p.Id_emsordrug;	      //服务项目物品	SINGL
            if(medsrv.getFg_mm().booleanValue()){
            	//医疗物品服务
            	IMeterialMDORService mmService = ServiceFinder.find(IMeterialMDORService.class);
            	MeterialDO[] mms = mmService.find(" id_srv='"+medsrv.getId_srv()+"'", null, FBoolean.FALSE);
            	if(mms != null && mms.length >0){
            		MeterialDO mm = mms[0];
            		srvdto.setId_mm(mm.getId_mm());	          //物品	SINGLE	 
            		srvdto.setCode_mm(mm.getCode());	          //物品编码	SINGL 
            		srvdto.setName_mm(mm.getSpec()+"【"+mm.getName()+"】");	          //物品名称	SINGL 
            		srvdto.setSpec_mm(mm.getSpec());
            		IMMPackageUnitDORService mmpkuService = ServiceFinder.find(IMMPackageUnitDORService.class);
            		MMPackageUnitDO[] mmpkus = mmpkuService.find(" id_mm='"+mm.getId_mm()+"'", null, FBoolean.FALSE);
            		if(mmpkus != null && mmpkus.length>0){
            			for (MMPackageUnitDO mmPackageUnitDO : mmpkus) {
							if(mmPackageUnitDO.getId_unit_pkg().equals(mm.getId_unit_pkgsp())){
								srvdto.setId_unit_sale(mmPackageUnitDO.getId_unit_pkg());	  //零售单位	REF	 
								srvdto.setName_unit_sale(mmPackageUnitDO.getMmpkguname());	  //零售单位名称	SINGL 
								
							}else if(mmPackageUnitDO.getId_unit_pkg().equals(mm.getId_unit_pkgbase())){
								srvdto.setFactor_cb(mmPackageUnitDO.getFactor());
								srvdto.setId_unit_base(mmPackageUnitDO.getId_unit_pkg());  //基本单位	REF	 
								srvdto.setName_unit_base(mmPackageUnitDO.getMmpkguname());	  //基本单位名称	SINGL 
							}
						}
            		}
            		srvdto.setFactor_mb(mm.getFactor_mb());	 
            		srvdto.setId_val(mm.getId_val());          //价值分类	SINGL 
                    srvdto.setSd_val(mm.getSd_val());	          //价值分类编码	SINGL 
                    srvdto.setId_mupkgutp(mm.getId_mupkgutp());// 住院取证模式
                    srvdto.setSd_mupkgutp(mm.getSd_mupkgutp()); // 住院取整模式
                    srvdto.setId_opmutp(mm.getId_opmutp());// 门诊取整模式
                    srvdto.setSd_opmutp(mm.getSd_opmutp());// 门诊取整模式
            	}
            	srvdto.setQuan_den_base(1);	  //单次数量_分母	S 

            }
            //srvdto.Spec_mm	          //规格	SINGLE	S 
            //srvdto.Quan_num_base = p.Quan_base;	  //单次数量_分子	S  	 	 	
            srvdto.setPrice_cur(pri);	      //参考价当前	SINGL 
            //srvdto.setQuan_cur = p.Quan_cur;	      //总量_当前	SINGL 
            //srvdto.Quan_base = p.Quan_base;      //总量_基本	SINGL 
            //srvdto.Quan_total_medu = srvdto.Quan_cur;
            srvdto.setQuan_bed_medu(FDouble.ZERO_DBL);	  //床边量_医学	SINGL 
            //if (p.Fg_ctm != null && p.Fg_ctm == true) // 处理药品自定义服务总量
            //{
            //    srvdto.Quan_total_medu = p.Quan_cur;
            //}
            //srvdto.Factor_cb = p.Factor_cb;	      //当前基本换算系数	S  
            //srvdto.Factor_cb = LogicEx.GetInstance().getDrugFactor(p.Id_mm,p.Id_unit_sale);
                 //医疗基本换算系数	S  	 	
//            IRoutedosageRService dosageService = ServiceFinder.find(IRoutedosageRService.class);
//            RouteDosageRefDO[] dosages = dosageService.find(" id_route ='"+medsrv.getId_route()+"'", null, FBoolean.FALSE);
//            if(dosages != null && dosages.length>0){
//            	RouteDosageRefDO dosage = dosages[0];
//            	
//            }
            //医疗服务药品属性服务
            IMedSrvDrugDORService medsrvdrugService = ServiceFinder.find(IMedSrvDrugDORService.class);
            MedSrvDrugDO[] medsrvdrugs = medsrvdrugService.find("id_srv='"+medsrv.getId_srv()+"'", null, FBoolean.FALSE);
            if(medsrvdrugs != null && medsrvdrugs.length >0){
            	MedSrvDrugDO medsrvdrug = medsrvdrugs[0];
            	srvdto.setId_dosage(medsrvdrug.getId_dosage());	      //药品剂型	SINGL 
            	srvdto.setSd_dosage(medsrvdrug.getSd_dosage());	      //药品剂型编码	SINGL 
            	srvdto.setId_pois(medsrvdrug.getId_pois());          //毒麻分类	SINGL 
            	srvdto.setSd_pois(medsrvdrug.getSd_pois());	          //毒麻分类编码	SINGL 
            	srvdto.setId_anti(medsrvdrug.getId_anti());	          //抗菌药分类	SINGL 
            	srvdto.setSd_anti(medsrvdrug.getSd_anti());	          //抗菌药分类编码	S 
            	srvdto.setId_mmtp(medsrvdrug.getId_mmtp());	          //物品类型	SINGL 
            	srvdto.setSd_mmtp(medsrvdrug.getSd_mmtp());	         //物品类型编码	SINGL 
            	
            }
            //srvdto.Id_pharm = p.Id_pharm;	      //药理分类	SINGL 
            //srvdto.Sd_pharm = p.Sd_pharm;	      //药理分类编码	SINGL 
            
            srvdto.setFg_self(FBoolean.FALSE);//自备药标识 UI界面勾选	SINGL  	
            srvdto.setFg_propc(FBoolean.FALSE);//预防用药标识	SINGL
            srvdto.setFg_indic(FBoolean.FALSE);// = p.Fg_treat;//治疗用药标识	SINGL  	
            srvdto.setId_dep(id_dep);// = p.Id_mp_dep;//执行科室	REF	 
            //srvdto.Name_dep = p.Name_mp_dep;//执行科室	REF	 
            srvdto.setDes_srv("");// = p.Note_or;
            //皮试内容
            srvdto.setFg_skintest(FBoolean.FALSE);// = p.Fg_skintest;false
            //srvdto.Id_skintest_skip_reason = p.Id_skintest_skip_reason;null
            //srvdto.Fg_skintest_mm = p.Fg_skintest_mm;//物品在定义态时的皮试标志null
            //srvdto.Sd_reltp = p.Sd_reltp;null
            //srvdto.Id_or_rel = p.Id_or_rel;null
            srvdto.setFg_mm(medsrv.getFg_mm());// = p.Fg_mm;true
            srvdto.setFg_selfsrv(FBoolean.FALSE);// = p.Fg_ctm;false
            srvdto.setFg_selfpay(FBoolean.TRUE);// = p.Fg_selfpay; // 自费标志true
            srvdto.setName_srv(medsrv.getName());// = p.Name_srv;
            srvdto.setId_dep_wh(id_dep); //= p.Id_dep_wh;//库房id 2016-08-03 zwq
            //srvdto.Fg_extdispense = p.Fg_extdispense;//外配药标识null
//            if (srvdto.IsNEW)
//            {
                //MedSrvDO medSrvDO = medService.findById(p.Id_srv);
                srvdto.setId_srvtp(medsrv.getId_srvtp());// = medSrvDO.Id_srvtp;	     //服务类型	REF	 		 	 	 
                srvdto.setSd_srvtp(medsrv.getSd_srvtp());// = medSrvDO.Sd_srvtp;     //服务类型编码	SINGL 
                srvdto.setCode_srv(medsrv.getCode());// = medSrvDO.Code;	     //医疗服务编码	SINGL 
                srvdto.setName_srv(medsrv.getName());// = p.Name_srv;	     //医疗服务名称	SINGL 
                srvdto.setId_srvca(medsrv.getId_srvca());// = medSrvDO.Id_srvca;	     //服务项目基本分类	S 
                srvdto.setFg_mm(medsrv.getFg_mm());// = medSrvDO.Fg_mm;	          //物品标识	SINGL 
                srvdto.setFg_set(medsrv.getFg_set());// = medSrvDO.Fg_set;	          //服务套标识	SINGL  	
                srvdto.setFg_or(medsrv.getFg_or());// = medSrvDO.Fg_or;	          //医嘱标识	SINGL 
                srvdto.setInnercode_srvca(medsrv.getSrvca_innercode());// = medSrvDO.Srvca_innercode;//服务分类内部编码
                //srvdto.Fg_bl	          //费用标识	SINGL 
                //srvdto.Id_srv_set	     //所属服务套	SINGL 


                srvdto.setId_hp(ent4bannerdto.getId_hp());// = p.Id_hp;//医保计划id zwq 2016-07-12
                //srvdto.setId_hpsrvtp(ent4bannerdto.ge); = p.Id_hpsrvtp;//医保目录类型 zwq 2016-07-12
                //srvdto.Sd_hpsrvtp = p.Sd_hpsrvtp;//医保目录类型编码 zwq 2016-07-12
                //srvdto.Eu_hpdoctorjudge = p.Eu_hpdoctorjudge;//医生是否已判断医保标志
                //srvdto.Limit = p.Limit;
                srvdto.setEu_blmd(medsrv.getEu_blmd());// = medSrvDO.Eu_blmd;
                //srvdto.Emsagentinfo = p.Agentinfolist;//毒麻药品时核对的患者信息
                //SaveDoseDrug(emsHeadDO,srvdto);
            //}
//            else if (srv == null && !string.IsNullOrEmpty(p.Id_orsrv) && srvdto.IsUPDATED) {// 增加该逻辑分支   针对 已保存的 医嘱项目 进行服务项目的修改 -- 2016-11-21 by wangqz
//                if (!p.IsDELETED) {
//                    IMedsrvMDOCrudService medService = XapServiceMgr.find<IMedsrvMDOCrudService>();
//                    MedSrvDO medSrvDO = medService.findById(p.Id_srv);
//                    srvdto.Id_srvtp = medSrvDO.Id_srvtp;	     //服务类型	REF	 		 	 	 
//                    srvdto.Sd_srvtp = medSrvDO.Sd_srvtp;     //服务类型编码	SINGL 
//                    srvdto.Code_srv = medSrvDO.Code;	     //医疗服务编码	SINGL 
//                    srvdto.Name_srv = p.Name_srv;	     //医疗服务名称	SINGL 
//                    srvdto.Id_srvca = medSrvDO.Id_srvca;	     //服务项目基本分类	S 
//                    srvdto.Fg_mm = medSrvDO.Fg_mm;	          //物品标识	SINGL 
//                    srvdto.Fg_set = medSrvDO.Fg_set;	          //服务套标识	SINGL  	
//                    srvdto.Fg_or = medSrvDO.Fg_or;	          //医嘱标识	SINGL 
//                    srvdto.Innercode_srvca = medSrvDO.Srvca_innercode;//服务分类内部编码
//                    //srvdto.Fg_bl	          //费用标识	SINGL 
//                    //srvdto.Id_srv_set	     //所属服务套	SINGL 
//
//
//                    srvdto.Id_hp = p.Id_hp;//医保计划id zwq 2016-07-12
//                    srvdto.Id_hpsrvtp = p.Id_hpsrvtp;//医保目录类型 zwq 2016-07-12
//                    srvdto.Sd_hpsrvtp = p.Sd_hpsrvtp;//医保目录类型编码 zwq 2016-07-12
//                    
//                    srvdto.Eu_blmd = medSrvDO.Eu_blmd;
//                    srvdto.Emsagentinfo = p.Agentinfolist;//毒麻药品时核对的患者信息
//                    SaveDoseDrug(emsHeadDO, srvdto);   
//                }
//            }
//            srvdto.Fg_hpindicjudged = p.Fg_hpindicjudged;0
           //srvdto.Fg_hpindicjudged = judgeHpindicjudg(p);
                srvdto.setDays_available(getDaysAvalidate(srvdto.getSd_opmutp(), srvdto.getQuan_cur(), srvdto.getQuan_bed_medu(), srvdto.getFactor_cb(), srvdto.getFactor_mb(), srvdto.getId_freq()));
            //srvdto.setDays_available
            //getDaysAvalidate(srvdto.getSd_opmutp, p.Quan_cur, p.Quan_med, p.Factor_cb, p.Factor_mb, emsHeadDO.Emsdrugs.Id_freq);
           
            list.add(srvdto);

        //}
        //药品医疗单删除的条目
//            XapDataList<EmsOrDrug> delItems = emsHeadDO.Emsdrugs.EmsOrDeleteDrugList;
//        if (delItems != null)
//            foreach (EmsOrDrug ems in delItems)
//            {
//                CiEmsSrvDTO ciEmsSrvDTO = flist.FirstOrDefault<CiEmsSrvDTO>(e => e.Id_orsrv == ems.Id_orsrv);//2016-07-06zwq 因为自定义服务存在，修改取对象条件：e.Id_srv==ems.Id_srv --> e.Id_orsrv==ems.Id_orsrv。
//                if (ciEmsSrvDTO != null)
//                {
//                    ciEmsSrvDTO.Status = DOStatus.DELETED;
//                    list.Add(ciEmsSrvDTO);
//                }
//                    
//            }

        return list;
    }
	
	private int getDaysAvalidate(String Sd_opmutp, FDouble quan_cur, FDouble quan_medu, FDouble factor,
			FDouble factor_mb, String id_freq) throws BizException {
		if (quan_cur == null || quan_medu == null || factor == null || factor_mb == null || id_freq == null)
			return 0;
		return ServiceFinder.find(ICiOrdMaintainService.class).getDaysAvalidate(Sd_opmutp, quan_cur, quan_medu, factor,
				factor_mb, id_freq);
	}
}
