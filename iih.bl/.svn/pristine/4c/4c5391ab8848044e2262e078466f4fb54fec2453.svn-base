package iih.bl.cg.s.bp.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊按医嘱销账
 * 
 * @author wq.li
 *
 */
public class RefundForOpIdOrsBP {

	/**
	 * 门诊预付费销账
	 * 
	 * @param entId
	 *            就诊id
	 * @param empId
	 *            记账人员id
	 * @param ordIds
	 *            需销账医嘱id
	 * @return
	 * @throws BizException
	 * @author wq.li 2018年12月21日
	 */
	public void exec(String entId, String empId, String[] ordIds) throws BizException {

		// 入参校验
		if (StringUtil.isEmpty(entId)) {
			throw new BizException("【entId】就诊信息不能为空");
		}

		if (StringUtil.isEmpty(empId)) {
			throw new BizException("【empId】记账人员不能为空");
		}

		if (ArrayUtil.isEmpty(ordIds)) {
			throw new BizException("【ordIds】 医嘱信息不能为空");
		}

		// 查询需要销账的记账信息
		BlCgItmOepDO[] cgArr=this.findCgitmInfo(entId, ordIds);
		
		//可退性校验
		this.checkRefund(cgArr, ordIds);
		
		//组装入参数据
		BlCgRefundAccountSetDTO setDto = new BlCgRefundAccountSetDTO();
		setDto.setId_dep_cg(empId);
		setDto.setEu_rfdmode(RefundModeEnum.CG_KEY);
		
		List<BlCgRefundAccountDTO> cgList=new ArrayList<>();
		
		for (BlCgItmOepDO cgDo : cgArr) {
			BlCgRefundAccountDTO refundDto=new BlCgRefundAccountDTO();
			refundDto.setId_pat(cgDo.getId_pat());
			refundDto.setId_ent(cgDo.getId_ent());
			refundDto.setId_cg(cgDo.getId_cgitmoep());
			refundDto.setQuan(cgDo.getQuan());
			cgList.add(refundDto);
		}
		
		// 调用销账接口
		IBlCgAccountService cgAccountService = ServiceFinder.find(IBlCgAccountService.class);
		cgAccountService.refundAccountForOp(cgList.toArray(new BlCgRefundAccountDTO[0]), setDto);
	}

	/**
	 * 可退性校验
	 * @param cgArr
	 * @throws BizException 
	 */
	private void checkRefund(BlCgItmOepDO[] cgArr,String[] orIds) throws BizException {

		if(ArrayUtil.isEmpty(cgArr)){
			throw new BizException("未查询到可以销账的记账数据数据");
		}
		
		Map<String, BlCgItmOepDO> orMap=new HashMap<>();
		
		for (BlCgItmOepDO cgDo : cgArr) {
			if(FBoolean.TRUE.equals(cgDo.getFg_st())){
				throw new BizException("【"+cgDo.getName_srv()+"】已经结算费");
			}
			
			if(!orMap.containsKey(cgDo.getId_or())){
				orMap.put(cgDo.getId_or(), cgDo);
			}
		}
		
		if(orMap.size()==orIds.length){
			return;
		}
		
		for (String orId : orIds) {
			if(!orMap.containsKey(orId)){
				throw new BizException("医嘱【"+orId+"】未查询到可退数据");
			}
		}
		
	}

	/**
	 * 查询记账信息
	 * 
	 * @param entId
	 * @param ordIds
	 * @return
	 * @throws BizException 
	 */
	private BlCgItmOepDO[] findCgitmInfo(String entId, String[] ordIds) throws BizException {
		StringBuilder sqlCg = new StringBuilder();
		sqlCg.append(" SELECT ");
		sqlCg.append(" OEP.id_pat, ");
		sqlCg.append(" OEP.id_ent, ");
		sqlCg.append(" OEP.id_or, ");
		sqlCg.append(" OEP.id_cgitmoep , ");
		sqlCg.append(" OEP.quan, ");
		sqlCg.append(" CG.eu_direct, ");
		sqlCg.append(" OEP.fg_st, ");
		sqlCg.append(" OEP.fg_refund ");
		sqlCg.append(" FROM BL_CG_ITM_OEP OEP ");
		sqlCg.append(" INNER JOIN BL_CG_OEP CG on OEP.id_cgoep=CG.id_cgoep ");
		sqlCg.append(" where OEP.fg_refund='N' ");
		sqlCg.append(" and CG.eu_direct=1 ");
		//sqlCg.append(" and OEP.fg_st='N'");
		sqlCg.append(" and OEP.id_ent = ? ");
		sqlCg.append(" and OEP.fg_hpcg='N'"); // 需要排除高端商保
		SqlParam param = new SqlParam();
		param.addParam(entId);
		if (!ArrayUtil.isEmpty(ordIds)) {
			sqlCg.append(" and " + SqlUtils.getInSqlByBigIds("OEP.ID_OR", ordIds));
		}
		sqlCg.append(" and OEP.fg_acc='Y'");

		List<BlCgItmOepDO> list = (List<BlCgItmOepDO>) new DAFacade().execQuery(sqlCg.toString(), param,
				new BeanListHandler(BlCgItmOepDO.class));
		
		return list.toArray(new BlCgItmOepDO[0]);
	}
}
