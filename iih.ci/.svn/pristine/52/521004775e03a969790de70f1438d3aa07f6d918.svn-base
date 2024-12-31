package iih.ci.mr.mrtree.s;

import xap.mw.core.data.BizException;
import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.dto.d.MrDTO;
import iih.ci.mr.mrtree.bp.MrTreeForMrDtoBP;
import iih.ci.mr.mrtree.bp.MrTreeForMrcactmBP;
import iih.ci.mr.mrtree.i.IMrTreeMaintainService;

/**
 * 病历树接口实现类
 * 
 * @author gaorn
 * @date 2020年7月17日-创建
 */
public class IMrTreeMaintainServiceImpl implements IMrTreeMaintainService {

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
	@Override
	public MrCaCtmMrDTO[] GetMrTreeForMrcactm(String id_ent, String code_entp,
			Integer hasAll, String docornur, String id_su_mr)
			throws BizException {
		MrTreeForMrcactmBP bp = new MrTreeForMrcactmBP();
		return bp.GetMrTreeForMrcactm(id_ent, code_entp, hasAll, docornur,
				id_su_mr);
	}

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
	@Override
	public MrDTO[] GetMrTreeForMrDto(String id_ent, String id_mrcactm,
			String code_entp, String docornur, String id_su_mr)
			throws BizException {
		MrTreeForMrDtoBP bp = new MrTreeForMrDtoBP();
		return bp.GetMrTreeForMrDto(id_ent, id_mrcactm, code_entp, docornur,
				id_su_mr);
	}

	
	public MrCaCtmMrDTO[] getMrCaCtmMrForPrint(String id_ent, String code_entp,String docornur,String id_dept) throws BizException{
		MrTreeForMrcactmBP bp=new MrTreeForMrcactmBP();
		return bp.getMrCaCtmMrForPrint(id_ent, code_entp, docornur, id_dept);
	}
	
	public MrDTO[] getMrdtoForPrint(String id_ent, String id_mrcactm, String code_entp, String paramtype,String docornur) throws BizException{
		MrTreeForMrDtoBP bp=new MrTreeForMrDtoBP();
		return bp.getMrdtoForPrint(id_ent, id_mrcactm, code_entp, paramtype, docornur);
	}
}
