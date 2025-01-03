package iih.bd.mm.mmalert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import iih.bd.base.utils.AppUtils;
import iih.bd.mm.mmalert.bp.FindExpiDataBp;
import iih.bd.mm.mmalert.bp.FindMmcfExpiDataBp;
import iih.bd.mm.mmcerti.d.MaterialCertiDO;
import iih.bd.mm.mmexpialterdto.d.Mmexpialterdto;
import iih.bd.utils.log.BdMmLogUtils;
import iih.mm.qy.validperiod.d.ValidPeriodView;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.message.message.i.IGenerateMessageExtdService;

/**
 * 失效期预警插件。
 * 
 * @author shao_yuan
 *
 */

public class MmcfExpiAlertPlugin implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc) throws BizException {

		BdMmLogUtils.info(">>失效期预警插件开始执行=%s", AppUtils.getServerDateTime());
		PreAlertObject retObj = new PreAlertObject();

		// 获取耗材证件数据集
		MaterialCertiDO[] valis = FindMmcfExpiDataBp.queryExpiData(bgwc);
		if (valis != null && valis.length > 0) {

			List<List<String>> jsonList = new ArrayList<List<String>>();
			Mmexpialterdto dto = this.getMmExptDTO(jsonList);
			for(MaterialCertiDO cfDO :valis)
			{
				this.setMmExpiDesc(jsonList, cfDO);
			}
			String desc = JSONObject.toJSONString(jsonList);
			dto.setQuan_invalid(valis.length);
			dto.setDesc(desc);
			Map<String, Object> map = getMap(dto);
			IGenerateMessageExtdService igservice = ServiceFinder.find(IGenerateMessageExtdService.class);
			igservice.GenerateMessageAndMap("MmcfExpiAlert", map, null);
		}
		
		// 获取供应商证件数据集
		valis = FindMmcfExpiDataBp.querySupExpiData(bgwc,"sup");
		if (valis != null && valis.length > 0) {

			List<List<String>> jsonList = new ArrayList<List<String>>();
			Mmexpialterdto dto = this.getMmExptDTO(jsonList);
			for(MaterialCertiDO cfDO :valis)
			{
				this.setMmExpiDesc(jsonList, cfDO);
			}
			String desc = JSONObject.toJSONString(jsonList);
			dto.setQuan_invalid(valis.length);
			dto.setDesc(desc);
			dto.setWh_name("供应商");
			Map<String, Object> map = getMap(dto);
			IGenerateMessageExtdService igservice = ServiceFinder.find(IGenerateMessageExtdService.class);
			igservice.GenerateMessageAndMap("SupcfExpiAlert", map, null);
		}
		
		// 获取生产商证件数据集
		valis = FindMmcfExpiDataBp.querySupExpiData(bgwc,"fac");
		if (valis != null && valis.length > 0) {

			List<List<String>> jsonList = new ArrayList<List<String>>();
			Mmexpialterdto dto = this.getMmExptDTO(jsonList);
			for(MaterialCertiDO cfDO :valis)
			{
				this.setMmExpiDesc(jsonList, cfDO);
			}
			String desc = JSONObject.toJSONString(jsonList);
			dto.setQuan_invalid(valis.length);
			dto.setWh_name("生产商");
			dto.setDesc(desc);
			Map<String, Object> map = getMap(dto);
			IGenerateMessageExtdService igservice = ServiceFinder.find(IGenerateMessageExtdService.class);
			igservice.GenerateMessageAndMap("SupcfExpiAlert", map, null);
		}
		
		
		return retObj;
	}

	private void setMmExpiDesc(List<List<String>> jsonList, MaterialCertiDO cfdo) {
		
		List<String> table_string = new ArrayList<String>();
		table_string.add(removeNull(cfdo.getMm_code()));
		table_string.add(removeNull(cfdo.getMm_name()));
		table_string.add(removeNull(cfdo.getCf_no()));
		table_string.add(removeNull(cfdo.getCerti_name()));
		table_string.add(removeNull(cfdo.getDa_e().toLocalString()));
		table_string.add(removeNull(cfdo.getSd_ct()));
		jsonList.add(table_string);
	}

	private Mmexpialterdto getMmExptDTO(List<List<String>> jsonList) {

		Mmexpialterdto dto = new Mmexpialterdto();
		// 失效物品条数
		dto.setQuan_invalid(1);
		// 描述
		List<String> head_string = new ArrayList<String>();
		head_string.add("编码");
		head_string.add("名称");
		head_string.add("证件名称");
		head_string.add("证件号码");
		head_string.add("失效期");
		head_string.add("剩余效期");
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
	
	private String removeNull(String str){
		if(str==null || str.equals("null"))
		{
			str = "";
		}
		return str;
	}
	
	
}
