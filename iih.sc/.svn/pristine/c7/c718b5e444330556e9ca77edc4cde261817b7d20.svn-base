package iih.sc.sch.s.bp.oral;

import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 获取口腔排班信息，含号位、渠道
 * 
 * @author
 *
 */
public class GetOralSchDetailBP {
	/**
	 * 获取口腔排班信息，含号位、渠道信息
	 * 
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	public SchOralInfoDTO exec(String schId) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("schId", schId);

		// 2、排班渠道和号位信息DTO
		SchOralInfoDTO infoDTO = new SchOralInfoDTO();
		infoDTO.setId_sch(schId);
		ScSchDO schDO = new SchEP().getById(schId);
		if (null != schDO) {
			infoDTO.setScpolcn(schDO.getScpolcn());
		}

		String where = String.format("id_sch = '%s'", schId);
		String whereStr = "id_sch = ?";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(schId);
		// 3、查询排班号位数据
		ScSchTickDO[] schTickDOs = this.getSchTickByCond(whereStr, param);

		// 4、查询排班渠道数据
		ScSchChlDO[] schChlDOs = this.getSchChlByCond(where);

		// 5、处理排班渠道数据
		this.processSchChl(infoDTO, schChlDOs);

		// 6、处理排班号位数据
		this.processSchTick(infoDTO, schTickDOs);

		return infoDTO;
	}

	/**
	 * 根据条件获取排班号位
	 *
	 * @param where 查询条件
	 * @return 排班号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchTickDO[] getSchTickByCond(String where, SqlParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		return new OralSchEP().getSchTickByCond(where, "queno", param);
	}

	/**
	 * 根据条件获取排班渠道
	 *
	 * @param where 查询条件
	 * @return 排班渠道DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchChlDO[] getSchChlByCond(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		return new OralSchEP().getSchChlByCond(where, "scpolcn");
	}

	/**
	 * 处理排班号位数据
	 *
	 * @param infoDTO 口腔科排班信息DTO
	 * @param schTickMap 排班号位Map
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void processSchTick(SchOralInfoDTO infoDTO, ScSchTickDO[] schTickDOs)
			throws BizException {
		if (infoDTO == null || ArrayUtil.isEmpty(schTickDOs)) {
			return;
		}
		FArrayList schTickFArray = new FArrayList();
		for (ScSchTickDO tickDO : schTickDOs) {
			schTickFArray.add(tickDO);
		}
		infoDTO.setSch_tick_list(schTickFArray);
	}

	/**
	 * 处理排班渠道数据
	 *
	 * @param infoDTO 口腔科排班信息DTO
	 * @param schChlkMap 排班渠道Map
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void processSchChl(SchOralInfoDTO infoDTO, ScSchChlDO[] schChlDOs) throws BizException {
		if (infoDTO == null || ArrayUtil.isEmpty(schChlDOs)) {
			return;
		}
		FArrayList schChlFArray = new FArrayList();
		for (ScSchChlDO chlDO : schChlDOs) {
			schChlFArray.add(chlDO);
		}
		infoDTO.setSch_chl_list(schChlFArray);
	}
}
