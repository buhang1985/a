package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import java.math.BigDecimal;
import java.util.HashMap;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.dto.d.MiMcSpecDrugLimitDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcCheckFailResultEnum;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvResultDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrderDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import iih.mi.mc.mimcspec.d.MiMcDrugControlEnum;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckSpecillBP;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeMsgUtilBP;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeSetErrMsgBP;
import iih.mm.itf.material.i.IMaterialUnitService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 特殊病开单校验规则
 * @author liming06
 * @since 2020-02-11
 *
 */
public class MiCheckSpecRule extends MiCheckBaseRule{
	/**
	 * 特殊病开单规则校验
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MiMcWholeRuleOutParamDTO exec(MiMcWholeRuleInParamDTO inParamDto) throws BizException {
		MiMcWholeRuleOutParamDTO outParamDto = new MiMcWholeRuleOutParamDTO();
		outParamDto.setFg_checkflag(FBoolean.TRUE);// 默认通过校验
		int orderMode = MiParamUtil.MHIR0001();// 0：采用病种模式；1:诊断模式
		// 3.获取特病患者诊断（病种）限制药品量
		MiCheckSpecillBP miCheckSpecillBP = new MiCheckSpecillBP();
		HashMap<String, MiMcSpecDrugLimitDTO> specPatLimitList = miCheckSpecillBP.exec(inParamDto.getId_hp(), inParamDto.getId_pat(), orderMode);
		// 4.获取患者当月开单量
		FMap patDrugMap =this.getPatDrugMap(inParamDto.getId_pat());
		// 5、校验规则
		outParamDto.setErroritm_list(new FArrayList());// 默认值
		//当前签署医嘱（开立多个，同时签署）
		HashMap<String,FDouble> mmMap= new HashMap<String,FDouble>();
		for (Object item : inParamDto.getCiorderlist()) {
			MiMcOrderDTO ciOrderDO = (MiMcOrderDTO) item;
			FArrayList orsrvLst = ciOrderDO.getOrdsrvlist();
			for (Object orsrv : orsrvLst) {
				MiMcOrdSrvDTO ordSrvDO = (MiMcOrdSrvDTO) orsrv;
				if (StringUtil.isEmpty(ordSrvDO.getId_mm())) {
					continue;
				}
				// 只校验西药、草药
				if (!ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG) 
						&& !ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)
						|| FBoolean.FALSE.equals(ordSrvDO.getSpecdrug_flag())) {
					continue;
				}
				
				FDouble days;//开单天数
				String unit = IBdSrvDictCodeConst.DAYS_UNIT;//单位

				MiCheckWholeSetErrMsgBP setErrorInfoBP = new MiCheckWholeSetErrMsgBP();
				MiMcOrdSrvResultDTO itmChkRstDTO = new MiMcOrdSrvResultDTO();
				String sKey = orderMode == 0 ? ordSrvDO.getId_dsdef() + ordSrvDO.getId_mm() : ordSrvDO.getId_mm();
				// 特殊病病判断
				if (specPatLimitList.containsKey(sKey)) {
					MiMcSpecDrugLimitDTO specDto = specPatLimitList.get(sKey);
					FDouble specLimitQuan = specDto.getQuan_limit();
					FDouble patDrugQuan = new FDouble(0); //当月开单量
					FBoolean bValid;
					// 按月控制
					if (MiMcDrugControlEnum.CONTROLMONTH == specDto.getSd_control()) {
						
						// 获取患者当月开单量
						if (patDrugMap.containsKey(sKey)) {
							patDrugQuan = (FDouble)patDrugMap.get(sKey);
						}						
						if(ordSrvDO.getQuan()!=null){
							unit=ordSrvDO.getName_unit();
							days=ordSrvDO.getQuan();
//							FDouble quan=this.getMaterialUnitFactor(ordSrvDO.getId_mm(), ordSrvDO.getId_unit(),ordSrvDO.getQuan());
//							bValid = quan.add(patDrugQuan).compareTo(new FDouble(specLimitQuan)) > 0 ? FBoolean.TRUE : FBoolean.FALSE;
							//bValid = ordSrvDO.getFactor().multiply(ordSrvDO.getFactor_mb()).multiply(ordSrvDO.getQuan()).add(patDrugQuan).compareTo(new FDouble(specLimitQuan)) > 0 ? FBoolean.TRUE : FBoolean.FALSE;
							FDouble curQuan=ordSrvDO.getFactor().multiply(ordSrvDO.getFactor_mb()).multiply(ordSrvDO.getQuan());
							if(mmMap.containsKey(ordSrvDO.getId_mm())){
								curQuan=curQuan.add(mmMap.get(ordSrvDO.getId_mm()));
							}
							mmMap.put(ordSrvDO.getId_mm(), curQuan);
							bValid = FDoubleUtils.compareFDouble(curQuan.add(patDrugQuan), new FDouble(specLimitQuan))==1?FBoolean.TRUE: FBoolean.FALSE;
						}else{
							days=new FDouble(0);
							bValid=FBoolean.TRUE;
						}
					} else {
						// 判断是草药还是西药 草药按付数提示 西药按医嘱的开单天数进行校验
						if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
							days = new FDouble(ciOrderDO.getQuan_orders());
							unit = IBdSrvDictCodeConst.ORDER_UNIT;
						} else {
							days = new FDouble(ciOrderDO.getQuan_days());
						}
						if(mmMap.containsKey(ordSrvDO.getId_mm())){
							days=new FDouble(days).add(mmMap.get(ordSrvDO.getId_mm()));
						}
						mmMap.put(ordSrvDO.getId_mm(), new FDouble(days));
						// 按天控制
						bValid =FDoubleUtils.compareFDouble(days , specLimitQuan) ==1 ? FBoolean.TRUE : FBoolean.FALSE;
					}
					if (FBoolean.TRUE.equals(bValid)) {
						String errorMsg ;
						if (MiMcDrugControlEnum.CONTROLMONTH == specDto.getSd_control()) {
							FDouble patDrugTurnQuan =new FDouble(0);
							//如果当月开单量大于0，则换算单位
							if(FDoubleUtils.isMoreThanZero(patDrugQuan)){
								patDrugTurnQuan= this.getMaterialUnitFactor(ordSrvDO.getId_mm(), specDto.getId_unit_pkgbase(), patDrugQuan, ordSrvDO.getId_unit());
							}
							if(mmMap.containsKey(ordSrvDO.getId_mm())){
								days=this.getMaterialUnitFactor(ordSrvDO.getId_mm(), specDto.getId_unit_pkgbase(),mmMap.get(ordSrvDO.getId_mm()), ordSrvDO.getId_unit());
							}
							//计算超出量
							FDouble quan=(days).add(patDrugTurnQuan).setScale(2, BigDecimal.ROUND_HALF_UP); //已开数量
							FDouble exceQuan= new FDouble();
							if(specDto.getId_unit().equals(ordSrvDO.getId_unit())){
								exceQuan= quan.sub(specDto.getQuan_ori_limit()).setScale(2, BigDecimal.ROUND_HALF_UP);
							}else{
								FDouble limitQuan= this.getMaterialUnitFactor(ordSrvDO.getId_mm(), specDto.getId_unit(), specDto.getQuan_ori_limit(), ordSrvDO.getId_unit());
								exceQuan =quan.sub(limitQuan).setScale(2, BigDecimal.ROUND_HALF_UP);
							}
							errorMsg = MiCheckWholeMsgUtilBP.getSpecExcessMsg(ciOrderDO.getName_or(), ordSrvDO.getName_mm(), specDto.getQuan_ori_limit(), specDto.getName_unit(), quan, unit,exceQuan );
						}else{
							errorMsg = MiCheckWholeMsgUtilBP.getChronicOrSpecExcessMsg(ciOrderDO.getName_or(), ordSrvDO.getName_mm(), specLimitQuan, days.intValue(), unit);
						}
						outParamDto.setFg_checkflag(FBoolean.FALSE);
						itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, MiMcCheckFailResultEnum.GREATER_THAN_GET_OEP, errorMsg);
						outParamDto.getErroritm_list().add(itmChkRstDTO);
						continue;
					}
				}
			}
		}
		return outParamDto;
	}
	
	/**
	 * 获取物品的换算率
	 * @param id_mm
	 * @param id_unit
	 * @return
	 * @throws BizException 
	 */
	private FDouble getMaterialUnitFactor(String id_mm,String id_unit,FDouble quan,String out_unit_id) throws BizException{
		IMaterialUnitService ser =ServiceFinder.find(IMaterialUnitService.class);
		FDouble factory =ser.unitConversion(id_mm, IMeterialService.TYPE_NUM, id_unit, quan, out_unit_id);
		return PrecisionUtils.formatQuan(factory);
	} 
}
