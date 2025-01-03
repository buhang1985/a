package iih.bl.hp.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.hp.hpblllitm.d.BlHpCgItmIpDo;
import iih.bl.hp.hpblllitm.i.IHpblllitmCudService;
import iih.bl.hp.hpblllitm.i.IHpblllitmRService;
import iih.bl.hp.s.bp.qry.GetIpBillItmDtosUnEntQry;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.external.provide.meta.bl.OrdDrugInfo4BlDTO;
import iih.mi.bd.d.DosageCompInfoDTO;
import iih.mi.bd.d.FeeCaCompInfoDTO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mi.bd.i.IMiBdDirCompQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetIpBillItemDtosUnEntBP {

	/** 
	 * 查找记账明细(住院收付款-明细上传所用)
	 * @param strIdEnt 就诊主键
	 * @return 记账明细集合
	 * @throws BizException
	 */
	public IpBillItmUploadHpDTO[] exec(String condition,String orderBy,FBoolean isUpload) throws BizException
	{
		IpBillItmUploadHpDTO[] billItmUploadHpDtoArr=(IpBillItmUploadHpDTO[])AppFwUtil.getDORstWithDao(new GetIpBillItmDtosUnEntQry(condition,orderBy, isUpload,"2"),IpBillItmUploadHpDTO.class);
		if(billItmUploadHpDtoArr != null && billItmUploadHpDtoArr.length > 0){
			if(isUpload.booleanValue())
			{
				billItmUploadHpDtoArr=processDataUploaded(billItmUploadHpDtoArr);
			}
			else{
				billItmUploadHpDtoArr=processDataUploading(billItmUploadHpDtoArr);
				saveHpCgItmIpDoBeforUpload(billItmUploadHpDtoArr);
			}
		}		
		return billItmUploadHpDtoArr;
	}
	
	/**
	 * 上传医保之前先保存医保交易明细
	 * @param list
	 * @throws BizException
	 */
	void saveHpCgItmIpDoBeforUpload(IpBillItmUploadHpDTO[] list) throws BizException
	{
		Map<String, BlHpCgItmIpDo> map = setBlHpCgItmIpDoMap(list);
		IHpblllitmCudService iCudService = ServiceFinder.find(IHpblllitmCudService.class);
		List<BlHpCgItmIpDo> saveList = new ArrayList<BlHpCgItmIpDo>();
		for (IpBillItmUploadHpDTO bill : list) {
			BlHpCgItmIpDo hpCgItmIpDo = map.get(bill.getId_cgip());				
			//如果不存在插入
			if (hpCgItmIpDo ==null) {
				BlHpCgItmIpDo newHpCgIpDo = new BlHpCgItmIpDo();
				newHpCgIpDo.setId_ent(bill.getId_ent());
				newHpCgIpDo.setId_cgip(bill.getId_cgip());
				newHpCgIpDo.setAmt(bill.getAmt_ratio());
				newHpCgIpDo.setAmt_payzl(bill.getAmt_pat());
				newHpCgIpDo.setAmt_payzf(bill.getAmt_payzf());
				newHpCgIpDo.setAmt_cxj_payzf(bill.getAmt_cxj_payzf());
				newHpCgIpDo.setAmt_czl_payzf(bill.getAmt_czl_payzf());
				newHpCgIpDo.setCode_ca(bill.getCode_ca());
				newHpCgIpDo.setSd_hpsrvtp(bill.getName_chargegrade());
				newHpCgIpDo.setFg_selfpay(bill.getFg_selfpay());
				newHpCgIpDo.setRate_payzl(bill.getRate_payzl());
				newHpCgIpDo.setLimited_pri(bill.getLimited_pri());
				newHpCgIpDo.setHp_srvcode(bill.getHp_srvcode());
				newHpCgIpDo.setId_hpblllitm(null);
				newHpCgIpDo.setDes(bill.getNote());
				newHpCgIpDo.setStatus(DOStatus.NEW);
				saveList.add(newHpCgIpDo);
			}
		}
		if(saveList.size() > 0)
		iCudService.save(saveList.toArray(new BlHpCgItmIpDo[0]));
	}
	
	/**
	 * 住院上传医保交易明细放在map中
	 * @param strIdEnt
	 * @return
	 * @throws BizException
	 */
	Map<String ,BlHpCgItmIpDo>setBlHpCgItmIpDoMap(IpBillItmUploadHpDTO[] list) throws BizException{
		Map<String, BlHpCgItmIpDo> map=new HashMap<>();
		String [] Id_cgips = new String[list.length];
		int i = 0;
		for(IpBillItmUploadHpDTO bill : list){
			Id_cgips[i] = bill.getId_cgip();
			i++;
		}
		IHpblllitmRService rService = ServiceFinder.find(IHpblllitmRService.class);
		BlHpCgItmIpDo[] blHpCgItmIpDos = rService.findByAttrValStrings(BlHpCgItmIpDo.ID_CGIP, Id_cgips);
		if(blHpCgItmIpDos != null && blHpCgItmIpDos.length > 0){
			for (BlHpCgItmIpDo blHpCgItmIpDo : blHpCgItmIpDos) {
				map.put(blHpCgItmIpDo.getId_cgip(), blHpCgItmIpDo);
			}			
		}
		return map; 
	}
	
	IpBillItmUploadHpDTO[] processDataUploading(IpBillItmUploadHpDTO[] data) throws BizException
	{
		
		//费用类别对照关系MAP
		Map<String,String> feecaMap = new HashMap<String, String>();
		
		//剂型对照关系MAP
		Map<String,String> docageMap = new HashMap<String, String>();
		Map<String,String> damap = new HashMap<>();
		IMiBdDirCompQryService miBdDirCompQryService=ServiceFinder.find(IMiBdDirCompQryService.class);
				
		HashSet<String> incSet = new HashSet<String>();
		HashSet<String> hisMedSrvIdsSet = new HashSet<String>();
		HashSet<String> hisDrugIdsSet = new HashSet<String>();
		HashSet<String> idHps = new HashSet<>();
		HashSet<String> idOrSrvs = new HashSet<>();
		for(IpBillItmUploadHpDTO billHpDto : data) {
			incSet.add(billHpDto.getCode_inccaitm());
			hisMedSrvIdsSet.add(billHpDto.getId_srv());
			if(!StringUtil.isEmpty(billHpDto.getId_mm())){
				hisDrugIdsSet.add(billHpDto.getId_mm());
			}
			if(!StringUtil.isEmpty(billHpDto.getId_hp())){
				idHps.add(billHpDto.getId_hp());
			}
			if(!StringUtil.isEmpty(billHpDto.getId_orsrv())){
				idOrSrvs.add(billHpDto.getId_orsrv());
			}
			
		}
		for(String idHp : idHps){
			FeeCaCompInfoDTO[] feeCaCompInfoDtos =  miBdDirCompQryService.findFeeCaCompInfo(idHp, IBdPpCodeTypeConst.ID_INHOS_INVOICE, incSet.toArray(new String[0]));
			for(FeeCaCompInfoDTO itm : feeCaCompInfoDtos) {
				feecaMap.put(itm.getCode_inccaitm(), itm.getCode());
			}			
		}		
		//剂型对照
		ICiOrdBlService ciOrdBlService = ServiceFinder.find(ICiOrdBlService.class);
		OrdDrugInfo4BlDTO[] dtos = ciOrdBlService.getOrdDrugInfo4BlDTOs(data[0].getId_ent(), null, idOrSrvs.toArray(new String[idOrSrvs.size()]), FBoolean.FALSE,null);
		//OrdDrugInfo4BlDTO[] dtos = ciOrdBlService.getOrdDrugInfo4BlDTOs(data[0].getId_ent(), null, null, FBoolean.FALSE,null);
		if(dtos != null && dtos.length > 0){
			damap.put(null, "999");
			for(OrdDrugInfo4BlDTO dto : dtos){
				damap.put(dto.getSd_dosage(), "999");//默认值
				docageMap.put(dto.getId_mm(), dto.getSd_dosage());
			}
			
			String[] daItms = new String[docageMap.size()];
			daItms = docageMap.values().toArray(daItms);				
			if(daItms.length > 0){
				for(String idHp : idHps){
					DosageCompInfoDTO[] dosageCompInfoDTOs =  miBdDirCompQryService.findDosageCompInfo(idHp,  daItms);				
					for(DosageCompInfoDTO itm : dosageCompInfoDTOs) {
						damap.put(itm.getSd_dosage_his(), itm.getCode_dosage_hp());
					}
				}				
			}
		}
		//三大目录对照
		Map<String,ThreeDirCompInfoDTO> threeDirsMap = new HashMap<>();
		for(String idHp : idHps){
			ThreeDirCompInfoDTO[] threeDirs = miBdDirCompQryService.findThreeDirCompByHisSrvIdsAndDrugIds(idHp,
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
		}
		
		
		for(IpBillItmUploadHpDTO billHpDto : data) {	
			//三大目录
			billHpDto.setHp_srvcode("9999");
			
			ThreeDirCompInfoDTO comoDto = null;
			if(!StringUtil.isEmpty(billHpDto.getId_mm())){
				comoDto = threeDirsMap.get(billHpDto.getId_mm());
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

	IpBillItmUploadHpDTO[] processDataUploaded(IpBillItmUploadHpDTO[] data) throws BizException
	{
		//查询就诊对应的医保计划，再查费用类别		
		HashSet<String> incSet = new HashSet<String>();
		HashSet<String> hisMedSrvIdsSet = new HashSet<String>();
		HashSet<String> hisDrugIdsSet = new HashSet<String>();
		
		ArrayList<String> idHps = new ArrayList<>();
		List<String> idCgList = new ArrayList<String>();
		for(IpBillItmUploadHpDTO billHpDto : data) {	
			incSet.add(billHpDto.getCode_inccaitm());
			hisMedSrvIdsSet.add(billHpDto.getId_srv());
			if(!StringUtil.isEmpty(billHpDto.getId_mm())){
				hisDrugIdsSet.add(billHpDto.getId_mm());
			}
			idCgList.add(billHpDto.getId_cgip());
			if(!StringUtil.isEmpty(billHpDto.getId_hp()) && idHps.contains(billHpDto.getId_hp())){
				idHps.add(billHpDto.getId_hp());
			}
		}
		
		IMiBdDirCompQryService miBdDirCompQryService=ServiceFinder.find(IMiBdDirCompQryService.class);
		Map<String,String> feecaMap = new HashMap<String,String>();
		for(String idHp : idHps){
			FeeCaCompInfoDTO[] feeCaCompInfoDtos =  miBdDirCompQryService.findFeeCaCompInfo(idHp, IBdPpCodeTypeConst.ID_INHOS_INVOICE, incSet.toArray(new String[0]));
			for(FeeCaCompInfoDTO itm : feeCaCompInfoDtos) {
				feecaMap.put(itm.getCode_inccaitm(), itm.getCode());
			}			
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
		for(String idHp : idHps){
			ThreeDirCompInfoDTO[] threeDirs = miBdDirCompQryService.findThreeDirCompByHisSrvIdsAndDrugIds(idHp,
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
		}
			
		for(IpBillItmUploadHpDTO billHpDto : data) {	
			//费用类别
			billHpDto.setCode_ca(feecaMap.get(billHpDto.getCode_inccaitm()));
			
			ThreeDirCompInfoDTO comoDto = null;
			if(!StringUtil.isEmpty(billHpDto.getId_mm())){
				comoDto = threeDirsMap.get(billHpDto.getId_mm());
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
