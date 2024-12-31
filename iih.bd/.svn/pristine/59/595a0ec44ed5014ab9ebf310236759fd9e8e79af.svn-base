package iih.bd.srv.s.bp;

import java.lang.reflect.Array;
import java.util.ArrayList;

import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.bp.qry.SrvRtCtlInfoQry;
import iih.bd.srv.srvrtctl.d.SrvRtCtlDTO;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/*
 * 获得受权限控制的服务数据集合信息操作BP
 */
public class GetSrvRtCtlInfosBP {
	/**
	 * 获得受权限控制的服务数据集合信息
	 * @param rtctlparam
	 * @return
	 * @throws BizException
	 */
	public SrvRtCtlDTO[] exec(SrvRtCtlParam rtctlparam)throws BizException {
		if(BdSrvUtils.isEmpty(rtctlparam))return null;
		SrvRtCtlInfoQry qry = new SrvRtCtlInfoQry(rtctlparam);
		SrvRtCtlDTO[] rtn = (SrvRtCtlDTO[])AppFwUtil.getDORstWithDao(qry, SrvRtCtlDTO.class);
		return getValidateVs(rtn,rtctlparam.getId_entp());
		
	}
	
	/**
	 * 获得有效服务开立权限数据信息
	 * @param rtn
	 * @param id_entp
	 * @return
	 */
	private SrvRtCtlDTO[] getValidateVs(SrvRtCtlDTO[] rtn,String id_entp){
		//有效性校验
		if(BdSrvUtils.isEmpty(rtn) || BdSrvUtils.isEmpty(id_entp))return null;
		
		//参数设置
		String id_entps=null;
		ArrayList<SrvRtCtlDTO> list=new ArrayList<SrvRtCtlDTO>();
		
		//遍历
		for(int i=0;i<rtn.length;i++){
			id_entps=rtn[i].getId_entp();  //空代表全部
			if(BdSrvUtils.isEmpty(id_entps) || BdSrvUtils.isInStr(id_entp, id_entps)){
				list.add(rtn[i]);
			}
		}
		
		if(BdSrvUtils.isEmpty(list))return null;
		return (SrvRtCtlDTO[]) list.toArray((SrvRtCtlDTO[]) Array.newInstance(SrvRtCtlDTO.class, 0));
	}
}
