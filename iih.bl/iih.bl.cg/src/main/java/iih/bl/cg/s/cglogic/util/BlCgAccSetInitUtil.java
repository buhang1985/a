package iih.bl.cg.s.cglogic.util;

import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.BlMethodUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 记账配置初始化工具类
 * @author ly 2018/06/24
 *
 */
public class BlCgAccSetInitUtil {

	/**
	 * 初始化参数
	 * @param setDto
	 * @return
	 * @throws BizException
	 */
	public static BlCgAccountSetDTO init(BlCgAccountSetDTO setDto) throws BizException{
		
		BlCgAccountSetDTO accSet = setDto;
		if (accSet == null) {
			accSet = new BlCgAccountSetDTO();
		}

		if (StringUtil.isEmpty(accSet.getId_emp_cg())) {
			accSet.setId_emp_cg(Context.get().getStuffId());
		}

		if (StringUtil.isEmpty(accSet.getId_org_cg())) {
			accSet.setId_org_cg(Context.get().getOrgId());
		}

		if (StringUtil.isEmpty(accSet.getId_dep_cg())) {
			accSet.setId_dep_cg(Context.get().getDeptId());
		}

		if (accSet.getDt_cg() == null) {
			accSet.setDt_cg(BlFlowContextUtil.getNowTime());
		}

		if (accSet.getFg_price_cal() == null) {
			// 默认计算费用
			accSet.setFg_price_cal(FBoolean.TRUE);
		}

		if (accSet.getFg_singlepat() == null) {
			// 默认非单患者
			accSet.setFg_singlepat(FBoolean.FALSE);
		}

		if (accSet.getFg_postpaid() == null) {
			// 默认支持后付费
			accSet.setFg_postpaid(FBoolean.TRUE);
		}

		if (accSet.getFg_exception() == null) {
			// 默认抛异常
			accSet.setFg_exception(FBoolean.TRUE);
		}

		if (FBoolean.TRUE.equals(accSet.getFg_singlepat())) {
			// 单患者模式不抛异常
			accSet.setFg_exception(FBoolean.FALSE);
		}

		if (accSet.getFg_addfee() == null) {
			// 默认非补费
			accSet.setFg_addfee(FBoolean.FALSE);
		}

		if (StringUtil.isEmpty(accSet.getSrcfunc_des())) {
			accSet.setSrcfunc_des(BlMethodUtil.findFirstCallPoint(null));
		}

		if (accSet.getEu_srctp() == null) {
			// 默认来源医嘱
			accSet.setEu_srctp(FeeOriginEnum.ORDERS_FEE);
		}
		
		return accSet;
	}

	/**
	 * 初始化参数(门诊配置)
	 * @param setDto
	 * @return
	 * @throws BizException
	 */
	public static BlCgOpAccountSetDTO init(BlCgOpAccountSetDTO setDto) throws BizException{
		
		BlCgOpAccountSetDTO accSet = setDto;
		if (accSet == null) {
			accSet = new BlCgOpAccountSetDTO();
		}

		if (StringUtil.isEmpty(accSet.getId_emp_cg())) {
			accSet.setId_emp_cg(Context.get().getStuffId());
		}

		if (StringUtil.isEmpty(accSet.getId_org_cg())) {
			accSet.setId_org_cg(Context.get().getOrgId());
		}

		if (StringUtil.isEmpty(accSet.getId_dep_cg())) {
			accSet.setId_dep_cg(Context.get().getDeptId());
		}

		if (accSet.getDt_cg() == null) {
			accSet.setDt_cg(BlFlowContextUtil.getNowTime());
		}

		if (accSet.getFg_price_cal() == null) {
			// 默认计算费用
			accSet.setFg_price_cal(FBoolean.TRUE);
		}

		if (accSet.getFg_exception() == null) {
			// 默认抛异常
			accSet.setFg_exception(FBoolean.TRUE);
		}

		if (accSet.getFg_addfee() == null) {
			// 默认非补费
			accSet.setFg_addfee(FBoolean.FALSE);
		}

		if(accSet.getFg_updateor() == null){
			// 默认更新
			accSet.setFg_updateor(FBoolean.TRUE);
		}
		
		if(accSet.getFg_reserve() == null){
			// 默认预留
			accSet.setFg_reserve(FBoolean.TRUE);
		}
		
		if (StringUtil.isEmpty(accSet.getSrcfunc_des())) {
			accSet.setSrcfunc_des(BlMethodUtil.findFirstCallPoint(null));
		}

		if (accSet.getEu_srctp() == null) {
			// 默认来源医嘱
			accSet.setEu_srctp(FeeOriginEnum.ORDERS_FEE);
		}
		
		if(accSet.getFg_pricing() == null) {
			accSet.setFg_pricing(FBoolean.FALSE);
		}
		
		return accSet;
	}
	
