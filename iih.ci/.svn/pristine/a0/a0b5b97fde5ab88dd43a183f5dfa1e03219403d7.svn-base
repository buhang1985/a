package iih.ci.mi.external.obtain.mi.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.ci.mi.diag.i.meta.CiMiDiagDTO;
import iih.ci.mi.log.CiMiLogManager;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillParamDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillRstDTO;
import iih.ci.mi.sysparam.CiMiParamUtil;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcDefDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcSpecDrugInDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcSpecDrugOutDTO;
import iih.mi.mc.i.IMiMcRuleService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取医保特殊病判断结果
 * @author HUMS
 *
 */
public class GetMiSpecillVerifyBP {

	private IMiMcRuleService miMcRuleService;

	public GetMiSpecillVerifyBP() {
		miMcRuleService = ServiceFinder.find(IMiMcRuleService.class);
	}
	
	public List<OrdSrvSpecillRstDTO> exec(CiEnContextDTO ctx, List<CiMiDiagDTO> diagList, List<OrdSrvSpecillParamDTO> ordSrvParamList) throws BizException{
		
		// MHIR0001 特殊病判断模式 ，0：病种模式时；1：诊断模式， 诊断模式时传入诊断，病种模式不传入诊断
		Integer mhir001 = CiMiParamUtil.MHIR0001();
		List<OrdSrvSpecillRstDTO> ordSrvRstList = new ArrayList<OrdSrvSpecillRstDTO>();
		
		Map<String,MiMcSpecDrugOutDTO> specDrugMap = this.getMiMcSpecillDrugMap(ctx, diagList, ordSrvParamList);
		 
		 for(OrdSrvSpecillParamDTO ordSrv : ordSrvParamList){
			 
			 OrdSrvSpecillRstDTO ordSrvRst = new OrdSrvSpecillRstDTO();
			 
			 ordSrvRst.setId_or(ordSrv.getId_or());
			 ordSrvRst.setId_orsrv(ordSrv.getId_orsrv());
			 ordSrvRst.setSd_srvtp(ordSrv.getSd_srvtp());
			 
			 ordSrvRst.setId_srv(ordSrv.getId_srv());
			 ordSrvRst.setCode_srv(ordSrv.getCode_srv());
			 ordSrvRst.setName_srv(ordSrv.getName_srv());
			 
			 ordSrvRst.setId_mm(ordSrv.getId_mm());
			 ordSrvRst.setCode_mm(ordSrv.getCode_mm());
			 ordSrvRst.setName_mm(ordSrv.getName_mm());
			 
			 ordSrvRst.setId_dsdef(ordSrv.getId_dsdef());
			 ordSrvRst.setCode_dsdef(ordSrv.getCode_dsdef());
			 ordSrvRst.setName_dsdef(ordSrv.getName_dsdef());
			 
			 String tempKey = ordSrvRst.getId_mm();
			 MiMcSpecDrugOutDTO drug = specDrugMap.get(tempKey);
			 
			 ordSrvRst.setFg_specdrug(drug.getFg_specdrug());
			 ordSrvRst.setFg_specill(FBoolean.FALSE);
			 
			 // 是患者特殊病药品，但是没有对应的诊断或病种
			 if(FBoolean.TRUE.equals(ordSrvRst.getFg_specdrug())){
				 
				 // 特殊病药品，缺少的病种或诊断ID集合
				 FArrayList miMcDefFList = drug.getDeflist();
				 StringBuffer msgBuffer = new StringBuffer();
				 List<String> idDefList = new ArrayList<String>();
				 for(Object obj : miMcDefFList){
					 MiMcDefDTO miMcDef = (MiMcDefDTO)obj;
					 idDefList.add(miMcDef.getId_def());
					 msgBuffer.append("；（"+miMcDef.getCode_def()+"）").append(miMcDef.getName_def());
				 }
				 
				 
				 if(mhir001 == 0 ){
					 if(idDefList.contains(ordSrvRst.getId_dsdef())){
						 ordSrvRst.setFg_specill(FBoolean.TRUE);	 
					 }else{
						 if(msgBuffer.length() >0){
							 ordSrvRst.setMsg("特殊病药品【"+ordSrvRst.getName_mm()+"】未选择特殊病病种："+msgBuffer.substring(1)+"！");	 
						 }else{
							 ordSrvRst.setMsg("特殊病药品【"+ordSrvRst.getName_mm()+"】未选择特殊病病种：特殊病校验返回病种集合为空，请查看病种是否启用！");
						 }	 
					 }
				 }else if(mhir001 == 1){
					 for(CiMiDiagDTO diag : diagList){
						 // 自定义诊断ID为空
						 if(StringUtils.isNotEmpty(diag.getId_didef()) && idDefList.contains(diag.getId_didef())){
							 ordSrvRst.setFg_specill(FBoolean.TRUE);
						 }else{
							 if(msgBuffer.length()>0){
								 ordSrvRst.setMsg("特殊病药品【"+ordSrvRst.getName_mm()+"】未选择特殊病诊断："+msgBuffer.substring(1)+"！");	 
							 }else{
								 ordSrvRst.setMsg("特殊病药品【"+ordSrvRst.getName_mm()+"】未选择特殊病诊断：特殊病校验返回诊断集合为空！");
							 }							 
						 }
					 }
				 }
			 }
			 
			 ordSrvRstList.add(ordSrvRst);
		 }
		 
		return ordSrvRstList;
	}
	
