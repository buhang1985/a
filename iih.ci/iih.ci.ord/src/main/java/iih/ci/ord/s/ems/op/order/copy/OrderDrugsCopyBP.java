package iih.ci.ord.s.ems.op.order.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.SortEnum;
import iih.ci.ord.s.bp.ems.CiOrMmBagFeeBp;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.utils.meta.DrugOrContentParam;
import iih.ci.ord.s.ems.utils.meta.OrContentDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 西药复制
 * 
 * @author Young
 *
 */
public class OrderDrugsCopyBP extends OrderBaseCopyBP {

	@Override
	protected void content_or(CiorderAggDO[] aggDOs, Map<String, OrdSrvMmDO> mapTeamSrvDOs) throws BizException {
		for (CiorderAggDO aggDO : aggDOs) {

			DrugOrContentParam drugOrContentParam = new DrugOrContentParam(aggDO, getOrContentDTOs(aggDO.getOrdSrvDO(), mapTeamSrvDOs));
			drugOrContentParam.setNote(aggDO.getParentDO().getDes_or());
			CiOrContentDO contentdo=new CiOrContentDO();
			Object[] params = new Object[]{contentdo,drugOrContentParam};
			BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_DRUG_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
			EventDispatcher.fireEvent(event);
			aggDO.getParentDO().setContent_or(contentdo==null?null:contentdo.toString());//CiOrContentUtils.create(drugOrContentParam)

		}
	}
	
