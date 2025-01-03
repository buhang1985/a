package iih.mp.nr.mpwardprint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import iih.mp.nr.dto.mpwardprint.d.MpOrPrnPlanMasterDTO;
import iih.mp.nr.dto.mpwardprint.d.MpOrPrnPlanSrvDTO;
import iih.mp.nr.dto.mpwardprint.d.WardPrntCondDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 病区执行打印按计划维度分组（药品贴）
 * 
 * @author fengjj
 * @date 2019年3月15日18:08:09 创建
 * @version xuxing_2019年5月24日09:54:28，迭代
 * @version fengjj 2019年8月5日13:47:13 迭代，保持顺序
 */
public class GetMpPrnPlanOrInfosBp {
	/**
	 * 计划维度分组 主入口
	 * 
	 * @param args
	 * @throws BizException
	 * @throws IOException
	 */

	public List<MpOrPrnPlanMasterDTO> exec(String param) throws BizException, IOException {

		// 1.参数解析
		WardPrntCondDTO paramDTO = paramAnalyze(param);

		// 2.获取数据
		List<MpOrPrnPlanSrvDTO> listDatas = getPlanSrvData(paramDTO);

		// 3.组装数据
		LinkedList<MpOrPrnPlanMasterDTO> rtns = packageRtns(listDatas);

		// 4.设置主DTO患者信息
		setMasterDTO(rtns);

		// 5.数据拼接
		handleData(rtns);
		
		return rtns;
	}

	/**
	 * 参数解析
	 * 
	 * @param param
	 * @throws BizException
	 * @throws IOException
	 */
	private WardPrntCondDTO paramAnalyze(String param) throws BizException, IOException {
		if (param == null || param.length() <= 0)
			throw new BizException("报表参数不能为空!");
		WardPrntCondDTO rtn = new WardPrntCondDTO();
		rtn.deSerializeJson(param);
		return rtn;
	}

