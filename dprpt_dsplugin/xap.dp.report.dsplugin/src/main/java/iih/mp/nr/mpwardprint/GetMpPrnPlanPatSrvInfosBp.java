package iih.mp.nr.mpwardprint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import iih.mp.nr.dto.mpwardprint.d.MpOrPrnPlanMasterDTO;
import iih.mp.nr.dto.mpwardprint.d.MpOrPrnPlanSrvDTO;
import iih.mp.nr.dto.mpwardprint.d.WardPrntCondDTO;
import xap.mw.core.data.BizException;

/**
 * 病区执行打印按患者id_ent分组（执行卡/液体核对卡）
 * 
 * @author fengjj
 * @data 2019年3月15日18:06:49 创建
 * @version xuxing_2019年5月24日09:54:28，迭代
 * @version xuxing_2019年6月5日18:29:343，患者表头信息增加执行计划主键集合信息
 */
public class GetMpPrnPlanPatSrvInfosBp {

	/**
	 * 患者维度分组 主入口
	 * 
	 * @param args
	 * @throws BizException
	 * @throws IOException
	 */

	public List<MpOrPrnPlanMasterDTO> exec(String param) throws BizException, IOException {

		// 1.获取数据
		List<MpOrPrnPlanSrvDTO> listDatas = getPlanSrvData(param);

		// 2.数据分组
		LinkedList<MpOrPrnPlanMasterDTO> rtn = GroupDataByPat(listDatas);

		// 3.设置主DTO信息（卡头信息）
		setMasterDTO(rtn, param);

		// 4.计算序号
		setIndex(rtn);

		return rtn;
	}

	/**
	 * 获取所有的srv数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @throws IOException
	 */
	private List<MpOrPrnPlanSrvDTO> getPlanSrvData(String param) throws BizException, IOException {
		GetMpPrnPlanSrvInfosBp bp = new GetMpPrnPlanSrvInfosBp();
		return bp.exec(param);
	}

	/**
	 * 数据分组
	 * 
	 * @param listDatas
	 */
	private LinkedList<MpOrPrnPlanMasterDTO> GroupDataByPat(List<MpOrPrnPlanSrvDTO> listDatas) {
		LinkedList<MpOrPrnPlanMasterDTO> rtn = new LinkedList<MpOrPrnPlanMasterDTO>();
		if (listDatas == null || listDatas.size() <= 0)
			return rtn;
		List<String> listOr = new ArrayList<String>();
		// 根据id_ent分组
		LinkedHashMap<String, List<MpOrPrnPlanSrvDTO>> mapListInfus = groupByOrPr(listDatas, listOr);
		Collection<List<MpOrPrnPlanSrvDTO>> values = mapListInfus.values();
		for (List<MpOrPrnPlanSrvDTO> Srvlist : values) {
			MpOrPrnPlanMasterDTO masterDTO = new MpOrPrnPlanMasterDTO();
			masterDTO.setArraydrugs(Srvlist);
			rtn.add(masterDTO);
		}
		return rtn;
	}

	/**
	 * 根据id_or_pr分组
	 * 
	 * @param params
	 * @param listOr
	 * @return
	 */
	private LinkedHashMap<String, List<MpOrPrnPlanSrvDTO>> groupByOrPr(List<MpOrPrnPlanSrvDTO> params, List<String> listOr) {
		LinkedHashMap<String, List<MpOrPrnPlanSrvDTO>> reMap = new LinkedHashMap<String, List<MpOrPrnPlanSrvDTO>>();
		if (params != null && params.size() > 0) {
			for (MpOrPrnPlanSrvDTO t : params) {
				Object key = t.getId_ent();
				if (key == null)
					continue;
				if (!listOr.contains(key.toString()))
					listOr.add(key.toString());
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(t);
				} else {
					List<MpOrPrnPlanSrvDTO> list = new ArrayList<MpOrPrnPlanSrvDTO>();
					list.add(t);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}

	/**
	 * 设置主DTO信息（卡头信息）
	 * 
	 * @param rtns
	 */
	private void setMasterDTO(LinkedList<MpOrPrnPlanMasterDTO> rtns, String param) {
		WardPrntCondDTO rtn = new WardPrntCondDTO();
		rtn.deSerializeJson(param);
		for (MpOrPrnPlanMasterDTO MasterDTO : rtns) {
			List<MpOrPrnPlanSrvDTO> listSrv = MasterDTO.getArraydrugs();
			if (listSrv == null || listSrv.size() < 1)
				continue;
			MpOrPrnPlanSrvDTO srvDTO = null;
			String id_or_prs = "";
			for (MpOrPrnPlanSrvDTO srv : listSrv) {
				if (srvDTO == null)
					srvDTO = srv;
				id_or_prs += (id_or_prs.length() == 0 ? "" : ",") + srv.getId_or_pr();
			}
			MasterDTO.setName_pat(srvDTO.getName_pat());
			MasterDTO.setName_bed(srvDTO.getName_bed());
			MasterDTO.setName_dep_phy(srvDTO.getName_dep_phy());
			MasterDTO.setName_sex(srvDTO.getName_sex());
			MasterDTO.setAge(srvDTO.getAge());
			MasterDTO.setCode_amr_ip(srvDTO.getCode_amr_ip());
			MasterDTO.setDt_birth_pat(srvDTO.getDt_birth_pat());
			MasterDTO.setDt_hour(srvDTO.getDt_hour());
			MasterDTO.setDt_mp_plan(srvDTO.getDt_mp_plan());
			MasterDTO.setNo_bar(srvDTO.getNo_bar());
			MasterDTO.setId_or_pr(id_or_prs);
			MasterDTO.setId_ent(srvDTO.getId_ent());
			MasterDTO.setCode_or(srvDTO.getCode_or());
			MasterDTO.setFg_long(srvDTO.getFg_long());
			MasterDTO.setDt_begin(rtn.getDt_begin());
			MasterDTO.setDt_end(rtn.getDt_end());
		}
	}

	/**
	 * 计算序号
	 * 
	 * @param rtn
	 */
	private void setIndex(LinkedList<MpOrPrnPlanMasterDTO> rtn) {
		for (MpOrPrnPlanMasterDTO MasterDto : rtn) {
			int i = 1;
			List<MpOrPrnPlanSrvDTO> arraydrugs = MasterDto.getArraydrugs();
			MpOrPrnPlanSrvDTO dto = new MpOrPrnPlanSrvDTO();
			for (MpOrPrnPlanSrvDTO SrvDTO : arraydrugs) {
				if (i != 1 && SrvDTO.getId_or_pr().equals(dto.getId_or_pr())) {
					SrvDTO.setIndex(dto.getIndex());
				} else {
					SrvDTO.setIndex(i + "");
					i++;
				}
				dto = SrvDTO;
			}
		}
	}

}
