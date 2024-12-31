package iih.ci.ord.s.ems.ip.assi.tpl.pathgy;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsPathgyViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.assi.base.BaseIpTplSaveBP;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 病理模板保存
 * @author Young
 *
 */
public class TplPathgySaveBP extends BaseIpTplSaveBP {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		EmsSaveDTO tpl = szEms[0];
		FArrayList pathgyList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(pathgyList)) 
			return null;
		for (Object object : pathgyList) {
//			String code_or = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
			String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			OrTplNItmDO ortplnitmdo = (OrTplNItmDO) object; 
			OrTmplDO ortmpldo = ServiceFinder.find(IOrtmplMDORService.class).findById(ortplnitmdo.getId_ortmpl());
			MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(ortplnitmdo.getId_srv());
			EmsPathgyViewDTO pathgy = new EmsPathgyViewDTO();
			this.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, tpl.getDriverInfo(), pathgy, code_or, 1);
			// 计算物资流向科室
			this.setOrWfDeptInfo(ctx, medSrvInfo, pathgy);
			FArrayList docmuent = new FArrayList();
			docmuent.append(pathgy);
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
		MedSrvLisDO[] medSrvLisDOs = ServiceFinder.find(IMedSrvLisDORService.class).find(String.format("a1.id_srv='%s'", medSrvInfo.getId_srv()), "", FBoolean.FALSE);
		if (null == medSrvLisDOs || medSrvLisDOs.length == 0) {
			return;
		}
		EmsPathgyViewDTO pathgy = (EmsPathgyViewDTO) orderListViewDTO;
		pathgy.setId_samptp(medSrvLisDOs[0].getId_samptp());//标本类型ID
		pathgy.setSd_samptp(medSrvLisDOs[0].getSd_samptp());//标本类型编码
		pathgy.setName_samptp(medSrvLisDOs[0].getSamptp_name());//标本类型
		pathgy.setDes_sympsign(OrderUtils.getClinicalzztzInfo(ctx.getId_en()));//病情描述
		pathgy.setFg_outer(FBoolean.FALSE);//是否外院
		pathgy.setOrg_pathgy_old(ctx.getName_grp());//既往医院
		pathgy.setId_emp(ctx.getId_emp_or());//采集者ID
		pathgy.setName_emp(ctx.getName_emp_or());//采集者
		pathgy.setDt_coll(CiOrdAppUtils.getServerDateTime());//采集时间
		
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			pathgy.setId_di(diagOutlineInfo.getId_di());// 主诊断的主项目id
			pathgy.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断id
			pathgy.setName_diitm(diagOutlineInfo.getName_diag());// 主诊断名称
		}
	}
}