	/**
	 * 获取所有的srv数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private List<MpOrPrnPlanSrvDTO> getPlanSrvData(WardPrntCondDTO param) throws BizException {
		GetSrvPlanCommonBp bp = new GetSrvPlanCommonBp();
		return bp.exec(param);
	}

	/**
	 * 组装数据
	 * 
	 * @param rtns
	 * @return
	 */
	private LinkedList<MpOrPrnPlanMasterDTO> packageRtns(List<MpOrPrnPlanSrvDTO> list) {
		LinkedList<MpOrPrnPlanMasterDTO> rtn = new LinkedList<MpOrPrnPlanMasterDTO>();
		if (list == null || list.size() <= 0)
			return rtn;
		List<String> listOr = new ArrayList<String>();
		// 根据id_or_pr分组
		HashMap<String, LinkedList<MpOrPrnPlanSrvDTO>> mapListInfus = groupByOrPr(list, listOr);
		Collection<LinkedList<MpOrPrnPlanSrvDTO>> values = mapListInfus.values();
		for (LinkedList<MpOrPrnPlanSrvDTO> Srvlist : values) {
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
	private HashMap<String, LinkedList<MpOrPrnPlanSrvDTO>> groupByOrPr(List<MpOrPrnPlanSrvDTO> params, List<String> listOr) {
		HashMap<String, LinkedList<MpOrPrnPlanSrvDTO>> reMap = new LinkedHashMap<String, LinkedList<MpOrPrnPlanSrvDTO>>();
		if (params != null && params.size() > 0) {
			for (MpOrPrnPlanSrvDTO t : params) {
				Object key = t.getId_or_pr();
				if (key == null)
					continue;
				if (!listOr.contains(key.toString()))
					listOr.add(key.toString());
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(t);
				} else {
					LinkedList<MpOrPrnPlanSrvDTO> list = new LinkedList<MpOrPrnPlanSrvDTO>();
					list.add(t);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}

	/**
	 * 设置表头信息
	 * 
	 * @param rtns
	 */
	private void setMasterDTO(List<MpOrPrnPlanMasterDTO> rtns) {
		for (MpOrPrnPlanMasterDTO MasterDTO : rtns) {
			MpOrPrnPlanSrvDTO srvDTO = MasterDTO.getArraydrugs().get(0);
			MasterDTO.setName_pat(srvDTO.getName_pat());
			MasterDTO.setName_bed(srvDTO.getName_bed());
			MasterDTO.setName_dep_phy(srvDTO.getName_dep_phy());
			MasterDTO.setName_sex(srvDTO.getName_sex());
			MasterDTO.setAge(srvDTO.getAge());
			MasterDTO.setCode_amr_ip(srvDTO.getCode_amr_ip());
			MasterDTO.setDt_birth_pat(srvDTO.getDt_birth_pat());
			MasterDTO.setDt_hour(srvDTO.getDt_hour());
			MasterDTO.setDt_mp_plan(srvDTO.getDt_mp_plan());
			MasterDTO.setCode_freq(srvDTO.getCode_freq());
			MasterDTO.setName_route(srvDTO.getName_route());
			MasterDTO.setNo_bar(srvDTO.getNo_bar());
			MasterDTO.setDes_or(srvDTO.getDes_or());
			MasterDTO.setId_or_pr(srvDTO.getId_or_pr());
			MasterDTO.setCode_or(srvDTO.getCode_or());
			MasterDTO.setFg_long(srvDTO.getFg_long());
			MasterDTO.setName_dripspeed(srvDTO.getName_dripspeed());
			MasterDTO.setTimes_ip(srvDTO.getTimes_ip());
			MasterDTO.setSug_name(srvDTO.getSug_name());
			MasterDTO.setName_routedes(srvDTO.getName_routedes());//医嘱用法要求
		}
	}

	/**
	 * 数据拼接（特殊处理，全部药品和备注规格都放一起）
	 * 
	 * @param rtns
	 */
	private void handleData(List<MpOrPrnPlanMasterDTO> rtns) {
		if (rtns != null && rtns.size() > 0) {
			for (MpOrPrnPlanMasterDTO MasterDTO : rtns) {
				List<MpOrPrnPlanSrvDTO> list = MasterDTO.getArraydrugs();
				String name = "";
				String quan_medu = "";
				String spec = "";
				int quan_medu_her = 0; // 草药剂量
				for (MpOrPrnPlanSrvDTO drugDTO : list) {
					if (drugDTO.getSd_srvtp() != null && drugDTO.getSd_srvtp().length() > 3 && "0103".equals(drugDTO.getSd_srvtp().subSequence(0, 4))) {// 草药
						name += ((StringUtil.isEmptyWithTrim(name)) ? "" : ";") + (drugDTO.getName() + (StringUtil.isEmptyWithTrim(drugDTO.getSpec()) ? "" : ("" + drugDTO.getSpec())));
						quan_medu_her += StringUtil.isEmptyWithTrim(drugDTO.getQuan_medu()) ? 0 : Integer.parseInt(drugDTO.getQuan_medu());
						spec = "";
					} else {
						name += ((StringUtil.isEmptyWithTrim(name)) ? "" : "<br/>") + (drugDTO.getName() + (StringUtil.isEmptyWithTrim(drugDTO.getSpec()) ? "" : ("" + drugDTO.getSpec())));
						quan_medu += ((StringUtil.isEmptyWithTrim(quan_medu)) ? "" : "<br/>") + (drugDTO.getQuan_medu() + (drugDTO.getName_medu() == null ? "" : drugDTO.getName_medu()));
						spec += ((StringUtil.isEmptyWithTrim(spec)) ? "" : "<br/>") + (drugDTO.getSpec());
					}
				}
				MasterDTO.setName(name + (StringUtil.isEmptyWithTrim(MasterDTO.getSug_name()) ? "" : ("("+MasterDTO.getSug_name())+")")+ "<br/>" + ((StringUtil.isEmptyWithTrim(MasterDTO.getDes_or())) ? "" : MasterDTO.getDes_or()));
				MasterDTO.setQuan_medu(quan_medu.length() <= 0 ? (quan_medu_her + "") : quan_medu);
				MasterDTO.setSpec(spec);
			}
		}
	} 
}
