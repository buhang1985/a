package iih.ci.mr.mrtreeqry.i;

import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.dto.d.MrDTO;
import xap.mw.core.data.BizException;

public interface IMrTreeQryService {

	/**
	 *住院病历召回审核节点一级分类树
	 */
	public abstract  MrCaCtmMrDTO[] getMrcactm( String id_ent , String code_entp , Integer hasAll , String docornur ) throws BizException;
	
	/**
	 * 住院病历召回审核节点一级分类树(获取指定病人医疗文件DTO包含文书状态)
	 */
	public abstract MrDTO[] GetMrDtoForTree(String id_ent, String id_mrcactm,
			String code_entp, String docornur)
			throws BizException;
}