	/**
	 * 调用医保平台回去医保特殊病判断结果
	 * @param ctx
	 * @param diagList
	 * @param ordSrvParamList
	 * @return
	 * @throws BizException
	 */
	protected Map<String,MiMcSpecDrugOutDTO> getMiMcSpecillDrugMap(CiEnContextDTO ctx, List<CiMiDiagDTO> diagList, List<OrdSrvSpecillParamDTO> ordSrvParamList) throws BizException{
		
		MiMcSpecDrugInDTO specDrugParam = new MiMcSpecDrugInDTO(); 
		 
		 specDrugParam.setId_ent(ctx.getId_en());
		 specDrugParam.setId_hp(ctx.getId_hp());
		 FArrayList idDidefFList = new FArrayList();
		 for(CiMiDiagDTO diag : diagList){
			 idDidefFList.add(diag.getId_didef());
		 }
		 specDrugParam.setId_didefs(idDidefFList);
		 
		 FMap mmDsdefMap = new FMap();
		 FArrayList idmmList = new FArrayList();
		 for(OrdSrvSpecillParamDTO ordSrvParam : ordSrvParamList){
			 
			 if(ordSrvParam.getFg_mm() && !idmmList.contains(ordSrvParam.getId_mm())){
				 //mmDsdefMap.put(ordSrvParam.getId_mm(), ordSrvParam.getId_dsdef());
				 mmDsdefMap.put(ordSrvParam.getId_mm(), ordSrvParam.getId_dsdef());
				 idmmList.add(ordSrvParam.getId_mm());
			 }
		 }
		 
		 Long start = System.currentTimeMillis();
		 Map<String,MiMcSpecDrugOutDTO> specDrugMap = new HashMap<String,MiMcSpecDrugOutDTO>();
		 if(mmDsdefMap.size() >0){
			 specDrugParam.setMmdsdefs(mmDsdefMap);
			 specDrugParam.setId_mms(idmmList);
			 MiMcSpecDrugOutDTO[] specDrugs = miMcRuleService.isPatSpecDrug(specDrugParam);
			 
			 for(MiMcSpecDrugOutDTO drug : specDrugs){
				 specDrugMap.put(drug.getId_mm(), drug);
			 }
		 }
		 Long end= System.currentTimeMillis();
		 CiMiLogManager.info(null, "特殊病药品判断结算结束时间 ："+(end-start));
		 return specDrugMap;
	}
}
