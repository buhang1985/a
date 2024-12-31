package iih.en.que.s.bp;

import iih.en.comm.ep.BrdCallEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.que.board.d.BrdStatusEnum;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.dto.d.EnBrdCallDateDTO;
import iih.en.que.s.listener.bp.SendBrdMsgBP;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class SendBrdCallInfoBP {
	
	private static final String FLAG_SUCCESS = "0";
	private static final String FLAG_ERROR = "1";
	
	public ResultBean callExec(final EnBrdCallDateDTO enBrdCallDTO) throws BizException{
		
		//1.记录输入参数日志
		EnLogUtil.getInstance().logInfo("方法：enBrdSiteDTO参数为:大屏地址addr_brd:"+enBrdCallDTO.getAddr_brd()+"站点编码code_site:"+enBrdCallDTO.getCode_site()+
				"患者名称name_pat"+enBrdCallDTO.getName_pat()+"号别name_srvtp:"+enBrdCallDTO.getName_srvtp()+"当前患者就诊号no_curpat"+enBrdCallDTO.getNo_curpat());
		
		//2.校验不可为空参数
		ResultBean result = this.validParam(enBrdCallDTO);
		if(result != null)
			return result;
		result = new ResultBean();
		result.setFlag(FLAG_SUCCESS);

		///3.获取大屏叫号数据
		EnBrdCallDO enBrdCallDO = this.getBrdCallDate(enBrdCallDTO);
		
		//4.发送大屏站点消息
		EnLogUtil logUtil =EnLogUtil.getInstance();
			
		try{
			logUtil.logInfo("上屏事件： ");
			Boolean res = false;
			logUtil.logInfo("调用一次分诊大屏");
			logUtil.logInfo("siteInfo:");
			res = this.sendBrdCallInfo(enBrdCallDO);
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
		return null;
	}
	/**
	 * 发送大屏站点消息
	 * @author fanlq 2018年1月26日
	 * @param enBrdSiteDO
	 * @return
	 * @throws BizException
	 */
	private boolean sendBrdCallInfo(EnBrdCallDO enBrdCallDO) throws BizException{
		EnBrdCallDO[] enBrdCallDOs = new EnBrdCallDO[]{enBrdCallDO};
		new SendBrdMsgBP().sendCallMsg(enBrdCallDOs);
		return true;
	}
	/***
	 * 
	 * @author fanlq 2018年1月26日
	 * @param enBrdCallDTO
	 * @return
	 * @throws BizException
	 */
	private EnBrdCallDO getBrdCallDate(EnBrdCallDateDTO enBrdCallDTO) throws BizException{
		EnBrdCallDO enBrdCallDO = new EnBrdCallDO();
		enBrdCallDO.setAddr_brd(enBrdCallDTO.getAddr_brd());//大屏地址
		enBrdCallDO.setCode_site(enBrdCallDTO.getCode_site());//站点编码
		enBrdCallDO.setTick_no(enBrdCallDTO.getNo_curpat());//当前患者就诊号
		enBrdCallDO.setName_pat(enBrdCallDTO.getName_pat());//患者姓名
		enBrdCallDO.setAge(enBrdCallDTO.getAge());//年龄
		enBrdCallDO.setName_srvtp(enBrdCallDTO.getName_srvtp());//号别
		enBrdCallDO.setDt_insert(EnAppUtils.getServerDateTime());//插入时间
		enBrdCallDO.setDt_call(EnAppUtils.getServerDateTime());//插入时间
		// 4.保存大屏站点DO到数据库中
		enBrdCallDO.setStatus(DOStatus.NEW);
		new BrdCallEP().save(new EnBrdCallDO[] { enBrdCallDO });
			return enBrdCallDO;
	}
	
	
	/**
	 * 验证必输参数
	 * @author fanlq 2018年1月26日
	 * @param enBrdSiteDO
	 * @return
	 * @throws BizException 
	 */
	private ResultBean validParam(EnBrdCallDateDTO enBrdCallDTO) throws BizException{
		ResultBean result = new ResultBean();
		result.setFlag(FLAG_ERROR);
		if(EnValidator.isEmpty(enBrdCallDTO.getAddr_brd())){
			result.setMsg("大屏地址不能为空！");
			return result;
		}
		if(EnValidator.isEmpty(enBrdCallDTO.getCode_site())){
			result.setMsg("站点编码不能为空！");
			return result;
		}else{
			//大屏上是否已存在当前站点
			if(isExitSiteOnBrd(enBrdCallDTO.getCode_site()) <= 0){
				result.setMsg("不存在已上屏站点！");
			   return result;
			}
		}
		return null;
	}
	
	/***
	 * 大屏上是否已存在当前站点
	 * @author fanlq 2018年1月29日
	 * @param code_site
	 * @return
	 * @throws BizException 
	 */
	private Integer isExitSiteOnBrd(String code_site) throws BizException{
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("SELECT  COUNT(*) as cont_site ");
		sb.append("FROM en_brd_site ");
		sb.append("WHERE code = ? ");
		sb.append("and eu_status in (?,?) ");
		param.addParam(code_site);
		param.addParam(BrdStatusEnum.ADD);
		param.addParam(BrdStatusEnum.UPDATE);
		int count = 0;
		// 查询数据
		@SuppressWarnings("unchecked")
		Map<String, Integer> datas = (Map<String, Integer>) new DAFacade().execQuery(sb.toString(), param, new MapHandler());
		if (null != datas && !datas.isEmpty()) {
			count = datas.get("cont_site");
		}
		return count;
	}
}
