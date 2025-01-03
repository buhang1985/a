package iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp;

import iih.bd.base.utils.FBooleanUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.external.provide.meta.bl.OrdDrugInfo4BlDTO;
import iih.mi.constant.IMiMcCheckConst;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcCiOrdMmDTO;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependOutParamDTO;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeMsgUtilBP;
import iih.mi.mc.s.util.MiBaseInfoUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 超量开药依赖检查
 * @author LIM
 *
 */
public class MiCheckExcessDiDependBP {
	private static final String KEY_DI_DIFFICALT_TO_MOVE = "行动不便";
	private static final String KEY_DIDEF_TYPE_CHRONIC = "fg_ExistChronicDi";
	private static final String KEY_DIDEF_TYPE_MOVE= "fg_ExistMoveDiffDi";
	/**
	 * 超量开药依赖检查
	 * @param id_ent
	 * @param diIds
	 *            删除诊断
	 * @param idDisSur
	 *            剩余诊断
	 * @return
	 * @throws BizException
	 */
	public List<MiMcDiDependOutParamDTO> exec(String id_ent,String id_hp, String[] diIds, String[] idDisSur) throws BizException {
		List<MiMcDiDependOutParamDTO> diDependDTOList = new ArrayList<MiMcDiDependOutParamDTO>();
		// 1.获取医嘱所有信息
		ICiOrdBlService cisrv= ServiceFinder.find(ICiOrdBlService.class);
		OrdDrugInfo4BlDTO[] ordDrugInfo4BlDTOArr=cisrv.getOrdDrugInfo4BlOnNewMedical(id_ent,null,null);
		List<MiMcCiOrdMmDTO> miMcCiOrdMmDTOList=this.convertMiMcCiOrdMmDTO(ordDrugInfo4BlDTOArr);
		// 如果医嘱下没有物品，则不再判断
		if (miMcCiOrdMmDTOList.size() <= 0) {
			return diDependDTOList;
		}
		// 3.查询本次删除后剩余诊断明细
		// 判断是否删除所有诊断
		if (idDisSur.length <= 0) {
			if (!ArrayUtil.isEmpty(ordDrugInfo4BlDTOArr)) {// 医嘱不为空
				// 如果剩余医嘱不为空，则提示不能删除
				MiMcDiDependOutParamDTO outParamDTO = new MiMcDiDependOutParamDTO();
				SetDiDependDTOBP setDiDependDTOBP = new SetDiDependDTOBP();
				outParamDTO = setDiDependDTOBP.exec(null, null, IMiMcCheckConst.ERROR_DEPEND);
				if (outParamDTO != null) {
					diDependDTOList.add(outParamDTO);
				}
			} 
			return diDependDTOList;
		} 
		// 4.调用校验
		diDependDTOList = CheckOpBillDaysRule(id_ent,id_hp, diIds,idDisSur, miMcCiOrdMmDTOList);

		return diDependDTOList;
	}
	
