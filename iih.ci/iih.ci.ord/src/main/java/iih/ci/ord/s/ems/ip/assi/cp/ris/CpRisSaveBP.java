package iih.ci.ord.s.ems.ip.assi.cp.ris;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewItemDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseCpSaveBP;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.hp.cp.docinfodto.d.DocSrvinfoDTO;
import iih.hp.cp.docinfodto.d.DocinfoDTO;
import iih.hp.cp.ele.d.HpCpElemOrderDO;
import iih.hp.cp.ele.i.IHpCpElemOrderDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 临床路径 - 检查保存逻辑
 *
 */
public class CpRisSaveBP extends BaseCpSaveBP {
	
	private ICiOrdQryService qryService = ServiceFinder.find(ICiOrdQryService.class);

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		EmsSaveDTO tpl = ems[0];
		FArrayList labList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(labList))
			return null;
		DocinfoDTO docinfo = (DocinfoDTO) labList.get(0);		
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
				EmsRisViewDTO ris = new EmsRisViewDTO();
				setEmsViewInfo( ctx,  medSrvInfo, tpl.getDriverInfo(),
						ris,  code_or,  1,  ords[0]);
				document.add(ris);
				EmsSaveDTO save = super.getEmsSaveDTO(document, tpl.getDriverInfo());
				return new EmsRisSave4CP().save(ctx, new EmsSaveDTO[] {save});
			}				
		}
		return null;
	}
	
	
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, MedSrvDO medSrvInfo, EmsDriverInfo driverinfo,
			OrderListViewDTO orderListViewDTO, String code_or, int index, HpCpElemOrderDO eleord) throws BizException {
		// TODO Auto-generated method stub		
		super.setEmsViewInfo(ctx, medSrvInfo, driverinfo, orderListViewDTO, code_or, index,eleord);
		EmsRisViewDTO ris = (EmsRisViewDTO)orderListViewDTO;
		if(medSrvInfo.getFg_set().booleanValue()) {
			setEmsSetItmInfo( ctx,  medSrvInfo,   ris);
		}
		
//		MedSrvRisDO[] medSrvRisDOs = ServiceFinder.find(IMedSrvRisDORService.class).find(String.format("a1.id_srv='%s'", medSrvInfo.getId_srv()), "", FBoolean.FALSE);
		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(medSrvInfo.getId_srv());
		MedSrvRisDO[] medSrvRisDOs = medSrvAggInfo.getMedSrvRisDO();
	   try {
		   ris.setPri(OrderEmsPriceUtils.calculatePrice(medSrvInfo, ctx.getId_pripat()));
	   }catch(Exception ex) {
		   System.out.print(ex.getMessage());
	   }
		
		ris.setId_pps(ICiDictCodeConst.Id_CI_OBS_OBJECTIVE);//检查目的ID
		ris.setSd_pps(ICiDictCodeConst.Sd_CI_OBS_OBJECTIVE);//检查目的编码
		ris.setName_pps(ICiDictCodeConst.NAME_OBS_OBJECTIVE);//检查目的：协助诊断
		ris.setNo_applyform(CiOrdUtils.getApplyNo(medSrvInfo.getSd_srvtp()));//申请单号
		//获取最新的临床症状及体征
		String theLatestClinicalzztz = qryService.getClinicalzztz(ctx.getId_en());
		//获取诊断信息
		String[] diagArray = qryService.getDiagArray(ctx.getId_en());
		String str_name_di = "";
		if (diagArray != null && diagArray.length > 0) {
			ris.setId_di(diagArray[7]);//主诊断的主项目id
			ris.setId_diitm(diagArray[3]);//主诊断id
			ris.setName_diitm(diagArray[4]);//主诊断名称
			str_name_di = diagArray[0];//诊断名称拼接
			//diagArray[1];//诊断编码拼接
			//diagArray[2];//诊断子项目id拼接
			//diagArray[5];//诊断id
		}
		//将诊断也拼接到临床病症及体征中
		if (StringUtils.isNotEmpty(str_name_di)) {
			if (StringUtils.isEmpty(theLatestClinicalzztz)) {
				theLatestClinicalzztz = "诊断：" + str_name_di.replace("&", "；");
			} else if (!theLatestClinicalzztz.contains("诊断：")) {
				theLatestClinicalzztz += "\r\n" + "诊断：" + str_name_di.replace("&", "；");
			}
		} 
		ris.setClinicalzztz(theLatestClinicalzztz);//临床症状体征
		
		// 计算物资流向科室
		this.setOrWfDeptInfo(ctx, medSrvInfo, ris);
		orderListViewDTO.setQuan_med((CiOrdUtils.isTrue(medSrvInfo.getIsmuldose()) ? eleord.getDosage() : new FDouble(1)));// 剂量
		orderListViewDTO.setDays_or(1);
		if(!medSrvInfo.getFg_set().booleanValue()) {
		FArrayList itemSets = new FArrayList();
		EmsRisViewItemDTO itemSet = new EmsRisViewItemDTO();
		itemSet.setFg_edit(FBoolean.TRUE);//套内项可编辑标识
		itemSet.setFg_check(FBoolean.TRUE);//临床项目可选标志
		itemSet.setId_srv(medSrvInfo.getId_srv());//套内项服务ID
		itemSet.setName_srv(medSrvInfo.getName());//套内项服务
		itemSet.setId_primd(medSrvInfo.getId_primd());//套内项定价模式
		itemSet.setId_body(medSrvRisDOs[0].getId_body());//检查部位ID
		itemSet.setSd_body(medSrvRisDOs[0].getSd_body());//检查部位编码
		itemSet.setName_body(medSrvRisDOs[0].getName_body());//检查部位
		itemSet.setId_pos(medSrvRisDOs[0].getId_pos());//检查方位ID
		itemSet.setSd_pos(medSrvRisDOs[0].getSd_pos());//检查方位编码
		itemSet.setName_pos(medSrvRisDOs[0].getName_pos());//检查方位
		itemSets.add(itemSet);
		ris.setExtInfoList(itemSets);
		}		
	}
	
	/**
	 * 拼装检验套内项目信息
	 * @param ctx
	 * @param ortmpldo
	 * @param risList
	 * @param lis
	 * @throws BizException
	 */
	private void setEmsSetItmInfo(CiEnContextDTO ctx, MedSrvDO medSrvInfo,  EmsRisViewDTO lis)
			throws BizException{
		FArrayList itemSets = new FArrayList();
		MedSrvSetItemDO[] szMedSrvSetItem = this.GetItemInSet(medSrvInfo.getId_srv(), true);
		for (MedSrvSetItemDO setitem : szMedSrvSetItem) {
			MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(setitem.getId_srv_itm());
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
		
		lis.setExtInfoList(itemSets);;
	}
	
	/**
	 * 获取套内项目集合
	 * 
	 * @param id_srv
	 * @param is_clinical
	 * @return
	 * @throws BizException
	 */
	protected MedSrvSetItemDO[] GetItemInSet(String id_srv, boolean is_clinical) throws BizException {
		return ServiceFinder.find(IMedSrvSetItemDORService.class).find(String
				.format("a8.fg_clinical='%s' and a8.id_srv='%s' and a8.fg_active='Y'", is_clinical ? "Y" : "N", id_srv),
				"", FBoolean.FALSE);
	}



}
