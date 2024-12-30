package iih.sc.sch.s.bp;

import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.scsch.d.SchOcpResDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 口腔科排班保存BP
 * 
 * @author zhengcm
 * @date 2016-09-19 17:53:22
 *
 */
public class SaveOralSchBP {

	/**
	 * 口腔科排班保存
	 *
	 * @param oralSchDTOList 口腔科排班信息DTO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(SchOralInfoDTO[] oralSchDTOs) throws BizException {
		if (ArrayUtil.isEmpty(oralSchDTOs)) {
			return;
		}
		// 新增排班
		List<SchOralInfoDTO> insertList = new ArrayList<SchOralInfoDTO>();
		// 修改排班
		List<SchOralInfoDTO> updateList = new ArrayList<SchOralInfoDTO>();
		// 删除排班
		List<SchOralInfoDTO> deleteList = new ArrayList<SchOralInfoDTO>();

		// 占用资源
		List<SchOralInfoDTO> ocpList = new ArrayList<SchOralInfoDTO>();

		// 数据归类
		for (SchOralInfoDTO oralSchDTO : oralSchDTOs) {
			if (oralSchDTO.getFg_occupy() != null && oralSchDTO.getFg_occupy().booleanValue()) {
				if (!StringUtil.isEmptyWithTrim(oralSchDTO.getId_sch())) {
					ocpList.add(oralSchDTO);
				} else {
					if (oralSchDTO.getStatus() == DOStatus.NEW) {
						insertList.add(oralSchDTO);
					}
				}
			} else {
				switch (oralSchDTO.getStatus()) {
				case DOStatus.NEW:
					insertList.add(oralSchDTO);
					break;
				case DOStatus.UPDATED:
					updateList.add(oralSchDTO);
					break;
				case DOStatus.DELETED:
					deleteList.add(oralSchDTO);
					break;
				}
			}
		}

		// 数据处理
		new DeleteOralSchBP().exec(deleteList);
		new InsertOralSchBP().exec(insertList);
		new UpdateOralSchBP().exec(updateList);		

		// 保存资源占用
		this.saveSchOcpRes(ocpList);
	}

	/**
	 * 保存排班资源占用
	 *
	 * @param ocpList
	 * @throws BizException
	 * @author zhengcm
	 */
	private void saveSchOcpRes(List<SchOralInfoDTO> ocpList) throws BizException {
		if (!ListUtil.isEmpty(ocpList)) {
			Map<String, SchOralInfoDTO> map = new HashMap<String, SchOralInfoDTO>();
			List<String> ids = new ArrayList<String>();
			for (SchOralInfoDTO dto : ocpList) {
				if (!StringUtil.isEmptyWithTrim(dto.getId_schocpres())) {
					ids.add(dto.getId_schocpres());
					map.put(dto.getId_schocpres(), dto);
				}
			}
			List<SchOcpResDO> datas = new ArrayList<SchOcpResDO>();
			OralSchEP oralSchEP = new OralSchEP();
			SchOcpResDO[] resDOs = null;
			if (!ListUtil.isEmpty(ids)) {
				resDOs = oralSchEP.getSchOcpResByCond(
						ScSqlUtils.getInSqlByIds("id_schocpres", ids), null);
			}
			// 更新的占用
			if (!ArrayUtil.isEmpty(resDOs)) {
				for (SchOcpResDO resDO : resDOs) {
					resDO.setStatus(map.get(resDO.getId_schocpres()).getStatus());
					resDO.setId_quesite(map.get(resDO.getId_schocpres()).getId_quesite());
					datas.add(resDO);
				}
			}
			// 找到新增的占用
			for (SchOralInfoDTO dto : ocpList) {
				if (StringUtil.isEmptyWithTrim(dto.getId_schocpres())) {
					SchOcpResDO resDO = new SchOcpResDO();
					resDO.setStatus(DOStatus.NEW);
					resDO.setId_sch(dto.getId_sch());
					resDO.setId_quesite(dto.getId_quesite());
					datas.add(resDO);
				}
			}
			oralSchEP.saveSchOcpRes(datas.toArray(new SchOcpResDO[0]));
		}
	}
}
