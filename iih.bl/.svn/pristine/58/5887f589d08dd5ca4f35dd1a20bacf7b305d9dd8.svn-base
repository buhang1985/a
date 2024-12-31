package iih.bl.cg.s.bp.ip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.cg.d.BlIpFeeDTO;
import iih.bl.cg.d.BlRefundDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.IBlConst;
import iih.bl.pay.dto.d.PrePaidAccAmtDTO;
import iih.bl.pay.i.IBlPayOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 住院补退费保存
 * @author ly 2018/08/18
 *
 */
public class BlIpSaveCompensationBP {

	/**
	 * 住院补退费保存
	 * @param entId 就诊id
	 * @param ipFeeDtos 费用明细
	 * @return
	 * @throws BizException
	 */
	public void exec(BlIpFeeDTO[] ipFeeDtos) throws BizException {
	
		this.validate(ipFeeDtos);
		
		List<BlIpFeeDTO> addFeeList = new ArrayList<BlIpFeeDTO>();
		List<BlIpFeeDTO> refundFeeList = new ArrayList<BlIpFeeDTO>();
		
		for (BlIpFeeDTO feeDto : ipFeeDtos) {
			
			if(feeDto.getQuan_mend() != null && feeDto.getQuan_mend().compareTo(FDouble.ZERO_DBL) > 0){
				addFeeList.add(feeDto);
			}
			
			if(feeDto.getQuan_will_ret() != null && feeDto.getQuan_will_ret().compareTo(FDouble.ZERO_DBL) > 0){
				refundFeeList.add(feeDto);
			}
		}
		
		if(addFeeList.size() != 0){
			this.addFee(addFeeList);
		}
		
		if(refundFeeList.size() != 0){
			this.RefundFee(refundFeeList);
		}
	}
	
	/**
	 * 入参校验
	 */
	private void validate(BlIpFeeDTO[] ipFeeDtos) throws BizException {
		
		if(ArrayUtil.isEmpty(ipFeeDtos)){
			throw new ArgumentNullException("住院补退费保存", "费用明细");
		}
		if(IsCancle(new String[]{ipFeeDtos[0].getId_ent()})){
			throw new BizException("住院补退费:患者已退诊疗或取消入科");
		}
		FDouble amt=FDouble.ZERO_DBL;
		
		//校验退数据完备性
		HashSet<String> idCgIps = new HashSet<>();//退费的记账id
		for (BlIpFeeDTO feeDto : ipFeeDtos) {			
			if(feeDto.getQuan_will_ret() != null && feeDto.getQuan_will_ret().
					compareTo(FDouble.ZERO_DBL) > 0){
				
				if(feeDto.getRefundlist() == null || feeDto.getRefundlist().size() == 0){
					throw new BizException("住院补退费保存:退费数据退费明细为空");
				}
				
				for(Object obj : feeDto.getRefundlist()){
					BlRefundDTO refundDto = (BlRefundDTO) obj;
					if(refundDto != null){
						if(refundDto.getQuan_will_ret() != null && refundDto.getQuan_will_ret().doubleValue() > 0){
							idCgIps.add(refundDto.getId_cgip());
						}
					}					
				}
			}
			
			if(feeDto.getQuan_mend() != null && feeDto.getQuan_mend().compareTo(FDouble.ZERO_DBL) > 0){
				amt=amt.add(feeDto.getPrice_ratio().multiply(feeDto.getQuan_mend()));
			}
			
			if(feeDto.getQuan_will_ret() != null && feeDto.getQuan_will_ret().compareTo(FDouble.ZERO_DBL) > 0){
				amt.sub(feeDto.getPrice_ratio().multiply(feeDto.getQuan_will_ret()));
			}
			
		}
		if(idCgIps.size() > 0 && IsSt(idCgIps)){
			throw new BizException("住院补退费保存:已结算数据不能退费,请刷新");
		}
		//预交金余额校验
		if(amt.compareTo(FDouble.ZERO_DBL)>0){
			
			IBlPayOutQryService payService=ServiceFinder.find(IBlPayOutQryService.class);
			PrePaidAccAmtDTO[] paidDto= payService.getAccJugeIpByentIds(new String[]{ipFeeDtos[0].getId_ent()});
			if(!ArrayUtil.isEmpty(paidDto) && FBoolean.TRUE.equals(paidDto[0].getFg_arrears())&& "3".equals(paidDto[0].getSd_arslv())){
				throw new BizException("住院补退费保存:该患者已欠费，不允许补费");
			}
		}
	}

