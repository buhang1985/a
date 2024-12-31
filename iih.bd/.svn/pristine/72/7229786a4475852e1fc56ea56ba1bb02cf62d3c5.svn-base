package iih.bd.mm.mmalert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import iih.bd.mm.mmalert.bp.FindBlDataBp;
import iih.bd.mm.mmalert.bp.FindBlDataBp2;
import iih.bd.mm.mmquanalertdto.d.MmQuanAlertDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.message.message.i.IGenerateMessageExtdService;

public class MmAlertMessageExtdService implements IBackgroundWorkPlugin {

	private static Map<String, Object> getMap(MmQuanAlertDTO basedtos) {
		Map<String, Object> variable = new HashMap<String, Object>();

		MmQuanAlertDTO basedto = basedtos;
		String classname = basedto.getClass().getSimpleName();
		variable.put(classname, basedto);
		return variable;
	}

	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		PreAlertObject obj = new PreAlertObject();
		// 获取数据集
		FindBlDataBp Sql = new FindBlDataBp();
		MmQuanAlertDTO[] wares = (MmQuanAlertDTO[]) AppFwUtil.getDORstWithDao(Sql, MmQuanAlertDTO.class);

		FindBlDataBp2 Sql2 = new FindBlDataBp2();
		MmQuanAlertDTO[] wares2 = (MmQuanAlertDTO[]) AppFwUtil.getDORstWithDao(Sql2, MmQuanAlertDTO.class);
		//表头
		List<String> head_json = new ArrayList<String>();
		head_json.add("编码");
		head_json.add("名称");
		head_json.add("规格");
		head_json.add("生产厂家");
		head_json.add("现存量");
		head_json.add("最低库存量");
		head_json.add("差量");
		head_json.add("通用名");
		head_json.add("打印名");
		for (MmQuanAlertDTO dto : wares2) {
			int i = 0;
			List<List<String>> jsonList = new ArrayList<List<String>>();
			jsonList.add(head_json);
			for (MmQuanAlertDTO mmdto : wares) {
				if (!dto.getId_wh().equals(mmdto.getId_wh())) {

					continue;
				}
				List<String> table_string = new ArrayList<String>();
				if (mmdto.getQuan_stock().compareTo(FDouble.ZERO_DBL) == 0) {
					i++;
				}
				table_string.add(mmdto.getMm_code());
				table_string.add(mmdto.getMm_name());
				table_string.add(mmdto.getMm_spec());
				table_string.add(mmdto.getSup_name());
				table_string.add(String.format("%s%s", mmdto.getQuan_stock().setScale(4, FDouble.ROUND_UP), mmdto.getName_unit_pkgsp()));
				table_string.add(String.format("%s%s", mmdto.getLownum().setScale(4, FDouble.ROUND_UP), mmdto.getName_unit_pkgsp()));
				FDouble quan_diff = (mmdto.getLownum().setScale(4, FDouble.ROUND_UP)).sub(mmdto.getQuan_stock().setScale(4, FDouble.ROUND_UP));
				table_string.add(String.format("%s%s", quan_diff.setScale(4, FDouble.ROUND_UP), mmdto.getName_unit_pkgsp()));
				table_string.add(mmdto.getSrv_name());
				table_string.add(mmdto.getPrintname());
				jsonList.add(table_string);
			}
			dto.setQuan_zero(i);
			String desc = JSONObject.toJSONString(jsonList);
			dto.setDesc(desc.toString());

		}
		for (MmQuanAlertDTO dto : wares2) {
			Map<String, Object> map = getMap(dto);

			IGenerateMessageExtdService igservice = ServiceFinder.find(IGenerateMessageExtdService.class);
			igservice.GenerateMessageAndMap("MmStockAlert", map, null);
		}
		return obj;
	}

}
