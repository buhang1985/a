package iih.bd.fc.s.bp.orpltpfun;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltp.i.IOrpltpStaDORService;
import iih.bd.fc.orpltpfunparam.d.OrpltpFunDTO;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.orpltpstafunc.i.IOrpltpstafuncRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱执行闭环节点状态匹配
 * 
 * @author xuxing2016-08-23
 *
 */
public class GetOrpltpFunBp {

	/**
	 * 医嘱执行闭环节点状态匹配主入口
	 * 
	 * @param DTO
	 * @return
	 * @throws BizException
	 */
	public OrpltpStaDO[] exec(OrpltpFunDTO[] DTOS) throws BizException {

		// 1、参数校验
		if (!validation(DTOS)) {
			return null;
		}

		// 2、获取全部的参数集合
		OrpltpStaFuncDO[] staFunDOS = getAllFunStaDO();

		// 3、获取匹配闭环状态集合
		String[] listOrpltpSta = matchParam(staFunDOS, DTOS);

		// 4、 根据状态集合获取状态实体
		OrpltpStaDO[] reDOS = getOrpltpStaDOS(listOrpltpSta);

		return reDOS;

	}

	/**
	 * 参数校验
	 * 
	 * @param DTO
	 * @return
	 */
	private boolean validation(OrpltpFunDTO[] DTO) {

		if (DTO == null || DTO.length == 0) {
			
			return false;
		}

		return true;
	}

	/**
	 * 获取全部的参数集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaFuncDO[] getAllFunStaDO() throws BizException {

		IOrpltpstafuncRService findService = ServiceFinder.find(IOrpltpstafuncRService.class);

		return findService.find("1=1", "", FBoolean.FALSE);
	}

	/**
	 * 获取匹配闭环状态集合
	 * 
	 * @param funStaDOS
	 * @param DTOS
	 * @return
	 */
	private String[] matchParam(OrpltpStaFuncDO[] funStaDOS, OrpltpFunDTO[] DTOS) {

		List<String> reList = new ArrayList<String>();

		if (funStaDOS != null && funStaDOS.length > 0) {

			for (OrpltpFunDTO DTO : DTOS) {

				String Id_orpltpSta = getOrpltpSta(funStaDOS, DTO);

				if (!StringUtil.isEmpty(Id_orpltpSta) && !reList.contains(Id_orpltpSta)) {

					reList.add(Id_orpltpSta);
				}
			}
		}

		return reList.toArray(new String[reList.size()]);

	}

	/**
	 * 单个参数匹配
	 * 
	 * @param funStaDOS
	 * @param DTO
	 * @return
	 */
	private String getOrpltpSta(OrpltpStaFuncDO[] funStaDOS, OrpltpFunDTO DTO) {

		for (OrpltpStaFuncDO orpltpStaFuncDO : funStaDOS) {

			boolean fg_fun = orpltpStaFuncDO.getFun_code().equals(DTO.getFun_code());
			boolean fg_orpltp = orpltpStaFuncDO.getId_orpltp().equals(DTO.getId_orpltp());
			boolean fg_oper = StringUtil.isEmpty(orpltpStaFuncDO.getSd_oper()) || orpltpStaFuncDO.getSd_oper().equals(DTO.getOper_code());

			if (fg_fun && fg_orpltp && fg_oper) {

				return orpltpStaFuncDO.getId_orpltpsta();
			}
		}

		return "";
	}

	/**
	 * 根据状态集合获取状态实体
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaDO[] getOrpltpStaDOS(String[] ids) throws BizException {

		IOrpltpStaDORService findService = ServiceFinder.find(IOrpltpStaDORService.class);

		return findService.findByBIds(ids, FBoolean.FALSE);
	}
}
