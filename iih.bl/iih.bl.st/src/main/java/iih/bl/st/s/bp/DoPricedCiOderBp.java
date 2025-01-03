package iih.bl.st.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.comm.IBlConst;
import iih.bl.st.service.i.IBLStQueService;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.dto.thirdparam.ChargeForCiParamDTO;
import iih.ci.ord.i.third.ICiOrderThirdService;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 铜陵处置收费（注册挂号、医嘱签署、划价）
 * @author liwq
 *
 */
public class DoPricedCiOderBp {

	public BlCgOepAggDTO exec(OpRegPatDTO regPat, BlOrderAppendBillParamDTO[] chargeItemArr, OperatorInfoDTO psnInfoDto) throws BizException {
		
		if(ArrayUtil.isEmpty(chargeItemArr)){
			throw new BizException("请录入补费信息");
		}
		//1、患者注册挂号
		IEnOutCmdService enOutService = ServiceFinder.find(IEnOutCmdService.class);
		PatiVisitDO entDo = enOutService.regPatAndOp(regPat);
		
		//2、开立医嘱并签署
		ICiOrderThirdService ciService = ServiceFinder.find(ICiOrderThirdService.class);
		
		List<ChargeForCiParamDTO> chargeDtoList = new ArrayList<ChargeForCiParamDTO>();
		
		//2.1 DTO转换
		for(BlOrderAppendBillParamDTO appendDto : chargeItemArr) {
			ChargeForCiParamDTO chargeDto = new ChargeForCiParamDTO();
			chargeDto.setId_ent(appendDto.getId_ent());
			chargeDto.setId_srv(appendDto.getId_srv());
			chargeDto.setId_mm(appendDto.getId_mm());
			chargeDto.setId_emp(psnInfoDto.getId_emp());
			chargeDto.setId_unit_pkg(appendDto.getPgku_cur());
			chargeDto.setFg_mm(appendDto.getFg_mm().booleanValue()? "Y" :"N");
			chargeDto.setPrice(appendDto.getPrice_ratio());
			chargeDto.setDt_b(AppUtils.getServerDateTime().toStdString());
			chargeDto.setQuan(appendDto.getQuan().toString());
			chargeDtoList.add(chargeDto);			
		}
		
		//医嘱生成
		ThirdRstDTO[] retDto = ciService.tidyFeeSave(entDo, chargeDtoList.toArray(new ChargeForCiParamDTO[]{}));
		if(ArrayUtil.isEmpty(retDto)){
			throw new BizException("生成医嘱时返回值为空");
		}
		
		List<ThirdRstDTO> thirdList=Arrays.asList(retDto);
		List<ThirdRstDTO> arrList = new ArrayList(thirdList);
		//给前台传过来的补费医嘱的每个对应DTO加一个医嘱主键
		for (BlOrderAppendBillParamDTO itm : chargeItemArr) {
			for(int i=0;i<arrList.size();i++){
				//本节点只针对治疗类的医嘱
				if (arrList.get(i).getOrderAggInfoList() == null) {
					throw new BizException("未获得医嘱信息");
				}
				FArrayList ciList=arrList.get(i).getOrderAggInfoList();
				List<CiorderAggDO> list=new ArrayList<CiorderAggDO>();
				list.addAll(ciList);
				if(list==null || list.size()==0){
					throw new BizException("获取医嘱信息为空");
				}
				//删除&& list.get(0).getParentDO().getOr_total_pri().equals(itm.getPrice_ratio())
				if(list.get(0).getParentDO().getId_srv().equals(itm.getId_srv()) && list.get(0).getOrdSrvDO()[0].getQuan_total_medu().equals(itm.getQuan())){
					if(!StringUtil.isEmpty(itm.getId_or())){
						continue;
					}
					itm.setId_or(list.get(0).getParentDO().getId_or());
					arrList.remove(i);
					i--;
					continue;
				}
			}
		}

		//校验补录的服务是否都加上了不同的id_or
		//校验补费服务是否都加上了医嘱号
		for(int i = 0;i < chargeItemArr.length;i++){
			if(StringUtil.isEmpty(chargeItemArr[i].getId_or())){
				throw new BizException("存在没有医嘱id的补费服务");
			}
		}
		//校验补费服务是否都加上了不同的医嘱号
		for(int i = 0;i < chargeItemArr.length;i++){
			for(int j = i + 1;j < chargeItemArr.length;j++){
				if(chargeItemArr[i].equals(chargeItemArr[j])){
					throw new BizException("存在医嘱id相同的补费服务");
				}
			}
		}
		
		if(!retDto[0].isSuccessful().booleanValue()){
			throw new BizException("收费项目保存失败！\n"+retDto[0].getErrorMessage());
		}
		//将补费入参转换为Map<String,BlOrderAppendBillParamDTO>
//		
		Map<String,BlOrderAppendBillParamDTO> appendDtoMap = new HashMap<String,BlOrderAppendBillParamDTO>();

		for(BlOrderAppendBillParamDTO chargeItem : chargeItemArr) {
			if(!appendDtoMap.containsKey(chargeItem.getId_srv()))
			appendDtoMap.put(chargeItem.getId_srv(), chargeItem);
		}
		
		
		//3、根据就诊id获取未缴费的处方
		IBLStQueService stQueService = ServiceFinder.find(IBLStQueService.class);
		BlOrderAppendBillParamDTO[] tmpDtos = stQueService.getOrderSrvPrinceInfoByIdpres_load(regPat.getId_pat(),1);
		
		if(ArrayUtil.isEmpty(tmpDtos)) {
			throw new BizException("未查询到需要结算的收费项目！");
		}
		
		//过滤
		List<BlOrderAppendBillParamDTO> ciOrderAppendDtos = new ArrayList<BlOrderAppendBillParamDTO>();
		for(BlOrderAppendBillParamDTO itmDto: tmpDtos) {
			if(!StringUtil.isEmpty(itmDto.getId_ent()) && itmDto.getId_ent().equals(entDo.getId_ent())) {
				ciOrderAppendDtos.add(itmDto);
			}
		}
		
		if(ListUtil.isEmpty(ciOrderAppendDtos))
			return null;
		
		//再次过滤，只取页面上补费的医嘱数据
		List<BlOrderAppendBillParamDTO> filterCiOrderAppendDtos = new ArrayList<BlOrderAppendBillParamDTO>();
		
		//因为要求能补费，所以给ciOrderAppendDtos赋值
		for (BlOrderAppendBillParamDTO itm : ciOrderAppendDtos) {
			for (BlOrderAppendBillParamDTO idorsrv : chargeItemArr) {
				if (idorsrv.getId_or().equals(itm.getId_or())) {
					if(idorsrv.getPrice() == null || idorsrv.getPrice_ratio() == null){
						throw new BizException("补费项目单价未获取");
					}
					if(itm.getEu_blmd() != null && "1".equals(itm.getEu_blmd())){
						itm.setFg_modifyprice(FBoolean.TRUE);
					}
					itm.setPrice(idorsrv.getPrice());
					itm.setPrice_ratio(idorsrv.getPrice_ratio());
					if(idorsrv.getPrice().compareTo(FDouble.ZERO_DBL) == 0  && idorsrv.getPrice_ratio().compareTo(FDouble.ZERO_DBL) != 0){
						itm.setEu_blmd("1");
						itm.setFg_modifyprice(FBoolean.TRUE);
					}
					itm.setRatio_pripat(idorsrv.getRatio_pripat());
					filterCiOrderAppendDtos.add(itm);
				}
			}
		}
		
		if(ListUtil.isEmpty(filterCiOrderAppendDtos)){
			throw new BizException("请录入补费信息");
		}
		
		 //补充字段
		supplementFields(appendDtoMap,psnInfoDto,filterCiOrderAppendDtos);
		
		//重新计算金额
		for (BlOrderAppendBillParamDTO blParamDto : filterCiOrderAppendDtos) {
			blParamDto.setAmt(blParamDto.getPrice_ratio().multiply(blParamDto.getQuan(), IBlConst.PRECISION_AMOUNT));
			blParamDto.setAmt_ratio(blParamDto.getAmt_ratio());
			blParamDto.setAmt_std(blParamDto.getPrice().multiply(blParamDto.getQuan(), IBlConst.PRECISION_AMOUNT));
			blParamDto.setAmt_pat(FDouble.ZERO_DBL);
			blParamDto.setAmt_hp(FDouble.ZERO_DBL);
		}
		
		//4、划价
		BlCgOepAggDTO aggDto = new BlCgOepAggDTO();
	
		IBLCiOrderToBlCgService cgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		
		aggDto = cgService.SetCiOrderToPrice(filterCiOrderAppendDtos.toArray(new BlOrderAppendBillParamDTO[]{}),psnInfoDto, FBoolean.TRUE);
		return aggDto;
	}
	
