package iih.ci.ord.s.ems.ip.assi.tpl.lis;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsLisViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.assi.base.BaseIpTplSaveBP;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验模板保存
 * @author Young
 *
 */
public class TplLisSaveBP extends BaseIpTplSaveBP {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		EmsSaveDTO tpl = szEms[0];
		FArrayList lisList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(lisList))
			return null;
		for (Object object : lisList) {
//			String code_or = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
			String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			OrTplNItmDO ortplnitmdo = (OrTplNItmDO) object;
			OrTmplDO ortmpldo = ServiceFinder.find(IOrtmplMDORService.class).findById(ortplnitmdo.getId_ortmpl());
			MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(ortplnitmdo.getId_srv());
			EmsLisViewDTO lis = new EmsLisViewDTO();
			this.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, tpl.getDriverInfo(), lis, code_or, 1);
			// 计算物资流向科室
			this.setOrWfDeptInfo(ctx, medSrvInfo, lis);
			FArrayList docmuent = new FArrayList();
			docmuent.append(lis);
			EmsSaveDTO save = super.getEmsSaveDTO(docmuent, tpl.getDriverInfo());
			// 反射调用医疗单加载方法
			return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx,
					EmsSaveDTO[].class, new EmsSaveDTO[] { save });
		}
		
		return null;
	}
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, OrTmplDO ortmpldo, OrTplNItmDO ortplnitmdo, MedSrvDO medSrvInfo, 
			EmsDriverInfo driverinfo, OrderListViewDTO orderListViewDTO, String code_or, int index) throws BizException {
		super.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, driverinfo, orderListViewDTO, code_or, index);
		MedSrvLisDO[] medSrvLisDOs = ServiceFinder.find(IMedSrvLisDORService.class).find(String.format("a1.id_srv='%s'", medSrvInfo.getId_srv()), "", FBoolean.FALSE);
		
		EmsLisViewDTO lis = (EmsLisViewDTO) orderListViewDTO;
		lis.setId_samptp(medSrvLisDOs[0].getId_samptp());//标本类型ID
		lis.setSd_samptp(medSrvLisDOs[0].getSd_samptp());//标本类型编码
		lis.setName_samptp(medSrvLisDOs[0].getSamptp_name());//标本类型
		lis.setId_extend(medSrvLisDOs[0].getId_samptp());//标本类型ID
		lis.setSd_extend(medSrvLisDOs[0].getSd_samptp());//标本类型编码
		lis.setExtend(medSrvLisDOs[0].getSamptp_name());//标本类型
		lis.setId_sampcoltime(medSrvLisDOs[0].getId_sampcoltime()); //标本采集时间ID
		lis.setName_sampcoltime(medSrvLisDOs[0].getName_sampcoltime()); //标本采集时间
		lis.setId_sampcollecttimetp(medSrvLisDOs[0].getId_sampcollecttimetp()); //标本采集时间类型ID
		lis.setSd_sampcollecttimetp(medSrvLisDOs[0].getSd_sampcollecttimetp()); //标本采集时间类型编码
		lis.setLen_sampcoltime(medSrvLisDOs[0].getLen_sampcoltime()); //标本采集时长
		lis.setId_unit_sampcoltime(medSrvLisDOs[0].getId_unit_sampcoltime()); //标本采集时长单位
		lis.setPri(OrderEmsPriceUtils.calculatePrice(medSrvInfo, ctx.getId_pripat()));
	}
}
