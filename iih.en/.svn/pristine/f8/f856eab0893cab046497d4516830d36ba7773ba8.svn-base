package iih.en.que.s.bp;

import iih.en.comm.ep.EnBrdEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.board.i.IEnbrddoMDORService;
import iih.en.que.dto.d.EnBrdSiteDateDTO;
import iih.en.que.s.event.bp.WrapObj2OpQue4EnBrdBP;
import iih.en.que.s.listener.bp.SendBrdMsgBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class SendBrdSiteInfoBP {
	private static final String FLAG_SUCCESS = "0";
	private static final String FLAG_ERROR = "1";
	
	public ResultBean siteExec(final EnBrdSiteDateDTO enBrdSiteDTO) throws BizException{

		//1.记录输入参数日志
		EnLogUtil.getInstance().logInfo("方法：enBrdSiteDTO参数为:大屏地址addr_brd:"+enBrdSiteDTO.getAddr_brd()+"站点编码code_site:"+enBrdSiteDTO.getCode_site()+
				"站点状态eu_status："+enBrdSiteDTO.getEu_status()+"科室名称name_dep："+enBrdSiteDTO.getName_dep()+"诊室名称name_clinic"+enBrdSiteDTO.getName_clinic()+
				"资源名称name_doc"+enBrdSiteDTO.getName_doc()+"当前患者就诊号no_curpat"+enBrdSiteDTO.getNo_curpat()+"候诊号nos_wait："+enBrdSiteDTO.getNos_wait());
		
		//2.校验不可为空参数
		ResultBean result = this.validParam(enBrdSiteDTO);
		if(result != null)
			return result;
		result = new ResultBean();
		result.setFlag(FLAG_SUCCESS);

		//3.获取大屏站点数据
		EnBrdSiteDO enBrdSiteDO = this.getBrdSiteDate(enBrdSiteDTO);
		
		//4.发送大屏站点消息
		EnLogUtil logUtil =EnLogUtil.getInstance();
			
		try{
			logUtil.logInfo("上屏事件： ");
			Boolean res = false;
			logUtil.logInfo("调用一次分诊大屏");
			logUtil.logInfo("siteInfo:");
			res = this.sendBrdSiteInfo(enBrdSiteDO);
			logUtil.logInfo("调用一次分诊大屏结果：" + res);
			if(!res){
				logUtil.logError("调用一次分诊大屏");
				logUtil.logError("siteInfo:");
				logUtil.logError("调用一次分诊大屏结果：" + res);
			}
		}catch(Exception e){
			logUtil.logError("上屏出错:"+e);
			result.setFlag(FLAG_ERROR);
			result.setMsg(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 发送大屏站点消息
	 * @author fanlq 2018年1月26日
	 * @param enBrdSiteDO
	 * @return
	 * @throws BizException
	 */
	private boolean sendBrdSiteInfo(EnBrdSiteDO enBrdSiteDO) throws BizException{
		EnBrdSiteDO[] enBrdSiteDOs = new EnBrdSiteDO[]{enBrdSiteDO};
		new SendBrdMsgBP().sendSiteMsg(enBrdSiteDOs);
		return true;
	}
	
	/***
	 * 获取要发送的大屏站点数据
	 * @author fanlq 2018年1月26日
	 * @param enBrdSiteDTO
	 * @return
	 * @throws BizException 
	 */
	private EnBrdSiteDO getBrdSiteDate(EnBrdSiteDateDTO enBrdSiteDTO) throws BizException{
		EnBrdSiteDO enBrdSiteDO = new EnBrdSiteDO();
		//大屏上是否已存在当前站点
		this.getBrdSiteDO(enBrdSiteDTO.getCode_site());
		enBrdSiteDO.setAddr_brd(enBrdSiteDTO.getAddr_brd());//大屏地址
		enBrdSiteDO.setCode(enBrdSiteDTO.getCode_site());//站点编码
		enBrdSiteDO.setEu_status(enBrdSiteDTO.getEu_status());//状态
		enBrdSiteDO.setName_dept(enBrdSiteDTO.getName_dep());//科室名称
		enBrdSiteDO.setName_dr(enBrdSiteDTO.getName_doc());//资源名称
		enBrdSiteDO.setName_clinic(enBrdSiteDTO.getName_clinic());//诊室
		enBrdSiteDO.setNo_curpat(enBrdSiteDTO.getNo_curpat());//当前患者就诊号
		enBrdSiteDO.setNos_wait(enBrdSiteDTO.getNos_wait());//候诊号
		enBrdSiteDO.setDt_lastmdf(EnAppUtils.getServerDateTime());//上次更新时间
		// 4.保存大屏站点DO到数据库中
		if(enBrdSiteDTO.getEu_status() == 1)
		    enBrdSiteDO.setStatus(DOStatus.NEW);
		else if(enBrdSiteDTO.getEu_status() == 2)
		    enBrdSiteDO.setStatus(DOStatus.DELETED);
		else if(enBrdSiteDTO.getEu_status() == 3)
		    enBrdSiteDO.setStatus(DOStatus.UPDATED);
		new EnBrdEP().save(new EnBrdSiteDO[] { enBrdSiteDO });
			return enBrdSiteDO;
	}
	
	/**
	 * 验证必输参数
	 * @author fanlq 2018年1月26日
	 * @param enBrdSiteDO
	 * @return
	 * @throws BizException 
	 */
	private ResultBean validParam(EnBrdSiteDateDTO enBrdSiteDTO) throws BizException{
		ResultBean result = new ResultBean();
		result.setFlag(FLAG_ERROR);
		if(EnValidator.isEmpty(enBrdSiteDTO.getAddr_brd())){
			result.setMsg("大屏地址不能为空！");
			return result;
		}else{
			EnBrdDO brdDO = this.getBrdByAddr(enBrdSiteDTO.getAddr_brd());
			if(brdDO == null){
				throw new BizException("IIH中不存在该地址的大屏！");
			}
		}
			if(EnValidator.isEmpty(enBrdSiteDTO.getCode_site())){
				result.setMsg("站点编码不能为空！");
				return result;
			}
			if(enBrdSiteDTO.getEu_status() != 1 && enBrdSiteDTO.getEu_status() != 2 && enBrdSiteDTO.getEu_status() != 3){
				result.setMsg("站点状态只能为1或2或3，分别为上线、下线、更新！");
				return result;
			}
			if(EnValidator.isEmpty(enBrdSiteDTO.getName_dep())){
				result.setMsg("科室不能为空！");
				return result;
			}
			if(EnValidator.isEmpty(enBrdSiteDTO.getName_doc())){
				result.setMsg("资源不能为空！");
				return result;
			}
		return null;
	}
	
	/***
	 * 获取大屏
	 * @author fanlq 2018年1月29日
	 * @param addr_brd 大屏地址
	 * @throws BizException 
	 */
	private EnBrdDO getBrdByAddr(String addr_brd) throws BizException{
		EnBrdDO[] rtns = ServiceFinder.find(IEnbrddoMDORService.class).findByAttrValString(EnBrdDO.ADDR,addr_brd);
		if (rtns != null && rtns.length == 1) {
			return rtns[0];
		}
		return null;
	}
	
	/***
	 * 大屏上是否已显示站点，是则更新或删除，否则新增
	 * 
	 * @author fanlq 2018年1月2日
	 * @param brdSiteDO
	 * @return
	 * @throws BizException
	 */
	private EnBrdSiteDO getBrdSiteDO(String siteCode) throws BizException {
		WrapObj2OpQue4EnBrdBP bp = new WrapObj2OpQue4EnBrdBP();
		return bp.getBrdSiteDO(siteCode);
	}
}
