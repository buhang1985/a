package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.itf.pe.IBlPeChargeService;
import iih.bl.params.BlParams;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundDTO;
import iih.bl.st.dto.refundcheck.d.RefundCheckDTO;
import iih.pe.papi.i.his.IChargeService;
import iih.pe.papt.dto.peitfrefunddto.d.PeItfRefundDTO;
import iih.pe.papt.dto.peitfsvrsdto.d.PeItfSvrsDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取体检记账明细
 * 
 * @author wq.li
 *
 */
public class FindOepCgItmByStIdBP {
	/**
	 * 查询记账明细
	 * 
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public BlOepRefundDTO[] exec(String stId) throws BizException {

		if (StringUtil.isEmpty(stId)) {
			return null;
		}

		// 1.查询记账信息
		StringBuilder sql = new StringBuilder();

		sql.append(" select ");
		sql.append(" pat.id_pat, ");
		sql.append(" pat.code Code_pat, ");
		sql.append(" cgoep.id_cgoep,");
		//添加code_srv  zx  2018年12月31日
		sql.append(" cgitm.code_srv,");
		sql.append(" stoep.id_stoep,");
		sql.append(" cgitm.id_pres,");
		sql.append(" cgitm.id_cgitmoep,");
		sql.append(" cgitm.id_or,");
		sql.append(" cgitm.srvu,");
		sql.append(" measdoc.name srvu_name,");
		sql.append(" cgitm.sd_srvtp,");
		sql.append(" cgitm.name_srv,");
		sql.append(" cgitm.id_srv,");
		sql.append(" 'N'can_return,");
		sql.append(" cgitm.amt,");
		sql.append(" cgitm.amt_std,");
		sql.append(" cgitm.amt_pat,");
		sql.append(" cgitm.amt_ratio,");
		sql.append(" cgitm.amt_hp,");
		sql.append(" cgitm.quan ,");
		sql.append(" 0 can_quan,");
		sql.append(" cgitm.price,");
		sql.append(" cgitm.price_ratio,");
		sql.append(" cgitm.id_ent,");
		sql.append(" cgitm.id_pat,");
		sql.append(" cgitm.fg_free,");
		sql.append(" cgitm.pecode,");
		sql.append(" 'Y' fg_pe,");
		sql.append("  pay.id_emp_pay ");
		sql.append("  from bl_cg_oep cgoep");
		sql.append(" inner join bl_cg_itm_oep cgitm on cgoep.id_cgoep=cgitm.id_cgoep");
		sql.append(" inner join bl_st_oep stoep on stoep.id_stoep=cgitm.id_stoep");
		sql.append(" inner join bl_pay_pat_oep pay on pay.id_paypatoep = stoep.id_paypatoep ");
		sql.append(" left join bd_measdoc measdoc on measdoc.id_measdoc=cgitm.srvu");
		sql.append(" inner join pi_pat pat on cgitm.id_pat=pat.id_pat ");
		sql.append(" where stoep.pecode is not null and stoep.id_stoep=?   ");

		SqlParam param = new SqlParam();
		param.addParam(stId);

		List<BlOepRefundDTO> list = (List<BlOepRefundDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(BlOepRefundDTO.class));

		FBoolean isCustom = BlParams.BLITF0002();

		BlOepRefundDTO[] refundDtoArr = null;

		if (FBoolean.TRUE.equals(isCustom)) {
			// 走第三方校验TODO暂缺
			refundDtoArr = this.customValidate(list.toArray(new BlOepRefundDTO[0]));
		} else {
			// 系统体检模块进行校验
			for (BlOepRefundDTO blOepRefundDTO : list) {
				String id_or = blOepRefundDTO.getId_or();
				// 1.查询体检项目名称
				StringBuilder sqlPe = new StringBuilder();

				sqlPe.append(" select ");
				sqlPe.append(" catlog.name ");
				sqlPe.append("  from pe_itm_pesrvbcatlog catlog");
				sqlPe.append(" inner join pe_apt_pepsnapptcat cat on catlog.id_pesrvbcatlog=cat.id_pesrvcatlog");
				sqlPe.append(" where id_pepsnapptcat=?");
				
				SqlParam paramPeOr = new SqlParam();
				paramPeOr.addParam(id_or);

				@SuppressWarnings("unchecked")
				List<String> listPeOr = (List<String>) new DAFacade().execQuery(sqlPe.toString(), paramPeOr,new ColumnListHandler());
				if(listPeOr.size()>0){
					blOepRefundDTO.setName_or(listPeOr.get(0));
				}
			}
			
			refundDtoArr = this.validateReturn(list.toArray(new BlOepRefundDTO[0]));
		}

		return refundDtoArr;
	}

	/**
	 * 第三方可退性校验
	 * 
	 * @param cgDos
	 * @throws BizException
	 */
	private BlOepRefundDTO[] customValidate(BlOepRefundDTO[] refundDtoArr) throws BizException {
		if (ArrayUtil.isEmpty(refundDtoArr)) {
			return null;
		}

		List<RefundCheckDTO> checkList = new ArrayList<>();
		for (BlOepRefundDTO blCgItmOepDO : refundDtoArr) {
			RefundCheckDTO checkDto = new RefundCheckDTO();
			checkDto.setPatcode(blCgItmOepDO.getCode_pat());
			checkDto.setPecode(blCgItmOepDO.getPecode());
			checkDto.setSrvcode(blCgItmOepDO.getCode_srv());
			checkList.add(checkDto);
		}

		// 调用第三方可退校验接口
		IBlPeChargeService chArgeService = ServiceFinder.find(IBlPeChargeService.class);

		RefundCheckDTO[] checkArr = chArgeService.peRefundCheck(checkList.toArray(new RefundCheckDTO[0]));

		if (ArrayUtil.isEmpty(checkArr)) {
			throw new BizException("体检结果未返回校验结果");
		}

		Map<String, RefundCheckDTO> rtnMap = new HashMap<>();
		for (RefundCheckDTO peItfRefundDTO : checkArr) {
			rtnMap.put(peItfRefundDTO.getPecode() + peItfRefundDTO.getSrvcode(), peItfRefundDTO);
		}
		// 查看记账明细的可退状态
		for (BlOepRefundDTO cgDto : refundDtoArr) {
			RefundCheckDTO rtnDTO = rtnMap.get(cgDto.getPecode() + cgDto.getCode_srv());
			if (rtnDTO == null) {
				throw new BizException("体检未返回【" + cgDto.getName_srv() + "】的可退状态");
			}

			cgDto.setCan_return(rtnDTO.getFg_canrefund());
		}
		return refundDtoArr;
	}