	/**
	 * 获取拼接医嘱内容的参数
	 */
	protected List<OrContentDTO> getOrContentDTOs(OrdSrvDO[] ordSrvs, Map<String, OrdSrvMmDO> mapTeamSrvDOs) {
		List<OrContentDTO> list = new ArrayList<OrContentDTO>();
		ordSrvs = CiOrdUtils.Sort(ordSrvs, OrdSrvDO.SORTNO, SortEnum.ASC);
		for (OrdSrvDO ordSrvDO : ordSrvs) {
			if (mapTeamSrvDOs.containsKey(ordSrvDO.getId_orsrv())) {
				OrContentDTO orContentDTO = new OrContentDTO(ordSrvDO,mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()));
				orContentDTO.setSpec(mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()).getSpec());
				list.add(orContentDTO);
			}else{
				OrContentDTO orContentDTO = new OrContentDTO(ordSrvDO);
				list.add(orContentDTO);
			}
		}
		return list;
	}

	@Override
	protected void setCiorderAggDOs(CiorderAggDO[] aggDOs, Map<String, String> mapIdors,
			Map<String, String> mapIdorsrvs, FDateTime dt, FMap2 extension,FDateTime defDatetime) throws BizException {
		super.setCiorderAggDOs(aggDOs, mapIdors, mapIdorsrvs, dt, extension,defDatetime);
		//renewAssebleUsageSrvs(aggDOs, mapIdors, mapIdorsrvs, dt, extension);
	}
	/**
	 * 重新组装用法关联费用
	 * @param aggDOs
	 * @param mapIdors
	 * @param mapIdorsrvs
	 * @param dt
	 * @param extension
	 * @throws BizException 
	 */
	protected void renewAssebleUsageSrvs(CiorderAggDO[] aggDOs, Map<String, String> mapIdors,
			Map<String, String> mapIdorsrvs, FDateTime dt, FMap2 extension) throws BizException{
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		//用来重新计算用法关联费用
		for (CiorderAggDO aggDO : aggDOs) {
			//不在院执行不做处理
			if(isStopExec(aggDO.getParentDO())){
				continue;
			}
			List<OrdSrvDO> ordSrvs = new ArrayList<OrdSrvDO>();
			Map<String,OrdSrvDO> usagerSrvs = new HashMap<String,OrdSrvDO>();
			OrdSrvDO[] ordSrvArrs =  aggDO.getOrdSrvDO();
			if(ordSrvArrs != null && ordSrvArrs.length >0){
				for (OrdSrvDO ordSrvDO : ordSrvArrs) {
					//不是用法关联的费用
					if(ordSrvDO.getEu_sourcemd() == null || !OrSrvSourceFromEnum.USAGERELFEE.equals(ordSrvDO.getEu_sourcemd())){
						ordSrvs.add(ordSrvDO);
					}else{
						usagerSrvs.put(ordSrvDO.getId_srv(),ordSrvDO);
					}
				}
			}
			// 获取当前需要去掉用法关联费用的就诊类型
			String orgId = CiOrdAppUtils.getEnvContext().getOrgId();
			String relUseageCodeEntp = ParamsetQryUtil.getParaString(orgId,ICiOrdCustomSysParamConst.TL_PARAM_CODE_ENTP_REMOVE_USAGE_REL);
			
			if(StringUtils.isNotEmpty(relUseageCodeEntp)){
				
				List<String> codeEntpList = Arrays.asList(relUseageCodeEntp.split(","));
				if(codeEntpList.contains(context.getCode_entp())){
					//如果包含用法关联的费用，就将不是用法关联的费用赋值给Agg
					if(usagerSrvs.size()>0){
						aggDO.setOrdSrvDO(ordSrvs.toArray(new OrdSrvDO[0]));
					}
					continue;
				}
			}		
			UsageRelFeeSrvDO[] relfeeinfos= CiOrdUtils.getPriUsgRelFeeSrvInfo(aggDO.getParentDO().getId_route(), CiOrdAppUtils.getEnvContext().getOrgId(), getEnWardDept(context.getId_en()));
			if(relfeeinfos != null && relfeeinfos.length >0){
				Map<String,MedSrvDO> medSrvMap = getMedSrvMap(relfeeinfos);
				for (UsageRelFeeSrvDO usageRelFeeSrvDO : relfeeinfos) {
					if(usagerSrvs.containsKey(usageRelFeeSrvDO.getId_srv())){
						ordSrvs.add(usagerSrvs.get(usageRelFeeSrvDO.getId_srv()));
					}else{
						OrdSrvDO srvdo = createOrdSrvDO(usageRelFeeSrvDO,aggDO.getParentDO(),medSrvMap.get(usageRelFeeSrvDO.getId_srv()));
						ordSrvs.add(srvdo);
					}
				}
				
			}
			aggDO.setOrdSrvDO(ordSrvs.toArray(new OrdSrvDO[0]));
		}
	}
	/**
	 * 是否停止操作
	 * @param order
	 * @return
	 */
	protected boolean isStopExec(CiOrderDO order){
		return !FBoolean.TRUE.equals(order.getFg_mp_in()) || StringUtils.isEmpty(order.getId_route());
	}
	/**
	 * 缓存服务
	 * @param relfeeinfos
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> getMedSrvMap(UsageRelFeeSrvDO[] relfeeinfos) throws BizException {
		List<String> idsrvs = new ArrayList<String>();
		for (UsageRelFeeSrvDO relFeeSrvs : relfeeinfos) {
			idsrvs.add(relFeeSrvs.getId_srv());
		}
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medsrvs = service.findByIds(idsrvs.toArray(new String[0]),FBoolean.FALSE);
		if(medsrvs == null || medsrvs.length == 0){
			return null;
		}
		Map<String,MedSrvDO> srvMap = new HashMap<String,MedSrvDO>();
		for(MedSrvDO srv :medsrvs){
			srvMap.put(srv.getId_srv(), srv);
		}
		return srvMap;
	}
	/**
	 * 重新生成用法关联的费用
	 * @param usgrelfeesrvdo
	 * @param ordo
	 * @param bdsrvdo
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO createOrdSrvDO(UsageRelFeeSrvDO usgrelfeesrvdo,CiOrderDO ordo,MedSrvDO bdsrvdo) throws BizException{
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		OrdSrvDO srvdo=new OrdSrvDO();
		srvdo.setId_or(ordo.getId_or());
		srvdo.setId_pat(ordo.getId_pat());
		srvdo.setId_entp(ordo.getId_entp());
		srvdo.setCode_entp(ordo.getCode_entp());
		srvdo.setId_en(ordo.getId_en());
		srvdo.setId_srvtp(bdsrvdo.getId_srvtp());
		srvdo.setSd_srvtp(bdsrvdo.getSd_srvtp());
		srvdo.setId_srv(bdsrvdo.getId_srv());
		srvdo.setName(bdsrvdo.getName());
		srvdo.setFg_dose_anoma(FBoolean.FALSE);
//		//2016-11-14 修正原有的剂量及剂量单位逻辑  下面6行原有的代码注释掉了   
//		//要注意的是服务单价是以BD_SRV中的医学单位定义的****计算单价时要考虑两者的单位转换
		//服务关联时，是定值时实际上是有两层含义（总量定值法、单次定值法）：我们目前情况下是指总量定值法
		if(CiOrdUtils.isTrue(usgrelfeesrvdo.getIsTotalQuanMd())){//2016-11-14 新增  服务关联总量模式的赋值逻辑
			srvdo.setQuan_medu(null);
			srvdo.setId_medu(CiOrdUtils.getUnit4UsgRelFeeSrv(usgrelfeesrvdo)); 
		}else{
			srvdo.setQuan_medu(CiOrdUtils.getQuan_Med4UsgRelFeeSrv(usgrelfeesrvdo));  //2016-06-22修改 //bdsrvdo.getQuan_med()
			srvdo.setId_medu(CiOrdUtils.getUnit4UsgRelFeeSrv(usgrelfeesrvdo));   
		}
		srvdo.setId_route(bdsrvdo.getId_route());
		srvdo.setId_routedes(bdsrvdo.getId_routedes());
		srvdo.setId_boil(bdsrvdo.getId_boil());
		srvdo.setId_boildes(bdsrvdo.getId_boildes());
		srvdo.setId_freq(ordo.getId_freq());
		//zwq 2016-09-05
		srvdo.setFreqct(ordo.getFreqct());
		srvdo.setFreq_name(ordo.getFreq_name());
		srvdo.setSd_frequnitct(ordo.getSd_frequnitct());
		
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		//srvdo.setId_dep_mp(getMpDeptID());      //调整到最后
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setDt_last_bl(ordo.getDt_last_bl());
		srvdo.setFg_or(FBoolean.FALSE);
		srvdo.setEu_blmd(bdsrvdo.getEu_blmd());  //本服务定价
		srvdo.setFg_mm(FBoolean.FALSE);
		srvdo.setFg_set(FBoolean.FALSE);
		//srvdo.setFg_indic(srvdto.getFg_indic());
		srvdo.setFg_propc(FBoolean.FALSE);
		srvdo.setFg_self(FBoolean.FALSE);
		srvdo.setFg_pres_outp(FBoolean.FALSE);
		srvdo.setNote_srv("");
		srvdo.setId_srvca(bdsrvdo.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(bdsrvdo.getFg_bl()));
		srvdo.setCode_srv(bdsrvdo.getCode());
		srvdo.setEu_sourcemd(CiOrdUtils.getRelType_Med4UsgRelFeeSrv(usgrelfeesrvdo));
		//srvdo.setFg_skintest_rst(Fg_skintest_rst);//2016-06-28新增字段
		srvdo.setId_primd(bdsrvdo.getId_primd());
		srvdo.setFg_selfsrv(bdsrvdo.getFg_ctm());
		srvdo.setId_srv_src(ordo.getId_srv());
		if(ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(context.getStationType())||CiOrdUtils.isOpMode(ordo.getCode_entp(), ordo.getFg_pres_outp(),srvdo.getSd_srvtp()).booleanValue()||srvdo.getEu_sourcemd().equals(OrSrvSourceFromEnum.BOILRELFEE)){
			//非物品计算总量
			CalQuantumBP calQuantum = new CalQuantumBP();
			if(srvdo.getEu_sourcemd() == OrSrvSourceFromEnum.BOILRELFEE ) {
				srvdo.setQuan_total_medu(calQuantum.getQuantum(srvdo.getQuan_medu(),ordo.getOrders_boil()));
			}else if(srvdo.getEu_sourcemd() == OrSrvSourceFromEnum.MMBAGFEE ){
				srvdo.setQuan_total_medu(srvdo.getQuan_medu());
			}else
			{
				if(srvdo.getQuan_medu()==null){
					throw new BizException("服务"+srvdo.getName()+"剂量为空");
				}
				srvdo.setQuan_total_medu(srvdo.getQuan_medu().multiply(ordo.getTimes_mp_in()==null?0:ordo.getTimes_mp_in()));
			}	
		}
		srvdo.setId_hp(usgrelfeesrvdo.getDef1());//2016-07-12新增医保相关信息
		srvdo.setId_dep_mp(ordo.getId_dep_mp());   //待打开
		if(srvdo.getId_org_mp()== null){srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));}

	    srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
	    srvdo.setId_grp( CiOrdAppUtils.getEnvContext().getGroupId());
	    
	    //计算价格 String code_entp, String id_srv, String id_primd, OrdSrvDO srvdo
	    
		srvdo.setFg_feertnable(FBoolean.TRUE);
		srvdo.setStatus(DOStatus.NEW);
		CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ordo.getCode_entp(), srvdo.getId_srv(), srvdo.getId_primd(), srvdo);
		return srvdo;
	}
	/**
	 * 获得患者所在病区或科室
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private String getEnWardDept(String id_en) throws BizException{
		PatiVisitDO endo=CiOrdUtils.getPatiVisitDO(id_en);
		if(endo==null)return "";
		if(!OrSrvSplitUtil.isEmpty(endo.getId_dep_nur()))return endo.getId_dep_nur();
		return endo.getId_dep_phy(); 
	}

	/**
	 * 获得医嘱药品关联药袋费数据
	 * @return
	 * @throws BizException
	 */
	@Override
	protected void aggCiOrderDrugHandle(CiorderAggDO aggDO, CiEmsDTO ems, Map<String, OrdSrvMmDO> mapMmDos,Hashtable ht) throws BizException {
		CiOrderDO ciOrderDO = aggDO.getParentDO();
		if(!ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)){
			return;
		}
		OrdSrvDO[] ordSrvDOs = aggDO.getOrdSrvDO();
		ArrayList<OrdSrvDO> ordSrvDOList = new ArrayList<OrdSrvDO>();
		for(int i=0; i<ordSrvDOs.length; i++){
			OrdSrvDO itm = ordSrvDOs[i];
			if(!itm.getEu_sourcemd().equals(OrSrvSourceFromEnum.MMBAGFEE)){
				if (FBoolean.TRUE.equals(itm.getFg_mm())) {
					OrdSrvMmDO mmSrvDO = mapMmDos.get(itm.getId_orsrv());
					itm.setId_mm(mmSrvDO.getId_mm());	//回写虚拟字段
				}
				ordSrvDOList.add(itm);
			}
		}
		aggDO.setOrdSrvDO(ordSrvDOList.toArray(new OrdSrvDO[0]));
		ems.setFg_prisrvhandled(FBoolean.FALSE);
		ArrayList<OrdSrvDO> bdsrvBagList = getMmbagSrvs(aggDO,ems,ordSrvDOList,ht);
		ordSrvDOs = merge(aggDO.getOrdSrvDO(), bdsrvBagList);
		aggDO.setOrdSrvDO(ordSrvDOs);
	}
	/**
	 * 
	 * @code 药品关联药袋费用派生费用创建医嘱服务项目
	 */
	private ArrayList<OrdSrvDO> getMmbagSrvs(CiorderAggDO aggorder, CiEmsDTO ems, ArrayList<OrdSrvDO> orsrvs,Hashtable ht) throws BizException {
		CiOrMmBagFeeBp bp = new CiOrMmBagFeeBp();
		return bp.exec(aggorder,ems,orsrvs,ht);
	}

	//0192176: 【验证版】住院医生站，住院医嘱，既往调入、复制、医嘱模板开了抗菌药，用药目的不应复制
	protected void GetSrvDrugInfo(OrdSrvMmDO[] ordSrvMmDOs) throws BizException {
		if(ordSrvMmDOs == null || ordSrvMmDOs.length < 1){
			return;
		}
		StringBuilder sqlQry = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sqlQry.append("SELECT a.id_mm,b.id_anti,b.sd_anti");
		sqlQry.append(" FROM bd_mm a inner join bd_srv_drug b on a.id_srv=b.id_srv");
		for(int i=0; i<ordSrvMmDOs.length; i++){
			if(i == 0){
				sqlQry.append(" WHERE a.id_mm = ?");
			}else{
				sqlQry.append(" or a.id_mm = ?");
			}
			sqlParam.addParam(ordSrvMmDOs[i].getId_mm());
		}
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> sqlRst = (List<Map<String, Object>>) (new DAFacade().execQuery(sqlQry.toString(), sqlParam, new MapListHandler()));
		if (sqlRst != null && sqlRst.size() > 0) {
			Map<String, String[]> mapAntis = new HashMap<String, String[]>();
			for (Map<String, Object> map : sqlRst) {
				String id_mm = map.get("id_mm").toString();
				String[] antiInfo = new String[2];
				antiInfo[0] = map.get("id_anti").toString();
				antiInfo[1] = map.get("sd_anti").toString();
				mapAntis.put(id_mm, antiInfo);
			}
			for(OrdSrvMmDO itm : ordSrvMmDOs){
				if(mapAntis.containsKey(itm.getId_mm())){
					String[] antiInfo = mapAntis.get(itm.getId_mm());
					itm.setId_anti(antiInfo[0]);
					itm.setSd_anti(antiInfo[1]);
				}
			}
		}
	}
}
