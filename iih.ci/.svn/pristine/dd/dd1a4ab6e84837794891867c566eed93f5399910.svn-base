package iih.ci.ord.s.ems.ip.assi.tpl.ris;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewItemDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.assi.base.BaseIpTplSaveBP;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查模板保存
 * @author Young
 *
 */
public class TplRisSaveBP extends BaseIpTplSaveBP {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		EmsSaveDTO tpl = szEms[0];
		FArrayList risList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(risList))
			return null;
		OrTplNItmDO tplItem = (OrTplNItmDO) risList.get(0);
		if (!CiOrdUtils.isEmpty(tplItem.getId_srv_set())) {
//			String code_or = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
			String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			OrTmplDO ortmpldo = ServiceFinder.find(IOrtmplMDORService.class).findById(tplItem.getId_ortmpl());
			MedSrvDO medMainSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(tplItem.getId_srv_set());
			EmsRisViewDTO ris = new EmsRisViewDTO();
			this.setEmsViewInfo(ctx, ortmpldo, tplItem, medMainSrvInfo, tpl.getDriverInfo(), ris, code_or, 1);
			// 计算物资流向科室
			this.setOrWfDeptInfo(ctx, medMainSrvInfo, ris);
			this.setEmsSetItmInfo(ctx, ortmpldo, risList, ris);
			FArrayList docmuent = new FArrayList();
			docmuent.append(ris);
			EmsSaveDTO save = super.getEmsSaveDTO(docmuent, tpl.getDriverInfo());
			return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx, EmsSaveDTO[].class, new EmsSaveDTO[] { save });
		}else{
			for (Object object : risList) {
//				String code_or = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
				String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
				OrTplNItmDO ortplnitmdo = (OrTplNItmDO) object;
				OrTmplDO ortmpldo = ServiceFinder.find(IOrtmplMDORService.class).findById(ortplnitmdo.getId_ortmpl());
				MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(ortplnitmdo.getId_srv());
				EmsRisViewDTO ris = new EmsRisViewDTO();
				this.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, tpl.getDriverInfo(), ris, code_or, 1);
				FArrayList docmuent = new FArrayList();
				docmuent.append(ris);
				EmsSaveDTO save = super.getEmsSaveDTO(docmuent, tpl.getDriverInfo());
				return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx, EmsSaveDTO[].class, new EmsSaveDTO[] { save });
			}
		}
		
		return null;
	}
	
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, OrTmplDO ortmpldo, OrTplNItmDO ortplnitmdo, MedSrvDO medSrvInfo, 
			EmsDriverInfo driverinfo, OrderListViewDTO orderListViewDTO, String code_or, int index) throws BizException {
		super.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, driverinfo, orderListViewDTO, code_or, index);
		
		EmsRisViewDTO ris = (EmsRisViewDTO) orderListViewDTO;
		ris.setId_pps(ICiDictCodeConst.Id_CI_OBS_OBJECTIVE);//检查目的ID
		ris.setSd_pps(ICiDictCodeConst.Sd_CI_OBS_OBJECTIVE);//检查目的编码
		ris.setName_pps(ICiDictCodeConst.NAME_OBS_OBJECTIVE);//检查目的：协助诊断
		ris.setNo_applyform(CiOrdUtils.getApplyNo(medSrvInfo.getSd_srvtp()));//申请单号
		ris.setClinicalzztz(OrderUtils.getClinicalzztzInfo(ctx.getId_en()));//临床症状体征
	}

	/**
	 * 拼装检查套内项目信息
	 * @param ctx
	 * @param ortmpldo
	 * @param risList
	 * @param ris
	 * @throws BizException
	 */
	private void setEmsSetItmInfo(CiEnContextDTO ctx, OrTmplDO ortmpldo, FArrayList risList, EmsRisViewDTO ris)
			throws BizException{
		FArrayList itemSets = new FArrayList();
		for (Object object : risList) {
			OrTplNItmDO ortplnitmdo = (OrTplNItmDO) object;
			MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(ortplnitmdo.getId_srv());
			MedSrvRisDO[] medSrvRisDOs = medSrvAggInfo.getMedSrvRisDO();
			if (medSrvRisDOs == null || medSrvRisDOs.length <= 0)
				continue;
			for (MedSrvRisDO medSrvRisDO : medSrvRisDOs) {
				EmsRisViewItemDTO itemSet = new EmsRisViewItemDTO();
				itemSet.setFg_edit(FBoolean.TRUE);//套内项可编辑标识
				itemSet.setFg_check(FBoolean.TRUE);//临床项目可选标志
				itemSet.setId_srv(medSrvAggInfo.getParentDO().getId_srv());//套内项服务ID
				itemSet.setName_srv(medSrvAggInfo.getParentDO().getName());//套内项服务
				itemSet.setId_primd(medSrvAggInfo.getParentDO().getId_primd());//套内项定价模式
				itemSet.setId_body(medSrvRisDO.getId_body());//检查部位ID
				itemSet.setSd_body(medSrvRisDO.getSd_body());//检查部位编码
				itemSet.setName_body(medSrvRisDO.getName_body());//检查部位
				itemSet.setId_pos(medSrvRisDO.getId_pos());//检查方位ID
				itemSet.setSd_pos(medSrvRisDO.getSd_pos());//检查方位编码
				itemSet.setName_pos(medSrvRisDO.getName_pos());//检查方位
				
				itemSets.append(itemSet);
			}
		}
		
		ris.setExtInfoList(itemSets);;
	}
}
