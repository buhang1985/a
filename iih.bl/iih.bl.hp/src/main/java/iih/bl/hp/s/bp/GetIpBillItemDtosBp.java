package iih.bl.hp.s.bp;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.hp.hpblllitm.d.BlHpCgItmIpDo;
import iih.bl.hp.hpblllitm.i.IHpblllitmRService;
import iih.bl.hp.s.bp.qry.GetIpBillItmDtosQry;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 住院医保明细上传查询类
 * @author 未知...
 *         version ly 2019/01/17 添加上传模式处理,整理代码
 */
public class GetIpBillItemDtosBp {

	private String hpId = null;
	
	
	/** 
	 * 查找记账明细(住院收付款-明细上传所用)
	 * @param strIdEnt 就诊主键
	 * @return 记账明细集合
	 * @throws BizException
	 */
	public IpBillItmUploadHpDTO[] exec(String strIdEnt,String idStIp, FBoolean isUpload) throws BizException{
		if(StringUtil.isEmpty(strIdEnt))
			return null;
		
		//查询医保计划
		PatiVisitDO enDO = (PatiVisitDO)new DAFacade().findByPK(PatiVisitDO.class, strIdEnt, new String[]{PatiVisitDO.ID_HP});
		if(enDO == null || StringUtil.isEmpty(enDO.getId_hp()))
			return null;
		
		this.hpId = enDO.getId_hp();
		
		InsureContext insureContext = new InsureContext();
		insureContext.setIdHp(this.hpId);
		InsureFacade facade = new InsureFacade(insureContext);
		
		String uploadMode = facade.GetIpDetailUploadMode();
		
		IpBillItmUploadHpDTO[] billItmUploadHpDtoArr = (IpBillItmUploadHpDTO[]) AppFwUtil
				.getDORstWithDao(new GetIpBillItmDtosQry(strIdEnt, idStIp, isUpload, uploadMode), IpBillItmUploadHpDTO.class);
		
		if(isUpload.booleanValue()){
			billItmUploadHpDtoArr=processDataUploaded(billItmUploadHpDtoArr, strIdEnt);
		}
		else{
			billItmUploadHpDtoArr=processDataUploading(billItmUploadHpDtoArr, strIdEnt);
		}
		return billItmUploadHpDtoArr;
	}
	
	/** 
	 * 查找记账明细(住院收付款-明细上传所用)
	 * @param strIdEnt 就诊主键
	 * @return 记账明细集合
	 * @throws BizException
	 */
	public IpBillItmUploadHpDTO[] exec2(String strIdEnt,String idStIp,String[] idCgIps, FBoolean isUpload) throws BizException{
		if(StringUtil.isEmpty(strIdEnt))
			return null;
		
		//查询医保计划
		PatiVisitDO enDO = (PatiVisitDO)new DAFacade().findByPK(PatiVisitDO.class, strIdEnt, new String[]{PatiVisitDO.ID_HP});
		if(enDO == null || StringUtil.isEmpty(enDO.getId_hp()))
			return null;
		
		this.hpId = enDO.getId_hp();
		
		InsureContext insureContext = new InsureContext();
		insureContext.setIdHp(this.hpId);
		InsureFacade facade = new InsureFacade(insureContext);
		
		String uploadMode = facade.GetIpDetailUploadMode();
		
		IpBillItmUploadHpDTO[] billItmUploadHpDtoArr = (IpBillItmUploadHpDTO[]) AppFwUtil
				.getDORstWithDao(new GetIpBillItmDtosQry(strIdEnt,idStIp, idCgIps, isUpload, uploadMode), IpBillItmUploadHpDTO.class);
		
		if(isUpload.booleanValue()){
			billItmUploadHpDtoArr=processDataUploaded(billItmUploadHpDtoArr, strIdEnt);
		}
		else{
			billItmUploadHpDtoArr=processDataUploading(billItmUploadHpDtoArr, strIdEnt);
		}
		return billItmUploadHpDtoArr;
	}
	
