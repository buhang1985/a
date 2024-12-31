package iih.ci.mr.cimrvs.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.mr.cimrvs.d.CimrvsAggDO;
import iih.ci.mr.cimrvs.qry.GetUnDeleteVsInfoSql;
import iih.mp.nr.vitalsigns.dto.d.VitalSignsDataDTO;
import iih.nmr.common.i.INmrMaintainService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 体征事件删除校验
 * 
 * @author xuxing_2017年12月7日17:52:52
 *
 */
public class MrVsDeleteRuleBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @throws BizException
	 */
	public void exec(CimrvsAggDO[] params) throws BizException {

		// 1、基础校验
		if (!validation(params)) {
			return;
		}

		// 2、查询异常数据
		VitalSignsDataDTO[] vs = querySysData(params);

		// 3、组装异常信息
		String errMsg = packageMesg(vs);

		// 4、抛出异常
		if (!StringUtil.isEmptyWithTrim(errMsg)) {
			throw new BizException(errMsg);
		}

		// 5、手动处理文书采集记录
		manualRecoderSet(params);
	}

	/**
	 * 基础校验
	 * 
	 * @param params
	 * @return
	 */
	private boolean validation(CimrvsAggDO[] params) {
		if (params == null || params.length < 1) {
			return false;
		}
		return true;
	}

	/**
	 * 获取不能删除的体征信息
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private VitalSignsDataDTO[] querySysData(CimrvsAggDO[] params) throws BizException {
		List<String> listKey = new ArrayList<String>();
		for (CimrvsAggDO agg : params) {
			listKey.add(agg.getParentDO().getId_mr_vs());
		}
		if (listKey.size() > 0) {
			GetUnDeleteVsInfoSql sql = new GetUnDeleteVsInfoSql(listKey.toArray(new String[listKey.size()]));
			return (VitalSignsDataDTO[]) AppFwUtil.getDORstWithDao(sql, VitalSignsDataDTO.class);
		}
		return null;
	}

	/**
	 * 获取异常信息
	 * 
	 * @param vs
	 * @return
	 */
	private String packageMesg(VitalSignsDataDTO[] vs) {
		String reMsg = "";
		if (vs != null && vs.length > 0) {
			for (VitalSignsDataDTO data : vs) {
				reMsg += ("患者【" + data.getName_pat() + "】在【" + data.getDt_vt() + "】存在系统事件【" + data.getName() + "】,不允许删除！\n");
			}
		}
		return reMsg;
	}

	/**
	 * 手动处理文书采集记录
	 * 
	 * @param params
	 * @throws BizException
	 */
	private void manualRecoderSet(CimrvsAggDO[] params) throws BizException {
		if (params != null && params.length > 0)
			ServiceFinder.find(INmrMaintainService.class).deleteMedicalRecordSetByObj(params);
	}
}
