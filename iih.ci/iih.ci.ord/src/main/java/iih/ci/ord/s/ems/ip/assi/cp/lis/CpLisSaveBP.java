package iih.ci.ord.s.ems.ip.assi.cp.lis;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.dws.ip.ems.d.EmsLisViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsLisViewItemDTO;
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
 * 临床路径 - 检验保存逻辑
 * 
 *
 */
public class CpLisSaveBP extends BaseCpSaveBP {

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
				EmsLisViewDTO lis = new EmsLisViewDTO();
				setEmsViewInfo( ctx,  medSrvInfo, tpl.getDriverInfo(),
						lis,  code_or,  1,  ords[0]);
				document.add(lis);
				EmsSaveDTO save = super.getEmsSaveDTO(document, tpl.getDriverInfo());
				return new EmsLisSave4CP().save(ctx, new EmsSaveDTO[] {save});
			}				
		}
		return null;
	}
	
	
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, MedSrvDO medSrvInfo, EmsDriverInfo driverinfo,
			OrderListViewDTO orderListViewDTO, String code_or, int index, HpCpElemOrderDO eleord) throws BizException {
		// TODO Auto-generated method stub		
		super.setEmsViewInfo(ctx, medSrvInfo, driverinfo, orderListViewDTO, code_or, index,eleord);
		EmsLisViewDTO lis = (EmsLisViewDTO)orderListViewDTO;
		if(medSrvInfo.getFg_set().booleanValue()) {
			setEmsSetItmInfo( ctx,  medSrvInfo,   lis);
		}
		
//		MedSrvLisDO[] medSrvLisDOs = ServiceFinder.find(IMedSrvLisDORService.class).find(String.format("a1.id_srv='%s'", medSrvInfo.getId_srv()), "", FBoolean.FALSE);
		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(medSrvInfo.getId_srv());
		MedSrvLisDO[] medSrvLisDOs = medSrvAggInfo.getMedSrvLisDO();
		
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
		
	    lis.setNo_applyform(CiOrdUtils.getApplyNo(medSrvInfo.getSd_srvtp()));//申请单号
	    
	    //获取临床症状及体征
	    String clinicalzztz = CiOrdUtils.DiseaseDescription(ctx.getId_en());
	    //获取诊断信息
  		String[] diagArray = qryService.getDiagArray(ctx.getId_en());
  		String str_name_di = "";
  		if (diagArray != null && diagArray.length > 0) {
  			lis.setId_di(diagArray[7]);//主诊断的主项目id
  			lis.setId_diitm(diagArray[3]);//主诊断id
  			lis.setName_diitm(diagArray[4]);//主诊断名称
  			str_name_di = diagArray[0];//诊断名称拼接
  			//diagArray[1];//诊断编码拼接
  			//diagArray[2];//诊断子项目id拼接
  			//diagArray[5];//诊断id
  		}
  		//将诊断也拼接到临床病症及体征中
  		if (StringUtils.isNotEmpty(str_name_di)) {
  			if (StringUtils.isEmpty(clinicalzztz)) {
  				clinicalzztz = "诊断：" + str_name_di.replace("&", "；");
  			} else {
  				clinicalzztz += "\r\n" + "诊断：" + str_name_di.replace("&", "；");
  			}
  		} 
  		lis.setClinicalzztz(clinicalzztz);//临床症状体征
		// 计算物资流向科室
		this.setOrWfDeptInfo(ctx, medSrvInfo, lis);
		orderListViewDTO.setQuan_med((CiOrdUtils.isTrue(medSrvInfo.getIsmuldose()) ? eleord.getDosage() : new FDouble(1)));// 剂量
		orderListViewDTO.setDays_or(1);
	}
	
	/**
	 * 拼装检验套内项目信息
	 * @param ctx
	 * @param ortmpldo
	 * @param risList
	 * @param lis
	 * @throws BizException
	 */
	private void setEmsSetItmInfo(CiEnContextDTO ctx, MedSrvDO medSrvInfo,  EmsLisViewDTO lis)
			throws BizException{
		FArrayList itemSets = new FArrayList();
		MedSrvSetItemDO[] szMedSrvSetItem = this.GetItemInSet(medSrvInfo.getId_srv(), true);
		for (MedSrvSetItemDO setitem : szMedSrvSetItem) {
			MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(setitem.getId_srv_itm());
			MedSrvLisDO[] medSrvLisDOs = medSrvAggInfo.getMedSrvLisDO();
			if (medSrvLisDOs == null || medSrvLisDOs.length <= 0)
				continue;
			
				EmsLisViewItemDTO itemSet = new EmsLisViewItemDTO();
				itemSet.setFg_edit(FBoolean.TRUE);//套内项可编辑标识
				itemSet.setFg_check(FBoolean.TRUE);//临床项目可选标志
				itemSet.setId_srv(medSrvAggInfo.getParentDO().getId_srv());//套内项服务ID
				itemSet.setName_srv(medSrvAggInfo.getParentDO().getName());//套内项服务
				itemSet.setId_primd(medSrvAggInfo.getParentDO().getId_primd());//套内项定价模式				
				itemSets.append(itemSet);
			
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
