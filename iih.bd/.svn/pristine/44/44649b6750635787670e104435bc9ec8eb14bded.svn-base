package iih.bd.res.warehouse.s.bp;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据科室主键查询所属仓库信息
 * 
 * @author hao_wu 2018-10-30
 *
 */
public class FindOwerWhByDepIdBp {

	public WarehouseDO exec(String depId, FBoolean fg_mm) throws BizException {
		if (StringUtils.isEmpty(depId)) {
			return null;
		}

		IWarehouseRService warehouseRService = ServiceFinder.find(IWarehouseRService.class);
		String whrStr = null;
		if(fg_mm.booleanValue()) {
			whrStr = String.format("id_dep_belong = '%s' and sd_whtp in ('%s', '%s', '%s') ", depId, 
					IBdResDictCodeConst.SD_WHTP_YAOKU, IBdResDictCodeConst.SD_WHTP_YAOFANG, IBdResDictCodeConst.SD_WHTP_JISHU);
		} else {
			whrStr = String.format("id_dep_belong = '%s' and sd_whtp in ('%s', '%s') ", depId, 
					IBdResDictCodeConst.SD_WHTP_HAOCAI, IBdResDictCodeConst.SD_WHTP_HVHAOCAI);
		}
		WarehouseDO[] result = warehouseRService.find(whrStr, "", FBoolean.TRUE);
		if (ArrayUtils.isNotEmpty(result)) {
			return result[0];
		}

		return null;
	}

}
