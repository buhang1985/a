package iih.bl.cg.s.bp.ip;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.dto.cgonlycode.d.BlCgOnlycodeDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院回写记账唯一码
 * 
 * @author ly 2018/03/04
 *
 */
public class BlCgWriteBackOnlycodeIpBP {

	/**
	 * 高值耗材回写记账数据唯一码
	 * 
	 * @param dtos
	 *            唯一码信息 id_orsrv为空时，使用id_or及id_srv组合进行检索
	 * @param codeEntp
	 * @throws BizException
	 */
	public void exec(BlCgOnlycodeDTO[] dtos, String codeEntp) throws BizException {
		// 1.获取对应的id_srv 获取 bd_srv 中 fg_idmgmt 唯一码管理标志
		IMedsrvMDORService srvService = ServiceFinder.find(IMedsrvMDORService.class);
		List<String> srvIdList = new ArrayList<String>();
		// 获取记账数据条件 id_or 与 id_orsrv 相等的数据
		String cgWhere = "";
		// 唯一编码Map key 是 id_or+id_orsrv
		HashMap<String, String> onlyCodeMap = new HashMap<String, String>();
		for (BlCgOnlycodeDTO dto : dtos) {
			if (!srvIdList.contains(dto.getId_srv())) {
				srvIdList.add(dto.getId_srv());
			}
			cgWhere += (StringUtil.isEmpty(cgWhere) ? "" : " or ") + "(id_or='" + dto.getId_or() + "' and id_orsrv='" + dto.getId_orsrv() + "')";
			String key = (dto.getId_or() + dto.getId_orsrv());
			onlyCodeMap.put(key, dto.getOnlycode());
		}
		MedSrvDO[] srvDOs = srvService.findByAttrValStrings(MedSrvDO.ID_SRV, srvIdList.toArray(new String[srvIdList.size()]));

		// 2.如果为false 弹出提示
		for (MedSrvDO srvDO : srvDOs) {
			if (!FBoolean.TRUE.equals(srvDO.getFg_idmgmt())) {
				throw new BizException("服务：" + srvDO.getName() + " 未启动唯一码管理功能，无法维护此数据！");
			}
		}
		// 3.根据 id_or id_orsrv 获取对应记账数据
		IBlcgqueryRService cgService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] itmDos = cgService.find(cgWhere, " SV ", FBoolean.FALSE);
		// 4.修改对应对应数据中的onlycode
		for (BlCgIpDO itmDo : itmDos) {
			String key = itmDo.getId_or() + itmDo.getId_orsrv();
			itmDo.setOnlycode(onlyCodeMap.get(key));
			itmDo.setStatus(DOStatus.UPDATED);
		}
		// 5.保存修改的唯一机长数据
		IBlcgqueryCudService cgCudService = ServiceFinder.find(IBlcgqueryCudService.class);
		cgCudService.update(itmDos);
	}
}
