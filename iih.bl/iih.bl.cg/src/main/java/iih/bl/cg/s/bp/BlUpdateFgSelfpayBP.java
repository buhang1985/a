package iih.bl.cg.s.bp;

import java.util.HashMap;
import java.util.Map;

import com.founder.xap.core.utils.StringUtils;
import com.google.common.util.concurrent.Service;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.i.IBlCgQryService;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 修改住院费用自费状态-指定自费 Title: BlupdateFgSelfpayBP.java
 * 
 * @author zhang.hw
 * @date 2019年4月30日
 * @version 1.0
 */
public class BlUpdateFgSelfpayBP {

	private Map<String, FBoolean> map = new HashMap<String, FBoolean>();

	public FBoolean exec(IpBillItmUploadHpDTO[] ipBillItmUploadHpDTOs) throws BizException {
		// 先获取原数据
		// 1.获取获取主键集合
		String[] pkys = this.getBlCgIds(ipBillItmUploadHpDTOs);
		// 2.根据id_cgip修改相应费用信息
		BlCgIpDO[] dos = this.getBlCgInfo(pkys);
		// 将DTO中的fg_selfpay字段赋值到查出来的DO中
		dos = this.assignmentFgSelfpay(dos, ipBillItmUploadHpDTOs);
		// 保存新DO
		FBoolean flag = this.saveBlCgIp(dos);

		return flag;
	}

	/**
	 * 保存新DO
	 * 
	 * @author zhang.hw
	 * @date 2019年4月30日
	 * @param dos
	 * @return
	 * @throws BizException
	 */
	private FBoolean saveBlCgIp(BlCgIpDO[] dos) throws BizException {
		IBlcgqueryCudService blcgquery = ServiceFinder.find(IBlcgqueryCudService.class);
		dos = blcgquery.save(dos);
		if (dos != null && dos.length > 0) {
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}

	/**
	 * 将DTO中的fg_selfpay字段赋值到查出来的DO中
	 * 
	 * @author zhang.hw
	 * @date 2019年4月30日
	 * @param dos
	 * @param ipBillItmUploadHpDTOs
	 * @return
	 */
	private BlCgIpDO[] assignmentFgSelfpay(BlCgIpDO[] dos, IpBillItmUploadHpDTO[] ipBillItmUploadHpDTOs) {
		for (BlCgIpDO do1 : dos) {
			FBoolean flag = map.get(do1.getId_cgip());
			if (flag != null) {
				do1.setFg_selfpay(flag);
				do1.setStatus(DOStatus.UPDATED);
			}
		}
		return dos;
	}

	/**
	 * 根据id_cgip修改相应费用信息
	 * 
	 * @author zhang.hw
	 * @date 2019年4月30日
	 * @param pkStrings
	 * @return
	 * @throws BizException
	 */
	private BlCgIpDO[] getBlCgInfo(String[] pkStrings) throws BizException {
		IBlcgqueryRService blCgQryService = ServiceFinder.find(IBlcgqueryRService.class);
		return blCgQryService.findByIds(pkStrings, FBoolean.FALSE);
	}

	/**
	 * 获取主键集合
	 * 
	 * @author zhang.hw
	 * @date 2019年4月30日
	 * @param ipBillItmUploadHpDTOs
	 * @return
	 */
	private String[] getBlCgIds(IpBillItmUploadHpDTO[] ipBillItmUploadHpDTOs) {
		String[] pkys = new String[ipBillItmUploadHpDTOs.length];
		for (int i = 0; i < ipBillItmUploadHpDTOs.length; i++) {
			pkys[i] = ipBillItmUploadHpDTOs[i].getId_cgip();
			map.put(ipBillItmUploadHpDTOs[i].getId_cgip(), ipBillItmUploadHpDTOs[i].getFg_selfpay());
		}

		return pkys;
	}
}
