package iih.ci.ord.s.ems.meta;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;

/**
 * 医疗单返回值处理
 * 
 * @author wangqingzhu
 *
 */
public class EmsRstInfoUtils {

	public static EmsRstDTO[] ToEmsRstDTOArray(CiEnContextDTO ctx, ErrorEmsListMap errorMap) {

		EmsRstInfoList rstList = new EmsRstInfoList();
		for (String key : errorMap.keySet()) {
			ErrorEmsList errorList = errorMap.get(key);
			if (null != errorList && errorList.size() > 0) {
				EmsRstDTO rstInfo = new EmsRstDTO();

				// TODO: 此处可以设置更多的返回值信息
				rstInfo.setErrorEmsList(errorList.asFArrayList());
			}
		}

		return rstList.asArray();
	}
}
