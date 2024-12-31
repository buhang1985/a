package iih.ci.ord.s.ems.op.ems.apbu;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.ciordems.d.EmsBuItemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.op.base.OpBaseEmsLoadBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsExtInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 用血医疗单加载逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsApBuLoadBP extends OpBaseEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsLoadDTO arg = args[0];
		EmsRstDTO[] rsts = super.load(ctx, args);
		EmsRstDTO rst = rsts[0];
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo){
			throw new BizException ("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		
		MedSrvDO med = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv()).getParentDO();
		EmsBuItemDO ems = ciOrdBuInfoFrom(ctx, ciEmsInfo);
        // 医疗单对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
        // 主服务对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, med);
        // 获取执行科室
 		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, med.getId_srv(), "","","",med.getFg_long(),FBoolean.FALSE,ems.getDt_begin_ui());
 		if(!CiOrdUtils.isEmpty(wf)){
 		// 保存执行科室过滤条件
 			OrderEmsExtInfoUtils.SetMpDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_mp_depts())?null:wf.getId_mp_depts());
        
 			// 保存物资流向
 			OrderEmsExtInfoUtils.SetWhDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_dept_whs())?null:wf.getId_dept_whs());
 			OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
 			OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
 		}
        // 医疗单模型文档
        rst.setDocument(this.handleReturnDocument(ems));
//        rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
        // 医疗单类型
        rst.getDriverInfo().setEmsBackendDriver(EmsType.BTUSE.toString());
        return rsts;
	}

	
	protected EmsBuItemDO ciOrdBuInfoFrom(CiEnContextDTO ctx, CiEmsDTO dto) throws BizException {
		Object objOrdAppBtUseInfo = dto.getOrapplysheet().get((EmsType.BTUSE).toString());
		if (null == objOrdAppBtUseInfo){
			throw new BizException("获取用血申请单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APPSHEET_NULL);
		}
        OrdAppBtUseDO buDO = (OrdAppBtUseDO)objOrdAppBtUseInfo ;
        CiorappbtAggDO [] szBtInfo = ServiceFinder.find(ICiorappbtRService.class).find("a0.id_or='" + dto.getId_or_rel() + "'", null, FBoolean.FALSE);
        if (szBtInfo == null || szBtInfo.length == 0){
        	throw new BizException("获取备血申请单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APPSHEET_NULL);
        }
        OrdApBtDO btDO = szBtInfo[0].getParentDO();
        
		CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx, dto);
		EmsBuItemDO model = null;
		if (buDO != null) {
			model = new EmsBuItemDO();

			model.setId_or(dto.getId_or_rel());
			model.setId_srv(dto.getId_srv());
			model.setName_srv(dto.getName());
			model.setId_apbu(buDO.getId_apbu());

			model.setNo_applyform_bt(btDO.getNo_applyform());
			model.setNo_applyform_bu(buDO.getNo_applyform());

			model.setQuan_medu_bu(mainSrvInfo.getQuan_med());
			model.setQuan_avi_bt(btDO.getNum_margin_bu());
			model.setQuan_medu_bt(btDO.getNum_margin_bu());
			model.setId_unit(mainSrvInfo.getId_unit_med());
			model.setName_unit(mainSrvInfo.getName_unit_med());

			model.setId_route(dto.getId_route());
			model.setName_route(dto.getName_route());

			model.setDt_pl_bt(new FDateTime(btDO.getDt_bt_pl()));
			model.setDt_pl_bu(buDO.getDt_bu_plan());

			model.setId_emp_bu(dto.getId_emp_phy());
			model.setName_emp_bu(dto.getName_emp_phy());

			model.setId_dep_mp(mainSrvInfo.getId_dep());
			model.setName_dep_mp(mainSrvInfo.getName_dep());
			
			model.setId_app_bloodtype(btDO.getId_bloodtype_ap());
			model.setSd_app_bloodtype(btDO.getSd_bloodtype_ap());
			model.setName_app_bloodtype(btDO.getName_bloodtp());
			
			model.setId_app_rhd(btDO.getId_rhd_ap());
			model.setSd_app_rhd(btDO.getSd_rhd_ap());
			model.setName_app_rhd(btDO.getName_rhd());

			model.setDes_or(dto.getNote());
			
			model.setOperationroom(buDO.getOperationroom());
			model.setOperationroomtel(buDO.getOperationroomtel());
			model.setApplydoctortel(buDO.getApplydoctortel());
			
                        model.setId_blodquan(buDO.getId_blodquan());
			model.setQuan_blood(model.getQuan_medu_bu().toString());

			model.setStatus(DOStatus.UPDATED);
		}
		return model;
    }

}
