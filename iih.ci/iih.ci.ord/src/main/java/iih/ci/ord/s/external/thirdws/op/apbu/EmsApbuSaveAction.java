package iih.ci.ord.s.external.thirdws.op.apbu;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.CiOrdBtTestDO;
import iih.ci.ord.cior.d.CiOrdBtTestItmDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.i.ICiorappbuCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbubbDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuentDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuordDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonOrdDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.BloodManageUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertDTOs2XmlUtils;
import iih.ci.ord.s.external.thirdws.op.base.OpCommonSaveAction;
import iih.ci.ord.s.external.thirdws.utils.BdMeasdocUtils;
import iih.ci.ord.s.external.thirdws.utils.CiorderUtils;
import iih.ci.ord.s.external.thirdws.utils.MedSrvUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

public class EmsApbuSaveAction extends OpCommonSaveAction{

	@Override
	public String save(EntWsDTO entdto) throws BizException {
		//父类保存
		super.save(entdto);
		EmsapbuentDTO emsapbuentDTO = (EmsapbuentDTO)entdto;
		//从就诊中获取医嘱集合
		List<EmsapbuordDTO> ordList=emsapbuentDTO.getOrdlist();
		//定义医嘱aggDo集合
		List<CiorderAggDO> ciorderAggDOList = new ArrayList<>();
		//定义用血申请集合
		List<OrdAppBtUseDO> ordAppBtUseDOList= new ArrayList<OrdAppBtUseDO>();
 		for (EmsapbuordDTO emsapbuordDTO : ordList) {
 			//覆盖某些数值
 			if(!CiOrdUtils.isEmpty(emsapbuordDTO.getSrvList())){
 				for(EmsCommonSrvDTO sCommonSrvDTO:emsapbuordDTO.getSrvList()) {
 	 				//38费用项目单次数量
 					sCommonSrvDTO.setQuan_medu_cur(sCommonSrvDTO.getQuan_medu_srv());
 	 			}
 			}
 			emsapbuordDTO.setQuan_medu_or(emsapbuordDTO.getQuan_medu_bt());
 			String code_srv =BloodManageUtils.LL_CIOR0425();
 			// 医疗服务
 			IMedsrvMDORService medsrvMDOservice = ServiceFinder.find(IMedsrvMDORService.class);
 			MedSrvDO[] medSrvDO = medsrvMDOservice.find("code='"+code_srv+"'", null, FBoolean.FALSE);
 			if(medSrvDO==null||medSrvDO.length==0)
 			{
 				throw new BizException("LL_CIOR0425参数值不正确，无法查询到服务，请重新配置！");
 			}
 			emsapbuordDTO.setCode_srv_or(medSrvDO[0].getCode());
			//医嘱和服务的主子关系都在这方法里
			CiorderAggDO aggdo = this.assebleOrderAgg(emsapbuordDTO);
			ciorderAggDOList.add(aggdo);
			CiOrderDO ciOrderDO=aggdo.getParentDO();//获取当前主表 给后面逻辑用  
			//判断医嘱编码是否重复
			CiOrderDO isDuplicateCiOrderDO=CiorderUtils.getCiOrderDO(CiOrderDO.CODE_OR, ciOrderDO.getCode_or());
			if(isDuplicateCiOrderDO != null) {
				throw new BizException("医嘱编码重复");
			}
			//组装用血申请单
			ordAppBtUseDOList = this.assebleOrdAppBtUseDO(aggdo,emsapbuordDTO,ordAppBtUseDOList);
			//医嘱表设置关联备血申请单
			OrdApBtDO aptDo = getApbtByApplyNo(emsapbuordDTO.getNo_applyform_bt());
			if(aptDo != null) {
				ciOrderDO.setId_or_rel(aptDo.getId_or());
			}else {
				throw new BizException("未查询到与之对应的备血申请单，请查看备血申请单号与备血单的申请单号是否一致");
			}
			//再次组装  之前的组装取不到值 用血的需要取备血的name_or去拼装content_or 用于显示
			this.assembleContent_or(aggdo);
			CiOrderDO c = aggdo.getParentDO();
			if(!CiOrdUtils.isEmpty(ordAppBtUseDOList)) {
				//用服务的申请单号 覆盖父类医嘱给的
				c.setApplyno(ordAppBtUseDOList.get(0).getNo_applyform());
			}
		}
 		//保存
 		EmsRstDTO retdto=this.saveValue(ciorderAggDOList, ordAppBtUseDOList);
 		ConvertDTOs2XmlUtils util = new ConvertDTOs2XmlUtils();
		//返回XML
		return util.exec(new EmsRstDTO[]{retdto}, "rst", "");
	}
	/**
	 * 保存
	 * @param ciorderAggDOList
	 * @param ordAppBtUseDOList
	 * @return
	 * @throws BizException
	 */
	private EmsRstDTO saveValue(List<CiorderAggDO> ciorderAggDOList,List<OrdAppBtUseDO> ordAppBtUseDOList)throws BizException {
 		EmsRstDTO retdto = new EmsRstDTO();
 		try {
 			//保存医嘱和服务
 	 		ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
 	 		CiorderAggDO[] dos=ciorderAggDOList.toArray(new CiorderAggDO[0]);
 			dos=service.save(dos);
 	 		//保存申请单集合
 	 		if(!CiOrdUtils.isEmpty(ordAppBtUseDOList)) {
 	 			ICiorappbuCudService buService=ServiceFinder.find(ICiorappbuCudService.class);
 	 			buService.save(ordAppBtUseDOList.toArray(new OrdAppBtUseDO[0]));
 	 		}
 	 		//发送事件
 	 		this.fireSignEvent(dos);
 	 		retdto.setResultcode("0");
		} catch (Exception e) {
			retdto.setResultcode("1");
			retdto.setResultmsg(e.toString());
			throw new BizException(e);
		}
 		return retdto;
	}
	/**
	 * 重写组装医嘱和服务
	 */
	@Override
	public CiorderAggDO assebleOrderAgg(EmsCommonOrdDTO emsDrugsOrdDTO) throws BizException {
		CiorderAggDO aggdo=super.assebleOrderAgg(emsDrugsOrdDTO);
		EmsapbuordDTO  emsapbuordDTO=(EmsapbuordDTO)emsDrugsOrdDTO;
		//补充其他数据在这里
		//医嘱和服务设置id_or
		String[] id_or = new DBUtil().getOIDs(1);
		System.out.println("id_or:=================="+id_or[0]+"=====================");
		CiOrderDO ciOrderDO=aggdo.getParentDO();
		ciOrderDO.setId_or(id_or[0]);
		ciOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);//医嘱来源功能sd
		ciOrderDO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);//医嘱来源功能id
		OrdSrvDO[] srvDOs=(OrdSrvDO[]) aggdo.getChildrenDO();
		if(!CiOrdUtils.isEmpty(srvDOs)) {
			for(OrdSrvDO srv:srvDOs) {
				srv.setId_or(id_or[0]);
				//频次
				srv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
				srv.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
				//服务单位 从医嘱26申请用量单位出获取
				if(StringUtils.isNotEmpty(emsapbuordDTO.getCode_medu_bt())&&(StringUtils.isEmpty(srv.getId_medu())||srv.getId_srv().equals(aggdo.getParentDO().getId_srv()))) {
					MeasDocDO meas=BdMeasdocUtils.getMeasDocDOByCode(emsapbuordDTO.getCode_medu_bt());
					if(meas!=null) {
						srv.setId_medu(meas.getId_measdoc());
					}
				}
			}
		}
		return aggdo;
	}
	/**
	 * 组装用血申请
	 * @param aggdo
	 * @param emsapbuordDTO
	 * @param ordAppBtUseDOList
	 * @return
	 */
	private List<OrdAppBtUseDO> assebleOrdAppBtUseDO(CiorderAggDO aggdo,EmsapbuordDTO emsapbuordDTO,List<OrdAppBtUseDO> ordAppBtUseDOList) {
		OrdAppBtUseDO userDo=new OrdAppBtUseDO();
		CiOrderDO ciOrderDO = aggdo.getParentDO();
		userDo.setStatus(DOStatus.NEW);
		//医嘱id
		userDo.setId_or(ciOrderDO.getId_or());
		//19用血申请单号no_applyform_bu
		userDo.setNo_applyform(emsapbuordDTO.getNo_applyform_bu());
		//21手术间operationroom
		userDo.setOperationroom(emsapbuordDTO.getOperationroom());
		//22手术间电话operationroomtel
		userDo.setOperationroomtel(emsapbuordDTO.getOperationroomtel());
		//23医生联系电话applydoctortel
		userDo.setApplydoctortel(emsapbuordDTO.getApplydoctortel());
		//24计划用血日期dt_bu_plan
		if(StringUtils.isNotEmpty(emsapbuordDTO.getDt_bu_plan())) {
			userDo.setDt_bu_plan(new FDateTime(emsapbuordDTO.getDt_bu_plan()));
		}
		//--------传进来但表里没有该字段-------------
		//17医嘱序号sortno_or
		//18医嘱编码code_or
		//20备血申请单号no_applyform_bt
		//25申请用量quan_medu_bt
		//26申请用量单位code_medu_bt
		//27加急标识fg_urgent
		//28嘱托des_or
		//29开立机构code_org_or
		//30开立部门code_dep_or
		//31开立医疗组code_wg_or
		//32开立医生code_emp_or
		//33开立日期dt_entry_or
		//34医嘱执行机构code_org_mp_or
		//35医嘱执行科室code_dep_mp_or
		//-----------表里其他数据-----------
		//打印标识
		//打印次数
		//血液可申请血量
		ordAppBtUseDOList.add(userDo);
		return ordAppBtUseDOList;
	}
	@Override
	protected void assembleContent_or(CiorderAggDO agg) {
		CiOrderDO orderDO = agg.getParentDO();
		StringBuilder stringBuilder=new StringBuilder();
		//查询所关联的备血的名字 
		String id_or_rel=orderDO.getId_or_rel();
		try {
			CiOrderDO ciOrderDO=CiorderUtils.getCiOrderDO(CiOrderDO.ID_OR,id_or_rel);
			stringBuilder.append("输"+(ciOrderDO==null?orderDO.getName_or():ciOrderDO.getName_or())+orderDO.getQuan_medu()+"次");
			String string=CiOrContentUtils.create(orderDO.getSd_srvtp(), stringBuilder.toString(), orderDO.getRoute_name(), FBoolean.FALSE)
					.toString();
			System.out.println("content_or:----"+string+"---------");
			orderDO.setContent_or(string);
		} catch (BizException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取申请单
	 * @param applyNo
	 * @return
	 * @throws BizException
	 */
	private  OrdApBtDO getApbtByApplyNo(String applyNo) throws BizException {

		if (StringUtil.isEmpty(applyNo))
			return null;

		String sql = "select * from ci_ap_bt where no_applyform = ?  ";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(applyNo);

		OrdApBtDO apt = (OrdApBtDO) new DAFacade().execQuery(sql, sqlParam, new BeanHandler(OrdApBtDO.class));
		System.out.println("apt:"+(apt==null?"null":apt.toString()));
		return apt;
	}
	
	private void createBbInfor(CiorderAggDO aggdo,EmsapbuordDTO emsapbuordDTO) {
		CiOrdBtTestDO testdo=new CiOrdBtTestDO();
		testdo.setStatus(DOStatus.NEW);
		testdo.setId_pat(this.getEntdo().getId_pat());
		testdo.setId_ent(this.getEntdo().getId_ent());
		List<CiOrdBtTestItmDO> itmlist=new ArrayList<>();
        if(emsapbuordDTO.getBbList()!=null) {
        	List<EmsapbubbDTO> bblist=emsapbuordDTO.getBbList();
        	for (EmsapbubbDTO emsapbubbDTO : bblist) {
        		CiOrdBtTestItmDO itm=new CiOrdBtTestItmDO();
        		itm.setStatus(DOStatus.NEW);
        		itm.setId_tb(emsapbuordDTO.getNo_applyform_bu());
        		itm.setBarcode_bb(emsapbubbDTO.getBarcode_bb());
        		itm.setNum_bb(emsapbubbDTO.getNum_bb()==null?null:Integer.parseInt(emsapbubbDTO.getNum_bb()));
        	    
			}
        }
	}
	


}
