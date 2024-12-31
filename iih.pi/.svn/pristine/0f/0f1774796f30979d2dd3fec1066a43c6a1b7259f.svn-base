package iih.pi.dic.patcate.s;

import iih.pi.dic.patcate.d.PatCateUIDTO;
import iih.pi.dic.patcate.i.IPatcateUiCudService;
import iih.pi.dic.patcate.i.IPatcateUiRService;
import iih.pi.dic.patcate.s.bp.DeletePatCateUIDTOsBp;
import iih.pi.dic.patcate.s.bp.FindPatCateUIDTOsByWherePartBp;
import iih.pi.dic.patcate.s.bp.SavePatCateUIDTOsBp;
import xap.mw.core.data.BizException;

/**
 * 患者分类UIDTO 数据CRUD服务实现
 */
public class PatcateUiCrudServiceImpl implements IPatcateUiCudService, IPatcateUiRService {

	/**
	 * 根据条件查找患者分类UIDTO数据集合
	 */
	@Override
	public PatCateUIDTO[] findPatCaUIDTOsByWherePart(String whereStr, String orderStr) throws BizException {
		FindPatCateUIDTOsByWherePartBp bp = new FindPatCateUIDTOsByWherePartBp();
		PatCateUIDTO[] result = bp.exec(whereStr, orderStr);
		return result;
	}

	/**
	 * 患者分类UIDTO数据保存
	 */
	@Override
	public PatCateUIDTO savePatCaUIDTOs(PatCateUIDTO patCateUIDTO) throws BizException {
		SavePatCateUIDTOsBp bp = new SavePatCateUIDTOsBp();
		PatCateUIDTO result = bp.exec(patCateUIDTO);
		return result;
	}

	/**
	 * 患者分类UIDTO数据删除
	 */
	@Override
	public void deletePatCaUIDTOs(PatCateUIDTO patCateUidto) throws BizException {
		DeletePatCateUIDTOsBp bp = new DeletePatCateUIDTOsBp();
		bp.exec(patCateUidto);
	}
}