	/**
	 * 体检获取可退状态
	 * 
	 * @param refundDtoArr
	 * @return
	 * @throws BizException
	 */
	private BlOepRefundDTO[] validateReturn(BlOepRefundDTO[] refundDtoArr) throws BizException {

		if (ArrayUtil.isEmpty(refundDtoArr)) {
			return null;
		}

		List<PeItfSvrsDTO> pesrvList = new ArrayList<>();
		for (BlOepRefundDTO blCgItmOepDO : refundDtoArr) {
			PeItfSvrsDTO dto = new PeItfSvrsDTO();
			dto.setId_pepsnappt(blCgItmOepDO.getPecode());
			dto.setId_srv(blCgItmOepDO.getId_srv());
			pesrvList.add(dto);
		}

		// 调用体检可退校验接口
		IChargeService peService = ServiceFinder.find(IChargeService.class);
		PeItfRefundDTO[] retDtoArr = peService.peRefund(pesrvList.toArray(new PeItfSvrsDTO[0]));

		if (ArrayUtil.isEmpty(retDtoArr)) {
			throw new BizException("体检结果未返回校验结果");
		}

		Map<String, PeItfRefundDTO> rtnMap = new HashMap<>();
		for (PeItfRefundDTO peItfRefundDTO : retDtoArr) {
			rtnMap.put(peItfRefundDTO.getId_pepsnappt() + peItfRefundDTO.getId_srv(), peItfRefundDTO);
		}
		// 查看记账明细的可退状态
		for (BlOepRefundDTO cgDto : refundDtoArr) {
			PeItfRefundDTO rtnDTO = rtnMap.get(cgDto.getPecode() + cgDto.getId_srv());
			if (rtnDTO == null) {
				throw new BizException("体检未返回【" + cgDto.getName_srv() + "】的可退状态");
			}

			cgDto.setCan_return(rtnDTO.getFg_refund());
		}
		return refundDtoArr;
	}
}
