package iih.ci.preop.order.bp.assi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.medterm.d.SampCollectTimeDictDO;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplItmDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrTplNItmDORService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.preop.ems.d.EmsLisViewDTO;
import iih.ci.preop.ems.d.EmsRisViewDTO;
import iih.ci.preop.ems.d.EmsSrvSetViewDTO;
import iih.ci.preop.ems.lis.EmsLisCreateBP;
import iih.ci.preop.ems.ris.EmsRisCreateBP;
import iih.ci.sdk.cache.BDSampcolTimeInfoCache;
import iih.ci.sdk.cache.BDSrvInfoCache;
import iih.ci.sdk.cache.BDSrvSetInfoCache;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.orctt.CiOrContentUtils;
import iih.ci.sdk.utils.CiAppNoUtils;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.CiOrderUtils;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.tsip.d.CiTsApLabDO;
import iih.ci.tsip.d.CiTsApObsDO;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.d.CiTsOrSrvDO;
import iih.ci.tsip.d.CiTsOrSrvSetDO;
import iih.ci.tsip.d.CitsorderAggDO;
import iih.ci.tsip.d.desc.CiTsOrDODesc;
import iih.ci.tsip.i.ICitsaplabCudService;
import iih.ci.tsip.i.ICitsapobsCudService;
import iih.ci.tsip.i.ICitsorderCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * @author yangdong
 *
 * @date 2020年5月26日上午9:46:48
 *
 * @classpath iih.ci.preop.order.bp.assi.OrderSaveByOrtmplBP
 *
 * 预住院模板保存
 *
 */
public class OrderSaveByOrtmplBP {
	public OrderRstDTO exec(CiEnContextDTO ctx, OrTplNItmDO[] ortplItemDO) throws BizException {
		OrderRstDTO rst = new OrderRstDTO();
		
		if (ortplItemDO==null) {
			rst.setIsSuccess(FBoolean.FALSE);
			rst.setMessageInfo("保存操作时，没有可执行的数据");
			return rst;
		}
		FMap2 map = OrtemplateGrouping(ortplItemDO);

		if (map == null || map.size() == 0)
			return null;
		
		List<CiOrTmplDTO> tmpList = new ArrayList<CiOrTmplDTO>();
		//医嘱模板的优化
		@SuppressWarnings("unchecked")
		List<String> ortmplList = (List<String>) map.get("ortmplList");
		Map<String,OrTmplDO> ortmplDOMap = OptimaizationOrTplNItmDO(ortmplList);
		
		
		map.remove("ortmplList");
		for (Object list : map.values()) {
			@SuppressWarnings("unchecked")
			List<OrTplNItmDO> temp = (List<OrTplNItmDO>) list;
			if (temp != null && temp.size() > 0) {
				FArrayList srvlist = new FArrayList();
				CiOrTmplDTO aggdto = new CiOrTmplDTO();
				OrTplNItmDO orTplItem = temp.get(0);
				if (orTplItem.getId_srv_set() != null && orTplItem.getId_srv_set() != "") {
					CitsorderAggDO ciTsOrderAggDO=new CitsorderAggDO();
					ciTsOrderAggDO=this.handleCreateOrderInfo(ctx, orTplItem.getId_srv_set(),list);
					//拼接医嘱内容
					CiOrContentDO contentDO=this.setOrContentInfo(ciTsOrderAggDO,orTplItem.getId_srv_set());
					ciTsOrderAggDO.getParentDO().setContent_or(contentDO.toString());
					//保存治疗方案
					CitsorderAggDO[] rtnAggDto=ServiceFinder.find(ICitsorderCudService.class).save(new CitsorderAggDO[]{ciTsOrderAggDO});
					if(ObjectUtils.isEmpty(rtnAggDto)){
						throw new BizException("预住院助手开单保存失败！");
					}
					//保存申请单属性表
					afterSaveTsOrderAggInfo(ctx,rtnAggDto);
					
					FArrayList objList = new FArrayList();
					objList.add(rtnAggDto[0]);
					rst.setDocument(objList);
					
				}else{
					CitsorderAggDO ciTsOrderAggDO=new CitsorderAggDO();
					ciTsOrderAggDO=this.handleCreateOrderInfo(ctx, orTplItem.getId_srv(),orTplItem);
					//拼接医嘱内容
					CiOrContentDO contentDO=this.setOrContentInfo(ciTsOrderAggDO,orTplItem.getId_srv());
					ciTsOrderAggDO.getParentDO().setContent_or(contentDO.toString());
					//保存治疗方案
					CitsorderAggDO[] rtnAggDto=ServiceFinder.find(ICitsorderCudService.class).save(new CitsorderAggDO[]{ciTsOrderAggDO});
					if(ObjectUtils.isEmpty(rtnAggDto)){
						throw new BizException("预住院助手开单保存失败！");
					}
					//保存申请单属性表
					afterSaveTsOrderAggInfo(ctx,rtnAggDto);
					
					FArrayList objList = new FArrayList();
					objList.add(rtnAggDto[0]);
					rst.setDocument(objList);
				}
			}
		}
			
		rst.setIsSuccess(FBoolean.TRUE);
		return rst;
	}
	
