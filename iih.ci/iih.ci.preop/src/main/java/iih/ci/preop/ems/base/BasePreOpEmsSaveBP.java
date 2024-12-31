package iih.ci.preop.ems.base;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.preop.ems.d.b.BasePreOpEmsViewDTO;
import iih.ci.sdk.cache.BDSrvInfoCache;
import iih.ci.sdk.cache.BDSrvSetInfoCache;
import iih.ci.sdk.ems.bp.BaseEmsSaveBP;
import iih.ci.sdk.orctt.CiOrContentUtils;
import iih.ci.sdk.utils.CiAppNoUtils;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.CiOrderUtils;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.d.CiTsOrSrvDO;
import iih.ci.tsip.d.CiTsOrSrvSetDO;
import iih.ci.tsip.d.CitsorderAggDO;
import iih.ci.tsip.d.desc.CiTsOrDODesc;
import iih.ci.tsip.i.ICitsorderCudService;
import iih.ci.tsip.i.ICitsorderMDOCudService;
import iih.ci.tsip.i.ICitsorderMDORService;
import iih.ci.tsip.i.ICitsorderRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class BasePreOpEmsSaveBP extends BaseEmsSaveBP{
	@Override
	public EmsRstDTO save(CiEnContextDTO ctx, EmsSaveDTO ems) throws BizException {
		EmsRstDTO rst = new EmsRstDTO();

		if(ObjectUtils.isEmpty(ems.getDocument()) || !(ems.getDocument().get(0) instanceof BasePreOpEmsViewDTO)){
			throw new BizException("获取预住院申请单数据失败！");
		}
		BasePreOpEmsViewDTO emsViewDto=(BasePreOpEmsViewDTO)ems.getDocument().get(0);
		CitsorderAggDO ciTsOrderAggDO=new CitsorderAggDO();
		if(emsViewDto.getStatus()== DOStatus.NEW){
			ciTsOrderAggDO=this.handleCreateOrderInfo(ctx, emsViewDto);
		}else if(emsViewDto.getStatus()== DOStatus.UPDATED){
			ciTsOrderAggDO=this.handleUpdateOrderInfo(ctx, emsViewDto);
		}
		//拼接医嘱内容
		CiOrContentDO contentDO=this.setOrContentInfo(ciTsOrderAggDO,emsViewDto);
		ciTsOrderAggDO.getParentDO().setContent_or(contentDO.toString());
		//保存治疗方案
		CitsorderAggDO[] rtnAggDto=ServiceFinder.find(ICitsorderCudService.class).save(new CitsorderAggDO[]{ciTsOrderAggDO});
		if(ObjectUtils.isEmpty(rtnAggDto)){
			throw new BizException("预住院申请单保存失败！");
		}
		//保存申请单属性表
		this.afterSaveTsOrderAggInfo(ctx, rtnAggDto[0], emsViewDto);
		FArrayList objList = new FArrayList();
		objList.add(rtnAggDto[0]);
		rst.setDocument(objList);
		return rst;
	}
	/**
	 * 新增治疗方案处理逻辑(保存签署)
	 * @param ctx
	 * @param emsViewDto
	 * @return
	 * @throws BizException
	 */
	protected CitsorderAggDO handleCreateOrderInfo(CiEnContextDTO ctx,BasePreOpEmsViewDTO emsViewDto) throws BizException{
		CitsorderAggDO agg=new CitsorderAggDO();
		MedSrvDO medSrvDO = BDSrvInfoCache.GetBdSrvInfo(ctx, emsViewDto.getId_srv()); 
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
			String[] id_srvsets=emsViewDto.getId_srv_items().split(",");
			List<CiTsOrSrvSetDO> srvSetList= new ArrayList<CiTsOrSrvSetDO>();
			Map<String,MedSrvSetItemDO> setItemMap=this.getSrvSetItemMap(medSrvDO.getId_srv());
			for(String id_srv:id_srvsets){
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
		this.mergeCiTsOrdInfo(agg.getParentDO(), emsViewDto);
		if(!ObjectUtils.isEmpty(agg.getCiTsOrSrvDO())){
			for(CiTsOrSrvDO ciTsOrSrvDO:agg.getCiTsOrSrvDO()){
				this.mergeCiTsOrdSrvInfo(ciTsOrSrvDO, emsViewDto);
			}
		}
		return agg;
	}
	/**
	 * 编辑治疗方案处理逻辑(作废原有医嘱，重新保存新医嘱)
	 * @param ctx
	 * @param emsViewDto
	 * @return
	 * @throws BizException
	 */
	protected CitsorderAggDO handleUpdateOrderInfo(CiEnContextDTO ctx,BasePreOpEmsViewDTO emsViewDto) throws BizException{
		CiTsOrDO[] ciTsOrDOs=ServiceFinder.find(ICitsorderMDORService.class).findByAttrValString(CiTsOrDO.CODE_OR, emsViewDto.getCode_or());
		if(ObjectUtils.isEmpty(ciTsOrDOs)){
			throw new BizException("查询治疗方案医嘱信息CiTsOrDO失败！");	
		}
		// 如果操作过程中，医嘱已被导入，则抛出异常
		if ("20".equals(ciTsOrDOs[0].getSd_su_ts_mp())) {
		    throw new BizException("数据已发生改变，请刷新后重新进入操作界面！");
		}
		ciTsOrDOs[0].setStatus(DOStatus.UPDATED);
		ciTsOrDOs[0].setSd_su_ts_or(ICiDictCodeConst.SD_SU_CANCEL);
		ciTsOrDOs[0].setFg_canc(FBoolean.TRUE);
		ciTsOrDOs[0].setId_dep_canc(ctx.getId_dep_en());
		ciTsOrDOs[0].setId_emp_canc(ctx.getId_emp_or());
		ciTsOrDOs[0].setDt_canc(CiOrdAppUtils.getServerDateTime());
		ServiceFinder.find(ICitsorderMDOCudService.class).save(ciTsOrDOs);		
		return this.handleCreateOrderInfo(ctx, emsViewDto);		
	}
	protected void createCiTsOrSrvSetInfo(){

	}

	/**
	 * 保存治疗方案后处理逻辑
	 * @param ctx
	 * @param aggD
	 * @param emsViewDto
	 * @throws BizException
	 */
	protected void afterSaveTsOrderAggInfo(CiEnContextDTO ctx,CitsorderAggDO aggD,BasePreOpEmsViewDTO emsViewDto) throws BizException {

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


	protected int GetObjStatus(Object objDO) {
		return ((BasePreOpEmsViewDTO) objDO).getStatus();
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

	/**
	 * 治疗方案服务项目默认赋值逻辑
	 * @param ctx
	 * @param ciTsOrSrvDo
	 * @param medSrvDO
	 */
	protected void defaultCreateCiTsOrdSrvInfo(CiEnContextDTO ctx,CiTsOrSrvDO ciTsOrSrvDo,MedSrvDO medSrvDO){
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
	 * 治疗方案医嘱数据合并逻辑
	 * @param ciTsOrDo
	 * @param emsViewDto
	 * @throws BizException
	 */
	protected void mergeCiTsOrdInfo(CiTsOrDO ciTsOrDo,BasePreOpEmsViewDTO emsViewDto)throws BizException{
		ciTsOrDo.setDes_or(emsViewDto.getDes_or());
		ciTsOrDo.setId_di_def(emsViewDto.getId_diitem());	        //临床诊断	
	}

	/**
	 * 治疗方案服务数据合并逻辑
	 * @param ciTsOrSrvDo
	 * @param emsViewDto
	 * @throws BizException
	 */
	protected void mergeCiTsOrdSrvInfo(CiTsOrSrvDO ciTsOrSrvDo,BasePreOpEmsViewDTO emsViewDto)throws BizException{
		ciTsOrSrvDo.setQuan_medu(emsViewDto.getQuan_med());
		ciTsOrSrvDo.setId_medu(emsViewDto.getId_unit_med());
	}
	/**
	 * 治疗方案申请单数据合并逻辑
	 * @param ciTsApInfoDo
	 * @param emsViewDto
	 * @throws BizException
	 */
	protected void mergeCiTsOrdAppInfo(Object ciTsApInfoDo,BasePreOpEmsViewDTO emsViewDto)throws BizException{
	}

	/**
	 * 医嘱内容拼接
	 * @param tsOrdAggDO
	 * @return
	 */
	protected CiOrContentDO setOrContentInfo(CitsorderAggDO tsOrdAggDO,BasePreOpEmsViewDTO emsViewDto) throws BizException{
		return CiOrContentUtils.getNullContent();
	}
}
