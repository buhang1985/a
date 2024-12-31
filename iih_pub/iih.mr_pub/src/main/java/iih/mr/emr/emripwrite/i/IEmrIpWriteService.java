package iih.mr.emr.emripwrite.i;

import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.core.data.BizException;

/**
 * 住院病历主服务
 * @author 任亚平
 *
 */
public interface IEmrIpWriteService {

	/**
	 * 根据就诊信息及病历树信息获取病历列表
	 * @param id_ent
	 * @param id_mrcactm
	 * @param code_entp
	 * @param docornur
	 * @param id_mr_bt
	 * @return
	 * @throws BizException
	 */
	public CiMrDO[] getMrByMrCaAndType(String id_ent, String id_mrcactm,
			String code_entp, String docornur,String id_mr_bt) throws BizException;
}
