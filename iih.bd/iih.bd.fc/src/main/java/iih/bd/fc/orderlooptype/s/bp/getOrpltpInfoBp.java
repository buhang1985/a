package iih.bd.fc.orderlooptype.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.orderlooptype.d.OrpltpInfoDTO;
import iih.bd.fc.orderlooptype.s.bp.qry.getOrpltpStaByOrpltpSql;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取闭环ID+desc
 * @author Administrator
 *
 */
public class getOrpltpInfoBp {

	/**
	 * 获取闭环明细
	 * 
	 * @return
	 * @throws BizException
	 */
	public OrpltpInfoDTO[] exec() throws BizException {

		// 1、取全部的闭环状态
		OrpltpStaDO[] orpltpStas = getOrpltp();

		// 2、获取不重复的闭环主键集合
		List<String> listKey = getOrpltpList(orpltpStas);

		// 3、拼装结果
		OrpltpInfoDTO[] rtn = packageRes(orpltpStas, listKey);

		return rtn;
	}

	/**
	 * 取全部的闭环状态
	 * 
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaDO[] getOrpltp() throws BizException {

		getOrpltpStaByOrpltpSql Sql = new getOrpltpStaByOrpltpSql(null);

		OrpltpStaDO[] orpltpStaDOS = (OrpltpStaDO[]) AppFwUtil.getDORstWithDao(Sql, OrpltpStaDO.class);

		return orpltpStaDOS;
	}

	/**
	 * 获取不重复的闭环主键集合
	 * 
	 * @param orpltpStaDOS
	 * @return
	 */
	private List<String> getOrpltpList(OrpltpStaDO[] orpltpStaDOS) {

		List<String> reList = new ArrayList<String>();

		if (orpltpStaDOS != null && orpltpStaDOS.length > 0) {

			for (OrpltpStaDO sta : orpltpStaDOS) {

				if (!reList.contains(sta.getId_orpltp())) {

					reList.add(sta.getId_orpltp());
				}
			}
		}
		return reList;
	}

	/**
	 * 拼装结果
	 * 
	 * @param orpltpStaDOS
	 * @param listKey
	 * @return
	 */
	private OrpltpInfoDTO[] packageRes(OrpltpStaDO[] orpltpStaDOS, List<String> listKey) {

		List<OrpltpInfoDTO> reList = new ArrayList<OrpltpInfoDTO>();

		if (listKey != null && listKey.size() > 0) {

			if (orpltpStaDOS != null && orpltpStaDOS.length > 0) {

				for (String id_orpltp : listKey) {

					String desc = "";

					for (OrpltpStaDO sta : orpltpStaDOS) {

						if (id_orpltp.equals(sta.getId_orpltp())) {

							desc += (desc.length() == 0 ? "" : "=>") + sta.getName();
						}
					}

					OrpltpInfoDTO DTO = new OrpltpInfoDTO();
					DTO.setId_orpltp(id_orpltp);
					DTO.setDes(desc);
					reList.add(DTO);
				}
			}
		}

		return reList.toArray(new OrpltpInfoDTO[reList.size()]);
	}

}