	/** 
	 * 获取医嘱服务药品信息和对应的服务项目主键的映射Map
	 * @param strIdEnt
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private Map<String,OrdDrugInfo4BlDTO> getIdOrSrvVsMMInfoMap(String strIdEnt) throws BizException
	{
		//获取本次就诊下所有药品信息
		ICiOrdBlService ciOrdBlService=ServiceFinder.find(ICiOrdBlService.class);
		List<OrdDrugInfo4BlDTO> lst=java.util.Arrays.asList(ciOrdBlService.getOrdDrugInfo4BlDTOs(strIdEnt,null,null,FBoolean.FALSE));
		Map<String,OrdDrugInfo4BlDTO> map=new HashMap<String, OrdDrugInfo4BlDTO>();
		for(OrdDrugInfo4BlDTO item:lst){
			if(!map.containsKey(item.getId_orsrv()))
			{
				map.put(item.getId_orsrv(), item);
			}
		}
		return map;
	}
	
	private IpBillItmUploadHpDTO[] processDataUploading(IpBillItmUploadHpDTO[] data,String strIdEnt) throws BizException{
		//费用类别对照关系MAP
		Map<String,String> feecaMap = new HashMap<String, String>();
		
		//剂型对照关系MAP
		Map<String,String> docageMap = new HashMap<String, String>();
		Map<String,String> damap = new HashMap<>();
		IMiBdDirCompQryService miBdDirCompQryService=ServiceFinder.find(IMiBdDirCompQryService.class);
		
		HashSet<String> incSet = new HashSet<String>();
		HashSet<String> hisMedSrvIdsSet = new HashSet<String>();
		HashSet<String> hisDrugIdsSet = new HashSet<String>();
		for(IpBillItmUploadHpDTO billHpDto : data) {	
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
		
		for(IpBillItmUploadHpDTO billHpDto : data) {	
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
			
			//补全 医保的项目类型和费用类别信息
			/*if(billHpDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				if(limitPsdDoList.contains(billHpDto.getId_srv()))
					billHpDto.setFg_single(FBoolean.TRUE);	
				else
					billHpDto.setFg_single(FBoolean.FALSE);
			}
			if(billHpDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
				//如果是药品信息补全剂型、规格等属性
				//难道对应的开药信息
				OrdDrugInfo4BlDTO ordDrugInfo=map.get(billHpDto.getId_orsrv());
				if(ordDrugInfo!=null)
				{
					//剂型
					billHpDto.setId_dosage(ordDrugInfo.getId_dosage());
					//剂型单位
					billHpDto.setName_dosage(ordDrugInfo.getName_dosage());
					//医疗用量
					billHpDto.setQuan_medu(ordDrugInfo.getQuan_medu());
					//用量单位
					billHpDto.setMeduunit_name(ordDrugInfo.getName_medu());
					//频次主键
					billHpDto.setId_freq(ordDrugInfo.getId_freq());
					//频次名称
					billHpDto.setName_freq(ordDrugInfo.getName_freq());
					//用药天数
					billHpDto.setDays(ordDrugInfo.getDays_or());
					//用法
					billHpDto.setId_route(ordDrugInfo.getId_route());
					billHpDto.setName_route(ordDrugInfo.getName_route());
				}
			}*/
			//费用类别
			String codeCa = feecaMap.get(billHpDto.getCode_inccaitm());
			if(StringUtil.isEmpty(codeCa) && comoDto != null){
				codeCa = comoDto.getCode_ca();
			}
			billHpDto.setCode_ca(codeCa);
			
			if(!docageMap.isEmpty() && !damap.isEmpty()){				
				billHpDto.setName_dosage(damap.get(docageMap.get(billHpDto.getId_mm())));
			}
		}
		return data;
	}

	private IpBillItmUploadHpDTO[] processDataUploaded(IpBillItmUploadHpDTO[] data,String strIdEnt) throws BizException{
		
		//if(strIdHp != null && strIdHp.size() > 0 && data != null && data.length > 0) 
			/*String sqlFeeCa = " select id_hp,code,id_incca_ip from bd_hp_feeca where id_hp= '" + strIdHp.get(0) +"' ";
			List<HpFeecaDO> feeCaRelList = (List<HpFeecaDO>)new DAFacade().execQuery(sqlFeeCa, new BeanListHandler(HpFeecaDO.class));
			String sql = " select id_inccaitm,code from bd_incca_itm where id_incca = '@@@@AA1000000001SHRE' ";
			List<IncCaItmDO> inccaItmList  = (List<IncCaItmDO>)new DAFacade().execQuery(sql, new BeanListHandler(IncCaItmDO.class));
			
			for(IncCaItmDO itm : inccaItmList) {
				for(HpFeecaDO feecaDo : feeCaRelList) {
					if(feecaDo.getId_incca_ip() != null && feecaDo.getId_incca_ip().equals(itm.getId_inccaitm())) {
						feecaMap.put(itm.getCode(), feecaDo.getCode());
					}
				}
			}*/	

		HashSet<String> incSet = new HashSet<String>();
		HashSet<String> hisMedSrvIdsSet = new HashSet<String>();
		HashSet<String> hisDrugIdsSet = new HashSet<String>();
		List<String> idCgList = new ArrayList<String>();
		for(IpBillItmUploadHpDTO billHpDto : data) {	
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

		for(IpBillItmUploadHpDTO billHpDto : data) {	
			//费用类别
			//billHpDto.setCode_ca(feecaMap.get(billHpDto.getCode_inccaitm()));
			
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
			
			String codeCa = feecaMap.get(billHpDto.getCode_inccaitm());
			if(StringUtil.isEmpty(codeCa) && comoDto != null){
				codeCa = comoDto.getCode_ca();
			}
			billHpDto.setCode_ca(codeCa);
			
			//添加 自费原因
			BlHpCgItmIpDo hpCgDO = hpCgMap.get(billHpDto.getId_cgip());
			if(hpCgDO != null){
				billHpDto.setNote(hpCgDO.getDes());
			}
		}
		
		return data;
	}
}
