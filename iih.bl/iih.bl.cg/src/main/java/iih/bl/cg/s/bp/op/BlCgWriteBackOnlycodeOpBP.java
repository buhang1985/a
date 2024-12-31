package iih.bl.cg.s.bp.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.dto.cgonlycode.d.BlCgOnlycodeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊回写记账唯一码
 * 
 * @author ly 2018/03/04
 *
 */
public class BlCgWriteBackOnlycodeOpBP {

	/**
	 * 高值耗材回写记账数据唯一码
	 * 
	 * @param dtos
	 *            唯一码信息 id_orsrv为空时，使用id_or及id_srv组合进行检索
	 * @param codeEntp
	 * @throws BizException
	 */
	public void exec(BlCgOnlycodeDTO[] dtos, String codeEntp) throws BizException {
		if (ArrayUtil.isEmpty(dtos))
			return;
		// 1.获取对应的id_srv 获取 bd_srv 中 fg_idmgmt 唯一码管理标志
		IMedsrvMDORService srvService = ServiceFinder.find(IMedsrvMDORService.class);
		IBlCgItmOepDORService cgService = ServiceFinder.find(IBlCgItmOepDORService.class);
		List<String> srvIdList = new ArrayList<String>();
		// 获取记账数据条件 id_or 与 id_orsrv 相等的数据
		String cgWhere = "";
		// 唯一编码Map key 是 id_or+id_orsrv
		HashMap<String, String> onlyCodeMap = new HashMap<String, String>();
		List<String> onlyCodeList = new ArrayList<String>();
		for (BlCgOnlycodeDTO dto : dtos) {
			if (!srvIdList.contains(dto.getId_srv())) {
				srvIdList.add(dto.getId_srv());
			}
			cgWhere += (StringUtil.isEmpty(cgWhere) ? "" : " or ") + "(id_or='" + dto.getId_or() + "' and id_orsrv='" + dto.getId_orsrv() + "')";
			String key = (dto.getId_or() + dto.getId_orsrv());
			onlyCodeMap.put(key, dto.getOnlycode());
			onlyCodeList.add(dto.getOnlycode());
		}

		// 校验唯一码是否已经被使用
		// 如果存在唯一编码相同（onlycode=A01），方向为收费(eu_direct=1），且没有退费（fg_refund =
		// N）的记录，则该唯一编码视为重复使用。
		
		String inSql = " FG_REFUND='N' AND " + SqlUtils.getInSqlByIds(BlCgItmOepDO.ONLYCODE, onlyCodeList.toArray(new String[onlyCodeList.size()]));
		String vWSql = inSql + " AND ID_CGOEP in (SELECT ID_CGOEP FROM BL_CG_OEP WHERE EU_DIRECT='1' AND ID_CGOEP IN (SELECT ID_CGOEP FROM BL_CG_ITM_OEP WHERE" + inSql + "))";
		BlCgItmOepDO[] vCgItmDos = cgService.find(vWSql, " SV ", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(vCgItmDos)) {
			String errMsg = "";
			for (BlCgItmOepDO cgitmdo : vCgItmDos) {
				errMsg += (StringUtil.isEmpty(errMsg) ? "" : "，") + cgitmdo.getOnlycode();
			}
			throw new BizException("唯一码：" + errMsg + "已经被使用，不可重复使用！");
		}

		MedSrvDO[] srvDOs = srvService.findByAttrValStrings(MedSrvDO.ID_SRV, srvIdList.toArray(new String[srvIdList.size()]));

		// 2.如果为false 弹出提示
		for (MedSrvDO srvDO : srvDOs) {
			if (!FBoolean.TRUE.equals(srvDO.getFg_idmgmt())) {
				throw new BizException("服务：" + srvDO.getName() + " 未启动唯一码管理功能，无法维护此数据！");
			}
		}

		// 3.根据 id_or id_orsrv 获取对应记账数据
		BlCgItmOepDO[] itmDos = cgService.find(cgWhere, " SV ", FBoolean.FALSE);
		// 4.修改对应对应数据中的onlycode
		for (BlCgItmOepDO itmDo : itmDos) {
			String key = itmDo.getId_or() + itmDo.getId_orsrv();
			itmDo.setOnlycode(onlyCodeMap.get(key));
			itmDo.setStatus(DOStatus.UPDATED);
		}
		// 5.保存修改的唯一机长数据
		IBlCgItmOepDOCudService cgCudService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
		cgCudService.update(itmDos);
	}
}