	/**
	 * 补充缺失字段
	 * @param entDo
	 * @param psnInfoDto
	 * @return
	 * @throws BizException
	 */
	public void supplementFields(Map<String,BlOrderAppendBillParamDTO> map, OperatorInfoDTO psnInfoDto, List<BlOrderAppendBillParamDTO> appendDtos) throws BizException {
		
//		for(BlOrderAppendBillParamDTO itmDto : appendDtos) {
//			
//			itmDto.setId_dep_cg(psnInfoDto.getId_dep());
//			itmDto.setId_emp_cg(psnInfoDto.getId_emp());
//			if(map.containsKey(itmDto.getId_srv())) {
//				BlOrderAppendBillParamDTO tmpOrign = map.get(itmDto.getId_srv());
//				itmDto.setId_mm(tmpOrign.getId_mm());
//				itmDto.setId_mmtp(tmpOrign.getId_mmtp());
//				itmDto.setSd_mmtp(tmpOrign.getSd_mmtp());
//				itmDto.setCode_mm(tmpOrign.getCode_mm());
//				itmDto.setName_mm(tmpOrign.getName_mm());
//				itmDto.setPgku_base(tmpOrign.getPgku_base());
//				itmDto.setPgku_cur(tmpOrign.getPgku_cur());
//				itmDto.setOnlycode(tmpOrign.getOnlycode());
//				itmDto.setCd_batch(tmpOrign.getCd_batch());
//				itmDto.setFactor(tmpOrign.getFactor());
//				itmDto.setQuan_base(tmpOrign.getQuan_base());
//				itmDto.setPri_ss(tmpOrign.getPri_ss());
//				
//				itmDto.setQuan(tmpOrign.getQuan());
//			}
//		}
		//不包含此次开立的费用 采用迭代器删除      by zx 2019年12月27日   0182028: 【验证版】门诊便民工作站划价报错（见截图） 
		Iterator<BlOrderAppendBillParamDTO> iterator = appendDtos.iterator();
		while (iterator.hasNext()){
			BlOrderAppendBillParamDTO itmDto =	iterator.next();
			if(map.containsKey(itmDto.getId_srv())){
				BlOrderAppendBillParamDTO tmpOrign = map.get(itmDto.getId_srv());
				itmDto.setId_mm(tmpOrign.getId_mm());
				itmDto.setId_mmtp(tmpOrign.getId_mmtp());
				itmDto.setSd_mmtp(tmpOrign.getSd_mmtp());
				itmDto.setCode_mm(tmpOrign.getCode_mm());
				itmDto.setName_mm(tmpOrign.getName_mm());
				itmDto.setPgku_base(tmpOrign.getPgku_base());
				itmDto.setPgku_cur(tmpOrign.getPgku_cur());
				itmDto.setOnlycode(tmpOrign.getOnlycode());
				itmDto.setCd_batch(tmpOrign.getCd_batch());
				itmDto.setFactor(tmpOrign.getFactor());
				itmDto.setQuan_base(tmpOrign.getQuan_base());
				itmDto.setPri_ss(tmpOrign.getPri_ss());
				itmDto.setQuan(tmpOrign.getQuan());
			}else {
				iterator.remove();
			}
		}
	}
}
