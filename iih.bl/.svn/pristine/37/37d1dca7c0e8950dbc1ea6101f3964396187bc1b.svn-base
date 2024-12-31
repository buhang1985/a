package iih.bl.cc.ebs.help.util;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.d.desc.QueSiteDODesc;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.d.desc.WorkStationPcDODesc;
import iih.bd.res.workstation.i.IWorkstationRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据pc标志取得工作站信息的工具类
 * @author ChaoXiaoGang
 *
 */
public class QueSiteAndStationUtil {
	
	/**
	 * 站点类型 
	 * @author ChaoXiaoGang
	 */
	public class QueSiteTP{
		/**
		 * 门诊医生站
		 */
		public static final String TP01="01";
		
		/**
		 * 住院医生站
		 */
		public static final String TP02="02";
		
		/**
		 * 医技医生站
		 */
		public static final String TP11="11";
		
		/**
		 * 发药工作点
		 */
		public static final String TP20="20";
		
		/**
		 * 配药工作点
		 */
		public static final String TP21="21";
	}

	/**
	 * 取得工作站数据
	 * @param pcid 计算机标识
	 * @return
	 * @throws BizException
	 */
	public static WorkStationPcDO getStationPc(String pcid) throws BizException{
		if(StringUtil.isEmptyWithTrim(pcid)) {
			throw new BizException("参数pcid不能为null或空");
		}
		IWorkstationRService workstationService = ServiceFinder.find(IWorkstationRService.class);
		String formatter="%1$s.pcid='%2$s' and %1$s.fg_active='Y' ";
//		String formatter="%1$s.pcid='%2$s' ";
		String sql=String.format(formatter,WorkStationPcDODesc.TABLE_ALIAS_NAME,pcid);
		WorkStationPcDO[] result = workstationService.find(sql,null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(result)){
			throw new BizException("本计算机站点未注册到系统中!");
		}
		if(result.length>1) {
			throw new BizException("pcid="+pcid+" 重复注册");
		}
		return result[0];
	}
	
	/**
	 * 取得队列工作站数据
	 * @param pcid 计算机标识
	 * @param sitetp 站点类型  01-门诊医生站 02-住院医生站 11-医技工作站 20 发药工作点 ，21 配药工作点
	 * @return
	 * @throws BizException
	 */
	public static QueSiteDO getQueSite(String pcid,String sitetp) throws BizException{
		WorkStationPcDO pc =getStationPc(pcid);
		IQuesiteRService quesiteRService = ServiceFinder.find(IQuesiteRService.class);
		String format=" %1$s.id_pc='%2$s' and %1$s.sd_quesitetp='%3$s' ";
		String sql=String.format(format, QueSiteDODesc.TABLE_ALIAS_NAME,pc.getId_pc(),sitetp);
		sql+=" and id_dep='"+Context.get().getDeptId()+"' ";
		QueSiteDO[] sites = quesiteRService.find(sql, null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(sites)){
			throw new BizException("本计算机站点未加入到队列中!");
		}
		if(sites.length>1) {
			throw new BizException(pcid+" 对应多个队列站点记录");
		}
		return sites[0];
	}
	
	/**
	 * 根据队列站点id取得数据库里的对应记录
	 * @param idquesite 队列站点主键数组
	 * @return
	 * @throws BizException
	 */
	public static QueSiteDO[] getQueSite(String[] idquesite) throws BizException {
		IQuesiteRService qrserv = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO[] ret=qrserv.findByIds(idquesite,FBoolean.FALSE);
		return ret;
	}

	/**
	 * 获取当前上下文主机的队列站点 
	 * @param sitetp 站点类型  01-门诊医生站 02-住院医生站 11-医技工作站 20 发药工作点 ，21 配药工作点
	 * @return 能正常返回的值有且只有一个
	 * @throws BizException 如果未报异常肯定有值
	 */
	public static QueSiteDO getQueSite(String sitetp) throws BizException{
		return getQueSite(Context.get().getClientHost(),sitetp);
	}
}
