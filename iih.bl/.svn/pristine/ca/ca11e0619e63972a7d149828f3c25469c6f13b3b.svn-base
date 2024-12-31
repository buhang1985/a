package iih.bl.cg.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPriCalcService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 门诊通用补费保存
 * @author liwq
 */
public class DoSaveOpAppendFeeBp {

	private IBdPriCalcService priCalcService = ServiceFinder.find(IBdPriCalcService.class);
	public BlOrderAppendBillParamDTO[] exec (NurseCompFeeItmDTO[] dtoArr,String id_ent) throws BizException {
		if(dtoArr == null || dtoArr.length == 0){
			throw new BizException("入参为空");
		}
		
			if(StringUtils.isEmptyWithTrim(id_ent)) {
				throw new BizException("对患者进行补费时，就诊id不能为空！");
			}
			//获取就诊对应的价格系数
			PatiVisitDO vist = this.getPatiVisitDO(id_ent);
			FDouble picPate = this.getPatRateByIdEnt(id_ent);
			//String id_psndoc = Context.get().getStuffId();
			
			Map<String,MeterialDO> mmMap = this.getMmDoMap(dtoArr);
			
			//计算价格
			Map<String,PriceResultDTO> priMap = this.getSrvPrice(dtoArr, vist.getId_pripat());
			
			//筛选、组装记账信息
			List<BlOrderAppendBillParamDTO> billDTOList = new ArrayList<BlOrderAppendBillParamDTO>();		
			for(NurseCompFeeItmDTO itm : dtoArr){
				BlOrderAppendBillParamDTO billDTO = null;
					billDTO = this.getBlCgDTO(itm,picPate,mmMap,vist,priMap);
					billDTOList.add(billDTO);
			}
			BlOrderAppendBillParamDTO[] finalDtos = null;
			//调用补费接口
			IBLOrderAppendBillService billService = ServiceFinder.find(IBLOrderAppendBillService.class);
			if(billDTOList != null && billDTOList.size() > 0){			
				//新接口，按明细补费
				finalDtos = billService.SetOrderAppendBill_ByItms(billDTOList.toArray(new BlOrderAppendBillParamDTO[]{}), IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			}
		
		
		return finalDtos;
	}

	/**
	 * 组装新增记账数据
	 * @param blCgIpDO 
	 * @param picPate 
	 * @return BlOrderAppendBillParamDTO
	 * @author liwq
	 * @since 2018年4月2日9:21:38
	 * */
	public BlOrderAppendBillParamDTO getBlCgDTO(NurseCompFeeItmDTO nurDto,FDouble picPate,Map<String,MeterialDO> mmMap,PatiVisitDO visit,Map<String,PriceResultDTO> priMap){
		TimeService timeService = new TimeServiceImpl();
		
		BlOrderAppendBillParamDTO blCgDTO = new BlOrderAppendBillParamDTO();

		
		PriceResultDTO priDto = priMap.get(nurDto.getId_srv());
		
		//blCgDTO.setId_pres(nurDto.getId_pres());
		blCgDTO.setId_ent(visit.getId_ent());
		blCgDTO.setId_srvtp(nurDto.getId_srvtp());
		blCgDTO.setId_srvca(nurDto.getId_srvca());
		blCgDTO.setSd_srvtp(nurDto.getSd_srvtp());
		blCgDTO.setId_srv(nurDto.getId_srv());
		blCgDTO.setCode_srv(nurDto.getCode_srv());
		blCgDTO.setName_srv(nurDto.getName_srv());
		blCgDTO.setSrvu(nurDto.getSrvu());
		blCgDTO.setPrice(nurDto.getPrice());
		blCgDTO.setPrice_ratio(nurDto.getPrice_ratio());
		blCgDTO.setId_pat(visit.getId_pat());
		blCgDTO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		blCgDTO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		blCgDTO.setDt_srv(timeService.getUFDateTime());
		blCgDTO.setQuan(nurDto.getQuan_mend());
		blCgDTO.setEu_direct(BookRtnDirectEnum.CHARGE);
		blCgDTO.setRatio_pripat(picPate);//当前患者价格比例
		blCgDTO.setEu_srctp(0);
		blCgDTO.setNote("补费（新增）");
		blCgDTO.setFg_additm(FBoolean.TRUE);

		blCgDTO.setId_grp(Context.get().getGroupId());
		blCgDTO.setId_org(Context.get().getOrgId());
		blCgDTO.setId_org_or(Context.get().getOrgId());
		blCgDTO.setId_dep_or(nurDto.getId_dep_or());
		blCgDTO.setId_emp_or(nurDto.getId_emp_or());
		//blCgDTO.setDt_or(nurDto.getDt_or());
		blCgDTO.setId_org_mp(Context.get().getOrgId());
		blCgDTO.setId_dep_mp(nurDto.getId_dep_mp());
		blCgDTO.setId_pripat(nurDto.getId_pripat());
		blCgDTO.setId_hp(visit.getId_hp());
		blCgDTO.setAmt_hp(new FDouble(0));
		
		if(blCgDTO.getQuan()!=null)
		{
			blCgDTO.setAmt_std(blCgDTO.getQuan().multiply(nurDto.getPrice()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			blCgDTO.setAmt_pat(blCgDTO.getQuan().multiply(nurDto.getPrice()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			//blCgDTO.setAmt(blCgDTO.getAmt_pat().multiply(blCgDTO.getRatio_pripat()).setScale(-2, BigDecimal.ROUND_HALF_UP));///???是否判空	
			blCgDTO.setAmt_ratio(blCgDTO.getQuan().multiply(blCgDTO.getPrice_ratio()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			blCgDTO.setAmt(blCgDTO.getAmt_ratio());
		}
		blCgDTO.setFg_mm(nurDto.getFg_mm());
		blCgDTO.setId_mm(nurDto.getId_mm());
		blCgDTO.setId_mmtp(nurDto.getId_mmtp());
		blCgDTO.setSd_mmtp(mmMap.get(nurDto.getId_mm())!= null ? mmMap.get(nurDto.getId_mm()).getSd_mmtp() : "");
		blCgDTO.setCode_mm(nurDto.getCode_mm());
		blCgDTO.setSpec(nurDto.getSpec());
		blCgDTO.setOnlycode(nurDto.getOnlycode());
		blCgDTO.setName_mm(nurDto.getName_mm());
		blCgDTO.setCd_batch(nurDto.getCd_batch());
		blCgDTO.setPgku_base(nurDto.getPgku_base());
		blCgDTO.setPgku_cur(nurDto.getPgku_cur());		

		blCgDTO.setFg_hp(FBoolean.FALSE);
		blCgDTO.setFg_susp(FBoolean.FALSE);
		blCgDTO.setFg_refund(FBoolean.FALSE);
		blCgDTO.setId_par(nurDto.getId_cgip());
		blCgDTO.setCode_cg(null);
		blCgDTO.setId_org_cg(Context.get().getOrgId());
		blCgDTO.setId_dep_cg(Context.get().getDeptId());//记账科室
		blCgDTO.setDt_cg(timeService.getUFDateTime());
		blCgDTO.setSupportAppendBill(FBoolean.TRUE);//是否支持后付费？？？
		blCgDTO.setId_emp_cg(nurDto.getId_emp_cg());
		
		BlOrderAppendInpBillParamDTO inpBillDTO = new BlOrderAppendInpBillParamDTO();
		inpBillDTO.setFg_pddisc(FBoolean.FALSE);//出院带药标志
		inpBillDTO.setId_wg_or(visit.getId_wg_phy());//医疗组
		inpBillDTO.setId_dep_nur(visit.getId_dep_nur());//病区
		blCgDTO.setSrcfunc_des(IBlCgCodeConst.NurWorkStation);//门诊护士站
		blCgDTO.setInpBillDTO(inpBillDTO);
		return blCgDTO;
	}
	/**
	 * 获取补费项目中物品的对应map集合
	 * @param arr
	 * @return
	 * @throws DAException
	 */
	private Map<String,MeterialDO> getMmDoMap(NurseCompFeeItmDTO[] arr) throws DAException {
		Map<String,MeterialDO>  map = new HashMap<String,MeterialDO>();
		List<String> mmList = new ArrayList<String>();
		
		for(NurseCompFeeItmDTO dto : arr) {
			if(dto.getFg_mm().booleanValue())
				mmList.add(dto.getId_mm());
		}
		
		DAFacade da = new DAFacade();		
		List<MeterialDO> list = (List<MeterialDO>)da.findByPKs(MeterialDO.class, mmList.toArray(new String[]{}));
		if(list!= null && !list.isEmpty()) {
			for(MeterialDO mmDo : list) {
				map.put(mmDo.getId_mm(), mmDo);
			}
		}
		return map;
	}
	/**
     * 获取就诊对应的价格系数
     * */
	private FDouble getPatRateByIdEnt(String id_ent) throws BizException {
    	StringBuffer sql = new StringBuffer();
		sql.append("select b.rate ")
		   .append("from en_ent e ")
		   .append("left join bd_pri_pat b on e.id_pripat = b.id_pripat ")
		   .append("where e.id_ent = '").append(id_ent).append("' ");
		BigDecimal discount = (BigDecimal)new DAFacade().execQuery(sql.toString(), new ColumnHandler() );
		if(discount == null)
		{
			throw new BizException("就诊对应的价格分类不存在！");
		}
		return new FDouble(discount);
    }
	/**
	 * 获取就诊信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getPatiVisitDO(String id_ent) throws BizException {
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
        PatiVisitDO patiVisitDo = service.findById(id_ent);
        return patiVisitDo;
	}

	/**
	 * 获取服务价格
	 * @param dtoArr
	 * @param pripatId
	 * @return
	 * @throws BizException
	 */
	private Map<String,PriceResultDTO> getSrvPrice(NurseCompFeeItmDTO[] dtoArr,String pripatId)throws BizException {
		
		List<String> srvList  = new ArrayList<String>();
		for (NurseCompFeeItmDTO dto : dtoArr) {
			if(!srvList.contains(dto.getId_srv())){
				srvList.add(dto.getId_srv());
			}
		}
		
		return priCalcService.batchCalcPatPrice(srvList.toArray(new String[0]), pripatId);
	}
	
}
