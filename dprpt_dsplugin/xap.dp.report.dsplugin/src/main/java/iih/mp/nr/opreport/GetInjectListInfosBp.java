package iih.mp.nr.opreport;

import java.util.List;

import iih.mp.nr.dto.pres.d.PreSkinTestDTO;
import xap.mw.core.data.BizException;

/**
 * 注射处方单（门急诊输液登记） 查询(按计划打印)
 * 
 * @author fengjj
 * @date 2019年3月20日18:54:17 创建
 * @version:fengjj_2020年5月3日10:00:27,抽取注射单查询的公共方法，以扩展根据分组打印注射单
 * 
 */
public class GetInjectListInfosBp  extends GetInjectCommonBp{

	@Override
	protected List<PreSkinTestDTO> packageData(List<PreSkinTestDTO> list) throws BizException {
		return new OpReUtil().packageData(list);
	}
}
