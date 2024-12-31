package iih.ci.ord.s.ems.ip.assi.tpl.icons;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsConsViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.assi.base.BaseIpTplSaveBP;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 院内会诊模板保存
 * @author Young
 *
 */
public class TplIConsSaveBP extends BaseIpTplSaveBP {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		EmsSaveDTO tpl = szEms[0];
		FArrayList consList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(consList)) 
			return null;
		for (Object object : consList) {
//			String code_or = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
			String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			OrTplNItmDO ortplnitmdo = (OrTplNItmDO) object; 
			OrTmplDO ortmpldo = ServiceFinder.find(IOrtmplMDORService.class).findById(ortplnitmdo.getId_ortmpl());
			MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(ortplnitmdo.getId_srv());
			EmsConsViewDTO dead = new EmsConsViewDTO();
			super.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, tpl.getDriverInfo(), dead, code_or, 1);
			// 计算物资流向科室
			this.setOrWfDeptInfo(ctx, medSrvInfo, dead);
			FArrayList docmuent = new FArrayList();
			docmuent.append(dead);
			EmsSaveDTO save = super.getEmsSaveDTO(docmuent, tpl.getDriverInfo());
			// 反射调用医疗单加载方法
			return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx, EmsSaveDTO[].class, new EmsSaveDTO[] { save });
		}
		return null;
	}
}
