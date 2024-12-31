package iih.ci.mr.mrtree.i;

import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.dto.d.MrDTO;
import xap.mw.core.data.BizException;

/**
 * 病历树接口
 * 
 * @author gaorn
 * @date 2020年7月17日- 创建
 */
/**
 * @author LJL
 *
 */
public interface IMrTreeMaintainService {

	/**
	 * 获取医疗记录自定义分类
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @param hasAll
	 * @param docornur
	 * @return MrCaCtmMrDTO[]
	 * @throws BizException
	 */
	public abstract MrCaCtmMrDTO[] GetMrTreeForMrcactm(String id_ent,
			String code_entp, Integer hasAll, String docornur, String id_su_mr)
			throws BizException;

	/**
	 * 获取指定病人医疗文件DTO
	 * 
	 * @param id_ent
	 * @param id_mrcactm
	 * @param code_entp
	 * @param paramtype
	 * @param docornur
	 * @return MrCaCtmMrDTO[]
	 * @throws BizException
	 */
	public abstract MrDTO[] GetMrTreeForMrDto(String id_ent, String id_mrcactm,
			String code_entp, String docornur, String id_su_mr)
			throws BizException;

	/**住院病历打印一级树
	 * @param id_ent
	 * @param code_entp
	 * @param docornur
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public MrCaCtmMrDTO[] getMrCaCtmMrForPrint(String id_ent, String code_entp,String docornur,String id_dept) throws BizException;
	
	/**住院病历打印二级树
	 * @param id_ent
	 * @param id_mrcactm
	 * @param code_entp
	 * @param paramtype
	 * @param docornur
	 * @return
	 * @throws BizException
	 */
	public MrDTO[] getMrdtoForPrint(String id_ent, String id_mrcactm, String code_entp, String paramtype,String docornur) throws BizException;
}
