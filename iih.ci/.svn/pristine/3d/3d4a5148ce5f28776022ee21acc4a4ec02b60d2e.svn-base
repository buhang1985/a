package iih.ci.ord.s.ems.ip.assi.tpl.outhosp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsOutHospViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.assi.base.BaseIpTplSaveBP;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 出院模板保存
 * @author Young
 *
 */
public class TplOutHospSaveBP extends BaseIpTplSaveBP {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		EmsSaveDTO tpl = szEms[0];
		FArrayList outHospList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(outHospList)) 
			return null;
		for (Object object : outHospList) {
//			String code_or = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
			String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			OrTplNItmDO ortplnitmdo = (OrTplNItmDO) object; 
			OrTmplDO ortmpldo = ServiceFinder.find(IOrtmplMDORService.class).findById(ortplnitmdo.getId_ortmpl());
			MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(ortplnitmdo.getId_srv());
			EmsOutHospViewDTO outHosp = new EmsOutHospViewDTO();
			this.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, tpl.getDriverInfo(), outHosp, code_or, 1);
			// 计算物资流向科室
			this.setOrWfDeptInfo(ctx, medSrvInfo, outHosp);
			
			FArrayList docmuent = new FArrayList();
			docmuent.append(outHosp);
			EmsSaveDTO save = super.getEmsSaveDTO(docmuent, tpl.getDriverInfo());
			// 反射调用医疗单加载方法
			return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx, EmsSaveDTO[].class, new EmsSaveDTO[] { save });
		}
		
		return null;
	}
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, OrTmplDO ortmpldo, OrTplNItmDO ortplnitmdo, MedSrvDO medSrvInfo, 
			EmsDriverInfo driverinfo, OrderListViewDTO orderListViewDTO, String code_or, int index) throws BizException {
		super.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, driverinfo, orderListViewDTO, code_or, index);
		
		EmsOutHospViewDTO outHosp = (EmsOutHospViewDTO) orderListViewDTO;
		outHosp.setDt_timeout(outHosp.getDt_effe());//离院时间
		outHosp.setId_outtp(ICiDictCodeConst.ID_OUTTP_1);//离院方式ID
		outHosp.setSd_outtp(ICiDictCodeConst.SD_OUTTP_1);//离院方式编码
		outHosp.setName_outtp(ICiDictCodeConst.NAME_OUTTP_1);//离院方式
		outHosp.setFg_again31(FBoolean.FALSE);//31日内再次计划住院标识
	}
}
