package iih.ci.test.s;


import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.service.i.IPpQueService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.InHpBbrEnum;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.test.i.ICiWfMainService;
import iih.ci.test.s.bp.CiWfSaveCommonDrugOrderBP;
import iih.ci.test.utils.FreqInfoUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;

@Service(serviceInterfaces = { ICiWfMainService.class }, binding = Binding.JSONRPC)
public class CiWfMainServiceImpl implements ICiWfMainService {
	//普药
	private static String COMMONDRUG = "commondrug";
	//草药
	private static String HERB = "herb";
	//注射类药品
	private static String SHOTDRUG = "shotdrug";
	//治疗
	private static String TREAT = "treat";
	//检查 非服务套
	private static String RIS = "ris";
	//检查服务套
	private static String SETRIS = "setris";
	//检验非服务套
	private static String LIS = "lis";
	//检验服务套
	private static String SETLIS = "setlis";
	@Override
	public CiOrderDO saveIPCiOrder(String emstype, String id_ent, String id_emp, String id_org, String id_dep,
			String id_grp, Ent4BannerDTO ent4bannerdto,String[] idsrvs) throws BizException {
		JudgeOrderStatusInMultiUser(ent4bannerdto);
		ICiOrdMaintainService service = ServiceFinder.find(ICiOrdMaintainService.class);
		CiEmsDTO ciemsdto = new CiEmsDTO();
		CiEnContextDTO ciencontextdto = getCiEnContext(id_ent, id_emp, id_org, id_dep, id_grp, ent4bannerdto);
		if (FBoolean.TRUE.equals(ciencontextdto.getFg_hpfundpay()))
        {
            //ICidiagQryService cidiagQryService = XapServiceMgr.find<ICidiagQryService>();
            // 判断是否存在保外诊断
            //CiDiagItemDO[] cidiagItems = cidiagQryService.getHpjudgetpCiDiagItems(ent4BannerDTO.Id_ent);
            //CiEnContextUtil.SetHpCiDiagItem(contextDTO, cidiagItems);
        }
		//校验频次
		List<String> errorlist = validateFreqAndUnitmed(ciemsdto);
		if (errorlist != null && errorlist.size()>0) return null;
		//设置医保信息
		setHpInfo(ciemsdto, ent4bannerdto.getId_hp());
		//根据id_srv 获取medsrv
		IMedsrvMDORService medsrvservice = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medsrvs = medsrvservice.findByBIds(idsrvs, FBoolean.FALSE);
		for (MedSrvDO medsrv : medsrvs) {
			saveCiDTO(ciemsdto, ent4bannerdto, medsrv, emstype, id_org, id_grp, id_dep);
			//医嘱保存
			CiOrderDO[] ciorderdo = service.SaveCiEmsDTO_TL(ciemsdto, ciencontextdto);
			if(ciorderdo != null && ciorderdo.length>0) return ciorderdo[0];
		}
		
		return null;
		
	}
	
	private void saveCiDTO(CiEmsDTO dto,Ent4BannerDTO ent4bannerdto,MedSrvDO medsrv,String emstype,String id_org,String id_grp,String id_dep) throws BizException{
		// 医嘱来源：服务参照
        dto.setEu_orsrcmdtp(OrSourceFromEnum.IIHSRVREF);
        //通用数据设置
        SaveDtoCommonDataBing(dto, ent4bannerdto, medsrv);
        CiEmsSrvDTO srvCommon = new CiEmsSrvDTO();
        SaveCommonSrvDataBing(srvCommon, ent4bannerdto, medsrv);
        if(emstype != null && COMMONDRUG.equals(emstype)){
        	
			CiWfSaveCommonDrugOrderBP common = new CiWfSaveCommonDrugOrderBP();
			common.exec(dto, ent4bannerdto,medsrv,id_org,id_grp,id_dep);
			
        }else if(emstype != null && RIS.equals(emstype)){
        	//TODO 将前端检查拼装数据的程序转移到这里
        }else if(emstype != null && LIS.equals(emstype)){
        	//TODO 将前端检验拼装数据的程序转移到这里
        }else if(emstype != null && HERB.equals(emstype)){
        	//TODO 将前端草药拼装数据的程序转移到这里
        }else if(emstype != null && TREAT.equals(emstype)){
        	//TODO 前端治疗拼装数据程序转到到这
        }
	}
	
