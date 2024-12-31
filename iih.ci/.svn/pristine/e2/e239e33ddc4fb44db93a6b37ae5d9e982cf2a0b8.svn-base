package iih.ci.ord.s.ems.op.ems.apbu;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.medsrvbloodquancanap.d.MedsrvbloodquancanapDO;
import iih.bd.srv.medsrvbloodquancanap.i.IMedsrvbloodquancanapRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.ciordems.d.EmsBuItemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.op.base.OpBaseEmsCreateBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsExtInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 备血医疗单保存逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsApBuCreateBP extends OpBaseEmsCreateBP {
	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsarray) throws BizException {
		// TODO Auto-generated method stub
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(
				ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！",
					CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		if (CiOrdUtils.isEmpty(ems.getExtension())) {
			throw new BizException("用血模板为空，开用血医疗单失败",
					CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APBU_TMPL_NULL);
		}

		// 合成主UI模型对象
		EmsBuItemDO emsModel = emsModelFrom(ems.getExtension()
				.get("CustomInfo").toString(), aggDO.getParentDO());

		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, aggDO.getParentDO().getId_srv(), "", "","",aggDO.getParentDO().getFg_long(),FBoolean.FALSE,emsModel.getDt_begin_ui());
		if (!CiOrdUtils.isEmpty(wf)){
			// 封装错误信息
			//FArrayList errorlist=new FArrayList();
			//errorlist.append("获取执行科室失败");
			//OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			//rsts.add(rst);
			//return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
			emsModel.setId_dep_mp(wf.getFirstid_mp_dept());
			emsModel.setName_dep_mp(wf.getFirstname_mp_dept());
			// 保存执行科室过滤条件
			OrderEmsExtInfoUtils.SetMpDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_mp_depts())?null:wf.getId_mp_depts());
			
			// 保存物资流向
			OrderEmsExtInfoUtils.SetWhDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_dept_whs())?null:wf.getId_dept_whs());
			OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
			OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		}
		//获取申请血量
		MedsrvbloodquancanapDO[] bloodquans=getBooldQuan(emsModel.getId_srv());
		if(bloodquans.length>0){
			if(!CiOrdUtils.isEmpty(emsModel.getQuan_avi_bt())){
				for(MedsrvbloodquancanapDO bloodquan : bloodquans){
					if(bloodquan.getQuan_blood()==emsModel.getQuan_avi_bt()){
						emsModel.setQuan_blood(bloodquan.getQuan_blood().toString());
						emsModel.setId_blodquan(bloodquan.getId_srvblodquancanap());
					}
				}
			}else{
				emsModel.setQuan_blood(bloodquans[0].getQuan_blood().toString());
				emsModel.setId_blodquan(bloodquans[0].getId_srvblodquancanap());
			}
		}
		emsModel.setId_dep_mp(wf.getFirstid_mp_dept());
		emsModel.setName_dep_mp(wf.getFirstname_mp_dept());

		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO());



		// 返回处理
		rst.setDocument(this.handleReturnDocument(emsModel));
		// rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.getDriverInfo().setEmsBackendDriver(EmsType.BTUSE.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}
			
	private OrdSrvDO mainOrdSrvDOFrom(CiorderAggDO ciagg) {
		CiOrderDO ordInfo = ciagg.getParentDO();
		for (OrdSrvDO srvInf : ciagg.getOrdSrvDO()) {
			if (srvInf.getId_srv().equals(ordInfo.getId_srv())) {
				return srvInf;
			}
		}
		return null;
	}

	private EmsBuItemDO emsModelFrom(String id_or, MedSrvDO med)
			throws BizException {
		FDateTime tm = CiOrdAppUtils.getServerDateTime();

		CiorderAggDO ciagg = ServiceFinder.find(ICiorderRService.class)
				.findById(id_or);
		CiOrderDO ciOrder = ciagg.getParentDO();
		CiorappbtAggDO[] szApbtAggInfo = ServiceFinder.find(
				ICiorappbtRService.class).find("id_or='" + id_or + "'", null,
				FBoolean.FALSE);
		OrdApBtDO btdo = szApbtAggInfo[0].getParentDO();
		OrdSrvDO mainSrvInfo = mainOrdSrvDOFrom(ciagg);

		EmsBuItemDO apbu = new EmsBuItemDO();
		if (null != mainSrvInfo) {
			apbu.setId_or(ciOrder.getId_or());
			apbu.setNo_applyform_bt(btdo.getNo_applyform());
			apbu.setNo_applyform_bu(CiOrdUtils.getApplyNo(med.getSd_srvtp()));
			apbu.setId_srv(mainSrvInfo.getId_srv());
			apbu.setName_srv(mainSrvInfo.getName());

			apbu.setQuan_medu_bt(mainSrvInfo.getQuan_medu());
			apbu.setQuan_medu_bu(apbu.getQuan_medu_bt());
			apbu.setQuan_avi_bt(btdo.getNum_margin_bu());
			apbu.setId_unit(mainSrvInfo.getId_medu());
			apbu.setName_unit(mainSrvInfo.getMedu_name());

			apbu.setId_route(med.getId_route());
			apbu.setName_route(med.getRoute_name());

			apbu.setDt_pl_bt(new FDateTime(btdo.getDt_bt_pl()));
			apbu.setDt_pl_bu(apbu.getDt_pl_bt());

			apbu.setId_emp_bu(ciOrder.getId_emp_sign());
			apbu.setName_emp_bu(ciOrder.getEmp_sign_name());

			apbu.setId_app_bloodtype(btdo.getId_bloodtype_ap());
			apbu.setSd_app_bloodtype(btdo.getSd_bloodtype_ap());
			apbu.setName_app_bloodtype(btdo.getName_bloodtp());

			apbu.setId_app_rhd(btdo.getId_rhd_ap());
			apbu.setSd_app_rhd(btdo.getSd_rhd_ap());
			apbu.setName_app_rhd(btdo.getName_rhd());

			apbu.setUse_days(1);
			apbu.setTimes_cur(new GetTotalTimesBP().getTotalTimes(tm,
					med.getId_freq(), apbu.getUse_days()));
			apbu.setDt_begin_ui(tm);
			apbu.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1),
					tm.getUFTime()));
			apbu.setStatus(DOStatus.NEW);
		}
		return apbu;
	}
	private MedsrvbloodquancanapDO[] getBooldQuan(String id_srv) throws BizException{
		IMedsrvbloodquancanapRService service = ServiceFinder.find(IMedsrvbloodquancanapRService.class);
		String wherestr=String.format("id_srv='%s'", id_srv);
		return service.find(wherestr, "quan_blood", FBoolean.FALSE);
	}

}
