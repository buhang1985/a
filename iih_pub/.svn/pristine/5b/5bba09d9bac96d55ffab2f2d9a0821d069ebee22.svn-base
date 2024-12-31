package iih.ci.mrqc.mrqccommon.i;

import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.dto.d.MrDTO;
import xap.mw.core.data.BizException;

public interface IMrQcCommonService {
	/**
	*  获取医疗记录自定义分类
	*  @param id_su_mr 前台传过来的参数，控制质控树显示状态
	*/
    public abstract  MrCaCtmMrDTO[] getMrQcCommonTreeForMrcactm(String id_ent, String code_entp, Integer hasAll, 
    		String docornurse, String id_su_mr) throws BizException;
    /**
	 * 质控用文书树
	 * @param id_ent
	 * @param id_mrcactm
	 * @param code_entp
	 * @param paramtype
	 * @param docornur
	 * @param id_su_mr 前台传过来的参数，控制质控树显示状态
	 * @return
	 * @throws BizException
	 */
	public abstract MrDTO[] getMrQcCommonTreeForMrDto(String id_ent, String id_mrcactm, String code_entp, String paramtype, 
			String docornur,String id_su_mr) throws BizException;
	
}
