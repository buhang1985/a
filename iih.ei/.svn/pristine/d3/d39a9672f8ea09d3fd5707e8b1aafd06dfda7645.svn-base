package iih.ei.std.s.v1.bp.mp.dispdruginfo;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.mp.opdispdrugInfo.d.OPCollocateDrugDTO;
import iih.ei.std.d.v1.mp.opdispdrugInfo.d.OPCollocateDrugResult;
import iih.ei.std.d.v1.mp.opdispdrugInfo.d.OPDispDrugParamDTO;
import iih.ei.std.s.v1.bp.mp.dispdruginfo.qry.GetOPDispDrugInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.util.AgeCalcUtil;

/**
 * 
 * @ClassName: QryOPDispDrugInfoBP
 * @Description: 获取门诊发药明细
 * @author zhy
 * @date 2019年10月16日
 *
 */
public class QryOPDispDrugInfoBP {

	/**
	 * 程序主入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OPCollocateDrugResult exec(OPDispDrugParamDTO param) throws BizException {

		// 查询门诊发药明细
		OPCollocateDrugDTO[] collocateDTOS = getDispDrugInfo(param);

		// 设置年龄
		setAge(collocateDTOS);

		// 组装返回值
		OPCollocateDrugResult result = new OPCollocateDrugResult();
		result.setCollocatedrug(ArrayListUtil.ConvertToFArrayList(collocateDTOS));
		return result;
	}

	/**
	 * 计算年龄
	 * 
	 * @param collocateDTOS
	 */
	private void setAge(OPCollocateDrugDTO[] collocateDTOS) {
		for (OPCollocateDrugDTO collocateDrugDto : collocateDTOS) {
			collocateDrugDto.setAge(AgeCalcUtil.getAge(new FDate(collocateDrugDto.getAge())));
		}

	}

	/**
	 * 查询门诊发药明细
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OPCollocateDrugDTO[] getDispDrugInfo(OPDispDrugParamDTO param) throws BizException {
		String deptId = Context.get().getDeptId();
		GetOPDispDrugInfoSql sql = new GetOPDispDrugInfoSql(param.getId_pres(), deptId);
		OPCollocateDrugDTO[] dos = (OPCollocateDrugDTO[]) AppFwUtil.getDORstWithDao(sql, OPCollocateDrugDTO.class);
		return dos;
	}

}
