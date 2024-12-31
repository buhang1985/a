package iih.ci.diag.s.bp;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.s.bp.qry.GetCiDiagItemsBPQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据就诊id和诊断类型编码获取已签署的诊断
 * 
 * @author hums
 *
 */
public class GetCiDiagItemsBP {

	/**
	 * 根据就诊id和诊断类型编码获取已签署的诊断
	 * @param id_en 就诊id
	 * @param sd_ditp 诊断类型编码
	 * @return
	 * @throws BizException
	 */
	public CiDiagItemDO[] exe(String id_en,String sd_ditp) throws BizException {

		GetCiDiagItemsBPQry qry = new GetCiDiagItemsBPQry(id_en, sd_ditp);

		return (CiDiagItemDO[]) AppFwUtil.getDORstWithDao(qry, CiDiagItemDO.class);
	}
}
