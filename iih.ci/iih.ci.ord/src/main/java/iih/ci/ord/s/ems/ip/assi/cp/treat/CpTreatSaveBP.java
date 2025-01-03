package iih.ci.ord.s.ems.ip.assi.cp.treat;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.dws.ip.ems.d.EmsTreatViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseCpSaveBP;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import iih.hp.cp.docinfodto.d.DocSrvinfoDTO;
import iih.hp.cp.docinfodto.d.DocinfoDTO;
import iih.hp.cp.ele.d.HpCpElemOrderDO;
import iih.hp.cp.ele.i.IHpCpElemOrderDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床路径 - 治疗保存逻辑
 *
 */
public class CpTreatSaveBP extends BaseCpSaveBP {

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		EmsSaveDTO tpl = ems[0];
		FArrayList treatList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(treatList))
			return null;
		DocinfoDTO docinfo = (DocinfoDTO) treatList.get(0);		
		FArrayList srvinfoList = docinfo.getRefeleitems();
		for (Object object : srvinfoList) {
			FArrayList document = new FArrayList();
			String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			DocSrvinfoDTO srv=(DocSrvinfoDTO) object;
			HpCpElemOrderDO[] ords=ServiceFinder.find(IHpCpElemOrderDORService.class).find(" id_ele='"+srv.getId_ele()+"'","",FBoolean.FALSE);
			if(ords!=null&&ords.length>0) {
				// 获取主服务信息
				MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(srv.getId_srv());
				// 拼装医疗单ui
				EmsTreatViewDTO treat = new EmsTreatViewDTO();
				setEmsViewInfo( ctx,  medSrvInfo, tpl.getDriverInfo(),
						treat,  code_or,  1,  ords[0]);
				treat.setDays_or(1);
				// 计算物资流向科室
				this.setOrWfDeptInfo(ctx, medSrvInfo, treat);
				 try {
					   treat.setPri(OrderEmsPriceUtils.calculatePrice(medSrvInfo, ctx.getId_pripat()));
				   }catch(Exception ex) {
					   Logger.error(ex);
				   }
				 treat.setQuan_med((CiOrdUtils.isTrue(medSrvInfo.getIsmuldose()) ? ords[0].getDosage() : new FDouble(1)));// 剂量
				document.add(treat);
				EmsSaveDTO save = super.getEmsSaveDTO(document, tpl.getDriverInfo());
				return new EmsTreatSave4CP().save(ctx, new EmsSaveDTO[] {save});
			}
		}
		return null;
	}

	
}