	private void SaveCommonSrvDataBing(CiEmsSrvDTO srv, Ent4BannerDTO ent4bannerdto,MedSrvDO medsrv)
    {
			TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
            srv.setCode_srv(medsrv.getCode());
            srv.setId_srv(medsrv.getId_srv());
            srv.setId_srvca(medsrv.getId_srvca());
            srv.setId_srvtp(medsrv.getId_srvtp());
            srv.setSd_srvtp(medsrv.getSd_srvtp());
            srv.setEu_blmd(medsrv.getEu_blmd());
            srv.setDt_create_srv(ts.getUFDateTime()); //开立时间	      SINGL 
            //srv.Id_org_srv = UserManager.getInstance().CurrentGroup.Id_grp;	      //开立机构	SINGL 
            //srv.Id_dep_srv = UserManager.getInstance().CurrentDept.Id_dep;      //开立科室	SINGL 
            //srv.Id_ward_srv = UserManager.getInstance().CurrentDept.Id_dep;      //开立病区	SINGL 
            //srv.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_psn;	      //开立人员	SINGL 

            srv.setEu_sourcemd(0);
            srv.setFg_bl(medsrv.getFg_bl());
    }
	
	private void SaveDtoCommonDataBing(CiEmsDTO dto, Ent4BannerDTO ent4bannerdto,MedSrvDO medsrv)
    {
        //dto.Id_or	        
        //dto.Id_or = emsHeadDO.Id_or;
        dto.setFg_cp(null);// = emsHeadDO.Fg_cp;
        dto.setId_pat(ent4bannerdto.getId_pat());
        dto.setId_en(ent4bannerdto.getId_ent());
        dto.setId_entp(ent4bannerdto.getId_entp());
        dto.setCode_entp(ent4bannerdto.getCode_entp());
        dto.setFuncclassstr("e0RsbDooaWloLmNpLm9yZC5kbGwpLENsYXNzcGF0aF9kbGw6KGlpaC5jaS5vcmQuY2lvcmRlci5jYXJkcy5FeHRPcmRlckRydWdzVmlldyksSmFyOihpaWguY2kub3JkLmphciksQ2xhc3NwYXRoX2phcjooaWloLmNpLm9yZC5FbXRweURyaXZlciksRW1zdHlwZTooMCksU3RhdHVzOigyKSxEaXJ0eTooZmFsc2UpfQ==");
        dto.setId_srvof("0001Z8100000000MLQDF");//普药医疗单id
        dto.setId_srvca(medsrv.getId_srvca());
        dto.setInnercode_srvca(medsrv.getSrvca_innercode());
        //dto.Id_srv_pkg	    
        dto.setEmstype(0);//普药 需要放入特性处理
        //dto.Id_primd = emsHeadDO.MedSrvDO.Id_primd;
        dto.setId_dept_en(ent4bannerdto.getId_dep_phy());
        dto.setId_dept_ns(ent4bannerdto.getId_dep_nur());
        dto.setId_dep_phy(ent4bannerdto.getId_dep_phy());

        //dto.Dt_begin = CommonExtentions.NowTime(this);
        //从EmsHeadDTO中获得
        //dto.Dt_begin = emsHeadDO.Dt_begin_ui;
        //dto.Dt_end = emsHeadDO.Dt_end_ui;
        //dto.Days_or = emsHeadDO.Days_or;
        //dto.Times_cur = emsHeadDO.Times_cur;
        //dto.Times_mp_in = emsHeadDO.Times_mp_in;

//        if (emsHeadDO.Status == DOStatus.NEW)
//        {
            dto.setCode(medsrv.getCode());
            dto.setName(medsrv.getName());
            dto.setId_srvtp(medsrv.getId_srvtp());
            dto.setSd_srvtp(medsrv.getSd_srvtp());
            dto.setId_srvca(medsrv.getId_srvca());
            dto.setId_freq(medsrv.getId_freq());
            dto.setId_srv(medsrv.getId_srv());
            dto.setFg_set(medsrv.getFg_set());
            //dto.Dt_begin = cof.GetSystemDateTime();
           
            // 天数有问题， 王琪在修改医疗单
            //if (emsHeadDO.Emsdrugs.Use_days != null && emsHeadDO.Emsdrugs.Use_days == 0)
            //{
            //    dto.Dt_end = DateTime.Parse(dto.Dt_begin.Value.ToString("yyyy-MM-dd 23:59:59"));
            //}
            //else
            //{
            //    dto.Dt_end = null;
            //}

            dto.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
            dto.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
            //dto.Id_emp_phy = UserManager.getInstance().CurrentUser.Id_psn;
            ////dto.Id_emp_phy = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
            //dto.Id_dep_phy = UserManager.getInstance().CurrentDept.Id_dep;
            //dto.Id_wg_or = UserManager.getInstance().CurrentGroup.Id_grp;
//        }
    }
	/**
	 * 获取CiEnContextDTO
	 * @param id_ent
	 * @param id_emp
	 * @param id_org
	 * @param id_dep
	 * @param id_grp
	 * @param ent4bannerdto
	 * @return
	 * @throws BizException
	 */
	private CiEnContextDTO getCiEnContext(String id_ent, String id_emp, String id_org, String id_dep,
			String id_grp, Ent4BannerDTO ent4bannerdto) throws BizException{
		CiEnContextDTO conetxtDTO = new CiEnContextDTO();
		DAFacade dafacade = new DAFacade();
		String user_sql = "select ID_USER from sys_user where id_psn = '"+id_emp+"'";
	    List id_users=(List) dafacade.execQuery(user_sql, new ColumnListHandler());
		String user_id = "";
		if (id_users != null && id_users.size()>0) {
			for (int i = 0; i < id_users.size(); i++) {
				user_id = (String)id_users.get(i);
			}
		}
//		if (context != null)
//        {
            conetxtDTO.setId_grp(id_grp); // 所属集团
            conetxtDTO.setId_org(id_org); // 所属组织
            conetxtDTO.setId_dep_or(id_dep); // 开立科室
            conetxtDTO.setId_emp_or(id_emp); // 开立医生
//            conetxtDTO.Name_grp = context.Group.Name;
//            conetxtDTO.Name_org = context.Org.Name; // 组织
//            conetxtDTO.Name_dep_or = context.Dept.Name; // 科室
//            conetxtDTO.Tel_dep_or = context.Dept.Tel; // 科室
//            conetxtDTO.Addr_dep_or = context.Dept.Id_plc; // 科室
//            conetxtDTO.Name_emp_or = context.PsnInfo.Name; // 人员
//            conetxtDTO.Code_emp_or = context.PsnInfo.Code;// 编码
            conetxtDTO.setId_user(user_id);// 用户
//            conetxtDTO.Name_user = context.User.Name; // 用户
//        }

        //conetxtDTO.Emsappmode = (int)emsAppModeEnum; // 医疗单应用场景

        conetxtDTO.setId_entp(ent4bannerdto.getId_entp()); // 就诊类型id
        conetxtDTO.setCode_entp(ent4bannerdto.getCode_entp()); // 就诊类型编码
        conetxtDTO.setId_pat(ent4bannerdto.getId_pat()); // 患者
        conetxtDTO.setName_pat(ent4bannerdto.getName_pat()); // 患者
        conetxtDTO.setId_pripat(ent4bannerdto.getId_pripat());// 患者价格分类
        
//        conetxtDTO.setName_sex = ent4bannerdto.Name_sex;// 性别
        conetxtDTO.setDt_birth(ent4bannerdto.getDt_birth()); // 患者出生日期
        conetxtDTO.setId_en(ent4bannerdto.getId_ent()); // 就诊
        conetxtDTO.setCode_entp(ent4bannerdto.getCode_entp()); // 就诊
        conetxtDTO.setSd_hptp(ent4bannerdto.getSd_hptp()); // 就诊
        conetxtDTO.setId_hp(ent4bannerdto.getId_hp()); // 主医保数据
        conetxtDTO.setNo_hp(ent4bannerdto.getNo_hp()); // 社保编码
        conetxtDTO.setId_dep_en(ent4bannerdto.getId_dep_phy()); // 当前就诊科室
        conetxtDTO.setName_dep_en(ent4bannerdto.getName_dep_phy()); // 当前就诊科室
        conetxtDTO.setId_dep_ns(ent4bannerdto.getId_dep_nur()); // 当前就诊病区
        conetxtDTO.setName_dep_ns(ent4bannerdto.getName_dep_nur()); // 当前就诊病区
        conetxtDTO.setId_bed(ent4bannerdto.getId_bed());; // 床位
        conetxtDTO.setName_bed(ent4bannerdto.getName_bed());;// 床位
//        conetxtDTO.Code_amr_ip = ent4bannerdto.getCode_amr_ip(); // 病历卡号
        conetxtDTO.setId_wg_or(ent4bannerdto.getId_wg_phy()); //TODO  开立医疗组 
        conetxtDTO.setFg_bb(ent4bannerdto.getFg_newborn()); // 婴儿标识
        conetxtDTO.setNo_bb(ent4bannerdto.getNum_newborn()); // 婴儿序号
        // ent4BannerDTO.Cp_status临床路径标识，1 在径 0 不在径
        if(ent4bannerdto.getCp_status() == "1" ){// 患者入径标识
        	conetxtDTO.setFg_cp(FBoolean.TRUE);
        }else{
        	conetxtDTO.setFg_cp(FBoolean.FALSE);
        }
        conetxtDTO.setFg_hpfundpay(ent4bannerdto.getFg_hpfundpay());// 本次就诊是否为医保就诊
        conetxtDTO.setFg_hpspcl(ent4bannerdto.getFg_hpspcl());// 特殊病标志
        conetxtDTO.setFg_gcvip(ent4bannerdto.getFg_gcvip());// vip患者标志

        if (FBoolean.TRUE.equals(ent4bannerdto.getFg_hpfundpay()))
        {
            // 如果本次是医保就诊
            if (FBoolean.TRUE.equals(ent4bannerdto.getFg_inhpbbr()))
            {
                conetxtDTO.setEu_inhpbbr(InHpBbrEnum.BLACKLIST); // 黑名单
            }
            else
            {
                conetxtDTO.setEu_inhpbbr(InHpBbrEnum.WHITELIST); // 白名单
            }
            // 如果本次就诊未医保就诊先将属性先设置为保内诊断，具体保内还是保外诊断，需要根据诊断的保外诊断属性判断
            conetxtDTO.setEu_hpbeyond(HpBeyondEnum.HPDIAG);
        }
        else
        {
            // 本次就诊为非医保就诊时，黑名单状态为9 ，如果医保就诊时 1 为黑名单，0 白名单
            conetxtDTO.setEu_inhpbbr(InHpBbrEnum.NONMEDICARE);
            conetxtDTO.setEu_hpbeyond(HpBeyondEnum.NONMEDICARE); // 本次就诊为非医保就诊时，保外诊断状态为9 ，如果医保就诊时 1 为保外诊断，0保内诊断

        }
        //conetxtDTO.Bhpjudgerst = ""; // 基本医保判断结果数据信息            
        // 基本医保判断结果数据信息
        conetxtDTO.setBhpjudgerst( (FBoolean.TRUE.equals(conetxtDTO.getFg_hpfundpay()) ? "1" : "0") + conetxtDTO.getEu_inhpbbr() + conetxtDTO.getEu_hpbeyond());

        // 非社保就诊时获取患者默认医保，用于保存服务项目时保存默认的医保目录类型
        if (!IsHpPat(conetxtDTO))
        {
            //如果患者的医保计划为空或者患者是高端商保，查询默认医保计划
            IPpQueService ppQueService = ServiceFinder.find(IPpQueService.class);
            FMap hpIdMap = ppQueService.getHpIdForHpCatalog(new String[] { conetxtDTO.getId_en() });
            if (hpIdMap != null && hpIdMap.containsKey(conetxtDTO.getId_en()))
            {
                conetxtDTO.setId_hp_default((String)hpIdMap.get(conetxtDTO.getId_en()));
            }
        }
		return conetxtDTO;
	}
	/**
	 * 多用户操作时医嘱状态校验
	 * @param ent4bannerdto
	 * @throws BizException
	 */
	private void JudgeOrderStatusInMultiUser(Ent4BannerDTO ent4bannerdto) throws BizException{
		CiOrderDO ciorder = new CiOrderDO();
        ciorder.setCode_entp(ent4bannerdto.getCode_entp());
        ciorder.setId_en(ent4bannerdto.getId_ent());
        ICiOrdQryService ciOrderQryService = ServiceFinder.find(ICiOrdQryService.class);
        ciOrderQryService.JudgeOrderStatusInMultiUser(new CiOrderDO[] { ciorder }, ent4bannerdto.getId_dep_phy(),ent4bannerdto.getId_dep_nur(), ICiDictCodeConst.ORD_VALIDATE_TYPE_OPEN);
	}
	/**
	 * 设置医保信息
	 * @param ciEmsDTO
	 * @param id_hp
	 * @throws BizException
	 */
	 private void setHpInfo(CiEmsDTO ciEmsDTO,String id_hp) throws BizException
     {
         if (StringUtils.isNullOrEmpty(id_hp)) return;
         FArrayList emssrvs = ciEmsDTO.getEmssrvs();
         if (emssrvs == null || emssrvs.size() == 0) {
             throw new BizException("医嘱的费用项目为空，不能保存！");
         }
         for(Object obj : emssrvs){
        	 CiEmsSrvDTO emssrv = (CiEmsSrvDTO) obj;
             HPSrvorcaDO hp = ServiceFinder.find(ICiOrdQryService.class).GetHpSrvOrCaDo(id_hp, emssrv.getId_srv());
             emssrv.setId_hp(id_hp);
             if (hp != null) {
                 emssrv.setId_hpsrvtp(hp.getId_hpsrvtp());
                 emssrv.setSd_hpsrvtp(hp.getSd_hpsrvtp());
                 String hpsrvtp_name = hp.getHpsrvtp_name();
                 emssrv.setLimit(StringUtils.isNullOrEmpty(hpsrvtp_name)?hp.getDes():hpsrvtp_name+(StringUtils.isNullOrEmpty(hp.getDes())?"":"，"+hp.getDes()));
             }
         }
     }
	 
