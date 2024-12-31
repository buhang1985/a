package iih.bd.mm.comm.bp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 自定义档案帮助类。
 * @author wu.junhui
 *
 */
public class UdiHelper {
	/**
	 * 根据编码查询组织机构下的自定义档案
	 * @param orgId 组织机构ID
	 * @param type 自定义档案类型编码
	 * @param code 自定义档案编码
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public UdidocDO getUdidocByCode(String orgId, String type, String code) throws BizException {
		
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
	
	@SuppressWarnings("unchecked")
	public UdidocDO getUdidocById(String docId) throws BizException {
		
		if(StringUtils.isBlank(docId)) {
			
			throw new BizException("传入参数信息不完整。");
		}
		
		DAFacade dao = new DAFacade();
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select a0.* from bd_udidoc a0 ");
		sqlStr.append("where ");
		sqlStr.append("  a0.ds=0 ");
		sqlStr.append("  and a0.id_udidoc='" + docId + "' ");
		
		List<UdidocDO> result = (List<UdidocDO>) dao.execQuery(sqlStr.toString(), new BeanListHandler(UdidocDO.class));
		if (result == null || result.size() <=0 ) {
			
			return null;
		} else {
			
			return result.get(0);
		}
	}	
}
