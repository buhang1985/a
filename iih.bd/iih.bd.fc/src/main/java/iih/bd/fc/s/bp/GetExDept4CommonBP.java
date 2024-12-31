package iih.bd.fc.s.bp;

import java.util.ArrayList;

import iih.bd.fc.mdwfor.d.MdWfOrDO;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.pub.BdFcUtils;
import xap.mw.core.data.BizException;

public class GetExDept4CommonBP {
	/**
	 * 获得医嘱的执行科室列表（通用部分）
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptDTO[] exec(OrWfExDeptParamDTO param)  throws BizException{
		//有效性判断
		if(param==null)return null;
		
		//根据就诊类型获得医嘱流向开立参数数据
		MdWfOrDO[] wforinfos=getOrWfParaInfos(param);
		
		//获得医嘱开立模式医嘱的执行科室数据并返回
		return getOrExDepts(wforinfos,param);
	}
	
	/**
	 * 获得医嘱流向开立参数数据
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private MdWfOrDO[] getOrWfParaInfos(OrWfExDeptParamDTO param ) throws BizException{
		GetOrWfParaDO8EntpBP bp=new GetOrWfParaDO8EntpBP();
		return bp.exec(param.getCode_entp(),param.getSd_srvtp(),param.getReserv1());
	}
	
	/**
	 * 获得医嘱开立模式医嘱的执行科室数据 
	 * @param wforinfos
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private OrWfExDeptDTO[] getOrExDepts(MdWfOrDO[] wforinfos,OrWfExDeptParamDTO param) throws BizException{
		//有效性校验
		if(wforinfos==null || wforinfos.length==0)return null;
		
		//参数设置
		ArrayList<OrWfExDeptDTO> list=new ArrayList<OrWfExDeptDTO>();
		OrWfExDeptDTO exdeptinto=null;
		String idwfstr=getMdwfInfoStr(param.getReserv1());
		
		//遍历
		for(int i=0;i<wforinfos.length;i++){
			// 如果校验通过，则添加到执行科室列表
			if(validateArgu(wforinfos[i],param,idwfstr)){
				exdeptinto=getExDept8WfOrArgu(wforinfos[i],param);
				if(exdeptinto==null)continue;
				list.add(exdeptinto);
			}
		}
		
		//返回值处理
		if(list==null || list.size()==0)return null;
		return (OrWfExDeptDTO[])BdFcUtils.list2Array(list, OrWfExDeptDTO.class);
	}
	
	/**
	 * 根据医嘱流向类型获得对应医嘱流向字符串
	 * @param sd_wftp
	 * @return
	 * @throws BizException
	 */
	private String getMdwfInfoStr(String sd_wftp) throws BizException{
		GetMdWf8SdWfTpBP bp=new GetMdWf8SdWfTpBP();
		return BdFcUtils.COMMA_STR+BdFcUtils.array2String(bp.exec(sd_wftp), "Id_wf")+BdFcUtils.COMMA_STR;
	}
	
	/**
	 * 医嘱流向参数有效性校验
	 * @param wforinfo
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private boolean validateArgu(MdWfOrDO wforinfo,OrWfExDeptParamDTO param,String idwfstr) throws BizException{
		OrWfArguValidateBP bp=new OrWfArguValidateBP();
		return bp.exec(wforinfo, param,idwfstr);
	}
	
	/**
	 * 获得执医嘱流向行科室信息
	 * @param wforinfo
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private OrWfExDeptDTO getExDept8WfOrArgu(MdWfOrDO wforinfo,OrWfExDeptParamDTO param) throws BizException{
		GetExDept8WfOrArgu1BP bp=new GetExDept8WfOrArgu1BP();
		return bp.exec(wforinfo,param);
	}
	
}
