package iih.ems.common.pub;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;

public class EmsGetCommonInfo {
	
	public static PsnDocDO getPsnDocInfo() throws BizException {
		
		IPsndocMDORService psnRSrv = ServiceFinder.find(IPsndocMDORService.class);
		
		PsnDocDO psndocDO = psnRSrv.findById(Context.get().getStuffId());
		if(psndocDO == null) {
			
			throw new BizException("获取人员信息失败。");
		}
		
		return psndocDO;
	}
	
	public static DeptDO getDeptInfo() throws BizException {
		
		IDeptRService depRSrv = ServiceFinder.find(IDeptRService.class);
		
		DeptDO deptDO = depRSrv.findById(Context.get().getDeptId());
		if(deptDO == null) {
			
			throw new BizException("获取部门信息失败。");
		}
		
		return deptDO;
	}
	
	public static UdidocDO getUdidocInfo(String udi_type, String udi_code) throws BizException {
		
		
		UdidocDO udidocDO = getUdidocByCode(Context.get().getOrgId(), udi_type, udi_code);
		if(udidocDO == null) {
			
			throw new BizException("获取自定义档案失败。");
		}
		
		return udidocDO;
	}
	
	
	
	/**
	 * 根据编码查询组织机构下的自定义档案
	 * @param orgId 组织机构ID
	 * @param type 自定义档案类型编码
	 * @param code 自定义档案编码
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static UdidocDO getUdidocByCode(String orgId, String type, String code) throws BizException {
		
		if(StringUtils.isBlank(type) || StringUtils.isBlank(code)) {
			
			throw new BizException("传入参数信息不完整。");
		}
		
		DAFacade dao = new DAFacade();
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select a0.* from bd_udidoc a0 ");
		sqlStr.append("  left join bd_udidoclist a1 ");
		sqlStr.append("    on a0.id_udidoclist=a1.id_udidoclist ");
		sqlStr.append("where ");
		sqlStr.append("  a0.ds=0 ");
		sqlStr.append("  and a1.ds=0 ");
		sqlStr.append("  and a0.code='" + code + "' ");
		sqlStr.append("  and a1.code='" + type + "' ");
		
		List<UdidocDO> result = (List<UdidocDO>) dao.execQuery(sqlStr.toString(), new BeanListHandler(UdidocDO.class));
		if (result == null || result.size() <=0 ) {
			
			return null;
		} else {
			
			return result.get(0);
		}
	}
	
}
