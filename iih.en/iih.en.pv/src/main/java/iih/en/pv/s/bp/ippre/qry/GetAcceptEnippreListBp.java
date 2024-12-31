package iih.en.pv.s.bp.ippre.qry;

import java.util.ArrayList;
import java.util.List;

import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.desc.EnIppreDODesc;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.inpatient.i.IEnippreRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.ListToArrayUtil;

/**
 * 获取预住院信息 
 * 
 * @author li.wm
 *
 */

public class GetAcceptEnippreListBp extends GetIpPreInfoAbstact {
	/**
	 * 根据  状态 查询预住院的人数
	 * 
	 * @param enIppreDO
	 * @return
	 * @throws BizException
	 */
	public EnIppreInfoDTO[] exec(EnIppreDO enIppreDO) throws BizException {
		IEnippreRService enippreservice = ServiceFinder.find(IEnippreRService.class);
		String wherepre = " 1=1 AND " +EnIppreDODesc.TABLE_ALIAS_NAME+".SD_STATUS = '1'";
		EnIppreDO[] enippres = enippreservice.find(wherepre, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(enippres)){
			return new EnIppreInfoDTO[0];
		}
		return this.getIpPreByEntIds(Recombination(enippres));
	}
	/**
	 * 组装 参数
	 * 
	 * @param enippres
	 * @return
	 * @throws BizException
	 */
	private String[] Recombination(EnIppreDO[] enippres) throws BizException {
		List<String> list = new ArrayList<>();
		for (EnIppreDO enIppreDO : enippres) {
			if(!StringUtil.isEmpty(enIppreDO.getId_ent())){
				list.add(enIppreDO.getId_ent());
			}
		}
		ListToArrayUtil<String> utils = new ListToArrayUtil<>();
		return utils.convertToArray(list);
	}
}
