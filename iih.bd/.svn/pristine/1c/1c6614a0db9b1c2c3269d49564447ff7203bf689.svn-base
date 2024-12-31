package iih.bd.mm.mmalert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import iih.bd.base.utils.AppUtils;
import iih.bd.mm.mmalert.bp.FindExpiDataBp;
import iih.bd.mm.mmalert.bp.FindMcExpiDataBp;
import iih.bd.mm.mmexpialterdto.d.Mmexpialterdto;
import iih.bd.utils.log.BdMmLogUtils;
import iih.mm.qy.validperiod.d.ValidPeriodView;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.message.message.i.IGenerateMessageExtdService;

/**
 * 耗材失效期预警插件。
 * 
 * @author liyong
 *
 */

public class McExpiAlertPlugin implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc) throws BizException {

		BdMmLogUtils.info(">>耗材失效期预警插件开始执行=%s", AppUtils.getServerDateTime());
		PreAlertObject retObj = new PreAlertObject();

		// 获取数据集
		ValidPeriodView[] valis = FindMcExpiDataBp.queryExpiData(bgwc);
		if (valis == null || valis.length == 0) {

			return retObj;
		}

		Map<String, Mmexpialterdto> result = new HashMap<String, Mmexpialterdto>();
		Map<String, List<List<String>>> jsonMap = new HashMap<String, List<List<String>>>();
		for (ValidPeriodView validPeriodView : valis) {

			if (result.containsKey(validPeriodView.getId_wh())) {
				List<List<String>> jsonList = jsonMap.get(validPeriodView.getId_wh());
				Mmexpialterdto dto = result.get(validPeriodView.getId_wh());
				dto.setQuan_invalid(dto.getQuan_invalid() + 1);
				this.setMmExpiDesc(jsonList, validPeriodView);
			} else {
				List<List<String>> jsonList = new ArrayList<List<String>>();
				Mmexpialterdto dto = this.getMmExptDTO(jsonList, validPeriodView);
				this.setMmExpiDesc(jsonList, validPeriodView);
				result.put(validPeriodView.getId_wh(), dto);
				jsonMap.put(validPeriodView.getId_wh(), jsonList);
			}
		}

		for (Mmexpialterdto dto : result.values()) {
			List<List<String>> json_List = jsonMap.get(dto.getId_wh());
			String desc = JSONObject.toJSONString(json_List);
			dto.setDesc(desc);
			Map<String, Object> map = getMap(dto);
			IGenerateMessageExtdService igservice = ServiceFinder.find(IGenerateMessageExtdService.class);
			igservice.GenerateMessageAndMap("McExpiAlert", map, null);

		}
		return retObj;
	}

	private void setMmExpiDesc(List<List<String>> jsonList, ValidPeriodView validPeriodView) {
		
		List<String> table_string = new ArrayList<String>();
		table_string.add(validPeriodView.getMm_code());
		table_string.add(validPeriodView.getMm_name());
		table_string.add(validPeriodView.getMm_spec());
		table_string.add(validPeriodView.getSup_name());
		if(StringUtils.isBlank(validPeriodView.getBatch()))
		{
			table_string.add("");
		}else{
			table_string.add(validPeriodView.getBatch());
		}
		
		String date_expi = validPeriodView.getDate_expi() == null ? "" : validPeriodView.getDate_expi().toString();
		table_string.add(date_expi);
		table_string.add(validPeriodView.getQuan_stockact().setScale(4, FDouble.ROUND_UP).toString());
		table_string.add(String.format("%s天", validPeriodView.getInvalid_dt()));
		//table_string.add(validPeriodView.getPrintname());
		//table_string.add(validPeriodView.getSrv_name());
		jsonList.add(table_string);
	}

	private Mmexpialterdto getMmExptDTO(List<List<String>> jsonList, ValidPeriodView validPeriodView) {

		Mmexpialterdto dto = new Mmexpialterdto();

		// 仓库
		dto.setId_wh(validPeriodView.getId_wh());
		// 仓库名称
		dto.setWh_name(validPeriodView.getWh_name());
		// 失效物品条数
		dto.setQuan_invalid(1);
		// 描述
		List<String> head_string = new ArrayList<String>();
		
		head_string.add("编码");
		head_string.add("名称");
		head_string.add("规格");
		head_string.add("生产厂家");
		head_string.add("批次");
		head_string.add("失效期");
		head_string.add("现存量");
		head_string.add("剩余效期");
		//head_string.add("通用名");
		//head_string.add("打印名");
		jsonList.add(head_string);
		return dto;
	}

	private static Map<String, Object> getMap(Mmexpialterdto basedtos) {
		Map<String, Object> variable = new HashMap<String, Object>();

		Mmexpialterdto basedto = basedtos;
		String classname = basedto.getClass().getSimpleName();
		variable.put(classname, basedto);
		return variable;
	}
}
