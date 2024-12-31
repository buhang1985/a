package iih.ci.ord.pub.listener;

import java.util.ArrayList;

import iih.bd.base.utils.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidoclistRService;

public abstract class AbstractUdidocListener {
	
	/**
	 * 实现自身业务逻辑
	 * @param ors
	 * @throws BizException 
	 */
	protected abstract void doYourActionAfter(Object[] newObjs)  throws BizException;
	/**
	 * 获得所需要类型数据信息
	 * @param newObjs
	 * @return
	 * @throws BizException
	 */
	protected UdidocDO[] getUdidocInfoByCode(Object[] newObjs,String codeString) throws BizException {
		UdidocDO ordo;
		ArrayList<UdidocDO> rtn=new ArrayList<UdidocDO>();
		//遍历
		for(Object obj: newObjs ){
			ordo=(UdidocDO) obj;
			//是否为所需要的类型
			if(!isSatisfyCode(ordo,codeString))continue;
			//加入列表中
			rtn.add(ordo);
	}
		//空判断
		if(rtn==null || rtn.size()==0)return null;
		//返回值
		return rtn.toArray(new UdidocDO[0]);
		
	}
	/**
	 * 筛选符合诊断类型的数据  根据code
	 */
	protected boolean isSatisfyCode(UdidocDO ordo,String codeString) throws BizException {
		if(ordo == null || !StringUtils.isNotEmpty(codeString))
		{return false;}
		//获取主DO
		UdidoclistDO udidoclistDo = getudidocListDo(ordo);
		if(udidoclistDo == null)
		{
			return false;
		}
		if(codeString.equals(udidoclistDo.getCode()))
		{
			return true;
		}
		return false;
	}
	/**
	 * 获取主DO
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	protected UdidoclistDO getudidocListDo(UdidocDO ordo) throws BizException {
		IUdidoclistRService service =  ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO udidoclistDo = service.findById(ordo.getId_udidoclist());
		return udidoclistDo;
	}
}
