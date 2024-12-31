package iih.ci.ord.s.bp.validate.assi.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.utils.GetOrdValidateInfoBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 医疗单基础检查
 * @author qzwang
 *
 */
public abstract class BaseEmsValidate4OtherBP implements IEmsValidate4OtherBP {
	/**
	 * 校验结果
	 */
	private CiTmplValidateRstDTO ciTmplValidateRstDTO;
	
	public CiTmplValidateRstDTO getValidateRst() {
		return ciTmplValidateRstDTO;
	}
	
	public BaseEmsValidate4OtherBP(){
		ciTmplValidateRstDTO = new CiTmplValidateRstDTO();
	}

	public void setValidateRst(CiTmplValidateRstDTO validateRst) {
		this.ciTmplValidateRstDTO = validateRst;
	}


	@Override
	public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// 频次信息检查
		checkSrvFreqInfo(emsDTO,errorList);
		// 手工划价校验
		checkEuBlmdInfo(emsDTO,errorList);
		// 医嘱流向整体控制排斥校验
		checkOrdFlowWhDeptInfo(emsDTO, errorList);
		return this.ciTmplValidateRstDTO;
	}


	protected void checkQuanMed(CiEmsDTO emsDTO,List<String> errorList){
		
	}
	/**
	 * 成组药品检查
	 * @param emsDTO
	 */
	protected void checkCombDurgInfo(CiEmsDTO emsDTO,List<String> errorList){
		if (emsDTO.getEmssrvs().size() > 1)
		{
			CanCombDrugValidateBP bp = new CanCombDrugValidateBP();
			bp.setValidateRst(this.getValidateRst());
			bp.exec(emsDTO,errorList);
		}
		
	}
	
	/**
	 * 服务频次检查
	 * @param emsDTO
	 * @param errors
	 * @throws BizException 
	 */
	protected void checkSrvFreqInfo(CiEmsDTO emsDTO,List<String> errors) throws BizException{
		if (StringUtil.isEmpty(emsDTO.getId_freq()) ||
				StringUtil.isEmpty(emsDTO.getName_freq())||
				StringUtil.isEmpty(emsDTO.getSd_frequnitct())){
			errors.add("频次信息不完整");
			this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
		}
		
		if(IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS.equals(emsDTO.getSd_frequnitct())){
			
			MeasDocDO measDOC = CiOrdAppUtils.getMeasdocRService().findById(emsDTO.getId_unit_med());
			if(measDOC==null || !ISysDictCodeConst.SD_OPPDIMEN_T.equals(measDOC.getSd_oppdimen())){
				errors.add("服务项目【" + emsDTO.getName() + "】的频次为持续类型，剂量单位必须是时间类型！");
				this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
			}
		}
	}
	
	/**
	 * 手工划价校验
	 * @param emsDTO
	 * @param errors
	 * @throws BizException
	 */
	protected void checkEuBlmdInfo(CiEmsDTO emsDTO,List<String> errors) throws BizException{
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		//护嘱不需要验证手工划价
		if (!(context.getEmsappmode()==3)) {
			IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO medSrvDO = medsrvMDORService.findById(emsDTO.getId_srv());
			if (medSrvDO!=null&&medSrvDO.getEu_blmd()!=null) {
				if ("1".equals(medSrvDO.getEu_blmd().toString())) {
					errors.add("服务项目【" + emsDTO.getName() + "】的划价方式为手工划价，请修改单价后进行保存！");
					this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
				}
			}
		}
		
		
	}
	
	protected void checkSrvRouteInfo(CiEmsDTO emsDTO,List<String> errors){
		if(StringUtils.isEmpty(emsDTO.getId_route()) || StringUtils.isEmpty(emsDTO.getName_route())){
			errors.add("用法信息不完整！");
			this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
		}
	}
	
	/**
	 * 相同药品检查
	 * @param srvList
	 * @param errors
	 */
	protected void checkSameDrugInfo(FArrayList srvList,List<String> errors){
		Map<String,Object> filterMap = new HashMap<String,Object>();
		for(Object obj : srvList){
			CiEmsSrvDTO srvItem = (CiEmsSrvDTO)obj;
			if (FBoolean.TRUE.equals(srvItem.getFg_or())){
				if (filterMap.containsKey(srvItem.getId_mm())){
					errors.add(String.format("%s([%s]) 已经存在", srvItem.getName_mm(),srvItem.getId_mm()));
					this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
				}
				else{
					filterMap.put(srvItem.getId_mm(), srvItem);
				}
			}
		}
		
	}

	/**
	 * 空药品项目检查
	 * @param srvList
	 * @param errors
	 */
	protected void checkEmptyDrugInfo(FArrayList srvList,List<String> errors){
		
		for(Object obj : srvList){
			CiEmsSrvDTO srvItem = (CiEmsSrvDTO)obj;
			if (srvItem.getFg_or()!= null && srvItem.getFg_or().booleanValue()){
				if (StringUtil.isEmpty(srvItem.getId_srv())||
						StringUtil.isEmpty(srvItem.getName_srv())||
						StringUtil.isEmpty(srvItem.getSd_srvtp())||
						StringUtil.isEmpty(srvItem.getInnercode_srvca())){
					errors.add("医疗单中存在空服务信息");
					this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.ERROR);
				}
				else if (FBoolean.TRUE.equals(srvItem.getFg_mm()) && ( StringUtil.isEmpty(srvItem.getId_mm())||
						StringUtil.isEmpty(srvItem.getName_mm()))){
					errors.add(String.format("%s([%s]) 没有物品信息", srvItem.getName_srv(),srvItem.getId_srv()));
					this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.ERROR);
				}
			}
		}
	}
	
	/**
	 * 剂量和总量信息检查
	 * @param srvList
	 * @param errors
	 */
	protected void checkDrugQuanInfo(FArrayList srvList,List<String> errors){
		for(Object obj : srvList){
			CiEmsSrvDTO srvItem = (CiEmsSrvDTO)obj;
			if (srvItem.getFg_or()!= null && srvItem.getFg_or().booleanValue()){
				//剂量必须大于0
				if (srvItem.getQuan_med()== null || srvItem.getQuan_med().doubleValue() <= 0){
					errors.add(String.format("%s([%s]) 剂量必须大于 0", srvItem.getName_srv(),srvItem.getId_srv()));
					this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
				}
				if(StringUtil.isEmpty(srvItem.getId_unit_med())||
						StringUtil.isEmpty(srvItem.getName_unit_med())){
					errors.add(String.format("%s([%s]) 计量单位不完整", srvItem.getName_srv(),srvItem.getId_srv()));
					this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
				}
				if (srvItem.getQuan_cur()!= null && srvItem.getQuan_cur().doubleValue() <= 0){
					errors.add(String.format("%s([%s]) 总量必须大于 0", srvItem.getName_srv(),srvItem.getId_srv()));
					this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
				}
				if(StringUtil.isEmpty(srvItem.getId_unit_sale())||
						StringUtil.isEmpty(srvItem.getName_unit_sale())){
					errors.add(String.format("%s([%s]) 总量单位不完整", srvItem.getName_srv(),srvItem.getId_srv()));
					this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
				}
			}
		}
	}
	
	/**
	 * 用药医嘱天数检查
	 * @param emsDTO
	 * @param errors
	 */
	protected void checkUseDayInfo(CiEmsDTO emsDTO,List<String> errors){
		if (emsDTO.getDays_or() == null || emsDTO.getDays_or().intValue() <= 0) {
			if (!emsDTO.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP) 
					&& !emsDTO.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)){
				errors.add(String.format("%s([%s]) 使用天数必须大于0", emsDTO.getName(),emsDTO.getId_srv()));
				this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
			} else if (emsDTO.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP) 
					&& FBoolean.TRUE.equals(emsDTO.getFg_pres_outp())) {
				errors.add(String.format("%s([%s]) 使用天数不可为空且必须大于0", emsDTO.getName(),emsDTO.getId_srv()));
				this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
			}
		}
	}
	/**
	 * 草药煎法不能为空
	 * @param ems
	 * @param errorList
	 */
    protected void checkBoilInfo(CiEmsDTO ems, List<String>errorList){
		if (StringUtil.isEmpty(ems.getId_boil())){
			if (!OrSourceFromEnum.IIHSRVCAHELPER.equals(ems.getEu_orsrcmdtp())) {
				errorList.add(ems.getName()+" 草药煎法不能为空");
			}
			this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
		}
	}
	/**
	 * 草药的剂数不能为空
	 * @param ems
	 * @param errorList
	 */
    protected void checkOrdersInfo(CiEmsDTO ems, List<String>errorList){
		if (ems.getOrders() > 0){
			errorList.add(ems.getName()+" 草药剂数");
			this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
		}
	}
    /**
     * 核对库存
     * @param emsDTO
     * @param errorList
     * @throws BizException
     */
	protected void checkStock(CiEmsDTO emsDTO, List<String> errorList) throws BizException {
		FArrayList emssrvs =  emsDTO.getEmssrvs();
		Map<String,String[]> mapParams = new HashMap<String,String[]>();
		for(int i=0;i<emssrvs.size();i++){
			CiEmsSrvDTO emssrv = (CiEmsSrvDTO)emssrvs.get(i);
			String[] params = new String[5];
			String keyId = CiOrdUtils.getKeyId(emssrv.getId_mm(),emssrv.getId_dep_wh(),emssrv.getId_unit_sale());
			if(!CiOrdUtils.isEmpty(keyId)){
				mapParams.put(keyId, params);
				params[0] = emssrv.getId_mm();
				if(CiOrdUtils.isEmpty(emssrv.getId_dep_wh())) {
					return;
				}
				params[1] = emssrv.getId_dep_wh();
				params[2] = emssrv.getId_unit_sale();
				params[3] = emssrv.getName_srv();
				params[4] = emssrv.getQuan_total_medu()==null?"0":emssrv.getQuan_total_medu().toString();
			}
		}
		if(!mapParams.isEmpty()){
			String refusedMsg = CiOrdUtils.ValidateDrugCount(mapParams);
			if(!CiOrdUtils.isEmpty(refusedMsg)){
				errorList.add(refusedMsg);
				this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
			}
		}
	}
	/**
	 * 检查是否有空的物资执行科室(药房)
	 * @param emsDTO
	 * @param errorList
	 * @throws BizException
	 */
	protected void checkWhDep(CiEmsDTO emsDTO, List<String> errorList)throws BizException{
		FArrayList emssrvs =  emsDTO.getEmssrvs();
		if(emssrvs == null || emssrvs.size() <= 0) {
			return;
		}
		String warn = "";
		for(int i=0;i<emssrvs.size();i++){
			CiEmsSrvDTO emssrv = (CiEmsSrvDTO)emssrvs.get(i);
			if(CiOrdUtils.isEmpty(emssrv.getId_dep_wh())) {
				warn += emssrv.getName_srv() +",";
			}
		}
		if(!CiOrdUtils.isEmpty(warn)) {
			warn = "服务：" + warn.substring(0, warn.length() - 1) + "，未匹配到药房！\r\n"+"请检查医嘱流向配置和物资库存 ";
			errorList.add(warn);
			this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
		}
	}
	/**
	 * 医嘱流向整体控制排斥校验
	 * @param emsDTO
	 * @param errorList
	 * @throws BizException
	 */
	protected void checkOrdFlowWhDeptInfo(CiEmsDTO emsDTO, List<String> errorList)throws BizException {
		GetOrdValidateInfoBP bp=new GetOrdValidateInfoBP();
		String errorMsgString=bp.getOrdWhDeptValidateInfo(emsDTO);
		if(!CiOrdUtils.isEmpty(errorMsgString)) {
			errorList.add(errorMsgString);
			this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
		}
	}
	/**
	 * 检查是否是抗菌药，如果是则提示，并清空用药目的
	 * @param emsDTO
	 * @param errorList
	 * @throws BizException
	 */
	protected void checkDrugAnti(CiEmsDTO emsDTO, List<String> errorList)throws BizException{
		FArrayList emssrvs =  emsDTO.getEmssrvs();
		if(emssrvs == null || emssrvs.size() <= 0) {
			return;
		}
		String warn = "";
		for(int i=0;i<emssrvs.size();i++){
			CiEmsSrvDTO emssrv = (CiEmsSrvDTO)emssrvs.get(i);
			if(FBoolean.TRUE.equals(emssrv.getFg_mm()) && !IBdSrvDictCodeConst.SD_ANTI_NONANTIBACTERIAL.equals(emssrv.getSd_anti())) {
				emssrv.setFg_propc(null);
				warn += emssrv.getName_mm() + ",";
			}
		}
		if(!CiOrdUtils.isEmpty(warn)) {
			warn = "【" + warn.substring(0, warn.length() - 1) + "】是抗菌药，需要选择“用药目的”！";
			errorList.add(warn);
			this.ciTmplValidateRstDTO.setLevel(CiTmplValidateRstDTO.WARN);
		}
	}
}