	private void afterSaveTsOrderAggInfo(CiEnContextDTO ctx, CitsorderAggDO[] rtnAggDto) throws BizException {
		for (CitsorderAggDO citsorderAggDO2 : rtnAggDto) {
			if (citsorderAggDO2.getParentDO().getSd_srvtp().startsWith("02")&&!citsorderAggDO2.getParentDO().getSd_srvtp().startsWith("0207")) {//检查
				//检查申请单属性表
				CiTsApObsDO ciTsApObsDo=new CiTsApObsDO();
				ciTsApObsDo.setStatus(DOStatus.NEW);
				ciTsApObsDo.setId_tsor(citsorderAggDO2.getParentDO().getId_tsor());
				EmsRisCreateBP emsRisCreateBP = new EmsRisCreateBP();
				EmsRisViewDTO risViewDto=emsRisCreateBP.emsModelFrom(ctx.getId_en(), citsorderAggDO2.getParentDO().getId_srv());
				ciTsApObsDo.setId_pps(risViewDto.getId_pps());//检查目的ID
				ciTsApObsDo.setSd_pps(risViewDto.getSd_pps());//检查目的SD
				ciTsApObsDo.setName_pps(risViewDto.getName_pps());//检查目的
				ciTsApObsDo.setDes_pps(risViewDto.getDes_pps());//检查目的描述
				ciTsApObsDo.setAnnouncements(risViewDto.getAnnouncements());//注意事项
				ciTsApObsDo.setDes_sympsign(risViewDto.getDes_sympsign());//症状和体征
				ServiceFinder.find(ICitsapobsCudService.class).save(new CiTsApObsDO[]{ciTsApObsDo});
			}else if(citsorderAggDO2.getParentDO().getSd_srvtp().startsWith("03"))//检验
			{
				//检验申请单属性
				CiTsApLabDO ciTsApLabDo=new CiTsApLabDO();
				ciTsApLabDo.setStatus(DOStatus.NEW);
				ciTsApLabDo.setId_tsor(citsorderAggDO2.getParentDO().getId_tsor());
				 EmsLisCreateBP emsLisCreateBP = new EmsLisCreateBP() ;
				EmsLisViewDTO lisViewDto=emsLisCreateBP.emsModelFrom(ctx.getId_en(), citsorderAggDO2.getParentDO().getId_srv());
				ciTsApLabDo.setId_samptp(lisViewDto.getId_samptp());	            //标本类型ID
				ciTsApLabDo.setSd_samptp(lisViewDto.getSd_samptp());	            //标本类型SD
				ciTsApLabDo.setName_samptp(lisViewDto.getName_samptp());	            //标本类型名称	
				if(!ObjectUtils.isEmpty(lisViewDto.getId_sampcoltime())){
					SampCollectTimeDictDO sampColTimeDo=BDSampcolTimeInfoCache.GetBDSampcolTimeInfo(lisViewDto.getId_sampcoltime());
					ciTsApLabDo.setId_sampcoltime(lisViewDto.getId_sampcoltime());	        //标本采集时间ID	
					ciTsApLabDo.setName_sampcoltime(lisViewDto.getName_sampcoltime());	    //标本采集时间
					ciTsApLabDo.setId_sampcollecttimetp(sampColTimeDo.getId_sampcollecttimetp());	//标本采集时间类型ID	
					ciTsApLabDo.setSd_sampcollecttimetp(sampColTimeDo.getSd_sampcollecttimetp());	//标本采集时间类型编码
					ciTsApLabDo.setLen_sampcoltime(sampColTimeDo.getLen_time());	        //标本采集时长	
					ciTsApLabDo.setId_unit_sampcoltime(sampColTimeDo.getId_unit_time());	    //标本采集时长单位	
				}
				ServiceFinder.find(ICitsaplabCudService.class).save(new CiTsApLabDO[]{ciTsApLabDo});
			}
		}
		
	}

