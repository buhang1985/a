package iih.sc.sch.s.bp;

import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.ep.OralSchEP;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;

/**
 * 删除口腔科排班BP
 * 
 * @author zhengcm
 * @date 2016-09-14 20:44:17
 *
 */
public class DeleteOralSchBP {

	/**
	 * 删除口腔科排班
	 *
	 * @param schDTOList
	 *            口腔科排班信息DTO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(List<SchOralInfoDTO> schDTOList) throws BizException {
		if (ListUtil.isEmpty(schDTOList)) {
			return;
		}
		// 排班主键列表
		List<String> schIds = new ArrayList<String>();

		// 1、获取排班主键
		schIds = this.getSchIds(schDTOList);
		if (ListUtil.isEmpty(schIds)) {
			return;
		}

		// 2、校验排班是否被使用
		new DeleteSchValidateBP().validate(schIds);

		// 3、删除排班号位
		this.deleteSchTick(schIds);

		// 4、删除排班渠道
		this.deleteSchChl(schIds);

		// 5、删除排班
		this.deleteSch(schIds);
	}

	/**
	 * 获取排班主键列表
	 *
	 * @param schDTOList
	 *            口腔科排班信息DTO列表
	 * @return 排班主键列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getSchIds(List<SchOralInfoDTO> schDTOList) throws BizException {
		List<String> schIds = new ArrayList<String>();
		for (SchOralInfoDTO schDTO : schDTOList) {
			schIds.add(schDTO.getId_sch());
		}
		return schIds;
	}

	/**
	 * 删除排班号位
	 *
	 * @param schIds
	 *            排班id列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void deleteSchTick(List<String> schIds) throws BizException {
		if (ListUtil.isEmpty(schIds)) {
			return;
		}
		String where = ScSqlUtils.getInSqlByIds("id_sch", schIds);
		new OralSchEP().deleteSchTickByCond(where);
	}

	/**
	 * 删除排班渠道
	 *
	 * @param schIds
	 *            排班id列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void deleteSchChl(List<String> schIds) throws BizException {
		if (ListUtil.isEmpty(schIds)) {
			return;
		}
		String where = ScSqlUtils.getInSqlByIds("id_sch", schIds);
		new OralSchEP().deleteSchChlByCond(where);
	}

	/**
	 * 删除排班
	 *
	 * @param schIds
	 *            排班id列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void deleteSch(List<String> schIds) throws BizException {
		if (ListUtil.isEmpty(schIds)) {
			return;
		}
		String where = ScSqlUtils.getInSqlByIds("id_sch", schIds);
		new OralSchEP().deleteSchByCond(where);
	}

}
