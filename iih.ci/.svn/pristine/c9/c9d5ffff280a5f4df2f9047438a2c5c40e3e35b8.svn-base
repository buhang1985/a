package iih.ci.ord.s.ems.ip.ems.lis;

import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsLisViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsLisViewItemDTO;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.defsave.DefaultLisCreateOrderInfo;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSetSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.LisOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

/**
 * 检查医疗单保存逻辑
 * @author Young
 *
 */
public class EmsLisSaveBP extends BaseIpEmsSetSaveBP {

	public EmsLisSaveBP() {
		super();
		// 设置有效性检查
		setEmsValidate(new EmsLisValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultLisCreateOrderInfo());
	}

	public EmsLisSaveBP(IEmsValidate emsValidate) {
		super();
		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultLisCreateOrderInfo());
	}

	@Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		EmsSaveRstInfo emsSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		for (OrderPackageInfo opInfo : szOrderPackageInfo) {
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList())) {
				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				// 检验申请单保存
				if (objAppSheetInfo instanceof OrdApLabDO) {
					CiOrdAppUtils.getOrapplisService().save(opInfo.getOrderAppSheetList().toArray(new OrdApLabDO[]{}));
				}
			}
		}
		return emsSaveInfo;
	}


	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		// TODO 合并申请单信息
		OrderListViewDTO viewDTO = (OrderListViewDTO) uiModel;
		for (Object obj : appSheetList) {
			OrdApLabDO ordlis = (OrdApLabDO) obj;
			ordlis.setNo_applyform(viewDTO.getNo_applyform());//申请单号	
			ordlis.setDt_plan(viewDTO.getDt_effe());//计划检查日期
			ordlis.setFg_urgent(viewDTO.getFg_urgent());//加急标识
			ordlis.setId_samptp(viewDTO.getId_extend());//标本类型ID
			ordlis.setSd_samptp(viewDTO.getSd_extend());//标本类型编码
			ordlis.setName_samptp(viewDTO.getExtend());//标本类型	
			ordlis.setClinicalzztz(((EmsLisViewDTO) uiModel).getClinicalzztz());// 临床症状及体征
			ordlis.setStatus(viewDTO.getStatus());
			if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
				EmsLisViewDTO lisDTO = (EmsLisViewDTO) uiModel;
				ordlis.setId_di(lisDTO.getId_di());//临床诊断	
				ordlis.setId_diitm(lisDTO.getId_diitm());//临床诊断子项
				ordlis.setName_diag(lisDTO.getName_diitm());//诊断名称	
				ordlis.setId_sampcoltime(lisDTO.getId_sampcoltime()); //标本采集时间ID
				ordlis.setName_sampcoltime(lisDTO.getName_sampcoltime()); //标本采集时间
				ordlis.setId_sampcollecttimetp(lisDTO.getId_sampcollecttimetp()); //标本采集时间类型ID
				ordlis.setSd_sampcollecttimetp(lisDTO.getSd_sampcollecttimetp()); //标本采集时间类型编码
				ordlis.setLen_sampcoltime(lisDTO.getLen_sampcoltime()); //标本采集时长
				ordlis.setId_unit_sampcoltime(lisDTO.getId_unit_sampcoltime()); //标本采集时长单位
				ordlis.setId_samptp(lisDTO.getId_samptp());//标本类型ID
				ordlis.setSd_samptp(lisDTO.getSd_samptp());//标本类型编码
				ordlis.setName_samptp(lisDTO.getName_samptp());//标本类型	
			}
		}
	}

	@Override
	protected void mergeOrderSetInfo(CiEnContextDTO ctx, OrdSrvSetDO[] setSrvList, Object uiModel) 
			throws BizException {
		// TODO 合并套内项目信息
		if (!CiOrdUtils.isEmpty(setSrvList)) {
			OrderListViewDTO emsLisViewDTO = (OrderListViewDTO) uiModel;
			FArrayList opList = emsLisViewDTO.getExtInfoList();
			for (OrdSrvSetDO setSrvDo : setSrvList) {
				for (Object object : opList) {
					EmsLisViewItemDTO emsLisViewItemDTO = (EmsLisViewItemDTO) object;
					if(emsLisViewItemDTO.getId_srv().equals(setSrvDo.getId_srvset())){
					}
				}
			}
		}
	}

	/**
	 * 合并医嘱
	 * @param srvInfo
	 * @param ctx
	 * @return
	 * @throws BizException 
	 */
	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, OrderPackageInfo pInfo)throws BizException{
		super.mergeOrderInfo(ctx, pInfo);
		Object uiModel = pInfo.getOrderSrvMmList().get(0).getUiModel();
		CiOrderDO orderInfo = pInfo.getOrderInfo();
		if(uiModel instanceof EmsLisViewDTO){
			EmsLisViewDTO emsBtDto=(EmsLisViewDTO)uiModel;
			orderInfo.setDes_or(emsBtDto.getDes_or());
		}
	}
	
	
	
	@Override
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO srvInfo, Object uiModel)
			throws BizException {
		// TODO Auto-generated method stub
		super.afterMergeOrderSrvInfo(ctx, orderInfo, srvInfo, uiModel);
		
		// 住院医嘱检验检查都不计算服务总量
		srvInfo.setQuan_total_medu(null);
	}

	/**
	 * 将前端选择的临床套内项目转化为服务ID的映射表
	 * @param objInfo
	 * @return
	 */
	@Override
	protected SrvKey2UiModelMap assembleSrvSetItemKey2UiModelMap(Object objInfo){
		SrvKey2UiModelMap o = new SrvKey2UiModelMap();
		OrderListViewDTO ems = (OrderListViewDTO) objInfo;
		for (Object obsLapInfo : ems.getExtInfoList()) {
			EmsLisViewItemDTO itemdo = (EmsLisViewItemDTO) obsLapInfo;
			if (itemdo.getStatus() != DOStatus.DELETED) {
				o.put(itemdo.getId_srv(), obsLapInfo);
			}
		}
		return o;
	}

	/**
	 * 获取申请单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException {
		// 检验申请单保存
		OrdApLabDO[] szOrdApLabDO = CiOrdAppUtils.getOrapplisQryService().findByAttrValStrings(CiOrderDO.ID_OR, szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApLabDO)) {
			return szOrdApLabDO;
		}
		return null;
	}

	/**
	 * 医嘱内容拼接
	 * @param ctx
	 * @param uiModel
	 * @return
	 */
	@Override
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx,Object uiModel){
		OrderListViewDTO uiDto=(OrderListViewDTO)uiModel;
		LisOrContentParam param=new LisOrContentParam();
		param.setName_srv(uiDto.getName_srv());
		param.setPri(uiDto.getPri());
		param.setIsmuldose(uiDto.getIsmuldose());
		param.setIsmulexec(uiDto.getIsmulexec());
		param.setSd_srvtp(uiDto.getSd_srvtp());
		param.setQuan_med(uiDto.getQuan_med());
		param.setName_unit_med(uiDto.getName_unit_med());
		param.setName_freq(uiDto.getName_freq());
		param.setDays_or(uiDto.getDays_or());
		param.setFg_urgent(uiDto.getFg_urgent());
		param.setName_samptp(uiDto.getExtend());
		param.setSd_nodispense(uiDto.getSd_nodispense());
		return CiOrContentUtils.create(param);
	}
}