	private CitsorderAggDO handleCreateOrderInfo(CiEnContextDTO ctx, String id_srv_set, Object list) throws BizException {
		List<OrTplNItmDO> temp = (List<OrTplNItmDO>) list;
		List<String> id_srvs= new ArrayList<String>();
		
		for (OrTplNItmDO orTplNItmDO : temp) {
			id_srvs.add(orTplNItmDO.getId_srv());
		}
		CitsorderAggDO agg=new CitsorderAggDO();
		
		MedSrvDO medSrvDO = BDSrvInfoCache.GetBdSrvInfo(ctx, id_srv_set); 
		if (ObjectUtils.isEmpty(medSrvDO)) {
			throw new BizException("获取主服务数据失败！");			
		}
		//创建治疗方案医嘱
		FDateTime createTime = CiOrdAppUtils.getServerDateTime();
		CiTsOrDO ciTsOrDo=new CiTsOrDO();
		String[] pkIds=CiOrderUtils.GeneratePKs(2);
		//主表默认赋值
		this.defaultCreateCiTsOrdInfo(ctx, ciTsOrDo, medSrvDO);
		ciTsOrDo.setStatus(DOStatus.NEW);
		ciTsOrDo.setDt_create(createTime);
		ciTsOrDo.setDt_effe(createTime.addSeconds(5)); // 生效时间
		ciTsOrDo.setDt_sign(createTime.addSeconds(7));
		ciTsOrDo.setId_tsor(pkIds[0]);
		agg.setParentDO(ciTsOrDo);
		//创建治疗方案主服务
		List<CiTsOrSrvDO> srvList= new ArrayList<CiTsOrSrvDO>();
		//序号初始值
		int sortNo=0;
		CiTsOrSrvDO ciTsOrSrvDo=new CiTsOrSrvDO();
		ciTsOrSrvDo.setStatus(DOStatus.NEW);
		ciTsOrSrvDo.setId_tsorsrv(pkIds[1]);
		ciTsOrSrvDo.setId_tsor(ciTsOrDo.getId_tsor());
		ciTsOrSrvDo.setDt_create(createTime);		

		this.defaultCreateCiTsOrdSrvInfo(ctx, ciTsOrSrvDo, medSrvDO);
		ciTsOrSrvDo.setSortno(sortNo);
		srvList.add(ciTsOrSrvDo);
		//服务套保存
		if(ObjectUtils.isTrue(medSrvDO.getFg_set())){
			//List<EmsSrvSetViewDTO> emsLisSetItemList = this.getEmsLisSetItemList(medSrvDO.getId_srv(),id_srvs);
			List<CiTsOrSrvSetDO> srvSetList= new ArrayList<CiTsOrSrvSetDO>();
			Map<String,MedSrvSetItemDO> setItemMap=this.getSrvSetItemMap(medSrvDO.getId_srv());
			for (String id_srv : id_srvs) {
				String[] pkids=CiOrderUtils.GeneratePKs(2);
				//创建服务信息
				CiTsOrSrvDO setSrvDo=new CiTsOrSrvDO();
				setSrvDo.setStatus(DOStatus.NEW);
				setSrvDo.setId_tsorsrv(pkids[0]);
				setSrvDo.setId_tsor(ciTsOrDo.getId_tsor());
				setSrvDo.setDt_create(createTime);
				//设置服务序号
				setSrvDo.setSortno(sortNo+1);
				sortNo++;
				//ctx
				this.defaultCreateCiTsOrdSrvInfo(ctx, setSrvDo, BDSrvInfoCache.GetBdSrvInfo(ctx, id_srv));
				srvList.add(setSrvDo);
				//创建套信息
				CiTsOrSrvSetDO srvSetDo=new CiTsOrSrvSetDO();
				srvSetDo.setId_tsor(ciTsOrDo.getId_tsor());
				srvSetDo.setId_tsorsrvset(pkids[1]);
				srvSetDo.setId_tsorsrv(setSrvDo.getId_tsorsrv());
				srvSetDo.setStatus(DOStatus.NEW);
				this.defaultCreateCiTsOrdSrvSetInfo(srvSetDo, setItemMap.get(id_srv));
				srvSetList.add(srvSetDo);
			}
				
		
			
			//放入套内项目
			agg.setCiTsOrSrvSetDO(srvSetList.toArray(new CiTsOrSrvSetDO[srvSetList.size()]));
		}
		//放入服务项目		
		agg.setCiTsOrSrvDO(srvList.toArray(new CiTsOrSrvDO[srvList.size()]));
		//对照界面信息
		this.mergeCiTsOrdInfo(agg.getParentDO(), id_srv_set);
		if(!ObjectUtils.isEmpty(agg.getCiTsOrSrvDO())){
			for(CiTsOrSrvDO ciTsOrSrvDO:agg.getCiTsOrSrvDO()){
				this.mergeCiTsOrdSrvInfo(ciTsOrSrvDO, id_srv_set,temp.get(0));
			}
		}
		return agg;

	}

