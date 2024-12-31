package iih.bl.hp.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.hp.hpblllitm.d.BlHpCgItmIpDo;
import iih.bl.hp.hpblllitm.i.IHpblllitmRService;
import iih.bl.hp.s.bp.qry.GetIpBillItmDtosQryPag;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.external.provide.meta.bl.OrdDrugInfo4BlDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.bd.d.DosageCompInfoDTO;
import iih.mi.bd.d.FeeCaCompInfoDTO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mi.bd.i.IMiBdDirCompQryService;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 住院医保明细上传查询类(分页查询) Title: GetIpBillItemDtosPagBp.java
 * 
 * @author zhang.hw
 * @date 2019年4月29日
 * @version 1.0
 */
public class GetIpBillItemDtosPagBp {
	private String hpId = null;

	/**
	 * 查找记账明细(住院收付款-明细上传所用)(分页查询)
	 * @author zhang.hw
	 * @date 2019年4月29日
	 * @param qryRootNodeDto
	 * @param strIdEnt
	 * @param ipStId
	 * @param isUpload
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<IpBillItmUploadHpDTO> exec(QryRootNodeDTO qryRootNodeDto, String strIdEnt, String ipStId,
			FBoolean isUpload, PaginationInfo pg) throws BizException {
		if(StringUtil.isEmpty(strIdEnt))
			return new PagingRtnData<IpBillItmUploadHpDTO>();
		
		//查询医保计划
		PatiVisitDO enDO = (PatiVisitDO)new DAFacade().findByPK(PatiVisitDO.class, strIdEnt, new String[]{PatiVisitDO.ID_HP});
		if(enDO == null || StringUtil.isEmpty(enDO.getId_hp()))
			throw new BizException("查询医保计划为空！请联系工程师");
		
		this.hpId = enDO.getId_hp();
		
		InsureContext insureContext = new InsureContext();
		insureContext.setIdHp(this.hpId);
		InsureFacade facade = new InsureFacade(insureContext);
		
		String uploadMode = facade.GetIpDetailUploadMode();
		//获取查询条件
		String wherePart = GetWherePart(qryRootNodeDto);
		GetIpBillItmDtosQryPag sql = new GetIpBillItmDtosQryPag(strIdEnt, ipStId, isUpload, uploadMode, wherePart);
		PagingServiceImpl<IpBillItmUploadHpDTO> pagingServiceImpl = new PagingServiceImpl<IpBillItmUploadHpDTO>();
		PagingRtnData<IpBillItmUploadHpDTO> pageData = pagingServiceImpl.findByPageInfo(new IpBillItmUploadHpDTO(), pg, sql.getQrySQLStr(), "", sql.getQryParameter(null));
		if(isUpload.booleanValue()){
			pageData=processDataUploaded(pageData, strIdEnt);
		}
		else{
			pageData=processDataUploading(pageData, strIdEnt);
		}
		return pageData;
	}
	
	/**
	 * 不带查询方案的分页
	 * @param strIdEnt
	 * @param ipStId
	 * @param isUpload
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<IpBillItmUploadHpDTO> exec2( String strIdEnt, String ipStId,
			FBoolean isUpload, PaginationInfo pg) throws BizException {
		if(StringUtil.isEmpty(strIdEnt))
			return new PagingRtnData<IpBillItmUploadHpDTO>();
		
		//查询医保计划
		PatiVisitDO enDO = (PatiVisitDO)new DAFacade().findByPK(PatiVisitDO.class, strIdEnt, new String[]{PatiVisitDO.ID_HP});
		if(enDO == null || StringUtil.isEmpty(enDO.getId_hp()))
			throw new BizException("查询医保计划为空！请联系工程师");
		
		this.hpId = enDO.getId_hp();
		
		InsureContext insureContext = new InsureContext();
		insureContext.setIdHp(this.hpId);
		InsureFacade facade = new InsureFacade(insureContext);
		
		String uploadMode = facade.GetIpDetailUploadMode();
	
		GetIpBillItmDtosQryPag sql = new GetIpBillItmDtosQryPag(strIdEnt, ipStId, isUpload, uploadMode, null);
		PagingServiceImpl<IpBillItmUploadHpDTO> pagingServiceImpl = new PagingServiceImpl<IpBillItmUploadHpDTO>();
		PagingRtnData<IpBillItmUploadHpDTO> pageData = pagingServiceImpl.findByPageInfo(new IpBillItmUploadHpDTO(), pg, sql.getQrySQLStr(), "", sql.getQryParameter(null));
		if(isUpload.booleanValue()){
			pageData=processDataUploaded(pageData, strIdEnt);
		}
		else{
			pageData=processDataUploading(pageData, strIdEnt);
		}
		return pageData;
	}
	
	/**
	 * 获取查询条件
	 * @author zhang.hw
	 * @date 2019年4月29日
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDto);
		if (!StringUtils.isEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}
	
	/**
	 * 待上传数据
	 * @author zhang.hw
	 * @date 2019年4月29日
	 * @param data
	 * @param strIdEnt
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<IpBillItmUploadHpDTO> processDataUploading(PagingRtnData<IpBillItmUploadHpDTO> data,String strIdEnt) throws BizException{
		//费用类别对照关系MAP
		Map<String,String> feecaMap = new HashMap<String, String>();
		
		//剂型对照关系MAP
		Map<String,String> docageMap = new HashMap<String, String>();
		Map<String,String> damap = new HashMap<>();
		IMiBdDirCompQryService miBdDirCompQryService=ServiceFinder.find(IMiBdDirCompQryService.class);
		
		HashSet<String> incSet = new HashSet<String>();
		HashSet<String> hisMedSrvIdsSet = new HashSet<String>();
		HashSet<String> hisDrugIdsSet = new HashSet<String>();
		
		Iterator<IpBillItmUploadHpDTO> iterator = data.getPageData().iterator();
		while (iterator.hasNext()) {
			IpBillItmUploadHpDTO billHpDto = iterator.next();
			incSet.add(billHpDto.getCode_inccaitm());
			hisMedSrvIdsSet.add(billHpDto.getId_srv());
			if(!StringUtil.isEmpty(billHpDto.getId_mm())){
				hisDrugIdsSet.add(billHpDto.getId_mm());
			}
		}
		FeeCaCompInfoDTO[] feeCaCompInfoDtos =  miBdDirCompQryService.findFeeCaCompInfo(this.hpId, IBdPpCodeTypeConst.ID_INHOS_INVOICE, incSet.toArray(new String[0]));
		
		for(FeeCaCompInfoDTO itm : feeCaCompInfoDtos) {
			feecaMap.put(itm.getCode_inccaitm(), itm.getCode());
		}
		
		//剂型对照
		ICiOrdBlService ciOrdBlService = ServiceFinder.find(ICiOrdBlService.class);
		OrdDrugInfo4BlDTO[] dtos = ciOrdBlService.getOrdDrugInfo4BlDTOs(strIdEnt, null, null, null);
		
		if(dtos != null && dtos.length > 0){
			damap.put(null, "999");
			for(OrdDrugInfo4BlDTO dto : dtos){
				damap.put(dto.getSd_dosage(), "999");//默认值
				docageMap.put(dto.getId_mm(), dto.getSd_dosage());
			}
			
			String[] daItms = new String[docageMap.size()];
			daItms = docageMap.values().toArray(daItms);				
			if(daItms.length > 0){
				DosageCompInfoDTO[] dosageCompInfoDTOs =  miBdDirCompQryService.findDosageCompInfo(this.hpId,  daItms);				
				for(DosageCompInfoDTO itm : dosageCompInfoDTOs) {
					damap.put(itm.getSd_dosage_his(), itm.getCode_dosage_hp());
				}
			}
		}
		//三大目录对照
		Map<String,ThreeDirCompInfoDTO> threeDirsMap = new HashMap<>();
		ThreeDirCompInfoDTO[] threeDirs = miBdDirCompQryService.findThreeDirCompByHisSrvIdsAndDrugIds(this.hpId,
						hisMedSrvIdsSet.toArray(new String[0]), hisDrugIdsSet.toArray(new String[0]));
		if(!ArrayUtil.isEmpty(threeDirs)){
			for(ThreeDirCompInfoDTO dto: threeDirs){
				if(!StringUtil.isEmpty(dto.getId_drug())){
					threeDirsMap.put(dto.getId_drug(), dto);
				}else{
					threeDirsMap.put(dto.getId_srv(), dto);
				}
			}
		}
		
		boolean fgMcUseSrv = BlParamValueConst.BLHP000024_SRV.equals(BlParams.BLHP000024());//耗材使用诊疗对照

		iterator = data.getPageData().iterator();
		while(iterator.hasNext()){
			IpBillItmUploadHpDTO billHpDto = iterator.next();
			//三大目录
			billHpDto.setHp_srvcode("9999");
			
			ThreeDirCompInfoDTO comoDto = null;
			if(!StringUtil.isEmpty(billHpDto.getId_mm())){
				if(billHpDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI) && fgMcUseSrv){
					comoDto = threeDirsMap.get(billHpDto.getId_srv());
					billHpDto.setFg_mm(FBoolean.FALSE);
				}else{
					comoDto = threeDirsMap.get(billHpDto.getId_mm());
				}
			}else{
				comoDto = threeDirsMap.get(billHpDto.getId_srv());
			}
			
			if(comoDto != null){
				//医保项目编码
				billHpDto.setHp_srvcode(comoDto.getCode());
				//医保费用类别
				billHpDto.setEu_hpsrvtp(comoDto.getEu_hpsrvtp().toString());
				//医保项目名称
				billHpDto.setHp_srvname(comoDto.getName());
			}
			
			
			//费用类别
			if(!feecaMap.isEmpty()) {
				billHpDto.setCode_ca(feecaMap.get(billHpDto.getCode_inccaitm()));
			}
			if(!docageMap.isEmpty() && !damap.isEmpty()){				
				billHpDto.setName_dosage(damap.get(docageMap.get(billHpDto.getId_mm())));
			}
		}
		return data;
	}
	
	/**
	 * 已上传数据
	 * @author zhang.hw
	 * @date 2019年4月29日
	 * @param data
	 * @param strIdEnt
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<IpBillItmUploadHpDTO> processDataUploaded(PagingRtnData<IpBillItmUploadHpDTO> data,String strIdEnt) throws BizException{
		HashSet<String> incSet = new HashSet<String>();
		HashSet<String> hisMedSrvIdsSet = new HashSet<String>();
		HashSet<String> hisDrugIdsSet = new HashSet<String>();
		List<String> idCgList = new ArrayList<String>();
		
		Iterator<IpBillItmUploadHpDTO> iterator = data.getPageData().iterator();
		while(iterator.hasNext()){
			IpBillItmUploadHpDTO billHpDto = iterator.next();
			incSet.add(billHpDto.getCode_inccaitm());
			hisMedSrvIdsSet.add(billHpDto.getId_srv());
			if(!StringUtil.isEmpty(billHpDto.getId_mm())){
				hisDrugIdsSet.add(billHpDto.getId_mm());
			}
			idCgList.add(billHpDto.getId_cgip());
		}
		
		IMiBdDirCompQryService miBdDirCompQryService=ServiceFinder.find(IMiBdDirCompQryService.class);
		FeeCaCompInfoDTO[] feeCaCompInfoDtos =  miBdDirCompQryService.findFeeCaCompInfo(this.hpId, IBdPpCodeTypeConst.ID_INHOS_INVOICE, incSet.toArray(new String[0]));
		
		Map<String,String> feecaMap = new HashMap<String,String>();
		for(FeeCaCompInfoDTO itm : feeCaCompInfoDtos) {
			feecaMap.put(itm.getCode_inccaitm(), itm.getCode());
		}
		
		Map<String, BlHpCgItmIpDo> hpCgMap = new HashMap<String, BlHpCgItmIpDo>();
		IHpblllitmRService iHpblllitmRService = ServiceFinder.find(IHpblllitmRService.class);
		BlHpCgItmIpDo[] blHpCgItmIpDos = iHpblllitmRService.findByAttrValStrings(BlHpCgItmIpDo.ID_CGIP,idCgList.toArray(new String[0]));
		if(!ArrayUtil.isEmpty(blHpCgItmIpDos)){
			for (BlHpCgItmIpDo hpCgDO : blHpCgItmIpDos) {
				hpCgMap.put(hpCgDO.getId_cgip(), hpCgDO);
			}
		}
		
		//三大目录对照
		Map<String,ThreeDirCompInfoDTO> threeDirsMap = new HashMap<>();
		ThreeDirCompInfoDTO[] threeDirs = miBdDirCompQryService.findThreeDirCompByHisSrvIdsAndDrugIds(this.hpId,
						hisMedSrvIdsSet.toArray(new String[0]), hisDrugIdsSet.toArray(new String[0]));
		if(!ArrayUtil.isEmpty(threeDirs)){
			for(ThreeDirCompInfoDTO dto: threeDirs){
				if(!StringUtil.isEmpty(dto.getId_drug())){
					threeDirsMap.put(dto.getId_drug(), dto);
				}else{
					threeDirsMap.put(dto.getId_srv(), dto);
				}
			}
		}
		
		boolean fgMcUseSrv = BlParamValueConst.BLHP000024_SRV.equals(BlParams.BLHP000024());//耗材使用诊疗对照

		iterator = data.getPageData().iterator();
		while(iterator.hasNext()){
			IpBillItmUploadHpDTO billHpDto = iterator.next();
			//费用类别
			billHpDto.setCode_ca(feecaMap.get(billHpDto.getCode_inccaitm()));
			
			ThreeDirCompInfoDTO comoDto = null;
			if(!StringUtil.isEmpty(billHpDto.getId_mm())){
				if(billHpDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI) && fgMcUseSrv){
					comoDto = threeDirsMap.get(billHpDto.getId_srv());
					billHpDto.setFg_mm(FBoolean.FALSE);
				}else{
					comoDto = threeDirsMap.get(billHpDto.getId_mm());
				}
			}else{
				comoDto = threeDirsMap.get(billHpDto.getId_srv());
			}
			
			if(comoDto != null){
				//医保项目编码
				billHpDto.setHp_srvcode(comoDto.getCode());
				//医保项目名称
				billHpDto.setHp_srvname(comoDto.getName());
			}
			
			//添加 自费原因
			BlHpCgItmIpDo hpCgDO = hpCgMap.get(billHpDto.getId_cgip());
			if(hpCgDO != null){
				billHpDto.setNote(hpCgDO.getDes());
			}
		}
		
		return data;
	}

}