	/**
	 * 将ci返回的dto转换为本域dto
	 * @param ordDrugInfo4BlDTOArr
	 * @return
	 */
	private  List<MiMcCiOrdMmDTO> convertMiMcCiOrdMmDTO(OrdDrugInfo4BlDTO[] ordDrugInfo4BlDTOArr){
		List<MiMcCiOrdMmDTO> miMcCiOrdMmDTOList= new ArrayList<MiMcCiOrdMmDTO>();
		for(OrdDrugInfo4BlDTO dto :ordDrugInfo4BlDTOArr){
			MiMcCiOrdMmDTO miMcCiOrdMmDTO= new MiMcCiOrdMmDTO();
			miMcCiOrdMmDTO.setId_or(dto.getId_or());
			miMcCiOrdMmDTO.setCode_or(dto.getCode_or());
			miMcCiOrdMmDTO.setName_or(dto.getName_or());
			miMcCiOrdMmDTO.setId_orsrv(dto.getId_orsrv());
			miMcCiOrdMmDTO.setId_srv(dto.getId_srv());
			miMcCiOrdMmDTO.setCode_srv(dto.getCode_srv());
			miMcCiOrdMmDTO.setName_srv(dto.getName());
			miMcCiOrdMmDTO.setId_mm(dto.getId_mm());
			miMcCiOrdMmDTO.setCode_mm(dto.getCode_mm());
			miMcCiOrdMmDTO.setName_mm(dto.getName_mm());
			miMcCiOrdMmDTO.setSd_srvtp(dto.getSd_srvtp());
			miMcCiOrdMmDTO.setDays_or(dto.getDays_or());
			miMcCiOrdMmDTO.setId_dsdef(dto.getId_dsdef());
			miMcCiOrdMmDTOList.add(miMcCiOrdMmDTO);
		}
		return miMcCiOrdMmDTOList;
	}
	/**
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param cidiagItemList
	 *            剩余诊断
	 * @param cidiagItemDelList
	 *            删除诊断
	 * @param orderMap
	 *            医嘱
	 * @param orsrvMap
	 *            服务
	 * @param ormmMap
	 *            物品
	 * @return
	 * @throws BizException
	 */
	private List<MiMcDiDependOutParamDTO> CheckOpBillDaysRule(String id_ent,String id_hp,String[] diIds, String[] idDisSur, List<MiMcCiOrdMmDTO> miMcCiOrdMmDTOList) throws BizException {
		List<MiMcDiDependOutParamDTO> list = new ArrayList<MiMcDiDependOutParamDTO>();
		List<MiMcCiOrdMmDTO> ordMMlist= new ArrayList<MiMcCiOrdMmDTO>();
		//1.通过参数，获取校验天数的限制值
		int orderMode= MiParamUtil.MHIR0001();//0：采用病种模式；1:诊断模式
		if(orderMode==0){
			for(MiMcCiOrdMmDTO dto :miMcCiOrdMmDTOList){
				if(StringUtil.isEmpty(dto.getId_dsdef())){
					ordMMlist.add(dto);
				}
			}
			if(ListUtil.isEmpty(ordMMlist))
				return list;
		}else{
			ordMMlist=miMcCiOrdMmDTOList;
		}
		int haveDays_mxb = MiParamUtil.MI3003(id_hp);// 慢病开单天数默认30天
		int haveDays_xdbb = MiParamUtil.MI3004(id_hp);// 行动不便开单天数默认14天
		int haveDays = MiParamUtil.MI3005(id_hp);// 普通开单天数 > 7
		//2.获取诊断信息
		DiagDefDO[] diagDefDOArr=this.getDiInfo(idDisSur);//剩余诊断信息
		DiagDefDO[] diagDefDODelArr=this.getDiInfo(diIds);//删除诊断信息
		// 3、分析诊断
		List<String> diTypeList = new ArrayList<String>();
		//3.1校验是否存在慢病行动不便诊断
		this.getDiFlag(diagDefDOArr,diTypeList);
		FBoolean fg_ExistChronicDi =diTypeList.contains(KEY_DIDEF_TYPE_CHRONIC)?FBoolean.TRUE: FBoolean.FALSE;//是否存在慢病诊断
		FBoolean fg_ExistMoveDiffDi = diTypeList.contains(KEY_DIDEF_TYPE_MOVE)?FBoolean.TRUE: FBoolean.FALSE;//是否存在行动不便诊断
		//4.获取剩余诊断所包含得物品
		List<String> mmList= MiBaseInfoUtil.getSpecPatDrugList(id_ent, id_hp, idDisSur);
		//删除诊断所包含物品
		List<String> delMMList=MiBaseInfoUtil.getSpecPatDrugList(id_ent, id_hp, diIds);
		// 4.开始校验
		for (MiMcCiOrdMmDTO dto :ordMMlist) {
			MiMcDiDependOutParamDTO[] outParamDTOArr = new MiMcDiDependOutParamDTO[] {};

			// 只校验西药、草药
			if (!dto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG) && !dto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
				continue;
			}
			// 是否特殊病
			FBoolean isSpecill = mmList.contains(dto.getId_mm())?FBoolean.TRUE:FBoolean.FALSE;
			FBoolean delIsSpecill = delMMList.contains(dto.getId_mm())?FBoolean.TRUE:FBoolean.FALSE;
			// (工伤医保,特病医保)
			if(orderMode==1 && FBooleanUtils.isTrue(delIsSpecill)&& !FBooleanUtils.isTrue(isSpecill) ){
				outParamDTOArr = this.setDiDependDTOBPBySpec(diagDefDODelArr, haveDays_mxb, dto);
			}else if (FBooleanUtils.isTrue(fg_ExistChronicDi)) {
				//诊断是慢性病
				if (dto.getDays_or() > haveDays_mxb) {
					outParamDTOArr = this.setDiDependDTOBPByFgChronic(diagDefDODelArr, haveDays_mxb, dto);
				}
			} else if (FBooleanUtils.isTrue(fg_ExistMoveDiffDi)) {
				// 行动不便
				// 先判断是否存在>14天医嘱，如果存在14天医嘱则查询删除的诊断中的慢病
				if (dto.getDays_or() > haveDays_xdbb) {
					outParamDTOArr = this.setDiDependDTOBPByDiffMove(diagDefDODelArr, haveDays_xdbb, dto);
				}
			} else if (dto.getDays_or() > haveDays) {
				// 如果不存在行动不便，则提示全部
				SetDiDependDTOBP setDiDependDTOBP = new SetDiDependDTOBP();
				DiagDefDO diagDefDO = new DiagDefDO();
				MiMcDiDependOutParamDTO outParamDTO = new MiMcDiDependOutParamDTO();
				String errorMsg = MiCheckWholeMsgUtilBP.GetCheckMsg(dto.getName_or(), dto.getName_mm(), haveDays, dto.getDays_or());
				outParamDTO = setDiDependDTOBP.exec(diagDefDO, dto, errorMsg);
				if (!StringUtil.isEmpty(outParamDTO.getDesc_dpndrsn())) {
					list.addAll(Arrays.asList(outParamDTO));
				}
			}
			if (outParamDTOArr != null && outParamDTOArr.length > 0) {
				list.addAll(Arrays.asList(outParamDTOArr));
			}
		}
		return list;
	}
	
	/**
	 * 慢病校验
	 * 
	 * @param cidiagItemDelList
	 * @param haveDays_mxb
	 * @param ciOrderDO
	 * @param ordSrvDO
	 * @param ordSrvMmDO
	 * @return
	 * @throws BizException
	 */
	private MiMcDiDependOutParamDTO[] setDiDependDTOBPBySpec(DiagDefDO[] diagDefDODelArr, int haveDays_mxb,MiMcCiOrdMmDTO miMcCiOrdMmDTO ) throws BizException {
		List<MiMcDiDependOutParamDTO> list = new ArrayList<MiMcDiDependOutParamDTO>();
		MiMcDiDependOutParamDTO diDependDTO = new MiMcDiDependOutParamDTO();
		SetDiDependDTOBP setDiDependDTOBP = new SetDiDependDTOBP();

		String errorMsg = "存在特殊病医嘱【"+ miMcCiOrdMmDTO.getName_mm() +"】";
		// 查询删除的诊断中是否存在慢病诊断
		for (DiagDefDO diagDefDO : diagDefDODelArr) {
			diDependDTO = setDiDependDTOBP.exec(diagDefDO, miMcCiOrdMmDTO, errorMsg);
			if (diDependDTO != null && !StringUtil.isEmpty(diDependDTO.getCode_di())) {
				list.add(diDependDTO);
			}
		}
		return list.toArray(new MiMcDiDependOutParamDTO[] {});
	}

	/**
	 * 慢病校验
	 * 
	 * @param cidiagItemDelList
	 * @param haveDays_mxb
	 * @param ciOrderDO
	 * @param ordSrvDO
	 * @param ordSrvMmDO
	 * @return
	 * @throws BizException
	 */
	private MiMcDiDependOutParamDTO[] setDiDependDTOBPByFgChronic(DiagDefDO[] diagDefDODelArr, int haveDays_mxb,MiMcCiOrdMmDTO miMcCiOrdMmDTO ) throws BizException {
		List<MiMcDiDependOutParamDTO> list = new ArrayList<MiMcDiDependOutParamDTO>();
		MiMcDiDependOutParamDTO diDependDTO = new MiMcDiDependOutParamDTO();
		SetDiDependDTOBP setDiDependDTOBP = new SetDiDependDTOBP();

		String errorMsg = MiCheckWholeMsgUtilBP.getChronicOrSpecExcessMsg(miMcCiOrdMmDTO.getName_or(), miMcCiOrdMmDTO.getName_mm(), new FDouble(haveDays_mxb), miMcCiOrdMmDTO.getDays_or(), IBdSrvDictCodeConst.DAYS_UNIT);
		// 查询删除的诊断中是否存在慢病诊断
		for (DiagDefDO diagDefDO : diagDefDODelArr) {
			// 如果是慢病
			if (FBooleanUtils.isTrue(diagDefDO.getFg_chronic())) {
				diDependDTO = setDiDependDTOBP.exec(diagDefDO, miMcCiOrdMmDTO, errorMsg);
			}
			// 如果没有慢病诊断 直接返回 防止 开立诊断时是慢病， 将诊断档案的慢病诊断再取消 ，然后再去删除诊断
			if (diDependDTO != null && !StringUtil.isEmpty(diDependDTO.getCode_di())) {
				list.add(diDependDTO);
			}
		}
		return list.toArray(new MiMcDiDependOutParamDTO[] {});
	}

	/**
	 * 行动不便
	 * 
	 * @param cidiagItemDelList
	 * @param haveDays_mxb
	 * @param ciOrderDO
	 * @param ordSrvDO
	 * @param ordSrvMmDO
	 * @return
	 * @throws BizException
	 */
	private MiMcDiDependOutParamDTO[] setDiDependDTOBPByDiffMove(DiagDefDO[] diagDefDODelArr, int haveDays_mxb,MiMcCiOrdMmDTO miMcCiOrdMmDTO) throws BizException {
		List<MiMcDiDependOutParamDTO> list = new ArrayList<MiMcDiDependOutParamDTO>();
		MiMcDiDependOutParamDTO diDependDTO = new MiMcDiDependOutParamDTO();
		SetDiDependDTOBP setDiDependDTOBP = new SetDiDependDTOBP();

		String errorMsg = MiCheckWholeMsgUtilBP.getChronicOrSpecExcessMsg(miMcCiOrdMmDTO.getName_or(), miMcCiOrdMmDTO.getName_mm(), new FDouble(haveDays_mxb,0), miMcCiOrdMmDTO.getDays_or(), IBdSrvDictCodeConst.DAYS_UNIT);
		
		// 查询删除的诊断中是否存在慢病诊断
		for (DiagDefDO diagDefDO : diagDefDODelArr) {
			// 如果是行动不便
			if (!StringUtil.isEmpty(diagDefDO.getName()) && !diagDefDO.getName().contains(KEY_DI_DIFFICALT_TO_MOVE)) {
				diDependDTO = setDiDependDTOBP.exec(diagDefDO, miMcCiOrdMmDTO, errorMsg);
			}
			if (diDependDTO != null && !StringUtil.isEmpty(diDependDTO.getCode_di())) {
				list.add(diDependDTO);
			}
		}
		return list.toArray(new MiMcDiDependOutParamDTO[] {});
	}
	
	/**
	 * 获取诊断信息
	 * @param diIds 诊断id
	 * @return
	 * @throws BizException 
	 */
	private DiagDefDO[] getDiInfo(String[] diIds) throws BizException{
		IDiagdefMDORService ser = ServiceFinder.find(IDiagdefMDORService.class);
		DiagDefDO[] diagDefDOArr = ser.findByAttrValStrings(DiagDefDO.ID_DIDEF, diIds);
		return diagDefDOArr;
	}
	
	/**
	 * 是否存在慢病或行动不便诊断
	 * @param diDefArr 诊断
	 * @param fg_ExistChronicDi 是否存在慢病诊断
	 * @param fg_ExistMoveDiffDi 是否存在行动不便
	 * @return
	 */
	private void getDiFlag(DiagDefDO[] diDefArr,List<String> diTypeList){
		if(ArrayUtil.isEmpty(diDefArr))
			return ;
		for(DiagDefDO diItm : diDefArr){
			if(FBoolean.TRUE.equals(diItm.getFg_chronic()) && !diTypeList.contains(KEY_DIDEF_TYPE_CHRONIC)){
				diTypeList.add(KEY_DIDEF_TYPE_CHRONIC);
			}else{
				if(diItm.getName().contains(KEY_DI_DIFFICALT_TO_MOVE)&& !diTypeList.contains(KEY_DIDEF_TYPE_MOVE))
					diTypeList.add(KEY_DIDEF_TYPE_MOVE); 			
			}
		}
	}
}