	/// <summary>
     /// 判断当前患者是否为医保就诊患者
     /// </summary>
     /// <param name="ent4BannerDTO">当前患者就诊banner对象</param>
     /// <returns>true 医保就诊， false 非医保就诊</returns>
     private boolean IsHpPat(CiEnContextDTO ctx)
     {

         // 有医保计划，并且医保类型为社保，并且是医保基金支付标识（持卡）才确认是社保
         if (ctx != null && !StringUtils.isNullOrEmpty(ctx.getId_hp()) &&
             !StringUtils.isNullOrEmpty(ctx.getSd_hptp()) && ctx.getSd_hptp().startsWith("1") &&
             FBoolean.TRUE.equals(ctx.getFg_hpfundpay()))
         {
             return true;
         }

         return false;
     }
	/**
	 * 校验频次
	 * @param dto
	 * @return
	 * @throws BizException 
	 */
	private List<String> validateFreqAndUnitmed(CiEmsDTO dto) throws BizException{
		List<String> errorList = new ArrayList<String>();
		String id_freq = "", id_unit_med = "";
        FArrayList emssrvs = dto.getEmssrvs();
        if (emssrvs == null) return errorList;
        for (Object obj : emssrvs) {
        	CiEmsSrvDTO srvdto =  (CiEmsSrvDTO) obj;
            id_freq = srvdto.getId_freq();
            id_unit_med = srvdto.getId_unit_med();
            FDouble quan_med = srvdto.getQuan_med();
            //药品:频次，剂量，剂量单位，频次，用法，用法要求不能为空
            if (IBdSrvDictCodeConst.SD_SRVTP_DRUG.equals(srvdto.getSd_srvtp().substring(0, 2)))
            {
                if (id_freq == null || id_freq == "")
                {
                    errorList.add("服务项目【" + srvdto.getName_srv()+ "】的频次不能为空！");
                }
                if (id_unit_med == null || id_unit_med == "")
                {
                    errorList.add("服务项目【" + srvdto.getName_srv() + "】的剂量单位不能为空！");
                }
                if (quan_med == null)
                {
                    errorList.add("服务项目【" + srvdto.getName_srv() + "】的剂量不能为空！");
                }
                //草药：煎法和煎法要求和其他药
                if (IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(srvdto.getSd_srvtp().substring(0, 4)))
                {
                    if (StringUtils.isNullOrEmpty(srvdto.getId_boil()))
                    {
                        errorList.add("服务项目【" + srvdto.getName_srv() + "】的煎法不能为空！");
                    }
                }
            }
            //备血：剂量，剂量单位，频次不能为空
            else if (IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE.equals(srvdto.getSd_srvtp()))
            {
                if (id_freq == null || id_freq == "")
                {
                    errorList.add("服务项目【" + srvdto.getName_srv() + "】的频次不能为空！");
                }
                if (id_unit_med == null || id_unit_med == "")
                {
                    errorList.add("服务项目【" + srvdto.getName_srv() + "】的剂量单位不能为空！");
                }
                if (quan_med == null)
                {
                    errorList.add("服务项目【" + srvdto.getName_srv() + "】的剂量不能为空！");
                }
            }
            //其他服务：剂量null:1,剂量单位null：次，频次null：once
            else {
                if (quan_med==null||quan_med==FDouble.ZERO_DBL) {
                    srvdto.setQuan_med(FDouble.ONE_DBL);
                }
                if (StringUtils.isNullOrEmpty(id_unit_med)) {
                    errorList.add("服务项目【" + srvdto.getName_srv() + "】的剂量单位不能为空！");
                }
                if (StringUtils.isNullOrEmpty(id_freq)) {
                    srvdto.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
                    id_freq = srvdto.getId_freq();
                }
            }
            
            if (errorList.size() > 0) return errorList;
            String sd_freq = FreqInfoUtils.GetSDFreq(id_freq);
            if (sd_freq == null)
            {
                if (srvdto.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE))
                {
                    errorList.add("用血频次为空！");
                }
                else {
                    errorList.add(srvdto.getName_srv() + "频次为空！");
                }
                return null;
            }
          
            //频次为持续类型，剂量单位为时间
            ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
            MeasDocDO meas = service.getMeasDocDOById(id_unit_med);
            if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS.equals(sd_freq))
            {
                if (!meas.getSd_oppdimen().equals(ISysDictCodeConst.SD_OPPDIMEN_T))
                {
                    errorList.add("服务项目【" + srvdto.getName_srv() + "】的频次为持续类型，剂量单位必须是时间类型！");
                    return errorList;
                }
            }
        
	}
        return errorList;
	}
}
