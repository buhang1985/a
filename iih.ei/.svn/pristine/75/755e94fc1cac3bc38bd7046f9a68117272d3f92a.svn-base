package iih.ei.std.s.v1.bp.ci.thirdws;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

/**
 * 临床ws接口基类
 * 
 * @author HUMS
 *
 */
public class BaseOrdWsServiceImpl {

	private static Map<String, OrgDO> orgMap = new HashMap<String, OrgDO>();

	/**
	 * webservice接口传入数据因为不确定组织结构id导致报错， 需要手动设置当前传入的机构id
	 * @throws BizException 
	 */
	protected void initContext(String bizOrgCode) throws BizException {

		
		IOrgRService orgRService = (IOrgRService) ServiceFinder.find(IOrgRService.class);
		try {
			if(StringUtils.isEmpty(bizOrgCode)){
				throw new BizException("Webservice接口初始Context异常：机构编码为空；");
				
			}
			OrgDO org = null;
			if (orgMap.containsKey(bizOrgCode)) {
				org = orgMap.get(bizOrgCode);
			} else {
				OrgDO[] orgs = orgRService.findByAttrValString(OrgDO.BIZORGCODE, bizOrgCode);
				org = orgs[0];
				orgMap.put(org.getBizorgcode(), org);
			}

			Context.get().setGroupId(org.getId_grp());
			Context.get().setOrgId(org.getId_org());
		} catch (BizException e) {

			e.printStackTrace();
			throw new BizException("Webservice接口初始Context获取机构对象异常：" + e.getMessage());
		}
	}

	

}