	/**
	 * 初始化退记账参数
	 * @param setDto
	 * @return
	 * @throws BizException
	 */
 	public static BlCgRefundAccountSetDTO initRfd(BlCgRefundAccountSetDTO setDto)throws BizException{
		
		BlCgRefundAccountSetDTO accSet = setDto;
		if (accSet == null) {
			accSet = new BlCgRefundAccountSetDTO();
		}
		
		if (StringUtil.isEmpty(accSet.getId_emp_cg())) {
			accSet.setId_emp_cg(Context.get().getStuffId());
		}

		if (StringUtil.isEmpty(accSet.getId_org_cg())) {
			accSet.setId_org_cg(Context.get().getOrgId());
		}

		if (StringUtil.isEmpty(accSet.getId_dep_cg())) {
			accSet.setId_dep_cg(Context.get().getDeptId());
		}

		if (accSet.getDt_cg() == null) {
			accSet.setDt_cg(BlFlowContextUtil.getNowTime());
		}
		
		if (accSet.getFg_singlepat() == null) {
			// 默认非单患者
			accSet.setFg_singlepat(FBoolean.FALSE);
		}
		
		if (accSet.getFg_exception() == null) {
			// 默认抛异常
			accSet.setFg_exception(FBoolean.TRUE);
		}

		if (FBoolean.TRUE.equals(accSet.getFg_singlepat())) {
			// 单患者模式不抛异常
			accSet.setFg_exception(FBoolean.FALSE);
		}
		
		if(accSet.getFg_updateor() == null){
			// 默认更新医嘱状态
			accSet.setFg_updateor(FBoolean.TRUE);
		}
		
		if (StringUtil.isEmpty(accSet.getSrcfunc_des())) {
			accSet.setSrcfunc_des(BlMethodUtil.findFirstCallPoint(null));
		}
		
		return accSet;
	}

	/**
	 * 住院配置转门诊配置
	 * @param setDto
	 * @return
	 * @throws BizException
	 */
	public static BlCgOpAccountSetDTO convertToOpSet(BlCgAccountSetDTO setDto) throws BizException{
		
		BlCgOpAccountSetDTO opSetDto = new BlCgOpAccountSetDTO();
		opSetDto.setId_emp_cg(setDto.getId_emp_cg());
		opSetDto.setId_org_cg(setDto.getId_org_cg());
		opSetDto.setId_dep_cg(setDto.getId_dep_cg());
		opSetDto.setDt_cg(setDto.getDt_cg());
		opSetDto.setFg_price_cal(setDto.getFg_price_cal());
		opSetDto.setFg_reserve(FBoolean.FALSE);
		opSetDto.setFg_addfee(setDto.getFg_addfee());
		opSetDto.setFg_updateor(FBoolean.TRUE);
		opSetDto.setSrcfunc_des(setDto.getSrcfunc_des());
		opSetDto.setEu_srctp(FeeOriginEnum.ORDERS_FEE);
		//opSetDto.setEu_oepcgmode(OepCgModeEnum.ARREARS_CG);
		opSetDto.setEu_oepcgmode(OepCgModeEnum.PREPAY_CG);
		opSetDto.setFg_postpaid(setDto.getFg_postpaid());
		return opSetDto;
	}
}