	/**
	 * 保存补费
	 * @param addFeeList
	 * @throws BizException
	 */
	private void addFee(List<BlIpFeeDTO> addFeeList) throws BizException {
		
		List<BlCgAccountDTO> accountDTOList = new ArrayList<BlCgAccountDTO>();
		for (BlIpFeeDTO feeDto : addFeeList) {
			BlCgAccountDTO accountDTO = new BlCgAccountDTO();
			accountDTO.setId_ent(feeDto.getId_ent());
			accountDTO.setId_pat(feeDto.getId_pat());
			accountDTO.setId_or(feeDto.getId_or());
			
			accountDTO.setId_srv(feeDto.getId_srv());
			accountDTO.setId_mm(feeDto.getId_mm());
			accountDTO.setFg_mm(feeDto.getFg_mm());
			if(feeDto.getFg_mm()!=null && feeDto.getFg_mm().isValue()){
				accountDTO.setId_pkgu_cur(feeDto.getId_srvu());
			}else {
				accountDTO.setId_unit_srv(feeDto.getId_srvu());
			}
			accountDTO.setQuan(feeDto.getQuan_mend().abs());
			accountDTO.setEu_direct(IBlConst.BL_CHARGES);
			accountDTO.setId_dep_mp(feeDto.getId_dep_mp());
			accountDTO.setId_dep_or(feeDto.getId_dep_or());
			accountDTO.setPrice_ratio(feeDto.getPrice());
			accountDTOList.add(accountDTO);
		}
		
		BlCgAccountSetDTO setDto = new BlCgAccountSetDTO();
		setDto.setSrcfunc_des(IBlCgFuncConst.FUNC_IPBL_COLLECTOR_ADDREFUNDCOST);
		setDto.setFg_addfee(FBoolean.TRUE);
		
		IBlCgAccountService cgAccountService = ServiceFinder.find(IBlCgAccountService.class);
		cgAccountService.keepAccountForIp(accountDTOList.toArray(new BlCgAccountDTO[0]), setDto);
	}
	
	/**
	 * 退补费
	 * @param refundFeeList
	 * @throws BizException
	 */
	private void RefundFee(List<BlIpFeeDTO> refundFeeList) throws BizException {
		
		List<BlCgRefundAccountDTO> accDtoList = new ArrayList<BlCgRefundAccountDTO>();
		
		for (BlIpFeeDTO feeDto : refundFeeList) {
			
			for (int i = 0; i < feeDto.getRefundlist().size(); i++) {
				
				BlRefundDTO rfdFeeDto = (BlRefundDTO)feeDto.getRefundlist().get(i);
				if(rfdFeeDto.getQuan_will_ret() != null && 
						rfdFeeDto.getQuan_will_ret().compareTo(FDouble.ZERO_DBL) > 0){
					
					BlCgRefundAccountDTO accDto = new BlCgRefundAccountDTO();
					accDto.setId_ent(feeDto.getId_ent());
					accDto.setId_cg(rfdFeeDto.getId_cgip());
					accDto.setQuan(rfdFeeDto.getQuan_will_ret());
					accDtoList.add(accDto);
				}
			}
		}
		
		BlCgRefundAccountSetDTO setDto = new BlCgRefundAccountSetDTO();
		setDto.setSrcfunc_des(IBlCgFuncConst.FUNC_IPBL_COLLECTOR_ADDREFUNDCOST);
		setDto.setEu_rfdmode(RefundModeEnum.CG_KEY);
		
		IBlCgAccountService cgAccountService = ServiceFinder.find(IBlCgAccountService.class);
		cgAccountService.refundAccountForIp(accDtoList.toArray(new BlCgRefundAccountDTO[0]), setDto);
	}
	
	/**
	 * 判断是否已经取消入科或退诊
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private boolean IsCancle(String [] id_ent) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(entip.id_inpatient) from en_ent ent ");
		sb.append(" join en_ent_ip entip on entip.id_ent = ent.id_ent ");
		sb.append(" where ent.id_ent in ( ");
		boolean isDouHao = false;
		for(String idEnt : id_ent){
			if(isDouHao){
				sb.append(" , ");
			}
			isDouHao = true;
			sb.append("'").append(idEnt).append("'");
		}
		sb.append(") and (entip.sd_status = 22 or ent.fg_canc = 'Y') ");
		DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
		Integer num = (Integer) daf.execQuery(sb.toString(), new ColumnHandler());
		if(num != null && num > 0){
			return true;
		}
        return false;
	}
	
	/**
	 * 判断住院记账明细是否已经结算
	 * @author : hanjq 2019年7月24日 上午10:17:03
	 * @param idCgIps
	 * @return
	 * @throws DAException 
	 */
	private boolean IsSt(HashSet<String> idCgIps) throws DAException{
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(id_cgip) from bl_cg_ip ");
		sb.append(" where id_cgip in ( ");
		boolean isDouHao = false;
		for(String idCgIp : idCgIps){
			if(isDouHao){
				sb.append(" , ");
			}
			isDouHao = true;
			sb.append("'").append(idCgIp).append("'");
		}
		sb.append(") and fg_st ='Y' ");
		DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
		Integer num = (Integer) daf.execQuery(sb.toString(), new ColumnHandler());
		if(num != null && num > 0){
			return true;
		}
		return false;
	}
}
