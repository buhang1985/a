package iih.en.pv.s.bp.op.ws;

import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.dto.d.OpEntListDTO;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescUtil;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescription;


/**
 * 查询预约和就诊数据 
 * 预约：未取消 
 * 就诊：所有
 * @author Sarah
 *
 */
public class GetOpAptAndEntListBP {
	
	/**
	 * 获取患者挂号记录
	 * @param patCode 患者编码
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @param agentPatCode
	 *            代办人编码      
	 * @return
	 * @throws BizException 
	 */
	public OpPatAptDTO[] exec(String patCode,String beginDate, String endDate,String agentPatCode) throws BizException{
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetOpAptAndEntListBP参数为:patCode:"+patCode+";beginDate:"+beginDate
				+";endDate:"+endDate+";agentPatCode:"+agentPatCode);		

		OpEntListDTO[] entDtos =null;
		OpPatAptDTO[] aptDtos =null;
		if(!EnValidator.isEmpty(agentPatCode)){
			//1. 查询患者就诊 
			entDtos =new  GetPatOpEntListBP().exec2(agentPatCode, beginDate, endDate);			
			//2. 查询预约患者 	
			aptDtos = new GetOpAptListByAgentPatCodeBP().exec(agentPatCode, beginDate, endDate);
		}else{			
			//1. 查询患者就诊 
			entDtos =new  GetPatOpEntListBP().exec2(patCode, beginDate, endDate);			
			//2. 查询预约患者 	
			aptDtos = new GetPatOpAptListBP().exec(patCode, beginDate, endDate);
		}
		
		//3.转换数据 取并集
		List<OpPatAptDTO> patAptList =this.resetData(entDtos, aptDtos);
		
		
		return patAptList.toArray(new OpPatAptDTO[]{});
	}
	
	
	/**
	 * 预约和就诊合并数据
	 * @param EntDtos
	 * @param AptDtos
	 */
	private List<OpPatAptDTO>  resetData(OpEntListDTO[] entDtos,OpPatAptDTO[] aptDtos){
		List<String> entIdList = new ArrayList();
		List<OpPatAptDTO> allList = new ArrayList<OpPatAptDTO>();
		if(!EnValidator.isEmpty(entDtos)){
			for(OpEntListDTO  entDTO:entDtos){
				if(!EnValidator.isEmpty(entDTO.getId_apt()))
					entIdList.add(entDTO.getId_apt());
				allList.add(this.changeEntToApt(entDTO));
			}
		}
		if(!EnValidator.isEmpty(aptDtos)){
			for(OpPatAptDTO aptDto : aptDtos){
				if(!entIdList.contains(aptDto.getId_apt())){
					allList.add(aptDto);
				}
			}
		}
		return allList;
	} 
	/**
	 * 转换数据
	 * @param entDto
	 * @return
	 */
	private OpPatAptDTO  changeEntToApt(OpEntListDTO entDto){
		OpPatAptDTO aptDTO = new OpPatAptDTO();
		aptDTO.setId_apt(entDto.getId_apt());
		aptDTO.setPatName(entDto.getPatName());
		aptDTO.setPatCode(entDto.getPatCode());
		aptDTO.setPatCa(entDto.getPatCa());// 患者类型编码
		aptDTO.setDeptCode(entDto.getDeptCode());// 科室编码
		aptDTO.setDeptName(entDto.getDeptName());// 科室名称
		aptDTO.setSrvCode(entDto.getSrvCode());// 号别编码
		aptDTO.setSrvName(entDto.getSrvName());// 号别名称
		aptDTO.setResCode(entDto.getResCode());// 医生编码
		aptDTO.setResName(entDto.getResName());// 医生名称
		aptDTO.setEntTime(entDto.getEntTime());// 挂号日期
		aptDTO.setOprTime(entDto.getOprTime());// 操作日期
		aptDTO.setDayslottp(entDto.getDayslottp());// 午别编码
		aptDTO.setDayslotName(entDto.getDayslotname());// 午别名称
		aptDTO.setSeqNo(entDto.getSeqNo());// 挂号顺序号
		aptDTO.setPaymodeno(entDto.getPaymodeno());// 支付订单号
		aptDTO.setBankno(entDto.getBankno());// 支付账户
		aptDTO.setPmCode(entDto.getPmCode());// 支付方式编码
		aptDTO.setAptno(entDto.getAptno());// 预约号
		aptDTO.setFeeStatus(entDto.getFeeStatus());// 费用状态
		aptDTO.setStatus(entDto.getStatus());// 状态
		aptDTO.setAmtPat(entDto.getAmtPat()==null?0: Float.parseFloat(entDto.getAmtPat().toString()));// 患者支付金额
		aptDTO.setAptCode(entDto.getAptCode());// 预约编码
		aptDTO.setAddress(entDto.getAddress());
		aptDTO.setAmt(entDto.getAmt() ==null?0: Float.parseFloat(entDto.getAmt().toString()) );// 总费用
		aptDTO.setTimesOp(entDto.getTimesOp());
		aptDTO.setMobile(entDto.getMobile());
		aptDTO.setId_ent(entDto.getId_ent());
		aptDTO.setAptChl(!EnValidator.isEmpty(entDto.getAptChl()) ? entDto.getAptChl() : entDto.getEu_regtp());
		aptDTO.setEntpCode(entDto.getEntpCode());
		aptDTO.setEntpName(entDto.getEntpName());
		aptDTO.setChlTypeName(!EnValidator.isEmpty(entDto.getAptChl()) ? entDto.getAptChl() : this.setRegChlName(entDto));
		aptDTO.setAmtRatio(aptDTO.getAmt()); //折扣金额，fanlq -add
		aptDTO.setT_b_tick(entDto.getT_b_tick());
		aptDTO.setT_e_tick(entDto.getT_e_tick());
		return aptDTO;
	}
	
	/***
	 * 设置挂号渠道名称，fanlq-2018-12-25
	 * @param entDto
	 * @return
	 */
	private String setRegChlName(OpEntListDTO entDto){
		Map<Object, EnumDescription> regTpMap = EnumDescUtil.getValue_EnumDescriptionMap(EuRegTp.class); 
		if(entDto.getEu_regtp() != null && regTpMap != null && regTpMap.get(entDto.getEu_regtp()) != null){
			return regTpMap.get(entDto.getEu_regtp()).getName();
		}else{
			return null;
		}
	}
}


