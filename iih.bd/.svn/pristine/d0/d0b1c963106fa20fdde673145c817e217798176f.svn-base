package iih.bd.mm.mmalert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import iih.bd.base.utils.AppUtils;
import iih.bd.mm.mmalert.bp.FindUnusableDataBp;
import iih.bd.mm.mmunusabledto.d.Mmunusabledto;
import iih.bd.utils.log.BdMmLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.message.message.i.IGenerateMessageExtdService;

public class MmUnusableAlertPlugin implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc) throws BizException {

		BdMmLogUtils.info(">>滞销预警插件开始执行=%s", AppUtils.getServerDateTime());
		PreAlertObject retObj = new PreAlertObject();

		Map<String, Object> mapPara = bgwc.getKeyMap();
		String id_grp = (String) mapPara.get("id_grp");
		String id_org = (String) mapPara.get("id_org");
		Context.get().setGroupId(id_grp);
		Context.get().setOrgId(id_org);

		// 获取数据集
		FindUnusableDataBp Sql = new FindUnusableDataBp();
		Mmunusabledto[] valis = (Mmunusabledto[]) AppFwUtil.getDORstWithDao(Sql, Mmunusabledto.class);
		if (valis == null || valis.length == 0) {

			return retObj;
		}

		Map<String, Mmunusabledto> result = new HashMap<String, Mmunusabledto>();
		Map<String, List<List<String>>> jsonMap = new HashMap<String, List<List<String>>>();
		for (Mmunusabledto unusableDTO : valis) {

			if (result.containsKey(unusableDTO.getId_wh())) {
				List<List<String>> jsonList = jsonMap.get(unusableDTO.getId_wh());
				Mmunusabledto dto = result.get(unusableDTO.getId_wh());
				dto.setQuan_unusa(dto.getQuan_unusa() + 1);
				this.setMmUnusableDesc(jsonList, unusableDTO);
			} else {
				List<List<String>> jsonList = new ArrayList<List<String>>();
				unusableDTO.setQuan_unusa(1);
				this.createTableHead(jsonList);
				this.setMmUnusableDesc(jsonList, unusableDTO);
				result.put(unusableDTO.getId_wh(), unusableDTO);
				jsonMap.put(unusableDTO.getId_wh(), jsonList);
			}
		}

		for (Mmunusabledto dto : result.values()) {
			List<List<String>> json_List = jsonMap.get(dto.getId_wh());
			String desc = JSONObject.toJSONString(json_List);
			dto.setDesc(desc);
			Map<String, Object> map = getMap(dto);
			IGenerateMessageExtdService igservice = ServiceFinder.find(IGenerateMessageExtdService.class);
			igservice.GenerateMessageAndMap("MmUnusableAlert", map, null);

		}
		return retObj;
	}

	private void createTableHead(List<List<String>> jsonList) {
		List<String> head_string = new ArrayList<String>();
		head_string.add("编码");
		head_string.add("名称");
		head_string.add("规格");
		head_string.add("生产厂家");
		head_string.add("批次");
		head_string.add("失效期");
		head_string.add("现存量");
		head_string.add("滞销天数");
		head_string.add("通用名");
		head_string.add("打印名");
		jsonList.add(head_string);
	}

	private void setMmUnusableDesc(List<List<String>> jsonList, Mmunusabledto unusableDTO) {
		
		List<String> table_string = new ArrayList<String>();
		table_string.add(unusableDTO.getMm_code());
		table_string.add(unusableDTO.getMm_name());
		table_string.add(unusableDTO.getMm_spec());
		table_string.add(unusableDTO.getSup_name());
		table_string.add(unusableDTO.getBatch());
		String date_expi = unusableDTO.getDate_expi() == null ? "" : unusableDTO.getDate_expi().toString();
		table_string.add(date_expi);
		table_string.add(String.format("%s%s", unusableDTO.getQuan_stockact().setScale(4, FDouble.ROUND_UP), unusableDTO.getMmpkguname()));
		table_string.add(String.format("%s天", unusableDTO.getUnusa_day()));
		table_string.add(unusableDTO.getPrintname());
		table_string.add(unusableDTO.getSrv_name());
		jsonList.add(table_string);
	}

	private static Map<String, Object> getMap(Mmunusabledto basedtos) {
		Map<String, Object> variable = new HashMap<String, Object>();

		Mmunusabledto basedto = basedtos;
		String classname = basedto.getClass().getSimpleName();
		variable.put(classname, basedto);
		return variable;
	}
}
