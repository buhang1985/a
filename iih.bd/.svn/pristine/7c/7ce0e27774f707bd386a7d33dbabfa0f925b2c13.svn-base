package iih.bd.fc.que.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeTypeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueCudService;
import iih.bd.fc.que.i.IQueRService;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 药房队列创建逻辑
 * 
 * @author hao_wu
 * @author hao_wu 2018-5-22 药房队列默认分诊
 * @author hao_wu 2018-5-25 修正发药窗口在门诊队列下bug
 *
 */
public class PharmacyQueBP {

	/**
	 * 创建对应科室的队列
	 * 
	 * @param depId
	 * @return 科室下创建的队列
	 * @throws BizException
	 */
	private QueDO creatPharmacyQue(DeptDO deptDO) throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO udidocDO = udidocServiceExt.findByCode(IBdFcDictCodeTypeConst.SD_MODEL,
				IBdFcDictCodeConst.SD_MODEL_PHA_YES);
		QueDO que = new QueDO();
		que.setCode(deptDO.getCode());
		que.setName(deptDO.getName());
		que.setDes(deptDO.getDes());
		que.setId_dep(deptDO.getId_dep());
		que.setSd_mode(udidocDO.getCode());
		que.setId_mode(udidocDO.getId_udidoc());
		que.setMode_code(udidocDO.getCode());
		que.setMode_name(udidocDO.getName());
		que.setFg_active(FBoolean.TRUE);
		que.setSd_quetp(IBdFcDictCodeConst.SD_QUETP_PHARMACY);
		que.setId_quetp(IBdFcDictCodeConst.ID_QUETP_PHARMACY);
		que.setId_grp(Context.get().getGroupId());
		que.setId_org(Context.get().getOrgId());
		que.setPycode(CnToPy.getPyFirstCode(deptDO.getName()));
		que.setWbcode(CnToWB.getWBCode(deptDO.getName()));
		que.setMnecode(deptDO.getCode());
		que.setStatus(DOStatus.NEW);
		IQueCudService queCudService = ServiceFinder.find(IQueCudService.class);
		QueDO[] queDo = queCudService.save(new QueDO[] { que });
		return queDo[0];
	}

	/**
	 * 查询科室下是否存在队列，存在返回队列，不存在创建队列
	 * 
	 * @param depId
	 * @return 科室下的队列
	 * @throws BizException
	 */
	public QueDO whetherExistQue(DeptDO deptDO) throws BizException {
		String wherePart = String.format("id_dep = '%s' and sd_quetp = '%s'", deptDO.getId_dep(),
				IBdFcDictCodeConst.SD_QUETP_PHARMACY);
		IQueRService queRService = ServiceFinder.find(IQueRService.class);
		QueDO[] result = queRService.find(wherePart, "", FBoolean.FALSE);
		if (result != null && result.length > 0) {
			return result[0];
		}
		return creatPharmacyQue(deptDO);
	}
}