	/**
	 * 查询出医嘱模板集合
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	private Map<String,OrTmplDO> OptimaizationOrTplNItmDO(List<String> list) throws BizException {
		if (list == null || list.size() == 0)
			return null;
		Map<String,OrTmplDO> orTemplmap = new HashMap<String,OrTmplDO>();
		String[] ids = list.toArray(new String[0]);
		OrTmplDO[] ortmpl = CiOrdAppUtils.getIOrtmplMDORService().findByIds(ids, FBoolean.FALSE);
		if (ortmpl != null && ortmpl.length > 0) {
			for (OrTmplDO ortmplDO : ortmpl) {
				orTemplmap.put(ortmplDO.getId_ortmpl(), ortmplDO);
			}
		}
		return orTemplmap;
	}

	/**
     * 医嘱项目 一个医嘱模板的 是一条医嘱
     * @param map
     * @param ortplItemDO
     * @throws BizException
     */
	@SuppressWarnings("unchecked")
	private FMap2 OrtemplateGrouping(OrTplNItmDO[] ortplItems)
			throws BizException {
		FMap2 map = new FMap2();
		List<OrTplNItmDO> itemlist = null;
		List<String> ortmplList = new ArrayList<String>();
		
		// 根据数据库中的医嘱模板明细补全前台传入的模板明细
		this.setOrtmplItmDefaultVal(ortplItems);
		
		for (OrTplNItmDO item : ortplItems) {
			ortmplList.add(item.getId_ortmpl());
			String key = item.getId_ortmpl() + item.getIdentical_ortmpl() + item.getSd_srvtp().substring(0, 2);
			if (map.containsKey(key)) {
				itemlist = (List<OrTplNItmDO>) map.get(key);
				itemlist.add(item);
			} else {
				List<OrTplNItmDO> temp = new ArrayList<OrTplNItmDO>();
				temp.add(item);
				map.put(key, temp);
			}
		}
		map.put("ortmplList", ortmplList);
		return map;
	}
	/**
	 * 根据数据库中的医嘱模板，补全前台传入的医嘱模板数据
	 * @return
	 * @throws BizException 
	 */
	private void  setOrtmplItmDefaultVal(OrTplNItmDO[] ortplItems) throws BizException{
		
		// 医嘱模板明细id集合
		List<String> idOrtmplItm = new ArrayList<String>();
				
		for(OrTplNItmDO orTplNItm : ortplItems){
			idOrtmplItm.add(orTplNItm.getId_ortmplitm());
		}
		
		// 查询中数据库中的医嘱模板，并转换为map结构
		IOrTplNItmDORService orTplNItmDORService =  (IOrTplNItmDORService)ServiceFinder.find(IOrTplNItmDORService.class);
		OrTplNItmDO[] defaultOrTplNItms = orTplNItmDORService.findByIds(idOrtmplItm.toArray(new String[0]), FBoolean.FALSE);
		if(defaultOrTplNItms == null || defaultOrTplNItms.length ==0){
			return ;
		}
		
		Map<String,OrTplNItmDO> orTplNItmMap = new HashMap<String,OrTplNItmDO>();
		Map<String,String> mapIdmm = new HashMap<String,String>();
		for(OrTplNItmDO orTplNItm : defaultOrTplNItms){
			orTplNItmMap.put(orTplNItm.getId_ortmplitm(), orTplNItm);
			if(orTplNItm.getSd_srvtp().startsWith("01")) {
				mapIdmm.put(orTplNItm.getId_mm(), orTplNItm.getId_unit_med());
			}
			
		}
		//判断模板的医学单位华为药品基本信息的基本单位是否不一致
		String message = JudgeMMUintMed(defaultOrTplNItms);
		if(!StringUtils.isNullOrEmpty(message)) {
			throw new BizException(message);
		}
		// 将数据库中医嘱模板信息合并到前台传入的模板数据中
		for(OrTplNItmDO orTplNItm : ortplItems){
			
			OrTplNItmDO sourceOrTplNItm = orTplNItmMap.get(orTplNItm.getId_ortmplitm());
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_freq())){
				orTplNItm.setId_freq(sourceOrTplNItm.getId_freq());
				orTplNItm.setOrtplnitm_freq_code(sourceOrTplNItm.getOrtplnitm_freq_code());
				orTplNItm.setOrtplnitm_freq_name(sourceOrTplNItm.getOrtplnitm_freq_name());
			}
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_route())){
				orTplNItm.setId_route(sourceOrTplNItm.getId_route());
				orTplNItm.setOrtplnitm_route_code(sourceOrTplNItm.getOrtplnitm_route_code());
				orTplNItm.setOrtplnitm_route_name(sourceOrTplNItm.getOrtplnitm_route_name());
			}
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_routedes())){
				orTplNItm.setId_routedes(sourceOrTplNItm.getId_routedes());
				orTplNItm.setOrtplnitm_routedes_code(sourceOrTplNItm.getOrtplnitm_routedes_code());
				orTplNItm.setOrtplnitm_routedes_name(sourceOrTplNItm.getOrtplnitm_routedes_name());
			}
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_boil())){
				orTplNItm.setId_boil(sourceOrTplNItm.getId_boil());
				orTplNItm.setOrtplnitm_boil_code(sourceOrTplNItm.getOrtplnitm_boil_code());
				orTplNItm.setOrtplnitm_boil_name(sourceOrTplNItm.getOrtplnitm_boil_name());
			}
			
			if(orTplNItm.getDays_or() == null){
				orTplNItm.setDays_or(sourceOrTplNItm.getDays_or());
			}
			if(orTplNItm.getDes_or() == null){
				orTplNItm.setDes_or(sourceOrTplNItm.getDes_or());
		
			}
			if(StringUtils.isNullOrEmpty(orTplNItm.getName_srv())){
				orTplNItm.setName_srv(sourceOrTplNItm.getName_srv());
		
			}
			if(orTplNItm.getId_dep_mp()==null){
				orTplNItm.setId_dep_mp(sourceOrTplNItm.getId_dep_mp());
			}			
		}
	}
	 /**
	  * 判断 药品的医学单位和模板的医学单位是否一致
	  * @param envinfo
	  * @param ortplItemDO
	  * @return
	  */
	  private String JudgeMMUintMed(OrTplNItmDO[] defaultOrTplNItms) throws BizException{
		 StringBuffer message =  new StringBuffer();
		 List<String> list = new ArrayList<String>();//药品 id_mm 集合
		 Map<String,String> map = new HashMap<String,String>();
		 if(defaultOrTplNItms !=null && defaultOrTplNItms.length > 0) {
			 for(OrTplNItmDO itemDO: defaultOrTplNItms) {
				 if(itemDO.getSd_srvtp().startsWith("01")) {
					 map.put(itemDO.getId_mm(), itemDO.getId_unit_med());
					 list.add(itemDO.getId_mm());
				 }
			 }
			 if(list != null && list.size() > 0) {
				 List<MeterialDO> materiaDOS = getMeterialDO((String[])list.toArray(new String[list.size()]));
			     if(materiaDOS != null && materiaDOS.size() > 0) {
			    	 for(MeterialDO meteria :materiaDOS) {
				    	 if(!meteria.getId_unit_med().equals(map.get(meteria.getId_mm()))){
				    		 message.append(meteria.getName()).append("" );
				    		 message.append("在模板里面的剂量单位和 药品基本信息里的剂量单位不一致 请修改模板，在开立" ).append("\n");
				    	 }
				     } 
			     } 
			 } 
		 }
		 return message.toString();
	  }
	  /**
	   * 查询药品  名称和 医学单位
	   * @param id_mms
	   * @return
	   * @throws BizException
	   */
	  private List<MeterialDO> getMeterialDO(String[] id_mms)throws BizException {
		  String sql ="select bdmm.name, bdmm.id_mm,bdmm.id_unit_med from bd_mm bdmm where  ";
		    sql +=	 SqlUtils.getInSqlByIds("bdmm.id_mm", id_mms);
		   DAFacade  facade = new  DAFacade();
		   List<MeterialDO> meterialDO = (List<MeterialDO>)facade.execQuery(sql, new BeanListHandler(MeterialDO.class));
	       return meterialDO;
	  }
	  
	/**
	 * 拼接医嘱内容
	 * @param ciTsOrderAggDO
	 * @param id_srv
	 * @return
	 */
	private CiOrContentDO setOrContentInfo(CitsorderAggDO ciTsOrderAggDO, String id_srv) {
		
		 return CiOrContentUtils.getNullContent();
	}
	/**
	 * 新增治疗方案处理逻辑(保存签署)
	 * @param ctx
	 * @param emsViewDto
	 * @return
	 * @throws BizException
	 */
	private CitsorderAggDO handleCreateOrderInfo(CiEnContextDTO ctx, String id_srv,OrTplNItmDO orTplItmDO) throws BizException {
		CitsorderAggDO agg=new CitsorderAggDO();
		
		MedSrvDO medSrvDO = BDSrvInfoCache.GetBdSrvInfo(ctx, id_srv); 
		if (ObjectUtils.isEmpty(medSrvDO)) {
			throw new BizException("获取主服务数据失败！");			
		}
		//创建治疗方案医嘱
		FDateTime createTime = CiOrdAppUtils.getServerDateTime();
		CiTsOrDO ciTsOrDo=new CiTsOrDO();
		String[] pkIds=CiOrderUtils.GeneratePKs(2);
		//主表默认赋值
		this.defaultCreateCiTsOrdInfo(ctx, ciTsOrDo, medSrvDO);
		ciTsOrDo.setStatus(DOStatus.NEW);
		ciTsOrDo.setDt_create(createTime);
		ciTsOrDo.setDt_effe(createTime.addSeconds(5)); // 生效时间
		ciTsOrDo.setDt_sign(createTime.addSeconds(7));
		ciTsOrDo.setId_tsor(pkIds[0]);
		agg.setParentDO(ciTsOrDo);
		//创建治疗方案主服务
		List<CiTsOrSrvDO> srvList= new ArrayList<CiTsOrSrvDO>();
		//序号初始值
		int sortNo=0;
		CiTsOrSrvDO ciTsOrSrvDo=new CiTsOrSrvDO();
		ciTsOrSrvDo.setStatus(DOStatus.NEW);
		ciTsOrSrvDo.setId_tsorsrv(pkIds[1]);
		ciTsOrSrvDo.setId_tsor(ciTsOrDo.getId_tsor());
		ciTsOrSrvDo.setDt_create(createTime);		

		this.defaultCreateCiTsOrdSrvInfo(ctx, ciTsOrSrvDo, medSrvDO);
		ciTsOrSrvDo.setSortno(sortNo);
		srvList.add(ciTsOrSrvDo);
		//服务套保存
		if(ObjectUtils.isTrue(medSrvDO.getFg_set())){
			List<EmsSrvSetViewDTO> emsLisSetItemList = this.getEmsLisSetItemList(medSrvDO.getId_srv());
			List<CiTsOrSrvSetDO> srvSetList= new ArrayList<CiTsOrSrvSetDO>();
			Map<String,MedSrvSetItemDO> setItemMap=this.getSrvSetItemMap(medSrvDO.getId_srv());
			for (EmsSrvSetViewDTO emsSrvSetViewDTO : emsLisSetItemList) {
				String[] pkids=CiOrderUtils.GeneratePKs(2);
				//创建服务信息
				CiTsOrSrvDO setSrvDo=new CiTsOrSrvDO();
				setSrvDo.setStatus(DOStatus.NEW);
				setSrvDo.setId_tsorsrv(pkids[0]);
				setSrvDo.setId_tsor(ciTsOrDo.getId_tsor());
				setSrvDo.setDt_create(createTime);
				//设置服务序号
				setSrvDo.setSortno(sortNo+1);
				sortNo++;
				//ctx
				this.defaultCreateCiTsOrdSrvInfo(ctx, setSrvDo, BDSrvInfoCache.GetBdSrvInfo(ctx, emsSrvSetViewDTO.getId_srv()));
				srvList.add(setSrvDo);
				//创建套信息
				CiTsOrSrvSetDO srvSetDo=new CiTsOrSrvSetDO();
				srvSetDo.setId_tsor(ciTsOrDo.getId_tsor());
				srvSetDo.setId_tsorsrvset(pkids[1]);
				srvSetDo.setId_tsorsrv(setSrvDo.getId_tsorsrv());
				srvSetDo.setStatus(DOStatus.NEW);
				this.defaultCreateCiTsOrdSrvSetInfo(srvSetDo, setItemMap.get(emsSrvSetViewDTO.getId_srv()));
				srvSetList.add(srvSetDo);
			}
			
			//放入套内项目
			agg.setCiTsOrSrvSetDO(srvSetList.toArray(new CiTsOrSrvSetDO[srvSetList.size()]));
		}
		//放入服务项目		
		agg.setCiTsOrSrvDO(srvList.toArray(new CiTsOrSrvDO[srvList.size()]));
		//对照界面信息
		this.mergeCiTsOrdInfo(agg.getParentDO(), id_srv);
		if(!ObjectUtils.isEmpty(agg.getCiTsOrSrvDO())){
			for(CiTsOrSrvDO ciTsOrSrvDO:agg.getCiTsOrSrvDO()){
				this.mergeCiTsOrdSrvInfo(ciTsOrSrvDO, id_srv,orTplItmDO);
			}
		}
		return agg;
	}
	/**
	 * 治疗方案医嘱数据合并逻辑
	 * @param ciTsOrDo
	 * @param emsViewDto
	 * @throws BizException
	 */
	protected void mergeCiTsOrdInfo(CiTsOrDO ciTsOrDo,String id_srv)throws BizException{
		/*ciTsOrDo.setDes_or();
		ciTsOrDo.setId_di_def();*/	        //临床诊断	
	}

	/**
	 * 治疗方案服务数据合并逻辑
	 * @param ciTsOrSrvDo
	 * @param orTplItmDO 
	 * @param emsViewDto
	 * @throws BizException
	 */
	protected void mergeCiTsOrdSrvInfo(CiTsOrSrvDO ciTsOrSrvDo,String id_srv, OrTplNItmDO orTplItmDO)throws BizException{
		if (orTplItmDO.getId_freq()!=null) {
			ciTsOrSrvDo.setId_freq(orTplItmDO.getId_freq());
		}
		if (orTplItmDO.getId_route()!=null) {
			ciTsOrSrvDo.setId_route(orTplItmDO.getId_route());
		}
		if (orTplItmDO.getQuan_medu_cur()!=null) {
			ciTsOrSrvDo.setQuan_medu(orTplItmDO.getQuan_medu_cur());
		}
		if (orTplItmDO.getId_medu_cur()!=null) {
			ciTsOrSrvDo.setId_medu(orTplItmDO.getId_medu_cur());
		}
	}
	protected Map<String,MedSrvSetItemDO> getSrvSetItemMap(String id_srv) throws BizException{
		MedSrvSetItemDO[] szMedSrvSetItemDO=BDSrvSetInfoCache.GetMedSrvSetItemInfo(id_srv);
		if(ObjectUtils.isEmpty(szMedSrvSetItemDO)){
			throw new BizException("获取服务套内项目数据失败！");
		}
		Map<String,MedSrvSetItemDO> setMap=new HashMap<String,MedSrvSetItemDO>();
		for(MedSrvSetItemDO itemDO:szMedSrvSetItemDO){
			setMap.put(itemDO.getId_srv_itm(), itemDO);
		}
		return setMap;
	}
	/**
	 * 创建套内项目
	 * @param id_srv
	 * @param fg_setradio
	 * @return
	 * @throws BizException
	 */
	protected List<EmsSrvSetViewDTO> getEmsLisSetItemList(String id_srv) throws BizException{
		SqlParamBuilder sbSql = new SqlParamBuilder()
				.appendSql(" select item.id_srv_itm as id_srv,srv.name as name_srv,item.fg_edit,item.fg_clinical,item.fg_check_def ")
				.appendSql(" from bd_srvset_def item  ")
				.appendSql(" left join bd_srv srv  on srv.id_srv = item.id_srv_itm ")
				.appendSql(" where item.fg_active='Y' and item.id_srv=? ").appendParam(id_srv);		
		List<EmsSrvSetViewDTO> setItemList= sbSql.Q(EmsSrvSetViewDTO.class);
		if(ObjectUtils.isEmpty(setItemList))return null;
		
		return setItemList;
	}
	/**
	 * 治疗方案服务套默认赋值逻辑
	 * @param ciTsOrSrvSetDo
	 * @param setItemDo
	 */
	protected void defaultCreateCiTsOrdSrvSetInfo(CiTsOrSrvSetDO ciTsOrSrvSetDo,MedSrvSetItemDO setItemDo){
		//		ciTsOrSrvSetDo.setId_tsorsrvset();		//治疗方案医嘱服务套ID
		//		ciTsOrSrvSetDo.setId_tsorsrv();	//医嘱服务项目ID
		//		ciTsOrSrvSetDo.setId_tsor();	 //治疗方案医嘱ID
		ciTsOrSrvSetDo.setId_srvsetdef(setItemDo.getId_srv());	//服务套项目定义主键	
		ciTsOrSrvSetDo.setId_srvset(setItemDo.getId_srv_itm());	 //套内服务项目主键	
		ciTsOrSrvSetDo.setName_srvset(setItemDo.getSet_name());	//套内服务项目名称	
		ciTsOrSrvSetDo.setSortno(setItemDo.getSortno());	 //序号
		ciTsOrSrvSetDo.setQuan_medu(setItemDo.getQuan_medu());	 //数值_医疗单位
		ciTsOrSrvSetDo.setId_medu(setItemDo.getId_medu());	 //医疗单位
		//		ciTsOrSrvSetDo.setId_body();	 //部位ID	
		//		ciTsOrSrvSetDo.setSd_body();	 //部位SD	
		//		ciTsOrSrvSetDo.setName_body();	 //部位	
		//		ciTsOrSrvSetDo.setId_pos();	 //方位ID	
		//		ciTsOrSrvSetDo.setSd_pos();	 //方位SD	
		//		ciTsOrSrvSetDo.setName_pos(); //方位
	}	
	/**
	 * 治疗方案服务项目默认赋值逻辑
	 * @param ctx
	 * @param ciTsOrSrvDo
	 * @param medSrvDO
	 */
	private void defaultCreateCiTsOrdSrvInfo(CiEnContextDTO ctx, CiTsOrSrvDO ciTsOrSrvDo, MedSrvDO medSrvDO) {
//		ciTsOrSrvDo.setId_tsorsrv();	    //医嘱服务项目ID		 
		//		ciTsOrSrvDo.setId_tsor();	        //治疗方案医嘱ID	
		ciTsOrSrvDo.setId_pat(ctx.getId_pat());	        //患者
		ciTsOrSrvDo.setId_en(ctx.getId_en());	        //就诊
		ciTsOrSrvDo.setSd_entp(ctx.getCode_entp());	        //就诊类型编码
		//		ciTsOrSrvDo.setSortno();	        //序号
		ciTsOrSrvDo.setSd_srvtp(medSrvDO.getSd_srvtp());	    //服务类型编码
		ciTsOrSrvDo.setId_srv(medSrvDO.getId_srv());	        //服务项目
		ciTsOrSrvDo.setCode_srv(medSrvDO.getCode());	    //服务编码
		ciTsOrSrvDo.setName(medSrvDO.getName());	        //服务项目名称
		ciTsOrSrvDo.setId_srvca(medSrvDO.getId_srvca());	    //服务项目分类
		ciTsOrSrvDo.setQuan_medu(medSrvDO.getQuan_med());	    //数值_医疗单位
		ciTsOrSrvDo.setId_medu(medSrvDO.getId_unit_med());	        //医疗单位
		//		ciTsOrSrvDo.setQuan_total_medu();	//服务总量
		ciTsOrSrvDo.setId_route(medSrvDO.getId_route());	    //医嘱用法
		ciTsOrSrvDo.setId_routedes(medSrvDO.getId_routedes());	    //医嘱用法要求
		ciTsOrSrvDo.setId_freq(medSrvDO.getId_freq());	        //医嘱频次	
		ciTsOrSrvDo.setId_boildes(medSrvDO.getId_boildes());	    //煎法要求	
		ciTsOrSrvDo.setSrv_des(medSrvDO.getDes());	        //服务备注	
		ciTsOrSrvDo.setFg_selfsrv(medSrvDO.getFg_ctm());	    //自定义服务标识	
		ciTsOrSrvDo.setId_org_srv(ctx.getId_org());	    //服务项目开立机构
		ciTsOrSrvDo.setId_dep_srv(ctx.getId_dep_en());	    //服务项目开立科室
		ciTsOrSrvDo.setId_dep_nur_srv(ctx.getId_dep_ns());	//服务项目开立病区
		ciTsOrSrvDo.setId_emp_srv(ctx.getId_emp_or());	    //服务项目开立人员
		//		ciTsOrSrvDo.setDt_create();	    //服务项目开立时间
		ciTsOrSrvDo.setId_wg_or(ctx.getId_wg_or());	    //医生医疗组	    
		//		ciTsOrSrvDo.setId_org_mp();	    //执行机构
		//		ciTsOrSrvDo.setId_dep_mp();	    //执行科室
		//		ciTsOrSrvDo.setSd_dep_mp();	    //执行科室来源模式
		ciTsOrSrvDo.setFg_or(medSrvDO.getFg_or());	        //医嘱标识
		ciTsOrSrvDo.setFg_mm(medSrvDO.getFg_mm());	        //物品标识
		
	}
	

	/**
	 * 治疗方案医嘱默认赋值逻辑
	 * @param ctx
	 * @param ciTsOrDo
	 * @param medSrvDO
	 * @throws BizException
	 */
	protected void defaultCreateCiTsOrdInfo(CiEnContextDTO ctx,CiTsOrDO ciTsOrDo,MedSrvDO medSrvDO) throws BizException{		
		//	    ciTsOrDo.setId_tsor();	            //治疗方案医嘱ID
		ciTsOrDo.setId_grp(ctx.getId_grp());	            //所属集团
		ciTsOrDo.setId_org(ctx.getId_org());	            //所属组织
		ciTsOrDo.setId_pat(ctx.getId_pat());	            //患者	
		ciTsOrDo.setId_en(ctx.getId_en());	            //就诊	
		ciTsOrDo.setSd_entp(ctx.getCode_entp());	            //就诊类型编码
		ciTsOrDo.setSd_srvtp(medSrvDO.getSd_srvtp());            //医嘱类型编码
		ciTsOrDo.setId_srv(medSrvDO.getId_srv());	            //服务	
		ciTsOrDo.setFg_set(medSrvDO.getFg_set());	            //服务套标识	
		ciTsOrDo.setFg_long(FBoolean.FALSE);	            //长临标识	
		ciTsOrDo.setCode_or(CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiTsOrDODesc.CLASS_FULLNAME));//医嘱编码	
		//		ciTsOrDo.setContent_or();	        //医嘱内容	需重写拼接方法
		ciTsOrDo.setName_or(medSrvDO.getName());	            //医嘱名称	
		ciTsOrDo.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);            //医嘱频次	
		ciTsOrDo.setId_route(medSrvDO.getId_route());	        //医嘱用法	
		ciTsOrDo.setId_routedes(medSrvDO.getId_routedes());	        //医嘱用法要求
		//		ciTsOrDo.setDays_or();	            //医嘱天数	
		ciTsOrDo.setId_boil(medSrvDO.getId_boil());	            //煎法
		//		ciTsOrDo.setOrders();	            //医嘱付数	
		//		ciTsOrDo.setTimes_cur();	        //次数	
		//		ciTsOrDo.setDt_bl_last();	        //最近生成日期时间	
		ciTsOrDo.setSd_tstp(ICiDictCodeConst.SD_TSTP_PREOP);	            //方案类型	
		ciTsOrDo.setEu_tsorsrcmdtp(ICiDictCodeConst.SD_TSORSRCMDTP_SRVREF);	    //方案医嘱来源方式
		ciTsOrDo.setSd_su_ts_or(ICiDictCodeConst.SD_SU_SIGN);	        //方案医嘱状态		 
		ciTsOrDo.setSd_su_ts_mp(ICiDictCodeConst.SD_SU_TS_MP_NONE);	        //方案医嘱生成状态

		//		ciTsOrDo.setDt_effe();	            //医嘱生效日期		 
		//		ciTsOrDo.setDt_end();	            //医嘱结束时间		 	 	 	 	 
		//		ciTsOrDo.setDes_or();	            //备注	
		//		ciTsOrDo.setId_srvof();	        //医疗单	
		//		ciTsOrDo.setFuncclassstr();	    //医疗单URL	
		ciTsOrDo.setId_org_create(ctx.getId_org());	    //开立机构	
		ciTsOrDo.setId_dep_create(ctx.getId_dep_en());	    //开立部门	
		ciTsOrDo.setId_wg_create(ctx.getId_wg_or());	    //开立医疗组	
		ciTsOrDo.setId_emp_create(ctx.getId_emp_or());	    //开立医生	
		ciTsOrDo.setId_dep_nur_create(ctx.getId_dep_ns());	//开立病区	
		//		ciTsOrDo.setDt_create();	        //开立日期	
		ciTsOrDo.setFg_sign(FBoolean.TRUE);	            //签署标识	
		ciTsOrDo.setId_emp_sign(ctx.getId_emp_or());	        //签署医生	
//		ciTsOrDo.setDt_sign(); 	        //签署日期	
		ciTsOrDo.setId_dep_sign(ctx.getId_dep_en());	        //签署部门	
		//		ciTsOrDo.setFg_stop();	            //停止标识	
		//		ciTsOrDo.setId_emp_stop();	        //停止医生	
		//		ciTsOrDo.setId_dep_stop();	        //停止科室	
		//		ciTsOrDo.setDt_stop();	            //停止日期	
		//		ciTsOrDo.setFg_canc();	            //作废标识	
		//		ciTsOrDo.setId_dep_canc();	        //作废科室	
		//		ciTsOrDo.setId_emp_canc();	        //作废医生	
		//		ciTsOrDo.setDt_canc();	            //作废日期	
		//		ciTsOrDo.setId_org_mp();	        //执行机构	
		//		ciTsOrDo.setId_dep_mp();	        //执行科室	
		//		ciTsOrDo.setId_di_def();	        //临床诊断	
		ciTsOrDo.setNo_applyform(CiAppNoUtils.getApplyNo(medSrvDO.getSd_srvtp()));	    //申请单号	
	}
}
